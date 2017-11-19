package br.com.test.vreal.service;

import br.com.test.vreal.domain.Properties;
import br.com.test.vreal.domain.Property;
import br.com.test.vreal.exception.UnprocessableEntityException;
import br.com.test.vreal.model.PropertyEntity;
import br.com.test.vreal.model.ProvinceEntity;
import br.com.test.vreal.repository.PropertyRepository;
import br.com.test.vreal.repository.ProvinceRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.stream.Collectors;
import static br.com.test.vreal.config.RedisCacheConfig.CACHE_PROPERTY;
import static java.util.stream.Collectors.toList;

@Service
@Slf4j
public class PropertyService {

    @Autowired
    PropertyRepository propertyRepository;

    @Autowired
    ProvinceRepository provinceRepository;

    public PropertyEntity findPropertyEntityByXAndY(int x, int y) {
        return propertyRepository.findByXAndY(x, y);
    }

    public Property findPropertyByXAndY(int x, int y) {
        PropertyEntity p = propertyRepository.findByXAndY(x, y);
        if (p == null) {
            log.info("property {} not exist x{},y{}", x, y);
            throw new UnprocessableEntityException("x {" + x + "} and y {" + y + "} not exist.");
        }
        return getProperty(p);
    }

    @CacheEvict(value = CACHE_PROPERTY, allEntries = true)
    public PropertyEntity save(PropertyEntity propertyEntity) {
        List<ProvinceEntity> li = provinceRepository.findPronvinces(propertyEntity.getX(), propertyEntity.getY());
        propertyEntity.setProvinces(li);
        log.info("property {} save", propertyEntity);
        return propertyRepository.save(propertyEntity);

    }

    @Cacheable(value = CACHE_PROPERTY)
    public Properties getProperty(int ax, int ay, int bx, int by) {
        List<PropertyEntity> properties = propertyRepository.findProperties(ax, ay, bx, by);
        List<Property> propertyList = properties.stream().map(this::getProperty).collect(toList());
        return new Properties(propertyList.size(), propertyList);
    }

    @Cacheable(value = CACHE_PROPERTY)
    public Property getProperty(long id) {
        PropertyEntity p = propertyRepository.findOne(id);
        if (p == null) {
            log.info("ID not exist {} ", id);
            throw new UnprocessableEntityException("Id >" + id + "< not exist.");
        }
        return getProperty(p);
    }

    Property getProperty(PropertyEntity p) {
        return new Property.PropertyBuilder(p.getId(), p.getX(), p.getY())
                .baths(p.getBaths())
                .beds(p.getBeds())
                .description(p.getDescription())
                .price(p.getPrice())
                .squareMeters(p.getSquareMeters())
                .title(p.getTitle())
                .provices(p.getProvinces().stream().map(ProvinceEntity::getName).collect(Collectors.toList()))
                .build();
    }
}

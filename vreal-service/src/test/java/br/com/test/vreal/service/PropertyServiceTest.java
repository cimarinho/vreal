package br.com.test.vreal.service;

import br.com.test.vreal.VRealApplicationTests;
import br.com.test.vreal.domain.Properties;
import br.com.test.vreal.domain.Property;
import br.com.test.vreal.model.PropertyEntity;
import br.com.test.vreal.model.ProvinceEntity;
import br.com.test.vreal.repository.PropertyRepository;
import br.com.test.vreal.repository.ProvinceRepository;
import org.junit.Before;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.util.Collections;

import static org.junit.Assert.assertNotNull;
import static org.mockito.Mockito.when;

public class PropertyServiceTest extends VRealApplicationTests {

    @InjectMocks
    PropertyService propertyService;

    @Mock
    ProvinceRepository provinceRepository;

    @Mock
    PropertyRepository propertyRepository;

    @Before
    public void initialize() {
        MockitoAnnotations.initMocks(this);
    }

    @Test
    public void save() {
        when(provinceRepository.findPronvinces(1, 1)).thenReturn(Collections.singletonList(provice()));
        PropertyEntity p = getPropertyEntity();
        when(propertyRepository.save(p)).thenReturn(p);
        p = propertyService.save(p);
        assertNotNull(p.getId());
    }

    @Test
    public void getProperty() {
        PropertyEntity p = getPropertyEntity();
        when(propertyRepository.findOne(1L)).thenReturn(p);
        Property property = propertyService.getProperty(1L);
        assertNotNull(property.getId());
    }

    @Test
    public void getProperty_params() {
        PropertyEntity p = getPropertyEntity();
        when(propertyRepository.findOne(1L)).thenReturn(p);
        Properties property = propertyService.getProperty(1,1,1,1);
        assertNotNull(property.getFoundProperties());
    }

    ProvinceEntity provice() {
        ProvinceEntity p = new ProvinceEntity();
        p.setBottomRightX(1);
        p.setBottomRightY(1);
        p.setName("teste");
        p.setUpperLeftX(1);
        p.setUpperLeftY(1);
        return p;
    }

    PropertyEntity getPropertyEntity() {
        PropertyEntity p = new PropertyEntity();
        p.setId(1L);
        p.setX(1);
        p.setY(1);
        p.setBaths(3);
        p.setBeds(4);
        p.setDescription("description");
        p.setPrice(22.2);
        p.setSquareMeters(1L);
        p.setTitle("title");
        p.setProvinces(Collections.singletonList(provice()));
        return p;
    }

}

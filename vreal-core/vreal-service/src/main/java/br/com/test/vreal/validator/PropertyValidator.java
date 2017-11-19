package br.com.test.vreal.validator;

import br.com.test.vreal.exception.UnprocessableEntityException;
import br.com.test.vreal.model.PropertyEntity;
import br.com.test.vreal.service.PropertyService;
import br.com.test.vreal.utils.NumberComparator;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Slf4j
@Component
public class PropertyValidator {

    @Autowired
    private PropertyService propertyService;

    public void propertyExist(PropertyEntity property) {
        PropertyEntity p = propertyService.findPropertyEntityByXAndY(property.getX(), property.getY());
        if (p != null && p.getId() != null) {
            log.error("PropertyEntity already registered {}",property);
            error("PropertyEntity already registered");
        }
    }

    public void idIsValid(Long id) {
        if (NumberComparator.valueOf(id).isLowerThan(1)) {
            log.error("{} is not valid", id);
            error("ID will be more than 0");
        }
    }

    public void paramIsValid(int ax, int ay, int bx, int by) {
        if (NumberComparator.valueOf(ax).isLowerThan(0) ||
                NumberComparator.valueOf(ay).isLowerThan(0) ||
                NumberComparator.valueOf(bx).isLowerThan(0) ||
                NumberComparator.valueOf(by).isLowerThan(0)) {
            log.error("ax {}, ay {}, bx {}, by {}   will be more 0 ", ax, ay, bx, by);
            error("ID will be more than 0");
        }
    }

    void error(String msg) {
        throw new UnprocessableEntityException(msg);
    }
}

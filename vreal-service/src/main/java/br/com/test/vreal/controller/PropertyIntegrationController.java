package br.com.test.vreal.controller;

import br.com.test.vreal.domain.Property;
import br.com.test.vreal.service.PropertyService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import static org.springframework.web.bind.annotation.RequestMethod.GET;

@RestController
@Slf4j
@RequestMapping(Endpoints.ROOT)
public class PropertyIntegrationController {

    @Autowired
    private PropertyService propertyService;

    @RequestMapping(value = {"/integration/{x}/{y}"}, method = GET)
    public Property get(@PathVariable("x") int x, @PathVariable("y") int y) throws Exception {
        log.debug("integration get {x} {y}", x, y);
        return propertyService.findPropertyByXAndY(x, y);
    }
}

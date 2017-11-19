package br.com.test.vreal.controller;

import br.com.test.vreal.domain.Properties;
import br.com.test.vreal.domain.Property;
import br.com.test.vreal.model.PropertyEntity;
import br.com.test.vreal.repository.ProvinceRepository;
import br.com.test.vreal.service.PropertyService;
import br.com.test.vreal.validator.PropertyValidator;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.net.URI;

import static br.com.test.vreal.controller.Endpoints.ROOT;
import static org.springframework.web.bind.annotation.RequestMethod.GET;

@RestController
@Slf4j
@RequestMapping(ROOT)
public class PropertyController {

    @Autowired
    PropertyService propertyService;

    @Autowired
    ProvinceRepository provinceRepository;

    @Autowired
    PropertyValidator propertyValidator;

    @ResponseStatus(HttpStatus.CREATED)
    @RequestMapping(value = "/properties", method = RequestMethod.POST)
    public ResponseEntity<PropertyEntity> create(@Valid @RequestBody PropertyEntity property) {
        log.info("Property create{}", property);
        propertyValidator.propertyExist(property);
        property = propertyService.save(property);
        return ResponseEntity.created(URI.create("/properties/" + property.getId())).body(property);
    }

    @RequestMapping(value = {"/properties/{id}"}, method = GET)
    public Property get(@PathVariable("id") Long id) throws Exception {
        log.info("Property get {}", id);
        propertyValidator.idIsValid(id);
        return propertyService.getProperty(id);
    }

    @RequestMapping(value = {"/properties"}, method = GET)
    public Properties getAll(@RequestParam(value = "ax") int ax,
                             @RequestParam(value = "ay") int ay,
                             @RequestParam(value = "bx") int bx,
                             @RequestParam(value = "by") int by) throws Exception {
        log.info("Property getAll ax{},ay{},bx{},by{}", ax,ay);
        propertyValidator.paramIsValid(ax, ay, bx, by);
        return propertyService.getProperty(ax, ay, bx, by);
    }
}
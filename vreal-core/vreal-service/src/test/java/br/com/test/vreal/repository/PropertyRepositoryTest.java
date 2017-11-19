package br.com.test.vreal.repository;

import br.com.test.vreal.VRealApplicationTests;
import br.com.test.vreal.model.PropertyEntity;
import br.com.test.vreal.model.ProvinceEntity;
import org.junit.Before;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.Collections;
import java.util.List;

import static org.junit.Assert.assertEquals;

public class PropertyRepositoryTest extends VRealApplicationTests {

    @Autowired
    PropertyRepository propertyRepository;

    @Autowired
    ProvinceRepository provinceRepository;

    @Before
    public void initialize() {
        savePropertyGroola();
        savePropertyScavy();
        savePropertyRuja();
    }

    @Test
    public void findProperties_square_inside_groola() {
        List<PropertyEntity> propertyEntities = propertyRepository.findProperties(600,500,1400,499);
        assertEquals("Groola",propertyEntities.get(0).getProvinces().get(0).getName());
    }

    @Test
    public void findProperties_square_inside_scavy() {
        List<PropertyEntity> propertyEntities = propertyRepository.findProperties(3,500,500,0);
        assertEquals("Scavy",propertyEntities.get(0).getProvinces().get(0).getName());
    }

    @Test
    public void findProperties_square_all() {
        List<PropertyEntity> propertyEntities = propertyRepository.findProperties(0,1000,1400,0);
        assertEquals(3 , propertyEntities.size());
    }

    @Test
    public void findProperties_square_ruja() {
        List<PropertyEntity> propertyEntities = propertyRepository.findProperties(3,500,500,0);
        assertEquals("Scavy",propertyEntities.get(0).getProvinces().get(0).getName());
    }

    @Test
    public void findProperties_square_inside_scavy_groola() {
        List<PropertyEntity> propertyEntities = propertyRepository.findProperties(3,1000,600,0);
        assertEquals("Scavy",propertyEntities.get(0).getProvinces().get(0).getName());
    }

    @Test
    public void findProperties_square_inside_ruja() {
        List<PropertyEntity> propertyEntities = propertyRepository.findProperties(600,1000,1400,501);
        assertEquals("Ruja",propertyEntities.get(0).getProvinces().get(0).getName());
    }

    private void savePropertyRuja(){
        save(provice(2L),601,501);
    }

    private void savePropertyGroola(){
        save(provice(5L),601,499);
    }

    private void savePropertyScavy(){
        save(provice(4L),499,499);
    }

    private ProvinceEntity provice(Long id) {
        return provinceRepository.findOne(id);
    }

    private PropertyEntity save(ProvinceEntity provinceEntity, int x, int y) {
        PropertyEntity p = new PropertyEntity();
        p.setX(x);
        p.setY(y);
        p.setBaths(3);
        p.setBeds(4);
        p.setDescription("description");
        p.setPrice(22.2);
        p.setSquareMeters(21L);
        p.setTitle("title");
        p.setProvinces(Collections.singletonList(provinceEntity));
        propertyRepository.save(p);
        return p;
    }
}


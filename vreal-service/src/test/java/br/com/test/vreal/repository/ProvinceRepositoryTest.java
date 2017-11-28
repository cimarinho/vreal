package br.com.test.vreal.repository;

import br.com.test.vreal.VRealApplicationTests;
import br.com.test.vreal.model.ProvinceEntity;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

import static org.junit.Assert.assertEquals;

public class ProvinceRepositoryTest extends VRealApplicationTests {

    @Autowired
    ProvinceRepository provinceRepository;

    @Test
    public void get_all_provice() {
        List<ProvinceEntity> list = provinceRepository.findAll();
        assertEquals(6, list.size());
    }

    @Test
    public void findPronvinces_gode() {
        List<ProvinceEntity> pronvinces = provinceRepository.findPronvinces(399, 501);
        assertEquals("Gode", pronvinces.get(0).getName());
    }

    @Test
    public void findPronvinces_goderuja() {
        List<ProvinceEntity> pronvinces = provinceRepository.findPronvinces(599, 501);
        assertEquals(2, pronvinces.size());
    }

    @Test
    public void findPronvinces_ruja() {
        List<ProvinceEntity> pronvinces = provinceRepository.findPronvinces(601, 501);
        assertEquals("Ruja", pronvinces.get(0).getName());
    }

    @Test
    public void findPronvinces_Jaby() {
        List<ProvinceEntity> pronvinces = provinceRepository.findPronvinces(1101, 501);
        assertEquals("Jaby", pronvinces.get(0).getName());
    }

    @Test
    public void findPronvinces_Scavy() {
        List<ProvinceEntity> pronvinces = provinceRepository.findPronvinces(599, 499);
        assertEquals("Scavy",pronvinces.get(0).getName());
    }

    @Test
    public void findPronvinces_Groola() {
        List<ProvinceEntity> pronvinces = provinceRepository.findPronvinces(601, 499);
        assertEquals("Groola",pronvinces.get(0).getName());
    }

    @Test
    public void findPronvinces_Nova() {
        List<ProvinceEntity> pronvinces = provinceRepository.findPronvinces(801, 499);
        assertEquals("Nova",pronvinces.get(0).getName());
    }

    @Test
    public void findPronvinces_Gode_Ruja__Jaby_Scavy() {
        List<ProvinceEntity> pronvinces = provinceRepository.findPronvinces(600, 500);
        assertEquals(4,pronvinces.size());
    }

}

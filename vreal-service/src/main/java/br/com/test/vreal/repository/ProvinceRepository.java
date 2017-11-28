package br.com.test.vreal.repository;

import br.com.test.vreal.model.ProvinceEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface ProvinceRepository extends JpaRepository<ProvinceEntity, Long> {

    @Query("select p FROM ProvinceEntity p WHERE :x >= p.upperLeftX  AND :x <= p.bottomRightX AND :y <= p.upperLeftY   AND :y >= p.bottomRightY ")
    List<ProvinceEntity> findPronvinces(@Param("x") int x, @Param("y") int y);

}

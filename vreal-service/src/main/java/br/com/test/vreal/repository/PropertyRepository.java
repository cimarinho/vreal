package br.com.test.vreal.repository;

import br.com.test.vreal.model.PropertyEntity;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface PropertyRepository extends JpaRepository<PropertyEntity, Long> {

    String SQL = " select distinct pr FROM PropertyEntity pr join fetch pr.provinces p " +
            " WHERE pr.x >= :ax  AND pr.x <=:bx AND pr.y >= :byy AND pr.y < :ay ";

    @Query(SQL)
    List<PropertyEntity> findProperties(@Param("ax") int ax, @Param("ay") int ay, @Param("bx") int bx, @Param("byy") int byy);

    PropertyEntity findByXAndY(int x, int y);
}
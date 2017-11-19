package br.com.test.vreal.model;

import lombok.Data;
import lombok.ToString;
import org.hibernate.validator.constraints.NotEmpty;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.io.Serializable;

@Data
@Entity
@ToString
@Table(name = "PROVINCE")
public class ProvinceEntity implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @Column(name = "ID")
    private Long id;

    @NotEmpty(message = "Title is required")
    @Column(name = "NAME")
    private String name;

    @Column(name = "UPPERLEFTX")
    private int upperLeftX;

    @Column(name = "UPPERLEFTY")
    private int upperLeftY;

    @Column(name = "BOTTOMRIGHTX")
    private int bottomRightX;

    @Column(name = "BOTTOMRIGHTY")
    private int bottomRightY;

}

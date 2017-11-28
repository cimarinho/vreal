package br.com.test.vreal.model;

import lombok.Data;
import lombok.ToString;
import org.hibernate.validator.constraints.NotEmpty;
import javax.persistence.*;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import java.io.Serializable;
import java.util.List;

@Entity
@Data
@ToString
@Table(name = "PROPERTY")
public class PropertyEntity implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@Column(name = "ID")
	@GeneratedValue
	private Long id;

	@Min(0)
	@Max(1400)
	@Column(name = "X")
	private int x;

	@Min(0)
	@Max(1400)
	@Column(name = "Y")
	private int y;

	@Column(name = "PRICE")
	@Min(0)
	private double price;

	@NotEmpty(message = "Title is required")
	@Column(name = "TITLE")
	private String title;

	@NotEmpty(message = "Description is required")
	@Column(name = "DESCRIPTION")
	private String description;

	@NotNull(message = "Beds is required")
	@Column(name = "BEDS")
	@Min(1)
	@Max(5)
	private int beds;

	@NotNull(message = "Baths is required")
	@Column(name = "BATHS")
	@Min(1)
	@Max(4)
	private int baths;

	@NotNull(message = "SquareMeters is required")
	@Column(name = "SQUAREMETERS")
	@Min(20)
	@Max(240)
	private long squareMeters;

	@ManyToMany(fetch = FetchType.LAZY)
	@JoinTable(name = "PROPERTY_PROVICE", joinColumns = {@JoinColumn(name = "ID_PROPERTY")}, inverseJoinColumns = {@JoinColumn(name = "ID_PROVICE")})
	private List<ProvinceEntity> provinces;




}

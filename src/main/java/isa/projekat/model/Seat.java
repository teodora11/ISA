package isa.projekat.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Seat {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name="seat_id")
	private Long id;

	@Column(nullable = false)
	private int number;
	
	@Column(nullable = false)
	private String reserved;
	
	public Seat() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Seat(int number, String reserved) {
		super();
		this.number = number;
		this.reserved = reserved;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public int getNumber() {
		return number;
	}

	public void setNumber(int number) {
		this.number = number;
	}

	public String getReserved() {
		return reserved;
	}

	public void setReserved(String reserved) {
		this.reserved = reserved;
	}
	
	
}

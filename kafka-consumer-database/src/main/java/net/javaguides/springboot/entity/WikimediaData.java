package net.javaguides.springboot.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Lob;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "wikimedia_recentchange")
@Getter
@Setter
public class WikimediaData {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;
	
	@Lob
	private String wikimediaEventData;

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getWikimediaEventData() {
		return wikimediaEventData;
	}

	public void setWikimediaEventData(String wikimediaEventData) {
		this.wikimediaEventData = wikimediaEventData;
	}

	

	

}

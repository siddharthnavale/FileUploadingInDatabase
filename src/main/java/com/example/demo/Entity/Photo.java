package com.example.demo.Entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Lob;

import org.hibernate.annotations.GenericGenerator;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
public class Photo {

	@Id
	@Column(length=50)
	@GeneratedValue(generator="uuid")
	@GenericGenerator(name ="uuid",strategy="uuid2")
	private String id;
	private String photoName;
	private String photoType;
	@Lob
	private byte[] data;
	
	public Photo(String photoName, String photoType, byte[] data) {
	
		this.photoName = photoName;
		this.photoType = photoType;
		this.data = data;
	}
	
	
}

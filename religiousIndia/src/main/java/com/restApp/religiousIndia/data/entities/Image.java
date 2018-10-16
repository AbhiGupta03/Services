package com.restApp.religiousIndia.data.entities;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.annotations.GenericGenerator;

@Entity
@Table(name = "RI_IMAGE")
public class Image {
	@Id
	@GenericGenerator(name = "sequence__id", strategy = "com.restApp.religiousIndia.utilities.ImageIdGenrator")
	@GeneratedValue(generator = "sequence__id")
	private String imageId;

	private String imageType;

	private String imagePath;

	private String category;

	public String getImageId() {
		return imageId;
	}

	public void setImageId(String imageId) {
		this.imageId = imageId;
	}

	public String getImageType() {
		return imageType;
	}

	public void setImageType(String imageType) {
		this.imageType = imageType;
	}

	public String getImagePath() {
		return imagePath;
	}

	public void setImagePath(String imagePath) {
		this.imagePath = imagePath;
	}

	@Override
	public String toString() {
		return "{'imageId':'" + imageId + "', 'imageType':'" + imageType + "', 'imagePath':'" + imagePath + "'}";
	}

	public String getCategory() {
		return category;
	}

	public void setCategory(String category) {
		this.category = category;
	}

}

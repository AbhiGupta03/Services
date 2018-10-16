package com.restApp.religiousIndia.data.entities;

import java.util.Arrays;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Lob;
import javax.persistence.Table;

@Entity
@Table(name = "RI_IMAGES")
public class Images {

	@Id
	@Column(name = "IMAGE_ID")
	private String imageId;

	private String category;

	private String imageType;

	@Lob
	@Column(name = "IMAGE")
	private byte[] image;

	public Images() {
	}

	public Images(String imageId, String category, String imageType, byte[] image) {
		super();
		this.imageId = imageId;
		this.category = category;
		this.imageType = imageType;
		this.image = image;
	}

	public String getImageId() {
		return imageId;
	}

	public void setImageId(String imageId) {
		this.imageId = imageId;
	}

	public String getCategory() {
		return category;
	}

	public void setCategory(String category) {
		this.category = category;
	}

	public String getImageType() {
		return imageType;
	}

	public void setImageType(String imageType) {
		this.imageType = imageType;
	}

	public byte[] getImage() {
		return image;
	}

	public void setImage(byte[] image) {
		this.image = image;
	}

	@Override
	public String toString() {
		return "Images [imageId=" + imageId + ", category=" + category + ", imageType=" + imageType + ", image="
				+ Arrays.toString(image) + "]";
	}

}

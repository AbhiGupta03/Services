package com.restApp.religiousIndia.services.imageServices;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.restApp.religiousIndia.data.entities.Image;
import com.restApp.religiousIndia.data.entities.Images;
import com.restApp.religiousIndia.data.repositry.ImageRepository;
import com.restApp.religiousIndia.data.repositry.ImagesRepositry;

@Service
public class RetriveImageService {

	@Autowired
	ImageRepository imageRepository;

	@Autowired
	ImagesRepositry dummyRepositry;

	/*
	 * public void saveImage() { String imageNames[] = { "2", "3", "4", "5" }; for
	 * (String image : imageNames) { ClassPathResource imgFile = new
	 * ClassPathResource("image/" + image + ".jpg");
	 * 
	 * byte[] arrayPic = null; try { arrayPic = new byte[(int)
	 * imgFile.contentLength()]; } catch (IOException e1) { e1.printStackTrace(); }
	 * 
	 * try { imgFile.getInputStream().read(arrayPic); } catch (IOException e) {
	 * e.printStackTrace(); }
	 * 
	 * Images blackImage = new Images(image, "temple", "jpg", arrayPic);
	 * imageRepository.save(blackImage); } }
	 */

	/*
	 * public void retriveImage() { List<Images> all = imageRepository.findAll();
	 * for (Images images : all) { Images image = images; try { String path =
	 * "retrieve-dir/" + images.getImageId() + "." + images.getImageType();
	 * Files.write(Paths.get(path), images.getImage()); } catch (IOException e) {
	 * e.printStackTrace(); } } // Images images = all.get(0);
	 * 
	 * }
	 */

	/*
	 * public String imageToBase64_2(String imageId) { Images retriveImageByID =
	 * retriveImageByID(imageId); String imageType =
	 * retriveImageByID.getImageType(); String byteArrayString = "data:image/" +
	 * imageType + ";base64,"; byte[] imageArraay = retriveImageByID.getImage();
	 * 
	 * byteArrayString += Base64.encodeBase64String(imageArraay); //
	 * System.out.println(byteArrayString);
	 * 
	 * return byteArrayString; }
	 */

	/*
	 * public String imageToBase64() { File file = new
	 * File("E:/ReligiousIndia/relegiousIndia/src/main/resources/image/temple.jpg");
	 * String byteArrayString = "data:image/jpeg;base64,"; try { FileInputStream
	 * inputStream = new FileInputStream(file); byte[] imageArraay = new byte[(int)
	 * file.length()]; try { inputStream.read(imageArraay); byteArrayString +=
	 * Base64.encodeBase64String(imageArraay); System.out.println(byteArrayString);
	 * } catch (IOException e) { e.printStackTrace(); } } catch
	 * (FileNotFoundException e) { e.printStackTrace(); } return byteArrayString; }
	 */

	public Images retriveImageByID(String imageId) {
		Images findByImageId = imageRepository.findByImageId(imageId);

		return findByImageId;

	}

	public String getImagePath(String imageId) {
		return dummyRepositry.findOne(imageId).getImagePath();
	}

	public String getImageType(String imageId) {
		return dummyRepositry.findOne(imageId).getImageType();
	}

	public String saveImageToDb(Image image) {
		Image save = dummyRepositry.save(image);

		if (save != null) {
			return save.getImageId();
		} else {
			return null;
		}
	}

	public Image getImage(String imageId) {
		return dummyRepositry.findOne(imageId);
	}

	public List<Image> getLatestUploadedImages() {
		return dummyRepositry.getLatestUploadedImages("1");

	}

}

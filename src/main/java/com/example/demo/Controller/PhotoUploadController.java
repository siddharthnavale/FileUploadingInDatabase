package com.example.demo.Controller;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;
import com.example.demo.Entity.Photo;
import com.example.demo.Response.Response;
import com.example.demo.Service.PhotoService;


@RestController
public class PhotoUploadController {
	
	@Autowired
	private PhotoService photoService;
	
	
	@PostMapping("/uploadPhoto")
	public Response uploadPhoto(@RequestParam ("photo") MultipartFile photo) {
	Photo p=photoService.storePhoto(photo);
	
	String photoDownloadUri=ServletUriComponentsBuilder.fromCurrentContextPath().
		                     path("/photos/").path(p.getPhotoName()).toUriString();
	
		return new Response(p.getPhotoName(),photoDownloadUri,photo.getContentType(),
				photo.getSize());
	}
	
	@PostMapping("/uploadPhotos")
	public List<Response> uploadPhotos(@RequestParam("photos") MultipartFile[] photos){
	
		return Arrays.asList(photos)
                .stream()
                .map(photo -> uploadPhoto(photo))
                .collect(Collectors.toList());
	}
	

}

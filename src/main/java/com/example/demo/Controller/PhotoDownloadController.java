package com.example.demo.Controller;




import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.ByteArrayResource;
import org.springframework.core.io.Resource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.Entity.Photo;
import com.example.demo.Service.PhotoService;

@RestController
public class PhotoDownloadController{
	
	@Autowired
	private  PhotoService photoService;
	
	@GetMapping("/downloadPhoto/{id}")
	public ResponseEntity<Resource>downloadPhoto(@PathVariable String id,HttpServletRequest request)
	{
	Photo photo	=photoService.getPhoto(id);
		
	     return ResponseEntity.ok()
	                .contentType(MediaType.parseMediaType(photo.getPhotoType()))
	                .header(HttpHeaders.CONTENT_DISPOSITION, "attachment; filename=\"" + photo.getPhotoName() + "\"")
	                .body(new ByteArrayResource(photo.getData()));
		
	}
	

}

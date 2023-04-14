package com.example.demo.Service;

import org.springframework.web.multipart.MultipartFile;
import com.example.demo.Entity.Photo;

public interface PhotoService {

	public Photo storePhoto(MultipartFile photo);

	public Photo getPhoto(String id);

}

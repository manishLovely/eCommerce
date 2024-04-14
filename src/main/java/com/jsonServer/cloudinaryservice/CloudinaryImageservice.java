package com.jsonServer.cloudinaryservice;

import java.util.Map;

import org.springframework.web.multipart.MultipartFile;

public interface CloudinaryImageservice {

	public Map upload(MultipartFile file);
		
}

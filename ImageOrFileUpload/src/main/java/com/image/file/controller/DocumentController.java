package com.image.file.controller;

import java.io.IOException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.image.file.service.DocumentService;

@RestController
@RequestMapping("/image")
public class DocumentController {

	
	@Autowired
	private DocumentService documentService;
	
	@PostMapping("/save")
	public String saveDocument(@RequestParam("file") MultipartFile file,@RequestParam("documentName") String documentName,@RequestParam("description") String description) throws IOException {
		return documentService.saveDocument(file,documentName,description);
	}
}

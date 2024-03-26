package com.image.file.service;

import java.io.IOException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.image.file.entity.Document;
import com.image.file.repository.DocumentRepo;

@Service
public class DocumentService {
	
	@Autowired
	private DocumentRepo documentRepo;
	
	public String saveDocument(MultipartFile file,String documentName,String description) throws IOException {
		Document document=new Document();
		document.setDocumentName(documentName);
		document.setDescription(description);
		document.setImage(file.getBytes());
		documentRepo.save(document);
		return "document saved";
	}

}

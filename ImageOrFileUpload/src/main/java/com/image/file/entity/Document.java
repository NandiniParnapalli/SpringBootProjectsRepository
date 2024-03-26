package com.image.file.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Lob;
import lombok.AllArgsConstructor;

import lombok.NoArgsConstructor;

@Entity

@AllArgsConstructor
@NoArgsConstructor
public class Document {
    
	@Id
       @GeneratedValue(strategy=GenerationType.IDENTITY)
	private Integer documentId;
	private String documentName;
	private String description;
	@Lob
	private byte[] image;
	
	   public Integer getDocumentId() {
			return documentId;
		}
		public void setDocumentId(Integer documentId) {
			this.documentId = documentId;
		}
		public String getDocumentName() {
			return documentName;
		}
		public void setDocumentName(String documentName) {
			this.documentName = documentName;
		}
		public String getDescription() {
			return description;
		}
		public void setDescription(String description) {
			this.description = description;
		}
		public byte[] getImage() {
			return image;
		}
		public void setImage(byte[] image) {
			this.image = image;
		}
	
}

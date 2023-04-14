package com.example.demo.Response;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Response {
	
	    private String photoName;
	    private String photoDownloadUrl;
	    private String photoType;
	    private long size;
}

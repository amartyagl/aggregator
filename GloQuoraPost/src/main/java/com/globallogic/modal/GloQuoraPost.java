package com.globallogic.modal;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Document(collection = "glo_quora_post")
public class GloQuoraPost {
	
	private int userid;
    @Id
    private String postid;
    private String title;
    private String body;

}

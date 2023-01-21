package com.globallogic.modal;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class GloQuoraPost {
	
	private int userid;
    private String postid;
    private String title;
    private String body;

}

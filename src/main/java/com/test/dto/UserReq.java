package com.test.dto;

// import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Builder
@Data
@NoArgsConstructor
@AllArgsConstructor
public class UserReq {

	private int id;
	private String name;
	private String email;
	private String password;
	private String confirm;
	private String role;

}

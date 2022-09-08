package com.test.bean;

import java.util.List;

import com.test.dto.CourseRes;
// import com.test.dto.StudentRes;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Builder
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Student {

	private String id;
	private String name;
	private String dob;
	private String gender;
	private String phone;
	private String education;
	private List<String> attend;
	private String course;
	private List<CourseRes> courseres;

}

package com.test.dto;

// import java.util.Arrays;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;
import javax.persistence.Transient;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Builder
@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "student")
public class StudentRes {

	@Id
	@Column(name = "sid")
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer id;
	private String name;
	private String dob;
	private String gender;
	private String phone;
	private String education;

	@Transient
	private String course;

	@ManyToMany
	@JoinTable(name = "coursedetail", joinColumns = {
			@JoinColumn(referencedColumnName = "sid", name = "studentid")
	}, inverseJoinColumns = {
			@JoinColumn(referencedColumnName = "cid", name = "courseid")
	})
	private List<CourseRes> courseres;

}

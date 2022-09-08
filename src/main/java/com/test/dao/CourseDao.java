package com.test.dao;

import java.util.List;

// import com.test.dto.CourseReq;
import com.test.dto.CourseRes;

public interface CourseDao {

    void insertCourse(CourseRes res);

    int couresMaxid();

    List<CourseRes> showCouse();

    List<CourseRes> getcourseofone(Integer i);

}

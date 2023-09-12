package com.example.springmodels.repos;

import com.example.springmodels.models.Course;
import org.springframework.data.repository.CrudRepository;

public interface CourseRepository extends CrudRepository<Course, Long> {
    Course findCourseByName(String name);
}

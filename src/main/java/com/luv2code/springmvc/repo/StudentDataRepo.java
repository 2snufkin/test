package com.luv2code.springmvc.repo;

import com.luv2code.springmvc.models.CollegeStudent;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface StudentDataRepo extends CrudRepository<CollegeStudent, Integer> {

    CollegeStudent findCollegeStudentById(int id);


}

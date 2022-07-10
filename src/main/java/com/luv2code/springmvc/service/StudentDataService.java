package com.luv2code.springmvc.service;


import com.luv2code.springmvc.models.CollegeStudent;
import com.luv2code.springmvc.repo.StudentDataRepo;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

@Service
@Transactional
public class StudentDataService {

    private final StudentDataRepo studentDataRepo;

    public StudentDataService(StudentDataRepo studentDataRepo) {
        this.studentDataRepo = studentDataRepo;
    }

    public CollegeStudent findStudentById(int id) {

        return studentDataRepo.findCollegeStudentById(id);


    }

    public CollegeStudent createNewStudent(CollegeStudent collge) {
       return  studentDataRepo.save(collge);
    }

    public void deleteStudentById(int i) {
         studentDataRepo.deleteById(i);
    }
}

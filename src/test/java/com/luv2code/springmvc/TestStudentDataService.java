package com.luv2code.springmvc;

import com.luv2code.springmvc.models.CollegeStudent;
import com.luv2code.springmvc.service.StudentDataService;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.Assertions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.test.context.TestPropertySource;
import static org.junit.jupiter.api.Assertions.*;
//@TestPropertySource("/application.properties")
@SpringBootTest
 class TestStudentDataService {


    @Autowired
    private StudentDataService studentDataService;

    @Autowired
    private JdbcTemplate jdbcTemplate;


    @BeforeEach
    public void beforeEach(){
        jdbcTemplate.execute("insert into student(id, firstname, lastname, email_address ) values (3, 'tomer', 'shenar', 'tomi@gmail.com')");
    }

    @Test
     void testCreateStudent(){
        CollegeStudent collge = studentDataService.findStudentById(3);
        collge.setFirstname("Oren");
        collge.setId(4);
        var stud = studentDataService.createNewStudent(collge);
        assertEquals("Oren",  studentDataService.findStudentById(4).getFirstname(), "the student name should be Oren");
        assertEquals("Oren",  stud.getFirstname(), "the student name should be Oren");


    }

    @Test
    void findById(){
       CollegeStudent student =  studentDataService.findStudentById(3);
       CollegeStudent studentNull =  studentDataService.findStudentById(1);
        assertNotNull(student, "student shouldnt be null");
        assertNull(studentNull, "student should  be null");
    }

    @Test
    void deleteStudent(){
        var id = 3;
        assertNotNull(studentDataService.findStudentById(3));
        studentDataService.deleteStudentById(3);
        assertNull(studentDataService.findStudentById(3));
    }

    @AfterEach
    public void afterEach(){
        jdbcTemplate.execute("delete from student");
    }
}

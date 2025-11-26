package com.driver;

import java.util.*;

import org.springframework.stereotype.Repository;

@Repository
public class StudentRepository {

    private HashMap<String, Student> studentMap;
    private HashMap<String, Teacher> teacherMap;
    private HashMap<String, List<String>> teacherStudentMapping;

    public StudentRepository(){
        this.studentMap = new HashMap<String, Student>();
        this.teacherMap = new HashMap<String, Teacher>();
        this.teacherStudentMapping = new HashMap<String, List<String>>();
    }

    public void saveStudent(Student student){
        // your code goes here
    }

    public void saveTeacher(Teacher teacher){
        // your code goes here
    }

    public void saveStudentTeacherPair(String student, String teacher){
        if(studentMap.containsKey(student) && teacherMap.containsKey(teacher)){
            // your code goes here
        }
    }

    public Student findStudent(String student){
        // your code goes here
    }

    public Teacher findTeacher(String teacher){
        // your code goes here
    }

    public List<String> findStudentsFromTeacher(String teacher){
        // your code goes here
        // find student list corresponding to a teacher
    }

    public List<String> findAllStudents(){
        // your code goes here
    }

    public void deleteTeacher(String teacher){
        // your code goes here
    }

    public void deleteAllTeachers(){
        // your code goes here
    }
}
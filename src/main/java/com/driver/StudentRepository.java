package com.driver;

import java.util.*;

import org.springframework.boot.web.client.ClientHttpRequestFactorySupplier;
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

        studentMap.put(student.getName(),student);
    }

    public void saveTeacher(Teacher teacher){

        teacherMap.put(teacher.getName(),teacher);
    }

    public void saveStudentTeacherPair(String student, String teacher){
        if(studentMap.containsKey(student) && teacherMap.containsKey(teacher)){
            teacherStudentMapping.putIfAbsent(teacher,new ArrayList<>());
            teacherStudentMapping.get(teacher).add(student);
        }
    }

    public Student findStudent(String student){

        return studentMap.get(student);
    }

    public Teacher findTeacher(String teacher){
        return teacherMap.get(teacher);
    }

    public List<String> findStudentsFromTeacher(String teacher){

        return teacherStudentMapping.getOrDefault(teacher,new ArrayList<>());
    }

    public List<String> findAllStudents(){

        return new ArrayList<>(studentMap.keySet());
    }

    public void deleteTeacher(String teacher){

        if (teacherStudentMapping.containsKey(teacher)) {
            for (String student : teacherStudentMapping.get(teacher)) {
                studentMap.remove(student);
            }
            teacherStudentMapping.remove(teacher);
        }
        teacherMap.remove(teacher);
    }

    public void deleteAllTeachers(){

        for (String teacher : teacherStudentMapping.keySet()) {
            for (String student : teacherStudentMapping.get(teacher)) {
                studentMap.remove(student);
            }
        }
        teacherStudentMapping.clear();
        teacherMap.clear();
    }
}
package com.example.studentmanager.service.impl;

import com.example.studentmanager.model.Student;
import com.example.studentmanager.service.IService;

import java.util.ArrayList;
import java.util.List;

public class StudentService implements IService<Student> {
    private List<Student> studentList = new ArrayList<>();

    public StudentService() {
        studentList.add(new Student(1, "Linh", "https://scontent.fhan17-1.fna.fbcdn.net/v/t39.30808-6/350109420_764451105152538_4996024575475619500_n.jpg?_nc_cat=108&ccb=1-7&_nc_sid=5f2048&_nc_ohc=aYYJp1zo0uQAX9s2B1w&_nc_ht=scontent.fhan17-1.fna&oh=00_AfAMpr3_JD0lTWxg4rx2HqjCTG_lMq_XyVExjZ7TocliTQ&oe=65648557"));
        studentList.add(new Student(2, "Giang", "https://scontent.fhan17-1.fna.fbcdn.net/v/t39.30808-6/393726824_7131796790177468_1233110796465954827_n.jpg?_nc_cat=109&ccb=1-7&_nc_sid=5f2048&_nc_ohc=z1yGxpEqxvgAX85WHBv&_nc_ht=scontent.fhan17-1.fna&oh=00_AfArzlPvlxiTTqwHij-bB_lXNp4t_Ybw2B6sdFks9DsaAg&oe=6563FF37"));
        studentList.add(new Student(3, "Vanh", "https://scontent.fhan17-1.fna.fbcdn.net/v/t1.6435-9/65564772_2238135596302211_2820444421294653440_n.jpg?_nc_cat=105&ccb=1-7&_nc_sid=be3454&_nc_ohc=Deh1F6pTXsAAX9L0-ob&_nc_ht=scontent.fhan17-1.fna&oh=00_AfCbYha2_N7xq5lG92lxNW_G3m0AtpDTNxvWivKECrQVJg&oe=65868AE3"));
        studentList.add(new Student(4, "Linh", "https://scontent.fhan17-1.fna.fbcdn.net/v/t1.18169-9/12647372_559924377497122_5248014128802813831_n.jpg?_nc_cat=102&ccb=1-7&_nc_sid=908e45&_nc_ohc=oqM0TuJIM4kAX9BWBE-&_nc_ht=scontent.fhan17-1.fna&oh=00_AfDo8FIlNABYRuXVo6tbtIq1lugYoRXGW_-P4JBLA0nCKA&oe=6587D473"));
    }

    @Override
    public void add(Student student) {
        studentList.add(student);
    }

    @Override
    public void edit(int id, Student student) {
        int index = findById(id);
        studentList.set(index, student);
    }

    @Override
    public void delete(int id) {
        int index = findById(id);
        studentList.remove(index);
    }

    @Override
    public List<Student> findAll() {
        return this.studentList;
    }

    @Override
    public int findById(int id) {
        for (int i = 0; i < this.studentList.size(); i++) {
            if (id == studentList.get(i).getId()) {
                return i;
            }
        }
        return -1;
    }

    @Override
    public List<Student> getByName(String name) {
        List<Student> listProduct = new ArrayList<>();
        for (Student student : studentList) {
            if (student.getName().toLowerCase().contains(name.toLowerCase())) {
                listProduct.add(student);
            }
        }
        return listProduct;
    }


    public Student getStudentById(int id) {
        int index = findById(id);
        return studentList.get(index);
    }

}

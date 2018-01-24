package com.school.student.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import org.hibernate.validator.constraints.NotBlank;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "students")
@EntityListeners(AuditingEntityListener.class)
@JsonIgnoreProperties(value = {"createdAt", "updatedAt"},allowGetters = true)


/*
 
DB : [Student.sql]
-------------------
studentCode
Name
IC
Age
Sex
Phone
Address
Year
StudentClass 
EmergencyContact
createdAt
updatedAt

*/


public class Student {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @NotBlank
    private String studentCode;
    
    @NotBlank
    private String name;

    @NotBlank
    private String ic;

    @NotBlank
    private String age;

    @NotBlank
    private String sex;

    @NotBlank
    private String phone;

    @NotBlank
    private String address;

    @NotBlank
    private String year;

    @NotBlank
    private String studentClass;


    @NotBlank
    private String emergencyContact;

    
    @Column(nullable = false, updatable = false)
    @Temporal(TemporalType.TIMESTAMP)
    @CreatedDate
    private Date createdAt;

    @Column(nullable = false)
    @Temporal(TemporalType.TIMESTAMP)
    @LastModifiedDate
    private Date updatedAt;

    
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }
    
    public String getStudentCode() {
        return studentCode;
    }

    public void setStudentCode(String _studentID) {
        this.studentCode = _studentID;
    }

    public String getName() {
        return name;
    }

    public void setName(String _name) {
        this.name = _name;
    }

    public String getIC() {
        return ic;
    }

    public void setIC(String _ic) {
        this.ic = _ic;
    }

    public String getAge() {
        return age;
    }

    public void setAge(String _age) {
        this.age = _age;
    }
    

    public String getSex() {
        return sex;
    }

    public void setSex(String _sex) {
        this.sex = _sex;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String _phone) {
        this.phone = _phone;
    }

    
    public String getAddress() {
        return address;
    }

    public void setAddress(String _address) {
        this.address = _address;
    }

    
    public String getYear() {
        return year;
    }

    public void setYear(String _year) {
        this.year = _year;
    }

    
    public String getStudentClass() {
        return studentClass;
    }

    public void setStudentClass(String _class) {
        this.studentClass = _class;
    }

    
    public String getEmergencyContact() {
        return emergencyContact;
    }

    public void setEmergencyContact(String _emergencyContact) {
        this.emergencyContact = _emergencyContact;
    }
    
    
    public Date getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(Date _createdAt) {
        this.createdAt = _createdAt;
    }

    public Date getUpdatedAt() {
        return updatedAt;
    }

    public void setUpdatedAt(Date _updatedAt) {
        this.updatedAt = _updatedAt;
    }

}

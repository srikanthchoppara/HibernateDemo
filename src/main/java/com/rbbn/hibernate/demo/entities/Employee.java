package com.rbbn.hibernate.demo.entities;

import lombok.Setter;
import lombok.Getter;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.sql.Date;

@Entity
@Table(name="tbl_employee")
@Getter
@Setter
public class Employee {
    @Id
    @Column(name="id")
    private Long id;

    @Column(name = "name")
    private String name;

    @Column(name="department")
    private String department;

    @Column(name="gender")
    private String gender;

    @Column(name="dob")
    private Date dob;

}

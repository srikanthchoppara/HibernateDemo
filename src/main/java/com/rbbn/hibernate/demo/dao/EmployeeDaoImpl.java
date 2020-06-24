package com.rbbn.hibernate.demo.dao;

import com.rbbn.hibernate.demo.entities.Employee;
import com.rbbn.hibernate.demo.util.HibernateUtilConfig;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.provider.HibernateUtils;
import org.springframework.stereotype.Repository;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import java.sql.Date;
import java.util.ArrayList;
import java.util.List;

@Repository
public class EmployeeDaoImpl implements EmployeeDao {

    private HibernateUtilConfig hibernateUtilConfig = new HibernateUtilConfig();

    private SessionFactory sessionFacotry = hibernateUtilConfig.getSessionFactory();

    @Override
    public void createEmployee(Employee employee) {
        Session session = null;

        try {
            session = sessionFacotry.openSession();
            session.beginTransaction();
            Long id = (Long) session.save(employee);
            System.out.println("Employee created with id = " + id);
            session.getTransaction().commit();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            session.clear();
            session = null;
        }
    }

    @Override
    public List<Employee> getAllEmployees() {
        List<Employee> empList = new ArrayList<Employee>();
        Session session = null;
        try {
            session = sessionFacotry.openSession();
            session.beginTransaction();
            CriteriaBuilder criteriaBuilder = session.getCriteriaBuilder();
            CriteriaQuery<Employee> criteriaQuery = criteriaBuilder.createQuery(Employee.class);
            empList = session.createQuery(criteriaQuery).getResultList();
            session.getTransaction().commit();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            session.clear();
            session = null;
        }
        return empList;
    }

    @Override
    public List<Employee> getEmployeeById(Long id) {
        List<Employee> empList = new ArrayList<Employee>();
        Session session = null;

        try {
            session = sessionFacotry.openSession();
            session.beginTransaction();
            CriteriaBuilder criteriaBuilder = session.getCriteriaBuilder();
            CriteriaQuery<Employee> criteriaQuery = criteriaBuilder.createQuery(Employee.class);
            Root<Employee> from = criteriaQuery.from(Employee.class);
            criteriaQuery.select(from);
            criteriaQuery.where(criteriaBuilder.equal(from.get("id"), id));
            empList = session.createQuery(criteriaQuery).getResultList();
            session.getTransaction().commit();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            session.clear();
            session = null;
        }
        return empList;
    }

    @Override
    public List<Employee> getEmployeeByName(String name) {
        List<Employee> empList = new ArrayList<Employee>();
        Session session = null;

        try {
            session = sessionFacotry.openSession();
            session.beginTransaction();
            CriteriaBuilder criteriaBuilder = session.getCriteriaBuilder();
            CriteriaQuery<Employee> criteriaQuery = criteriaBuilder.createQuery(Employee.class);
            Root<Employee> from = criteriaQuery.from(Employee.class);
            criteriaQuery.select(from);
            criteriaQuery.where(criteriaBuilder.equal(from.get("name"), name));
            empList = session.createQuery(criteriaQuery).getResultList();
            session.getTransaction().commit();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            session.clear();
            session = null;
        }
        return empList;
    }

    @Override
    public List<Employee> getEmployeeByDepartment(String department) {
        List<Employee> empList = new ArrayList<Employee>();
        Session session = null;

        try {
            session = sessionFacotry.openSession();
            session.beginTransaction();
            CriteriaBuilder criteriaBuilder = session.getCriteriaBuilder();
            CriteriaQuery<Employee> criteriaQuery = criteriaBuilder.createQuery(Employee.class);
            Root<Employee> from = criteriaQuery.from(Employee.class);
            criteriaQuery.select(from);
            criteriaQuery.where(criteriaBuilder.equal(from.get("department"), department));
            empList = session.createQuery(criteriaQuery).getResultList();
            session.getTransaction().commit();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            session.clear();
            session = null;
        }
        return empList;
    }

    @Override
    public List<Employee> getEmployeeByGender(String gender) {
        List<Employee> empList = new ArrayList<Employee>();
        Session session = null;

        try {
            session = sessionFacotry.openSession();
            session.beginTransaction();
            CriteriaBuilder criteriaBuilder = session.getCriteriaBuilder();
            CriteriaQuery<Employee> criteriaQuery = criteriaBuilder.createQuery(Employee.class);
            Root<Employee> from = criteriaQuery.from(Employee.class);
            criteriaQuery.select(from);
            criteriaQuery.where(criteriaBuilder.equal(from.get("gender"), gender));
            empList = session.createQuery(criteriaQuery).getResultList();
            session.getTransaction().commit();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            session.clear();
            session = null;
        }
        return empList;
    }

    @Override
    public List<Employee> getEmployeeByDob(Date dob) {
        List<Employee> empList = new ArrayList<Employee>();
        Session session = null;

        try {
            session = sessionFacotry.openSession();
            session.beginTransaction();
            CriteriaBuilder criteriaBuilder = session.getCriteriaBuilder();
            CriteriaQuery<Employee> criteriaQuery = criteriaBuilder.createQuery(Employee.class);
            Root<Employee> from = criteriaQuery.from(Employee.class);
            criteriaQuery.select(from);
            criteriaQuery.where(criteriaBuilder.equal(from.get("dob"), dob));
            empList = session.createQuery(criteriaQuery).getResultList();
            session.getTransaction().commit();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            session.clear();
            session = null;
        }
        return empList;
    }
}

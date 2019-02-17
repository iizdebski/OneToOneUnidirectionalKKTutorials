package com.izdebski.client;

import java.util.Date;

import com.izdebski.entities.Address;
import com.izdebski.entities.Employee;
import com.izdebski.util.HibernateUtil;
import org.hibernate.HibernateException;
import org.hibernate.Session;

public class SaveDataClient {

    public static void main(String[] args) {
        try(Session session = HibernateUtil.getSessionFactory().openSession()) {

            createEmployee(session);
        } catch (HibernateException e) {
            e.printStackTrace();
        }
    }

    private static void createEmployee(Session session) {
        session.beginTransaction();
        Integer id =(Integer)session.save(getEmployee());
        System.out.println("Employee is created  with Id::"+id);
        session.getTransaction().commit();

    }

    private static Employee getEmployee(){
        Employee employee= new Employee();
        employee.setEmployeeName("Peter Petrenko");
        employee.setEmail("peter.pt2031@gmail.com");
        employee.setSalary(50000.00);
        employee.setDoj(new Date());

        Address address1 = new Address();
        address1.setCity("Ternopil");
        address1.setPincode(9087727L);
        address1.setState("Western Ukraine");
        address1.setStreet("Petlury Street");

        employee.setAddress(address1);

        return employee;
    }
}
package com.capgemini.spring;

import java.util.*;

import org.hibernate.Criteria;
import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.SQLQuery;
import org.hibernate.Session;    
import org.hibernate.SessionFactory;    
import org.hibernate.Transaction;  
import org.hibernate.boot.Metadata;  
import org.hibernate.boot.MetadataSources;  
import org.hibernate.boot.registry.StandardServiceRegistry;  
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;  
import org.hibernate.cfg.Configuration;
import org.hibernate.criterion.Criterion;
import org.hibernate.criterion.Restrictions;

  
    
public class StoreData { 
	
	private static SessionFactory factory;
	static Session session;
	static Transaction tx;
	 Metadata meta;
	 StandardServiceRegistry ssr;
	
	public StoreData()
	{
		 ssr = new StandardServiceRegistryBuilder().configure("hibernate.cfg.xml").build();  
        
		    meta = new MetadataSources(ssr).getMetadataBuilder().build();  
		  
		 factory = meta.getSessionFactoryBuilder().build();
		 
		 session = factory.openSession();  
			 tx = session.beginTransaction();
	}
	
	
public void criDel()
{
	Employee emp = (Employee ) session.createCriteria(Employee.class)
            .add(Restrictions.eq("id", 202)).uniqueResult();
session.delete(emp);
tx.commit();
}
	


	
	
	public void listEmployeesNat( ){
	     
		 session = factory.openSession();
	      
	      try {
	         tx = session.beginTransaction();
	         
	         String sql = "SELECT firstName,lastName FROM EMPLOYEE where id=101 ";
	         SQLQuery query = session.createSQLQuery(sql);
	         query.setResultTransformer(Criteria.ALIAS_TO_ENTITY_MAP);
	         List data = query.list();

	         for(Object object : data) {
	            Map row = (Map)object;
	            System.out.print("First Name: " + row.get("firstName")); 
	            System.out.println(", Last Nmae: " + row.get("lastName")); 
	         }
	         tx.commit();
	      } catch (HibernateException e) {
	         if (tx!=null) tx.rollback();
	         e.printStackTrace(); 
	      } finally {
	         session.close(); 
	      }
	   }
	
	 public  void listEmployees( ){
		 session = factory.openSession();
	     
	      System.out.println("Before try");
	      try {
	         tx = session.beginTransaction();
	         List employees = (List) session.createQuery("FROM Employee").list(); 
	         for (Iterator iterator = ((java.util.List) employees).iterator(); iterator.hasNext();){
	            Employee employee = (Employee) iterator.next(); 
	            System.out.print("First Name: " + employee.getFirstName()); 
	            System.out.print("  Last Name: " + employee.getLastName()); 
	            System.out.println(" Id "+employee.getId());
	            
	         }
	         tx.commit();
	      } catch (HibernateException e) {
	         if (tx!=null) tx.rollback();
	         e.printStackTrace(); 
	      } finally {
	         session.close(); 
	      }
	   }
	 
	
	 
	 
	   public  void hqldelete(Integer EmployeeID){
		      
			 session = factory.openSession();
		      try {
		         tx = session.beginTransaction();
		         Employee employee = (Employee)session.get(Employee.class, EmployeeID); 
		         session.delete(employee); 
		         tx.commit();
		      } catch (HibernateException e) {
		         if (tx!=null) tx.rollback();
		         e.printStackTrace(); 
		      } finally {
		         session.close(); 
		      }
		   }
	   @SuppressWarnings("null")
	
	   
	
	   public static void hqlupdate(){
			 session = factory.openSession();
	   tx = session.beginTransaction(); 
       Query query=session.createQuery("update Employee set firstName=:n where id=:i");  
      query.setParameter("n","Ram");  
      query.setParameter("i",100);  
      query.executeUpdate();  
      tx.commit();
	   }
	   public  void sqlupdate(Integer EmployeeID, String FirstName){
			 session = factory.openSession();
		      
		      try {
		         tx = session.beginTransaction();
		         Employee employee = (Employee)session.get(Employee.class, EmployeeID); 
		         employee.setFirstName( FirstName);
		                                session.update(employee); 
		         tx.commit();
		      } catch (HibernateException e) {
		         if (tx!=null) tx.rollback();
		         e.printStackTrace(); 
		      } finally {
		         session.close(); 
		      }
		   }

	 
	 
	 
	 
	 
	 public  void Natadd()
	 {
		 session = factory.openSession();
		
		 Session sess = null;
		  try{
		  sess = HibernateUtil.currentSession();
		  Transaction tx = sess.beginTransaction();
		  Employee emp = new Employee();
		  emp.setFirstName(("gfhd"));
		  emp.setLastName("dhdh");
		  emp.setId(202);
		  sess.save(emp);
		  System.out.println("Successfully data insert in database");
		  tx.commit();
		  }
		  catch(Exception e){
		  System.out.println(e.getMessage());
		  }
		  finally{
		  sess.close();
		  }
		  }
	 
	 
	 
	 public  void listEmployeesCri( ) {
	     
		 session = factory.openSession();
	      try {
	    	  
	         tx = session.beginTransaction();
	         Criteria cr = session.createCriteria(Employee.class);
	         // Add restriction.
	         cr.add(Restrictions.gt("id", 99));
	         List employees = cr.list();

	         for (Iterator iterator = employees.iterator(); iterator.hasNext();){
	            Employee employee = (Employee) iterator.next(); 
	            System.out.print("First Name: " + employee.getFirstName()); 
	            System.out.print("  Last Name: " + employee.getLastName()); 
	            System.out.println(" Id "+employee.getId());
	         }
	         tx.commit();
	      } catch (HibernateException e) {
	         if (tx!=null) tx.rollback();
	         e.printStackTrace(); 
	      } finally {
	         session.close(); 
	      }
	   }
	   

	
	

}   
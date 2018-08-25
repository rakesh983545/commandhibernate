package com.persistentclass.employee;



import java.util.List; 
import java.util.Date;
import java.util.Iterator; 
 










import org.hibernate.HibernateException; 
import org.hibernate.Query;
import org.hibernate.SQLQuery;
import org.hibernate.Session; 
import org.hibernate.Transaction;
import org.hibernate.SessionFactory;
import org.hibernate.Criteria;
import org.hibernate.criterion.Restrictions;
import org.hibernate.criterion.Projections;
import org.hibernate.cfg.Configuration;
import org.hibernate.mapping.Map;




public class StoreData {
	private static SessionFactory factory; 

	 public static void  main( String[] args )  
	    { 
		 StoreData sc=new StoreData();
		 
	        /* StandardServiceRegistry ssr = new StandardServiceRegistryBuilder().configure("hibernate.cfg.xml").build();  
	            Metadata meta = new MetadataSources(ssr).getMetadataBuilder().build();  
	          
	        SessionFactory factory = meta.getSessionFactoryBuilder().build();  
	        Session session = factory.openSession();  
	        Transaction t = session.beginTransaction();  
	          
	         Employee e1=new Employee();    
	            e1.setId(1);    
	            e1.setFirstName("Gaurav");    
	            e1.setLastName("Chawla");    */
	         
	            
	            /*e1.setId(2);    
	            e1.setFirstName("prajwal");    
	            e1.setLastName("prabhu");  
	       session.save(e1);  
	       t.commit();  
	       System.out.println("successfully saved");    
	        factory.close();  
	        session.close(); */  
	        
	       try {
	            factory = new Configuration().configure().buildSessionFactory();
	         } catch (Throwable ex) { 
	            System.err.println("Failed to create sessionFactory object." + ex);
	            throw new ExceptionInInitializerError(ex); 
	         }
	       
	        //sc.listEmployeesScalar();
	       //sc.deleteEmployee(101);
	     //  sc.sqlupdate(1,"pragnya");
	       sc.criDel();
	    }

		      /*Add few employee records in database */
		    
	 
	      /* public Integer addEmployee(int id,String firstName,String lastName){
	    	      Session session = factory.openSession();
	    	      Transaction tx = null;
	    	      Integer employeeID = null;
	    	      
	    	      try {
	    	         tx = session.beginTransaction();
	    	         Employee employee = new Employee(id, firstName, lastName);
	    	         employeeID = (Integer) session.save(employee); 
	    	         tx.commit();
	    	      } catch (HibernateException e) {
	    	         if (tx!=null) tx.rollback();
	    	         e.printStackTrace(); 
	    	      } finally {
	    	         session.close(); 
	    	      }
	    	      return employeeID;
	    	   }
}
	    
	
	/*public static void listEmployees( ){
	    Session session = factory.openSession();
	      Transaction tx = null;
	      
	        try {
	         tx = session.beginTransaction();
	         java.util.List employees = session.createQuery("FROM Employee").list(); 
	         for (Iterator iterator = employees.iterator(); iterator.hasNext();){
	            Employee employee = (Employee) iterator.next();
	            System.out.print("ID: "+employee.getId());
	            System.out.print("  First Name: " + employee.getFirstName()); 
	            System.out.println("  Last Name: " + employee.getLastName()); 
	            
	         }
	         tx.commit();
	      } catch (HibernateException e) {
	         if (tx!=null) tx.rollback();
	         e.printStackTrace(); 
	      } finally {
	         session.close(); 
	      }
	   }*/
	      
	      /*try {
	    	  tx = session.beginTransaction();
	          @SuppressWarnings("deprecation")
			Criteria cr = session.createCriteria(Employee.class);
	          // Add restriction.
	          cr.add(Restrictions.gt("id", 1));
	          List employees = (List) cr.list();
		         for (Iterator iterator = ((java.util.List) employees).iterator(); iterator.hasNext();){
		            Employee employee = (Employee) iterator.next();
		            System.out.print("ID: "+employee.getId());
		            System.out.print("  First Name: " + employee.getFirstName()); 
		            System.out.println("  Last Name: " + employee.getLastName()); 
		            
		         }
		         tx.commit();
		      } catch (HibernateException e) {
		         if (tx!=null) tx.rollback();
		         e.printStackTrace(); 
		      } finally {
		         session.close(); 
		      }
		   }*/
	      /* public void listEmployeesScalar()
	       {
	    	      Session session = factory.openSession();
	    	      Transaction tx = null;
	      try {
	          tx = session.beginTransaction();
	          String sql ="select * from emp1000";
	          SQLQuery query = session.createSQLQuery(sql);
	          query.addEntity(Employee.class);
	          List employees = query.list();

	          for (Iterator iterator = employees.iterator(); iterator.hasNext();){
	             Employee employee = (Employee) iterator.next(); 
	             System.out.print("ID: "+employee.getId());
	             System.out.print("First Name: " + employee.getFirstName()); 
	             System.out.print("  Last Name: " + employee.getLastName());  
	          }
	          tx.commit();
	       } catch (HibernateException e) {
	          if (tx!=null) tx.rollback();
	          e.printStackTrace(); 
	       } finally {
	          session.close(); 
	       }
	    }
	    }*/
	 
	    /* public static void deleteEmployee(Integer EmployeeID){
	          Session session = factory.openSession();
	          Transaction tx = null;
	          
	          try {
	             tx = session.beginTransaction();
	             Employee employee = (Employee)session.get(Employee.class,EmployeeID); 
	             session.delete(employee); 
	             tx.commit();
	          } catch (HibernateException e) {
	             if (tx!=null) tx.rollback();
	             e.printStackTrace(); 
	          } finally {
	             session.close(); 
	          }
	     }*/

	   /*@SuppressWarnings("deprecation")
	public static void hqlupdate(){
		   Session session = factory.openSession();
		      Transaction t = null;
		      try{
	   t = session.beginTransaction(); 
     Query query=session.createQuery("update Employee set firstName=:n where id=:i");  
    query.setParameter("n","pragnya");  
    query.setParameter("i",3);  
    query.executeUpdate();  
    t.commit();
	   }
		      catch (HibernateException e) {
			         if (t!=null) t.rollback();
			         e.printStackTrace(); 
			      } finally {
			         session.close(); 
	   }*/
	   /*public static void sqlupdate(Integer id, String firstName){
		      Session session = factory.openSession();
		      Transaction t = null;
		      
		      try {
		         t = session.beginTransaction();
		         Employee employee = (Employee)session.get(Employee.class, id); 
		         employee.setFirstName( firstName);
		                                session.update(employee); 
		         t.commit();
		      } catch (HibernateException e) {
		         if (t!=null) t.rollback();
		         e.printStackTrace(); 
		      } finally {
		         session.close(); 
		      }
		   }*/
	 
		
	 public void criDel()
	 { Session session = factory.openSession();
     Transaction t = null;
	 	Employee emp = (Employee ) session.createCriteria(Employee.class)
	             .add(Restrictions.eq("id", 2)).uniqueResult();
	 session.delete(emp);
	 t.commit();
	 }
	   }
    
	    






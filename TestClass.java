package com.capgemini.spring;

import org.hibernate.cfg.Configuration;

public class TestClass {
	
	
	public static void main(String[] args) {    
        
	    //Create typesafe ServiceRegistry object    
	    //StandardServiceRegistry ssr = new StandardServiceRegistryBuilder().configure("hibernate.cfg.xml").build();  
	          
	   //Metadata meta = new MetadataSources(ssr).getMetadataBuilder().build();  
	  
	//SessionFactory factory = meta.getSessionFactoryBuilder().build();  
	//Session session = factory.openSession();  
	//Transaction t = session.beginTransaction();   
	            
	    //Employee e1=new Employee();    
	    /*e1.setId(101);    
	    e1.setFirstName("Gaurav");    
	    e1.setLastName("Chawla");    
	      */
	    /*e1.setId(100);
	    e1.setFirstName("Sanu");    
	    e1.setLastName("Bhattachary");
	    */
	   /* 
		try {
	        factory = new Configuration().configure().buildSessionFactory();
	     } catch (Throwable ex) { 
	        System.err.println("Failed to create sessionFactory object." + ex);
	        throw new ExceptionInInitializerError(ex); 
	     }*/
	     StoreData ob=new StoreData();
	     
	     //ob.Natadd();
	     ob.criDel();
	   //ob.hqldelete(100);
		//ob.criadd("loki","odinson",102);
	    //ob.hqlupdate();
	    //session.save(e1);  
	    //t.commit();  
	    //System.out.println("successfully saved");    
	    //factory.close();  
	    //session.close();    
	        
	}    

}

package employeeDAO;

import java.sql.Connection;
import java.sql.ResultSet;
import java.util.ArrayList;

import org.springframework.jdbc.core.JdbcTemplate;  

import com.employee.AdressDetails;
import com.employee.EmployeeDetails;
import com.mysql.jdbc.Statement;

  
public class empDAO {
	ArrayList<EmployeeDetails> n;
	private JdbcTemplate jdbcTemplate;
	public java.sql.Connection con;  
	  
	public void setJdbcTemplate(JdbcTemplate jdbcTemplate) {  
	        this.jdbcTemplate = jdbcTemplate;  
	}  
	
	public int saveEmployeeDetails(EmployeeDetails e,AdressDetails a){
		String query1="INSERT INTO adresstable (empid,pincode, state, city )"
				+" VALUES ('"+e.getEmpid()+"','"+a.getPincode()+"','"+a.getState()+"','"+a.getCity()+"')";
		jdbcTemplate.update(query1);
		
		String query="INSERT INTO employee (empid, empName, empdept, empSalary, empcommission)"
	+" VALUES ('"+e.getEmpid()+"','"+e.getEmpname()+"','"+e.getEmpdept()+"','"+e.getEmpsalary()+"','"+e.getEmpcommission()+"')";
		return jdbcTemplate.update(query);
	}
	
	public int deleteEmployeeDetails(int id){
		String sql="delete from employee where empid="+id+"";  
	    return jdbcTemplate.update(sql);
	}
	public int updateEmployee(EmployeeDetails e){  
	    String query="update employee set empName='"+e.getEmpname()+"',empcommission='"+e.getEmpcommission()+"' where empid='"+e.getEmpid()+"' ";  
	    return jdbcTemplate.update(query);  
	}  
	
	
  
	public int saveAdressDetails(AdressDetails e){
		String query="INSERT INTO adresstable (pincode, state, city)"
	+" VALUES ('"+e.getPincode()+"','"+e.getState()+"','"+e.getCity()+"')";
		return jdbcTemplate.update(query);
	}
	
	public int updateAdressDetails(AdressDetails e){  
	    String query="update adresstable set state='"+e.getState()+"',city='"+e.getCity()+"' where pincode='"+e.getPincode()+"' ";  
	    return jdbcTemplate.update(query);  
	}
	public ArrayList<EmployeeDetails> getEmployeeDetails(){
		String query1="select * from employee";
		String query2="select * from pragnya.adresstable";
		try{
			
		con=jdbcTemplate.getDataSource().getConnection();
		
		java.sql.Statement st=con.createStatement();
		java.sql.Statement st1=con.createStatement();
		
		ResultSet rs=st.executeQuery(query1);
		//ResultSet rs1=st1.executeQuery(query2);
		
		while(rs.next()){
			
			//n.add(new EmployeeDetails(rs.getInt("empid"),rs.getString("empname"),rs.getString("empdept"),rs.getDouble("empSalary"),rs.getDouble("empcommission")));
			System.out.println(rs.getInt("empid")+" "+rs.getString("empname")+" "+rs.getString("empdept")+" "+rs.getDouble("empSalary"));
		}
		}
		catch(Exception m){
			System.out.println("sqlExceptionThrown");
			m.printStackTrace();
		}
		return n;
	}
	
	public ArrayList<EmployeeDetails> getEmployeeDetailsbyID(int id){
		String query1="select * from employee where empid='"+id+"'";
		
		try{
			
		con=jdbcTemplate.getDataSource().getConnection();
		
		java.sql.Statement st=con.createStatement();
		
		ResultSet rs1=st.executeQuery(query1);
		
		
		while(rs1.next()){
			
			System.out.println(rs1.getInt("empid")+" "+rs1.getString("empname")+" "+rs1.getString("empdept")+" "+rs1.getDouble("empSalary"));
		}
		}
		catch(Exception m){
			System.out.println("sqlExceptionThrown");
			m.printStackTrace();
		}
		return n;
	}
	
	
	public ArrayList<EmployeeDetails> getEmployeeDetailsbysalary(){
		String query1="select empdept, MAX(empSalary) from employee group by empdept" ;
		
		try{
			
		con=jdbcTemplate.getDataSource().getConnection();
		
		java.sql.Statement st=con.createStatement();
		
		ResultSet rs2=st.executeQuery(query1);
		
	
		while(rs2.next()){
			
			System.out.println(rs2.getString(1)+" "+rs2.getDouble(2));
		}
		}
		catch(Exception m){
			System.out.println("sqlExceptionThrown");
			m.printStackTrace();
		}
		return n;
	}
}

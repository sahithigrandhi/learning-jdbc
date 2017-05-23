package learningJdbc;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;

public class Employee_Crud_Sample extends Jdbc_utility{
	public void retrive_employee() throws Exception {
		
		Connection con = getConnection();
		Statement stmt= con.createStatement();
		String sql="Select emp_id, emp_name,salary from Employee";
		ResultSet rs=stmt.executeQuery(sql);
		System.out.println(rs);
		
		while(rs.next()){
			int id_emp=rs.getInt("emp_id");
			String name_emp=rs.getString("emp_name");
			long salary=rs.getInt("salary");
			System.out.println("employee id:"+id_emp+" employee name:"+name_emp+" salary:"+salary);
		}
	}
	
	public void update_employee() throws Exception{
		Connection con = getConnection();
		Statement stmt= con.createStatement();
		String sql="update Employee set emp_name = ? where emp_id = 1";
		PreparedStatement statement = con.prepareStatement(sql);
		
	     statement.setString(1, "Bharathi");

		int rowsInserted = statement.executeUpdate();
		if (rowsInserted > 0) {
	      	System.out.println("A user was updated successfully!");
			}
			con.close();
	}
	public void Create_employee() throws Exception{
		Connection con = getConnection();
		Statement stmt= con.createStatement();
		String sql="insert into Employee (emp_id, emp_name,salary)values(?,?,?)";
		PreparedStatement statement = con.prepareStatement(sql);
		
	     statement.setInt(1,5);
	     statement.setString(2, "Aryan");
	     statement.setLong(3,6000);

		int rowsInserted = statement.executeUpdate();
		if (rowsInserted > 0) {
	      	System.out.println("A user was inserted successfully!");
			}
			con.close();
	}
	public void Delete_employee() throws Exception{
		Connection con = getConnection();
		Statement stmt= con.createStatement();
		String sql="delete from Employee where emp_id = 1";
		PreparedStatement statement = con.prepareStatement(sql);
			int result = statement.executeUpdate();
			if (result > 0) {
		    System.out.println("Record deleted successfully!");
		}
			con.close();	
	}
	
	public static void main(String[] args) throws Exception {
		//Employee_Crud_sample  s = new Employee_Crud_sample();
		//s.update_employee();
		Employee_Crud_Sample s=new Employee_Crud_Sample();
		//s.update_employee();
		//s.Delete_employee();
		s.Create_employee();
	}	
		
	
}

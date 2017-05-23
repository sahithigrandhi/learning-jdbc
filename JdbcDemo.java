package learningJdbc;
import java.sql.*;
public class JdbcDemo {
	public static void main(String[] args) throws Exception {
		Connection myConn=DriverManager.getConnection("jdbc:mysql://localhost:3306/sys", "root", "rules");
	Statement stmt=myConn.createStatement();
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
}

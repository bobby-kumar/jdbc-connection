package jdbcConnectionDemo;

import java.io.IOException;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

import com.jdbcConnectionAll.DbConnection;

public class APP {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int ch;
		String user = "root";
		String password = " ";
		boolean flag = false;
		try(Connection c = DbConnection.getConn())
		{
			Statement stmt = c.createStatement();
			ResultSet rs = stmt.executeQuery("select * from acc");
			while(rs.next())
			{
				if((rs.getString("username").equals(user)) && (rs.getString("password").equals(password)))
				{flag = true;}
				
			}
			
		if(flag) {		
		do {
			System.out.print("\n1.Adding new Record\n2.Deleting an record\n3.Updating a Record\n4.Search Record\n5.Print all Record\n9.for exit\nEnter Your Choice : ");
			ch = sc.nextInt();
			switch(ch)
			{
			case 1: 
				int uid;
				String uname,uemail,umobile;
				System.out.print("Enter user id :");
				uid=sc.nextInt();
				sc.nextLine();
				System.out.print("Enter Username :");
				uname =sc.nextLine();
				System.out.print("Enter Email :");
				uemail=sc.nextLine();
				System.out.print("Enter Mobile :");
				umobile=sc.nextLine();
				
				Service.addNewUser(uid, uname, uemail, umobile);
				
				System.out.println("press any key too continue :");
				try {System.in.read();}
				catch (IOException e) {e.printStackTrace();}
				
				break;
				
			case 2:
				System.out.print("Enter UserId : ");
				uid = sc.nextInt();
				Service.deleteUser(uid);
				break;
			case 3:
				System.out.print("Enter user id :");
				uid=sc.nextInt();
				sc.nextLine();
				System.out.print("Enter Username :");
				uname =sc.nextLine();
				System.out.print("Enter Email :");
				uemail=sc.nextLine();
				System.out.print("Enter Mobile :");
				umobile=sc.nextLine();
				
				Service.updateRecord(uid, uname, uemail, umobile);
				break;
			case 4:
				System.out.print("Enter UserId : ");
				uid = sc.nextInt();
				Service.searchRecord(uid);
				break;
			case 5:
				Service.showAllRecord();
				break;
			case 9: 
				System.exit(0);
				break;
			default : System.out.println("invalid Choice \n Enter again : ");
			ch = sc.nextInt();
			}
		} while (ch!=9);
		}else
		{
			System.out.println("username and password not found");
		}
		} catch (SQLException e1) {
			e1.printStackTrace();
		} catch (ClassNotFoundException e) {
			throw new RuntimeException(e);
		}

	}
	      
}



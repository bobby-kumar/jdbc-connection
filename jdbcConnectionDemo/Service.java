package jdbcConnectionDemo;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import com.jdbcConnectionAll.DbConnection;


public class Service {
    //method for creating table.


    static public void createTable() {
        final String createTableQuery = "CREATE TABLE if not exists U_Info"
                + "(userid int primary key auto_increment,username varchar(20) not null, emails varchar(40),moblile_Numbers varchar(10) not null)";
        Statement stm = null;
        try (Connection c = DbConnection.getConn()) {
            stm = c.createStatement();
            boolean _statusOfTableCreation = stm.execute(createTableQuery);

            if (!_statusOfTableCreation)
                System.out.println("Hurray! \nTable Created successfully");
            else
                System.out.println("Damm! \nTable Not Created");

        } catch (SQLException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        } finally {
            if (stm != null) {
                try {
                    stm.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    //		method for adding new Record in Users_data
    static public void addNewUser(int uid, String uname, String uemail, String umoblienumber)
    {
        final String addNewUserQuery = "INSERT INTO U_Info () values "
                + "(?,?,?,?)";
        PreparedStatement prepstmt = null;
        try(Connection c = DbConnection.getConn();)
        {
            prepstmt = c.prepareStatement(addNewUserQuery);

            prepstmt.setInt(1, uid);
            prepstmt.setString(2, uname);
            prepstmt.setString(3, uemail);
            prepstmt.setString(4, umoblienumber);

            int _result = prepstmt.executeUpdate();

            if(_result>=1)
                System.out.println(_result+" records added succussfully");
            else
                System.out.println("Something went wrong");
        }catch (Exception e) {
            if(prepstmt!=null)
                try {
                    prepstmt.close();
                } catch (SQLException e1) {
                    e1.printStackTrace();
                }
            e.printStackTrace();
        }
    }

    //		method for deleting a perticular row
    static public void deleteUser(int uid)
    {
        final String deleteQuery = "DELETE FROM U_Info where userid = ?";
        PreparedStatement psmt = null;
        try(Connection c = DbConnection.getConn();)
        {
            psmt = c.prepareStatement(deleteQuery);
            psmt.setInt(1, uid);
            int _result = psmt.executeUpdate();

            if(_result>=1)
                System.out.println("user with "+uid +" id is deleted");
            else
                System.out.println(uid+" not found in database");
        } catch (SQLException e) {
            if(psmt!=null)
                try {
                    psmt.close();
                } catch (SQLException e1) {
                    e1.printStackTrace();
                }
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
    }

    //		method for update user record
    static public void updateRecord(int uid, String uname, String uemail, String umobile)
    {
        final String updateQuery = "UPDATE U_Info SET username = ?, emails=?,  moblile_Numbers = ? "
                + "where userid =? ";
        try(Connection c = DbConnection.getConn();PreparedStatement psmt = c.prepareStatement(updateQuery))
        {
            psmt.setString(1, uname);
            psmt.setString(2, uemail);
            psmt.setString(3, umobile);

            psmt.setInt(4, uid);

            int _result = psmt.executeUpdate();

            if(_result>=1)
                System.out.println("record Updated");
            else
                System.out.println("record not found");
        } catch (SQLException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
    }

    //		method for searching record in Database
    static public void searchRecord(int uid)
    {
        final String searchQuery = "select * from U_Info "
                + "where userid = ?";
        try(Connection c = DbConnection.getConn();
            PreparedStatement psmt = c.prepareStatement(searchQuery);
        )
        {
            psmt.setInt(1, uid);

            ResultSet rs =  psmt.executeQuery();

            int i=0;
            while(rs.next())
            {
                if(i==0)
                    System.out.println("User Id"+"\t\t"+"User Name\t"+"User Email\t\t\t\t"+"User Mobile");
                System.out.println(rs.getInt(1)+"\t\t"+rs.getString(2)+"\t\t"+rs.getString(3)+"\t\t"+rs.getString(4));
                i++;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }

    }

    //		method for Retrieve all Records from Database
    static public void showAllRecord()
    {
        final String showAllRecordQuery = "select * from U_Info;";
        try(Connection c = DbConnection.getConn();
            Statement stmt = c.createStatement();
        )
        {

            ResultSet rs =  stmt.executeQuery(showAllRecordQuery);

            System.out.println("User Id"+"\t\t"+"User Name\t"+"User Email\t\t\t\t"+"User Mobile");
            while(rs.next())
            {
                System.out.println(rs.getInt(1)+"\t\t"+rs.getString(2)+"\t\t"+rs.getString(3)+"\t\t"+rs.getString(4));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }

    }



}



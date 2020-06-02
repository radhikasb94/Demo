package main.com.bayer.frontend.selenium.utils.handlers;

import java.sql.*;
import java.util.HashMap;
import java.util.Map;

public class DataBaseHandler {
    public static  Map<String, String> getOneRow(String query) {
        //----DB2 DataBase Connection
        /*String jdbcClassName="com.ibm.db2.jcc.DB2Driver";
        String URL="jdbc:db2://170.74.252.153:1308/DB2";
        String UserName="";
        String Password="";*/
        ResultSet rst = null;
        Connection connection = null;
        Map<String, String> mapval = null;
       // System.out.println(PropertiesRepository.getString("global.browser.access.mdb.file"));
      try {
            //----DB2 DataBase Connection
            /* Class.forName(jdbcClassName);
            connection=DriverManager.getConnection(URL,UserName,Password);
            */
            //----MS Access DataBase Connection
            connection = DriverManager
                    .getConnection("jdbc:ucanaccess://G:\\ITPA\\SeleniumFW_SVN\\GitRepository\\databesefile\\Bayertestdata.mdb");
            Statement statement = connection.createStatement();
            rst = statement.executeQuery(query);
            ResultSetMetaData rsmd = rst.getMetaData();
            int colcount = rsmd.getColumnCount();
            mapval = new HashMap<String, String>();
            while (rst.next()) {
				for (int i = 1; i <= colcount; i++) {
                    mapval.put(rsmd.getColumnName(i), rst.getString(rsmd.getColumnName(i)).trim());
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if (connection != null) {
                System.out.println("DB Connection is Successful");
                try {
                    rst.close();
                    connection.close();

                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
        }
        return mapval;
    }

    public static Map<Integer, Map<String, String>> getAllRow(String query) {
        //----DB2 DataBase Connection
        /*String jdbcClassName="com.ibm.db2.jcc.DB2Driver";
        String URL="jdbc:db2://170.74.252.153:1308/DB2";
        String UserName="";
        String Password="";*/

        ResultSet rst = null;
        Connection connection = null;
        Map<Integer, Map<String, String>> mapval = null;
        try {
            //----DB2 DataBase Connection
            /* Class.forName(jdbcClassName);
            connection=DriverManager.getConnection(URL,UserName,Password);
            */
            //----MS Access DataBase Connection
            connection = DriverManager
                    .getConnection("jdbc:ucanaccess://G:\\ITPA\\SeleniumFW_SVN\\GitRepository\\databesefile\\Bayertestdata.mdb");
            Statement statement = connection.createStatement();
            rst = statement.executeQuery(query);
            ResultSetMetaData rsmd = rst.getMetaData();
            int colcount = rsmd.getColumnCount();
            int rowcount=0;
            Map <String, String>tempmap=null;
            mapval = new HashMap<Integer, Map<String, String>>();
            while (rst.next()) {
                tempmap=new HashMap<String,String>();
                for (int i = 1; i <= colcount; i++) {
                    tempmap.put(rsmd.getColumnName(i), rst.getString(rsmd.getColumnName(i)).trim());
                    mapval.put(rowcount,tempmap);
                }
                rowcount++;
            }

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if (connection != null) {
                System.out.println("DB Connection is Successful");

                try {
                    rst.close();
                    connection.close();

                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
        }
        return mapval;
    }

}

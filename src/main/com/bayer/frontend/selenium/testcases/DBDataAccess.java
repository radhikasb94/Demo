package main.com.bayer.frontend.selenium.testcases;

import main.com.bayer.frontend.selenium.utils.handlers.DataBaseHandler;
import org.testng.annotations.Test;

import java.util.Iterator;
import java.util.Map;

public class DBDataAccess {

    @Test(description="Test Data Base Connection one row")
    public void testDBconnectionOneRow(){
        Map<String, String> hm= DataBaseHandler.getOneRow("Select * from login");
        System.out.println(hm);

        Iterator<String> it = hm.keySet().iterator();       //keyset is a method
        String key=it.next();
        System.out.println(hm.get("UserName"));
        System.out.println(hm.get("Pwd"));
        System.out.println(hm.get("Sal"));
        System.out.println(hm.get("Addres"));
        System.out.println("Roll no.: "+key+"= "+hm.get(key));
    }
    @Test(description="Test Data Base Connection all Record")
    public void testDBconnectionAllRow() {
        Map<Integer, Map<String, String>> hm = DataBaseHandler.getAllRow("Select * from login");
        for (Map.Entry<Integer, Map<String, String>> entry : hm.entrySet()) {
            Map<String, String> childMap = entry.getValue();
            int rowcount = entry.getKey();
            for (Map.Entry<String, String> entry2 : childMap.entrySet()) {
                String childKey = entry2.getKey();
                String childValue = entry2.getValue();
                // System.out.println(childKey+"="+childValue);
                if (rowcount == 1 && childKey.equalsIgnoreCase("UserName")) {
                    System.out.println(childValue);
                    break;
                }
            }
        }
    }
}

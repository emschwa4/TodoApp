
import java.sql.*;

public class App {
    public static void main(String[] args) throws Exception {
        ResultSet rs = null;
		PreparedStatement stmt = null;
		Connection conn = null;


        try{
        while(true){
        boolean exit = false;
            int option = 0;
            while (!exit) {
                String main = "\n" + "Menu\n" + "1.Insert\n" + "2.Filter\n" + "3.Update\n" + "4.Delete\n" + "0.Exit\n" +
                        "Enter one of the options above please\n";

                String in = Menu.parseInput(main);
                try {
                    option = Integer.parseInt(in);
                } catch (Exception e) {
                    System.out.println("Enter a valid option");
                }
                switch (option) {
                    case 0:
                        exit = true;
                        break;
                    case 1:
                        Menu.InsertMenu();
                        break;
                    // case 2:
                    //     Menu.FilterMenu();
                    //     break;
                    // case 3:
                    //     Menu.UpdateMenu();
                    //     break;
                    // case 4:
                    //     Menu.DeleteMenu();
                    //     break;
                    default:
                        System.out.println("Entered option is not an option");
                }

            }

    }
}catch(Exception exc)
{
    exc.printStackTrace();
}
finally {  // ALWAYS clean up your DB resources
    try {
        if (rs != null)
            rs.close();
        if (stmt != null)
            stmt.close();
    } catch (Throwable t1) {
        System.out.println("A problem closing db resources!");
    }
    try {
        if (conn != null)
            conn.close();
    }
    catch (Throwable t2) {
        System.out.println("Oh-oh! Connection leaked!");
    }
}
}
}

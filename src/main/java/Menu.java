import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;


public class Menu{

  public static String parseInput(String message) {
        String tmp = null;
        System.out.print(message);
        try {
            BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
            tmp = reader.readLine();

        } catch (IOException e) {
            e.printStackTrace();
        }

        return tmp;
    }
public static void addUser(){
    String username,firstname,middlename,lastname,email,hash;
    String[] query;

// did not prompt user for hash informatiom, team needs to generate how it will be generated into db
    String submenu ="\n" + "Menu\n" + "Enter record information you want to enter\n" +
    "Please enter in the following format\n"+ "<username>,<firstname>,<middlename>,<lastname>,<hash method>,<email>\n";
    String input = parseInput(submenu);
    query = input.split(",");
    if (query.length == 6){
        username= query[0];
        firstname= query[1];
        middlename= query[2];
        lastname=query[3];
        hash=query[4];
        email=query[5];
    }else{
        System.err.println("You did not follow the format:\n"+"<username>,<firstname>,<middlename>,<lastname>,<email>\n");
    }


}
public static void addTodo(){

    String description,status,title,due_date,id;
    String[] query;

// did not prompt user for sectionId, team decision needed
    String submenu ="\n" + "Menu\n" + "Enter record information you want to enter\n" +
    "Please enter in the following format\n"+ "<description>,<status>,<title>,<due date>,<section id>\n";
    String input = parseInput(submenu);
    query = input.split(",");
    if (query.length == 5){
        description= query[0];
        status= query[1];
        title= query[2];
        due_date=query[3];
        id= query[4];
    }else{
        System.err.println("You did not follow the format:\n"+"<username>,<firstname>,<middlename>,<lastname>,<email>\n");
    }



}
public static void addDashboard(){
    String name,id;
    String[] query;
    String submenu ="\n" + "Menu\n" + "Enter record information you want to enter\n" +
    "Please enter in the following format\n"+ "<name>,<userid>\n";
    String input = parseInput(submenu);
    query = input.split(",");
    if (query.length == 2){
        name= query[0];
        id= query[1];
    }else{
        System.err.println("You did not follow the format:\n"+"<username>,<firstname>,<middlename>,<lastname>,<email>\n");
    }




}
public static void addSection(){

    String section,id;
    String[] query;
    String submenu ="\n" + "Menu\n" + "Enter record information you want to enter\n" +
    "Please enter in the following format\n"+ "<name>,<dashboard id>\n";
    String input = parseInput(submenu);
    query = input.split(",");
    if (query.length == 2){
        section= query[0];
        id =query[1];
    }else{
        System.err.println("You did not follow the format:\n"+"<username>,<firstname>,<middlename>,<lastname>,<email>\n");
    }



}
    public static void InsertMenu() {
        boolean exit = false;
        int choice = 0;
        while (!exit) {
            String menu = "\n" + "Menu\n" + 
                 "Enter the following options\n" + "1.To Add to User Table\n"+ "2.Add a todo task\n"+"2.Add a dashboard\n"+"2.Add a section\n"+
                 "0.exit\n" +
                    "Enter one of the options above please\n";
            String input = parseInput(menu);
            try {
                choice = Integer.valueOf(input);
            } catch (NumberFormatException nfe) {
                System.out.println("You selected an option not listed");
            }
            switch (choice) {
                case 1:
                    addUser();
                    break;
                case 2:
                    addTodo();
                    break;
                case 3:
                    addDashboard();
                    break;
                case 4:
                    addSection();
                    break;       
                case 0:
                    exit = true;
                    break;
                default:
                    System.out.println("Entered option is not an option");

            }
        }
    }

/**
 * 
 * 
 * 
 */

public static void deleteUser(String table){

    String section,id;
    String[] query;
    String submenu ="\n" + "Menu\n" + "Enter record information you want to delete\n" +
    "Please enter in the following format\n"+ "<>\n";
    String input = parseInput(submenu);
    query = input.split(",");
    if (query.length == 2){
        section= query[0];
        id =query[1];
    }else{
        System.err.println("You did not follow the format:\n"+"<username>,<firstname>,<middlename>,<lastname>,<email>\n");
    }



}
public static void DeleteMenu() {
    boolean exit = false;
    int choice = 0;
    while (!exit) {
        String menu = "\n" + "Menu\n" + 
             "Choose one of the following tables to delete from\n" + "1.User\n"+ "2.Dashboard\n"+"2.Section\n"+"2.Todo\n"+
             "0.exit\n" +
                "Enter one of the options above please\n";
        String input = parseInput(menu);
        try {
            choice = Integer.valueOf(input);
        } catch (NumberFormatException nfe) {
            System.out.println("You selected an option not listed");
        }
        switch (choice) {
            case 1:
                String user ="User";
                deleteUser(user);
                break;
            case 2:
                deleteDashboard();
                break;
            case 3:
                deleteSection();
                break;
            case 4:
                deleteTodo();
                break;       
            case 0:
                exit = true;
                break;
            default:
                System.out.println("Entered option is not an option");

        }
    }
}

}
package TUI_Layer;

import modellayer.*;
import java.util.*;

public class LoginUI 
{
    private MainMenu mainMenu;
    private Employee loggedIn;
   
    Scanner sc;
    public LoginUI()
    {
      sc =new Scanner(System.in);
      loginEmployee();
      
    }   
    
    public void loginEmployee() 
    {
        
        EmployeeContainer eCon = EmployeeContainer.getInstance();
        System.out.println("Type username");
        String username = sc.nextLine();
        System.out.println("Type password");
        String password = sc.nextLine();
        loggedIn = eCon.loginEmployee(username,password);
      
        if(loggedIn != null)
        {
            mainMenu = new MainMenu(loggedIn);
        }
        else
        {
            System.out.println("Username or password is incorrect");
            loginEmployee();
        }  
        
    }
    
    public Employee getEmployee() 
    {
        return loggedIn;
    }
}

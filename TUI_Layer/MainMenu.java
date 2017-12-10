package TUI_Layer;


/**
 * Write a description of class MainMenu here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
import modellayer.*;

public class MainMenu extends Menu
{
    
    private EmployeeMenu employeeMenu;
    private ActionMenu actionMenu;
    private Employee currentlyLoggedIn;
    private LoginUI loginUI;
    public MainMenu(Employee employee)
    {
        
        super("Main Menu",null);
        currentlyLoggedIn = employee;
        printMenu();
        chooseTask();
    }
    public void printMenu() /** This method prints */
    {
       // System.out.println("\f");
        printMenuDescription();
        System.out.println("\n");
        System.out.println("Press 1 for EmployeeMenu");
        System.out.println("Press 2 for ActionMenu");
        System.out.println("Press 3 for ComingMenu");
        System.out.println("Press 4 to logout ");
        System.out.println("Press 5 to exit program");
        
    }
   
    public void chooseTask()
    { 
       int menuNumber = sc.nextInt();
       String whichMenu;
       
       switch(menuNumber)
       {    
           case 1: 
           { 
                if(employeeMenu == null )
                {
                System.out.println("You have created new employeeMenu object");
                employeeMenu = new EmployeeMenu(this);
                employeeMenu.chooseTask();
                break;  
                }
                else
               {
                employeeMenu.printMenu();
                employeeMenu.chooseTask();
                break;  
               }    
               
           }
           case 2: 
           { 
                if(actionMenu == null )
                {
                System.out.println("You have created new actionMenu object");
                actionMenu = new ActionMenu(this);
                actionMenu.chooseTask();
                break;  
                }
                else
               {
                actionMenu.printMenu();
                actionMenu.chooseTask();
                break;  
               }    
               
           }
           case 4 : 
           loginUI = new LoginUI();
           
           
           
            default: System.out.println("\f" +"\n" + "wrong number please try again");
            printMenu();
            this.chooseTask();      
       }
    }
}

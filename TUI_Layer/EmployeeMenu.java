package TUI_Layer;


import cntrllayer.*;

public class EmployeeMenu extends Menu
{
    private EmployeeController employeeController;
    
    
    public EmployeeMenu(Menu parent)
    {
        super("Employee",parent);
        printMenu();
        
    }
    public void printMenu()
    {
        printMenuDescription();
        System.out.println("\n");
        System.out.println("Press 1 for Employee task one");
        System.out.println("Press 2 for Employee task two");
        System.out.println("Press 3 for Employee task three");
        System.out.println("Press 4 to go back" ) ;
        
        System.out.println("This is my parent name" + parent.name);
        
    }
   
    
    public void chooseTask()
    {
        
        
          int menuNumber = sc.nextInt();
        String whichMenu;
        switch(menuNumber)
        {
        case 1: System.out.println("Task one was yet not uploaded, try another one");
        chooseTask();
        break;
        
        case 2: System.out.println("Task two was yet not uploaded, try another one");
        chooseTask();
        break;
        
        case 3: System.out.println("Task three was yet not uploaded, try another one");
        chooseTask();
        break;
        
        case 4: 
        System.out.println("\f");
        goBackToPreviousMenu();
        break;
        
        default: whichMenu = "wrong number please try again";
        {
         System.out.println("Akos you are fucking whore, let`s play WoW today");
         System.out.println("\n" + whichMenu);
         printMenu();
        chooseTask();
        break;
        }
        
        }
        
    }
        
    
}

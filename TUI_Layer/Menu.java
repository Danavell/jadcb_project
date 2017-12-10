package TUI_Layer;
import java.util.*;
import modellayer.Employee;
/**
 * Write a description of class Menu here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public abstract class Menu
{
    private  Employee currentEmployee;
    public Menu parent;
    public String name;
    Scanner sc = new Scanner(System.in);
    
    
    public Menu(String name, Menu parent)
    {
        this.parent = parent;
        this.name = name;
        
    }
    public void printMenuDescription()
    {
        // System.out.println("\f");
        System.out.println("This is " + name +" Menu" ) ;
        System.out.println("Press number to select wanted action");
    }
    public abstract void printMenu();
    public abstract void chooseTask();
    
     public void goBackToPreviousMenu()
    {
        parent.printMenu();
        parent.chooseTask();
    }
    
    
    
    
    
}   

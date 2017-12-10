package TUI_Layer;
import cntrllayer.*;


public class ActionMenu extends Menu
{
    private SaleController s;
    private boolean isFirstSaleLine = true;
   
   
    
    
    public ActionMenu(Menu parent)
    {
        super("Action",parent);
        printMenu();
        s = new SaleController();
        
    }
    public void printMenu()
    {
        printMenuDescription();
        System.out.println("\n");
        System.out.println("1. Create Sale");
        System.out.println("Press 2 for Action two");
        System.out.println("Press 3 for Action three");
        System.out.println("Press 4 to go back" );
        System.out.println("This is my parent name" + parent.name);
        
    }
   
    public void chooseTask()
    {
    int  menuNumber = sc.nextInt();
        String whichMenu;
        switch(menuNumber)
        {
            case 1:
            
            handleSale();
            break;
            
            case 2:
                System.out.println("Action two was yet not uploaded, try another one");
                chooseTask();
                break;
            
            case 3: 
                System.out.println("Action three was yet not uploaded, try another one");
                chooseTask();
                break;
                
            case 4: 
                System.out.println("\f");
                goBackToPreviousMenu();
                break;
            
            default: 
            {
                whichMenu = "wrong number please try again";
                System.out.println("Akos you are fucking whore, let`s play WoW today");
                System.out.println("\n" + whichMenu);
                printMenu();
                chooseTask();
                break;
            }
            
        }
        
    }
  
    public void handleSale()
    {    
        System.out.println("Type product name");
        String productName = sc.next();
        System.out.println( s.showProductMatches(productName) );
        
        System.out.println("Type index of product");
        int index = sc.nextInt();
        int temp;
        System.out.println("Quantity: ") ;
        int amount = sc.nextInt();
        if(isFirstSaleLine == true)
        {
                temp = s.addAction(index,amount);
            }
            else 
            {
                temp = s.addAnotherLine(index,amount);
            }
                switch(temp)
                {
                    case 0:
                    {
                    isFirstSaleLine = false;    
                    System.out.print("\f" + s.getRunningDisplay() +"\n" + "\n" + "Purchase added: " + "\n") ;
                    System.out.println("What would u like to do next");
                    System.out.println("1. Buy something else");
                    System.out.println("2. Edit current order");
                    System.out.println("3. Proceed to checkout");
                    
                    int choice = sc.nextInt();
                    while(choice < 1 || choice > 3 )
                    {
                        System.out.println("Wrong number, please try again");
                        choice = sc.nextInt();
                    }
                        
                    switch(choice)
                    {
                        case 1: handleSale(); break;
                        case 2: //blank ; break ;
                        case 3: return;
                    }
                }
                case -1:  System.out.println("Invalid index please recreate ur order");
                          handleSale(); break;
                case -2: // it has to be oreder there are two ways if u want to cancel or reserve
            }
        
        }
}        
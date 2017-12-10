package modellayer;

public class Sale {
    private Customer customer;
    private String employee;
    private Action action;

    private String status;
    private String bill;
    private static int serial;
    private String saleID;

    public Sale(int amount, Item item) {
        action = new Action(amount,item); 
        serial += 1;
    }
    
    public String bill() {
        String a = "" + serial; int zeroes = 6 - a.length();
        saleID = String.format("%0" + zeroes + "d", (serial-1));        
        
        bill  = "Sale ID: " + "\n"
                + "=======================================\n"
                +  action.actionPrint() + "\n"
                + "Total: " + getCSP()  + "\n"
                + "=======================================\n";                
        return bill;
    }    
    
    public boolean deleteItemLine(int i) 
    {
        if(action.delete(i) == true)
        {
            return true;
        } 
        else
        return false;
    }    
    
    public int getSerial() {return serial;}    
    public Action getAction() {Action a = action; return a;}
    public String getCSP() {String a = "\n" + "Total: " + action.calcSalePrice(); return a;}
    public String getBill() {String a = bill; return bill;}
    public String runningDisplay() {String d = action.actionPrint() + getCSP(); return d;}
    public void setStatus(String s) {status = s;}    
    public void addCustomer(Customer cust) {customer = cust;}                  
}
 
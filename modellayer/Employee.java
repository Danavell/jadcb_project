package modellayer;

public class Employee
{
    private String name;
    private String address;
    private String email;
    private String position;
    private String ID;
    private boolean manager;
    private String password;
    private static int index;
    private String login;
    
    public Employee(String name, String address, String email, String position,String login, String password) {
        this.name = name;
        this.address = address;
        this.email = email;
        this.position = position;  
        this.password = password;
        this.login = login ;
        index++;
        generateID();
    }
    
    public String generateID() {
        index--; String a = "" + index;
        ID = String.format("%0" + (6 - a.length()) + "d", (index));
        return ID;
    }
    
    public boolean isManager() {
        if(manager == true) {
            return true;
        }else return false;
    }    
    
    public void setName(String name) {this.name = name;}    
    public void setManager() {manager = true;}    
    public void setPosition(String pos){ position = pos;}
    
    public String getName() {return this.name;}    
    public int getIndex() {int i = index--; return i;}
    public String getPosition() {return this.position;}
    public String getID() {String i = ID; return i;}    
    public String getPassword() {String p = password; return p;}
    public String getLogin() { return login ; }
    
}
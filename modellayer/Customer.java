package modellayer;

public class Customer
{
    private String name;
    private String address;
    private String email;
    private int bankaccount;
    private int phone;
    private static int index;
    
    public Customer(String name, String address, String email, int bankaccount, int phone)
    {
        this.name = name;
        this.address = address;
        this.email = email;
        this.bankaccount = bankaccount;
        this.phone = phone;
        index++;
    }
    
    public void setName(String name) {this.name = name;}    
    public void setAddress(String address) {this.address = address;}
    public void setEmail(String email) {this.email = email;}    
    public void setAccount(int bankaccount){this.bankaccount = bankaccount;}
    public void setPhone(int phone){this.phone = phone;}
            
    public String getName(){return this.name;}
    public int getPhone() {return this.phone;}    
    public String getEmail() {return this.email;}
    public int getIndex() {return index;}
}

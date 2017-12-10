package modellayer;


/**
 * Write a description of class Product here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class Product
{
    private String name;
    private String barcode;
    private double price;
    /**
     * Constructor for objects of class Product
     */
    public Product(String name, String barcode, double price)
    {
        this.name = name;
        this.barcode = barcode;
        this.price = price;
    }

    
    public void setBarcode(String barcode) {this.barcode = barcode;}
    public void setPrice(int price) {this.price = price;}       
        
    public String getName() {String n = name; return name;}
    public String getBarcode() {String b = barcode; return b;}    
    public double getPrice() {double p = price; return p;}
}

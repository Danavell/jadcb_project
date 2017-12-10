package modellayer;


public class ItemLine
{
    private Product product;
    private int requiredAmount;
    private int stock;
    private double price;
    private int index;
    
    public ItemLine(Product prod, int pos, int amount)
    {
        requiredAmount = amount;
        product = prod;
        price = product.getPrice();
        index = pos;
    }
    
    public int getAmount() {int a = requiredAmount; return a;} 
    public int getIndex() {int a = index--; return a;}
    public String getName() {String a = product.getName(); return a;}
    public double getPrice() {double a = product.getPrice(); return a;}
    public Product getProduct() {Product prod = product; return prod;}
}

package modellayer;


import java.util.ArrayList;
public class Stock
{
    private ArrayList<Integer> stock;
    private ArrayList<Integer> maxValue;
    private static Stock instance = null;
    
    private Stock()
    {
        stock = new ArrayList<>();
        maxValue = new ArrayList<>();
    }

    public static Stock getInstance()
    {
        if(instance == null)
        {
            instance = new Stock();
        }
        return instance;
    }
    
    public void decrease(int i, int amount)
    {
        int a = stock.get(i); int b = a - amount;
        
        stock.set(i, b);        
    }
    
    public int add(int i) {stock.add(i); int a = stock.size(); return a;}    
    public int check(int i) {int a = stock.get(i); return a;}    
    public int last() {int a = (stock.size()-1); return a;}

    public int delete(int s, int i)
    {
        if(s >  0)
        {
            if(s < (stock.size()-2))
            {
                stock.set(i,null);
                return 0;
            }
        }
        if(s == -1)
        {
            stock.remove(stock.size()-1);
            return 1;
        }
        return -1;
    }    
}

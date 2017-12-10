package modellayer;


import java.util.ArrayList;
import modellayer.ItemLine.*; 
public class ItemContainer
{
    private ArrayList<Item> single;
    private ArrayList<Item> multiple;
    private int currentIndex;
    public ItemContainer()
    {
        single = new ArrayList<>();
    }

    public void addSingle(Item item)
    {
        currentIndex = item.getIndex(); currentIndex--;
        single.add(item);
        single.trimToSize();        
    }
    
    public void addPackage(Item item)
    {
        currentIndex = item.getIndex(); currentIndex--;
        multiple.add(item);
        multiple.trimToSize();        
    }
    
    public void addItemLine(ItemLine itemLine)
    {
        multiple.get(currentIndex).addItemLine(itemLine);
        multiple.trimToSize();        
    }

    public ArrayList<Item> getSingle(String prefix) 
    {
        ArrayList<Item> matches = new ArrayList<>();

        for(Item item : single) 
        {
            if(item.getName().contains(prefix));
            matches.add(item);
        }
        return matches;
    }
    
    public ArrayList<Item> getMultiple(String prefix) 
    {
        ArrayList<Item> matches = new ArrayList<>();

        for(Item item : multiple) 
        {
            if(item.getName().contains(prefix));
            matches.add(item);
        }
        return matches;
    } 
    
    public boolean getSpecific(int i)
    {
        if(single.get(i).getSingle() == true)
        {
            return true;
        }
        else
        return false;
    }
}

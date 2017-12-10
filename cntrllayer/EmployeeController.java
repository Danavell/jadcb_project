package cntrllayer;

import java.util.*;
import modellayer.*;

public class EmployeeController
{ 
    private EmployeeContainer cont;

    public EmployeeController()
    {
        cont = EmployeeContainer.getInstance();
    
    }

    public void add(String a, String b, String c, String d, String e, String f)
    {
        cont.createEmployee(new Employee(a, b, c, d, e, f));
    }

    public void delete(Employee employee)
    {
        cont.deleteEmployee(employee);
    }
    
    public void update(Employee oldE, String a, String b, String c, String d, String e, String f)
    {
        Employee newE = new Employee(a, b, c, d, e, f);
        cont.deleteEmployee(oldE);
        cont.createEmployee(newE);
    }
}

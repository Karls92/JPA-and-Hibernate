package com.softwaredevone.CustomerManager;

/**
 * @author CARMEN BRAVO
 * @version 1.0
 */
public class App 
{
    public static void main( String[] args )
    {
        
        CustomerController cc = new CustomerController();
        
        //test Customer class
        cc.addCustomer("Arnold", "Smith", 35);
        cc.addCustomer("Jhonny", "Linderman", 22);
        cc.addCustomer("Richard", "Stwart", 16);
        cc.addCustomer("Fernando", "Mendez", 48);
        cc.addCustomer("Georgina", "Spencer", 39);
        
        cc.allCustomers();
        
        cc.getCustomer(4);
        cc.editCustomer("Martin", "Luthor", 20, 4);
        
        cc.allCustomers();
        
        cc.deleteCustomer(2);
        cc.allCustomers();
    }
}

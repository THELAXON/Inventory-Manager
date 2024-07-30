public class Addtowarehouse extends InventoryMain implements Runnable
{
    
    @Override
    public void run() 
    {
        if(InventoryMain.getflag() == 0)
        {
            sync();
        }
        else if(InventoryMain.getflag() == 1)
        {
            unsync();
        }

    }


    public void sync(){
        //If the bugflag is 0 a synchronized block is used to add to inventory
        synchronized(InventoryMain.class)
        {
            int inventory = InventoryMain.getinventory()+1;
            InventoryMain.settinventory(inventory);
            System.out.println("Added." + "Inventory size =" + inventory);
        }
    }

    public void unsync()
    {

        //If the bugflag is 1 a thread sleep is used to add to inventory
        int inventory = InventoryMain.getinventory()+1;
        try 
        {
            Thread.sleep(1);
        } 
        catch (InterruptedException e) 
        {
            e.printStackTrace();
        }
        InventoryMain.settinventory(inventory);
        System.out.println("Added." + "Inventory size =" + inventory);
    }

}

    


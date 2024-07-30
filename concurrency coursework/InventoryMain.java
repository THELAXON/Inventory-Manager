import java.util.ArrayList;
import java.util.List;

public class InventoryMain 
{
    private static int inventorysize;
    private static int bugflag;
    

    public static void main(String[] args) 
    {

        // Numbers in the command line get parsed through and converted to integer for next process
        int additem = Integer.parseInt(args[0]);
        int removeitem = Integer.parseInt(args[1]);
        bugflag = Integer.parseInt(args[2]);
        
        // This array list stores all the threads for both adding and removing operations
        List<Thread> threads = new ArrayList<>();

        // The two for loops below create threads, start them and then add it to the array list
        for(int i=0;i<additem;i++)
        {
            Thread addthread = new Thread(new Addtowarehouse());
            addthread.start();
            threads.add(addthread);
        }

        for(int i=0;i<removeitem;i++)
        {
            Thread removethread = new Thread(new Removefromwarehouse());
            removethread.start();
            threads.add(removethread);
        }

        // For the length of the array list the threads join
        for(Thread threading : threads)
        {
            try 
            {
                threading.join();
            } 
            catch (InterruptedException e) 
            {
                e.printStackTrace();
            }
        }

        // Prints final inventory once all the operations take place
        System.out.println("Final Inventory size = " + inventorysize);

    }

    // The inventory getter, setter and get flag are use in the other classes to access variables from this class
    public static int getinventory(){
        return inventorysize;
    }

    public static void settinventory(int newinventory){
        inventorysize = newinventory;
    }

    public static int getflag(){
        return bugflag;
    }

}
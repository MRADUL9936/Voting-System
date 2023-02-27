import javax.swing.*;
import java.io.File;
import java.io.IOException;
import java.util.*;

abstract class method{
    abstract void admin();
    abstract void user();
    abstract void result();
    abstract void candidate();
    abstract void add_candidate();
    abstract void status_of_yourvote();


}
abstract class admin{
    

}
abstract class user{


}
public class Main extends admin {

    static {
      try{
          File f=new File("admins.csv");
          if(f.createNewFile())
          {System.out.print("");}
      } catch (Exception e) {

      }
    }
    public void admin() {
        Scanner sc=new Scanner(System.in);
     System.out.print("Enter Your id (should be 8 character long) :");
     String id=sc.nextLine();
     System.out.print("Enter Password (should be 8 character long) :");
     String password=sc.nextLine();

    }
    public static void main(String[] args) {
        Main ob=new Main();
        Scanner sc=new Scanner(System.in);
 System.out.println("Welcome to Online Voting System");
        System.out.print("you are admin Or user Enter(1/2) for  Admin:1 ,User:2 ,Result:3 :");
        int ch=sc.nextInt();
        switch(ch)
        {
            case 1:
                ob.admin();
                break;
            case 2:
//                ob.user();
                break;
            case 3:
//                ob.result();
                break;
            default :
                System.out.print("You can Enter only 3 choices (1/2/3)");
                break ;
        }

    }
}
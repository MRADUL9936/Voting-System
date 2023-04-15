
import java.io.*;
import java.util.*;


class Result{
    Result() throws IOException {
        FileReader fr=new FileReader("C:\\Users\\91829\\Java Project\\src\\Candidate.csv");
        BufferedReader br=new BufferedReader(fr);
        String currentLine=br.readLine();
        while((currentLine=br.readLine())!=null)
        {
            System.out.println(currentLine);

        }
        br.close();
    }
}
public class Main  {  //Main class to Run the program

    public static void main(String[] args) {


        Scanner sc=new Scanner(System.in);
        System.out.println("Welcome to Online Voting System");
        System.out.print("you are admin Or user Enter(1/2/3) for  Admin:1 ,User:2 ,Result:3 :");
        try {
            int ch = sc.nextInt();
            switch (ch) {
                case 1 -> {
                    Admin ob1 = new Admin();
                }
                case 2 -> {
                    Voter ob2 = new Voter();
                }
                case 3 -> {
                    Result ob3 = new Result();
                }
                default -> System.out.print("You can Enter only 3 choices (1/2/3)");
            }
        }catch(InputMismatchException e)
        {
            System.out.println("Enter only Integer values(1/2/3)");
        } catch (IOException e) {
            throw new RuntimeException(e);
        }catch(Exception e)
        {
            System.out.println("Exception Occurred");
        }

    }
}
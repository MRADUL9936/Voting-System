import java.util.*;
import java.io.*;

class Admin{     // class for administrator

        File file=new File("C:\\Users\\91829\\Java Project\\src\\Admins.csv");

    Admin() throws IOException {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter Your id  :");
        String id = sc.nextLine();
        System.out.print("Enter Password (should be minimum 8 character long) :");
        String password = sc.nextLine();
        //verity the id and password
        while(password.length()<8) {
            System.out.print("Enter valid password:");
            password = sc.nextLine();
        }


       //Fetching info from file and checking for the valid info
        try {

            Scanner scanner = new Scanner(file);


            while (scanner.hasNextLine()) {
                scanner.nextLine();
                String line = scanner.nextLine();
                String[] fields = line.split(",");
                if(fields[0].equals(id) && fields[1].equals(password))
                {
                    break;
                }else {
                    System.out.println("You are not allowed to use this field");
                    System.exit(0);
                }
            }
            scanner.close();
        } catch (IOException e) {
            e.printStackTrace();
        }

        System.out.print("Enter (1: candidate section , 2:Voter section) :");
        try{
        int c=sc.nextInt();
        switch (c) {

            case 1:
               Candidate cd=new Candidate();
                break;
            case 2:
                New_Voter nv=new New_Voter();
                break;
            default: System.out.print("You can Enter only 2 choices");
        }}catch(InputMismatchException e)
        {
            System.out.println("Please Enter only integers(1/2/3)");
        }
    }
    class Candidate {     // candidate inner class
        Candidate(){
            Scanner sc = new Scanner(System.in);
            System.out.print("Enter (1 to add new candidate Or 2 to remove the candidate) :");
            try{
            int c=sc.nextInt();
            switch(c){
                case 1 ->add_candidate();
                case 2 ->remove_candidate();
                default->System.out.print("You can Enter only 2 choices ");
            }}catch(InputMismatchException e)
            {
                System.out.print("Enter only integer values (1/2)");
            } catch (IOException e) {
                throw new RuntimeException(e);
            }catch(Exception e){
                System.out.println("Exception occured");
            }
        }
        void add_candidate() throws IOException {  //to add a new candidate
            Scanner sc = new Scanner(System.in);
            System.out.print("Enter candidate name :");
            String name = sc.nextLine(); //Read name
            System.out.print("Enter party_name if no party Enter 'null':");
            String party_name = sc.nextLine(); //Read party name
            FileWriter csvWriter=new FileWriter("C:\\Users\\91829\\Java Project\\src\\Candidate.csv",true);

                csvWriter.write(name+","+party_name+0+"\n");
            csvWriter.close();
            System.out.println("successfully updated");
            //add the new candidate

        }
        void remove_candidate() throws IOException       //function to remove the candidate from list
        { Scanner sc = new Scanner(System.in);
            System.out.print("Enter candidate name :");
            String name = sc.nextLine(); //Read name
            System.out.print("Enter party_name if no party Enter 'null':");
            String party_name = sc.nextLine(); //Read party name

         File inputFile = new File("C:\\Users\\91829\\Java Project\\src\\Candidate.csv");
            File tempFile=new File("temp.csv" );
            FileWriter tempWriter=new FileWriter(tempFile,true);
            BufferedWriter bw=new BufferedWriter(tempWriter);
            PrintWriter pw=new PrintWriter(bw);
            FileReader fr=new FileReader("C:\\Users\\91829\\Java Project\\src\\Candidate.csv");
            BufferedReader br=new BufferedReader(fr);

            String currentLine=br.readLine();
            pw.println(currentLine);
            boolean flag=true,flag2=false;
            while((currentLine=br.readLine())!=null)
            {

flag=false;
                String[] t=currentLine.split(",");
                if(t[0].equals(name)&&t[1].equals(party_name)){
                    flag2=true;
                    continue;}
                pw.println(currentLine);

            }
            if(flag){
                System.out.println("file if empty");
            }if(flag2)
            System.out.println("Deleted Successfully");
           pw.flush();
            pw.close();
            fr.close();
            br.close();
            bw.close();
            tempWriter.close();
            inputFile.delete();
            tempFile.renameTo(inputFile);


            //add the new candidate

        }
    }

    class New_Voter{
        New_Voter(){
            Scanner sc = new Scanner(System.in);
            System.out.print("Enter 1 to add new Voter Or 2 to remove the Voter :");
            try {
                int c = sc.nextInt();
                switch (c) {
                    case 1 -> add_Voter();
                    case 2 -> remove_Voter();
                    default -> System.out.print("You can Enter only 2 choices (1/2)");
                }
            }catch(InputMismatchException e)
            {
                System.out.println("You can enter only Integer (1/2)");
            }catch(IOException e)
            {
                System.out.print("Exception occured");
            }
        }
        void add_Voter() throws IOException { //method to add new admin
            Scanner sc = new Scanner(System.in);
            System.out.print("Enter Name :");
            String name = sc.nextLine(); //Read name
            System.out.print("Enter Voter Id:");
            String voter_Id = sc.nextLine(); //Read party name
            System.out.println("Enter Adhar Id :");
            String adhar_id=sc.nextLine();
            try{
                if(adhar_id.length()<12  || voter_Id.length()<12 ||adhar_id.length()>12  || voter_Id.length()>12)
                    throw new Exception();
                Long id=Long.parseLong(voter_Id);
                Long adhar=Long.parseLong(adhar_id);
            }catch(Exception e){
                System.out.println("voter_id and adhar_id can only be in digits ");
            }
            FileWriter csvWriter=new FileWriter("C:\\Users\\91829\\Java Project\\src\\Voters.csv",true);

            csvWriter.write(name+","+voter_Id+","+adhar_id+'N'+"\n");
            csvWriter.close();
            System.out.println("updated successfully");
        }
        void remove_Voter() throws IOException { //method to remove the admin
            Scanner sc = new Scanner(System.in);
            System.out.print("Enter voter name :");
            String voter_name = sc.nextLine(); //Read name
            System.out.print("Enter voter id:");
            String voter_id = sc.nextLine(); //Read party name
            System.out.print("Enter Adhar id:");
            String adhar_id=sc.nextLine();
            try{
                if(adhar_id.length()<12  || voter_id.length()<12 || adhar_id.length()>12  || voter_id.length()>12)
                    throw new Exception();
                Long id=Long.parseLong(voter_id);
                Long adhar=Long.parseLong(adhar_id);
            }catch(Exception e){
                System.out.println("voter_id and adhar_id can only be in digits and 12 digits long ");
            }
            File inputFile = new File("C:\\Users\\91829\\Java Project\\src\\Voters.csv");
            File tempFile=new File("temp.csv" );
            FileWriter tempWriter=new FileWriter(tempFile,true);
            BufferedWriter bw=new BufferedWriter(tempWriter);
            PrintWriter pw=new PrintWriter(bw);
            FileReader fr=new FileReader("C:\\Users\\91829\\Java Project\\src\\Voters.csv");
            BufferedReader br=new BufferedReader(fr);

            String currentLine=br.readLine();
            pw.println(currentLine);
            boolean flag=true;
            boolean flag2=false;
            while((currentLine=br.readLine())!=null)
            {
                 flag=false;

                String[] t=currentLine.split(",");
                if(t[0].equals(voter_name)&&t[1].equals(voter_id)&&t[2].equals(adhar_id)) {
                    flag2=true;
                    continue;

                }
                pw.println(currentLine);

            }
     if(flag)
         System.out.println("file is empty");
     if(flag2){
         System.out.println("Successfully deleted");
     }
            pw.flush();
            pw.close();
            fr.close();
            br.close();
            bw.close();
            tempWriter.close();
            inputFile.delete();
            tempFile.renameTo(inputFile);

        }
    }

}
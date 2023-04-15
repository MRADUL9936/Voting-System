import java.util.*;
import java.io.*;
 class Voter {   //class for user
 Voter() throws IOException {
 System.out.print("Want to Apply to be a voter Or want to vote (Apply:1 / Vote:2) :");
 Scanner sc=new Scanner(System.in);
 int choice=sc.nextInt();
 switch (choice) {
 case 1 -> this.apply();
 case 2 -> this.vote();
 default -> System.out.print("You can only Enter 2 choices ");
 }
 }




 void apply() throws IOException {
  Scanner sc = new Scanner(System.in);
  System.out.print("Enter your name: ");
  String name = sc.nextLine();
  System.out.print("Enter Adhar no :");
  String adhar = sc.nextLine();
  System.out.print("Enter Age");
  int age = sc.nextInt();
  // Here we have to write the code to check the age and verity the adhar no
  if (age >= 18) {

   FileReader fr=new FileReader("C:\\Users\\91829\\Java Project\\src\\Voters.csv");
   BufferedReader br=new BufferedReader(fr);

   String currentLine=br.readLine();
   boolean flag=true;
 String lastline = null;
   while((currentLine=br.readLine())!=null)
   {
       lastline=currentLine;
    String[] t=currentLine.split(",");
    if(t[2].equals(adhar)) {
     System.out.println("You are already a voter ");
     flag=false;
     break;
    }
   }
   if(flag){
    FileWriter csvWriter=new FileWriter("C:\\Users\\91829\\Java Project\\src\\Voters.csv",true);
    assert lastline != null;
    String[] t=lastline.split(",");
    Long your_id=(Long.parseLong(t[1])+1);
    csvWriter.write(name+","+your_id+","+adhar+","+'N'+"\n");
    csvWriter.close();
    System.out.println("updated successfully ! Note you id for voting:"+your_id);
  }
  }else
   System.out.println("Your age is not 18 years So you cannot apply to be a voter");
 }



 void vote() throws IOException {  Scanner sc=new Scanner(System.in);
  System.out.println("Enter you id ");
  String id=sc.nextLine();
  System.out.println("Enter you adhar");
  String adhar=sc.nextLine();

  FileReader frr=new FileReader("C:\\Users\\91829\\Java Project\\src\\Voters.csv");
  BufferedReader br=new BufferedReader(frr);

  String currentLine=br.readLine();
  boolean flag=true;
  while((currentLine=br.readLine())!=null)
  {
   String[] t=currentLine.split(",");
   if(t[2].equals(adhar)&&t[1].equals(id)&&t[3].equals("N")) {
    FileReader fr1=new FileReader("C:\\Users\\91829\\Java Project\\src\\Candidate.csv");
    BufferedReader br1=new BufferedReader(fr1);
    String currentLine1=br1.readLine();
    while((currentLine1=br1.readLine())!=null)
    {
     System.out.println(currentLine1);
   }

    System.out.println("Enter you preference starting from 1:for first candidate and go on :");
    int c=sc.nextInt();

      File inputFile2 = new File("C:\\Users\\91829\\Java Project\\src\\Candidate.csv");
      File tempFile2=new File("temp.csv" );
      FileWriter tempWriter2=new FileWriter(tempFile2,true);
      BufferedWriter bw2=new BufferedWriter(tempWriter2);
      PrintWriter pw2=new PrintWriter(bw2);
      FileReader fr2=new FileReader("C:\\Users\\91829\\Java Project\\src\\Candidate.csv");
      BufferedReader br2=new BufferedReader(fr2);
      String currentLine2=br2.readLine();
      pw2.println(currentLine2);
      int count=1;

      while((currentLine2=br2.readLine())!=null) {
          if (count == c) {
              String[] t2 = currentLine2.split(",");
              t2[3] = String.valueOf(Integer.parseInt(t2[3]) + 1);
              currentLine = Arrays.toString(t2);

          }

          pw2.println(currentLine);
          count++;

      }

      pw2.flush();
      pw2.close();
      fr2.close();
      br2.close();
      bw2.close();
      tempWriter2.close();
      inputFile2.delete();
      tempFile2.renameTo(inputFile2);

      //Update the voting status of the voter

      File inputFile4 = new File("C:\\Users\\91829\\Java Project\\src\\Voters.csv");
      File tempFile4=new File("temp.csv" );
      FileWriter tempWriter4=new FileWriter(tempFile4,true);
      BufferedWriter bw4=new BufferedWriter(tempWriter4);
      PrintWriter pw4=new PrintWriter(bw4);
      FileReader fr4=new FileReader("C:\\Users\\91829\\Java Project\\src\\Voters.csv");
      BufferedReader br4=new BufferedReader(fr4);
      String currentLine4=br4.readLine();
      pw4.println(currentLine4);
      while((currentLine4=br4.readLine())!=null)
      {
       String[] t4=currentLine4.split(",");
       if(t4[1].equals(id)&&t4[2].equals(adhar)) {
        t4[3]= "Y";
        currentLine4= Arrays.toString(t4);
       }
       pw4.println(currentLine4);

      }

      pw4.flush();
      pw4.close();
      fr4.close();
      br4.close();
      bw4.close();
      tempWriter4.close();
      inputFile4.delete();
      tempFile4.renameTo(inputFile4);

      break;

   }else
    System.out.println("You have already voted");

 }
 }
}


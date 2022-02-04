import java.io.*;
import java.util.Scanner;
/**
 * @author prakash
 * @version 1.1
 */
public class AccountMaintaince {
    /**
     * class AccountMaintainance
     */
    public void viewAccountDetails()throws IOException{
        /**
         * viewAccountDetails method
         * @throws IOException
         * @param id of user
         */
          System.out.println("the account details\n");
          Scanner scan=new Scanner(new FileReader("users.csv"));
          String account=" ";
          while(scan.hasNext()){
              account+="\n"+scan.nextLine();
          }
          System.out.println("the details of users is \n"+account);

    }
    public void deleteMembership()throws IOException{
        /**
         * deleteMembership method
         * @param user id
         */
          System.out.println("enter the user mailId of deleting membership");
          Scanner del=new Scanner(System.in);
          String mailId=del.nextLine();
          Scanner del1=new Scanner(new FileReader("users.csv"));
          String data2=" ";
          while(del1.hasNext()){
              data2+="\n"+del1.nextLine();
          }
          if(data2.contains(mailId)){
              data2=data2.replace(mailId,"USER NOT VALID");
          }
          FileWriter f4=new FileWriter("users.csv");
          f4.write(data2);
          f4.close();
          System.out.println("delete the membership of user");
    }
    public void updateAccountDetails()throws IOException{
        /**
         * update AccountDetails
         * @param id  user
         * @throws IOException
         */
        Scanner scan=new Scanner(System.in);
        System.out.println("changing part in account is");
        String change=scan.nextLine();
        try{
            Scanner sc=new Scanner(new FileReader("users.csv"));
            String b=" ";
            while(sc.hasNext()){
                b+="\n"+sc.nextLine();
            }
            System.out.println("updating details");
            String update=scan.nextLine();
            FileWriter f5=new FileWriter("users.csv");
            b=b.replace(change,update);
            f5.write(b);
            f5.close();
        }catch(IOException e){
            System.out.println(e);
        }
    }
    public void addBooks()throws IOException{
        Scanner books=new Scanner(new FileReader("prakash.csv"));
        String bookdata=" ";
        while(books.hasNext()){
            bookdata+=books.nextLine()+"\n";
        }
        Scanner read=new Scanner(System.in);
        System.out.println("Enter the book data to add");
        String addbook=read.nextLine();
        FileWriter bookwrite=new  FileWriter("prakash.csv");
        bookwrite.write(bookdata+addbook);
        bookwrite.close();
    }
    public void help()throws IOException{
        /**
         * help method 
         * @throws IOException
         */
        FileReader f8=new FileReader("20bq1a05j5.txt");
        int i;
        while((i=f8.read())!=-1){
            System.out.print((char)i+"");
        }
        System.out.println("");
    }
}

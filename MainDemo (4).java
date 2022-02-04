import java.io.*;
import java.io.IOException;
import java.util.Scanner;
/**
 * @author prakash
 * @version 1.1
 */
public class MainDemo {
    /**
     * this is a main class 
     */
    public static void main(String[] args)throws IOException{
        /**
         * @param args
         * @throws IOException
         * MAINMETHOD
         */
        Scanner scan=new Scanner(System.in);
        System.out.println("Enter Mail For Signup:");
        String mail=scan.nextLine();
        while(!mail.contains("@vvit.net")){
            System.out.println("please enter valid mail id");
            mail=scan.nextLine();
        }
        System.out.println("Enter Password:");
        Console con=System.console();
        char[] ch=con.readPassword();
        String password=String.valueOf(ch);
        Register reg=new Register(mail,password);
        reg.signup();
        Scanner fs=new Scanner(new FileReader("users.csv"));
        String filedata=" ";
        while(fs.hasNext()){
            filedata+=fs.nextLine()+"\n";
        }
        int flag=0;
        while(true){
            System.out.println("      ********MAIN MENU********      ");
            System.out.println("      ********LIBSOFT********        ");
            System.out.println("SELECT THE CHOICE");
            System.out.println("1.LOGIN");
            System.out.println("2.BOOKCARRY\n   *SEARCH BOOK\n   *RESERVE BOOK\n  *ISSUE BOOK\n  *RETURNBOOK");
            System.out.println("3.ACCOUNT MAINTAINANCE\n  *VIEW ACCOUNT DETAILS\n  *DELETE MEMBERSHIP\n  *UPDATE ACCOUNT DETAILS\n  *HELP\n *ADD BOOK");
            String choice=scan.nextLine();
            switch(choice){
                case "1":
                System.out.println("Enter the mail for login");
                String mailsign=scan.nextLine();
                if(filedata.contains(mailsign)){
                    System.out.println("This user is already exists");
                    flag=1;
                }else{
                    reg.login(filedata);
                    flag=1;
                }
                break;
                case "2":
                /**
                 * this case represents the class BookCarry
                 *the methods are searchBook,reserveBook,issueBook,returnBook
                 */
                System.out.println("enter the book name\n");
                String bookname=scan.nextLine();
                BookCarry b=new BookCarry(bookname);
                System.out.println("1. searchBook\n 2.reserveBook\n 3.issueBook\n 4.returnBook");
                System.out.println("enter the choice\n");
                String subchoice=scan.nextLine();
                /**
                 *this is case represents cases of searchBook,reserveBook,issueBook methods
                 */
                switch(subchoice){
                    case "1":
                    b.searchBook();
                    break;
                    case "2":
                    if(flag!=1){
                        System.out.println("logIn LIBSOFT");
                        reg.login(filedata);
                    }
                    b.reserveBook();
                    break;
                    case "3":
                    if(flag!=1){
                        System.out.println("logIn LIBSOFT");
                        reg.login(filedata);
                    }
                    System.out.println("enter the bookID");
                    String bookID=scan.nextLine();
                    System.out.println("enter the login mailId");
                    String mailId=scan.nextLine();
                    Scanner issue=new Scanner(new FileReader("users.csv"));
                    String data=" ";
                    while(issue.hasNext()){
                        data+=issue.nextLine()+"\n";
                    }
                    b.issueBook(mailId,data,bookID);
                    break;
                    case "4":
                    if(flag!=1){
                        System.out.println("logIn LIBSOFT");
                        reg.login(filedata);
                    }
                    System.out.println("enter the bookID");
                    String bookID1=scan.nextLine();
                    System.out.println("enter the login mailId");
                    String mail1=scan.nextLine();
                    Scanner ret=new Scanner(new FileReader("users.csv"));
                    String data1=" ";
                    while(ret.hasNext()){
                        data1+=ret.nextLine()+"\n";
                    }
                    b.returnBook(mail1,bookID1,data1);
                    break;
                }
                break; 
                case "3":
                AccountMaintaince acc=new AccountMaintaince();
                System.out.println("enter the choice");
                System.out.println("\n1. viewAccountDetails\n 2. deleteMembership\n 3.updateAccountDetails\n 4.Help\n 5.addBook");
                String choice1=scan.nextLine();
                switch(choice1){
                    case "1":
                    if(flag!=1){
                        System.out.println("logIn LIBSOFT");
                        reg.login(filedata);
                    }
                    acc.viewAccountDetails();
                    break;
                    case "2":
                    acc.deleteMembership();
                    break;
                    case "3":
                    if(flag!=1){
                        System.out.println("logIn LIBSOFT");
                        reg.login(filedata);
                    }
                    acc.updateAccountDetails();
                    break;
                    case "4":
                    acc.help();
                    break;
                    case "5":
                    acc.addBooks();
                    break;
                }
                break;
            }

        }
    }
    
}

import java.io.FileReader;
import java.io.IOException;
import java.util.Scanner;
public class MainDemo {
    public static void main(String[] args)throws IOException{
        Scanner scan=new Scanner(System.in);
        while(true){
            System.out.println("enter the choice");
            System.out.println("1. Register\n 2.SearchBook\n 3.AccountMaintainance\n");
            String choice=scan.nextLine();
            switch(choice){
                case "1":
                System.out.println("enter mail for signup:");
                String mail=scan.nextLine();
                while(!mail.contains("@vvit.net")){
                    System.out.println("please enter valid mail id");
                    mail=scan.nextLine();
                } 
                System.out.println("enter password:");
                String password=scan.nextLine();
                Register reg=new Register(mail,password);
                reg.signup();
                reg.login();
                break;
                case "3":
                AccountMaintaince acc=new AccountMaintaince();
                System.out.println("enter the id");
                String id=scan.nextLine();
                System.out.println("enter the id is"+id);
                while(true){
                    System.out.println("enter the choice");
                    System.out.println("\n1. viewAccountDetails\n 2. deleteMembership\n 3.updateAccountDetails\n 4.Help");
                    String choice1=scan.nextLine();
                    switch(choice1){
                        case "1":
                        acc.viewAccountDetails(id);
                        break;
                        case "2":
                        acc.deleteMembership(id);
                        break;
                        case "3":
                        acc.updateAccountDetails(id);
                        break;
                        case "4":
                        acc.help();
                        break;
                    }
                }
                case "2":
                /**
                 * this case represents the class BookCarry
                 * the methods are searchBook,reserveBook,issueBook,returnBook
                 */
                System.out.println("enter the book name\n");
                String bookname=scan.nextLine();
                BookCarry b=new BookCarry(bookname);
                while(true){
                    System.out.println("1. searchBook\n 2.reserveBook\n 3.issueBook\n 4.returnBook");
                    System.out.println("enter the choice\n");
                    String subchoice=scan.nextLine();
                    switch(subchoice){
                        case "1":
                        b.searchBook();
                        break;
                        case "2":
                        b.reserveBook();
                        break;
                        case "3":
                        System.out.println("enter the id of user\n");
                        String id1=scan.nextLine();
                        System.out.println("enter the bookID");
                        String bookID=scan.nextLine();
                        FileReader f7=new FileReader(id1+".csv");
                        int i;
                        String data=" ";
                        while((i=f7.read())!=-1){
                            data+=(char)i;
                        }
                        b.issueBook(id1,data,bookID);
                        break;
                        case "4":
                        System.out.println("enter the id of user\n");
                        String id2=scan.nextLine();
                        System.out.println("enter the bookID");
                        String bookID1=scan.nextLine();
                        b.returnBook(id2, bookID1);
                        break;
                    }
                }
            }
        }
    }
    
}

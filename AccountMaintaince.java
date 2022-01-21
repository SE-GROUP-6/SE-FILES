import java.io.*;
import java.util.Scanner;
/* this class is AccountMaintainence
 there are various methods like deleteMembership 
 UpdateAccountDetails
 ViewAccountDetails
 this class is declared as public*/

public class AccountMaintaince {
    //this method is viewAccountDetails
    /* it may throw an io exception if account details are not found
    */
    public void viewAccountDetails(String id)throws IOException{
          System.out.println("the id or name is"+id);
          System.out.println("the account details\n");
          Scanner scan=new Scanner(new File(id+".csv"));//taking input of  file name of the current user
          System.out.println("the data of user is\n"+scan.nextLine());

    }
    //this method is deleteMembership
    /* it takes id of the user as parameter and deletes the account of the user based on id given*/
    public void deleteMembership(String id){
          System.out.println("the id or name of user is"+id);
          File f5=new File(id+".csv");
          f5.delete();//deletes the membership of the user
          System.out.println("delete the membership of user");
    }
    /* this method UpdateAccountDetails is used to update account details of the user
    this  may throw IOException if  valid id is not given */
    public void updateAccountDetails(String id)throws IOException{
        Scanner scan=new Scanner(System.in);
        System.out.println("changing part in account is");
        /* we need to give input of which part of account should be updated*/
        String change=scan.nextLine();
        //try block is used
        try{
            Scanner sc=new Scanner(new File(id+".csv"));
            String data=sc.nextLine();
            FileOutputStream f6=new FileOutputStream(id+".csv");
            byte[] b=data.replace(change,scan.nextLine()).getBytes();
            f6.write(b);
        }catch(IOException e){// to catch the exception
            System.out.println(e);
        }
    }
    /* help method is used to show guidlines to the user to  use the libsoft  a file named help is taken ,in that file the inforamtion related to libsoft is already given 
    when the user asks for  help all the inforamtion will be displayed on the screen*/
    public void help()throws IOException{
        FileReader f8=new FileReader("help.txt");
        int i;
        while((i=f8.read())!=-1){// reads the information present in the file
            System.out.println((char)i+"");
        }
        System.out.println("");
    }
}

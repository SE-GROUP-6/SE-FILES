import java.io.*;
import java.util.Scanner;
public class AccountMaintaince {
    public void viewAccountDetails(String id)throws IOException{
          System.out.println("the id or name is"+id);
          System.out.println("the account details\n");
          Scanner scan=new Scanner(new File(id+".csv"));
          System.out.println("the data of user is\n"+scan.nextLine());

    }
    public void deleteMembership(String id){
          System.out.println("the id or name of user is"+id);
          File f5=new File(id+".csv");
          f5.delete();
          System.out.println("delete the membership of user");
    }
    public void updateAccountDetails(String id)throws IOException{
        Scanner scan=new Scanner(System.in);
        System.out.println("changing part in account is");
        String change=scan.nextLine();
        try{
            Scanner sc=new Scanner(new File(id+".csv"));
            String data=sc.nextLine();
            FileOutputStream f6=new FileOutputStream(id+".csv");
            byte[] b=data.replace(change,scan.nextLine()).getBytes();
            f6.write(b);
        }catch(IOException e){
            System.out.println(e);
        }
    }
    public void help()throws IOException{
        FileReader f8=new FileReader("20bq1a05j5.txt");
        int i;
        while((i=f8.read())!=-1){
            System.out.println((char)i+"");
        }
        System.out.println("");
    }
}

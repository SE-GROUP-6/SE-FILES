import java.io.*;
import java.util.Scanner;
/**
 * @author prakash
 * @version 1.1
 */
public class Register {
    /**
     * this is register class and emailId,password are parameters declared as private
     */
    private String emailId; 
    private String password; 
    public Register(String emailId,String password){
        this.emailId=emailId;
        this.password=password;
    } 
    /**
     * these are setter and getter methods used to modify the parameters data
     */
    public String getEmailId() {
        return this.emailId;
    }

    public void setEmailId(String emailId) {
        this.emailId = emailId;
    }

    public String getPassword() {
        return this.password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
    public void signup()throws IOException{ 
        /**
         * signup method  for only signup
         */
        Scanner scan=new Scanner(System.in);
        System.out.println("enter the username");
        String name=scan.nextLine();
        System.out.println("Name:"+name);
        System.out.println("Email:"+this.emailId);
        System.out.println("Password:"+this.password);
        System.out.println("Signup succesfully");
        
    }
    public void login(String filedata)throws IOException{
       /**
        * @throws IOException
        *login method 
        */
        Scanner scan=new Scanner(System.in);
        System.out.println("login");
        System.out.println("enter mail:");
        String email=scan.nextLine();
        while(!email.contains("@vvit.net")){
            System.out.println("INVALID EMAIL AND PASSWORD \n Enter valid mail id");
            email=scan.nextLine();
        } 
        System.out.println("Enter password:");
        Console con1=System.console();
        char[] ch1=con1.readPassword();
        String pass=String.valueOf(ch1);
        while(!getEmailId().equals(email)  || !getPassword().equals(pass)){
            System.out.println("enter the valid mailId");
            email=scan.nextLine();
            while(!email.contains("@vvit.net")){
                System.out.println("please enter valid mail id");
                email=scan.nextLine();
            } 
            System.out.println("enter password:");
            pass=con1.readLine();
        }
        System.out.println("Login Succesfully");
        if(filedata.contains(email)){
            System.out.println("this user is already exists");
        }else{
            System.out.println("enter the user related data");
            FileWriter f=new FileWriter("users.csv");
            f.write(filedata+this.emailId+","+scan.nextLine());
            f.close();
        }
    }

}




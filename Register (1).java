import java.io.*;
import java.util.Scanner;
public class Register {
    //@param
    // student to initialise his/her name
    private String emailId; // student to initialise his/her mail id
    private String password; // student to initialise his/her password
    // parametrized constructor
    public Register(String emailId,String password){
        this.emailId=emailId;
        this.password=password;
    } // end parametrized SignUp constructor

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
    public void signup(){
         // end while
        Scanner scan=new Scanner(System.in);
        System.out.println("enter the username");
        String name=scan.nextLine();
        System.out.println("Name:"+name);
        System.out.println("Email:"+this.emailId);
        System.out.println("Password:"+this.password);
        System.out.println("Signup succesfully");
        
    }
    public void login()throws IOException{
        Scanner scan=new Scanner(System.in);
        System.out.println("login");
        System.out.println("enter mail:");
        String email=scan.nextLine();
        while(!email.contains("@vvit.net")){
            System.out.println("please enter valid mail id");
            email=scan.nextLine();
        } 
        System.out.println("enter password:");
        String  pass=scan.nextLine();
        if(getEmailId().equals(email) && getPassword().equals(pass)){
            System.out.println("enter the id");
            String id=scan.nextLine();
            try{
                File f=new File(id+".csv");
                if(!f.exists()){
                   f.createNewFile();
                   FileWriter f1=new FileWriter(id+".csv");
                   System.out.println("enter the data\n");
                   f1.write(scan.nextLine());
                   f1.close();
                }else{
                   FileWriter f2=new FileWriter(id+".csv");
                   f2.write(scan.nextLine());
                   f2.close();
                }
            }catch(IOException e){
                System.out.println(e);
            }
       }
       else{
          System.out.println("Invalid Password or mailid");
       }
    }

}




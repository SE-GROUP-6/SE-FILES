import java.util.Scanner;
import java.io.*;
/**
 * @author prakash
 * @version 1.1
 */
public class BookCarry {
    /**
     * BookCarry class 
     * @param bookname
     */
    private String bookname;
	public String getBookname(){
		return this.bookname;
	}
    /**
     * setter and getter methods
     * @param bookname
     */
	public void setBookname(String bookname){
		this.bookname = bookname;
	}
    public BookCarry(String bookname){
        this.bookname=bookname;
    }
    public boolean searchBook()throws IOException{
        /**
         * searchBook method 
         * Throws IOException
         */
        FileInputStream f1=new FileInputStream("prakash.csv");
        int i;
        String data=" ";
        while((i=f1.read())!=-1){
            data+=(char)i;
        }
        if(data.contains(getBookname())){
            System.out.println("Book is Available");
            return true;
        }else{
            System.out.println("book is not available");
            return false;
        }
        
    }
    public void reserveBook()throws IOException{
        /**
         * reserveBook method 
         * @throws IOException
         */
        if(searchBook()){
            System.out.println("Reserve book");
        } else{
            System.out.println("can't reserve book");
        }
    }
    public void issueBook(String mail,String data,String bookID)throws IOException{
        /**
         * issueBook method 
         * @throws IOException
         * @param id,data of userFile,bookID
         */
        System.out.println("Issue a book");
        String data2=" ";
        if(data.contains(mail)){
            data2=data.replace(mail,mail+","+bookID);
        }
        FileWriter f2=new FileWriter("users.csv");
        f2.write(data2);
        f2.close();
        System.out.println("Book Issued");

    }
    public void returnBook(String mail,String bookID,String data1)throws IOException{
        /**
         * returnBook method 
         * @param id,bookID
         * @throws IOException
         */
        String res=" ";
        Scanner ret=new Scanner(new FileReader("users.csv"));
        while(ret.hasNext()){
            res+="\n"+ret.nextLine();
        }
        if(res.contains(bookID)){
            System.out.println("book return");
            String data3=" ";
            if(data1.contains(mail)){
                data3=data1.replace(mail,mail+","+bookID+"book returned");
            }
            FileWriter f3=new FileWriter("users.csv");
            f3.write(data3);
            f3.close();
        }else{
            System.out.println("book not return");
        }
    }  
}

import java.util.Scanner;
import java.io.*;
public class BookCarry {
    private String bookname;

	public String getBookname() {
		return this.bookname;
	}

	public void setBookname(String bookname) {
		this.bookname = bookname;
	}
    public BookCarry(String bookname){
        this.bookname=bookname;
    }
    public boolean searchBook()throws IOException{
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
        if(searchBook()){
            System.out.println("reserve book");
        }else{
            System.out.println("can't reserve book");
        }
    }
    public void issueBook(String id,String data,String bookID)throws IOException{
        System.out.println("Issue a book");
        String data1=data+","+getBookname()+","+bookID;
        System.out.println(data1);
        FileWriter f3=new FileWriter(id+".csv");
        f3.write(data1);
        f3.close();
        System.out.println("Book Issued");

    }
    public void returnBook(String id,String bookID)throws IOException{
        FileReader f4=new FileReader(id+".csv");
        int i;
        String res=" ";
        while((i=f4.read())!=-1){
            res+=(char)i;
        }
        if(res.contains(bookID)){
            System.out.println("book return");
        }else{
            System.out.println("book not return");
        }
    }



    
}

package Databaseprgms;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Scanner;
	public class BookTest {
		
			public static void main(String[] args){
			// TODO Auto-generated method stub
			Connection con;
			Statement sts = null;
			Scanner scan=new Scanner(System.in);
			
			Book obj=new Book();
			
			try {
				Class.forName("com.mysql.jdbc.Driver");
				con=DriverManager.getConnection("jdbc:mysql://localhost:3306/applicationsdb","root","");
				sts=con.createStatement();
			} catch (ClassNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			System.out.println("^^^^^^^^^^^^ LIBRARY BOOKS ^^^^^^^^^^^^^");
			System.out.println("========================================");
			System.out.println("****** CHOICES *******");
			System.out.println("To search book details: select 1");
			System.out.println("To insert book details: select 2");
			System.out.println("To update book details: select 3");
			System.out.println("To delete book details: select 4");
			System.out.println("To display all books in the library: select 5");
			System.out.println("Enter your choice: ");
			int c=scan.nextInt();
			if(c==1)
			{
				try {
					obj.selectByBook(sts);
					
					System.out.println("********* FINDING A BOOK BY AUTHOR NAME ********* ");
					System.out.println("Enter author name: ");
					String name=scan.next();
					ResultSet rs=obj.selectByAuthor(sts,name);
					while(rs.next()){
						System.out.println("Book number: "+rs.getInt(1));
						System.out.println("Book's name: "+rs.getString(2));
						System.out.println("Author : "+rs.getString(3));
						System.out.println("Book's genre: "+rs.getString(4));
						System.out.println("Book's publication: "+rs.getString(5));
						System.out.println("Book's edition: "+rs.getInt(6));
						System.out.println("Book's price: "+rs.getFloat(7));
					}
					
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}				
			}
			if(c==2){
				try {
					System.out.println("******** INSERT BOOKS DETAILS **********");
					boolean b=true;
					while(b){
					System.out.println("Enter book number: ");
					int bnum=scan.nextInt();				
					System.out.println("Enter title of the book: ");
					String bookname=scan.next();						
					System.out.println("Enter author name: ");
					String author=scan.next();				
					System.out.println("Enter book's genre: ");
					String genre=scan.next();				
					System.out.println("Enter book's publication: ");
					String pub=scan.next();				
					System.out.println("Enter book's edition: ");
					int edition=scan.nextInt();
					System.out.println("Enter book's price: ");
					float price=scan.nextFloat();
					
				LibraryBooks bf1=new LibraryBooks(bnum,bookname,author,genre,pub,edition,price); 				
				int output1=obj.insertDetails(sts, bf1);
					if(output1!=-1){
						System.out.println("INSERTION SUCCESFULLY COMPLETED");
					}else{
						System.out.println("INSERTION FAILED");
					}
					System.out.println("Do you want to insert another book details(y/n)? :");
					char ch=scan.next().charAt(0);
					if(ch=='n'){
					b=false;
						System.out.println("---------- Details are recorded -----------");
					}
					}
					ArrayList res=obj.display(sts);
					for(int i=0;i<res.size();i++)
					{
						LibraryBooks f=(LibraryBooks)res.get(i);
						System.out.print(f.getBno()+" ");
						System.out.print(f.getBname()+" ");
						System.out.print(f.getBauthor()+" ");
						System.out.print(f.getBgenre()+" ");
						System.out.print(f.getBpublications()+" ");
						System.out.print(f.getBedition()+" ");
						System.out.println(f.getBprice()+" ");
					}
					
					
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
			if(c==3)
			{
				try {
					System.out.println("^^^^^^^^^^^ UPDATE DETAILS ^^^^^^^^^");
					System.out.println("Enter the book number to update details:");
					int u=scan.nextInt();
					System.out.println("Enter author name");
					String up=scan.next();					
					obj.updateDetails(sts,u,up);
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
			if(c==4)
			{
				try {
					System.out.println("Enter the book number to delete whole record:");
					int n=scan.nextInt();					
					int del=obj.deleteDetails(sts,n);
					if(del!=-1)
					{
						System.out.println("DELETION COMPLETED SUCCESSFULLY");
					}else{
						System.out.println("DELETION FAILED");
					}
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
			if(c==5)
			{
				try {
				System.out.println("######### BOOKS IN THE LIBRARY #########");				
				ArrayList res=obj.display(sts);
				for(int i=0;i<res.size();i++)
				{					
					LibraryBooks f=(LibraryBooks)res.get(i);
					System.out.print(f.getBno()+" ");
					System.out.print(f.getBname()+" ");
					System.out.print(f.getBauthor()+" ");
					System.out.print(f.getBgenre()+" ");
					System.out.print(f.getBpublications()+" ");
					System.out.print(f.getBedition()+" ");
					System.out.println(f.getBprice()+" ");
				}
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		}
	}
	
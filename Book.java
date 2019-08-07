package Databaseprgms;

import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Scanner;

	public class Book {
		Scanner scan=new Scanner(System.in);
				
		public int insertDetails(Statement sts, int bnum, String bookname, String author, String genre, String pub, int edition, float price) throws SQLException
		{		
		int status=sts.executeUpdate("INSERT INTO librarybooks VALUES("+bnum+",'"+bookname+"','"+author+"','"+genre+"','"+pub+"',"+edition+","+price+")");
		return status;
		}
		
		public int insertDetails(Statement sts, LibraryBooks bf1) throws SQLException
		{		
		int status=sts.executeUpdate("INSERT INTO librarybooks VALUES("+bf1.getBno()+",'"+bf1.getBname()+"','"+bf1.getBauthor()+"','"+bf1.getBgenre()+"','"+bf1.getBpublications()+"',"+bf1.getBedition()+","+bf1.getBprice()+")");
		return status;
		}
		
		public ArrayList display(Statement sts) throws SQLException
		{		
			ArrayList bk=new ArrayList();
			ResultSet rs=sts.executeQuery("SELECT * FROM librarybooks");
			System.out.println("B.Number"+"  "+"Book Name"+"  "+"Author"+"  "+"Genre"+"  "+"Publication"+"  "+"Edition"+"  "+"Price");
			while(rs.next())
			{
				int no=rs.getInt(1);
				String bname=rs.getString(2);
				String bauth=rs.getString(3);
				String gen=rs.getString(4);
				String pub=rs.getString(5);
				int edi=rs.getInt(6);
				float pri=rs.getFloat(7);
				
				LibraryBooks bkf=new LibraryBooks(no,bname,bauth,gen,pub,edi,pri);
				bk.add(bkf);
			}
		return bk;
		} 			
		public void selectByBook(Statement sts) throws SQLException
		{		
			System.out.println("******* SEARCH BOOKS ********");
			System.out.println("Enter the title of the book: ");
			String bname=scan.next();
			
				ResultSet rs=sts.executeQuery("SELECT * FROM librarybooks WHERE title='"+bname+"'");
				while(rs.next())
				{
					System.out.println("Book number: "+rs.getInt(1));
					System.out.println("Book's name: "+rs.getString(2));
					System.out.println("Author : "+rs.getString(3));
					System.out.println("Book's genre: "+rs.getString(4));
					System.out.println("Book's publication: "+rs.getString(5));
					System.out.println("Book's edition: "+rs.getInt(6));
					System.out.println("Book's price: "+rs.getFloat(7));
				}		
		}
		public ResultSet selectByAuthor(Statement sts,String name) throws SQLException
		{
				ResultSet r=sts.executeQuery("SELECT * FROM librarybooks WHERE author='"+name+"'");
				return r;
		}	
		public void updateDetails(Statement sts,int u,String up) throws SQLException
		{
			
			
				int status=sts.executeUpdate("UPDATE librarybooks SET author='"+up+"' WHERE booknum="+u);
				if(status!=-1)
				{
					System.out.println("UPDATED SUCCESSFULLY");
				}
				else
				{
					System.out.println("FAILED TO UPDATE");
				}
			} 
		public int deleteDetails(Statement sts,int n) throws SQLException
		{	
				int  status=sts.executeUpdate("DELETE FROM librarybooks WHERE booknum="+n);
				return status;
			} 
		}

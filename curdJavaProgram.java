	import java.sql.*;
	import java.io.*;
	
	
	
	class curdJavaProgram
	{
	    public static void main(String args[])throws IOException
	    {
	       
	       BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
	       Connection con=null;
	       
	       try
	        {
	          	Class.forName("com.mysql.cj.jdbc.Driver");
	          	con=DriverManager.getConnection("jdbc:mysql://localhost:3306/Student","root","redhat");
	       		int ch=0;
	       		do
	       		{
	       		 	System.out.println("1) Insert Student data into Student Table");
	       		        System.out.println("2) Update Student data into Student Table");
	       		        System.out.println("3) Delete Student data From Student table");
	       		        System.out.println("4) Get List of all Students");
	       		        System.out.println("5) Get One Student information depending on the Student id filter");
	       		        System.out.println("6) Exit");
	       		        ch=Integer.parseInt(br.readLine());
	       		        
	       		        switch(ch)
	       		        {
	       		        	case 1: //Insert
	       		        	
                                                
                                                 try
                                                 { 
	       		        	        	
	       		        	        	    
	       		        	        	   	        	        	    
	       		        	        
	       		        	        	PreparedStatement ps=con.prepareStatement("Insert into STUDENT values(?,?,?,?)");
	       	                                         int count=0;
	       	                                         Statement st =con.createStatement();
	       	                                         ResultSet rs=st.executeQuery("Select * from STUDENT");
	       	                                         while(rs.next())
	       	                                         {
	       	                                            count=rs.getInt(1);
	       	                                         } 	        	        	
	       		        	        	System.out.println("Enter student name");
	       		        	        	String  sname=br.readLine();
	       		        	        	System.out.println("Enter your date of birth(yyyy/mm/dd)");
	       		        	        	String dob=br.readLine();
                                                           		        	        		       		        	                         	System.out.println("Enter your date of Join(yyyy/mm/dd)");
	       		        	        	String doj=br.readLine();
	       		        	        	 
	       		        	        	        	
	       		        	        	if(count==0)
	       		        	        	{
	       		        	        	   ps.setInt(1,count+1);
		       		        	           ps.setString(2,sname);
		       		        	           ps.setString(3,dob);
		       		        	           ps.setString(4,doj);
		       		        	           ps.executeUpdate();
		       		        	           System.out.println("Record Inserted!!!!!!");
		       		        	        }
		       		        	        else
		       		        	        {
 		       		        	           ps.setInt(1,count+1);
		       		        	           ps.setString(2,sname);
		       		        	           ps.setString(3,dob);
		       		        	           ps.setString(4,doj);
		       		        	           ps.executeUpdate();
		       		        	           System.out.println("Record Inserted!!!!!!");
		       		        	        }
		       		        	        
		       		                }	
		       		                catch(Exception e)
		       		                {
		       		                   System.out.println(e);
		       		                }
		       		                break;
		       		     case 2://update record details
		       		             try
		       		             {
		       		                 PreparedStatement ps=con.prepareStatement("Update STUDENT set STUDENT_NAME=?,STUDENT_DOB=?,STUDENT_DOJ=? where STUDENT_NO=?");
		       		                 System.out.println("Enter STUDENT_ID of student whoose details you want to update");
		       		                 int sno=Integer.parseInt(br.readLine());
		       		                 System.out.println("Enter student name");
	       		        	         String  sname=br.readLine();
	       		        	         System.out.println("Enter your date of birth(yyyy/mm/dd)");
	       		        	         String dob=br.readLine();
                                                          	        		       		        	                         	         System.out.println("Enter your date of Join(yyyy/mm/dd)");
	       		        	         String doj=br.readLine();
	       		        	         ps.setInt(4,sno);
	       		        	         ps.setString(1,sname);
	       		        	         ps.setString(2,dob);
	       		        	         ps.setString(3,doj);
	       		        	         System.out.println("You whant to Update Student Details Enter [Y/N]");
		       		                 String op=br.readLine();
		       		                   if(op.equals("Y"))
		       		                    {
		       		                       ps.executeUpdate();
		       		                       System.out.println("Record Updated!!!!!!");
		       		                     }
		       		                    else
		       		                    {
		       		                       System.out.println("You cancel update operation....");
		       		                       break;
		       		                    } 
	       		        	         
		       		             }
		       		             catch(Exception e)
		       		             {
		       		                System.out.println(e);
		       		             }
		       		             break;             
		       		                          
		       		     case 3://delete
		       		               try
		       		               {
		       		                  
		       		                   System.out.println("Enter Student Id to delete record");
		       		                   int sno=Integer.parseInt(br.readLine());
		       		                   String sql="delete from STUDENT where STUDENT_NO=?";
		       		                   PreparedStatement ps=con.prepareStatement(sql);
		       		                   ps.setInt(1,sno);
		       		                   System.out.println("You whant to delete record Enter [Y/N]");
		       		                   String op=br.readLine();
		       		                   if(op.equals("Y"))
		       		                    {
		       		                       ps.executeUpdate();
		       		                       System.out.println("Record deleted!!!!!!");
		       		                     }
		       		                    else
		       		                    {
		       		                       System.out.println("You cancel delete operation....");
		       		                       break;
		       		                    } 
		       		               }
		       		               catch(Exception e)
		       		               {
		       		                 System.out.println(e);
		       		               }
		       		               break; 
		       		    case 4://display
		       		             try
		       		             {
		       		                        Statement st=con.createStatement();
		       		                        ResultSet rs=st.executeQuery("select * from STUDENT");
		       		                        while(rs.next())
		       		                        {
		       		                           System.out.println("Student No:"+rs.getInt(1)+" Student Name:"+rs.getString(2)+"DOB: "+rs.getString(3)+"DOJ: "+rs.getString(4));
		       		                        }	
		       		             }
		       		             catch(Exception e)
		       		             {
		       		                 System.out.println(e); 
		       		             }		       		                   
		       		             break;      
		       		    case 5: //Serarch by student_no
		       		                   System.out.println("Enter Student no");
		       		                   int sno=Integer.parseInt(br.readLine());  
		       		                                  
		       		                   try
		       		                   {
		       		                        
		       		                        Statement st=con.createStatement();
		       		                        ResultSet rs=st.executeQuery("select * from STUDENT where STUDENT_NO="+sno);	
		       		                        System.out.println("| Student Number | Student Name | Student DOB | Student DOJ |"); 
		       		                        if(rs.next())
		       		                        {
		       		                           System.out.println("|"+rs.getInt(1)+"\t\t|\t"+rs.getString(2)+"|\t "+rs.getString(3)+"|\t "+rs.getString(4)+"|");
		       		                           
		       		                        }
		       		                        else
		       		                        {
		       		                           System.out.println("Student not found"); 
		       		                        }
		       		                   }
		       		                   catch(Exception e)
		       		                   {
		       		                        System.out.println(e);
		       		                   }
		       		                   break;
		       		    
		       	            case 6:System.out.println("Buy");
		       	                    System.exit(0);
		       	            
	       		        }
	       		 	  
	       		   
	       		}while(ch!=6);
	         }
	       catch(Exception e)
	       {
	          System.out.println(e);
	       }
	       
	    }
	}

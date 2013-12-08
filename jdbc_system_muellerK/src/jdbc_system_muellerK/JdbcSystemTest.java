package jdbc_system_muellerK;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;


public class JdbcSystemTest {
	
		
	   

	 public static void main(String[] args)
	   {
		 
		 String driver = "org.apache.derby.jdbc.EmbeddedDriver";
		// the database name  
	      String dbName="jdbcSystem";
	   // define the Derby connection URL to use 
	      String connectionURL = "jdbc:derby:" + dbName + ";create=true;";
	      
	      String start="start";
	      String insert="insert";
	      String delete="delete";
	      String update="update";
	      String insertupdate="insertupdate";
	      
	      Connection conn = null;
	      Statement statement;
	      Statement stateshow;
	      PreparedStatement psInsert;
	      ResultSet myInsert;
	      ResultSet myDelete;
	      PreparedStatement psDelete;
	      
	      String printLine = " ###################################################";
	      String createString = "CREATE TABLE SYSTEMINSERT  "
	        +  "(INSERT_ID INT NOT NULL GENERATED ALWAYS AS IDENTITY " 
	        +  "   CONSTRAINT INSERT_PK PRIMARY KEY, " 
	       // +  " ENTRY_DATE TIMESTAMP DEFAULT CURRENT_TIMESTAMP, "
	        +  " INSERT_ITEM VARCHAR(32) NOT NULL) " ;
	      String answer;
	      
	      try{
	    	  
	      
	    	  Class.forName(driver); 
	          System.out.println(driver + " loaded. ");
	      }
	      catch(java.lang.ClassNotFoundException e)     {
	          System.err.print("ClassNotFoundException ist aufgetreten: ");
	          System.err.println(e.getMessage());
	          System.out.println("\n    >>> Please check your CLASSPATH variable   <<<\n");
	      }
	      try {
	            
	            conn = DriverManager.getConnection(connectionURL);		 
	            System.out.println("Connected to database " + dbName);
	      
	      statement = conn.createStatement();
	      stateshow = conn.createStatement();
          // Call utility method to check if table exists.
          //      Create the table if needed
          if (! Jdbc_reader_muellerK.insertlistcheck(conn))
          {  
               System.out.println (" . . . . creating table INSERT_LIST");
               statement.execute(createString);
           }
	      
	      //psInsert = conn.prepareStatement("insert into SYSTEMINSERT(INSERT_ITEM) values (?)");

          //   ## ADD / DISPLAY RECORD SECTION ## 
          //  The Add-Record Loop - continues until 'exit' is entered 
          do {
              // Call utility method to ask user for input 
              answer = Jdbc_reader_muellerK.getInsertItem(start);
              // Check if it is time to EXIT, if not insert the data   
              if(answer.equals("show")){
            	  myInsert = statement.executeQuery("select ENTRY_DATE, INSERT_ITEM from SYSTEMINSERT order by ENTRY_DATE");

                  //  Loop through the ResultSet and print the data 
                  System.out.println(printLine);
                  while (myInsert.next())
                   {
                         System.out.println("I insert " + myInsert.getString(2) + " at " + myInsert.getTimestamp(1) );
                    }
                    System.out.println(printLine);
                    //  Close the resultSet 
                    myInsert.close();
              }
              
              if(answer.equals("delete")){
            	  try{
            	  String valuesdelete = "";
            	  ResultSet myInsertsNow;
            	 
            	  System.out.println("Which element do you want to delete? ");
            	  String answerdelete = Jdbc_reader_muellerK.getInsertItem(delete);
            	  if (! answerdelete.equals("exit"))
                  {
                      
                      valuesdelete= answerdelete;
                  }
            	  
            	  
            	  String sqldelete="DELETE FROM SYSTEMINSERT where INSERT_ITEM = '"+valuesdelete+"'";
            	  stateshow.execute(sqldelete);
                  System.out.println("Delete the element "+valuesdelete+" accepted ");

                         
                  myInsert = statement.executeQuery("select ENTRY_DATE, INSERT_ITEM from SYSTEMINSERT order by ENTRY_DATE");

                 
                  System.out.println(printLine);
                  while (myInsert.next())
                   {
                         System.out.println("I insert " + myInsert.getString(2) + " at " + myInsert.getTimestamp(1) );
                    }
                    System.out.println(printLine);
                    //  Close the resultSet 
                    myInsert.close();
            	  }
            	  catch(Exception e){
            		  System.out.println(e.getMessage());
            	  }
              
              
              }
              if (answer.equals("update")){
            	  String valuesupdate = "";
            	  String valuesnew="";
            	  ResultSet myUpdateNow;
            	  System.out.println("Which element do you want to update? ");
            	  String answerupdate = Jdbc_reader_muellerK.getInsertItem(update);
            	  if (! answerupdate.equals("exit"))
                  {
                      
                      valuesupdate= answerupdate;
                  }
            	  System.out.println("Enter now the new name for the Element ");
            	  String newupdate = Jdbc_reader_muellerK.getInsertItem(insertupdate);
            	  if (! newupdate.equals("exit"))
                  {
                     
                      valuesnew= newupdate;
                  }
            	  
            	  String sqldelete="UPDATE SYSTEMINSERT SET INSERT_ITEM = '"+valuesnew+"' WHERE INSERT_ITEM='"+valuesupdate+"'";
            	  stateshow.execute(sqldelete);
                  System.out.println("The element "+valuesupdate+" has changed to "+valuesnew);
                  myInsert = statement.executeQuery("select ENTRY_DATE, INSERT_ITEM from SYSTEMINSERT order by ENTRY_DATE");

                  
                  System.out.println(printLine);
                  while (myInsert.next())
                   {
                         System.out.println("I insert " + myInsert.getString(2) + " at " + myInsert.getTimestamp(1) );
                    }
                    System.out.println(printLine);
                    //  Close the resultSet 
                    myInsert.close();
            	  
              }
               if(answer.equals("insert"))   {
            	   try{
                 	  String valuesinsert = "";
                 	  ResultSet myInsertsNow;
                 	  
                 	  System.out.println("Which element do you want to insert? ");
                 	  String answerinsert = Jdbc_reader_muellerK.getInsertItem(insert);
                 	  if (! answerinsert.equals("exit"))
                       {
                          
                           valuesinsert= answerinsert;
                       }
                 	  
                 	  
                 	  String sqldelete="insert into SYSTEMINSERT(INSERT_ITEM) values'"+ valuesinsert+"'";
                 	  stateshow.execute(sqldelete);
                       System.out.println("Insert the element "+valuesinsert+" accepted ");

                               
                       myInsert = statement.executeQuery("select ENTRY_DATE, INSERT_ITEM from SYSTEMINSERT order by ENTRY_DATE");

                       //  Loop through the ResultSet and print the data 
                       System.out.println(printLine);
                       while (myInsert.next())
                        {
                              System.out.println("I insert " + myInsert.getString(2) + " at " + myInsert.getTimestamp(1) );
                         }
                         System.out.println(printLine);
                         //  Close the resultSet 
                         myInsert.close();
                           
                 	  }
                 	  catch(Exception e){
                 		  System.out.println(e.getMessage());
                 	  }
              
            } 
          }
          
          while (! answer.equals("exit")) ;  // End of do-while loop 
          //psInsert.close();
          statement.close();
          conn.close();	
          System.out.println("Closed connection");
          
        
         /*** In embedded mode, an application should shut down Derby.
         Shutdown throws the XJ015 exception to confirm success. ***/			
      if (driver.equals("org.apache.derby.jdbc.JdbcSystemTest")) {
         boolean gotSQLExc = false;
         try {
            DriverManager.getConnection("jdbc:derby:;shutdown=true");
         } catch (SQLException se)  {	
            if ( se.getSQLState().equals("XJ015") ) {		
               gotSQLExc = true;
            }
         }
         if (!gotSQLExc) {
         	  System.out.println("Database did not shut down normally");
         }  else  {
           // System.out.println("Database shut down normally");	
        	 }
         
      	}
         
	      }catch (Throwable e)  {   
          /*       Catch all exceptions and pass them to 
          **       the exception reporting method             */
          System.out.println(" . . . exception thrown:");
          errorPrint(e);
       }
       System.out.println("Getting Started With Derby JDBC program ending.");
    }
      
      static void errorPrint(Throwable e) {
          if (e instanceof SQLException) 
             SQLExceptionPrint((SQLException)e);
          else {
             System.out.println("A non SQL error occured.");
             e.printStackTrace();
          }   
       }  // END errorPrint 

     //  Iterates through a stack of SQLExceptions 
       static void SQLExceptionPrint(SQLException sqle) {
          while (sqle != null) {
             System.out.println("\n---SQLException Caught---\n");
             System.out.println("SQLState:   " + (sqle).getSQLState());
             System.out.println("Severity: " + (sqle).getErrorCode());
             System.out.println("Message:  " + (sqle).getMessage()); 
             sqle.printStackTrace();  
             sqle = sqle.getNextException();
          }

	   }	      
       
      
}

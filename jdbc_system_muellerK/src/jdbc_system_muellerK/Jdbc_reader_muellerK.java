package jdbc_system_muellerK;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;



public class Jdbc_reader_muellerK {


	
	   public static String getInsertItem(String type) {
	      BufferedReader br = new BufferedReader( new InputStreamReader(System.in));
	      String ans = "";
	      try
	      {
	         while ( ans.length() == 0 ) {
	        	 if(type.equals("start")){
	        		System.out.println("1, Show the current inserts of the table (write show):");
	 	            System.out.println("2, Insert one Element (write insert + push enter)");
	 	            System.out.println("3, Delete (write delete + push enter):");
	 	            System.out.println("4, Update(write update + push enter):");
	 	            
	        	 }
	        	 else if(type.equals("delete")){
	 	            System.out.println("Write here, which element do you want to delete (next push enter): ");
	        	 }
	        	 else if(type.equals("update")){
	        		 System.out.println("Write here, which element do you want to update");
	        	 }
	        	 else if(type.equals("insertupdate")){
	        		 System.out.println("Write here, the new name for the element");
	        	 }
	        	 else if(type.equals("insert")){
	        		 System.out.println("Write the name which element do you want to insert:");
	        	 }

	            ans = br.readLine();
	            if ( ans.length() == 0 ) 
	               System.out.print("Nothing entered: ");
	         }
	      } catch (java.io.IOException e) {
	         System.out.println("Could not read response from stdin");	
	         }
	         return ans;
	    }  /**  END  getWishItem  ***/

	/***      Check for  INSERT_LIST table    ****/
	   public static boolean insertlistcheck (Connection conTst ) throws SQLException {
	      boolean chk = true;
	      boolean doCreate = false;
	      try {
	         Statement s = conTst.createStatement();
	         s.execute("update SYSTEMINSERT set ENTRY_DATE = CURRENT_TIMESTAMP, INSERT_ITEM = 'TEST ENTRY' where 1=3");
	      }  catch (SQLException sqle) {
	         String theError = (sqle).getSQLState();
	         //   System.out.println("  Utils GOT:  " + theError);
	         /** If table exists will get -  WARNING 02000: No row was found **/
	         if (theError.equals("42X05"))   // Table does not exist
	         {  return false;
	          }  else if (theError.equals("42X14") || theError.equals("42821"))  {
	             System.out.println("WwdChk4Table: Incorrect table definition. Drop table INSERT_LIST and rerun this program");
	             throw sqle;   
	          } else {
	             System.out.println("WwdChk4Table: Unhandled SQLException" );
	             throw sqle; 
	          }
	      }
	      //  System.out.println("Just got the warning - table exists OK ");
	      return true;
	   }  /*** END wwdInitTable  **/


	   public static void main  (String[] args) {
	   // This method allows stand-alone testing of the getWishItem method
	      String answer;
	      String type="";
	      do {
	         answer = getInsertItem(type);
	         if (! answer.equals("exit"))  {
	            System.out.println ("You said: " + answer);
	         }
	      } while (! answer.equals("exit")) ;
	   }

}


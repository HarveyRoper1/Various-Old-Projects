import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Scanner;

public class FileReader {

	public static void main(String[] args) throws IOException {
		
		//File file = new File("C:\\Users\\Harvey\\Desktop\\test1.txt");
		//Scanner sc = new Scanner(file);
		//Scanner inputScanner = new Scanner(System.in);
		
		//String fileContents = "";
		//System.out.println("File Name?");
		//String name = inputScanner.nextLine();
		
		//while(sc.hasNextLine()) {
		//	fileContents = fileContents.concat(sc.nextLine() + " ");
		//}
		
		//System.out.println(fileContents);
		
		//FileWriter writer = new FileWriter(String.format("C:\\Users\\Harvey\\Desktop\\%s.txt", name));
		//FileWriter writer2 = new FileWriter(file);
		//writer.write(fileContents);
		//writer2.write("Hello");
		
		
		 for(int i = 0 ; i < 10; i++) {
			try(FileWriter fw = new FileWriter(String.format("C:\\Users\\Harvey\\Desktop\\Random Passwords %s.txt",i), true);
				    BufferedWriter bw = new BufferedWriter(fw);
				    PrintWriter out = new PrintWriter(bw))
				{
				   for(int j = 0 ; j < 1000; j++) {
					   out.println(getAlphaNumericString(20));
				   }
				} catch (IOException e) {
				    //exception handling left as an exercise for the reader
				}
		
		 }
		//writer.close();
		//sc.close();
	}
	
	public static String getAlphaNumericString(int n) 
    { 
  
        // chose a Character random from this String 
        String AlphaNumericString = "ABCDEFGHIJKLMNOPQRSTUVWXYZ"
                                    + "0123456789"
                                    + "abcdefghijklmnopqrstuvxyz"; 
  
        // create StringBuffer size of AlphaNumericString 
        StringBuilder sb = new StringBuilder(n); 
  
        for (int i = 0; i < n; i++) { 
  
            // generate a random number between 
            // 0 to AlphaNumericString variable length 
            int index = (int)(AlphaNumericString.length() * Math.random()); 
  
            // add Character one by one in end of sb 
            sb.append(AlphaNumericString 
                          .charAt(index)); 
        } 
  
        return sb.toString(); 
    } 

}

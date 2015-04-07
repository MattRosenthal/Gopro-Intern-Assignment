import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class ConstitutionReader {
	
	public static void main(String args[]) {
		int line = 0;
		int word = 0; 
		int charbyte = 0;
		
		try {
			BufferedReader reader = new BufferedReader(new FileReader(args[0]));
			String currline = null;
			while ((currline = reader.readLine()) != null) {
				line++;
				word += currline.split(" ").length;
				charbyte += currline.getBytes().length;
			}
			
			System.out.println(line + " " + word + " " + charbyte);
			reader.close();
			
		}
		catch (IOException e) {
			e.printStackTrace();
		}
	}
	
}

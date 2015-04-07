import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class ConstitutionReader {
	
	public static void main(String args[]) {
		int line = 0;
		int word = 0; 
		int charbyte = 0;
		
		try {
			BufferedReader reader = new BufferedReader(new FileReader("constitution.txt"));
			String currline = null;
			while ((currline = reader.readLine()) != null) {
				line++;
				String[] words = currline.split(" +");
				if (words.length == 1) {
					if (!words[0].equals("")) word += words.length;
				}
				else {
					word += words.length;
				}
				charbyte += currline.getBytes().length;
				
				//System.out.println(currline.split(" "));
			}
			
			System.out.println(line + " " + word + " " + charbyte);
			reader.close();
			
		}
		catch (IOException e) {
			e.printStackTrace();
		}
	}
	
}

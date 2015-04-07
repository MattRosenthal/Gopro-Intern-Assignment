import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashSet;

public class ConstitutionReader {
	
	public static void main(String args[]) {
		int line = 0;
		int word = 0; 
		long charbyte = 0;
		
		int pline = 0;
		int pword = 0;
		long pcharbyte = 0;
		
		HashSet<String> ignore = new HashSet<String>();
		String list = "I We You They a and the that of for with";
		for (String s : list.split(" ")) {
			ignore.add(s);
		}
		
		try {
			File file = new File("constitution.txt");
			charbyte = file.length();
			
			BufferedReader reader = new BufferedReader(new FileReader(file));
			String currline = null;
			
			while ((currline = reader.readLine()) != null) {
				line++;
				String[] words = currline.split(" +");
				
				if (words.length == 1) {
					if (!words[0].equals("")) {
						word += words.length;
						if (!ignore.contains(words[0])) {
							pword++;
							pcharbyte += words[0].length();
						}
					}
				}
				else {
					word += words.length;
					for (String tok : words) {
						tok = tok.replaceAll("[^a-zA-Z]", "");
						if (!ignore.contains(tok)) {
							pword++;
						}
						else {
							pcharbyte += tok.length();
						}
					}
				}
			}
			
			System.out.println("all: " + line + " " + word + " " + charbyte);
			System.out.println("proper: " + pword + " " + (charbyte - pcharbyte));
			reader.close();
			
		}
		catch (IOException e) {
			e.printStackTrace();
		}
	}
	
}

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class ConstitutionReader {
	
	public static void main(String args[]) {
		int word, line, character = 0;
		
		try {
			BufferedReader reader = new BufferedReader(new FileReader(args[0]));
			
			
		}
		catch (IOException e) {
			e.printStackTrace();
		}
	}
	
}

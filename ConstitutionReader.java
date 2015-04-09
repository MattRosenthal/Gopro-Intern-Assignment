/**
 * ConstitutionReader: A Java class to parse the U.S. Constitution
 * @author mattrosenthal
 * @usage  javac ConstitutionReader.java
 * 		   java  ConstitutionReader constitution.txt
 * 
 * */

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashSet;
import java.util.TreeMap;

public class ConstitutionReader {
	
	/**
	 * Main. Takes in text file as input and outputs
	 * equivalent to calling wc $filename from bash.
	 * Also outputs adjusted wc for ignored words
	 * and article and section count.
	 * 
	 * @param args[0] filename to be processed
	 * @throws IOException
	 * 
	 * */
	public static void main(String args[]) {
		int line = 0;
		int word = 0; 
		long charbyte = 0;
		
		int pword = 0;
		long pcharbyte = 0;
		
		int article = 0;
		int section = 0;
		int sectionTotal = 0;
		
		/**
		 * Set of ignored words. Capitalization matters here
		 * so add any additional variation of desired words to "list"
		 * */
		HashSet<String> ignore = new HashSet<String>();
		String list = "I We You They a and the that of for with";
		for (String s : list.split(" ")) {
			ignore.add(s);
		}
		
		/**
		 * TreeMap to keep track of number of articles and sections per article
		 * */
		TreeMap<Integer, Integer> artsec = new TreeMap<Integer, Integer>();
		
		try {
			File file = new File(args[0]);
			charbyte = file.length();
			
			BufferedReader reader = new BufferedReader(new FileReader(file));
			String currline = null;
			
			// Read every line of document
			while ((currline = reader.readLine()) != null) {
				line++;
				String[] words = currline.split(" +");
				
				// Check for empty array
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
					
					// Keep running count of articles and sections
					if (words[0].equals("Article") && words.length == 2) {
						section = 0;
						article++;
						artsec.put(article, section);						
					}
					
					if (words[0].equals("Section")) {
						section++;
						sectionTotal++;
						artsec.put(article, section);
					}
					
					// Check for ignored word. Total bytecount reduced by length of word if ignored
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
			
			System.out.println("all: " + line + " " + word + " " + charbyte + " " + file.getName());
			System.out.println("proper: " + line + " " + pword + " " + (charbyte - pcharbyte));
			System.out.println("Total Articles: " + artsec.size());
			System.out.println("Total Sections: " + sectionTotal);
			System.out.println("Total Sections Per Article:");
			for (int i = 1; i <= article; i++) {
				System.out.println("	Article " + i + ": " + artsec.get(i));
			}
			reader.close();	
		}
		
		catch (IOException e) {
			e.printStackTrace();
		}
	}	
}

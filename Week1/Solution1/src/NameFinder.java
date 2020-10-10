import java.io.BufferedReader;
import java.net.*;
import java.io.*;


public class NameFinder {

  public static void readPage(String ID) throws Exception{
      URL url = new URL("https://www.ecs.soton.ac.uk/people/" + ID);
      BufferedReader webpage = new BufferedReader(new InputStreamReader(url.openStream()));
      String line = "";
      for (int i = 0; i < 20; i++) {
        line = webpage.readLine();
        if (line == null) {
          System.out.println("Invalid Entry.");
          System.exit(0);
        } else if (line.contains("Professor")) {
          Integer name_start = line.indexOf(">");
          Integer name_end = line.indexOf(" |");
          System.out.println(line.substring(name_start+1, name_end));
        }
      }
  }

  public static void main(String[] args) throws Exception {
    System.out.println("Enter a Soton ID: ");
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    String ID = br.readLine();
    readPage(ID);
  }
}

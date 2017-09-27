package TestCases;

import org.testng.annotations.AfterClass;

import java.io.BufferedReader;
import java.io.InputStreamReader;

/**
 * Created by levon on 7/22/17.
 */
public class ExecuteShellCommand {



   //in windows
   //String command = "ping -n 3 " + domainName;



   //System.out.println(output);



   public String executeCommand(String command) {

      StringBuffer output = new StringBuffer();


      String s;
      Process p;
      try {
         p = Runtime.getRuntime().exec(command);
         BufferedReader br = new BufferedReader(
                 new InputStreamReader(p.getInputStream()));
         while ((s = br.readLine()) != null)
            System.out.println("line: " + s);
         p.waitFor();
         System.out.println ("exit: " + p.exitValue());
         p.destroy();
      } catch (Exception e) {
         e.printStackTrace();
      }

      return output.toString();

}



}

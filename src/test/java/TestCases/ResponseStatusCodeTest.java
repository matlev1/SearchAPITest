package TestCases;

import SearchAPI.SearchObject;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.AfterTest;
import org.testng.annotations.Test;

import static org.testng.Assert.*;

/**
 * Created by levon on 4/11/16.
 */
public class ResponseStatusCodeTest
{
   @Test
   public void responseTermCountry()
   {
      SearchObject request = new SearchObject("https://itunes.apple.com/search?term=bobmarley&country=us");
      assertEquals(200, request.responseCode, "Verify that response code is 200");
   }

   @Test
   public void responseTermCountryMedia()
   {
      SearchObject request = new SearchObject("https://itunes.apple.com/search?term=bobmarley&country=us&media=movie");
      assertEquals(200, request.responseCode, "Verify that status code is 200");
   }

   @Test
   public void responseTermCountryMedialimit()
   {
      SearchObject request = new SearchObject("https://itunes.apple.com/search?term=bobmarley&country=us&media=movie&limit=10");
      assertEquals(200, request.responseCode, "Verify that status code is 200");
   }


  /* @AfterClass
   public void RunReport() throws InterruptedException {
      ExecuteShellCommand shellCommand = new ExecuteShellCommand();
      //shellCommand.executeCommand();
      Thread.sleep(7000);
      //shellCommand.executeCommand("brew install allure");

      shellCommand.executeCommand("allure serve target/surefire-report");
      System.out.println("Wha thte fuck for real !");

      //System.out.println(shellCommand.executeCommand("allure serve Desktop/IdeaProjects/SearchAPITest/target/surefire-reports"));
   }*/
}

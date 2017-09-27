package TestCases;

import SearchAPI.SearchObject;
import org.aspectj.lang.annotation.After;
import org.testng.annotations.AfterClass;
import org.testng.annotations.Test;

import static org.testng.Assert.*;

//Created by levon on 4/11/16.


public class LimitCountTest
{
   @Test
   public void testLimitCount20()
   {
      SearchObject request = new SearchObject("https://itunes.apple.com/search?term=michael-jackson&limit=20");
      assertEquals(request.resultCount, 20, "Verify the number of returned results is 20");
   }

   @Test
   public void testLimit200() {
      SearchObject request = new SearchObject("https://itunes.apple.com/search?term=abba&limit=200");
      assertEquals(request.resultCount, 200, "Verify not more then 200 results returned");
   }

   @Test
   public void testLimit1() {
      SearchObject request = new SearchObject("https://itunes.apple.com/search?term=abba&limit=1");
      assertEquals(request.resultCount, 1, "Verify requested number of results returned");
   }

   @Test
   public void TestDefaultLimit() {
      SearchObject request = new SearchObject("https://itunes.apple.com/search?term=abba");
      assertEquals(request.resultCount, 50, "Verify default limit is 50");
   }

   @Test
   public void TestLimit0_Negative() {
      SearchObject request = new SearchObject("https://itunes.apple.com/search?term=abba");
      assertNotEquals(request.resultCount, 0, "Verify 0 accepted as input");
   }



}

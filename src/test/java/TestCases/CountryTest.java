package TestCases;

//import static org.junit.Assert.assertEquals;
//import org.junit.Test;

import SearchAPI.SearchObject;
import org.testng.annotations.Test;
import static org.testng.Assert.assertEquals;

// Created by levon on 4/7/16.


public class CountryTest
{
   @Test
   public void testDefaultCountry()
   {
      SearchObject request = new SearchObject("https://itunes.apple.com/search?term=abba&limit=10");
      for (int i = 0; i < request.countryArrayList.size(); i++)
      {
         assertEquals( "SA", request.countryArrayList.get(i), "Verify country of origin is US in all results");
      }
   }

   @Test
   public void ValidCountryGBR()
   {
      SearchObject request = new SearchObject("https://itunes.apple.com/search?term=abba&country=gb");
      for (int i = 0; i < request.countryArrayList.size(); i++)
      {
         assertEquals("GBR", request.countryArrayList.get(i), "Verify country of origin is GRB in all results");
      }
   }

   @Test
   public void ValidCountryARM()
   {
      SearchObject request = new SearchObject("https://itunes.apple.com/search?term=abba&country=am");
      for (int i = 0; i < request.countryArrayList.size(); i++)
      {
         assertEquals("ARM", request.countryArrayList.get(i), "Verify country of origin is ARM in all results");
      }
   }

   @Test
   public void invalidCountryNegative()
   {
      SearchObject request = new SearchObject("https://itunes.apple.com/search?term=abba&country=uk");
      assertEquals(400, request.responseCode, "response code is 400");
   }
}

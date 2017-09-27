package TestCases;

import SearchAPI.SearchObject;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.AfterReturning;
import org.testng.annotations.*;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

// Created by levon on 7/15/16.


public class MediaTest {

   @Test
   public void testDefaultMovie()
   {
      SearchObject request = new SearchObject("https://itunes.apple.com/search?term=Rome&limit=20");

         if (request.mediaArrayList.contains("song") && request.mediaArrayList.contains("tv-episode"))
         {
            System.out.println("Pass");
         }
         else
         {
            assertEquals(request.mediaArrayList, "song", "Verify 'song' is contain in all results");
            assertEquals(request.mediaArrayList, "tv-episode", "Verify 'tv-episode' is contain in all results");
            System.out.println("Fail");
            //break;
         }
         //assertEquals("tv-episode, song", request.mediaArrayList.get(i), "Verify default media is 'song' if the search term is a band");
         //request.mediaArrayList.get(i).contains("song");
   }

   @Test
   public void testDefaultMusicBand()
   {
      SearchObject request = new SearchObject("https://itunes.apple.com/search?term=Sting&limit=20");

      if (request.mediaArrayList.contains("song") && request.mediaArrayList.contains("feature-movie"))
      {
         System.out.println("Pass");
      }
      else
      {
         assertEquals(request.mediaArrayList, "song", "Verify 'song' is contain in all results");
         assertEquals(request.mediaArrayList, "feature-movie", "Verify 'tv-episode' is contain in all results");
         System.out.println("Fail");
      }
   }

   @Test
   public void testDefaultSong()
   {
      SearchObject request = new SearchObject("https://itunes.apple.com/search?term=Erth+Song&limit=20");

      if (request.mediaArrayList.contains("song")) //&& request.mediaArrayList.contains("feature-movie"))
      {
         System.out.println("Pass");
      }
      else
      {
         assertEquals(request.mediaArrayList, "song", "Verify 'song' is contain in all results");
         //assertEquals(request.mediaArrayList, "feature-movie", "Verify 'tv-episode' is contain in all results");
         System.out.println("Fail");
      }
   }

   @Test
   public void testMovieMedia()
   {
      SearchObject request = new SearchObject("https://itunes.apple.com/search?term=Rome&limit=5&media=movie");

      for (int i = 0; i < request.mediaArrayList.size(); i++)
      {
         assertEquals("feature-movie", request.mediaArrayList.get(i), "Verify all results' media is 'feature-movie'");
      }

   }

   @Test
   public void testEbookMedia()
   {
      SearchObject request = new SearchObject("https://itunes.apple.com/search?term=Rome&limit=5&media=ebook");

      for (int i = 0; i < request.mediaArrayList.size(); i++)
      {
         assertEquals("ebook", request.mediaArrayList.get(i), "Verify all results' media is 'ebook'");
      }

   }

   @Test
   public void testGenreBasedOnMedia()
   {
      SearchObject request = new SearchObject("https://itunes.apple.com/search?term=Rome&limit=5&media=ebook");

      for (int i = 0; i < request.genreArrayList.size(); i++)
      {
         assertTrue(request.genreArrayList.toString().contains("History"), "Verify 'History' is included as genre");
      }

   }

   @Test
   public void testAudiobookMedia()
   {
      SearchObject request = new SearchObject("https://itunes.apple.com/search?term=Rome&limit=5&media=audiobook");

      for (int i = 0; i < request.wrapperTypeArrayList.size(); i++)
      {
         assertEquals("audiobook", request.wrapperTypeArrayList.get(i), "Verify all results' media is 'audiobook'");
         System.out.println(request.wrapperTypeArrayList.get(i) + " Here I am ");
      }

   }

   @Test
   public void testPodCastMedia()
   {
      SearchObject request = new SearchObject("https://itunes.apple.com/search?term=New+Earth&limit=5&media=podcast");

      for (int i = 0; i < request.mediaArrayList.size(); i++)
      {
         assertEquals("podcast", request.mediaArrayList.get(i), "Verify all results' media is 'podcast'");
      }
   }

   @Test
   public void testSoftwareMedia()
   {
      SearchObject request = new SearchObject("https://itunes.apple.com/search?term=New+Earth&limit=5&media=software");

      for (int i = 0; i < request.mediaArrayList.size(); i++)
      {
         assertEquals("software", request.mediaArrayList.get(i), "Verify all results' media is 'software'");
      }
   }

   @Test
   public void testTvShowMedia()
   {
      SearchObject request = new SearchObject("https://itunes.apple.com/search?term=New+Earth&limit=5&media=tvShow");

      for (int i = 0; i < request.mediaArrayList.size(); i++)
      {
         assertEquals("tv-episode", request.mediaArrayList.get(i), "Verify all results' media is 'tv-episode'");
      }
   }

   @Test
   public void testShortFilmMedia()
   {
      SearchObject request = new SearchObject("https://itunes.apple.com/search?term=for+the+birds&limit=5&media=shortFilm");

      for (int i = 0; i < request.mediaArrayList.size(); i++)
      {
         assertEquals("feature-movie", request.mediaArrayList.get(i), "Verify all results' media is 'feature-movie'");
      }

   }


}

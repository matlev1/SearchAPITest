package SearchAPI;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.ArrayList;

import org.json.JSONArray;
import org.json.JSONObject;
/**
 * Created by levon on 4/7/16.
 */
public class SearchObject
{
   public JSONObject response;
   public int responseCode, resultCount;

   //public String mediaType;
   public ArrayList<String> countryArrayList = new ArrayList<String>();
   public ArrayList<String> mediaArrayList = new ArrayList<String>();
   public ArrayList<String> wrapperTypeArrayList = new ArrayList<String>();
   public ArrayList<String> genreArrayList = new ArrayList<String>();

   public SearchObject (String url)
   {
      this.response = getResponse(url);
   }

   public JSONObject getResponse(String URLName)
   {
      try
      {
         HttpURLConnection.setFollowRedirects(true);
         HttpURLConnection con = (HttpURLConnection) new URL(URLName).openConnection();
         con.setRequestMethod("GET");
         responseCode = con.getResponseCode();

         if (responseCode == 200)
         {
            BufferedReader br = new BufferedReader(new InputStreamReader(con.getInputStream()));
            String inputLine;
            StringBuffer response = new StringBuffer();

            while((inputLine = br.readLine()) != null)
            {
               response.append(inputLine);
            }
            br.close();
            JSONObject obj = new JSONObject(response.toString());
            resultCount = (Integer) obj.get("resultCount");
            //mediaType = (String) obj.get("mediaType");

            JSONArray results = (JSONArray) obj.get("results");

            for (int i = 0; i < results.length(); i++)
            {
               JSONObject eachResult = (JSONObject) results.get(i);
               //System.out.println(eachResult.toString().contains("country"));

               //eachResult.toString().contains("country")
               if (eachResult.toString().contains("country"))
               {
                  String country = eachResult.getString("country");
                  countryArrayList.add(country);
               }
               else
               {
                  //System.out.println("There is no 'country'");
               }

               if (eachResult.toString().contains("kind"))
               {
                  String media = eachResult.getString("kind");
                  mediaArrayList.add(media);
               }
               else
               {
                  System.out.println("There is no 'kind'");
               }

               if (eachResult.toString().contains("wrapperType"))
               {
                  String wrapperType = eachResult.getString("wrapperType");
                  wrapperTypeArrayList.add(wrapperType);
               }
               else
               {
                  System.out.println("There is no 'wrapperType'");
               }

               if (eachResult.toString().contains("genres"))
               {
                  JSONArray genresEachResult = eachResult.getJSONArray("genres");

                  for (int j = 0; j < genresEachResult.length(); j++)
                  {
                     String genreType = genresEachResult.getString(j);
                     genreArrayList.add(genreType);
                     //System.out.println("There is Genre: " + genreArrayList.toString());
                  }
               }
               else
               {
                  //System.out.println("There is no 'genres' " + genreArrayList.toString());
               }
            }



           /* JSONArray media = (JSONArray) obj.get("media");

            for (int i = 0; i < media.length(); i++)
            {
               JSONObject eachMedia = (JSONObject) media.get(i);
            }*/
            return obj;
         }
      }
      catch (Exception e)
      {
         e.printStackTrace();
      }
      JSONObject obj = new JSONObject("{'EMPTY RESPONSE':0}");
      return obj;
   }
}

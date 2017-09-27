package SearchAPI;

/**
 * Created by levon on 4/7/16.
 */
public class SearchAPI
{
   public static  String url = "http://itunes.apple.com/search?term=New+Earth&limit=5&media=podcast";

   public static void main(String[] args)
   {
      SearchObject request = new SearchObject(url);

     /* System.out.println(request.resultCount);
      System.out.println(request.responseCode);
      System.out.println(request.countryArrayList.toString());
      System.out.println(request.mediaArrayList.toString());
      System.out.println(request.genreArrayList.toString());
      System.out.println(request.response.toString(2));*/




   }

}



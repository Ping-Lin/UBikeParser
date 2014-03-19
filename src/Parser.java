import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import com.google.gson.stream.JsonReader;
import java.util.ArrayList;

public class Parser {
	
	 public ArrayList<StationData> readJsonStream(InputStream in) throws IOException {
	     JsonReader reader = new JsonReader(new InputStreamReader(in, "UTF-8"));
	     ArrayList<StationData> tmp;
	     try {
	    	 tmp = readretVal(reader);
	    	 return tmp;
	     } finally {
	    	 reader.close();
	     }
	 }

	 public ArrayList<StationData> readretVal(JsonReader reader) throws IOException {
		 ArrayList<StationData> data = new ArrayList<StationData>();
		 String name;
		 reader.beginObject();
		 while(reader.hasNext()){
			 name = reader.nextName();
			 if(name.equals("retVal")){
				 data = readretValArray(reader, data);
			 }
			 else
				 reader.skipValue();
		 }
		 reader.endObject();
		 return data;
		 
	 }
	 public ArrayList<StationData> readretValArray(JsonReader reader, ArrayList<StationData> data) throws IOException {
		 reader.beginArray();
	     while (reader.hasNext()) {
	    	 data.add(readData(reader));
	     }
	     reader.endArray();
	     return data;
	 }

	 public StationData readData(JsonReader reader) throws IOException {
		 int iid = -1;
		 String sna = null;
		 String snaen = null;
		 int tot = -1;
		 int sbi = -1;
		 String mday = null;
		 double lat = 0.0f;
		 double lng = 0.0f;
		 int nbcnt = -1;
		 int bemp = -1;
		   
		 String name;
		 reader.beginObject();
	     while (reader.hasNext()){
		   name = reader.nextName();
		   if(name.equals("iid")){
			   iid = reader.nextInt();
		   }
		   else if(name.equals("sna")){
			   sna = reader.nextString();
		   }
		   else if(name.equals("tot")){
			   tot = reader.nextInt();
		   }
		   else if(name.equals("sbi")) {
			   sbi = reader.nextInt();
		   }
		   else if(name.equals("mday")){
			   mday = reader.nextString();
		   }
		   else if(name.equals("lat")){
			   lat = reader.nextDouble();
		   }
		   else if(name.equals("lng")){
			   lng = reader.nextDouble();
		   }
		   else if(name.equals("snaen")){
			   snaen = reader.nextString();
		   }
		   else if(name.equals("nbcnt")){
			   nbcnt = reader.nextInt();
		   }
		   else if(name.equals("bemp")){
			   bemp = reader.nextInt();
		   }
		   else
			   reader.skipValue();
	     }
	     reader.endObject();
	     return new StationData(iid, sna, snaen, tot, sbi, mday, lat, lng, nbcnt, bemp);
	   }

}

import java.io.*;
import java.util.ArrayList;

public class UbikeJsonParser {

	public static void main(String[] args) {
		try {
			ArrayList<ArrayList<StationData>> data;
			ArrayList<StationData> tmp = new ArrayList<StationData>();
			InputStream in = new FileInputStream(new File("src/data/gwjs_cityhall.json"));
			Parser parser = new Parser();
			tmp = parser.readJsonStream(in);
			PrintStream ps = new PrintStream(new BufferedOutputStream(new FileOutputStream("data.csv", true)));
			PrintWriter out = new PrintWriter(ps, true);
			out.println("ItemId,場站名稱,場站英文名稱,場站的總停車格,場站的目前車輛數,資料更新時間(yyyyMMddhhmmss),經度,緯度,擋板數量,空位數量");
			for(StationData t: tmp)
				out.println(t.iid + "," + t.sna + "," + t.snaen + "," + t.tot + "," + t.sbi + "," + t.mday + "," + t.lat + "," + t.lng + "," + t.nbcnt + "," + t.bemp);
			out.close();
			ps.close();
			in.close();
		}
		catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

}
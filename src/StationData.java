
public class StationData {
	int iid;   //ItemId
	String sna;   //場站名稱
	String snaen;   //場站英文名稱
	int tot;   //場站的總停車格
	int sbi;   //場站的目前車輛數
	String mday;  //資料更新時間   yyyyMMddhhmmss
	double lat;   //經度
	double lng;   //緯度
	int nbcnt;   //擋板數量
	int bemp;   //空位數量
	
	/*
	 * Constructor
	 */
	public StationData(int iid, String sna, String snaen, int tot,  int sbi, String mday, double lat, double lng, int nbcnt, int bemp){
		this.iid = iid;
		this.sna = sna;
		this.snaen = snaen;
		this.tot = tot;
		this.sbi = sbi;
		this.mday = mday;
		this.lat = lat;
		this.lng = lng;
		this.nbcnt = nbcnt;
		this.bemp = bemp;
	}
}

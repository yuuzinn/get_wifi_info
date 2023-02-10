package DB;

import java.util.Date;

public class Wifi_History_Info {

	private int id;
	private String X;
	private String Y;
	private String read_date;
	
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getX() {
		return X;
	}
	public void setX(String x) {
		X = x;
	}
	public String getY() {
		return Y;
	}
	public void setY(String y) {
		Y = y;
	}
	public String getRead_date() {
		return read_date;
	}
	public void setRead_date(String read_date) {
		this.read_date = read_date;
	}
	
	@Override
	public String toString() {
		return "Wifi_History_Info [id=" + id + ", X=" + X + ", Y=" + Y + ", read_date=" + read_date + "]";
	}
	
	public Wifi_History_Info(int id, String x, String y, String read_date) {
		super();
		this.id = id;
		X = x;
		Y = y;
		this.read_date = read_date;
	}
	
	public Wifi_History_Info() {}
	
	
	
	

}

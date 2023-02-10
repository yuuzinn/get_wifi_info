package DB;

import java.util.Date;

public class Wifi_Info {

	private Double km; // 거리
	private String no; // 관리번호
	private String gu; // 자치구
	private String wifi_name; // 와이파이명
	private String road_address; // 도로명주소
	private String detail_address; // 상세주소
	private String floor; // 설치위치(층)
	private String install_type; // 설치유형
	private String center; // 설치기관
	private String service; // 서비스구분
	private String net_type; // 망종류
	private int install_year; // 설치년도
	private String in_out; // 실내외구분
	private String wifi_env; // 와이파이접속환경
	private Double Y_crood; // Y좌표
	private Double X_crood; // X좌표
	private String date; // 작업일자
	
	public double getKm() {
		return km;
	}
	public void setKm(double km) {
		this.km = km;
	}
	public String getNo() {
		return no;
	}
	public void setNo(String no) {
		this.no = no;
	}
	public String getGu() {
		return gu;
	}
	public void setGu(String gu) {
		this.gu = gu;
	}
	public String getWifi_name() {
		return wifi_name;
	}
	public void setWifi_name(String wifi_name) {
		this.wifi_name = wifi_name;
	}
	public String getRoad_address() {
		return road_address;
	}
	public void setRoad_address(String road_address) {
		this.road_address = road_address;
	}
	public String getDetail_address() {
		return detail_address;
	}
	public void setDetail_address(String detail_address) {
		this.detail_address = detail_address;
	}
	public String Date() {
		return floor;
	}
	public void setFloor(String floor) {
		this.floor = floor;
	}
	public String Service() {
		return install_type;
	}
	public void setInstall_type(String install_type) {
		this.install_type = install_type;
	}
	public String getCenter() {
		return center;
	}
	public void setCenter(String center) {
		this.center = center;
	}
	public String getService() {
		return service;
	}
	public void setService(String service) {
		this.service = service;
	}
	public String getNet_type() {
		return net_type;
	}
	public void setNet_type(String net_type) {
		this.net_type = net_type;
	}
	public int getInstall_year() {
		return install_year;
	}
	public void setInstall_year(int install_year) {
		this.install_year = install_year;
	}
	public String getIn_out() {
		return in_out;
	}
	public void setIn_out(String in_out) {
		this.in_out = in_out;
	}
	public String getFloor() {
		return floor;
	}
	public String getInstall_type() {
		return install_type;
	}
	public String getWifi_env() {
		return wifi_env;
	}
	public void setWifi_env(String wifi_env) {
		this.wifi_env = wifi_env;
	}
	public Double getY_crood() {
		return Y_crood;
	}
	public void setY_crood(Double y_crood) {
		Y_crood = y_crood;
	}
	public Double getX_crood() {
		return X_crood;
	}
	public void setX_crood(Double x_crood) {
		X_crood = x_crood;
	}
	public String getDate() {
		return date;
	}
	public void setDate(String date) {
		this.date = date;
	}
	
	
	@Override
	public String toString() {
		return "Wifi_Info [km=" + km + ", no=" + no + ", gu=" + gu + ", wifi_name=" + wifi_name + ", road_address="
				+ road_address + ", detail_address=" + detail_address + ", floor=" + floor + ", install_type="
				+ install_type + ", center=" + center + ", service=" + service + ", net_type=" + net_type
				+ ", install_year=" + install_year + ", in_out=" + in_out + ", wifi_env=" + wifi_env + ", Y_crood="
				+ Y_crood + ", X_crood=" + X_crood + ", date=" + date + "]";
	}
	
	public Wifi_Info(double km, String no, String gu, String wifi_name, String road_address, String detail_address,
			String floor, String install_type, String center, String service, String net_type, int install_year,
			String in_out, String wifi_env, Double y_crood, Double x_crood, String date) {
		super();
		this.km = km;
		this.no = no;
		this.gu = gu;
		this.wifi_name = wifi_name;
		this.road_address = road_address;
		this.detail_address = detail_address;
		this.floor = floor;
		this.install_type = install_type;
		this.center = center;
		this.service = service;
		this.net_type = net_type;
		this.install_year = install_year;
		this.in_out = in_out;
		this.wifi_env = wifi_env;
		Y_crood = y_crood;
		X_crood = x_crood;
		this.date = date;
	}
	
	public Wifi_Info() {}
	
	
	

}

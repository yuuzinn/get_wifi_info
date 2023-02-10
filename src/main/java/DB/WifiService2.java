package DB;

import java.net.URLEncoder;
import java.sql.*;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.stream.Collectors;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

import DB.Wifi_Info;

public class WifiService2 {

	// 거리가 가장 가까운 순으로 20개 출력
	public List<Wifi_Info> wifiSelect20(double x, double y) {
		System.out.print(x + " : " + y);
		List<Wifi_Info> list = new ArrayList<>();
		List<Wifi_Info> result = new ArrayList<>();
		String url = "jdbc:mariadb://220.86.74.248:3306/testdb2";
		String dbUserId = "testuser1";
		String dbPassword = "1111";

		try {
			Class.forName("org.mariadb.jdbc.Driver");
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}

		Connection connection = null; // 통로
		PreparedStatement preparedStatement = null; // sql 문
		ResultSet rs = null; // select 한 결과값을 가져오는 객체

		try {

			connection = DriverManager.getConnection(url, dbUserId, dbPassword);

			Statement statement = connection.createStatement();

			String sql = " SELECT * FROM test22 ";

			// 도착
			preparedStatement = connection.prepareStatement(sql);
			rs = preparedStatement.executeQuery();

			while (rs.next()) {
				Wifi_Info kmWifi20 = new Wifi_Info();
				kmWifi20.setNo(rs.getString("no"));
				kmWifi20.setGu(rs.getString("gu"));
				kmWifi20.setWifi_name(rs.getString("wifi_name"));
				kmWifi20.setRoad_address(rs.getString("road_address"));
				kmWifi20.setDetail_address(rs.getString("detail_address"));
				kmWifi20.setFloor(rs.getString("floor"));
				kmWifi20.setInstall_type(rs.getString("install_type"));
				kmWifi20.setCenter(rs.getString("center"));
				kmWifi20.setService(rs.getString("service"));
				kmWifi20.setNet_type(rs.getString("net_type"));
				kmWifi20.setInstall_year(rs.getInt("install_year"));
				kmWifi20.setIn_out(rs.getString("in_out"));
				kmWifi20.setWifi_env(rs.getString("wifi_env"));
				kmWifi20.setX_crood(rs.getDouble("X_crood"));
				kmWifi20.setY_crood(rs.getDouble("Y_crood"));
				kmWifi20.setDate(rs.getString("date"));
				list.add(kmWifi20);
			}

			for (Wifi_Info i : list) {
				Double dis = distance(x, y, i.getX_crood(), i.getY_crood());
				i.setKm(dis);

			}

			list.sort((o1, o2) -> (int) (o1.getKm() - o2.getKm()));

			for (int i = 0; i < 20; i++) {
				result.add(list.get(i));

			}

		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				if (rs != null && !rs.isClosed()) {
					rs.close();
				}
			} catch (SQLException e) {
				e.printStackTrace();
			}
			try {
				if (preparedStatement != null && !preparedStatement.isClosed()) {
					preparedStatement.close();
				}
			} catch (SQLException e) {
				e.printStackTrace();
			}
			try {
				if (connection != null && !connection.isClosed()) {
					connection.close();
				}
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return result;
	}
	// insert
	public List<Wifi_Info> wifiInsert(List<Wifi_Info> data) {

		List<Wifi_Info> list = new ArrayList<>();

		String url = "jdbc:mariadb://220.86.74.248:3306/testdb2";
		String dbUserId = "testuser1";
		String dbPassword = "1111";

		try {
			Class.forName("org.mariadb.jdbc.Driver");
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}

		Connection connection = null; // 통로
		PreparedStatement preparedStatement = null; // sql 문

		try {

			connection = DriverManager.getConnection(url, dbUserId, dbPassword);
			connection.setAutoCommit(true);
			Statement statement = connection.createStatement();

			String sql = "INSERT INTO testdb2.test22 (no, gu, wifi_name, road_address, detail_address, floor, install_type, center, service, net_type, install_year, in_out, wifi_env, Y_crood, X_crood, date) "
					+ "VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";

			// 도착
			preparedStatement = connection.prepareStatement(sql);
			for (int i = 0; i < data.size(); i++) {

				preparedStatement.setString(1, data.get(i).getNo());
				preparedStatement.setString(2, data.get(i).getGu());
				preparedStatement.setString(3, data.get(i).getWifi_name());
				preparedStatement.setString(4, data.get(i).getRoad_address());
				preparedStatement.setString(5, data.get(i).getDetail_address());
				preparedStatement.setString(6, data.get(i).getFloor());
				preparedStatement.setString(7, data.get(i).getInstall_type());
				preparedStatement.setString(8, data.get(i).getCenter());
				preparedStatement.setString(9, data.get(i).getService());
				preparedStatement.setString(10, data.get(i).getNet_type());
				preparedStatement.setDouble(11, data.get(i).getInstall_year());
				preparedStatement.setString(12, data.get(i).getIn_out());
				preparedStatement.setString(13, data.get(i).getWifi_env());
				preparedStatement.setDouble(14, data.get(i).getY_crood());
				preparedStatement.setDouble(15, data.get(i).getX_crood());
				preparedStatement.setString(16, data.get(i).getDate());
				preparedStatement.addBatch();
				preparedStatement.clearParameters();

			}

			preparedStatement.executeBatch();
			connection.commit();

		} catch (SQLException e) {
			e.printStackTrace();
		} finally {

			try {
				if (preparedStatement != null && !preparedStatement.isClosed()) {
					preparedStatement.close();
				}
			} catch (SQLException e) {
				e.printStackTrace();
			}
			try {
				if (connection != null && !connection.isClosed()) {
					connection.close();
				}
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return list;

	}

	public static String getTagValue(String tag, Element eElement) {

		// 결과를 저장할 result 변수 선언
		String result = "";

		NodeList nlList = eElement.getElementsByTagName(tag).item(0).getChildNodes();
		if (nlList.item(0) == null) {
			return null;
		}
		result = nlList.item(0).getTextContent();

		return result;
	}
	//count 메서드
	public String parseCount() {

		String count = "0";
		try {
			// parsing할 url 지정(API 키 포함해서)
			StringBuilder urlBuilder = new StringBuilder("http://openapi.seoul.go.kr:8088"); /* URL */
			urlBuilder.append("/" + URLEncoder.encode("424f546a747331313130386244426844",
					"UTF-8")); /* 인증키 (sample사용시에는 호출시 제한됩니다.) */
			urlBuilder.append("/" + URLEncoder.encode("xml", "UTF-8")); /* 요청파일타입 (xml,xmlf,xls,json) */
			urlBuilder.append("/" + URLEncoder.encode("TbPublicWifiInfo", "UTF-8")); /* 요청파일타입 (xml,xmlf,xls,json) */
			urlBuilder.append("/" + URLEncoder.encode("1", "UTF-8")); /* 요청파일타입 (xml,xmlf,xls,json) */
			urlBuilder.append("/" + URLEncoder.encode("1", "UTF-8")); /* 요청파일타입 (xml,xmlf,xls,json) */
			System.out.println("urlBuilder.toString() = " + urlBuilder.toString());
			// 요청할 url 만들기
			DocumentBuilderFactory dbFactoty = DocumentBuilderFactory.newInstance();
			DocumentBuilder dBuilder = dbFactoty.newDocumentBuilder();
			Document doc = dBuilder.parse(urlBuilder.toString());

			// 제일 첫번째 태그
			doc.getDocumentElement().normalize();

			// 파싱할 tag
			NodeList nList = doc.getElementsByTagName("list_total_count");
			Node nNode = nList.item(0);

			count = nNode.getTextContent();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return count;
	}

	public String dowonLoadAction() {
		String count = parseCount();
		List<Wifi_Info> data = parseData();
		wifiInsert(data);
		return count;
	}
	// data 불러오기
	public List<Wifi_Info> parseData() {
		int count = 0;
		int min = 1;
		int max = 1000;
		List<Wifi_Info> result = new ArrayList<>();
		for (int i = 0; i < 20; i++) {
			try {
				// parsing할 url 지정(API 키 포함해서)
				StringBuilder urlBuilder = new StringBuilder("http://openapi.seoul.go.kr:8088"); /* URL */
				urlBuilder.append("/" + URLEncoder.encode("424f546a747331313130386244426844",
						"UTF-8")); /* 인증키 (sample사용시에는 호출시 제한됩니다.) */
				urlBuilder.append("/" + URLEncoder.encode("xml", "UTF-8")); /* 요청파일타입 (xml,xmlf,xls,json) */
				urlBuilder
						.append("/" + URLEncoder.encode("TbPublicWifiInfo", "UTF-8")); /* 요청파일타입 (xml,xmlf,xls,json) */
				urlBuilder
						.append("/" + URLEncoder.encode(String.valueOf(min), "UTF-8")); /* 요청파일타입 (xml,xmlf,xls,json) */
				urlBuilder
						.append("/" + URLEncoder.encode(String.valueOf(max), "UTF-8")); /* 요청파일타입 (xml,xmlf,xls,json) */
				// 요청할 url 만들기
				DocumentBuilderFactory dbFactoty = DocumentBuilderFactory.newInstance();
				DocumentBuilder dBuilder = dbFactoty.newDocumentBuilder();
				Document doc = dBuilder.parse(urlBuilder.toString());

				// 제일 첫번째 태그
				doc.getDocumentElement().normalize();

				// 파싱할 tag
				NodeList nList = doc.getElementsByTagName("row");

				for (int temp = 0; temp < nList.getLength(); temp++) {
					Node nNode = nList.item(temp);
					Element eElement = (Element) nNode;
					Wifi_Info data = new Wifi_Info();
					data.setNo(getTagValue("X_SWIFI_MGR_NO", eElement));
					data.setGu(getTagValue("X_SWIFI_WRDOFC", eElement));
					data.setWifi_name(getTagValue("X_SWIFI_MAIN_NM", eElement));
					data.setRoad_address(getTagValue("X_SWIFI_ADRES1", eElement));
					data.setDetail_address(getTagValue("X_SWIFI_ADRES2", eElement));
					data.setFloor(getTagValue("X_SWIFI_INSTL_FLOOR", eElement));
					data.setInstall_type(getTagValue("X_SWIFI_INSTL_TY", eElement));
					data.setCenter(getTagValue("X_SWIFI_INSTL_MBY", eElement));
					data.setService(getTagValue("X_SWIFI_SVC_SE", eElement));
					data.setNet_type(getTagValue("X_SWIFI_CMCWR", eElement));
					data.setInstall_year(Integer.parseInt(getTagValue("X_SWIFI_CNSTC_YEAR", eElement)));
					data.setIn_out(getTagValue("X_SWIFI_INOUT_DOOR", eElement));
					data.setWifi_env(getTagValue("X_SWIFI_REMARS3", eElement));
					data.setX_crood(Double.parseDouble(getTagValue("LNT", eElement)));
					data.setY_crood(Double.parseDouble(getTagValue("LAT", eElement)));
					data.setDate(getTagValue("WORK_DTTM", eElement));
					result.add(data);
					count++;
				}

				min = max + 1;
				max = max + 1000;
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		return result;
	}

	// 거리 계산
	private static double distance(double lat1, double lon1, double lat2, double lon2) {
		double theta = lon1 - lon2;
		double dist = Math.sin(deg2rad(lat1)) * Math.sin(deg2rad(lat2))
				+ Math.cos(deg2rad(lat1)) * Math.cos(deg2rad(lat2)) * Math.cos(deg2rad(theta));
		dist = Math.acos(dist);
		dist = rad2deg(dist);
		dist = dist * 60 * 1.1515 * 1609.344;

		return dist;
	}

	private static double deg2rad(double deg) {
		return (deg * Math.PI / 180.0);
	}

	private static double rad2deg(double rad) {
		return (rad * 180 / Math.PI);
	}
}

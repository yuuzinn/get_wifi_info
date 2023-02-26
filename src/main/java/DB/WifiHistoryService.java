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

public class WifiHistoryService {

	

	public List<Wifi_History_Info> historySelect() {
		List<Wifi_History_Info> list = new ArrayList<>();

		String url = "jdbc:mariadb://myIP:3306/testdb2";
		String dbUserId = "testuser1";
		String dbPassword = "1111";

		try {
			Class.forName("org.mariadb.jdbc.Driver");
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}

		Connection connection = null;
		PreparedStatement preparedStatement = null; // sql 문
		ResultSet rs = null;

		try {

			connection = DriverManager.getConnection(url, dbUserId, dbPassword);

			Statement statement = connection.createStatement();

			String sql = " SELECT * FROM history ";

			preparedStatement = connection.prepareStatement(sql);
			rs = preparedStatement.executeQuery();

			while (rs.next()) {
				Wifi_History_Info info = new Wifi_History_Info();
				info.setId(rs.getInt("id"));
				info.setX(rs.getString("X_his"));
				info.setY(rs.getString("Y_his"));
				info.setRead_date(rs.getString("read_date"));
				list.add(info);
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
		return list;
	}

	public void deleteHistory(int id) {

		String url = "jdbc:mariadb://myIP:3306/testdb2";
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

			Statement statement = connection.createStatement();

			String sql = "delete from testdb2.history where id= ?";
			// 도착
			preparedStatement = connection.prepareStatement(sql);
			preparedStatement.setDouble(1, id);

			preparedStatement.executeUpdate();

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
	}

	public void historyInsert(Double x, Double y) {

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

			Statement statement = connection.createStatement();

			String sql = "INSERT INTO testdb2.history (X_his,Y_his,read_date) " + "VALUES (?,?,now())";

			// 도착
			preparedStatement = connection.prepareStatement(sql);
			preparedStatement.setDouble(1, x);
			preparedStatement.setDouble(2, y);
			preparedStatement.executeUpdate();

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
	}

}

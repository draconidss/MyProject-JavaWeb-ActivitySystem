package Tool;

import java.sql.*;

public class DataClose {

	// 关闭连接方法,包括Statement的关闭
	public static void DataClose(ResultSet rs, Statement stmt, Connection conn) {
		try {
			if (rs != null)
				rs.close();
			if (stmt != null)
				stmt.close();
			if (conn != null)
				conn.close();
		} catch (final SQLException e) {
			e.printStackTrace();

		}

	}

	// 方法重载，包括PreparedStatement的关闭
	public static void DataClose(ResultSet rs, PreparedStatement pstmt,
			Connection conn) {
		try {
			if (rs != null)
				rs.close();
			if (pstmt != null)
				pstmt.close();
			if (conn != null)
				conn.close();
		} catch (final SQLException e) {
			e.printStackTrace();

		}

	}

	// 方法重载，包括PreparedStatement和Statement的关闭
	public static void DataClose(ResultSet rs, Statement stmt,
			PreparedStatement pstmt, Connection conn) {
		try {
			if (rs != null)
				rs.close();
			if (stmt != null)
				stmt.close();
			if (pstmt != null)
				pstmt.close();
			if (conn != null)
				conn.close();
		} catch (final SQLException e) {
			e.printStackTrace();

		}

	}
}

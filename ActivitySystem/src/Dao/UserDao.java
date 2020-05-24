package Dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Vector;

import Dto.ActivityDto;
import Dto.UserDto;
import Tool.DataAccess;
import Tool.DataClose;

public class UserDao {
	//通过用户名和密码登录
	public int UserLogin(String _uname,String _password ) {
			int flag = 0;
			Connection conn = null;
			PreparedStatement pstmt = null;
			ResultSet rs = null;
			try {
				conn = DataAccess.getConnection();
				pstmt = conn.prepareStatement("select * from User where deletemark = 1 and uname = ? and password = ?");
				pstmt.setString(1, _uname);
				pstmt.setString(2, _password);
				rs = pstmt.executeQuery();
				if (rs.next()) {
					flag = rs.getInt("sSuper");
					System.out.println("-----------------------------------------------------------用户信息----------------------------------------------------------");
					System.out.println("用户id" + "\t" + "用户姓名" + "\t" + "密码"+ "\t" + "权限" );
					System.out.print("#" + rs.getString("uid") + "\t");
					System.out.print(rs.getString("uname") + "\t  ");
					System.out.print(rs.getString("password") + "\t");
					System.out.println(rs.getString("sSuper") + "\t");
				} else
					System.out.println("记录不存在或密码错误!");
			} catch (SQLException e) {
				e.printStackTrace();
			} finally {
				DataClose.DataClose(rs, pstmt, conn);
			}
			return flag;
		}
		
	//查找所有用户
	public Vector<UserDto> AllUser( ) {
				Vector<UserDto> v = new Vector<UserDto>();
					Connection conn = null;
					PreparedStatement pstmt = null;
					ResultSet rs = null;
					try {
						conn = DataAccess.getConnection();
						pstmt = conn.prepareStatement("select * from User where deletemark = 1");
						rs = pstmt.executeQuery();
						while(rs.next()) {
							UserDto u = new UserDto();
							u.setUid(rs.getString("uid"));
							u.setUname(rs.getString("uname"));
							u.setPassword(rs.getString("password"));
							u.setsSuper(rs.getInt("sSuper"));
							v.add(u);						
							} 
					} catch (SQLException e) {
						e.printStackTrace();
					} finally {
						DataClose.DataClose(rs, pstmt, conn);
					}
					return v;
				}

	//查找所有被删除的用户
	public Vector<UserDto> AllDelUser( ) {
		Vector<UserDto> v = new Vector<UserDto>();
			Connection conn = null;
			PreparedStatement pstmt = null;
			ResultSet rs = null;
			try {
				conn = DataAccess.getConnection();
				pstmt = conn.prepareStatement("select * from User where deletemark = 0");
				rs = pstmt.executeQuery();
				while(rs.next()) {
					UserDto u = new UserDto();
					u.setUid(rs.getString("uid"));
					u.setUname(rs.getString("uname"));
					u.setPassword(rs.getString("password"));
					u.setsSuper(rs.getInt("sSuper"));
					v.add(u);						
					} 
			} catch (SQLException e) {
				e.printStackTrace();
			} finally {
				DataClose.DataClose(rs, pstmt, conn);
			}
			return v;
		}	
	//通过Uname查询，注册或更新的时候判断
	public boolean FindByUname( String _Uname) {
			boolean flag = false;
			Connection conn = null;
			PreparedStatement pstmt = null;
			ResultSet rs = null;
			try {
				conn = DataAccess.getConnection();
				pstmt = conn.prepareStatement("select * from User where   uname =?");
				pstmt.setString(1,_Uname);
				rs = pstmt.executeQuery();
				if(rs.next())
					flag = true;
			} catch (SQLException e) {
				e.printStackTrace();
			} finally {
				DataClose.DataClose(rs, pstmt, conn);
			}
			return flag;
		}
	
	//查找除Uname以外是否有同名的
	public boolean FindElseByUname( String _Uname) {
		boolean flag = false;
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		try {
			conn = DataAccess.getConnection();
			pstmt = conn.prepareStatement("select * from User where  uname !=?");
			pstmt.setString(1,_Uname);
			rs = pstmt.executeQuery();
			if(rs.next())
				flag = true;
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			DataClose.DataClose(rs, pstmt, conn);
		}
		return flag;
	}

	//更新用户表中的名字，密码和权限
	public boolean UpdateUser(UserDto u) {
			boolean flag = false;
			Connection conn = null;
			PreparedStatement pstmt = null;
			ResultSet rs = null;
			try {
				conn = DataAccess.getConnection();
				pstmt = conn
						.prepareStatement("update User set uname=?,password=?,sSuper=? where uid = ?");
				pstmt.setString(1, u.getUname());
				pstmt.setString(2, u.getPassword());
				pstmt.setInt(3, u.getsSuper());
				pstmt.setString(4, u.getUid());

				if (pstmt.executeUpdate() == 1)
					flag = true;
			} catch (SQLException e) {
				e.printStackTrace();
			} finally {
				DataClose.DataClose(rs, pstmt, conn);
			}
			return flag;

		}	
		
	//根据用户uid来删除用户
	public boolean DeleteUserByuid(UserDto u) {
			boolean flag = false;
			Connection conn = null;
			PreparedStatement pstmt = null;
			ResultSet rs = null;
			try {
				conn = DataAccess.getConnection();
				//
				pstmt = conn.prepareStatement("update User set deletemark = 0 where uid=?");
				pstmt.setString(1, u.getUid());
				if (pstmt.executeUpdate() == 1)// 删除成功后返回1
					flag = true;
			} catch (SQLException e) {
				e.printStackTrace();
			} finally {
				DataClose.DataClose(rs, pstmt, conn);
			}
			return flag;

		}
	//根据用户uid来删除用户
		public boolean DeleteUserByUname(UserDto u) {
				boolean flag = false;
				Connection conn = null;
				PreparedStatement pstmt = null;
				ResultSet rs = null;
				try {
					conn = DataAccess.getConnection();
					//
					pstmt = conn.prepareStatement("update User set deletemark = 0 where uname=?");
					pstmt.setString(1, u.getUname());
					if (pstmt.executeUpdate() == 1)// 删除成功后返回1
						flag = true;
				} catch (SQLException e) {
					e.printStackTrace();
				} finally {
					DataClose.DataClose(rs, pstmt, conn);
				}
				return flag;

			}	
	//根据用户uid来批量删除用户
	public boolean DeleteUserByaid(String sql) {
				boolean flag = false;
				Connection conn = null;
				PreparedStatement pstmt = null;
				ResultSet rs = null;
				try {
					conn = DataAccess.getConnection();
					//
					pstmt = conn.prepareStatement("update User set deletemark = 0 where uid in (?)");
					pstmt.setString(1, sql);
					if (pstmt.executeUpdate() == 1)// 删除成功后返回1
						flag = true;
				} catch (SQLException e) {
					e.printStackTrace();
				} finally {
					DataClose.DataClose(rs, pstmt, conn);
				}
				return flag;

			}
	
	//用户注册，插入
	public boolean InsertUser(UserDto u) {
		boolean flag = false;
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		try {
			conn = DataAccess.getConnection();
			
			pstmt = conn
					.prepareStatement("insert into User values(?,?,?,?,?)");
			pstmt.setString(1, u.getUid());
			pstmt.setString(2, u.getUname());
			pstmt.setString(3, u.getPassword());
			pstmt.setInt(4, u.getsSuper());
			pstmt.setInt(5, 1);
			if (pstmt.executeUpdate() == 1)// 插入成功后返回1
				flag = true;
		} catch (final SQLException e) {
			e.printStackTrace();
		} finally {

			DataClose.DataClose(rs, pstmt, conn);
		}
		return flag;
	}

	// 返回用户表记录数
	public int GetRowForUser() {
			int i = 0;
			Connection conn = null;
			PreparedStatement pstmt = null;
			ResultSet rs = null;
			try {
				conn = DataAccess.getConnection();
				pstmt = conn
						.prepareStatement("select * from User ");
				rs = pstmt.executeQuery();
				rs.last();
				i = rs.getRow();
			} catch (SQLException e) {
				e.printStackTrace();
			} finally {
				DataClose.DataClose(rs, pstmt, conn);
			}
			return i;
		}
}

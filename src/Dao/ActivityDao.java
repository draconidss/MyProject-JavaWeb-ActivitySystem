package Dao;

import java.io.*;
import java.sql.*;
import java.util.*;

import Dto.*;
import Tool.*;

public class ActivityDao {
	// 寻找活动所有内容或通过aid和aname寻找并输出，通过左右连接，i=1：时通过aid查询，i=2：通过名称拆线呢，i=3：查询三个表的左右连接
	public void FindAll(int i) {
		Scanner in = new Scanner(System.in);
		String s = null;
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		try {
			conn = DataAccess.getConnection();

			// 活动查询方式
			switch (i) {
			case 1:// 通过活动id查询
				pstmt = conn
						.prepareStatement("select a.aid,a.aname,a.level,a.place,a.duration,c.pid,e.pname,e.phonenumber,c.con,c.nreason"
								+ " from Activity a left outer join Con c "
								+ " on a.aid = c.aid left outer join ExamineP e"
								+ " on e.pid=c.pid"
								+ " where a.deletemark =1 and a.aid = ?");
				System.out.print("请输入想查询的活动id：");
				s = in.next();// 读取查询id
				pstmt.setString(1, s);
				break;
			case 2:// 通过活动名字查询
				pstmt = conn
						.prepareStatement("select a.aid,a.aname,a.level,a.place,a.duration,c.pid,e.pname,e.phonenumber,c.con,c.nreason"
								+ " from Activity a left outer join Con c "
								+ " on a.aid = c.aid left outer join ExamineP e"
								+ " on e.pid=c.pid"
								+ " where a.deletemark =1 and a.aname like ? ");
				System.out.print("请输入想查询的活动关键字：");
				s = in.next();// 读取查询名
				s = "%" + s + "%";// 关键字查询
				pstmt.setString(1, s);
				break;
			case 3:// 查询所有
				pstmt = conn
						.prepareStatement("select a.aid,a.aname,a.level,a.place,a.duration,c.pid,e.pname,e.phonenumber,c.con,c.nreason"
								+ " from Activity a left outer join Con c "
								+ " on a.aid = c.aid left outer join ExamineP e"
								+ " on e.pid=c.pid"
								+ " where a.deletemark =1 and a.aid in(select aid from Activity)");
				break;
			}
			rs = pstmt.executeQuery();
			if (rs.next()) {
				rs.previous();
				System.out
						.println("-----------------------------------------------------------所有活动情况查询成功----------------------------------------------------------");
				System.out.println("活动编号" + "  " + "\t" + " 活动名称" + "  " + "\t"
						+ "级别" + "  " + "\t" + " 地点" + "  " + "\t"
						+ "                      " + "时间" + "           "
						+ "\t" + " 审核人编号" + "  " + "\t" + "审核人名字" + "    "
						+ "审核人联系方式" + "   " + "\t" + " 审核状态" + "  " + "\t"
						+ " 审核未通过原因" + '\t');
				while (rs.next()) {
					System.out.print("#" + rs.getString("a.aid") + "  " + "\t");
					System.out.print(rs.getString("a.aname") + "  " + "\t");
					System.out.print(rs.getString("a.level") + "  " + "\t");
					System.out.print(rs.getString("a.place") + "\t" + "   ");
					System.out.print(rs.getString("a.duration") + "  "
							+ "\t   ");
					System.out.print(rs.getString("c.pid") + "\t        ");
					System.out.print(rs.getString("e.pname") + "\t     ");
					System.out.print(rs.getString("e.phonenumber") + "\t    ");
					System.out.print(rs.getString("c.con") + "  \t      ");
					System.out.println(rs.getString("c.nreason") + "\t");
				}
				rs.last();
				System.out
						.println("\n---------------------------------------------------------------共"
								+ rs.getRow()
								+ "条记录---------------------------------------------------------------\n");
			} else
				System.out.println("未找到记录或输入格式错误！");
			System.out.println();//
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			DataClose.DataClose(rs, pstmt, conn);
		}
	}

	// 通过aid查询是否存在并输出
	public boolean FindActivityByaid(String _aid) {
		boolean flag = false;
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		try {
			conn = DataAccess.getConnection();
			pstmt = conn
					.prepareStatement("select * from Activity where aid=? and deletemark =1");
			pstmt.setString(1, _aid);
			rs = pstmt.executeQuery();
			if (rs.next()) {
				flag = true;
				System.out.println("活动编号" + "  " + "\t" + " 活动名称" + "  " + "\t"
						+ "级别" + "  " + "\t" + " 地点" + "  " + "\t"
						+ "                      " + "时间");
				System.out.print("#" + rs.getString("aid") + "  " + "\t");
				System.out.print(rs.getString("aname") + "  " + "\t");
				System.out.print(rs.getString("level") + "  " + "\t");
				System.out.print(rs.getString("place") + "\t" + "   ");
				System.out.println(rs.getString("duration") + "  " + "\t   ");
			}

		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			DataClose.DataClose(rs, pstmt, conn);
		}
		return flag;
	}

	// 通过aname查询是否存在
	public boolean FindActivityByaname(String _aname) {
		boolean flag = false;
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		try {
			conn = DataAccess.getConnection();
			pstmt = conn
					.prepareStatement("select * from Activity where aname=? and deletemark =1");
			pstmt.setString(1, _aname);
			rs = pstmt.executeQuery();
			if (rs.next()) {
				flag = true;
				System.out.println("活动编号" + "  " + "\t" + " 活动名称" + "  " + "\t"
						+ "级别" + "  " + "\t" + " 地点" + "  " + "\t"
						+ "                      " + "时间");
				System.out.print("#" + rs.getString("aid") + "  " + "\t");
				System.out.print(rs.getString("aname") + "  " + "\t");
				System.out.print(rs.getString("level") + "  " + "\t");
				System.out.print(rs.getString("place") + "\t" + "   ");
				System.out.println(rs.getString("duration") + "  " + "\t   ");
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			DataClose.DataClose(rs, pstmt, conn);
		}
		return flag;
	}

	//更具aname关键字查询
	public Vector<ActivityDto> FindActivityByAnamekeyword(String _anamekeyword) {
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		Vector<ActivityDto> v = new Vector<ActivityDto>();
		
		try {
			conn = DataAccess.getConnection();
			pstmt = conn
					.prepareStatement("select * from Activity where aname like ? and deletemark = 1");
			String s = '%'+ _anamekeyword+'%';
			pstmt.setString(1, s);
			rs = pstmt.executeQuery();
			while (rs.next()) {
				ActivityDto a = new ActivityDto();
				System.out.println("aid="+rs.getString("aid"));
/*				a.setAid(rs.getString("aid"));
				a.setAname(rs.getString("aname"));
				a.setLevel(rs.getString("level"));
				a.setPlace(rs.getString("place"));
				a.setDuration(rs.getString("duration"));
				a.setPname(rs.getString("pname"));
				a.setEmail(rs.getString("email"));
				a.setInf(rs.getString("inf"));
				a.setCon(rs.getString("con"));*/
				a.setAll(rs.getString("aid"), rs.getString("aname"), rs.getString("level"), rs.getString("place"), rs.getString("duration"), 
						rs.getString("pname"),rs.getString("email"), rs.getString("inf"), rs.getString("con"), "1");
				v.add(a);				
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			DataClose.DataClose(rs, pstmt, conn);
		}
		return v;
	}	
	
	// 通过aname查询aid
	public String FindActivityAidByaname(String _aname) {
		String s = null ;
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		try {
				conn = DataAccess.getConnection();
				pstmt = conn.prepareStatement("select aid from Activity where aname=? and deletemark =1");
				pstmt.setString(1, _aname);
				rs = pstmt.executeQuery();
				if(rs.next())
					s = rs.getString("aid");
			} catch (SQLException e) {
				e.printStackTrace();
			} finally {
				DataClose.DataClose(rs, pstmt, conn);
			}
		return s;
	}
	
	// 查询并输出活动表
	public Vector<ActivityDto> FindAllActivity() {
		Vector<ActivityDto> v = new Vector<ActivityDto>();
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		try {
			conn = DataAccess.getConnection();
			pstmt = conn
					.prepareStatement("select * from Activity where deletemark = 1");
			rs = pstmt.executeQuery();
			
			while(rs.next()) {
				ActivityDto a = new ActivityDto();
				a.setAid(rs.getString("aid"));
				a.setAname(rs.getString("aname"));
				a.setLevel(rs.getString("level"));
				a.setPlace(rs.getString("place"));
				a.setDuration(rs.getString("duration"));
				a.setPname(rs.getString("pname"));
				a.setEmail(rs.getString("email"));
				a.setInf(rs.getString("inf"));
				a.setCon(rs.getString("con"));
				v.add(a);						
				} 
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			DataClose.DataClose(rs, pstmt, conn);
		}
		return v;

	}

	// 查询并输出被删除的活动表
	public Vector<ActivityDto> FindAllDelActivity() {
		Vector<ActivityDto> v = new Vector<ActivityDto>();
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		try {
			conn = DataAccess.getConnection();
			pstmt = conn
					.prepareStatement("select * from Activity where deletemark = 0");
			rs = pstmt.executeQuery();
			
			while(rs.next()) {
				ActivityDto a = new ActivityDto();
				a.setAid(rs.getString("aid"));
				a.setAname(rs.getString("aname"));
				a.setLevel(rs.getString("level"));
				a.setPlace(rs.getString("place"));
				a.setDuration(rs.getString("duration"));
				a.setPname(rs.getString("pname"));
				a.setEmail(rs.getString("email"));
				a.setInf(rs.getString("inf"));
				a.setCon(rs.getString("con"));
				v.add(a);						
				} 
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			DataClose.DataClose(rs, pstmt, conn);
		}
		return v;

	}
	
	// 返回活动表记录数
	public int GetRowForActivity() {
		int i = 0;
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		try {
			conn = DataAccess.getConnection();
			pstmt = conn
					.prepareStatement("select * from Activity ");
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

	// 活动表插入
	public boolean InsertActivity(ActivityDto a) {
		boolean flag = false;
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		try {
			conn = DataAccess.getConnection();
			pstmt = conn
					.prepareStatement("insert into Activity values(?,?,?,?,?,?,?,?,?,?)");
			pstmt.setString(1, a.getAid());
			pstmt.setString(2, a.getAname());
			pstmt.setString(3, a.getLevel());
			pstmt.setString(4, a.getPlace());
			pstmt.setString(5, a.getDuration());
			pstmt.setString(6, a.getPname());
			pstmt.setString(7, a.getEmail());
			pstmt.setString(8, a.getInf());
			pstmt.setString(9, a.getCon());
			pstmt.setString(10, a.getDeletemark());
			if (pstmt.executeUpdate() == 1)// 插入成功后返回1
				flag = true;
		} catch (final SQLException e) {
			e.printStackTrace();
		} finally {

			DataClose.DataClose(rs, pstmt, conn);
		}
		return flag;
	}

	// 根据aid删除活动表，并删除活动情况表记录
	public boolean DeleteActivityByaid(ActivityDto a) {
		boolean flag = false;
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		try {
			conn = DataAccess.getConnection();
			// 删除将deletemark改为0，先删除活动情况表，在删除活动表
			pstmt = conn
					.prepareStatement("update Activity set deletemark = 0 where aid=?");
			pstmt.setString(1, a.getAid());
			if (pstmt.executeUpdate() == 1)// 删除成功后返回1
				flag = true;
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			DataClose.DataClose(rs, pstmt, conn);
		}
		return flag;

	}

	// 根据aname删除活动表，并删除活动情况表记录
	public boolean DeleteActivityByaname(ActivityDto a) {
		boolean flag = false;
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		try {
			conn = DataAccess.getConnection();
			// 删除将deletemark改为0，先删除活动情况表，在删除活动表
			pstmt = conn
					.prepareStatement("update Activity set deletemark = 0 where aname like ?");
			pstmt.setString(1, a.getAname());
			if (pstmt.executeUpdate() == 1)// 删除成功后返回1
				flag = true;
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			DataClose.DataClose(rs, pstmt, conn);
		}
		return flag;

	}

	// 根据aid更新Activity
	public boolean UpdateActivityByaid(ActivityDto a) {
		boolean flag = false;
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		try {
			conn = DataAccess.getConnection();
			pstmt = conn
					.prepareStatement("update Activity set aname=?,pname=?,email=?,level=?,place=?,duration=?,inf=?,con=? where aid = ?");
			pstmt.setString(1, a.getAname());
			pstmt.setString(2, a.getPname());
			pstmt.setString(3, a.getEmail());
			pstmt.setString(4, a.getLevel());
			pstmt.setString(5, a.getPlace());
			pstmt.setString(6, a.getDuration());
			pstmt.setString(7, a.getInf());
			pstmt.setString(8, a.getCon());
			pstmt.setString(9, a.getAid());
			if (pstmt.executeUpdate() == 1)
				flag = true;
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			DataClose.DataClose(rs, pstmt, conn);
		}
		return flag;

	}

	// 根据aname更新Activity
	public boolean UpdateActivityByaname(ActivityDto a) {
		boolean flag = false;
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		try {
			conn = DataAccess.getConnection();
			// 删除将deletemark改为0，先删除活动情况表，在删除活动表
			pstmt = conn
					.prepareStatement("update Activity set aname=?,level=?,place=?,duration=? where aname = ?");
			pstmt.setString(1, a.getAname());
			pstmt.setString(2, a.getLevel());
			pstmt.setString(3, a.getPlace());
			pstmt.setString(4, a.getDuration());
			pstmt.setString(5, a.getAname());
			if (pstmt.executeUpdate() == 1)// 删除成功后返回1
				flag = true;
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			DataClose.DataClose(rs, pstmt, conn);
		}
		return flag;

	}

}

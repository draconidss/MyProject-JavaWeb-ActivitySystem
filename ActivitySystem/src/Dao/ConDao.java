package Dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Vector;

import Dto.ActivityDto;
import Dto.ConDto;
import Dto.ExaminerDto;
import Tool.DataAccess;
import Tool.DataClose;

public class ConDao {
	
	// 查询所有审核情况
	public Vector<ConDto> FindAllCondition() {
		Vector<ConDto> v = new Vector<ConDto>();
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		String s;
		try {
			conn = DataAccess.getConnection();
			pstmt = conn.prepareStatement("select * from Con where deletemark = 1");
			rs = pstmt.executeQuery();
			
			while(rs.next()) {
				ConDto c = new ConDto();
				c.setAid(rs.getString("aid"));
				c.setAname(rs.getString("aname"));
				c.setName(rs.getString("name"));
				c.setLevel(rs.getString("level"));
				c.setCon(rs.getString("con"));
				c.setNreason(rs.getString("nreason"));
				v.add(c);						
				} 
			
			
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			DataClose.DataClose(rs, pstmt, conn);
		}
		return v;
	}

	// 查询所有被删除的审核情况
		public Vector<ConDto> FindAlDelCondition() {
			Vector<ConDto> v = new Vector<ConDto>();
			Connection conn = null;
			PreparedStatement pstmt = null;
			ResultSet rs = null;
			String s;
			try {
				conn = DataAccess.getConnection();
				pstmt = conn.prepareStatement("select * from Con where deletemark = 0");
				rs = pstmt.executeQuery();
				
				while(rs.next()) {
					ConDto c = new ConDto();
					c.setAid(rs.getString("aid"));
					c.setAname(rs.getString("aname"));
					c.setName(rs.getString("name"));
					c.setLevel(rs.getString("level"));
					c.setCon(rs.getString("con"));
					c.setNreason(rs.getString("nreason"));
					v.add(c);						
					} 
				
				
				
			} catch (SQLException e) {
				e.printStackTrace();
			} finally {
				DataClose.DataClose(rs, pstmt, conn);
			}
			return v;
		}	
	// 通过id或名字查找
	public void FindAllConditionByaidAndeid() {
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		String s;
		try {
			conn = DataAccess.getConnection();
			pstmt = conn
					.prepareStatement("select a.aid,a.aname,c.eid,e.ename,a.level,c.con,c.nreason    "
							+ "from Activity a left outer join Con c   "
							+ " on a.aid = c.aid left outer join ExamineP e on e.eid=c.eid "
							+ " where a.deletemark =1 and a.aid in(select aid from Activity)");
			rs = pstmt.executeQuery();
			System.out
					.println("-----------------------------------------------------------查询审核情况表查询成功----------------------------------------------------------");
			System.out.println("活动id" + "\t" + "活动名称" + "    \t" + "审核人id"
					+ "\t" + "审核人名字" + "\t" + "级别" + "\t" + "审核情况" + "\t"
					+ "未通过原因" + "\t");
			if (rs.next()) {
				rs.previous();
				while (rs.next()) {
					System.out.print("#" + rs.getString("aid") + "\t");
					System.out.print(rs.getString("aname") + "\t");
					System.out.print(rs.getString("eid") + "\t");
					System.out.print(rs.getString("ename")
							+ "\t                ");
					System.out.print(rs.getString("level") + "\t");
					System.out.print(rs.getString("con") + "\t");
					System.out.println(rs.getString("nreason") + "\t");
				}
				rs.last();
				System.out
						.println("\n------------------------------------------------------------共"
								+ rs.getRow()
								+ "条记录------------------------------------------------------------------\n");
			} else
				System.out.println("记录为空！");
			System.out.println();//

		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			DataClose.DataClose(rs, pstmt, conn);
		}
	}

	// 通过aid查询是否存在
	public boolean FindConditionByaid(String _aid) {
		boolean flag = false;
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		try {
			conn = DataAccess.getConnection();
			pstmt = conn.prepareStatement("select * from Con where aid=?");
			pstmt.setString(1, _aid);
			rs = pstmt.executeQuery();
			if (rs.next()) {
				flag = true;
				System.out.println("活动id" + "\t" + "审核人id" + "\t" + "审核人名字"
						+ "\t" + "级别" + "\t" + "审核情况" + "\t" + "未通过原因" + "\t");
				System.out.print("#" + rs.getString("aid") + "  " + "\t");
				System.out.print(rs.getString("eid") + "  " + "\t");
				System.out.print(rs.getString("level") + "  " + "\t");
				System.out.print(rs.getString("con") + "\t" + "   ");
				System.out.println(rs.getString("nreason") + "  " + "\t   ");
			}

		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			DataClose.DataClose(rs, pstmt, conn);
		}
		return flag;
	}

	// 通过eid查询是否存在
	public boolean FindConditionByeid(String _eid) {
		boolean flag = false;
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		try {
			conn = DataAccess.getConnection();
			pstmt = conn.prepareStatement("select * from Con where eid=?");
			pstmt.setString(1, _eid);
			rs = pstmt.executeQuery();
			if (rs.next()) {
				flag = true;
				System.out.println("活动id" + "\t" + "审核人id" + "\t" + "审核人名字"
						+ "\t" + "级别" + "\t" + "审核情况" + "\t" + "未通过原因" + "\t");
				System.out.print("#" + rs.getString("aid") + "  " + "\t");
				System.out.print(rs.getString("eid") + "  " + "\t");
				System.out.print(rs.getString("level") + "  " + "\t");
				System.out.print(rs.getString("con") + "\t" + "   ");
				System.out.println(rs.getString("nreason") + "  " + "\t   ");
			}

		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			DataClose.DataClose(rs, pstmt, conn);
		}
		return flag;
	}
	



	// 增加活动表后，增加活动审核情况表
	public boolean InsertActivityAndCon(ActivityDto a) {
		boolean flag = false;
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		try {
			conn = DataAccess.getConnection();
			pstmt = conn
					.prepareStatement("insert into Con values(?,'null',?,'审核中','null',?)");
			pstmt.setString(1, a.getAid());
			pstmt.setString(2, a.getLevel());
			pstmt.setString(3, a.getDeletemark());
			if (pstmt.executeUpdate() == 1)// 插入成功后返回1
				flag = true;
		} catch (final SQLException e) {
			e.printStackTrace();
		} finally {
			DataClose.DataClose(rs, pstmt, conn);
		}
		return flag;
	}

	// 通过aid删除活动情况表
	public boolean DeleteConByaid(ConDto c) {
		boolean flag = false;
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		try {
			conn = DataAccess.getConnection();
			pstmt = conn
					.prepareStatement("update Con set deletemark = 0 where aid=?");
			pstmt.setString(1, c.getAid());
			if (pstmt.executeUpdate() == 1)// 删除成功后返回1
				flag = true;
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			DataClose.DataClose(rs, pstmt, conn);
		}
		return flag;

	}

	// 通过aname删除活动情况表
	public boolean DeleteConByaname(ConDto c) {
		boolean flag = false;
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		try {
			conn = DataAccess.getConnection();
			pstmt = conn
					.prepareStatement("update Con set deletemark = 0 where aname like ?");
			pstmt.setString(1, c.getAname());
			if (pstmt.executeUpdate() == 1)// 删除成功后返回1
				flag = true;
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			DataClose.DataClose(rs, pstmt, conn);
		}
		return flag;

	}

	// 通过eid删除活动情况表
	/*public boolean DeleteConByeid(ConDto c) {
		boolean flag = false;
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		try {
			conn = DataAccess.getConnection();
			pstmt = conn
					.prepareStatement("update Con set eid=null where eid=?");
			pstmt.setString(1, c.getEid());
			if (pstmt.executeUpdate() == 1)// 删除成功后返回1
				flag = true;
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			DataClose.DataClose(rs, pstmt, conn);
		}
		return flag;

	}*/

	// 通过ename删除活动情况表
	public boolean DeleteConByename(ConDto c) {
		boolean flag = false;
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		try {
			conn = DataAccess.getConnection();
			pstmt = conn
					.prepareStatement("update Con set eid=null where ename = ?");
			pstmt.setString(1, c.getName());
			if (pstmt.executeUpdate() == 1)// 删除成功后返回1
				flag = true;
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			DataClose.DataClose(rs, pstmt, conn);
		}
		return flag;

	}

	// 通过aid更新
	public boolean UpdateConByaid(ConDto c) {
		boolean flag = false;
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		try {
			conn = DataAccess.getConnection();
			// 删除将deletemark改为0，先删除活动情况表，在删除活动表
			pstmt = conn.prepareStatement("Update Con set name=? ,level=?,con=?,nreason=? where aid=?");
			pstmt.setString(1, c.getName());
			pstmt.setString(2, c.getLevel());
			pstmt.setString(3, c.getCon());
			pstmt.setString(4, c.getNreason());
			pstmt.setString(5, c.getAid());
			if (pstmt.executeUpdate() == 1)// 
				flag = true;
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			DataClose.DataClose(rs, pstmt, conn);
		}
		return flag;

	}

}

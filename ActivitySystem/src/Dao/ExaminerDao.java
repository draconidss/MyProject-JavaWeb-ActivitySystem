package Dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Vector;

import Dto.ActivityDto;
import Dto.ExaminerDto;
import Dto.UserDto;
import Tool.DataAccess;
import Tool.DataClose;

public class ExaminerDao {

	// 通过eid查询,返回值为boolean
	public boolean FindExaminerByeid(String _eid) {
		boolean flag = false;
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		try {
			conn = DataAccess.getConnection();
			pstmt = conn
					.prepareStatement("select * from Examiner where deletemark = 1 and eid=?");
			pstmt.setString(1, _eid);
			rs = pstmt.executeQuery();
			if (rs.next()) {
				flag = true;
				System.out
						.println("-----------------------------------------------------------通过审核人id查询成功----------------------------------------------------------");
				System.out.println("审核人id" + "\t" + "审核人姓名" + "\t" + "级别"
						+ "\t" + "联系号码" + "\t");
				System.out.print("#" + rs.getString("eid") + "\t");
				System.out.print(rs.getString("ename") + "\t                ");
				System.out.print(rs.getString("level") + "\t");
				System.out.println(rs.getString("phonenumber") + "\t");
				rs.last();
				System.out
						.println("\n------------------------------------------------------------共"
								+ rs.getRow()
								+ "条记录------------------------------------------------------------------\n");
			} else
				System.out.println("记录未找到或输入格式错误（查询id输入格式为：p01，p02等）!");
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			DataClose.DataClose(rs, pstmt, conn);
		}
		return flag;
	}

	// 通过ename查询,返回值为boolean
	public boolean FindExaminerByename(String _ename) {
		boolean flag = false;
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		System.out.println("查找Ename是否存在是，方法里面的ename="+_ename);
		try {
			conn = DataAccess.getConnection();
			pstmt = conn.prepareStatement("select * from Examiner where deletemark = 1 and ename =?");
			pstmt.setString(1, _ename);
			rs = pstmt.executeQuery();
			if (rs.next()) {
				flag = true;
				System.out.println("-----------------------------------------------------------通过审核人名字查询成功----------------------------------------------------------");
				System.out.println("审核人id" + "\t" + "审核人姓名" + "\t" + "级别"+ "\t" + "联系号码" + "\t");
				System.out.print("#" + rs.getString("eid") + "\t");
				System.out.print(rs.getString("ename") + "\t                ");
				System.out.print(rs.getString("level") + "\t");
				System.out.println(rs.getString("phonenumber") + "\t");
			} else
				System.out.println("记录未找到或输入格式错误!");
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			DataClose.DataClose(rs, pstmt, conn);
		}
		return flag;
	}

	// 查询所有审核人信息,返回Vector数组
	public Vector<ExaminerDto> FindAllExaminer() {
		Vector<ExaminerDto> v = new Vector<ExaminerDto>();
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		String s;
		try {
			conn = DataAccess.getConnection();
			pstmt = conn.prepareStatement("select * from Examiner where deletemark = 1");
			rs = pstmt.executeQuery();
			
			while(rs.next()) {
				ExaminerDto e = new ExaminerDto();
				e.setEid(rs.getString("eid"));
				e.setEname(rs.getString("ename"));
				e.setName(rs.getString("Name"));
				e.setLevel(rs.getString("level"));
				e.setPhonenumber(rs.getString("phonenumber"));
				v.add(e);						
				} 
			
			
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			DataClose.DataClose(rs, pstmt, conn);
		}
		return v;
	}
	
	// 查询所有审核人信息,返回Vector数组
		public Vector<ExaminerDto> FindAllDelExaminer() {
			Vector<ExaminerDto> v = new Vector<ExaminerDto>();
			Connection conn = null;
			PreparedStatement pstmt = null;
			ResultSet rs = null;
			String s;
			try {
				conn = DataAccess.getConnection();
				pstmt = conn.prepareStatement("select * from Examiner where deletemark = 0");
				rs = pstmt.executeQuery();
				
				while(rs.next()) {
					ExaminerDto e = new ExaminerDto();
					e.setEid(rs.getString("eid"));
					e.setEname(rs.getString("ename"));
					e.setName(rs.getString("Name"));
					e.setLevel(rs.getString("level"));
					e.setPhonenumber(rs.getString("phonenumber"));
					v.add(e);						
					} 
				
				
				
			} catch (SQLException e) {
				e.printStackTrace();
			} finally {
				DataClose.DataClose(rs, pstmt, conn);
			}
			return v;
		}	

	// 通过ename查询eid
	public String FindEidByEname(String _ename) {
		String eid = null;
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		try {
			conn = DataAccess.getConnection();
			pstmt = conn.prepareStatement("select eid from Examiner where name=?");
			pstmt.setString(1, _ename);
			rs = pstmt.executeQuery();
			if (rs.next()) {
				eid = rs.getString("ename");

			}

		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			DataClose.DataClose(rs, pstmt, conn);
		}
		return eid;
	}
	
	
	// 返回审核人表记录数
	public int GetRowForExaminer() {
		int i = 0;
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		try {
			conn = DataAccess.getConnection();
			pstmt = conn
					.prepareStatement("select * from Examiner ");
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

	// 插入审核人表
	public boolean InsertExaminer(ExaminerDto e) {
		boolean flag = false;
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		try {
			conn = DataAccess.getConnection();
			pstmt = conn
					.prepareStatement("insert into Examiner values(?,?,?,?,?,?)");
			pstmt.setString(1, e.getEid());
			pstmt.setString(2, e.getEname());
			pstmt.setString(3, e.getName());
			pstmt.setString(4, e.getLevel());
			pstmt.setString(5, e.getPhonenumber());
			pstmt.setString(6, e.getDeletemark());
			if (pstmt.executeUpdate() == 1)// 插入成功后返回1
				flag = true;
		} catch (SQLException e1) {
			e1.printStackTrace();
		} finally {
			DataClose.DataClose(rs, pstmt, conn);
		}
		return flag;
	}

	// 根据eid删除活动表，并删除活动情况表记录里面的审核人记录
	public boolean DeleteExaminerByeid(ExaminerDto e) {
		boolean flag = false;
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		try {
			conn = DataAccess.getConnection();
			// 删除将deletemark改为0，先删除活动情况表，在删除活动表
			pstmt = conn
					.prepareStatement("update 	Examiner set deletemark = 0 where eid=?");
			pstmt.setString(1, e.getEid());
			if (pstmt.executeUpdate() == 1)// 删除成功后返回1
				flag = true;
		} catch (SQLException e1) {
			e1.printStackTrace();
		} finally {
			DataClose.DataClose(rs, pstmt, conn);
		}
		return flag;

	}

	// 根据ename删除活动表，并删除活动情况表记录里面的审核人记录
	public boolean DeleteExaminerByename(ExaminerDto e) {
		boolean flag = false;
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		try {
			conn = DataAccess.getConnection();
			// 删除将deletemark改为0，先删除活动情况表，在删除活动表
			pstmt = conn
					.prepareStatement("update 	Examiner set deletemark = 0 where ename=?");
			pstmt.setString(1, e.getEname());
			if (pstmt.executeUpdate() == 1)// 删除成功后返回1
				flag = true;
		} catch (SQLException e1) {
			e1.printStackTrace();
		} finally {
			DataClose.DataClose(rs, pstmt, conn);
		}
		return flag;
	}

	// 根据eid更新审核人表,更新姓名,级别,电话号码
	public boolean UpdateExaminerByeid(ExaminerDto e) {
		boolean flag = false;
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		try {
			conn = DataAccess.getConnection();
			pstmt = conn.prepareStatement("update Examiner set name=?, level=?,phonenumber=? where eid = ? and deletemark = 1");
			pstmt.setString(1, e.getName());
			pstmt.setString(2, e.getLevel());
			pstmt.setString(3, e.getPhonenumber());
			pstmt.setString(4, e.getEid());
			if (pstmt.executeUpdate() == 1)// 更新成功后返回1
				flag = true;
		} catch (SQLException e1) {
			e1.printStackTrace();
		} finally {
			DataClose.DataClose(rs, pstmt, conn);
		}
		return flag;

	}

	// 根据ename更新审核人表
	public boolean UpdateExaminerEnameByEname(String _NewEname,String _OldEname) {
		boolean flag = false;
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		try {
			conn = DataAccess.getConnection();
			// 删除将deletemark改为0，先删除活动情况表，在删除活动表
			pstmt = conn.prepareStatement("update Examiner set ename=? where ename = ? and deletemark = 1");
			pstmt.setString(1, _NewEname);
			pstmt.setString(2,_OldEname);

			System.out.println(pstmt.executeUpdate());
			if (pstmt.executeUpdate() == 1)// 更新成功后返回1
				flag = true;
		} catch (SQLException e1) {
			e1.printStackTrace();
		} finally {
			DataClose.DataClose(rs, pstmt, conn);
		}
		return flag;

	}
	

	
}

/*package Test;

import java.io.ObjectInputStream.GetField;
import java.sql.*;
import java.util.*;

import javax.print.attribute.standard.Finishings;

import Dao.*;//Dao类引入
import Dto.*;//Dto类引入
import Tool.*;//工具类引入

public class Test {

	// 一级菜单目录
	public static void catalog() {
		System.out.println("***************一级菜单目录****************");
		System.out.println("*1.查询记录\n*2.增加记录\n*3.删除记录\n*4.更新记录\n*0.退出系统");
		System.out.println("请选择您所需的服务：");
		System.out.println("*****************************************");

	}

	// 二级菜单查询目录
	public static void Level2ForSearch() {
		System.out.println("\n***************二级菜单查询目录*************");
		System.out.println("1.审核人查询\n2.活动查询\n3.活动审核情况查询\n4.返回一级菜单\n0.退出系统");
		System.out.println("请选择您所需的服务：");
		System.out.println("*****************************************");
	}

	// 二级菜单增加目录
	public static void Level2ForAdd() {
		System.out.println("\n***************二级菜单增加目录*************");
		System.out.println("1.增加活动表\n2.增加审核人表\n3.增加活动情况表\n4.返回一级菜单\n0.退出系统");
		System.out.println("请选择您所需的服务：");
		System.out.println("*****************************************");
	}

	// 二级菜单删除目录
	public static void Level2ForDelete() {
		System.out.println("\n***************二级菜单删除目录*************");
		System.out.println("1.删除活动表\n2.删除审核人表\n3.返回一级菜单\n0.退出系统");
		System.out.println("请选择您所需的服务：");
		System.out.println("*****************************************");
	}

	// 二级菜单更新目录
	public static void Level2ForUpdate() {
		System.out.println("***************二级菜单更新目录*************");
		System.out.println("1.更新活动表\n2.更新审核人表\n3.更新活动审核情况表\n4.返回一级菜单\n0.退出系统");
		System.out.println("请选择您所需的服务：");
		System.out.println("*****************************************");
	}

	// 事件处理
	public static void Event(int select1) {
		ActivityDao a = new ActivityDao();
		ExaminerDao e = new ExaminerDao();
		ConDao c = new ConDao();

		ActivityDto aDto = new ActivityDto();// 用于插入,删除等活动表操作
		ExaminerDto eDto = new ExaminerDto();// 用于插入,删除等审核人表操作
		ConDto cDto = new ConDto();// 用于插入,删除等审核人表操作

		Scanner in = new Scanner(System.in);
		String s;
		// 一级菜单循环
		while (select1 != 0) {
			int select2 = 1;// 二级菜单的选择
			int select3 = 1;// 三级菜单的选择
			catalog();
			select1 = in.nextInt();
			switch (select1) {// 一级菜单选择
			// --------------------------------------------------------------一级菜单:查询记录-----------------------------------------------------
			case 1:
				// 二级菜单查询记录：审核人查询
				while (select2 != 4 && select2 != 0 && select3 != 0) {// 当select2为0或select3为0时推出所有循环
					Level2ForSearch();// 二级菜单查询目录
					select2 = in.nextInt();
					switch (select2) {
					// 审核人表查询
					case 1:// 二级菜单审核表查询
						System.out
								.println("\n************三级菜单审核人表查询目录*********");
						System.out
								.println("1.通过审核人姓名查询\n2.通过审核人id查询\n3.所有审核人查询\n4.返回二级菜单\n0.退出系统");
						System.out.println("您想通过什么来查询：");
						System.out
								.println("*****************************************");
						select3 = in.nextInt();
						// 通过审核人id查询
						if (select3 == 1) {
							System.out.println("请输入审核人姓名（可输入关键字查询）：");
							s = in.next();
							e.FindExaminePBypname(s);
						}

						// 通过审核人名字
						else if (select3 == 2) {
							System.out.println("请输入审核人id（格式为p01,p02）：");
							s = in.next();
							e.FindExaminePBypid(s);
						}
						// 查询所有审核人
						else if (select3 == 3) {
							e.FindAllExamineP();
						}
						// 返回二级菜单
						else if (select3 == 4)
							break;
						// 退出系统
						else if (select3 == 0)
							break;
						else
							System.out.println("您输入的操作序列有误，请重新输入！");

						break;

					case 2:// 二级菜单查询记录：活动情况查询
						System.out
								.println("\n***********三级菜单活动情况表查询目录*********");
						System.out
								.println("1.通过活动id查找\n2.通过活动名称关键字查询\n3.查询所有活动信息\n4.返回二级查询菜单\n0.退出系统");
						System.out.println("您想通过什么来查询：");
						System.out
								.println("*****************************************");
						select3 = in.nextInt();

						if (select3 == 1 || select3 == 2 || select3 == 3)
							a.FindAll(select3);
						if (select3 == 4)// 返回二级菜单
							break;
						else if (select3 == 0)// 退出系统
							break;

						else
							System.out.println("您输入的操作序列有误，请重新输入！");
						break;

					case 3:// 二级菜单查询：审核情况查询
						c.FindAllCondition();
						break;

					case 4:// 返回一级菜单
						break;

					case 0:// 退出系统
						break;

					default:
						System.out.println("您输入的操作序列有误，请重新输入！");
						break;

					}// switch(select2结束)

				}// while(select2)末尾

				break;// 一级菜单case1结束

			// --------------------------------------------------------------一级菜单:增加记录-----------------------------------------------------
			case 2:
				// 二级菜单增加循环
				while (select2 != 4 && select2 != 0) {
					Level2ForAdd();// 二级菜单增加目录
					select2 = in.nextInt();
					String s1, s2, s3, s4, s5;

					switch (select2) {
					// 活动表增加记录
					case 1:
						int ra = a.GetRowForActivity();// 获得数据库中表记录数
						System.out
								.println("***************增加活动表*******************");
						if (ra < 9)// 根据活动数量自动设置活动编号
							s1 = "a0" + (ra + 1);
						else
							s1 = "a" + (ra + 1);
						aDto.setAid(s1);
						System.out.println("请输入活动名称：");
						s2 = in.next();
						System.out.println("添加的活动名称为：" + s2);

						System.out.println("请输入活动级别（院级，部门，校级）：");

						while ((s3 = in.next()) != null) {
							if (s3.equals("部门") || s3.equals("院级")
									|| s3.equals("校级"))
								break;
							else
								System.out
										.println("添加的活动级别格式有误，请重新输入（格式为：院级，部门，校级）：");

						}
						System.out.println("添加的活动级别为：" + s3);

						System.out.println("请输入活动地点：");
						s4 = in.next();
						System.out.println("添加的活动地点为：" + s4);

						System.out.println("请输入活动开始和结束时间：");
						s5 = in.next();
						System.out.println("添加的活动开始结束时间为：" + s5);

						aDto.setLevel(s3);
						aDto.setAname(s2);
						aDto.setPlace(s4);
						aDto.setDuration(s5);
						aDto.setDeletemark("1");// 删除标记
						// 活动表添加后，在添加活动审核表
						if (a.InsertActivity(aDto) == true
								&& c.InsertActivityAndCon(aDto) == true) {// 插入成功时
							System.out
									.println("----------------------------------------------------------------插入成功----------------------------------------------------------");
							a.FindAllActivity();// 输出所有表
							a.FindAll(3);// 输出活动情况表
						} else
							System.out.println("插入失败，请注意插入格式并重新插入");

						// 审核人表增加记录
					case 2:

						int re = e.GetRowForExamineP();// 获得数据库中表记录数
						System.out
								.println("***************增加审核人表******************");
						if (re < 9)// 根据活动数量自动设置活动编号
							s1 = "p0" + (re + 1);
						else
							s1 = "p" + (re + 1);
						eDto.setPid(s1);
						System.out.println("请输入审核人姓名：");
						s2 = in.next();
						System.out.println("添加的审核人姓名为：" + s2);

						System.out.println("请输入审核人级别（部门，院级，校级）：");

						while ((s3 = in.next()) != null) {
							if (s3.equals("部门") || s3.equals("院级")
									|| s3.equals("校级"))
								break;
							else
								System.out
										.println("添加的审核人级别格式有误，请重新输入（格式为：院级，部门，校级）：");

						}
						System.out.println("添加的审核人级别为：" + s3);

						System.out.println("请输入审核人联系电话：");
						s4 = in.next();
						System.out.println("添加的审核人联系电话为：" + s4);

						eDto.setPname(s2);
						eDto.setLevel(s3);
						eDto.setPhonenumber(s4);
						eDto.setDeletemark("1");// 是否删除标记
						if (e.InsertExamineP(eDto) == true) {// 插入成功时
							System.out
									.println("----------------------------------------------------------------插入成功----------------------------------------------------------");
							e.FindAllExamineP();// 输出所有审核人表
						} else
							System.out.println("插入失败，请注意插入格式并重新插入");

						break;

					// 活动审核情况插入
					case 3:
						System.out.println("您的权限不够，无法进行操作，请选择其他操作！");
						break;

					case 4:// 返回一级菜单
						break;

					case 0:// 退出系统
						break;

					default:
						System.out.println("您输入的操作序列有误，请重新输入！");
						break;

					}// switch(select2结束)

				}// while(select2)末尾

				break;// 一级菜单case1结束

			// --------------------------------------------------------------一级菜单：删除记录-----------------------------------------------------
			case 3:
				// 二级菜单删除循环
				while (select2 != 3 && select2 != 0 && select3 != 0) {
					Level2ForDelete();// 二级菜单删除目录
					select2 = in.nextInt();
					String s1, s2, s3, s4, s5;

					switch (select2) {

					// 活动表删除记录
					case 1:
						System.out
								.println("\n************三级菜单删除活动表目录***********");
						System.out
								.println("1.通过活动aid删除\n2.通过活动名称(全名)删除\n3.返回二级删除菜单\n0.退出系统");
						System.out.println("您想通过什么来删除：");
						System.out
								.println("*****************************************");
						select3 = in.nextInt();
						// 通过aid查询
						if (select3 == 1) {
							System.out.println("请输入想要删除的活动aid（格式为：a01,a02等）：");
							s = in.next();
							aDto.setAid(s);
							cDto.setAid(s);
							System.out
									.println("------------------------------------------------------------您所删除的记录为-----------------------------------------------------");
							if (a.FindActivityByaid(s) == false)// 如果记录不存在FindAllActivityByaid里面不会输出，如果存在则会输出所要删除的记录
								System.out.println("您想删除的aid=" + s
										+ "的记录不存在，请重新选择操作！");
							else {
								// 先删除活动情况表，再删除活动表
								if (c.DeleteConByaid(cDto) == true
										&& a.DeleteActivityByaid(aDto) == true) {
									System.out
											.println("---------------------------------------------------------------删除成功--------------------------------------------------------");
									a.FindAllActivity();// 输出删除后的活动表
									a.FindAll(3);
								} else
									System.out.println("删除失败，请重新选择操作！");
							}
						}

						// 通过活动名称删除
						else if (select3 == 2) {
							System.out.println("请输入想要删除的活动名称（全名）：");
							s = in.next();
							aDto.setAname(s);
							cDto.setAid(a.FindActivityAidByaname(s));//由于con表没有aname属性，所以只能先通过aname找到aid在进行删除
							System.out
									.println("------------------------------------------------------------您所删除的记录为-----------------------------------------------------");
							if (a.FindActivityByaname(s) == false)// 如果记录不存在FindAllActivityByaname里面不会输出，如果存在则会输出所要删除的记录
								System.out.println("您想删除的aname=" + s
										+ "的记录不存在，请重新选择操作！");
							else {
								// 先删除活动情况表，再删除活动表
								if (c.DeleteConByaid(cDto) == true&& a.DeleteActivityByaname(aDto) == true) {
									System.out
											.println("--------------------------------------------------------------删除成功----------------------------------------------------------");
									a.FindAllActivity();// 输出删除后的活动表
									a.FindAll(3);
								} else
									System.out.println("删除失败，请重新选择操作！");
							}
						}

						// 返回二级菜单
						else if (select3 == 3)
							break;
						// 退出系统
						else if (select3 == 0)
							break;
						else
							System.out.println("您输入的操作序列有误，请重新输入！");

						break;

					// 审核人表删除记录
					case 2:
						System.out
								.println("\n************三级菜单删除审核人表目录**********");
						System.out
								.println("1.通过审核人pid删除\n2.通过审核人名字删除\n3.返回二级删除菜单\n0.退出系统");
						System.out.println("您想通过什么来删除：");
						System.out
								.println("******************************************");

						select3 = in.nextInt();
						// 通过审核人id删除
						if (select3 == 1) {
							System.out.println("请输入想要删除的审核人pid（格式为p01，p02等）：");
							s = in.next();
							eDto.setPid(s);
							cDto.setPid(s);
							System.out
									.println("------------------------------------------------------------您所删除的记录为-----------------------------------------------------");
							if (e.FindExaminePBypid(s) == false)// 如果记录不存在FindByPid里面不会输出，如果存在则会输出所要删除的记录
								System.out.println("您想删除的pid=" + s
										+ "的记录不存在，请重新选择操作！");
							else {
								// 先删除活动情况表，再删除活动表
								if (c.DeleteConBypid(cDto) == true
										&& e.DeleteExaminePBypid(eDto) == true) {
									System.out
											.println("---------------------------------------------------------------删除成功--------------------------------------------------------");
									e.FindAllExamineP();// 输出删除后的活动表
									a.FindAll(3);
								} else
									System.out.println("删除失败，请重新选择操作！");
							}
						}

						// 通过审核人名字删除
						else if (select3 == 2) {
							System.out.println("请输入想要删除的审核人名字（全名）：");
							s = in.next();
							eDto.setPname(s);
							cDto.setPid(e.FindExaminePPidBypname(s));//由于Con表没有pname属性，所以要先通过pname找到pid再删除
							System.out
									.println("------------------------------------------------------------您所删除的记录为-----------------------------------------------------");
							if (e.FindExaminePBypname(s) == false)// 如果记录不存在
								System.out.println("您想删除的pname=" + s
										+ "的记录不存在，请重新选择操作！");
							else {
								// 先删除活动情况表，再删除活动表
								if (c.DeleteConBypid(cDto) == true
										&& e.DeleteExaminePBypname(eDto) == true) {
									System.out
											.println("--------------------------------------------------------------删除成功----------------------------------------------------------");
									e.FindAllExamineP();// 输出删除后的活动表
									a.FindAll(3);
								} else
									System.out.println("删除失败，请重新选择操作！");
							}
						}

						// 返回二级菜单
						else if (select3 == 3)
							break;
						else if (select3 == 0)
							break;

						else
							System.out.println("您输入的操作序列有误，请重新输入！");

						break;

					// 返回一级菜单
					case 3:
						break;

					case 0:// 退出系统
						break;

					default:
						System.out.println("您输入的操作序列有误，请重新输入！");
						break;

					}// switch(select2结束)

				}// while(select2)末尾

				break;// 一级菜单case1结束

			// --------------------------------------------------------------一级菜单:更新记录-----------------------------------------------------
			case 4:
				// 二级菜单更新循环
				while (select2 != 4 && select2 != 0 && select3 != 0) {
					Level2ForUpdate();// 二级菜单更新目录
					select2 = in.nextInt();
					String s1, s2, s3, s4, s5;

					switch (select2) {
					// 活动表更新记录
					case 1:
						System.out
								.println("\n************三级菜单更新活动表目录***********");
						System.out
								.println("1.通过活动aid更新\n2.通过活动名称(全名)更新\n3.返回二级更新菜单\n0.退出系统");
						System.out.println("您想通过什么来更新：");
						System.out
								.println("*****************************************");
						select3 = in.nextInt();
						// 通过aid更新
						if (select3 == 1) {
							System.out.println("请输入想要更新的活动aid（格式为a01，a02等）：");
							s = in.next();
							aDto.setAid(s);
							System.out
									.println("------------------------------------------------------------您所更新的记录为-----------------------------------------------------");
							if (a.FindActivityByaid(s) == false)// 如果记录不存在FindByPid里面不会输出，如果存在则会输出所要删除的记录
								System.out.println("您想更新的aid=" + s
										+ "的记录不存在，请重新选择操作！");
							else {
								System.out
										.println("*****************更新活动表*****************");
								System.out.println("请输入更新后的活动名称：");
								s2 = in.next();
								System.out.println("更新的活动名称为：" + s2);

								System.out.println("请输入更新后的活动级别（院级，部门，校级）：");
								while ((s3 = in.next()) != null) {
									if (s3.equals("部门") || s3.equals("院级")
											|| s3.equals("校级"))
										break;
									else
										System.out
												.println("输入的活动级别格式有误，请重新输入（格式为：院级，部门，校级）：");

								}
								System.out.println("更新的活动级别为：" + s3);

								System.out.println("请输入更新后的活动地点：");
								s4 = in.next();
								System.out.println("更新的活动地点为：" + s4);

								System.out.println("请输入更新后的活动开始和结束时间：");
								s5 = in.next();
								System.out.println("更新的活动开始结束时间为：" + s5);

								aDto.setAname(s2);
								aDto.setLevel(s3);
								aDto.setPlace(s4);
								aDto.setDuration(s5);
								if (a.UpdateActivityByaid(aDto) == true) {
									System.out
											.println("---------------------------------------------------------------更新成功--------------------------------------------------------");
									a.FindAllActivity();
									;// 输出删除后的活动表
									a.FindAll(3);
								} else
									System.out.println("更新失败，请重新选择操作！");
							}
						}

						else if (select3 == 2)// 更具活动名称更新
						{
							System.out.println("请输入想要更新的活动全名：");
							s = in.next();
							aDto.setAname(s);
							System.out
									.println("------------------------------------------------------------您所更新的记录为-----------------------------------------------------");
							if (a.FindActivityByaname(s) == false)// 如果记录不存在FindByPid里面不会输出，如果存在则会输出所要删除的记录
								System.out.println("您想更新的aname=" + s
										+ "的记录不存在，请重新选择操作！");
							else {
								System.out
										.println("*****************更新活动表*****************");
								System.out.println("请输入更新后的活动名称：");
								s2 = in.next();
								System.out.println("更新的活动名称为：" + s2);

								System.out.println("请输入更新后的活动级别（院级，部门，校级）：");
								while ((s3 = in.next()) != null) {
									if (s3.equals("部门") || s3.equals("院级")
											|| s3.equals("校级"))
										break;
									else
										System.out
												.println("输入的活动级别格式有误，请重新输入（格式为：院级，部门，校级）：");

								}
								System.out.println("更新的活动级别为：" + s3);

								System.out.println("请输入更新后的活动地点：");
								s4 = in.next();
								System.out.println("更新的活动地点为：" + s4);

								System.out.println("请输入更新后的活动开始和结束时间：");
								s5 = in.next();
								System.out.println("更新的活动开始结束时间为：" + s5);

								aDto.setAname(s2);
								aDto.setLevel(s3);
								aDto.setPlace(s4);
								aDto.setDuration(s5);
								if (a.UpdateActivityByaid(aDto) == true) {
									System.out
											.println("---------------------------------------------------------------更新成功--------------------------------------------------------");
									a.FindAllActivity();
									;// 输出更新后的活动表
									a.FindAll(3);
								} else
									System.out.println("更新失败，请重新选择操作！");
							}
						}

						else if (select3 == 3)
							break;// 返回二级菜单
						else if (select3 == 0)
							break;// 退出系统
						
						break;
						// 审核人表更新
					case 2:
						System.out
								.println("\n***********三级菜单更新审核人表目录***********");
						System.out
								.println("1.通过审核人pid更新\n2.通过审核人名字更新\n3.返回二级更新菜单\n0.退出系统");
						System.out.println("您想通过什么来更新：");
						System.out
								.println("*****************************************");
						select3 = in.nextInt();
						// 通过pid更新
						if (select3 == 1) {
							System.out.println("请输入想要更新的审核人pid（格式为p01，p02等）：");
							s = in.next();
							eDto.setPid(s);
							System.out
									.println("------------------------------------------------------------您所更新的记录为-----------------------------------------------------");
							if (e.FindExaminePBypid(s) == false)// 如果记录不存在FindByPid里面不会输出，如果存在则会输出所要删除的记录
								System.out.println("您想更新的pid=" + s
										+ "的记录不存在，请重新选择操作！");
							else {
								System.out
										.println("****************更新审核人表*****************");
								System.out.println("请输入更新后的审核人名字：");
								s2 = in.next();
								System.out.println("更新的审核人名字为：" + s2);

								System.out.println("请输入更新后的审核人电话号码：");
								s3 = in.next();
								System.out.println("更新的审核人电话号码为：" + s3);

								eDto.setPname(s2);
								eDto.setPhonenumber(s3);
								if (e.UpdateExaminePBypid(eDto) == true) {
									System.out.println("---------------------------------------------------------------更新成功--------------------------------------------------------");
									e.FindAllExamineP();// 输出删除后的活动表
									a.FindAll(3);
								} else
									System.out.println("更新失败，请重新选择操作！");
							}
						}

						else if (select3 == 2)// 根据审核人名字更新
						{
							System.out.println("请输入想要更新的审核人名字：");
							s = in.next();
							System.out.println("------------------------------------------------------------您所更新的记录为-----------------------------------------------------");
							if (e.FindExaminePBypname(s) == false)// 如果记录不存在FindByPid里面不会输出，如果存在则会输出所要删除的记录
								System.out.println("您想更新的pname="+s+ "的记录不存在，请重新选择操作！");
							else {
								
								System.out.println("****************更新审核人表*****************");
								System.out.println("请输入更新后的审核人名字：");
								s2 = in.next();
								System.out.println("更新的审核人名字为：" + s2);

								System.out.println("请输入更新后的审核人电话号码：");
								s3 = in.next();
								System.out.println("更新的审核人电话号码为：" + s3);

								eDto.setPid(e.FindExaminePPidBypname(s));//先通过pname查找pid，再通过pid更新
								eDto.setPname(s2);
								eDto.setPhonenumber(s3);

								if (e.UpdateExaminePBypid(eDto) == true) {//由于pname要被更新，所以不能用pname来查询并更新的方法
									System.out.println("---------------------------------------------------------------更新成功--------------------------------------------------------");
									e.FindAllExamineP();// 输出删除后的活动表
									a.FindAll(3);
								} else
									System.out.println("更新失败，请重新选择操作！");
							}
						}

						else if (select3 == 3)
							break;// 返回二级菜单
						else if (select3 == 0)
							break;// 退出系统
						
						break;
						// 更新活动审核情况表
					case 3:
						System.out
								.println("***************更新活动审核情况表***************");
						System.out.println("请输入想要更新的活动aid（格式为a01，a02等）：");
						s = in.next();
						cDto.setAid(s);
						System.out
								.println("------------------------------------------------------------您所更新的记录为-----------------------------------------------------");
						if (c.FindConditionByaid(s) == false)// 如果记录不存在FindConditionByaid(s)里面不会输出，如果存在则会输出所要删除的记录
							System.out.println("您想更新的aid=" + s
									+ "的记录不存在，请重新选择操作！");
						else {

							System.out
									.println("请输入想要更新的活动审核情况（格式为审核中，未通过，已通过）：");
							while ((s2 = in.next()) != null) {
								if (s2.equals("审核中") || s2.equals("未通过")
										|| s2.equals("已通过"))
									break;
								else
									System.out
											.println("添加的审核人级别格式有误，请重新输入（格式为审核中，未通过，已通过）：");

							}
							System.out.println("更新的活动审核情况为：" + s2);
							cDto.setCon(s2);

							if (s2.equals("未通过")) {// 如果活动审核未通过，就要输入审核情况
								System.out.println("请输入活动未通过的原因：");
								s3 = in.next();
								System.out.println("更新的活动未通过原因为：" + s3);
								cDto.setNreason(s3);
							} else {
								cDto.setNreason("无");
							}

							if (c.UpdateConByaid(cDto) == true) {
								System.out
										.println("---------------------------------------------------------------更新成功--------------------------------------------------------");
								c.FindAllCondition();
								a.FindAll(3);
							} else
								System.out.println("更新失败，请重新选择操作！");
						}

						break;

					case 4:// 返回一级菜单
						break;

					case 0:// 退出系统
						break;

					default:
						System.out.println("您输入的操作序列有误，请重新输入！");
						break;

					}// switch(select2结束)

				}// while(select2)末尾

				break;// 四级菜单case4结束

			// --------------------------------------------------------------一级菜单退出系统-----------------------------------------------------
			case 0:
				System.out.println("感谢您的使用！");
				break;

			// 一级菜单末尾
			default:
				System.out.println("您输入的操作序列有误，请重新输入！");
				break;

			}
			if (select2 == 0 || select3 == 0) {// 二级菜单或三级菜单选择退出系统
				System.out.println("感谢您的使用！");
				break;
			}
		}
	}

	public static void main(String[] args) {
		System.out.println("----------欢迎使用大学活动管理系统----------");
		Event(1);
	}
}
*/
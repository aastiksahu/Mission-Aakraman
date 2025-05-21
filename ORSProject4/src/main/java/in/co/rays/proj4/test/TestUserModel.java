package in.co.rays.proj4.test;

import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;

import in.co.rays.proj4.Exception.ApplicationException;
import in.co.rays.proj4.bean.CollegeBean;
import in.co.rays.proj4.bean.UserBean;
import in.co.rays.proj4.model.CollegeModel;
import in.co.rays.proj4.model.UserModel;

public class TestUserModel {

	public static void main(String[] args) throws Exception {

//		testNextPk();
//		testAdd();
//		testUpdate();
//		testDelete();
//		testfindByPk();
//		testfindByLogin();
//		testsearch();
//		testlist();
		testauthenticate();
	}

	private static void testauthenticate() throws Exception {

		UserBean bean = new UserBean();
		UserModel model = new UserModel();

		bean = model.authenticate("jeet@gmail.com","Jeet@123");

		if (bean != null) {

			System.out.print("\t" + bean.getId());
			System.out.print("\t" + bean.getFirstName());
			System.out.print("\t" + bean.getLastName());
			System.out.print("\t" + bean.getLogin());
			System.out.print("\t" + bean.getPassword());
			System.out.print("\t" + bean.getDob());
			System.out.print("\t" + bean.getMobileNo());
			System.out.print("\t" + bean.getRoleId());
			System.out.print("\t" + bean.getGender());
			System.out.print("\t" + bean.getCreatedBy());
			System.out.print("\t" + bean.getModifiedBy());
			System.out.print("\t" + bean.getCreatedDatetime());
			System.out.println("\t" + bean.getModifiedDatetime());
		} else {
			System.out.println("Invalid Login ID and Password...");
		}

	}

	private static void testlist() throws Exception {

		UserBean bean = new UserBean();
		UserModel model = new UserModel();

		List list = new ArrayList();

		list = model.list(1, 10);

		Iterator it = list.iterator();

		while (it.hasNext()) {

			bean = (UserBean) it.next();

			System.out.print("\t" + bean.getId());
			System.out.print("\t" + bean.getFirstName());
			System.out.print("\t" + bean.getLastName());
			System.out.print("\t" + bean.getLogin());
			System.out.print("\t" + bean.getPassword());
			System.out.print("\t" + bean.getDob());
			System.out.print("\t" + bean.getMobileNo());
			System.out.print("\t" + bean.getRoleId());
			System.out.print("\t" + bean.getGender());
			System.out.print("\t" + bean.getCreatedBy());
			System.out.print("\t" + bean.getModifiedBy());
			System.out.print("\t" + bean.getCreatedDatetime());
			System.out.println("\t" + bean.getModifiedDatetime());

		}
	}

	private static void testsearch() throws Exception {

		UserBean bean = new UserBean();
		UserModel model = new UserModel();
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");

		List list = new ArrayList();

		// bean.setId(5262);
		// bean.setFirstName("Shraddha");
		// bean.setLastName("Sharma");
		// bean.setLogin("shraddha@gmail.com");
		// bean.setDob(sdf.parse("2001-04-29"));
		// bean.setMobileNo("9669866628");
		// bean.setRoleId(22222);
		// bean.setGender("Male");

		list = model.search(bean, 1, 10);

		Iterator it = list.iterator();

		while (it.hasNext()) {

			bean = (UserBean) it.next();

			System.out.print("\t" + bean.getId());
			System.out.print("\t" + bean.getFirstName());
			System.out.print("\t" + bean.getLastName());
			System.out.print("\t" + bean.getLogin());
			System.out.print("\t" + bean.getPassword());
			System.out.print("\t" + bean.getDob());
			System.out.print("\t" + bean.getMobileNo());
			System.out.print("\t" + bean.getRoleId());
			System.out.print("\t" + bean.getGender());
			System.out.print("\t" + bean.getCreatedBy());
			System.out.print("\t" + bean.getModifiedBy());
			System.out.print("\t" + bean.getCreatedDatetime());
			System.out.println("\t" + bean.getModifiedDatetime());

		}
	}

	private static void testfindByLogin() throws Exception {

		UserBean bean = new UserBean();
		UserModel model = new UserModel();

		bean = model.findByLogin("jeet@gmail.com");

		if (bean != null) {

			System.out.print("\t" + bean.getId());
			System.out.print("\t" + bean.getFirstName());
			System.out.print("\t" + bean.getLastName());
			System.out.print("\t" + bean.getLogin());
			System.out.print("\t" + bean.getPassword());
			System.out.print("\t" + bean.getDob());
			System.out.print("\t" + bean.getMobileNo());
			System.out.print("\t" + bean.getRoleId());
			System.out.print("\t" + bean.getGender());
			System.out.print("\t" + bean.getCreatedBy());
			System.out.print("\t" + bean.getModifiedBy());
			System.out.print("\t" + bean.getCreatedDatetime());
			System.out.println("\t" + bean.getModifiedDatetime());
		} else {
			System.out.println("Invalid Login ID...");
		}
	}

	private static void testfindByPk() throws Exception {

		UserBean bean = new UserBean();
		UserModel model = new UserModel();

		bean = model.findByPk(5264);

		if (bean != null) {

			System.out.print("\t" + bean.getId());
			System.out.print("\t" + bean.getFirstName());
			System.out.print("\t" + bean.getLastName());
			System.out.print("\t" + bean.getLogin());
			System.out.print("\t" + bean.getPassword());
			System.out.print("\t" + bean.getDob());
			System.out.print("\t" + bean.getMobileNo());
			System.out.print("\t" + bean.getRoleId());
			System.out.print("\t" + bean.getGender());
			System.out.print("\t" + bean.getCreatedBy());
			System.out.print("\t" + bean.getModifiedBy());
			System.out.print("\t" + bean.getCreatedDatetime());
			System.out.println("\t" + bean.getModifiedDatetime());
		} else {
			System.out.println("Invalid ID...");
		}
	}

	private static void testDelete() throws Exception {

		UserBean bean = new UserBean();
		UserModel model = new UserModel();

		bean.setId(5312);

		model.delete(bean);

	}

	private static void testUpdate() throws Exception {

		UserBean bean = new UserBean();
		UserModel model = new UserModel();
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");

		bean.setFirstName("Kalpana");
		bean.setLastName("Sahu");
		bean.setLogin("kalpana@gmail.com");
		bean.setPassword("pass123");
		bean.setDob(sdf.parse("1976-12-20"));
		bean.setMobileNo("9407126877");
		bean.setRoleId(44444);
		bean.setGender("Female");
		bean.setCreatedBy("admin");
		bean.setModifiedBy("admin");
		bean.setCreatedDatetime(new Timestamp(new Date().getTime()));
		bean.setModifiedDatetime(new Timestamp(new Date().getTime()));
		bean.setId(5312);

		model.update(bean);

	}

	private static void testAdd() throws Exception {

		UserBean bean = new UserBean();
		UserModel model = new UserModel();
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");

		bean.setFirstName("Kalpana");
		bean.setLastName("Sa");
		bean.setLogin("kalpana@gmail.com");
		bean.setPassword("pass123");
		bean.setDob(sdf.parse("1976-12-20"));
		bean.setMobileNo("9407126877");
		bean.setRoleId(44444);
		bean.setGender("Female");
		bean.setCreatedBy("admin");
		bean.setModifiedBy("admin");
		bean.setCreatedDatetime(new Timestamp(new Date().getTime()));
		bean.setModifiedDatetime(new Timestamp(new Date().getTime()));

		model.add(bean);

	}

	private static void testNextPk() throws Exception {

		UserModel model = new UserModel();

		int i = model.nextPk();

		System.out.println("NextPk is ..." + i);
	}

}

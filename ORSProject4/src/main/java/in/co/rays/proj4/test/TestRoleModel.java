package in.co.rays.proj4.test;

import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;

import in.co.rays.proj4.Exception.ApplicationException;
import in.co.rays.proj4.bean.CollegeBean;
import in.co.rays.proj4.bean.RoleBean;
import in.co.rays.proj4.model.RoleModel;

public class TestRoleModel {

	public static void main(String[] args) throws Exception {

//		testNextPk();
//		testAdd();
//		testUpdate();
		testDelete();
//		testfindByPk();
//		testfindByName();
//		testsearch();
//		testlist();
	}

	private static void testlist() throws Exception {
		
		RoleBean bean = new RoleBean();
		RoleModel model = new RoleModel();

		List list = new ArrayList();

		list = model.search(bean, 1, 3);

		Iterator it = list.iterator();

		while (it.hasNext()) {

			bean = (RoleBean) it.next();

			System.out.print("\t" + bean.getId());
			System.out.print("\t" + bean.getName());
			System.out.print("\t" + bean.getDescription());
			System.out.print("\t" + bean.getCreatedBy());
			System.out.print("\t" + bean.getModifiedBy());
			System.out.print("\t" + bean.getCreatedDatetime());
			System.out.println("\t" + bean.getModifiedDatetime());

		}
	}

	private static void testsearch() throws Exception {

		RoleBean bean = new RoleBean();
		RoleModel model = new RoleModel();

		List list = new ArrayList();

		// bean.setId(44444);
		// bean.setName("Kiosk");
		// bean.setDescription("Faculty has limited Access.");

		list = model.search(bean, 1, 10);

		Iterator it = list.iterator();

		while (it.hasNext()) {

			bean = (RoleBean) it.next();

			System.out.print("\t" + bean.getId());
			System.out.print("\t" + bean.getName());
			System.out.print("\t" + bean.getDescription());
			System.out.print("\t" + bean.getCreatedBy());
			System.out.print("\t" + bean.getModifiedBy());
			System.out.print("\t" + bean.getCreatedDatetime());
			System.out.println("\t" + bean.getModifiedDatetime());

		}

	}

	private static void testfindByName() throws Exception {

		RoleBean bean = new RoleBean();
		RoleModel model = new RoleModel();

		bean = model.findByName("del");

		if (bean != null) {

			System.out.print("\t" + bean.getId());
			System.out.print("\t" + bean.getName());
			System.out.print("\t" + bean.getDescription());
			System.out.print("\t" + bean.getCreatedBy());
			System.out.print("\t" + bean.getModifiedBy());
			System.out.print("\t" + bean.getCreatedDatetime());
			System.out.println("\t" + bean.getModifiedDatetime());
		} else {
			System.out.println("Invalid Role Name...");
		}

	}

	private static void testfindByPk() throws Exception {

		RoleBean bean = new RoleBean();
		RoleModel model = new RoleModel();

		bean = model.findByPk(44445);

		if (bean != null) {

			System.out.print("\t" + bean.getId());
			System.out.print("\t" + bean.getName());
			System.out.print("\t" + bean.getDescription());
			System.out.print("\t" + bean.getCreatedBy());
			System.out.print("\t" + bean.getModifiedBy());
			System.out.print("\t" + bean.getCreatedDatetime());
			System.out.println("\t" + bean.getModifiedDatetime());
		} else {
			System.out.println("Invalid ID...");
		}

	}

	private static void testDelete() throws Exception {

		RoleBean bean = new RoleBean();
		RoleModel model = new RoleModel();

		bean.setId(44445);

		model.delete(bean);

	}

	private static void testUpdate() throws Exception {

		RoleBean bean = new RoleBean();
		RoleModel model = new RoleModel();

		
		bean.setName("del");
		bean.setDescription("delete has limited Access.");
		bean.setCreatedBy("admin");
		bean.setModifiedBy("admin");
		bean.setCreatedDatetime(new Timestamp(new Date().getTime()));
		bean.setModifiedDatetime(new Timestamp(new Date().getTime()));
		bean.setId(44445);

		model.update(bean);

	}

	private static void testAdd() throws Exception {

		RoleBean bean = new RoleBean();
		RoleModel model = new RoleModel();

		bean.setName("delete");
		bean.setDescription("delete has limited Access.");
		bean.setCreatedBy("admin");
		bean.setModifiedBy("admin");
		bean.setCreatedDatetime(new Timestamp(new Date().getTime()));
		bean.setModifiedDatetime(new Timestamp(new Date().getTime()));

		model.add(bean);

	}

	private static void testNextPk() throws Exception {

		RoleModel model = new RoleModel();

		int i = model.nextPk();

		System.out.println("NextPk is ..." + i);
	}

}

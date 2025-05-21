package in.co.rays.proj4.test;

import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;

import in.co.rays.proj4.Exception.ApplicationException;
import in.co.rays.proj4.bean.CollegeBean;
import in.co.rays.proj4.bean.MarksheetBean;
import in.co.rays.proj4.model.CollegeModel;
import in.co.rays.proj4.model.MarksheetModel;

public class TestMarksheetModel {

	public static void main(String[] args) throws Exception {

//		testNextPk();
//		testAdd();
//		testUpdate();
//		testDelete();
//		testfindByPk();
//		testfindByName();
//		testfindByRollNo();
//		testsearch();
//		testlist();
	}

	private static void testlist() throws Exception {

		MarksheetBean bean = new MarksheetBean();
		MarksheetModel model = new MarksheetModel();

		List list = new ArrayList();

		list = model.list(2, 10);

		Iterator it = list.iterator();

		while (it.hasNext()) {

			bean = (MarksheetBean) it.next();

			System.out.print("\t" + bean.getId());
			System.out.print("\t" + bean.getRollNo());
			System.out.print("\t" + bean.getStudentId());
			System.out.print("\t" + bean.getName());
			System.out.print("\t" + bean.getPhysics());
			System.out.print("\t" + bean.getChemistry());
			System.out.print("\t" + bean.getMaths());
			System.out.print("\t" + bean.getCreatedBy());
			System.out.print("\t" + bean.getModifiedBy());
			System.out.print("\t" + bean.getCreatedDatetime());
			System.out.println("\t" + bean.getModifiedDatetime());

		}
	}

	private static void testsearch() throws Exception {

		MarksheetBean bean = new MarksheetBean();
		MarksheetModel model = new MarksheetModel();

		List list = new ArrayList();

		// bean.setId(2);
		// bean.setRollNo("2012");
		// bean.setStudentId(107);
		// bean.setName("Ashwin Khatri");

		list = model.search(bean, 1, 10);

		Iterator it = list.iterator();

		while (it.hasNext()) {

			bean = (MarksheetBean) it.next();

			System.out.print("\t" + bean.getId());
			System.out.print("\t" + bean.getRollNo());
			System.out.print("\t" + bean.getStudentId());
			System.out.print("\t" + bean.getName());
			System.out.print("\t" + bean.getPhysics());
			System.out.print("\t" + bean.getChemistry());
			System.out.print("\t" + bean.getMaths());
			System.out.print("\t" + bean.getCreatedBy());
			System.out.print("\t" + bean.getModifiedBy());
			System.out.print("\t" + bean.getCreatedDatetime());
			System.out.println("\t" + bean.getModifiedDatetime());

		}
	}

	private static void testfindByRollNo() throws Exception {

		MarksheetBean bean = new MarksheetBean();
		MarksheetModel model = new MarksheetModel();

		bean = model.findByRollNo("101");

		if (bean != null) {

			System.out.print("\t" + bean.getId());
			System.out.print("\t" + bean.getRollNo());
			System.out.print("\t" + bean.getStudentId());
			System.out.print("\t" + bean.getName());
			System.out.print("\t" + bean.getPhysics());
			System.out.print("\t" + bean.getChemistry());
			System.out.print("\t" + bean.getMaths());
			System.out.print("\t" + bean.getCreatedBy());
			System.out.print("\t" + bean.getModifiedBy());
			System.out.print("\t" + bean.getCreatedDatetime());
			System.out.println("\t" + bean.getModifiedDatetime());
		} else {
			System.out.println("Invalid Roll No...");
		}
	}

	private static void testfindByName() throws Exception {

		MarksheetBean bean = new MarksheetBean();
		MarksheetModel model = new MarksheetModel();

		bean = model.findByName("Aastik");

		if (bean != null) {

			System.out.print("\t" + bean.getId());
			System.out.print("\t" + bean.getRollNo());
			System.out.print("\t" + bean.getStudentId());
			System.out.print("\t" + bean.getName());
			System.out.print("\t" + bean.getPhysics());
			System.out.print("\t" + bean.getChemistry());
			System.out.print("\t" + bean.getMaths());
			System.out.print("\t" + bean.getCreatedBy());
			System.out.print("\t" + bean.getModifiedBy());
			System.out.print("\t" + bean.getCreatedDatetime());
			System.out.println("\t" + bean.getModifiedDatetime());
		} else {
			System.out.println("Invalid Marksheet Name...");
		}
	}

	private static void testfindByPk() throws Exception {

		MarksheetBean bean = new MarksheetBean();
		MarksheetModel model = new MarksheetModel();

		bean = model.findByPk(31);

		if (bean != null) {

			System.out.print("\t" + bean.getId());
			System.out.print("\t" + bean.getRollNo());
			System.out.print("\t" + bean.getStudentId());
			System.out.print("\t" + bean.getName());
			System.out.print("\t" + bean.getPhysics());
			System.out.print("\t" + bean.getChemistry());
			System.out.print("\t" + bean.getMaths());
			System.out.print("\t" + bean.getCreatedBy());
			System.out.print("\t" + bean.getModifiedBy());
			System.out.print("\t" + bean.getCreatedDatetime());
			System.out.println("\t" + bean.getModifiedDatetime());
		} else {
			System.out.println("Invalid ID...");
		}
	}

	private static void testDelete() throws Exception {

		MarksheetBean bean = new MarksheetBean();
		MarksheetModel model = new MarksheetModel();

		bean.setId(31);

		model.delete(bean);

	}

	private static void testUpdate() throws Exception {

		MarksheetBean bean = new MarksheetBean();
		MarksheetModel model = new MarksheetModel();

		bean.setRollNo("101");
		bean.setStudentId(20251);
		bean.setName("Aastik");
		bean.setPhysics(84);
		bean.setChemistry(87);
		bean.setMaths(94);
		bean.setCreatedBy("admin");
		bean.setModifiedBy("admin");
		bean.setCreatedDatetime(new Timestamp(new Date().getTime()));
		bean.setModifiedDatetime(new Timestamp(new Date().getTime()));
		bean.setId(31);

		model.update(bean);

	}

	private static void testAdd() throws Exception {

		MarksheetBean bean = new MarksheetBean();
		MarksheetModel model = new MarksheetModel();

		bean.setRollNo("101");
		bean.setStudentId(20251);
		bean.setName("Aa");
		bean.setPhysics(84);
		bean.setChemistry(87);
		bean.setMaths(94);
		bean.setCreatedBy("admin");
		bean.setModifiedBy("admin");
		bean.setCreatedDatetime(new Timestamp(new Date().getTime()));
		bean.setModifiedDatetime(new Timestamp(new Date().getTime()));

		model.add(bean);

	}

	private static void testNextPk() throws Exception {

		MarksheetModel model = new MarksheetModel();

		int i = model.nextPk();

		System.out.println("NextPk is ..." + i);
	}

}

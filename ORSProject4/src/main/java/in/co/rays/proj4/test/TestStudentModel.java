package in.co.rays.proj4.test;

import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;

import in.co.rays.proj4.Exception.ApplicationException;
import in.co.rays.proj4.bean.CollegeBean;
import in.co.rays.proj4.bean.StudentBean;
import in.co.rays.proj4.model.StudentModel;

public class TestStudentModel {

	public static void main(String[] args) throws Exception {

//		testNextPk();
		testAdd();
//		testUpdate();
//		testDelete();
//		testfindByPk();
//		testfindByName();
//		testfindByEmail();
//		testsearch();
//		testlist();
	}

	private static void testlist() throws Exception {

		StudentBean bean = new StudentBean();
		StudentModel model = new StudentModel();

		List list = new ArrayList();

		list = model.list(1, 10);

		Iterator it = list.iterator();

		while (it.hasNext()) {

			bean = (StudentBean) it.next();

			System.out.print("\t" + bean.getId());
			System.out.print("\t" + bean.getFirstName());
			System.out.print("\t" + bean.getLastName());
			System.out.print("\t" + bean.getDob());
			System.out.print("\t" + bean.getGender());
			System.out.print("\t" + bean.getMobileNo());
			System.out.print("\t" + bean.getEmail());
			System.out.print("\t" + bean.getCollegeId());
			System.out.print("\t" + bean.getCollegeName());
			System.out.print("\t" + bean.getCreatedBy());
			System.out.print("\t" + bean.getModifiedBy());
			System.out.print("\t" + bean.getCreatedDatetime());
			System.out.println("\t" + bean.getModifiedDatetime());

		}
	}

	private static void testsearch() throws Exception {

		StudentBean bean = new StudentBean();
		StudentModel model = new StudentModel();
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");

		List list = new ArrayList();

//		bean.setId(111);
//		bean.setFirstName("Aditi");
//		bean.setLastName("Shukala");
		bean.setDob(sdf.parse("2000-09-05"));
//		bean.setGender("Female");
//		bean.setMobileNo("8200133445  ");
//		bean.setEmail("avi@gmail.com");
//		bean.setCollegeId(10);
//		bean.setCollegeName("SGSITS");

		list = model.search(bean, 1, 10);

		Iterator it = list.iterator();

		while (it.hasNext()) {

			bean = (StudentBean) it.next();

			System.out.print("\t" + bean.getId());
			System.out.print("\t" + bean.getFirstName());
			System.out.print("\t" + bean.getLastName());
			System.out.print("\t" + bean.getDob());
			System.out.print("\t" + bean.getGender());
			System.out.print("\t" + bean.getMobileNo());
			System.out.print("\t" + bean.getEmail());
			System.out.print("\t" + bean.getCollegeId());
			System.out.print("\t" + bean.getCollegeName());
			System.out.print("\t" + bean.getCreatedBy());
			System.out.print("\t" + bean.getModifiedBy());
			System.out.print("\t" + bean.getCreatedDatetime());
			System.out.println("\t" + bean.getModifiedDatetime());

		}

	}

	private static void testfindByEmail() throws Exception {

		StudentBean bean = new StudentBean();
		StudentModel model = new StudentModel();

		bean = model.findByEmail("aastik@gmail.com");

		if (bean != null) {

			System.out.print("\t" + bean.getId());
			System.out.print("\t" + bean.getFirstName());
			System.out.print("\t" + bean.getLastName());
			System.out.print("\t" + bean.getDob());
			System.out.print("\t" + bean.getGender());
			System.out.print("\t" + bean.getMobileNo());
			System.out.print("\t" + bean.getEmail());
			System.out.print("\t" + bean.getCollegeId());
			System.out.print("\t" + bean.getCollegeName());
			System.out.print("\t" + bean.getCreatedBy());
			System.out.print("\t" + bean.getModifiedBy());
			System.out.print("\t" + bean.getCreatedDatetime());
			System.out.println("\t" + bean.getModifiedDatetime());
		} else {
			System.out.println("Invalid Email...");
		}
	}

	private static void testfindByName() throws Exception {

		StudentBean bean = new StudentBean();
		StudentModel model = new StudentModel();

		bean = model.findByName("Aastik");

		if (bean != null) {

			System.out.print("\t" + bean.getId());
			System.out.print("\t" + bean.getFirstName());
			System.out.print("\t" + bean.getLastName());
			System.out.print("\t" + bean.getDob());
			System.out.print("\t" + bean.getGender());
			System.out.print("\t" + bean.getMobileNo());
			System.out.print("\t" + bean.getEmail());
			System.out.print("\t" + bean.getCollegeId());
			System.out.print("\t" + bean.getCollegeName());
			System.out.print("\t" + bean.getCreatedBy());
			System.out.print("\t" + bean.getModifiedBy());
			System.out.print("\t" + bean.getCreatedDatetime());
			System.out.println("\t" + bean.getModifiedDatetime());
		} else {
			System.out.println("Invalid Name...");
		}
	}

	private static void testfindByPk() throws Exception {

		StudentBean bean = new StudentBean();
		StudentModel model = new StudentModel();

		bean = model.findByPk(131);

		if (bean != null) {

			System.out.print("\t" + bean.getId());
			System.out.print("\t" + bean.getFirstName());
			System.out.print("\t" + bean.getLastName());
			System.out.print("\t" + bean.getDob());
			System.out.print("\t" + bean.getGender());
			System.out.print("\t" + bean.getMobileNo());
			System.out.print("\t" + bean.getEmail());
			System.out.print("\t" + bean.getCollegeId());
			System.out.print("\t" + bean.getCollegeName());
			System.out.print("\t" + bean.getCreatedBy());
			System.out.print("\t" + bean.getModifiedBy());
			System.out.print("\t" + bean.getCreatedDatetime());
			System.out.println("\t" + bean.getModifiedDatetime());
		} else {
			System.out.println("Invalid ID...");
		}
	}

	private static void testDelete() throws Exception {

		StudentBean bean = new StudentBean();
		StudentModel model = new StudentModel();

		bean.setId(131);

		model.delete(bean);

	}

	private static void testUpdate() throws Exception {

		StudentBean bean = new StudentBean();
		StudentModel model = new StudentModel();
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");

		bean.setFirstName("Aastik");
		bean.setLastName("Sahu");
		bean.setDob(sdf.parse("1998-02-03"));
		bean.setGender("Male");
		bean.setMobileNo("9669866628");
		bean.setEmail("aastik@gmail.com");
		bean.setCollegeId(1);
		bean.setCollegeName("IPS Academy");
		bean.setCreatedBy("Faculty");
		bean.setModifiedBy("Faculty");
		bean.setCreatedDatetime(new Timestamp(new Date().getTime()));
		bean.setModifiedDatetime(new Timestamp(new Date().getTime()));
		bean.setId(131);

		model.update(bean);

	}

	private static void testAdd() throws Exception {

		StudentBean bean = new StudentBean();
		StudentModel model = new StudentModel();
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");

		bean.setFirstName("Aastik");
		bean.setLastName("Sa");
		bean.setDob(sdf.parse("1998-02-03"));
		bean.setGender("Male");
		bean.setMobileNo("9669866628");
		bean.setEmail("aastik@gmail.com");
		//bean.setCollegeId(1);
		bean.setCollegeName("IPS Academy");
		bean.setCreatedBy("admin");
		bean.setModifiedBy("admin");
		bean.setCreatedDatetime(new Timestamp(new Date().getTime()));
		bean.setModifiedDatetime(new Timestamp(new Date().getTime()));

		model.add(bean);

	}

	private static void testNextPk() throws Exception {

		StudentModel model = new StudentModel();

		int i = model.nextPk();

		System.out.println("NextPk is ..." + i);
	}

}

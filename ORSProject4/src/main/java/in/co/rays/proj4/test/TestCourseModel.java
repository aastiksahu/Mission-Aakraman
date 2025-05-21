package in.co.rays.proj4.test;

import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;

import in.co.rays.proj4.Exception.ApplicationException;
import in.co.rays.proj4.bean.CollegeBean;
import in.co.rays.proj4.bean.CourseBean;
import in.co.rays.proj4.model.CollegeModel;
import in.co.rays.proj4.model.CourseModel;

public class TestCourseModel {

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
		
		CourseBean bean = new CourseBean();
		CourseModel model = new CourseModel();

		List list = new ArrayList();
		
		list = model.list(2, 3);

		Iterator it = list.iterator();

		while (it.hasNext()) {

			bean = (CourseBean) it.next();

			System.out.print("\t" + bean.getId());
			System.out.print("\t" + bean.getName());
			System.out.print("\t" + bean.getDuration());
			System.out.print("\t" + bean.getDescription());
			System.out.print("\t" + bean.getCreatedBy());
			System.out.print("\t" + bean.getModifiedBy());
			System.out.print("\t" + bean.getCreatedDatetime());
			System.out.println("\t" + bean.getModifiedDatetime());

		}
	}

	private static void testsearch() throws Exception {

		CourseBean bean = new CourseBean();
		CourseModel model = new CourseModel();

		List list = new ArrayList();

		// bean.setId(33);
		// bean.setName("BCA");
		// bean.setDescription("Placement Training");
		// bean.setDuration("3 Year");

		list = model.search(bean, 1, 10);

		Iterator it = list.iterator();

		while (it.hasNext()) {

			bean = (CourseBean) it.next();

			System.out.print("\t" + bean.getId());
			System.out.print("\t" + bean.getName());
			System.out.print("\t" + bean.getDuration());
			System.out.print("\t" + bean.getDescription());
			System.out.print("\t" + bean.getCreatedBy());
			System.out.print("\t" + bean.getModifiedBy());
			System.out.print("\t" + bean.getCreatedDatetime());
			System.out.println("\t" + bean.getModifiedDatetime());

		}

	}

	private static void testfindByName() throws Exception {

		CourseBean bean = new CourseBean();
		CourseModel model = new CourseModel();

		bean = model.findByName("B.Tech");

		if (bean != null) {

			System.out.print("\t" + bean.getId());
			System.out.print("\t" + bean.getName());
			System.out.print("\t" + bean.getDuration());
			System.out.print("\t" + bean.getDescription());
			System.out.print("\t" + bean.getCreatedBy());
			System.out.print("\t" + bean.getModifiedBy());
			System.out.print("\t" + bean.getCreatedDatetime());
			System.out.println("\t" + bean.getModifiedDatetime());
		} else {
			System.out.println("Inalid Course Name...");
		}
	}

	private static void testfindByPk() throws Exception {

		CourseBean bean = new CourseBean();
		CourseModel model = new CourseModel();

		bean = model.findByPk(11);

		if (bean != null) {

			System.out.print("\t" + bean.getId());
			System.out.print("\t" + bean.getName());
			System.out.print("\t" + bean.getDuration());
			System.out.print("\t" + bean.getDescription());
			System.out.print("\t" + bean.getCreatedBy());
			System.out.print("\t" + bean.getModifiedBy());
			System.out.print("\t" + bean.getCreatedDatetime());
			System.out.println("\t" + bean.getModifiedDatetime());
		} else {
			System.out.println("Inalid ID...");
		}
	}

	private static void testDelete() throws Exception {

		CourseBean bean = new CourseBean();
		CourseModel model = new CourseModel();

		bean.setId(56);

		model.delete(bean);

	}

	private static void testUpdate() throws Exception {

		CourseBean bean = new CourseBean();
		CourseModel model = new CourseModel();

		bean.setName("B.Tec");
		bean.setDuration("4 Year");
		bean.setDescription("B.Tech in Computer Science");
		bean.setCreatedBy("admin");
		bean.setModifiedBy("admin");
		bean.setCreatedDatetime(new Timestamp(new Date().getTime()));
		bean.setModifiedDatetime(new Timestamp(new Date().getTime()));
		bean.setId(56);

		model.update(bean);

	}

	private static void testAdd() throws Exception {

		CourseBean bean = new CourseBean();
		CourseModel model = new CourseModel();

		bean.setName("Bed");
		bean.setDuration("4 Year");
		bean.setDescription("B.Tech in Computer");
		bean.setCreatedBy("admin");
		bean.setModifiedBy("admin");
		bean.setCreatedDatetime(new Timestamp(new Date().getTime()));
		bean.setModifiedDatetime(new Timestamp(new Date().getTime()));

		model.add(bean);

	}

	private static void testNextPk() throws Exception {

		CourseModel model = new CourseModel();

		int i = model.nextPk();

		System.out.println("NextPk is ..." + i);
	}

}

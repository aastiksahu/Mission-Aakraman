package in.co.rays.proj4.test;

import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;

import in.co.rays.proj4.Exception.ApplicationException;
import in.co.rays.proj4.bean.CollegeBean;
import in.co.rays.proj4.bean.StudentBean;
import in.co.rays.proj4.bean.SubjectBean;
import in.co.rays.proj4.model.CollegeModel;
import in.co.rays.proj4.model.SubjectModel;

public class TestSubjectModel {
	
	public static void main(String[] args) throws Exception {

//		testNextPk();
//		testAdd();
//		testUpdate();
//		testDelete();
//		testfindByPk();
		testfindByName();
//		testsearch();
//		testlist();
	}

	private static void testlist() throws Exception {
		
		SubjectBean bean = new SubjectBean();
		SubjectModel model = new SubjectModel();

		List list = new ArrayList();
		
		list = model.list(1, 10);

		Iterator it = list.iterator();

		while (it.hasNext()) {

			bean = (SubjectBean) it.next();

			System.out.print("\t" + bean.getId());
			System.out.print("\t" + bean.getName());
			System.out.print("\t" + bean.getCourseId());
			System.out.print("\t" + bean.getCourseName());
			System.out.print("\t" + bean.getDescription());
			System.out.print("\t" + bean.getCreatedBy());
			System.out.print("\t" + bean.getModifiedBy());
			System.out.print("\t" + bean.getCreatedDatetime());
			System.out.println("\t" + bean.getModifiedDatetime());

		}
	}

	private static void testsearch() throws Exception {
		
		SubjectBean bean = new SubjectBean();
		SubjectModel model = new SubjectModel();

		List list = new ArrayList();
		
		//bean.setId(9001);
		//bean.setName("Maths");
		//bean.setCourseId(22);
		//bean.setCourseName("B.Tech");
		//bean.setDescription("Corporate Java is a Placement training course");
		
		list = model.search(bean, 1, 10);

		Iterator it = list.iterator();

		while (it.hasNext()) {

			bean = (SubjectBean) it.next();

			System.out.print("\t" + bean.getId());
			System.out.print("\t" + bean.getName());
			System.out.print("\t" + bean.getCourseId());
			System.out.print("\t" + bean.getCourseName());
			System.out.print("\t" + bean.getDescription());
			System.out.print("\t" + bean.getCreatedBy());
			System.out.print("\t" + bean.getModifiedBy());
			System.out.print("\t" + bean.getCreatedDatetime());
			System.out.println("\t" + bean.getModifiedDatetime());

		}
	}

	private static void testfindByName() throws Exception {
		
		SubjectBean bean = new SubjectBean();
		SubjectModel model = new SubjectModel();

		bean = model.findByName("Chemistry");

		if (bean != null) {

			System.out.print("\t" + bean.getId());
			System.out.print("\t" + bean.getName());
			System.out.print("\t" + bean.getCourseId());
			System.out.print("\t" + bean.getCourseName());
			System.out.print("\t" + bean.getDescription());
			System.out.print("\t" + bean.getCreatedBy());
			System.out.print("\t" + bean.getModifiedBy());
			System.out.print("\t" + bean.getCreatedDatetime());
			System.out.println("\t" + bean.getModifiedDatetime());
		} else {
			System.out.println("Invalid Subject Name...");
		}
	}

	private static void testfindByPk() throws Exception {
		
		SubjectBean bean = new SubjectBean();
		SubjectModel model = new SubjectModel();

		bean = model.findByPk(4002);

		if (bean != null) {

			System.out.print("\t" + bean.getId());
			System.out.print("\t" + bean.getName());
			System.out.print("\t" + bean.getCourseId());
			System.out.print("\t" + bean.getCourseName());
			System.out.print("\t" + bean.getDescription());
			System.out.print("\t" + bean.getCreatedBy());
			System.out.print("\t" + bean.getModifiedBy());
			System.out.print("\t" + bean.getCreatedDatetime());
			System.out.println("\t" + bean.getModifiedDatetime());
		} else {
			System.out.println("Invalid Subject Name...");
		}
	}

	private static void testDelete() throws Exception {

		SubjectBean bean = new SubjectBean();
		SubjectModel model = new SubjectModel();

		bean.setId(9004);

		model.delete(bean);

	}

	private static void testUpdate() throws Exception {

		SubjectBean bean = new SubjectBean();
		SubjectModel model = new SubjectModel();

		bean.setName("Aastik");
		bean.setCourseId(22);
		bean.setCourseName("Corporate Java");
		bean.setDescription("Corporate Java is a Placement training course");
		bean.setCreatedBy("admin");
		bean.setModifiedBy("admin");
		bean.setCreatedDatetime(new Timestamp(new Date().getTime()));
		bean.setModifiedDatetime(new Timestamp(new Date().getTime()));
		bean.setId(9004);

		model.update(bean);

	}

	private static void testAdd() throws Exception {

		SubjectBean bean = new SubjectBean();
		SubjectModel model = new SubjectModel();

		bean.setName("Aas");
		//bean.setCourseId(11);
		bean.setCourseName("Corporate Java");
		bean.setDescription("Corporate Java is a Placement training course");
		bean.setCreatedBy("admin");
		bean.setModifiedBy("admin");
		bean.setCreatedDatetime(new Timestamp(new Date().getTime()));
		bean.setModifiedDatetime(new Timestamp(new Date().getTime()));

		model.add(bean);

	}

	private static void testNextPk() throws Exception {

		SubjectModel model = new SubjectModel();

		int i = model.nextPk();

		System.out.println("NextPk is ..." + i);
	}

}

package in.co.rays.proj4.test;

import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;

import in.co.rays.proj4.Exception.ApplicationException;
import in.co.rays.proj4.bean.FacultyBean;
import in.co.rays.proj4.model.FacultyModel;

public class TestFacultyModel {

	public static void main(String[] args) throws Exception {

//		testNextPk();
//		testAdd();
//		testUpdate();
//		testDelete();
//		testfindByPk();
//		testfindByName();
//		testfindbyEmail();
		testsearch();
//		testlist();
	}

	private static void testlist() throws Exception {
		
		FacultyBean bean = new FacultyBean();
		FacultyModel model = new FacultyModel();

		List list = new ArrayList();
		
		list = model.list(1, 10);

		Iterator it = list.iterator();

		while (it.hasNext()) {

			bean = (FacultyBean) it.next();

			System.out.print("\t" + bean.getId());
			System.out.print("\t" + bean.getFirstName());
			System.out.print("\t" + bean.getLastName());
			System.out.print("\t" + bean.getDob());
			System.out.print("\t" + bean.getGender());
			System.out.print("\t" + bean.getMobileNo());
			System.out.print("\t" + bean.getEmail());
			System.out.print("\t" + bean.getCollegeId());
			System.out.print("\t" + bean.getCollegeName());
			System.out.print("\t" + bean.getCourseId());
			System.out.print("\t" + bean.getCourseName());
			System.out.print("\t" + bean.getSubjectId());
			System.out.print("\t" + bean.getSubjectName());
			System.out.print("\t" + bean.getCreatedBy());
			System.out.print("\t" + bean.getModifiedBy());
			System.out.print("\t" + bean.getCreatedDatetime());
			System.out.println("\t" + bean.getModifiedDatetime());

		}
	}

	private static void testsearch() throws Exception {

		FacultyBean bean = new FacultyBean();
		FacultyModel model = new FacultyModel();
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");

		List list = new ArrayList();

		// bean.setId(700016);
		// bean.setFirstName("Mamta");
		// bean.setLastName("Sahu");
		   bean.setDob(sdf.parse("2000-04-12"));
		// bean.setGender("Female");
		// bean.setMobileNo("9827071414");
		// bean.setEmail("kalpana@gmail.com");
		// bean.setCollegeId(11);
		// bean.setCollegeName("Rays");
		// bean.setCourseId(33);
		// bean.setCourseName("BCA");
		// bean.setSubjectId(7002);
		// bean.setSubjectName("Physics");

		list = model.search(bean, 1, 10);

		Iterator it = list.iterator();

		while (it.hasNext()) {

			bean = (FacultyBean) it.next();

			System.out.print("\t" + bean.getId());
			System.out.print("\t" + bean.getFirstName());
			System.out.print("\t" + bean.getLastName());
			System.out.print("\t" + bean.getDob());
			System.out.print("\t" + bean.getGender());
			System.out.print("\t" + bean.getMobileNo());
			System.out.print("\t" + bean.getEmail());
			System.out.print("\t" + bean.getCollegeId());
			System.out.print("\t" + bean.getCollegeName());
			System.out.print("\t" + bean.getCourseId());
			System.out.print("\t" + bean.getCourseName());
			System.out.print("\t" + bean.getSubjectId());
			System.out.print("\t" + bean.getSubjectName());
			System.out.print("\t" + bean.getCreatedBy());
			System.out.print("\t" + bean.getModifiedBy());
			System.out.print("\t" + bean.getCreatedDatetime());
			System.out.println("\t" + bean.getModifiedDatetime());
		}

	}

	private static void testfindbyEmail() throws Exception {

		FacultyBean bean = new FacultyBean();
		FacultyModel model = new FacultyModel();

		bean = model.findByEmail("kalpana@gmail.com");

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
			System.out.print("\t" + bean.getCourseId());
			System.out.print("\t" + bean.getCourseName());
			System.out.print("\t" + bean.getSubjectId());
			System.out.print("\t" + bean.getSubjectName());
			System.out.print("\t" + bean.getCreatedBy());
			System.out.print("\t" + bean.getModifiedBy());
			System.out.print("\t" + bean.getCreatedDatetime());
			System.out.println("\t" + bean.getModifiedDatetime());
		} else {
			System.out.println("Invalid Faculty Email...");
		}
	}

	private static void testfindByName() throws Exception {

		FacultyBean bean = new FacultyBean();
		FacultyModel model = new FacultyModel();

		bean = model.findByName("Mamta");

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
			System.out.print("\t" + bean.getCourseId());
			System.out.print("\t" + bean.getCourseName());
			System.out.print("\t" + bean.getSubjectId());
			System.out.print("\t" + bean.getSubjectName());
			System.out.print("\t" + bean.getCreatedBy());
			System.out.print("\t" + bean.getModifiedBy());
			System.out.print("\t" + bean.getCreatedDatetime());
			System.out.println("\t" + bean.getModifiedDatetime());
		} else {
			System.out.println("Invalid Faculty Name...");
		}
	}

	private static void testfindByPk() throws Exception {

		FacultyBean bean = new FacultyBean();
		FacultyModel model = new FacultyModel();

		bean = model.findByPk(700016);

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
			System.out.print("\t" + bean.getCourseId());
			System.out.print("\t" + bean.getCourseName());
			System.out.print("\t" + bean.getSubjectId());
			System.out.print("\t" + bean.getSubjectName());
			System.out.print("\t" + bean.getCreatedBy());
			System.out.print("\t" + bean.getModifiedBy());
			System.out.print("\t" + bean.getCreatedDatetime());
			System.out.println("\t" + bean.getModifiedDatetime());
		} else {
			System.out.println("Invalid ID...");
		}
	}

	private static void testDelete() throws Exception {

		FacultyBean bean = new FacultyBean();
		FacultyModel model = new FacultyModel();

		bean.setId(700016);

		model.delete(bean);

	}

	private static void testUpdate() throws Exception {

		FacultyBean bean = new FacultyBean();
		FacultyModel model = new FacultyModel();
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");

		bean.setFirstName("Mamta");
		bean.setLastName("Sahu");
		bean.setDob(sdf.parse("1976-12-20"));
		bean.setGender("Female");
		bean.setMobileNo("9407126877");
		bean.setEmail("kalpana@gmail.com");
		bean.setCollegeId(1);
		bean.setCollegeName("Rays");
		bean.setCourseId(33);
		bean.setCourseName("Corporate Java");
		bean.setSubjectId(4003);
		bean.setSubjectName("Core Java");
		bean.setCreatedBy("admin");
		bean.setModifiedBy("admin");
		bean.setCreatedDatetime(new Timestamp(new Date().getTime()));
		bean.setModifiedDatetime(new Timestamp(new Date().getTime()));
		bean.setId(700016);

		model.update(bean);

	}

	private static void testAdd() throws Exception {

		FacultyBean bean = new FacultyBean();
		FacultyModel model = new FacultyModel();
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");

		bean.setFirstName("Kalpana");
		bean.setLastName("Sahu");
		bean.setDob(sdf.parse("1976-12-20"));
		bean.setGender("Female");
		bean.setMobileNo("9407126877");
		bean.setEmail("kalpana@gmail.com");
		bean.setCollegeId(1);
		//bean.setCollegeName("Rays");
		bean.setCourseId(33);
		//bean.setCourseName("Corporate Java");
		bean.setSubjectId(4003);
		//bean.setSubjectName("Core Java");
		bean.setCreatedBy("admin");
		bean.setModifiedBy("admin");
		bean.setCreatedDatetime(new Timestamp(new Date().getTime()));
		bean.setModifiedDatetime(new Timestamp(new Date().getTime()));

		model.add(bean);

	}

	private static void testNextPk() throws Exception {

		FacultyModel model = new FacultyModel();

		int i = model.nextPk();

		System.out.println("NextPk is ..." + i);
	}

}

package in.co.rays.proj4.test;

import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;

import in.co.rays.proj4.Exception.ApplicationException;
import in.co.rays.proj4.bean.FacultyBean;
import in.co.rays.proj4.bean.TimeTableBean;
import in.co.rays.proj4.model.FacultyModel;
import in.co.rays.proj4.model.TimeTableModel;

public class TestTimeTableModel {
	
	public static void main(String[] args) throws Exception {

//		testNextPk();
		testAdd();
//		testUpdate();
//		testDelete();
//		testfindByPk();
//		testsearch();
//		testlist();
	}

	private static void testlist() throws Exception {
		
		TimeTableBean bean = new TimeTableBean();
		TimeTableModel model = new TimeTableModel();

		List list = new ArrayList();
		
		list = model.list(1, 10);

		Iterator it = list.iterator();

		while (it.hasNext()) {

			bean = (TimeTableBean) it.next();

			System.out.print("\t" + bean.getId());
			System.out.print("\t" + bean.getSemester());
			System.out.print("\t" + bean.getDescription());
			System.out.print("\t" + bean.getExamDate());
			System.out.print("\t" + bean.getExamTime());
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
		
		TimeTableBean bean = new TimeTableBean();
		TimeTableModel model = new TimeTableModel();
		
		List list = new ArrayList();

		// bean.setId(771);
		// bean.setSemester("8th");
		// bean.setDescription("Placement Training");
		// bean.setExamTime("9 to 12");
		// bean.setCourseId(11);
		// bean.setCourseName("Corporate Java");
		// bean.setSubjectId(4001);
		// bean.setSubjectName("Physics");

		list = model.search(bean, 1, 10);

		Iterator it = list.iterator();

		while (it.hasNext()) {

			bean = (TimeTableBean) it.next();

			System.out.print("\t" + bean.getId());
			System.out.print("\t" + bean.getSemester());
			System.out.print("\t" + bean.getDescription());
			System.out.print("\t" + bean.getExamDate());
			System.out.print("\t" + bean.getExamTime());
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

	private static void testfindByPk() throws Exception {
		
		TimeTableBean bean = new TimeTableBean();
		TimeTableModel model = new TimeTableModel();
		
		bean = model.findByPk(767);

		if (bean != null) {

			System.out.print("\t" + bean.getId());
			System.out.print("\t" + bean.getSemester());
			System.out.print("\t" + bean.getDescription());
			System.out.print("\t" + bean.getExamDate());
			System.out.print("\t" + bean.getExamTime());
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

		TimeTableBean bean = new TimeTableBean();
		TimeTableModel model = new TimeTableModel();

		bean.setId(784);

		model.delete(bean);

	}

	private static void testUpdate() throws Exception {

		TimeTableBean bean = new TimeTableBean();
		TimeTableModel model = new TimeTableModel();
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		
		bean.setSemester("8th");
		bean.setDescription("Last Semester");
		bean.setExamDate(sdf.parse("2025-06-14"));
		bean.setExamTime("9 to 12");
		bean.setCourseId(1);
		bean.setCourseName("Corporate Java");
		bean.setSubjectId(12);
		bean.setSubjectName("Core Java");
		bean.setCreatedBy("admin");
		bean.setModifiedBy("admin");
		bean.setCreatedDatetime(new Timestamp(new Date().getTime()));
		bean.setModifiedDatetime(new Timestamp(new Date().getTime()));
		bean.setId(784);

		model.update(bean);

	}

	private static void testAdd() throws Exception {

		TimeTableBean bean = new TimeTableBean();
		TimeTableModel model = new TimeTableModel();
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");

		bean.setSemester("6th");
		bean.setDescription("Semester");
		bean.setExamDate(sdf.parse("2025-06-14"));
		bean.setExamTime("9 to 12");
		bean.setCourseId(11);
		bean.setCourseName("Corporate Java");
		//bean.setSubjectId(1001);
		bean.setSubjectName("Physics");
		bean.setCreatedBy("admin");
		bean.setModifiedBy("admin");
		bean.setCreatedDatetime(new Timestamp(new Date().getTime()));
		bean.setModifiedDatetime(new Timestamp(new Date().getTime()));

		model.add(bean);

	}

	private static void testNextPk() throws Exception {
		
		TimeTableModel model = new TimeTableModel();

		int i = model.nextPk();

		System.out.println("NextPk is ..." + i);
	}

}

package in.co.rays.proj4.model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import javax.security.auth.Subject;

import in.co.rays.proj4.Exception.ApplicationException;
import in.co.rays.proj4.Exception.DataBaseException;
import in.co.rays.proj4.Exception.DuplicateRecordException;
import in.co.rays.proj4.bean.CollegeBean;
import in.co.rays.proj4.bean.CourseBean;
import in.co.rays.proj4.bean.SubjectBean;
import in.co.rays.proj4.util.JDBCDataSource;

public class SubjectModel {
	
	/**
	 * Find next PK of Subject
	 *
	 * @throws DatabaseException
	 */
	public Integer nextPk() throws Exception {
		Connection conn = null;
		int pk = 0;

		try {
			conn = JDBCDataSource.getConnection();

			PreparedStatement pstmt = conn.prepareStatement("SELECT MAX(ID) FROM ST_SUBJECT");

			ResultSet rs = pstmt.executeQuery();

			while (rs.next()) {
				pk = rs.getInt(1);
			}
			rs.close();
			pstmt.close();

		} catch (Exception e) {

			throw new DataBaseException("Exceptio :Exception in getting PK");

		} finally {

			JDBCDataSource.closeConnection(conn);
		}
		return pk + 1;
	}
	
	/**
	 * Add a Subject
	 *
	 * @param bean
	 * @throws DatabaseException
	 *
	 */
	public long add(SubjectBean bean) throws Exception {
		
		CourseBean courseBean = new CourseBean();
		CourseModel courseModel = new CourseModel();

		Connection conn = null;
		int pk = 0;
		
		if (bean.getCourseId() > 0) {

			courseBean = courseModel.findByPk(bean.getCourseId());
			bean.setCourseName(courseBean.getName());
			
		}else if (bean.getCourseName() != null && bean.getCourseName().length() > 0) {

			courseBean = courseModel.findByName(bean.getCourseName());
			bean.setCourseId(courseBean.getId());
		}
		
		SubjectBean duplicateSubjectName = findByName(bean.getName());

		if (duplicateSubjectName != null && duplicateSubjectName.getId() != bean.getId()) {
			throw new DuplicateRecordException("Subject Name Already Exists");
		}

		try {
			conn = JDBCDataSource.getConnection();
			pk = nextPk();
			conn.setAutoCommit(false);

			PreparedStatement pstmt = conn.prepareStatement("insert into st_subject values(?,?,?,?,?,?,?,?,?)");

			pstmt.setLong(1, nextPk());
			pstmt.setString(2, bean.getName());
			pstmt.setLong(3, bean.getCourseId());
			pstmt.setString(4, bean.getCourseName());
			pstmt.setString(5, bean.getDescription());
			pstmt.setString(6, bean.getCreatedBy());
			pstmt.setString(7, bean.getModifiedBy());
			pstmt.setTimestamp(8, bean.getCreatedDatetime());
			pstmt.setTimestamp(9, bean.getModifiedDatetime());

			int i = pstmt.executeUpdate();

			conn.commit();
			pstmt.close();
			System.out.println("Data Added Successfully...." + i);

		} catch (Exception e) {
			try {
				conn.rollback();
			} catch (Exception ex) {
				ex.printStackTrace();
				throw new ApplicationException("Exception : Add RollBack Exception" + ex.getMessage());
			}
			throw new ApplicationException("Exception : Exception in Add Student");
		} finally {
			JDBCDataSource.closeConnection(conn);
		}
		return pk;

	}
	
	/**
	 * Update a Subject
	 *
	 * @param bean
	 * @throws DatabaseException
	 */
	public void update(SubjectBean bean) throws Exception {
		
		CourseBean courseBean = new CourseBean();
		CourseModel courseModel = new CourseModel();

		Connection conn = null;
		
		if (bean.getCourseId() > 0) {

			courseBean = courseModel.findByPk(bean.getCourseId());
			bean.setCourseName(courseBean.getName());
			
		}else if (bean.getCourseName() != null && bean.getCourseName().length() > 0) {

			courseBean = courseModel.findByName(bean.getCourseName());
			bean.setCourseId(courseBean.getId());
		}
		
		SubjectBean duplicateSubjectName = findByName(bean.getName());
		
		// Check if updated College already exist
		if (duplicateSubjectName != null && duplicateSubjectName.getId() != bean.getId()) {
			throw new DuplicateRecordException("Subject Name Already Exists");
		}
		
		try {
			conn = JDBCDataSource.getConnection();

			conn.setAutoCommit(false);// Begin transaction

			PreparedStatement pstmt = conn.prepareStatement(
					"update st_subject set name = ?, course_id = ?, course_name = ?, description = ?, created_by = ?, modified_by = ?, created_datetime = ?, modified_datetime = ? where id = ?");

			pstmt.setString(1, bean.getName());
			pstmt.setLong(2, bean.getCourseId());
			pstmt.setString(3, bean.getCourseName());
			pstmt.setString(4, bean.getDescription());
			pstmt.setString(5, bean.getCreatedBy());
			pstmt.setString(6, bean.getModifiedBy());
			pstmt.setTimestamp(7, bean.getCreatedDatetime());
			pstmt.setTimestamp(8, bean.getModifiedDatetime());
			pstmt.setLong(9, bean.getId());

			int i = pstmt.executeUpdate();

			conn.commit();// End transaction
			pstmt.close();
			
			System.out.println("Data Updated Successfully..." + i);

		} catch (Exception e) {
			try {
				conn.rollback();
			}catch(Exception ex) {
				throw new ApplicationException("Exception : Update RollBack Exception " + ex.getMessage());
			}
			// throw new ApplicationException("Exception in updating Student ");
		}finally {
			JDBCDataSource.closeConnection(conn);
		}

	}
	
	/**
	 * Delete a Subject
	 *
	 * @param bean
	 * @throws DatabaseException
	 */
	public void delete(SubjectBean bean) throws Exception {

		Connection conn = null;

		try {
			conn = JDBCDataSource.getConnection();

			conn.setAutoCommit(false);

			PreparedStatement pstmt = conn.prepareStatement("delete from st_subject where id = ?");

			pstmt.setLong(1, bean.getId());

			int i = pstmt.executeUpdate();

			conn.commit();
			pstmt.close();

			System.out.println("Data Deleted Successfully..." + i);

		} catch (Exception e) {

			try {
				conn.rollback();

			} catch (Exception ex) {

				throw new ApplicationException("Exception :Delete rollback exception" + ex.getMessage());
			}
			throw new ApplicationException("Exception : Exception in delete Subject");
		} finally {

			JDBCDataSource.closeConnection(conn);
		}

	}

	/**
	 * Find User by SubjectPk
	 *
	 * @param pk : get parameter
	 * @return bean
	 * @throws DatabaseException
	 */
	public SubjectBean findByPk(long pk) throws ApplicationException {

		StringBuffer sql = new StringBuffer("select * from st_subject where id = ?");
		SubjectBean bean = null;
		Connection conn = null;
		try {
			conn = JDBCDataSource.getConnection();

			PreparedStatement pstmt = conn.prepareStatement(sql.toString());
			pstmt.setLong(1, pk);
			ResultSet rs = pstmt.executeQuery();

			while (rs.next()) {

				bean = new SubjectBean();

				bean.setId(rs.getLong(1));
				bean.setName(rs.getString(2));
				bean.setCourseId(rs.getLong(3));
				bean.setCourseName(rs.getString(4));
				bean.setDescription(rs.getString(5));
				bean.setCreatedBy(rs.getString(6));
				bean.setModifiedBy(rs.getString(7));
				bean.setCreatedDatetime(rs.getTimestamp(8));
				bean.setModifiedDatetime(rs.getTimestamp(9));
			}
			rs.close();
			pstmt.close();
		} catch (Exception e) {

			throw new ApplicationException("Exception : Exception is getting Subject byPK");
		} finally {

			JDBCDataSource.closeConnection(conn);
		}
		return bean;
	}

	/**
	 * Find User by SubjectName
	 *
	 * @param login : get parameter
	 * @return bean
	 * @throws DatabaseException
	 */
	public SubjectBean findByName(String Name) throws ApplicationException {

		StringBuffer sql = new StringBuffer("select * from st_subject where name = ?");
		SubjectBean bean = null;
		Connection conn = null;

		try {
			conn = JDBCDataSource.getConnection();

			PreparedStatement pstmt = conn.prepareStatement(sql.toString());
			pstmt.setString(1, Name);
			ResultSet rs = pstmt.executeQuery();

			while (rs.next()) {

				bean = new SubjectBean();

				bean.setId(rs.getLong(1));
				bean.setName(rs.getString(2));
				bean.setCourseId(rs.getLong(3));
				bean.setCourseName(rs.getString(4));
				bean.setDescription(rs.getString(5));
				bean.setCreatedBy(rs.getString(6));
				bean.setModifiedBy(rs.getString(7));
				bean.setCreatedDatetime(rs.getTimestamp(8));
				bean.setModifiedDatetime(rs.getTimestamp(9));
			}
			rs.close();
			pstmt.close();
		} catch (Exception e) {

			throw new ApplicationException("Exception : Exception is getting Subject by Name");
		} finally {

			JDBCDataSource.closeConnection(conn);
		}
		return bean;
	}
	
	/**
	 * Search Subject with pagination
	 *
	 * @return list : List of Subject
	 * @param bean     : Search Parameters
	 * @param pageNo   : Current Page No.
	 * @param pageSize : Size of Page
	 *
	 * @throws DatabaseException
	 */
	public List search(SubjectBean bean, int pageNo, int PageSize) throws ApplicationException {

		StringBuffer sql = new StringBuffer("select * from st_subject where 1=1");

		if (bean != null) {

			if (bean.getId() > 0) {
				sql.append(" and id = " + bean.getId());
			}
			if (bean.getName() != null && bean.getName().length() > 0) {
				sql.append(" and name like '" + bean.getName() + "%'");
			}
			if (bean.getCourseId() > 0) {
				sql.append(" and course_id = " + bean.getCourseId());
			}
			if (bean.getCourseName() != null && bean.getCourseName().length() > 0) {
				sql.append(" and course_name like '" + bean.getCourseName() + "%'");
			}
			if (bean.getDescription() != null && bean.getDescription().length() > 0) {
				sql.append(" and description like '" + bean.getDescription() + "%'");
			}
		}
		// if page size is greater than zero then apply pagination
		if (PageSize > 0) {
			// Calculate start record index
			pageNo = (pageNo - 1) * PageSize;
			sql.append(" limit " + pageNo + "," + PageSize);
		}
		System.out.println(sql.toString());
		List list = new ArrayList();

		Connection conn = null;

		try {
			conn = JDBCDataSource.getConnection();
			PreparedStatement pstmt = conn.prepareStatement(sql.toString());
			ResultSet rs = pstmt.executeQuery();

			while (rs.next()) {

				bean = new SubjectBean();

				bean.setId(rs.getLong(1));
				bean.setName(rs.getString(2));
				bean.setCourseId(rs.getLong(3));
				bean.setCourseName(rs.getString(4));
				bean.setDescription(rs.getString(5));
				bean.setCreatedBy(rs.getString(6));
				bean.setModifiedBy(rs.getString(7));
				bean.setCreatedDatetime(rs.getTimestamp(8));
				bean.setModifiedDatetime(rs.getTimestamp(9));

				list.add(bean);
			}
			rs.close();
			pstmt.close();

		} catch (Exception e) {
			e.printStackTrace();
			throw new ApplicationException("Exception : Exception in Search Subject");
		} finally {
			JDBCDataSource.closeConnection(conn);
		}
		return list;

	}
	
	/**
	 * Get List of Subject with pagination
	 *
	 * @return list : List of Subject
	 * @param pageNo   : Current Page No.
	 * @param pageSize : Size of Page
	 * @throws ApplicationException 
	 * @throws DatabaseException
	 */
	public List list(int pageNo, int pageSize) throws ApplicationException {
		
		ArrayList list = new ArrayList();
		StringBuffer sql = new StringBuffer("select * from st_subject");
		// if page size is greater than zero then apply pagination
		if (pageSize > 0) {
			// Calculate start record index
			pageNo = (pageNo -1) * pageSize;
			sql.append(" limit " + pageNo + "," + pageSize);
		}
		
		Connection conn = null;
		SubjectBean bean = null;
		
		try {
			conn = JDBCDataSource.getConnection();
			PreparedStatement pstmt = conn.prepareStatement(sql.toString());
			ResultSet rs = pstmt.executeQuery();
			
			while (rs.next()) {
				
				bean = new SubjectBean();
				
				bean.setId(rs.getLong(1));
				bean.setName(rs.getString(2));
				bean.setCourseId(rs.getLong(3));
				bean.setCourseName(rs.getString(4));
				bean.setDescription(rs.getString(5));
				bean.setCreatedBy(rs.getString(6));
				bean.setModifiedBy(rs.getString(7));
				bean.setCreatedDatetime(rs.getTimestamp(8));
				bean.setModifiedDatetime(rs.getTimestamp(9));
				
				list.add(bean);
			}
			rs.close();
		} catch (Exception e) {
			throw new ApplicationException("Exception : Exception in getting list of Subject");
		}finally {
			JDBCDataSource.closeConnection(conn);
		}
		return list;
	}

}

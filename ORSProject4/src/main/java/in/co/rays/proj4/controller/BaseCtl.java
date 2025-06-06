package in.co.rays.proj4.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import in.co.rays.proj4.Exception.ApplicationException;
import in.co.rays.proj4.bean.BaseBean;
import in.co.rays.proj4.bean.RoleBean;
import in.co.rays.proj4.bean.UserBean;
import in.co.rays.proj4.model.RoleModel;
import in.co.rays.proj4.util.DataUtility;
import in.co.rays.proj4.util.DataValidator;
import in.co.rays.proj4.util.ServletUtility;

/**
 * Base controller class of project. It contain (1) Generic operations (2)
 * Generic constants (3) Generic work flow
 *
 * @author Aastik Sahu
 *
 */
public abstract class BaseCtl extends HttpServlet {

	public static final String OP_SAVE = "Save";
	public static final String OP_CANCEL = "Cancel";
	public static final String OP_DELETE = "Delete";
	public static final String OP_LIST = "List";
	public static final String OP_SEARCH = "Search";
	public static final String OP_VIEW = "View";
	public static final String OP_NEXT = "Next";
	public static final String OP_PREVIOUS = "Previous";
	public static final String OP_NEW = "New";
	public static final String OP_GO = "Go";
	public static final String OP_BACK = "Back";
	public static final String OP_LOG_OUT = "Logout";
	public static final String OP_RESET = "Reset";
	public static final String OP_UPDATE = "update";

	/**
	 * Success message key constant
	 */
	public static final String MSG_SUCCESS = "success";

	/**
	 * Error message key constant
	 */
	public static final String MSG_ERROR = "error";

	/**
	 * Validates input data entered by User
	 *
	 * @param request
	 * @return
	 */
	protected boolean validate(HttpServletRequest request) {
		return true;
	}

	/**
	 * Loads list and other data required to display at HTML form
	 *
	 * @param request
	 */
	protected void preload(HttpServletRequest request) {
	}

	/**
	 * Populates bean object from request parameters
	 *
	 * @param request
	 * @return
	 */
	protected BaseBean populateBean(HttpServletRequest request) {
		return null;
	}

	/**
	 * Populates Generic attributes in DTO
	 *
	 * @param dto
	 * @param request
	 * @return
	 */
	protected BaseBean populateDTO(BaseBean dto, HttpServletRequest request) {

		RoleModel rModel = new RoleModel();
		RoleBean rBean = new RoleBean();
		String createdBy = request.getParameter("createdBy");
		String modifiedBy = null;
		long roleId = 0;

		UserBean userbean = (UserBean) request.getSession().getAttribute("user");

		if (userbean == null) {
			// If record is created without login
			createdBy = "root";
			modifiedBy = "root";
		} else {
			try {

				roleId = userbean.getRoleId();
				rBean = rModel.findByPk(roleId);
				modifiedBy = rBean.getName();

			} catch (ApplicationException e) {
				e.printStackTrace();

			}
			// If record is created first time
			if ("null".equalsIgnoreCase(createdBy) || DataValidator.isNull(createdBy)) {
				createdBy = modifiedBy;
			}

		}

		dto.setCreatedBy(createdBy);
		dto.setModifiedBy(modifiedBy);

		long cdt = DataUtility.getLong(request.getParameter("createdDatetime"));

		if (cdt > 0) {
			dto.setCreatedDatetime(DataUtility.getTimestamp(cdt));
		} else {
			dto.setCreatedDatetime(DataUtility.getCurrentTimestamp());
		}

		dto.setModifiedDatetime(DataUtility.getCurrentTimestamp());

		return dto;
	}

//	protected BaseBean populateDTO(BaseBean dto, HttpServletRequest request) {
//
//		String createdBy = request.getParameter("createdBy");
//		String modifiedBy = null;
//
//		UserBean userbean = (UserBean) request.getSession().getAttribute("user");
//
//		if (userbean == null) {
//			// If record is created without login
//			createdBy = "root";
//			modifiedBy = "root";
//		} else {
//
//			modifiedBy = userbean.getLogin();
//
//			// If record is created first time
//			if ("null".equalsIgnoreCase(createdBy) || DataValidator.isNull(createdBy)) {
//				createdBy = modifiedBy;
//			}
//
//		}
//
//		dto.setCreatedBy(createdBy);
//		dto.setModifiedBy(modifiedBy);
//
//		long cdt = DataUtility.getLong(request.getParameter("createdDatetime"));
//
//		if (cdt > 0) {
//			dto.setCreatedDatetime(DataUtility.getTimestamp(cdt));
//		} else {
//			dto.setCreatedDatetime(DataUtility.getCurrentTimestamp());
//		}
//
//		dto.setModifiedDatetime(DataUtility.getCurrentTimestamp());
//
//		return dto;
//	}

	@Override
	protected void service(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		System.out.println("Bctl service");

		// Load the preloaded data required to display at HTML form
		preload(request);

		String op = DataUtility.getString(request.getParameter("operation"));
		System.out.println("Bctl servi op " + op);
		// Check if operation is not DELETE, VIEW, CANCEL, RESET and NULL then
		// perform input data validation

		if (DataValidator.isNotNull(op) && !OP_CANCEL.equalsIgnoreCase(op) && !OP_VIEW.equalsIgnoreCase(op)
				&& !OP_DELETE.equalsIgnoreCase(op) && !OP_RESET.equalsIgnoreCase(op)) {
			System.out.println("Bctl 5 operation");
			// Check validation, If fail then send back to page with error
			// messages

			if (!validate(request)) {
				System.out.println("Bctl validate ");
				BaseBean bean = (BaseBean) populateBean(request);
				// call setBean method for show inserted data
				ServletUtility.setBean(bean, request);
				ServletUtility.forward(getView(), request, response);
				return;
			}
		}
		System.out.println("method: " + request.getMethod());
		super.service(request, response);

	}

	/**
	 * Returns the VIEW page of this Controller
	 *
	 * @return
	 */
	protected abstract String getView();
}

package in.co.rays.proj4.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import in.co.rays.proj4.bean.BaseBean;
import in.co.rays.proj4.bean.RoleBean;
import in.co.rays.proj4.bean.UserBean;
import in.co.rays.proj4.model.UserModel;
import in.co.rays.proj4.util.DataUtility;
import in.co.rays.proj4.util.DataValidator;
import in.co.rays.proj4.util.ServletUtility;

@WebServlet(name = "UserRegistrationCtl", urlPatterns = { "/UserRegistrationCtl" })
public class UserRegistrationCtl extends BaseCtl {

	public static final String OP_SIGN_UP = "SignUp";

	@Override
	protected boolean validate(HttpServletRequest request) {

		boolean isValid = true;

		if (DataValidator.isNull(request.getParameter("firstName"))) {
			request.setAttribute("firstName", "First Name Is Required");
			isValid = false;

		} else if (!DataValidator.isName(request.getParameter("firstName"))) {
			request.setAttribute("firstName", "First Name Contains Alphabets Only");
			isValid = false;

		}

		if (DataValidator.isNull(request.getParameter("lastName"))) {
			request.setAttribute("lastName", "Last Name Is Required");
			isValid = false;

		} else if (!DataValidator.isName(request.getParameter("lastName"))) {
			request.setAttribute("lastName", "Last Name Contains Alphabets Only");
			isValid = false;

		}

		if (DataValidator.isNull(request.getParameter("login"))) {
			request.setAttribute("login", "Login Id Is Required");
			isValid = false;

		}

		if (DataValidator.isNull(request.getParameter("password"))) {
			request.setAttribute("password", "Password Is Required");
			isValid = false;

		}

		if (DataValidator.isNull(request.getParameter("confirmPassword"))) {
			request.setAttribute("confirmPassword", "Confirm Password Is Required");
			isValid = false;

		} else if (!request.getParameter("password").equals(request.getParameter("confirmPassword"))) {
			request.setAttribute("confirmPassword", "Password And Confirm Password Must Be Same");
			isValid = false;

		}

		if (DataValidator.isNull(request.getParameter("gender"))) {
			request.setAttribute("gender", "Gender Is Required");
			isValid = false;

		}

		if (DataValidator.isNull(request.getParameter("mobileNo"))) {
			request.setAttribute("mobileNo", "Mobile No. Is Required");
			isValid = false;

		}

		if (DataValidator.isNull(request.getParameter("dob"))) {
			request.setAttribute("dob", "Date Of Birth Is Required");
			isValid = false;

		}

		return isValid;

	}
	
	@Override
	protected BaseBean populateBean(HttpServletRequest request) {
		
		UserBean bean = new UserBean();
		
		bean.setRoleId(RoleBean.STUDENT);
		
		bean.setId(DataUtility.getLong(request.getParameter("id")));
		bean.setFirstName(DataUtility.getString(request.getParameter("firstName")));
		bean.setLastName(DataUtility.getString(request.getParameter("lastName")));
		bean.setLogin(DataUtility.getString(request.getParameter("login")));
		bean.setPassword(DataUtility.getString(request.getParameter("password")));
		bean.setConfirmPassword(DataUtility.getString(request.getParameter("confirmPassword")));
		bean.setGender(DataUtility.getString(request.getParameter("gender")));
		bean.setDob(DataUtility.getDate(request.getParameter("dob")));
		bean.setMobileNo(DataUtility.getString(request.getParameter("mobileNo")));
		
		populateDTO(bean, request);
		return bean;
	
	}

	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		ServletUtility.forward(getView(), request, response);
	}

	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		String op = DataUtility.getString(request.getParameter("operation"));
		
		UserBean bean = new UserBean();
		UserModel model = new UserModel();
		
		bean = (UserBean)populateBean(request);
		
		if (OP_SIGN_UP.equalsIgnoreCase(op)) {
			try {
				model.add(bean);
				ServletUtility.setBean(bean, request);
				ServletUtility.setSuccessMessage("User Register Successfully", request);
			} catch (Exception e) {
				e.printStackTrace();
			}
			
		}
		ServletUtility.forward(getView(), request, response);
	}

	@Override
	protected String getView() {
		return ORSView.USER_REGISTRATION_VIEW;
	}
}

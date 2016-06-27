package ftd.action;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.apache.struts2.ServletActionContext;

import com.opensymphony.xwork2.ActionSupport;

import ftd.InternetUtil.GetConnection;

public class SerchCourseByTeacher extends ActionSupport {
	private String name;
	private String code;
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getCode() {
		return code;
	}
	public void setCode(String code) {
		this.code = code;
	}
	
	public String excute(){
		HttpServletRequest request = ServletActionContext.getRequest();
		HttpSession session = request.getSession();
		String id = request.getParameter("id");
		String code = request.getParameter("code");
		GetConnection con = new GetConnection();
		String result = con.getConnection(id, code);
		System.out.println(result);
		return SUCCESS;
	}
			
}

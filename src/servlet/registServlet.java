package servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import services.UserService;
import bean.user;

public class registServlet extends HttpServlet {

	/**
	 * Constructor of the object.
	 */
	public registServlet() {
		super();
	}

	/**
	 * Destruction of the servlet. <br>
	 */
	public void destroy() {
		super.destroy(); // Just puts "destroy" string in log
		// Put your code here
	}

	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		String username = request.getParameter("username");
		String psd = request.getParameter("pass");
		String age = request.getParameter("age");
		String capture = request.getParameter("capture");

		// 获取session中的text值
		String text = (String) request.getSession().getAttribute("text");

		String msg = username + "," + psd + "," + age + "\r\n";
		System.out.print(msg);
		//判断验证码输入是否正确
		boolean a = capture.equals(text);
		UserService userService = new UserService();
		boolean rs = false;
		try {
			rs = userService.adduser(msg, a);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		request.setAttribute("result", rs);

		System.out.print("注册成功！" + rs);

		request.getRequestDispatcher("registResult.jsp").forward(request,
				response);
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		this.doGet(request, response);
	}

	/**
	 * Initialization of the servlet. <br>
	 * 
	 * @throws ServletException
	 *             if an error occurs
	 */
	public void init() throws ServletException {
		// Put your code here
	}

}

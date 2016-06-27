package servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import services.ImgCreator;

public class ImgServlet extends HttpServlet {

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		doPost(req, resp);
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		ImgCreator imgCreator = new ImgCreator();
		String text = imgCreator.createRandomText();
		req.getSession().setAttribute("text", text);
		imgCreator.responseImg(text, resp.getOutputStream());
	}

}

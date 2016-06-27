package ftd.action;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.struts2.ServletActionContext;
import org.apache.struts2.interceptor.ServletResponseAware;


import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;

import ftd.InternetUtil.Constants;

public class GetCodeAction extends ActionSupport  implements ServletResponseAware
{
	HttpClient httpClient = new DefaultHttpClient();
	HttpServletRequest request = ServletActionContext.getRequest();
	HttpSession session = request.getSession();
	private HttpServletResponse response;
	private InputStream  inputStream;
    
	
	public InputStream getInputStream() {
		return inputStream;
	}

	public void setInputStream(InputStream inputStream) {
		this.inputStream = inputStream;
	}

	public  String excute() {
		
		session.putValue("onlyonehttpClient", httpClient);
		ByteArrayOutputStream outStream = new ByteArrayOutputStream();
		HttpGet httpGet = new HttpGet(Constants.CODEURL);
		byte[] data = new byte[1024];
		try {
			HttpResponse httpResponse = httpClient.execute(httpGet);
			int len = 0;
			if (httpResponse.getStatusLine().getStatusCode() == 200) {
				HttpEntity entity = httpResponse.getEntity();
				InputStream is = entity.getContent();
				while ((len = is.read(data)) != -1) {
					outStream.write(data, 0, len);
				}
				this.inputStream = new ByteArrayInputStream(data);  
				
			}
		} catch (ClientProtocolException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println(inputStream);
		System.out.println(data);
		return SUCCESS;
	}

	@Override
	public void setServletResponse(HttpServletResponse response) {
		this.response=response;		
	}
}

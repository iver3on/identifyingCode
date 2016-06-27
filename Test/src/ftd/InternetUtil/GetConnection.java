package ftd.InternetUtil;

import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;

import javax.imageio.stream.FileImageOutputStream;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.NameValuePair;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.HttpClient;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.message.BasicNameValuePair;
import org.apache.http.util.EntityUtils;
import org.apache.struts2.ServletActionContext;

import com.opensymphony.xwork2.ActionContext;

public class GetConnection {
	HttpServletRequest request = ServletActionContext.getRequest();
	HttpSession session = request.getSession();
	/*public void byte2image(byte[] data,String path){  
	    if(data.length<3||path.equals("")) return;  
	    try{  
	    FileImageOutputStream imageOutput = new FileImageOutputStream(new File(path));  
	    imageOutput.write(data, 0, data.length);  
	    imageOutput.close();  
	    System.out.println("Make Picture success,Please find image in " + path);  
	    } catch(Exception ex) {  
	      System.out.println("Exception: " + ex);  
	      ex.printStackTrace();  
	    }  
	  }  */
	public String getConnection(String id, String code) {
		 String s="";
		HttpClient httpClient= (HttpClient) session.getAttribute("onlyonehttpClient");
		HttpPost httppost = new HttpPost(Constants.URL);
		httppost.setHeader("Referer", Constants.REFERER);
		NameValuePair pair1 = new BasicNameValuePair("Sel_XNXQ", "20141");
		NameValuePair pair2 = new BasicNameValuePair("Sel_JS", id);
		NameValuePair pair3 = new BasicNameValuePair("type", "1");
		NameValuePair pair4 = new BasicNameValuePair("txt_yzm", code);
		List<NameValuePair> pairList = new ArrayList<NameValuePair>();
		pairList.add(pair1);
		pairList.add(pair2);
		pairList.add(pair3);
		pairList.add(pair4);
		try {
			HttpEntity requestHttpEntity = new UrlEncodedFormEntity(pairList);
			httppost.setEntity(requestHttpEntity);
			try {
				// 第三步：执行请求对象，获取服务器发还的相应对象
				HttpResponse response = httpClient.execute(httppost);
				// 第四步：检查相应的状态是否正常
				// if (response.getStatusLine().getStatusCode() ==
				// 200) {
				// 第五步：从相应对象当中取出数据，放到entity当中
				// 获取响应消息实体
				HttpEntity entity = response.getEntity();
				System.out
						.println("上面试响应头------------------------------------下面是响应体");
				if (entity != null) {
					// 添加解析代码*******************************************
					 s = EntityUtils.toString(entity);
					
				} else
					System.out.println("响应实体为空");
			} catch (Exception e) {
				e.printStackTrace();
			}
		} 
		catch (Exception e) {
			e.printStackTrace();
		}
		return s;
	}
}

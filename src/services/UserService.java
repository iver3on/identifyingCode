package services;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.StringTokenizer;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;

import org.omg.CORBA.PUBLIC_MEMBER;
import org.omg.CORBA.Request;

import sun.applet.resources.MsgAppletViewer;

import com.sun.org.apache.bcel.internal.generic.NEW;

import bean.user;

public class UserService {

	private ResultSet rs;

	@SuppressWarnings("unused")
	public boolean checkRegiste(String info) throws Exception {
		File txt = new File("C:/Users/iver3-hp/Desktop/abc.txt");

		FileReader file = null;

		file = new FileReader(txt);

		BufferedReader reader = new BufferedReader(file);
		ArrayList<String> list = new ArrayList<String>();
		String str = "";

		str = reader.readLine();

		while (str != null) {
			String[] s = str.split(",");
			list.add(s[0]);
			str = reader.readLine();
		}
		Iterator<String> iterator = list.iterator();

		while (iterator.hasNext()) {
			if (info.equals(iterator.next())) {
				return false;
			} else {
				return true;
			}
		}
		return true;

	}

	public boolean checklogin(String name, String psd) throws Exception {
		File txt = new File("C:/Users/iver3-hp/Desktop/abc.txt");

		FileReader file = null;

		file = new FileReader(txt);
		BufferedReader reader = new BufferedReader(file);
		ArrayList<String> list = new ArrayList<String>();
		ArrayList<String> list1 = new ArrayList<String>();
		String str = "";

		str = reader.readLine();

		while (str != null) {
			String[] s = str.split(",");
			list.add(s[0]);
			list1.add(s[1]);
			str = reader.readLine();
		}
		System.out.println();
		Iterator<String> iterator = list.iterator();
		Iterator<String> iterator1 = list1.iterator();
		for(String temp :list1)
		{
			System.out.println(temp);
			
		}
		while (iterator.hasNext() || iterator1.hasNext()) {
			if (name.equals(iterator.next()) && psd.equals(iterator1.next())) {
				return true;
			} else {
				return false;
			}
		}
		return false;

	}

	public boolean adduser(String info, Boolean info1) throws Exception {
		File txt = new File("C:/Users/iver3-hp/Desktop/abc.txt");
		if (!txt.exists()) {
			txt.createNewFile();
		}
		byte bytes[] = new byte[1024];
		FileOutputStream fos = new FileOutputStream(txt, true);
		String[] line = info.split(",");
		if (checkRegiste(line[0]) && info1) {
			fos.write(info.getBytes());
			fos.close();
			return true;
		} else
			return false;
	}
}
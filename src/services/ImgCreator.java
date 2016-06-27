package services;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.io.OutputStream;
import java.util.HashSet;
import java.util.Random;
import java.util.Set;
import javax.imageio.ImageIO;

public class ImgCreator {

	/**
	 * 产生指定个不重复且不大于指定最大数的随机数
	 *
	 * @param size 产生随机数的个数
	 * @param maxNumber 最大不超过这个数
	 * @return 返回一个存有随机数的集合；
	 */
	public Set<Integer> createRandom(int size, int maxNumber) {
		Set<Integer> set = new HashSet<Integer>();

		Random random = new Random();
		while (set.size() < size) {
			int number = random.nextInt(maxNumber);
			if (!set.contains(number)) {
				set.add(number);
			}
		}
		return set;

	}

	
	/**
	 * 产生验证码图片文字
	 * @return
	 */
	public String createRandomText() {
		StringBuffer sb = new StringBuffer();
		String base = "1234567890abcdefghijklmnopqrstuvwxyz";
		Set<Integer> set = createRandom(5, base.length());
		for (int index : set) {
			sb.append(base.charAt(index));
		}
		return sb.toString();
	}

	/**
	 * 返回验证码
	 * @param text 验证码文字
	 * @param out 输出流
	 * @return
	 */
	public boolean responseImg(String text, OutputStream out) {
		BufferedImage img = new BufferedImage(200, 80,
				BufferedImage.TYPE_INT_RGB);
		Graphics g = img.getGraphics();
		g.setColor(Color.gray);
		g.fillRect(0, 0, 200, 80);
		g.setColor(Color.green);
		g.setFont(new Font("宋体", Font.BOLD, 30));
		g.drawString(text, 10, 35);
		g.dispose();
		try {
			return ImageIO.write(img, "JPEG", out);
		} catch (IOException e) {
			e.printStackTrace();
		}
		return false;
	}
}

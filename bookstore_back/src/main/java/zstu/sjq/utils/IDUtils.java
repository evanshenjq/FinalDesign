package zstu.sjq.utils;

import java.util.Random;
import java.util.UUID;


public class IDUtils {

	//生成图片名字
	public static String genImageName() {
		
		long millis = System.currentTimeMillis();
		//long millis = System.nanoTime();
		Random random = new Random();
		int end3 = random.nextInt(999);
		String str = millis + String.format("%03d", end3);
		
		return str;
	}
	

	//生成随机Id
	public static long genRandomId() {

		long millis = System.currentTimeMillis();

		Random random = new Random();
		int end2 = random.nextInt(99);

		String str = millis + String.format("%02d", end2);
		long id = new Long(str);
		return id;
	}
	

	
	public static void main(String[] args) {
		
	}
}

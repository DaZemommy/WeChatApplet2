package org.wechatapplet.utils;

import java.util.Random;
/**
 * 此工具用来生成一个10位随机数字,其中最大重复数字的次数不能超过5个(包括5个)
 * @author Administrator
 *
 */
public class RandomUtil {

	/**
	 * 工具类测试
	 */
	/*@Test
	public void test(){
		String result = getResult();
		System.out.println(result);
		System.out.println("最大重复次数:"+getMax(result));
	}*/
	
	
	public static String getResult(){
		while (true) {
			String s = getNum();
			int max = getMax(s);
			if (max<5) {
				return s;
			}
		}
	}
	
	
	public static String getNum(){
		Random random = new Random();
		StringBuilder sb = new StringBuilder();
			for (int i = 0; i < 10; i++) {
				int nextInt = random.nextInt(10);
				sb.append(nextInt);
			}
			String s = sb.toString();
			return s;
	}
	
	public static int getMax(String s){
		int max = 0; // 记录最大出现次数  
		int[] cnt = new int[127]; // 临时计数用的数组  
        for (int i = 0; i < s.length(); i++) { // 循环字符以做统计  
              char c = s.charAt(i); // 取出单个字母  
              max = (++cnt[c] > max) ? cnt[c] : max; // 计数并检测最大出现次数  
        }  
        return max;
	}
	
	
	
}

/**
 * -------------------------------------------------------------*
 *                     COPYRIGHT(C) 2018                        *
 *   National Audit Office of the People’s Republic Of China    *
 *                                                              *
 *                                                              *
 *  This work contains confidential business information        *
 *  and intellectual property of CNAO.                          *
 *  All rights reserved.                                        *
 * -------------------------------------------------------------*
 */
/****************************************************************
 * Revision information:
 *
 *@version	1.0	2019年3月19日	Initial release (ChenJunMa)
 *			
 ***************************************************************/
package com.disk;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

/**
 * @author ChenJunMa
 * @date 2019年3月19日
 * @description
 * 
 */
public class Demo {

	/**
	 * @author ChenJunMa
	 * @date 2019年3月19日
	 * @description 获取文件系统使用率
	 * @return
	 */
	public static List<String> getDisk() {
		// 操作系统
		List<String> list = new ArrayList<String>();
		for (char c = 'A'; c <= 'Z'; c++) {
			String dirName = c + ":/";
			File win = new File(dirName);
			if (win.exists()) {
				long total = (long) win.getTotalSpace();
				long free = (long) win.getFreeSpace();
				Double compare = (Double) (1 - free * 1.0 / total) * 100;
				String str = c + ":盘  已使用 " + compare.intValue() + "%";
				list.add(str);
			}
		}
		return list;
	}

	public static void main(String[] args) {
		List<String> disk = Demo.getDisk();
		for (String string : disk) {
			System.out.println(string);
		}
	}
}

package cn.enilu.flash.api.helper;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Enumeration;
import java.util.zip.ZipEntry;
import java.util.zip.ZipFile;

public class UnZipUtil {
	/**
	 * zip解压
	 * 
	 * @param srcFile     zip源文件
	 * @param destDirPath 解压后的目标文件夹
	 * @throws RuntimeException 解压失败会抛出运行时异常
	 */
	public static void unZip(File srcFile, String destDirPath) throws RuntimeException {

		// 判断源文件是否存在
		if (!srcFile.exists()) {
			throw new RuntimeException(srcFile.getPath() + "所指文件不存在");
		}
		
		// 开始解压
		ZipFile zipFile = null;
		try {
			zipFile = new ZipFile(srcFile);
			Enumeration<?> entries = zipFile.entries();
			while (entries.hasMoreElements()) {
				ZipEntry entry = (ZipEntry) entries.nextElement();
//				System.out.println("解压" + entity.getName());
				// 如果是文件夹，就创建个文件夹
				if (entry.isDirectory()) {
					String dirPath = destDirPath + "/" + entry.getName();
					File dir = new File(dirPath);
					dir.mkdirs();
				} else {
					// 如果是文件，就先创建一个文件，然后用io流把内容copy过去
					File targetFile = new File(destDirPath + "/" + entry.getName());
					// 保证这个文件的父文件夹必须要存在
					if (!targetFile.getParentFile().exists()) {
						targetFile.getParentFile().mkdirs();
					}
					targetFile.createNewFile();
					
					// 将压缩文件内容写入到这个文件中
					InputStream inputStream = zipFile.getInputStream(entry);
					FileOutputStream outStream = new FileOutputStream(targetFile);
					int len;
					byte[] buf = new byte[1024];
					while ((len = inputStream.read(buf)) != -1) {
						outStream.write(buf, 0, len);
					}
					// 关流顺序，先打开的后关闭
					outStream.close();
					inputStream.close();
				}
			}
		} catch (Exception e) {
			throw new RuntimeException("unzip error from ZipUtils", e);
		} finally {
			if (zipFile != null) {
				try {
					zipFile.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		}
	}

	/**
	 * 删除指定路径所有的文件, 及该文件夹里的所有文件夹，不包括该文件夹
	 * 
	 * @param file
	 * @param singal
	 * @param destDirPath
	 */
	public static void delAllFiles(File file, String singal, String destDirPath) {
		if (!file.exists()) {
			System.out.println("不存在该路径: " + file);
			return;
		}
		if (singal == null || "".equals(singal)) {
			singal = "-";
		}
//		System.out.println(singal + "目录 [" + file.getName() + "]中：");
		singal = singal + " -";
		File[] files = file.listFiles();
		if (files.length > 0) {
			for (File f : files) {
				if (f.isDirectory()) {// 如果是目录
					delAllFiles(f, singal, destDirPath); // 递归
					
//					System.out.println(singal + "目录 [" + f.getName() + "]已删除");
					
					// 删除该文件夹
					f.delete();
				} else {
//					System.out.println(singal + " 文件《" + f.getName() + "》已删除");
					f.delete();
				}
			}
		} else {
			System.out.println("*** no file in folder ***");
		}

//		System.out.println(destDirPath + "本次转换过程中产生的无用文件已清空！");

	}// static
}

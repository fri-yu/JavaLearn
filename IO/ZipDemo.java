package IO;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.OutputStream;
import java.io.InputStream;
import java.util.Enumeration;
import java.util.zip.ZipEntry;
import java.util.zip.ZipFile;
import java.util.zip.ZipInputStream;
import java.util.zip.ZipOutputStream;

public class ZipDemo {

	/**
	 * @param args
	 */
	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
		// myZip(getFiles(), "D:\\A.ZIP");
		// System.out.println("done");
		getZipFiles("D:\\A.ZIP");
	}

	static String[] getZipFiles(String zipFileName) throws Exception {
		ZipFile zFile = new ZipFile(new File(zipFileName));
		String[] arr = new String[zFile.size()];
		ZipEntry zipEntry = null;
		InputStream input = null;
		OutputStream out = null;
		Enumeration<ZipEntry> eZipEnumeration = (Enumeration<ZipEntry>) zFile
				.entries();
		while (eZipEnumeration.hasMoreElements()) {
			zipEntry = eZipEnumeration.nextElement();
			input = zFile.getInputStream(zipEntry);
			File dir = new File("D:" + File.separator + "B" + File.separator);
			if (!dir.exists())
				dir.mkdir();
			String dZipFileName="D:\\B" + File.separator
			+ zipEntry.getName();
			File dZipFile = new File(dZipFileName);
			out = new FileOutputStream(dZipFile);
			int temp = 0;
			while ((temp = input.read()) != -1) {
				out.write(temp);
			}
			out.close();
			input.close();

			 System.out.println(dZipFileName+"解压成功");
		}

		return arr;
	}

	static void myZip(String[] arr, String zipFileName) throws Exception {
		File zipFile = new File(zipFileName);
		ZipOutputStream zOut = new ZipOutputStream(
				new FileOutputStream(zipFile));
		int temp = 0;
		zOut.setComment("这是一个由java应用程序压缩成的压缩包");
		for (String str : arr) {

			File file = new File(str);
			boolean a = file.isDirectory();
			if (!a) {
				InputStream input = new FileInputStream(file);
				zOut.putNextEntry(new ZipEntry("zip" + file.getName()));
				while ((temp = input.read()) != -1) {
					zOut.write(temp);

				}
				input.close();
			}
		}
		zOut.close();
	}

	static String[] getFiles() {
		File f = new File("D:" + File.separator + "JavaFile");
		String[] arr = new String[f.listFiles().length];
		int index = 0;
		for (File fSub : f.listFiles()) {
			arr[index] = fSub.getPath();
			index++;
		}
		return arr;
	}
}

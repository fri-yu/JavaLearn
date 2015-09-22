package IO;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.OutputStream;
import java.io.Serializable;

public class ObjectSerializableDemo {
	public static void main(String[] ar) throws Exception {
		File file = new File("D:" + File.separator + "JavaFile"
				+ File.separator + "serializable.txt");
		ObjectOutputStream oos = new ObjectOutputStream(
				(OutputStream) (new FileOutputStream(file)));// fileoutputsteam向上转型outputstream
		oos.writeObject(new SerializableDemo[] {
				new SerializableDemo("lisi", 14),
				new SerializableDemo("zhangsan", 13) });
		oos.close();
		ObjectInputStream ois = new ObjectInputStream(
				(InputStream) (new FileInputStream(file)));
		SerializableDemo[] objArr = (SerializableDemo[]) ois.readObject();
		ois.close();
		System.out.println(objArr[0]);
		System.out.println(objArr[1]);
	}
}

class SerializableDemo implements Serializable {
	/**
	 * 
	 */
	// private static final long serialVersionUID = 1L;
	private String name;
	private int age;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public SerializableDemo(String name, int age) {
		super();
		this.name = name;
		this.age = age;
	}

	public String toString() {
		return "name:" + name + " age:" + age;
	}
}
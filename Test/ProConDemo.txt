public class ProConDemo {
	public static void main(String[] arg) {
		Resource res = new Resource();
		Producer pro=new Producer(res);
		Consumer con=new Consumer(res);
		Thread t1=new Thread(pro);
		Thread t2=new Thread(con);
		t1.start();
		t2.start();
		Producer pro2=new Producer(res);
		Consumer con2=new Consumer(res);
		Thread t3=new Thread(pro2);
		Thread t4=new Thread(con2);
		t3.start();
		t4.start();
	}

}

class Producer implements Runnable {
	private Resource res;

	Producer(Resource res) {
		this.res = res;
	}

	public void run() {
		while (true) {
//			try {
//				Thread.sleep(10);
//			} catch (InterruptedException e) {
//				// TODO Auto-generated catch block
//				e.printStackTrace();
//			}
			res.set("+商品+");
		}
	}
}

class Consumer implements Runnable {
	private Resource res;

	Consumer(Resource res) {
		this.res = res;
	}

	public void run() {
		while (true) {
//			try {
//				Thread.sleep(10);
//			} catch (InterruptedException e) {
//				// TODO Auto-generated catch block
//				e.printStackTrace();
//			}
			res.out();
		}
	}
}

class Resource {
	private String nameString;
	private int count = 1;
	private boolean flag = false;

	public synchronized void set(String name) {
		if (!flag){
		this.nameString = name + "--" + count++;
		System.out.println(Thread.currentThread().getName() + "....生产者..."
				+ this.nameString);
		/*处理生产者消费者多线程安全问题，*/
		flag = true;
		this.notify();
		try {
			wait();
		} catch (Exception e) {
			// TODO: handle exception
		}
	}
	}

	public synchronized void out() {
		if (flag)
		{
		System.out.println(Thread.currentThread().getName() + "....消费者..."
				+ this.nameString);
		flag = false;
		this.notify();
		try {
			wait();
		} catch (Exception e) {
			// TODO: handle exception
		}
		}
	}
}
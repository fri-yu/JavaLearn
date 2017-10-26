package observer;

/**
 * Package : observer
 *
 * @author YixinCapital -- jieliyu 2017年10月26日 15:21:00
 */
public interface Subject {

	/**
	 * 注册观察者
	 * 
	 * @param observer
	 */
	void attach(Observer observer) throws Exception;

	/**
	 * 删除观察者
	 * 
	 * @param observer
	 */
	void detach(Observer observer);

	/**
	 * 通知所有观察者
	 */
	void notice();
}

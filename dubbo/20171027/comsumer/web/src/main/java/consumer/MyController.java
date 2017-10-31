package consumer;

import com.test.Provider;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * Package : consumer
 *
 * @author YixinCapital -- jieliyu 2017年10月27日 16:54:00
 */
@Controller
public class MyController {

	@Autowired
	Provider provider;

	@RequestMapping("/login") // 用来处理前台的login请求
	private @ResponseBody String login() {

		try {
			return ("-----------" + provider.build(System.currentTimeMillis() + ""));
		} catch (Exception e) {
			e.printStackTrace();
		}

		return "Hello";

	}

}
package a.b.http;

import java.util.Map;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;

public class GetWebCell extends ActionSupport {
	private Map request;
	private Map session;
	private Map application;

	public GetWebCell() {
		request = (Map) ActionContext.getContext().get("request");
		session = ActionContext.getContext().getSession();
		application = ActionContext.getContext().getApplication();
	}

	@Override
	public String execute() {
		return SUCCESS;

	}
}

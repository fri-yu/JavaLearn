package Filter;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;

public class DemoFilter implements Filter{

	@Override
	public void destroy() {
		// TODO Auto-generated method stub
		System.out.println("fiter destory");
	}

	@Override
	public void doFilter(ServletRequest res, ServletResponse req,
	FilterChain ch) throws IOException, ServletException {
		// TODO Auto-generated method stub
		System.out.println("fiter dofilter");
	}

	@Override
	public void init(FilterConfig conf) throws ServletException {
		// TODO Auto-generated method stub
		System.out.println("fiter init");
	}

}

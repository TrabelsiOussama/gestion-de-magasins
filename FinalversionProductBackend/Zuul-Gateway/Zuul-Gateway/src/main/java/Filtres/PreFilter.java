package Filtres;
import javax.servlet.http.HttpServletRequest;

import com.netflix.zuul.ZuulFilter;
import com.netflix.zuul.context.RequestContext;

public class PreFilter extends ZuulFilter {
	 public String filterType() {
		 return "pre";
	 }
	 public int filterOrder() {
		 return 1;
	 }
	 public boolean shouldFilter() {
		 return true;
	 }
	 public Object run() {
		 RequestContext ctx = RequestContext.getCurrentContext();
		 HttpServletRequest request = ctx.getRequest();
		 System.out.println("Request Method : " + request.getMethod()+ "Request URL :" + request.getRequestURL().toString());
		 return null;
	 }
	}

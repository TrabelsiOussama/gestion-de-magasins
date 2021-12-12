package Filtres;

import com.netflix.zuul.ZuulFilter;

public class ErrorFilter extends ZuulFilter {
 public String filterType() {
	 return "error";
 }
 public int filterOrder() {
	 return 1;
 }
 public boolean shouldFilter() {
	 return true;
 }
 public Object run() {
	 System.out.println("Inside Route Filter");
	 return null;
 }
}

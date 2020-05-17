package com.cts.ba2;

import javax.servlet.http.HttpServletRequest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import com.netflix.zuul.ZuulFilter;
import com.netflix.zuul.context.RequestContext;
import com.netflix.zuul.exception.ZuulException;

@Component
public class ZuulLogginFilter extends ZuulFilter{
	
	private Logger logger=LoggerFactory.getLogger(this.getClass());

	@Override
	public boolean shouldFilter() {
		// TODO Auto-generated method stub
		return true;                                    //excete ?
	}

	@Override
	public Object run() throws ZuulException {
		HttpServletRequest detaails = RequestContext.getCurrentContext().getRequest();
		
		logger.info("request -> {}",detaails);
		return null;                                                                     //logic
	}

	@Override
	public String filterType() {
		// TODO Auto-generated method stub
		return "pre";                                                               //before,after,error
	}

	@Override
	public int filterOrder() {
		// TODO Auto-generated method stub
		return 1;
	}

}

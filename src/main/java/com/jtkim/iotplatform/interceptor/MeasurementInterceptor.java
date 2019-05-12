package com.jtkim.iotplatform.interceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.servlet.AsyncHandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

public class MeasurementInterceptor implements AsyncHandlerInterceptor {

	public static final String START_TIME = "startTime";
	
	private static final Logger log = LoggerFactory.getLogger(MeasurementInterceptor.class);
	
	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
			throws Exception {
		
		if (request.getAttribute(START_TIME) == null) {
			request.setAttribute(START_TIME, System.currentTimeMillis());
		}
		return true;
	}
	
	@Override
	public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler,
			ModelAndView modelAndView) throws Exception {
		
		long startTime = (Long)request.getAttribute(START_TIME);
		long endTime = System.currentTimeMillis();
		request.removeAttribute(START_TIME);
		
		log.trace("Response Processing Time : " + (endTime - startTime) + "ms");
		log.trace("Response Processing Thread : " + Thread.currentThread().getName());
	}

	@Override
	public void afterConcurrentHandlingStarted(HttpServletRequest request,
			HttpServletResponse response, Object handler) throws Exception {

		long startTime = (Long)request.getAttribute(START_TIME);
		long endTime = System.currentTimeMillis();
		request.removeAttribute(START_TIME);
		
		log.trace("Request Processing Time : " + (endTime - startTime) + "ms");
		log.trace("Request Processing Thread : " + Thread.currentThread().getName());
	}
}

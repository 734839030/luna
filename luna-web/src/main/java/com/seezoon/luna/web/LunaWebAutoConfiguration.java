package com.seezoon.luna.web;

import org.springframework.boot.autoconfigure.AutoConfigureAfter;
import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;
import org.springframework.core.Ordered;

import com.seezoon.luna.web.aspect.ParamsValidateAspect;
import com.seezoon.luna.web.controller.AdviceController;
import com.seezoon.luna.web.filter.TraceFilter;

/**
 * luna 自动配置
 * @author hdf
 *
 */
@Configuration
@AutoConfigureAfter
@Import({ParamsValidateAspect.class,AdviceController.class})
public class LunaWebAutoConfiguration {

	/**
	 * 请求跟踪
	 * @return
	 */
	@Bean
	public FilterRegistrationBean<TraceFilter> traceFilter() {
		FilterRegistrationBean<TraceFilter> registration = new FilterRegistrationBean<TraceFilter>();
        registration.setFilter(new TraceFilter());
        registration.addUrlPatterns("/*");
       //registration.addUrlPatterns("*.do");
        registration.setName("traceFilter");
        registration.setOrder(Ordered.HIGHEST_PRECEDENCE);
        return registration;
	}
}

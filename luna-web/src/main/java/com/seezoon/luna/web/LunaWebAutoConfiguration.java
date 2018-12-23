package com.seezoon.luna.web;

import java.text.SimpleDateFormat;

import org.springframework.boot.autoconfigure.AutoConfigureAfter;
import org.springframework.boot.autoconfigure.jackson.Jackson2ObjectMapperBuilderCustomizer;
import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;
import org.springframework.core.Ordered;
import org.springframework.http.converter.json.Jackson2ObjectMapperBuilder;

import com.fasterxml.jackson.annotation.JsonInclude.Include;
import com.fasterxml.jackson.databind.PropertyNamingStrategy;
import com.seezoon.luna.web.aspect.ParamsValidateAspect;
import com.seezoon.luna.web.controller.AdviceController;
import com.seezoon.luna.web.filter.TraceFilter;

/**
 * luna 自动配置
 * 
 * @author hdf
 *
 */
@Configuration
@AutoConfigureAfter
@Import({ ParamsValidateAspect.class, AdviceController.class })
public class LunaWebAutoConfiguration {

	/**
	 * 请求跟踪
	 * 
	 * @return
	 */
	@Bean
	public FilterRegistrationBean<TraceFilter> traceFilter() {
		FilterRegistrationBean<TraceFilter> registration = new FilterRegistrationBean<TraceFilter>();
		registration.setFilter(new TraceFilter());
		registration.addUrlPatterns("/*");
		// registration.addUrlPatterns("*.do");
		registration.setName("traceFilter");
		registration.setOrder(Ordered.HIGHEST_PRECEDENCE);
		return registration;
	}

	/**
	 * 默认jackson 的序列化属性 等价于下列配置
	 * 
	 * spring.jackson.default-property-inclusion=non-null
		spring.jackson.date-format=yyyy-MM-dd HH:mm:ss
	 * @return
	 */
	@Bean
	public Jackson2ObjectMapperBuilderCustomizer customJackson() {
		return new Jackson2ObjectMapperBuilderCustomizer() {

			@Override
			public void customize(Jackson2ObjectMapperBuilder jacksonObjectMapperBuilder) {
				jacksonObjectMapperBuilder.serializationInclusion(Include.NON_NULL);
				jacksonObjectMapperBuilder.dateFormat(new SimpleDateFormat("yyyy-MM-dd HH:mm:ss"));
				jacksonObjectMapperBuilder.failOnUnknownProperties(false);
			}

		};
	}
}

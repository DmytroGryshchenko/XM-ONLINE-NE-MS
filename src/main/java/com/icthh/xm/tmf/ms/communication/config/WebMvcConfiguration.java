package com.icthh.xm.tmf.ms.communication.config;

import com.icthh.xm.commons.web.spring.TenantInterceptor;
import com.icthh.xm.commons.web.spring.XmLoggingInterceptor;
import com.icthh.xm.commons.web.spring.config.XmWebMvcConfigurerAdapter;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.PathMatchConfigurer;

import java.util.Collections;
import java.util.List;

@Configuration
public class WebMvcConfiguration extends XmWebMvcConfigurerAdapter {

    protected WebMvcConfiguration(TenantInterceptor tenantInterceptor,
                                  XmLoggingInterceptor xmLoggingInterceptor) {
        super(tenantInterceptor, xmLoggingInterceptor);
    }

    @Override
    protected void xmAddInterceptors(final InterceptorRegistry registry) {
    }

    @Override
    protected void xmConfigurePathMatch(PathMatchConfigurer configurer) {

    }

    @Override
    protected List<String> getTenantIgnorePathPatterns() {
        return Collections.emptyList();
    }
}

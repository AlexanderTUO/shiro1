package com.itdragon.config;

import org.sitemesh.builder.SiteMeshFilterBuilder;
import org.sitemesh.config.ConfigurableSiteMeshFilter;

/**
 * @Author: itdragon
 * @Date: 2019/5/14 10:39
 * @Description:
 */
public class WebSiteMeshFilter extends ConfigurableSiteMeshFilter {
    @Override
    protected void applyCustomConfiguration(SiteMeshFilterBuilder builder) {
        builder.addDecoratorPath("/*", "/WEB-INF/layouts/default.jsp")  // 配置装饰页面
                .addExcludedPath("/static/*") 	// 静态资源不拦截
                .addExcludedPath("/login**");
    }
}

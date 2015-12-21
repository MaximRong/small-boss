package com.bc.smallboss.base.freemarker;

import com.bc.smallboss.base.spring.AppContext;
import com.google.common.collect.Maps;

import java.util.Map;

/**
 * Created by liolay on 15-10-12.
 */
public class FreemarkerVariablesRegistrar {

    public static Map buildFreemarkerVariables() {
        Map<String, Object> freemarkerVariables = Maps.newHashMap();
        freemarkerVariables.put("e",  AppContext.getBean("funs"));
//        freemarkerVariables.putAll(AppContext.getApplicationContext().getBeansOfType(TemplateDirectiveModel.class));
        return freemarkerVariables;
    }

}

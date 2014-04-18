package com.aop;

import org.springframework.aop.support.DefaultIntroductionAdvisor;

/**
 * User: Anish
 * Date: 2/17/13
 * Time: 12:18 PM
 */
public class FinderIntroductionAdvisor extends DefaultIntroductionAdvisor {

    public FinderIntroductionAdvisor() {
        super(new FinderIntroductionInterceptor());
    }

    public boolean matches(Class clazz){
        return FinderExecutor.class.isAssignableFrom(clazz);
    }
}

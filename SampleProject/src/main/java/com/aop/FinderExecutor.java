package com.aop;

import java.lang.reflect.Method;
import java.util.List;

/**
 * User: Anish
 * Date: 2/17/13
 * Time: 12:33 PM
 */
public interface FinderExecutor<T> {
    /**
     * The method to call named queries, named query must start with (find)
     * @param method
     * @param queryArgs
     * @return
     */
    public List<T> executeFinder(Method method, final Object[] queryArgs);

}

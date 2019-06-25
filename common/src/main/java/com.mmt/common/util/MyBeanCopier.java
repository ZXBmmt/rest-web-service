package com.mmt.common.util;

import com.google.common.collect.Lists;
import com.mmt.common.exception.ServiceException;
import org.springframework.cglib.beans.BeanCopier;
import org.springframework.util.CollectionUtils;

import java.util.List;

public class MyBeanCopier {
    public static <T, A> T copyAsObject(A object, Class<T> clazz) {
        BeanCopier copier = BeanCopier.create(object.getClass(), clazz, false);
        T t;
        try {
            t = clazz.getDeclaredConstructor().newInstance();
        } catch (Exception e) {
            throw new ServiceException(e.getMessage());
        }
        copier.copy(object, t, null);
        return t;
    }

    public static <T, A> List<T> copyAsList(List<A> objects, Class<T> clazz) {
        if (CollectionUtils.isEmpty(objects)) {
            return Lists.newArrayList();
        }
        BeanCopier copier = BeanCopier.create(objects.get(0).getClass(), clazz, false);
        List<T> tList = Lists.newArrayList();
        try {
            for (Object object : objects) {
                T t = clazz.newInstance();
                copier.copy(object, t, null);
                tList.add(t);
            }
        } catch (Exception e) {
            throw new ServiceException(e.getMessage());
        }
        return tList;
    }
}

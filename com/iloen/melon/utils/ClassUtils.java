package com.iloen.melon.utils;

import java.util.Collection;

public class ClassUtils {
    public static boolean equals(Object object0, Object object1) {
        if(object0 == object1) {
            return true;
        }
        if(object0 != null) {
            return object0.equals(object1);
        }
        return object1 == null ? false : object1.equals(null);
    }

    public static boolean isEmpty(Collection collection0) {
        return collection0 == null || collection0.isEmpty();
    }

    public static String shortName(Class class0) {
        return class0 == null ? null : class0.getSimpleName();
    }

    public static String shortName(Object object0) {
        return object0 == null ? null : ClassUtils.shortName(object0.getClass()) + "@" + object0.hashCode();
    }

    public static int size(Collection collection0) {
        return collection0 == null ? 0 : collection0.size();
    }
}


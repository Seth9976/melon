package io.netty.handler.ssl;

import io.netty.util.internal.ObjectUtil;
import java.util.ArrayList;
import java.util.List;

final class ApplicationProtocolUtil {
    private static final int DEFAULT_LIST_SIZE = 2;

    public static List toList(int v, Iterable iterable0) {
        if(iterable0 == null) {
            return null;
        }
        ArrayList arrayList0 = new ArrayList(v);
        for(Object object0: iterable0) {
            arrayList0.add(ObjectUtil.checkNonEmpty(((String)object0), "p"));
        }
        return (List)ObjectUtil.checkNonEmpty(arrayList0, "result");
    }

    public static List toList(int v, String[] arr_s) {
        if(arr_s == null) {
            return null;
        }
        ArrayList arrayList0 = new ArrayList(v);
        for(int v1 = 0; v1 < arr_s.length; ++v1) {
            arrayList0.add(ObjectUtil.checkNonEmpty(arr_s[v1], "p"));
        }
        return (List)ObjectUtil.checkNonEmpty(arrayList0, "result");
    }

    public static List toList(Iterable iterable0) {
        return ApplicationProtocolUtil.toList(2, iterable0);
    }

    public static List toList(String[] arr_s) {
        return ApplicationProtocolUtil.toList(2, arr_s);
    }
}


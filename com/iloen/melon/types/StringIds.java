package com.iloen.melon.types;

import android.text.TextUtils;
import com.iloen.melon.utils.Predicate;
import com.iloen.melon.utils.StringUtils;
import com.iloen.melon.utils.log.LogU;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import v9.p;

public class StringIds extends ArrayList {
    public static final StringIds a = null;
    public static final p b = null;
    public static final p c = null;
    public static final p d = null;
    public static final p e = null;
    public static final p f = null;
    public static final p g = null;
    public static final p h = null;
    public static final p i = null;
    public static final p j = null;
    public static final p k = null;
    private static final long serialVersionUID = 1L;

    static {
        StringIds.a = new StringIds(0);  // 初始化器: Ljava/util/ArrayList;-><init>(I)V
        StringIds.b = new p(3);
        StringIds.c = new p(4);
        StringIds.d = new p(5);
        StringIds.e = new p(6);
        StringIds.f = new p(7);
        StringIds.g = new p(8);
        StringIds.h = new p(9);
        StringIds.i = new p(0);
        StringIds.j = new p(1);
        StringIds.k = new p(2);
    }

    public static boolean a(String s, Predicate predicate0) {
        return predicate0.test(s);
    }

    public static boolean b(StringIds stringIds0) {
        return stringIds0 == null || stringIds0.isEmpty();
    }

    public final LinkedHashMap d(List list0) {
        String s1;
        LinkedHashMap linkedHashMap0 = new LinkedHashMap();
        int v = 0;
        for(Object object0: this) {
            String s = (String)object0;
            try {
                s1 = (String)list0.get(v);
            }
            catch(IndexOutOfBoundsException unused_ex) {
                LogU.w("StringIds", "no values at index:" + v + ", id:" + s);
                s1 = "";
            }
            linkedHashMap0.put(s, s1);
            ++v;
        }
        return linkedHashMap0;
    }

    public static StringIds e(String s) {
        if(TextUtils.isEmpty(s)) {
            StringIds stringIds0 = new StringIds(1);  // 初始化器: Ljava/util/ArrayList;-><init>(I)V
            stringIds0.add("");
            return stringIds0;
        }
        List list0 = StringUtils.tokenizeCsv(s);
        if(list0 != null && list0.size() != 0) {
            return new StringIds(list0);  // 初始化器: Ljava/util/ArrayList;-><init>(Ljava/util/Collection;)V
        }
        StringIds stringIds1 = new StringIds(1);  // 初始化器: Ljava/util/ArrayList;-><init>(I)V
        stringIds1.add(s);
        return stringIds1;
    }

    @Override
    public final String toString() [...] // 潜在的解密器
}


package com.google.firebase.concurrent;

import H7.k;
import T7.b;
import X6.a;
import X6.d;
import Y6.c;
import Y6.o;
import Y6.s;
import android.annotation.SuppressLint;
import com.google.firebase.components.ComponentRegistrar;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.concurrent.Executor;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.ScheduledExecutorService;

@SuppressLint({"ThreadPoolCreation"})
public class ExecutorsRegistrar implements ComponentRegistrar {
    public static final o a;
    public static final o b;
    public static final o c;
    public static final o d;

    static {
        ExecutorsRegistrar.a = new o(new k(3));
        ExecutorsRegistrar.b = new o(new k(4));
        ExecutorsRegistrar.c = new o(new k(5));
        ExecutorsRegistrar.d = new o(new k(6));
    }

    @Override  // com.google.firebase.components.ComponentRegistrar
    public final List getComponents() {
        Class class0 = ScheduledExecutorService.class;
        s s0 = new s(a.class, class0);
        Class class1 = ExecutorService.class;
        s s1 = new s(a.class, class1);
        Class class2 = Executor.class;
        s[] arr_s = {s1, new s(a.class, class2)};
        HashSet hashSet0 = new HashSet();
        HashSet hashSet1 = new HashSet();
        HashSet hashSet2 = new HashSet();
        hashSet0.add(s0);
        for(int v = 0; v < 2; ++v) {
            B.a.o(arr_s[v], "Null interface");
        }
        Collections.addAll(hashSet0, arr_s);
        b b0 = new b(18);
        c c0 = new c(null, new HashSet(hashSet0), new HashSet(hashSet1), 0, 0, b0, hashSet2);
        s s2 = new s(X6.b.class, class0);
        s[] arr_s1 = {new s(X6.b.class, class1), new s(X6.b.class, class2)};
        HashSet hashSet3 = new HashSet();
        HashSet hashSet4 = new HashSet();
        HashSet hashSet5 = new HashSet();
        hashSet3.add(s2);
        for(int v1 = 0; v1 < 2; ++v1) {
            B.a.o(arr_s1[v1], "Null interface");
        }
        Collections.addAll(hashSet3, arr_s1);
        b b1 = new b(19);
        c c1 = new c(null, new HashSet(hashSet3), new HashSet(hashSet4), 0, 0, b1, hashSet5);
        s s3 = new s(X6.c.class, class0);
        s[] arr_s2 = {new s(X6.c.class, class1), new s(X6.c.class, class2)};
        HashSet hashSet6 = new HashSet();
        HashSet hashSet7 = new HashSet();
        HashSet hashSet8 = new HashSet();
        hashSet6.add(s3);
        for(int v2 = 0; v2 < 2; ++v2) {
            B.a.o(arr_s2[v2], "Null interface");
        }
        Collections.addAll(hashSet6, arr_s2);
        b b2 = new b(20);
        c c2 = new c(null, new HashSet(hashSet6), new HashSet(hashSet7), 0, 0, b2, hashSet8);
        Y6.b b3 = c.a(new s(d.class, class2));
        b3.g = new b(21);
        return Arrays.asList(new c[]{c0, c1, c2, b3.b()});
    }
}


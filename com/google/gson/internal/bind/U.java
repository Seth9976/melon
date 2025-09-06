package com.google.gson.internal.bind;

import W7.a;
import W7.b;
import com.google.gson.E;
import com.google.gson.x;
import java.util.ArrayList;
import java.util.concurrent.atomic.AtomicIntegerArray;

public class u extends E {
    @Override  // com.google.gson.E
    public final Object b(a a0) {
        ArrayList arrayList0 = new ArrayList();
        a0.h();
        while(a0.E()) {
            try {
                arrayList0.add(a0.M());
            }
            catch(NumberFormatException numberFormatException0) {
                throw new x(numberFormatException0);  // 初始化器: Ljava/lang/RuntimeException;-><init>(Ljava/lang/Throwable;)V
            }
        }
        a0.q();
        int v = arrayList0.size();
        AtomicIntegerArray atomicIntegerArray0 = new AtomicIntegerArray(v);
        for(int v1 = 0; v1 < v; ++v1) {
            atomicIntegerArray0.set(v1, ((int)(((Integer)arrayList0.get(v1)))));
        }
        return atomicIntegerArray0;
    }

    @Override  // com.google.gson.E
    public final void c(b b0, Object object0) {
        b0.m();
        int v = ((AtomicIntegerArray)object0).length();
        for(int v1 = 0; v1 < v; ++v1) {
            b0.K(((long)((AtomicIntegerArray)object0).get(v1)));
        }
        b0.q();
    }
}


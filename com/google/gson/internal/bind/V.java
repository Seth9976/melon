package com.google.gson.internal.bind;

import W7.a;
import W7.b;
import com.google.gson.E;
import com.google.gson.x;

public class v extends E {
    @Override  // com.google.gson.E
    public final Object b(a a0) {
        if(a0.Z() == 9) {
            a0.T();
            return null;
        }
        try {
            return a0.N();
        }
        catch(NumberFormatException numberFormatException0) {
            throw new x(numberFormatException0);  // 初始化器: Ljava/lang/RuntimeException;-><init>(Ljava/lang/Throwable;)V
        }
    }

    @Override  // com.google.gson.E
    public final void c(b b0, Object object0) {
        if(((Number)object0) == null) {
            b0.B();
            return;
        }
        b0.K(((Number)object0).longValue());
    }
}


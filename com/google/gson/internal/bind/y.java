package com.google.gson.internal.bind;

import W7.a;
import W7.b;
import com.google.gson.E;
import com.google.gson.x;

public class y extends E {
    @Override  // com.google.gson.E
    public final Object b(a a0) {
        if(a0.Z() == 9) {
            a0.T();
            return null;
        }
        String s = a0.W();
        if(s.length() == 1) {
            return Character.valueOf(s.charAt(0));
        }
        StringBuilder stringBuilder0 = com.iloen.melon.utils.a.n("Expecting character, got: ", s, "; at ");
        stringBuilder0.append(a0.C());
        throw new x(stringBuilder0.toString());  // 初始化器: Ljava/lang/RuntimeException;-><init>(Ljava/lang/String;)V
    }

    @Override  // com.google.gson.E
    public final void c(b b0, Object object0) {
        b0.P((((Character)object0) == null ? null : String.valueOf(((Character)object0))));
    }
}


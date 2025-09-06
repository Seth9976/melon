package androidx.emoji2.text;

import K4.a;
import K4.b;
import Q5.k;
import android.content.Context;
import androidx.lifecycle.D;
import androidx.lifecycle.ProcessLifecycleInitializer;
import androidx.lifecycle.t;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import v2.h;
import v2.i;
import v2.o;

public class EmojiCompatInitializer implements b {
    @Override  // K4.b
    public final List a() {
        return Collections.singletonList(ProcessLifecycleInitializer.class);
    }

    @Override  // K4.b
    public final Object b(Context context0) {
        Object object2;
        k k0 = new k();  // 初始化器: Ljava/lang/Object;-><init>()V
        k0.a = context0.getApplicationContext();
        o o0 = new o(k0);
        o0.b = 1;
        if(h.k == null) {
            synchronized(h.j) {
                if(h.k == null) {
                    h.k = new h(o0);
                }
            }
        }
        a a0 = a.c(context0);
        Class class0 = ProcessLifecycleInitializer.class;
        a0.getClass();
        synchronized(a.e) {
            object2 = a0.a.get(class0);
            if(object2 == null) {
                object2 = a0.b(class0, new HashSet());
            }
        }
        t t0 = ((D)object2).getLifecycle();
        t0.a(new i(this, t0));
        return true;
    }
}


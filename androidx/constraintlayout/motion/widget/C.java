package androidx.constraintlayout.motion.widget;

import android.content.Context;
import android.util.AttributeSet;
import java.util.HashMap;
import java.util.HashSet;

public abstract class c {
    public int a;
    public int b;
    public String c;
    public HashMap d;

    public c() {
        this.a = -1;
        this.b = -1;
        this.c = null;
    }

    public abstract void a(HashMap arg1);

    public abstract c b();

    public c c(c c0) {
        this.a = c0.a;
        this.b = c0.b;
        this.c = c0.c;
        this.d = c0.d;
        return this;
    }

    public abstract void d(HashSet arg1);

    public abstract void e(Context arg1, AttributeSet arg2);

    public void f(HashMap hashMap0) {
    }

    // 去混淆评级： 低(20)
    public static float g(Number number0) {
        return number0 instanceof Float ? ((float)(((Float)number0))) : Float.parseFloat(number0.toString());
    }
}


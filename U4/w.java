package U4;

import android.util.Log;

public final class w {
    public final int a;
    public static final Object b;
    public static volatile w c;

    static {
        w.b = new Object();
    }

    public w(int v) {
        this.a = v;
    }

    public final void a(String s, String s1) {
        if(this.a <= 3) {
            Log.d(s, s1);
        }
    }

    public final void b(String s, String s1, Throwable throwable0) {
        if(this.a <= 3) {
            Log.d(s, s1, throwable0);
        }
    }

    public final void c(String s, String s1) {
        if(this.a <= 6) {
            Log.e(s, s1);
        }
    }

    public final void d(String s, String s1, Throwable throwable0) {
        if(this.a <= 6) {
            Log.e(s, s1, throwable0);
        }
    }

    public static w e() {
        synchronized(w.b) {
            if(w.c == null) {
                w.c = new w(3);
            }
            return w.c;
        }
    }

    public final void f(String s, String s1) {
        if(this.a <= 4) {
            Log.i(s, s1);
        }
    }

    public static String g(String s) [...] // 潜在的解密器

    public final void h(String s, String s1) {
        if(this.a <= 5) {
            Log.w(s, s1);
        }
    }
}


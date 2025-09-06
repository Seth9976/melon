package g7;

import android.util.Log;
import e7.f;
import java.io.File;
import java.io.IOException;
import java.nio.charset.Charset;
import java.util.Locale;

public final class n implements d {
    public final File a;
    public l b;
    public static final Charset c;

    static {
        n.c = Charset.forName("UTF-8");
    }

    public n(File file0) {
        this.a = file0;
    }

    @Override  // g7.d
    public final void a() {
        f.b(this.b, "There was a problem closing the Crashlytics log file.");
        this.b = null;
    }

    public final void b() {
        File file0 = this.a;
        if(this.b == null) {
            try {
                this.b = new l(file0);
            }
            catch(IOException iOException0) {
                Log.e("FirebaseCrashlytics", "Could not open log file: " + file0, iOException0);
            }
        }
    }

    @Override  // g7.d
    public final String i() {
        m m0;
        if(this.a.exists()) {
            this.b();
            l l0 = this.b;
            if(l0 == null) {
                m0 = null;
            }
            else {
                int[] arr_v = {0};
                byte[] arr_b = new byte[l0.p()];
                try {
                    this.b.g(new g7.f(arr_b, arr_v));
                }
                catch(IOException iOException0) {
                    Log.e("FirebaseCrashlytics", "A problem occurred while reading the Crashlytics log file.", iOException0);
                }
                m0 = new m(arr_b, arr_v[0]);
            }
        }
        else {
            m0 = null;
        }
        if(m0 == null) {
            return null;
        }
        int v = m0.b;
        byte[] arr_b1 = new byte[v];
        System.arraycopy(m0.a, 0, arr_b1, 0, v);
        return arr_b1 == null ? null : new String(arr_b1, n.c);
    }

    @Override  // g7.d
    public final void k(long v, String s) {
        this.b();
        if(this.b == null) {
            return;
        }
        else {
            if(s == null) {
                s = "null";
            }
            try {
                if(s.length() > 0x4000) {
                    s = "..." + s.substring(s.length() - 0x4000);
                }
                this.b.c(String.format(Locale.US, "%d %s%n", v, s.replaceAll("\r", " ").replaceAll("\n", " ")).getBytes(n.c));
                while(!this.b.h() && this.b.p() > 0x10000) {
                    this.b.m();
                }
                return;
            }
            catch(IOException iOException0) {
            }
        }
        Log.e("FirebaseCrashlytics", "There was a problem writing to the Crashlytics log.", iOException0);
    }
}


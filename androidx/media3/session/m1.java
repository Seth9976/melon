package androidx.media3.session;

import X2.t;
import X2.u;
import android.media.VolumeProvider;
import android.os.Build.VERSION;
import android.os.Handler;
import d8.e;
import d8.f;
import java.nio.charset.StandardCharsets;

public final class m1 {
    public final String a;
    public int b;
    public int c;
    public int d;
    public Object e;
    public final Object f;
    public Object g;

    public m1(o1 o10, int v, int v1, int v2, String s, Handler handler0) {
        this.g = o10;
        this.f = handler0;
        this.b = v;
        this.c = v1;
        this.d = v2;
        this.a = s;
    }

    public m1(String s) {
        byte[] arr_b = s.getBytes(StandardCharsets.ISO_8859_1);
        StringBuilder stringBuilder0 = new StringBuilder(arr_b.length);
        for(int v = 0; v < arr_b.length; ++v) {
            int v1 = (char)(arr_b[v] & 0xFF);
            if(v1 == 0x3F && s.charAt(v) != 0x3F) {
                throw new IllegalArgumentException("Message contains characters outside ISO-8859-1 encoding.");
            }
            stringBuilder0.append(((char)v1));
        }
        this.a = stringBuilder0.toString();
        this.e = f.a;
        this.f = new StringBuilder(s.length());
        this.c = -1;
    }

    public char a() {
        return this.a.charAt(this.b);
    }

    public VolumeProvider b() {
        if(((VolumeProvider)this.e) == null) {
            if(Build.VERSION.SDK_INT >= 30) {
                this.e = new t(this.a, this.b, this.c, this.d, 1, this);
                return (VolumeProvider)this.e;
            }
            this.e = new u(this, this.b, this.c, this.d, 1);
        }
        return (VolumeProvider)this.e;
    }

    public boolean c() {
        return this.b < this.a.length() - this.d;
    }

    public void d(int v) {
        e e0 = (e)this.g;
        if(e0 != null && v <= e0.b) {
            return;
        }
        this.g = e.e(v, ((f)this.e));
    }

    public void e(char c) {
        ((StringBuilder)this.f).append(c);
    }
}


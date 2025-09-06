package b3;

import Qc.l;
import android.media.AudioAttributes.Builder;
import android.os.Bundle;

public final class d {
    public final int a;
    public final int b;
    public final int c;
    public final int d;
    public final int e;
    public M f;
    public static final d g;
    public static final String h;
    public static final String i;
    public static final String j;
    public static final String k;
    public static final String l;

    static {
        d.g = new d(0, 0, 1, 1, 0);
        d.h = "0";
        d.i = "1";
        d.j = "2";
        d.k = "3";
        d.l = "4";
    }

    public d(int v, int v1, int v2, int v3, int v4) {
        this.a = v;
        this.b = v1;
        this.c = v2;
        this.d = v3;
        this.e = v4;
    }

    public static d a(Bundle bundle0) {
        int v = 0;
        int v1 = bundle0.containsKey(d.h) ? bundle0.getInt(d.h) : 0;
        int v2 = bundle0.containsKey(d.i) ? bundle0.getInt(d.i) : 0;
        int v3 = 1;
        int v4 = bundle0.containsKey(d.j) ? bundle0.getInt(d.j) : 1;
        String s = d.k;
        if(bundle0.containsKey(s)) {
            v3 = bundle0.getInt(s);
        }
        String s1 = d.l;
        if(bundle0.containsKey(s1)) {
            v = bundle0.getInt(s1);
        }
        return new d(v1, v2, v4, v3, v);
    }

    public final M b() {
        if(this.f == null) {
            M m0 = new M();  // 初始化器: Ljava/lang/Object;-><init>()V
            AudioAttributes.Builder audioAttributes$Builder0 = new AudioAttributes.Builder().setContentType(this.a).setFlags(this.b).setUsage(this.c);
            l.v(audioAttributes$Builder0, this.d);
            audioAttributes$Builder0.setSpatializationBehavior(this.e);
            m0.a = audioAttributes$Builder0.build();
            this.f = m0;
        }
        return this.f;
    }

    public final Bundle c() {
        Bundle bundle0 = new Bundle();
        bundle0.putInt(d.h, this.a);
        bundle0.putInt(d.i, this.b);
        bundle0.putInt(d.j, this.c);
        bundle0.putInt(d.k, this.d);
        bundle0.putInt(d.l, this.e);
        return bundle0;
    }

    @Override
    public final boolean equals(Object object0) {
        if(this == object0) {
            return true;
        }
        if(object0 != null) {
            Class class0 = object0.getClass();
            return d.class == class0 && this.a == ((d)object0).a && this.b == ((d)object0).b && this.c == ((d)object0).c && this.d == ((d)object0).d && this.e == ((d)object0).e;
        }
        return false;
    }

    @Override
    public final int hashCode() {
        return ((((this.a + 0x20F) * 0x1F + this.b) * 0x1F + this.c) * 0x1F + this.d) * 0x1F + this.e;
    }
}


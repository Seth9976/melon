package l3;

import B3.L;
import B3.m;
import B3.r;
import B3.s;
import B3.t;
import B3.w;
import Y3.j;
import android.text.TextUtils;
import androidx.media3.common.b;
import b3.I;
import b3.n;
import e3.p;
import e3.v;
import e3.x;
import g4.h;
import g4.i;
import java.math.RoundingMode;
import java.nio.charset.StandardCharsets;
import java.util.Arrays;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public final class q implements r {
    public final String a;
    public final v b;
    public final p c;
    public final j d;
    public final boolean e;
    public t f;
    public byte[] g;
    public int h;
    public static final Pattern i;
    public static final Pattern j;

    static {
        q.i = Pattern.compile("LOCAL:([^,]+)");
        q.j = Pattern.compile("MPEGTS:(-?\\d+)");
    }

    public q(String s, v v0, j j0, boolean z) {
        this.a = s;
        this.b = v0;
        this.c = new p();
        this.g = new byte[0x400];
        this.d = j0;
        this.e = z;
    }

    @Override  // B3.r
    public final int a(s s0, B3.v v0) {
        String s4;
        Matcher matcher0;
        this.f.getClass();
        int v1 = (int)s0.getLength();
        byte[] arr_b = this.g;
        if(this.h == arr_b.length) {
            this.g = Arrays.copyOf(arr_b, (v1 == -1 ? arr_b.length : v1) * 3 / 2);
        }
        int v2 = s0.read(this.g, this.h, this.g.length - this.h);
        if(v2 != -1) {
            int v3 = this.h + v2;
            this.h = v3;
            if(v1 == -1 || v3 != v1) {
                return 0;
            }
        }
        p p0 = new p(this.g);
        i.d(p0);
        String s1 = p0.h(StandardCharsets.UTF_8);
        long v4 = 0L;
        long v5 = 0L;
        while(true) {
            matcher0 = null;
            if(TextUtils.isEmpty(s1)) {
                break;
            }
            if(s1.startsWith("X-TIMESTAMP-MAP")) {
                Matcher matcher1 = q.i.matcher(s1);
                if(!matcher1.find()) {
                    throw I.a(null, "X-TIMESTAMP-MAP doesn\'t contain local timestamp: " + s1);
                }
                Matcher matcher2 = q.j.matcher(s1);
                if(!matcher2.find()) {
                    throw I.a(null, "X-TIMESTAMP-MAP doesn\'t contain media timestamp: " + s1);
                }
                String s2 = matcher1.group(1);
                s2.getClass();
                v5 = i.c(s2);
                String s3 = matcher2.group(1);
                s3.getClass();
                v4 = x.T(Long.parseLong(s3), 1000000L, 90000L, RoundingMode.DOWN);
            }
            s1 = p0.h(StandardCharsets.UTF_8);
        }
    alab1:
        while(true) {
            do {
                s4 = p0.h(StandardCharsets.UTF_8);
                if(s4 == null) {
                    break alab1;
                }
                if(!i.a.matcher(s4).matches()) {
                    goto label_40;
                }
            label_37:
                String s5 = p0.h(StandardCharsets.UTF_8);
            }
            while(s5 == null || s5.isEmpty());
            goto label_37;
        label_40:
            Matcher matcher3 = h.a.matcher(s4);
            if(matcher3.matches()) {
                matcher0 = matcher3;
                break;
            }
        }
        if(matcher0 == null) {
            this.e(0L);
            return -1;
        }
        String s6 = matcher0.group(1);
        s6.getClass();
        long v6 = i.c(s6);
        long v7 = x.T(v4 + v6 - v5, 90000L, 1000000L, RoundingMode.DOWN);
        long v8 = this.b.b(v7 % 0x200000000L);
        L l0 = this.e(v8 - v6);
        this.c.E(this.g, this.h);
        l0.d(this.c, this.h, 0);
        l0.c(v8, 1, this.h, 0, null);
        return -1;
    }

    @Override  // B3.r
    public final boolean c(s s0) {
        ((m)s0).peekFully(this.g, 0, 6, false);
        p p0 = this.c;
        p0.E(this.g, 6);
        if(i.a(p0)) {
            return true;
        }
        ((m)s0).peekFully(this.g, 6, 3, false);
        p0.E(this.g, 9);
        return i.a(p0);
    }

    @Override  // B3.r
    public final void d(t t0) {
        if(this.e) {
            t0 = new d5.m(t0, this.d);
        }
        this.f = t0;
        t0.n(new w(0x8000000000000001L));
    }

    public final L e(long v) {
        L l0 = this.f.track(0, 3);
        n n0 = new n();
        n0.m = "text/vtt";
        n0.d = this.a;
        n0.r = v;
        l0.b(new b(n0));
        this.f.endTracks();
        return l0;
    }

    @Override  // B3.r
    public final void release() {
    }

    @Override  // B3.r
    public final void seek(long v, long v1) {
        throw new IllegalStateException();
    }
}


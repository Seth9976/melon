package i.n.i.b.a.s.e;

import B3.v;
import android.text.TextUtils;
import java.util.Arrays;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public final class g7 implements q4 {
    public final String a;
    public final r6 b;
    public final wb c;
    public U5 d;
    public byte[] e;
    public int f;
    public static final Pattern g;
    public static final Pattern h;

    static {
        g7.g = Pattern.compile("LOCAL:([^,]+)");
        g7.h = Pattern.compile("MPEGTS:(-?\\d+)");
    }

    public g7(String s, r6 r60) {
        this.a = s;
        this.b = r60;
        this.c = new wb(1, false);
        this.e = new byte[0x400];
    }

    public final ie a(long v) {
        ie ie0 = this.d.i(0, 3);
        ob ob0 = new ob();
        ob0.k = "text/vtt";
        ob0.c = this.a;
        ob0.o = v;
        ie0.a(new u(ob0));
        this.d.b();
        return ie0;
    }

    @Override  // i.n.i.b.a.s.e.q4
    public final void d(long v, long v1) {
        throw new IllegalStateException();
    }

    @Override  // i.n.i.b.a.s.e.q4
    public final boolean e(i5 i50) {
        i50.k(this.e, 0, 6, false);
        wb wb0 = this.c;
        wb0.i(6, this.e);
        String s = wb0.q();
        if(s != null && s.startsWith("WEBVTT")) {
            return true;
        }
        i50.k(this.e, 6, 3, false);
        wb0.i(9, this.e);
        String s1 = wb0.q();
        return s1 != null && s1.startsWith("WEBVTT");
    }

    @Override  // i.n.i.b.a.s.e.q4
    public final int f(i5 i50, v v0) {
        Matcher matcher2;
        String s3;
        this.d.getClass();
        int v1 = (int)((D2)i50).c;
        byte[] arr_b = this.e;
        if(this.f == arr_b.length) {
            this.e = Arrays.copyOf(arr_b, (v1 == -1 ? arr_b.length : v1) * 3 / 2);
        }
        int v2 = ((D2)i50).o(this.e, this.f, this.e.length - this.f);
        if(v2 != -1) {
            int v3 = this.f + v2;
            this.f = v3;
            if(v1 == -1 || v3 != v1) {
                return 0;
            }
        }
        wb wb0 = new wb(this.e);
        f0.c(wb0);
        String s = wb0.q();
        long v4 = 0L;
        long v5 = 0L;
        while(!TextUtils.isEmpty(s)) {
            if(s.startsWith("X-TIMESTAMP-MAP")) {
                Matcher matcher0 = g7.g.matcher(s);
                if(!matcher0.find()) {
                    throw new H4("X-TIMESTAMP-MAP doesn\'t contain local timestamp: " + s);  // 初始化器: Ljava/io/IOException;-><init>(Ljava/lang/String;)V
                }
                Matcher matcher1 = g7.h.matcher(s);
                if(!matcher1.find()) {
                    throw new H4("X-TIMESTAMP-MAP doesn\'t contain media timestamp: " + s);  // 初始化器: Ljava/io/IOException;-><init>(Ljava/lang/String;)V
                }
                String s1 = matcher0.group(1);
                s1.getClass();
                v5 = f0.b(s1);
                String s2 = matcher1.group(1);
                s2.getClass();
                v4 = Long.parseLong(s2) * 1000000L / 90000L;
            }
            s = wb0.q();
        }
        do {
            do {
                s3 = wb0.q();
                if(s3 == null) {
                    goto label_43;
                }
                if(!f0.a.matcher(s3).matches()) {
                    goto label_39;
                }
            label_36:
                String s4 = wb0.q();
            }
            while(s4 == null || s4.isEmpty());
            goto label_36;
        label_39:
            matcher2 = we.a.matcher(s3);
        }
        while(!matcher2.matches());
        Matcher matcher3 = matcher2;
        goto label_44;
    label_43:
        matcher3 = null;
    label_44:
        if(matcher3 == null) {
            this.a(0L);
            return -1;
        }
        String s5 = matcher3.group(1);
        s5.getClass();
        long v6 = f0.b(s5);
        long v7 = this.b.b((v4 + v6 - v5) * 90000L / 1000000L % 0x200000000L);
        ie ie0 = this.a(v7 - v6);
        this.c.i(this.f, this.e);
        ie0.b(this.f, this.c);
        ie0.f(v7, 1, this.f, 0, null);
        return -1;
    }

    @Override  // i.n.i.b.a.s.e.q4
    public final void g(U5 u50) {
        this.d = u50;
        u50.t(new K8(0x8000000000000001L));
    }
}


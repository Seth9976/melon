package i.n.i.b.a.s.e;

import android.net.Uri;
import android.os.SystemClock;
import android.util.Log;
import android.util.Pair;
import android.util.SparseBooleanArray;
import androidx.compose.foundation.lazy.layout.Z;
import g3.h;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.util.Collections;
import java.util.Iterator;
import java.util.Map;
import jeb.synthetic.FIN;

public final class s8 implements gb {
    public final W2 a;
    public W2 b;
    public String c;
    public Uri d;
    public Map e;
    public long f;
    public boolean g;
    public final u8 h;

    public s8(u8 u80, W2 w20) {
        this.h = u80;
        this.a = w20;
        this.b = w20;
        this.f = 0L;
        this.g = false;
        this.c = null;
        this.d = w20.b;
        this.e = Collections.EMPTY_MAP;
    }

    public static Pair a(q4 q40) {
        if(q40 instanceof Z9) {
            return new Pair("video/x-matroska", Z9.b0);
        }
        if(q40 instanceof q3) {
            return new Pair("application/mp4", new p(11));
        }
        if(q40 instanceof s4) {
            return new Pair("application/mp4", s4.w);
        }
        if(q40 instanceof Od) {
            return new Pair("audio/mpeg", Od.q);
        }
        if(q40 instanceof c2) {
            return new Pair("audio/aac-adts", new p(12));
        }
        if(q40 instanceof q) {
            return new Pair("audio/ac3", q.d);
        }
        if(q40 instanceof r0) {
            return new Pair("video/MP2T", r0.t);
        }
        if(q40 instanceof l3) {
            return new Pair("video/x-flv", l3.q);
        }
        if(q40 instanceof ha) {
            return new Pair("application/ogg", ha.d);
        }
        if(q40 instanceof Lc) {
            return new Pair("video/MP2P", Lc.l);
        }
        if(q40 instanceof t3) {
            return new Pair("audio/raw", t3.f);
        }
        if(q40 instanceof n0) {
            return new Pair("audio/3gpp", n0.m);
        }
        Log.w("Ibis.FormatSniffer", "unknown extractor type");
        return new Pair(null, null);
    }

    @Override  // i.n.i.b.a.s.e.gb
    public final void b() {
        this.g = true;
    }

    public final byte[] b(byte[] arr_b, int v, h h0) {
        ByteArrayOutputStream byteArrayOutputStream0 = new ByteArrayOutputStream();
        int v1 = FIN.finallyOpen$NT();
        byteArrayOutputStream0.write(arr_b, 0, v);
        int v2;
        while((v2 = h0.read(arr_b, 0, arr_b.length)) != -1) {
            byteArrayOutputStream0.write(arr_b, 0, v2);
            if(byteArrayOutputStream0.size() <= 0xA00000) {
                this.f += (long)v2;
                continue;
            }
            FIN.finallyExec$NT(v1);
            throw new IOException("max cache size");
        }
        byte[] arr_b1 = byteArrayOutputStream0.toByteArray();
        try {
            FIN.finallyCodeBegin$NT(v1);
            byteArrayOutputStream0.close();
            FIN.finallyCodeEnd$NT(v1);
        }
        catch(IOException unused_ex) {
        }
        return arr_b1;
    }

    public final void c() {
        if(this.c == null) {
            String s = this.d.getHost();
            if(s != null) {
                this.c = M7.y(s);
            }
        }
    }

    @Override  // i.n.i.b.a.s.e.gb
    public final void g() {
        r8 r83;
        r8 r80 = null;
        this.c = null;
        u8 u80 = this.h;
        W2 w20 = u80.l == null ? this.a : M7.d(u80.l, this.a);
        try {
            this.b = w20;
            try(h h0 = new h(u80.a, w20)) {
                long v1 = SystemClock.elapsedRealtime();
                h0.b();
                h0.available();
                Uri uri0 = u80.a.c();
                uri0.getClass();
                this.d = uri0;
                this.e = u80.a.e();
                this.c();
                byte[] arr_b = new byte[0x2802];
                this.f = 0L;
                int v2 = 0;
                while(true) {
                    if(v2 >= 0x2800 || this.g) {
                        break;
                    }
                    int v3 = h0.read(arr_b, v2, 0x2800 - v2);
                    if(v3 < 0) {
                        break;
                    }
                    v2 += v3;
                    this.f = (long)v2;
                }
                Iterator iterator0 = u8.o.iterator();
                while(true) {
                    if(!iterator0.hasNext()) {
                        break;
                    }
                    Object object0 = iterator0.next();
                    r8 r81 = ((q8)object0).a(v2, arr_b);
                    long v4 = SystemClock.elapsedRealtime() - v1;
                    if(v4 >= 0x7FFFFFFFFFFFFFFFL) {
                        throw new t8(v4);
                    }
                    if(r81 != null && (r80 == null || r81.b > r80.b)) {
                        r80 = r81;
                    }
                }
                if(r80 != null && (r80.c && !this.g)) {
                    try {
                        u80.m = this.b(arr_b, v2, h0);
                    }
                    catch(IOException unused_ex) {
                        Log.w("Ibis.FormatSniffer", "failed to cache the manifest");
                    }
                }
                if(r80 == null) {
                    q4[] arr_q4 = new k3().a();  // 初始化器: Ljava/lang/Object;-><init>()V
                    r8 r82 = null;
                    int v5 = 0;
                    while(true) {
                        if(v5 >= arr_q4.length) {
                            break;
                        }
                        q4 q40 = arr_q4[v5];
                        Z z0 = new Z();  // 初始化器: Ljava/lang/Object;-><init>()V
                        z0.c = arr_b;
                        z0.d = new SparseBooleanArray();
                        z0.e = new SparseBooleanArray();
                        new SparseBooleanArray();
                        new SparseBooleanArray();
                        try {
                            if(q40.e(z0)) {
                                if(!(q40 instanceof r0) || !(u80.a instanceof X0)) {
                                    Pair pair0 = s8.a(q40);
                                    r83 = new r8(((Y6)pair0.second), ((String)pair0.first), 0.5f, false);
                                }
                                else {
                                    r83 = new r8(r0.u, "application/vnd.oma.skb.drm.content", 1.0f, false);
                                }
                                goto label_86;
                            }
                            goto label_92;
                        }
                        catch(IOException iOException0) {
                            M7.M(iOException0, "Ibis.FormatSniffer", "error while sniffing: " + iOException0);
                            goto label_98;
                        }
                    label_86:
                        if(r82 == null) {
                            r82 = r83;
                        }
                        else if(r83.b > r82.b) {
                            r82 = r83;
                        }
                    label_92:
                        long v6 = SystemClock.elapsedRealtime() - v1;
                        if(v6 >= 0x7FFFFFFFFFFFFFFFL) {
                            throw new t8(v6);
                        }
                    label_98:
                        ++v5;
                    }
                    r80 = r82;
                }
                if(r80 != null) {
                    u80.h = r80;
                }
            }
        }
        finally {
            this.c();
        }
    }
}


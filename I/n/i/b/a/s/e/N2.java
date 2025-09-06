package i.n.i.b.a.s.e;

import android.util.Pair;
import androidx.media3.session.legacy.p;
import java.util.LinkedList;
import org.xmlpull.v1.XmlPullParser;

public final class n2 extends p {
    public final LinkedList e;
    public int f;
    public int g;
    public long h;
    public long i;
    public long j;
    public int k;
    public boolean l;
    public s1 m;

    public n2(String s) {
        super(null, s, "SmoothStreamingMedia");
        this.k = -1;
        this.m = null;
        this.e = new LinkedList();
    }

    @Override  // androidx.media3.session.legacy.p
    public final Object c(Gd gd0) {
        int v = this.e.size();
        t1[] arr_t1 = new t1[v];
        this.e.toArray(arr_t1);
        s1 s10 = this.m;
        if(s10 != null) {
            c3 c30 = new c3(new b[]{new b(s10.a, null, "video/mp4", s10.b)});
            for(int v1 = 0; v1 < v; ++v1) {
                t1 t10 = arr_t1[v1];
                if(t10.a == 1 || t10.a == 2) {
                    u[] arr_u = t10.j;
                    for(int v2 = 0; v2 < arr_u.length; ++v2) {
                        ob ob0 = arr_u[v2].a();
                        ob0.n = c30;
                        arr_u[v2] = new u(ob0);
                    }
                }
            }
        }
        int v3 = this.f;
        int v4 = this.g;
        long v5 = this.h;
        long v6 = this.j;
        boolean z = this.l;
        int v7 = this.k;
        s1 s11 = this.m;
        long v8 = Long.compare(this.i, 0L) == 0 ? 0x8000000000000001L : L7.C(this.i, 1000000L, v5);
        return v6 == 0L ? new u1(v3, v4, v8, 0x8000000000000001L, v7, z, s11, arr_t1) : new u1(v3, v4, v8, L7.C(v6, 1000000L, v5), v7, z, s11, arr_t1);
    }

    @Override  // androidx.media3.session.legacy.p
    public final void f(Object object0) {
        if(object0 instanceof t1) {
            this.e.add(((t1)object0));
            return;
        }
        if(object0 instanceof s1) {
            M7.J(this.m == null);
            this.m = (s1)object0;
        }
    }

    @Override  // androidx.media3.session.legacy.p
    public final void i(XmlPullParser xmlPullParser0) {
        long v;
        this.f = p.h(xmlPullParser0, "MajorVersion");
        this.g = p.h(xmlPullParser0, "MinorVersion");
        this.h = p.b(xmlPullParser0, "TimeScale", 10000000L);
        String s = xmlPullParser0.getAttributeValue(null, "Duration");
        if(s == null) {
            throw new k2("Duration");
        }
        try {
            v = Long.parseLong(s);
        }
        catch(NumberFormatException numberFormatException0) {
            throw new H4(numberFormatException0);  // 初始化器: Ljava/io/IOException;-><init>(Ljava/lang/Throwable;)V
        }
        this.i = v;
        this.j = p.b(xmlPullParser0, "DVRWindowLength", 0L);
        this.k = p.a(xmlPullParser0, "LookaheadCount");
        String s1 = xmlPullParser0.getAttributeValue(null, "IsLive");
        this.l = s1 == null ? false : Boolean.parseBoolean(s1);
        Pair pair0 = Pair.create("TimeScale", this.h);
        ((LinkedList)this.d).add(pair0);
    }
}


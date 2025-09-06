package i.n.i.b.a.s.e;

import android.util.Pair;
import androidx.media3.session.legacy.p;
import java.util.ArrayList;
import java.util.LinkedList;
import org.xmlpull.v1.XmlPullParser;

public final class o2 extends p {
    public final String e;
    public final LinkedList f;
    public int g;
    public String h;
    public long i;
    public String j;
    public String k;
    public int l;
    public int m;
    public int n;
    public int o;
    public String p;
    public ArrayList q;
    public long r;

    public o2(p p0, String s) {
        super(p0, s, "StreamIndex");
        this.e = s;
        this.f = new LinkedList();
    }

    @Override  // androidx.media3.session.legacy.p
    public final Object c(Gd gd0) {
        LinkedList linkedList0 = this.f;
        if(this.g == 2) {
            M7.t(linkedList0, new Ma(3), gd0);
        }
        u[] arr_u = new u[linkedList0.size()];
        linkedList0.toArray(arr_u);
        String s = this.k;
        int v = this.g;
        String s1 = this.h;
        long v1 = this.i;
        String s2 = this.j;
        int v2 = this.l;
        int v3 = this.m;
        int v4 = this.n;
        int v5 = this.o;
        String s3 = this.p;
        ArrayList arrayList0 = this.q;
        long v6 = this.r;
        int v7 = arrayList0.size();
        long[] arr_v = new long[v7];
        int v8 = Long.compare(v1, 1000000L);
        if(v8 >= 0 && v1 % 1000000L == 0L) {
            for(int v9 = 0; v9 < v7; ++v9) {
                arr_v[v9] = ((long)(((Long)arrayList0.get(v9)))) / (v1 / 1000000L);
            }
        }
        else if(v8 >= 0 || 1000000L % v1 != 0L) {
            for(int v11 = 0; v11 < v7; ++v11) {
                arr_v[v11] = (long)(((double)(((long)(((Long)arrayList0.get(v11)))))) * (1000000.0 / ((double)v1)));
            }
        }
        else {
            for(int v10 = 0; v10 < v7; ++v10) {
                arr_v[v10] = ((long)(((Long)arrayList0.get(v10)))) * (1000000L / v1);
            }
        }
        long v12 = L7.C(v6, 1000000L, v1);
        return new t1(this.e, s, v, s1, v1, s2, v2, v3, v4, v5, s3, arr_u, arrayList0, arr_v, v12);
    }

    @Override  // androidx.media3.session.legacy.p
    public final void f(Object object0) {
        if(object0 instanceof u) {
            this.f.add(((u)object0));
        }
    }

    @Override  // androidx.media3.session.legacy.p
    public final void i(XmlPullParser xmlPullParser0) {
        LinkedList linkedList0 = (LinkedList)this.d;
        int v = 1;
        if("c".equals(xmlPullParser0.getName())) {
            int v1 = this.q.size();
            long v2 = p.b(xmlPullParser0, "t", 0x8000000000000001L);
            if(v2 == 0x8000000000000001L) {
                if(v1 == 0) {
                    v2 = 0L;
                }
                else {
                    if(this.r == -1L) {
                        throw new H4("Unable to infer start time");  // 初始化器: Ljava/io/IOException;-><init>(Ljava/lang/String;)V
                    }
                    v2 = ((long)(((Long)this.q.get(v1 - 1)))) + this.r;
                }
            }
            this.q.add(v2);
            this.r = p.b(xmlPullParser0, "d", 0x8000000000000001L);
            long v3 = p.b(xmlPullParser0, "r", 1L);
            if(v3 > 1L && this.r == 0x8000000000000001L) {
                throw new H4("Repeated chunk with unspecified duration");  // 初始化器: Ljava/io/IOException;-><init>(Ljava/lang/String;)V
            }
            while(((long)v) < v3) {
                this.q.add(((long)(this.r * ((long)v) + v2)));
                ++v;
            }
            return;
        }
        String s = xmlPullParser0.getAttributeValue(null, "Type");
        if(s == null) {
            throw new k2("Type");
        }
        if(!"audio".equalsIgnoreCase(s)) {
            if("video".equalsIgnoreCase(s)) {
                v = 2;
            }
            else {
                if(!"text".equalsIgnoreCase(s)) {
                    throw new H4("Invalid key value[" + s + "]");  // 初始化器: Ljava/io/IOException;-><init>(Ljava/lang/String;)V
                }
                v = 3;
            }
        }
        this.g = v;
        linkedList0.add(Pair.create("Type", v));
        if(this.g == 3) {
            String s1 = xmlPullParser0.getAttributeValue(null, "Subtype");
            if(s1 == null) {
                throw new k2("Subtype");
            }
            this.h = s1;
        }
        else {
            this.h = xmlPullParser0.getAttributeValue(null, "Subtype");
        }
        linkedList0.add(Pair.create("Subtype", this.h));
        this.j = xmlPullParser0.getAttributeValue(null, "Name");
        String s2 = xmlPullParser0.getAttributeValue(null, "Url");
        if(s2 == null) {
            throw new k2("Url");
        }
        this.k = s2;
        this.l = p.a(xmlPullParser0, "MaxWidth");
        this.m = p.a(xmlPullParser0, "MaxHeight");
        this.n = p.a(xmlPullParser0, "DisplayWidth");
        this.o = p.a(xmlPullParser0, "DisplayHeight");
        String s3 = xmlPullParser0.getAttributeValue(null, "Language");
        this.p = s3;
        linkedList0.add(Pair.create("Language", s3));
        long v4 = (long)p.a(xmlPullParser0, "TimeScale");
        this.i = v4;
        if(v4 == -1L) {
            this.i = (long)(((Long)this.d("TimeScale")));
        }
        this.q = new ArrayList();
    }

    @Override  // androidx.media3.session.legacy.p
    public final boolean j(String s) {
        return "c".equals(s);
    }
}


package androidx.media3.session.legacy;

import android.os.Bundle;
import android.util.Pair;
import b2.b;
import i.n.i.b.a.s.e.Gd;
import i.n.i.b.a.s.e.H4;
import i.n.i.b.a.s.e.k2;
import i.n.i.b.a.s.e.l2;
import i.n.i.b.a.s.e.m2;
import i.n.i.b.a.s.e.o2;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import org.xmlpull.v1.XmlPullParser;

public abstract class p {
    public final Serializable a;
    public Object b;
    public Object c;
    public final Object d;

    public p(MediaBrowserServiceCompat mediaBrowserServiceCompat0) {
        this.d = mediaBrowserServiceCompat0;
        this.a = new ArrayList();
    }

    public p(p p0, String s, String s1) {
        this.c = p0;
        this.a = s;
        this.b = s1;
        this.d = new LinkedList();
    }

    public static int a(XmlPullParser xmlPullParser0, String s) {
        String s1 = xmlPullParser0.getAttributeValue(null, s);
        if(s1 != null) {
            try {
                return Integer.parseInt(s1);
            }
            catch(NumberFormatException numberFormatException0) {
                throw new H4(numberFormatException0);  // 初始化器: Ljava/io/IOException;-><init>(Ljava/lang/Throwable;)V
            }
        }
        return -1;
    }

    public static long b(XmlPullParser xmlPullParser0, String s, long v) {
        String s1 = xmlPullParser0.getAttributeValue(null, s);
        if(s1 != null) {
            try {
                return Long.parseLong(s1);
            }
            catch(NumberFormatException numberFormatException0) {
                throw new H4(numberFormatException0);  // 初始化器: Ljava/io/IOException;-><init>(Ljava/lang/Throwable;)V
            }
        }
        return v;
    }

    public abstract Object c(Gd arg1);

    public Object d(String s) {
        LinkedList linkedList0 = (LinkedList)this.d;
        for(int v = 0; v < linkedList0.size(); ++v) {
            Pair pair0 = (Pair)linkedList0.get(v);
            if(((String)pair0.first).equals(s)) {
                return pair0.second;
            }
        }
        p p0 = (p)this.c;
        return p0 == null ? null : p0.d(s);
    }

    public Object e(XmlPullParser xmlPullParser0, Gd gd0) {
        boolean z = false;
        int v = 0;
        while(true) {
            m2 m20 = null;
            switch(xmlPullParser0.getEventType()) {
                case 1: {
                    return null;
                }
                case 2: {
                    String s = xmlPullParser0.getName();
                    if(((String)this.b).equals(s)) {
                        this.i(xmlPullParser0);
                        z = true;
                    }
                    else if(z) {
                        if(v > 0) {
                            ++v;
                        }
                        else if(this.j(s)) {
                            this.i(xmlPullParser0);
                        }
                        else {
                            String s1 = (String)this.a;
                            if("QualityLevel".equals(s)) {
                                m20 = new m2(this, s1, "QualityLevel");  // 初始化器: Landroidx/media3/session/legacy/p;-><init>(Landroidx/media3/session/legacy/p;Ljava/lang/String;Ljava/lang/String;)V
                            }
                            else if("Protection".equals(s)) {
                                m20 = new l2(this, s1, "Protection");  // 初始化器: Landroidx/media3/session/legacy/p;-><init>(Landroidx/media3/session/legacy/p;Ljava/lang/String;Ljava/lang/String;)V
                            }
                            else if("StreamIndex".equals(s)) {
                                m20 = new o2(this, s1);
                            }
                            if(m20 == null) {
                                v = 1;
                            }
                            else {
                                this.f(m20.e(xmlPullParser0, gd0));
                            }
                        }
                    }
                    break;
                }
                case 3: {
                    if(z) {
                        if(v > 0) {
                            --v;
                        }
                        else {
                            String s2 = xmlPullParser0.getName();
                            this.g(xmlPullParser0);
                            if(!this.j(s2)) {
                                return this.c(gd0);
                            }
                        }
                    }
                    break;
                }
                case 4: {
                    if(z && v == 0) {
                        this.k(xmlPullParser0);
                    }
                }
            }
            xmlPullParser0.next();
        }
    }

    public void f(Object object0) {
    }

    public void g(XmlPullParser xmlPullParser0) {
    }

    public static int h(XmlPullParser xmlPullParser0, String s) {
        String s1 = xmlPullParser0.getAttributeValue(null, s);
        if(s1 != null) {
            try {
                return Integer.parseInt(s1);
            }
            catch(NumberFormatException numberFormatException0) {
                throw new H4(numberFormatException0);  // 初始化器: Ljava/io/IOException;-><init>(Ljava/lang/Throwable;)V
            }
        }
        throw new k2(s);
    }

    public abstract void i(XmlPullParser arg1);

    public boolean j(String s) {
        return false;
    }

    public void k(XmlPullParser xmlPullParser0) {
    }

    public b0 l() {
        n n0 = ((MediaBrowserServiceCompat)this.d).f;
        if(n0 == null) {
            throw new IllegalStateException("This should be called inside of onGetRoot, onLoadChildren, onLoadItem, onSearch, or onCustomAction methods");
        }
        return n0.d;
    }

    public void m(n n0, String s, Bundle bundle0) {
        int v7;
        int v6;
        List list0 = (List)n0.f.get(s);
        if(list0 != null) {
            for(Object object0: list0) {
                b b0 = (b)object0;
                Bundle bundle1 = (Bundle)b0.b;
                int v = bundle0 == null ? -1 : bundle0.getInt("android.media.browse.extra.PAGE", -1);
                int v1 = bundle1 == null ? -1 : bundle1.getInt("android.media.browse.extra.PAGE", -1);
                int v2 = bundle0 == null ? -1 : bundle0.getInt("android.media.browse.extra.PAGE_SIZE", -1);
                int v3 = bundle1 == null ? -1 : bundle1.getInt("android.media.browse.extra.PAGE_SIZE", -1);
                int v4 = 0x7FFFFFFF;
                int v5 = 0;
                if(v == -1 || v2 == -1) {
                    v7 = 0x7FFFFFFF;
                    v6 = 0;
                }
                else {
                    v6 = v * v2;
                    v7 = v2 + v6 - 1;
                }
                if(v1 != -1 && v3 != -1) {
                    v5 = v3 * v1;
                    v4 = v3 + v5 - 1;
                }
                if(v7 >= v5 && v4 >= v6) {
                    ((MediaBrowserServiceCompat)this.d).j(s, n0, ((Bundle)b0.b), bundle0);
                }
            }
        }
    }

    public void n(Bundle bundle0, String s) {
        X2.b b0 = (X2.b)this.b;
        b0.getClass();
        b0.notifyChildrenChanged(s);
    }
}


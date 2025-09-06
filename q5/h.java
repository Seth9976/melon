package Q5;

import android.os.Trace;
import androidx.collection.L;
import androidx.collection.y;
import androidx.compose.runtime.w0;
import androidx.compose.runtime.x0;
import e.k;
import g0.e;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import kotlin.jvm.internal.q;
import we.a;

public final class h {
    public Object a;
    public Object b;
    public Object c;
    public Object d;
    public Object e;
    public Object f;
    public Serializable g;
    public Object h;
    public Object i;
    public Object j;

    public h(Set set0) {
        this.a = set0;
        e e0 = new e(new x0[16]);
        this.b = e0;
        this.c = e0;
        this.d = new e(new Object[16]);
        this.e = new e(new a[16]);
        this.g = new ArrayList();
        this.h = new y();
        this.i = new y();
    }

    public void a(String s, String s1) {
        HashMap hashMap0 = (HashMap)this.h;
        if(hashMap0 == null) {
            throw new IllegalStateException("Property \"autoMetadata\" has not been set");
        }
        hashMap0.put(s, s1);
    }

    public i b() {
        String s = ((String)this.a) == null ? " transportName" : "";
        if(((n)this.e) == null) {
            s = s + " encodedPayload";
        }
        if(((Long)this.f) == null) {
            s = s + " eventMillis";
        }
        if(((Long)this.g) == null) {
            s = s + " uptimeMillis";
        }
        if(((HashMap)this.h) == null) {
            s = s + " autoMetadata";
        }
        if(!s.isEmpty()) {
            throw new IllegalStateException("Missing required properties:" + s);
        }
        return new i(((String)this.a), ((Integer)this.c), ((n)this.e), ((long)(((Long)this.f))), ((long)(((Long)this.g))), ((HashMap)this.h), ((Integer)this.d), ((String)this.b), ((byte[])this.i), ((byte[])this.j));
    }

    public void c() {
        Set set0 = (Set)this.a;
        if(!set0.isEmpty()) {
            Trace.beginSection("Compose:abandons");
            try {
                Iterator iterator0 = set0.iterator();
                while(iterator0.hasNext()) {
                    Object object0 = iterator0.next();
                    iterator0.remove();
                    ((w0)object0).d();
                }
            }
            finally {
                Trace.endSection();
            }
        }
    }

    public void d() {
        e e0 = (e)this.b;
        Set set0 = (Set)this.a;
        this.e(0x80000000);
        e e1 = (e)this.d;
        if(e1.c != 0) {
            Trace.beginSection("Compose:onForgotten");
            try {
                L l0 = (L)this.f;
                for(int v1 = e1.c - 1; -1 < v1; --v1) {
                    Object object0 = e1.a[v1];
                    if(object0 instanceof x0) {
                        set0.remove(((x0)object0).a);
                        ((x0)object0).a.e();
                    }
                    if(object0 instanceof androidx.compose.runtime.i) {
                        if(l0 == null || !l0.c(object0)) {
                            ((androidx.compose.runtime.i)object0).a();
                        }
                        else {
                            ((androidx.compose.runtime.i)object0).c();
                        }
                    }
                }
            }
            finally {
                Trace.endSection();
            }
        }
        if(e0.c != 0) {
            Trace.beginSection("Compose:onRemembered");
            try {
                Object[] arr_object = e0.a;
                int v3 = e0.c;
                for(int v4 = 0; v4 < v3; ++v4) {
                    w0 w00 = ((x0)arr_object[v4]).a;
                    set0.remove(w00);
                    w00.c();
                }
            }
            finally {
                Trace.endSection();
            }
        }
    }

    public void e(int v) {
        y y0 = (y)this.i;
        ArrayList arrayList0 = (ArrayList)this.g;
        if(!arrayList0.isEmpty()) {
            List list0 = null;
            int v2 = 0;
            y y1 = null;
            y y2 = null;
            while(v2 < y0.b) {
                if(v <= y0.c(v2)) {
                    Object object0 = arrayList0.remove(v2);
                    int v3 = y0.e(v2);
                    int v4 = ((y)this.h).e(v2);
                    if(list0 == null) {
                        list0 = k.C(new Object[]{object0});
                        y2 = new y();
                        y2.a(v3);
                        y1 = new y();
                    }
                    else {
                        q.e(y1, "null cannot be cast to non-null type androidx.collection.MutableIntList");
                        q.e(y2, "null cannot be cast to non-null type androidx.collection.MutableIntList");
                        list0.add(object0);
                        y2.a(v3);
                    }
                    y1.a(v4);
                }
                else {
                    ++v2;
                }
            }
            if(list0 != null) {
                q.e(y1, "null cannot be cast to non-null type androidx.collection.MutableIntList");
                q.e(y2, "null cannot be cast to non-null type androidx.collection.MutableIntList");
                int v5 = list0.size();
                for(int v1 = 0; v1 < v5 - 1; ++v1) {
                    int v6 = list0.size();
                    for(int v7 = v1 + 1; v7 < v6; ++v7) {
                        int v8 = y2.c(v1);
                        int v9 = y2.c(v7);
                        if(v8 < v9 || v9 == v8 && y1.c(v1) < y1.c(v7)) {
                            Object object1 = list0.get(v1);
                            list0.set(v1, list0.get(v7));
                            list0.set(v7, object1);
                            int v10 = y1.c(v1);
                            y1.f(v1, y1.c(v7));
                            y1.f(v7, v10);
                            int v11 = y2.c(v1);
                            y2.f(v1, y2.c(v7));
                            y2.f(v7, v11);
                        }
                    }
                }
                ((e)this.d).d(((e)this.d).c, list0);
            }
        }
    }

    public void f(int v, int v1, int v2, Object object0) {
        this.e(v);
        if(v2 >= 0 && v2 < v) {
            ((ArrayList)this.g).add(object0);
            ((y)this.h).a(v1);
            ((y)this.i).a(v2);
            return;
        }
        ((e)this.d).b(object0);
    }
}


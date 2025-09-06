package e3;

import E9.t;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.content.pm.ResolveInfo;
import android.content.pm.ServiceInfo;
import android.os.Build.VERSION;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.text.TextUtils;
import androidx.appcompat.app.z;
import androidx.media3.exoplayer.V;
import androidx.media3.session.M;
import b3.P;
import j3.n;
import java.util.AbstractCollection;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.concurrent.CopyOnWriteArraySet;
import l4.Q;
import l4.h;
import l4.i0;

public final class m {
    public boolean a;
    public boolean b;
    public final Object c;
    public final Object d;
    public final Object e;
    public final Object f;
    public final AbstractCollection g;
    public final Object h;
    public final Object i;

    public m(Context context0, h h0) {
        this.g = new ArrayList();
        this.h = new z(this, 9);
        this.i = new t(this, 23);
        this.c = context0;
        this.d = h0;
        this.e = new Handler();
        this.f = context0.getPackageManager();
    }

    public m(Looper looper0, r r0, k k0) {
        this(new CopyOnWriteArraySet(), looper0, r0, k0, true);
    }

    public m(CopyOnWriteArraySet copyOnWriteArraySet0, Looper looper0, r r0, k k0, boolean z) {
        this.c = r0;
        this.f = copyOnWriteArraySet0;
        this.e = k0;
        this.i = new Object();
        this.g = new ArrayDeque();
        this.h = new ArrayDeque();
        this.d = r0.a(looper0, new M(this, 4));
        this.b = z;
    }

    public void a(Object object0) {
        object0.getClass();
        synchronized(this.i) {
            if(this.a) {
                return;
            }
            l l0 = new l(object0);
            ((CopyOnWriteArraySet)this.f).add(l0);
        }
    }

    public void b() {
        e3.t t0 = (e3.t)this.d;
        ArrayDeque arrayDeque0 = (ArrayDeque)this.g;
        this.h();
        ArrayDeque arrayDeque1 = (ArrayDeque)this.h;
        if(!arrayDeque1.isEmpty()) {
            if(!t0.a.hasMessages(1)) {
                t0.getClass();
                s s0 = e3.t.b();
                Message message0 = t0.a.obtainMessage(1);
                s0.a = message0;
                message0.getClass();
                t0.a.sendMessageAtFrontOfQueue(message0);
                s0.a();
            }
            arrayDeque0.addAll(arrayDeque1);
            arrayDeque1.clear();
            if(arrayDeque0.isEmpty()) {
                while(!arrayDeque0.isEmpty()) {
                    ((Runnable)arrayDeque0.peekFirst()).run();
                    arrayDeque0.removeFirst();
                }
            }
        }
    }

    public void c(int v, j j0) {
        this.h();
        V v1 = new V(new CopyOnWriteArraySet(((CopyOnWriteArraySet)this.f)), v, j0, 5);
        ((ArrayDeque)this.h).add(v1);
    }

    public void d() {
        this.h();
        synchronized(this.i) {
            this.a = true;
        }
        for(Object object0: ((CopyOnWriteArraySet)this.f)) {
            l l0 = (l)object0;
            k k0 = (k)this.e;
            l0.d = true;
            if(l0.c) {
                l0.c = false;
                b3.m m0 = l0.b.f();
                k0.a(l0.a, m0);
            }
        }
        ((CopyOnWriteArraySet)this.f).clear();
    }

    public void e(P p0) {
        this.h();
        CopyOnWriteArraySet copyOnWriteArraySet0 = (CopyOnWriteArraySet)this.f;
        for(Object object0: copyOnWriteArraySet0) {
            l l0 = (l)object0;
            if(l0.a.equals(p0)) {
                k k0 = (k)this.e;
                l0.d = true;
                if(l0.c) {
                    l0.c = false;
                    b3.m m0 = l0.b.f();
                    k0.a(l0.a, m0);
                }
                copyOnWriteArraySet0.remove(l0);
            }
        }
    }

    public void f() {
        int v3;
        h h0 = (h)this.d;
        Context context0 = (Context)this.c;
        PackageManager packageManager0 = (PackageManager)this.f;
        ArrayList arrayList0 = (ArrayList)this.g;
        if(this.b) {
            ArrayList arrayList1 = new ArrayList();
            if(Build.VERSION.SDK_INT >= 30) {
                Intent intent0 = new Intent("android.media.MediaRoute2ProviderService");
                ArrayList arrayList2 = new ArrayList();
                for(Object object0: packageManager0.queryIntentServices(intent0, 0)) {
                    ServiceInfo serviceInfo0 = ((ResolveInfo)object0).serviceInfo;
                    if(!this.a || TextUtils.equals("com.iloen.melon", serviceInfo0.packageName)) {
                        arrayList2.add(serviceInfo0);
                    }
                }
                arrayList1 = arrayList2;
            }
            int v = 0;
            Iterator iterator1 = packageManager0.queryIntentServices(new Intent("android.media.MediaRouteProviderService"), 0).iterator();
        label_19:
            while(iterator1.hasNext()) {
                Object object1 = iterator1.next();
                ServiceInfo serviceInfo1 = ((ResolveInfo)object1).serviceInfo;
                if(serviceInfo1 != null) {
                    if((Q.c == null ? false : Q.c().h()) && !arrayList1.isEmpty()) {
                        for(Object object2: arrayList1) {
                            if(serviceInfo1.packageName.equals(((ServiceInfo)object2).packageName) && serviceInfo1.name.equals(((ServiceInfo)object2).name)) {
                                continue label_19;
                            }
                            if(false) {
                                break;
                            }
                        }
                    }
                    String s = serviceInfo1.packageName;
                    String s1 = serviceInfo1.name;
                    int v1 = arrayList0.size();
                    int v2 = 0;
                    while(true) {
                        if(v2 < v1) {
                            ComponentName componentName0 = ((i0)arrayList0.get(v2)).i;
                            if(componentName0.getPackageName().equals(s) && componentName0.getClassName().equals(s1)) {
                                break;
                            }
                            else {
                                ++v2;
                                continue;
                            }
                        }
                        v2 = -1;
                        break;
                    }
                    if(v2 < 0) {
                        i0 i00 = new i0(context0, new ComponentName(serviceInfo1.packageName, serviceInfo1.name));
                        i00.r = new n(this, i00);
                        if(!i00.l) {
                            i00.l = true;
                            i00.l();
                        }
                        v3 = v + 1;
                        arrayList0.add(v, i00);
                        h0.a(i00, false);
                    }
                    else {
                        if(v2 < v) {
                            continue;
                        }
                        i0 i01 = (i0)arrayList0.get(v2);
                        if(!i01.l) {
                            i01.l = true;
                            i01.l();
                        }
                        if(i01.n == null && (i01.l && (i01.e != null || !i01.k.isEmpty()))) {
                            i01.k();
                            i01.h();
                        }
                        v3 = v + 1;
                        Collections.swap(arrayList0, v2, v);
                    }
                    v = v3;
                }
            }
            if(v < arrayList0.size()) {
                for(int v4 = arrayList0.size() - 1; v4 >= v; --v4) {
                    i0 i02 = (i0)arrayList0.get(v4);
                    h0.k(i02);
                    arrayList0.remove(i02);
                    i02.r = null;
                    if(i02.l) {
                        i02.l = false;
                        i02.l();
                    }
                }
            }
        }
    }

    public void g(int v, j j0) {
        this.c(v, j0);
        this.b();
    }

    public void h() {
        if(!this.b) {
            return;
        }
        b.j(Thread.currentThread() == ((e3.t)this.d).a.getLooper().getThread());
    }
}


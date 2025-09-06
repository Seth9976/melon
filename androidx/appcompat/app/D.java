package androidx.appcompat.app;

import android.content.DialogInterface.OnClickListener;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.os.Messenger;
import android.os.RemoteException;
import android.os.SystemClock;
import android.util.Log;
import android.util.SparseArray;
import androidx.mediarouter.media.MediaRouteProviderService;
import df.B;
import e3.m;
import j3.n;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Objects;
import l4.A;
import l4.D;
import l4.E;
import l4.F;
import l4.G;
import l4.J;
import l4.c0;
import l4.d0;
import l4.g0;
import l4.h;
import l4.i0;
import l4.u;
import l4.v;
import l4.w;
import l4.y;
import l4.z;

public final class d extends Handler {
    public final int a;
    public WeakReference b;

    public d() {
        this.a = 0;
        super();
    }

    public d(MediaRouteProviderService mediaRouteProviderService0) {
        this.a = 1;
        super();
        this.b = new WeakReference(mediaRouteProviderService0);
    }

    public d(c0 c00) {
        this.a = 2;
        super();
        this.b = new WeakReference(c00);
    }

    @Override  // android.os.Handler
    public final void handleMessage(Message message0) {
        w w0;
        v v15;
        D d0;
        Messenger messenger1;
        String s1;
        String s = null;
        switch(this.a) {
            case 0: {
                switch(message0.what) {
                    case -3: 
                    case -2: 
                    case -1: {
                        ((DialogInterface.OnClickListener)message0.obj).onClick(((DialogInterface)this.b.get()), message0.what);
                        return;
                    }
                    case 1: {
                        ((DialogInterface)message0.obj).dismiss();
                        return;
                    }
                    default: {
                        return;
                    }
                }
            }
            case 1: {
                WeakReference weakReference0 = this.b;
                Messenger messenger0 = message0.replyTo;
                if(messenger0 != null) {
                    try {
                        if(messenger0.getBinder() != null) {
                            goto label_130;
                        }
                    }
                    catch(NullPointerException unused_ex) {
                    }
                    return;
                label_130:
                    int v7 = message0.what;
                    int v8 = message0.arg1;
                    int v9 = message0.arg2;
                    Object object4 = message0.obj;
                    Bundle bundle4 = message0.peekData();
                    if(v7 == 1) {
                        String[] arr_s = ((MediaRouteProviderService)weakReference0.get()).getPackageManager().getPackagesForUid(message0.sendingUid);
                        s1 = arr_s == null || arr_s.length <= 0 ? null : arr_s[0];
                    }
                    else {
                        s1 = null;
                    }
                    MediaRouteProviderService mediaRouteProviderService0 = (MediaRouteProviderService)weakReference0.get();
                    if(mediaRouteProviderService0 == null) {
                    label_316:
                        if(v8 != 0) {
                            MediaRouteProviderService.e(messenger0, 0, v8, 0, null, null);
                        }
                    }
                    else {
                        F f0 = mediaRouteProviderService0.e;
                        switch(v7) {
                            case 1: {
                                messenger1 = messenger0;
                                if(v9 < 1) {
                                    messenger0 = messenger1;
                                    f0.getClass();
                                    goto label_316;
                                }
                                else if(f0.c(messenger1) < 0) {
                                    E e0 = f0.b(messenger1, v9, s1);
                                    try {
                                        e0.a.getBinder().linkToDeath(e0, 0);
                                    }
                                    catch(RemoteException unused_ex) {
                                        messenger0 = messenger1;
                                        e0.binderDied();
                                        goto label_316;
                                    }
                                    f0.b.add(e0);
                                    f0.e();
                                    if(v8 != 0) {
                                        MediaRouteProviderService.e(messenger1, 2, v8, 3, MediaRouteProviderService.a(f0.a.d.g, e0.b), null);
                                        return;
                                    }
                                }
                                else {
                                    messenger0 = messenger1;
                                    goto label_316;
                                }
                                break;
                            }
                            case 2: {
                                messenger1 = messenger0;
                                int v10 = f0.c(messenger1);
                                if(v10 < 0) {
                                    messenger0 = messenger1;
                                    goto label_316;
                                }
                                E e1 = (E)f0.b.remove(v10);
                                f0.e();
                                e1.d();
                                MediaRouteProviderService.d(messenger1, v8);
                                return;
                            }
                            case 3: {
                                messenger1 = messenger0;
                                String s2 = bundle4.getString("routeId");
                                String s3 = bundle4.getString("routeGroupId");
                                Bundle bundle5 = (Bundle)bundle4.getParcelable("routeControllerOptions");
                                A a0 = bundle5 == null ? A.b : new A(bundle5);
                                if(s2 == null) {
                                    messenger0 = messenger1;
                                }
                                else {
                                    E e2 = f0.d(messenger1);
                                    if(e2 == null) {
                                        messenger0 = messenger1;
                                    }
                                    else {
                                        Bundle bundle6 = new Bundle();
                                        Bundle bundle7 = (Bundle)a0.a.getParcelable("controlHints");
                                        if(bundle7 == null) {
                                            bundle7 = Bundle.EMPTY;
                                        }
                                        bundle6.putParcelable("controlHints", bundle7);
                                        bundle6.putString("clientPackageName", a0.a.getString("clientPackageName", ""));
                                        bundle6.putString("clientPackageName", e2.c);
                                        if(!e2.c(s2, s3, new A(bundle6), v9)) {
                                            messenger0 = messenger1;
                                            goto label_316;
                                        }
                                        MediaRouteProviderService.d(messenger1, v8);
                                        return;
                                    }
                                }
                                goto label_316;
                            }
                            case 4: {
                                messenger1 = messenger0;
                                E e3 = f0.d(messenger1);
                                if(e3 == null || !e3.f(v9)) {
                                    messenger0 = messenger1;
                                    goto label_316;
                                }
                                MediaRouteProviderService.d(messenger1, v8);
                                return;
                            }
                            case 5: {
                                messenger1 = messenger0;
                                E e4 = f0.d(messenger1);
                                if(e4 == null) {
                                    messenger0 = messenger1;
                                }
                                else {
                                    z z0 = e4.e(v9);
                                    if(z0 == null) {
                                        messenger0 = messenger1;
                                        goto label_316;
                                    }
                                    z0.f();
                                    MediaRouteProviderService.d(messenger1, v8);
                                    return;
                                }
                                goto label_316;
                            }
                            case 6: {
                                messenger1 = messenger0;
                                int v11 = bundle4 == null ? 0 : bundle4.getInt("unselectReason", 0);
                                E e5 = f0.d(messenger1);
                                if(e5 == null) {
                                    messenger0 = messenger1;
                                }
                                else {
                                    z z1 = e5.e(v9);
                                    if(z1 == null) {
                                        messenger0 = messenger1;
                                        goto label_316;
                                    }
                                    z1.i(v11);
                                    MediaRouteProviderService.d(messenger1, v8);
                                    return;
                                }
                                goto label_316;
                            }
                            case 7: {
                                messenger1 = messenger0;
                                int v12 = bundle4.getInt("volume", -1);
                                if(v12 >= 0) {
                                    E e6 = f0.d(messenger1);
                                    if(e6 == null) {
                                        messenger0 = messenger1;
                                    }
                                    else {
                                        z z2 = e6.e(v9);
                                        if(z2 == null) {
                                            messenger0 = messenger1;
                                            goto label_316;
                                        }
                                        z2.g(v12);
                                        MediaRouteProviderService.d(messenger1, v8);
                                        return;
                                    }
                                }
                                else {
                                    messenger0 = messenger1;
                                }
                                goto label_316;
                            }
                            case 8: {
                                messenger1 = messenger0;
                                int v13 = bundle4.getInt("volume", 0);
                                if(v13 == 0) {
                                    messenger0 = messenger1;
                                }
                                else {
                                    E e7 = f0.d(messenger1);
                                    if(e7 == null) {
                                        messenger0 = messenger1;
                                    }
                                    else {
                                        z z3 = e7.e(v9);
                                        if(z3 == null) {
                                            messenger0 = messenger1;
                                            goto label_316;
                                        }
                                        z3.j(v13);
                                        MediaRouteProviderService.d(messenger1, v8);
                                        return;
                                    }
                                }
                                goto label_316;
                            }
                            case 9: {
                                if(object4 instanceof Intent) {
                                    E e8 = f0.d(messenger0);
                                    if(e8 == null) {
                                        messenger1 = messenger0;
                                    }
                                    else {
                                        z z4 = e8.e(v9);
                                        if(z4 == null) {
                                            messenger1 = messenger0;
                                        }
                                        else {
                                            if(v8 == 0) {
                                                messenger1 = messenger0;
                                                d0 = null;
                                            }
                                            else {
                                                messenger1 = messenger0;
                                                d0 = new D(f0, e8, v9, ((Intent)object4), messenger0, v8);
                                            }
                                            if(z4.d(((Intent)object4), d0)) {
                                                return;
                                            }
                                        }
                                    }
                                    messenger0 = messenger1;
                                }
                                goto label_316;
                            }
                            case 10: {
                                if(object4 == null || object4 instanceof Bundle) {
                                    v v14 = ((Bundle)object4) == null ? null : new v(((Bundle)object4));
                                    if(v14 == null) {
                                        v15 = null;
                                    }
                                    else {
                                        v14.a();
                                        G g0 = v14.b;
                                        g0.a();
                                        v15 = g0.b.contains(null) ? null : v14;
                                    }
                                    E e9 = f0.d(messenger0);
                                    if(e9 != null) {
                                        long v16 = SystemClock.elapsedRealtime();
                                        if(!Objects.equals(e9.d, v15)) {
                                            e9.d = v15;
                                            e9.e = v16;
                                            e9.h.h();
                                        }
                                        MediaRouteProviderService.d(messenger0, v8);
                                        return;
                                    }
                                }
                                goto label_316;
                            }
                            case 11: {
                                String s4 = bundle4.getString("memberRouteId");
                                Bundle bundle8 = (Bundle)bundle4.getParcelable("routeControllerOptions");
                                A a1 = bundle8 == null ? A.b : new A(bundle8);
                                if(s4 != null) {
                                    E e10 = f0.d(messenger0);
                                    if(e10 != null) {
                                        Bundle bundle9 = new Bundle();
                                        Bundle bundle10 = (Bundle)a1.a.getParcelable("controlHints");
                                        if(bundle10 == null) {
                                            bundle10 = Bundle.EMPTY;
                                        }
                                        bundle9.putParcelable("controlHints", bundle10);
                                        bundle9.putString("clientPackageName", a1.a.getString("clientPackageName", ""));
                                        bundle9.putString("clientPackageName", e10.c);
                                        Bundle bundle11 = e10.b(s4, new A(bundle9), v9);
                                        if(bundle11 != null) {
                                            MediaRouteProviderService.e(messenger0, 6, v8, 3, bundle11, null);
                                            return;
                                        }
                                    }
                                }
                                goto label_316;
                            }
                            case 12: {
                                String s5 = bundle4.getString("memberRouteId");
                                if(s5 != null) {
                                    E e11 = f0.d(messenger0);
                                    if(e11 != null) {
                                        z z5 = e11.e(v9);
                                        if(z5 instanceof y) {
                                            ((y)z5).n(s5);
                                            MediaRouteProviderService.d(messenger0, v8);
                                            return;
                                        }
                                    }
                                }
                                goto label_316;
                            }
                            case 13: {
                                String s6 = bundle4.getString("memberRouteId");
                                if(s6 != null) {
                                    E e12 = f0.d(messenger0);
                                    if(e12 != null) {
                                        z z6 = e12.e(v9);
                                        if(z6 instanceof y) {
                                            ((y)z6).o(s6);
                                            MediaRouteProviderService.d(messenger0, v8);
                                            return;
                                        }
                                    }
                                }
                                goto label_316;
                            }
                            case 14: {
                                ArrayList arrayList3 = bundle4.getStringArrayList("memberRouteIds");
                                if(arrayList3 != null) {
                                    E e13 = f0.d(messenger0);
                                    if(e13 != null) {
                                        z z7 = e13.e(v9);
                                        if(z7 instanceof y) {
                                            ((y)z7).p(arrayList3);
                                            MediaRouteProviderService.d(messenger0, v8);
                                            return;
                                        }
                                    }
                                }
                                goto label_316;
                            }
                            default: {
                                goto label_316;
                            }
                        }
                    }
                }
                return;
            }
            default: {
                c0 c00 = (c0)this.b.get();
                if(c00 != null) {
                    SparseArray sparseArray0 = c00.h;
                    i0 i00 = c00.i;
                    ArrayList arrayList0 = i00.k;
                    int v1 = message0.what;
                    int v2 = message0.arg1;
                    int v3 = message0.arg2;
                    Object object0 = message0.obj;
                    Bundle bundle0 = message0.peekData();
                    switch(v1) {
                        case 0: {
                            if(v2 == c00.g) {
                                c00.g = 0;
                                if(i00.n == c00) {
                                    i00.k();
                                }
                            }
                            J j1 = (J)sparseArray0.get(v2);
                            if(j1 != null) {
                                sparseArray0.remove(v2);
                                j1.a(null, null);
                                return;
                            }
                            break;
                        }
                        case 2: {
                            if((object0 == null || object0 instanceof Bundle) && c00.f == 0 && v2 == c00.g && v3 >= 1) {
                                c00.g = 0;
                                c00.f = v3;
                                B b0 = B.a(((Bundle)object0));
                                if(i00.n == c00) {
                                    i00.f(b0);
                                }
                                if(i00.n == c00) {
                                    i00.o = true;
                                    int v4 = arrayList0.size();
                                    for(int v = 0; v < v4; ++v) {
                                        ((d0)arrayList0.get(v)).a(i00.n);
                                    }
                                    v v5 = i00.e;
                                    if(v5 != null) {
                                        int v6 = i00.n.d;
                                        i00.n.d = v6 + 1;
                                        i00.n.b(10, v6, 0, v5.a, null);
                                        return;
                                    }
                                }
                            }
                            break;
                        }
                        case 3: {
                            if(object0 == null || object0 instanceof Bundle) {
                                J j2 = (J)sparseArray0.get(v2);
                                if(j2 != null) {
                                    sparseArray0.remove(v2);
                                    j2.b(((Bundle)object0));
                                    return;
                                }
                            }
                            break;
                        }
                        case 4: {
                            if(object0 == null || object0 instanceof Bundle) {
                                if(bundle0 != null) {
                                    s = bundle0.getString("error");
                                }
                                J j3 = (J)sparseArray0.get(v2);
                                if(j3 != null) {
                                    sparseArray0.remove(v2);
                                    j3.a(s, ((Bundle)object0));
                                    return;
                                }
                            }
                            break;
                        }
                        case 5: {
                            if((object0 == null || object0 instanceof Bundle) && c00.f != 0) {
                                B b1 = B.a(((Bundle)object0));
                                if(i00.n == c00) {
                                    i00.f(b1);
                                    return;
                                }
                            }
                            break;
                        }
                        case 6: {
                            if(object0 instanceof Bundle) {
                                J j0 = (J)sparseArray0.get(v2);
                                if(((Bundle)object0) != null && ((Bundle)object0).containsKey("routeId")) {
                                    sparseArray0.remove(v2);
                                    j0.b(((Bundle)object0));
                                    return;
                                }
                                j0.a("DynamicGroupRouteController is created without valid route id.", ((Bundle)object0));
                                return;
                            }
                            Log.w("MediaRouteProviderProxy", "No further information on the dynamic group controller");
                            return;
                        }
                        case 7: {
                            if((object0 == null || object0 instanceof Bundle) && c00.f != 0) {
                                Bundle bundle1 = (Bundle)((Bundle)object0).getParcelable("groupRoute");
                                u u0 = bundle1 == null ? null : new u(bundle1);
                                ArrayList arrayList1 = ((Bundle)object0).getParcelableArrayList("dynamicRoutes");
                                ArrayList arrayList2 = new ArrayList();
                                for(Object object1: arrayList1) {
                                    Bundle bundle2 = (Bundle)object1;
                                    if(bundle2 == null) {
                                        w0 = null;
                                    }
                                    else {
                                        Bundle bundle3 = bundle2.getBundle("mrDescriptor");
                                        w0 = new w((bundle3 == null ? null : new u(bundle3)), bundle2.getInt("selectionState", 1), bundle2.getBoolean("isUnselectable", false), bundle2.getBoolean("isGroupable", false), bundle2.getBoolean("isTransferable", false));
                                    }
                                    arrayList2.add(w0);
                                }
                                if(i00.n == c00) {
                                    for(Object object2: arrayList0) {
                                        d0 d00 = (d0)object2;
                                        if(d00.b() == v3) {
                                            s = d00;
                                            break;
                                        }
                                        if(false) {
                                            break;
                                        }
                                    }
                                    if(s instanceof g0) {
                                        ((g0)s).m(u0, arrayList2);
                                        return;
                                    }
                                }
                            }
                            break;
                        }
                        case 8: {
                            if(i00.n == c00) {
                                for(Object object3: arrayList0) {
                                    d0 d01 = (d0)object3;
                                    if(d01.b() == v3) {
                                        s = d01;
                                        break;
                                    }
                                    if(false) {
                                        break;
                                    }
                                }
                                n n0 = i00.r;
                                if(n0 != null && s instanceof z) {
                                    h h0 = (h)((m)n0.b).d;
                                    if(h0.e == ((z)s)) {
                                        h0.l(h0.c(), 2, true);
                                    }
                                }
                                if(s != null) {
                                    arrayList0.remove(s);
                                    ((d0)s).c();
                                    i00.l();
                                    return;
                                }
                            }
                            break;
                        }
                    }
                }
            }
        }
    }
}


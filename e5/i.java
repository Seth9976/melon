package e5;

import U4.D;
import U4.a;
import U4.w;
import U4.x;
import U4.y;
import V4.G;
import V4.f;
import V4.p;
import V4.s;
import android.database.Cursor;
import android.net.NetworkRequest.Builder;
import android.net.NetworkRequest;
import android.util.Log;
import androidx.appcompat.app.o;
import androidx.room.O;
import androidx.work.impl.WorkDatabase;
import androidx.work.impl.WorkDatabase_Impl;
import d5.c;
import d5.h;
import e.k;
import java.util.ArrayList;
import java.util.Collection;
import je.n;
import je.u;
import kotlin.jvm.internal.q;

public abstract class i {
    public static final int[] a;

    static {
        i.a = new int[]{13, 15, 14};
    }

    public static final void a(s s0, String s1) {
        G g0;
        q.f(s0.j, "workManagerImpl.workDatabase");
        d5.s s2 = s0.j.g();
        c c0 = s0.j.b();
        ArrayList arrayList0 = k.C(new String[]{s1});
        while(!arrayList0.isEmpty()) {
            String s3 = (String)u.Z(arrayList0);
            D d0 = s2.i(s3);
            if(d0 != D.c && d0 != D.d) {
                WorkDatabase_Impl workDatabase_Impl0 = (WorkDatabase_Impl)s2.a;
                workDatabase_Impl0.assertNotSuspendingTransaction();
                h h0 = (h)s2.e;
                H4.h h1 = h0.a();
                h1.k(1, s3);
                try {
                    workDatabase_Impl0.beginTransaction();
                    try {
                        h1.w();
                        workDatabase_Impl0.setTransactionSuccessful();
                    }
                    catch(Throwable throwable0) {
                        workDatabase_Impl0.endTransaction();
                        throw throwable0;
                    }
                    workDatabase_Impl0.endTransaction();
                }
                finally {
                    h0.n(h1);
                }
            }
            arrayList0.addAll(c0.d(s3));
        }
        q.f(s0.m, "workManagerImpl.processor");
        synchronized(s0.m.k) {
            w.e().a("WM-Processor", "Processor cancelling " + s1);
            s0.m.i.add(s1);
            g0 = s0.m.b(s1);
        }
        f.d(s1, g0, 1);
        for(Object object0: s0.l) {
            ((V4.h)object0).b(s1);
        }
    }

    public static final void b(WorkDatabase workDatabase0, a a0, p p0) {
        int v2;
        q.g(workDatabase0, "workDatabase");
        q.g(a0, "configuration");
        ArrayList arrayList0 = k.C(new p[]{p0});
        int v = 0;
        int v1;
        for(v1 = 0; !arrayList0.isEmpty(); v1 += v2) {
            Iterable iterable0 = ((p)u.Z(arrayList0)).l;
            if(!(iterable0 instanceof Collection) || !((Collection)iterable0).isEmpty()) {
                v2 = 0;
                for(Object object0: iterable0) {
                    if(((y)object0).b.j.b()) {
                        ++v2;
                        if(v2 < 0) {
                            k.N();
                            throw null;
                        }
                        if(false) {
                            break;
                        }
                    }
                }
            }
            else {
                v2 = 0;
            }
        }
        if(v1 != 0) {
            d5.s s0 = workDatabase0.g();
            s0.getClass();
            O o0 = O.c(0, "Select COUNT(*) FROM workspec WHERE LENGTH(content_uri_triggers)<>0 AND state NOT IN (2, 3, 5)");
            WorkDatabase_Impl workDatabase_Impl0 = (WorkDatabase_Impl)s0.a;
            workDatabase_Impl0.assertNotSuspendingTransaction();
            Cursor cursor0 = E9.w.R(workDatabase_Impl0, o0, false);
            try {
                if(cursor0.moveToFirst()) {
                    v = cursor0.getInt(0);
                }
            }
            finally {
                cursor0.close();
                o0.release();
            }
            int v4 = a0.j;
            if(v + v1 > v4) {
                throw new IllegalArgumentException(x.g(v1, ".\nTo address this issue you can: \n1. enqueue less workers or batch some of workers with content uri triggers together;\n2. increase limit via Configuration.Builder.setContentUriTriggerWorkersLimit;\nPlease beware that workers with content uri triggers immediately occupy slots in JobScheduler so no updates to content uris are missed.", o.t(v4, v, "Too many workers with contentUriTriggers are enqueued:\ncontentUriTrigger workers limit: ", ";\nalready enqueued count: ", ";\ncurrent enqueue operation count: ")));
            }
        }
    }

    public static e5.h c(int[] arr_v, int[] arr_v1) {
        NetworkRequest.Builder networkRequest$Builder0 = new NetworkRequest.Builder();
        for(int v1 = 0; v1 < arr_v.length; ++v1) {
            int v2 = arr_v[v1];
            try {
                networkRequest$Builder0.addCapability(v2);
            }
            catch(IllegalArgumentException illegalArgumentException0) {
                if(w.e().a <= 5) {
                    Log.w("WM-NetworkRequestCompat", "Ignoring adding capability \'" + v2 + '\'', illegalArgumentException0);
                }
            }
        }
        for(int v3 = 0; v3 < 3; ++v3) {
            int v4 = i.a[v3];
            if(!n.P(arr_v, v4)) {
                try {
                    networkRequest$Builder0.removeCapability(v4);
                }
                catch(IllegalArgumentException illegalArgumentException1) {
                    if(w.e().a <= 5) {
                        Log.w("WM-NetworkRequestCompat", "Ignoring removing default capability \'" + v4 + '\'', illegalArgumentException1);
                    }
                }
            }
        }
        for(int v = 0; v < arr_v1.length; ++v) {
            networkRequest$Builder0.addTransportType(arr_v1[v]);
        }
        NetworkRequest networkRequest0 = networkRequest$Builder0.build();
        q.f(networkRequest0, "networkRequest.build()");
        return new e5.h(networkRequest0);
    }
}


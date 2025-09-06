package e5;

import U4.B;
import U4.D;
import U4.i;
import U4.w;
import U4.y;
import V4.p;
import V4.s;
import android.database.Cursor;
import android.text.TextUtils;
import androidx.room.O;
import androidx.work.impl.WorkDatabase;
import androidx.work.impl.WorkDatabase_Impl;
import d5.a;
import d5.c;
import d5.k;
import d5.l;
import d5.o;
import d5.q;
import d5.u;
import d5.v;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.UUID;
import k8.Y;

public abstract class d {
    public static final String a;

    static {
        d.a = "WM-EnqueueRunnable";
    }

    public static boolean a(p p0) {
        UUID uUID1;
        int v8;
        D d7;
        Iterator iterator5;
        boolean z5;
        boolean z4;
        int v5;
        boolean z1;
        boolean z;
        HashSet hashSet0 = p.M(p0);
        s s0 = p0.i;
        List list0 = p0.l;
        String[] arr_s = (String[])hashSet0.toArray(new String[0]);
        String s1 = p0.j;
        int v1 = p0.k;
        s0.i.d.getClass();
        long v2 = System.currentTimeMillis();
        WorkDatabase workDatabase0 = s0.j;
        int v3 = arr_s == null || arr_s.length <= 0 ? 0 : 1;
        D d0 = D.c;
        D d1 = D.f;
        D d2 = D.d;
        if(v3 == 0) {
            v5 = 1;
            z = false;
            z1 = false;
        }
        else {
            int v4 = arr_s.length;
            z = false;
            z1 = false;
            v5 = 1;
            for(int v = 0; v < v4; ++v) {
                String s2 = arr_s[v];
                q q0 = workDatabase0.g().j(s2);
                if(q0 == null) {
                    w.e().c("WM-EnqueueRunnable", "Prerequisite " + s2 + " doesn\'t exist; not enqueuing");
                    p0.o = true;
                    return false;
                }
                D d3 = q0.b;
                v5 &= (d3 == d0 ? 1 : 0);
                if(d3 == d2) {
                    z1 = true;
                }
                else if(d3 == d1) {
                    z = true;
                }
            }
        }
        boolean z3 = TextUtils.isEmpty(s1);
        D d4 = D.a;
        if(z3 || v3 != 0) {
            z4 = z3;
            z5 = false;
        }
        else {
            z4 = false;
            ArrayList arrayList0 = workDatabase0.g().k(s1);
            if(arrayList0.isEmpty()) {
                z4 = z3;
                z5 = false;
            }
            else if(v1 != 3 && v1 != 4) {
                if(v1 == 2) {
                    for(Object object0: arrayList0) {
                        D d5 = ((o)object0).b;
                        if(d5 != d4 && d5 != D.b) {
                            continue;
                        }
                        p0.o = true;
                        return false;
                    }
                }
                kotlin.jvm.internal.q.f(s0.j, "workManagerImpl.workDatabase");
                b b0 = new b(s0.j, s1, s0, 0);
                s0.j.runInTransaction(b0);
                d5.s s3 = workDatabase0.g();
                for(Object object1: arrayList0) {
                    s3.c(((o)object1).a);
                }
                z5 = true;
            }
            else {
                c c0 = workDatabase0.b();
                List list1 = new ArrayList();
                for(Object object2: arrayList0) {
                    o o0 = (o)object2;
                    String s4 = o0.a;
                    c0.getClass();
                    O o1 = O.c(1, "SELECT COUNT(*)>0 FROM dependency WHERE prerequisite_id=?");
                    o1.k(1, s4);
                    WorkDatabase_Impl workDatabase_Impl0 = (WorkDatabase_Impl)c0.b;
                    workDatabase_Impl0.assertNotSuspendingTransaction();
                    Cursor cursor0 = E9.w.R(workDatabase_Impl0, o1, false);
                    try {
                        boolean z6 = cursor0.moveToFirst() && cursor0.getInt(0) != 0;
                    }
                    finally {
                        cursor0.close();
                        o1.release();
                    }
                    if(!z6) {
                        D d6 = o0.b;
                        if(d6 == d2) {
                            z1 = true;
                        }
                        else if(d6 == d1) {
                            z = true;
                        }
                        ((ArrayList)list1).add(o0.a);
                        v5 &= (d6 == d0 ? 1 : 0);
                    }
                }
                if(v1 == 4 && (z || z1)) {
                    d5.s s5 = workDatabase0.g();
                    for(Object object3: s5.k(s1)) {
                        s5.c(((o)object3).a);
                    }
                    list1 = Collections.EMPTY_LIST;
                    z = false;
                    z1 = false;
                }
                arr_s = (String[])list1.toArray(arr_s);
                v3 = arr_s.length <= 0 ? 0 : 1;
                z5 = false;
            }
        }
        Iterator iterator4 = list0.iterator();
        while(iterator4.hasNext()) {
            Object object4 = iterator4.next();
            q q1 = ((y)object4).b;
            UUID uUID0 = ((y)object4).a;
            if(v3 == 0 || v5 != 0) {
                q1.n = v2;
            }
            else if(z1) {
                q1.b = d2;
            }
            else if(z) {
                q1.b = d1;
            }
            else {
                q1.b = D.e;
            }
            if(q1.b == d4) {
                z5 = true;
            }
            d5.s s6 = workDatabase0.g();
            kotlin.jvm.internal.q.g(s0.l, "schedulers");
            if(q1.e.b("androidx.work.multiprocess.RemoteListenableDelegatingWorker.ARGUMENT_REMOTE_LISTENABLE_WORKER_NAME") || !q1.e.b("androidx.work.impl.workers.RemoteListenableWorker.ARGUMENT_PACKAGE_NAME") || !q1.e.b("androidx.work.impl.workers.RemoteListenableWorker.ARGUMENT_CLASS_NAME")) {
                iterator5 = iterator4;
                d7 = d4;
                v8 = v3;
                uUID1 = uUID0;
            }
            else {
                B b1 = new B();
                iterator5 = iterator4;
                i i0 = q1.e;
                d7 = d4;
                kotlin.jvm.internal.q.g(i0, "data");
                b1.c(i0.a);
                ((LinkedHashMap)b1.a).put("androidx.work.multiprocess.RemoteListenableDelegatingWorker.ARGUMENT_REMOTE_LISTENABLE_WORKER_NAME", q1.c);
                i i1 = b1.a();
                D d8 = q1.b;
                long v7 = q1.g;
                U4.d d9 = q1.j;
                v8 = v3;
                uUID1 = uUID0;
                long v9 = q1.n;
                boolean z7 = q1.q;
                String s7 = q1.x;
                kotlin.jvm.internal.q.g(q1.a, "id");
                kotlin.jvm.internal.q.g(d8, "state");
                kotlin.jvm.internal.q.g(q1.d, "inputMergerClassName");
                kotlin.jvm.internal.q.g(q1.f, "output");
                kotlin.jvm.internal.q.g(d9, "constraints");
                Y.r(q1.l, "backoffPolicy");
                Y.r(q1.r, "outOfQuotaPolicy");
                q1 = new q(q1.a, d8, "androidx.work.multiprocess.RemoteListenableDelegatingWorker", q1.d, i1, q1.f, v7, q1.h, q1.i, d9, q1.k, q1.l, q1.m, v9, q1.o, q1.p, z7, q1.r, q1.s, q1.t, q1.u, q1.v, q1.w, s7);
            }
            WorkDatabase_Impl workDatabase_Impl1 = (WorkDatabase_Impl)s6.a;
            workDatabase_Impl1.assertNotSuspendingTransaction();
            workDatabase_Impl1.beginTransaction();
            try {
                ((d5.b)s6.b).p(q1);
                workDatabase_Impl1.setTransactionSuccessful();
            }
            finally {
                workDatabase_Impl1.endTransaction();
            }
            if(v8 != 0) {
                for(int v11 = 0; v11 < arr_s.length; ++v11) {
                    String s8 = arr_s[v11];
                    String s9 = uUID1.toString();
                    kotlin.jvm.internal.q.f(s9, "id.toString()");
                    a a0 = new a(s9, s8);
                    c c1 = workDatabase0.b();
                    WorkDatabase_Impl workDatabase_Impl2 = (WorkDatabase_Impl)c1.b;
                    workDatabase_Impl2.assertNotSuspendingTransaction();
                    workDatabase_Impl2.beginTransaction();
                    try {
                        ((d5.b)c1.c).p(a0);
                        workDatabase_Impl2.setTransactionSuccessful();
                    }
                    finally {
                        workDatabase_Impl2.endTransaction();
                    }
                }
            }
            v v13 = workDatabase0.h();
            String s10 = uUID1.toString();
            kotlin.jvm.internal.q.f(s10, "id.toString()");
            v13.getClass();
            kotlin.jvm.internal.q.g(((y)object4).c, "tags");
            for(Object object5: ((y)object4).c) {
                u u0 = new u(((String)object5), s10);
                WorkDatabase_Impl workDatabase_Impl3 = (WorkDatabase_Impl)v13.a;
                workDatabase_Impl3.assertNotSuspendingTransaction();
                workDatabase_Impl3.beginTransaction();
                try {
                    ((d5.b)v13.b).p(u0);
                    workDatabase_Impl3.setTransactionSuccessful();
                }
                finally {
                    workDatabase_Impl3.endTransaction();
                }
            }
            if(!z4) {
                l l0 = workDatabase0.e();
                String s11 = uUID1.toString();
                kotlin.jvm.internal.q.f(s11, "id.toString()");
                k k0 = new k(s1, s11);
                WorkDatabase_Impl workDatabase_Impl4 = (WorkDatabase_Impl)l0.b;
                workDatabase_Impl4.assertNotSuspendingTransaction();
                workDatabase_Impl4.beginTransaction();
                try {
                    ((d5.b)l0.c).p(k0);
                    workDatabase_Impl4.setTransactionSuccessful();
                }
                finally {
                    workDatabase_Impl4.endTransaction();
                }
            }
            iterator4 = iterator5;
            d4 = d7;
            v3 = v8;
        }
        p0.o = true;
        return z5;
    }
}


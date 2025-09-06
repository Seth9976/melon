package H8;

import A1.g;
import A3.c;
import M7.H;
import Me.N;
import Pe.z;
import S0.b;
import T3.e;
import U4.a;
import V4.f;
import W.p;
import Xe.j;
import Xe.k;
import android.content.Context;
import android.os.Build.VERSION;
import android.util.Log;
import android.view.Menu;
import androidx.media3.session.r0;
import androidx.work.impl.WorkDatabase;
import com.google.android.gms.tasks.Task;
import com.google.android.gms.tasks.TaskCompletionSource;
import com.google.android.gms.tasks.Tasks;
import com.google.firebase.crashlytics.internal.persistence.FileStore;
import com.iloen.melon.database.core.LocalPlaylistDatabase_Impl;
import com.iloen.melon.net.v4x.response.MyMusicLikeInformContentsLikeRes;
import com.iloen.melon.utils.network.NetUtils;
import d5.n;
import e7.t;
import e7.u;
import f7.d;
import g7.o;
import h7.A;
import h7.D0;
import h7.F;
import h7.K0;
import h7.O;
import h7.P;
import h7.Q;
import h7.S;
import h7.U;
import h7.V;
import h7.W;
import h7.a0;
import h7.d0;
import h7.e0;
import h7.g0;
import h7.h0;
import i.n.i.b.a.s.e.M3;
import java.io.BufferedInputStream;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map.Entry;
import java.util.Map;
import java.util.Stack;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.Executor;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicMarkableReference;
import jeb.synthetic.FIN;
import jf.l;
import jf.m;
import kotlinx.coroutines.flow.Flow;
import kotlinx.coroutines.flow.FlowKt;
import lf.Y;
import vf.s;

public final class q implements l {
    public Object a;
    public Object b;
    public Object c;
    public Object d;
    public Object e;
    public Object f;
    public Object g;

    public q(Context context0, a a0, f5.a a1, f f0, WorkDatabase workDatabase0, d5.q q0, ArrayList arrayList0) {
        kotlin.jvm.internal.q.g(context0, "context");
        super();
        this.a = a0;
        this.b = a1;
        this.c = f0;
        this.d = workDatabase0;
        this.e = q0;
        this.f = arrayList0;
        Context context1 = context0.getApplicationContext();
        kotlin.jvm.internal.q.f(context1, "context.applicationContext");
        this.g = context1;
        new d5.l(4);
    }

    public q(LocalPlaylistDatabase_Impl localPlaylistDatabase_Impl0) {
        this.a = localPlaylistDatabase_Impl0;
        this.b = new Eb.f(3);
        this.c = new Eb.f(4);
        this.d = new Eb.f(5);
        this.e = new h(3);
        this.f = new h(4);
        this.g = new h(5);
    }

    public q(String s, FileStore fileStore0, d d0) {
        this.d = new c(this, false);
        this.e = new c(this, true);
        this.f = new e(4);
        this.g = new AtomicMarkableReference(null, false);
        this.c = s;
        this.a = new g7.h(fileStore0);
        this.b = d0;
    }

    public q(nf.f f0, z z0, nf.h h0, q q0, List list0) {
        kotlin.jvm.internal.q.g(f0, "strings");
        kotlin.jvm.internal.q.g(list0, "contextExtensions");
        super();
        this.a = f0;
        this.b = z0;
        this.c = h0;
        this.d = q0;
        this.e = list0;
        this.f = new LinkedHashMap();
        k.a.getClass();
        this.g = j.a();
    }

    public static P a(P p0, g7.f f0, q q0, Map map0) {
        Map map3;
        Map map2;
        Map map1;
        O o0 = p0.a();
        String s = ((g7.d)f0.b).i();
        if(s != null) {
            o0.e = new d0(s);
        }
        else if(Log.isLoggable("FirebaseCrashlytics", 2)) {
            Log.v("FirebaseCrashlytics", "No log data to include with this event.", null);
        }
        c c0 = (c)q0.d;
        if(map0.isEmpty()) {
            g7.e e0 = (g7.e)((AtomicMarkableReference)c0.b).getReference();
            synchronized(e0) {
                map1 = Collections.unmodifiableMap(new HashMap(e0.a));
            }
        }
        else {
            g7.e e1 = (g7.e)((AtomicMarkableReference)c0.b).getReference();
            synchronized(e1) {
                map2 = Collections.unmodifiableMap(new HashMap(e1.a));
            }
            HashMap hashMap0 = new HashMap(map2);
            int v2 = 0;
            for(Object object0: map0.entrySet()) {
                Map.Entry map$Entry0 = (Map.Entry)object0;
                String s1 = g7.e.a(0x400, ((String)map$Entry0.getKey()));
                if(hashMap0.size() >= 0x40 && !hashMap0.containsKey(s1)) {
                    ++v2;
                }
                else {
                    hashMap0.put(s1, g7.e.a(0x400, ((String)map$Entry0.getValue())));
                }
            }
            if(v2 > 0) {
                Log.w("FirebaseCrashlytics", "Ignored " + v2 + " keys when adding event specific keys. Maximum allowable: 1024", null);
            }
            map1 = Collections.unmodifiableMap(hashMap0);
        }
        List list0 = q.i(map1);
        g7.e e2 = (g7.e)((AtomicMarkableReference)((c)q0.e).b).getReference();
        synchronized(e2) {
            map3 = Collections.unmodifiableMap(new HashMap(e2.a));
        }
        List list1 = q.i(map3);
        if(!list0.isEmpty() || !list1.isEmpty()) {
            o0.c = new Q(((Q)p0.c).a, list0, list1, ((Q)p0.c).d, ((Q)p0.c).e, ((Q)p0.c).f, ((Q)p0.c).g);
        }
        return o0.a();
    }

    public static void b(Menu menu0, b b0) {
        int v2;
        int v = b0.a;
        int v1 = b0.b;
        switch(b0.ordinal()) {
            case 0: {
                v2 = 0x1040001;
                break;
            }
            case 1: {
                v2 = 0x104000B;
                break;
            }
            case 2: {
                v2 = 0x1040003;
                break;
            }
            case 3: {
                v2 = 0x104000D;
                break;
            }
            case 4: {
                v2 = Build.VERSION.SDK_INT > 26 ? 0x104001A : 0x7F13017A;  // string:autofill "Autofill"
                break;
            }
            default: {
                throw new M3();  // 初始化器: Ljava/lang/RuntimeException;-><init>()V
            }
        }
        menu0.add(0, v, v1, v2).setShowAsAction(1);
    }

    public static void c(Menu menu0, b b0, we.a a0) {
        int v = b0.a;
        if(a0 != null && menu0.findItem(v) == null) {
            q.b(menu0, b0);
            return;
        }
        if(a0 == null && menu0.findItem(v) != null) {
            menu0.removeItem(v);
        }
    }

    public static K0 d(P p0, q q0) {
        List list0 = ((e)q0.f).f();
        ArrayList arrayList0 = new ArrayList();
        for(int v = 0; v < list0.size(); ++v) {
            o o0 = (o)list0.get(v);
            o0.getClass();
            e0 e00 = new e0();  // 初始化器: Ljava/lang/Object;-><init>()V
            String s = ((g7.b)o0).e;
            if(s == null) {
                throw new NullPointerException("Null variantId");
            }
            String s1 = ((g7.b)o0).b;
            if(s1 == null) {
                throw new NullPointerException("Null rolloutId");
            }
            e00.a = new g0(s1, s);
            String s2 = ((g7.b)o0).c;
            if(s2 == null) {
                throw new NullPointerException("Null parameterKey");
            }
            e00.b = s2;
            String s3 = ((g7.b)o0).d;
            if(s3 == null) {
                throw new NullPointerException("Null parameterValue");
            }
            e00.c = s3;
            e00.d = ((g7.b)o0).f;
            e00.e = (byte)(e00.e | 1);
            arrayList0.add(e00.a());
        }
        if(arrayList0.isEmpty()) {
            return p0;
        }
        O o1 = p0.a();
        o1.f = new h0(arrayList0);
        return o1.a();
    }

    public static String e(InputStream inputStream0) {
        try(BufferedInputStream bufferedInputStream0 = new BufferedInputStream(inputStream0); ByteArrayOutputStream byteArrayOutputStream0 = new ByteArrayOutputStream()) {
            byte[] arr_b = new byte[0x2000];
            int v;
            while((v = bufferedInputStream0.read(arr_b)) != -1) {
                byteArrayOutputStream0.write(arr_b, 0, v);
            }
            return byteArrayOutputStream0.toString("UTF-8");
        }
    }

    public static q f(Context context0, u u0, FileStore fileStore0, P0.d0 d00, g7.f f0, q q0, d5.c c0, g g0, p p0, e7.h h0, d d0) {
        e7.p p1 = new e7.p(context0, u0, d00, c0, g0);
        k7.a a0 = new k7.a(fileStore0, g0, h0);
        Q5.u.b(context0);
        l7.a a1 = new l7.a(new l7.c(Q5.u.a().c(new O5.a("https://crashlyticsreports-pa.googleapis.com/v1/firelog/legacy/batchlog", "AIzaSyBrpSYT4FFL09reHJi6H9FYdeiSnUTOv2M")).a("FIREBASE_CRASHLYTICS_REPORT", new N5.c("json"), l7.a.e), g0.d(), p0));
        q q1 = new q();  // 初始化器: Ljava/lang/Object;-><init>()V
        q1.a = p1;
        q1.b = a0;
        q1.c = a1;
        q1.d = f0;
        q1.e = q0;
        q1.f = u0;
        q1.g = d0;
        return q1;
    }

    public Flow g(String s, String s1, String s2) {
        kotlin.jvm.internal.q.g(s, "contsTypeCode");
        kotlin.jvm.internal.q.g(s1, "contsId");
        return FlowKt.catch(FlowKt.flow(new bb.a(this, s, s1, s2, null)), new H(3, 2, null));
    }

    public Object h(String s, String s1, String s2, oe.c c0) {
        bb.c c1;
        if(c0 instanceof bb.c) {
            c1 = (bb.c)c0;
            int v = c1.B;
            if((v & 0x80000000) == 0) {
                c1 = new bb.c(this, c0);
            }
            else {
                c1.B = v ^ 0x80000000;
            }
        }
        else {
            c1 = new bb.c(this, c0);
        }
        Object object0 = c1.r;
        ne.a a0 = ne.a.a;
        switch(c1.B) {
            case 0: {
                n.D(object0);
                try {
                    c1.B = 1;
                    object0 = ((ua.u)this.a).g(s, s1, s2, c1);
                    if(object0 == a0) {
                        return a0;
                    label_18:
                        n.D(object0);
                    }
                    return new Na.e(((MyMusicLikeInformContentsLikeRes)object0));
                }
                catch(Exception exception0) {
                    break;
                }
            }
            case 1: {
                goto label_18;
            }
            default: {
                throw new IllegalStateException("call to \'resume\' before \'invoke\' with coroutine");
            }
        }
        return new Na.d(exception0);
    }

    public static List i(Map map0) {
        ArrayList arrayList0 = new ArrayList();
        arrayList0.ensureCapacity(map0.size());
        for(Object object0: map0.entrySet()) {
            String s = (String)((Map.Entry)object0).getKey();
            if(s == null) {
                throw new NullPointerException("Null key");
            }
            String s1 = (String)((Map.Entry)object0).getValue();
            if(s1 == null) {
                throw new NullPointerException("Null value");
            }
            arrayList0.add(new F(s, s1));
        }
        Collections.sort(arrayList0, new E1.a(12));
        return Collections.unmodifiableList(arrayList0);
    }

    public Integer j(int v) {
        Integer integer0 = (Integer)((LinkedHashMap)this.f).get(v);
        if(integer0 == null) {
            q q0 = (q)this.d;
            return q0 == null ? null : q0.j(v);
        }
        return integer0;
    }

    @Override  // jf.l
    public void k() {
        E9.u u0 = (E9.u)this.c;
        qf.b b0 = (qf.b)this.e;
        HashMap hashMap0 = (HashMap)this.b;
        kotlin.jvm.internal.q.g(hashMap0, "arguments");
        boolean z = false;
        if(b0.equals(Ie.a.b)) {
            Object object0 = hashMap0.get(qf.e.e("value"));
            s s0 = null;
            vf.u u1 = object0 instanceof vf.u ? ((vf.u)object0) : null;
            if(u1 != null) {
                Object object1 = u1.a;
                if(object1 instanceof s) {
                    s0 = (s)object1;
                }
                if(s0 != null) {
                    z = u0.z(s0.a.a);
                }
            }
        }
        if(z || u0.z(b0)) {
            return;
        }
        ((List)this.f).add(new Ne.c(((Me.e)this.d).g(), hashMap0, ((N)this.g)));
    }

    @Override  // jf.l
    public m l(qf.e e0) {
        E9.u u0 = (E9.u)this.a;
        m m0 = new o9.b();  // 初始化器: Ljava/lang/Object;-><init>()V
        m0.b = u0;
        m0.c = e0;
        m0.d = this;
        m0.a = new ArrayList();
        return m0;
    }

    @Override  // jf.l
    public l m(qf.b b0, qf.e e0) {
        ArrayList arrayList0 = new ArrayList();
        return new i(((E9.u)this.a).B(b0, N.q, arrayList0), this, e0, arrayList0);
    }

    @Override  // jf.l
    public void n(qf.e e0, qf.b b0, qf.e e1) {
        vf.j j0 = new vf.j(b0, e1);
        ((HashMap)this.b).put(e0, j0);
    }

    @Override  // jf.l
    public void o(qf.e e0, Object object0) {
        vf.g g0 = E9.u.m(((E9.u)this.a), e0, object0);
        ((HashMap)this.b).put(e0, g0);
    }

    @Override  // jf.l
    public void p(qf.e e0, vf.f f0) {
        vf.u u0 = new vf.u(new s(f0));  // 初始化器: Lvf/g;-><init>(Ljava/lang/Object;)V
        ((HashMap)this.b).put(e0, u0);
    }

    public void q(Throwable throwable0, Thread thread0, String s, g7.c c0, boolean z) {
        Iterator iterator1;
        boolean z1 = s.equals("crash");
        e7.p p0 = (e7.p)this.a;
        long v = c0.b;
        Context context0 = p0.a;
        int v1 = context0.getResources().getConfiguration().orientation;
        d5.c c1 = p0.d;
        Stack stack0 = new Stack();
        for(Throwable throwable1 = throwable0; throwable1 != null; throwable1 = throwable1.getCause()) {
            stack0.push(throwable1);
        }
        o9.b b0;
        for(b0 = null; !stack0.isEmpty(); b0 = b1) {
            Throwable throwable2 = (Throwable)stack0.pop();
            String s1 = throwable2.getClass().getName();
            StackTraceElement[] arr_stackTraceElement = c1.l(throwable2.getStackTrace());
            o9.b b1 = new o9.b();  // 初始化器: Ljava/lang/Object;-><init>()V
            b1.a = throwable2.getLocalizedMessage();
            b1.b = s1;
            b1.c = arr_stackTraceElement;
            b1.d = b0;
        }
        O o0 = new O();  // 初始化器: Ljava/lang/Object;-><init>()V
        o0.b = s;
        o0.a = v;
        o0.g = (byte)(o0.g | 1);
        D0 d00 = b7.c.b.d(context0);
        int v2 = ((a0)d00).c;
        Boolean boolean0 = v2 <= 0 ? null : Boolean.valueOf(v2 != 100);
        ArrayList arrayList0 = b7.c.c(context0);
        ArrayList arrayList1 = new ArrayList();
        StackTraceElement[] arr_stackTraceElement1 = (StackTraceElement[])b0.c;
        String s2 = thread0.getName();
        if(s2 == null) {
            throw new NullPointerException("Null name");
        }
        List list0 = e7.p.d(arr_stackTraceElement1, 4);
        if(list0 == null) {
            throw new NullPointerException("Null frames");
        }
        arrayList1.add(new W(s2, 4, list0));
        if(z) {
            for(Iterator iterator0 = Thread.getAllStackTraces().entrySet().iterator(); iterator0.hasNext(); iterator0 = iterator1) {
                Object object0 = iterator0.next();
                Map.Entry map$Entry0 = (Map.Entry)object0;
                Thread thread1 = (Thread)map$Entry0.getKey();
                if(thread1.equals(thread0)) {
                    iterator1 = iterator0;
                }
                else {
                    StackTraceElement[] arr_stackTraceElement2 = c1.l(((StackTraceElement[])map$Entry0.getValue()));
                    String s3 = thread1.getName();
                    if(s3 == null) {
                        throw new NullPointerException("Null name");
                    }
                    iterator1 = iterator0;
                    List list1 = e7.p.d(arr_stackTraceElement2, 0);
                    if(list1 == null) {
                        throw new NullPointerException("Null frames");
                    }
                    arrayList1.add(new W(s3, 0, list1));
                    continue;
                }
            }
        }
        List list2 = Collections.unmodifiableList(arrayList1);
        U u0 = e7.p.c(b0, 0);
        V v3 = e7.p.e();
        List list3 = p0.a();
        if(list3 == null) {
            throw new NullPointerException("Null binaries");
        }
        o0.c = new Q(new S(list2, u0, null, v3, list3), null, null, boolean0, d00, arrayList0, v1);
        o0.d = p0.b(v1);
        P p1 = o0.a();
        g7.f f0 = (g7.f)this.d;
        q q0 = (q)this.e;
        K0 k00 = q.d(q.a(p1, f0, q0, c0.c), q0);
        if(!z) {
            ((d)this.g).b.a(new r0(this, k00, c0, z1, 2));
            return;
        }
        ((k7.a)this.b).d(k00, c0.a, z1);
    }

    // This method was un-flattened
    public Task r(String s, Executor executor0) {
        TaskCompletionSource taskCompletionSource0;
        int v;
        ArrayBlockingQueue arrayBlockingQueue0;
        ArrayList arrayList0 = ((k7.a)this.b).b();
        ArrayList arrayList1 = new ArrayList();
        for(Object object0: arrayList0) {
            File file0 = (File)object0;
            try {
                String s1 = k7.a.e(file0);
                k7.a.g.getClass();
                arrayList1.add(new e7.a(i7.a.i(s1), file0.getName(), file0));
            }
            catch(IOException iOException0) {
                Log.w("FirebaseCrashlytics", "Could not load report file " + file0 + "; deleting", iOException0);
                file0.delete();
            }
        }
        ArrayList arrayList2 = new ArrayList();
        for(Object object1: arrayList1) {
            e7.a a0 = (e7.a)object1;
            if(s == null || s.equals(a0.b)) {
                l7.a a1 = (l7.a)this.c;
                if(a0.a.f == null || a0.a.g == null) {
                    t t0 = ((u)this.f).b(true);
                    A a2 = a0.a.a();
                    a2.e = t0.a;
                    A a3 = a2.a().a();
                    a3.f = t0.b;
                    a0 = new e7.a(a3.a(), a0.b, a0.c);
                }
                if(s == null) {
                    arrayBlockingQueue0 = a1.a.f;
                    __monitor_enter(arrayBlockingQueue0);
                    v = FIN.finallyOpen$NT();
                    taskCompletionSource0 = new TaskCompletionSource();
                    a1.a.b(a0, taskCompletionSource0);
                }
                else {
                    l7.c c0 = a1.a;
                    arrayBlockingQueue0 = c0.f;
                    __monitor_enter(arrayBlockingQueue0);
                    v = FIN.finallyOpen$NT();
                    taskCompletionSource0 = new TaskCompletionSource();
                    ((AtomicInteger)c0.i.a).getAndIncrement();
                    if(c0.f.size() < c0.e) {
                        b7.c.a.b("Enqueueing report: " + a0.b);
                        b7.c.a.b("Queue size: " + c0.f.size());
                        X4.d d0 = new X4.d(c0, a0, taskCompletionSource0, 4);
                        c0.g.execute(d0);
                        b7.c.a.b("Closing task for report: " + a0.b);
                    }
                    else {
                        c0.a();
                        String s2 = "Dropping report due to queue being full: " + a0.b;
                        if(Log.isLoggable("FirebaseCrashlytics", 3)) {
                            Log.d("FirebaseCrashlytics", s2, null);
                        }
                        ((AtomicInteger)c0.i.b).getAndIncrement();
                    }
                    taskCompletionSource0.trySetResult(a0);
                }
                FIN.finallyCodeBegin$NT(v);
                __monitor_exit(arrayBlockingQueue0);
                FIN.finallyCodeEnd$NT(v);
                arrayList2.add(taskCompletionSource0.getTask().continueWith(executor0, new com.iloen.melon.fragments.musicmessage.e(this)));
            }
        }
        return Tasks.whenAll(arrayList2);
    }

    public static Flow s(q q0, boolean z, String s, String s1, String s2, String s3, String s4, int v) {
        String s5;
        if((v & 16) != 0) {
            s3 = "";
        }
        if((v & 0x20) == 0) {
            s5 = s4;
        }
        else {
            kotlin.jvm.internal.q.f("N20001", "value");
            s5 = "N20001";
        }
        q0.getClass();
        kotlin.jvm.internal.q.g(s, "contentId");
        kotlin.jvm.internal.q.g(s1, "menuId");
        kotlin.jvm.internal.q.g(s2, "contsTypeCode");
        kotlin.jvm.internal.q.g(s5, "actTypeCode");
        if(s.length() == 0) {
            return FlowKt.flowOf(new bb.f(new Na.c("cid is empty")));
        }
        if(!NetUtils.isConnected()) {
            return FlowKt.flowOf(new bb.l(0x7F1303DA));  // string:error_network_connectivity_toast "해당 페이지의 접속이 지연되고 있습니다.\n잠시 후 다시 이용해주세요."
        }
        return ((va.e0)(((mb.k)q0.e))).m() ? FlowKt.catch(FlowKt.flow(new bb.d(z, q0, s2, s5, s, s1, s3, null)), new H(3, 4, null)) : FlowKt.flowOf(bb.k.a);
    }

    public q t(List list0) {
        kotlin.jvm.internal.q.g(list0, "typeParameters");
        q q0 = new q(((nf.f)this.a), ((z)this.b), ((nf.h)this.c), this, ((List)this.e));
        for(Object object0: list0) {
            ((LinkedHashMap)q0.f).put(((Y)object0).e, ((Y)object0).d);
        }
        return q0;
    }
}


package d5;

import B3.j;
import B3.n;
import B3.r;
import B3.s;
import D2.E0;
import Df.d;
import Df.e;
import E9.w;
import android.content.Context;
import android.database.Cursor;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup.LayoutParams;
import android.view.ViewGroup.MarginLayoutParams;
import android.widget.EditText;
import androidx.room.O;
import androidx.work.impl.WorkDatabase_Impl;
import com.google.android.material.floatingactionbutton.ExtendedFloatingActionButton;
import com.iloen.melon.MelonAppBase;
import com.iloen.melon.utils.MenuIdQueue;
import com.iloen.melon.utils.log.Category;
import com.iloen.melon.utils.log.LogU;
import com.melon.net.res.common.ResponseBase;
import e1.G;
import e1.u;
import e3.h;
import e3.p;
import e3.v;
import e3.x;
import h4.z;
import hf.o;
import ie.H;
import ie.m;
import java.lang.reflect.Constructor;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.concurrent.atomic.AtomicBoolean;
import jeb.synthetic.FIN;
import kotlin.jvm.internal.q;
import n7.a;
import r6.g;
import va.e0;
import we.k;
import x2.i;

public final class c implements j, e, a, g {
    public final int a;
    public Object b;
    public Object c;

    public c(int v) {
        this.a = v;
        if(v != 5) {
            super();
            return;
        }
        super();
        this.b = new LinkedHashMap();
        this.c = new LinkedHashMap();
    }

    public c(int v, Object object0, Object object1) {
        this.a = v;
        this.b = object0;
        this.c = object1;
        super();
    }

    public c(n n0) {
        this.a = 1;
        super();
        this.b = n0;
        this.c = new AtomicBoolean(false);
    }

    public c(E0 e00, String s) {
        this.a = 10;
        super();
        q.g(s, "className");
        this.c = e00;
        this.b = s;
    }

    public c(Context context0, Z8.g g0) {
        this.a = 7;
        super();
        this.b = context0;
        this.c = new com.gaa.sdk.iap.a(g0);
    }

    public c(EditText editText0) {
        this.a = 15;
        super();
        this.b = editText0;
        i i0 = new i(editText0);
        this.c = i0;
        editText0.addTextChangedListener(i0);
        if(x2.a.b == null) {
            synchronized(x2.a.a) {
                if(x2.a.b == null) {
                    x2.a a0 = new x2.a();  // 初始化器: Landroid/text/Editable$Factory;-><init>()V
                    try {
                        x2.a.c = Class.forName("android.text.DynamicLayout$ChangeWatcher", false, x2.a.class.getClassLoader());
                    }
                    catch(Throwable unused_ex) {
                    }
                    x2.a.b = a0;
                }
            }
        }
        editText0.setEditableFactory(x2.a.b);
    }

    public c(WorkDatabase_Impl workDatabase_Impl0) {
        this.a = 0;
        super();
        this.b = workDatabase_Impl0;
        this.c = new b(workDatabase_Impl0, false, 0);
    }

    public c(v v0) {
        this.a = 9;
        super();
        this.b = v0;
        this.c = new p();
    }

    public c(Object object0, Object object1, boolean z, int v) {
        this.a = v;
        this.c = object0;
        this.b = object1;
        super();
    }

    public c(na.c c0) {
        this.a = 8;
        super();
        this.b = c0;
        LogU logU0 = new LogU("PVReportUseCase");
        logU0.setCategory(Category.None);
        logU0.setUseThreadInfo(true);
        this.c = logU0;
    }

    public c(a[] arr_a) {
        this.a = 13;
        super();
        this.b = arr_a;
        this.c = new h();  // 初始化器: Ljava/lang/Object;-><init>()V
    }

    @Override  // B3.j
    public B3.i a(s s0, long v) {
        long v1 = s0.getPosition();
        int v2 = (int)Math.min(20000L, s0.getLength() - v1);
        p p0 = (p)this.c;
        p0.D(v2);
        s0.peekFully(p0.a, 0, v2);
        int v3 = -1;
        int v4 = -1;
        long v5 = 0x8000000000000001L;
        while(p0.a() >= 4) {
            if(G3.b.g(p0.a, p0.b) == 442) {
                p0.H(4);
                long v6 = z.c(p0);
                if(v6 != 0x8000000000000001L) {
                    long v7 = ((v)this.b).b(v6);
                    if(v7 > v) {
                        return v5 == 0x8000000000000001L ? new B3.i(-1, v7, v1) : new B3.i(0, 0x8000000000000001L, v1 + ((long)v4));
                    }
                    if(v7 + 100000L > v) {
                        return new B3.i(0, 0x8000000000000001L, v1 + ((long)p0.b));
                    }
                    v5 = v7;
                    v4 = p0.b;
                }
                int v8 = p0.c;
                if(p0.a() < 10) {
                    p0.G(v8);
                }
                else {
                    p0.H(9);
                    int v9 = p0.u() & 7;
                    if(p0.a() < v9) {
                        p0.G(v8);
                    }
                    else {
                        p0.H(v9);
                        if(p0.a() < 4) {
                            p0.G(v8);
                        }
                        else {
                            if(G3.b.g(p0.a, p0.b) == 443) {
                                p0.H(4);
                                int v10 = p0.A();
                                if(p0.a() < v10) {
                                    p0.G(v8);
                                    goto label_52;
                                }
                                else {
                                    p0.H(v10);
                                }
                            }
                            while(p0.a() >= 4) {
                                int v11 = G3.b.g(p0.a, p0.b);
                                if(v11 == 442 || v11 == 441 || v11 >>> 8 != 1) {
                                    break;
                                }
                                p0.H(4);
                                if(p0.a() < 2) {
                                    p0.G(v8);
                                    break;
                                }
                                int v12 = p0.A();
                                p0.G(Math.min(p0.c, p0.b + v12));
                            }
                        }
                    }
                }
            label_52:
                v3 = p0.b;
            }
            else {
                p0.H(1);
            }
        }
        return v5 == 0x8000000000000001L ? B3.i.d : new B3.i(-2, v5, v1 + ((long)v3));
    }

    public void b(String s, k k0, String s1) {
        LinkedHashMap linkedHashMap0 = ((E0)this.c).a;
        o o0 = new o(this, s, s1);
        k0.invoke(o0);
        String s2 = (String)this.b;
        ArrayList arrayList0 = o0.b;
        ArrayList arrayList1 = new ArrayList(je.q.Q(10, arrayList0));
        for(Object object0: arrayList0) {
            arrayList1.add(((String)((m)object0).a));
        }
        String s3 = (String)o0.c.a;
        q.g(s3, "ret");
        StringBuilder stringBuilder0 = new StringBuilder();
        stringBuilder0.append(s);
        stringBuilder0.append('(');
        stringBuilder0.append(je.p.q0(arrayList1, "", null, null, jf.q.a, 30));
        stringBuilder0.append(')');
        if(s3.length() > 1) {
            s3 = "L" + s3 + ';';
        }
        stringBuilder0.append(s3);
        String s4 = stringBuilder0.toString();
        q.g(s2, "internalName");
        q.g(s4, "jvmDescriptor");
        hf.q q0 = (hf.q)o0.c.b;
        ArrayList arrayList2 = new ArrayList(je.q.Q(10, arrayList0));
        for(Object object1: arrayList0) {
            arrayList2.add(((hf.q)((m)object1).b));
        }
        linkedHashMap0.put(s2 + '.' + s4, new hf.m(q0, arrayList2, o0.a));
    }

    @Override  // r6.g
    public ViewGroup.LayoutParams c() {
        int v = ((ExtendedFloatingActionButton)this.c).g0;
        if(v == 0) {
            v = -2;
        }
        return new ViewGroup.LayoutParams(-1, v);
    }

    public ArrayList d(String s) {
        O o0 = O.c(1, "SELECT work_spec_id FROM dependency WHERE prerequisite_id=?");
        o0.k(1, s);
        WorkDatabase_Impl workDatabase_Impl0 = (WorkDatabase_Impl)this.b;
        workDatabase_Impl0.assertNotSuspendingTransaction();
        Cursor cursor0 = w.R(workDatabase_Impl0, o0, false);
        try {
            ArrayList arrayList0 = new ArrayList(cursor0.getCount());
            while(cursor0.moveToNext()) {
                arrayList0.add(cursor0.getString(0));
            }
            return arrayList0;
        }
        finally {
            cursor0.close();
            o0.release();
        }
    }

    public r e(Object[] arr_object) {
        Constructor constructor0;
        AtomicBoolean atomicBoolean0 = (AtomicBoolean)this.c;
        __monitor_enter(atomicBoolean0);
        int v = FIN.finallyOpen$NT();
        if(((AtomicBoolean)this.c).get()) {
        label_12:
            FIN.finallyCodeBegin$NT(v);
            __monitor_exit(atomicBoolean0);
            FIN.finallyCodeEnd$NT(v);
            constructor0 = null;
        }
        else {
            try {
                constructor0 = ((n)this.b).h();
                FIN.finallyExec$NT(v);
            }
            catch(ClassNotFoundException unused_ex) {
                ((AtomicBoolean)this.c).set(true);
                goto label_12;
            }
            catch(Exception exception0) {
                FIN.finallyExec$NT(v);
                throw new RuntimeException("Error instantiating extension", exception0);
            }
        }
        if(constructor0 == null) {
            return null;
        }
        try {
            return (r)constructor0.newInstance(arr_object);
        }
        catch(Exception exception1) {
            throw new IllegalStateException("Unexpected error creating extractor", exception1);
        }
    }

    @Override  // Df.e
    public d f(qf.b b0) {
        q.g(b0, "classId");
        Re.b b1 = (Re.b)this.b;
        jf.e e0 = (jf.e)this.c;
        e0.c().c.getClass();
        Re.c c0 = G.q(b1, b0, nf.e.g);
        if(c0 == null) {
            return null;
        }
        Se.c.a(c0.a).equals(b0);
        return e0.g(c0);
    }

    public Object g(eb.q q0, oe.c c0) {
        eb.o o0;
        if(c0 instanceof eb.o) {
            o0 = (eb.o)c0;
            int v = o0.D;
            if((v & 0x80000000) == 0) {
                o0 = new eb.o(this, c0);
            }
            else {
                o0.D = v ^ 0x80000000;
            }
        }
        else {
            o0 = new eb.o(this, c0);
        }
        Object object0 = o0.w;
        ne.a a0 = ne.a.a;
        switch(o0.D) {
            case 0: {
                d5.n.D(object0);
                try {
                    o0.r = q0;
                    o0.D = 1;
                    if(((na.c)this.b).b(q0.b, o0) == a0) {
                        return a0;
                    label_18:
                        q0 = o0.r;
                        d5.n.D(object0);
                    }
                }
                catch(Exception exception0) {
                    LogU.warn$default(((LogU)this.c), "report::onErrorResponse() " + exception0.getMessage(), null, false, 6, null);
                }
                break;
            }
            case 1: {
                goto label_18;
            }
            default: {
                throw new IllegalStateException("call to \'resume\' before \'invoke\' with coroutine");
            }
        }
        String s = q0.a.menuId;
        p8.r.a(q0.a, s, q0.c);
        MenuIdQueue.getInstance().offer(s);
        return H.a;
    }

    @Override  // r6.g
    public int getHeight() {
        ExtendedFloatingActionButton extendedFloatingActionButton0 = ((r6.c)this.b).b;
        ExtendedFloatingActionButton extendedFloatingActionButton1 = (ExtendedFloatingActionButton)this.c;
        int v = extendedFloatingActionButton1.g0;
        if(v == -1) {
            if(!(extendedFloatingActionButton1.getParent() instanceof View)) {
                return extendedFloatingActionButton0.getMeasuredHeight();
            }
            View view0 = (View)extendedFloatingActionButton1.getParent();
            ViewGroup.LayoutParams viewGroup$LayoutParams0 = view0.getLayoutParams();
            if(viewGroup$LayoutParams0 != null && viewGroup$LayoutParams0.height == -2) {
                return extendedFloatingActionButton0.getMeasuredHeight();
            }
            int v1 = view0.getPaddingTop();
            int v2 = view0.getPaddingBottom();
            if(extendedFloatingActionButton1.getLayoutParams() instanceof ViewGroup.MarginLayoutParams) {
                ViewGroup.MarginLayoutParams viewGroup$MarginLayoutParams0 = (ViewGroup.MarginLayoutParams)extendedFloatingActionButton1.getLayoutParams();
                if(viewGroup$MarginLayoutParams0 != null) {
                    int v3 = viewGroup$MarginLayoutParams0.topMargin + viewGroup$MarginLayoutParams0.bottomMargin;
                    return view0.getHeight() - v3 - (v2 + v1);
                }
            }
            return view0.getHeight() - (v2 + v1);
        }
        return v == -2 || v == 0 ? extendedFloatingActionButton0.getMeasuredHeight() : v;
    }

    @Override  // r6.g
    public int getPaddingEnd() {
        return ((ExtendedFloatingActionButton)this.c).V;
    }

    @Override  // r6.g
    public int getPaddingStart() {
        return ((ExtendedFloatingActionButton)this.c).T;
    }

    @Override  // r6.g
    public int getWidth() {
        r6.c c0 = (r6.c)this.b;
        ExtendedFloatingActionButton extendedFloatingActionButton0 = (ExtendedFloatingActionButton)this.c;
        if(!(extendedFloatingActionButton0.getParent() instanceof View)) {
            return c0.getWidth();
        }
        View view0 = (View)extendedFloatingActionButton0.getParent();
        ViewGroup.LayoutParams viewGroup$LayoutParams0 = view0.getLayoutParams();
        if(viewGroup$LayoutParams0 != null && viewGroup$LayoutParams0.width == -2) {
            return c0.getWidth();
        }
        int v = view0.getPaddingLeft();
        int v1 = view0.getPaddingRight();
        if(extendedFloatingActionButton0.getLayoutParams() instanceof ViewGroup.MarginLayoutParams) {
            ViewGroup.MarginLayoutParams viewGroup$MarginLayoutParams0 = (ViewGroup.MarginLayoutParams)extendedFloatingActionButton0.getLayoutParams();
            if(viewGroup$MarginLayoutParams0 != null) {
                int v2 = viewGroup$MarginLayoutParams0.leftMargin + viewGroup$MarginLayoutParams0.rightMargin;
                return view0.getWidth() - v2 - (v1 + v);
            }
        }
        return view0.getWidth() - (v1 + v);
    }

    public Object h(eb.q q0, oe.c c0) {
        eb.p p0;
        if(c0 instanceof eb.p) {
            p0 = (eb.p)c0;
            int v = p0.D;
            if((v & 0x80000000) == 0) {
                p0 = new eb.p(this, c0);
            }
            else {
                p0.D = v ^ 0x80000000;
            }
        }
        else {
            p0 = new eb.p(this, c0);
        }
        Object object0 = p0.w;
        ne.a a0 = ne.a.a;
        switch(p0.D) {
            case 0: {
                d5.n.D(object0);
                try {
                    p0.r = q0;
                    p0.D = 1;
                    if(((na.c)this.b).b(q0.b, p0) == a0) {
                        return a0;
                    label_18:
                        q0 = p0.r;
                        d5.n.D(object0);
                    }
                }
                catch(Exception exception0) {
                    LogU.warn$default(((LogU)this.c), "report::onErrorResponse() " + exception0.getMessage(), null, false, 6, null);
                }
                break;
            }
            case 1: {
                goto label_18;
            }
            default: {
                throw new IllegalStateException("call to \'resume\' before \'invoke\' with coroutine");
            }
        }
        HashMap hashMap0 = new HashMap();
        hashMap0.put("player_type", "6");
        hashMap0.put("PIP", "On");
        ResponseBase responseBase0 = q0.a;
        String s = responseBase0.menuId;
        String s1 = q0.c;
        if(TextUtils.isEmpty(s)) {
            LogU.Companion.w("MelonTiaraLogHelper", "sendPvLog() - Invalid argument");
        }
        else {
            MelonAppBase.Companion.getClass();
            q.f("페이지보기", "getString(...)");
            HashMap hashMap1 = p8.q.b();
            hashMap1.put("menuid", s);
            hashMap1.put("orgmenuid", s1);
            hashMap1.put("charged", (u.u(((e0)va.o.a()).j()).equals("4") ? "N" : "Y"));
            hashMap1.putAll(hashMap0);
            if(TextUtils.isEmpty(responseBase0.section) || TextUtils.isEmpty(responseBase0.page)) {
                p8.q.c().trackPage("페이지보기").page(s).customProps(hashMap1).adTrackId("2875552754074864296").track();
            }
            else {
                p8.q.c().trackPage((responseBase0.section == null ? "" : responseBase0.section) + "페이지보기").section(responseBase0.section).page(responseBase0.page).customProps(hashMap1).adTrackId("2875552754074864296").track();
            }
        }
        MenuIdQueue.getInstance().offer(s);
        return H.a;
    }

    @Override  // n7.a
    public StackTraceElement[] l(StackTraceElement[] arr_stackTraceElement) {
        if(arr_stackTraceElement.length <= 0x400) {
            return arr_stackTraceElement;
        }
        a[] arr_a = (a[])this.b;
        StackTraceElement[] arr_stackTraceElement1 = arr_stackTraceElement;
        for(int v = 0; v < 1; ++v) {
            a a0 = arr_a[v];
            if(arr_stackTraceElement1.length <= 0x400) {
                break;
            }
            arr_stackTraceElement1 = a0.l(arr_stackTraceElement);
        }
        return arr_stackTraceElement1.length <= 0x400 ? arr_stackTraceElement1 : ((h)this.c).l(arr_stackTraceElement1);
    }

    @Override  // B3.j
    public void onSeekFinished() {
        p p0 = (p)this.c;
        p0.getClass();
        p0.E(x.f, x.f.length);
    }

    @Override
    public String toString() {
        return this.a == 11 ? ((String)this.b) + ", " + ((String)this.c) : super.toString();
    }
}


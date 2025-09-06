package androidx.compose.ui.tooling;

import G.s0;
import P0.I;
import P0.d0;
import Q0.k0;
import Sf.n;
import Tf.o;
import android.content.Context;
import android.graphics.Canvas;
import android.graphics.DashPathEffect;
import android.graphics.Paint.Style;
import android.graphics.Paint;
import android.graphics.Rect;
import android.util.AttributeSet;
import android.util.Log;
import android.widget.FrameLayout;
import androidx.compose.runtime.O0;
import androidx.compose.runtime.b0;
import androidx.compose.runtime.m0;
import androidx.compose.runtime.n0;
import androidx.compose.runtime.p;
import androidx.compose.ui.platform.ComposeView;
import androidx.lifecycle.f0;
import e1.k;
import e1.x;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.LinkedHashSet;
import java.util.List;
import je.u;
import je.w;
import kotlin.Metadata;
import kotlin.jvm.internal.r;
import m0.b;
import m1.d;
import m1.e;
import m1.f;
import m1.g;
import m1.h;
import m1.l;
import m1.m;
import n1.i;
import n1.q;
import org.jetbrains.annotations.NotNull;
import q1.j;
import we.a;
import x9.c;
import y0.M;
import y0.s;

@Metadata(d1 = {"\u0000R\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\u000E\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000B\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\t\b\u0000\u0018\u00002\u00020\u0001B\u0019\b\u0016\u0012\u0006\u0010\u0003\u001A\u00020\u0002\u0012\u0006\u0010\u0005\u001A\u00020\u0004¢\u0006\u0004\b\u0006\u0010\u0007B!\b\u0016\u0012\u0006\u0010\u0003\u001A\u00020\u0002\u0012\u0006\u0010\u0005\u001A\u00020\u0004\u0012\u0006\u0010\t\u001A\u00020\b¢\u0006\u0004\b\u0006\u0010\nR(\u0010\u0013\u001A\b\u0012\u0004\u0012\u00020\f0\u000B8\u0000@\u0000X\u0080\u000E¢\u0006\u0012\n\u0004\b\r\u0010\u000E\u001A\u0004\b\u000F\u0010\u0010\"\u0004\b\u0011\u0010\u0012R(\u0010\u0018\u001A\b\u0012\u0004\u0012\u00020\u00140\u000B8\u0000@\u0000X\u0080\u000E¢\u0006\u0012\n\u0004\b\u0015\u0010\u000E\u001A\u0004\b\u0016\u0010\u0010\"\u0004\b\u0017\u0010\u0012R&\u0010 \u001A\u000E\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u001B0\u001A0\u00198\u0002X\u0082\u0004¢\u0006\f\n\u0004\b\u001C\u0010\u001D\u0012\u0004\b\u001E\u0010\u001FR\"\u0010(\u001A\u00020!8\u0000@\u0000X\u0080\u000E¢\u0006\u0012\n\u0004\b\"\u0010#\u001A\u0004\b$\u0010%\"\u0004\b&\u0010\'R(\u00101\u001A\u00020)8\u0000@\u0000X\u0081.¢\u0006\u0018\n\u0004\b*\u0010+\u0012\u0004\b0\u0010\u001F\u001A\u0004\b,\u0010-\"\u0004\b.\u0010/¨\u00062"}, d2 = {"Landroidx/compose/ui/tooling/ComposeViewAdapter;", "Landroid/widget/FrameLayout;", "Landroid/content/Context;", "context", "Landroid/util/AttributeSet;", "attrs", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "", "defStyleAttr", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "", "Lm1/q;", "e", "Ljava/util/List;", "getViewInfos$ui_tooling_release", "()Ljava/util/List;", "setViewInfos$ui_tooling_release", "(Ljava/util/List;)V", "viewInfos", "", "f", "getDesignInfoList$ui_tooling_release", "setDesignInfoList$ui_tooling_release", "designInfoList", "Landroidx/compose/runtime/b0;", "Lkotlin/Function0;", "Lie/H;", "k", "Landroidx/compose/runtime/b0;", "getContent$annotations", "()V", "content", "", "r", "Z", "getStitchTrees$ui_tooling_release", "()Z", "setStitchTrees$ui_tooling_release", "(Z)V", "stitchTrees", "Ln1/q;", "B", "Ln1/q;", "getClock$ui_tooling_release", "()Ln1/q;", "setClock$ui_tooling_release", "(Ln1/q;)V", "getClock$ui_tooling_release$annotations", "clock", "ui-tooling_release"}, k = 1, mv = {1, 9, 0}, xi = 0x30)
public final class ComposeViewAdapter extends FrameLayout {
    public q B;
    public final f D;
    public final g E;
    public final e G;
    public final d I;
    public final String a;
    public final ComposeView b;
    public boolean c;
    public boolean d;
    public List e;
    public List f;
    public final m g;
    public String h;
    public final c i;
    public b j;
    public final b0 k;
    public boolean l;
    public boolean m;
    public String n;
    public a o;
    public boolean r;
    public final Paint w;

    public ComposeViewAdapter(@NotNull Context context0, @NotNull AttributeSet attributeSet0) {
        super(context0, attributeSet0);
        this.a = "ComposeViewAdapter";
        this.b = new ComposeView(this.getContext(), null, 6, 0);
        this.e = w.a;
        this.f = w.a;
        this.g = new m();
        this.h = "";
        this.i = new c(12);
        this.j = m1.b.b;
        this.k = androidx.compose.runtime.w.s(l.a);
        this.n = "";
        this.o = h.i;
        this.r = true;
        Paint paint0 = new Paint();
        paint0.setPathEffect(new DashPathEffect(new float[]{5.0f, 10.0f, 15.0f, 20.0f}, 0.0f));
        paint0.setStyle(Paint.Style.STROKE);
        paint0.setColor(M.z(s.d));
        this.w = paint0;
        this.D = new f();
        this.E = new g();
        this.G = new e(this);
        this.I = new d();
        this.e(attributeSet0);
    }

    public ComposeViewAdapter(@NotNull Context context0, @NotNull AttributeSet attributeSet0, int v) {
        super(context0, attributeSet0, v);
        this.a = "ComposeViewAdapter";
        this.b = new ComposeView(this.getContext(), null, 6, 0);
        this.e = w.a;
        this.f = w.a;
        this.g = new m();
        this.h = "";
        this.i = new c(12);
        this.j = m1.b.b;
        this.k = androidx.compose.runtime.w.s(l.a);
        this.n = "";
        this.o = h.i;
        this.r = true;
        Paint paint0 = new Paint();
        paint0.setPathEffect(new DashPathEffect(new float[]{5.0f, 10.0f, 15.0f, 20.0f}, 0.0f));
        paint0.setStyle(Paint.Style.STROKE);
        paint0.setColor(M.z(s.d));
        this.w = paint0;
        this.D = new f();
        this.E = new g();
        this.G = new e(this);
        this.I = new d();
        this.e(attributeSet0);
    }

    public static final void a(ComposeViewAdapter composeViewAdapter0, b b0, androidx.compose.runtime.l l0, int v) {
        ((p)l0).c0(0x1F1F458C);
        int v1 = (v & 6) == 0 ? (((p)l0).i(b0) ? 4 : 2) | v : v;
        if((v & 0x30) == 0) {
            v1 |= (((p)l0).i(composeViewAdapter0) ? 0x20 : 16);
        }
        if(((p)l0).Q(v1 & 1, (v1 & 19) != 18)) {
            LayoutlibFontResourceLoader layoutlibFontResourceLoader0 = new LayoutlibFontResourceLoader(composeViewAdapter0.getContext());
            m0 m00 = k0.j.a(layoutlibFontResourceLoader0);
            k k0 = e1.m.m(composeViewAdapter0.getContext());
            androidx.compose.runtime.w.b(new m0[]{m00, k0.k.a(k0), c.e.a.a(composeViewAdapter0.G), c.d.a.a(composeViewAdapter0.I)}, m0.c.e(0xA80CE8CC, ((p)l0), new B2.p(21, composeViewAdapter0, b0)), ((p)l0), 56);
        }
        else {
            ((p)l0).T();
        }
        n0 n00 = ((p)l0).t();
        if(n00 != null) {
            n00.d = new s0(composeViewAdapter0, b0, v, 8);
        }
    }

    public static final boolean b(ComposeViewAdapter composeViewAdapter0, q1.c c0) {
        Iterable iterable0 = (Iterable)c0.f;
        if(!(iterable0 instanceof Collection) || !((Collection)iterable0).isEmpty()) {
            for(Object object0: iterable0) {
                Method method0 = null;
                if(object0 != null) {
                    try {
                        method0 = object0.getClass().getDeclaredMethod("getDesignInfo", Integer.TYPE, Integer.TYPE, String.class);
                    }
                    catch(NoSuchMethodException unused_ex) {
                    }
                }
                if(method0 != null) {
                    return true;
                }
                if(false) {
                    break;
                }
            }
        }
        return false;
    }

    public final String c(q1.c c0, r1.k k0) {
        Method method0;
        int v1;
        int v;
        String s;
        Iterator iterator0 = ((Iterable)c0.f).iterator();
        do {
            s = null;
            if(!iterator0.hasNext()) {
                break;
            }
            Object object0 = iterator0.next();
            if(object0 != null) {
                try {
                    v = k0.a;
                    v1 = k0.c;
                    method0 = null;
                    method0 = object0.getClass().getDeclaredMethod("getDesignInfo", Integer.TYPE, Integer.TYPE, String.class);
                }
                catch(NoSuchMethodException unused_ex) {
                }
                if(method0 != null) {
                    try {
                        Object object1 = method0.invoke(object0, v, v1, this.n);
                        kotlin.jvm.internal.q.e(object1, "null cannot be cast to non-null type kotlin.String");
                        String s1 = (String)object1;
                        if(s1.length() != 0) {
                            s = s1;
                        }
                    }
                    catch(Exception unused_ex) {
                    }
                }
            }
        }
        while(s == null);
        return s;
    }

    public static boolean d(q1.c c0) {
        String s;
        j j0 = c0.c;
        if(j0 == null) {
            s = "";
        }
        else {
            s = j0.d;
            if(s == null) {
                return (c0.c == null ? -1 : c0.c.a) == -1;
            }
        }
        return s.length() == 0 ? (c0.c == null ? -1 : c0.c.a) == -1 : false;
    }

    @Override  // android.view.ViewGroup
    public final void dispatchDraw(Canvas canvas0) {
        super.dispatchDraw(canvas0);
        if(this.l) {
            ((O0)this.k).setValue(m1.b.c);
            ((O0)this.k).setValue(this.j);
            this.invalidate();
        }
        this.o.invoke();
        if(this.d) {
            Iterable iterable0 = this.e;
            ArrayList arrayList0 = new ArrayList();
            for(Object object0: iterable0) {
                u.U(arrayList0, je.p.A0(e.k.z(((m1.q)object0)), ((m1.q)object0).a()));
            }
            for(Object object1: arrayList0) {
                m1.q q0 = (m1.q)object1;
                if(q0.c.d != 0 && q0.c.c != 0) {
                    canvas0.drawRect(new Rect(q0.c.a, q0.c.b, q0.c.c, q0.c.d), this.w);
                }
            }
        }
    }

    public final void e(AttributeSet attributeSet0) {
        long v1;
        f0.k(this, this.D);
        a.a.M(this, this.D);
        f0.l(this, this.E);
        ComposeView composeView0 = this.b;
        this.addView(composeView0);
        String s = attributeSet0.getAttributeValue("http://schemas.android.com/tools", "composableName");
        if(s == null) {
            return;
        }
        String s1 = o.c1('.', s, s);
        String s2 = o.Y0('.', s, s);
        int v = attributeSet0.getAttributeIntValue("http://schemas.android.com/tools", "parameterProviderIndex", 0);
        String s3 = attributeSet0.getAttributeValue("http://schemas.android.com/tools", "parameterProviderClass");
        Class class0 = s3 == null ? null : e1.u.n(s3);
        try {
            v1 = -1L;
            v1 = Long.parseLong(attributeSet0.getAttributeValue("http://schemas.android.com/tools", "animationClockStartTime"));
        }
        catch(Exception unused_ex) {
        }
        boolean z = attributeSet0.getAttributeBooleanValue("http://schemas.android.com/tools", "forceCompositionInvalidation", false);
        boolean z1 = attributeSet0.getAttributeBooleanValue("http://schemas.android.com/tools", "paintBounds", this.d);
        boolean z2 = attributeSet0.getAttributeBooleanValue("http://schemas.android.com/tools", "printViewInfos", this.c);
        boolean z3 = attributeSet0.getAttributeBooleanValue("http://schemas.android.com/tools", "findDesignInfoProviders", this.m);
        String s4 = attributeSet0.getAttributeValue("http://schemas.android.com/tools", "designInfoProvidersArgument");
        h h0 = h.g;
        h h1 = h.h;
        this.d = z1;
        this.c = z2;
        this.h = s2;
        this.l = z;
        this.m = z3;
        if(s4 == null) {
            s4 = "";
        }
        this.n = s4;
        this.o = h1;
        b b0 = new b(0x8608C70E, new m1.k(h0, this, s1, s2, class0, v, v1), true);
        this.j = b0;
        composeView0.setContent(b0);
        this.invalidate();
    }

    public static m1.q f(q1.c c0) {
        String s;
        q1.d d0 = c0 instanceof q1.d ? ((q1.d)c0) : null;
        Object object0 = d0 == null ? null : d0.h;
        I i0 = object0 instanceof I ? ((I)object0) : null;
        Object object1 = c0.g;
        if(((Collection)object1).size() == 1 && ComposeViewAdapter.d(c0) && i0 == null) {
            return ComposeViewAdapter.f(((q1.c)je.p.D0(((Iterable)object1))));
        }
        ArrayList arrayList0 = new ArrayList();
        for(Object object2: ((Iterable)object1)) {
            q1.c c1 = (q1.c)object2;
            if(ComposeViewAdapter.d(c1) && ((Collection)c1.g).isEmpty()) {
                q1.d d1 = c1 instanceof q1.d ? ((q1.d)c1) : null;
                Object object3 = d1 == null ? null : d1.h;
                if((object3 instanceof I ? ((I)object3) : null) != null) {
                    arrayList0.add(object2);
                }
            }
            else {
                arrayList0.add(object2);
            }
        }
        ArrayList arrayList1 = new ArrayList(je.q.Q(10, arrayList0));
        for(Object object4: arrayList0) {
            arrayList1.add(ComposeViewAdapter.f(((q1.c)object4)));
        }
        j j0 = c0.c;
        if(j0 == null) {
            s = "";
        }
        else {
            s = j0.d;
            if(s == null) {
                return j0 == null ? new m1.q("", -1, c0.e, null, arrayList1, i0) : new m1.q("", j0.a, c0.e, j0, arrayList1, i0);
            }
        }
        return j0 == null ? new m1.q(s, -1, c0.e, null, arrayList1, i0) : new m1.q(s, j0.a, c0.e, j0, arrayList1, i0);
    }

    @NotNull
    public final q getClock$ui_tooling_release() {
        q q0 = this.B;
        if(q0 != null) {
            return q0;
        }
        kotlin.jvm.internal.q.m("clock");
        throw null;
    }

    public static void getClock$ui_tooling_release$annotations() {
    }

    private static void getContent$annotations() {
    }

    @NotNull
    public final List getDesignInfoList$ui_tooling_release() {
        return this.f;
    }

    public final boolean getStitchTrees$ui_tooling_release() {
        return this.r;
    }

    @NotNull
    public final List getViewInfos$ui_tooling_release() {
        return this.e;
    }

    @Override  // android.view.ViewGroup
    public final void onAttachedToWindow() {
        f0.k(this.b.getRootView(), this.D);
        super.onAttachedToWindow();
    }

    @Override  // android.widget.FrameLayout
    public final void onLayout(boolean z, int v, int v1, int v2, int v3) {
        Throwable throwable0;
        super.onLayout(z, v, v1, v2, v3);
        c c0 = this.i;
        synchronized(c0.c) {
            throwable0 = (Throwable)c0.b;
            if(throwable0 == null) {
                ArrayList arrayList0 = new ArrayList(je.q.Q(10, this.g.a));
                for(Object object1: this.g.a) {
                    arrayList0.add(ComposeViewAdapter.f(q1.h.b(((q0.a)object1))));
                }
                List list0 = je.p.P0(arrayList0);
                boolean z1 = true;
                if(this.r && list0.size() >= 2) {
                    ArrayList arrayList1 = new ArrayList(je.q.Q(10, list0));
                    for(Object object2: list0) {
                        arrayList1.add(new m1.o(null, ((m1.q)object2)));
                    }
                    ArrayList arrayList2 = new ArrayList();
                    for(Object object3: arrayList1) {
                        u.T(arrayList2, ((m1.o)object3).d);
                    }
                    ArrayList arrayList3 = new ArrayList(je.q.Q(10, arrayList2));
                    for(Object object4: arrayList2) {
                        Object object5 = ((m1.o)object4).b.f;
                        arrayList3.add(new ie.m((object5 instanceof I ? ((I)object5) : null), ((m1.o)object4)));
                    }
                    ArrayList arrayList4 = new ArrayList();
                    for(Object object6: arrayList3) {
                        if(((ie.m)object6).a != null) {
                            arrayList4.add(object6);
                        }
                    }
                    LinkedHashMap linkedHashMap0 = new LinkedHashMap();
                    for(Object object7: arrayList4) {
                        I i0 = (I)((ie.m)object7).a;
                        ArrayList arrayList5 = linkedHashMap0.get(i0);
                        if(arrayList5 == null) {
                            arrayList5 = new ArrayList();
                            linkedHashMap0.put(i0, arrayList5);
                        }
                        arrayList5.add(object7);
                    }
                    LinkedHashSet linkedHashSet0 = new LinkedHashSet(arrayList1);
                    for(Object object8: arrayList1) {
                        m1.o o0 = (m1.o)object8;
                        androidx.compose.foundation.w w0 = new androidx.compose.foundation.w(linkedHashMap0, 13);
                        kotlin.jvm.internal.q.g(o0.d, "<this>");
                        m1.o o1 = (m1.o)n.i0(n.n0(new Sf.g(new Sf.h(o0.d, w0, Sf.q.b), true, new androidx.compose.foundation.w(o0, 14)), m1.p.g));
                        if(o1 != null) {
                            m1.o o2 = o0.a;
                            if(o2 != null) {
                                ArrayList arrayList6 = o2.c;
                                if(arrayList6 != null) {
                                    arrayList6.remove(o0);
                                }
                            }
                            o1.c.add(o0);
                            o0.a = o1;
                            linkedHashSet0.remove(o0);
                        }
                    }
                    ArrayList arrayList7 = new ArrayList(je.q.Q(10, linkedHashSet0));
                    for(Object object9: linkedHashSet0) {
                        arrayList7.add(((m1.o)object9).b());
                    }
                    list0 = arrayList7;
                }
                this.e = list0;
                if(this.c) {
                    String s = x.N(list0, 0, m1.p.h);
                    Log.d(this.a, s);
                }
                if(this.h.length() > 0) {
                    ArrayList arrayList8 = new ArrayList(je.q.Q(10, this.g.a));
                    for(Object object10: this.g.a) {
                        arrayList8.add(q1.h.b(((q0.a)object10)));
                    }
                    boolean z2 = this.B != null;
                    d0 d00 = new d0(new Q0.n(0, 6, ComposeViewAdapter.class, this, "clock", "getClock$ui_tooling_release()Landroidx/compose/ui/tooling/animation/PreviewAnimationClock;"), new Ic.h(0, this, ComposeViewAdapter.class, "requestLayout", "requestLayout()V", 0, 21));
                    if(!arrayList8.isEmpty()) {
                        for(Object object11: arrayList8) {
                            ArrayList arrayList9 = new ArrayList();
                            ArrayList arrayList10 = e.k.C(new q1.c[]{((q1.c)object11)});
                            while(!arrayList10.isEmpty()) {
                                q1.c c1 = (q1.c)u.Z(arrayList10);
                                arrayList9.add(c1);
                                arrayList10.addAll(((Collection)c1.g));
                            }
                            LinkedHashSet linkedHashSet1 = (LinkedHashSet)d00.g;
                            if(linkedHashSet1 != null && linkedHashSet1.isEmpty()) {
                                continue;
                            }
                            Iterator iterator10 = linkedHashSet1.iterator();
                        label_108:
                            if(!iterator10.hasNext()) {
                                continue;
                            }
                            Object object12 = iterator10.next();
                            i i1 = (i)object12;
                            i1.getClass();
                            if(arrayList9.isEmpty()) {
                                goto label_108;
                            }
                            Iterator iterator11 = arrayList9.iterator();
                            do {
                                if(!iterator11.hasNext()) {
                                    goto label_108;
                                }
                                Object object13 = iterator11.next();
                            }
                            while(!i1.b(((q1.c)object13)));
                            goto label_119;
                        }
                    }
                    z1 = false;
                label_119:
                    if(z2 && z1) {
                        n1.e e0 = (n1.e)d00.d;
                        for(Object object14: arrayList8) {
                            ArrayList arrayList11 = new ArrayList();
                            ArrayList arrayList12 = e.k.C(new q1.c[]{((q1.c)object14)});
                            while(!arrayList12.isEmpty()) {
                                q1.c c2 = (q1.c)u.Z(arrayList12);
                                arrayList11.add(c2);
                                arrayList12.addAll(((Collection)c2.g));
                            }
                            for(Object object15: ((LinkedHashSet)d00.i)) {
                                ((i)object15).a(arrayList11);
                            }
                            e0.b.removeAll(((n1.e)d00.f).b);
                            e0.b.removeAll(((n1.e)d00.e).b);
                        }
                        for(Object object16: ((LinkedHashSet)d00.h)) {
                            Iterable iterable0 = je.p.C0(((i)object16).b);
                            r r0 = ((i)object16).a;
                            for(Object object17: iterable0) {
                                ((we.k)r0).invoke(object17);
                            }
                        }
                    }
                    if(this.m) {
                        ArrayList arrayList13 = new ArrayList(je.q.Q(10, this.g.a));
                        for(Object object18: this.g.a) {
                            arrayList13.add(q1.h.b(((q0.a)object18)));
                        }
                        ArrayList arrayList14 = new ArrayList();
                        for(Object object19: arrayList13) {
                            androidx.compose.foundation.w w1 = new androidx.compose.foundation.w(this, 12);
                            ArrayList arrayList15 = new ArrayList();
                            ArrayList arrayList16 = e.k.C(new q1.c[]{((q1.c)object19)});
                            while(!arrayList16.isEmpty()) {
                                q1.c c3 = (q1.c)u.Z(arrayList16);
                                if(((Boolean)w1.invoke(c3)).booleanValue()) {
                                    arrayList15.add(c3);
                                }
                                arrayList16.addAll(((Collection)c3.g));
                            }
                            ArrayList arrayList17 = new ArrayList();
                            for(Object object20: arrayList15) {
                                q1.c c4 = (q1.c)object20;
                                String s1 = this.c(c4, c4.e);
                                if(s1 == null) {
                                    s1 = null;
                                    for(Object object21: ((Iterable)c4.g)) {
                                        String s2 = this.c(((q1.c)object21), c4.e);
                                        if(s2 != null) {
                                            s1 = s2;
                                            break;
                                        }
                                    }
                                }
                                if(s1 != null) {
                                    arrayList17.add(s1);
                                }
                            }
                            u.U(arrayList14, arrayList17);
                        }
                        this.f = arrayList14;
                    }
                }
                return;
            }
            c0.b = null;
        }
        throw throwable0;
    }

    public final void setClock$ui_tooling_release(@NotNull q q0) {
        this.B = q0;
    }

    public final void setDesignInfoList$ui_tooling_release(@NotNull List list0) {
        this.f = list0;
    }

    public final void setStitchTrees$ui_tooling_release(boolean z) {
        this.r = z;
    }

    public final void setViewInfos$ui_tooling_release(@NotNull List list0) {
        this.e = list0;
    }
}


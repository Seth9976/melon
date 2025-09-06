package pc;

import Ba.G;
import De.w;
import Hf.x;
import Me.L;
import Me.Q;
import Me.k;
import Me.m;
import Pe.C;
import Pe.I;
import Pe.J;
import Pe.S;
import Pe.h;
import Pe.y;
import android.graphics.Bitmap;
import android.os.Build.VERSION;
import android.util.Log;
import android.view.View;
import android.view.autofill.AutofillManager;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.profileinstaller.ProfileInstallReceiver;
import coil.memory.MemoryCache.Key;
import com.google.android.gms.tasks.OnSuccessListener;
import com.iloen.melon.MelonAppBase;
import com.iloen.melon.custom.j;
import com.iloen.melon.net.v4x.request.OutPostingLogReq;
import com.iloen.melon.net.v4x.response.DownloadInformCheckRes;
import com.iloen.melon.net.v4x.response.GiftInformGiftBoxReceiveRes;
import com.iloen.melon.net.v4x.response.GiftInformGiftBoxSendRes;
import com.iloen.melon.net.v4x.response.GiftUseProdGiftRes;
import com.iloen.melon.playback.Playable;
import com.iloen.melon.sns.model.Sharable;
import com.iloen.melon.sns.target.SnsManager.SnsType;
import com.iloen.melon.sns.target.SnsTarget;
import com.iloen.melon.task.ReportService;
import com.iloen.melon.utils.log.LogU;
import com.iloen.melon.utils.ui.ViewUtils;
import d2.n;
import e1.u;
import i.n.i.b.a.s.e.M3;
import ie.H;
import java.io.IOException;
import java.io.Serializable;
import java.io.StringWriter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.Stack;
import java.util.WeakHashMap;
import jg.i;
import kotlin.jvm.internal.q;
import oc.F;
import oc.a;
import okhttp3.ResponseBody;
import qc.n0;
import r5.f;
import sb.d;
import sf.g;
import t7.e;
import t9.A;
import t9.D;
import t9.E;
import t9.K;
import t9.p;
import td.z;
import u3.c;
import va.e0;
import va.o;
import vd.v;
import w4.b;

public final class t implements m, OnSuccessListener, j, com.iloen.melon.custom.t, n, i, a, f, tg.m, c, b {
    public final int a;
    public Object b;

    public t(int v) {
        this.a = v;
        switch(v) {
            case 16: {
                super();
                this.b = new HashMap();
                return;
            }
            case 23: {
                super();
                this.b = new R6.c(9);
                return;
            }
            default: {
                super();
                this.b = new Stack();
            }
        }
    }

    public t(int v, boolean z) {
        this.a = v;
        super();
    }

    public t(Object object0, int v) {
        this.a = v;
        this.b = object0;
        super();
    }

    public Serializable A(String s, oe.c c0) {
        d d0;
        if(c0 instanceof d) {
            d0 = (d)c0;
            int v = d0.B;
            if((v & 0x80000000) == 0) {
                d0 = new d(this, c0);
            }
            else {
                d0.B = v ^ 0x80000000;
            }
        }
        else {
            d0 = new d(this, c0);
        }
        Object object0 = d0.r;
        Serializable serializable0 = ne.a.a;
        switch(d0.B) {
            case 0: {
                d5.n.D(object0);
                try {
                    d0.B = 1;
                    object0 = ((G)((ya.c)this.b).a.a).a(s, u.v(((e0)o.a()).j()), d0);
                    if(object0 == serializable0) {
                        return serializable0;
                    label_18:
                        d5.n.D(object0);
                    }
                    return (GiftUseProdGiftRes)object0;
                }
                catch(Exception unused_ex) {
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
        return null;
    }

    public SnsTarget B(SnsManager.SnsType snsManager$SnsType0) {
        WeakHashMap weakHashMap0 = (WeakHashMap)this.b;
        SnsTarget snsTarget0 = (SnsTarget)weakHashMap0.get(snsManager$SnsType0);
        if(snsTarget0 == null) {
            if(SnsManager.SnsType.a.equals(snsManager$SnsType0)) {
                snsTarget0 = new t9.d();
            }
            else if(SnsManager.SnsType.b.equals(snsManager$SnsType0)) {
                snsTarget0 = new p();  // 初始化器: Ljava/lang/Object;-><init>()V
            }
            else if(SnsManager.SnsType.c.equals(snsManager$SnsType0)) {
                snsTarget0 = new K();
            }
            else if(SnsManager.SnsType.d.equals(snsManager$SnsType0)) {
                snsTarget0 = new D();
            }
            else if(SnsManager.SnsType.e.equals(snsManager$SnsType0)) {
                snsTarget0 = new A();  // 初始化器: Ljava/lang/Object;-><init>()V
            }
            else if(SnsManager.SnsType.f.equals(snsManager$SnsType0)) {
                snsTarget0 = new E(0);
            }
            else if(SnsManager.SnsType.g.equals(snsManager$SnsType0)) {
                snsTarget0 = new E(2);
            }
            else if(SnsManager.SnsType.h.equals(snsManager$SnsType0)) {
                snsTarget0 = new E(1);
            }
            weakHashMap0.put(snsManager$SnsType0, snsTarget0);
        }
        return snsTarget0;
    }

    public boolean C(we.a a0) {
        return ((i)this.b).execute(new E9.t(a0));
    }

    public void D(View view0, int v, boolean z) {
        if(Build.VERSION.SDK_INT >= 27) {
            ((AutofillManager)this.b).notifyViewVisibilityChanged(view0, v, z);
        }
    }

    public static void E(SnsTarget snsTarget0, Sharable sharable0) {
        if(snsTarget0 != null && sharable0 != null) {
            ReportService.sendLogging(new OutPostingLogReq(MelonAppBase.instance.getContext(), snsTarget0, sharable0));
            sharable0.addExtraReport();
            return;
        }
        LogU.w("SnsManager", "sendOutPostingLog() invalid target or sharable");
    }

    public void F(Me.u u0, StringBuilder stringBuilder0) {
        boolean z1;
        g g0 = (g)this.b;
        sf.j j0 = g0.a;
        sf.j j1 = g0.a;
        if(!g0.r()) {
            w[] arr_w = sf.j.Y;
            if(!((Boolean)j1.g.getValue(j1, arr_w[5])).booleanValue()) {
                List list0 = u0.D0();
                q.f(list0, "getContextReceiverParameters(...)");
                g0.C(list0, stringBuilder0);
                g0.y(stringBuilder0, u0, null);
                Me.o o0 = u0.getVisibility();
                q.f(o0, "getVisibility(...)");
                g0.g0(o0, stringBuilder0);
                g0.M(u0, stringBuilder0);
                if(((Boolean)j1.T.getValue(j1, arr_w[44])).booleanValue()) {
                    g0.K(u0, stringBuilder0);
                }
                boolean z = false;
                g0.S(u0, stringBuilder0);
                if(((Boolean)j1.T.getValue(j1, arr_w[44])).booleanValue()) {
                    if(u0.isOperator()) {
                        z1 = true;
                        Collection collection0 = u0.f();
                        q.f(collection0, "getOverriddenDescriptors(...)");
                        if(!collection0.isEmpty()) {
                            for(Object object0: collection0) {
                                if(((Me.u)object0).isOperator()) {
                                    if(((Boolean)j1.O.getValue(j1, sf.j.Y[39])).booleanValue()) {
                                        break;
                                    }
                                    z1 = false;
                                    break;
                                }
                            }
                        }
                    }
                    else {
                        z1 = false;
                    }
                    if(u0.isInfix()) {
                        Collection collection1 = u0.f();
                        q.f(collection1, "getOverriddenDescriptors(...)");
                        if(!collection1.isEmpty()) {
                            for(Object object1: collection1) {
                                if(!((Me.u)object1).isInfix()) {
                                    continue;
                                }
                                if(((Boolean)j1.O.getValue(j1, sf.j.Y[39])).booleanValue()) {
                                    z = true;
                                }
                                goto label_46;
                            }
                        }
                        z = true;
                    }
                label_46:
                    g0.N(stringBuilder0, u0.A(), "tailrec");
                    g0.N(stringBuilder0, u0.isSuspend(), "suspend");
                    g0.N(stringBuilder0, u0.isInline(), "inline");
                    g0.N(stringBuilder0, z, "infix");
                    g0.N(stringBuilder0, z1, "operator");
                }
                else {
                    g0.N(stringBuilder0, u0.isSuspend(), "suspend");
                }
                g0.J(u0, stringBuilder0);
                if(g0.u()) {
                    if(u0.H0()) {
                        stringBuilder0.append("/*isHiddenToOvercomeSignatureClash*/ ");
                    }
                    if(u0.M0()) {
                        stringBuilder0.append("/*isHiddenForResolutionEverywhereBesideSupercalls*/ ");
                    }
                }
            }
            stringBuilder0.append(g0.I("fun"));
            stringBuilder0.append(" ");
            List list1 = u0.getTypeParameters();
            q.f(list1, "getTypeParameters(...)");
            g0.c0(list1, stringBuilder0, true);
            g0.U(u0, stringBuilder0);
        }
        g0.P(u0, stringBuilder0, true);
        List list2 = u0.F();
        q.f(list2, "getValueParameters(...)");
        g0.f0(list2, u0.o0(), stringBuilder0);
        g0.V(u0, stringBuilder0);
        x x0 = u0.getReturnType();
        if(!((Boolean)j0.l.getValue(j0, sf.j.Y[10])).booleanValue() && (((Boolean)j0.k.getValue(j0, sf.j.Y[9])).booleanValue() || x0 == null || !Je.i.E(x0, Je.o.d))) {
            stringBuilder0.append(": ");
            stringBuilder0.append((x0 == null ? "[NULL]" : g0.X(x0)));
        }
        List list3 = u0.getTypeParameters();
        q.f(list3, "getTypeParameters(...)");
        g0.h0(list3, stringBuilder0);
    }

    public void G(Pe.G g0, StringBuilder stringBuilder0, String s) {
        g g1 = (g)this.b;
        switch(((sf.o)g1.a.H.getValue(g1.a, sf.j.Y[0x20])).ordinal()) {
            case 0: {
                g1.K(g0, stringBuilder0);
                stringBuilder0.append(s + " for ");
                L l0 = g0.t1();
                q.f(l0, "getCorrespondingProperty(...)");
                g.n(g1, l0, stringBuilder0);
                return;
            }
            case 1: {
                this.F(g0, stringBuilder0);
                return;
            }
            case 2: {
                return;
            }
            default: {
                throw new M3();  // 初始化器: Ljava/lang/RuntimeException;-><init>()V
            }
        }
    }

    @Override  // r5.f
    public r5.a a(MemoryCache.Key memoryCache$Key0) {
        return null;
    }

    @Override  // r5.f
    public void b(MemoryCache.Key memoryCache$Key0, Bitmap bitmap0, Map map0) {
        ((r5.g)this.b).g(memoryCache$Key0, bitmap0, map0, e1.x.E(bitmap0));
    }

    @Override  // w4.b
    public void c() {
        Log.d("ProfileInstaller", "DIAGNOSTIC_PROFILE_IS_COMPRESSED");
    }

    @Override  // r5.f
    public void clearMemory() {
    }

    @Override  // Me.m
    public Object d(C c0, Object object0) {
        g g0 = (g)this.b;
        g0.getClass();
        ((StringBuilder)object0).append(g0.I("package-fragment"));
        q.g(c0.e.a, "fqName");
        String s = g0.o(u.O(qf.d.e(c0.e.a)));
        if(s.length() > 0) {
            ((StringBuilder)object0).append(" ");
            ((StringBuilder)object0).append(s);
        }
        if(g0.a.n()) {
            ((StringBuilder)object0).append(" in ");
            g0.P(c0.t1(), ((StringBuilder)object0), false);
        }
        return H.a;
    }

    @Override  // Me.m
    public Object e(Me.u u0, Object object0) {
        this.F(u0, ((StringBuilder)object0));
        return H.a;
    }

    @Override  // jg.i
    public boolean execute(Runnable runnable0) {
        return ((i)this.b).execute(runnable0);
    }

    @Override  // w4.b
    public void f(int v, Object object0) {
        String s;
        switch(v) {
            case 1: {
                s = "RESULT_INSTALL_SUCCESS";
                break;
            }
            case 2: {
                s = "RESULT_ALREADY_INSTALLED";
                break;
            }
            case 3: {
                s = "RESULT_UNSUPPORTED_ART_VERSION";
                break;
            }
            case 4: {
                s = "RESULT_NOT_WRITABLE";
                break;
            }
            case 5: {
                s = "RESULT_DESIRED_FORMAT_UNSUPPORTED";
                break;
            }
            case 6: {
                s = "RESULT_BASELINE_PROFILE_NOT_FOUND";
                break;
            }
            case 7: {
                s = "RESULT_IO_EXCEPTION";
                break;
            }
            case 8: {
                s = "RESULT_PARSE_EXCEPTION";
                break;
            }
            case 10: {
                s = "RESULT_INSTALL_SKIP_FILE_SUCCESS";
                break;
            }
            case 11: {
                s = "RESULT_DELETE_SKIP_FILE_SUCCESS";
                break;
            }
            default: {
                s = "";
            }
        }
        if(v == 6 || v == 7 || v == 8) {
            Log.e("ProfileInstaller", s, ((Throwable)object0));
        }
        else {
            Log.d("ProfileInstaller", s);
        }
        ((ProfileInstallReceiver)this.b).setResultCode(v);
    }

    @Override  // Me.m
    public Object g(Pe.K k0, Object object0) {
        this.G(k0, ((StringBuilder)object0), "setter");
        return H.a;
    }

    @Override  // com.iloen.melon.custom.t
    public int getCount() {
        return this.a == 7 ? ((rd.D)this.b).b : ((z)this.b).b;
    }

    @Override  // oc.a
    public Object h(Playable playable0, F f0) {
        return this.a == 0 ? ((Z)this.b).k.b(playable0) : ((n0)this.b).q.b(playable0);
    }

    @Override  // Me.m
    public Object i(S s0, Object object0) {
        ((g)this.b).e0(s0, true, ((StringBuilder)object0), true);
        return H.a;
    }

    @Override  // Me.m
    public Object j(I i0, Object object0) {
        q.g(i0, "descriptor");
        g.n(((g)this.b), i0, ((StringBuilder)object0));
        return H.a;
    }

    public void k(String s, String s1) {
        q.g(s1, "value");
        ((HashMap)this.b).put("${" + s + "}", s1);
    }

    @Override  // tg.m
    public Object l(Object object0) {
        return Optional.ofNullable(((tg.m)this.b).l(((ResponseBody)object0)));
    }

    @Override  // Me.m
    public Object m(Pe.A a0, Object object0) {
        ((g)this.b).P(a0, ((StringBuilder)object0), true);
        return H.a;
    }

    public void n(rf.d d0) {
        if(d0.g()) {
            int[] arr_v = rf.x.h;
            int v = Arrays.binarySearch(arr_v, d0.size());
            if(v < 0) {
                v = -(v + 1) - 1;
            }
            int v1 = arr_v[v + 1];
            Stack stack0 = (Stack)this.b;
            if(!stack0.isEmpty() && ((rf.d)stack0.peek()).size() < v1) {
                int v2 = arr_v[v];
                rf.d d1;
                for(d1 = (rf.d)stack0.pop(); !stack0.isEmpty() && ((rf.d)stack0.peek()).size() < v2; d1 = new rf.x(((rf.d)stack0.pop()), d1)) {
                }
                rf.x x0;
                for(x0 = new rf.x(d1, d0); !stack0.isEmpty(); x0 = new rf.x(((rf.d)stack0.pop()), x0)) {
                    int[] arr_v1 = rf.x.h;
                    int v3 = Arrays.binarySearch(arr_v1, x0.b);
                    if(v3 < 0) {
                        v3 = -(v3 + 1) - 1;
                    }
                    int v4 = arr_v1[v3 + 1];
                    if(((rf.d)stack0.peek()).size() >= v4) {
                        break;
                    }
                }
                stack0.push(x0);
                return;
            }
            stack0.push(d0);
            return;
        }
        if(d0 instanceof rf.x) {
            this.n(((rf.x)d0).c);
            this.n(((rf.x)d0).d);
            return;
        }
        String s = String.valueOf(d0.getClass());
        throw new IllegalArgumentException(U4.x.m(new StringBuilder(s.length() + 49), "Has a new type of ByteString been created? Found ", s));
    }

    public String o(Object object0) {
        StringWriter stringWriter0 = new StringWriter();
        try {
            e e0 = new e(stringWriter0, ((t7.d)this.b).a, ((t7.d)this.b).b, ((t7.d)this.b).c, ((t7.d)this.b).d);
            e0.h(object0);
            e0.j();
            e0.b.flush();
        }
        catch(IOException unused_ex) {
        }
        return stringWriter0.toString();
    }

    @Override  // com.iloen.melon.custom.j
    public void onScrollChanged() {
        v v0 = (v)this.b;
        if(v0.i == null || v0.i.getVisibility() == 0) {
            return;
        }
        ViewUtils.showWhen(v0.i, true);
    }

    @Override  // com.iloen.melon.custom.j
    public void onScrollReachedBottom() {
        ViewUtils.hideWhen(((v)this.b).i, true);
    }

    @Override  // com.google.android.gms.tasks.OnSuccessListener
    public void onSuccess(Object object0) {
        ((ma.b)this.b).invoke(object0);
    }

    public Serializable p(String s, String s1, String s2, String s3, String s4, oe.c c0) {
        sb.a a0;
        if(c0 instanceof sb.a) {
            a0 = (sb.a)c0;
            int v = a0.B;
            if((v & 0x80000000) == 0) {
                a0 = new sb.a(this, c0);
            }
            else {
                a0.B = v ^ 0x80000000;
            }
        }
        else {
            a0 = new sb.a(this, c0);
        }
        Object object0 = a0.r;
        Serializable serializable0 = ne.a.a;
        switch(a0.B) {
            case 0: {
                d5.n.D(object0);
                try {
                    a0.B = 1;
                    object0 = ((G)((ya.c)this.b).a.a).d(s, s1, s2, s3, s4, u.v(((e0)o.a()).j()), a0);
                    if(object0 == serializable0) {
                        return serializable0;
                    label_18:
                        d5.n.D(object0);
                    }
                    return (DownloadInformCheckRes)object0;
                }
                catch(Exception unused_ex) {
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
        return null;
    }

    @Override  // Me.m
    public Object q(Pe.u u0, Object object0) {
        ((StringBuilder)object0).append(u0.getName());
        return H.a;
    }

    public Object r(String s, oe.c c0) {
        sb.b b0;
        if(c0 instanceof sb.b) {
            b0 = (sb.b)c0;
            int v = b0.B;
            if((v & 0x80000000) == 0) {
                b0 = new sb.b(this, c0);
            }
            else {
                b0.B = v ^ 0x80000000;
            }
        }
        else {
            b0 = new sb.b(this, c0);
        }
        Serializable serializable0 = b0.r;
        ne.a a0 = ne.a.a;
        switch(b0.B) {
            case 0: {
                d5.n.D(serializable0);
                try {
                    b0.B = 1;
                    serializable0 = ((ya.c)this.b).a(s, b0);
                    if(serializable0 == a0) {
                        return a0;
                    label_18:
                        d5.n.D(serializable0);
                    }
                    return new Na.e(((GiftInformGiftBoxReceiveRes)serializable0));
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

    @Override  // Me.m
    public Object s(Pe.f f0, Object object0) {
        g g0 = (g)this.b;
        g0.getClass();
        g0.y(((StringBuilder)object0), f0, null);
        q.f(f0.f, "getVisibility(...)");
        g0.g0(f0.f, ((StringBuilder)object0));
        g0.K(f0, ((StringBuilder)object0));
        ((StringBuilder)object0).append(g0.I("typealias"));
        ((StringBuilder)object0).append(" ");
        g0.P(f0, ((StringBuilder)object0), true);
        g0.c0(f0.h(), ((StringBuilder)object0), false);
        g0.A(f0, ((StringBuilder)object0));
        ((StringBuilder)object0).append(" = ");
        ((StringBuilder)object0).append(g0.X(((Ff.v)f0).v1()));
        return H.a;
    }

    @Override  // d2.n
    public boolean t(View view0) {
        DrawerLayout drawerLayout0 = (DrawerLayout)this.b;
        if(DrawerLayout.j(view0) && drawerLayout0.f(view0) != 2) {
            drawerLayout0.b(view0, true);
            return true;
        }
        return false;
    }

    @Override  // jg.i
    public void terminate() {
        ((i)this.b).terminate();
    }

    @Override  // r5.f
    public void trimMemory(int v) {
    }

    @Override  // Me.m
    public Object u(h h0, Object object0) {
        ((g)this.b).a0(h0, ((StringBuilder)object0), true);
        return H.a;
    }

    @Override  // Me.m
    public Object v(Pe.w w0, Object object0) {
        g g0 = (g)this.b;
        g0.getClass();
        ((StringBuilder)object0).append(g0.I("package"));
        q.g(w0.d.a, "fqName");
        String s = g0.o(u.O(qf.d.e(w0.d.a)));
        if(s.length() > 0) {
            ((StringBuilder)object0).append(" ");
            ((StringBuilder)object0).append(s);
        }
        if(g0.a.n()) {
            ((StringBuilder)object0).append(" in context of ");
            g0.P(w0.c, ((StringBuilder)object0), false);
        }
        return H.a;
    }

    @Override  // Me.m
    public Object w(J j0, Object object0) {
        this.G(j0, ((StringBuilder)object0), "getter");
        return H.a;
    }

    @Override  // Me.m
    public Object x(y y0, Object object0) {
        String s;
        StringBuilder stringBuilder0 = (StringBuilder)object0;
        g g0 = (g)this.b;
        sf.j j0 = g0.a;
        boolean z = y0.getKind() == Me.f.d;
        if(!g0.r()) {
            List list0 = y0.f0();
            q.f(list0, "getContextReceivers(...)");
            g0.C(list0, stringBuilder0);
            g0.y(stringBuilder0, y0, null);
            if(!z) {
                Me.o o0 = y0.getVisibility();
                q.f(o0, "getVisibility(...)");
                g0.g0(o0, stringBuilder0);
            }
            if((y0.getKind() != Me.f.b || y0.i() != Me.y.e) && (!y0.getKind().a() || y0.i() != Me.y.b)) {
                Me.y y1 = y0.i();
                q.f(y1, "getModality(...)");
                g0.L(y1, stringBuilder0, g.v(y0));
            }
            g0.K(y0, stringBuilder0);
            g0.N(stringBuilder0, g0.q().contains(sf.h.h) && y0.x(), "inner");
            g0.N(stringBuilder0, g0.q().contains(sf.h.j) && y0.O0(), "data");
            g0.N(stringBuilder0, g0.q().contains(sf.h.k) && y0.isInline(), "inline");
            g0.N(stringBuilder0, g0.q().contains(sf.h.w) && y0.j(), "value");
            g0.N(stringBuilder0, g0.q().contains(sf.h.r) && y0.l0(), "fun");
            if(y0 instanceof Q) {
                s = "typealias";
            }
            else if(y0.g0()) {
                s = "companion object";
            }
            else {
                switch(y0.getKind().ordinal()) {
                    case 0: {
                        s = "class";
                        break;
                    }
                    case 1: {
                        s = "interface";
                        break;
                    }
                    case 2: {
                        s = "enum class";
                        break;
                    }
                    case 3: {
                        s = "enum entry";
                        break;
                    }
                    case 4: {
                        s = "annotation class";
                        break;
                    }
                    case 5: {
                        s = "object";
                        break;
                    }
                    default: {
                        throw new M3();  // 初始化器: Ljava/lang/RuntimeException;-><init>()V
                    }
                }
            }
            stringBuilder0.append(g0.I(s));
        }
        if(tf.e.l(y0)) {
            if(((Boolean)j0.G.getValue(j0, sf.j.Y[0x1F])).booleanValue()) {
                if(g0.r()) {
                    stringBuilder0.append("companion object");
                }
                g.W(stringBuilder0);
                k k0 = y0.e();
                if(k0 != null) {
                    stringBuilder0.append("of ");
                    qf.e e0 = k0.getName();
                    q.f(e0, "getName(...)");
                    stringBuilder0.append(g0.O(e0, false));
                }
            }
            if(g0.u() || !q.b(y0.getName(), qf.g.b)) {
                if(!g0.r()) {
                    g.W(stringBuilder0);
                }
                qf.e e1 = y0.getName();
                q.f(e1, "getName(...)");
                stringBuilder0.append(g0.O(e1, true));
            }
        }
        else {
            if(!g0.r()) {
                g.W(stringBuilder0);
            }
            g0.P(y0, stringBuilder0, true);
        }
        if(!z) {
            List list1 = y0.h();
            q.f(list1, "getDeclaredTypeParameters(...)");
            g0.c0(list1, stringBuilder0, false);
            g0.A(y0, stringBuilder0);
            if(!y0.getKind().a() && ((Boolean)j0.i.getValue(j0, sf.j.Y[7])).booleanValue()) {
                Pe.i i0 = y0.B();
                if(i0 != null) {
                    stringBuilder0.append(" ");
                    g0.y(stringBuilder0, i0, null);
                    Me.o o1 = i0.getVisibility();
                    q.f(o1, "getVisibility(...)");
                    g0.g0(o1, stringBuilder0);
                    stringBuilder0.append(g0.I("constructor"));
                    List list2 = i0.F();
                    q.f(list2, "getValueParameters(...)");
                    g0.f0(list2, i0.o0(), stringBuilder0);
                }
            }
            if(!((Boolean)j0.x.getValue(j0, sf.j.Y[22])).booleanValue() && !Je.i.F(y0.g())) {
                Collection collection0 = y0.q().f();
                q.f(collection0, "getSupertypes(...)");
                if(!collection0.isEmpty()) {
                    if(collection0.size() == 1) {
                        Object object1 = collection0.iterator().next();
                        if(!Je.i.y(((x)object1))) {
                            goto label_88;
                        }
                    }
                    else {
                    label_88:
                        g.W(stringBuilder0);
                        stringBuilder0.append(": ");
                        je.p.p0(collection0, stringBuilder0, ", ", null, null, new sf.f(g0, 1), 60);
                    }
                }
            }
            g0.h0(list1, stringBuilder0);
        }
        return H.a;
    }

    @Override  // Me.m
    public Object y(Pe.i i0, Object object0) {
        boolean z1;
        boolean z = i0.Y;
        g g0 = (g)this.b;
        g0.getClass();
        g0.y(((StringBuilder)object0), i0, null);
        sf.j j0 = g0.a;
        w[] arr_w = sf.j.Y;
        if(!((Boolean)j0.o.getValue(j0, arr_w[13])).booleanValue() && i0.i0().i() == Me.y.c) {
            z1 = false;
        }
        else {
            Me.o o0 = i0.getVisibility();
            q.f(o0, "getVisibility(...)");
            z1 = g0.g0(o0, ((StringBuilder)object0));
        }
        g0.J(i0, ((StringBuilder)object0));
        boolean z2 = ((Boolean)j0.P.getValue(j0, arr_w[40])).booleanValue() || !z || z1;
        if(z2) {
            ((StringBuilder)object0).append(g0.I("constructor"));
        }
        Me.e e0 = i0.F1();
        q.f(e0, "getContainingDeclaration(...)");
        if(((Boolean)j0.A.getValue(j0, arr_w[25])).booleanValue()) {
            if(z2) {
                ((StringBuilder)object0).append(" ");
            }
            g0.P(e0, ((StringBuilder)object0), true);
            g0.c0(i0.getTypeParameters(), ((StringBuilder)object0), false);
        }
        List list0 = i0.F();
        q.f(list0, "getValueParameters(...)");
        g0.f0(list0, i0.o0(), ((StringBuilder)object0));
        if(((Boolean)j0.q.getValue(j0, arr_w[15])).booleanValue() && !z) {
            Pe.i i1 = e0.B();
            if(i1 != null) {
                List list1 = i1.F();
                q.f(list1, "getValueParameters(...)");
                ArrayList arrayList0 = new ArrayList();
                for(Object object1: list1) {
                    if(!((S)object1).u1() && ((S)object1).j == null) {
                        arrayList0.add(object1);
                    }
                }
                if(!arrayList0.isEmpty()) {
                    ((StringBuilder)object0).append(" : ");
                    ((StringBuilder)object0).append(g0.I("this"));
                    ((StringBuilder)object0).append(je.p.q0(arrayList0, ", ", "(", ")", sf.d.n, 24));
                }
            }
        }
        if(((Boolean)j0.A.getValue(j0, sf.j.Y[25])).booleanValue()) {
            g0.h0(i0.getTypeParameters(), ((StringBuilder)object0));
        }
        return H.a;
    }

    public Object z(String s, oe.c c0) {
        sb.c c1;
        if(c0 instanceof sb.c) {
            c1 = (sb.c)c0;
            int v = c1.B;
            if((v & 0x80000000) == 0) {
                c1 = new sb.c(this, c0);
            }
            else {
                c1.B = v ^ 0x80000000;
            }
        }
        else {
            c1 = new sb.c(this, c0);
        }
        Serializable serializable0 = c1.r;
        ne.a a0 = ne.a.a;
        switch(c1.B) {
            case 0: {
                d5.n.D(serializable0);
                try {
                    c1.B = 1;
                    serializable0 = ((ya.c)this.b).b(s, c1);
                    if(serializable0 == a0) {
                        return a0;
                    label_18:
                        d5.n.D(serializable0);
                    }
                    return new Na.e(((GiftInformGiftBoxSendRes)serializable0));
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
}


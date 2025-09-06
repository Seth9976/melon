package x9;

import Df.c;
import Df.s;
import E9.w;
import Hf.x;
import M6.B;
import Me.z;
import Nb.i;
import U4.F;
import android.content.ComponentName;
import android.content.Context;
import android.content.pm.PackageManager.NameNotFoundException;
import android.content.pm.PackageManager;
import android.content.pm.ServiceInfo;
import android.os.Bundle;
import android.util.Log;
import com.google.android.datatransport.cct.CctBackendFactory;
import com.google.android.datatransport.runtime.backends.TransportBackendDiscovery;
import com.google.firebase.messaging.u;
import com.google.gson.E;
import com.google.gson.r;
import com.iloen.melon.net.v4x.response.InformArtistRes;
import com.iloen.melon.net.v6x.response.FeedLogsNewsCountRes;
import com.iloen.melon.net.v6x.response.PowerDjListRes;
import com.iloen.melon.userstore.VolatileDatabase_Impl;
import com.iloen.melon.userstore.entity.TabMenuShortcutEntity;
import com.iloen.melon.utils.log.LogU;
import com.kakao.emoticon.interfaces.EmoticonClickListener;
import com.kakao.emoticon.model.EmoticonViewParam;
import com.kakao.emoticon.ui.PopupEmoticonFragment;
import com.melon.net.res.InfoCommerceAndBtnVer6Res;
import com.melon.net.res.MainMenuTabBannerRes;
import com.melon.net.res.NavigationMenuBenefitRes;
import com.melon.net.res.NavigationMenuListRes;
import fb.d;
import fb.j;
import fb.n;
import fb.o;
import i.n.i.b.a.s.e.g9;
import java.io.ByteArrayOutputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.Serializable;
import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import k8.Y;
import kc.d3;
import kc.s2;
import kotlin.jvm.internal.q;
import kotlinx.coroutines.guava.ListenableFutureKt;
import lf.A;
import lf.I;
import lf.b0;
import lf.e;
import lf.h;
import lf.v;
import m9.l;
import nf.f;
import oa.k;
import oc.T;
import oc.U;
import okhttp3.ResponseBody;
import sd.g;
import tg.m;
import va.e0;

public final class a implements Df.a, c, EmoticonClickListener, m {
    public Object a;
    public Object b;

    public a() {
        ByteArrayOutputStream byteArrayOutputStream0 = new ByteArrayOutputStream(0x200);
        this.a = byteArrayOutputStream0;
        this.b = new DataOutputStream(byteArrayOutputStream0);
    }

    public a(z z0, u u0, Cf.a a0) {
        q.g(z0, "module");
        q.g(a0, "protocol");
        super();
        this.a = a0;
        this.b = new b(z0, u0);
    }

    public a(Object object0, Object object1) {
        this.a = object0;
        this.b = object1;
        super();
    }

    public Object A(String s, oe.c c0) {
        n n0;
        if(c0 instanceof n) {
            n0 = (n)c0;
            int v = n0.B;
            if((v & 0x80000000) == 0) {
                n0 = new n(this, c0);
            }
            else {
                n0.B = v ^ 0x80000000;
            }
        }
        else {
            n0 = new n(this, c0);
        }
        Integer integer0 = n0.r;
        ne.a a0 = ne.a.a;
        int v1 = 0;
        switch(n0.B) {
            case 0: {
                d5.n.D(integer0);
                try {
                    n0.B = 1;
                    b b0 = (b)((k)this.a).a.b;
                    integer0 = new Integer((b0 == null ? 0 : ((int)(((Integer)w.N(((VolatileDatabase_Impl)b0.a), true, false, new g(s, 17)))))));
                    if(integer0 == a0) {
                        return a0;
                    label_20:
                        d5.n.D(integer0);
                    }
                    v1 = integer0.intValue();
                }
                catch(Exception unused_ex) {
                }
                break;
            }
            case 1: {
                goto label_20;
            }
            default: {
                throw new IllegalStateException("call to \'resume\' before \'invoke\' with coroutine");
            }
        }
        return new Integer(v1);
    }

    public Object B(TabMenuShortcutEntity tabMenuShortcutEntity0, oe.c c0) {
        long v2;
        o o0;
        if(c0 instanceof o) {
            o0 = (o)c0;
            int v = o0.B;
            if((v & 0x80000000) == 0) {
                o0 = new o(this, c0);
            }
            else {
                o0.B = v ^ 0x80000000;
            }
        }
        else {
            o0 = new o(this, c0);
        }
        Long long0 = o0.r;
        ne.a a0 = ne.a.a;
        long v1 = -1L;
        switch(o0.B) {
            case 0: {
                d5.n.D(long0);
                try {
                    o0.B = 1;
                    b b0 = (b)((k)this.a).a.b;
                    if(b0 == null) {
                        v2 = -1L;
                    }
                    else {
                        tabMenuShortcutEntity0.getClass();
                        v2 = (long)(((Long)w.N(((VolatileDatabase_Impl)b0.a), false, true, new l(26, b0, tabMenuShortcutEntity0))));
                    }
                    Long long1 = new Long(v2);
                    if(long1 == a0) {
                        return a0;
                    }
                    long0 = long1;
                    v1 = long0.longValue();
                    break;
                label_27:
                    d5.n.D(long0);
                    v1 = long0.longValue();
                }
                catch(Exception unused_ex) {
                }
                break;
            }
            case 1: {
                goto label_27;
            }
            default: {
                throw new IllegalStateException("call to \'resume\' before \'invoke\' with coroutine");
            }
        }
        return new Long(v1);
    }

    public Object C(String s, oe.c c0) {
        int v1;
        pb.m m0;
        s2 s20 = (s2)this.a;
        if(c0 instanceof pb.m) {
            m0 = (pb.m)c0;
            int v = m0.D;
            if((v & 0x80000000) == 0) {
                m0 = new pb.m(this, c0);
            }
            else {
                m0.D = v ^ 0x80000000;
            }
        }
        else {
            m0 = new pb.m(this, c0);
        }
        Object object0 = m0.w;
        ne.a a0 = ne.a.a;
        switch(m0.D) {
            case 0: {
                d5.n.D(object0);
                oc.w w0 = ((d3)s20).k();
                v1 = 0;
                if(w0 != null) {
                    String s1 = F.Y(s).a;
                    Iterator iterator0 = e1.b.B(w0.getState()).iterator();
                    while(true) {
                        if(!iterator0.hasNext()) {
                            v1 = -1;
                            break;
                        }
                        iterator0.next();
                        if(q.b("", s1)) {
                            break;
                        }
                        ++v1;
                    }
                    B b0 = ((d3)s20).w(w0.getId(), e.k.z(new Integer(v1)));
                    m0.r = s;
                    m0.D = 1;
                    object0 = ListenableFutureKt.await(b0, m0);
                    if(object0 == a0) {
                        return a0;
                    }
                    v1 = ((U)object0) instanceof T;
                }
                break;
            }
            case 1: {
                s = m0.r;
                d5.n.D(object0);
                v1 = ((U)object0) instanceof T;
                break;
            }
            default: {
                throw new IllegalStateException("call to \'resume\' before \'invoke\' with coroutine");
            }
        }
        Boolean boolean0 = Boolean.valueOf(((boolean)v1));
        if(v1) {
            LogU.debug$default(((LogU)this.b), "success: " + s, null, false, 6, null);
            return boolean0;
        }
        LogU.error$default(((LogU)this.b), "failed: " + s, null, false, 6, null);
        return boolean0;
    }

    public Ne.c D(h h0, f f0) {
        q.g(h0, "proto");
        q.g(f0, "nameResolver");
        return ((b)this.b).j(h0, f0);
    }

    @Override  // Df.c
    public List a(Df.u u0, v v0) {
        q.g(u0, "container");
        List list0 = (List)v0.i(((Cf.a)this.a).h);
        if(list0 == null) {
            list0 = je.w.a;
        }
        List list1 = new ArrayList(je.q.Q(10, list0));
        for(Object object0: list0) {
            ((ArrayList)list1).add(this.D(((h)object0), ((f)u0.b)));
        }
        return list1;
    }

    @Override  // Df.c
    public List b(Df.u u0, rf.a a0, int v, int v1, b0 b00) {
        q.g(a0, "callableProto");
        Y.r(v, "kind");
        List list0 = (List)b00.i(((Cf.a)this.a).j);
        if(list0 == null) {
            list0 = je.w.a;
        }
        List list1 = new ArrayList(je.q.Q(10, list0));
        for(Object object0: list0) {
            ((ArrayList)list1).add(this.D(((h)object0), ((f)u0.b)));
        }
        return list1;
    }

    @Override  // Df.c
    public ArrayList c(lf.T t0, f f0) {
        q.g(t0, "proto");
        q.g(f0, "nameResolver");
        List list0 = (List)t0.i(((Cf.a)this.a).k);
        if(list0 == null) {
            list0 = je.w.a;
        }
        ArrayList arrayList0 = new ArrayList(je.q.Q(10, list0));
        for(Object object0: list0) {
            arrayList0.add(this.D(((h)object0), f0));
        }
        return arrayList0;
    }

    @Override  // Df.c
    public List d(Df.u u0, rf.a a0, int v) {
        List list0;
        Cf.a a1 = (Cf.a)this.a;
        q.g(a0, "proto");
        Y.r(v, "kind");
        if(a0 instanceof lf.n) {
            list0 = (List)((lf.n)a0).i(a1.b);
        }
        else if(a0 instanceof A) {
            list0 = (List)((A)a0).i(a1.d);
        }
        else if(a0 instanceof I) {
            switch(e0.b.b(v)) {
                case 1: {
                    list0 = (List)((I)a0).i(a1.e);
                    break;
                }
                case 2: {
                    list0 = (List)((I)a0).i(a1.f);
                    break;
                }
                case 3: {
                    list0 = (List)((I)a0).i(a1.g);
                    break;
                }
                default: {
                    throw new IllegalStateException("Unsupported callable kind with property proto");
                }
            }
        }
        else {
            throw new IllegalStateException(("Unknown message: " + a0).toString());
        }
        if(list0 == null) {
            list0 = je.w.a;
        }
        List list1 = new ArrayList(je.q.Q(10, list0));
        for(Object object0: list0) {
            ((ArrayList)list1).add(this.D(((h)object0), ((f)u0.b)));
        }
        return list1;
    }

    @Override  // Df.c
    public List e(Df.u u0, I i0) {
        q.g(i0, "proto");
        ((Cf.a)this.a).getClass();
        List list0 = new ArrayList(je.q.Q(10, je.w.a));
        for(Object object0: je.w.a) {
            ((ArrayList)list0).add(this.D(((h)object0), ((f)u0.b)));
        }
        return list0;
    }

    @Override  // Df.c
    public List f(Df.u u0, I i0) {
        q.g(i0, "proto");
        ((Cf.a)this.a).getClass();
        List list0 = new ArrayList(je.q.Q(10, je.w.a));
        for(Object object0: je.w.a) {
            ((ArrayList)list0).add(this.D(((h)object0), ((f)u0.b)));
        }
        return list0;
    }

    @Override  // Df.c
    public List g(Df.u u0, rf.a a0, int v) {
        String s;
        Cf.a a1 = (Cf.a)this.a;
        q.g(a0, "proto");
        Y.r(v, "kind");
        if(a0 instanceof A) {
            a1.getClass();
        }
        else if(a0 instanceof I) {
            switch(e0.b.b(v)) {
                case 1: 
                case 2: 
                case 3: {
                    a1.getClass();
                    break;
                }
                default: {
                    switch(v) {
                        case 1: {
                            s = "FUNCTION";
                            break;
                        }
                        case 2: {
                            s = "PROPERTY";
                            break;
                        }
                        case 3: {
                            s = "PROPERTY_GETTER";
                            break;
                        }
                        case 4: {
                            s = "PROPERTY_SETTER";
                            break;
                        }
                        default: {
                            s = "null";
                        }
                    }
                    throw new IllegalStateException(("Unsupported callable kind with property proto for receiver annotations: " + s).toString());
                }
            }
        }
        else {
            throw new IllegalStateException(("Unknown message: " + a0).toString());
        }
        List list0 = new ArrayList(je.q.Q(10, je.w.a));
        for(Object object0: je.w.a) {
            ((ArrayList)list0).add(this.D(((h)object0), ((f)u0.b)));
        }
        return list0;
    }

    @Override  // Df.c
    public ArrayList h(lf.Y y0, f f0) {
        q.g(y0, "proto");
        q.g(f0, "nameResolver");
        List list0 = (List)y0.i(((Cf.a)this.a).l);
        if(list0 == null) {
            list0 = je.w.a;
        }
        ArrayList arrayList0 = new ArrayList(je.q.Q(10, list0));
        for(Object object0: list0) {
            arrayList0.add(this.D(((h)object0), f0));
        }
        return arrayList0;
    }

    @Override  // Df.a
    public Object i(Df.u u0, I i0, x x0) {
        q.g(i0, "proto");
        e e0 = (e)e1.x.G(i0, ((Cf.a)this.a).i);
        return e0 == null ? null : ((b)this.b).u(x0, e0, ((f)u0.b));
    }

    @Override  // Df.c
    public ArrayList j(s s0) {
        q.g(s0, "container");
        List list0 = (List)s0.e.i(((Cf.a)this.a).c);
        if(list0 == null) {
            list0 = je.w.a;
        }
        ArrayList arrayList0 = new ArrayList(je.q.Q(10, list0));
        for(Object object0: list0) {
            arrayList0.add(this.D(((h)object0), ((f)s0.b)));
        }
        return arrayList0;
    }

    @Override  // Df.a
    public Object k(Df.u u0, I i0, x x0) {
        q.g(i0, "proto");
        return null;
    }

    @Override  // tg.m
    public Object l(Object object0) {
        com.google.gson.n n0 = (com.google.gson.n)this.a;
        W7.a a0 = new W7.a(((ResponseBody)object0).charStream());
        a0.c0((n0.l == 0 ? 2 : n0.l));
        try {
            Object object1 = ((E)this.b).b(a0);
            if(a0.Z() == 10) {
                return object1;
            }
        }
        finally {
            ((ResponseBody)object0).close();
        }
        throw new r("JSON document was not fully consumed.");  // 初始化器: Ljava/lang/RuntimeException;-><init>(Ljava/lang/String;)V
    }

    public static void m(DataOutputStream dataOutputStream0, long v) {
        dataOutputStream0.writeByte(((int)(v >>> 24)) & 0xFF);
        dataOutputStream0.writeByte(((int)(v >>> 16)) & 0xFF);
        dataOutputStream0.writeByte(((int)(v >>> 8)) & 0xFF);
        dataOutputStream0.writeByte(((int)v) & 0xFF);
    }

    public byte[] n(g9 g90) {
        DataOutputStream dataOutputStream0 = (DataOutputStream)this.b;
        ByteArrayOutputStream byteArrayOutputStream0 = (ByteArrayOutputStream)this.a;
        byteArrayOutputStream0.reset();
        try {
            dataOutputStream0.writeBytes(g90.a);
            dataOutputStream0.writeByte(0);
            dataOutputStream0.writeBytes((g90.b == null ? "" : g90.b));
            dataOutputStream0.writeByte(0);
            a.m(dataOutputStream0, g90.c);
            a.m(dataOutputStream0, g90.d);
            dataOutputStream0.write(g90.e);
            dataOutputStream0.flush();
            return byteArrayOutputStream0.toByteArray();
        }
        catch(IOException iOException0) {
            throw new RuntimeException(iOException0);
        }
    }

    public Object o(String s, oe.c c0) {
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
        Integer integer0 = d0.r;
        ne.a a0 = ne.a.a;
        int v1 = -1;
        switch(d0.B) {
            case 0: {
                d5.n.D(integer0);
                try {
                    d0.B = 1;
                    b b0 = (b)((k)this.a).a.b;
                    integer0 = new Integer((b0 == null ? -1 : ((int)(((Integer)w.N(((VolatileDatabase_Impl)b0.a), false, true, new g(s, 18)))))));
                    if(integer0 == a0) {
                        return a0;
                    label_20:
                        d5.n.D(integer0);
                    }
                    v1 = integer0.intValue();
                }
                catch(Exception unused_ex) {
                }
                break;
            }
            case 1: {
                goto label_20;
            }
            default: {
                throw new IllegalStateException("call to \'resume\' before \'invoke\' with coroutine");
            }
        }
        return new Integer(v1);
    }

    @Override  // com.kakao.emoticon.interfaces.EmoticonClickListener
    public void onEmoticonClick(EmoticonViewParam emoticonViewParam0) {
        ((EmoticonClickListener)this.a).onEmoticonClick(emoticonViewParam0);
        PopupEmoticonFragment popupEmoticonFragment0 = ((b9.d)this.b).f;
        if(popupEmoticonFragment0 != null) {
            popupEmoticonFragment0.dismiss();
        }
    }

    @Override  // com.kakao.emoticon.interfaces.EmoticonClickListener
    public void onEmoticonDoubleClick(EmoticonViewParam emoticonViewParam0) {
        ((EmoticonClickListener)this.a).onEmoticonDoubleClick(emoticonViewParam0);
    }

    public Object p(String s, String s1, oe.c c0) {
        fb.e e0;
        if(c0 instanceof fb.e) {
            e0 = (fb.e)c0;
            int v = e0.B;
            if((v & 0x80000000) == 0) {
                e0 = new fb.e(this, c0);
            }
            else {
                e0.B = v ^ 0x80000000;
            }
        }
        else {
            e0 = new fb.e(this, c0);
        }
        Integer integer0 = e0.r;
        ne.a a0 = ne.a.a;
        int v1 = -1;
        switch(e0.B) {
            case 0: {
                d5.n.D(integer0);
                try {
                    e0.B = 1;
                    b b0 = (b)((k)this.a).a.b;
                    integer0 = new Integer((b0 == null ? -1 : ((int)(((Integer)w.N(((VolatileDatabase_Impl)b0.a), false, true, new i(s, s1, 14)))))));
                    if(integer0 == a0) {
                        return a0;
                    label_20:
                        d5.n.D(integer0);
                    }
                    v1 = integer0.intValue();
                }
                catch(Exception unused_ex) {
                }
                break;
            }
            case 1: {
                goto label_20;
            }
            default: {
                throw new IllegalStateException("call to \'resume\' before \'invoke\' with coroutine");
            }
        }
        return new Integer(v1);
    }

    public Object q(ArrayList arrayList0, String s, oe.c c0) {
        fb.f f0;
        if(c0 instanceof fb.f) {
            f0 = (fb.f)c0;
            int v = f0.B;
            if((v & 0x80000000) == 0) {
                f0 = new fb.f(this, c0);
            }
            else {
                f0.B = v ^ 0x80000000;
            }
        }
        else {
            f0 = new fb.f(this, c0);
        }
        Integer integer0 = f0.r;
        ne.a a0 = ne.a.a;
        switch(f0.B) {
            case 0: {
                d5.n.D(integer0);
                try {
                    f0.B = 1;
                    integer0 = ((k)this.a).a(s, arrayList0);
                    if(integer0 == a0) {
                        return a0;
                    label_18:
                        d5.n.D(integer0);
                    }
                    return new Integer(integer0.intValue());
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
        return new Integer(-1);
    }

    public CctBackendFactory r(String s) {
        Map map0;
        Bundle bundle0;
        if(((Map)this.b) == null) {
            Context context0 = (Context)this.a;
            try {
                PackageManager packageManager0 = context0.getPackageManager();
                if(packageManager0 == null) {
                    Log.w("BackendRegistry", "Context has no PackageManager.");
                    goto label_13;
                }
                else {
                    ServiceInfo serviceInfo0 = packageManager0.getServiceInfo(new ComponentName(context0, TransportBackendDiscovery.class), 0x80);
                    if(serviceInfo0 == null) {
                        Log.w("BackendRegistry", "TransportBackendDiscovery has no service info.");
                        goto label_13;
                    }
                    else {
                        bundle0 = serviceInfo0.metaData;
                    }
                }
                goto label_14;
            }
            catch(PackageManager.NameNotFoundException unused_ex) {
            label_12:
                Log.w("BackendRegistry", "Application info not found.");
            }
            try {
            label_13:
                bundle0 = null;
            }
            catch(PackageManager.NameNotFoundException unused_ex) {
                goto label_12;
            }
        label_14:
            if(bundle0 == null) {
                Log.w("BackendRegistry", "Could not retrieve metadata, returning empty list of transport backends.");
                map0 = Collections.EMPTY_MAP;
            }
            else {
                HashMap hashMap0 = new HashMap();
                for(Object object0: bundle0.keySet()) {
                    String s1 = (String)object0;
                    Object object1 = bundle0.get(s1);
                    if(object1 instanceof String && s1.startsWith("backend:")) {
                        String[] arr_s = ((String)object1).split(",", -1);
                        for(int v = 0; v < arr_s.length; ++v) {
                            String s2 = arr_s[v].trim();
                            if(!s2.isEmpty()) {
                                hashMap0.put(s2, s1.substring(8));
                            }
                        }
                    }
                }
                map0 = hashMap0;
            }
            this.b = map0;
        }
        String s3 = (String)((Map)this.b).get(s);
        if(s3 == null) {
            return null;
        }
        try {
            return (CctBackendFactory)Class.forName(s3).asSubclass(CctBackendFactory.class).getDeclaredConstructor(null).newInstance(null);
        }
        catch(ClassNotFoundException classNotFoundException0) {
            Log.w("BackendRegistry", "Class " + s3 + " is not found.", classNotFoundException0);
            return null;
        }
        catch(IllegalAccessException illegalAccessException0) {
            Log.w("BackendRegistry", "Could not instantiate " + s3 + ".", illegalAccessException0);
            return null;
        }
        catch(InstantiationException instantiationException0) {
            Log.w("BackendRegistry", "Could not instantiate " + s3 + ".", instantiationException0);
            return null;
        }
        catch(NoSuchMethodException noSuchMethodException0) {
            Log.w("BackendRegistry", "Could not instantiate " + s3, noSuchMethodException0);
            return null;
        }
        catch(InvocationTargetException invocationTargetException0) {
            Log.w("BackendRegistry", "Could not instantiate " + s3, invocationTargetException0);
            return null;
        }
    }

    public Object s(oe.c c0) {
        fb.g g0;
        if(c0 instanceof fb.g) {
            g0 = (fb.g)c0;
            int v = g0.B;
            if((v & 0x80000000) == 0) {
                g0 = new fb.g(this, c0);
            }
            else {
                g0.B = v ^ 0x80000000;
            }
        }
        else {
            g0 = new fb.g(this, c0);
        }
        Serializable serializable0 = g0.r;
        ne.a a0 = ne.a.a;
        switch(g0.B) {
            case 0: {
                d5.n.D(serializable0);
                try {
                    g0.B = 1;
                    serializable0 = ((k)this.a).b(g0);
                    if(serializable0 == a0) {
                        return a0;
                    label_18:
                        d5.n.D(serializable0);
                    }
                    return E9.h.H(new Na.e(((FeedLogsNewsCountRes)serializable0)));
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
        return E9.h.H(new Na.d(exception0));
    }

    public Object t(oe.c c0) {
        fb.h h0;
        if(c0 instanceof fb.h) {
            h0 = (fb.h)c0;
            int v = h0.B;
            if((v & 0x80000000) == 0) {
                h0 = new fb.h(this, c0);
            }
            else {
                h0.B = v ^ 0x80000000;
            }
        }
        else {
            h0 = new fb.h(this, c0);
        }
        Object object0 = h0.r;
        ne.a a0 = ne.a.a;
        switch(h0.B) {
            case 0: {
                d5.n.D(object0);
                try {
                    h0.B = 1;
                    object0 = ((k)this.a).c(h0);
                    if(object0 == a0) {
                        return a0;
                    label_18:
                        d5.n.D(object0);
                    }
                    return E9.h.H(new Na.e(((InfoCommerceAndBtnVer6Res)object0)));
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
        return E9.h.H(new Na.d(exception0));
    }

    public Object u(String s, oe.c c0) {
        fb.i i0;
        if(c0 instanceof fb.i) {
            i0 = (fb.i)c0;
            int v = i0.B;
            if((v & 0x80000000) == 0) {
                i0 = new fb.i(this, c0);
            }
            else {
                i0.B = v ^ 0x80000000;
            }
        }
        else {
            i0 = new fb.i(this, c0);
        }
        Serializable serializable0 = i0.r;
        ne.a a0 = ne.a.a;
        switch(i0.B) {
            case 0: {
                d5.n.D(serializable0);
                try {
                    i0.B = 1;
                    serializable0 = ((k)this.a).d(s, i0);
                    if(serializable0 == a0) {
                        return a0;
                    label_18:
                        d5.n.D(serializable0);
                    }
                    return E9.h.H(new Na.e(((InformArtistRes)serializable0)));
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
        return E9.h.H(new Na.d(exception0));
    }

    public Serializable v(oe.c c0) {
        Serializable serializable1;
        j j0;
        if(c0 instanceof j) {
            j0 = (j)c0;
            int v = j0.B;
            if((v & 0x80000000) == 0) {
                j0 = new j(this, c0);
            }
            else {
                j0.B = v ^ 0x80000000;
            }
        }
        else {
            j0 = new j(this, c0);
        }
        Object object0 = j0.r;
        Serializable serializable0 = ne.a.a;
        switch(j0.B) {
            case 0: {
                d5.n.D(object0);
                try {
                    j0.B = 1;
                    object0 = ((Ba.c)((Ua.h)((Ua.h)this.b).a).a).a(e1.u.w(((e0)va.o.a()).j()), j0);
                    if(object0 == serializable0) {
                        return serializable0;
                    label_18:
                        d5.n.D(object0);
                    }
                    serializable1 = (MainMenuTabBannerRes)object0;
                    return serializable1 instanceof ie.o ? null : serializable1;
                }
                catch(Throwable throwable0) {
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
        serializable1 = d5.n.t(throwable0);
        return serializable1 instanceof ie.o ? null : serializable1;
    }

    public Object w(String s, oe.c c0) {
        fb.k k0;
        if(c0 instanceof fb.k) {
            k0 = (fb.k)c0;
            int v = k0.B;
            if((v & 0x80000000) == 0) {
                k0 = new fb.k(this, c0);
            }
            else {
                k0.B = v ^ 0x80000000;
            }
        }
        else {
            k0 = new fb.k(this, c0);
        }
        Serializable serializable0 = k0.r;
        ne.a a0 = ne.a.a;
        switch(k0.B) {
            case 0: {
                d5.n.D(serializable0);
                try {
                    k0.B = 1;
                    serializable0 = ((k)this.a).e(s, k0);
                    if(serializable0 == a0) {
                        return a0;
                    label_18:
                        d5.n.D(serializable0);
                    }
                    return E9.h.H(new Na.e(((NavigationMenuBenefitRes)serializable0)));
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
        return E9.h.H(new Na.d(exception0));
    }

    public Object x(String s, String s1, oe.c c0) {
        fb.l l0;
        if(c0 instanceof fb.l) {
            l0 = (fb.l)c0;
            int v = l0.B;
            if((v & 0x80000000) == 0) {
                l0 = new fb.l(this, c0);
            }
            else {
                l0.B = v ^ 0x80000000;
            }
        }
        else {
            l0 = new fb.l(this, c0);
        }
        Serializable serializable0 = l0.r;
        ne.a a0 = ne.a.a;
        switch(l0.B) {
            case 0: {
                d5.n.D(serializable0);
                try {
                    l0.B = 1;
                    serializable0 = ((k)this.a).f(s, s1, l0);
                    if(serializable0 == a0) {
                        return a0;
                    label_18:
                        d5.n.D(serializable0);
                    }
                    return new Na.e(((NavigationMenuListRes)serializable0));
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

    public Object y(int v, int v1, String s, String s1, oe.c c0) {
        hb.q q0;
        if(c0 instanceof hb.q) {
            q0 = (hb.q)c0;
            int v2 = q0.B;
            if((v2 & 0x80000000) == 0) {
                q0 = new hb.q(this, c0);
            }
            else {
                q0.B = v2 ^ 0x80000000;
            }
        }
        else {
            q0 = new hb.q(this, c0);
        }
        Object object0 = q0.r;
        ne.a a0 = ne.a.a;
        switch(q0.B) {
            case 0: {
                d5.n.D(object0);
                try {
                    d5.v v3 = (d5.v)this.a;
                    String s2 = e1.u.w(((e0)(((mb.k)this.b))).j());
                    q0.B = 1;
                    object0 = v3.M(v, v1, s, s1, s2, q0);
                    if(object0 == a0) {
                        return a0;
                    label_20:
                        d5.n.D(object0);
                    }
                    return new Na.e(((PowerDjListRes)object0));
                }
                catch(Exception exception0) {
                    break;
                }
            }
            case 1: {
                goto label_20;
            }
            default: {
                throw new IllegalStateException("call to \'resume\' before \'invoke\' with coroutine");
            }
        }
        return new Na.d(exception0);
    }

    public Object z(int v, String s, oe.c c0) {
        fb.m m0;
        if(c0 instanceof fb.m) {
            m0 = (fb.m)c0;
            int v1 = m0.B;
            if((v1 & 0x80000000) == 0) {
                m0 = new fb.m(this, c0);
            }
            else {
                m0.B = v1 ^ 0x80000000;
            }
        }
        else {
            m0 = new fb.m(this, c0);
        }
        List list0 = m0.r;
        ne.a a0 = ne.a.a;
        je.w w0 = je.w.a;
        switch(m0.B) {
            case 0: {
                d5.n.D(list0);
                try {
                    m0.B = 1;
                    b b0 = (b)((k)this.a).a.b;
                    if(b0 == null) {
                        list0 = w0;
                    }
                    else {
                        List list1 = (List)w.N(((VolatileDatabase_Impl)b0.a), true, false, new Ld.w(s, v, 8));
                        list0 = list1 == null ? w0 : list1;
                    }
                    return list0 == a0 ? a0 : list0;
                label_28:
                    d5.n.D(list0);
                    return list0;
                }
                catch(Exception unused_ex) {
                    return w0;
                }
            }
            case 1: {
                goto label_28;
            }
            default: {
                throw new IllegalStateException("call to \'resume\' before \'invoke\' with coroutine");
            }
        }
    }
}


package E9;

import Ac.z;
import B2.j;
import B2.r;
import B2.s;
import Cc.N1;
import Cc.c1;
import Cc.e0;
import Cc.r0;
import Cc.u3;
import Cd.O;
import F.m0;
import Fc.g;
import I.Z;
import I.u0;
import K2.c;
import M.j0;
import M.p0;
import M.y;
import N0.M;
import Na.f;
import Nc.M0;
import Nc.Q0;
import Nc.T0;
import O.F;
import P.t;
import Q0.k0;
import Tf.o;
import Tf.v;
import U4.i;
import U4.w;
import U4.x;
import android.content.Context;
import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.content.pm.ApplicationInfo;
import android.content.pm.ResolveInfo;
import android.database.Cursor;
import android.util.Log;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup.MarginLayoutParams;
import android.view.ViewGroup;
import android.view.ViewParent;
import androidx.compose.foundation.E0;
import androidx.compose.foundation.layout.FillElement;
import androidx.compose.foundation.layout.LayoutWeightElement;
import androidx.compose.material.ripple.RippleContainer;
import androidx.compose.runtime.V;
import androidx.compose.runtime.b0;
import androidx.compose.runtime.i0;
import androidx.compose.runtime.k;
import androidx.compose.runtime.l;
import androidx.compose.runtime.n0;
import androidx.compose.runtime.p;
import androidx.compose.ui.platform.AndroidCompositionLocals_androidKt;
import androidx.coordinatorlayout.widget.CoordinatorLayout;
import com.google.android.material.datepicker.E;
import d8.d;
import e1.m;
import java.io.ByteArrayOutputStream;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Locale;
import java.util.Map.Entry;
import kotlin.jvm.internal.I;
import kotlin.jvm.internal.J;
import kotlin.jvm.internal.q;
import org.json.JSONArray;
import org.json.JSONObject;
import r0.n;
import y0.b;
import y0.e;
import y5.a;

public abstract class h {
    public static final int a;
    public static final int b;
    public static final int c;
    public static final int d;
    public static e e;
    public static b f;
    public static A0.b g;
    public static final int h;

    public static b2.b A(Long long0, Long long1) {
        if(long0 == null && long1 == null) {
            return new b2.b(null, null);
        }
        if(long0 == null) {
            return new b2.b(null, h.B(((long)long1)));
        }
        if(long1 == null) {
            return new b2.b(h.B(((long)long0)), null);
        }
        Calendar calendar0 = E.f();
        Calendar calendar1 = E.g(null);
        calendar1.setTimeInMillis(((long)long0));
        Calendar calendar2 = E.g(null);
        calendar2.setTimeInMillis(((long)long1));
        if(calendar1.get(1) == calendar2.get(1)) {
            return calendar1.get(1) == calendar0.get(1) ? new b2.b(h.G(((long)long0), Locale.getDefault()), h.G(((long)long1), Locale.getDefault())) : new b2.b(h.G(((long)long0), Locale.getDefault()), h.M(((long)long1), Locale.getDefault()));
        }
        return new b2.b(h.M(((long)long0), Locale.getDefault()), h.M(((long)long1), Locale.getDefault()));
    }

    public static String B(long v) {
        Calendar calendar0 = E.f();
        Calendar calendar1 = E.g(null);
        calendar1.setTimeInMillis(v);
        return calendar0.get(1) == calendar1.get(1) ? h.G(v, Locale.getDefault()) : h.M(v, Locale.getDefault());
    }

    public abstract int C();

    public abstract int D();

    public abstract int E();

    public abstract int F();

    public static String G(long v, Locale locale0) {
        return E.b("MMMd", locale0).format(new Date(v));
    }

    public static final Object H(f f0) {
        q.g(f0, "<this>");
        return f0 instanceof Na.e ? ((Na.e)f0).a : null;
    }

    public abstract int I(View arg1);

    public abstract int J(CoordinatorLayout arg1);

    public abstract int K();

    public static long L(double f) {
        a.m(h.P(f), "not a normal value");
        long v = Double.doubleToRawLongBits(f);
        return Math.getExponent(f) == 0xFFFFFC01 ? (v & 0xFFFFFFFFFFFFFL) << 1 : v & 0xFFFFFFFFFFFFFL | 0x10000000000000L;
    }

    public static String M(long v, Locale locale0) {
        return E.b("yMMMd", locale0).format(new Date(v));
    }

    public static final boolean N(j j0) {
        String s = null;
        K2.b b0 = (K2.b)j0.a.foldIn(null, B2.e.l);
        K2.a a0 = b0 == null ? null : b0.a;
        if(a0 != null) {
            Object object0 = a0.a.get(c.a);
            if(object0 == null) {
                object0 = null;
            }
            if(((List)object0) != null) {
                s = (String)((List)object0).get(0);
            }
        }
        return s == null || s.length() == 0;
    }

    public abstract boolean O(float arg1);

    public static boolean P(double f) {
        return Math.getExponent(f) <= 0x3FF;
    }

    public static boolean Q(MotionEvent motionEvent0, int v) {
        return (motionEvent0.getSource() & v) == v;
    }

    public abstract boolean R(View arg1);

    public abstract boolean S(float arg1, float arg2);

    public static final int T(t t0, u0 u00) {
        return u00 == u0.a ? ((int)(t0.p & 0xFFFFFFFFL)) : ((int)(t0.p >> 0x20));
    }

    public abstract boolean U(View arg1, float arg2);

    public static boolean V(Context context0) {
        Intent intent0 = new Intent().addFlags(0x10000000).setAction("com.android.settings.panel.action.MEDIA_OUTPUT").putExtra("com.android.settings.panel.extra.PACKAGE_NAME", "com.iloen.melon");
        for(Object object0: context0.getPackageManager().queryIntentActivities(intent0, 0)) {
            ActivityInfo activityInfo0 = ((ResolveInfo)object0).activityInfo;
            if(activityInfo0 != null) {
                ApplicationInfo applicationInfo0 = activityInfo0.applicationInfo;
                if(applicationInfo0 != null && (applicationInfo0.flags & 0x81) != 0) {
                    intent0.setPackage(applicationInfo0.packageName);
                    context0.startActivity(intent0);
                    return true;
                }
                if(false) {
                    break;
                }
            }
        }
        return false;
    }

    public static final ArrayList W(List list0) {
        q.g(list0, "<this>");
        ArrayList arrayList0 = new ArrayList();
        arrayList0.addAll(list0);
        return arrayList0;
    }

    public static byte[] X(i i0) {
        byte[] arr_b;
        DataOutputStream dataOutputStream0;
        ByteArrayOutputStream byteArrayOutputStream0;
        q.g(i0, "data");
        HashMap hashMap0 = i0.a;
        try {
            byteArrayOutputStream0 = new ByteArrayOutputStream();
            dataOutputStream0 = new DataOutputStream(byteArrayOutputStream0);
        }
        catch(IOException iOException0) {
            w.e().d("WM-Data", "Error in Data#toByteArray: ", iOException0);
            return new byte[0];
        }
        try {
            dataOutputStream0.writeShort(0xFFFFABEF);
            dataOutputStream0.writeShort(1);
            dataOutputStream0.writeInt(hashMap0.size());
            for(Object object0: hashMap0.entrySet()) {
                h.Y(dataOutputStream0, ((String)((Map.Entry)object0).getKey()), ((Map.Entry)object0).getValue());
            }
            dataOutputStream0.flush();
            if(dataOutputStream0.size() > 0x2800) {
                throw new IllegalStateException("Data cannot occupy more than 10240 bytes when serialized");
            }
            arr_b = byteArrayOutputStream0.toByteArray();
            goto label_22;
        }
        catch(Throwable throwable0) {
        }
        try {
            throw throwable0;
        }
        catch(Throwable throwable1) {
            try {
                d.l(dataOutputStream0, throwable0);
                throw throwable1;
            label_22:
                dataOutputStream0.close();
                q.f(arr_b, "{\n                ByteAr…          }\n            }");
                return arr_b;
            }
            catch(IOException iOException0) {
            }
        }
        w.e().d("WM-Data", "Error in Data#toByteArray: ", iOException0);
        return new byte[0];
    }

    public static final void Y(DataOutputStream dataOutputStream0, String s, Object object0) {
        int v;
        if(object0 == null) {
            dataOutputStream0.writeByte(0);
            dataOutputStream0.writeUTF(s);
            return;
        }
        if(object0 instanceof Boolean) {
            dataOutputStream0.writeByte(1);
            dataOutputStream0.writeBoolean(((Boolean)object0).booleanValue());
            dataOutputStream0.writeUTF(s);
            return;
        }
        if(object0 instanceof Byte) {
            dataOutputStream0.writeByte(2);
            dataOutputStream0.writeByte(((Number)object0).byteValue());
            dataOutputStream0.writeUTF(s);
            return;
        }
        if(object0 instanceof Integer) {
            dataOutputStream0.writeByte(3);
            dataOutputStream0.writeInt(((Number)object0).intValue());
            dataOutputStream0.writeUTF(s);
            return;
        }
        if(object0 instanceof Long) {
            dataOutputStream0.writeByte(4);
            dataOutputStream0.writeLong(((Number)object0).longValue());
            dataOutputStream0.writeUTF(s);
            return;
        }
        if(object0 instanceof Float) {
            dataOutputStream0.writeByte(5);
            dataOutputStream0.writeFloat(((Number)object0).floatValue());
            dataOutputStream0.writeUTF(s);
            return;
        }
        if(object0 instanceof Double) {
            dataOutputStream0.writeByte(6);
            dataOutputStream0.writeDouble(((Number)object0).doubleValue());
            dataOutputStream0.writeUTF(s);
            return;
        }
        boolean z = false;
        if(object0 instanceof String) {
            z = true;
            dataOutputStream0.writeByte(7);
            dataOutputStream0.writeUTF(((String)object0));
        }
        else if(object0 instanceof Object[]) {
            z = true;
            Class class0 = ((Object[])object0).getClass();
            J j0 = I.a;
            De.d d0 = j0.b(class0);
            if(d0.equals(j0.b(Boolean[].class))) {
                v = 8;
            }
            else {
                if(d0.equals(j0.b(Byte[].class))) {
                    v = 9;
                    goto label_55;
                }
                if(d0.equals(j0.b(Integer[].class))) {
                    v = 10;
                    goto label_55;
                }
                if(d0.equals(j0.b(Long[].class))) {
                    v = 11;
                    goto label_55;
                }
                if(d0.equals(j0.b(Float[].class))) {
                    v = 12;
                    goto label_55;
                }
                if(d0.equals(j0.b(Double[].class))) {
                    v = 13;
                }
                else if(d0.equals(j0.b(String[].class))) {
                    v = 14;
                }
                else {
                    throw new IllegalArgumentException("Unsupported value type " + j0.b(((Object[])object0).getClass()).l());
                }
            }
        label_55:
            dataOutputStream0.writeByte(v);
            dataOutputStream0.writeInt(((Object[])object0).length);
            for(int v1 = 0; v1 < ((Object[])object0).length; ++v1) {
                Object object1 = ((Object[])object0)[v1];
                Boolean boolean0 = null;
                switch(v) {
                    case 8: {
                        if(object1 instanceof Boolean) {
                            boolean0 = (Boolean)object1;
                        }
                        dataOutputStream0.writeBoolean((boolean0 == null ? false : boolean0.booleanValue()));
                        break;
                    }
                    case 9: {
                        if(object1 instanceof Byte) {
                            boolean0 = (Byte)object1;
                        }
                        dataOutputStream0.writeByte((boolean0 == null ? 0 : ((byte)(((Byte)boolean0)))));
                        break;
                    }
                    case 10: {
                        if(object1 instanceof Integer) {
                            boolean0 = (Integer)object1;
                        }
                        dataOutputStream0.writeInt((boolean0 == null ? 0 : ((int)(((Integer)boolean0)))));
                        break;
                    }
                    case 11: {
                        if(object1 instanceof Long) {
                            boolean0 = (Long)object1;
                        }
                        dataOutputStream0.writeLong((boolean0 == null ? 0L : ((long)(((Long)boolean0)))));
                        break;
                    }
                    case 12: {
                        if(object1 instanceof Float) {
                            boolean0 = (Float)object1;
                        }
                        dataOutputStream0.writeFloat((boolean0 == null ? 0.0f : ((float)(((Float)boolean0)))));
                        break;
                    }
                    case 13: {
                        if(object1 instanceof Double) {
                            boolean0 = (Double)object1;
                        }
                        dataOutputStream0.writeDouble((boolean0 == null ? 0.0 : ((double)(((Double)boolean0)))));
                        break;
                    }
                    case 14: {
                        if(object1 instanceof String) {
                            boolean0 = (String)object1;
                        }
                        if(boolean0 == null) {
                            boolean0 = "androidx.work.Data-95ed6082-b8e9-46e8-a73f-ff56f00f5d9d";
                        }
                        dataOutputStream0.writeUTF(((String)boolean0));
                    }
                }
            }
        }
        if(z) {
            dataOutputStream0.writeUTF(s);
            return;
        }
        Class class1 = object0.getClass();
        throw new IllegalArgumentException("Unsupported value type " + I.a.b(class1).m());
    }

    public static final qf.b Z(String s) {
        boolean z = v.r0(s, ".", false);
        if(z) {
            s = s.substring(1);
            q.f(s, "substring(...)");
        }
        return new qf.b(new qf.c(v.o0(o.c1('/', s, ""), '/', '.')), new qf.c(o.Y0('/', s, s)), z);
    }

    public static final T.c a(int v) {
        return new T.c(((float)v));
    }

    public static final ArrayList a0(JSONArray jSONArray0) {
        ArrayList arrayList0 = new ArrayList();
        int v = jSONArray0.length();
        for(int v1 = 0; v1 < v; ++v1) {
            Object object0 = jSONArray0.get(v1);
            q.f(object0, "this[i]");
            if(object0 instanceof JSONArray) {
                object0 = h.a0(((JSONArray)object0));
            }
            else if(object0 instanceof JSONObject) {
                object0 = h.b0(((JSONObject)object0));
            }
            arrayList0.add(object0);
        }
        return arrayList0;
    }

    public static final void b(String s, boolean z, boolean z1, boolean z2, l l0, int v, int v1) {
        boolean z4;
        long v5;
        ((p)l0).c0(0x25B02914);
        int v2 = v | (((p)l0).g(s) ? 4 : 2);
        if((v & 0x30) == 0) {
            v2 |= (((p)l0).h(z) ? 0x20 : 16);
        }
        int v3 = v2 | (((p)l0).h(z1) ? 0x100 : 0x80);
        int v4 = (v1 & 8) == 0 ? v3 | (((p)l0).h(z2) ? 0x800 : 0x400) : v3 | 0xC00;
        if(((p)l0).Q(v4 & 1, (v4 & 0x493) != 1170)) {
            boolean z3 = (v1 & 8) == 0 ? z2 : false;
            if(z3) {
                ((p)l0).a0(2051689317);
                ((p)l0).p(false);
                v5 = 0x24FFFFFF00000000L;
            }
            else {
                v5 = z ? A7.d.f(((p)l0), 2051693305, 0x7F0604A1, ((p)l0), false) : A7.d.f(((p)l0), 2051695055, 0x7F0604B4, ((p)l0), false);  // color:white000e
            }
            N1.b(s, androidx.compose.foundation.layout.a.n(androidx.compose.foundation.layout.d.f(n.a, 1.0f), 0.0f, 0.0f, 0.0f, (z1 ? 16.0f : 8.0f), 7), v5, 18.0f, null, null, 0L, null, 23.0f, 0, false, 0, 0, null, null, ((p)l0), v4 & 14 | 0xC00, 6, 0x1FBF0);
            z4 = z3;
        }
        else {
            ((p)l0).T();
            z4 = z2;
        }
        n0 n00 = ((p)l0).t();
        if(n00 != null) {
            n00.d = new Fc.e(s, z, z1, z4, v, v1);
        }
    }

    public static final LinkedHashMap b0(JSONObject jSONObject0) {
        LinkedHashMap linkedHashMap0 = new LinkedHashMap();
        Iterator iterator0 = jSONObject0.keys();
        q.f(iterator0, "this.keys()");
        while(iterator0.hasNext()) {
            Object object0 = iterator0.next();
            Object object1 = jSONObject0.get(((String)object0));
            q.f(object1, "this.get(key)");
            if(object1 instanceof JSONArray) {
                object1 = h.a0(((JSONArray)object1));
            }
            else if(object1 instanceof JSONObject) {
                object1 = h.b0(((JSONObject)object1));
            }
            linkedHashMap0.put(((String)object0), object1);
        }
        return linkedHashMap0;
    }

    public static final void c(d9.h h0, l l0, int v) {
        q.g(h0, "lyricViewModel");
        p p0 = (p)l0;
        p0.c0(-94061438);
        int v1 = (p0.i(h0) ? 4 : 2) | v;
        if(p0.Q(v1 & 1, (v1 & 3) != 2)) {
            b0 b00 = p0.N();
            V v2 = k.a;
            if(b00 == v2) {
                b00 = androidx.compose.runtime.w.s(Boolean.TRUE);
                p0.l0(b00);
            }
            r0.q q0 = androidx.compose.foundation.layout.d.c;
            M m0 = M.p.d(r0.d.a, false);
            int v3 = p0.P;
            i0 i00 = p0.m();
            r0.q q1 = r0.a.d(p0, q0);
            P0.k.y.getClass();
            P0.i i0 = P0.j.b;
            p0.e0();
            if(p0.O) {
                p0.l(i0);
            }
            else {
                p0.o0();
            }
            androidx.compose.runtime.w.x(p0, m0, P0.j.f);
            androidx.compose.runtime.w.x(p0, i00, P0.j.e);
            P0.h h1 = P0.j.g;
            if(p0.O || !q.b(p0.N(), v3)) {
                A7.d.q(v3, p0, v3, h1);
            }
            androidx.compose.runtime.w.x(p0, q1, P0.j.d);
            b0 b01 = m.x(h0.k, p0);
            boolean z = p0.g(((List)b01.getValue()));
            Boolean boolean0 = p0.N();
            if(z || boolean0 == v2) {
                boolean0 = Boolean.valueOf(h0.i);
                p0.l0(boolean0);
            }
            boolean z1 = boolean0.booleanValue();
            boolean z2 = p0.g(((List)b01.getValue()));
            Boolean boolean1 = p0.N();
            if(z2 || boolean1 == v2) {
                boolean1 = Boolean.valueOf(h0.j);
                p0.l0(boolean1);
            }
            List list0 = je.w.a;
            if(!z1 || boolean1.booleanValue()) {
                p0.a0(0x44A14C76);
                List list2 = (List)b01.getValue();
                if(list2 != null) {
                    list0 = list2;
                }
                h.e(list0, p0, 0);
            }
            else {
                p0.a0(0x44A33703);
                b0 b02 = m.x(h0.h, p0);
                F f0 = O.I.a(0, 0, 3, p0);
                g g0 = p0.N();
                if(g0 == v2) {
                    g0 = new g(b00);
                    p0.l0(g0);
                }
                if(((Boolean)b00.getValue()).booleanValue()) {
                    p0.a0(1152037528);
                    Integer integer0 = (Integer)b02.getValue();
                    boolean z3 = p0.g(b01);
                    boolean z4 = p0.g(b02);
                    boolean z5 = p0.g(f0);
                    Fc.f f1 = p0.N();
                    if((z3 | z4 | z5) != 0 || f1 == v2) {
                        f1 = new Fc.f(f0, b01, b02, null);
                        p0.l0(f1);
                    }
                    androidx.compose.runtime.J.d(p0, integer0, f1);
                }
                else {
                    p0.a0(0x447FDAA6);
                }
                p0.p(false);
                if(((Boolean)b00.getValue()).booleanValue()) {
                    q0 = androidx.compose.ui.input.nestedscroll.a.a(q0, g0, null);
                }
                List list1 = (List)b01.getValue();
                h.d(q0, f0, (list1 == null ? list0 : list1), ((Integer)b02.getValue()), (h0.m == null ? -1L : h0.m.getDurationLimit()), p0, 0);
            }
            p0.p(false);
            p0.p(true);
        }
        else {
            p0.T();
        }
        n0 n00 = p0.t();
        if(n00 != null) {
            n00.d = new C8.a(h0, v, 6);
        }
    }

    public abstract void c0(ViewGroup.MarginLayoutParams arg1, int arg2);

    public static final void d(r0.q q0, F f0, List list0, Integer integer0, long v, l l0, int v1) {
        ((p)l0).c0(149136075);
        int v2 = v1 | (((p)l0).g(q0) ? 4 : 2) | (((p)l0).g(f0) ? 0x20 : 16) | (((p)l0).i(list0) ? 0x100 : 0x80) | (((p)l0).g(integer0) ? 0x800 : 0x400) | (((p)l0).f(v) ? 0x4000 : 0x2000);
        int v3 = 0;
        if(((p)l0).Q(v2 & 1, (v2 & 9363) != 9362)) {
            float f1 = M.c.f(M.b.e(((p)l0)).k, ((p)l0)).a();
            j0 j00 = androidx.compose.foundation.layout.a.c(0.0f, 0.0f, 0.0f, h.t(((p)l0), 0x7F0700AD) + f1, 7);  // dimen:cover_screen_bottom_margin
            boolean z = ((p)l0).i(list0);
            if((v2 & 0x1C00) == 0x800) {
                v3 = 1;
            }
            Fc.c c0 = ((p)l0).N();
            if((z | (0xE000 & v2) == 0x4000 | v3) != 0 || c0 == k.a) {
                Fc.c c1 = new Fc.c(0, v, list0, integer0);
                ((p)l0).l0(c1);
                c0 = c1;
            }
            c1.o(q0, f0, j00, false, null, null, null, false, c0, ((p)l0), v2 & 0x7E, 0xF8);
        }
        else {
            ((p)l0).T();
        }
        n0 n00 = ((p)l0).t();
        if(n00 != null) {
            n00.d = new Fc.d(q0, f0, list0, integer0, v, v1);
        }
    }

    public abstract void d0(ViewGroup.MarginLayoutParams arg1, int arg2, int arg3);

    public static final void e(List list0, l l0, int v) {
        ((p)l0).c0(633477707);
        int v1 = (((p)l0).i(list0) ? 4 : 2) | v;
        if(((p)l0).Q(v1 & 1, (v1 & 3) != 2)) {
            float f = M.c.f(M.b.e(((p)l0)).k, ((p)l0)).a();
            float f1 = h.t(((p)l0), 0x7F0700AD);  // dimen:cover_screen_bottom_margin
            FillElement fillElement0 = androidx.compose.foundation.layout.d.c;
            j0 j00 = androidx.compose.foundation.layout.a.c(0.0f, 0.0f, 0.0f, f1 + f, 7);
            boolean z = ((p)l0).i(list0);
            Fc.a a0 = ((p)l0).N();
            if(z || a0 == k.a) {
                a0 = new Fc.a(list0, 0);
                ((p)l0).l0(a0);
            }
            c1.o(fillElement0, null, j00, false, null, null, null, false, a0, ((p)l0), 6, 0xFA);
        }
        else {
            ((p)l0).T();
        }
        n0 n00 = ((p)l0).t();
        if(n00 != null) {
            n00.d = new Fc.b(list0, v);
        }
    }

    public static final void f(r0.q q0, Q0 q00, boolean z, boolean z1, l l0, int v) {
        int v3;
        q.g(q00, "uiState");
        p p0 = (p)l0;
        p0.c0(0x7AAF9B14);
        int v1 = v | (p0.i(q00) ? 0x20 : 16) | (p0.h(z) ? 0x100 : 0x80) | (p0.h(z1) ? 0x800 : 0x400);
        if(p0.Q(v1 & 1, (v1 & 0x493) != 1170)) {
            y y0 = M.w.a(M.j.c, r0.d.m, p0, 0);
            int v2 = p0.P;
            i0 i00 = p0.m();
            r0.q q1 = r0.a.d(p0, q0);
            P0.k.y.getClass();
            P0.i i0 = P0.j.b;
            p0.e0();
            if(p0.O) {
                p0.l(i0);
            }
            else {
                p0.o0();
            }
            P0.h h0 = P0.j.f;
            androidx.compose.runtime.w.x(p0, y0, h0);
            P0.h h1 = P0.j.e;
            androidx.compose.runtime.w.x(p0, i00, h1);
            P0.h h2 = P0.j.g;
            if(p0.O || !q.b(p0.N(), v2)) {
                A7.d.q(v2, p0, v2, h2);
            }
            P0.h h3 = P0.j.d;
            androidx.compose.runtime.w.x(p0, q1, h3);
            n n0 = n.a;
            a.a.e(androidx.compose.foundation.layout.a.l(n0, 16.0f, 0.0f, 2), q00.a, p0, 6);
            M.c.d(p0, androidx.compose.foundation.layout.d.h(n0, 12.0f));
            if(!z) {
                v3 = z1 ? 3 : 4;
            }
            else if(z1) {
                v3 = 5;
            }
            else {
                v3 = 7;
            }
            r0.q q2 = androidx.compose.foundation.layout.a.l(n0, 16.0f, 0.0f, 2);
            p0 p00 = M.n0.a(M.j.h(10.0f), r0.d.j, p0, 6);
            int v4 = p0.P;
            i0 i01 = p0.m();
            r0.q q3 = r0.a.d(p0, q2);
            p0.e0();
            if(p0.O) {
                p0.l(i0);
            }
            else {
                p0.o0();
            }
            androidx.compose.runtime.w.x(p0, p00, h0);
            androidx.compose.runtime.w.x(p0, i01, h1);
            if(p0.O || !q.b(p0.N(), v4)) {
                A7.d.q(v4, p0, v4, h2);
            }
            androidx.compose.runtime.w.x(p0, q3, h3);
            p0.a0(0xD187AC08);
            for(int v5 = 0; v5 < v3; ++v5) {
                T0.a(new LayoutWeightElement(1.0f, true), ((M0)je.p.n0(v5, q00.b)), p0, 0);
            }
            A7.d.s(p0, false, true, true);
        }
        else {
            p0.T();
        }
        n0 n00 = p0.t();
        if(n00 != null) {
            n00.d = new Mc.j(q0, q00, z, z1, v, 2);
        }
    }

    public static final void g(B2.t t0, String s, B2.n n0, int v, l l0, int v1, int v2) {
        B2.n n2;
        int v5;
        B2.n n1;
        p p0 = (p)l0;
        p0.c0(0x1D5027F3);
        int v3 = v1 | (p0.g(t0) ? 4 : 2);
        if((v1 & 0x30) == 0) {
            v3 |= (p0.g(s) ? 0x20 : 16);
        }
        int v4 = (v2 & 4) == 0 ? v3 | (p0.g(n0) ? 0x100 : 0x80) : v3 | 0x180;
        if(((((v2 & 8) == 0 ? v4 | (p0.e(v) ? 0x800 : 0x400) : v4 | 0xC00) | 0x6000) & 9363) == 9362 && p0.D()) {
            p0.T();
            n1 = n0;
            v5 = v;
            goto label_46;
        }
        n1 = (v2 & 4) == 0 ? n0 : B2.l.a;
        int v6 = (v2 & 8) == 0 ? v : 1;
        p0.b0(0x81591AB);
        if(s == null) {
            n2 = n1;
        }
        else {
            p0.b0(135633130);
            boolean z = p0.g(s);
            s s1 = p0.N();
            if(z || s1 == k.a) {
                s1 = new s(s, 0);
                p0.l0(s1);
            }
            p0.p(false);
            n2 = c.a(n1, s1);
        }
        p0.p(false);
        B2.q q0 = B2.q.b;
        p0.b0(0xBD7CCD0A);
        p0.b0(0x7076B8D0);
        if(p0.a instanceof B2.b) {
            p0.Y();
            if(p0.O) {
                p0.l(new B2.o(q0));
            }
            else {
                p0.o0();
            }
            androidx.compose.runtime.w.x(p0, t0, B2.e.h);
            androidx.compose.runtime.w.x(p0, n2, B2.e.i);
            androidx.compose.runtime.w.x(p0, new J2.j(v6), B2.e.j);
            androidx.compose.runtime.w.x(p0, null, B2.e.k);
            p0.p(true);
            p0.p(false);
            p0.p(false);
            v5 = v6;
        label_46:
            n0 n00 = p0.t();
            if(n00 != null) {
                n00.d = new r(t0, s, n1, v5, v1, v2);
            }
            return;
        }
        androidx.compose.runtime.w.m();
        throw null;
    }

    public static final void h(P.a a0, r0.q q0, P.F f0, j0 j00, M.f f1, M.h h0, Z z0, boolean z1, androidx.compose.foundation.m m0, we.k k0, l l0, int v, int v1, int v2) {
        M.h h2;
        androidx.compose.foundation.m m2;
        boolean z5;
        M.h h1;
        int v13;
        androidx.compose.foundation.m m1;
        boolean z3;
        int v8;
        int v6;
        Z z2;
        p p0 = (p)l0;
        p0.c0(0x25E7B320);
        int v3 = (p0.g(a0) ? 4 : 2) | v;
        if((v & 0x30) == 0) {
            v3 |= (p0.g(q0) ? 0x20 : 16);
        }
        int v4 = v3 | (p0.g(f0) ? 0x100 : 0x80);
        if((v & 0xC00) == 0) {
            v4 |= (p0.g(j00) ? 0x800 : 0x400);
        }
        int v5 = (v2 & 16) == 0 ? v4 | (p0.h(false) ? 0x4000 : 0x2000) : v4 | 0x6000;
        if((v & 0x30000) == 0) {
            v5 |= (p0.g(f1) ? 0x20000 : 0x10000);
        }
        if((v2 & 0x40) != 0) {
            v5 |= 0x180000;
        }
        else if((0x180000 & v) == 0) {
            v5 |= (p0.g(h0) ? 0x100000 : 0x80000);
        }
        if((v2 & 0x80) == 0) {
            z2 = z0;
            v6 = p0.g(z2) ? 0x800000 : 0x400000;
        }
        else {
            z2 = z0;
            v6 = 0x400000;
        }
        int v7 = v5 | v6;
        if((v2 & 0x100) == 0) {
            z3 = z1;
            v8 = v7 | (p0.h(z3) ? 0x4000000 : 0x2000000);
        }
        else {
            v8 = v7 | 0x6000000;
            z3 = z1;
        }
        int v9 = (v1 & 6) == 0 ? v1 | (p0.i(k0) ? 4 : 2) : v1;
        int v10 = v8 | 0x10000000;
        int v11 = 1;
        if(p0.Q(v10 & 1, ((v8 | 0x10000000) & 306783379) != 306783378 || (v9 & 3) != 2)) {
            p0.V();
            V v12 = k.a;
            if((v & 1) == 0 || p0.B()) {
                h1 = (v2 & 0x40) == 0 ? h0 : M.j.c;
                if((v2 & 0x80) != 0) {
                    G.y y0 = m0.a(p0);
                    boolean z4 = p0.g(y0);
                    I.n n0 = p0.N();
                    if(z4 || n0 == v12) {
                        n0 = new I.n(y0);
                        p0.l0(n0);
                    }
                    z2 = n0;
                    v10 &= 0xFE3FFFFF;
                }
                if((v2 & 0x100) != 0) {
                    z3 = true;
                }
                v13 = v10 & 0x8FFFFFFF;
                m1 = E0.a(p0);
            }
            else {
                p0.T();
                m1 = m0;
                v13 = ((v2 & 0x80) == 0 ? v10 : v10 & 0xFE3FFFFF) & 0x8FFFFFFF;
                h1 = h0;
            }
            p0.q();
            int v14 = v13 & 14 | v13 >> 15 & 0x70;
            int v15 = ((v14 & 14 ^ 6) <= 4 || !p0.g(a0)) && (v14 & 6) != 4 ? 0 : 1;
            if(((v14 & 0x70 ^ 0x30) <= 0x20 || !p0.g(h1)) && (v14 & 0x30) != 0x20) {
                v11 = 0;
            }
            P.c c0 = p0.N();
            if((v15 | v11) != 0 || c0 == v12) {
                c0 = new P.c(new B2.p(10, a0, h1));
                p0.l0(c0);
            }
            E9.w.e(q0, f0, c0, j00, false, z2, z3, m1, h1, f1, k0, p0, v13 >> 3 & 0x1C00000 | (v13 >> 3 & 14 | 0x30000 | v13 >> 3 & 0x70 | v13 & 0x1C00 | 0xE000 & v13 | 0x380000 & v13 >> 3) | v13 << 9 & 0x70000000, v13 >> 15 & 14 | v9 << 3 & 0x70);
            z5 = z3;
            m2 = m1;
            h2 = h1;
        }
        else {
            p0.T();
            m2 = m0;
            z5 = z3;
            h2 = h0;
        }
        n0 n00 = p0.t();
        if(n00 != null) {
            n00.d = new P.e(a0, q0, f0, j00, f1, h2, z2, z5, m2, k0, v, v1, v2);
        }
    }

    public static final void i(P.a a0, r0.q q0, P.F f0, M.i0 i00, M.h h0, M.f f1, Z z0, boolean z1, androidx.compose.foundation.m m0, we.k k0, l l0, int v, int v1) {
        Z z6;
        boolean z5;
        androidx.compose.foundation.m m1;
        int v11;
        boolean z3;
        int v7;
        int v5;
        Z z2;
        p p0 = (p)l0;
        p0.c0(-2072102870);
        int v2 = (p0.g(a0) ? 4 : 2) | v;
        if((v & 0x30) == 0) {
            v2 |= (p0.g(q0) ? 0x20 : 16);
        }
        int v3 = v2 | (p0.g(f0) ? 0x100 : 0x80);
        if((v & 0xC00) == 0) {
            v3 |= (p0.g(i00) ? 0x800 : 0x400);
        }
        int v4 = (v1 & 16) == 0 ? v3 | (p0.h(false) ? 0x4000 : 0x2000) : v3 | 0x6000;
        if((v & 0x30000) == 0) {
            v4 |= (p0.g(h0) ? 0x20000 : 0x10000);
        }
        if((0x180000 & v) == 0) {
            v4 |= (p0.g(f1) ? 0x100000 : 0x80000);
        }
        if((v1 & 0x80) == 0) {
            z2 = z0;
            v5 = p0.g(z2) ? 0x800000 : 0x400000;
        }
        else {
            z2 = z0;
            v5 = 0x400000;
        }
        int v6 = v4 | v5;
        if((v1 & 0x100) == 0) {
            z3 = z1;
            v7 = v6 | (p0.h(z3) ? 0x4000000 : 0x2000000);
        }
        else {
            v7 = v6 | 0x6000000;
            z3 = z1;
        }
        int v8 = v7 | 0x10000000;
        int v9 = p0.i(k0) ? 4 : 2;
        if(p0.Q(v8 & 1, (v8 & 306783379) != 306783378 || (v9 & 3) != 2)) {
            p0.V();
            V v10 = k.a;
            if((v & 1) == 0 || p0.B()) {
                if((v1 & 0x80) != 0) {
                    G.y y0 = m0.a(p0);
                    boolean z4 = p0.g(y0);
                    I.n n0 = p0.N();
                    if(z4 || n0 == v10) {
                        n0 = new I.n(y0);
                        p0.l0(n0);
                    }
                    v8 &= 0xFE3FFFFF;
                    z2 = n0;
                }
                if((v1 & 0x100) != 0) {
                    z3 = true;
                }
                v11 = v8 & 0x8FFFFFFF;
                m1 = E0.a(p0);
            }
            else {
                p0.T();
                if((v1 & 0x80) != 0) {
                    v8 &= 0xFE3FFFFF;
                }
                v11 = v8 & 0x8FFFFFFF;
                m1 = m0;
            }
            z5 = z3;
            p0.q();
            int v12 = v11 & 14 | v11 >> 15 & 0x70;
            int v13 = ((v12 & 14 ^ 6) <= 4 || !p0.g(a0)) && (v12 & 6) != 4 ? 0 : 1;
            int v14 = ((v12 & 0x70 ^ 0x30) <= 0x20 || !p0.g(f1)) && (v12 & 0x30) != 0x20 ? 0 : 1;
            P.c c0 = p0.N();
            if((v13 | v14) != 0 || c0 == v10) {
                c0 = new P.c(new B2.p(9, a0, f1));
                p0.l0(c0);
            }
            z6 = z2;
            E9.w.e(q0, f0, c0, i00, true, z6, z5, m1, h0, f1, k0, p0, v11 >> 3 & 0x1C00000 | (v11 >> 3 & 14 | 0x30000 | v11 >> 3 & 0x70 | v11 & 0x1C00 | 0xE000 & v11 | 0x380000 & v11 >> 3) | v11 << 12 & 0x70000000, v11 >> 18 & 14 | v9 << 3 & 0x70);
        }
        else {
            p0.T();
            m1 = m0;
            z5 = z3;
            z6 = z2;
        }
        n0 n00 = p0.t();
        if(n00 != null) {
            n00.d = new P.f(a0, q0, f0, i00, h0, f1, z6, z5, m1, k0, v, v1);
        }
    }

    public static final void j(Cd.M m0, we.a a0, l l0, int v) {
        n n2;
        n n1;
        q.g(m0, "uiState");
        p p0 = (p)l0;
        p0.c0(-1238176380);
        int v1 = v | (p0.g(m0) ? 4 : 2) | (p0.i(a0) ? 0x20 : 16);
        if(p0.Q(v1 & 1, (v1 & 19) != 18)) {
            Context context0 = (Context)p0.k(AndroidCompositionLocals_androidKt.b);
            n n0 = n.a;
            r0.q q0 = androidx.compose.foundation.layout.d.t(androidx.compose.foundation.layout.d.f(n0, 1.0f), 3);
            M.d d0 = M.j.c;
            r0.g g0 = r0.d.m;
            y y0 = M.w.a(d0, g0, p0, 0);
            int v2 = p0.P;
            i0 i00 = p0.m();
            r0.q q1 = r0.a.d(p0, q0);
            P0.k.y.getClass();
            P0.i i0 = P0.j.b;
            p0.e0();
            if(p0.O) {
                p0.l(i0);
            }
            else {
                p0.o0();
            }
            P0.h h0 = P0.j.f;
            androidx.compose.runtime.w.x(p0, y0, h0);
            P0.h h1 = P0.j.e;
            androidx.compose.runtime.w.x(p0, i00, h1);
            P0.h h2 = P0.j.g;
            if(p0.O || !q.b(p0.N(), v2)) {
                A7.d.q(v2, p0, v2, h2);
            }
            P0.h h3 = P0.j.d;
            androidx.compose.runtime.w.x(p0, q1, h3);
            r0.q q2 = r0.a.a(androidx.compose.foundation.layout.d.t(androidx.compose.foundation.layout.d.f(androidx.compose.foundation.layout.a.l(n0, 16.0f, 0.0f, 2), 1.0f), 3), new u3(17, a0));
            y y1 = M.w.a(d0, g0, p0, 0);
            int v3 = p0.P;
            i0 i01 = p0.m();
            r0.q q3 = r0.a.d(p0, q2);
            p0.e0();
            if(p0.O) {
                p0.l(i0);
            }
            else {
                p0.o0();
            }
            androidx.compose.runtime.w.x(p0, y1, h0);
            androidx.compose.runtime.w.x(p0, i01, h1);
            if(p0.O || !q.b(p0.N(), v3)) {
                A7.d.q(v3, p0, v3, h2);
            }
            androidx.compose.runtime.w.x(p0, q3, h3);
            r0.q q4 = androidx.compose.foundation.layout.d.h(androidx.compose.foundation.layout.d.v(androidx.compose.foundation.layout.a.n(n0, 0.0f, 18.0f, 0.0f, 0.0f, 13), null, 3), 22.0f);
            r0.q q5 = H0.b.q(r0.d.n, q4);
            p0 p00 = M.n0.a(M.j.a, r0.d.j, p0, 0);
            int v4 = p0.P;
            i0 i02 = p0.m();
            r0.q q6 = r0.a.d(p0, q5);
            p0.e0();
            r0.g g1 = r0.d.n;
            if(p0.O) {
                p0.l(i0);
            }
            else {
                p0.o0();
            }
            androidx.compose.runtime.w.x(p0, p00, h0);
            androidx.compose.runtime.w.x(p0, i02, h1);
            if(p0.O || !q.b(p0.N(), v4)) {
                A7.d.q(v4, p0, v4, h2);
            }
            androidx.compose.runtime.w.x(p0, q6, h3);
            r0.q q7 = androidx.compose.foundation.layout.d.u(n0, 3);
            q.f("To.", "getString(...)");
            N1.b("To.", q7, e0.T(p0, 0x7F060160), 18.0f, null, null, 0L, null, 0.0f, 0, false, 0, 0, null, null, p0, 0xC30, 0, 0x1FFF0);  // color:gray600s_support_high_contrast
            if(m0.a) {
                p0.a0(0x1FC3239C);
                r0.q q8 = androidx.compose.foundation.layout.d.u(androidx.compose.foundation.layout.a.n(n0, 4.0f, 0.0f, 4.0f, 0.0f, 10), 3);
                q.f("DJ", "getString(...)");
                q.d(m0.b);
                n1 = n0;
                N1.b("DJ", q8, e0.T(p0, ((int)m0.b)), 18.0f, e1.y.i, null, 0L, null, 0.0f, 0, false, 0, 0, null, null, p0, 0x30C30, 0, 0x1FFD0);
            }
            else {
                n1 = n0;
                p0.a0(0x1F916BEE);
            }
            p0.p(false);
            r0.q q9 = x.r(1.0f, androidx.compose.foundation.layout.d.c(androidx.compose.foundation.layout.d.v(n1, null, 3), 1.0f), false);
            N1.b((m0.c == null ? "" : m0.c), q9, e0.T(p0, 0x7F060169), 18.0f, null, null, 0L, null, 0.0f, 2, false, 1, 0, null, null, p0, 0xC00, 0xC30, 0x1D7F0);  // color:gray850s
            if(m0.d) {
                p0.a0(0x1FD1DCC6);
                n2 = n1;
                r0.q q10 = androidx.compose.foundation.layout.d.u(androidx.compose.foundation.layout.a.n(n2, 4.0f, 0.0f, 0.0f, 0.5f, 6), 3);
                androidx.compose.foundation.q.c(De.I.Q(0x7F08041C, p0, 6), null, q10, null, N0.j.g, 0.0f, null, p0, 25008, 104);  // drawable:ic_common_verify_14
            }
            else {
                n2 = n1;
                p0.a0(0x1F916BEE);
            }
            p0.p(false);
            p0.p(true);
            r0.q q11 = H0.b.q(g1, androidx.compose.foundation.layout.d.h(androidx.compose.foundation.layout.d.v(androidx.compose.foundation.layout.a.n(n2, 0.0f, 1.0f, 0.0f, 0.0f, 13), null, 3), 16.0f));
            N1.b((m0.e == null ? "" : m0.e), q11, e0.T(p0, 0x7F060160), 12.0f, null, null, 0L, null, 0.0f, 2, false, 1, 0, null, null, p0, 0xC00, 0xC30, 0x1D7F0);  // color:gray600s_support_high_contrast
            r0.q q12 = H0.b.q(g1, androidx.compose.foundation.layout.d.n(androidx.compose.foundation.layout.a.n(n2, 0.0f, 12.0f, 0.0f, 0.0f, 13), 113.0f));
            r0.q q13 = androidx.compose.foundation.q.i(0.5f, e0.T(p0, 0x7F06014A), q12, T.e.a);  // color:gray100a
            r0.b.e(q13, (m0.f == null ? "" : m0.f), 113.0f, null, 0L, false, false, p0, 0xC00180, 120);
            p0.p(true);
            r0.q q14 = H0.b.q(g1, androidx.compose.foundation.layout.d.u(androidx.compose.foundation.layout.a.n(n2, 0.0f, 18.0f, 0.0f, 0.0f, 13), 3));
            N1.b((m0.g == null ? "" : m0.g), q14, e0.T(p0, 0x7F060163), 14.0f, null, null, 0L, new l1.k(3), 21.5f, 0, false, 0, 0, null, null, p0, 0xC00, 6, 0x1F9F0);  // color:gray700s
            r0.q q15 = H0.b.q(g1, androidx.compose.foundation.layout.d.u(androidx.compose.foundation.layout.a.n(n2, 0.0f, 20.5f, 0.0f, 0.0f, 13), 3));
            N1.b(("선물 사용 유효기간ㅣ " + (m0.h == null ? "" : m0.h)), q15, e0.T(p0, 0x7F06017B), 14.0f, null, null, 0L, null, 0.0f, 0, false, 0, 0, null, null, p0, 0xC00, 0, 0x1FFF0);  // color:green500s
            A7.d.v(n2, 24.0f, p0, true);
        }
        else {
            p0.T();
        }
        n0 n00 = p0.t();
        if(n00 != null) {
            n00.d = new z(m0, a0, v, 16);
        }
    }

    public static final void k(O o0, l l0, int v) {
        q.g(o0, "uiState");
        p p0 = (p)l0;
        p0.c0(649449097);
        int v1 = (p0.g(o0) ? 4 : 2) | v;
        if(p0.Q(v1 & 1, (v1 & 3) != 2)) {
            Context context0 = (Context)p0.k(AndroidCompositionLocals_androidKt.b);
            String s = q.b(o0.b, "1B0006") ? "선물 사용 : 사용완료" : "선물 사용 : 미사용";
            q.d(s);
            n n0 = n.a;
            r0.q q0 = androidx.compose.foundation.layout.d.f(androidx.compose.foundation.layout.a.n(n0, 16.0f, 0.0f, 16.0f, 0.0f, 10), 1.0f);
            p0 p00 = M.n0.a(M.j.a, r0.d.k, p0, 0x30);
            int v2 = p0.P;
            i0 i00 = p0.m();
            r0.q q1 = r0.a.d(p0, q0);
            P0.k.y.getClass();
            P0.i i0 = P0.j.b;
            p0.e0();
            if(p0.O) {
                p0.l(i0);
            }
            else {
                p0.o0();
            }
            P0.h h0 = P0.j.f;
            androidx.compose.runtime.w.x(p0, p00, h0);
            P0.h h1 = P0.j.e;
            androidx.compose.runtime.w.x(p0, i00, h1);
            P0.h h2 = P0.j.g;
            if(p0.O || !q.b(p0.N(), v2)) {
                A7.d.q(v2, p0, v2, h2);
            }
            P0.h h3 = P0.j.d;
            androidx.compose.runtime.w.x(p0, q1, h3);
            r0.q q2 = e0.K(androidx.compose.foundation.layout.d.h(androidx.compose.foundation.layout.d.q(androidx.compose.foundation.layout.a.n(n0, 0.0f, 8.0f, 0.0f, 8.0f, 5), 48.0f), 48.0f));
            M m0 = M.p.d(r0.d.a, false);
            int v3 = p0.P;
            i0 i01 = p0.m();
            r0.q q3 = r0.a.d(p0, q2);
            p0.e0();
            if(p0.O) {
                p0.l(i0);
            }
            else {
                p0.o0();
            }
            androidx.compose.runtime.w.x(p0, m0, h0);
            androidx.compose.runtime.w.x(p0, i01, h1);
            if(p0.O || !q.b(p0.N(), v3)) {
                A7.d.q(v3, p0, v3, h2);
            }
            androidx.compose.runtime.w.x(p0, q3, h3);
            androidx.compose.foundation.q.c(L5.c.a(d5.w.B(context0, 0x7F0808B9), p0), null, androidx.compose.foundation.layout.d.c, null, N0.j.f, 0.0f, null, p0, 25008, 104);  // drawable:shape_rectangle_gray100a_0_5dp_blue400s_bg_round4
            androidx.compose.foundation.q.c(De.I.Q(0x7F08044E, p0, 6), null, androidx.compose.foundation.layout.d.c, null, N0.j.f, 0.0f, null, p0, 25008, 104);  // drawable:ic_gift_pass_small
            p0.p(true);
            r0.q q4 = x.r(1.0f, androidx.compose.foundation.layout.d.t(androidx.compose.foundation.layout.d.f(androidx.compose.foundation.layout.a.n(n0, 10.0f, 0.0f, 0.0f, 0.0f, 14), 1.0f), 3), true);
            y y0 = M.w.a(M.j.c, r0.d.m, p0, 0);
            int v4 = p0.P;
            i0 i02 = p0.m();
            r0.q q5 = r0.a.d(p0, q4);
            p0.e0();
            if(p0.O) {
                p0.l(i0);
            }
            else {
                p0.o0();
            }
            androidx.compose.runtime.w.x(p0, y0, h0);
            androidx.compose.runtime.w.x(p0, i02, h1);
            if(p0.O || !q.b(p0.N(), v4)) {
                A7.d.q(v4, p0, v4, h2);
            }
            androidx.compose.runtime.w.x(p0, q5, h3);
            N1.b((o0.a == null ? "" : o0.a), null, e0.T(p0, 0x7F06016D), 15.0f, null, null, 0L, null, 0.0f, 2, false, 1, 0, null, null, p0, 0xC00, 0xC30, 0x1D7F2);  // color:gray900s
            N1.b(s, androidx.compose.foundation.layout.a.n(n0, 0.0f, 4.0f, 0.0f, 0.0f, 13), e0.T(p0, 0x7F06015D), 12.0f, null, null, 0L, null, 0.0f, 0, false, 0, 0, null, null, p0, 0xC30, 0, 0x1FFF0);  // color:gray500s_support_high_contrast
            p0.p(true);
            p0.p(true);
        }
        else {
            p0.T();
        }
        n0 n00 = p0.t();
        if(n00 != null) {
            n00.d = new C8.a(o0, v, 4);
        }
    }

    public static final void l(Kd.g g0, we.a a0, we.a a1, l l0, int v) {
        q.g(g0, "uiState");
        p p0 = (p)l0;
        p0.c0(-1385065557);
        int v1 = v | (p0.i(g0) ? 4 : 2) | (p0.i(a0) ? 0x20 : 16) | (p0.i(a1) ? 0x100 : 0x80);
        if(p0.Q(v1 & 1, (v1 & 0x93) != 0x92)) {
            boolean z = g0.i;
            n n0 = n.a;
            r0.q q0 = androidx.compose.foundation.layout.d.h(androidx.compose.foundation.layout.d.f(n0, 1.0f), 60.0f);
            Bc.d d0 = p0.N();
            if((v1 & 0x380) == 0x100 || d0 == k.a) {
                d0 = new Bc.d(8, a1);
                p0.l0(d0);
            }
            r0.q q1 = r0.a.a(q0, new u3(18, d0));
            if(!z) {
                q1 = e2.a.r(q1, 0.3f);
            }
            M.b b0 = M.j.a;
            p0 p00 = M.n0.a(b0, r0.d.j, p0, 0);
            int v2 = p0.P;
            i0 i00 = p0.m();
            r0.q q2 = r0.a.d(p0, q1);
            P0.k.y.getClass();
            P0.i i0 = P0.j.b;
            p0.e0();
            if(p0.O) {
                p0.l(i0);
            }
            else {
                p0.o0();
            }
            P0.h h0 = P0.j.f;
            androidx.compose.runtime.w.x(p0, p00, h0);
            P0.h h1 = P0.j.e;
            androidx.compose.runtime.w.x(p0, i00, h1);
            P0.h h2 = P0.j.g;
            if(p0.O || !q.b(p0.N(), v2)) {
                A7.d.q(v2, p0, v2, h2);
            }
            P0.h h3 = P0.j.d;
            androidx.compose.runtime.w.x(p0, q2, h3);
            r0.q q3 = androidx.compose.foundation.layout.d.f(n0, 1.0f);
            p0 p01 = M.n0.a(b0, r0.d.k, p0, 0x30);
            int v3 = p0.P;
            i0 i01 = p0.m();
            r0.q q4 = r0.a.d(p0, q3);
            p0.e0();
            if(p0.O) {
                p0.l(i0);
            }
            else {
                p0.o0();
            }
            androidx.compose.runtime.w.x(p0, p01, h0);
            androidx.compose.runtime.w.x(p0, i01, h1);
            if(p0.O || !q.b(p0.N(), v3)) {
                A7.d.q(v3, p0, v3, h2);
            }
            androidx.compose.runtime.w.x(p0, q4, h3);
            int v4 = v1 << 3 & 0x70;
            c1.R(androidx.compose.foundation.layout.a.n(n0, 16.0f, 0.0f, 0.0f, 0.0f, 14), g0, 0L, false, null, p0, v4 | 0x6006, 12);
            c1.S(x.r(1.0f, androidx.compose.foundation.layout.d.t(androidx.compose.foundation.layout.d.f(androidx.compose.foundation.layout.a.n(n0, 10.0f, 0.0f, 0.0f, 0.0f, 14), 1.0f), 3), true), g0, 0L, 0L, z, z, z, p0, v4, 0, 7532);
            c1.Q(z, false, 0L, a0, null, p0, v1 << 6 & 0x1C00 | 0x30, 20);
            p0.p(true);
            p0.p(true);
        }
        else {
            p0.T();
        }
        n0 n00 = p0.t();
        if(n00 != null) {
            n00.d = new Ac.E(g0, a0, a1, v, 12);
        }
    }

    public static final RippleContainer m(ViewGroup viewGroup0) {
        int v = viewGroup0.getChildCount();
        for(int v1 = 0; v1 < v; ++v1) {
            View view0 = viewGroup0.getChildAt(v1);
            if(view0 instanceof RippleContainer) {
                return (RippleContainer)view0;
            }
        }
        RippleContainer rippleContainer0 = new RippleContainer(viewGroup0.getContext());
        viewGroup0.addView(rippleContainer0);
        return rippleContainer0;
    }

    public static final ViewGroup n(View view0) {
        while(!(view0 instanceof ViewGroup)) {
            ViewParent viewParent0 = view0.getParent();
            if(!(viewParent0 instanceof View)) {
                throw new IllegalArgumentException(("Couldn\'t find a valid parent for " + view0 + ". Are you overriding LocalView and providing a View that is not attached to the view hierarchy?").toString());
            }
            view0 = viewParent0;
        }
        return (ViewGroup)view0;
    }

    public abstract int o(ViewGroup.MarginLayoutParams arg1);

    public abstract float p(int arg1);

    public static float q(float f, float f1, float f2) {
        if(f < f1) {
            return f1;
        }
        return f > f2 ? f2 : f;
    }

    public static int r(int v, int v1, int v2) {
        if(v < v1) {
            return v1;
        }
        return v <= v2 ? v : v2;
    }

    public abstract boolean s(O0.f arg1);

    public static final float t(l l0, int v) {
        r1.c c0 = (r1.c)((p)l0).k(k0.h);
        return E9.w.T(((p)l0)).getDimension(v) / c0.b();
    }

    public static String u(androidx.datastore.preferences.protobuf.j j0) {
        StringBuilder stringBuilder0 = new StringBuilder(j0.size());
        for(int v = 0; v < j0.size(); ++v) {
            int v1 = j0.a(v);
            switch(v1) {
                case 7: {
                    stringBuilder0.append("\\a");
                    break;
                }
                case 8: {
                    stringBuilder0.append("\\b");
                    break;
                }
                case 9: {
                    stringBuilder0.append("\\t");
                    break;
                }
                case 10: {
                    stringBuilder0.append("\\n");
                    break;
                }
                case 11: {
                    stringBuilder0.append("\\v");
                    break;
                }
                case 12: {
                    stringBuilder0.append("\\f");
                    break;
                }
                case 13: {
                    stringBuilder0.append("\\r");
                    break;
                }
                case 34: {
                    stringBuilder0.append("\\\"");
                    break;
                }
                case 39: {
                    stringBuilder0.append("\\\'");
                    break;
                }
                case 92: {
                    stringBuilder0.append("\\\\");
                    break;
                }
                default: {
                    if(v1 < 0x20 || v1 > 0x7E) {
                        stringBuilder0.append('\\');
                        stringBuilder0.append(((char)((v1 >>> 6 & 3) + 0x30)));
                        stringBuilder0.append(((char)((v1 >>> 3 & 7) + 0x30)));
                        stringBuilder0.append(((char)((v1 & 7) + 0x30)));
                    }
                    else {
                        stringBuilder0.append(((char)v1));
                    }
                }
            }
        }
        return stringBuilder0.toString();
    }

    public static final Serializable v(DataInputStream dataInputStream0, byte b) {
        switch(b) {
            case 0: {
                return null;
            }
            case 1: {
                return Boolean.valueOf(dataInputStream0.readBoolean());
            }
            case 2: {
                return dataInputStream0.readByte();
            }
            case 3: {
                return dataInputStream0.readInt();
            }
            case 4: {
                return dataInputStream0.readLong();
            }
            case 5: {
                return dataInputStream0.readFloat();
            }
            case 6: {
                return dataInputStream0.readDouble();
            }
            default: {
                int v = 0;
                switch(b) {
                    case 7: {
                        return dataInputStream0.readUTF();
                    }
                    case 8: {
                        int v1 = dataInputStream0.readInt();
                        Serializable serializable0 = new Boolean[v1];
                        while(v < v1) {
                            serializable0[v] = Boolean.valueOf(dataInputStream0.readBoolean());
                            ++v;
                        }
                        return serializable0;
                    }
                    case 9: {
                        int v2 = dataInputStream0.readInt();
                        Serializable serializable1 = new Byte[v2];
                        while(v < v2) {
                            serializable1[v] = dataInputStream0.readByte();
                            ++v;
                        }
                        return serializable1;
                    }
                    case 10: {
                        int v3 = dataInputStream0.readInt();
                        Serializable serializable2 = new Integer[v3];
                        while(v < v3) {
                            serializable2[v] = dataInputStream0.readInt();
                            ++v;
                        }
                        return serializable2;
                    }
                    case 11: {
                        int v4 = dataInputStream0.readInt();
                        Serializable serializable3 = new Long[v4];
                        while(v < v4) {
                            serializable3[v] = dataInputStream0.readLong();
                            ++v;
                        }
                        return serializable3;
                    }
                    case 12: {
                        int v5 = dataInputStream0.readInt();
                        Serializable serializable4 = new Float[v5];
                        while(v < v5) {
                            serializable4[v] = dataInputStream0.readFloat();
                            ++v;
                        }
                        return serializable4;
                    }
                    case 13: {
                        int v6 = dataInputStream0.readInt();
                        Serializable serializable5 = new Double[v6];
                        while(v < v6) {
                            serializable5[v] = dataInputStream0.readDouble();
                            ++v;
                        }
                        return serializable5;
                    }
                    case 14: {
                        int v7 = dataInputStream0.readInt();
                        Serializable serializable6 = new String[v7];
                        while(v < v7) {
                            String s = dataInputStream0.readUTF();
                            if(q.b(s, "androidx.work.Data-95ed6082-b8e9-46e8-a73f-ff56f00f5d9d")) {
                                s = null;
                            }
                            serializable6[v] = s;
                            ++v;
                        }
                        return serializable6;
                    }
                    default: {
                        throw new IllegalStateException("Unsupported type " + ((int)b));
                    }
                }
            }
        }
    }

    public abstract Object w(O0.f arg1);

    public static final int x(Cursor cursor0, String s) {
        q.g(cursor0, "c");
        int v = cursor0.getColumnIndex(s);
        if(v >= 0) {
            return v;
        }
        int v1 = cursor0.getColumnIndex("`" + s + '`');
        return v1 < 0 ? -1 : v1;
    }

    public static final int y(Cursor cursor0, String s) {
        String s1;
        q.g(cursor0, "c");
        int v = h.x(cursor0, s);
        if(v >= 0) {
            return v;
        }
        try {
            String[] arr_s = cursor0.getColumnNames();
            q.f(arr_s, "getColumnNames(...)");
            s1 = je.n.r0(arr_s, null, null, null, null, 0x3F);
        }
        catch(Exception exception0) {
            Log.d("RoomCursorUtil", "Cannot collect column names for debug purposes", exception0);
            s1 = "unknown";
        }
        throw new IllegalArgumentException("column \'" + s + "\' does not exist. Available columns: " + s1);
    }

    public abstract int z(ViewGroup.MarginLayoutParams arg1);
}


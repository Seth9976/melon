package y8;

import A3.g;
import A8.M;
import Ac.F2;
import B3.L;
import B3.r;
import E8.f;
import I6.G0;
import I6.Q;
import I6.V;
import I6.Y;
import I6.b0;
import I6.p0;
import Ic.k;
import M6.B;
import Nb.A0;
import Nb.B0;
import Nb.C0;
import Nb.D0;
import Nb.E0;
import Nb.F0;
import Nb.H0;
import Tf.o;
import U4.D;
import U4.i;
import U4.y;
import Y3.d;
import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import android.text.Editable;
import android.text.Selection;
import android.text.TextUtils;
import android.util.Log;
import android.util.SparseArray;
import android.view.Choreographer;
import android.view.KeyEvent;
import android.view.View;
import android.widget.TextView;
import androidx.collection.K;
import androidx.collection.u;
import b3.E;
import b3.w;
import c7.a;
import c7.b;
import com.iloen.melon.playback.playlist.PlaylistId;
import com.iloen.melon.popup.OnClickListener;
import com.iloen.melon.utils.NameValuePairList;
import com.iloen.melon.utils.color.ColorUtils;
import com.iloen.melon.utils.color.DrawableColorUtils;
import com.iloen.melon.utils.log.LogU;
import com.iloen.melon.utils.system.ScreenUtils;
import com.iloen.melon.utils.system.ToastManager;
import com.iloen.melon.utils.ui.ViewUtils;
import d5.n;
import e3.h;
import e3.x;
import h4.G;
import ie.H;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.EOFException;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.ByteBuffer;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map.Entry;
import java.util.Map;
import java.util.NoSuchElementException;
import java.util.Set;
import java.util.UUID;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.TimeUnit;
import je.I;
import je.p;
import kc.d3;
import kc.s2;
import kc.x2;
import kotlin.jvm.internal.q;
import kotlinx.coroutines.flow.FlowKt;
import kotlinx.coroutines.guava.ListenableFutureKt;
import kotlinx.serialization.SerializationStrategy;
import kotlinx.serialization.json.Json;
import oc.O;
import oc.e;
import oc.z;
import oe.c;
import okhttp3.Headers;
import okhttp3.MediaType;
import okhttp3.RequestBody;
import okhttp3.Response;
import pc.t;
import s3.N;
import tg.m;
import v2.l;
import va.e0;

public final class s implements f, d, a, b, OnClickListener, m {
    public Object a;
    public Object b;
    public Object c;
    public static s d;

    public s(int v) {
        if(v != 16) {
            super();
            this.a = new u(16);
            this.b = new K();
            this.c = new h();  // 初始化器: Ljava/lang/Object;-><init>()V
            return;
        }
        super();
        this.a = new Object();
    }

    public s(Class class0) {
        UUID uUID0 = UUID.randomUUID();
        q.f(uUID0, "randomUUID()");
        this.a = uUID0;
        String s = ((UUID)this.a).toString();
        q.f(s, "id.toString()");
        this.b = new d5.q(s, null, class0.getName(), null, null, null, 0L, 0L, 0L, null, 0, 0, 0L, 0L, 0L, 0L, false, 0, 0, 0L, 0, 0, null, 0xFFFFFA);
        this.c = I.J(new String[]{class0.getName()});
    }

    public s(Object object0, Object object1, Object object2) {
        this.a = object0;
        this.b = object1;
        this.c = object2;
        super();
    }

    public s(ArrayDeque arrayDeque0, BufferedReader bufferedReader0) {
        this.b = arrayDeque0;
        this.a = bufferedReader0;
    }

    public s(List list0) {
        this.a = list0;
        this.b = new L[list0.size()];
        this.c = new androidx.recyclerview.widget.b(new com.iloen.melon.fragments.radio.a(this, 11));
    }

    public s(t t0) {
        this.a = t0;
        this.b = Choreographer.getInstance();
        this.c = new u2.a(this);
    }

    public static void a(s s0, Response response0) {
        BufferedWriter bufferedWriter0;
        if(response0.headers() == null) {
            return;
        }
        if(((File)s0.a).exists()) {
            ((File)s0.a).delete();
        }
        try {
            bufferedWriter0 = null;
            bufferedWriter0 = new BufferedWriter(new FileWriter(((File)s0.a)));
            Headers headers0 = response0.headers();
            for(Object object0: headers0.names()) {
                String s1 = (String)object0;
                String s2 = headers0.get(s1);
                if(!TextUtils.isEmpty(s1) && !TextUtils.isEmpty(s2)) {
                    bufferedWriter0.write(s1 + ":" + s2);
                    bufferedWriter0.newLine();
                }
            }
            s0.p();
        }
        catch(IOException unused_ex) {
            if(bufferedWriter0 != null) {
                try {
                    bufferedWriter0.close();
                    return;
                }
                catch(IOException unused_ex) {
                }
            }
            return;
        }
        catch(Throwable throwable0) {
            if(bufferedWriter0 != null) {
                try {
                    bufferedWriter0.close();
                }
                catch(IOException unused_ex) {
                }
            }
            throw throwable0;
        }
        try {
            bufferedWriter0.close();
        }
        catch(IOException unused_ex) {
        }
    }

    public y b() {
        y y0 = new y(((UUID)this.a), ((d5.q)this.b), ((Set)this.c));
        U4.d d0 = ((d5.q)this.b).j;
        boolean z = d0.b() || d0.e || d0.c || d0.d;
        d5.q q0 = (d5.q)this.b;
        if(q0.q) {
            if(z) {
                throw new IllegalArgumentException("Expedited jobs only support network and storage constraints");
            }
            if(q0.g > 0L) {
                throw new IllegalArgumentException("Expedited jobs cannot be delayed");
            }
        }
        if(q0.x == null) {
            List list0 = o.R0(q0.c, new String[]{"."}, 0, 6);
            String s = list0.size() == 1 ? ((String)list0.get(0)) : ((String)p.s0(list0));
            if(s.length() > 0x7F) {
                s = o.d1(0x7F, s);
            }
            q0.x = s;
        }
        UUID uUID0 = UUID.randomUUID();
        q.f(uUID0, "randomUUID()");
        this.a = uUID0;
        String s1 = uUID0.toString();
        q.f(s1, "id.toString()");
        d5.q q1 = (d5.q)this.b;
        q.g(q1, "other");
        D d1 = q1.b;
        i i0 = new i(q1.e);
        i i1 = new i(q1.f);
        long v = q1.g;
        U4.d d2 = new U4.d(q1.j);
        this.b = new d5.q(s1, d1, q1.c, q1.d, i0, i1, v, q1.h, q1.i, d2, q1.k, q1.l, q1.m, q1.n, q1.o, q1.p, q1.q, q1.r, q1.s, q1.u, q1.v, q1.w, q1.x, 0x80000);
        return y0;
    }

    public Object c(int v, c c0) {
        B0 b00;
        if(c0 instanceof B0) {
            b00 = (B0)c0;
            int v1 = b00.D;
            if((v1 & 0x80000000) == 0) {
                b00 = new B0(this, c0);
            }
            else {
                b00.D = v1 ^ 0x80000000;
            }
        }
        else {
            b00 = new B0(this, c0);
        }
        Object object0 = b00.w;
        ne.a a0 = ne.a.a;
        switch(b00.D) {
            case 0: {
                n.D(object0);
                B b0 = ListenableFutureKt.future$default(((d3)(((s2)this.b))).b, null, null, new x2(((d3)(((s2)this.b))), null), 3, null);
                b00.r = v;
                b00.D = 1;
                object0 = ListenableFutureKt.await(b0, b00);
                if(object0 == a0) {
                    return a0;
                }
                break;
            }
            case 1: {
                v = b00.r;
                n.D(object0);
                break;
            }
            default: {
                throw new IllegalStateException("call to \'resume\' before \'invoke\' with coroutine");
            }
        }
        if(((e)object0) instanceof oc.d) {
            ToastManager.show(v);
        }
        return H.a;
    }

    public static k3.f d(w w0) {
        g g0 = new g(7, 0);
        byte[] arr_b = null;
        g0.e = null;
        A3.c c0 = new A3.c((w0.b == null ? null : w0.b.toString()), w0.f, g0);
        Y y0 = w0.c;
        b0 b00 = y0.a;
        if(b00 == null) {
            b00 = y0.b();
            y0.a = b00;
        }
        G0 g00 = b00.k();
        while(g00.hasNext()) {
            Object object0 = g00.next();
            String s = (String)((Map.Entry)object0).getKey();
            String s1 = (String)((Map.Entry)object0).getValue();
            s.getClass();
            s1.getClass();
            synchronized(((HashMap)c0.d)) {
                ((HashMap)c0.d).put(s, s1);
            }
        }
        HashMap hashMap1 = new HashMap();
        Nf.p p0 = new Nf.p(-1);
        UUID uUID0 = w0.a;
        uUID0.getClass();
        boolean z = w0.d;
        boolean z1 = w0.e;
        int[] arr_v = ye.a.Y(w0.g);
        for(int v1 = 0; v1 < arr_v.length; ++v1) {
            boolean z2 = true;
            switch(arr_v[v1]) {
                case 1: 
                case 2: {
                    break;
                }
                default: {
                    z2 = false;
                }
            }
            e3.b.c(z2);
        }
        k3.f f0 = new k3.f(uUID0, c0, hashMap1, z, ((int[])arr_v.clone()), z1, p0);
        byte[] arr_b1 = w0.h;
        if(arr_b1 != null) {
            arr_b = Arrays.copyOf(arr_b1, arr_b1.length);
        }
        e3.b.j(f0.m.isEmpty());
        f0.v = arr_b;
        return f0;
    }

    public void e(B3.t t0, G g0) {
        L[] arr_l = (L[])this.b;
        for(int v = 0; v < arr_l.length; ++v) {
            g0.c();
            g0.d();
            L l0 = t0.track(g0.d, 3);
            androidx.media3.common.b b0 = (androidx.media3.common.b)((List)this.a).get(v);
            String s = b0.n;
            e3.b.d("application/cea-608".equals(s) || "application/cea-708".equals(s), "Invalid closed caption MIME type provided: " + s);
            String s1 = b0.a;
            if(s1 == null) {
                g0.d();
                s1 = g0.e;
            }
            b3.n n0 = new b3.n();
            n0.a = s1;
            n0.m = b3.H.l(s);
            n0.e = b0.e;
            n0.d = b0.d;
            n0.G = b0.H;
            n0.p = b0.q;
            l0.b(new androidx.media3.common.b(n0));
            arr_l[v] = l0;
        }
    }

    public static boolean f(Editable editable0, KeyEvent keyEvent0, boolean z) {
        if(KeyEvent.metaStateHasNoModifiers(keyEvent0.getMetaState())) {
            int v = Selection.getSelectionStart(editable0);
            int v1 = Selection.getSelectionEnd(editable0);
            if(v != -1 && v1 != -1 && v == v1) {
                v2.t[] arr_t = (v2.t[])editable0.getSpans(v, v1, v2.t.class);
                if(arr_t != null && arr_t.length > 0) {
                    for(int v2 = 0; v2 < arr_t.length; ++v2) {
                        v2.t t0 = arr_t[v2];
                        int v3 = editable0.getSpanStart(t0);
                        int v4 = editable0.getSpanEnd(t0);
                        if(z && v3 == v || !z && v4 == v || v > v3 && v < v4) {
                            editable0.delete(v3, v4);
                            return true;
                        }
                    }
                }
            }
        }
        return false;
    }

    public k3.o g(E e0) {
        e0.b.getClass();
        w w0 = e0.b.c;
        if(w0 == null) {
            return k3.o.a;
        }
        synchronized(this.a) {
            if(!w0.equals(((w)this.b))) {
                this.b = w0;
                this.c = s.d(w0);
            }
            k3.o o0 = (k3.f)this.c;
            o0.getClass();
            return o0;
        }
    }

    @Override  // Y3.d
    public List getCues(long v) {
        List list0 = (List)this.a;
        List list1 = new ArrayList();
        ArrayList arrayList0 = new ArrayList();
        for(int v2 = 0; v2 < list0.size(); ++v2) {
            long[] arr_v = (long[])this.b;
            if(arr_v[v2 * 2] <= v && v < arr_v[v2 * 2 + 1]) {
                g4.c c0 = (g4.c)list0.get(v2);
                d3.b b0 = c0.a;
                if(b0.e == -3.402823E+38f) {
                    arrayList0.add(c0);
                }
                else {
                    ((ArrayList)list1).add(b0);
                }
            }
        }
        Collections.sort(arrayList0, new E1.a(14));
        for(int v1 = 0; v1 < arrayList0.size(); ++v1) {
            d3.b b1 = ((g4.c)arrayList0.get(v1)).a;
            ((ArrayList)list1).add(new d3.b(b1.a, b1.b, b1.c, b1.d, ((float)(-1 - v1)), 1, b1.g, b1.h, b1.i, b1.n, b1.o, b1.j, b1.k, b1.l, b1.m, b1.p, b1.q));
        }
        return list1;
    }

    @Override  // Y3.d
    public long getEventTime(int v) {
        long[] arr_v = (long[])this.c;
        boolean z = false;
        e3.b.c(v >= 0);
        if(v < arr_v.length) {
            z = true;
        }
        e3.b.c(z);
        return arr_v[v];
    }

    @Override  // Y3.d
    public int getEventTimeCount() {
        return ((long[])this.c).length;
    }

    @Override  // Y3.d
    public int getNextEventTimeIndex(long v) {
        long[] arr_v = (long[])this.c;
        int v1 = x.a(arr_v, v, false);
        return v1 >= arr_v.length ? -1 : v1;
    }

    public long h() {
        B3.m m0 = (B3.m)this.c;
        return m0 == null ? -1L : m0.d;
    }

    public boolean i(CharSequence charSequence0, int v, int v1, v2.s s0) {
        if((s0.c & 3) == 0) {
            v2.e e0 = (v2.e)this.c;
            w2.a a0 = s0.b();
            int v2 = a0.a(8);
            if(v2 != 0) {
                ((ByteBuffer)a0.d).getShort(v2 + a0.a);
            }
            ((v2.c)e0).getClass();
            ThreadLocal threadLocal0 = v2.c.b;
            if(threadLocal0.get() == null) {
                threadLocal0.set(new StringBuilder());
            }
            StringBuilder stringBuilder0 = (StringBuilder)threadLocal0.get();
            stringBuilder0.setLength(0);
            while(v < v1) {
                stringBuilder0.append(charSequence0.charAt(v));
                ++v;
            }
            boolean z = ((v2.c)e0).a.hasGlyph(stringBuilder0.toString());
            int v3 = s0.c & 4;
            s0.c = z ? v3 | 2 : v3 | 1;
        }
        return (s0.c & 3) == 2;
    }

    public boolean j() {
        ArrayDeque arrayDeque0 = (ArrayDeque)this.b;
        if(((String)this.c) == null) {
            if(!arrayDeque0.isEmpty()) {
                String s = (String)arrayDeque0.poll();
                s.getClass();
                this.c = s;
                return true;
            }
            while(true) {
                String s1 = ((BufferedReader)this.a).readLine();
                this.c = s1;
                if(s1 == null) {
                    break;
                }
                String s2 = s1.trim();
                this.c = s2;
                if(s2.isEmpty()) {
                    continue;
                }
                return true;
            }
            return false;
        }
        return true;
    }

    public void k(g3.f f0, Uri uri0, Map map0, long v, long v1, N n0) {
        boolean z1;
        B3.m m0 = new B3.m(f0, v, v1);
        this.c = m0;
        if(((r)this.b) != null) {
            return;
        }
        r[] arr_r = ((B3.u)this.a).d(uri0, map0);
        I6.w.c(arr_r.length, "expectedSize");
        Q q0 = new Q(arr_r.length);  // 初始化器: LI6/N;-><init>(I)V
        boolean z = true;
        if(arr_r.length == 1) {
            this.b = arr_r[0];
            ((r)this.b).d(n0);
            return;
        }
        int v2 = 0;
        while(v2 < arr_r.length) {
            r r0 = arr_r[v2];
            try {
                if(r0.c(m0)) {
                    this.b = r0;
                    m0.f = 0;
                    break;
                }
                q0.d(r0.b());
            }
            catch(EOFException unused_ex) {
                z1 = ((r)this.b) != null || m0.d == v;
                goto label_32;
            }
            catch(Throwable throwable0) {
                if(((r)this.b) == null && m0.d != v) {
                    z = false;
                }
                e3.b.j(z);
                m0.f = 0;
                throw throwable0;
            }
            z1 = ((r)this.b) != null || m0.d == v;
        label_32:
            e3.b.j(z1);
            m0.f = 0;
            ++v2;
        }
        if(((r)this.b) != null) {
            ((r)this.b).d(n0);
            return;
        }
        B3.q q1 = new B3.q(", ");
        p0 p00 = V.q(arr_r);
        Iterator iterator0 = I6.w.w(new i3.d(26), p00).iterator();
        StringBuilder stringBuilder0 = new StringBuilder();
        q1.b(stringBuilder0, iterator0);
        uri0.getClass();
        p0 p01 = q0.g();
        H3.d d0 = new H3.d(1, "None of the available extractors (" + stringBuilder0.toString() + ") could read the stream.", null, false);  // 初始化器: Lb3/I;-><init>(ILjava/lang/String;Ljava/lang/Throwable;Z)V
        V.p(p01);
        throw d0;
    }

    @Override  // tg.m
    public Object l(Object object0) {
        A0.c c0 = (A0.c)this.c;
        MediaType mediaType0 = (MediaType)this.a;
        SerializationStrategy serializationStrategy0 = (SerializationStrategy)this.b;
        q.g(serializationStrategy0, "saver");
        RequestBody requestBody0 = RequestBody.create(mediaType0, ((Json)c0.b).encodeToString(serializationStrategy0, object0));
        q.f(requestBody0, "RequestBody.create(contentType, string)");
        return requestBody0;
    }

    public Object m(int v, c c0) {
        C0 c00;
        if(c0 instanceof C0) {
            c00 = (C0)c0;
            int v1 = c00.D;
            if((v1 & 0x80000000) == 0) {
                c00 = new C0(this, c0);
            }
            else {
                c00.D = v1 ^ 0x80000000;
            }
        }
        else {
            c00 = new C0(this, c0);
        }
        Object object0 = c00.w;
        ne.a a0 = ne.a.a;
        switch(c00.D) {
            case 0: {
                n.D(object0);
                B b0 = ((d3)(((s2)this.b))).g();
                c00.r = v;
                c00.D = 1;
                object0 = ListenableFutureKt.await(b0, c00);
                if(object0 == a0) {
                    return a0;
                }
                return ((oc.H)object0) instanceof z ? Boolean.valueOf(((z)(((oc.H)object0))).e().d().contains(new Integer(v))) : false;
            }
            case 1: {
                v = c00.r;
                n.D(object0);
                return ((oc.H)object0) instanceof z ? Boolean.valueOf(((z)(((oc.H)object0))).e().d().contains(new Integer(v))) : false;
            }
            default: {
                throw new IllegalStateException("call to \'resume\' before \'invoke\' with coroutine");
            }
        }
    }

    public boolean n() {
        return ((Ub.q)this.c).a().b;
    }

    public Object o(c c0) {
        D0 d00;
        if(c0 instanceof D0) {
            d00 = (D0)c0;
            int v = d00.B;
            if((v & 0x80000000) == 0) {
                d00 = new D0(this, c0);
            }
            else {
                d00.B = v ^ 0x80000000;
            }
        }
        else {
            d00 = new D0(this, c0);
        }
        Object object0 = d00.r;
        ne.a a0 = ne.a.a;
        switch(d00.B) {
            case 0: {
                n.D(object0);
                B b0 = ((d3)(((s2)this.b))).g();
                d00.B = 1;
                object0 = ListenableFutureKt.await(b0, d00);
                if(object0 == a0) {
                    return a0;
                }
                break;
            }
            case 1: {
                n.D(object0);
                break;
            }
            default: {
                throw new IllegalStateException("call to \'resume\' before \'invoke\' with coroutine");
            }
        }
        z z0 = ((oc.H)object0) instanceof z ? ((z)(((oc.H)object0))) : null;
        if(z0 != null) {
            O o0 = z0.e();
            return o0 == null ? Boolean.valueOf(((boolean)0)) : Boolean.valueOf(!o0.d().isEmpty());
        }
        return Boolean.valueOf(((boolean)0));
    }

    @Override  // com.iloen.melon.popup.OnClickListener
    public void onBuyClick(int v) {
        String s = (String)this.c;
        String s1 = (String)this.b;
        k k0 = (k)this.a;
        switch(v) {
            case 0: {
                Md.h h0 = k0.getDownloadHelper();
                h0.getClass();
                q.g(s, "menuId");
                LogU.info$default(h0.b, "downloadAlbumUnit() albumId: " + s1, null, true, 2, null);
                if(s1.length() == 0 || s.length() == 0) {
                    LogU.warn$default(h0.b, "downloadAlbumUnit() Invalid params", null, false, 6, null);
                    return;
                }
                if(!((e0)va.o.a()).m()) {
                    h0.d();
                    return;
                }
                NameValuePairList nameValuePairList0 = h0.a(s1, s, "", false);
                q.f(M.w, "ALBUM_DOWN_URL");
                h0.c(M.w, nameValuePairList0);
                return;
            }
            case 1: {
                k0.getDownloadHelper().b(s1, "FG1107", s);
                return;
            }
            case 2: {
                k0.getDownloadHelper().b(s1, "FG1109", s);
            }
        }
    }

    @Override  // c7.b
    public void onEvent(String s, Bundle bundle0) {
        CountDownLatch countDownLatch0 = (CountDownLatch)this.c;
        if(countDownLatch0 != null && "_ae".equals(s)) {
            countDownLatch0.countDown();
        }
    }

    public void p() {
        BufferedReader bufferedReader1;
        BufferedReader bufferedReader0;
        if(((File)this.a).exists()) {
            try {
                bufferedReader0 = null;
                bufferedReader1 = new BufferedReader(new FileReader(((File)this.a)));
                goto label_6;
            }
            catch(IOException unused_ex) {
                goto label_16;
            }
            catch(Throwable throwable0) {
            }
            goto label_21;
            try {
                while(true) {
                label_6:
                    String s = bufferedReader1.readLine();
                    if(s == null) {
                        goto label_24;
                    }
                    if(s.contains(":")) {
                        int v = s.indexOf(":");
                        if(v > 0 && v < s.length() - 1) {
                            String s1 = s.substring(v + 1, s.length());
                            if("ETag".equals(s.substring(0, v))) {
                                this.c = s1;
                            }
                        }
                    }
                }
            }
            catch(IOException unused_ex) {
                bufferedReader0 = bufferedReader1;
            label_16:
                if(bufferedReader0 != null) {
                    try {
                        bufferedReader0.close();
                        return;
                    }
                    catch(IOException unused_ex) {
                    }
                }
                return;
            }
            catch(Throwable throwable0) {
                bufferedReader0 = bufferedReader1;
            }
        label_21:
            if(bufferedReader0 != null) {
                try {
                    bufferedReader0.close();
                }
                catch(IOException unused_ex) {
                }
            }
            throw throwable0;
            try {
            label_24:
                bufferedReader1.close();
            }
            catch(IOException unused_ex) {
            }
        }
    }

    public String q() {
        if(!this.j()) {
            throw new NoSuchElementException();
        }
        String s = (String)this.c;
        this.c = null;
        return s;
    }

    public Object r(c c0) {
        E0 e00;
        if(c0 instanceof E0) {
            e00 = (E0)c0;
            int v = e00.B;
            if((v & 0x80000000) == 0) {
                e00 = new E0(this, c0);
            }
            else {
                e00.B = v ^ 0x80000000;
            }
        }
        else {
            e00 = new E0(this, c0);
        }
        Object object0 = e00.r;
        ne.a a0 = ne.a.a;
        switch(e00.B) {
            case 0: {
                n.D(object0);
                B b0 = ((d3)(((s2)this.b))).g();
                e00.B = 1;
                object0 = ListenableFutureKt.await(b0, e00);
                if(object0 == a0) {
                    return a0;
                }
                break;
            }
            case 1: {
                n.D(object0);
                break;
            }
            default: {
                throw new IllegalStateException("call to \'resume\' before \'invoke\' with coroutine");
            }
        }
        if(!e1.b.D(((oc.H)object0).getState())) {
            ((Qb.z)this.a).q();
            return H.a;
        }
        PlaylistId playlistId0 = ((oc.H)object0).getId();
        q.g(playlistId0, "playlistId");
        ToastManager.showShort((A0.a[playlistId0.ordinal()] == 1 ? 0x7F13082C : 0x7F13082B));  // string:playlist_empty_mv "재생할 비디오가 없습니다."
        return H.a;
    }

    public void s(View view0, boolean z, int v, int v1, int v2, int v3, int v4) {
        int v9;
        int v7;
        Context context0 = (Context)this.b;
        int v5 = ScreenUtils.dipToPixel(context0, 0.5f);
        TextView textView0 = (TextView)view0.findViewById(0x7F0A04A0);  // id:filter_name_tv
        View view1 = view0.findViewById(0x7F0A049E);  // id:filter_layout
        view0.setTag(0x7F1310F7, Boolean.valueOf(z));  // string:view_pressed_status "view pressed status"
        E8.c c0 = (E8.c)this.c;
        int v6 = 0x7F06017F;  // color:green502s_support_high_contrast
        if(z) {
            c0.getClass();
            v7 = 0x7F06017F;  // color:green502s_support_high_contrast
        }
        else {
            c0.getClass();
            v7 = 0x7F06048A;  // color:transparent
        }
        int v8 = ColorUtils.getColor(context0, v7);
        if(z) {
            c0.getClass();
            v9 = 0x7F0604A1;  // color:white000e
        }
        else {
            c0.getClass();
            v9 = 0x7F060163;  // color:gray700s
        }
        int v10 = ColorUtils.getColor(context0, v9);
        if(z) {
            c0.getClass();
        }
        else {
            c0.getClass();
            v6 = 0x7F060152;  // color:gray200a
        }
        DrawableColorUtils.changeDrawableStrokeColor(view1, v5, ColorUtils.getColor(context0, v6));
        DrawableColorUtils.changeDrawableInnerColor(view1, v8);
        textView0.setTextColor(v10);
        if(v == 0) {
            view0.setPadding(v2, 0, 0, 0);
        }
        else if(v == v1 - 1) {
            view0.setPadding(v4, 0, v3, 0);
        }
        else {
            view0.setPadding(v4, 0, 0, 0);
        }
        ViewUtils.setTabContentDescription(view0, textView0.getText().toString(), v + 1, v1, z);
    }

    // This method was un-flattened
    public Object t(CharSequence charSequence0, int v, int v1, int v2, boolean z, l l0) {
        int v6;
        m4.e e0 = new m4.e(((v2.p)((o9.b)this.b).c));
        int v3 = Character.codePointAt(charSequence0, v);
        int v4 = 0;
        boolean z1 = true;
        int v5 = v;
        while(true) {
            v6 = v5;
        label_6:
            if(v5 >= v1 || v4 >= v2 || !z1) {
                break;
            }
            SparseArray sparseArray0 = ((v2.p)e0.e).a;
            v2.p p0 = sparseArray0 == null ? null : ((v2.p)sparseArray0.get(v3));
            if(e0.a == 2) {
            label_17:
                if(p0 != null) {
                    e0.e = p0;
                    ++e0.c;
                    goto label_49;
                }
                else if(v3 == 0xFE0E) {
                    e0.b();
                }
                else if(v3 == 0xFE0F) {
                    goto label_49;
                }
                else {
                    v2.p p1 = (v2.p)e0.e;
                    if(p1.b == null) {
                    label_43:
                        e0.b();
                    }
                    else {
                        if(e0.c == 1) {
                            if(e0.c()) {
                                e0.f = (v2.p)e0.e;
                                e0.b();
                                goto label_36;
                            }
                            else {
                                e0.b();
                                goto label_44;
                            }
                            goto label_34;
                        }
                        else {
                        label_34:
                            e0.f = p1;
                            e0.b();
                        }
                    label_36:
                        e0.b = v3;
                        if(!z && this.i(charSequence0, v6, v5, ((v2.p)e0.f).b)) {
                            v6 = v5;
                            goto label_6;
                        }
                        else {
                            z1 = l0.e(charSequence0, v6, v5, ((v2.p)e0.f).b);
                            ++v4;
                            continue;
                        }
                        goto label_43;
                    }
                }
            }
            else {
                if(p0 == null) {
                    e0.b();
                    goto label_44;
                }
                else {
                    e0.a = 2;
                    e0.e = p0;
                    e0.c = 1;
                    goto label_49;
                }
                goto label_17;
            }
        label_44:
            e0.b = v3;
            v5 = Character.charCount(Character.codePointAt(charSequence0, v6)) + v6;
            if(v5 >= v1) {
                continue;
            }
            v3 = Character.codePointAt(charSequence0, v5);
            continue;
        label_49:
            e0.b = v3;
            int v7 = Character.charCount(v3) + v5;
            if(v7 < v1) {
                v3 = Character.codePointAt(charSequence0, v7);
            }
            v5 = v7;
            goto label_6;
        }
        if(e0.a == 2 && ((v2.p)e0.e).b != null && (e0.c > 1 || e0.c()) && v4 < v2 && z1 && (z || !this.i(charSequence0, v6, v5, ((v2.p)e0.e).b))) {
            l0.e(charSequence0, v6, v5, ((v2.p)e0.e).b);
        }
        return l0.getResult();
    }

    @Override  // c7.a
    public void u(Bundle bundle0) {
        synchronized(this.b) {
            b7.c c0 = b7.c.a;
            c0.e("Logging event _ae to Firebase Analytics with params " + bundle0);
            this.c = new CountDownLatch(1);
            ((androidx.lifecycle.b)this.a).u(bundle0);
            c0.e("Awaiting app exception callback from Analytics...");
            try {
                if(((CountDownLatch)this.c).await(500L, TimeUnit.MILLISECONDS)) {
                    c0.e("App exception callback received from Analytics listener.");
                }
                else {
                    c0.f("Timeout exceeded while awaiting app exception callback from Analytics listener.", null);
                }
            }
            catch(InterruptedException unused_ex) {
                Log.e("FirebaseCrashlytics", "Interrupted while awaiting app exception callback from Analytics listener.", null);
            }
            this.c = null;
        }
    }

    public void v() {
        Qb.z z0 = (Qb.z)this.a;
        LogU.info$default(z0.h, "resetResumeAfterGain()", null, false, 6, null);
        z0.f(new Qb.r(2, null));  // 初始化器: Loe/i;-><init>(ILkotlin/coroutines/Continuation;)V
    }

    public Object w(c c0) {
        oc.M m0;
        F0 f00;
        s2 s20 = (s2)this.b;
        if(c0 instanceof F0) {
            f00 = (F0)c0;
            int v = f00.B;
            if((v & 0x80000000) == 0) {
                f00 = new F0(this, c0);
            }
            else {
                f00.B = v ^ 0x80000000;
            }
        }
        else {
            f00 = new F0(this, c0);
        }
        Object object0 = f00.r;
        ne.a a0 = ne.a.a;
        switch(f00.B) {
            case 0: {
                n.D(object0);
                F2 f20 = ((d3)s20).d();
                f00.B = 1;
                object0 = FlowKt.first(f20, f00);
                if(object0 == a0) {
                    return a0;
                }
                break;
            }
            case 1: {
                n.D(object0);
                break;
            }
            case 2: {
                n.D(object0);
                return object0;
            }
            default: {
                throw new IllegalStateException("call to \'resume\' before \'invoke\' with coroutine");
            }
        }
        switch(((oc.M)object0).ordinal()) {
            case 1: {
                m0 = oc.M.c;
                break;
            }
            case 2: {
                m0 = oc.M.a;
                break;
            }
            default: {
                m0 = oc.M.b;
            }
        }
        B b0 = ((d3)s20).y(m0);
        f00.B = 2;
        Object object1 = ListenableFutureKt.await(b0, f00);
        return object1 == a0 ? a0 : object1;
    }

    public Object x(c c0) {
        Nb.G0 g00;
        s2 s20 = (s2)this.b;
        if(c0 instanceof Nb.G0) {
            g00 = (Nb.G0)c0;
            int v = g00.B;
            if((v & 0x80000000) == 0) {
                g00 = new Nb.G0(this, c0);
            }
            else {
                g00.B = v ^ 0x80000000;
            }
        }
        else {
            g00 = new Nb.G0(this, c0);
        }
        Object object0 = g00.r;
        ne.a a0 = ne.a.a;
        switch(g00.B) {
            case 0: {
                n.D(object0);
                F2 f20 = ((d3)s20).c();
                g00.B = 1;
                object0 = FlowKt.first(f20, g00);
                if(object0 == a0) {
                    return a0;
                }
                break;
            }
            case 1: {
                n.D(object0);
                break;
            }
            case 2: {
                n.D(object0);
                return object0;
            }
            default: {
                throw new IllegalStateException("call to \'resume\' before \'invoke\' with coroutine");
            }
        }
        B b0 = ((d3)s20).z(!((Boolean)object0).booleanValue());
        g00.B = 2;
        Object object1 = ListenableFutureKt.await(b0, g00);
        return object1 == a0 ? a0 : object1;
    }

    public Object y(c c0) {
        H0 h00;
        s2 s20 = (s2)this.b;
        if(c0 instanceof H0) {
            h00 = (H0)c0;
            int v = h00.B;
            if((v & 0x80000000) == 0) {
                h00 = new H0(this, c0);
            }
            else {
                h00.B = v ^ 0x80000000;
            }
        }
        else {
            h00 = new H0(this, c0);
        }
        Object object0 = h00.r;
        ne.a a0 = ne.a.a;
        H h0 = H.a;
        switch(h00.B) {
            case 0: {
                n.D(object0);
                B b0 = ((d3)s20).h();
                h00.B = 1;
                object0 = ListenableFutureKt.await(b0, h00);
                if(object0 == a0) {
                    return a0;
                }
                break;
            }
            case 1: {
                n.D(object0);
                break;
            }
            case 2: {
                n.D(object0);
                return h0;
            }
            default: {
                throw new IllegalStateException("call to \'resume\' before \'invoke\' with coroutine");
            }
        }
        if(!((PlaylistId)object0).isAudioType()) {
            if(this.n()) {
                ((Qb.z)this.a).r();
            }
            B b1 = ((d3)s20).b();
            h00.B = 2;
            if(ListenableFutureKt.await(b1, h00) == a0) {
                return a0;
            }
        }
        return h0;
    }
}


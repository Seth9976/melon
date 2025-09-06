package x9;

import A3.g;
import Ac.F2;
import Hf.B;
import Hf.x;
import I6.V;
import Je.o;
import M6.t;
import Me.N;
import Me.e;
import Me.w;
import Me.z;
import P6.a;
import Pe.S;
import android.net.Uri;
import android.os.Bundle;
import android.os.SystemClock;
import android.text.Spannable;
import android.text.SpannableString;
import androidx.collection.u;
import androidx.media3.session.d0;
import androidx.media3.session.r;
import androidx.media3.session.u1;
import androidx.media3.session.x0;
import b3.E;
import c1.d;
import com.iloen.melon.net.HttpResponse;
import com.iloen.melon.net.v6x.response.ArtistMusicRecmtrackSongListRes;
import com.iloen.melon.net.v6x.response.MusicDnaMonthListRes;
import com.iloen.melon.utils.log.LogU;
import d5.n;
import e3.h;
import i.n.i.b.a.s.e.F3;
import i.n.i.b.a.s.e.L7;
import i.n.i.b.a.s.e.M7;
import i.n.i.b.a.s.e.T4;
import ib.j;
import ie.H;
import ie.m;
import java.io.Serializable;
import java.security.GeneralSecurityException;
import java.security.InvalidAlgorithmParameterException;
import java.security.SecureRandom;
import java.security.spec.AlgorithmParameterSpec;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import javax.crypto.Cipher;
import javax.crypto.spec.SecretKeySpec;
import je.C;
import je.D;
import je.p;
import kc.X1;
import kc.Z1;
import kc.d2;
import kc.e2;
import kc.f2;
import kc.g2;
import kotlin.jvm.internal.q;
import kotlinx.coroutines.flow.Flow;
import kotlinx.coroutines.flow.FlowKt;
import l2.i;
import nf.f;
import oc.M;
import oe.c;
import v2.l;
import v2.s;
import v2.v;
import va.e0;
import vf.A;
import vf.k;
import vf.y;

public final class b implements t, d, T4, l, w3.l {
    public Object a;
    public Object b;

    public b(int v) {
        if(v != 8) {
            super();
            this.a = new h();  // 初始化器: Ljava/lang/Object;-><init>()V
            this.b = new u(16);
            return;
        }
        super();
        this.a = new HashMap();
    }

    public b(z z0, com.google.firebase.messaging.u u0) {
        q.g(z0, "module");
        q.g(u0, "notFoundClasses");
        super();
        this.a = z0;
        this.b = u0;
    }

    public b(Object object0, Object object1) {
        this.a = object0;
        this.b = object1;
        super();
    }

    public b(byte[] arr_b) {
        Boolean boolean0;
        byte[] arr_b1 = new byte[0];
        System.arraycopy(new byte[0], 0, arr_b1, 0, 0);
        super();
        if(a.b.get()) {
            try {
                boolean0 = (Boolean)Class.forName("org.conscrypt.Conscrypt").getMethod("isBoringSslFIPSBuild", null).invoke(null, null);
            }
            catch(Exception unused_ex) {
                a.a.info("Conscrypt is not available or does not support checking for FIPS build.");
                boolean0 = Boolean.FALSE;
            }
            if(!boolean0.booleanValue()) {
                throw new GeneralSecurityException("Can not use AES-GCM in FIPS-mode, as BoringCrypto module is not available.");
            }
        }
        if(arr_b.length != 16 && arr_b.length != 0x20) {
            throw new InvalidAlgorithmParameterException(String.format("invalid key size %d; only 128-bit and 256-bit AES keys are supported", ((int)(arr_b.length * 8))));
        }
        this.a = new SecretKeySpec(arr_b, "AES");
        byte[] arr_b2 = new byte[0];
        System.arraycopy(arr_b1, 0, arr_b2, 0, 0);
        this.b = arr_b2;
    }

    @Override  // i.n.i.b.a.s.e.T4
    public int a() {
        return ((long[])this.b).length;
    }

    @Override  // i.n.i.b.a.s.e.T4
    public int a(long v) {
        long[] arr_v = (long[])this.b;
        int v1 = L7.g(arr_v, v, false);
        return v1 >= arr_v.length ? -1 : v1;
    }

    @Override  // i.n.i.b.a.s.e.T4
    public long a(int v) {
        long[] arr_v = (long[])this.b;
        boolean z = false;
        M7.u(v >= 0);
        if(v < arr_v.length) {
            z = true;
        }
        M7.u(z);
        return arr_v[v];
    }

    @Override  // c1.d
    public int b(int v) {
        CharSequence charSequence0 = (CharSequence)this.a;
        while(true) {
            v = ((g)this.b).x(v);
            if(v == -1 || v == charSequence0.length()) {
                break;
            }
            if(!Character.isWhitespace(charSequence0.charAt(v))) {
                return v;
            }
        }
        return -1;
    }

    @Override  // i.n.i.b.a.s.e.T4
    public List b(long v) {
        int v1 = L7.y(((long[])this.b), v, false);
        if(v1 != -1) {
            F3 f30 = ((F3[])this.a)[v1];
            return f30 == F3.s ? Collections.EMPTY_LIST : Collections.singletonList(f30);
        }
        return Collections.EMPTY_LIST;
    }

    @Override  // c1.d
    public int c(int v) {
        do {
            v = ((g)this.b).y(v);
            if(v == -1) {
                return -1;
            }
        }
        while(Character.isWhitespace(((CharSequence)this.a).charAt(v)));
        return v;
    }

    @Override  // c1.d
    public int d(int v) {
        do {
            v = ((g)this.b).x(v);
            if(v == -1) {
                return -1;
            }
        }
        while(Character.isWhitespace(((CharSequence)this.a).charAt(v - 1)));
        return v;
    }

    @Override  // v2.l
    public boolean e(CharSequence charSequence0, int v, int v1, s s0) {
        if((s0.c & 4) > 0) {
            return true;
        }
        if(((v)this.a) == null) {
            Spannable spannable0 = charSequence0 instanceof Spannable ? ((Spannable)charSequence0) : new SpannableString(charSequence0);
            this.a = new v(spannable0);
        }
        ((h)this.b).getClass();
        v2.t t0 = new v2.t(s0);
        ((v)this.a).setSpan(t0, v, v1, 33);
        return true;
    }

    @Override  // w3.l
    public m3.l f(Uri uri0, g3.h h0) {
        m3.l l0 = ((w3.l)this.a).f(uri0, h0);
        List list0 = (List)this.b;
        return list0 == null || list0.isEmpty() ? l0 : ((m3.l)l0.a(list0));
    }

    @Override  // c1.d
    public int g(int v) {
        while(true) {
            v = ((g)this.b).y(v);
            if(v == -1 || v == 0) {
                break;
            }
            if(!Character.isWhitespace(((CharSequence)this.a).charAt(v - 1))) {
                return v;
            }
        }
        return -1;
    }

    @Override  // v2.l
    public Object getResult() {
        return (v)this.a;
    }

    public Object h(c c0) {
        LogU logU1;
        X1 x10;
        if(c0 instanceof X1) {
            x10 = (X1)c0;
            int v = x10.D;
            if((v & 0x80000000) == 0) {
                x10 = new X1(this, c0);
            }
            else {
                x10.D = v ^ 0x80000000;
            }
        }
        else {
            x10 = new X1(this, c0);
        }
        Object object0 = x10.w;
        ne.a a0 = ne.a.a;
        switch(x10.D) {
            case 0: {
                n.D(object0);
                LogU logU0 = (LogU)this.b;
                Flow flow0 = ((i)this.a).getData();
                x10.r = logU0;
                x10.D = 1;
                Object object1 = FlowKt.first(flow0, x10);
                if(object1 == a0) {
                    return a0;
                }
                logU1 = logU0;
                object0 = object1;
                break;
            }
            case 1: {
                logU1 = x10.r;
                n.D(object0);
                break;
            }
            default: {
                throw new IllegalStateException("call to \'resume\' before \'invoke\' with coroutine");
            }
        }
        LogU.debug$default(logU1, "debugAfterUpdate() " + object0, null, false, 6, null);
        return H.a;
    }

    public byte[] i(byte[] arr_b, byte[] arr_b1) {
        byte[] arr_b2 = (byte[])this.b;
        if(arr_b == null) {
            throw new NullPointerException("ciphertext is null");
        }
        if(arr_b.length < arr_b2.length + 28) {
            throw new GeneralSecurityException("ciphertext too short");
        }
        if(arr_b.length < arr_b2.length) {
            throw new GeneralSecurityException("Decryption failed (OutputPrefix mismatch).");
        }
        for(int v = 0; v < arr_b2.length; ++v) {
            if(arr_b[v] != arr_b2[v]) {
                throw new GeneralSecurityException("Decryption failed (OutputPrefix mismatch).");
            }
        }
        AlgorithmParameterSpec algorithmParameterSpec0 = O6.a.a(arr_b, arr_b2.length, 12);
        Cipher cipher0 = (Cipher)O6.a.a.get();
        cipher0.init(2, ((SecretKeySpec)this.a), algorithmParameterSpec0);
        if(arr_b1 != null && arr_b1.length != 0) {
            cipher0.updateAAD(arr_b1);
        }
        return cipher0.doFinal(arr_b, arr_b2.length + 12, arr_b.length - arr_b2.length - 12);
    }

    public Ne.c j(lf.h h0, f f0) {
        q.g(h0, "proto");
        q.g(f0, "nameResolver");
        qf.b b0 = Q1.c.z(f0, h0.c);
        e e0 = w.f(((z)this.a), b0, ((com.google.firebase.messaging.u)this.b));
        if(h0.d.size() != 0 && !Jf.l.f(e0) && tf.e.m(e0, Me.f.e)) {
            Collection collection0 = e0.s();
            q.f(collection0, "getConstructors(...)");
            Pe.i i0 = (Pe.i)p.F0(collection0);
            if(i0 != null) {
                List list0 = i0.F();
                q.f(list0, "getValueParameters(...)");
                int v = D.N(je.q.Q(10, list0));
                if(v < 16) {
                    v = 16;
                }
                LinkedHashMap linkedHashMap0 = new LinkedHashMap(v);
                for(Object object0: list0) {
                    linkedHashMap0.put(((S)object0).getName(), object0);
                }
                List list1 = h0.d;
                q.f(list1, "getArgumentList(...)");
                ArrayList arrayList0 = new ArrayList();
                for(Object object1: list1) {
                    lf.f f1 = (lf.f)object1;
                    q.d(f1);
                    S s0 = (S)linkedHashMap0.get(Q1.c.B(f0, f1.c));
                    vf.g g0 = null;
                    if(s0 != null) {
                        qf.e e1 = Q1.c.B(f0, f1.c);
                        x x0 = s0.getType();
                        q.f(x0, "getType(...)");
                        lf.e e2 = f1.d;
                        q.f(e2, "getValue(...)");
                        vf.g g1 = this.u(x0, e2, f0);
                        if(this.k(g1, x0, e2)) {
                            g0 = g1;
                        }
                        if(g0 == null) {
                            String s1 = "Unexpected argument value: actual type " + e2.c + " != expected type " + x0;
                            q.g(s1, "message");
                            g0 = new k(s1);
                        }
                        g0 = new m(e1, g0);
                    }
                    if(g0 != null) {
                        arrayList0.add(g0);
                    }
                }
                Map map0 = C.Y(arrayList0);
                return new Ne.c(e0.g(), map0, N.q);
            }
        }
        return new Ne.c(e0.g(), je.x.a, N.q);
    }

    public boolean k(vf.g g0, x x0, lf.e e0) {
        z z0 = (z)this.a;
        switch((e0.c == null ? -1 : Df.b.a[e0.c.ordinal()])) {
            case 10: {
                Me.h h0 = x0.w().e();
                e e1 = h0 instanceof e ? ((e)h0) : null;
                return e1 == null || Je.i.b(e1, o.Q);
            }
            case 13: {
                if(!(g0 instanceof vf.b) || ((List)((vf.b)g0).a).size() != e0.k.size()) {
                    throw new IllegalStateException(("Deserialized ArrayValue should have the same number of elements as the original array value: " + g0).toString());
                }
                x x1 = z0.d().g(x0);
                if(x1 != null) {
                    Ce.g g1 = e.k.r(((Collection)((vf.b)g0).a));
                    if(!(g1 instanceof Collection) || !((Collection)g1).isEmpty()) {
                        Ce.f f0 = g1.b();
                        while(f0.c) {
                            int v = f0.nextInt();
                            vf.g g2 = (vf.g)((List)((vf.b)g0).a).get(v);
                            lf.e e2 = (lf.e)e0.k.get(v);
                            q.f(e2, "getArrayElement(...)");
                            if(!this.k(g2, x1, e2)) {
                                return false;
                            }
                            if(false) {
                                break;
                            }
                        }
                    }
                    return true;
                }
                return false;
            }
            default: {
                return q.b(g0.a(z0), x0);
            }
        }
    }

    public byte[] l(byte[] arr_b, byte[] arr_b1) {
        byte[] arr_b2 = (byte[])this.b;
        if(arr_b == null) {
            throw new NullPointerException("plaintext is null");
        }
        byte[] arr_b3 = new byte[12];
        ((SecureRandom)Q6.b.a.get()).nextBytes(arr_b3);
        AlgorithmParameterSpec algorithmParameterSpec0 = O6.a.a(arr_b3, 0, 12);
        Object object0 = O6.a.a.get();
        ((Cipher)object0).init(1, ((SecretKeySpec)this.a), algorithmParameterSpec0);
        if(arr_b1 != null && arr_b1.length != 0) {
            ((Cipher)object0).updateAAD(arr_b1);
        }
        int v = ((Cipher)object0).getOutputSize(arr_b.length);
        if(v > 0x7FFFFFF3 - arr_b2.length) {
            throw new GeneralSecurityException("plaintext too long");
        }
        byte[] arr_b4 = Arrays.copyOf(arr_b2, arr_b2.length + 12 + v);
        System.arraycopy(arr_b3, 0, arr_b4, arr_b2.length, 12);
        if(((Cipher)object0).doFinal(arr_b, 0, arr_b.length, arr_b4, arr_b2.length + 12) != v) {
            throw new GeneralSecurityException("not enough data written");
        }
        return arr_b4;
    }

    public Serializable m(String s, String s1, c c0) {
        ib.g g0;
        if(c0 instanceof ib.g) {
            g0 = (ib.g)c0;
            int v = g0.B;
            if((v & 0x80000000) == 0) {
                g0 = new ib.g(this, c0);
            }
            else {
                g0.B = v ^ 0x80000000;
            }
        }
        else {
            g0 = new ib.g(this, c0);
        }
        Serializable serializable0 = g0.r;
        Serializable serializable1 = ne.a.a;
        switch(g0.B) {
            case 0: {
                n.D(serializable0);
                try {
                    g0.B = 1;
                    serializable0 = ((V9.c)this.b).b(s, s1, g0);
                    if(serializable0 == serializable1) {
                        return serializable1;
                    label_18:
                        n.D(serializable0);
                    }
                    return (ArtistMusicRecmtrackSongListRes)serializable0;
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

    public F2 n() {
        return new F2(FlowKt.catch(((i)this.a).getData(), new Z1(this, null, 0)), 21);
    }

    public F2 o() {
        return new F2(FlowKt.catch(((i)this.a).getData(), new Z1(this, null, 1)), 22);
    }

    @Override  // M6.t
    public void onFailure(Throwable throwable0) {
        M6.H h0 = (M6.H)this.a;
        d0 d00 = (d0)this.b;
        h0.k(new r(-1, SystemClock.elapsedRealtime(), d00, new u1("no error message provided", -1, Bundle.EMPTY), null, 4));
        e3.b.q("MediaSessionImpl", "Failed fetching recent media item at boot time: " + throwable0.getMessage(), throwable0);
    }

    @Override  // M6.t
    public void onSuccess(Object object0) {
        d0 d00 = (d0)this.b;
        M6.H h0 = (M6.H)this.a;
        V v0 = ((x0)object0).a;
        if(v0.isEmpty()) {
            h0.k(new r(-2, SystemClock.elapsedRealtime(), d00, new u1("no error message provided", -2, Bundle.EMPTY), null, 4));
            return;
        }
        h0.k(r.c(V.t(((E)v0.get(Math.max(0, Math.min(((x0)object0).b, v0.size() - 1))))), d00));
    }

    public Serializable p(c c0) {
        ib.h h0;
        if(c0 instanceof ib.h) {
            h0 = (ib.h)c0;
            int v = h0.B;
            if((v & 0x80000000) == 0) {
                h0 = new ib.h(this, c0);
            }
            else {
                h0.B = v ^ 0x80000000;
            }
        }
        else {
            h0 = new ib.h(this, c0);
        }
        Object object0 = h0.r;
        Serializable serializable0 = ne.a.a;
        switch(h0.B) {
            case 0: {
                n.D(object0);
                try {
                    h0.B = 1;
                    object0 = ((ra.h)this.a).a.a.f(e1.u.w(((e0)va.o.a()).j()), h0);
                    if(object0 == serializable0) {
                        return serializable0;
                    label_18:
                        n.D(object0);
                    }
                    return (MusicDnaMonthListRes)object0;
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

    public Object q(String s, c c0) {
        ib.i i0;
        if(c0 instanceof ib.i) {
            i0 = (ib.i)c0;
            int v = i0.B;
            if((v & 0x80000000) == 0) {
                i0 = new ib.i(this, c0);
            }
            else {
                i0.B = v ^ 0x80000000;
            }
        }
        else {
            i0 = new ib.i(this, c0);
        }
        Serializable serializable0 = i0.r;
        ne.a a0 = ne.a.a;
        switch(i0.B) {
            case 0: {
                n.D(serializable0);
                try {
                    i0.B = 1;
                    serializable0 = ((ra.h)this.a).d(s, i0);
                    if(serializable0 == a0) {
                        return a0;
                    label_18:
                        n.D(serializable0);
                    }
                    return new Na.e(serializable0);
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

    public Serializable r(c c0) {
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
                n.D(object0);
                try {
                    j0.B = 1;
                    object0 = ((ra.h)this.a).a.a.c(e1.u.w(((e0)va.o.a()).j()), j0);
                    if(object0 == serializable0) {
                        return serializable0;
                    label_18:
                        n.D(object0);
                    }
                    return (MusicDnaMonthListRes)object0;
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

    public Map s() {
        synchronized(this) {
            if(((Map)this.b) == null) {
                this.b = Collections.unmodifiableMap(new HashMap(((HashMap)this.a)));
            }
            return (Map)this.b;
        }
    }

    public Object t(String s, String s1, c c0) {
        hb.r r0;
        if(c0 instanceof hb.r) {
            r0 = (hb.r)c0;
            int v = r0.B;
            if((v & 0x80000000) == 0) {
                r0 = new hb.r(this, c0);
            }
            else {
                r0.B = v ^ 0x80000000;
            }
        }
        else {
            r0 = new hb.r(this, c0);
        }
        Object object0 = r0.r;
        ne.a a0 = ne.a.a;
        switch(r0.B) {
            case 0: {
                n.D(object0);
                try {
                    d5.v v1 = (d5.v)this.a;
                    String s2 = e1.u.w(((e0)(((mb.k)this.b))).j());
                    r0.B = 1;
                    object0 = v1.R(s, s1, s2, r0);
                    if(object0 == a0) {
                        return a0;
                    label_20:
                        n.D(object0);
                    }
                    return new Na.e(((HttpResponse)object0));
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

    public vf.g u(x x0, lf.e e0, f f0) {
        q.g(e0, "value");
        q.g(f0, "nameResolver");
        boolean z = nf.d.P.e(e0.m).booleanValue();
        switch((e0.c == null ? -1 : Df.b.a[e0.c.ordinal()])) {
            case 1: {
                int v = (byte)(((int)e0.d));
                return z ? new A(((byte)v)) : new vf.d(((byte)v));
            }
            case 2: {
                return new vf.e(Character.valueOf(((char)(((int)e0.d)))));  // 初始化器: Lvf/g;-><init>(Ljava/lang/Object;)V
            }
            case 3: {
                int v1 = (short)(((int)e0.d));
                return z ? new A(((short)v1)) : new vf.x(((short)v1));
            }
            case 4: {
                int v2 = (int)e0.d;
                return z ? new A(v2) : new vf.l(v2);
            }
            case 5: {
                long v3 = e0.d;
                return z ? new A(v3) : new vf.v(v3);
            }
            case 6: {
                return new vf.c(e0.e);
            }
            case 7: {
                return new vf.c(e0.f);
            }
            case 8: {
                return e0.d == 0L ? new vf.c(Boolean.FALSE) : new vf.c(Boolean.TRUE);
            }
            case 9: {
                return new y(f0.getString(e0.g));  // 初始化器: Lvf/g;-><init>(Ljava/lang/Object;)V
            }
            case 10: {
                return new vf.u(Q1.c.z(f0, e0.h), e0.l);
            }
            case 11: {
                return new vf.j(Q1.c.z(f0, e0.h), Q1.c.B(f0, e0.i));
            }
            case 12: {
                lf.h h0 = e0.j;
                q.f(h0, "getAnnotation(...)");
                return new vf.a(this.j(h0, f0));  // 初始化器: Lvf/g;-><init>(Ljava/lang/Object;)V
            }
            case 13: {
                List list0 = e0.k;
                q.f(list0, "getArrayElementList(...)");
                ArrayList arrayList0 = new ArrayList(je.q.Q(10, list0));
                for(Object object0: list0) {
                    B b0 = ((z)this.a).d().e();
                    q.d(((lf.e)object0));
                    arrayList0.add(this.u(b0, ((lf.e)object0), f0));
                }
                return new vf.z(arrayList0, x0);
            }
            default: {
                throw new IllegalStateException(("Unsupported annotation argument type: " + e0.c + " (expected " + x0 + ')').toString());
            }
        }
    }

    public Object v(M m0, c c0) {
        d2 d20;
        if(c0 instanceof d2) {
            d20 = (d2)c0;
            int v = d20.B;
            if((v & 0x80000000) == 0) {
                d20 = new d2(this, c0);
            }
            else {
                d20.B = v ^ 0x80000000;
            }
        }
        else {
            d20 = new d2(this, c0);
        }
        Object object0 = d20.r;
        ne.a a0 = ne.a.a;
        switch(d20.B) {
            case 0: {
                n.D(object0);
                i i0 = (i)this.a;
                e2 e20 = new e2(m0, null);
                d20.B = 1;
                if(i0.a(e20, d20) == a0) {
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
                return H.a;
            }
            default: {
                throw new IllegalStateException("call to \'resume\' before \'invoke\' with coroutine");
            }
        }
        d20.B = 2;
        return this.h(d20) == a0 ? a0 : H.a;
    }

    public Object w(boolean z, c c0) {
        f2 f20;
        if(c0 instanceof f2) {
            f20 = (f2)c0;
            int v = f20.D;
            if((v & 0x80000000) == 0) {
                f20 = new f2(this, c0);
            }
            else {
                f20.D = v ^ 0x80000000;
            }
        }
        else {
            f20 = new f2(this, c0);
        }
        Object object0 = f20.w;
        ne.a a0 = ne.a.a;
        switch(f20.D) {
            case 0: {
                n.D(object0);
                i i0 = (i)this.a;
                g2 g20 = new g2(z, null);
                f20.r = z;
                f20.D = 1;
                if(i0.a(g20, f20) == a0) {
                    return a0;
                }
                break;
            }
            case 1: {
                z = f20.r;
                n.D(object0);
                break;
            }
            case 2: {
                n.D(object0);
                return H.a;
            }
            default: {
                throw new IllegalStateException("call to \'resume\' before \'invoke\' with coroutine");
            }
        }
        LogU.debug$default(((LogU)this.b), "setIsShuffle() " + z, null, false, 6, null);
        f20.r = z;
        f20.D = 2;
        return this.h(f20) == a0 ? a0 : H.a;
    }
}


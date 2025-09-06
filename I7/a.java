package i7;

import android.util.Base64;
import android.util.JsonReader;
import h7.A0;
import h7.A;
import h7.B0;
import h7.B;
import h7.C0;
import h7.C;
import h7.D0;
import h7.D;
import h7.E0;
import h7.E;
import h7.F0;
import h7.F;
import h7.G0;
import h7.G;
import h7.H0;
import h7.H;
import h7.I0;
import h7.I;
import h7.J0;
import h7.J;
import h7.K0;
import h7.K;
import h7.L0;
import h7.L;
import h7.M0;
import h7.M;
import h7.N0;
import h7.N;
import h7.O0;
import h7.O;
import h7.P;
import h7.Q;
import h7.S;
import h7.T;
import h7.U;
import h7.V;
import h7.W;
import h7.X;
import h7.Y;
import h7.Z;
import h7.a0;
import h7.b0;
import h7.b;
import h7.c0;
import h7.c;
import h7.d0;
import h7.e0;
import h7.f0;
import h7.f;
import h7.g0;
import h7.g;
import h7.h0;
import h7.h;
import h7.i0;
import h7.i;
import h7.j0;
import h7.j;
import h7.k0;
import h7.k;
import h7.l;
import h7.m;
import h7.n;
import h7.o;
import h7.p0;
import h7.p;
import h7.q0;
import h7.q;
import h7.r0;
import h7.r;
import h7.s0;
import h7.s;
import h7.t0;
import h7.u0;
import h7.u;
import h7.v0;
import h7.v;
import h7.w0;
import h7.w;
import h7.x0;
import h7.x;
import h7.y0;
import h7.y;
import h7.z0;
import h7.z;
import java.io.IOException;
import java.io.StringReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import pc.t;
import r7.e;
import t7.d;

public final class a {
    public static final t a;

    static {
        d d0 = new d();
        d0.a(O0.class, h7.d.a);
        d0.a(B.class, h7.d.a);
        d0.a(N0.class, j.a);
        d0.a(J.class, j.a);
        d0.a(v0.class, g.a);
        d0.a(K.class, g.a);
        d0.a(u0.class, h.a);
        d0.a(L.class, h.a);
        d0.a(M0.class, (/* 缺少Lambda参数 */, z this) -> ((e)object1).a(z.b, ((k0)(((M0)object0))).a));
        d0.a(k0.class, (/* 缺少Lambda参数 */, z this) -> ((e)object1).a(z.b, ((k0)(((M0)object0))).a));
        d0.a(L0.class, y.a);
        d0.a(j0.class, y.a);
        d0.a(w0.class, i.a);
        d0.a(N.class, i.a);
        d0.a(K0.class, h7.t.a);
        d0.a(P.class, h7.t.a);
        d0.a(E0.class, k.a);
        d0.a(Q.class, k.a);
        d0.a(C0.class, m.a);
        d0.a(S.class, m.a);
        d0.a(B0.class, p.a);
        d0.a(W.class, p.a);
        d0.a(A0.class, q.a);
        d0.a(Y.class, q.a);
        d0.a(y0.class, n.a);
        d0.a(U.class, n.a);
        d0.a(q0.class, b.a);
        d0.a(D.class, b.a);
        d0.a(p0.class, h7.a.a);
        d0.a(E.class, h7.a.a);
        d0.a(z0.class, o.a);
        d0.a(V.class, o.a);
        d0.a(x0.class, l.a);
        d0.a(T.class, l.a);
        d0.a(r0.class, c.a);
        d0.a(F.class, c.a);
        d0.a(D0.class, r.a);
        d0.a(a0.class, r.a);
        d0.a(F0.class, s.a);
        d0.a(c0.class, s.a);
        d0.a(G0.class, (/* 缺少Lambda参数 */, u this) -> ((e)object1).a(u.b, ((d0)(((G0)object0))).a));
        d0.a(d0.class, (/* 缺少Lambda参数 */, u this) -> ((e)object1).a(u.b, ((d0)(((G0)object0))).a));
        d0.a(J0.class, (/* 缺少Lambda参数 */, x this) -> ((e)object1).a(x.b, ((h0)(((J0)object0))).a));
        d0.a(h0.class, (/* 缺少Lambda参数 */, x this) -> ((e)object1).a(x.b, ((h0)(((J0)object0))).a));
        d0.a(I0.class, v.a);
        d0.a(f0.class, v.a);
        d0.a(H0.class, w.a);
        d0.a(g0.class, w.a);
        d0.a(t0.class, h7.e.a);
        d0.a(G.class, h7.e.a);
        d0.a(s0.class, f.a);
        d0.a(H.class, f.a);
        d0.d = true;
        a.a = new t(d0, 15);
    }

    public static Y a(JsonReader jsonReader0) {
        X x0 = new X();  // 初始化器: Ljava/lang/Object;-><init>()V
        jsonReader0.beginObject();
        while(jsonReader0.hasNext()) {
            String s = jsonReader0.nextName();
            s.getClass();
            switch(s) {
                case "file": {
                    x0.c = jsonReader0.nextString();
                    break;
                }
                case "importance": {
                    x0.e = jsonReader0.nextInt();
                    x0.f = (byte)(x0.f | 4);
                    break;
                }
                case "offset": {
                    x0.d = jsonReader0.nextLong();
                    x0.f = (byte)(x0.f | 2);
                    break;
                }
                case "pc": {
                    x0.a = jsonReader0.nextLong();
                    x0.f = (byte)(x0.f | 1);
                    break;
                }
                case "symbol": {
                    String s1 = jsonReader0.nextString();
                    if(s1 == null) {
                        throw new NullPointerException("Null symbol");
                    }
                    x0.b = s1;
                    continue;
                }
                default: {
                    jsonReader0.skipValue();
                }
            }
        }
        jsonReader0.endObject();
        return x0.a();
    }

    public static F b(JsonReader jsonReader0) {
        jsonReader0.beginObject();
        String s = null;
        String s1 = null;
        while(jsonReader0.hasNext()) {
            String s2 = jsonReader0.nextName();
            s2.getClass();
            if(s2.equals("key")) {
                s = jsonReader0.nextString();
                if(s == null) {
                    throw new NullPointerException("Null key");
                }
                if(false) {
                    break;
                }
            }
            else if(s2.equals("value")) {
                s1 = jsonReader0.nextString();
                if(s1 == null) {
                    throw new NullPointerException("Null value");
                }
            }
            else {
                jsonReader0.skipValue();
            }
        }
        jsonReader0.endObject();
        if(s != null && s1 != null) {
            return new F(s, s1);
        }
        StringBuilder stringBuilder0 = new StringBuilder();
        if(s == null) {
            stringBuilder0.append(" key");
        }
        if(s1 == null) {
            stringBuilder0.append(" value");
        }
        throw new IllegalStateException("Missing required properties:" + stringBuilder0);
    }

    public static D c(JsonReader jsonReader0) {
        C c0 = new C();  // 初始化器: Ljava/lang/Object;-><init>()V
        jsonReader0.beginObject();
        while(jsonReader0.hasNext()) {
            String s = jsonReader0.nextName();
            s.getClass();
            switch(s) {
                case "buildIdMappingForArch": {
                    c0.i = a.d(jsonReader0, new i3.d(4));
                    break;
                }
                case "importance": {
                    c0.d = jsonReader0.nextInt();
                    c0.j = (byte)(c0.j | 4);
                    break;
                }
                case "pid": {
                    c0.a = jsonReader0.nextInt();
                    c0.j = (byte)(c0.j | 1);
                    break;
                }
                case "processName": {
                    String s1 = jsonReader0.nextString();
                    if(s1 == null) {
                        throw new NullPointerException("Null processName");
                    }
                    c0.b = s1;
                    continue;
                }
                case "pss": {
                    c0.e = jsonReader0.nextLong();
                    c0.j = (byte)(c0.j | 8);
                    break;
                }
                case "reasonCode": {
                    c0.c = jsonReader0.nextInt();
                    c0.j = (byte)(c0.j | 2);
                    break;
                }
                case "rss": {
                    c0.f = jsonReader0.nextLong();
                    c0.j = (byte)(c0.j | 16);
                    break;
                }
                case "timestamp": {
                    c0.g = jsonReader0.nextLong();
                    c0.j = (byte)(c0.j | 0x20);
                    break;
                }
                case "traceFile": {
                    c0.h = jsonReader0.nextString();
                    break;
                }
                default: {
                    jsonReader0.skipValue();
                }
            }
        }
        jsonReader0.endObject();
        return c0.a();
    }

    // This method was un-flattened
    public static List d(JsonReader jsonReader0, i3.d d0) {
        Y y0;
        String s12;
        ArrayList arrayList0 = new ArrayList();
        jsonReader0.beginArray();
        while(jsonReader0.hasNext()) {
            String s = null;
            switch(d0.a) {
                case 4: {
                    jsonReader0.beginObject();
                    String s1 = null;
                    String s2 = null;
                    while(jsonReader0.hasNext()) {
                        String s3 = jsonReader0.nextName();
                        s3.getClass();
                        switch(s3) {
                            case "arch": {
                                String s4 = jsonReader0.nextString();
                                if(s4 == null) {
                                    throw new NullPointerException("Null arch");
                                }
                                s = s4;
                                continue;
                            }
                            case "buildId": {
                                s2 = jsonReader0.nextString();
                                if(s2 == null) {
                                    throw new NullPointerException("Null buildId");
                                }
                                break;
                            }
                            case "libraryName": {
                                s1 = jsonReader0.nextString();
                                if(s1 == null) {
                                    throw new NullPointerException("Null libraryName");
                                }
                                continue;
                            }
                            default: {
                                jsonReader0.skipValue();
                                continue;
                            }
                        }
                        if(false) {
                            break;
                        }
                    }
                    jsonReader0.endObject();
                    if(s != null && s1 != null && s2 != null) {
                        y0 = new E(s, s1, s2);
                        break;
                    }
                    StringBuilder stringBuilder0 = new StringBuilder();
                    if(s == null) {
                        stringBuilder0.append(" arch");
                    }
                    if(s1 == null) {
                        stringBuilder0.append(" libraryName");
                    }
                    if(s2 == null) {
                        stringBuilder0.append(" buildId");
                    }
                    throw new IllegalStateException("Missing required properties:" + stringBuilder0);
                }
                case 5: {
                    jsonReader0.beginObject();
                    byte[] arr_b = null;
                    while(jsonReader0.hasNext()) {
                        String s5 = jsonReader0.nextName();
                        s5.getClass();
                        if(s5.equals("filename")) {
                            String s6 = jsonReader0.nextString();
                            if(s6 == null) {
                                throw new NullPointerException("Null filename");
                            }
                            s = s6;
                        }
                        else if(s5.equals("contents")) {
                            arr_b = Base64.decode(jsonReader0.nextString(), 2);
                            if(arr_b == null) {
                                throw new NullPointerException("Null contents");
                            }
                        }
                        else {
                            jsonReader0.skipValue();
                        }
                    }
                    jsonReader0.endObject();
                    if(s != null && arr_b != null) {
                        y0 = new H(s, arr_b);
                        break;
                    }
                    StringBuilder stringBuilder1 = new StringBuilder();
                    if(s == null) {
                        stringBuilder1.append(" filename");
                    }
                    if(arr_b == null) {
                        stringBuilder1.append(" contents");
                    }
                    throw new IllegalStateException("Missing required properties:" + stringBuilder1);
                }
                case 6: {
                    e0 e00 = new e0();  // 初始化器: Ljava/lang/Object;-><init>()V
                    jsonReader0.beginObject();
                    while(jsonReader0.hasNext()) {
                        String s7 = jsonReader0.nextName();
                        s7.getClass();
                        switch(s7) {
                            case "parameterKey": {
                                String s8 = jsonReader0.nextString();
                                if(s8 == null) {
                                    throw new NullPointerException("Null parameterKey");
                                }
                                e00.b = s8;
                                continue;
                            }
                            case "parameterValue": {
                                s12 = jsonReader0.nextString();
                                if(s12 == null) {
                                    throw new NullPointerException("Null parameterValue");
                                }
                                break;
                            }
                            case "rolloutVariant": {
                                jsonReader0.beginObject();
                                String s9 = null;
                                String s10 = null;
                                while(jsonReader0.hasNext()) {
                                    String s11 = jsonReader0.nextName();
                                    s11.getClass();
                                    if(s11.equals("variantId")) {
                                        s10 = jsonReader0.nextString();
                                        if(s10 == null) {
                                            throw new NullPointerException("Null variantId");
                                        }
                                        if(false) {
                                            break;
                                        }
                                    }
                                    else if(s11.equals("rolloutId")) {
                                        s9 = jsonReader0.nextString();
                                        if(s9 == null) {
                                            throw new NullPointerException("Null rolloutId");
                                        }
                                    }
                                    else {
                                        jsonReader0.skipValue();
                                    }
                                }
                                jsonReader0.endObject();
                                if(s9 != null && s10 != null) {
                                    e00.a = new g0(s9, s10);
                                    continue;
                                }
                                StringBuilder stringBuilder2 = new StringBuilder();
                                if(s9 == null) {
                                    stringBuilder2.append(" rolloutId");
                                }
                                if(s10 == null) {
                                    stringBuilder2.append(" variantId");
                                }
                                throw new IllegalStateException("Missing required properties:" + stringBuilder2);
                            }
                            case "templateVersion": {
                                e00.d = jsonReader0.nextLong();
                                e00.e = (byte)(e00.e | 1);
                                continue;
                            }
                            default: {
                                jsonReader0.skipValue();
                                continue;
                            }
                        }
                        e00.c = s12;
                    }
                    jsonReader0.endObject();
                    y0 = e00.a();
                    break;
                }
                case 7: {
                    jsonReader0.beginObject();
                    List list0 = null;
                    int v = 0;
                    int v1 = 0;
                    while(jsonReader0.hasNext()) {
                        String s13 = jsonReader0.nextName();
                        s13.getClass();
                        switch(s13) {
                            case "frames": {
                                list0 = a.d(jsonReader0, new i3.d(9));
                                if(list0 == null) {
                                    throw new NullPointerException("Null frames");
                                }
                                continue;
                            }
                            case "importance": {
                                v1 = jsonReader0.nextInt();
                                v = (byte)(v | 1);
                                break;
                            }
                            case "name": {
                                s = jsonReader0.nextString();
                                if(s == null) {
                                    throw new NullPointerException("Null name");
                                }
                                continue;
                            }
                            default: {
                                jsonReader0.skipValue();
                            }
                        }
                    }
                    jsonReader0.endObject();
                    if(v == 1 && s != null && list0 != null) {
                        y0 = new W(s, v1, list0);
                        break;
                    }
                    StringBuilder stringBuilder3 = new StringBuilder();
                    if(s == null) {
                        stringBuilder3.append(" name");
                    }
                    if((v & 1) == 0) {
                        stringBuilder3.append(" importance");
                    }
                    if(list0 == null) {
                        stringBuilder3.append(" frames");
                    }
                    throw new IllegalStateException("Missing required properties:" + stringBuilder3);
                }
                case 8: {
                    jsonReader0.beginObject();
                    String s14 = null;
                    String s15 = null;
                    int v2 = 0;
                    long v3 = 0L;
                    long v4 = 0L;
                    while(jsonReader0.hasNext()) {
                        String s16 = jsonReader0.nextName();
                        s16.getClass();
                        switch(s16) {
                            case "baseAddress": {
                                v2 = (byte)(v2 | 1);
                                v3 = jsonReader0.nextLong();
                                break;
                            }
                            case "name": {
                                String s17 = jsonReader0.nextString();
                                if(s17 == null) {
                                    throw new NullPointerException("Null name");
                                }
                                s14 = s17;
                                continue;
                            }
                            case "size": {
                                v2 = (byte)(v2 | 2);
                                v4 = jsonReader0.nextLong();
                                break;
                            }
                            case "uuid": {
                                s15 = new String(Base64.decode(jsonReader0.nextString(), 2), O0.a);
                                break;
                            }
                            default: {
                                jsonReader0.skipValue();
                            }
                        }
                    }
                    jsonReader0.endObject();
                    if(v2 != 3 || s14 == null) {
                        goto label_181;
                    }
                    y0 = new T(v3, s14, s15, v4);
                    break;
                }
                default: {
                    y0 = a.a(jsonReader0);
                }
            }
            arrayList0.add(y0);
            continue;
        label_181:
            StringBuilder stringBuilder4 = new StringBuilder();
            if((v2 & 1) == 0) {
                stringBuilder4.append(" baseAddress");
            }
            if((v2 & 2) == 0) {
                stringBuilder4.append(" size");
            }
            if(s14 == null) {
                stringBuilder4.append(" name");
            }
            throw new IllegalStateException("Missing required properties:" + stringBuilder4);
        }
        jsonReader0.endArray();
        return Collections.unmodifiableList(arrayList0);
    }

    // This method was un-flattened
    public static P e(JsonReader jsonReader0) {
        List list0;
        O o0 = new O();  // 初始化器: Ljava/lang/Object;-><init>()V
        jsonReader0.beginObject();
        while(jsonReader0.hasNext()) {
            String s = jsonReader0.nextName();
            s.getClass();
            switch(s) {
                case "app": {
                    jsonReader0.beginObject();
                    boolean z = false;
                    int v = 0;
                    S s3 = null;
                    List list2 = null;
                    List list3 = null;
                    Boolean boolean0 = null;
                    D0 d00 = null;
                    List list4 = null;
                    while(jsonReader0.hasNext()) {
                        String s4 = jsonReader0.nextName();
                        s4.getClass();
                        switch(s4) {
                            case "appProcessDetails": {
                                ArrayList arrayList0 = new ArrayList();
                                jsonReader0.beginArray();
                                while(jsonReader0.hasNext()) {
                                    arrayList0.add(a.g(jsonReader0));
                                }
                                jsonReader0.endArray();
                                list4 = Collections.unmodifiableList(arrayList0);
                                break;
                            }
                            case "background": {
                                boolean0 = Boolean.valueOf(jsonReader0.nextBoolean());
                                break;
                            }
                            case "currentProcessDetails": {
                                d00 = a.g(jsonReader0);
                                break;
                            }
                            case "customAttributes": {
                                ArrayList arrayList2 = new ArrayList();
                                jsonReader0.beginArray();
                                while(jsonReader0.hasNext()) {
                                    arrayList2.add(a.b(jsonReader0));
                                }
                                jsonReader0.endArray();
                                list2 = Collections.unmodifiableList(arrayList2);
                                break;
                            }
                            case "execution": {
                                jsonReader0.beginObject();
                                List list5 = null;
                                U u0 = null;
                                q0 q00 = null;
                                V v1 = null;
                                List list6 = null;
                                while(jsonReader0.hasNext()) {
                                    String s5 = jsonReader0.nextName();
                                    s5.getClass();
                                    switch(s5) {
                                        case "appExitInfo": {
                                            q00 = a.c(jsonReader0);
                                            break;
                                        }
                                        case "binaries": {
                                            list6 = a.d(jsonReader0, new i3.d(8));
                                            if(list6 == null) {
                                                throw new NullPointerException("Null binaries");
                                            }
                                            continue;
                                        }
                                        case "exception": {
                                            u0 = a.f(jsonReader0);
                                            break;
                                        }
                                        case "signal": {
                                            jsonReader0.beginObject();
                                            long v2 = 0L;
                                            int v3 = 0;
                                            String s6 = null;
                                            String s7 = null;
                                            while(jsonReader0.hasNext()) {
                                                String s8 = jsonReader0.nextName();
                                                s8.getClass();
                                                switch(s8) {
                                                    case "address": {
                                                        v3 = (byte)(v3 | 1);
                                                        v2 = jsonReader0.nextLong();
                                                        continue;
                                                    }
                                                    case "code": {
                                                        s7 = jsonReader0.nextString();
                                                        if(s7 == null) {
                                                            throw new NullPointerException("Null code");
                                                        }
                                                        continue;
                                                    }
                                                    case "name": {
                                                        s6 = jsonReader0.nextString();
                                                        if(s6 == null) {
                                                            throw new NullPointerException("Null name");
                                                        }
                                                        break;
                                                    }
                                                    default: {
                                                        jsonReader0.skipValue();
                                                        continue;
                                                    }
                                                }
                                                if(false) {
                                                    break;
                                                }
                                            }
                                            jsonReader0.endObject();
                                            if(v3 == 1 && s6 != null && s7 != null) {
                                                v1 = new V(s6, s7, v2);
                                                continue;
                                            }
                                            StringBuilder stringBuilder0 = new StringBuilder();
                                            if(s6 == null) {
                                                stringBuilder0.append(" name");
                                            }
                                            if(s7 == null) {
                                                stringBuilder0.append(" code");
                                            }
                                            if((v3 & 1) == 0) {
                                                stringBuilder0.append(" address");
                                            }
                                            throw new IllegalStateException("Missing required properties:" + stringBuilder0);
                                        }
                                        case "threads": {
                                            list5 = a.d(jsonReader0, new i3.d(7));
                                            break;
                                        }
                                        default: {
                                            jsonReader0.skipValue();
                                        }
                                    }
                                }
                                jsonReader0.endObject();
                                if(v1 != null && list6 != null) {
                                    s3 = new S(list5, u0, q00, v1, list6);
                                    continue;
                                }
                                StringBuilder stringBuilder1 = new StringBuilder();
                                if(v1 == null) {
                                    stringBuilder1.append(" signal");
                                }
                                if(list6 == null) {
                                    stringBuilder1.append(" binaries");
                                }
                                throw new IllegalStateException("Missing required properties:" + stringBuilder1);
                            }
                            case "internalKeys": {
                                ArrayList arrayList1 = new ArrayList();
                                jsonReader0.beginArray();
                                while(jsonReader0.hasNext()) {
                                    arrayList1.add(a.b(jsonReader0));
                                }
                                jsonReader0.endArray();
                                list3 = Collections.unmodifiableList(arrayList1);
                                break;
                            }
                            case "uiOrientation": {
                                v = jsonReader0.nextInt();
                                z = true;
                                break;
                            }
                            default: {
                                jsonReader0.skipValue();
                            }
                        }
                    }
                    jsonReader0.endObject();
                    if(z && s3 != null) {
                        o0.c = new Q(s3, list2, list3, boolean0, d00, list4, v);
                        continue;
                    }
                    StringBuilder stringBuilder2 = new StringBuilder();
                    if(s3 == null) {
                        stringBuilder2.append(" execution");
                    }
                    if(!z) {
                        stringBuilder2.append(" uiOrientation");
                    }
                    throw new IllegalStateException("Missing required properties:" + stringBuilder2);
                }
                case "device": {
                    b0 b00 = new b0();  // 初始化器: Ljava/lang/Object;-><init>()V
                    jsonReader0.beginObject();
                    while(jsonReader0.hasNext()) {
                        String s1 = jsonReader0.nextName();
                        s1.getClass();
                        switch(s1) {
                            case "batteryLevel": {
                                b00.a = jsonReader0.nextDouble();
                                break;
                            }
                            case "batteryVelocity": {
                                b00.b = jsonReader0.nextInt();
                                b00.g = (byte)(b00.g | 1);
                                break;
                            }
                            case "diskUsed": {
                                b00.f = jsonReader0.nextLong();
                                b00.g = (byte)(b00.g | 16);
                                break;
                            }
                            case "orientation": {
                                b00.d = jsonReader0.nextInt();
                                b00.g = (byte)(b00.g | 4);
                                break;
                            }
                            case "proximityOn": {
                                b00.c = jsonReader0.nextBoolean();
                                b00.g = (byte)(b00.g | 2);
                                break;
                            }
                            case "ramUsed": {
                                b00.e = jsonReader0.nextLong();
                                b00.g = (byte)(b00.g | 8);
                                break;
                            }
                            default: {
                                jsonReader0.skipValue();
                            }
                        }
                    }
                    jsonReader0.endObject();
                    o0.d = b00.a();
                    break;
                }
                case "log": {
                    list0 = null;
                    jsonReader0.beginObject();
                    while(jsonReader0.hasNext()) {
                        if(jsonReader0.nextName().equals("content")) {
                            String s9 = jsonReader0.nextString();
                            if(s9 == null) {
                                throw new NullPointerException("Null content");
                            }
                            list0 = s9;
                        }
                        else {
                            jsonReader0.skipValue();
                        }
                    }
                    jsonReader0.endObject();
                    if(list0 == null) {
                        throw new IllegalStateException("Missing required properties: content");
                    }
                    o0.e = new d0(((String)list0));
                    continue;
                }
                case "rollouts": {
                    list0 = null;
                    jsonReader0.beginObject();
                    while(jsonReader0.hasNext()) {
                        String s2 = jsonReader0.nextName();
                        s2.getClass();
                        if(s2.equals("assignments")) {
                            List list1 = a.d(jsonReader0, new i3.d(6));
                            if(list1 == null) {
                                throw new NullPointerException("Null rolloutAssignments");
                            }
                            list0 = list1;
                        }
                        else {
                            jsonReader0.skipValue();
                        }
                    }
                    jsonReader0.endObject();
                    if(list0 == null) {
                        throw new IllegalStateException("Missing required properties: rolloutAssignments");
                    }
                    o0.f = new h0(list0);
                    continue;
                }
                case "timestamp": {
                    o0.a = jsonReader0.nextLong();
                    o0.g = (byte)(o0.g | 1);
                    break;
                }
                case "type": {
                    String s10 = jsonReader0.nextString();
                    if(s10 == null) {
                        throw new NullPointerException("Null type");
                    }
                    o0.b = s10;
                    continue;
                }
                default: {
                    jsonReader0.skipValue();
                }
            }
        }
        jsonReader0.endObject();
        return o0.a();
    }

    public static U f(JsonReader jsonReader0) {
        jsonReader0.beginObject();
        int v = 0;
        String s = null;
        String s1 = null;
        List list0 = null;
        U u0 = null;
        int v1 = 0;
        while(jsonReader0.hasNext()) {
            String s2 = jsonReader0.nextName();
            s2.getClass();
            switch(s2) {
                case "causedBy": {
                    u0 = a.f(jsonReader0);
                    break;
                }
                case "frames": {
                    List list1 = a.d(jsonReader0, new i3.d(9));
                    if(list1 == null) {
                        throw new NullPointerException("Null frames");
                    }
                    list0 = list1;
                    continue;
                }
                case "overflowCount": {
                    v = jsonReader0.nextInt();
                    v1 = (byte)(v1 | 1);
                    break;
                }
                case "reason": {
                    s1 = jsonReader0.nextString();
                    break;
                }
                case "type": {
                    String s3 = jsonReader0.nextString();
                    if(s3 == null) {
                        throw new NullPointerException("Null type");
                    }
                    s = s3;
                    continue;
                }
                default: {
                    jsonReader0.skipValue();
                }
            }
        }
        jsonReader0.endObject();
        if(v1 == 1 && s != null && list0 != null) {
            return new U(s, s1, list0, u0, v);
        }
        StringBuilder stringBuilder0 = new StringBuilder();
        if(s == null) {
            stringBuilder0.append(" type");
        }
        if(list0 == null) {
            stringBuilder0.append(" frames");
        }
        if((v1 & 1) == 0) {
            stringBuilder0.append(" overflowCount");
        }
        throw new IllegalStateException("Missing required properties:" + stringBuilder0);
    }

    public static a0 g(JsonReader jsonReader0) {
        Z z0 = new Z();  // 初始化器: Ljava/lang/Object;-><init>()V
        jsonReader0.beginObject();
        while(jsonReader0.hasNext()) {
            String s = jsonReader0.nextName();
            s.getClass();
            switch(s) {
                case "defaultProcess": {
                    z0.d = jsonReader0.nextBoolean();
                    z0.e = (byte)(z0.e | 4);
                    break;
                }
                case "importance": {
                    z0.c = jsonReader0.nextInt();
                    z0.e = (byte)(z0.e | 2);
                    break;
                }
                case "pid": {
                    z0.b = jsonReader0.nextInt();
                    z0.e = (byte)(z0.e | 1);
                    break;
                }
                case "processName": {
                    String s1 = jsonReader0.nextString();
                    if(s1 == null) {
                        throw new NullPointerException("Null processName");
                    }
                    z0.a = s1;
                    continue;
                }
                default: {
                    jsonReader0.skipValue();
                }
            }
        }
        jsonReader0.endObject();
        return z0.a();
    }

    // This method was un-flattened
    public static B h(JsonReader jsonReader0) {
        String s12;
        I i0;
        A a0 = new A();  // 初始化器: Ljava/lang/Object;-><init>()V
        jsonReader0.beginObject();
        while(jsonReader0.hasNext()) {
            String s = jsonReader0.nextName();
            s.getClass();
        alab1:
            switch(s) {
                case "appExitInfo": {
                    a0.l = a.c(jsonReader0);
                    continue;
                }
                case "appQualitySessionId": {
                    a0.g = jsonReader0.nextString();
                    continue;
                }
                case "buildVersion": {
                    String s4 = jsonReader0.nextString();
                    if(s4 == null) {
                        throw new NullPointerException("Null buildVersion");
                    }
                    a0.h = s4;
                    continue;
                }
                case "displayVersion": {
                    String s7 = jsonReader0.nextString();
                    if(s7 == null) {
                        throw new NullPointerException("Null displayVersion");
                    }
                    a0.i = s7;
                    continue;
                }
                case "firebaseAuthenticationToken": {
                    a0.f = jsonReader0.nextString();
                    continue;
                }
                case "firebaseInstallationId": {
                    a0.e = jsonReader0.nextString();
                    continue;
                }
                case "gmpAppId": {
                    String s5 = jsonReader0.nextString();
                    if(s5 == null) {
                        throw new NullPointerException("Null gmpAppId");
                    }
                    a0.b = s5;
                    continue;
                }
                case "installationUuid": {
                    String s6 = jsonReader0.nextString();
                    if(s6 == null) {
                        throw new NullPointerException("Null installationUuid");
                    }
                    a0.d = s6;
                    continue;
                }
                case "ndkPayload": {
                    jsonReader0.beginObject();
                    List list0 = null;
                    String s1 = null;
                    while(jsonReader0.hasNext()) {
                        String s2 = jsonReader0.nextName();
                        s2.getClass();
                        if(s2.equals("files")) {
                            list0 = a.d(jsonReader0, new i3.d(5));
                            if(list0 == null) {
                                throw new NullPointerException("Null files");
                            }
                            if(false) {
                                break;
                            }
                        }
                        else if(s2.equals("orgId")) {
                            s1 = jsonReader0.nextString();
                        }
                        else {
                            jsonReader0.skipValue();
                        }
                    }
                    jsonReader0.endObject();
                    if(list0 == null) {
                        throw new IllegalStateException("Missing required properties: files");
                    }
                    a0.k = new G(list0, s1);
                    continue;
                }
                case "platform": {
                    a0.c = jsonReader0.nextInt();
                    a0.m = (byte)(a0.m | 1);
                    continue;
                }
                case "sdkVersion": {
                    String s3 = jsonReader0.nextString();
                    if(s3 == null) {
                        throw new NullPointerException("Null sdkVersion");
                    }
                    a0.a = s3;
                    continue;
                }
                case "session": {
                    i0 = new I();  // 初始化器: Ljava/lang/Object;-><init>()V
                    i0.f = false;
                    i0.m = (byte)(i0.m | 2);
                    jsonReader0.beginObject();
                    while(true) {
                        if(!jsonReader0.hasNext()) {
                            break alab1;
                        }
                        String s8 = jsonReader0.nextName();
                        s8.getClass();
                        switch(s8) {
                            case "app": {
                                jsonReader0.beginObject();
                                String s16 = null;
                                String s17 = null;
                                String s18 = null;
                                String s19 = null;
                                String s20 = null;
                                String s21 = null;
                                while(jsonReader0.hasNext()) {
                                    String s22 = jsonReader0.nextName();
                                    s22.getClass();
                                    switch(s22) {
                                        case "developmentPlatform": {
                                            s20 = jsonReader0.nextString();
                                            break;
                                        }
                                        case "developmentPlatformVersion": {
                                            s21 = jsonReader0.nextString();
                                            break;
                                        }
                                        case "displayVersion": {
                                            s18 = jsonReader0.nextString();
                                            break;
                                        }
                                        case "identifier": {
                                            s16 = jsonReader0.nextString();
                                            if(s16 == null) {
                                                throw new NullPointerException("Null identifier");
                                            }
                                            continue;
                                        }
                                        case "installationUuid": {
                                            s19 = jsonReader0.nextString();
                                            break;
                                        }
                                        case "version": {
                                            s17 = jsonReader0.nextString();
                                            if(s17 == null) {
                                                throw new NullPointerException("Null version");
                                            }
                                            continue;
                                        }
                                        default: {
                                            jsonReader0.skipValue();
                                        }
                                    }
                                }
                                jsonReader0.endObject();
                                if(s16 != null && s17 != null) {
                                    i0.g = new K(s16, s17, s18, s19, s20, s21);
                                    break;
                                }
                                StringBuilder stringBuilder0 = new StringBuilder();
                                if(s16 == null) {
                                    stringBuilder0.append(" identifier");
                                }
                                if(s17 == null) {
                                    stringBuilder0.append(" version");
                                }
                                throw new IllegalStateException("Missing required properties:" + stringBuilder0);
                            }
                            case "appQualitySessionId": {
                                i0.c = jsonReader0.nextString();
                                break;
                            }
                            case "crashed": {
                                i0.f = jsonReader0.nextBoolean();
                                i0.m = (byte)(i0.m | 2);
                                break;
                            }
                            case "device": {
                                M m0 = new M();  // 初始化器: Ljava/lang/Object;-><init>()V
                                jsonReader0.beginObject();
                                while(jsonReader0.hasNext()) {
                                    String s9 = jsonReader0.nextName();
                                    s9.getClass();
                                    switch(s9) {
                                        case "arch": {
                                            m0.a = jsonReader0.nextInt();
                                            m0.j = (byte)(m0.j | 1);
                                            continue;
                                        }
                                        case "cores": {
                                            m0.c = jsonReader0.nextInt();
                                            m0.j = (byte)(m0.j | 2);
                                            continue;
                                        }
                                        case "diskSpace": {
                                            m0.e = jsonReader0.nextLong();
                                            m0.j = (byte)(m0.j | 8);
                                            continue;
                                        }
                                        case "manufacturer": {
                                            String s10 = jsonReader0.nextString();
                                            if(s10 == null) {
                                                throw new NullPointerException("Null manufacturer");
                                            }
                                            m0.h = s10;
                                            continue;
                                        }
                                        case "model": {
                                            String s11 = jsonReader0.nextString();
                                            if(s11 == null) {
                                                throw new NullPointerException("Null model");
                                            }
                                            m0.b = s11;
                                            continue;
                                        }
                                        case "modelClass": {
                                            s12 = jsonReader0.nextString();
                                            if(s12 == null) {
                                                throw new NullPointerException("Null modelClass");
                                            }
                                            break;
                                        }
                                        case "ram": {
                                            m0.d = jsonReader0.nextLong();
                                            m0.j = (byte)(m0.j | 4);
                                            continue;
                                        }
                                        case "simulator": {
                                            m0.f = jsonReader0.nextBoolean();
                                            m0.j = (byte)(m0.j | 16);
                                            continue;
                                        }
                                        case "state": {
                                            m0.g = jsonReader0.nextInt();
                                            m0.j = (byte)(m0.j | 0x20);
                                            continue;
                                        }
                                        default: {
                                            jsonReader0.skipValue();
                                            continue;
                                        }
                                    }
                                    m0.i = s12;
                                }
                                jsonReader0.endObject();
                                i0.j = m0.a();
                                break;
                            }
                            case "endedAt": {
                                i0.e = jsonReader0.nextLong();
                                break;
                            }
                            case "events": {
                                ArrayList arrayList0 = new ArrayList();
                                jsonReader0.beginArray();
                                while(jsonReader0.hasNext()) {
                                    arrayList0.add(a.e(jsonReader0));
                                }
                                jsonReader0.endArray();
                                i0.k = Collections.unmodifiableList(arrayList0);
                                break;
                            }
                            case "generator": {
                                String s24 = jsonReader0.nextString();
                                if(s24 == null) {
                                    throw new NullPointerException("Null generator");
                                }
                                i0.a = s24;
                                break;
                            }
                            case "generatorType": {
                                i0.l = jsonReader0.nextInt();
                                i0.m = (byte)(i0.m | 4);
                                break;
                            }
                            case "identifier": {
                                i0.b = new String(Base64.decode(jsonReader0.nextString(), 2), O0.a);
                                break;
                            }
                            case "os": {
                                i0 i00 = new i0();  // 初始化器: Ljava/lang/Object;-><init>()V
                                jsonReader0.beginObject();
                                while(jsonReader0.hasNext()) {
                                    String s13 = jsonReader0.nextName();
                                    s13.getClass();
                                    switch(s13) {
                                        case "buildVersion": {
                                            String s14 = jsonReader0.nextString();
                                            if(s14 == null) {
                                                throw new NullPointerException("Null buildVersion");
                                            }
                                            i00.c = s14;
                                            continue;
                                        }
                                        case "jailbroken": {
                                            i00.d = jsonReader0.nextBoolean();
                                            i00.e = (byte)(i00.e | 2);
                                            break;
                                        }
                                        case "platform": {
                                            i00.a = jsonReader0.nextInt();
                                            i00.e = (byte)(i00.e | 1);
                                            break;
                                        }
                                        case "version": {
                                            String s15 = jsonReader0.nextString();
                                            if(s15 == null) {
                                                throw new NullPointerException("Null version");
                                            }
                                            i00.b = s15;
                                            continue;
                                        }
                                        default: {
                                            jsonReader0.skipValue();
                                        }
                                    }
                                }
                                jsonReader0.endObject();
                                i0.i = i00.a();
                                break;
                            }
                            case "startedAt": {
                                i0.d = jsonReader0.nextLong();
                                i0.m = (byte)(i0.m | 1);
                                break;
                            }
                            case "user": {
                                jsonReader0.beginObject();
                                String s23 = null;
                                while(jsonReader0.hasNext()) {
                                    if(jsonReader0.nextName().equals("identifier")) {
                                        s23 = jsonReader0.nextString();
                                        if(s23 == null) {
                                            throw new NullPointerException("Null identifier");
                                        }
                                    }
                                    else {
                                        jsonReader0.skipValue();
                                    }
                                }
                                jsonReader0.endObject();
                                if(s23 == null) {
                                    throw new IllegalStateException("Missing required properties: identifier");
                                }
                                i0.h = new k0(s23);
                                break;
                            }
                            default: {
                                jsonReader0.skipValue();
                            }
                        }
                    }
                }
                default: {
                    jsonReader0.skipValue();
                    continue;
                }
            }
            jsonReader0.endObject();
            a0.j = i0.a();
        }
        jsonReader0.endObject();
        return a0.a();
    }

    public static B i(String s) {
        try(JsonReader jsonReader0 = new JsonReader(new StringReader(s))) {
            return a.h(jsonReader0);
        }
        catch(IllegalStateException illegalStateException0) {
            throw new IOException(illegalStateException0);
        }
    }
}


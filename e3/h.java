package e3;

import Nf.p;
import U4.x;
import Ud.e;
import Vd.w;
import X7.d;
import android.graphics.Bitmap;
import android.media.MediaCodecInfo.CodecCapabilities;
import android.media.MediaCodecInfo;
import android.media.MediaCodecList;
import android.text.TextUtils;
import android.util.Log;
import android.view.View;
import c2.B0;
import coil.memory.MemoryCache.Key;
import com.google.android.gms.tasks.SuccessContinuation;
import com.google.android.gms.tasks.Task;
import com.google.android.gms.tasks.Tasks;
import com.google.android.material.internal.D;
import com.google.android.material.internal.E;
import com.iloen.melon.playback.Playable;
import com.iloen.melon.playback.PlayableAlbumExtensionsKt;
import com.iloen.melon.utils.FilenameUtils;
import com.kakao.emoticon.interfaces.EmoticonAuthListener;
import com.kakao.emoticon.net.EmoticonApiError;
import d5.n;
import e1.F;
import i.n.i.b.a.s.e.M3;
import java.nio.charset.Charset;
import java.nio.charset.CharsetEncoder;
import java.util.EnumMap;
import java.util.HashMap;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.NoSuchElementException;
import kotlin.jvm.internal.q;
import l2.c;
import m7.b;
import n7.a;
import o3.t;
import oc.N;
import oc.j;
import oe.i;
import org.json.JSONObject;
import pb.r;
import r5.g;
import s5.f;
import we.k;

public class h implements e, d, SuccessContinuation, D, EmoticonAuthListener, c, b, a, t, oc.a, g, f, t3.c, w4.b {
    @Override  // r5.g
    public r5.a a(MemoryCache.Key memoryCache$Key0) {
        return null;
    }

    @Override  // l2.c
    public Object b(l2.b b0) {
        throw b0;
    }

    @Override  // w4.b
    public void c() {
    }

    @Override  // r5.g
    public void clearMemory() {
    }

    @Override  // o3.t
    public boolean d(String s, MediaCodecInfo.CodecCapabilities mediaCodecInfo$CodecCapabilities0) {
        return false;
    }

    @Override  // m7.b
    public m7.a e(F f0, JSONObject jSONObject0) {
        return h.n(f0);
    }

    @Override  // w4.b
    public void f(int v, Object object0) {
    }

    @Override  // r5.g
    public void g(MemoryCache.Key memoryCache$Key0, Bitmap bitmap0, Map map0, int v) {
    }

    @Override  // t3.c
    public long getChunkEndTimeUs() {
        throw new NoSuchElementException();
    }

    @Override  // t3.c
    public long getChunkStartTimeUs() {
        throw new NoSuchElementException();
    }

    @Override  // o3.t
    public int getCodecCount() {
        return MediaCodecList.getCodecCount();
    }

    @Override  // o3.t
    public MediaCodecInfo getCodecInfoAt(int v) {
        return MediaCodecList.getCodecInfoAt(v);
    }

    @Override  // oc.a
    public Object h(Playable playable0, oc.F f0) {
        return PlayableAlbumExtensionsKt.getAlbumUri(playable0, false, f0);
    }

    @Override  // s5.f
    public boolean i() {
        return true;
    }

    // 去混淆评级： 低(20)
    @Override  // o3.t
    public boolean isFeatureSupported(String s, String s1, MediaCodecInfo.CodecCapabilities mediaCodecInfo$CodecCapabilities0) {
        return "secure-playback".equals(s) && "video/avc".equals(s1);
    }

    public static final String j(String s) {
        Locale locale0 = Locale.US;
        q.f(locale0, "Locale.US");
        if(s == null) {
            throw new NullPointerException("null cannot be cast to non-null type java.lang.String");
        }
        String s1 = s.toLowerCase(locale0);
        q.f(s1, "(this as java.lang.String).toLowerCase(locale)");
        return s1;
    }

    @Override  // com.google.android.material.internal.D
    public B0 k(View view0, B0 b00, E e0) {
        int v = e0.d;
        e0.d = b00.a() + v;
        boolean z = view0.getLayoutDirection() == 1;
        int v1 = b00.b();
        int v2 = b00.c();
        int v3 = e0.a + (z ? v2 : v1);
        e0.a = v3;
        int v4 = e0.c;
        if(!z) {
            v1 = v2;
        }
        int v5 = v4 + v1;
        e0.c = v5;
        view0.setPaddingRelative(v3, e0.b, v5, e0.d);
        return b00;
    }

    @Override  // n7.a
    public StackTraceElement[] l(StackTraceElement[] arr_stackTraceElement) {
        if(arr_stackTraceElement.length <= 0x400) {
            return arr_stackTraceElement;
        }
        StackTraceElement[] arr_stackTraceElement1 = new StackTraceElement[0x400];
        System.arraycopy(arr_stackTraceElement, 0, arr_stackTraceElement1, 0, 0x200);
        System.arraycopy(arr_stackTraceElement, arr_stackTraceElement.length - 0x200, arr_stackTraceElement1, 0x200, 0x200);
        return arr_stackTraceElement1;
    }

    public static a8.b m(byte[][] arr2_b, int v) {
        int v1 = arr2_b.length + v * 2;
        a8.b b0 = new a8.b(arr2_b[0].length + v * 2, v1);
        int[] arr_v = b0.d;
        for(int v2 = 0; v2 < arr_v.length; ++v2) {
            arr_v[v2] = 0;
        }
        int v3 = v1 - v - 1;
        int v4 = 0;
        while(v4 < arr2_b.length) {
            byte[] arr_b = arr2_b[v4];
            for(int v5 = 0; v5 < arr2_b[0].length; ++v5) {
                if(arr_b[v5] == 1) {
                    b0.b(v5 + v, v3);
                }
            }
            ++v4;
            --v3;
        }
        return b0;
    }

    public static m7.a n(F f0) {
        return new m7.a(System.currentTimeMillis() + 3600000L, new p(8), new V3.c(true, false, false), 10.0, 1.2, 60);
    }

    @Override  // t3.c
    public boolean next() {
        return false;
    }

    public u9.a o(String s) {
        HashMap hashMap0 = u9.a.d;
        u9.a a0 = (u9.a)hashMap0.get(s);
        if(a0 == null) {
            synchronized(this) {
                u9.a a1 = (u9.a)hashMap0.get(s);
                if(a1 == null) {
                    if(!s.equals("dcf") && !s.equals("legacy_db")) {
                        throw new IllegalArgumentException("Invalid storage name.");
                    }
                    a1 = new u9.a(s);
                    hashMap0.put(s, a1);
                }
                return a1;
            }
        }
        return a0;
    }

    @Override  // Ud.e
    public Object onChange(Object object0, boolean z) {
        q.g(((Kd.g)object0), "state");
        return ((Kd.g)object0).i ? Kd.g.a(((Kd.g)object0), null, false, z, 0x7FFFFF) : ((Kd.g)object0);
    }

    @Override  // com.kakao.emoticon.interfaces.EmoticonAuthListener
    public void onFail(EmoticonApiError emoticonApiError0) {
        q.g(emoticonApiError0, "e");
        Log.d("Emoticon", "Emoticon Auth Error");
    }

    @Override  // X7.d
    public a8.b p(String s, int v, EnumMap enumMap0) {
        boolean z3;
        int v53;
        int v52;
        int v51;
        boolean z2;
        int v28;
        int v19;
        boolean z1;
        int v14;
        int v1;
        if(v != 11) {
            throw new IllegalArgumentException("Can only encode PDF_417, but got " + x.C(v));
        }
        boolean z = enumMap0.containsKey(X7.a.g) ? Boolean.valueOf(enumMap0.get(X7.a.g).toString()).booleanValue() : false;
        X7.a a0 = X7.a.h;
        if(enumMap0.containsKey(a0)) {
            String s1 = enumMap0.get(a0).toString();
            if(s1 == null) {
                throw new NullPointerException("Name is null");
            }
            if(s1.equals("AUTO")) {
                v1 = 1;
            }
            else if(s1.equals("TEXT")) {
                v1 = 2;
            }
            else if(s1.equals("BYTE")) {
                v1 = 3;
            }
            else {
                if(!s1.equals("NUMERIC")) {
                    throw new IllegalArgumentException("No enum constant com.google.zxing.pdf417.encoder.Compaction." + s1);
                }
                v1 = 4;
            }
        }
        else {
            v1 = 1;
        }
        X7.a a1 = X7.a.i;
        if(!enumMap0.containsKey(a1)) {
            int v2 = enumMap0.containsKey(X7.a.f) ? Integer.parseInt(enumMap0.get(X7.a.f).toString()) : 30;
            int v3 = enumMap0.containsKey(X7.a.a) ? Integer.parseInt(enumMap0.get(X7.a.a).toString()) : 2;
            Charset charset0 = enumMap0.containsKey(X7.a.b) ? Charset.forName(enumMap0.get(X7.a.b).toString()) : null;
            if(v3 < 0 || v3 > 8) {
                throw new IllegalArgumentException("Error correction level must be between 0 and 8!");
            }
            int v4 = 1 << v3 + 1;
            Charset charset1 = g8.b.e;
            StringBuilder stringBuilder0 = new StringBuilder(s.length());
            if(charset0 == null) {
                charset0 = charset1;
            }
            else if(!charset1.equals(charset0)) {
                a8.c c0 = (a8.c)a8.c.d.get(charset0.name());
                if(c0 != null) {
                    int v5 = c0.a[0];
                    if(v5 >= 0 && v5 < 900) {
                        stringBuilder0.append('Ο');
                        stringBuilder0.append(((char)v5));
                    }
                    else if(v5 < 810900) {
                        stringBuilder0.append('Ξ');
                        stringBuilder0.append(((char)(v5 / 900 - 1)));
                        stringBuilder0.append(((char)(v5 % 900)));
                    }
                    else {
                        if(v5 >= 811800) {
                            throw new X7.e("ECI number not in valid range from 0..811799, but was " + v5);  // 初始化器: Ljava/lang/Exception;-><init>(Ljava/lang/String;)V
                        }
                        stringBuilder0.append('Ν');
                        stringBuilder0.append(((char)(810900 - v5)));
                    }
                }
            }
            int v6 = s.length();
            switch(e0.b.b(v1)) {
                case 1: {
                    z2 = z;
                    g8.b.c(s, 0, v6, stringBuilder0, 0);
                    break;
                }
                case 2: {
                    z2 = z;
                    byte[] arr_b1 = s.getBytes(charset0);
                    g8.b.a(arr_b1, arr_b1.length, 1, stringBuilder0);
                    break;
                }
                case 3: {
                    z2 = z;
                    stringBuilder0.append('Ά');
                    g8.b.b(0, v6, s, stringBuilder0);
                    break;
                }
                default: {
                    int v7 = 0;
                    int v8 = 0;
                    int v9 = 0;
                    while(v9 < v6) {
                        int v10 = s.length();
                        if(v9 < v10) {
                            int v11 = v9;
                            int v12 = s.charAt(v9);
                            int v13 = 0;
                            while(v12 >= 0x30 && v12 <= 57 && v11 < v10) {
                                ++v13;
                                ++v11;
                                if(v11 < v10) {
                                    v12 = s.charAt(v11);
                                }
                            }
                            v14 = v13;
                        }
                        else {
                            v14 = 0;
                        }
                        if(v14 >= 13) {
                            stringBuilder0.append('Ά');
                            g8.b.b(v9, v14, s, stringBuilder0);
                            v9 += v14;
                            v7 = 2;
                            v8 = 0;
                        }
                        else {
                            int v15 = s.length();
                            int v16 = v9;
                            while(v16 < v15) {
                                int v17 = s.charAt(v16);
                                z1 = z;
                                int v18 = 0;
                                while(v18 < 13 && v17 >= 0x30 && v17 <= 57 && v16 < v15) {
                                    ++v18;
                                    ++v16;
                                    if(v16 < v15) {
                                        v17 = s.charAt(v16);
                                    }
                                }
                                if(v18 >= 13) {
                                    v19 = v16 - v9 - v18;
                                    goto label_103;
                                }
                                else if(v18 <= 0) {
                                    int v20 = s.charAt(v16);
                                    if(v20 == 9 || v20 == 10 || v20 == 13 || v20 >= 0x20 && v20 <= 0x7E) {
                                        ++v16;
                                        z = z1;
                                        continue;
                                    }
                                }
                                else {
                                    z = z1;
                                    continue;
                                }
                                goto label_102;
                            }
                            z1 = z;
                        label_102:
                            v19 = v16 - v9;
                        label_103:
                            if(v19 >= 5 || v14 == v6) {
                                if(v7 == 0) {
                                    v28 = v8;
                                }
                                else {
                                    stringBuilder0.append('΄');
                                    v28 = 0;
                                    v7 = 0;
                                }
                                v8 = g8.b.c(s, v9, v19, stringBuilder0, v28);
                                v9 += v19;
                            }
                            else {
                                CharsetEncoder charsetEncoder0 = charset0.newEncoder();
                                int v21 = s.length();
                                int v22;
                                for(v22 = v9; v22 < v21; ++v22) {
                                    int v23 = s.charAt(v22);
                                    int v24 = 0;
                                    while(v24 < 13 && v23 >= 0x30 && v23 <= 57) {
                                        ++v24;
                                        int v25 = v22 + v24;
                                        if(v25 >= v21) {
                                            break;
                                        }
                                        v23 = s.charAt(v25);
                                    }
                                    if(v24 >= 13) {
                                        break;
                                    }
                                    int v26 = s.charAt(v22);
                                    if(!charsetEncoder0.canEncode(((char)v26))) {
                                        throw new X7.e("Non-encodable character detected: " + ((char)v26) + " (Unicode: " + v26 + ')');  // 初始化器: Ljava/lang/Exception;-><init>(Ljava/lang/String;)V
                                    }
                                }
                                int v27 = v9 + (v22 - v9 == 0 ? 1 : v22 - v9);
                                byte[] arr_b = s.substring(v9, v27).getBytes(charset0);
                                if(arr_b.length != 1 || v7 != 0) {
                                    g8.b.a(arr_b, arr_b.length, v7, stringBuilder0);
                                    v7 = 1;
                                    v8 = 0;
                                }
                                else {
                                    g8.b.a(arr_b, 1, 0, stringBuilder0);
                                }
                                v9 = v27;
                            }
                            z = z1;
                        }
                    }
                    z2 = z;
                }
            }
            String s2 = stringBuilder0.toString();
            int v29 = s2.length();
            float f = 0.0f;
            int[] arr_v = null;
            for(int v30 = 2; v30 <= 30; ++v30) {
                int v31 = v29 + 1 + v4;
                int v32 = v31 / v30;
                int v33 = v32 + 1;
                if(v30 * v33 < v31 + v30) {
                    v32 = v33;
                }
                if(v32 < 2) {
                    break;
                }
                if(v32 <= 30) {
                    float f1 = ((float)(v30 * 17 + 69)) * 0.357f / (((float)v32) * 2.0f);
                    if(arr_v == null || Math.abs(f1 - 3.0f) <= Math.abs(f - 3.0f)) {
                        f = f1;
                        arr_v = new int[]{v30, v32};
                    }
                }
            }
            if(arr_v == null) {
                int v34 = v29 + 1 + v4;
                int v35 = v34 / 2;
                if((2 * (v35 + 1) >= v34 + 2 ? v34 / 2 : v35 + 1) < 2) {
                    arr_v = new int[]{2, 2};
                }
            }
            if(arr_v == null) {
                throw new X7.e("Unable to fit message in columns");  // 初始化器: Ljava/lang/Exception;-><init>(Ljava/lang/String;)V
            }
            int v36 = arr_v[0];
            int v37 = arr_v[1];
            int v38 = v36 * v37 - v4;
            int v39 = v38 <= v29 + 1 ? 0 : v38 - v29 - 1;
            if(v29 + v4 + 1 > 929) {
                throw new X7.e("Encoded message contains too many code words, message too big (" + s.length() + " bytes)");  // 初始化器: Ljava/lang/Exception;-><init>(Ljava/lang/String;)V
            }
            int v40 = v29 + v39 + 1;
            StringBuilder stringBuilder1 = new StringBuilder(v40);
            stringBuilder1.append(((char)v40));
            stringBuilder1.append(s2);
            for(int v41 = 0; v41 < v39; ++v41) {
                stringBuilder1.append('΄');
            }
            String s3 = stringBuilder1.toString();
            int[][] arr2_v = g8.a.b;
            char[] arr_c = new char[v4];
            int v42 = s3.length();
            for(int v43 = 0; v43 < v42; ++v43) {
                int v44 = v4 - 1;
                int v45 = (s3.charAt(v43) + arr_c[v44]) % 929;
                while(v44 > 0) {
                    arr_c[v44] = (char)((arr_c[v44 - 1] + (929 - arr2_v[v3][v44] * v45 % 929)) % 929);
                    --v44;
                }
                arr_c[0] = (char)((929 - v45 * arr2_v[v3][0] % 929) % 929);
            }
            StringBuilder stringBuilder2 = new StringBuilder(v4);
            for(int v46 = v4 - 1; v46 >= 0; --v46) {
                int v47 = arr_c[v46];
                if(v47 != 0) {
                    arr_c[v46] = (char)(929 - v47);
                }
                stringBuilder2.append(arr_c[v46]);
            }
            w w0 = new w(v37, v36);
            String s4 = s3 + stringBuilder2.toString();
            int[][] arr2_v1 = g8.a.a;
            int v48 = 0;
            for(int v49 = 0; v48 < v37; v49 = v55) {
                int v50 = v48 % 3;
                ++w0.b;
                g8.a.a(0x1FEA8, 17, w0.g());
                if(v50 == 0) {
                    v51 = v48 / 3 * 30;
                    v52 = (v37 - 1) / 3 + v51;
                    v53 = v36 - 1 + v51;
                }
                else if(v50 == 1) {
                    v51 = v48 / 3 * 30;
                    v52 = v3 * 3 + v51 + (v37 - 1) % 3;
                    v53 = (v37 - 1) / 3 + v51;
                }
                else {
                    int v54 = v48 / 3 * 30;
                    v52 = v36 - 1 + v54;
                    v53 = v3 * 3 + v54 + (v37 - 1) % 3;
                }
                g8.a.a(arr2_v1[v50][v52], 17, w0.g());
                int v55 = v49;
                for(int v56 = 0; v56 < v36; ++v56) {
                    g8.a.a(arr2_v1[v50][s4.charAt(v55)], 17, w0.g());
                    ++v55;
                }
                if(z2) {
                    g8.a.a(0x3FA29, 1, w0.g());
                }
                else {
                    g8.a.a(arr2_v1[v50][v53], 17, w0.g());
                    g8.a.a(0x3FA29, 18, w0.g());
                }
                ++v48;
            }
            byte[][] arr2_b = w0.k(1, 4);
            if(arr2_b[0].length < arr2_b.length) {
                arr2_b = h.u(arr2_b);
                z3 = true;
            }
            else {
                z3 = false;
            }
            int v57 = 200 / arr2_b[0].length;
            int v58 = 200 / arr2_b.length;
            if(v57 >= v58) {
                v57 = v58;
            }
            if(v57 > 1) {
                byte[][] arr2_b1 = w0.k(v57, v57 << 2);
                if(z3) {
                    arr2_b1 = h.u(arr2_b1);
                }
                return h.m(arr2_b1, v2);
            }
            return h.m(arr2_b, v2);
        }
        enumMap0.get(a1).getClass();
        throw new ClassCastException();
    }

    public static j q(N n0, we.a a0, boolean z) {
        q.g(n0, "curState");
        int v = n0.getRepeatMode().ordinal();
        switch(v) {
            case 0: {
                return new j(((Number)a0.invoke()).intValue(), !z);
            }
            case 1: {
                return new j(((Number)a0.invoke()).intValue(), true);
            }
            default: {
                if(v != 2) {
                    throw new M3();  // 初始化器: Ljava/lang/RuntimeException;-><init>()V
                }
                return new j(n0.b(), true);
            }
        }
    }

    public Enum r(boolean z, k k0, boolean z1, long v, String s, String s1, oe.c c0) {
        pb.d d0;
        if(c0 instanceof pb.d) {
            d0 = (pb.d)c0;
            int v1 = d0.N;
            if((v1 & 0x80000000) == 0) {
                d0 = new pb.d(this, c0);
            }
            else {
                d0.N = v1 ^ 0x80000000;
            }
        }
        else {
            d0 = new pb.d(this, c0);
        }
        Object object0 = d0.I;
        Enum enum0 = ne.a.a;
        switch(d0.N) {
            case 0: {
                n.D(object0);
                if(!z) {
                    goto label_43;
                }
                d0.B = (i)k0;
                d0.D = s;
                d0.E = s1;
                d0.r = true;
                d0.w = z1;
                d0.G = v;
                d0.N = 1;
                object0 = k0.invoke(d0);
                if(object0 == enum0) {
                    return enum0;
                }
                goto label_32;
            }
            case 1: {
                v = d0.G;
                z1 = d0.w;
                z = d0.r;
                s1 = d0.E;
                s = d0.D;
                k0 = (k)d0.B;
                n.D(object0);
            label_32:
                if(TextUtils.isEmpty(((CharSequence)object0))) {
                    goto label_43;
                }
                d0.B = null;
                d0.D = null;
                d0.E = null;
                d0.r = z;
                d0.w = z1;
                d0.G = v;
                d0.N = 2;
                object0 = k0.invoke(d0);
                if(object0 == enum0) {
                    return enum0;
                label_43:
                    if(z1 && v < 0L) {
                        if(je.p.d0(e.k.A(new String[]{"AC4", "EC3"}), s)) {
                            return r.l;
                        }
                        if("FLAC16".equals(s)) {
                            return r.e;
                        }
                        if("AAC".equals(s)) {
                            if("128".equals(s1)) {
                                return r.g;
                            }
                            return "320".equals(s1) ? r.h : r.f;
                        }
                        if("MP3".equals(s)) {
                            if(!TextUtils.isEmpty(s1) && !"192".equals(s1)) {
                                if("320".equals(s1)) {
                                    return r.k;
                                }
                                return "128".equals(s1) ? r.i : r.a;
                            }
                            return r.j;
                        }
                        return "HD".equals(s) ? r.k : r.a;
                    }
                    return r.a;
                }
                goto label_61;
            }
            case 2: {
                break;
            }
            default: {
                throw new IllegalStateException("call to \'resume\' before \'invoke\' with coroutine");
            }
        }
        n.D(object0);
    label_61:
        switch(FilenameUtils.getFileType(((String)object0))) {
            case 0x102: {
                return r.b;
            }
            case 0x202: {
                return r.d;
            }
            case 0x402: {
                return r.c;
            }
            default: {
                return r.b;
            }
        }
    }

    public boolean s(CharSequence charSequence0) {
        return charSequence0 instanceof a2.d;
    }

    @Override  // o3.t
    public boolean secureDecodersExplicit() {
        return false;
    }

    @Override  // s5.f
    public void shutdown() {
    }

    public static vd.i t(String s, String s1, String s2, boolean z, we.a a0, String s3, k k0, k k1, boolean z1, boolean z2, vd.h h0, boolean z3, List list0, int v) {
        k k2 = null;
        boolean z4 = false;
        if((v & 0x100) == 0) {
            k2 = k1;
        }
        vd.h h1 = (v & 0x800) == 0 ? h0 : vd.h.a;
        if((v & 0x4000) != 0) {
            z4 = true;
        }
        List list1 = (v & 0x8000) == 0 ? list0 : je.w.a;
        vd.i i0 = new vd.i();
        i0.e = (v & 1) == 0 ? s : null;
        i0.f = (v & 2) == 0 ? s1 : null;
        i0.g = (v & 4) == 0 ? s2 : null;
        i0.m = (v & 8) == 0 ? z : false;
        i0.j = (v & 16) == 0 ? a0 : null;
        i0.h = (v & 0x20) == 0 ? s3 : null;
        i0.n = true;
        i0.k = (v & 0x80) == 0 ? k0 : null;
        i0.l = k2;
        i0.i = (v & 0x200) == 0 ? z1 : true;
        i0.setShouldRetain(((v & 0x400) == 0 ? z2 : false));
        i0.o = h1;
        i0.setDismissOnBackPressed(z4);
        i0.setDismissOnConfigurationChanged(((v & 0x2000) == 0 ? z3 : false));
        i0.r = list1;
        return i0;
    }

    @Override  // com.google.android.gms.tasks.SuccessContinuation
    public Task then(Object object0) {
        Void void0 = (Void)object0;
        return Tasks.forResult(Boolean.TRUE);
    }

    @Override  // r5.g
    public void trimMemory(int v) {
    }

    public static byte[][] u(byte[][] arr2_b) {
        byte[][] arr2_b1 = new byte[arr2_b[0].length][arr2_b.length];
        for(int v = 0; v < arr2_b.length; ++v) {
            int v1 = arr2_b.length - v - 1;
            for(int v2 = 0; v2 < arr2_b[0].length; ++v2) {
                arr2_b1[v2][v1] = arr2_b[v][v2];
            }
        }
        return arr2_b1;
    }
}


package b3;

import H6.e;
import I6.Q;
import I6.V;
import I6.p0;
import S1.d;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import androidx.media3.common.DrmInitData;
import androidx.media3.common.Metadata;
import androidx.media3.common.StreamKey;
import c2.B0;
import c2.v;
import com.android.volley.Response.ErrorListener;
import com.android.volley.VolleyError;
import com.facebook.AccessToken;
import com.facebook.FacebookSdk.GraphRequestCreator;
import com.facebook.FacebookSdk;
import com.facebook.GraphRequest;
import com.facebook.internal.FeatureManager.Callback;
import com.google.android.exoplayer2.extractor.Extractor;
import com.google.android.exoplayer2.extractor.ExtractorsFactory;
import com.google.android.exoplayer2.extractor.amr.AmrExtractor;
import com.iloen.melon.net.HttpResponse;
import com.iloen.melon.utils.log.LogU;
import java.util.ArrayList;
import org.json.JSONObject;

public final class z implements e, v, ErrorListener, GraphRequestCreator, Callback, ExtractorsFactory {
    public final int a;

    public z(int v) {
        this.a = v;
        super();
    }

    @Override  // H6.e
    public Object apply(Object object0) {
        p0 p00;
        b b1;
        E[] arr_e2;
        E[] arr_e;
        a[] arr_a;
        switch(this.a) {
            case 0: {
                ((StreamKey)object0).getClass();
                Bundle bundle1 = new Bundle();
                int v2 = ((StreamKey)object0).a;
                if(v2 != 0) {
                    bundle1.putInt("0", v2);
                }
                int v3 = ((StreamKey)object0).b;
                if(v3 != 0) {
                    bundle1.putInt("1", v3);
                }
                int v4 = ((StreamKey)object0).c;
                if(v4 != 0) {
                    bundle1.putInt("2", v4);
                }
                return bundle1;
            }
            case 1: {
                ((D)object0).getClass();
                Bundle bundle2 = new Bundle();
                bundle2.putParcelable("0", ((D)object0).a);
                String s = ((D)object0).b;
                if(s != null) {
                    bundle2.putString("1", s);
                }
                String s1 = ((D)object0).c;
                if(s1 != null) {
                    bundle2.putString("2", s1);
                }
                int v5 = ((D)object0).d;
                if(v5 != 0) {
                    bundle2.putInt("3", v5);
                }
                int v6 = ((D)object0).e;
                if(v6 != 0) {
                    bundle2.putInt("4", v6);
                }
                String s2 = ((D)object0).f;
                if(s2 != null) {
                    bundle2.putString("5", s2);
                }
                String s3 = ((D)object0).g;
                if(s3 != null) {
                    bundle2.putString("6", s3);
                }
                return bundle2;
            }
            case 2: {
                Uri uri0 = (Uri)((Bundle)object0).getParcelable("0");
                uri0.getClass();
                String s4 = ((Bundle)object0).getString("1");
                String s5 = ((Bundle)object0).getString("2");
                int v7 = ((Bundle)object0).getInt("3", 0);
                int v8 = ((Bundle)object0).getInt("4", 0);
                String s6 = ((Bundle)object0).getString("5");
                String s7 = ((Bundle)object0).getString("6");
                Y6.b b0 = new Y6.b();  // 初始化器: Ljava/lang/Object;-><init>()V
                b0.d = uri0;
                b0.a = H.l(s4);
                b0.e = s5;
                b0.b = v7;
                b0.c = v8;
                b0.f = s6;
                b0.g = s7;
                return new D(b0);
            }
            case 3: {
                Bundle bundle3 = ((Bundle)object0).getBundle("1");
                E e0 = bundle3 == null ? E.g : E.b(bundle3);
                long v9 = ((Bundle)object0).getLong("2", 0x8000000000000001L);
                long v10 = ((Bundle)object0).getLong("3", 0x8000000000000001L);
                long v11 = ((Bundle)object0).getLong("4", 0x8000000000000001L);
                boolean z = ((Bundle)object0).getBoolean("5", false);
                boolean z1 = ((Bundle)object0).getBoolean("6", false);
                Bundle bundle4 = ((Bundle)object0).getBundle("7");
                y y0 = bundle4 == null ? null : y.b(bundle4);
                boolean z2 = ((Bundle)object0).getBoolean("8", false);
                long v12 = ((Bundle)object0).getLong("9", 0L);
                long v13 = ((Bundle)object0).getLong("a", 0x8000000000000001L);
                int v14 = ((Bundle)object0).getInt("b", 0);
                int v15 = ((Bundle)object0).getInt("c", 0);
                long v16 = ((Bundle)object0).getLong("d", 0L);
                o0 o00 = new o0();
                o00.b(o0.r, e0, null, v9, v10, v11, z, z1, y0, v12, v13, v14, v15, v16);
                o00.k = z2;
                return o00;
            }
            case 4: {
                int v17 = ((Bundle)object0).getInt("0", 0);
                long v18 = ((Bundle)object0).getLong("1", 0x8000000000000001L);
                long v19 = ((Bundle)object0).getLong("2", 0L);
                boolean z3 = ((Bundle)object0).getBoolean("3", false);
                Bundle bundle5 = ((Bundle)object0).getBundle("4");
                if(bundle5 == null) {
                    b1 = b.f;
                }
                else {
                    ArrayList arrayList0 = bundle5.getParcelableArrayList("1");
                    if(arrayList0 == null) {
                        arr_a = new a[0];
                    }
                    else {
                        a[] arr_a1 = new a[arrayList0.size()];
                        int v20 = 0;
                        while(v20 < arrayList0.size()) {
                            Bundle bundle6 = (Bundle)arrayList0.get(v20);
                            long v21 = bundle6.getLong("0");
                            int v22 = bundle6.getInt("1");
                            int v23 = bundle6.getInt("7");
                            ArrayList arrayList1 = bundle6.getParcelableArrayList("2");
                            ArrayList arrayList2 = bundle6.getParcelableArrayList("8");
                            int[] arr_v2 = bundle6.getIntArray("3");
                            long[] arr_v3 = bundle6.getLongArray("4");
                            long v24 = bundle6.getLong("5");
                            boolean z4 = bundle6.getBoolean("6");
                            if(arr_v2 == null) {
                                arr_v2 = new int[0];
                            }
                            if(arrayList2 != null) {
                                arr_e = new E[arrayList2.size()];
                                for(int v25 = 0; v25 < arrayList2.size(); ++v25) {
                                    Bundle bundle7 = (Bundle)arrayList2.get(v25);
                                    arr_e[v25] = bundle7 == null ? null : E.b(bundle7);
                                }
                            }
                            else if(arrayList1 == null) {
                                arr_e = new E[0];
                            }
                            else {
                                E[] arr_e1 = new E[arrayList1.size()];
                                for(int v26 = 0; v26 < arrayList1.size(); ++v26) {
                                    Uri uri1 = (Uri)arrayList1.get(v26);
                                    arr_e1[v26] = uri1 == null ? null : E.c(uri1);
                                }
                                arr_e2 = arr_e1;
                                goto label_131;
                            }
                            arr_e2 = arr_e;
                        label_131:
                            if(arr_v3 == null) {
                                arr_v3 = new long[0];
                            }
                            arr_a1[v20] = new a(v21, v22, v23, arr_v2, arr_e2, arr_v3, v24, z4);
                            ++v20;
                        }
                        arr_a = arr_a1;
                    }
                    b1 = new b(arr_a, bundle5.getLong("2", 0L), bundle5.getLong("3", 0x8000000000000001L), bundle5.getInt("4", 0));
                }
                m0 m00 = new m0();
                m00.i(null, null, v17, v18, v19, b1, z3);
                return m00;
            }
            case 5: {
                Bundle bundle8 = (Bundle)object0;
                androidx.media3.common.b b2 = androidx.media3.common.b.N;
                n n0 = new n();
                if(bundle8 != null) {
                    bundle8.setClassLoader(e3.b.class.getClassLoader());
                }
                String s8 = bundle8.getString("0");
                String s9 = b2.a;
                if(s8 == null) {
                    s8 = s9;
                }
                n0.a = s8;
                String s10 = bundle8.getString("1");
                String s11 = b2.b;
                if(s10 == null) {
                    s10 = s11;
                }
                n0.b = s10;
                ArrayList arrayList3 = bundle8.getParcelableArrayList("w");
                if(arrayList3 == null) {
                    p00 = p0.e;
                }
                else {
                    Q q0 = V.o();
                    for(int v27 = 0; v27 < arrayList3.size(); ++v27) {
                        Bundle bundle9 = (Bundle)arrayList3.get(v27);
                        bundle9.getClass();
                        String s12 = bundle9.getString("0");
                        String s13 = bundle9.getString("1");
                        s13.getClass();
                        q0.a(new q(s12, s13));
                    }
                    p00 = q0.g();
                }
                n0.c = V.p(p00);
                String s14 = bundle8.getString("2");
                String s15 = b2.d;
                if(s14 == null) {
                    s14 = s15;
                }
                n0.d = s14;
                n0.e = bundle8.getInt("3", b2.e);
                n0.f = bundle8.getInt("4", b2.f);
                n0.g = bundle8.getInt("x", b2.g);
                n0.h = bundle8.getInt("5", b2.h);
                n0.i = bundle8.getInt("6", b2.i);
                String s16 = bundle8.getString("7");
                String s17 = b2.k;
                if(s16 == null) {
                    s16 = s17;
                }
                n0.j = s16;
                Metadata metadata0 = (Metadata)bundle8.getParcelable("8");
                Metadata metadata1 = b2.l;
                if(metadata0 == null) {
                    metadata0 = metadata1;
                }
                n0.k = metadata0;
                String s18 = bundle8.getString("9");
                String s19 = b2.m;
                if(s18 == null) {
                    s18 = s19;
                }
                n0.l = H.l(s18);
                String s20 = bundle8.getString("a");
                String s21 = b2.n;
                if(s20 == null) {
                    s20 = s21;
                }
                n0.m = H.l(s20);
                n0.n = bundle8.getInt("b", b2.o);
                ArrayList arrayList4 = new ArrayList();
                byte[] arr_b;
                for(int v = 0; (arr_b = bundle8.getByteArray("c_" + Integer.toString(v, 36))) != null; ++v) {
                    arrayList4.add(arr_b);
                }
                n0.p = arrayList4;
                n0.q = (DrmInitData)bundle8.getParcelable("d");
                n0.r = bundle8.getLong("e", b2.s);
                n0.t = bundle8.getInt("f", b2.u);
                n0.u = bundle8.getInt("g", b2.v);
                n0.v = bundle8.getFloat("h", b2.w);
                n0.w = bundle8.getInt("i", b2.x);
                n0.x = bundle8.getFloat("j", b2.y);
                n0.y = bundle8.getByteArray("k");
                n0.z = bundle8.getInt("l", b2.A);
                Bundle bundle10 = bundle8.getBundle("m");
                if(bundle10 != null) {
                    int v28 = bundle10.getInt("0", -1);
                    int v29 = bundle10.getInt("1", -1);
                    int v30 = bundle10.getInt("2", -1);
                    byte[] arr_b1 = bundle10.getByteArray("3");
                    n0.A = new i(v28, v29, v30, bundle10.getInt("4", -1), bundle10.getInt("5", -1), arr_b1);
                }
                n0.B = bundle8.getInt("n", b2.C);
                n0.C = bundle8.getInt("o", b2.D);
                n0.D = bundle8.getInt("p", b2.E);
                n0.E = bundle8.getInt("q", b2.F);
                n0.F = bundle8.getInt("r", b2.G);
                n0.G = bundle8.getInt("s", b2.H);
                n0.I = bundle8.getInt("u", b2.J);
                n0.J = bundle8.getInt("v", b2.K);
                n0.K = bundle8.getInt("t", b2.L);
                return new androidx.media3.common.b(n0);
            }
            case 6: {
                ((v0)object0).getClass();
                Bundle bundle11 = new Bundle();
                bundle11.putBundle("0", ((v0)object0).b.d());
                bundle11.putIntArray("1", ((v0)object0).d);
                bundle11.putBooleanArray("3", ((v0)object0).e);
                bundle11.putBoolean("4", ((v0)object0).c);
                return bundle11;
            }
            default: {
                Bundle bundle0 = ((Bundle)object0).getBundle("0");
                bundle0.getClass();
                q0 q00 = q0.a(bundle0);
                int[] arr_v = ((Bundle)object0).getIntArray("1");
                int v1 = q00.a;
                int[] arr_v1 = new int[v1];
                if(arr_v == null) {
                    arr_v = arr_v1;
                }
                boolean[] arr_z = ((Bundle)object0).getBooleanArray("3");
                boolean[] arr_z1 = new boolean[v1];
                if(arr_z == null) {
                    arr_z = arr_z1;
                }
                return new v0(q00, ((Bundle)object0).getBoolean("4", false), arr_v, arr_z);
            }
        }
    }

    @Override  // com.google.android.exoplayer2.extractor.ExtractorsFactory
    public Extractor[] createExtractors() {
        return AmrExtractor.a();
    }

    @Override  // com.facebook.FacebookSdk$GraphRequestCreator
    public GraphRequest createPostRequest(AccessToken accessToken0, String s, JSONObject jSONObject0, com.facebook.GraphRequest.Callback graphRequest$Callback0) {
        return FacebookSdk.b(accessToken0, s, jSONObject0, graphRequest$Callback0);
    }

    @Override  // com.facebook.internal.FeatureManager$Callback
    public void onCompleted(boolean z) {
        switch(this.a) {
            case 15: {
                FacebookSdk.g(z);
                return;
            }
            case 16: {
                FacebookSdk.f(z);
                return;
            }
            case 17: {
                FacebookSdk.a(z);
                return;
            }
            case 18: {
                FacebookSdk.c(z);
                return;
            }
            case 19: {
                FacebookSdk.h(z);
                return;
            }
            case 20: {
                com.facebook.appevents.AppEventsManager.start.1.j(z);
                return;
            }
            case 21: {
                com.facebook.appevents.AppEventsManager.start.1.k(z);
                return;
            }
            case 22: {
                com.facebook.appevents.AppEventsManager.start.1.i(z);
                return;
            }
            case 23: {
                com.facebook.appevents.AppEventsManager.start.1.o(z);
                return;
            }
            case 24: {
                com.facebook.appevents.AppEventsManager.start.1.c(z);
                return;
            }
            case 25: {
                com.facebook.appevents.AppEventsManager.start.1.e(z);
                return;
            }
            case 26: {
                com.facebook.appevents.AppEventsManager.start.1.a(z);
                return;
            }
            case 27: {
                com.facebook.appevents.AppEventsManager.start.1.h(z);
                return;
            }
            case 28: {
                com.facebook.appevents.AppEventsManager.start.1.d(z);
                return;
            }
            default: {
                com.facebook.appevents.AppEventsManager.start.1.b(z);
            }
        }
    }

    @Override  // com.android.volley.Response$ErrorListener
    public void onErrorResponse(VolleyError volleyError0) {
        if(this.a != 12) {
            String s = va.e.b("fetchLoginPromotion() failed with error : ", HttpResponse.Companion.getErrorMessage(volleyError0));
            LogU.warn$default(c9.i.b, s, null, false, 6, null);
            return;
        }
        String s1 = va.e.b("requestTmpManage() failed with error : ", HttpResponse.Companion.getErrorMessage(volleyError0));
        LogU.warn$default(c9.i.b, s1, null, false, 6, null);
    }

    @Override  // c2.v
    public B0 s(View view0, B0 b00) {
        kotlin.jvm.internal.q.g(view0, "v");
        d d0 = b00.a.g(647);
        kotlin.jvm.internal.q.f(d0, "getInsets(...)");
        view0.setPadding(d0.a, d0.b, d0.c, d0.d);
        return b00;
    }
}


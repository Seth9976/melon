package i3;

import B3.r;
import B3.u;
import H6.e;
import I6.V;
import I6.p0;
import I6.w;
import Tf.o;
import Y6.f;
import android.graphics.Bitmap;
import android.net.Uri;
import android.view.View;
import androidx.viewpager.widget.k;
import b3.I;
import b3.q0;
import co.ab180.airbridge.common.OnSuccess;
import com.android.volley.Response.ErrorListener;
import com.android.volley.Response.Listener;
import com.android.volley.VolleyError;
import com.google.firebase.datatransport.TransportRegistrar;
import com.iloen.melon.MusicBrowserActivity;
import com.iloen.melon.net.v5x.response.ListCommCodeInfoRes.RESPONSE.CODELIST;
import com.iloen.melon.net.v5x.response.ListCommCodeInfoRes.RESPONSE;
import com.iloen.melon.net.v5x.response.ListCommCodeInfoRes;
import com.iloen.melon.utils.log.LogU;
import com.iloen.melon.utils.preference.MelonPrefs;
import com.melon.ui.player.TransformableFrameLayout;
import e3.j;
import h7.O0;
import java.io.IOException;
import java.nio.charset.Charset;
import java.util.ArrayList;
import java.util.HashMap;
import k3.n;
import l3.p;
import l7.a;
import qd.X;
import s3.S;
import s3.g0;
import s3.x;
import z6.c;

public final class d implements u, e, N5.e, f, k, OnSuccess, ErrorListener, Listener, e3.e, j, n, z6.n {
    public final int a;

    public d(int v) {
        this.a = v;
        super();
    }

    public static Bitmap a(int v, byte[] arr_b) {
        try {
            return d8.d.o(arr_b, v, -1);
        }
        catch(I i0) {
            throw new n3.d("Could not decode image data with BitmapFactory. (data.length = " + arr_b.length + ", input length = " + v + ")", i0);  // 初始化器: Ljava/lang/Exception;-><init>(Ljava/lang/String;Ljava/lang/Throwable;)V
        }
        catch(IOException iOException0) {
            throw new n3.d(iOException0);  // 初始化器: Ljava/lang/Exception;-><init>(Ljava/lang/Throwable;)V
        }
    }

    @Override  // e3.e
    public void accept(Object object0) {
        ((S)object0).b.release();
    }

    @Override  // H6.e, N5.e
    public Object apply(Object object0) {
        switch(this.a) {
            case 16: {
                ((p)object0).j();
                p0 p00 = ((p)object0).e0.b;
                return V.p(w.w(new d(29), p00));
            }
            case 17: {
                a.b.getClass();
                return i7.a.a.o(((O0)object0)).getBytes(Charset.forName("UTF-8"));
            }
            case 26: {
                ((r)object0).getClass();
                return ((r)object0).getClass().getSimpleName();
            }
            case 27: {
                g0 g00 = ((x)object0).getTrackGroups();
                return V.p(w.w(new d(29), g00.b));
            }
            default: {
                return ((q0)object0).c;
            }
        }
    }

    @Override  // z6.n
    public z6.d b(z6.d d0) {
        return d0 instanceof z6.a ? new c(((z6.a)d0).a) : d0;
    }

    @Override  // Y6.f
    public Object c(Y6.u u0) {
        switch(this.a) {
            case 20: {
                return TransportRegistrar.c(u0);
            }
            case 21: {
                return TransportRegistrar.b(u0);
            }
            default: {
                return TransportRegistrar.a(u0);
            }
        }
    }

    @Override  // B3.u
    public r[] createExtractors() {
        return new r[]{new i4.c()};
    }

    private final void e(VolleyError volleyError0) {
    }

    @Override  // e3.j, co.ab180.airbridge.common.Callback
    public void invoke(Object object0) {
        switch(this.a) {
            case 0: {
                ((b)object0).getClass();
                return;
            }
            case 1: {
                ((b)object0).getClass();
                return;
            }
            case 2: {
                ((b)object0).getClass();
                return;
            }
            case 14: {
                MusicBrowserActivity.u(((Uri)object0));
                return;
            }
            default: {
                MusicBrowserActivity.N(((Uri)object0));
            }
        }
    }

    @Override  // com.android.volley.Response$ErrorListener
    public void onErrorResponse(VolleyError volleyError0) {
        if(this.a != 13) {
            return;
        }
        MusicBrowserActivity.k0(volleyError0);
    }

    @Override  // com.android.volley.Response$Listener
    public void onResponse(Object object0) {
        if(object0 instanceof ListCommCodeInfoRes && ((ListCommCodeInfoRes)object0).isSuccessful()) {
            LogU.Companion.d("MelonTiaraCodeManager", "saveTiaraCommCodeList()");
            RESPONSE listCommCodeInfoRes$RESPONSE0 = ((ListCommCodeInfoRes)object0).response;
            if(listCommCodeInfoRes$RESPONSE0 != null) {
                String s = MelonPrefs.getInstance().getString("TIARA_COMMON_CODE_VERSION", null);
                if(s == null || o.H0(s) || !s.equals(listCommCodeInfoRes$RESPONSE0.version)) {
                    ArrayList arrayList0 = listCommCodeInfoRes$RESPONSE0.codeList;
                    if(arrayList0 != null) {
                        StringBuilder stringBuilder0 = new StringBuilder();
                        int v = 0;
                        for(Object object1: arrayList0) {
                            if(v > 0) {
                                stringBuilder0.append("/");
                            }
                            stringBuilder0.append(((CODELIST)object1).codeCode);
                            stringBuilder0.append(",");
                            stringBuilder0.append(((CODELIST)object1).commCode);
                            p8.c c0 = new p8.c(((CODELIST)object1).codeCode, ((CODELIST)object1).commCode);
                            ((HashMap)p8.d.a.getValue()).put(((CODELIST)object1).commCode, c0);
                            ++v;
                        }
                        MelonPrefs.getInstance().setString("TIARA_COMMON_CODE_VERSION", listCommCodeInfoRes$RESPONSE0.version);
                        MelonPrefs.getInstance().setString("TIARA_COMMON_CODE_LIST", stringBuilder0.toString());
                    }
                }
            }
        }
    }

    @Override  // k3.n
    public void release() {
    }

    @Override  // androidx.viewpager.widget.k
    public void transformPage(View view0, float f) {
        X x0 = view0 instanceof X ? ((X)view0) : null;
        if(x0 != null) {
            we.k k0 = ((TransformableFrameLayout)x0).a;
            if(k0 != null) {
                k0.invoke(f);
            }
        }
    }
}


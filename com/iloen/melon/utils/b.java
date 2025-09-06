package com.iloen.melon.utils;

import com.android.volley.Response.ErrorListener;
import com.android.volley.Response.Listener;
import com.android.volley.VolleyError;
import com.iloen.melon.net.v4x.response.OauthUserMeRes;
import kotlin.jvm.internal.q;
import kotlinx.coroutines.BuildersKt__Builders_commonKt;
import mb.k;
import va.X;
import va.e0;
import va.o;

public final class b implements ErrorListener, Listener {
    public final Callback a;

    public b(Callback partnerUtils$Callback0) {
        this.a = partnerUtils$Callback0;
        super();
    }

    @Override  // com.android.volley.Response$ErrorListener
    public void onErrorResponse(VolleyError volleyError0) {
        Callback partnerUtils$Callback0 = this.a;
        if(partnerUtils$Callback0 != null) {
            partnerUtils$Callback0.onComplete("");
        }
    }

    @Override  // com.android.volley.Response$Listener
    public void onResponse(Object object0) {
        String s1;
        if(object0 instanceof OauthUserMeRes) {
            k k0 = o.a();
            String s = ((OauthUserMeRes)object0).id;
            q.f(s, "id");
            ((e0)k0).getClass();
            X x0 = new X(((e0)k0), s, null);
            BuildersKt__Builders_commonKt.launch$default(((e0)k0).i, null, null, x0, 3, null);
            s1 = ((OauthUserMeRes)object0).id;
            q.f(s1, "id");
        }
        else {
            s1 = "";
        }
        Callback partnerUtils$Callback0 = this.a;
        if(partnerUtils$Callback0 != null) {
            partnerUtils$Callback0.onComplete(s1);
        }
    }
}


package com.iloen.melon.custom;

import A8.u;
import android.net.Uri;
import android.text.TextUtils;
import kotlin.coroutines.Continuation;
import kotlinx.coroutines.BuildersKt__BuildersKt;
import va.e0;
import va.i0;
import va.o;
import va.t;
import x8.f;

public final class s0 extends f {
    public final MelonWebView a;

    public s0(MelonWebView melonWebView0) {
        this.a = melonWebView0;
        super();
    }

    @Override  // x8.f
    public final Object backgroundWork(Object object0, Continuation continuation0) {
        u u0;
        String s = ((Uri)object0).getQueryParameter("option");
        if(s == null || !TextUtils.isDigitsOnly(s)) {
            u0 = u.d;
        }
        else {
            u.b.getClass();
            u0 = z6.f.f(s);
        }
        e0 e00 = (e0)o.a();
        e00.getClass();
        i0 i00 = (i0)BuildersKt__BuildersKt.runBlocking$default(null, new t(e00, u0, null), 1, null);
        return ((Uri)object0).getQueryParameter("rtrnurl");
    }

    @Override  // x8.f
    public final void postTask(Object object0) {
        if(!TextUtils.isEmpty(((String)object0))) {
            this.a.loadUrl(((String)object0));
        }
    }
}


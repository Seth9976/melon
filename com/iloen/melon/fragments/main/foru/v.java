package com.iloen.melon.fragments.main.foru;

import com.android.volley.Response.ErrorListener;
import com.android.volley.Response.Listener;
import com.android.volley.VolleyError;

public final class v implements ErrorListener, Listener {
    public final int a;
    public final ForUTasteSongFragment b;

    public v(ForUTasteSongFragment forUTasteSongFragment0, int v) {
        this.a = v;
        this.b = forUTasteSongFragment0;
        super();
    }

    @Override  // com.android.volley.Response$ErrorListener
    public void onErrorResponse(VolleyError volleyError0) {
        if(this.a != 0) {
            ForUTasteSongFragment.callSaveSetAll$lambda$6(this.b, volleyError0);
            return;
        }
        ForUTasteSongFragment.onFetchStart$lambda$8(this.b, volleyError0);
    }

    @Override  // com.android.volley.Response$Listener
    public void onResponse(Object object0) {
        ForUTasteSongFragment.callSaveSetAll$lambda$5(this.b, object0);
    }
}


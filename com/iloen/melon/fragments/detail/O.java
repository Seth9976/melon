package com.iloen.melon.fragments.detail;

import com.android.volley.Response.ErrorListener;
import com.android.volley.Response.Listener;
import com.android.volley.VolleyError;
import com.iloen.melon.net.v6x.response.SnsHlyricsUploadRes;

public final class o implements ErrorListener, Listener {
    public final LyricHighLightShareFragment a;

    public o(LyricHighLightShareFragment lyricHighLightShareFragment0) {
        this.a = lyricHighLightShareFragment0;
        super();
    }

    @Override  // com.android.volley.Response$ErrorListener
    public void onErrorResponse(VolleyError volleyError0) {
        LyricHighLightShareFragment.shareHighlightImage$lambda$51$lambda$50(this.a, volleyError0);
    }

    @Override  // com.android.volley.Response$Listener
    public void onResponse(Object object0) {
        LyricHighLightShareFragment.shareHighlightImage$lambda$51$lambda$49(this.a, ((SnsHlyricsUploadRes)object0));
    }
}


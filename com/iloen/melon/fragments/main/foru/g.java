package com.iloen.melon.fragments.main.foru;

import J8.a1;
import androidx.recyclerview.widget.O0;
import com.android.volley.Response.ErrorListener;
import com.android.volley.Response.Listener;
import com.android.volley.VolleyError;
import com.iloen.melon.net.v6x.response.ForuMixMakerKeywordSelectRes;
import com.iloen.melon.net.v6x.response.ForuTasteArtistRes;
import com.iloen.melon.utils.ui.ViewTreeObserverHelper.OnGlobalLayoutListener;
import v9.i;

public final class g implements ErrorListener, Listener, OnGlobalLayoutListener {
    public final int a;
    public final Object b;
    public final Object c;

    public g(int v, Object object0, Object object1) {
        this.a = v;
        this.b = object0;
        this.c = object1;
        super();
    }

    @Override  // com.android.volley.Response$ErrorListener
    public void onErrorResponse(VolleyError volleyError0) {
        ForUMixMakerKeywordSelectFragment.onFetchStart$lambda$6(((String)this.b), ((ForUMixMakerKeywordSelectFragment)this.c), volleyError0);
    }

    @Override  // com.iloen.melon.utils.ui.ViewTreeObserverHelper$OnGlobalLayoutListener
    public void onGlobalLayout() {
        if(this.a != 0) {
            ForUMixMakerMainFragment.updateUi$lambda$39$lambda$38$lambda$37(((a1)this.b), ((ForUMixMakerMainFragment)this.c));
            return;
        }
        MixMakerKeywordSelectAdapter.onBindViewImpl$lambda$7$lambda$6(((O0)this.b), ((MixMakerKeywordSelectAdapter)this.c));
    }

    @Override  // com.android.volley.Response$Listener
    public void onResponse(Object object0) {
        if(this.a != 1) {
            ForUTasteArtistFragment.onFetchStart$lambda$3(((ForUTasteArtistFragment)this.b), ((i)this.c), ((ForuTasteArtistRes)object0));
            return;
        }
        ForUMixMakerKeywordSelectFragment.onFetchStart$lambda$4(((ForUMixMakerKeywordSelectFragment)this.b), ((i)this.c), ((ForuMixMakerKeywordSelectRes)object0));
    }
}


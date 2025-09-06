package com.iloen.melon.fragments.melontv;

import com.android.volley.Response.ErrorListener;
import com.android.volley.VolleyError;
import com.iloen.melon.adapters.MelonTvAdapter.OnInfoBtnClick;
import com.iloen.melon.playback.Playable;

public final class d implements a9.d, ErrorListener, OnInfoBtnClick {
    public final int a;
    public final Object b;

    public d(Object object0, int v) {
        this.a = v;
        this.b = object0;
        super();
    }

    @Override  // com.iloen.melon.adapters.MelonTvAdapter$OnInfoBtnClick
    public void a(Playable playable0) {
        if(this.a != 1) {
            ((MelonTvPopularFragment)this.b).lambda$createRecyclerViewAdapter$1(playable0);
            return;
        }
        MelonTvNewFragment.createRecyclerViewAdapter$lambda$3$lambda$2(((MelonTvNewFragment)this.b), playable0);
    }

    @Override  // com.android.volley.Response$ErrorListener
    public void onErrorResponse(VolleyError volleyError0) {
        MelonTvProgramSelectFragment.onFetchStart$lambda$0(((MelonTvProgramSelectFragment)this.b), volleyError0);
    }

    @Override  // a9.d
    public void onSelected(int v) {
        ((MusicVideoAdapter)this.b).lambda$onBindViewImpl$0(v);
    }
}


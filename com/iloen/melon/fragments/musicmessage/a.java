package com.iloen.melon.fragments.musicmessage;

import androidx.activity.result.ActivityResult;
import com.android.volley.Response.ErrorListener;
import com.android.volley.Response.Listener;
import com.android.volley.VolleyError;
import com.iloen.melon.net.v6x.response.CleanIsBlackRes;
import com.iloen.melon.net.v6x.response.MusicMessageDeleteBanUserRes;
import com.iloen.melon.net.v6x.response.MusicMessageInsertBanUserRes;
import com.iloen.melon.net.v6x.response.MusicMessageInsertMusicMsgRes;

public final class a implements ErrorListener, Listener, e.a {
    public final int a;
    public final MusicMessageEditorFragment b;

    public a(MusicMessageEditorFragment musicMessageEditorFragment0, int v) {
        this.a = v;
        this.b = musicMessageEditorFragment0;
        super();
    }

    @Override  // e.a
    public void onActivityResult(Object object0) {
        MusicMessageEditorFragment.searchActivityResult$lambda$1(this.b, ((ActivityResult)object0));
    }

    @Override  // com.android.volley.Response$ErrorListener
    public void onErrorResponse(VolleyError volleyError0) {
        MusicMessageEditorFragment.g0(this.b, volleyError0);
    }

    @Override  // com.android.volley.Response$Listener
    public void onResponse(Object object0) {
        switch(this.a) {
            case 1: {
                MusicMessageEditorFragment.h0(this.b, ((CleanIsBlackRes)object0));
                return;
            }
            case 2: {
                MusicMessageEditorFragment.j0(this.b, ((MusicMessageDeleteBanUserRes)object0));
                return;
            }
            case 3: {
                MusicMessageEditorFragment.x0(this.b, ((MusicMessageInsertMusicMsgRes)object0));
                return;
            }
            default: {
                MusicMessageEditorFragment.blockUser$lambda$43$lambda$41(this.b, ((MusicMessageInsertBanUserRes)object0));
            }
        }
    }
}


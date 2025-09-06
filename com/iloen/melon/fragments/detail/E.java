package com.iloen.melon.fragments.detail;

import androidx.activity.result.ActivityResult;
import androidx.core.widget.NestedScrollView;
import androidx.core.widget.h;
import androidx.fragment.app.I;
import com.android.volley.Response.ErrorListener;
import com.android.volley.Response.Listener;
import com.android.volley.VolleyError;
import com.iloen.melon.custom.J;
import com.iloen.melon.custom.S;
import e.a;

public final class e implements h, ErrorListener, Listener, J, a {
    public final int a;
    public final I b;

    public e(I i0, int v) {
        this.a = v;
        this.b = i0;
        super();
    }

    @Override  // com.iloen.melon.custom.J
    public void a(S s0, boolean z) {
        PlaylistDetailContentsAllSongBaseFragment.makeHeaderView$lambda$3(((PlaylistDetailContentsAllSongBaseFragment)this.b), s0, z);
    }

    @Override  // androidx.core.widget.h
    public void j(NestedScrollView nestedScrollView0, int v, int v1, int v2, int v3) {
        DetailContentsAlbumInfoFragment.initUi$lambda$3(((DetailContentsAlbumInfoFragment)this.b), nestedScrollView0, v, v1, v2, v3);
    }

    @Override  // e.a
    public void onActivityResult(Object object0) {
        ((PlaylistMakeFragment)this.b).lambda$new$0(((ActivityResult)object0));
    }

    @Override  // com.android.volley.Response$ErrorListener
    public void onErrorResponse(VolleyError volleyError0) {
        switch(this.a) {
            case 0: {
                ArtistPlaylistDetailContentsAllSongFragment.onFetchStart$lambda$3(((ArtistPlaylistDetailContentsAllSongFragment)this.b), volleyError0);
                return;
            }
            case 2: {
                DjPlaylistDetailContentsAllSongFragment.onFetchStart$lambda$3(((DjPlaylistDetailContentsAllSongFragment)this.b), volleyError0);
                return;
            }
            default: {
                PlaylistDetailContentsAllSongFragment.onFetchStart$lambda$3(((PlaylistDetailContentsAllSongFragment)this.b), volleyError0);
            }
        }
    }

    @Override  // com.android.volley.Response$Listener
    public void onResponse(Object object0) {
        LyricHighLightFragment.onToolBarClick$lambda$8(((LyricHighLightFragment)this.b), object0);
    }
}


package com.iloen.melon.fragments.searchandadd;

import android.view.View;
import com.android.volley.Response.ErrorListener;
import com.android.volley.VolleyError;
import com.iloen.melon.sns.model.Sharable;

public final class m implements ErrorListener, OnItemEventListener, OnItemViewClickListener {
    public final int a;
    public final SearchAndAddBaseFragment b;

    public m(SearchAndAddBaseFragment searchAndAddBaseFragment0, int v) {
        this.a = v;
        this.b = searchAndAddBaseFragment0;
        super();
    }

    @Override  // com.iloen.melon.fragments.searchandadd.SearchAndAddBaseAdapter$OnItemEventListener
    public boolean onAdd(Sharable sharable0) {
        switch(this.a) {
            case 0: {
                return SearchAndAddBaseFragment.mSongItemEventListener$lambda$5(this.b, sharable0);
            }
            case 1: {
                return SearchAndAddBaseFragment.mMvItemEventListener$lambda$6(this.b, sharable0);
            }
            default: {
                return SearchAndAddBaseFragment.mContentItemEventListener$lambda$7(this.b, sharable0);
            }
        }
    }

    @Override  // com.android.volley.Response$ErrorListener
    public void onErrorResponse(VolleyError volleyError0) {
        PlaylistSearchAndAddPlaylistFragment.fetchPlaylistSongs$lambda$2(((PlaylistSearchAndAddPlaylistFragment)this.b), volleyError0);
    }

    @Override  // com.iloen.melon.fragments.searchandadd.SearchAndAddBaseAdapter$OnItemViewClickListener
    public void onItemViewClick(View view0, int v) {
        SearchAndAddBaseFragment.mOnItemViewClickListener$lambda$8(this.b, view0, v);
    }
}


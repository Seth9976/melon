package com.iloen.melon.fragments.searchandadd;

import android.view.View.OnFocusChangeListener;
import android.view.View;

public final class i implements View.OnFocusChangeListener {
    public final PlaylistSearchAndAddTabFragment a;

    public i(PlaylistSearchAndAddTabFragment playlistSearchAndAddTabFragment0) {
        this.a = playlistSearchAndAddTabFragment0;
    }

    @Override  // android.view.View$OnFocusChangeListener
    public final void onFocusChange(View view0, boolean z) {
        PlaylistSearchAndAddTabFragment.onViewCreated$lambda$12(this.a, view0, z);
    }
}


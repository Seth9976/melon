package com.iloen.melon.fragments.searchandadd;

import android.view.View.OnClickListener;
import android.view.View;

public final class k implements View.OnClickListener {
    public final int a;
    public final PlaylistSearchAndAddTabFragment b;

    public k(PlaylistSearchAndAddTabFragment playlistSearchAndAddTabFragment0, int v) {
        this.a = v;
        this.b = playlistSearchAndAddTabFragment0;
        super();
    }

    @Override  // android.view.View$OnClickListener
    public final void onClick(View view0) {
        switch(this.a) {
            case 0: {
                ToggleFilterHolder._init_$lambda$0(this.b, view0);
                return;
            }
            case 1: {
                PlaylistSearchAndAddTabFragment.onViewCreated$lambda$11(this.b, view0);
                return;
            }
            case 2: {
                PlaylistSearchAndAddTabFragment.onViewCreated$lambda$6(this.b, view0);
                return;
            }
            case 3: {
                PlaylistSearchAndAddTabFragment.onViewCreated$lambda$8$lambda$7(this.b, view0);
                return;
            }
            case 4: {
                PlaylistSearchAndAddTabFragment.onViewCreated$lambda$9(this.b, view0);
                return;
            }
            default: {
                PlaylistSearchAndAddTabFragment.onViewCreated$lambda$10(this.b, view0);
            }
        }
    }
}


package com.iloen.melon.fragments.searchandadd;

import a9.d;
import android.widget.TextView;
import com.iloen.melon.fragments.MelonBaseFragment;

public final class b implements d {
    public final int a;
    public final TextView b;
    public final MelonBaseFragment c;

    public b(MelonBaseFragment melonBaseFragment0, TextView textView0, int v) {
        this.a = v;
        this.c = melonBaseFragment0;
        this.b = textView0;
        super();
    }

    @Override  // a9.d
    public final void onSelected(int v) {
        if(this.a != 0) {
            PlaylistSearchAndAddTabFragment.showContextPopupSort$lambda$18(((PlaylistSearchAndAddTabFragment)this.c), this.b, v);
            return;
        }
        PlaylistSearchAndAddLikeFragment.showContextPopupSort$lambda$3(((PlaylistSearchAndAddLikeFragment)this.c), this.b, v);
    }
}


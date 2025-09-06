package com.iloen.melon.fragments.searchandadd;

import com.iloen.melon.fragments.MelonBaseFragment;
import java.util.ArrayList;
import we.k;

public final class a implements k {
    public final int a;
    public final MelonBaseFragment b;

    public a(MelonBaseFragment melonBaseFragment0, int v) {
        this.a = v;
        this.b = melonBaseFragment0;
        super();
    }

    @Override  // we.k
    public final Object invoke(Object object0) {
        switch(this.a) {
            case 0: {
                return PlaylistSearchAndAddLikeFragment.onCreate$lambda$2(((PlaylistSearchAndAddLikeFragment)this.b), ((ArrayList)object0));
            }
            case 1: {
                return PlaylistSearchAndAddPlaylistFragment.onViewCreated$lambda$1(((PlaylistSearchAndAddPlaylistFragment)this.b), ((ArrayList)object0));
            }
            case 2: {
                return PlaylistSearchAndAddRecentFragment.onCreate$lambda$1(((PlaylistSearchAndAddRecentFragment)this.b), ((ArrayList)object0));
            }
            case 3: {
                return PlaylistSearchAndAddSongListFragment.onCreate$lambda$1(((PlaylistSearchAndAddSongListFragment)this.b), ((ArrayList)object0));
            }
            default: {
                return PlaylistSearchAndAddTabFragment.onCreate$lambda$4(((PlaylistSearchAndAddTabFragment)this.b), ((ArrayList)object0));
            }
        }
    }
}


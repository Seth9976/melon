package com.iloen.melon.player.playlist.mixup;

import Jd.b;
import Jd.c;
import Jd.d;
import com.iloen.melon.custom.ToolBar.ToolBarItem;
import com.iloen.melon.custom.s1;
import com.melon.ui.M0;
import java.util.List;

public final class f implements s1, M0 {
    public final Object a;

    public f(Object object0) {
        this.a = object0;
        super();
    }

    @Override  // com.melon.ui.M0
    public void a(boolean z, boolean z1) {
        MixUpPlaylistComposeViewModel.access$playDjMalrangAfterLocationAgreementAndPermissionCheck(((MixUpPlaylistComposeViewModel)this.a), z, z1);
    }

    @Override  // com.iloen.melon.custom.s1
    public void onToolBarItemClicked(ToolBarItem toolBar$ToolBarItem0, int v) {
        MixUpPlaylistComposeFragment mixUpPlaylistComposeFragment0 = (MixUpPlaylistComposeFragment)this.a;
        List list0 = ((MixUpPlaylistComposeViewModel)mixUpPlaylistComposeFragment0.getViewModel()).getSelectedPlayableList();
        switch(v) {
            case 1: {
                mixUpPlaylistComposeFragment0.sendUserEvent(c.c);
                mixUpPlaylistComposeFragment0.n().logClickDownloadFromToolbar(list0);
                return;
            }
            case 2: {
                mixUpPlaylistComposeFragment0.sendUserEvent(b.c);
                mixUpPlaylistComposeFragment0.n().logClickPutFromToolbar(list0);
                return;
            }
            case 4: {
                ((MixUpPlaylistComposeViewModel)mixUpPlaylistComposeFragment0.getViewModel()).deleteSelected();
                mixUpPlaylistComposeFragment0.n().logClickRemoveFromToolbar(list0);
                return;
            }
            case 0x1F: {
                mixUpPlaylistComposeFragment0.sendUserEvent(d.c);
                mixUpPlaylistComposeFragment0.n().logClickMixUpFromToolbar(list0);
            }
        }
    }
}


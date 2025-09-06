package com.iloen.melon.player.playlist.drawernew;

import Jd.b;
import Jd.c;
import Jd.d;
import com.iloen.melon.custom.ToolBar.ToolBarItem;
import com.iloen.melon.custom.s1;
import com.iloen.melon.player.playlist.tiara.PlaylistSongBaseTiaraLogHelper.TiaraMixUpEventMeta;

public final class j implements s1 {
    public final DrawerSongFragment a;

    public j(DrawerSongFragment drawerSongFragment0) {
        this.a = drawerSongFragment0;
    }

    @Override  // com.iloen.melon.custom.s1
    public final void onToolBarItemClicked(ToolBarItem toolBar$ToolBarItem0, int v) {
        c c0;
        DrawerSongFragment drawerSongFragment0 = this.a;
        TiaraMixUpEventMeta playlistSongBaseTiaraLogHelper$TiaraMixUpEventMeta0 = v == 0x1F ? ((DrawerSongFragmentViewModel)drawerSongFragment0.getViewModel()).getTiaraEventMetaForMixUp() : null;
        ((DrawerSongFragmentViewModel)drawerSongFragment0.getViewModel()).getTiaraLogHelper().sendToolbarClickEvent(v, playlistSongBaseTiaraLogHelper$TiaraMixUpEventMeta0);
        switch(v) {
            case 1: {
                c0 = c.c;
                break;
            }
            case 2: {
                c0 = b.c;
                break;
            }
            case 4: {
                c0 = ToolBarClickRemoveUserEvent.INSTANCE;
                break;
            }
            case 19: {
                c0 = ToolBarClickReplayUserEvent.INSTANCE;
                break;
            }
            case 0x1F: {
                c0 = d.c;
                break;
            }
            default: {
                return;
            }
        }
        drawerSongFragment0.sendUserEvent(c0);
    }
}


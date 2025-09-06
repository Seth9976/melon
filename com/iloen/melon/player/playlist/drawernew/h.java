package com.iloen.melon.player.playlist.drawernew;

import Lb.d;
import com.iloen.melon.player.playlist.common.SectionSelectUserEvent.ClickSectionSelectButton;
import com.iloen.melon.player.playlist.common.SectionSelectUserEvent.ClickSectionSelectCancelButton;
import ie.H;
import we.a;

public final class h implements a {
    public final int a;
    public final DrawerSongFragment b;

    public h(DrawerSongFragment drawerSongFragment0, int v) {
        this.a = v;
        this.b = drawerSongFragment0;
        super();
    }

    @Override  // we.a
    public final Object invoke() {
        H h0 = H.a;
        DrawerSongFragment drawerSongFragment0 = this.b;
        switch(this.a) {
            case 0: {
                drawerSongFragment0.sendUserEvent(OnTouchDownMoveIconWhenSelectRepeatOn.INSTANCE);
                return h0;
            }
            case 1: {
                drawerSongFragment0.sendUserEvent(OnClickHeader.INSTANCE);
                return h0;
            }
            case 2: {
                drawerSongFragment0.sendUserEvent(ClickAllSelectUserEvent.INSTANCE);
                return h0;
            }
            case 3: {
                drawerSongFragment0.sendUserEvent(d.a);
                return h0;
            }
            case 4: {
                drawerSongFragment0.sendUserEvent(ClickSectionSelectButton.INSTANCE);
                return h0;
            }
            case 5: {
                drawerSongFragment0.sendUserEvent(ClickSectionSelectCancelButton.INSTANCE);
                return h0;
            }
            case 6: {
                ((DrawerSongFragmentViewModel)drawerSongFragment0.getViewModel()).unSelectAll();
                return h0;
            }
            default: {
                ((DrawerSongFragmentViewModel)drawerSongFragment0.getViewModel()).unSelectAll();
                ((DrawerSongFragmentViewModel)drawerSongFragment0.getViewModel()).setIsDragging(true);
                return h0;
            }
        }
    }
}


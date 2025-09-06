package com.iloen.melon.player.playlist.music;

import Jd.c;
import com.iloen.melon.custom.ToolBar.ToolBarItem;
import com.iloen.melon.custom.s1;
import com.iloen.melon.player.playlist.tiara.PlaylistSongBaseTiaraLogHelper.TiaraMixUpEventMeta;
import kotlin.jvm.internal.q;
import oc.p0;
import oc.q0;
import oc.r0;
import oc.s0;
import oc.t0;
import oc.u0;
import oc.v0;
import oc.w0;
import oc.x0;

public final class d implements a9.d, s1 {
    public final MusicPlaylistBaseFragment a;

    public d(MusicPlaylistBaseFragment musicPlaylistBaseFragment0) {
        this.a = musicPlaylistBaseFragment0;
        super();
    }

    @Override  // a9.d
    public void onSelected(int v) {
        t0 t00;
        switch(v) {
            case 0: {
                t00 = t0.b;
                break;
            }
            case 1: {
                t00 = s0.b;
                break;
            }
            case 2: {
                t00 = u0.b;
                break;
            }
            case 3: {
                t00 = v0.b;
                break;
            }
            case 4: {
                t00 = q0.b;
                break;
            }
            case 5: {
                t00 = r0.b;
                break;
            }
            case 6: {
                t00 = w0.b;
                break;
            }
            case 7: {
                t00 = x0.b;
                break;
            }
            case 8: {
                t00 = p0.b;
                break;
            }
            default: {
                throw new IllegalArgumentException("Unknown sort type: " + v);
            }
        }
        String s = ((String[])this.a.h.getValue())[v];
        q.f(s, "get(...)");
        ClickSortTypeInPopupUserEvent musicPlaylistBaseUserEvent$ClickSortTypeInPopupUserEvent0 = new ClickSortTypeInPopupUserEvent(t00, s);
        this.a.sendUserEvent(musicPlaylistBaseUserEvent$ClickSortTypeInPopupUserEvent0);
    }

    @Override  // com.iloen.melon.custom.s1
    public void onToolBarItemClicked(ToolBarItem toolBar$ToolBarItem0, int v) {
        c c0;
        MusicPlaylistBaseFragment musicPlaylistBaseFragment0 = this.a;
        TiaraMixUpEventMeta playlistSongBaseTiaraLogHelper$TiaraMixUpEventMeta0 = v == 0x1F ? ((MusicPlaylistBaseViewModel)musicPlaylistBaseFragment0.getViewModel()).getTiaraEventMetaForMixUp() : null;
        musicPlaylistBaseFragment0.getTiaraLogHelper().sendToolbarClickEvent(v, playlistSongBaseTiaraLogHelper$TiaraMixUpEventMeta0);
        switch(v) {
            case 1: {
                c0 = c.c;
                break;
            }
            case 2: {
                c0 = ToolBarClickPutUserEvent.INSTANCE;
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
                c0 = Jd.d.c;
                break;
            }
            default: {
                return;
            }
        }
        musicPlaylistBaseFragment0.sendUserEvent(c0);
    }
}


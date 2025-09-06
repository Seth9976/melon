package com.iloen.melon.player.playlist;

import androidx.fragment.app.FragmentActivity;
import androidx.lifecycle.f0;
import com.iloen.melon.popup.SmartPlayerSettingPopup;
import ie.H;
import kc.d3;
import kotlinx.coroutines.BuildersKt__Builders_commonKt;
import od.b;
import we.a;

public final class k implements a {
    public final int a;
    public final PlaylistMainFragment b;

    public k(PlaylistMainFragment playlistMainFragment0, int v) {
        this.a = v;
        this.b = playlistMainFragment0;
        super();
    }

    @Override  // we.a
    public final Object invoke() {
        H h0 = H.a;
        PlaylistMainFragment playlistMainFragment0 = this.b;
        switch(this.a) {
            case 0: {
                BuildersKt__Builders_commonKt.launch$default(f0.f(playlistMainFragment0), null, null, new com.iloen.melon.player.playlist.PlaylistMainFragment.playlistPopupListener.1.1.1.1(playlistMainFragment0, null), 3, null);
                return h0;
            }
            case 1: {
                return playlistMainFragment0.getContext();
            }
            case 2: {
                return ((d3)((PlaylistMainViewModel)playlistMainFragment0.getViewModel()).getPlaylistManager()).f();
            }
            case 3: {
                return ((d3)((PlaylistMainViewModel)playlistMainFragment0.getViewModel()).getPlaylistManager()).k();
            }
            case 4: {
                return playlistMainFragment0.o().getFocusingTabTiaraProperty();
            }
            case 5: {
                return new b(new k(playlistMainFragment0, 7));
            }
            case 6: {
                return ((b)playlistMainFragment0.i.getValue()).c();
            }
            case 7: {
                return ((PlaylistMainViewModel)playlistMainFragment0.getViewModel()).getCurrentPlaylistDJMalrangInfo();
            }
            case 8: {
                FragmentActivity fragmentActivity0 = playlistMainFragment0.getActivity();
                if(fragmentActivity0 != null) {
                    playlistMainFragment0.dismissRetainedPopup();
                    SmartPlayerSettingPopup smartPlayerSettingPopup0 = new SmartPlayerSettingPopup(fragmentActivity0, playlistMainFragment0.n);
                    smartPlayerSettingPopup0.setOnDismissListener(playlistMainFragment0.getRetainDismissListener());
                    playlistMainFragment0.setRetainDialog(smartPlayerSettingPopup0);
                    smartPlayerSettingPopup0.show();
                }
                playlistMainFragment0.q().logClickSetting();
                return h0;
            }
            case 9: {
                playlistMainFragment0.sendUserEvent(ClickPrevButton.INSTANCE);
                playlistMainFragment0.q().logClickPrev();
                return h0;
            }
            case 10: {
                playlistMainFragment0.sendUserEvent(ClickNextButton.INSTANCE);
                playlistMainFragment0.q().logClickNext();
                return h0;
            }
            case 11: {
                playlistMainFragment0.q().logClickGoToPlayer();
                playlistMainFragment0.sendUserEvent(ClickAlbumArtButton.INSTANCE);
                return h0;
            }
            default: {
                return new PlaylistMainTiaraLogHelper(new k(playlistMainFragment0, 1), new k(playlistMainFragment0, 2), new k(playlistMainFragment0, 3), new k(playlistMainFragment0, 4), new g(playlistMainFragment0, 1), new g(playlistMainFragment0, 2), new g(playlistMainFragment0, 3), new k(playlistMainFragment0, 6), new g(playlistMainFragment0, 4));
            }
        }
    }
}


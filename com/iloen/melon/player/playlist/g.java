package com.iloen.melon.player.playlist;

import U8.l;
import androidx.fragment.app.FragmentActivity;
import androidx.fragment.app.l0;
import androidx.lifecycle.f0;
import com.iloen.melon.fragments.musicmessage.e;
import com.iloen.melon.net.RequestBuilder;
import com.iloen.melon.net.v4x.request.MyMusicDjPlaylistInformCntCheckReq;
import com.iloen.melon.playback.Playable;
import com.iloen.melon.popup.RemoteConnectPopup;
import com.iloen.melon.utils.Navigator;
import com.melon.ui.K1;
import com.melon.ui.k2;
import ie.H;
import kotlin.jvm.internal.q;
import kotlinx.coroutines.BuildersKt__Builders_commonKt;
import od.b;
import we.k;

public final class g implements k {
    public final int a;
    public final PlaylistMainFragment b;

    public g(PlaylistMainFragment playlistMainFragment0, int v) {
        this.a = v;
        this.b = playlistMainFragment0;
        super();
    }

    @Override  // we.k
    public final Object invoke(Object object0) {
        H h0 = H.a;
        PlaylistMainFragment playlistMainFragment0 = this.b;
        switch(this.a) {
            case 0: {
                int v = (int)(((Integer)object0));
                FragmentActivity fragmentActivity0 = playlistMainFragment0.getActivity();
                if(fragmentActivity0 != null && !fragmentActivity0.isFinishing() && !fragmentActivity0.isDestroyed()) {
                    switch(v) {
                        case 0: {
                            l l0 = new l();
                            Navigator.INSTANCE.open(l0);
                            break;
                        }
                        case 1: {
                            l0 l00 = playlistMainFragment0.getChildFragmentManager();
                            q.f(l00, "getChildFragmentManager(...)");
                            RemoteConnectPopup remoteConnectPopup0 = RemoteConnectPopup.Companion.newInstance();
                            remoteConnectPopup0.setDismissListener(new vd.H(null));
                            remoteConnectPopup0.show(l00, "PlaylistMainFragment");
                            return h0;
                        label_25:
                            if(v == 2) {
                                BuildersKt__Builders_commonKt.launch$default(f0.f(playlistMainFragment0), null, null, new com.iloen.melon.player.playlist.PlaylistMainFragment.playlistPopupListener.1.1(playlistMainFragment0, null), 3, null);
                                return h0;
                            }
                            break;
                        }
                        default: {
                            goto label_25;
                        }
                    }
                }
                return h0;
            }
            case 1: {
                q.g(((PlaylistTab)object0), "page");
                return playlistMainFragment0.o().getTabTiaraProperty(((PlaylistTab)object0));
            }
            case 2: {
                return ((b)playlistMainFragment0.i.getValue()).a(((Playable)object0));
            }
            case 3: {
                Playable playable0 = (Playable)object0;
                return ((b)playlistMainFragment0.i.getValue()).b();
            }
            case 4: {
                return ((b)playlistMainFragment0.i.getValue()).d(playlistMainFragment0.getContext(), ((Playable)object0));
            }
            default: {
                q.g(((k2)object0), "onEvent");
                if(((k2)object0) instanceof K1) {
                    switch(((K1)(((k2)object0))).b.a.ordinal()) {
                        case 33: {
                            playlistMainFragment0.checkWithMakePlaylist();
                            break;
                        }
                        case 34: {
                            if(!((PlaylistMainViewModel)playlistMainFragment0.getViewModel()).isLoginUser()) {
                                com.melon.ui.popup.b.l(playlistMainFragment0.getContext(), playlistMainFragment0.getChildFragmentManager(), null, 12);
                                return h0;
                            }
                            RequestBuilder.newInstance(new MyMusicDjPlaylistInformCntCheckReq(playlistMainFragment0.getContext())).tag("PlaylistMainFragment").listener(new f(playlistMainFragment0, 1)).errorListener(new e(21)).request();
                            return h0;
                        }
                        default: {
                            return h0;
                        }
                    }
                }
                return h0;
            }
        }
    }
}


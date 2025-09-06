package com.iloen.melon.player.playlist.common;

import Cb.i;
import De.w;
import Tf.l;
import X0.s;
import X0.u;
import X0.x;
import a7.c;
import com.iloen.melon.fragments.mymusic.dna.d;
import com.iloen.melon.playback.Playable;
import com.iloen.melon.player.playlist.drawernew.DrawerSongUiState.Idle;
import com.iloen.melon.player.playlist.drawernew.DrawerUiState.Loading;
import com.iloen.melon.player.playlist.drawernew.DrawerUiState.NeedLogin;
import com.iloen.melon.player.playlist.mixup.MixUpUIItemData;
import com.iloen.melon.player.playlist.music.MusicPlaylistUiState.Success;
import com.iloen.melon.player.video.VideoOneDepthContentType;
import com.melon.net.ApiClient;
import com.melon.net.res.common.ArtistsInfoBase;
import com.melon.playback.melon.streaming.tracker.NetworkEvents;
import com.melon.ui.K4;
import d5.n;
import dc.a;
import ie.H;
import java.util.Collection;
import java.util.Map.Entry;
import je.p;
import kotlin.jvm.internal.q;
import oc.c0;
import okhttp3.OkHttpClient.Builder;
import p8.f;
import q8.b;
import we.k;

public final class h implements k {
    public final int a;

    public h(int v) {
        this.a = v;
        super();
    }

    @Override  // we.k
    public final Object invoke(Object object0) {
        boolean z = true;
        H h0 = H.a;
        switch(this.a) {
            case 0: {
                ((Integer)object0).getClass();
                return h0;
            }
            case 1: {
                q.g(((x)object0), "$this$semantics");
                u.e(((x)object0));
                return h0;
            }
            case 2: {
                q.g(((x)object0), "$this$semantics");
                u.m(((x)object0));
                w w0 = u.a[9];
                s.r.a(((x)object0), 0.0f);
                return h0;
            }
            case 3: {
                q.g(((x)object0), "$this$semantics");
                u.m(((x)object0));
                w w1 = u.a[9];
                s.r.a(((x)object0), 1.0f);
                return h0;
            }
            case 4: {
                q.g(((x)object0), "$this$semantics");
                u.k(((x)object0), 2);
                return h0;
            }
            case 5: {
                q.g(((K4)object0), "it");
                return Loading.INSTANCE;
            }
            case 6: {
                q.g(((K4)object0), "it");
                return NeedLogin.INSTANCE;
            }
            case 7: {
                K4 k40 = (K4)object0;
                return Loading.INSTANCE;
            }
            case 8: {
                q.g(((K4)object0), "it");
                return Idle.INSTANCE;
            }
            case 9: {
                q.g(((String)object0), "it");
                return (String)object0;
            }
            case 10: {
                q.g(((x)object0), "$this$semantics");
                u.m(((x)object0));
                return h0;
            }
            case 11: {
                q.g(((x)object0), "$this$semantics");
                u.e(((x)object0));
                return h0;
            }
            case 12: {
                q.g(((MixUpUIItemData)object0), "item");
                return ((MixUpUIItemData)object0).getId();
            }
            case 13: {
                q.g(((MixUpUIItemData)object0), "item");
                return i.o(((MixUpUIItemData)object0));
            }
            case 14: {
                q.g(((K4)object0), "it");
                return com.iloen.melon.player.playlist.music.MusicPlaylistUiState.Loading.INSTANCE;
            }
            case 15: {
                q.g(((Success)object0), "prevState");
                return Success.copy$default(((Success)object0), null, false, false, null, null, null, 0, c0.d, 0x7F, null);
            }
            case 16: {
                q.g(((Success)object0), "prevState");
                return Success.copy$default(((Success)object0), null, false, false, null, null, null, 0, c0.b, 0x7F, null);
            }
            case 17: {
                if(((Playable)object0) == null) {
                    return VideoOneDepthContentType.INFO;
                }
                if(((Playable)object0).isOnAir()) {
                    return VideoOneDepthContentType.CHAT;
                }
                return ((Playable)object0).isLivePreView() ? VideoOneDepthContentType.LIVE_PREVIEW : VideoOneDepthContentType.INFO;
            }
            case 18: {
                q.g(((l)object0), "it");
                return "♩♪♬";
            }
            case 19: {
                q.g(((f)object0), "$this$trackTiaraEventLog");
                ((f)object0).a = "";
                ((f)object0).y = "";
                return (f)object0;
            }
            case 20: {
                q.g(((f)object0), "$this$trackTiaraEventLog");
                ((f)object0).a = "";
                ((f)object0).y = "";
                ((f)object0).F = "";
                return (f)object0;
            }
            case 21: {
                q.g(((b)object0), "$this$common");
                ((b)object0).c(new com.iloen.melon.popup.H(0));
                ((b)object0).b(new com.iloen.melon.popup.H(1));
                return h0;
            }
            case 22: {
                q.g(((b)object0), "$this$common");
                ((b)object0).a(new d(26));
                ((b)object0).c(new d(27));
                ((b)object0).b(new d(28));
                return h0;
            }
            case 23: {
                l2.b b0 = (l2.b)object0;
                q.g(b0, "it");
                try {
                    c.a().c(b0);
                    return new q2.b(true);
                }
                catch(Throwable throwable0) {
                    n.t(throwable0);
                    return new q2.b(true);
                }
            }
            case 24: {
                q.g(((Map.Entry)object0), "it");
                if(((Number)((Map.Entry)object0).getValue()).longValue() + 86400000L >= System.currentTimeMillis()) {
                    z = false;
                }
                return Boolean.valueOf(z);
            }
            case 25: {
                q.g(((Map.Entry)object0), "it");
                if(((Number)((Map.Entry)object0).getValue()).longValue() + 86400000L >= System.currentTimeMillis()) {
                    z = false;
                }
                return Boolean.valueOf(z);
            }
            case 26: {
                q.g(((Map.Entry)object0), "it");
                if(((Number)((Map.Entry)object0).getValue()).longValue() >= System.currentTimeMillis()) {
                    z = false;
                }
                return Boolean.valueOf(z);
            }
            case 27: {
                q.g(((ArtistsInfoBase)object0), "it");
                String s = ((ArtistsInfoBase)object0).getArtistName();
                return s == null ? "" : s;
            }
            case 28: {
                return ApiClient.a(((Builder)object0));
            }
            default: {
                q.g(((NetworkEvents)object0), "previous");
                Collection collection0 = ((NetworkEvents)object0).getEvents();
                return NetworkEvents.copy$default(((NetworkEvents)object0), p.z0(new a("dnsEnd", System.currentTimeMillis()), collection0), null, null, null, null, 30, null);
            }
        }
    }
}


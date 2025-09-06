package com.iloen.melon.fragments.artistchannel.viewholder;

import G4.a;
import Qb.z;
import X0.u;
import X0.x;
import com.iloen.melon.fragments.detail.StationEpisodeDetailFragment;
import com.iloen.melon.fragments.melonchart.MelonChartPeriodFragment;
import com.iloen.melon.fragments.settings.SettingMainFragment;
import com.iloen.melon.net.v4x.response.StreamGetPathRes;
import com.iloen.melon.net.v5x.response.CreatorInfoBase.ContsList;
import com.iloen.melon.playback.GalaxyBudsReceiver;
import com.iloen.melon.playback.Playable;
import com.iloen.melon.playback.TaskUpdateLocalPlaylists;
import com.iloen.melon.playback.playlist.db.PlaylistDao_Impl;
import com.iloen.melon.playback.voicealarm.VoiceAlarmPlay;
import ie.H;
import java.util.List;
import kotlin.jvm.internal.q;
import oc.U;
import we.k;

public final class f implements k {
    public final int a;

    public f(int v) {
        this.a = v;
        super();
    }

    @Override  // we.k
    public final Object invoke(Object object0) {
        switch(this.a) {
            case 0: {
                return ArtistFanLoungeHolder.FanLoungeButton$lambda$8$lambda$6$lambda$5(((x)object0));
            }
            case 1: {
                return ArtistHiRisingHolderKt.ArtistHiRisingSlot$lambda$5$lambda$1$lambda$0(((x)object0));
            }
            case 2: {
                return ArtistMixUpHolder.MixUpButton$lambda$8$lambda$6$lambda$5(((x)object0));
            }
            case 3: {
                return ArtistSpotlightHolderKt.ArtistSpotlightSlot$lambda$5$lambda$1$lambda$0(((x)object0));
            }
            case 4: {
                return StationEpisodeDetailFragment.s0(((ContsList)object0));
            }
            case 5: {
                return StationEpisodeDetailFragment.u0(((ContsList)object0));
            }
            case 6: {
                return StationEpisodeDetailFragment.x0(((ContsList)object0));
            }
            case 7: {
                return MelonChartPeriodFragment.z0(((x)object0));
            }
            case 8: {
                return MelonChartPeriodFragment.A0(((x)object0));
            }
            case 9: {
                return SettingMainFragment.q0(((List)object0));
            }
            case 10: {
                return GalaxyBudsReceiver.a(((z)object0));
            }
            case 11: {
                return TaskUpdateLocalPlaylists.a(((Playable)object0));
            }
            case 12: {
                return PlaylistDao_Impl.B(((a)object0));
            }
            case 13: {
                return PlaylistDao_Impl.X(((a)object0));
            }
            case 14: {
                return PlaylistDao_Impl.J(((a)object0));
            }
            case 15: {
                return PlaylistDao_Impl.x(((a)object0));
            }
            case 16: {
                return PlaylistDao_Impl.d(((a)object0));
            }
            case 17: {
                return PlaylistDao_Impl.f(((a)object0));
            }
            case 18: {
                return PlaylistDao_Impl.N(((a)object0));
            }
            case 19: {
                return PlaylistDao_Impl.A(((a)object0));
            }
            case 20: {
                return PlaylistDao_Impl.m(((a)object0));
            }
            case 21: {
                return PlaylistDao_Impl.Z(((a)object0));
            }
            case 22: {
                return PlaylistDao_Impl.R(((a)object0));
            }
            case 23: {
                return VoiceAlarmPlay.e(((StreamGetPathRes)object0));
            }
            case 24: {
                q.g(((U)object0), "it");
                return H.a;
            }
            case 25: {
                q.g(((U)object0), "it");
                return H.a;
            }
            case 26: {
                q.g(((U)object0), "it");
                return H.a;
            }
            case 27: {
                q.g(((U)object0), "it");
                return H.a;
            }
            case 28: {
                q.g(((x)object0), "$this$semantics");
                u.k(((x)object0), 2);
                return H.a;
            }
            default: {
                q.g(((x)object0), "$this$clearAndSetSemantics");
                return H.a;
            }
        }
    }
}


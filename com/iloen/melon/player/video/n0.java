package com.iloen.melon.player.video;

import com.iloen.melon.playback.Playable;
import com.kakao.tiara.data.ActionKind;
import ie.H;
import kotlin.jvm.internal.q;
import q8.d;
import q8.h;
import we.k;

public final class n0 implements k {
    public final EventMeta a;
    public final String b;
    public final ActionKind c;
    public final SongListFragment d;
    public final String e;
    public final Playable f;

    public n0(EventMeta videoSongListBottomSheetFragment$SongListFragment$EventMeta0, String s, ActionKind actionKind0, SongListFragment videoSongListBottomSheetFragment$SongListFragment0, String s1, Playable playable0) {
        this.a = videoSongListBottomSheetFragment$SongListFragment$EventMeta0;
        this.b = s;
        this.c = actionKind0;
        this.d = videoSongListBottomSheetFragment$SongListFragment0;
        this.e = s1;
        this.f = playable0;
    }

    @Override  // we.k
    public final Object invoke(Object object0) {
        q.g(((d)object0), "$this$tiaraEventLogBuilder");
        new o0(this.b, 7).invoke(((h)((d)object0).b));
        SongListFragment videoSongListBottomSheetFragment$SongListFragment0 = this.d;
        ((d)object0).c(new s(10, this.c, videoSongListBottomSheetFragment$SongListFragment0));
        ((d)object0).b(new s(11, this.e, videoSongListBottomSheetFragment$SongListFragment0));
        ((d)object0).k(new s(12, videoSongListBottomSheetFragment$SongListFragment0, this.f));
        EventMeta videoSongListBottomSheetFragment$SongListFragment$EventMeta0 = this.a;
        if(videoSongListBottomSheetFragment$SongListFragment$EventMeta0 != null) {
            ((d)object0).e(new o0(videoSongListBottomSheetFragment$SongListFragment$EventMeta0, 0));
        }
        ((d)object0).d(new o0(videoSongListBottomSheetFragment$SongListFragment0, 8));
        return H.a;
    }
}


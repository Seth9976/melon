package com.iloen.melon.player.video;

import J8.g2;
import J8.w3;
import android.view.View;
import com.iloen.melon.custom.CheckableImageView;
import com.iloen.melon.net.v6x.response.LiveTimedMetaSongRes.RESPONSE;
import com.iloen.melon.net.v6x.response.LiveTimedMetaSongRes.SONG;
import com.kakao.tiara.data.ActionKind;
import ie.H;
import kotlin.jvm.internal.q;
import we.n;

public final class j implements n {
    public final VideoChatFragment a;
    public final RESPONSE b;

    public j(VideoChatFragment videoChatFragment0, RESPONSE liveTimedMetaSongRes$RESPONSE0) {
        this.a = videoChatFragment0;
        this.b = liveTimedMetaSongRes$RESPONSE0;
    }

    @Override  // we.n
    public final Object invoke(Object object0, Object object1) {
        CheckableImageView checkableImageView0;
        q.g(((View)object0), "view");
        q.g(((String)object1), "songId");
        VideoChatFragment videoChatFragment0 = this.a;
        if(videoChatFragment0.isLoginUser()) {
            videoChatFragment0.updateLike(((String)object1), "N10001", !q.b(videoChatFragment0.f0().isLiked().getValue(), Boolean.TRUE), videoChatFragment0.getMenuId(), new VideoChatFragment.updateLikeInfo.1(((View)object0), videoChatFragment0));
        }
        else {
            videoChatFragment0.showLoginPopup();
        }
        if(videoChatFragment0.d) {
            w3 w30 = videoChatFragment0.f;
            q.d(w30);
            checkableImageView0 = (CheckableImageView)((g2)w30.g.c).e;
        }
        else {
            w3 w31 = videoChatFragment0.f;
            q.d(w31);
            checkableImageView0 = (CheckableImageView)((g2)w31.g.d).e;
        }
        String s = checkableImageView0.a ? "dislike" : "like";
        q.d(s);
        String s1 = null;
        SONG liveTimedMetaSongRes$SONG0 = this.b == null ? null : VideoChatFragment.g0(this.b);
        ActionKind actionKind0 = ActionKind.Like;
        String s2 = liveTimedMetaSongRes$SONG0 == null ? null : liveTimedMetaSongRes$SONG0.songId;
        String s3 = liveTimedMetaSongRes$SONG0 == null ? null : videoChatFragment0.getString(0x7F130F01);  // string:tiara_meta_type_song "곡"
        if(liveTimedMetaSongRes$SONG0 != null) {
            s1 = liveTimedMetaSongRes$SONG0.songName;
        }
        VideoChatFragment.j0(videoChatFragment0, actionKind0, null, s2, s3, s1, s, 2);
        return H.a;
    }
}


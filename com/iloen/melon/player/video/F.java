package com.iloen.melon.player.video;

import J8.g2;
import J8.w3;
import Tf.o;
import android.content.Context;
import android.widget.ImageView;
import android.widget.LinearLayout;
import androidx.cardview.widget.CardView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.lifecycle.M;
import androidx.recyclerview.widget.j0;
import com.bumptech.glide.Glide;
import com.iloen.melon.custom.CheckableImageView;
import com.iloen.melon.custom.MelonTextView;
import com.iloen.melon.net.v6x.response.LiveDetailRes;
import com.iloen.melon.net.v6x.response.LiveTimedMetaSongRes.RESPONSE;
import com.iloen.melon.net.v6x.response.LiveTimedMetaSongRes.SONG;
import com.iloen.melon.player.video.chat.ChatAdapter;
import com.iloen.melon.utils.ui.ViewUtils;
import ie.H;
import ie.m;
import java.util.ArrayList;
import kotlin.jvm.internal.q;
import v8.h;
import v8.i;

public final class f implements M {
    public final int a;
    public final VideoChatFragment b;

    public f(VideoChatFragment videoChatFragment0, int v) {
        this.a = v;
        this.b = videoChatFragment0;
        super();
    }

    @Override  // androidx.lifecycle.M
    public final void onChanged(Object object0) {
        CheckableImageView checkableImageView0;
        boolean z = false;
        VideoChatFragment videoChatFragment0 = this.b;
        switch(this.a) {
            case 0: {
                j j0 = new j(videoChatFragment0, ((RESPONSE)object0));
                k k0 = new k(0, videoChatFragment0, ((RESPONSE)object0));
                w3 w30 = videoChatFragment0.f;
                q.d(w30);
                w3 w31 = videoChatFragment0.f;
                q.d(w31);
                boolean z1 = videoChatFragment0.d;
                Object object1 = z1 ? ((g2)w30.g.c).f : ((g2)w31.g.d).f;
                MelonTextView melonTextView0 = z1 ? ((g2)w30.g.c).c : ((g2)w31.g.d).c;
                MelonTextView melonTextView1 = z1 ? ((g2)w30.g.c).b : ((g2)w31.g.d).b;
                ImageView imageView0 = z1 ? ((g2)w30.g.c).e : ((g2)w31.g.d).e;
                w3 w32 = videoChatFragment0.f;
                q.d(w32);
                boolean z2 = videoChatFragment0.d;
                g2 g20 = z2 ? ((g2)w32.g.c) : ((g2)w32.g.d);
                m m0 = new m(((ConstraintLayout)((g2)w32.g.c).d), ((CardView)((g2)w32.g.d).d));
                ViewUtils.INSTANCE.switchShowAndHide(m0, z2);
                g20.getRoot().setOnClickListener(new v(k0, 1));
                SONG liveTimedMetaSongRes$SONG0 = ((RESPONSE)object0) == null ? null : VideoChatFragment.g0(((RESPONSE)object0));
                videoChatFragment0.k0(((ConstraintLayout)w32.g.b), liveTimedMetaSongRes$SONG0 != null);
                if(liveTimedMetaSongRes$SONG0 != null) {
                    videoChatFragment0.f0().requestLikeInfo(videoChatFragment0.getContext(), liveTimedMetaSongRes$SONG0.songId);
                    ((CheckableImageView)imageView0).setOnClickListener(new l(1, j0, liveTimedMetaSongRes$SONG0));
                    String s = liveTimedMetaSongRes$SONG0.albumImg;
                    String s1 = liveTimedMetaSongRes$SONG0.songName;
                    String s2 = liveTimedMetaSongRes$SONG0.getArtistNames();
                    Context context0 = videoChatFragment0.getContext();
                    if(context0 != null) {
                        VideoChatFragment.chatBannerSongData.3.1 videoChatFragment$chatBannerSongData$3$10 = (VideoChatFragment.chatBannerSongData.3.1)Glide.with(context0).asBitmap().load(s).into(new VideoChatFragment.chatBannerSongData.3.1(((ImageView)object1), videoChatFragment0, g20));
                    }
                    melonTextView0.setText(s1);
                    melonTextView1.setText(s2);
                }
                return;
            }
            case 1: {
                j0 j01 = videoChatFragment0.getAdapter();
                q.e(j01, "null cannot be cast to non-null type com.iloen.melon.player.video.chat.ChatAdapter");
                ((ChatAdapter)j01).addMessageList(((ArrayList)object0));
                return;
            }
            case 2: {
                if(((LiveDetailRes)object0) != null) {
                    videoChatFragment0.onFetchSuccessUI(new i(h.a, v9.i.b, ((LiveDetailRes)object0), null));
                }
                return;
            }
            case 3: {
                w3 w33 = videoChatFragment0.f;
                q.d(w33);
                LinearLayout linearLayout0 = w33.m;
                if(((String)object0) == null || o.H0(((String)object0))) {
                    z = true;
                }
                ViewUtils.hideWhen(linearLayout0, z);
                w3 w34 = videoChatFragment0.f;
                q.d(w34);
                q.d(((String)object0));
                Context context1 = videoChatFragment0.requireContext();
                q.f(context1, "requireContext(...)");
                String s3 = Cb.k.a(context1, ((String)object0));
                w34.t.setText(s3);
                return;
            }
            case 4: {
                q.d(((Boolean)object0));
                boolean z3 = ((Boolean)object0).booleanValue();
                if(videoChatFragment0.d) {
                    w3 w35 = videoChatFragment0.f;
                    q.d(w35);
                    checkableImageView0 = (CheckableImageView)((g2)w35.g.c).e;
                }
                else {
                    w3 w36 = videoChatFragment0.f;
                    q.d(w36);
                    checkableImageView0 = (CheckableImageView)((g2)w36.g.d).e;
                }
                q.d(checkableImageView0);
                checkableImageView0.setChecked(z3);
                return;
            }
            default: {
                H h0 = (H)object0;
                j0 j00 = videoChatFragment0.getAdapter();
                q.e(j00, "null cannot be cast to non-null type com.iloen.melon.player.video.chat.ChatAdapter");
                ((ChatAdapter)j00).clearMessageList();
            }
        }
    }
}


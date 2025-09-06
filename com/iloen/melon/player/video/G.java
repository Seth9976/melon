package com.iloen.melon.player.video;

import J8.w3;
import J8.x;
import P1.c;
import android.content.Context;
import android.graphics.drawable.Drawable;
import android.view.View;
import androidx.cardview.widget.CardView;
import androidx.constraintlayout.widget.ConstraintLayout;
import com.bumptech.glide.Glide;
import com.bumptech.glide.RequestBuilder;
import com.bumptech.glide.RequestManager;
import com.google.android.material.imageview.ShapeableImageView;
import com.iloen.melon.custom.MelonTextView;
import com.iloen.melon.net.v6x.response.LiveTimedMetaMessageRes.MESSAGE;
import com.iloen.melon.net.v6x.response.LiveTimedMetaNoticeRes.NOTICE;
import com.iloen.melon.player.video.chat.VideoChatHelper;
import com.iloen.melon.player.video.chat.VideoChatHelperKt;
import com.iloen.melon.utils.ui.ViewUtils;
import com.iloen.melon.utils.ui.ViewUtilsKt;
import com.melon.net.res.common.ArtistsInfoBase;
import com.melon.net.res.common.LinkInfoBase;
import ie.H;
import kotlin.jvm.internal.q;
import q8.h;
import we.k;

public final class g implements k {
    public final int a;
    public final VideoChatFragment b;

    public g(VideoChatFragment videoChatFragment0, int v) {
        this.a = v;
        this.b = videoChatFragment0;
        super();
    }

    @Override  // we.k
    public final Object invoke(Object object0) {
        String s8;
        String s5;
        String s3;
        boolean z;
        String s = null;
        String s1 = "";
        int v = 0;
        H h0 = H.a;
        VideoChatFragment videoChatFragment0 = this.b;
        switch(this.a) {
            case 0: {
                w3 w30 = videoChatFragment0.f;
                q.d(w30);
                CardView cardView0 = (CardView)w30.f.c;
                View view0 = cardView0.findViewById(0x7F0A0CD0);  // id:tv_notice_text
                if(((NOTICE)object0) == null) {
                    z = false;
                }
                else {
                    LinkInfoBase linkInfoBase0 = ((NOTICE)object0).link;
                    z = linkInfoBase0 == null || !linkInfoBase0.isLinkable() ? false : true;
                }
                ConstraintLayout constraintLayout0 = (ConstraintLayout)cardView0.findViewById(0x7F0A036A);  // id:ctl_action
                MelonTextView melonTextView0 = (MelonTextView)cardView0.findViewById(0x7F0A0C03);  // id:tv_action_text
                if(((MelonTextView)view0) != null) {
                    ((MelonTextView)view0).setText((((NOTICE)object0) == null ? null : ((NOTICE)object0).text));
                }
                if(melonTextView0 != null) {
                    if(((NOTICE)object0) == null) {
                        s3 = null;
                    }
                    else {
                        LinkInfoBase linkInfoBase1 = ((NOTICE)object0).link;
                        s3 = linkInfoBase1 == null ? null : linkInfoBase1.getLinkTitle();
                    }
                    melonTextView0.setText(s3);
                }
                ViewUtils.showWhen(constraintLayout0, z);
                if(constraintLayout0 != null) {
                    constraintLayout0.setOnClickListener(new l(0, ((NOTICE)object0), videoChatFragment0));
                }
                q.d(((MelonTextView)view0));
                ViewUtilsKt.setMarginToDp$default(((MelonTextView)view0), null, null, ((float)(z ? 0.0f : 10.0f)), null, 11, null);
                if(((NOTICE)object0) != null) {
                    s = ((NOTICE)object0).text;
                }
                if(s == null || s.length() == 0) {
                    v = 1;
                }
                videoChatFragment0.k0(cardView0, ((boolean)(v ^ 1)));
                return h0;
            }
            case 1: {
                w3 w31 = videoChatFragment0.f;
                q.d(w31);
                x x0 = w31.e;
                q.f(x0, "containerChatBannerArtistMessage");
                CardView cardView1 = (CardView)x0.b;
                q.f(cardView1, "getRoot(...)");
                String s4 = ((MESSAGE)object0) == null ? null : ((MESSAGE)object0).text;
                if(s4 == null || s4.length() == 0) {
                    v = 1;
                }
                videoChatFragment0.k0(cardView1, ((boolean)(1 ^ v)));
                ShapeableImageView shapeableImageView0 = (ShapeableImageView)x0.c;
                q.f(shapeableImageView0, "artistThumbnail");
                MelonTextView melonTextView1 = (MelonTextView)x0.d;
                q.f(melonTextView1, "tvNoticeTitle");
                int v1 = videoChatFragment0.d ? 0x7F0807A4 : 0x7F0807A3;  // drawable:noimage_person_xxmini_w
                Drawable drawable0 = c.getDrawable(videoChatFragment0.requireContext(), v1);
                Context context0 = videoChatFragment0.getContext();
                if(context0 != null) {
                    RequestManager requestManager0 = Glide.with(context0);
                    if(((MESSAGE)object0) == null) {
                        s5 = null;
                    }
                    else {
                        ArtistsInfoBase artistsInfoBase0 = ((MESSAGE)object0).artist;
                        s5 = artistsInfoBase0 == null ? null : artistsInfoBase0.getArtistImg();
                    }
                    ((RequestBuilder)requestManager0.load(s5).error(drawable0)).into(shapeableImageView0);
                }
                VideoChatHelper videoChatHelper0 = VideoChatHelper.INSTANCE;
                Context context1 = videoChatFragment0.requireContext();
                q.f(context1, "requireContext(...)");
                boolean z1 = videoChatFragment0.d;
                if(((MESSAGE)object0) == null) {
                    s8 = "";
                }
                else {
                    ArtistsInfoBase artistsInfoBase1 = ((MESSAGE)object0).artist;
                    if(artistsInfoBase1 == null) {
                        s8 = "";
                    }
                    else {
                        String s6 = artistsInfoBase1.getArtistName();
                        if(s6 == null) {
                            s8 = "";
                        }
                        else {
                            String s7 = VideoChatHelperKt.replaceSpaceToNbsp(s6);
                            s8 = s7 == null ? "" : s7;
                        }
                    }
                }
                if(((MESSAGE)object0) != null) {
                    s = ((MESSAGE)object0).text;
                }
                melonTextView1.setText(VideoChatHelper.getChatMessageSpan$default(videoChatHelper0, context1, z1, s8, null, VideoChatHelperKt.replaceSpaceToNbsp(s), null, true, false, 0xA8, null));
                return h0;
            }
            default: {
                q.g(((h)object0), "$this$track");
                String s2 = videoChatFragment0.getString(0x7F130DD0);  // string:tiara_common_action_name_select "선택"
                if(s2 != null) {
                    s1 = s2;
                }
                ((h)object0).a = s1;
                return h0;
            }
        }
    }
}


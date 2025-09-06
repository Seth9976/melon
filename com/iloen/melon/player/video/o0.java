package com.iloen.melon.player.video;

import androidx.compose.runtime.b0;
import com.iloen.melon.custom.CheckableImageView;
import com.iloen.melon.net.v3x.comments.InformCmtContsSummRes.result;
import com.kakaoent.leonplayer.core.LeonPlayer;
import com.kakaoent.leonplayer.core.model.data.player.LeonVideoProfile;
import com.melon.ui.K1;
import com.melon.ui.k2;
import com.melon.ui.popup.context.more.ExtraProperties.CheckedItemInfo;
import com.melon.ui.popup.context.more.ExtraProperties;
import com.melon.ui.popup.context.more.MelonBottomSheetItem;
import gc.G;
import gc.l;
import ie.H;
import kotlin.jvm.internal.C;
import kotlin.jvm.internal.q;
import q8.c;
import q8.f;
import q8.h;
import we.k;

public final class o0 implements k {
    public final int a;
    public final Object b;

    public o0(Object object0, int v) {
        this.a = v;
        this.b = object0;
        super();
    }

    @Override  // we.k
    public final Object invoke(Object object0) {
        int v = 0;
        H h0 = H.a;
        Object object1 = this.b;
        switch(this.a) {
            case 0: {
                q.g(((f)object0), "$this$eventMeta");
                ((f)object0).a = ((EventMeta)object1).getId();
                ((f)object0).b = ((EventMeta)object1).getType();
                ((f)object0).c = ((EventMeta)object1).getName();
                return h0;
            }
            case 1: {
                q.g(((WrappedData)object0), "data");
                ((WrappedData)object0).setLike(((LikeData)object1).isLike());
                ((WrappedData)object0).setSumCount("0");
                return h0;
            }
            case 2: {
                q.g(((WrappedData)object0), "data");
                ((WrappedData)object0).setInformCmtResult(((result)object1));
                return h0;
            }
            case 3: {
                q.g(((k2)object0), "onEvent");
                if(((k2)object0) instanceof K1) {
                    MelonBottomSheetItem melonBottomSheetItem0 = ((K1)(((k2)object0))).b;
                    String s1 = null;
                    switch(melonBottomSheetItem0.a.ordinal()) {
                        case 109: {
                            ((l)(((G)object1))).f.setVideoProfileId(null);
                            return h0;
                        }
                        case 0x72: {
                            ExtraProperties extraProperties0 = melonBottomSheetItem0.f;
                            if(extraProperties0 instanceof CheckedItemInfo) {
                                v = ((CheckedItemInfo)extraProperties0).a;
                            }
                            if(!v) {
                                ((l)(((G)object1))).f.setVideoProfileId(null);
                                return h0;
                            }
                            LeonPlayer leonPlayer0 = ((l)(((G)object1))).f;
                            LeonVideoProfile leonVideoProfile0 = ((l)(((G)object1))).f.getCurrentVideoProfile();
                            LeonVideoProfile leonVideoProfile1 = (LeonVideoProfile)leonPlayer0.getCurrentVideoProfiles().get(0);
                            String s2 = leonVideoProfile1.getId();
                            if(leonVideoProfile0 != null) {
                                s1 = leonVideoProfile0.getId();
                            }
                            if(!q.b(s2, s1)) {
                                leonPlayer0.setVideoProfileId(leonVideoProfile1.getId());
                                return h0;
                            }
                            break;
                        }
                        default: {
                            return h0;
                        }
                    }
                }
                return h0;
            }
            case 4: {
                ((b0)object1).setValue(((int)(((r1.l)object0).a & 0xFFFFFFFFL)));
                return h0;
            }
            case 5: {
                CheckableImageView checkableImageView0 = ((VideoPlayerLiveFragment)object1).getBinding().e;
                if(((Boolean)object0) != null) {
                    v = ((Boolean)object0).booleanValue();
                }
                checkableImageView0.setChecked(((boolean)v));
                return h0;
            }
            case 6: {
                q.d(((Boolean)object0));
                ((C)object1).a = ((Boolean)object0).booleanValue();
                return h0;
            }
            case 7: {
                String s3 = (String)object1;
                q.g(((h)object0), "$this$track");
                if(s3 == null) {
                    s3 = "";
                }
                ((h)object0).a = s3;
                return h0;
            }
            default: {
                q.g(((c)object0), "$this$customProps");
                ((c)object0).a(new com.iloen.melon.player.video.c(((SongListFragment)object1), 5));
                String s = ((SongListFragment)object1).a.getPlayerType();
                ((c)object0).a.put("Player Type", s);
                return h0;
            }
        }
    }
}


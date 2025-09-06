package com.iloen.melon.fragments.shortform;

import Cc.N1;
import Cc.e0;
import F.m;
import M.t;
import androidx.compose.runtime.l;
import com.iloen.melon.net.v6x.response.TrendShortFormRes.Response.SLOTLIST.CHAT;
import com.iloen.melon.player.video.VideoStatus;
import com.iloen.melon.player.video.VideoViewModel.BottomSheetState;
import com.iloen.melon.player.video.VideoViewModel.FoldingFeatureAndScreenLayout;
import com.iloen.melon.player.video.VideoViewModelKt;
import ie.H;
import kotlin.jvm.internal.q;
import we.p;

public final class a implements p {
    public final int a;

    public a(int v) {
        this.a = v;
        super();
    }

    @Override  // we.p
    public final Object invoke(Object object0, Object object1, Object object2, Object object3) {
        switch(this.a) {
            case 0: {
                return ComposableSingletons.TrendMusicWaveExclusiveFragmentKt.lambda_1323796333$lambda$0(((t)object0), ((CHAT)object1), ((l)object2), ((int)(((Integer)object3))));
            }
            case 1: {
                boolean z = ((Boolean)object0).booleanValue();
                boolean z1 = ((Boolean)object1).booleanValue();
                int v = (int)(((Integer)object3));
                return ((FoldingFeatureAndScreenLayout)object2) == null ? new BottomSheetState(z, z1, null, v) : new BottomSheetState(z, z1, ((FoldingFeatureAndScreenLayout)object2).getFoldingFeature(), v);
            }
            case 2: {
                q.g(((VideoStatus)object0), "videoStatus");
                return ((VideoStatus)object0) != VideoStatus.Expand || !((Boolean)object1).booleanValue() || VideoViewModelKt.isHalfOpened(((FoldingFeatureAndScreenLayout)object2)) || ((Boolean)object3).booleanValue() ? false : true;
            }
            default: {
                q.g(((m)object0), "$this$AnimatedContent");
                q.g(((String)object1), "targetText");
                N1.b(((String)object1), null, e0.T(((l)object2), 0x7F0604B7), 13.0f, null, null, 0L, null, 0.0f, 0, false, 0, 0, null, null, ((l)object2), ((int)(((Integer)object3))) >> 3 & 14 | 0xC00, 0, 0x1FFF2);  // color:white700e
                return H.a;
            }
        }
    }
}


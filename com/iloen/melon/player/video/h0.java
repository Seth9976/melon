package com.iloen.melon.player.video;

import ie.H;
import kotlin.jvm.internal.q;
import q8.a;
import we.k;

public final class h0 implements k {
    public final int a;
    public final VideoPlayerFragmentBase b;
    public final int c;

    public h0(VideoPlayerFragmentBase videoPlayerFragmentBase0, int v, int v1) {
        this.a = v1;
        this.b = videoPlayerFragmentBase0;
        this.c = v;
        super();
    }

    @Override  // we.k
    public final Object invoke(Object object0) {
        H h0 = H.a;
        int v = this.c;
        VideoPlayerFragmentBase videoPlayerFragmentBase0 = this.b;
        if(this.a != 0) {
            q.g(((a)object0), "$this$click");
            ((a)object0).a = videoPlayerFragmentBase0.getString(0x7F130DEF);  // string:tiara_common_layer1_curationvideo "추천영상"
            ((a)object0).e = String.valueOf(v);
            return h0;
        }
        q.g(((a)object0), "$this$click");
        ((a)object0).a = videoPlayerFragmentBase0.getString(0x7F130DEE);  // string:tiara_common_layer1_controlview "컨트롤뷰"
        ((a)object0).g = videoPlayerFragmentBase0.getString(v);
        return h0;
    }
}


package com.iloen.melon.player.video;

import De.d;
import S2.c;
import androidx.fragment.app.I;
import androidx.lifecycle.o0;
import androidx.lifecycle.q0;
import kotlin.jvm.internal.q;
import o9.b;
import we.a;

public final class k0 implements a {
    public final int a;
    public final VideoPlayerFragmentBase b;

    public k0(VideoPlayerFragmentBase videoPlayerFragmentBase0, int v) {
        this.a = v;
        this.b = videoPlayerFragmentBase0;
        super();
    }

    @Override  // we.a
    public final Object invoke() {
        VideoPlayerFragmentBase videoPlayerFragmentBase0 = this.b;
        switch(this.a) {
            case 0: {
                return VideoPlayerFragmentBase.h0(videoPlayerFragmentBase0);
            }
            case 1: {
                return VideoPlayerFragmentBase.g0(videoPlayerFragmentBase0);
            }
            case 2: {
                I i0 = videoPlayerFragmentBase0.requireParentFragment();
                q.f(i0, "requireParentFragment(...)");
                q0 q00 = i0.getViewModelStore();
                o0 o00 = i0.getDefaultViewModelProviderFactory();
                c c0 = i0.getDefaultViewModelCreationExtras();
                q.g(q00, "store");
                q.g(o00, "factory");
                b b0 = com.iloen.melon.utils.a.p(c0, "defaultCreationExtras", q00, o00, c0);
                d d0 = df.d.y(LiveViewModel.class);
                String s = d0.l();
                if(s == null) {
                    throw new IllegalArgumentException("Local and anonymous classes can not be ViewModels");
                }
                return (LiveViewModel)b0.s(d0, "androidx.lifecycle.ViewModelProvider.DefaultKey:" + s);
            }
            case 3: {
                return videoPlayerFragmentBase0.findViewById(0x7F0A0668);  // id:iv_player_play_pause
            }
            default: {
                return videoPlayerFragmentBase0.findViewById(0x7F0A018C);  // id:btn_player_remote
            }
        }
    }
}


package com.iloen.melon.player.video;

import De.d;
import androidx.fragment.app.I;
import androidx.lifecycle.f0;
import androidx.lifecycle.n;
import androidx.lifecycle.o0;
import androidx.lifecycle.q0;
import androidx.lifecycle.r0;
import com.iloen.melon.player.video.cheer.LivePollingManager;
import ie.H;
import kotlin.jvm.internal.q;
import o9.b;
import we.a;
import we.k;
import zd.F;

public final class c implements a {
    public final int a;
    public final Object b;

    public c(Object object0, int v) {
        this.a = v;
        this.b = object0;
        super();
    }

    @Override  // we.a
    public final Object invoke() {
        Class class0 = LiveViewModel.class;
        H h0 = H.a;
        Object object0 = this.b;
        switch(this.a) {
            case 0: {
                return new LivePollingManager(f0.h(((LiveViewModel)object0)), new com.iloen.melon.player.video.a(((LiveViewModel)object0), 1), new com.iloen.melon.player.video.a(((LiveViewModel)object0), 2), new com.iloen.melon.player.video.a(((LiveViewModel)object0), 0));
            }
            case 1: {
                I i0 = ((VideoLivePreviewFragment)object0).requireParentFragment();
                q.f(i0, "requireParentFragment(...)");
                q0 q00 = i0.getViewModelStore();
                o0 o00 = i0.getDefaultViewModelProviderFactory();
                S2.c c0 = i0.getDefaultViewModelCreationExtras();
                q.g(q00, "store");
                q.g(o00, "factory");
                b b0 = com.iloen.melon.utils.a.p(c0, "defaultCreationExtras", q00, o00, c0);
                d d0 = df.d.y(class0);
                String s = d0.l();
                if(s == null) {
                    throw new IllegalArgumentException("Local and anonymous classes can not be ViewModels");
                }
                return (LiveViewModel)b0.s(d0, "androidx.lifecycle.ViewModelProvider.DefaultKey:" + s);
            }
            case 2: {
                r0 r00 = f0.e(((VideoMiniPlayer)object0));
                q.d(r00);
                q0 q01 = r00.getViewModelStore();
                o0 o01 = r00 instanceof n ? ((n)r00).getDefaultViewModelProviderFactory() : T2.b.a;
                S2.c c1 = r00 instanceof n ? ((n)r00).getDefaultViewModelCreationExtras() : S2.a.b;
                q.g(q01, "store");
                q.g(o01, "factory");
                q.g(c1, "defaultCreationExtras");
                b b1 = new b(q01, o01, c1);
                d d1 = df.d.y(class0);
                String s1 = d1.l();
                if(s1 == null) {
                    throw new IllegalArgumentException("Local and anonymous classes can not be ViewModels");
                }
                return (LiveViewModel)b1.s(d1, "androidx.lifecycle.ViewModelProvider.DefaultKey:" + s1);
            }
            case 3: {
                ((k)object0).invoke(F.a);
                return h0;
            }
            case 4: {
                ((VideoPlayerLiveFragment)object0).getVideoViewModel().changeToDefaultPlaylist();
                return h0;
            }
            default: {
                return SongListFragment.d0(((SongListFragment)object0));
            }
        }
    }
}


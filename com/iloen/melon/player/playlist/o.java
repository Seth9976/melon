package com.iloen.melon.player.playlist;

import De.d;
import Ma.m;
import Qb.z;
import S2.c;
import U4.F;
import android.content.Context;
import androidx.fragment.app.I;
import androidx.lifecycle.o0;
import androidx.lifecycle.q0;
import com.iloen.melon.player.video.LiveViewModel;
import com.iloen.melon.player.video.VideoViewModel;
import kotlin.jvm.internal.q;
import o9.b;
import we.a;

public final class o implements a {
    public final int a;
    public final VideoPlaylistFragment b;

    public o(VideoPlaylistFragment videoPlaylistFragment0, int v) {
        this.a = v;
        this.b = videoPlaylistFragment0;
        super();
    }

    @Override  // we.a
    public final Object invoke() {
        VideoPlaylistFragment videoPlaylistFragment0 = this.b;
        switch(this.a) {
            case 0: {
                I i0 = videoPlaylistFragment0.requireParentFragment();
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
            case 1: {
                return ((VideoViewModel)videoPlaylistFragment0.c.getValue()).getPlayerType();
            }
            case 2: {
                Context context2 = videoPlaylistFragment0.requireContext();
                q.f(context2, "requireContext(...)");
                return F.x(context2);
            }
            case 3: {
                Context context3 = videoPlaylistFragment0.requireContext();
                q.f(context3, "requireContext(...)");
                Context context4 = context3.getApplicationContext();
                q.d(context4);
                return (z)((k8.o)(((m)com.google.firebase.b.B(context4, m.class)))).t.get();
            }
            default: {
                Context context0 = videoPlaylistFragment0.requireContext();
                q.f(context0, "requireContext(...)");
                Context context1 = context0.getApplicationContext();
                q.d(context1);
                return ((k8.o)(((Ma.o)com.google.firebase.b.B(context1, Ma.o.class)))).k();
            }
        }
    }
}


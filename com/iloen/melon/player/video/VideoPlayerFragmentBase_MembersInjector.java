package com.iloen.melon.player.video;

import Bc.h;
import Pd.i;
import Ub.q;
import Ub.s;
import Ub.u;
import Xd.a;
import com.iloen.melon.fragments.MelonBaseFragment_MembersInjector;
import ge.b;
import hc.l;
import kc.s2;
import ob.z;

public final class VideoPlayerFragmentBase_MembersInjector implements a {
    public final b a;
    public final b b;
    public final b c;
    public final b d;
    public final b e;
    public final b f;
    public final b g;
    public final b h;
    public final b i;
    public final b j;
    public final b k;

    public VideoPlayerFragmentBase_MembersInjector(b b0, b b1, b b2, b b3, b b4, b b5, b b6, b b7, b b8, b b9, b b10) {
        this.a = b0;
        this.b = b1;
        this.c = b2;
        this.d = b3;
        this.e = b4;
        this.f = b5;
        this.g = b6;
        this.h = b7;
        this.i = b8;
        this.j = b9;
        this.k = b10;
    }

    public static a create(b b0, b b1, b b2, b b3, b b4, b b5, b b6, b b7, b b8, b b9, b b10) {
        return new VideoPlayerFragmentBase_MembersInjector(b0, b1, b2, b3, b4, b5, b6, b7, b8, b9, b10);
    }

    public static void injectAppVisibilityManager(VideoPlayerFragmentBase videoPlayerFragmentBase0, i i0) {
        videoPlayerFragmentBase0.appVisibilityManager = i0;
    }

    public void injectMembers(VideoPlayerFragmentBase videoPlayerFragmentBase0) {
        MelonBaseFragment_MembersInjector.injectBlockingProgressDialogManage(videoPlayerFragmentBase0, ((k8.a)this.a.get()));
        MelonBaseFragment_MembersInjector.injectPlaylistManager(videoPlayerFragmentBase0, ((s2)this.b.get()));
        MelonBaseFragment_MembersInjector.injectVodRepeatManager(videoPlayerFragmentBase0, ((u)this.c.get()));
        MelonBaseFragment_MembersInjector.injectRemotePlayerManager(videoPlayerFragmentBase0, ((s)this.d.get()));
        MelonBaseFragment_MembersInjector.injectScreenCaptureUseCase(videoPlayerFragmentBase0, ((eb.u)this.e.get()));
        VideoPlayerFragmentBase_MembersInjector.injectPlaybackManager(videoPlayerFragmentBase0, ((q)this.f.get()));
        VideoPlayerFragmentBase_MembersInjector.injectPlayerUseCase(videoPlayerFragmentBase0, ((z)this.g.get()));
        VideoPlayerFragmentBase_MembersInjector.injectRemotePlayerManager(videoPlayerFragmentBase0, ((s)this.h.get()));
        VideoPlayerFragmentBase_MembersInjector.injectRemoteDeviceUseCase(videoPlayerFragmentBase0, ((l)this.i.get()));
        VideoPlayerFragmentBase_MembersInjector.injectPlayerUiHelper(videoPlayerFragmentBase0, ((h)this.j.get()));
        VideoPlayerFragmentBase_MembersInjector.injectAppVisibilityManager(videoPlayerFragmentBase0, ((i)this.k.get()));
    }

    public void injectMembers(Object object0) {
        this.injectMembers(((VideoPlayerFragmentBase)object0));
    }

    public static void injectPlaybackManager(VideoPlayerFragmentBase videoPlayerFragmentBase0, q q0) {
        videoPlayerFragmentBase0.playbackManager = q0;
    }

    public static void injectPlayerUiHelper(VideoPlayerFragmentBase videoPlayerFragmentBase0, h h0) {
        videoPlayerFragmentBase0.playerUiHelper = h0;
    }

    public static void injectPlayerUseCase(VideoPlayerFragmentBase videoPlayerFragmentBase0, z z0) {
        videoPlayerFragmentBase0.playerUseCase = z0;
    }

    public static void injectRemoteDeviceUseCase(VideoPlayerFragmentBase videoPlayerFragmentBase0, l l0) {
        videoPlayerFragmentBase0.remoteDeviceUseCase = l0;
    }

    public static void injectRemotePlayerManager(VideoPlayerFragmentBase videoPlayerFragmentBase0, s s0) {
        videoPlayerFragmentBase0.remotePlayerManager = s0;
    }
}


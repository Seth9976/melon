package com.iloen.melon.player.video;

import Ub.s;
import Xd.a;
import ge.b;
import kc.s2;
import ob.z;

public final class VideoMainFrameFragment_MembersInjector implements a {
    public final b a;
    public final b b;
    public final b c;
    public final b d;

    public VideoMainFrameFragment_MembersInjector(b b0, b b1, b b2, b b3) {
        this.a = b0;
        this.b = b1;
        this.c = b2;
        this.d = b3;
    }

    public static a create(b b0, b b1, b b2, b b3) {
        return new VideoMainFrameFragment_MembersInjector(b0, b1, b2, b3);
    }

    public void injectMembers(VideoMainFrameFragment videoMainFrameFragment0) {
        VideoMainFrameFragment_MembersInjector.injectPlayerUseCase(videoMainFrameFragment0, ((z)this.a.get()));
        VideoMainFrameFragment_MembersInjector.injectPlaylistManager(videoMainFrameFragment0, ((s2)this.b.get()));
        VideoMainFrameFragment_MembersInjector.injectPlayerController(videoMainFrameFragment0, ((Qb.z)this.c.get()));
        VideoMainFrameFragment_MembersInjector.injectRemotePlayerManager(videoMainFrameFragment0, ((s)this.d.get()));
    }

    public void injectMembers(Object object0) {
        this.injectMembers(((VideoMainFrameFragment)object0));
    }

    public static void injectPlayerController(VideoMainFrameFragment videoMainFrameFragment0, Qb.z z0) {
        videoMainFrameFragment0.playerController = z0;
    }

    public static void injectPlayerUseCase(VideoMainFrameFragment videoMainFrameFragment0, z z0) {
        videoMainFrameFragment0.playerUseCase = z0;
    }

    public static void injectPlaylistManager(VideoMainFrameFragment videoMainFrameFragment0, s2 s20) {
        videoMainFrameFragment0.playlistManager = s20;
    }

    public static void injectRemotePlayerManager(VideoMainFrameFragment videoMainFrameFragment0, s s0) {
        videoMainFrameFragment0.remotePlayerManager = s0;
    }
}


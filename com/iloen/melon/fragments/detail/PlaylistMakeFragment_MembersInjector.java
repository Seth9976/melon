package com.iloen.melon.fragments.detail;

import Ub.s;
import Ub.u;
import Xd.a;
import com.iloen.melon.fragments.MelonBaseFragment_MembersInjector;
import ge.b;
import kc.s2;

public final class PlaylistMakeFragment_MembersInjector implements a {
    private final b blockingProgressDialogManageProvider;
    private final b playlistManagerProvider;
    private final b playlistManagerProvider2;
    private final b remotePlayerManagerProvider;
    private final b screenCaptureUseCaseProvider;
    private final b vodRepeatManagerProvider;

    public PlaylistMakeFragment_MembersInjector(b b0, b b1, b b2, b b3, b b4, b b5) {
        this.blockingProgressDialogManageProvider = b0;
        this.playlistManagerProvider = b1;
        this.vodRepeatManagerProvider = b2;
        this.remotePlayerManagerProvider = b3;
        this.screenCaptureUseCaseProvider = b4;
        this.playlistManagerProvider2 = b5;
    }

    public static a create(b b0, b b1, b b2, b b3, b b4, b b5) {
        return new PlaylistMakeFragment_MembersInjector(b0, b1, b2, b3, b4, b5);
    }

    public void injectMembers(PlaylistMakeFragment playlistMakeFragment0) {
        MelonBaseFragment_MembersInjector.injectBlockingProgressDialogManage(playlistMakeFragment0, ((k8.a)this.blockingProgressDialogManageProvider.get()));
        MelonBaseFragment_MembersInjector.injectPlaylistManager(playlistMakeFragment0, ((s2)this.playlistManagerProvider.get()));
        MelonBaseFragment_MembersInjector.injectVodRepeatManager(playlistMakeFragment0, ((u)this.vodRepeatManagerProvider.get()));
        MelonBaseFragment_MembersInjector.injectRemotePlayerManager(playlistMakeFragment0, ((s)this.remotePlayerManagerProvider.get()));
        MelonBaseFragment_MembersInjector.injectScreenCaptureUseCase(playlistMakeFragment0, ((eb.u)this.screenCaptureUseCaseProvider.get()));
        PlaylistMakeFragment_MembersInjector.injectPlaylistManager(playlistMakeFragment0, ((s2)this.playlistManagerProvider2.get()));
    }

    public void injectMembers(Object object0) {
        this.injectMembers(((PlaylistMakeFragment)object0));
    }

    public static void injectPlaylistManager(PlaylistMakeFragment playlistMakeFragment0, s2 s20) {
        playlistMakeFragment0.playlistManager = s20;
    }
}


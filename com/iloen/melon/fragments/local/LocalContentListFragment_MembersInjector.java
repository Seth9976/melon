package com.iloen.melon.fragments.local;

import Bc.h;
import Ub.s;
import Ub.u;
import Xd.a;
import com.iloen.melon.fragments.MelonBaseFragment_MembersInjector;
import ge.b;
import kc.s2;
import ob.z;

public final class LocalContentListFragment_MembersInjector implements a {
    private final b blockingProgressDialogManageProvider;
    private final b playerUiHelperProvider;
    private final b playerUseCaseProvider;
    private final b playlistManagerProvider;
    private final b playlistManagerProvider2;
    private final b remotePlayerManagerProvider;
    private final b screenCaptureUseCaseProvider;
    private final b vodRepeatManagerProvider;

    public LocalContentListFragment_MembersInjector(b b0, b b1, b b2, b b3, b b4, b b5, b b6, b b7) {
        this.blockingProgressDialogManageProvider = b0;
        this.playlistManagerProvider = b1;
        this.vodRepeatManagerProvider = b2;
        this.remotePlayerManagerProvider = b3;
        this.screenCaptureUseCaseProvider = b4;
        this.playlistManagerProvider2 = b5;
        this.playerUseCaseProvider = b6;
        this.playerUiHelperProvider = b7;
    }

    public static a create(b b0, b b1, b b2, b b3, b b4, b b5, b b6, b b7) {
        return new LocalContentListFragment_MembersInjector(b0, b1, b2, b3, b4, b5, b6, b7);
    }

    public void injectMembers(LocalContentListFragment localContentListFragment0) {
        MelonBaseFragment_MembersInjector.injectBlockingProgressDialogManage(localContentListFragment0, ((k8.a)this.blockingProgressDialogManageProvider.get()));
        MelonBaseFragment_MembersInjector.injectPlaylistManager(localContentListFragment0, ((s2)this.playlistManagerProvider.get()));
        MelonBaseFragment_MembersInjector.injectVodRepeatManager(localContentListFragment0, ((u)this.vodRepeatManagerProvider.get()));
        MelonBaseFragment_MembersInjector.injectRemotePlayerManager(localContentListFragment0, ((s)this.remotePlayerManagerProvider.get()));
        MelonBaseFragment_MembersInjector.injectScreenCaptureUseCase(localContentListFragment0, ((eb.u)this.screenCaptureUseCaseProvider.get()));
        LocalContentListFragment_MembersInjector.injectPlaylistManager(localContentListFragment0, ((s2)this.playlistManagerProvider2.get()));
        LocalContentListFragment_MembersInjector.injectPlayerUseCase(localContentListFragment0, ((z)this.playerUseCaseProvider.get()));
        LocalContentListFragment_MembersInjector.injectPlayerUiHelper(localContentListFragment0, ((h)this.playerUiHelperProvider.get()));
    }

    public void injectMembers(Object object0) {
        this.injectMembers(((LocalContentListFragment)object0));
    }

    public static void injectPlayerUiHelper(LocalContentListFragment localContentListFragment0, h h0) {
        localContentListFragment0.playerUiHelper = h0;
    }

    public static void injectPlayerUseCase(LocalContentListFragment localContentListFragment0, z z0) {
        localContentListFragment0.playerUseCase = z0;
    }

    public static void injectPlaylistManager(LocalContentListFragment localContentListFragment0, s2 s20) {
        localContentListFragment0.playlistManager = s20;
    }
}


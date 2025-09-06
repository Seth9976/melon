package com.iloen.melon.fragments;

import Ub.s;
import Ub.u;
import Xd.a;
import ge.b;
import kc.s2;

public final class MelonBaseFragment_MembersInjector implements a {
    private final b blockingProgressDialogManageProvider;
    private final b playlistManagerProvider;
    private final b remotePlayerManagerProvider;
    private final b screenCaptureUseCaseProvider;
    private final b vodRepeatManagerProvider;

    public MelonBaseFragment_MembersInjector(b b0, b b1, b b2, b b3, b b4) {
        this.blockingProgressDialogManageProvider = b0;
        this.playlistManagerProvider = b1;
        this.vodRepeatManagerProvider = b2;
        this.remotePlayerManagerProvider = b3;
        this.screenCaptureUseCaseProvider = b4;
    }

    public static a create(b b0, b b1, b b2, b b3, b b4) {
        return new MelonBaseFragment_MembersInjector(b0, b1, b2, b3, b4);
    }

    public static void injectBlockingProgressDialogManage(MelonBaseFragment melonBaseFragment0, k8.a a0) {
        melonBaseFragment0.blockingProgressDialogManage = a0;
    }

    public void injectMembers(MelonBaseFragment melonBaseFragment0) {
        MelonBaseFragment_MembersInjector.injectBlockingProgressDialogManage(melonBaseFragment0, ((k8.a)this.blockingProgressDialogManageProvider.get()));
        MelonBaseFragment_MembersInjector.injectPlaylistManager(melonBaseFragment0, ((s2)this.playlistManagerProvider.get()));
        MelonBaseFragment_MembersInjector.injectVodRepeatManager(melonBaseFragment0, ((u)this.vodRepeatManagerProvider.get()));
        MelonBaseFragment_MembersInjector.injectRemotePlayerManager(melonBaseFragment0, ((s)this.remotePlayerManagerProvider.get()));
        MelonBaseFragment_MembersInjector.injectScreenCaptureUseCase(melonBaseFragment0, ((eb.u)this.screenCaptureUseCaseProvider.get()));
    }

    public void injectMembers(Object object0) {
        this.injectMembers(((MelonBaseFragment)object0));
    }

    public static void injectPlaylistManager(MelonBaseFragment melonBaseFragment0, s2 s20) {
        melonBaseFragment0.playlistManager = s20;
    }

    public static void injectRemotePlayerManager(MelonBaseFragment melonBaseFragment0, s s0) {
        melonBaseFragment0.remotePlayerManager = s0;
    }

    public static void injectScreenCaptureUseCase(MelonBaseFragment melonBaseFragment0, eb.u u0) {
        melonBaseFragment0.screenCaptureUseCase = u0;
    }

    public static void injectVodRepeatManager(MelonBaseFragment melonBaseFragment0, u u0) {
        melonBaseFragment0.vodRepeatManager = u0;
    }
}


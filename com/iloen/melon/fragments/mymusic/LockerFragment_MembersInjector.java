package com.iloen.melon.fragments.mymusic;

import Ub.s;
import Ub.u;
import Xd.a;
import com.iloen.melon.fragments.MelonBaseFragment_MembersInjector;
import ge.b;
import kc.s2;
import mb.k;

public final class LockerFragment_MembersInjector implements a {
    private final b blockingProgressDialogManageProvider;
    private final b loginUseCaseProvider;
    private final b playlistManagerProvider;
    private final b remotePlayerManagerProvider;
    private final b screenCaptureUseCaseProvider;
    private final b vodRepeatManagerProvider;

    public LockerFragment_MembersInjector(b b0, b b1, b b2, b b3, b b4, b b5) {
        this.blockingProgressDialogManageProvider = b0;
        this.playlistManagerProvider = b1;
        this.vodRepeatManagerProvider = b2;
        this.remotePlayerManagerProvider = b3;
        this.screenCaptureUseCaseProvider = b4;
        this.loginUseCaseProvider = b5;
    }

    public static a create(b b0, b b1, b b2, b b3, b b4, b b5) {
        return new LockerFragment_MembersInjector(b0, b1, b2, b3, b4, b5);
    }

    public static void injectLoginUseCase(LockerFragment lockerFragment0, k k0) {
        lockerFragment0.loginUseCase = k0;
    }

    public void injectMembers(LockerFragment lockerFragment0) {
        MelonBaseFragment_MembersInjector.injectBlockingProgressDialogManage(lockerFragment0, ((k8.a)this.blockingProgressDialogManageProvider.get()));
        MelonBaseFragment_MembersInjector.injectPlaylistManager(lockerFragment0, ((s2)this.playlistManagerProvider.get()));
        MelonBaseFragment_MembersInjector.injectVodRepeatManager(lockerFragment0, ((u)this.vodRepeatManagerProvider.get()));
        MelonBaseFragment_MembersInjector.injectRemotePlayerManager(lockerFragment0, ((s)this.remotePlayerManagerProvider.get()));
        MelonBaseFragment_MembersInjector.injectScreenCaptureUseCase(lockerFragment0, ((eb.u)this.screenCaptureUseCaseProvider.get()));
        LockerFragment_MembersInjector.injectLoginUseCase(lockerFragment0, ((k)this.loginUseCaseProvider.get()));
    }

    public void injectMembers(Object object0) {
        this.injectMembers(((LockerFragment)object0));
    }
}


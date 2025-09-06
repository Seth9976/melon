package com.iloen.melon.fragments.local;

import Bc.h;
import Ub.s;
import Ub.u;
import Xd.a;
import com.iloen.melon.fragments.MelonBaseFragment_MembersInjector;
import ge.b;
import kc.s2;
import ob.z;

public final class LocalContentNewDbBaseFragment_MembersInjector implements a {
    private final b blockingProgressDialogManageProvider;
    private final b playerUiHelperProvider;
    private final b playerUseCaseProvider;
    private final b playlistManagerProvider;
    private final b remotePlayerManagerProvider;
    private final b screenCaptureUseCaseProvider;
    private final b vodRepeatManagerProvider;

    public LocalContentNewDbBaseFragment_MembersInjector(b b0, b b1, b b2, b b3, b b4, b b5, b b6) {
        this.blockingProgressDialogManageProvider = b0;
        this.playlistManagerProvider = b1;
        this.vodRepeatManagerProvider = b2;
        this.remotePlayerManagerProvider = b3;
        this.screenCaptureUseCaseProvider = b4;
        this.playerUseCaseProvider = b5;
        this.playerUiHelperProvider = b6;
    }

    public static a create(b b0, b b1, b b2, b b3, b b4, b b5, b b6) {
        return new LocalContentNewDbBaseFragment_MembersInjector(b0, b1, b2, b3, b4, b5, b6);
    }

    public void injectMembers(LocalContentNewDbBaseFragment localContentNewDbBaseFragment0) {
        MelonBaseFragment_MembersInjector.injectBlockingProgressDialogManage(localContentNewDbBaseFragment0, ((k8.a)this.blockingProgressDialogManageProvider.get()));
        MelonBaseFragment_MembersInjector.injectPlaylistManager(localContentNewDbBaseFragment0, ((s2)this.playlistManagerProvider.get()));
        MelonBaseFragment_MembersInjector.injectVodRepeatManager(localContentNewDbBaseFragment0, ((u)this.vodRepeatManagerProvider.get()));
        MelonBaseFragment_MembersInjector.injectRemotePlayerManager(localContentNewDbBaseFragment0, ((s)this.remotePlayerManagerProvider.get()));
        MelonBaseFragment_MembersInjector.injectScreenCaptureUseCase(localContentNewDbBaseFragment0, ((eb.u)this.screenCaptureUseCaseProvider.get()));
        LocalContentNewDbBaseFragment_MembersInjector.injectPlayerUseCase(localContentNewDbBaseFragment0, ((z)this.playerUseCaseProvider.get()));
        LocalContentNewDbBaseFragment_MembersInjector.injectPlayerUiHelper(localContentNewDbBaseFragment0, ((h)this.playerUiHelperProvider.get()));
    }

    public void injectMembers(Object object0) {
        this.injectMembers(((LocalContentNewDbBaseFragment)object0));
    }

    public static void injectPlayerUiHelper(LocalContentNewDbBaseFragment localContentNewDbBaseFragment0, h h0) {
        localContentNewDbBaseFragment0.playerUiHelper = h0;
    }

    public static void injectPlayerUseCase(LocalContentNewDbBaseFragment localContentNewDbBaseFragment0, z z0) {
        localContentNewDbBaseFragment0.playerUseCase = z0;
    }
}


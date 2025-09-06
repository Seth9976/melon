package com.iloen.melon.fragments.webview;

import Ub.s;
import Ub.u;
import Xd.a;
import com.iloen.melon.fragments.MelonBaseFragment_MembersInjector;
import ge.b;
import kc.s2;
import ob.z;

public final class MelonWebViewFragment_MembersInjector implements a {
    private final b blockingProgressDialogManageProvider;
    private final b playerUseCaseProvider;
    private final b playlistManagerProvider;
    private final b playlistManagerProvider2;
    private final b remotePlayerManagerProvider;
    private final b screenCaptureUseCaseProvider;
    private final b vodRepeatManagerProvider;

    public MelonWebViewFragment_MembersInjector(b b0, b b1, b b2, b b3, b b4, b b5, b b6) {
        this.blockingProgressDialogManageProvider = b0;
        this.playlistManagerProvider = b1;
        this.vodRepeatManagerProvider = b2;
        this.remotePlayerManagerProvider = b3;
        this.screenCaptureUseCaseProvider = b4;
        this.playlistManagerProvider2 = b5;
        this.playerUseCaseProvider = b6;
    }

    public static a create(b b0, b b1, b b2, b b3, b b4, b b5, b b6) {
        return new MelonWebViewFragment_MembersInjector(b0, b1, b2, b3, b4, b5, b6);
    }

    public void injectMembers(MelonWebViewFragment melonWebViewFragment0) {
        MelonBaseFragment_MembersInjector.injectBlockingProgressDialogManage(melonWebViewFragment0, ((k8.a)this.blockingProgressDialogManageProvider.get()));
        MelonBaseFragment_MembersInjector.injectPlaylistManager(melonWebViewFragment0, ((s2)this.playlistManagerProvider.get()));
        MelonBaseFragment_MembersInjector.injectVodRepeatManager(melonWebViewFragment0, ((u)this.vodRepeatManagerProvider.get()));
        MelonBaseFragment_MembersInjector.injectRemotePlayerManager(melonWebViewFragment0, ((s)this.remotePlayerManagerProvider.get()));
        MelonBaseFragment_MembersInjector.injectScreenCaptureUseCase(melonWebViewFragment0, ((eb.u)this.screenCaptureUseCaseProvider.get()));
        MelonWebViewFragment_MembersInjector.injectPlaylistManager(melonWebViewFragment0, ((s2)this.playlistManagerProvider2.get()));
        MelonWebViewFragment_MembersInjector.injectPlayerUseCase(melonWebViewFragment0, ((z)this.playerUseCaseProvider.get()));
    }

    public void injectMembers(Object object0) {
        this.injectMembers(((MelonWebViewFragment)object0));
    }

    public static void injectPlayerUseCase(MelonWebViewFragment melonWebViewFragment0, z z0) {
        melonWebViewFragment0.playerUseCase = z0;
    }

    public static void injectPlaylistManager(MelonWebViewFragment melonWebViewFragment0, s2 s20) {
        melonWebViewFragment0.playlistManager = s20;
    }
}


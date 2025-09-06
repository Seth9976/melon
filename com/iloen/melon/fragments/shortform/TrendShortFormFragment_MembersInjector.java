package com.iloen.melon.fragments.shortform;

import Ub.s;
import Ub.u;
import Xd.a;
import com.iloen.melon.fragments.MelonBaseFragment_MembersInjector;
import ge.b;
import kc.s2;
import ob.z;

public final class TrendShortFormFragment_MembersInjector implements a {
    private final b blockingProgressDialogManageProvider;
    private final b playerUseCaseProvider;
    private final b playlistManagerProvider;
    private final b remotePlayerManagerProvider;
    private final b screenCaptureUseCaseProvider;
    private final b vodRepeatManagerProvider;

    public TrendShortFormFragment_MembersInjector(b b0, b b1, b b2, b b3, b b4, b b5) {
        this.blockingProgressDialogManageProvider = b0;
        this.playlistManagerProvider = b1;
        this.vodRepeatManagerProvider = b2;
        this.remotePlayerManagerProvider = b3;
        this.screenCaptureUseCaseProvider = b4;
        this.playerUseCaseProvider = b5;
    }

    public static a create(b b0, b b1, b b2, b b3, b b4, b b5) {
        return new TrendShortFormFragment_MembersInjector(b0, b1, b2, b3, b4, b5);
    }

    public void injectMembers(TrendShortFormFragment trendShortFormFragment0) {
        MelonBaseFragment_MembersInjector.injectBlockingProgressDialogManage(trendShortFormFragment0, ((k8.a)this.blockingProgressDialogManageProvider.get()));
        MelonBaseFragment_MembersInjector.injectPlaylistManager(trendShortFormFragment0, ((s2)this.playlistManagerProvider.get()));
        MelonBaseFragment_MembersInjector.injectVodRepeatManager(trendShortFormFragment0, ((u)this.vodRepeatManagerProvider.get()));
        MelonBaseFragment_MembersInjector.injectRemotePlayerManager(trendShortFormFragment0, ((s)this.remotePlayerManagerProvider.get()));
        MelonBaseFragment_MembersInjector.injectScreenCaptureUseCase(trendShortFormFragment0, ((eb.u)this.screenCaptureUseCaseProvider.get()));
        TrendShortFormFragment_MembersInjector.injectPlayerUseCase(trendShortFormFragment0, ((z)this.playerUseCaseProvider.get()));
    }

    public void injectMembers(Object object0) {
        this.injectMembers(((TrendShortFormFragment)object0));
    }

    public static void injectPlayerUseCase(TrendShortFormFragment trendShortFormFragment0, z z0) {
        trendShortFormFragment0.playerUseCase = z0;
    }
}


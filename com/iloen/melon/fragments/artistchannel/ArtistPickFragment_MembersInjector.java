package com.iloen.melon.fragments.artistchannel;

import Ub.s;
import Ub.u;
import Xd.a;
import com.iloen.melon.fragments.MelonBaseFragment_MembersInjector;
import ge.b;
import kc.s2;
import ob.z;

public final class ArtistPickFragment_MembersInjector implements a {
    private final b blockingProgressDialogManageProvider;
    private final b playerUseCaseProvider;
    private final b playlistManagerProvider;
    private final b remotePlayerManagerProvider;
    private final b screenCaptureUseCaseProvider;
    private final b vodRepeatManagerProvider;

    public ArtistPickFragment_MembersInjector(b b0, b b1, b b2, b b3, b b4, b b5) {
        this.blockingProgressDialogManageProvider = b0;
        this.playlistManagerProvider = b1;
        this.vodRepeatManagerProvider = b2;
        this.remotePlayerManagerProvider = b3;
        this.screenCaptureUseCaseProvider = b4;
        this.playerUseCaseProvider = b5;
    }

    public static a create(b b0, b b1, b b2, b b3, b b4, b b5) {
        return new ArtistPickFragment_MembersInjector(b0, b1, b2, b3, b4, b5);
    }

    public void injectMembers(ArtistPickFragment artistPickFragment0) {
        MelonBaseFragment_MembersInjector.injectBlockingProgressDialogManage(artistPickFragment0, ((k8.a)this.blockingProgressDialogManageProvider.get()));
        MelonBaseFragment_MembersInjector.injectPlaylistManager(artistPickFragment0, ((s2)this.playlistManagerProvider.get()));
        MelonBaseFragment_MembersInjector.injectVodRepeatManager(artistPickFragment0, ((u)this.vodRepeatManagerProvider.get()));
        MelonBaseFragment_MembersInjector.injectRemotePlayerManager(artistPickFragment0, ((s)this.remotePlayerManagerProvider.get()));
        MelonBaseFragment_MembersInjector.injectScreenCaptureUseCase(artistPickFragment0, ((eb.u)this.screenCaptureUseCaseProvider.get()));
        ArtistPickFragment_MembersInjector.injectPlayerUseCase(artistPickFragment0, ((z)this.playerUseCaseProvider.get()));
    }

    public void injectMembers(Object object0) {
        this.injectMembers(((ArtistPickFragment)object0));
    }

    public static void injectPlayerUseCase(ArtistPickFragment artistPickFragment0, z z0) {
        artistPickFragment0.playerUseCase = z0;
    }
}


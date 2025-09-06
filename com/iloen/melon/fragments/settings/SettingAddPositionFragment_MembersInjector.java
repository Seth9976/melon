package com.iloen.melon.fragments.settings;

import Ub.q;
import Ub.s;
import Ub.u;
import Xd.a;
import com.iloen.melon.fragments.MelonBaseFragment_MembersInjector;
import ge.b;
import kc.s2;

public final class SettingAddPositionFragment_MembersInjector implements a {
    private final b blockingProgressDialogManageProvider;
    private final b playbackManagerProvider;
    private final b playlistManagerProvider;
    private final b playlistManagerProvider2;
    private final b remotePlayerManagerProvider;
    private final b screenCaptureUseCaseProvider;
    private final b vodRepeatManagerProvider;

    public SettingAddPositionFragment_MembersInjector(b b0, b b1, b b2, b b3, b b4, b b5, b b6) {
        this.blockingProgressDialogManageProvider = b0;
        this.playlistManagerProvider = b1;
        this.vodRepeatManagerProvider = b2;
        this.remotePlayerManagerProvider = b3;
        this.screenCaptureUseCaseProvider = b4;
        this.playlistManagerProvider2 = b5;
        this.playbackManagerProvider = b6;
    }

    public static a create(b b0, b b1, b b2, b b3, b b4, b b5, b b6) {
        return new SettingAddPositionFragment_MembersInjector(b0, b1, b2, b3, b4, b5, b6);
    }

    public void injectMembers(SettingAddPositionFragment settingAddPositionFragment0) {
        MelonBaseFragment_MembersInjector.injectBlockingProgressDialogManage(settingAddPositionFragment0, ((k8.a)this.blockingProgressDialogManageProvider.get()));
        MelonBaseFragment_MembersInjector.injectPlaylistManager(settingAddPositionFragment0, ((s2)this.playlistManagerProvider.get()));
        MelonBaseFragment_MembersInjector.injectVodRepeatManager(settingAddPositionFragment0, ((u)this.vodRepeatManagerProvider.get()));
        MelonBaseFragment_MembersInjector.injectRemotePlayerManager(settingAddPositionFragment0, ((s)this.remotePlayerManagerProvider.get()));
        MelonBaseFragment_MembersInjector.injectScreenCaptureUseCase(settingAddPositionFragment0, ((eb.u)this.screenCaptureUseCaseProvider.get()));
        SettingAddPositionFragment_MembersInjector.injectPlaylistManager(settingAddPositionFragment0, ((s2)this.playlistManagerProvider2.get()));
        SettingAddPositionFragment_MembersInjector.injectPlaybackManager(settingAddPositionFragment0, ((q)this.playbackManagerProvider.get()));
    }

    public void injectMembers(Object object0) {
        this.injectMembers(((SettingAddPositionFragment)object0));
    }

    public static void injectPlaybackManager(SettingAddPositionFragment settingAddPositionFragment0, q q0) {
        settingAddPositionFragment0.playbackManager = q0;
    }

    public static void injectPlaylistManager(SettingAddPositionFragment settingAddPositionFragment0, s2 s20) {
        settingAddPositionFragment0.playlistManager = s20;
    }
}


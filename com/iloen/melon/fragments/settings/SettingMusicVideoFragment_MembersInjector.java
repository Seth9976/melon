package com.iloen.melon.fragments.settings;

import Ub.s;
import Ub.u;
import Xd.a;
import com.iloen.melon.fragments.MelonBaseFragment_MembersInjector;
import com.melon.utils.system.DeviceData;
import ge.b;
import kc.s2;

public final class SettingMusicVideoFragment_MembersInjector implements a {
    private final b blockingProgressDialogManageProvider;
    private final b mDeviceDataProvider;
    private final b playlistManagerProvider;
    private final b remotePlayerManagerProvider;
    private final b screenCaptureUseCaseProvider;
    private final b vodRepeatManagerProvider;

    public SettingMusicVideoFragment_MembersInjector(b b0, b b1, b b2, b b3, b b4, b b5) {
        this.blockingProgressDialogManageProvider = b0;
        this.playlistManagerProvider = b1;
        this.vodRepeatManagerProvider = b2;
        this.remotePlayerManagerProvider = b3;
        this.screenCaptureUseCaseProvider = b4;
        this.mDeviceDataProvider = b5;
    }

    public static a create(b b0, b b1, b b2, b b3, b b4, b b5) {
        return new SettingMusicVideoFragment_MembersInjector(b0, b1, b2, b3, b4, b5);
    }

    public static void injectMDeviceData(SettingMusicVideoFragment settingMusicVideoFragment0, DeviceData deviceData0) {
        settingMusicVideoFragment0.mDeviceData = deviceData0;
    }

    public void injectMembers(SettingMusicVideoFragment settingMusicVideoFragment0) {
        MelonBaseFragment_MembersInjector.injectBlockingProgressDialogManage(settingMusicVideoFragment0, ((k8.a)this.blockingProgressDialogManageProvider.get()));
        MelonBaseFragment_MembersInjector.injectPlaylistManager(settingMusicVideoFragment0, ((s2)this.playlistManagerProvider.get()));
        MelonBaseFragment_MembersInjector.injectVodRepeatManager(settingMusicVideoFragment0, ((u)this.vodRepeatManagerProvider.get()));
        MelonBaseFragment_MembersInjector.injectRemotePlayerManager(settingMusicVideoFragment0, ((s)this.remotePlayerManagerProvider.get()));
        MelonBaseFragment_MembersInjector.injectScreenCaptureUseCase(settingMusicVideoFragment0, ((eb.u)this.screenCaptureUseCaseProvider.get()));
        SettingMusicVideoFragment_MembersInjector.injectMDeviceData(settingMusicVideoFragment0, ((DeviceData)this.mDeviceDataProvider.get()));
    }

    public void injectMembers(Object object0) {
        this.injectMembers(((SettingMusicVideoFragment)object0));
    }
}


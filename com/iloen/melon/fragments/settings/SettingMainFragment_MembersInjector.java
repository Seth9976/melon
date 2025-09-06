package com.iloen.melon.fragments.settings;

import Ub.s;
import Ub.u;
import Xd.a;
import com.iloen.melon.fragments.MelonBaseFragment_MembersInjector;
import com.melon.utils.system.DeviceData;
import ge.b;
import kc.s2;
import mb.k;
import mb.o;

public final class SettingMainFragment_MembersInjector implements a {
    private final b blockingProgressDialogManageProvider;
    private final b deviceDataProvider;
    private final b loginUseCaseProvider;
    private final b playlistManagerProvider;
    private final b remotePlayerManagerProvider;
    private final b screenCaptureUseCaseProvider;
    private final b simpleAccountUseCaseProvider;
    private final b vodRepeatManagerProvider;

    public SettingMainFragment_MembersInjector(b b0, b b1, b b2, b b3, b b4, b b5, b b6, b b7) {
        this.blockingProgressDialogManageProvider = b0;
        this.playlistManagerProvider = b1;
        this.vodRepeatManagerProvider = b2;
        this.remotePlayerManagerProvider = b3;
        this.screenCaptureUseCaseProvider = b4;
        this.loginUseCaseProvider = b5;
        this.simpleAccountUseCaseProvider = b6;
        this.deviceDataProvider = b7;
    }

    public static a create(b b0, b b1, b b2, b b3, b b4, b b5, b b6, b b7) {
        return new SettingMainFragment_MembersInjector(b0, b1, b2, b3, b4, b5, b6, b7);
    }

    public static void injectDeviceData(SettingMainFragment settingMainFragment0, DeviceData deviceData0) {
        settingMainFragment0.deviceData = deviceData0;
    }

    public static void injectLoginUseCase(SettingMainFragment settingMainFragment0, k k0) {
        settingMainFragment0.loginUseCase = k0;
    }

    public void injectMembers(SettingMainFragment settingMainFragment0) {
        MelonBaseFragment_MembersInjector.injectBlockingProgressDialogManage(settingMainFragment0, ((k8.a)this.blockingProgressDialogManageProvider.get()));
        MelonBaseFragment_MembersInjector.injectPlaylistManager(settingMainFragment0, ((s2)this.playlistManagerProvider.get()));
        MelonBaseFragment_MembersInjector.injectVodRepeatManager(settingMainFragment0, ((u)this.vodRepeatManagerProvider.get()));
        MelonBaseFragment_MembersInjector.injectRemotePlayerManager(settingMainFragment0, ((s)this.remotePlayerManagerProvider.get()));
        MelonBaseFragment_MembersInjector.injectScreenCaptureUseCase(settingMainFragment0, ((eb.u)this.screenCaptureUseCaseProvider.get()));
        SettingMainFragment_MembersInjector.injectLoginUseCase(settingMainFragment0, ((k)this.loginUseCaseProvider.get()));
        SettingMainFragment_MembersInjector.injectSimpleAccountUseCase(settingMainFragment0, ((o)this.simpleAccountUseCaseProvider.get()));
        SettingMainFragment_MembersInjector.injectDeviceData(settingMainFragment0, ((DeviceData)this.deviceDataProvider.get()));
    }

    public void injectMembers(Object object0) {
        this.injectMembers(((SettingMainFragment)object0));
    }

    public static void injectSimpleAccountUseCase(SettingMainFragment settingMainFragment0, o o0) {
        settingMainFragment0.simpleAccountUseCase = o0;
    }
}


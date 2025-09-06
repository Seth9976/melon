package com.iloen.melon.fragments.settings;

import Ub.s;
import Ub.u;
import Xd.a;
import com.iloen.melon.fragments.MelonBaseFragment_MembersInjector;
import com.melon.utils.preference.PreferenceHelper;
import ge.b;
import kc.s2;

public final class SettingPushFragment_MembersInjector implements a {
    private final b blockingProgressDialogManageProvider;
    private final b playlistManagerProvider;
    private final b preferenceHelperProvider;
    private final b remotePlayerManagerProvider;
    private final b screenCaptureUseCaseProvider;
    private final b vodRepeatManagerProvider;

    public SettingPushFragment_MembersInjector(b b0, b b1, b b2, b b3, b b4, b b5) {
        this.blockingProgressDialogManageProvider = b0;
        this.playlistManagerProvider = b1;
        this.vodRepeatManagerProvider = b2;
        this.remotePlayerManagerProvider = b3;
        this.screenCaptureUseCaseProvider = b4;
        this.preferenceHelperProvider = b5;
    }

    public static a create(b b0, b b1, b b2, b b3, b b4, b b5) {
        return new SettingPushFragment_MembersInjector(b0, b1, b2, b3, b4, b5);
    }

    public void injectMembers(SettingPushFragment settingPushFragment0) {
        MelonBaseFragment_MembersInjector.injectBlockingProgressDialogManage(settingPushFragment0, ((k8.a)this.blockingProgressDialogManageProvider.get()));
        MelonBaseFragment_MembersInjector.injectPlaylistManager(settingPushFragment0, ((s2)this.playlistManagerProvider.get()));
        MelonBaseFragment_MembersInjector.injectVodRepeatManager(settingPushFragment0, ((u)this.vodRepeatManagerProvider.get()));
        MelonBaseFragment_MembersInjector.injectRemotePlayerManager(settingPushFragment0, ((s)this.remotePlayerManagerProvider.get()));
        MelonBaseFragment_MembersInjector.injectScreenCaptureUseCase(settingPushFragment0, ((eb.u)this.screenCaptureUseCaseProvider.get()));
        SettingPushFragment_MembersInjector.injectPreferenceHelper(settingPushFragment0, ((PreferenceHelper)this.preferenceHelperProvider.get()));
    }

    public void injectMembers(Object object0) {
        this.injectMembers(((SettingPushFragment)object0));
    }

    public static void injectPreferenceHelper(SettingPushFragment settingPushFragment0, PreferenceHelper preferenceHelper0) {
        settingPushFragment0.preferenceHelper = preferenceHelper0;
    }
}


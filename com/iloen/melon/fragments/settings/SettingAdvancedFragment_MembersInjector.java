package com.iloen.melon.fragments.settings;

import Ub.s;
import Ub.u;
import Vb.t0;
import Xd.a;
import com.iloen.melon.fragments.MelonBaseFragment_MembersInjector;
import ge.b;
import kc.s2;

public final class SettingAdvancedFragment_MembersInjector implements a {
    private final b blockingProgressDialogManageProvider;
    private final b playerRulesProvider;
    private final b playlistManagerProvider;
    private final b remotePlayerManagerProvider;
    private final b screenCaptureUseCaseProvider;
    private final b vodRepeatManagerProvider;

    public SettingAdvancedFragment_MembersInjector(b b0, b b1, b b2, b b3, b b4, b b5) {
        this.blockingProgressDialogManageProvider = b0;
        this.playlistManagerProvider = b1;
        this.vodRepeatManagerProvider = b2;
        this.remotePlayerManagerProvider = b3;
        this.screenCaptureUseCaseProvider = b4;
        this.playerRulesProvider = b5;
    }

    public static a create(b b0, b b1, b b2, b b3, b b4, b b5) {
        return new SettingAdvancedFragment_MembersInjector(b0, b1, b2, b3, b4, b5);
    }

    public void injectMembers(SettingAdvancedFragment settingAdvancedFragment0) {
        MelonBaseFragment_MembersInjector.injectBlockingProgressDialogManage(settingAdvancedFragment0, ((k8.a)this.blockingProgressDialogManageProvider.get()));
        MelonBaseFragment_MembersInjector.injectPlaylistManager(settingAdvancedFragment0, ((s2)this.playlistManagerProvider.get()));
        MelonBaseFragment_MembersInjector.injectVodRepeatManager(settingAdvancedFragment0, ((u)this.vodRepeatManagerProvider.get()));
        MelonBaseFragment_MembersInjector.injectRemotePlayerManager(settingAdvancedFragment0, ((s)this.remotePlayerManagerProvider.get()));
        MelonBaseFragment_MembersInjector.injectScreenCaptureUseCase(settingAdvancedFragment0, ((eb.u)this.screenCaptureUseCaseProvider.get()));
        SettingAdvancedFragment_MembersInjector.injectPlayerRules(settingAdvancedFragment0, ((t0)this.playerRulesProvider.get()));
    }

    public void injectMembers(Object object0) {
        this.injectMembers(((SettingAdvancedFragment)object0));
    }

    public static void injectPlayerRules(SettingAdvancedFragment settingAdvancedFragment0, t0 t00) {
        settingAdvancedFragment0.playerRules = t00;
    }
}


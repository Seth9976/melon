package com.iloen.melon.fragments.settings.alarm;

import Ab.d;
import android.app.Application;
import ge.b;

public final class SettingAlarmListViewModel_Factory implements b {
    private final b applicationProvider;
    private final b voiceAlarmUseCaseProvider;

    public SettingAlarmListViewModel_Factory(b b0, b b1) {
        this.voiceAlarmUseCaseProvider = b0;
        this.applicationProvider = b1;
    }

    public static SettingAlarmListViewModel_Factory create(b b0, b b1) {
        return new SettingAlarmListViewModel_Factory(b0, b1);
    }

    public SettingAlarmListViewModel get() {
        return SettingAlarmListViewModel_Factory.newInstance(((d)this.voiceAlarmUseCaseProvider.get()), ((Application)this.applicationProvider.get()));
    }

    @Override  // javax.inject.Provider
    public Object get() {
        return this.get();
    }

    public static SettingAlarmListViewModel newInstance(d d0, Application application0) {
        return new SettingAlarmListViewModel(d0, application0);
    }
}


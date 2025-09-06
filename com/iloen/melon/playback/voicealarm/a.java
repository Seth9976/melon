package com.iloen.melon.playback.voicealarm;

public final class a implements we.a {
    public final int a;
    public final AlarmPlayService b;

    public a(AlarmPlayService alarmPlayService0, int v) {
        this.a = v;
        this.b = alarmPlayService0;
        super();
    }

    @Override  // we.a
    public final Object invoke() {
        return this.a != 0 ? AlarmPlayService.broadcastReceiver_delegate$lambda$1(this.b) : AlarmPlayService.alarmNotificationManager_delegate$lambda$0(this.b);
    }
}


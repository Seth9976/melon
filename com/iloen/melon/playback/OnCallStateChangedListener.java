package com.iloen.melon.playback;

import kotlin.Metadata;

@Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\b\b\bf\u0018\u00002\u00020\u0001J\u000F\u0010\u0003\u001A\u00020\u0002H&¢\u0006\u0004\b\u0003\u0010\u0004J\u000F\u0010\u0005\u001A\u00020\u0002H&¢\u0006\u0004\b\u0005\u0010\u0004J\u000F\u0010\u0006\u001A\u00020\u0002H&¢\u0006\u0004\b\u0006\u0010\u0004J\u000F\u0010\u0007\u001A\u00020\u0002H&¢\u0006\u0004\b\u0007\u0010\u0004J\u000F\u0010\b\u001A\u00020\u0002H&¢\u0006\u0004\b\b\u0010\u0004J\u000F\u0010\t\u001A\u00020\u0002H&¢\u0006\u0004\b\t\u0010\u0004¨\u0006\nÀ\u0006\u0003"}, d2 = {"Lcom/iloen/melon/playback/OnCallStateChangedListener;", "", "Lie/H;", "onIncomingCallRinging", "()V", "onIncomingCallStarted", "onIncomingCallEnded", "onIncomingCallMissed", "onOutgoingCallStarted", "onOutgoingCallEnded", "app_playstoreProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 0x30)
public interface OnCallStateChangedListener {
    void onIncomingCallEnded();

    void onIncomingCallMissed();

    void onIncomingCallRinging();

    void onIncomingCallStarted();

    void onOutgoingCallEnded();

    void onOutgoingCallStarted();
}


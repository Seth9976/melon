package com.iloen.melon.eventbus;

import kotlin.Metadata;

@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0007\b\u0017\u0018\u00002\u00020\u0001:\u0004\u0004\u0005\u0006\u0007B\u0007¢\u0006\u0004\b\u0002\u0010\u0003¨\u0006\b"}, d2 = {"Lcom/iloen/melon/eventbus/EventPlayback;", "", "<init>", "()V", "VolumeChanged", "SeekComplete", "KeepOnScreen", "TriggerVideoLog", "app_playstoreProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 0x30)
public class EventPlayback {
    @Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000B\n\u0002\b\u0004\b\u0007\u0018\u00002\u00020\u0001B\u000F\u0012\u0006\u0010\u0002\u001A\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005R\u0011\u0010\u0002\u001A\u00020\u0003¢\u0006\b\n\u0000\u001A\u0004\b\u0002\u0010\u0006¨\u0006\u0007"}, d2 = {"Lcom/iloen/melon/eventbus/EventPlayback$KeepOnScreen;", "Lcom/iloen/melon/eventbus/EventPlayback;", "isKeepOn", "", "<init>", "(Z)V", "()Z", "app_playstoreProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 0x30)
    public static final class KeepOnScreen extends EventPlayback {
        public static final int $stable;
        private final boolean isKeepOn;

        public KeepOnScreen(boolean z) {
            this.isKeepOn = z;
        }

        public final boolean isKeepOn() {
            return this.isKeepOn;
        }
    }

    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0007\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003¨\u0006\u0004"}, d2 = {"Lcom/iloen/melon/eventbus/EventPlayback$SeekComplete;", "Lcom/iloen/melon/eventbus/EventPlayback;", "<init>", "()V", "app_playstoreProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 0x30)
    public static final class SeekComplete extends EventPlayback {
        public static final int $stable;

    }

    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0007\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003¨\u0006\u0004"}, d2 = {"Lcom/iloen/melon/eventbus/EventPlayback$TriggerVideoLog;", "Lcom/iloen/melon/eventbus/EventPlayback;", "<init>", "()V", "app_playstoreProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 0x30)
    public static final class TriggerVideoLog extends EventPlayback {
        public static final int $stable;

    }

    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0007\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003¨\u0006\u0004"}, d2 = {"Lcom/iloen/melon/eventbus/EventPlayback$VolumeChanged;", "Lcom/iloen/melon/eventbus/EventPlayback;", "<init>", "()V", "app_playstoreProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 0x30)
    public static final class VolumeChanged extends EventPlayback {
        public static final int $stable;

    }

    public static final int $stable;

}


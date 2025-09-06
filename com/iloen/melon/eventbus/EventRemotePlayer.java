package com.iloen.melon.eventbus;

import ic.e;

public class EventRemotePlayer {
    public static class EventDlna extends EventRemotePlayer {
        public static EventRemotePlayer CONNECTION_SUCCESS;
        public static EventRemotePlayer DISCONNECTION_SUCCESS;
        public static EventRemotePlayer FOUND_DEVICE;
        public static EventRemotePlayer LOST_DEVICE;
        public static EventRemotePlayer PLAYER_PAUSE;
        public static EventRemotePlayer PLAYER_PLAYING;
        public static EventRemotePlayer PLAYER_STOP;
        public static EventRemotePlayer START_SEARCH;
        public static EventRemotePlayer STOP_SEARCH;

        static {
            EventDlna.PLAYER_STOP = new EventDlna(EventType.PLAYER_STOP);
            EventDlna.PLAYER_PAUSE = new EventDlna(EventType.PLAYER_PAUSE);
            EventDlna.PLAYER_PLAYING = new EventDlna(EventType.PLAYER_PLAYING);
            EventDlna.CONNECTION_SUCCESS = new EventDlna(EventType.CONNECTION_SUCCESS);
            EventDlna.DISCONNECTION_SUCCESS = new EventDlna(EventType.DISCONNECTION_SUCCESS);
            EventDlna.START_SEARCH = new EventDlna(EventType.START_SEARCH);
            EventDlna.STOP_SEARCH = new EventDlna(EventType.STOP_SEARCH);
            EventDlna.FOUND_DEVICE = new EventDlna(EventType.FOUND_DEVICE);
            EventDlna.LOST_DEVICE = new EventDlna(EventType.LOST_DEVICE);
        }

        private EventDlna(EventType eventRemotePlayer$EventType0) {
            super(eventRemotePlayer$EventType0, 0);
        }
    }

    public static class EventGoogleCast extends EventRemotePlayer {
        public static EventRemotePlayer DEVICE_VOLUME_CHANGE;
        public static EventRemotePlayer PLAYER_PAUSE;
        public static EventRemotePlayer PLAYER_PLAYING;

        static {
            EventGoogleCast.PLAYER_PAUSE = new EventGoogleCast(EventType.PLAYER_PAUSE);
            EventGoogleCast.PLAYER_PLAYING = new EventGoogleCast(EventType.PLAYER_PLAYING);
            EventGoogleCast.DEVICE_VOLUME_CHANGE = new EventGoogleCast(EventType.DEVICE_VOLUME_CHANGE);
        }

        private EventGoogleCast(EventType eventRemotePlayer$EventType0) {
            super(eventRemotePlayer$EventType0, 0);
        }
    }

    public static enum EventType {
        NONE,
        PLAYER_PAUSE,
        PLAYER_PLAYING,
        PLAYER_STOP,
        CONNECTION_SUCCESS,
        DISCONNECTION_SUCCESS,
        DEVICE_VOLUME_CHANGE,
        START_SEARCH,
        STOP_SEARCH,
        FOUND_DEVICE,
        LOST_DEVICE,
        CHANGE_PREFERENCE;

        private static EventType[] $values() [...] // Inlined contents
    }

    private boolean mContinuePlay;
    private e mDevice;
    private EventType mEventType;

    private EventRemotePlayer(EventType eventRemotePlayer$EventType0) {
        this.mContinuePlay = false;
        this.mEventType = eventRemotePlayer$EventType0;
    }

    public EventRemotePlayer(EventType eventRemotePlayer$EventType0, int v) {
        this(eventRemotePlayer$EventType0);
    }

    public e getRemoteDevice() {
        return this.mDevice;
    }

    public EventType getType() {
        return this.mEventType;
    }

    public boolean isContinuePlay() {
        return this.mContinuePlay;
    }

    public static void postChangePreference() {
        EventBusHelper.post(new EventRemotePlayer(EventType.CHANGE_PREFERENCE));
    }

    public void setContinuePlay(boolean z) {
        this.mContinuePlay = z;
    }

    public void setRemoteDevice(e e0) {
        this.mDevice = e0;
    }

    @Override
    public String toString() {
        return super.toString() + " : " + this.mEventType;
    }
}


package com.iloen.melon.fragments.main.common;

public class Event {
    private static int EVENT_FAN = 1;
    private static int EVENT_LIKE = 0;
    private static int EVENT_MORE = 0;
    private static int EVENT_MOVE_SCROLL = 0;
    private static int EVENT_OPEN_MULTI_ARTIST = 0;
    private static int EVENT_PLAY_ALBUM = 0;
    private static int EVENT_PLAY_MV = 0;
    private static int EVENT_PLAY_PLAYLIST = 0;
    private static int EVENT_PLAY_RADIO = 0;
    private static int EVENT_PLAY_SONG = 0;
    private static int EVENT_PLAY_SONGS = 0;
    private static int EVENT_REFRESH = 0;
    public static final Event FAN = null;
    public static final Event LIKE = null;
    public static final Event MORE = null;
    public static final Event MOVE_SCROLL = null;
    public static final Event NONE = null;
    private static int NULL = -1;
    public static final Event OPEN_MULTI_ARTIST;
    public static final Event PLAY_ALBUM;
    public static final Event PLAY_MV;
    public static final Event PLAY_PLAYLIST;
    public static final Event PLAY_RADIO;
    public static final Event PLAY_SONG;
    public static final Event PLAY_SONGS;
    public static final Event REFRESH;
    private final int type;

    static {
        Event.EVENT_PLAY_SONG = 2;
        Event.EVENT_PLAY_SONGS = 3;
        Event.EVENT_PLAY_ALBUM = 4;
        Event.EVENT_PLAY_MV = 5;
        Event.EVENT_PLAY_PLAYLIST = 6;
        Event.EVENT_PLAY_RADIO = 7;
        Event.EVENT_OPEN_MULTI_ARTIST = 8;
        Event.EVENT_MORE = 9;
        Event.EVENT_LIKE = 10;
        Event.EVENT_MOVE_SCROLL = 11;
        Event.NONE = new Event(-1);
        Event.REFRESH = new Event(Event.EVENT_REFRESH);
        Event.FAN = new Event(Event.EVENT_FAN);
        Event.PLAY_SONG = new Event(2);
        Event.PLAY_SONGS = new Event(3);
        Event.PLAY_ALBUM = new Event(4);
        Event.PLAY_MV = new Event(5);
        Event.PLAY_PLAYLIST = new Event(6);
        Event.PLAY_RADIO = new Event(7);
        Event.OPEN_MULTI_ARTIST = new Event(8);
        Event.MORE = new Event(9);
        Event.LIKE = new Event(10);
        Event.MOVE_SCROLL = new Event(11);
    }

    private Event(int v) {
        this.type = v;
    }

    @Override
    public String toString() {
        return String.valueOf(this.type);
    }
}


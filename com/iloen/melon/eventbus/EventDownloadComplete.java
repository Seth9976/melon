package com.iloen.melon.eventbus;

public class EventDownloadComplete {
    public final String path;
    public final int songId;

    public EventDownloadComplete(int v, String s) {
        this.songId = v;
        this.path = s;
    }
}


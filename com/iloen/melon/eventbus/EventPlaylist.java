package com.iloen.melon.eventbus;

import java.util.List;

public class EventPlaylist {
    public static class EventAddSongIds extends EventPlaylist {
        public List addList;

        public EventAddSongIds(String s, List list0) {
            super(s);
            this.addList = list0;
        }
    }

    public static class EventDeleteSong extends EventPlaylist {
        public List delList;

        public EventDeleteSong(String s, List list0) {
            super(s);
            this.delList = list0;
        }
    }

    public String playlistSeq;

    public EventPlaylist(String s) {
        this.playlistSeq = s;
    }
}


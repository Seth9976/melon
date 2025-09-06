package com.iloen.melon.fragments.mymusic;

import java.util.ArrayList;

public class SeriesDjPlaylist {
    static final class SeriesDjPlaylistListHolder {
        private static final SeriesDjPlaylist sInstance;

        static {
            SeriesDjPlaylistListHolder.sInstance = new SeriesDjPlaylist();
        }

        public static SeriesDjPlaylist a() {
            return SeriesDjPlaylistListHolder.sInstance;
        }
    }

    private ArrayList mDjPlaylistList;

    public ArrayList getDjPlaylistList() {
        return this.mDjPlaylistList;
    }

    public static SeriesDjPlaylist getInstance() {
        return SeriesDjPlaylistListHolder.a();
    }

    public void setDjPlaylistList(ArrayList arrayList0) {
        this.mDjPlaylistList = arrayList0;
    }
}


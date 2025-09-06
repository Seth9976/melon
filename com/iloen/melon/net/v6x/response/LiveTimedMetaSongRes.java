package com.iloen.melon.net.v6x.response;

import S7.b;
import com.melon.net.res.common.ResponseBase;
import com.melon.net.res.common.SongInfoBase;
import java.util.ArrayList;

public class LiveTimedMetaSongRes extends ResponseV6Res {
    public static class RESPONSE extends ResponseBase {
        private static final long serialVersionUID = 6653103273724718306L;
        @b("SONGLIST")
        public ArrayList songList;
        @b("TITLE")
        public String title;

        public RESPONSE() {
            this.title = "";
        }
    }

    public static class SONG extends SongInfoBase {
        @b("ISPICK")
        public boolean isPick;
        private static final long serialVersionUID = 0xFCA6BF877368D0A3L;

        public SONG() {
            this.isPick = false;
        }
    }

    @b("response")
    public RESPONSE response;
    private static final long serialVersionUID = 0x711524E24FB295D1L;

    public LiveTimedMetaSongRes() {
        this.response = null;
    }
}


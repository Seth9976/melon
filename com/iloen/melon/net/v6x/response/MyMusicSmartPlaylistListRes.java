package com.iloen.melon.net.v6x.response;

import S7.b;
import com.iloen.melon.net.v4x.common.ArtistPlayListInfoBase;
import com.iloen.melon.net.v4x.common.ToStringUtil;
import com.melon.net.res.common.ResponseBase;
import java.util.ArrayList;

public class MyMusicSmartPlaylistListRes extends ResponseV6Res {
    public static class RESPONSE extends ResponseBase {
        public static class PLAYLISTLIST extends ArtistPlayListInfoBase {
            @b("MEMBERDJICONTYPE")
            public String memberDjIconType;
            private static final long serialVersionUID = 0x3603791C90528E40L;

            public PLAYLISTLIST() {
                this.memberDjIconType = "";
            }
        }

        @b("HASMORE")
        public boolean hasMore;
        @b("MULTIDELMAXCNT")
        public int multiDelMaxCnt;
        @b("PLAYLISTLIST")
        public ArrayList playlistList;
        private static final long serialVersionUID = 4040399313254560296L;

        public RESPONSE() {
            this.hasMore = false;
            this.multiDelMaxCnt = 0;
            this.playlistList = null;
        }
    }

    @b("response")
    public RESPONSE response;
    private static final long serialVersionUID = 9070029838635571562L;

    @Override
    public String toString() {
        return ToStringUtil.toStringFields(this);
    }
}


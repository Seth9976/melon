package com.iloen.melon.net.v4x.response;

import S7.b;
import com.melon.net.res.common.ResponseBase;
import com.melon.net.res.common.SongInfoBase;
import java.util.ArrayList;

public class ForUSearchRecommListRes extends ResponseV4Res {
    public static class Response extends ResponseBase {
        public static class SONGLIST extends SongInfoBase {
            private static final long serialVersionUID = 7105282830680620717L;

        }

        @b("ARTISTCOUNT")
        public String artistCount;
        @b("ARTISTHASMORE")
        public String artistHasMore;
        @b("ARTISTLIST")
        public ArrayList artistList;
        private static final long serialVersionUID = 0x39563D2EAB8544D8L;
        @b("SONGCOUNT")
        public String songCount;
        @b("SONGHASMORE")
        public String songHasMore;
        @b("SONGLIST")
        public ArrayList songList;

    }

    @b("response")
    public Response response;
    private static final long serialVersionUID = 0x6F8F4E359D3CAD7EL;

    public ForUSearchRecommListRes() {
        this.response = null;
    }
}


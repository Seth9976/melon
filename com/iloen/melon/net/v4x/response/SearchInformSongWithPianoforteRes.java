package com.iloen.melon.net.v4x.response;

import S7.b;
import com.iloen.melon.net.v4x.common.ToStringUtil;
import com.melon.net.res.common.ResponseBase;
import com.melon.net.res.common.SongInfoBase;

public class SearchInformSongWithPianoforteRes extends ResponseV4Res {
    public static class RESPONSE extends ResponseBase {
        public static class SONGINFO extends SongInfoBase {
            private static final long serialVersionUID = 8516050281831025102L;

        }

        private static final long serialVersionUID = 0xED47225D7ECC0FC6L;
        @b("SONGINFO")
        public SONGINFO songInfo;

    }

    @b("response")
    public RESPONSE response;
    private static final long serialVersionUID = 0xA2EFB4C03F424010L;

    public SearchInformSongWithPianoforteRes() {
        this.response = null;
    }

    @Override
    public String toString() {
        return ToStringUtil.toStringFields(this);
    }
}


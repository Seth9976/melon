package com.iloen.melon.net.v4x.response;

import S7.b;
import com.melon.net.res.common.ResponseBase;
import com.melon.net.res.common.SongInfoBase;
import java.util.ArrayList;

public class ForUSearchAutoComplListForURes extends ResponseV4Res {
    public static class Response extends ResponseBase {
        public static class SONGLIST extends SongInfoBase {
            private static final long serialVersionUID = 0x4350E141E5F6F3C3L;

        }

        @b("ARTISTLIST")
        public ArrayList artistList;
        private static final long serialVersionUID = -2457802726125244008L;
        @b("SONGLIST")
        public ArrayList songList;

    }

    @b("response")
    public Response response;
    private static final long serialVersionUID = 0xF3BA874F82F2AD48L;

    public ForUSearchAutoComplListForURes() {
        this.response = null;
    }
}


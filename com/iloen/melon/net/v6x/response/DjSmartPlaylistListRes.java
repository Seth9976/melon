package com.iloen.melon.net.v6x.response;

import S7.b;
import com.iloen.melon.net.v4x.common.ArtistPlayListInfoBase;
import com.iloen.melon.net.v4x.common.ToStringUtil;
import com.melon.net.res.common.ResponseBase;
import java.util.ArrayList;

public class DjSmartPlaylistListRes extends ResponseV6Res {
    public static class RESPONSE extends ResponseBase {
        public static class DJPLAYLISTLIST extends ArtistPlayListInfoBase {
            @b("MEMBERDJICONTYPE")
            public String memberDjIconType;
            private static final long serialVersionUID = 0xC57B69E28704097FL;

            public DJPLAYLISTLIST() {
                this.memberDjIconType = "";
            }
        }

        @b("DJPLAYLISTLIST")
        public ArrayList djPlaylistList;
        @b("HASMORE")
        public boolean hasMore;
        @b("MULTIDELMAXCNT")
        public int multiDelMaxCnt;
        private static final long serialVersionUID = 0xD81AB3D4B5E2511CL;

        public RESPONSE() {
            this.hasMore = false;
            this.multiDelMaxCnt = 0;
            this.djPlaylistList = null;
        }
    }

    @b("response")
    public RESPONSE response;
    private static final long serialVersionUID = 0xE204E7C3D9AED01CL;

    @Override
    public String toString() {
        return ToStringUtil.toStringFields(this);
    }
}


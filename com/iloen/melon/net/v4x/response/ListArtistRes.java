package com.iloen.melon.net.v4x.response;

import S7.b;
import com.iloen.melon.net.ResponseAdapter;
import com.iloen.melon.net.v4x.common.ToStringUtil;
import com.iloen.melon.net.v5x.common.StatsElementsBase;
import com.melon.net.res.common.ResponseBase;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collection;

public class ListArtistRes extends ResponseV4Res implements ResponseAdapter {
    public static class Response extends ResponseBase {
        public static class CONTENTSLIST implements Serializable {
            @b("ACTGENRE")
            public String actGenre;
            @b("ARTISTID")
            public String artistId;
            @b("ARTISTIMG")
            public String artistImg;
            @b("ARTISTNAME")
            public String artistName;
            @b("ISEXCARTIST")
            public boolean isExcArtist;

        }

        @b("CONTENTSLIST")
        public ArrayList contentsList;
        @b("HASMORE")
        public boolean hasMore;
        private static final long serialVersionUID = 0x673ED9CA8CA2BD67L;

        public Response() {
            this.hasMore = false;
            this.contentsList = null;
        }
    }

    @b("response")
    public Response response;
    private static final long serialVersionUID = 0xD3C7811BBFB3AC4L;

    @Override  // com.iloen.melon.net.ResponseAdapter
    public Collection getItems() {
        Response listArtistRes$Response0 = this.response;
        return listArtistRes$Response0 != null ? listArtistRes$Response0.contentsList : null;
    }

    @Override  // com.iloen.melon.net.ResponseAdapter
    public StatsElementsBase getStatsElements() {
        return null;
    }

    @Override  // com.iloen.melon.net.ResponseAdapter
    public boolean hasMore() {
        return this.response == null ? false : this.response.hasMore;
    }

    @Override
    public String toString() {
        return ToStringUtil.toStringFields(this);
    }
}


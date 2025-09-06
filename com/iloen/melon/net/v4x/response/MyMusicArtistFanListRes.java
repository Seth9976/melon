package com.iloen.melon.net.v4x.response;

import S7.b;
import com.iloen.melon.net.ResponseAdapter;
import com.iloen.melon.net.v4x.common.ToStringUtil;
import com.iloen.melon.net.v5x.common.StatsElementsBase;
import com.melon.net.res.common.ArtistInfoBase;
import com.melon.net.res.common.ResponseBase;
import java.util.ArrayList;
import java.util.Collection;

public class MyMusicArtistFanListRes extends ResponseV4Res implements ResponseAdapter {
    public static class RESPONSE extends ResponseBase {
        public static class ARTISTLIST extends ArtistInfoBase {
            @b("CONTSTYPECODE")
            public String contstypecode;
            private static final long serialVersionUID = 0xD9856B06AA5F65BFL;
            @b("TLINEDATE")
            public String tlinedate;
            @b("TLINETYPE")
            public String tlinetype;
            @b("USERSCORE")
            public String userscore;

            public ARTISTLIST() {
                this.tlinedate = "";
                this.tlinetype = "";
                this.userscore = "";
                this.contstypecode = "";
            }
        }

        @b("ARTISTLIST")
        public ArrayList artistlist;
        @b("HASMORE")
        public boolean hasMore;
        private static final long serialVersionUID = 8366096073275820181L;

        public RESPONSE() {
            this.artistlist = null;
        }
    }

    @b("response")
    public RESPONSE response;
    private static final long serialVersionUID = 0xB7C7EFCAE609EB8CL;

    @Override  // com.iloen.melon.net.ResponseAdapter
    public Collection getItems() {
        RESPONSE myMusicArtistFanListRes$RESPONSE0 = this.response;
        return myMusicArtistFanListRes$RESPONSE0 != null ? myMusicArtistFanListRes$RESPONSE0.artistlist : null;
    }

    @Override  // com.iloen.melon.net.ResponseAdapter, com.iloen.melon.net.HttpResponse
    public String getMenuId() {
        return this.response == null ? "" : this.response.menuId;
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


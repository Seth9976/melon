package com.iloen.melon.net.v5x.response;

import S7.b;
import com.iloen.melon.net.ResponseAdapter;
import com.iloen.melon.net.v4x.common.ToStringUtil;
import com.iloen.melon.net.v4x.response.ResponseV4Res;
import com.iloen.melon.net.v5x.common.StatsElementsBase;
import com.melon.net.res.common.AlbumInfoBase;
import com.melon.net.res.common.ArtistInfoBase;
import com.melon.net.res.common.ResponseBase;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collection;

public class GenreMoreArtistRes extends ResponseV4Res implements ResponseAdapter {
    public static class RESPONSE extends ResponseBase {
        public static class ARTISTLIST extends ArtistInfoBase {
            @b("ALBUM")
            public AlbumInfoBase album;
            @b("ARTISTDESC")
            public String artistDesc;
            @b("GNRARTISTSEQ")
            public String gnrArtistSeq;
            private static final long serialVersionUID = 0xF64C708579B5E712L;

            public ARTISTLIST() {
                this.gnrArtistSeq = "";
                this.artistDesc = "";
                this.album = null;
            }
        }

        public static class FILTERLIST implements Serializable {
            @b("FILTERTYPECODE")
            public String filterTypeCode;
            @b("FILTERTYPEFLG")
            public String filterTypeFlg;
            @b("FILTERTYPENAME")
            public String filterTypeName;

            public FILTERLIST() {
                this.filterTypeFlg = "";
                this.filterTypeCode = "";
                this.filterTypeName = "";
            }
        }

        @b("ARTISTLIST")
        public ArrayList artistList;
        @b("FILTERLIST")
        public ArrayList filterList;
        @b("HASMORE")
        public boolean hasMore;
        private static final long serialVersionUID = -8080679478749324260L;

        public RESPONSE() {
            this.artistList = null;
            this.filterList = null;
        }
    }

    @b("response")
    public RESPONSE response;
    private static final long serialVersionUID = 0xB938834130920B87L;

    public GenreMoreArtistRes() {
        this.response = null;
    }

    @Override  // com.iloen.melon.net.ResponseAdapter
    public Collection getItems() {
        RESPONSE genreMoreArtistRes$RESPONSE0 = this.response;
        return genreMoreArtistRes$RESPONSE0 != null ? genreMoreArtistRes$RESPONSE0.artistList : null;
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


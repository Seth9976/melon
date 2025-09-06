package com.iloen.melon.net.v6x.response;

import S7.b;
import com.iloen.melon.net.ResponseAdapter;
import com.iloen.melon.net.v4x.common.ToStringUtil;
import com.iloen.melon.net.v5x.common.StatsElementsBase;
import com.melon.net.res.common.AlbumInfoBase;
import com.melon.net.res.common.ResponseBase;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collection;
import org.jetbrains.annotations.NotNull;

public class ArtistPickWholeListRes extends ResponseV6Res implements ResponseAdapter {
    public static class RESPONSE extends ResponseBase {
        public static class ArtistPick implements Serializable {
            @b("ALBUMINFO")
            public AlbumInfoBase albuminfo;
            @b("ARTISTID")
            public String artistId;
            @b("ARTISTNAME")
            public String artistName;
            @b("ARTISTPICKSEQ")
            public String artistPickSeq;
            @b("ARTISTPICKTHUMBURL")
            public String artistPickThumbUrl;
            @b("ARTISTPICKTITLE")
            public String artistPickTitle;
            @b("LIKECNT")
            public String likeCnt;
            private static final long serialVersionUID = 0xC094A994EF433584L;

            public ArtistPick() {
                this.artistPickSeq = "";
                this.artistId = "";
                this.artistName = "";
                this.artistPickTitle = "";
                this.artistPickThumbUrl = "";
                this.likeCnt = "";
                this.albuminfo = null;
            }
        }

        @b("ARTISTPICKLIST")
        public ArrayList artistPickList;
        @b("HASMORE")
        public boolean hasMore;
        private static final long serialVersionUID = 0xF35FF623D6A970FDL;
        @b("VIEWTYPE")
        public String viewType;

        public RESPONSE() {
            this.hasMore = false;
            this.viewType = "";
        }
    }

    @b("response")
    public RESPONSE response;
    private static final long serialVersionUID = 0x14860C7E0E5629D2L;

    public ArtistPickWholeListRes() {
        this.response = null;
    }

    @Override  // com.iloen.melon.net.ResponseAdapter
    public Collection getItems() {
        RESPONSE artistPickWholeListRes$RESPONSE0 = this.response;
        return artistPickWholeListRes$RESPONSE0 != null ? artistPickWholeListRes$RESPONSE0.artistPickList : null;
    }

    @Override  // com.iloen.melon.net.ResponseAdapter
    public StatsElementsBase getStatsElements() {
        return null;
    }

    @Override  // com.iloen.melon.net.ResponseAdapter
    public boolean hasMore() {
        return this.response != null && this.response.hasMore;
    }

    @Override
    @NotNull
    public String toString() {
        return ToStringUtil.toStringFields(this);
    }
}


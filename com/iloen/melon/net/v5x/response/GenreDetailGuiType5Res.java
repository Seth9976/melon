package com.iloen.melon.net.v5x.response;

import S7.b;
import com.iloen.melon.net.ResponseAdapter;
import com.iloen.melon.net.v4x.common.ToStringUtil;
import com.iloen.melon.net.v4x.response.ResponseV4Res;
import com.iloen.melon.net.v5x.common.StatsElementsBase;
import com.melon.net.res.common.AlbumInfoBase;
import com.melon.net.res.common.ArtistInfoBase;
import com.melon.net.res.common.ResponseBase;
import com.melon.net.res.common.SongInfoBase;
import java.util.ArrayList;
import java.util.Collection;

public class GenreDetailGuiType5Res extends ResponseV4Res implements ResponseAdapter {
    public static class RESPONSE extends ResponseBase {
        public static class GNRDETAILCONTENTS extends SongInfoBase {
            public static class AGEARTISTLIST extends ArtistInfoBase {
                public static class ALBUMLIST extends AlbumInfoBase {
                    private static final long serialVersionUID = 0x8D2BA4A0C117F296L;

                }

                @b("ALBUMLIST")
                public ArrayList albumList;
                @b("ARTISTSUBNAME")
                public String artistSubName;
                @b("GNRARTISTSEQ")
                public String gnrArtistSeq;
                private static final long serialVersionUID = 0x824B9065F062F438L;

                public AGEARTISTLIST() {
                    this.albumList = null;
                }
            }

            @b("AGEARTISTLIST")
            public ArrayList ageArtistList;
            @b("AGEDESC")
            public String ageDesc;
            @b("AGENAME")
            public String ageName;
            @b("FILTERTYPECODE")
            public String filterTypeCode;
            @b("FILTERTYPEFLG")
            public String filterTypeFlg;
            private static final long serialVersionUID = 0xF2692C3A246080CFL;

            public GNRDETAILCONTENTS() {
                this.ageArtistList = null;
            }
        }

        @b("GNRDETAILCONTENTS")
        public ArrayList gnrDetailContents;
        private static final long serialVersionUID = 5945519240543095260L;

        public RESPONSE() {
            this.gnrDetailContents = null;
        }
    }

    @b("response")
    public RESPONSE response;
    private static final long serialVersionUID = 0x18CA096F5B9F3E73L;

    public GenreDetailGuiType5Res() {
        this.response = null;
    }

    @Override  // com.iloen.melon.net.ResponseAdapter
    public Collection getItems() {
        RESPONSE genreDetailGuiType5Res$RESPONSE0 = this.response;
        return genreDetailGuiType5Res$RESPONSE0 != null ? genreDetailGuiType5Res$RESPONSE0.gnrDetailContents : null;
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
        return false;
    }

    @Override
    public String toString() {
        return ToStringUtil.toStringFields(this);
    }
}


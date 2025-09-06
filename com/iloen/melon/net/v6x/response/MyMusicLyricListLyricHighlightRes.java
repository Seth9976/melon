package com.iloen.melon.net.v6x.response;

import S7.b;
import com.iloen.melon.net.ResponseAdapter;
import com.iloen.melon.net.v5x.common.StatsElementsBase;
import com.melon.net.res.common.ArtistInfoBase;
import com.melon.net.res.common.ResponseBase;
import java.io.Serializable;
import java.util.Collection;
import java.util.List;

public class MyMusicLyricListLyricHighlightRes extends ResponseV6Res implements ResponseAdapter {
    public static class RESPONSE extends ResponseBase {
        public static class LYRICHIGHLIGHTLIST implements Serializable {
            public static class ARTISTLIST extends ArtistInfoBase {
                private static final long serialVersionUID = -1190722610248193052L;

            }

            @b("ALBUMIMG")
            public String albumImg;
            @b("ARTISTLIST")
            public List artistList;
            @b("CHICLYRIC")
            public String chicLyric;
            @b("HIGHLIGHTDATE")
            public String highlightDate;
            @b("ISSERVICE")
            public Boolean isService;
            private static final long serialVersionUID = 8771034867074260266L;
            @b("SONGID")
            public String songId;
            @b("SONGNAME")
            public String songName;

        }

        @b("HASMORE")
        public boolean hasMore;
        @b("LYRICHIGHLIGHTLIST")
        public List lyricHighLightList;
        private static final long serialVersionUID = -117124880623001902L;
        @b("TOTALCOUNT")
        public String totalCount;

        public RESPONSE() {
            this.hasMore = false;
        }
    }

    @b("response")
    public RESPONSE response;
    private static final long serialVersionUID = 0xEC2AFF7082816E24L;

    public MyMusicLyricListLyricHighlightRes() {
        this.response = null;
    }

    @Override  // com.iloen.melon.net.ResponseAdapter
    public Collection getItems() {
        RESPONSE myMusicLyricListLyricHighlightRes$RESPONSE0 = this.response;
        return myMusicLyricListLyricHighlightRes$RESPONSE0 != null ? myMusicLyricListLyricHighlightRes$RESPONSE0.lyricHighLightList : null;
    }

    @Override  // com.iloen.melon.net.ResponseAdapter
    public StatsElementsBase getStatsElements() {
        return null;
    }

    @Override  // com.iloen.melon.net.ResponseAdapter
    public boolean hasMore() {
        return this.response != null && this.response.hasMore;
    }
}


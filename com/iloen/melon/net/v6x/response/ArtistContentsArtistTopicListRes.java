package com.iloen.melon.net.v6x.response;

import S7.b;
import com.iloen.melon.net.ResponseAdapter;
import com.iloen.melon.net.v5x.common.StatsElementsBase;
import com.iloen.melon.net.v6x.common.TopicInfoBase;
import com.melon.net.res.common.ResponseBase;
import java.io.Serializable;
import java.util.Collection;
import java.util.List;

public class ArtistContentsArtistTopicListRes extends ResponseV6Res implements ResponseAdapter {
    public static class RESPONSE extends ResponseBase {
        public static class ARTISTINFO implements Serializable {
            @b("ARTISTID")
            public String artistId;
            @b("ARTISTNAME")
            public String artistName;
            private static final long serialVersionUID = 0x39328348826FEFD3L;

            public ARTISTINFO() {
                this.artistId = "";
                this.artistName = "";
            }
        }

        public static class TOPICLIST extends TopicInfoBase {
            private static final long serialVersionUID = 1895392033523008892L;

        }

        @b("ARTISTINFO")
        public ARTISTINFO artistInfo;
        @b("HASMORE")
        public boolean hasMore;
        private static final long serialVersionUID = 0xA8E45EC133D416A3L;
        @b("TOPICCNT")
        public String topicCnt;
        @b("TOPICLIST")
        public List topicList;

        public RESPONSE() {
            this.hasMore = false;
            this.topicCnt = "";
        }
    }

    @b("response")
    public RESPONSE response;
    private static final long serialVersionUID = 0xD2EF2C43E3C0EE1AL;

    public ArtistContentsArtistTopicListRes() {
        this.response = null;
    }

    @Override  // com.iloen.melon.net.ResponseAdapter
    public Collection getItems() {
        RESPONSE artistContentsArtistTopicListRes$RESPONSE0 = this.response;
        return artistContentsArtistTopicListRes$RESPONSE0 != null ? artistContentsArtistTopicListRes$RESPONSE0.topicList : null;
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


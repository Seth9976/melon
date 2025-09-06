package com.iloen.melon.net.v6x.response;

import S7.b;
import com.iloen.melon.net.ResponseAdapter;
import com.iloen.melon.net.v5x.common.StatsElementsBase;
import com.melon.net.res.common.ResponseBase;
import java.util.Collection;
import java.util.List;

public class AlbumContentsPhotoRes extends ResponseV6Res implements ResponseAdapter {
    public static class RESPONSE extends ResponseBase {
        @b("HASMORE")
        public boolean hasMore;
        @b("PAGEMETANAME")
        public String pageMetaName;
        @b("PHOTOLIST")
        public List photos;
        private static final long serialVersionUID = 5385209391259501105L;

        public RESPONSE() {
            this.hasMore = false;
            this.pageMetaName = "";
        }
    }

    @b("response")
    public RESPONSE response;
    private static final long serialVersionUID = 0x14860C7E0E5629D2L;

    public AlbumContentsPhotoRes() {
        this.response = null;
    }

    @Override  // com.iloen.melon.net.ResponseAdapter
    public Collection getItems() {
        RESPONSE albumContentsPhotoRes$RESPONSE0 = this.response;
        return albumContentsPhotoRes$RESPONSE0 != null ? albumContentsPhotoRes$RESPONSE0.photos : null;
    }

    @Override  // com.iloen.melon.net.ResponseAdapter
    public StatsElementsBase getStatsElements() {
        return null;
    }

    @Override  // com.iloen.melon.net.ResponseAdapter
    public boolean hasMore() {
        return this.response == null ? false : this.response.hasMore;
    }
}


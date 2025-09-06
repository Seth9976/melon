package com.iloen.melon.net.v6x.response;

import S7.b;
import com.iloen.melon.net.ResponseAdapter;
import com.iloen.melon.net.v5x.common.StatsElementsBase;
import com.melon.net.res.common.ResponseBase;
import java.util.Collection;
import java.util.List;

public class ArtistContentsPhotoListRes extends ResponseV6Res implements ResponseAdapter {
    public static class RESPONSE extends ResponseBase {
        @b("ARTISTNAME")
        public String artistName;
        @b("HASMORE")
        public boolean hasMore;
        @b("PHOTOLIST")
        public List photos;
        private static final long serialVersionUID = 0x580A6D7FC47CF42EL;

        public RESPONSE() {
            this.artistName = "";
            this.hasMore = false;
        }
    }

    @b("response")
    public RESPONSE response;
    private static final long serialVersionUID = 0x6372DAAE2616F3FFL;

    public ArtistContentsPhotoListRes() {
        this.response = null;
    }

    @Override  // com.iloen.melon.net.ResponseAdapter
    public Collection getItems() {
        RESPONSE artistContentsPhotoListRes$RESPONSE0 = this.response;
        return artistContentsPhotoListRes$RESPONSE0 != null ? artistContentsPhotoListRes$RESPONSE0.photos : null;
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


package com.iloen.melon.net.v6x.response;

import S7.b;
import com.iloen.melon.net.v4x.common.ToStringUtil;
import com.melon.net.res.common.ResponseBase;
import java.io.Serializable;
import java.util.ArrayList;

public class ArtistMusicAlbumFilterListRes extends ResponseV6Res {
    public static class RESPONSE extends ResponseBase {
        public static class FILTERLIST implements Serializable {
            @b("FILTERCODE")
            public String filterCode;
            @b("FILTERNAME")
            public String filterName;
            private static final long serialVersionUID = 0x2E98364A7D257DF9L;

            public FILTERLIST() {
                this.filterName = "";
                this.filterCode = "";
            }
        }

        @b("FILTERLIST")
        public ArrayList filterList;
        private static final long serialVersionUID = -9113132201507899607L;

    }

    @b("response")
    public RESPONSE response;
    private static final long serialVersionUID = 0xA663A4E2CDC6441AL;

    @Override  // com.iloen.melon.net.HttpResponse
    public String getMenuId() {
        return this.response == null ? "" : this.response.menuId;
    }

    @Override
    public String toString() {
        return ToStringUtil.toStringFields(this);
    }
}


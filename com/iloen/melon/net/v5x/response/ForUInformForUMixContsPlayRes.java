package com.iloen.melon.net.v5x.response;

import S7.b;
import com.iloen.melon.net.v4x.common.ToStringUtil;
import com.iloen.melon.net.v5x.common.StatsElementsBase;
import com.melon.net.res.common.ResponseBase;
import com.melon.net.res.common.SongInfoBase;
import java.util.ArrayList;

public class ForUInformForUMixContsPlayRes extends ResponseV5Res {
    public static class RESPONSE extends ResponseBase {
        public static class SONGLIST extends SongInfoBase {
            private static final long serialVersionUID = 0xF86CB3DDA4D91FF0L;

        }

        public static class STATSELEMENTS extends StatsElementsBase {
            private static final long serialVersionUID = 0x8085E538CA23B447L;

        }

        private static final long serialVersionUID = 0xF86CB3DDA4D91FF0L;
        @b("SONGLIST")
        public ArrayList songList;
        @b("STATSELEMENTS")
        public STATSELEMENTS statsElements;

        public RESPONSE() {
            this.statsElements = null;
        }
    }

    @b("response")
    public RESPONSE response;
    private static final long serialVersionUID = 0xB1132E04D83D32C7L;

    @Override  // com.iloen.melon.net.HttpResponse
    public String getMenuId() {
        return this.response == null ? "" : this.response.menuId;
    }

    @Override
    public String toString() {
        return ToStringUtil.toStringFields(this);
    }
}


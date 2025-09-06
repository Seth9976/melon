package com.iloen.melon.net.v4x.response;

import S7.b;
import com.iloen.melon.net.ResponseAdapter;
import com.iloen.melon.net.v4x.common.ToStringUtil;
import com.iloen.melon.net.v5x.common.StatsElementsBase;
import com.melon.net.res.common.MvInfoBase;
import com.melon.net.res.common.ResponseBase;
import java.util.ArrayList;
import java.util.Collection;

public class MelonTvLikedProgramRes extends ResponseV4Res implements ResponseAdapter {
    public static class RESPONSE extends ResponseBase {
        public static class CONTENTSLIST extends MvInfoBase {
            public static class MVLIST extends MvInfoBase {
                private static final long serialVersionUID = 0x6868ACAC0AA59B71L;

            }

            @b("ESPDYN")
            public String espdYN;
            @b("HOTYN")
            public String hotYN;
            @b("MVLIST")
            public ArrayList mvList;
            @b("NEWYN")
            public String newYN;
            @b("PROGSEQ")
            public String progSeq;
            @b("PROGSIMPLDESC")
            public String progSimplDesc;
            @b("PROGTHUMBIMAGEURL")
            public String progThumbImageUrl;
            private static final long serialVersionUID = 0x6868ACBA3FB45691L;

        }

        @b("CONTENTSLIST")
        public ArrayList contentsList;
        private static final long serialVersionUID = 0x1BCCE9E3AC1FB1F7L;

    }

    @b("response")
    public RESPONSE response;
    private static final long serialVersionUID = 0x352F41990F9B90F5L;

    @Override  // com.iloen.melon.net.ResponseAdapter
    public Collection getItems() {
        if(this.response == null) {
            return null;
        }
        Collection collection0 = new ArrayList();
        ArrayList arrayList0 = this.response.contentsList;
        if(arrayList0 != null) {
            ((ArrayList)collection0).addAll(arrayList0);
        }
        return collection0;
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


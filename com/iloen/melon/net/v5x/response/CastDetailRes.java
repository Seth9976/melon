package com.iloen.melon.net.v5x.response;

import S7.b;
import com.iloen.melon.net.ResponseAdapter;
import com.iloen.melon.net.v4x.common.ToStringUtil;
import com.iloen.melon.net.v5x.common.StatsElementsBase;
import com.melon.net.res.common.ResponseBase;
import com.melon.net.res.common.SongInfoBase;
import java.util.ArrayList;
import java.util.Collection;
import org.jetbrains.annotations.NotNull;

public class CastDetailRes extends ResponseV5Res implements ResponseAdapter {
    public static class CAST extends CastInfoBase {
        @b("ISEPSD")
        public boolean isEpsd;
        private static final long serialVersionUID = 0x42C222F4A2D55E28L;

        public CAST() {
            this.isEpsd = false;
        }

        @Override  // com.iloen.melon.net.v5x.response.CastInfoBase
        @NotNull
        public String toString() {
            return ToStringUtil.toStringFields(this);
        }
    }

    public static class PROGRAM extends ProgramBase {
        private static final long serialVersionUID = 0x6935F674517A94DL;

    }

    public static class RESPONSE extends ResponseBase {
        @b("BBSCHANNELSEQ")
        public String bbsChannelSeq;
        @b("BBSCONTSID")
        public String bbsContsId;
        @b("CAST")
        public CAST cast;
        public boolean hasMore;
        @b("PROGRAM")
        public PROGRAM program;
        private static final long serialVersionUID = 0x147A095505942B0EL;
        @b("SONGLIST")
        public ArrayList songList;
        @b("STATSELEMENTS")
        public STATSELEMENTS statsElements;

        public RESPONSE() {
            this.hasMore = false;
            this.cast = null;
            this.songList = null;
        }
    }

    public static class SONGLIST extends SongInfoBase {
        private static final long serialVersionUID = 0xBDB05A0626E88826L;

    }

    public static class STATSELEMENTS extends StatsElementsBase {
        private static final long serialVersionUID = 0x7F630644695F87CDL;

    }

    public RESPONSE response;
    private static final long serialVersionUID = 0x39C48B0FB448722BL;

    @Override  // com.iloen.melon.net.ResponseAdapter
    public Collection getItems() {
        RESPONSE castDetailRes$RESPONSE0 = this.response;
        return castDetailRes$RESPONSE0 != null ? castDetailRes$RESPONSE0.songList : null;
    }

    @Override  // com.iloen.melon.net.ResponseAdapter, com.iloen.melon.net.HttpResponse
    public String getMenuId() [...] // 潜在的解密器

    @Override  // com.iloen.melon.net.ResponseAdapter
    public StatsElementsBase getStatsElements() {
        RESPONSE castDetailRes$RESPONSE0 = this.response;
        return castDetailRes$RESPONSE0 != null ? castDetailRes$RESPONSE0.statsElements : null;
    }

    @Override  // com.iloen.melon.net.ResponseAdapter
    public boolean hasMore() {
        return false;
    }

    @Override
    @NotNull
    public String toString() {
        return ToStringUtil.toStringFields(this);
    }
}


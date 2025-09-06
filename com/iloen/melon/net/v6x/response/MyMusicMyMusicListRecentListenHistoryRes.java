package com.iloen.melon.net.v6x.response;

import S7.b;
import com.iloen.melon.net.v4x.common.ArtistPlayListInfoBase;
import com.iloen.melon.net.v5x.common.StatsElementsBase;
import com.iloen.melon.net.v5x.response.CastInfoBase;
import com.melon.net.res.common.DjPlayListInfoBase;
import com.melon.net.res.common.MvInfoBase;
import com.melon.net.res.common.ResponseBase;
import java.io.Serializable;

public class MyMusicMyMusicListRecentListenHistoryRes extends ResponseV6Res {
    public static class RESPONSE extends ResponseBase {
        public static class RECENTDJPLYST extends RecentListenHistoryInfoBase {
            public static class RESULT extends DjPlayListInfoBase {
                private static final long serialVersionUID = 0x3353F066770FE0F8L;

            }

            @b("RESULT")
            public RESULT result;
            private static final long serialVersionUID = -2151331836100500926L;

        }

        public static class RECENTMV extends RecentListenHistoryInfoBase {
            public static class com.iloen.melon.net.v6x.response.MyMusicMyMusicListRecentListenHistoryRes.RESPONSE.RECENTMV.RESULT extends MvInfoBase {
                private static final long serialVersionUID = 0xABF04FCBBEE0DDC5L;

            }

            @b("RESULT")
            public com.iloen.melon.net.v6x.response.MyMusicMyMusicListRecentListenHistoryRes.RESPONSE.RECENTMV.RESULT result;
            private static final long serialVersionUID = 0xEE0BE8AE1D2867C1L;

        }

        public static class RECENTMYPLYST extends RecentListenHistoryInfoBase {
            public static class com.iloen.melon.net.v6x.response.MyMusicMyMusicListRecentListenHistoryRes.RESPONSE.RECENTMYPLYST.RESULT extends ArtistPlayListInfoBase {
                private static final long serialVersionUID = 0xD94F39B5DE44C0CBL;

            }

            @b("RESULT")
            public com.iloen.melon.net.v6x.response.MyMusicMyMusicListRecentListenHistoryRes.RESPONSE.RECENTMYPLYST.RESULT result;
            private static final long serialVersionUID = 0x18058FFDE1F77D0AL;

        }

        public static class RECENTSTATION extends RecentListenHistoryInfoBase {
            public static class com.iloen.melon.net.v6x.response.MyMusicMyMusicListRecentListenHistoryRes.RESPONSE.RECENTSTATION.RESULT extends CastInfoBase {
                @b("PROGTITLE")
                public String progTitle;
                private static final long serialVersionUID = -660888150050629178L;

                public com.iloen.melon.net.v6x.response.MyMusicMyMusicListRecentListenHistoryRes.RESPONSE.RECENTSTATION.RESULT() {
                    this.progTitle = "";
                }
            }

            @b("RESULT")
            public com.iloen.melon.net.v6x.response.MyMusicMyMusicListRecentListenHistoryRes.RESPONSE.RECENTSTATION.RESULT result;
            private static final long serialVersionUID = 0x5FA5FDB7A2446474L;

        }

        public static class RecentListenHistoryInfoBase implements Serializable {
            private static final long serialVersionUID = 0x579B2BC172A039B2L;
            @b("TYPE")
            public String type;

            public RecentListenHistoryInfoBase() {
                this.type = "";
            }
        }

        public static class STATSELEMENTS extends StatsElementsBase {
            private static final long serialVersionUID = 0xFAA0418A6F95FA75L;

        }

        @b("RECENTDJPLYST")
        public RECENTDJPLYST recentDjPlyst;
        @b("RECENTMV")
        public RECENTMV recentMv;
        @b("RECENTSTATION")
        public RECENTSTATION recentStaion;
        @b("RECENTMYPLYST")
        public RECENTMYPLYST recnetMyPlyst;
        private static final long serialVersionUID = 0xDDD513AE1058FCDEL;
        @b("STATSELEMENTS")
        public STATSELEMENTS statsElements;

    }

    @b("response")
    public RESPONSE response;
    private static final long serialVersionUID = 0x97E38A39D9D0302L;

    @Override  // com.iloen.melon.net.HttpResponse
    public String getMenuId() {
        return this.response == null ? "" : this.response.menuId;
    }
}


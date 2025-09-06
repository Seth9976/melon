package com.iloen.melon.net.v5x.response;

import S7.b;
import com.iloen.melon.net.v4x.common.ToStringUtil;
import com.iloen.melon.net.v4x.response.ResponseV4Res;
import com.melon.net.res.common.AlbumInfoBase;
import com.melon.net.res.common.ArtistInfoBase;
import com.melon.net.res.common.ResponseBase;
import java.io.Serializable;
import java.util.ArrayList;

public class GenreLabelDetailRes extends ResponseV4Res {
    public static class RESPONSE extends ResponseBase {
        public static class LABELINFO implements Serializable {
            public static class ALBUMINFO implements Serializable {
                public static class ALBUMLIST extends AlbumInfoBase {
                    private static final long serialVersionUID = 0x366B372A08E1AC05L;

                }

                @b("ALBUMLIST")
                public ArrayList albumList;
                private static final long serialVersionUID = 0xF90CC77F71F958BL;
                @b("TITLE")
                public String title;

                public ALBUMINFO() {
                    this.title = "";
                    this.albumList = null;
                }
            }

            public static class ARTISTLIST extends ArtistInfoBase {
                public static class com.iloen.melon.net.v5x.response.GenreLabelDetailRes.RESPONSE.LABELINFO.ARTISTLIST.ALBUMLIST extends AlbumInfoBase {
                    private static final long serialVersionUID = 0xF06816A2095AE77DL;

                }

                @b("ALBUMLIST")
                public ArrayList albumList;
                @b("ARTISTSUBNAME")
                public String artistSubName;
                @b("GNRARTISTSEQ")
                public String gnrArtistSeq;
                private static final long serialVersionUID = 0xF068178AA2377275L;

                public ARTISTLIST() {
                    this.artistSubName = "";
                    this.gnrArtistSeq = "";
                    this.albumList = null;
                }
            }

            public static class PLYLSTINFO implements Serializable {
                public static class PLYLSTLIST extends GenrePlayListInfoBase {
                    private static final long serialVersionUID = 0xFBB6F67D0847E0BL;

                }

                @b("PLYLSTLIST")
                public ArrayList plyLstList;
                private static final long serialVersionUID = 0xF068178AA2377315L;
                @b("TITLE")
                public String title;

                public PLYLSTINFO() {
                    this.title = "";
                    this.plyLstList = null;
                }
            }

            @b("ALBUMINFO")
            public ALBUMINFO albumInfo;
            @b("ARTISTLIST")
            public ArrayList artistList;
            @b("BGIMGURL")
            public String bgImgUrl;
            @b("BRANDPAGEURL")
            public String brandPageUrl;
            @b("LABELINTROD")
            public String labelIntrod;
            @b("LABELNAME")
            public String labelName;
            @b("LABLESEQ")
            public String labelSeq;
            @b("LOGOIMGURL")
            public String logoImgUrl;
            @b("PLYLSTINFO")
            public PLYLSTINFO plyLstInfo;
            private static final long serialVersionUID = 0xF90CD7814D3AEDBL;

            public LABELINFO() {
                this.labelSeq = "";
                this.labelName = "";
                this.logoImgUrl = "";
                this.bgImgUrl = "";
                this.brandPageUrl = "";
                this.labelIntrod = "";
                this.albumInfo = null;
                this.artistList = null;
                this.plyLstInfo = null;
            }
        }

        @b("LABELINFO")
        public LABELINFO labelInfo;
        private static final long serialVersionUID = 0xEE11D3384503156DL;

        public RESPONSE() {
            this.labelInfo = null;
        }
    }

    @b("response")
    public RESPONSE response;
    private static final long serialVersionUID = 0x95935A3EC2CA0815L;

    public GenreLabelDetailRes() {
        this.response = null;
    }

    @Override
    public String toString() {
        return ToStringUtil.toStringFields(this);
    }
}


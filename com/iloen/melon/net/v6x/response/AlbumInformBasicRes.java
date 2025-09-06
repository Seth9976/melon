package com.iloen.melon.net.v6x.response;

import S7.b;
import com.iloen.melon.net.v4x.common.BannerBase;
import com.iloen.melon.net.v4x.common.ToStringUtil;
import com.melon.net.res.common.AlbumInfoBase;
import com.melon.net.res.common.ArtistInfoBase;
import com.melon.net.res.common.ResponseBase;
import com.melon.net.res.common.SongInfoBase;
import java.io.Serializable;
import java.util.ArrayList;

public class AlbumInformBasicRes extends ResponseV6Res {
    public static class RESPONSE extends ResponseBase {
        public static class ARTISTINFO extends ArtistInfoBase {
            @b("CONTSTYPECODE")
            public String contsTypeCode;
            @b("IMAGETYPE")
            public String imageType;
            private static final long serialVersionUID = 0x473939F1BB74FD99L;

            public ARTISTINFO() {
                this.contsTypeCode = "";
                this.imageType = "";
            }
        }

        public static class ARTISTNOTELIST extends AlbumInfoBase {
            private static final long serialVersionUID = 0x615F97B0E888CBFAL;

        }

        public static class BANNER extends BannerBase {
            private static final long serialVersionUID = 626505590754920467L;

        }

        public static class BOOKLETIMGLIST implements Serializable {
            @b("BOOKLETIMGNO")
            public String bookletImgNo;
            @b("BOOKLETIMGURL")
            public String bookletImgUrl;
            private static final long serialVersionUID = 0x15CDC076EDEAB5AAL;

            public BOOKLETIMGLIST() {
                this.bookletImgNo = "";
                this.bookletImgUrl = "";
            }
        }

        public static class MARKET extends BannerBase {
            private static final long serialVersionUID = 5022805072690091267L;

        }

        public static class TITLESONG extends SongInfoBase {
            private static final long serialVersionUID = -4011498530537839610L;

        }

        @b("ALBUMFLACINFO")
        public String albumFlacInfo;
        @b("ALBUMID")
        public String albumId;
        @b("ALBUMIMG")
        public String albumImg;
        @b("ALBUMIMGLARGE")
        public String albumImgLarge;
        @b("ALBUMNAME")
        public String albumName;
        @b("ALBUMPRICEFLAC16")
        public String albumPriceFlac16;
        @b("ALBUMPRICEFLAC24")
        public String albumPriceFlac24;
        @b("ALBUMTYPE")
        public String albumType;
        @b("ALBUMMESSAGE")
        public String albummessage;
        @b("ALBUMPRICE")
        public String albumprice;
        @b("ARTISTLIST")
        public ArrayList artistList;
        @b("ARTISTNOTELIST")
        public ArrayList artistNoteList;
        @b("BANNER")
        public BANNER banner;
        @b("BBSCHANNELSEQ")
        public String bbschannelseq;
        @b("BOOKLETIMGLIST")
        public ArrayList bookletimglist;
        @b("CPLANCODE")
        public String cPlanCode;
        @b("DUMMYTEXT")
        public String dummyText;
        @b("ISMASTERPIECE")
        public boolean isMasterPiece;
        @b("ISSUEDATE")
        public String issueDate;
        @b("LIKECNT")
        public String likeCnt;
        @b("LIKEYN")
        public String likeYN;
        @b("MARKET")
        public MARKET market;
        @b("MARKETSCHEME")
        public String marketscheme;
        @b("POSTEDITIMG")
        public String postEditImg;
        @b("POSTIMG")
        public String postImg;
        @b("PTCPNMPRCO")
        public String ptCpnMprco;
        private static final long serialVersionUID = 0x61F88BD8FB7E0C08L;
        @b("TITLESONG")
        public TITLESONG titleSong;
        @b("TOTAVRGSCORE")
        public String totAvrgScore;

        public RESPONSE() {
            this.albumId = "";
            this.albumName = "";
            this.albumImg = "";
            this.albumImgLarge = "";
            this.artistList = null;
            this.issueDate = "";
            this.totAvrgScore = "";
            this.ptCpnMprco = "";
            this.likeYN = "";
            this.likeCnt = "";
            this.isMasterPiece = false;
            this.albumprice = "";
            this.albummessage = "";
            this.bbschannelseq = "";
            this.marketscheme = "";
            this.market = null;
            this.banner = null;
            this.postImg = "";
            this.postEditImg = "";
            this.bookletimglist = null;
            this.albumFlacInfo = "";
            this.albumPriceFlac16 = "";
            this.albumPriceFlac24 = "";
            this.albumType = "";
            this.cPlanCode = "";
            this.dummyText = "";
            this.artistNoteList = null;
        }
    }

    @b("response")
    public RESPONSE response;
    private static final long serialVersionUID = 0x21D01485CD178B05L;

    public AlbumInformBasicRes() {
        this.response = null;
    }

    @Override
    public String toString() {
        return ToStringUtil.toStringFields(this);
    }
}


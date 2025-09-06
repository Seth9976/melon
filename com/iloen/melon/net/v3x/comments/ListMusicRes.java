package com.iloen.melon.net.v3x.comments;

import S7.b;
import com.iloen.melon.custom.l1;
import com.iloen.melon.net.v4x.common.ToStringUtil;
import java.io.Serializable;
import java.util.ArrayList;

public class ListMusicRes extends CmtBaseRes {
    public static class result implements Serializable {
        public static class MUSICLIST implements Serializable {
            public static class ARTISTLIST implements Serializable {
                @b("artistId")
                public int artistid;
                @b("artistName")
                public String artistname;
                private static final long serialVersionUID = 4005193950222148437L;

                public ARTISTLIST() {
                    this.artistid = -1;
                    this.artistname = "";
                }

                @Override
                public String toString() {
                    return ToStringUtil.toStringFields(this);
                }
            }

            @b("actTypeName")
            public String acttypename;
            @b("adultFlag")
            public boolean adultflag;
            @b("albumDiscountFlag")
            public String albumdiscountflag;
            @b("albumId")
            public int albumid;
            @b("albumImageDsplyPath")
            public String albumimagedsplypath;
            @b("albumImagePath")
            public String albumimagepath;
            @b("albumName")
            public String albumname;
            @b("albumOnlyFlag")
            public String albumonlyflag;
            @b("artistId")
            public int artistid;
            @b("artistImageDsplyPath")
            public String artistimagedsplypath;
            @b("artistImagePath")
            public String artistimagepath;
            @b("artistList")
            public ArrayList artistlist;
            @b("artistName")
            public String artistname;
            @b("dlAvailFlag")
            public boolean dlavailflag;
            @b("dsplyIssueDate")
            public String dsplyissuedate;
            @b("dsplyPlayTime")
            public String dsplyplaytime;
            @b("dsplyVideoIssueDate")
            public String dsplyvideoissuedate;
            @b("fanCnt")
            public int fancnt;
            @b("freezoneFlag")
            public boolean freezoneflag;
            @b("gnr")
            public String gnr;
            @b("holdBackFlag")
            public boolean holdbackflag;
            @b("hotSongFlag")
            public boolean hotsongflag;
            @b("issueDate")
            public String issuedate;
            @b("liveFlag")
            public boolean liveflag;
            @b("mvFlag")
            public boolean mvflag;
            @b("nationalityName")
            public String nationalityname;
            private static final long serialVersionUID = 0xC774FC13634B4DA6L;
            @b("sex")
            public String sex;
            @b("songId")
            public int songid;
            @b("songName")
            public String songname;
            @b("stAvailFlag")
            public boolean stavailflag;
            @b("svcAvailFlag")
            public String svcavailflag;
            @b("videoEpsdName")
            public String videoEpsdName;
            @b("videoAdultFlag")
            public boolean videoadultflag;
            @b("videoAgeLevel")
            public int videoagelevel;
            @b("videoId")
            public int videoid;
            @b("videoImageDsplyPath")
            public String videoimagedsplypath;
            @b("videoImagePath")
            public String videoimagepath;
            @b("videoIssueDate")
            public String videoissuedate;
            @b("videoTitle")
            public String videotitle;
            @b("videoViewCnt")
            public int videoviewcnt;

            public MUSICLIST() {
                this.songid = -1;
                this.songname = "";
                this.albumid = -1;
                this.albumname = "";
                this.albumimagepath = "";
                this.albumimagedsplypath = "";
                this.albumonlyflag = "";
                this.albumdiscountflag = "";
                this.issuedate = "";
                this.dsplyissuedate = "";
                this.artistid = -1;
                this.artistname = "";
                this.artistimagepath = "";
                this.artistimagedsplypath = "";
                this.svcavailflag = "";
                this.stavailflag = false;
                this.dlavailflag = false;
                this.adultflag = false;
                this.holdbackflag = false;
                this.freezoneflag = false;
                this.hotsongflag = false;
                this.nationalityname = "";
                this.acttypename = "";
                this.sex = "";
                this.gnr = "";
                this.fancnt = -1;
                this.videoid = -1;
                this.videotitle = "";
                this.videoadultflag = false;
                this.videoimagepath = "";
                this.videoimagedsplypath = "";
                this.videoissuedate = "";
                this.dsplyvideoissuedate = "";
                this.videoagelevel = -1;
                this.videoviewcnt = -1;
                this.mvflag = false;
                this.liveflag = false;
                this.dsplyplaytime = "";
                this.videoEpsdName = "";
                this.artistlist = null;
            }

            @Override
            public String toString() {
                return ToStringUtil.toStringFields(this);
            }
        }

        public static class PAGEINFO extends PageInfoBase {
            @b("albumCnt")
            public int albumcnt;
            @b("artistCnt")
            public int artistcnt;
            @b("musicType")
            public String musictype;
            private static final long serialVersionUID = 0xDD9180511609CC2DL;
            @b("songCnt")
            public int songcnt;
            @b("videoCnt")
            public int videocnt;

            public PAGEINFO() {
                this.musictype = "";
                this.songcnt = -1;
                this.albumcnt = -1;
                this.artistcnt = -1;
                this.videocnt = -1;
            }

            @Override  // com.iloen.melon.net.v3x.comments.CmtSharedTypeRes$PageInfoBase
            public String toString() {
                return ToStringUtil.toStringFields(this);
            }
        }

        public static class PAGINGINFO extends PagingInfoBase {
            private static final long serialVersionUID = 0xDA00A938812756BBL;

        }

        @b("musicList")
        public ArrayList musiclist;
        @b("pageInfo")
        public PAGEINFO pageinfo;
        @b("pagingInfo")
        public PAGINGINFO paginginfo;
        private static final long serialVersionUID = 1046933030020023161L;

        public result() {
            this.musiclist = null;
            this.paginginfo = null;
            this.pageinfo = null;
        }

        @Override
        public String toString() {
            return ToStringUtil.toStringFields(this);
        }
    }

    @b("result")
    public result result;
    private static final long serialVersionUID = 0xAA6A6E7082F953E8L;

    public ListMusicRes() {
        this.result = null;
    }

    public static String getArtistNames(ArrayList arrayList0) {
        if(arrayList0 != null && !arrayList0.isEmpty()) {
            StringBuilder stringBuilder0 = new StringBuilder();
            for(Object object0: arrayList0) {
                stringBuilder0.append(((ARTISTLIST)object0).artistname);
                stringBuilder0.append(", ");
            }
            return l1.q(stringBuilder0, 2, 0);
        }
        return null;
    }

    public static String getMvTitle(MUSICLIST listMusicRes$result$MUSICLIST0) {
        if(listMusicRes$result$MUSICLIST0 == null) {
            return null;
        }
        StringBuilder stringBuilder0 = new StringBuilder();
        if(listMusicRes$result$MUSICLIST0.mvflag) {
            stringBuilder0.append("[MV] ");
        }
        else if(listMusicRes$result$MUSICLIST0.liveflag) {
            stringBuilder0.append("[Live] ");
        }
        stringBuilder0.append(listMusicRes$result$MUSICLIST0.videotitle);
        return stringBuilder0.toString();
    }

    @Override  // com.iloen.melon.net.v3x.comments.CmtBaseRes
    public String toString() {
        return ToStringUtil.toStringFields(this);
    }
}


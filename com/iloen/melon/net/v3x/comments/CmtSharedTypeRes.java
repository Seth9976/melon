package com.iloen.melon.net.v3x.comments;

import S7.b;
import com.iloen.melon.custom.l1;
import com.iloen.melon.net.v4x.common.ToStringUtil;
import java.io.Serializable;
import java.util.ArrayList;

public class CmtSharedTypeRes {
    public static class AdCmtListBase implements Serializable {
        public static class ADCMTINFO extends CmtInfoBase {
            private static final long serialVersionUID = 0x9102612E829CA11EL;

        }

        public static class MEMBERINFO extends MemberInfoBase {
            private static final long serialVersionUID = 0x9B9A1CCC2F50CFADL;

        }

        @b("adcmtInfo")
        public ADCMTINFO adcmtinfo;
        @b("memberInfo")
        public MEMBERINFO memberinfo;
        @b("recommenderInfo")
        public MEMBERINFO recommenderInfo;
        private static final long serialVersionUID = 0xB2B1B9CA3AF302E4L;

        public AdCmtListBase() {
            this.adcmtinfo = null;
            this.memberinfo = null;
            this.recommenderInfo = null;
        }

        @Override
        public String toString() {
            return ToStringUtil.toStringFields(this);
        }
    }

    public static class AdCmtSumaryBase implements Serializable {
        public static class com.iloen.melon.net.v3x.comments.CmtSharedTypeRes.AdCmtSumaryBase.ADCMTINFO extends CmtInfoBase {
            private static final long serialVersionUID = 0x51BB24FE48A40089L;

        }

        public static class com.iloen.melon.net.v3x.comments.CmtSharedTypeRes.AdCmtSumaryBase.MEMBERINFO extends MemberInfoBase {
            private static final long serialVersionUID = 568618023404225191L;

        }

        @b("adcmtInfo")
        public com.iloen.melon.net.v3x.comments.CmtSharedTypeRes.AdCmtSumaryBase.ADCMTINFO adcmtinfo;
        @b("memberInfo")
        public com.iloen.melon.net.v3x.comments.CmtSharedTypeRes.AdCmtSumaryBase.MEMBERINFO memberinfo;
        private static final long serialVersionUID = 0x492A6E65D13F3BE6L;

        public AdCmtSumaryBase() {
            this.adcmtinfo = null;
            this.memberinfo = null;
        }

        @Override
        public String toString() {
            return ToStringUtil.toStringFields(this);
        }
    }

    public static class ArtistListBase implements Serializable {
        @b("artistId")
        public int artistid;
        @b("artistName")
        public String artistname;
        private static final long serialVersionUID = 0xD22B07D224E1FCC1L;

        public ArtistListBase() {
            this.artistid = -1;
            this.artistname = "";
        }

        @Override
        public String toString() {
            return ToStringUtil.toStringFields(this);
        }
    }

    public static class AtachListBase implements Serializable {
        public static class ATACHPROPTY extends AtachProptyBase {
            private static final long serialVersionUID = 0x190F169D615E0344L;

        }

        @b("atachDsplyOrder")
        public int atachdsplyorder;
        @b("atachPropty")
        public ATACHPROPTY atachpropty;
        @b("atachSeq")
        public int atachseq;
        @b("atachType")
        public String atachtype;
        @b("atachValue")
        public String atachvalue;
        private static final long serialVersionUID = 0x108CCEAB6F735458L;

        public AtachListBase() {
            this.atachseq = -1;
            this.atachdsplyorder = -1;
            this.atachtype = "";
            this.atachvalue = "";
            this.atachpropty = null;
        }

        @Override
        public String toString() {
            return ToStringUtil.toStringFields(this);
        }
    }

    public static class AtachProptyBase implements Serializable {
        public static class ARTISTLIST extends ArtistListBase {
            private static final long serialVersionUID = 0xFF9F75BA8D090FAL;

        }

        public static class VIDEOAPPEARANCELIST extends VideoAppearanceListBase {
            private static final long serialVersionUID = 0xFA112997CCD6CC01L;

        }

        @b("actTypeName")
        public String acttypename;
        @b("adultFlag")
        public boolean adultflag;
        @b("albumDiscountFlag")
        public boolean albumdiscountflag;
        @b("albumId")
        public int albumid;
        @b("albumImagePath")
        public String albumimagepath;
        @b("albumName")
        public String albumname;
        @b("albumOnlyFlag")
        public boolean albumonlyflag;
        @b("artistId")
        public int artistid;
        @b("artistImagePath")
        public String artistimagepath;
        @b("artistList")
        public ArrayList artistlist;
        @b("artistName")
        public String artistname;
        @b("artistType")
        public String artisttype;
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
        @b("innerVideoType")
        public String innervideotype;
        @b("issueDate")
        public String issuedate;
        @b("kakaoEmoticon")
        public String kakaoemoticon;
        @b("linkUrl")
        public String linkurl;
        @b("liveFlag")
        public boolean liveflag;
        @b("mvFlag")
        public boolean mvflag;
        @b("nationalityName")
        public String nationalityname;
        @b("originalUrl")
        public String originalurl;
        private static final long serialVersionUID = 0xCAB1A18900191120L;
        public boolean serviceFlag;
        @b("sex")
        public String sex;
        @b("songId")
        public int songid;
        @b("songName")
        public String songname;
        @b("stAvailFlag")
        public boolean stavailflag;
        @b("textCont")
        public String textcont;
        @b("thumbUrl")
        public String thumburl;
        @b("totalSongCnt")
        public int totalsongcnt;
        @b("videoAdultFlag")
        public boolean videoadultflag;
        @b("videoAgeLevel")
        public int videoagelevel;
        @b("videoAppearanceList")
        public ArrayList videoappearancelist;
        @b("videoFreezoneFlag")
        public boolean videofreezoneflag;
        @b("videoHeight")
        public int videoheight;
        @b("videoId")
        public int videoid;
        @b("videoImagePath")
        public String videoimagepath;
        @b("videoIssueDate")
        public String videoissuedate;
        @b("videoTitle")
        public String videotitle;
        @b("videoUrl")
        public String videourl;
        @b("videoViewCnt")
        public int videoviewcnt;
        @b("videoWidth")
        public int videowidth;

        public AtachProptyBase() {
            this.textcont = "";
            this.thumburl = "";
            this.originalurl = "";
            this.videourl = "";
            this.linkurl = "";
            this.artistid = -1;
            this.artistname = "";
            this.artistimagepath = "";
            this.artisttype = "";
            this.nationalityname = "";
            this.acttypename = "";
            this.sex = "";
            this.gnr = "";
            this.fancnt = -1;
            this.albumid = -1;
            this.albumname = "";
            this.albumimagepath = "";
            this.issuedate = "";
            this.dsplyissuedate = "";
            this.songid = -1;
            this.songname = "";
            this.totalsongcnt = -1;
            this.serviceFlag = true;
            this.adultflag = false;
            this.holdbackflag = false;
            this.freezoneflag = false;
            this.stavailflag = false;
            this.dlavailflag = false;
            this.albumonlyflag = false;
            this.albumdiscountflag = false;
            this.videoid = -1;
            this.videowidth = -1;
            this.videoheight = -1;
            this.videotitle = "";
            this.videofreezoneflag = false;
            this.videoadultflag = false;
            this.videoagelevel = -1;
            this.videoimagepath = "";
            this.videoissuedate = "";
            this.dsplyvideoissuedate = "";
            this.videoviewcnt = -1;
            this.innervideotype = "";
            this.mvflag = false;
            this.liveflag = false;
            this.dsplyplaytime = "";
            this.videoappearancelist = null;
            this.artistlist = null;
            this.kakaoemoticon = null;
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

        public static String getMvTitle(AtachProptyBase cmtSharedTypeRes$AtachProptyBase0) {
            if(cmtSharedTypeRes$AtachProptyBase0 == null) {
                return null;
            }
            StringBuilder stringBuilder0 = new StringBuilder();
            if(cmtSharedTypeRes$AtachProptyBase0.mvflag) {
                stringBuilder0.append("[MV] ");
            }
            else if(cmtSharedTypeRes$AtachProptyBase0.liveflag) {
                stringBuilder0.append("[Live] ");
            }
            stringBuilder0.append(cmtSharedTypeRes$AtachProptyBase0.videotitle);
            return stringBuilder0.toString();
        }

        public boolean isUnavailableService() {
            return !this.serviceFlag;
        }

        @Override
        public String toString() {
            return ToStringUtil.toStringFields(this);
        }
    }

    public static class AtachSumryBase implements Serializable {
        @b("atachDsplyOrder")
        public int atachdsplyorder;
        @b("atachSeq")
        public int atachseq;
        @b("atachThumbUrl")
        public String atachthumburl;
        @b("atachType")
        public String atachtype;
        @b("atachValue")
        public String atachvalue;
        @b("atachVideoTitle")
        public String atachvideotitle;
        private static final long serialVersionUID = 0x319EB2805F98B852L;

        public AtachSumryBase() {
            this.atachseq = -1;
            this.atachtype = "";
            this.atachdsplyorder = -1;
            this.atachvalue = "";
            this.atachthumburl = "";
            this.atachvideotitle = "";
        }

        @Override
        public String toString() {
            return ToStringUtil.toStringFields(this);
        }
    }

    public static class BreakIPListBase implements Serializable {
        @b("breakIp")
        public String breakip;
        private static final long serialVersionUID = 0xA2197C507F79CF99L;

        public BreakIPListBase() {
            this.breakip = "";
        }

        @Override
        public String toString() {
            return ToStringUtil.toStringFields(this);
        }
    }

    public static class BreakWordlistBase implements Serializable {
        @b("breakWord")
        public String breakword;
        private static final long serialVersionUID = 5513933209800881104L;

        public BreakWordlistBase() {
            this.breakword = "";
        }

        @Override
        public String toString() {
            return ToStringUtil.toStringFields(this);
        }
    }

    public static class CmtInfoBase implements Serializable {
        public static class ADCMTSUMARY extends AdCmtSumaryBase {
            private static final long serialVersionUID = 0x5A498174BEAF2A8DL;

        }

        public static class ATACHSUMRY extends AtachSumryBase {
            private static final long serialVersionUID = 0xE93A412E566C4E2EL;

        }

        @b("adcmtSumary")
        public ArrayList adcmtsumary;
        @b("ancmFlag")
        public boolean ancmflag;
        @b("atachCnt")
        public int atachcnt;
        @b("atachSumry")
        public ArrayList atachsumry;
        @b("bestFlag")
        public boolean bestflag;
        @b("breakFlag")
        public boolean breakflag;
        @b(alternate = {"CMTCONT"}, value = "cmtCont")
        public String cmtcont;
        @b(alternate = {"CMTNO"}, value = "cmtNo")
        public int cmtno;
        @b(alternate = {"CMTSEQ"}, value = "cmtSeq")
        public int cmtseq;
        @b("cmtSumry")
        public String cmtsumry;
        @b("delBtnFlag")
        public boolean delbtnflag;
        @b("delFlag")
        public boolean delflag;
        @b("dsplyDate2")
        public String dsplyDate2;
        @b("dsplyDate")
        public String dsplydate;
        @b("dsplyRegDate")
        public String dsplyregdate;
        @b("dsplyTime")
        public String dsplytime;
        @b("dsplyUpdtDate")
        public String dsplyupdtdate;
        @b("imageAtachFlag")
        public boolean imageatachflag;
        @b("linkAtachFlag")
        public boolean linkatachflag;
        @b("melonDjLevel")
        public int melondjlevel;
        @b("memberCmtFlag")
        public boolean membercmtflag;
        @b("memberNonRecmFlag")
        public boolean membernonrecmflag;
        @b("memberRecmFlag")
        public boolean memberrecmflag;
        @b("memberReprtFlag")
        public boolean memberreprtflag;
        @b("mobleFlag")
        public boolean mobleflag;
        @b("musicAtachFlag")
        public boolean musicatachflag;
        @b("newFlag")
        public boolean newflag;
        @b("nonRecmCnt")
        public int nonrecmcnt;
        @b("parntCmtSeq")
        public int parntcmtseq;
        public boolean pinnedFlag;
        public boolean playFlag;
        @b("recmCnt")
        public int recmcnt;
        @b("recmFlag")
        public boolean recmflag;
        @b("reprtCnt")
        public int reprtcnt;
        @b("secrtFlag")
        public boolean secrtflag;
        private static final long serialVersionUID = -7958875020231756190L;
        @b("stickerSeq")
        public String stickerseq;
        public boolean tempActFlag;
        @b("textAtachFlag")
        public boolean textatachflag;
        @b("totalAdcmtCnt")
        public int totaladcmtcnt;
        @b("updtBtnFlag")
        public boolean updtbtnflag;
        @b("validAdcmtCnt")
        public int validadcmtcnt;
        @b("vdoAtachFlag")
        public boolean vdoatachflag;
        @b("viewCnt")
        public int viewcnt;

        public CmtInfoBase() {
            this.cmtno = -1;
            this.cmtseq = -1;
            this.cmtcont = "";
            this.cmtsumry = "";
            this.parntcmtseq = -1;
            this.ancmflag = false;
            this.bestflag = false;
            this.mobleflag = false;
            this.secrtflag = false;
            this.breakflag = false;
            this.tempActFlag = false;
            this.delflag = false;
            this.newflag = false;
            this.textatachflag = false;
            this.musicatachflag = false;
            this.vdoatachflag = false;
            this.imageatachflag = false;
            this.linkatachflag = false;
            this.atachcnt = -1;
            this.recmcnt = -1;
            this.nonrecmcnt = -1;
            this.reprtcnt = -1;
            this.viewcnt = -1;
            this.totaladcmtcnt = -1;
            this.validadcmtcnt = -1;
            this.updtbtnflag = false;
            this.delbtnflag = false;
            this.dsplydate = "";
            this.dsplyDate2 = "";
            this.dsplytime = "";
            this.dsplyregdate = "";
            this.dsplyupdtdate = "";
            this.stickerseq = "";
            this.recmflag = false;
            this.memberrecmflag = false;
            this.membernonrecmflag = false;
            this.memberreprtflag = false;
            this.membercmtflag = false;
            this.melondjlevel = -1;
            this.atachsumry = null;
            this.adcmtsumary = null;
            this.pinnedFlag = false;
            this.playFlag = false;
        }

        @Override
        public String toString() {
            return ToStringUtil.toStringFields(this);
        }
    }

    public static class CmtListBase implements Serializable {
        public static class ATACHLIST extends AtachListBase {
            private static final long serialVersionUID = 0x318A3762BD96536AL;

        }

        public static class CMTINFO extends CmtInfoBase {
            private static final long serialVersionUID = 0xEE44B0A50F439EB0L;

        }

        public static class com.iloen.melon.net.v3x.comments.CmtSharedTypeRes.CmtListBase.MEMBERINFO extends MemberInfoBase {
            private static final long serialVersionUID = 0x5219D12EA7ED250CL;

        }

        @b("atachList")
        public ArrayList atachlist;
        @b("cmtInfo")
        public CMTINFO cmtinfo;
        @b("memberInfo")
        public com.iloen.melon.net.v3x.comments.CmtSharedTypeRes.CmtListBase.MEMBERINFO memberinfo;
        @b("recommenderInfo")
        public com.iloen.melon.net.v3x.comments.CmtSharedTypeRes.CmtListBase.MEMBERINFO recommenderInfo;
        private static final long serialVersionUID = -4457674489878511070L;

        public CmtListBase() {
            this.cmtinfo = null;
            this.memberinfo = null;
            this.recommenderInfo = null;
            this.atachlist = null;
        }

        @Override
        public String toString() {
            return ToStringUtil.toStringFields(this);
        }
    }

    public static class GenrlLinkAtachBreakURLListBase implements Serializable {
        @b("genrlLinkAtachBreakUrl")
        public String genrllinkatachbreakurl;
        private static final long serialVersionUID = 0xA86C0D528A7DD09DL;

        public GenrlLinkAtachBreakURLListBase() {
            this.genrllinkatachbreakurl = "";
        }

        @Override
        public String toString() {
            return ToStringUtil.toStringFields(this);
        }
    }

    public static class MemberInfoBase implements Serializable {
        public boolean artistFanFlag;
        public int artistTemperature;
        @b("artistFlag")
        public boolean artistflag;
        @b("artistId")
        public int artistid;
        @b("artistImage")
        public String artistimage;
        @b("artistName")
        public String artistname;
        @b("ISESSENTIAL")
        public boolean isessential;
        @b("melonDjFlag")
        public boolean melondjflag;
        @b("melonDjLevel")
        public int melondjlevel;
        @b("melonLabelDjFlag")
        public boolean melonlabeldjflag;
        @b("melonPowerDjFlag")
        public boolean melonpowerdjflag;
        @b(alternate = {"MEMBERDJICONTYPE"}, value = "memberDjIconType")
        public String memberDjIconType;
        @b("memberDjType")
        public String memberDjType;
        @b("memberKey")
        public String memberkey;
        @b("memberNickname")
        public String membernickname;
        @b("memberStatus")
        public int memberstatus;
        @b("mypageImg")
        public String mypageimg;
        public boolean official;
        public boolean pinUseFlag;
        private static final long serialVersionUID = 0x7A5614913C814A20L;
        @b("svcStatus")
        public int svcstatus;

        public MemberInfoBase() {
            this.memberkey = "";
            this.membernickname = "";
            this.melondjflag = false;
            this.melonpowerdjflag = false;
            this.melonlabeldjflag = false;
            this.isessential = false;
            this.artistflag = false;
            this.artistid = -1;
            this.artistname = "";
            this.artistimage = "";
            this.memberstatus = -1;
            this.svcstatus = -1;
            this.melondjlevel = -1;
            this.memberDjType = "";
            this.mypageimg = "";
            this.memberDjIconType = "";
            this.artistTemperature = -1;
            this.artistFanFlag = false;
            this.pinUseFlag = false;
            this.official = false;
        }

        @Override
        public String toString() {
            return ToStringUtil.toStringFields(this);
        }
    }

    public static class PageInfoBase implements Serializable {
        @b("chnlSeq")
        public int chnlseq;
        @b("contsRefValue")
        public String contsrefvalue;
        @b("pageNo")
        public int pageno;
        @b("pageSize")
        public int pagesize;
        private static final long serialVersionUID = 0x400CC55BD5F74FB6L;
        @b("sortType")
        public int sorttype;
        @b("srchType")
        public int srchtype;
        @b("srchWord")
        public String srchword;
        @b("startSeq")
        public int startseq;
        @b("totalCnt")
        public int totalcnt;
        @b("validCnt")
        public int validcnt;

        public PageInfoBase() {
            this.chnlseq = -1;
            this.contsrefvalue = "";
            this.sorttype = -1;
            this.srchtype = -1;
            this.srchword = "";
            this.totalcnt = -1;
            this.validcnt = -1;
            this.startseq = -1;
            this.pagesize = -1;
            this.pageno = -1;
        }

        @Override
        public String toString() {
            return ToStringUtil.toStringFields(this);
        }
    }

    public static class PageListBase implements Serializable {
        @b("page")
        public int page;
        private static final long serialVersionUID = 0x7C5EAEE941455106L;

        public PageListBase() {
            this.page = -1;
        }

        @Override
        public String toString() {
            return ToStringUtil.toStringFields(this);
        }
    }

    public static class PagingInfoBase implements Serializable {
        public static class PAGELIST extends PageListBase {
            private static final long serialVersionUID = 0xE99F373606B57FD9L;

        }

        @b("firstPageNo")
        public int firstpageno;
        @b("lastPageNo")
        public int lastpageno;
        @b("more")
        public boolean more;
        @b("nextGroupPageNo")
        public int nextgrouppageno;
        @b("nextPageNo")
        public int nextpageno;
        @b("pageList")
        public ArrayList pagelist;
        @b("prevGroupPageNo")
        public int prevgrouppageno;
        @b("prevPageNo")
        public int prevpageno;
        private static final long serialVersionUID = -7332940808600260556L;

        public PagingInfoBase() {
            this.firstpageno = -1;
            this.lastpageno = -1;
            this.prevpageno = -1;
            this.nextpageno = -1;
            this.prevgrouppageno = -1;
            this.nextgrouppageno = -1;
            this.more = false;
            this.pagelist = null;
        }

        @Override
        public String toString() {
            return ToStringUtil.toStringFields(this);
        }
    }

    public static class VdoLinkAtachPermURLListBase implements Serializable {
        private static final long serialVersionUID = 79208718727014114L;
        @b("vdoLinkAtachPermUrl")
        public String vdolinkatachpermurl;

        public VdoLinkAtachPermURLListBase() {
            this.vdolinkatachpermurl = "";
        }

        @Override
        public String toString() {
            return ToStringUtil.toStringFields(this);
        }
    }

    public static class VideoAppearanceListBase implements Serializable {
        private static final long serialVersionUID = 0x1CC841CFEF1CE0EAL;
        @b("videoAppearance")
        public String videoappearance;

        public VideoAppearanceListBase() {
            this.videoappearance = "";
        }

        @Override
        public String toString() {
            return ToStringUtil.toStringFields(this);
        }
    }

}


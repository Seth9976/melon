package com.iloen.melon.net.v3x.comments;

import S7.b;
import com.iloen.melon.net.v4x.common.ToStringUtil;
import java.io.Serializable;
import java.util.ArrayList;

public class LoadPgnRes extends CmtBaseRes {
    public static class result implements Serializable {
        public static class CHNLINFO implements Serializable {
            public static class LinkInfo implements Serializable {
                public String contsRefName;
                public String link;
                private static final long serialVersionUID = 0xE44484030A1715AAL;
                public String text1;

                public LinkInfo() {
                    this.link = "";
                    this.contsRefName = "";
                    this.text1 = "";
                }
            }

            @b("adcmtPlaceholderText")
            public String adcmtplaceholdertext;
            @b("adcmtRegMaxLength")
            public int adcmtregmaxlength;
            @b("adcmtRegMinLength")
            public int adcmtregminlength;
            @b("adcmtUseFlag")
            public boolean adcmtuseflag;
            @b("atachMaxCnt")
            public int atachmaxcnt;
            @b("atachUseFlag")
            public boolean atachuseflag;
            @b("blindContsCmtListFlag")
            public boolean blindContsCmtListFlag;
            @b("blindContsCmtWriteFlag")
            public boolean blindContsCmtWriteFlag;
            @b("blindContsDsplyText")
            public String blindContsDsplyText;
            @b("breakCmtDsplyText")
            public String breakcmtdsplytext;
            public boolean checkArtistFanFlag;
            @b("chnlName")
            public String chnlname;
            @b("chnlSeq")
            public int chnlseq;
            public String cmtImageCdnDomain;
            public String cmtImageUploadDomain;
            @b("cmtDsplyCnt")
            public int cmtdsplycnt;
            @b("cmtGuidetext")
            public String cmtguidetext;
            @b("cmtPlaceholderText")
            public String cmtplaceholdertext;
            @b("cmtPocTypeCode")
            public String cmtpoctypecode;
            @b("cmtRegMaxLength")
            public int cmtregmaxlength;
            @b("cmtRegMinLength")
            public int cmtregminlength;
            public LinkInfo contsRefLinkInfo;
            @b("cyworldSyncpstUseFlag")
            public boolean cyworldsyncpstuseflag;
            @b("dateDsplyForm")
            public String datedsplyform;
            @b("deleteCmtDsplyText")
            public String deletecmtdsplytext;
            @b("facebookSyncpstUseFlag")
            public boolean facebooksyncpstuseflag;
            @b("genrlLinkAtachUseFlag")
            public boolean genrllinkatachuseflag;
            @b("imageAtachUseFlag")
            public boolean imageatachuseflag;
            @b("kakaoEmoticonAtachUseFlag")
            public boolean kakaoemoticonatachuseflag;
            @b("kakaostorySyncpstUseFlag")
            public boolean kakaostorysyncpstuseflag;
            @b("kakaotalkSyncpstUseFlag")
            public boolean kakaotalksyncpstuseflag;
            @b("linkAtachUseFlag")
            public boolean linkatachuseflag;
            @b("mobileCmtPlaceholderText")
            public String mobilecmtplaceholdertext;
            @b("musicAtachUseFlag")
            public boolean musicatachuseflag;
            @b("nateonSyncpstUseFlag")
            public boolean nateonsyncpstuseflag;
            @b("newDispPrid")
            public int newdispprid;
            @b("pageDsplyCmtCnt")
            public int pagedsplycmtcnt;
            @b("pastePermFlag")
            public boolean pastepermflag;
            @b("pgnTitle")
            public String pgntitle;
            public boolean playFilterUseFlag;
            @b("pocTypeCode")
            public String poctypecode;
            @b("readOnlyFlag")
            public boolean readonlyflag;
            @b("recmUseFlag")
            public boolean recmuseflag;
            public String reprtWindowUrl;
            @b("reprtUseFlag")
            public boolean reprtuseflag;
            @b("secrtCmtDsplyText")
            public String secrtcmtdsplytext;
            @b("secrtCmtUseFlag")
            public boolean secrtcmtuseflag;
            private static final long serialVersionUID = 2069256033254599254L;
            @b("snsSimultPostUseFlag")
            public boolean snssimultpostuseflag;
            @b("snsSyncpstUseFlag")
            public boolean snssyncpstuseflag;
            @b("sumryViewUseFlag")
            public boolean sumryviewuseflag;
            public String tempActCmtDsplyText;
            public String tempActLinkUrlText;
            @b("textAtachUseFlag")
            public boolean textatachuseflag;
            @b("twitterSyncpstUseFlag")
            public boolean twittersyncpstuseflag;
            @b("vdoAtachUseFlag")
            public boolean vdoatachuseflag;
            @b("vdoLinkAtachUseFlag")
            public boolean vdolinkatachuseflag;

            public CHNLINFO() {
                this.chnlseq = -1;
                this.poctypecode = "";
                this.cmtpoctypecode = "";
                this.chnlname = "";
                this.pgntitle = "";
                this.cmtdsplycnt = -1;
                this.cmtregminlength = -1;
                this.cmtregmaxlength = -1;
                this.adcmtregminlength = -1;
                this.adcmtregmaxlength = -1;
                this.adcmtuseflag = false;
                this.recmuseflag = false;
                this.reprtuseflag = false;
                this.atachuseflag = false;
                this.textatachuseflag = false;
                this.musicatachuseflag = false;
                this.imageatachuseflag = false;
                this.vdoatachuseflag = false;
                this.linkatachuseflag = false;
                this.vdolinkatachuseflag = false;
                this.genrllinkatachuseflag = false;
                this.kakaoemoticonatachuseflag = false;
                this.atachmaxcnt = -1;
                this.pastepermflag = false;
                this.sumryviewuseflag = false;
                this.cmtguidetext = "";
                this.cmtplaceholdertext = "";
                this.adcmtplaceholdertext = "";
                this.mobilecmtplaceholdertext = "";
                this.snssimultpostuseflag = false;
                this.snssyncpstuseflag = false;
                this.facebooksyncpstuseflag = false;
                this.twittersyncpstuseflag = false;
                this.nateonsyncpstuseflag = false;
                this.cyworldsyncpstuseflag = false;
                this.kakaotalksyncpstuseflag = false;
                this.kakaostorysyncpstuseflag = false;
                this.pagedsplycmtcnt = -1;
                this.datedsplyform = "";
                this.breakcmtdsplytext = "";
                this.deletecmtdsplytext = "";
                this.secrtcmtdsplytext = "";
                this.newdispprid = -1;
                this.secrtcmtuseflag = false;
                this.readonlyflag = false;
                this.blindContsCmtListFlag = false;
                this.blindContsCmtWriteFlag = false;
                this.blindContsDsplyText = "";
                this.tempActCmtDsplyText = "";
                this.tempActLinkUrlText = "";
                this.reprtWindowUrl = "";
                this.playFilterUseFlag = false;
                this.checkArtistFanFlag = false;
                this.cmtImageUploadDomain = "";
                this.cmtImageCdnDomain = "";
                this.contsRefLinkInfo = null;
            }

            @Override
            public String toString() {
                return ToStringUtil.toStringFields(this);
            }
        }

        public static class CMTLIST extends CmtListBase {
            private static final long serialVersionUID = 0x27C8F38832F1998CL;

        }

        public static class MYMEMBERINFO extends MemberInfoBase {
            private static final long serialVersionUID = 0x24991B272AAD297EL;

        }

        public static class PAGEINFO extends PageInfoBase {
            private static final long serialVersionUID = 0x886F9C703A0C213AL;

        }

        public static class PAGINGINFO extends PagingInfoBase {
            private static final long serialVersionUID = 0xFB0E1C344D9EE8B4L;

        }

        public static class SNSINFO implements Serializable {
            @b("facebookConnectExpiredFlag")
            public boolean facebookconnectexpiredflag;
            @b("facebookConnectFlag")
            public boolean facebookconnectflag;
            @b("facebookConnectInfoStatus")
            public String facebookconnectinfostatus;
            private static final long serialVersionUID = 0x5C335DD2CEF75B5L;
            @b("twitterConnectExpiredFlag")
            public boolean twitterconnectexpiredflag;
            @b("twitterConnectFlag")
            public boolean twitterconnectflag;
            @b("twitterConnectInfoStatus")
            public String twitterconnectinfostatus;

            public SNSINFO() {
                this.facebookconnectflag = false;
                this.facebookconnectexpiredflag = false;
                this.facebookconnectinfostatus = "";
                this.twitterconnectflag = false;
                this.twitterconnectexpiredflag = false;
                this.twitterconnectinfostatus = "";
            }

            @Override
            public String toString() {
                return ToStringUtil.toStringFields(this);
            }
        }

        public static class SPAMINFO implements Serializable {
            public static class BREAKIPLIST extends BreakIPListBase {
                private static final long serialVersionUID = 0x776FA7B40CD2FAB9L;

            }

            public static class BREAKWORDLIST extends BreakWordlistBase {
                private static final long serialVersionUID = 0x131652DFBB267DE3L;

            }

            public static class GENRLLINKATACHBREAKURLLIST extends GenrlLinkAtachBreakURLListBase {
                private static final long serialVersionUID = 0xD81473647243DED5L;

            }

            public static class VDOLINKATACHPERMURLLIST extends VdoLinkAtachPermURLListBase {
                private static final long serialVersionUID = 0x78010BA5A3FFD495L;

            }

            @b("breakMemberGuideAppSchme")
            public String breakMemberGuideAppSchme;
            @b("breakMemberGuideText")
            public String breakMemberGuideText;
            @b("breakMemberGuideUrl")
            public String breakMemberGuideUrl;
            @b("breakIpFlag")
            public boolean breakipflag;
            @b("breakIpList")
            public ArrayList breakiplist;
            @b("breakMemberFlag")
            public boolean breakmemberflag;
            @b("breakWordList")
            public ArrayList breakwordlist;
            @b("checkIpAddr")
            public String checkipaddr;
            @b("checkMemberKey")
            public String checkmemberkey;
            @b("cmtRegPosblMin")
            public int cmtregposblmin;
            @b("genrlLinkAtachBreakURLList")
            public ArrayList genrllinkatachbreakurllist;
            private static final long serialVersionUID = 0xA55B04D9EDFBA3DCL;
            @b("vdoLinkAtachPermURLList")
            public ArrayList vdolinkatachpermurllist;

            public SPAMINFO() {
                this.checkipaddr = "";
                this.checkmemberkey = "";
                this.breakmemberflag = false;
                this.breakipflag = false;
                this.cmtregposblmin = -1;
                this.breakwordlist = null;
                this.breakiplist = null;
                this.vdolinkatachpermurllist = null;
                this.genrllinkatachbreakurllist = null;
                this.breakMemberGuideUrl = "";
                this.breakMemberGuideAppSchme = "";
                this.breakMemberGuideText = "";
            }

            @Override
            public String toString() {
                return ToStringUtil.toStringFields(this);
            }
        }

        public static class TOPLIST implements Serializable {
            private static final long serialVersionUID = 7052495091608424933L;

            @Override
            public String toString() {
                return ToStringUtil.toStringFields(this);
            }
        }

        @b("chnlInfo")
        public CHNLINFO chnlinfo;
        @b("cmtList")
        public ArrayList cmtlist;
        public MYMEMBERINFO myMemberInfo;
        @b("pageInfo")
        public PAGEINFO pageinfo;
        @b("pagingInfo")
        public PAGINGINFO paginginfo;
        private static final long serialVersionUID = 0xA77B0900814A5B98L;
        @b("snsInfo")
        public SNSINFO snsinfo;
        @b("spamInfo")
        public SPAMINFO spaminfo;
        @b("topList")
        public ArrayList toplist;

        public result() {
            this.chnlinfo = null;
            this.spaminfo = null;
            this.pageinfo = null;
            this.paginginfo = null;
            this.cmtlist = null;
            this.toplist = null;
            this.snsinfo = null;
            this.myMemberInfo = null;
        }

        @Override
        public String toString() {
            return ToStringUtil.toStringFields(this);
        }
    }

    @b("result")
    public result result;
    private static final long serialVersionUID = 0xD999CF0E92F31B83L;

    public LoadPgnRes() {
        this.result = null;
    }

    @Override  // com.iloen.melon.net.v3x.comments.CmtBaseRes
    public String toString() {
        return ToStringUtil.toStringFields(this);
    }
}


package com.iloen.melon.net.v4x.common;

import S7.b;
import com.melon.net.res.common.ArtistsInfoBase;
import java.io.Serializable;
import java.util.ArrayList;

public class FeedLogInfoBase implements Serializable {
    public static class ARTISTLIST extends ArtistsInfoBase {
        @b("ISADULT")
        public String isAdult;
        private static final long serialVersionUID = 0x65C94B5A4F770DF4L;

    }

    @b("ACTCNT")
    public String actCount;
    @b("ACTDPTYPE")
    public String actDpType;
    @b("ACTTITLE")
    public String actTitle;
    @b("ACTTYPE")
    public String actType;
    @b("ACTTYPECODE")
    public String actTypeCode;
    @b("ADULTGRADE")
    public String adultGrade;
    @b("ALBUMID")
    public String albumId;
    @b("ARTISTLIST")
    public ArrayList artistlist;
    @b("CHNLSEQ")
    public String chnlSeq;
    @b("CMTSEQ")
    public String cmtSeq;
    @b("CMTTEXT")
    public String cmtText;
    @b("CONTSID")
    public String contsId;
    @b("CONTSIMG")
    public String contsImg;
    @b("CONTSTITLE")
    public String contsTitle;
    @b("CONTSTYPECODE")
    public String contsTypeCode;
    @b("DATADAY")
    public String dataDay;
    @b("DATAWEEK")
    public String dataWeek;
    @b("DATESTR")
    public String dateStr;
    @b("FEEDDATE")
    public String feedDate;
    @b("FEEDLOGSEQ")
    public String feedLogSeq;
    @b("FEEDTYPE")
    public String feedType;
    @b("GIFTNO")
    public String giftNo;
    @b("INBOXSEQ")
    public String inboxSeq;
    @b("ISADULT")
    public boolean isAdult;
    @b("LINKTYPE")
    public String linkType;
    @b("LINKURL")
    public String linkUrl;
    @b("LOGMONTH")
    public String logMonth;
    @b("LOGTYPE")
    public String logType;
    @b("PARNTCMTSEQ")
    public String parentCmtSeq;
    @b("PROFILEID")
    public String profileId;
    @b("PROFILEIMG")
    public String profileImg;
    @b("PROFILEIMGGORG")
    public String profileImgOrg;
    @b("PROFILELANDTYPE")
    public String profileLandType;
    @b("PROFILENAME")
    public String profileName;
    @b("ROWKEY")
    public String rowKey;
    private static final long serialVersionUID = 0x76698C0D7FC319C0L;

    public FeedLogInfoBase() {
        this.actTitle = "";
    }

    @Override
    public String toString() {
        return ToStringUtil.toStringFields(this);
    }
}


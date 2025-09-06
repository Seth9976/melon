package com.iloen.melon.net.v3x.comments;

import S7.b;
import com.iloen.melon.net.v4x.common.ToStringUtil;
import java.io.Serializable;
import java.util.ArrayList;

public class CmtResViewModel implements Serializable {
    public static class result implements Serializable {
        public static class cmtList extends CmtListBase {
            public int chnlseq;
            public String contsrefvalue;
            public boolean isContentExpand;
            public boolean isReadOnly;
            public boolean reprtUseFlag;
            private static final long serialVersionUID = 0x3803285E62098E6FL;

            public cmtList() {
                this.chnlseq = -1;
                this.contsrefvalue = "";
                this.isReadOnly = false;
                this.reprtUseFlag = false;
                this.isContentExpand = false;
            }
        }

        public int chnlseq;
        public ArrayList cmtlist;
        public String contsrefvalue;
        public LoadPgnRes loadPgnRes;
        public boolean reprtUseFlag;
        private static final long serialVersionUID = 0x49EDE9361D35D40EL;
        public int totalCount;

        public result() {
            this.chnlseq = -1;
            this.contsrefvalue = "";
            this.totalCount = -1;
            this.reprtUseFlag = false;
            this.cmtlist = new ArrayList();
        }

        @Override
        public String toString() {
            return ToStringUtil.toStringFields(this);
        }
    }

    @b("result")
    public result result;
    private static final long serialVersionUID = 0x1171BCDC60FD17D8L;

    public CmtResViewModel() {
        this.result = new result();
    }

    private ArrayList converAtatachList(ArrayList arrayList0) {
        if(arrayList0 == null) {
            return null;
        }
        ArrayList arrayList1 = new ArrayList();
        for(Object object0: arrayList0) {
            ATACHLIST cmtSharedTypeRes$CmtListBase$ATACHLIST0 = new ATACHLIST();
            cmtSharedTypeRes$CmtListBase$ATACHLIST0.atachseq = ((AtachListBase)object0).atachseq;
            cmtSharedTypeRes$CmtListBase$ATACHLIST0.atachdsplyorder = ((AtachListBase)object0).atachdsplyorder;
            cmtSharedTypeRes$CmtListBase$ATACHLIST0.atachtype = ((AtachListBase)object0).atachtype;
            cmtSharedTypeRes$CmtListBase$ATACHLIST0.atachvalue = ((AtachListBase)object0).atachvalue;
            cmtSharedTypeRes$CmtListBase$ATACHLIST0.atachpropty = ((AtachListBase)object0).atachpropty;
            arrayList1.add(cmtSharedTypeRes$CmtListBase$ATACHLIST0);
        }
        return arrayList1;
    }

    private CMTINFO convertCmtInfo(CmtInfoBase cmtSharedTypeRes$CmtInfoBase0) {
        if(cmtSharedTypeRes$CmtInfoBase0 == null) {
            return null;
        }
        CMTINFO cmtSharedTypeRes$CmtListBase$CMTINFO0 = new CMTINFO();
        cmtSharedTypeRes$CmtListBase$CMTINFO0.cmtno = cmtSharedTypeRes$CmtInfoBase0.cmtno;
        cmtSharedTypeRes$CmtListBase$CMTINFO0.cmtseq = cmtSharedTypeRes$CmtInfoBase0.cmtseq;
        cmtSharedTypeRes$CmtListBase$CMTINFO0.cmtcont = cmtSharedTypeRes$CmtInfoBase0.cmtcont;
        cmtSharedTypeRes$CmtListBase$CMTINFO0.cmtsumry = cmtSharedTypeRes$CmtInfoBase0.cmtsumry;
        cmtSharedTypeRes$CmtListBase$CMTINFO0.parntcmtseq = cmtSharedTypeRes$CmtInfoBase0.parntcmtseq;
        cmtSharedTypeRes$CmtListBase$CMTINFO0.ancmflag = cmtSharedTypeRes$CmtInfoBase0.ancmflag;
        cmtSharedTypeRes$CmtListBase$CMTINFO0.bestflag = cmtSharedTypeRes$CmtInfoBase0.bestflag;
        cmtSharedTypeRes$CmtListBase$CMTINFO0.mobleflag = cmtSharedTypeRes$CmtInfoBase0.mobleflag;
        cmtSharedTypeRes$CmtListBase$CMTINFO0.secrtflag = cmtSharedTypeRes$CmtInfoBase0.secrtflag;
        cmtSharedTypeRes$CmtListBase$CMTINFO0.tempActFlag = cmtSharedTypeRes$CmtInfoBase0.tempActFlag;
        cmtSharedTypeRes$CmtListBase$CMTINFO0.breakflag = cmtSharedTypeRes$CmtInfoBase0.breakflag;
        cmtSharedTypeRes$CmtListBase$CMTINFO0.delflag = cmtSharedTypeRes$CmtInfoBase0.delflag;
        cmtSharedTypeRes$CmtListBase$CMTINFO0.newflag = cmtSharedTypeRes$CmtInfoBase0.newflag;
        cmtSharedTypeRes$CmtListBase$CMTINFO0.textatachflag = cmtSharedTypeRes$CmtInfoBase0.textatachflag;
        cmtSharedTypeRes$CmtListBase$CMTINFO0.musicatachflag = cmtSharedTypeRes$CmtInfoBase0.musicatachflag;
        cmtSharedTypeRes$CmtListBase$CMTINFO0.vdoatachflag = cmtSharedTypeRes$CmtInfoBase0.vdoatachflag;
        cmtSharedTypeRes$CmtListBase$CMTINFO0.imageatachflag = cmtSharedTypeRes$CmtInfoBase0.imageatachflag;
        cmtSharedTypeRes$CmtListBase$CMTINFO0.linkatachflag = cmtSharedTypeRes$CmtInfoBase0.linkatachflag;
        cmtSharedTypeRes$CmtListBase$CMTINFO0.atachcnt = cmtSharedTypeRes$CmtInfoBase0.atachcnt;
        cmtSharedTypeRes$CmtListBase$CMTINFO0.recmcnt = cmtSharedTypeRes$CmtInfoBase0.recmcnt;
        cmtSharedTypeRes$CmtListBase$CMTINFO0.nonrecmcnt = cmtSharedTypeRes$CmtInfoBase0.nonrecmcnt;
        cmtSharedTypeRes$CmtListBase$CMTINFO0.reprtcnt = cmtSharedTypeRes$CmtInfoBase0.reprtcnt;
        cmtSharedTypeRes$CmtListBase$CMTINFO0.viewcnt = cmtSharedTypeRes$CmtInfoBase0.viewcnt;
        cmtSharedTypeRes$CmtListBase$CMTINFO0.totaladcmtcnt = cmtSharedTypeRes$CmtInfoBase0.totaladcmtcnt;
        cmtSharedTypeRes$CmtListBase$CMTINFO0.validadcmtcnt = cmtSharedTypeRes$CmtInfoBase0.validadcmtcnt;
        cmtSharedTypeRes$CmtListBase$CMTINFO0.updtbtnflag = cmtSharedTypeRes$CmtInfoBase0.updtbtnflag;
        cmtSharedTypeRes$CmtListBase$CMTINFO0.delbtnflag = cmtSharedTypeRes$CmtInfoBase0.delbtnflag;
        cmtSharedTypeRes$CmtListBase$CMTINFO0.dsplydate = cmtSharedTypeRes$CmtInfoBase0.dsplydate;
        cmtSharedTypeRes$CmtListBase$CMTINFO0.dsplyDate2 = cmtSharedTypeRes$CmtInfoBase0.dsplyDate2;
        cmtSharedTypeRes$CmtListBase$CMTINFO0.dsplytime = cmtSharedTypeRes$CmtInfoBase0.dsplytime;
        cmtSharedTypeRes$CmtListBase$CMTINFO0.dsplyregdate = cmtSharedTypeRes$CmtInfoBase0.dsplyregdate;
        cmtSharedTypeRes$CmtListBase$CMTINFO0.dsplyupdtdate = cmtSharedTypeRes$CmtInfoBase0.dsplyupdtdate;
        cmtSharedTypeRes$CmtListBase$CMTINFO0.stickerseq = cmtSharedTypeRes$CmtInfoBase0.stickerseq;
        cmtSharedTypeRes$CmtListBase$CMTINFO0.recmflag = cmtSharedTypeRes$CmtInfoBase0.recmflag;
        cmtSharedTypeRes$CmtListBase$CMTINFO0.memberrecmflag = cmtSharedTypeRes$CmtInfoBase0.memberrecmflag;
        cmtSharedTypeRes$CmtListBase$CMTINFO0.membernonrecmflag = cmtSharedTypeRes$CmtInfoBase0.membernonrecmflag;
        cmtSharedTypeRes$CmtListBase$CMTINFO0.memberreprtflag = cmtSharedTypeRes$CmtInfoBase0.memberreprtflag;
        cmtSharedTypeRes$CmtListBase$CMTINFO0.membercmtflag = cmtSharedTypeRes$CmtInfoBase0.membercmtflag;
        cmtSharedTypeRes$CmtListBase$CMTINFO0.melondjlevel = cmtSharedTypeRes$CmtInfoBase0.melondjlevel;
        cmtSharedTypeRes$CmtListBase$CMTINFO0.atachsumry = cmtSharedTypeRes$CmtInfoBase0.atachsumry;
        cmtSharedTypeRes$CmtListBase$CMTINFO0.adcmtsumary = cmtSharedTypeRes$CmtInfoBase0.adcmtsumary;
        cmtSharedTypeRes$CmtListBase$CMTINFO0.pinnedFlag = cmtSharedTypeRes$CmtInfoBase0.pinnedFlag;
        cmtSharedTypeRes$CmtListBase$CMTINFO0.playFlag = cmtSharedTypeRes$CmtInfoBase0.playFlag;
        return cmtSharedTypeRes$CmtListBase$CMTINFO0;
    }

    private MEMBERINFO convertMemberInfo(MemberInfoBase cmtSharedTypeRes$MemberInfoBase0) {
        if(cmtSharedTypeRes$MemberInfoBase0 == null) {
            return null;
        }
        MEMBERINFO cmtSharedTypeRes$CmtListBase$MEMBERINFO0 = new MEMBERINFO();
        cmtSharedTypeRes$CmtListBase$MEMBERINFO0.memberkey = cmtSharedTypeRes$MemberInfoBase0.memberkey;
        cmtSharedTypeRes$CmtListBase$MEMBERINFO0.membernickname = cmtSharedTypeRes$MemberInfoBase0.membernickname;
        cmtSharedTypeRes$CmtListBase$MEMBERINFO0.melondjflag = cmtSharedTypeRes$MemberInfoBase0.melondjflag;
        cmtSharedTypeRes$CmtListBase$MEMBERINFO0.melonpowerdjflag = cmtSharedTypeRes$MemberInfoBase0.melonpowerdjflag;
        cmtSharedTypeRes$CmtListBase$MEMBERINFO0.melonlabeldjflag = cmtSharedTypeRes$MemberInfoBase0.melonlabeldjflag;
        cmtSharedTypeRes$CmtListBase$MEMBERINFO0.isessential = cmtSharedTypeRes$MemberInfoBase0.isessential;
        cmtSharedTypeRes$CmtListBase$MEMBERINFO0.memberDjType = cmtSharedTypeRes$MemberInfoBase0.memberDjType;
        cmtSharedTypeRes$CmtListBase$MEMBERINFO0.artistflag = cmtSharedTypeRes$MemberInfoBase0.artistflag;
        cmtSharedTypeRes$CmtListBase$MEMBERINFO0.artistid = cmtSharedTypeRes$MemberInfoBase0.artistid;
        cmtSharedTypeRes$CmtListBase$MEMBERINFO0.artistname = cmtSharedTypeRes$MemberInfoBase0.artistname;
        cmtSharedTypeRes$CmtListBase$MEMBERINFO0.artistimage = cmtSharedTypeRes$MemberInfoBase0.artistimage;
        cmtSharedTypeRes$CmtListBase$MEMBERINFO0.memberstatus = cmtSharedTypeRes$MemberInfoBase0.memberstatus;
        cmtSharedTypeRes$CmtListBase$MEMBERINFO0.svcstatus = cmtSharedTypeRes$MemberInfoBase0.svcstatus;
        cmtSharedTypeRes$CmtListBase$MEMBERINFO0.melondjlevel = cmtSharedTypeRes$MemberInfoBase0.melondjlevel;
        cmtSharedTypeRes$CmtListBase$MEMBERINFO0.mypageimg = cmtSharedTypeRes$MemberInfoBase0.mypageimg;
        cmtSharedTypeRes$CmtListBase$MEMBERINFO0.artistTemperature = cmtSharedTypeRes$MemberInfoBase0.artistTemperature;
        cmtSharedTypeRes$CmtListBase$MEMBERINFO0.artistFanFlag = cmtSharedTypeRes$MemberInfoBase0.artistFanFlag;
        cmtSharedTypeRes$CmtListBase$MEMBERINFO0.pinUseFlag = cmtSharedTypeRes$MemberInfoBase0.pinUseFlag;
        cmtSharedTypeRes$CmtListBase$MEMBERINFO0.official = cmtSharedTypeRes$MemberInfoBase0.official;
        cmtSharedTypeRes$CmtListBase$MEMBERINFO0.memberDjIconType = cmtSharedTypeRes$MemberInfoBase0.memberDjIconType;
        return cmtSharedTypeRes$CmtListBase$MEMBERINFO0;
    }

    public void databindAdCmtListBase(ArrayList arrayList0, int v, String s, boolean z, boolean z1) {
        if(arrayList0 != null) {
            for(Object object0: arrayList0) {
                cmtList cmtResViewModel$result$cmtList0 = new cmtList();
                cmtResViewModel$result$cmtList0.memberinfo = this.convertMemberInfo(((AdCmtListBase)object0).memberinfo);
                cmtResViewModel$result$cmtList0.recommenderInfo = this.convertMemberInfo(((AdCmtListBase)object0).recommenderInfo);
                cmtResViewModel$result$cmtList0.cmtinfo = this.convertCmtInfo(((AdCmtListBase)object0).adcmtinfo);
                cmtResViewModel$result$cmtList0.atachlist = null;
                cmtResViewModel$result$cmtList0.chnlseq = v;
                cmtResViewModel$result$cmtList0.contsrefvalue = s;
                cmtResViewModel$result$cmtList0.isReadOnly = z;
                cmtResViewModel$result$cmtList0.reprtUseFlag = z1;
                this.result.cmtlist.add(cmtResViewModel$result$cmtList0);
            }
        }
    }

    public void databindCmtListBase(LoadPgnRes loadPgnRes0, ArrayList arrayList0, int v, String s, boolean z, boolean z1) {
        if(arrayList0 != null) {
            this.result.chnlseq = v;
            this.result.contsrefvalue = s;
            this.result.loadPgnRes = loadPgnRes0;
            this.result.totalCount = loadPgnRes0.result.pageinfo.totalcnt;
            this.result.reprtUseFlag = loadPgnRes0.result.chnlinfo.reprtuseflag;
            for(Object object0: arrayList0) {
                cmtList cmtResViewModel$result$cmtList0 = new cmtList();
                cmtResViewModel$result$cmtList0.memberinfo = ((CmtListBase)object0).memberinfo;
                cmtResViewModel$result$cmtList0.recommenderInfo = ((CmtListBase)object0).recommenderInfo;
                cmtResViewModel$result$cmtList0.cmtinfo = ((CmtListBase)object0).cmtinfo;
                cmtResViewModel$result$cmtList0.atachlist = ((CmtListBase)object0).atachlist;
                cmtResViewModel$result$cmtList0.chnlseq = v;
                cmtResViewModel$result$cmtList0.contsrefvalue = s;
                cmtResViewModel$result$cmtList0.isReadOnly = z;
                cmtResViewModel$result$cmtList0.reprtUseFlag = z1;
                this.result.cmtlist.add(cmtResViewModel$result$cmtList0);
            }
        }
    }

    public void databindCmtListBase(ArrayList arrayList0, int v, String s, boolean z, boolean z1) {
        if(arrayList0 != null) {
            for(Object object0: arrayList0) {
                cmtList cmtResViewModel$result$cmtList0 = new cmtList();
                cmtResViewModel$result$cmtList0.memberinfo = ((CmtListBase)object0).memberinfo;
                cmtResViewModel$result$cmtList0.recommenderInfo = ((CmtListBase)object0).recommenderInfo;
                cmtResViewModel$result$cmtList0.cmtinfo = ((CmtListBase)object0).cmtinfo;
                cmtResViewModel$result$cmtList0.atachlist = ((CmtListBase)object0).atachlist;
                cmtResViewModel$result$cmtList0.chnlseq = v;
                cmtResViewModel$result$cmtList0.contsrefvalue = s;
                cmtResViewModel$result$cmtList0.isReadOnly = z;
                cmtResViewModel$result$cmtList0.reprtUseFlag = z1;
                this.result.cmtlist.add(cmtResViewModel$result$cmtList0);
            }
        }
    }

    public void databindInformCmtRes(com.iloen.melon.net.v3x.comments.InformCmtRes.result informCmtRes$result0, int v, String s, boolean z, boolean z1) {
        if(informCmtRes$result0 == null) {
            return;
        }
        cmtList cmtResViewModel$result$cmtList0 = new cmtList();
        cmtResViewModel$result$cmtList0.memberinfo = this.convertMemberInfo(informCmtRes$result0.memberinfo);
        cmtResViewModel$result$cmtList0.recommenderInfo = this.convertMemberInfo(informCmtRes$result0.recommenderInfo);
        cmtResViewModel$result$cmtList0.cmtinfo = this.convertCmtInfo(informCmtRes$result0.cmtinfo);
        cmtResViewModel$result$cmtList0.atachlist = this.converAtatachList(informCmtRes$result0.atachlist);
        cmtResViewModel$result$cmtList0.chnlseq = v;
        cmtResViewModel$result$cmtList0.contsrefvalue = s;
        cmtResViewModel$result$cmtList0.isReadOnly = z;
        cmtResViewModel$result$cmtList0.reprtUseFlag = z1;
        this.result.cmtlist.add(cmtResViewModel$result$cmtList0);
    }

    @Override
    public String toString() {
        return ToStringUtil.toStringFields(this);
    }
}


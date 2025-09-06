package com.iloen.melon.fragments.comments;

import Ac.O1;
import Ac.T3;
import Cb.i;
import com.iloen.melon.net.v3x.comments.CmtResViewModel.result.cmtList;
import com.iloen.melon.net.v3x.comments.CmtSharedTypeRes.CmtListBase.CMTINFO;
import com.iloen.melon.net.v3x.comments.CmtSharedTypeRes.CmtListBase.MEMBERINFO;
import com.iloen.melon.net.v3x.comments.LoadPgnRes.result.CHNLINFO;
import com.iloen.melon.net.v3x.comments.LoadPgnRes.result.MYMEMBERINFO;
import com.iloen.melon.net.v3x.comments.LoadPgnRes.result.PAGEINFO;
import com.iloen.melon.net.v3x.comments.LoadPgnRes.result.SPAMINFO;
import com.iloen.melon.net.v3x.comments.LoadPgnRes.result;
import com.iloen.melon.net.v3x.comments.LoadPgnRes;
import com.melon.net.res.v3.CommentConfig;
import java.util.ArrayList;
import kotlin.Metadata;
import kotlin.jvm.internal.q;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\u001A\u0015\u0010\u0003\u001A\u00020\u00022\u0006\u0010\u0001\u001A\u00020\u0000¢\u0006\u0004\b\u0003\u0010\u0004\u001A\u0011\u0010\u0006\u001A\u00020\u0002*\u00020\u0005¢\u0006\u0004\b\u0006\u0010\u0007\u001A\u0011\u0010\n\u001A\u00020\t*\u00020\b¢\u0006\u0004\b\n\u0010\u000B¨\u0006\f"}, d2 = {"Lcom/iloen/melon/net/v3x/comments/LoadPgnRes;", "loadPgnRes", "Lcom/melon/net/res/v3/CommentConfig;", "convertLoadPgnToUiModel", "(Lcom/iloen/melon/net/v3x/comments/LoadPgnRes;)Lcom/melon/net/res/v3/CommentConfig;", "Lcom/iloen/melon/net/v3x/comments/LoadPgnRes$result;", "toUiModel", "(Lcom/iloen/melon/net/v3x/comments/LoadPgnRes$result;)Lcom/melon/net/res/v3/CommentConfig;", "LAc/T3;", "Lcom/iloen/melon/net/v3x/comments/CmtResViewModel$result$cmtList;", "toCmtList", "(LAc/T3;)Lcom/iloen/melon/net/v3x/comments/CmtResViewModel$result$cmtList;", "app_playstoreProdRelease"}, k = 2, mv = {2, 2, 0}, xi = 0x30)
public final class CommentActionImplKt {
    @NotNull
    public static final CommentConfig convertLoadPgnToUiModel(@NotNull LoadPgnRes loadPgnRes0) {
        q.g(loadPgnRes0, "loadPgnRes");
        result loadPgnRes$result0 = loadPgnRes0.result;
        q.f(loadPgnRes$result0, "result");
        return CommentActionImplKt.toUiModel(loadPgnRes$result0);
    }

    @NotNull
    public static final cmtList toCmtList(@NotNull T3 t30) {
        q.g(t30, "<this>");
        CMTINFO cmtSharedTypeRes$CmtListBase$CMTINFO0 = new CMTINFO();
        cmtSharedTypeRes$CmtListBase$CMTINFO0.recmcnt = t30.d;
        boolean z = false;
        cmtSharedTypeRes$CmtListBase$CMTINFO0.memberrecmflag = t30.a == O1.a && t30.b;
        cmtSharedTypeRes$CmtListBase$CMTINFO0.nonrecmcnt = t30.e;
        if(t30.a == O1.b && t30.b) {
            z = true;
        }
        cmtSharedTypeRes$CmtListBase$CMTINFO0.membernonrecmflag = z;
        cmtList cmtResViewModel$result$cmtList0 = new cmtList();
        cmtResViewModel$result$cmtList0.cmtinfo = cmtSharedTypeRes$CmtListBase$CMTINFO0;
        MEMBERINFO cmtSharedTypeRes$CmtListBase$MEMBERINFO0 = !t30.f || cmtResViewModel$result$cmtList0.recommenderInfo != null ? cmtResViewModel$result$cmtList0.recommenderInfo : new MEMBERINFO();
        cmtResViewModel$result$cmtList0.recommenderInfo = cmtSharedTypeRes$CmtListBase$MEMBERINFO0;
        if(cmtSharedTypeRes$CmtListBase$MEMBERINFO0 != null) {
            cmtSharedTypeRes$CmtListBase$MEMBERINFO0.mypageimg = t30.g;
        }
        return cmtResViewModel$result$cmtList0;
    }

    @NotNull
    public static final CommentConfig toUiModel(@NotNull result loadPgnRes$result0) {
        q.g(loadPgnRes$result0, "<this>");
        int v = loadPgnRes$result0.paginginfo == null ? -1 : loadPgnRes$result0.paginginfo.firstpageno;
        boolean z = loadPgnRes$result0.chnlinfo == null ? false : loadPgnRes$result0.chnlinfo.playFilterUseFlag;
        boolean z1 = i.l(loadPgnRes$result0.chnlinfo) && i.l(loadPgnRes$result0.spaminfo);
        CHNLINFO loadPgnRes$result$CHNLINFO0 = loadPgnRes$result0.chnlinfo;
        boolean z2 = loadPgnRes$result$CHNLINFO0 == null ? false : loadPgnRes$result$CHNLINFO0.recmuseflag;
        PAGEINFO loadPgnRes$result$PAGEINFO0 = loadPgnRes$result0.pageinfo;
        int v1 = loadPgnRes$result$PAGEINFO0 == null ? 0 : loadPgnRes$result$PAGEINFO0.validcnt;
        boolean z3 = loadPgnRes$result$CHNLINFO0 == null ? false : loadPgnRes$result$CHNLINFO0.blindContsCmtListFlag;
        boolean z4 = loadPgnRes$result$CHNLINFO0 == null ? false : loadPgnRes$result$CHNLINFO0.blindContsCmtWriteFlag;
        String s = loadPgnRes$result$CHNLINFO0 == null ? null : loadPgnRes$result$CHNLINFO0.blindContsDsplyText;
        if(s == null) {
            s = "";
        }
        int v2 = loadPgnRes$result$PAGEINFO0 == null ? -1 : loadPgnRes$result$PAGEINFO0.startseq;
        boolean z5 = loadPgnRes$result$CHNLINFO0 == null ? false : loadPgnRes$result$CHNLINFO0.checkArtistFanFlag;
        MYMEMBERINFO loadPgnRes$result$MYMEMBERINFO0 = loadPgnRes$result0.myMemberInfo;
        boolean z6 = loadPgnRes$result$MYMEMBERINFO0 == null ? false : loadPgnRes$result$MYMEMBERINFO0.artistFanFlag;
        SPAMINFO loadPgnRes$result$SPAMINFO0 = loadPgnRes$result0.spaminfo;
        boolean z7 = loadPgnRes$result$SPAMINFO0 == null ? false : loadPgnRes$result$SPAMINFO0.breakmemberflag;
        String s1 = loadPgnRes$result$SPAMINFO0 == null ? null : loadPgnRes$result$SPAMINFO0.breakMemberGuideUrl;
        if(s1 == null) {
            s1 = "";
        }
        String s2 = loadPgnRes$result$SPAMINFO0 == null ? null : loadPgnRes$result$SPAMINFO0.breakMemberGuideAppSchme;
        if(s2 == null) {
            s2 = "";
        }
        String s3 = loadPgnRes$result$SPAMINFO0 == null ? null : loadPgnRes$result$SPAMINFO0.breakMemberGuideText;
        if(s3 == null) {
            s3 = "";
        }
        int v3 = loadPgnRes$result$CHNLINFO0 == null ? -1 : loadPgnRes$result$CHNLINFO0.chnlseq;
        String s4 = loadPgnRes$result$CHNLINFO0 == null ? null : loadPgnRes$result$CHNLINFO0.chnlname;
        if(s4 == null) {
            s4 = "";
        }
        String s5 = loadPgnRes$result$PAGEINFO0 == null ? null : loadPgnRes$result$PAGEINFO0.contsrefvalue;
        if(s5 == null) {
            s5 = "";
        }
        String s6 = loadPgnRes$result$CHNLINFO0 == null ? null : loadPgnRes$result$CHNLINFO0.adcmtplaceholdertext;
        if(s6 == null) {
            s6 = "";
        }
        int v4 = loadPgnRes$result$CHNLINFO0 == null ? 0 : loadPgnRes$result$CHNLINFO0.adcmtregminlength;
        int v5 = loadPgnRes$result$CHNLINFO0 == null ? 0 : loadPgnRes$result$CHNLINFO0.adcmtregmaxlength;
        boolean z8 = loadPgnRes$result$CHNLINFO0 == null ? false : loadPgnRes$result$CHNLINFO0.reprtuseflag;
        boolean z9 = loadPgnRes$result$CHNLINFO0 == null ? false : loadPgnRes$result$CHNLINFO0.adcmtuseflag;
        boolean z10 = loadPgnRes$result$MYMEMBERINFO0 == null ? false : loadPgnRes$result$MYMEMBERINFO0.pinUseFlag;
        boolean z11 = loadPgnRes$result$CHNLINFO0 == null ? false : loadPgnRes$result$CHNLINFO0.playFilterUseFlag;
        String s7 = loadPgnRes$result$CHNLINFO0 == null ? null : loadPgnRes$result$CHNLINFO0.reprtWindowUrl;
        if(s7 == null) {
            s7 = "";
        }
        String s8 = loadPgnRes$result$CHNLINFO0 == null ? null : loadPgnRes$result$CHNLINFO0.mobilecmtplaceholdertext;
        if(s8 == null) {
            s8 = "";
        }
        int v6 = loadPgnRes$result$CHNLINFO0 == null ? 0 : loadPgnRes$result$CHNLINFO0.cmtregmaxlength;
        int v7 = loadPgnRes$result$CHNLINFO0 == null ? 0 : loadPgnRes$result$CHNLINFO0.cmtregminlength;
        boolean z12 = loadPgnRes$result$CHNLINFO0 == null ? false : loadPgnRes$result$CHNLINFO0.musicatachuseflag;
        boolean z13 = loadPgnRes$result$CHNLINFO0 == null ? false : loadPgnRes$result$CHNLINFO0.imageatachuseflag;
        boolean z14 = loadPgnRes$result$CHNLINFO0 == null ? false : loadPgnRes$result$CHNLINFO0.vdoatachuseflag;
        boolean z15 = loadPgnRes$result$CHNLINFO0 == null ? false : loadPgnRes$result$CHNLINFO0.linkatachuseflag;
        boolean z16 = loadPgnRes$result$CHNLINFO0 == null ? false : loadPgnRes$result$CHNLINFO0.kakaoemoticonatachuseflag;
        boolean z17 = loadPgnRes$result$CHNLINFO0 == null ? false : loadPgnRes$result$CHNLINFO0.atachuseflag;
        int v8 = loadPgnRes$result$CHNLINFO0 == null ? 0 : loadPgnRes$result$CHNLINFO0.atachmaxcnt;
        String s9 = loadPgnRes$result$CHNLINFO0 == null ? null : loadPgnRes$result$CHNLINFO0.cmtImageUploadDomain;
        return s9 == null ? new CommentConfig(v, z, z1, z2, v1, z3, z4, s, v2, z5, z6, z7, s1, s2, s3, v3, s4, s5, 0, s6, v4, v5, z8, z9, z10, z11, s7, s8, v6, v7, z12, z13, z14, z15, z16, z17, v8, "", new ArrayList(), null, 0x40000, 0, null) : new CommentConfig(v, z, z1, z2, v1, z3, z4, s, v2, z5, z6, z7, s1, s2, s3, v3, s4, s5, 0, s6, v4, v5, z8, z9, z10, z11, s7, s8, v6, v7, z12, z13, z14, z15, z16, z17, v8, s9, new ArrayList(), null, 0x40000, 0, null);
    }
}


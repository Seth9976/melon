package com.melon.net.res.v3;

import S7.b;
import ba.s;
import com.iloen.melon.types.StringIds;
import com.iloen.melon.utils.ResourceUtils;
import d3.g;
import e.k;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collection;
import java.util.regex.Pattern;
import je.p;
import je.w;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.q;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0013\b\u0007\u0018\u00002\u00020\u0001:\u0010\u0004\u0005\u0006\u0007\b\t\n\u000B\f\r\u000E\u000F\u0010\u0011\u0012\u0013B\u0007¢\u0006\u0004\b\u0002\u0010\u0003¨\u0006\u0014"}, d2 = {"Lcom/melon/net/res/v3/CommentApiModel;", "", "<init>", "()V", "CmtInfoBase", "CmtListBase", "AdCmtListBase", "MemberInfoBase", "AttachListBase", "AttachSumryBase", "AdCmtSumaryBase", "AttachPropertyBase", "PageInfoBase", "PagingInfoBase", "PageListBase", "BreakWordlistBase", "BreakIPListBase", "VdoLinkAttachPermURLListBase", "GenrlLinkAttachBreakURLListBase", "VideoAppearanceListBase", "app_playstoreProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 0x30)
public final class CommentApiModel {
    @Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000B\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u000B\b\u0007\u0018\u0000  2\u00020\u00012\u00020\u0002:\u0001 B\u0007¢\u0006\u0004\b\u0003\u0010\u0004J\r\u0010\u0006\u001A\u00020\u0005¢\u0006\u0004\b\u0006\u0010\u0007J\r\u0010\b\u001A\u00020\u0005¢\u0006\u0004\b\b\u0010\u0007J\r\u0010\t\u001A\u00020\u0005¢\u0006\u0004\b\t\u0010\u0007J\r\u0010\n\u001A\u00020\u0005¢\u0006\u0004\b\n\u0010\u0007J\r\u0010\u000B\u001A\u00020\u0005¢\u0006\u0004\b\u000B\u0010\u0007J\u000F\u0010\r\u001A\u00020\fH\u0016¢\u0006\u0004\b\r\u0010\u000ER$\u0010\u0010\u001A\u0004\u0018\u00010\u000F8\u0006@\u0006X\u0087\u000E¢\u0006\u0012\n\u0004\b\u0010\u0010\u0011\u001A\u0004\b\u0012\u0010\u0013\"\u0004\b\u0014\u0010\u0015R$\u0010\u0017\u001A\u0004\u0018\u00010\u00168\u0006@\u0006X\u0087\u000E¢\u0006\u0012\n\u0004\b\u0017\u0010\u0018\u001A\u0004\b\u0019\u0010\u001A\"\u0004\b\u001B\u0010\u001CR$\u0010\u001D\u001A\u0004\u0018\u00010\u00168\u0006@\u0006X\u0087\u000E¢\u0006\u0012\n\u0004\b\u001D\u0010\u0018\u001A\u0004\b\u001E\u0010\u001A\"\u0004\b\u001F\u0010\u001C¨\u0006!"}, d2 = {"Lcom/melon/net/res/v3/CommentApiModel$AdCmtListBase;", "Ljava/io/Serializable;", "", "<init>", "()V", "", "isArtist", "()Z", "hasUserLink", "isBlocked", "isEditable", "isNotice", "Lcom/melon/net/res/v3/CommentUiModel;", "toUiModel", "()Lcom/melon/net/res/v3/CommentUiModel;", "Lcom/melon/net/res/v3/CommentApiModel$CmtInfoBase;", "cmtInfo", "Lcom/melon/net/res/v3/CommentApiModel$CmtInfoBase;", "getCmtInfo", "()Lcom/melon/net/res/v3/CommentApiModel$CmtInfoBase;", "setCmtInfo", "(Lcom/melon/net/res/v3/CommentApiModel$CmtInfoBase;)V", "Lcom/melon/net/res/v3/CommentApiModel$MemberInfoBase;", "memberInfo", "Lcom/melon/net/res/v3/CommentApiModel$MemberInfoBase;", "getMemberInfo", "()Lcom/melon/net/res/v3/CommentApiModel$MemberInfoBase;", "setMemberInfo", "(Lcom/melon/net/res/v3/CommentApiModel$MemberInfoBase;)V", "recommenderInfo", "getRecommenderInfo", "setRecommenderInfo", "Companion", "app_playstoreProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 0x30)
    public static final class AdCmtListBase implements Serializable {
        @Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\t\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003R\u000E\u0010\u0004\u001A\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000¨\u0006\u0006"}, d2 = {"Lcom/melon/net/res/v3/CommentApiModel$AdCmtListBase$Companion;", "", "<init>", "()V", "serialVersionUID", "", "app_playstoreProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 0x30)
        public static final class Companion {
            private Companion() {
            }

            public Companion(DefaultConstructorMarker defaultConstructorMarker0) {
            }
        }

        public static final int $stable = 0;
        @NotNull
        public static final Companion Companion = null;
        @b("adcmtInfo")
        @Nullable
        private CmtInfoBase cmtInfo;
        @b("memberInfo")
        @Nullable
        private MemberInfoBase memberInfo;
        @b("recommenderInfo")
        @Nullable
        private MemberInfoBase recommenderInfo;
        private static final long serialVersionUID = 0x86F0C334AA23B82BL;

        static {
            AdCmtListBase.Companion = new Companion(null);
            AdCmtListBase.$stable = 8;
        }

        @Nullable
        public final CmtInfoBase getCmtInfo() {
            return this.cmtInfo;
        }

        @Nullable
        public final MemberInfoBase getMemberInfo() {
            return this.memberInfo;
        }

        @Nullable
        public final MemberInfoBase getRecommenderInfo() {
            return this.recommenderInfo;
        }

        public final boolean hasUserLink() {
            String s = this.memberInfo == null ? null : this.memberInfo.getMemberKey();
            if(s == null) {
                s = "";
            }
            return this.isArtist() || !StringIds.a(s, StringIds.c) && !StringIds.a(s, StringIds.i) && !StringIds.a(s, StringIds.k);
        }

        public final boolean isArtist() {
            return this.memberInfo == null ? false : this.memberInfo.getArtistFlag();
        }

        public final boolean isBlocked() {
            Boolean boolean0 = null;
            Boolean boolean1 = this.cmtInfo == null ? null : Boolean.valueOf(this.cmtInfo.getBreakFlag());
            CmtInfoBase commentApiModel$CmtInfoBase0 = this.cmtInfo;
            if(commentApiModel$CmtInfoBase0 != null) {
                boolean0 = Boolean.valueOf(commentApiModel$CmtInfoBase0.getDelFlag());
            }
            Iterable iterable0 = k.A(new Boolean[]{boolean1, boolean0});
            if(iterable0 instanceof Collection && ((Collection)iterable0).isEmpty()) {
                return false;
            }
            for(Object object0: iterable0) {
                if(q.b(((Boolean)object0), Boolean.TRUE)) {
                    return true;
                }
                if(false) {
                    break;
                }
            }
            return false;
        }

        // 去混淆评级： 低(40)
        public final boolean isEditable() {
            return this.cmtInfo != null && !this.cmtInfo.getDelFlag() && !this.cmtInfo.getAncmFlag() && this.cmtInfo.getMemberCmtFlag() && !this.cmtInfo.getTempActFlag();
        }

        public final boolean isNotice() {
            return this.cmtInfo == null ? false : this.cmtInfo.getAncmFlag();
        }

        public final void setCmtInfo(@Nullable CmtInfoBase commentApiModel$CmtInfoBase0) {
            this.cmtInfo = commentApiModel$CmtInfoBase0;
        }

        public final void setMemberInfo(@Nullable MemberInfoBase commentApiModel$MemberInfoBase0) {
            this.memberInfo = commentApiModel$MemberInfoBase0;
        }

        public final void setRecommenderInfo(@Nullable MemberInfoBase commentApiModel$MemberInfoBase0) {
            this.recommenderInfo = commentApiModel$MemberInfoBase0;
        }

        public s toUiModel() {
            return this.toUiModel();
        }

        @NotNull
        public CommentUiModel toUiModel() {
            String s12;
            String s8;
            boolean z12;
            int v3;
            String s6;
            String s5;
            String s4;
            String s3;
            String s2;
            int v = this.cmtInfo == null ? -1 : this.cmtInfo.getCmtSeq();
            boolean z = this.cmtInfo == null ? false : this.cmtInfo.getAncmFlag();
            String s = this.memberInfo == null ? null : this.memberInfo.getMemberKey();
            if(s == null) {
                s = "";
            }
            boolean z1 = this.isArtist();
            String s1 = String.valueOf((this.memberInfo == null ? null : this.memberInfo.getArtistId()));
            boolean z2 = this.cmtInfo == null ? false : this.cmtInfo.getBestFlag();
            boolean z3 = this.hasUserLink();
            boolean z4 = this.isBlocked();
            boolean z5 = this.cmtInfo == null ? false : this.cmtInfo.getTempActFlag();
            boolean z6 = this.isEditable();
            boolean z7 = g.M((this.memberInfo == null ? null : this.memberInfo.getMemberDjType()));
            int v1 = ResourceUtils.getDjIconColorId((this.memberInfo == null ? null : this.memberInfo.getMemberDjIconType()));
            boolean z8 = this.memberInfo == null ? false : this.memberInfo.getOfficial();
            boolean z9 = this.cmtInfo == null ? false : this.cmtInfo.getMemberCmtFlag();
            if(this.isArtist()) {
                s2 = s;
                s3 = this.memberInfo == null ? null : this.memberInfo.getArtistName();
                if(s3 == null) {
                    s3 = "";
                }
            }
            else {
                s2 = s;
                s3 = this.memberInfo == null ? null : this.memberInfo.getMemberNickname();
                if(s3 == null) {
                    s3 = "";
                }
            }
            if(this.isArtist()) {
                s4 = s3;
                s5 = this.memberInfo == null ? null : this.memberInfo.getArtistImage();
            }
            else {
                s4 = s3;
                s5 = this.memberInfo == null ? null : this.memberInfo.getMyPageImg();
            }
            s6 = s5 == null ? "" : s5;
            boolean z10 = this.cmtInfo == null ? false : this.cmtInfo.getPinnedFlag();
            boolean z11 = this.cmtInfo == null ? false : this.cmtInfo.getPlayFlag();
            int v2 = this.memberInfo == null ? -1 : this.memberInfo.getArtistTemperature();
            String s7 = this.cmtInfo == null ? null : this.cmtInfo.getCmtCont();
            if(s7 == null || s7.length() <= 0) {
                s7 = null;
            }
            if(s7 == null) {
                v3 = v1;
                z12 = z8;
                s8 = "";
            }
            else {
                v3 = v1;
                Pattern pattern0 = Pattern.compile("\n");
                z12 = z8;
                q.f(pattern0, "compile(...)");
                s8 = pattern0.matcher(s7).replaceAll("<br>");
                q.f(s8, "replaceAll(...)");
            }
            String s9 = this.cmtInfo == null ? null : this.cmtInfo.getDsplyDate();
            String s10 = s9 == null ? "" : s9;
            CmtInfoBase commentApiModel$CmtInfoBase0 = this.cmtInfo;
            if(commentApiModel$CmtInfoBase0 == null) {
                s12 = "";
            }
            else {
                String s11 = commentApiModel$CmtInfoBase0.getDsplyDate2();
                s12 = s11 == null ? "" : s11;
            }
            int v4 = this.cmtInfo == null ? 0 : this.cmtInfo.getRecmCnt();
            int v5 = this.cmtInfo == null ? 0 : this.cmtInfo.getNonRecmCnt();
            boolean z13 = this.cmtInfo == null ? false : this.cmtInfo.getMemberRecmFlag();
            boolean z14 = this.cmtInfo == null ? false : this.cmtInfo.getMemberNonRecmFlag();
            int v6 = this.cmtInfo == null ? 0 : this.cmtInfo.getValidAdcmtCnt();
            boolean z15 = this.recommenderInfo != null;
            String s13 = this.recommenderInfo == null ? null : this.recommenderInfo.getMyPageImg();
            return s13 == null ? new CommentUiModel(v, z, s2, z1, s1, z2, z3, z4, z5, z6, z7, v3, z12, z9, s4, s6, 0, z10, z11, v2, s8, false, s10, s12, v4, v5, z13, z14, v6, w.a, true, false, z15, "", 0x80000000, 0, null) : new CommentUiModel(v, z, s2, z1, s1, z2, z3, z4, z5, z6, z7, v3, z12, z9, s4, s6, 0, z10, z11, v2, s8, false, s10, s12, v4, v5, z13, z14, v6, w.a, true, false, z15, s13, 0x80000000, 0, null);
        }
    }

    @Metadata(d1 = {"\u0000\u001C\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0017\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003R \u0010\u0004\u001A\u0004\u0018\u00010\u00058\u0006@\u0006X\u0087\u000E¢\u0006\u000E\n\u0000\u001A\u0004\b\u0006\u0010\u0007\"\u0004\b\b\u0010\tR \u0010\n\u001A\u0004\u0018\u00010\u000B8\u0006@\u0006X\u0087\u000E¢\u0006\u000E\n\u0000\u001A\u0004\b\f\u0010\r\"\u0004\b\u000E\u0010\u000F¨\u0006\u0010"}, d2 = {"Lcom/melon/net/res/v3/CommentApiModel$AdCmtSumaryBase;", "Ljava/io/Serializable;", "<init>", "()V", "adcmtInfo", "Lcom/melon/net/res/v3/CommentApiModel$CmtInfoBase;", "getAdcmtInfo", "()Lcom/melon/net/res/v3/CommentApiModel$CmtInfoBase;", "setAdcmtInfo", "(Lcom/melon/net/res/v3/CommentApiModel$CmtInfoBase;)V", "memberInfo", "Lcom/melon/net/res/v3/CommentApiModel$MemberInfoBase;", "getMemberInfo", "()Lcom/melon/net/res/v3/CommentApiModel$MemberInfoBase;", "setMemberInfo", "(Lcom/melon/net/res/v3/CommentApiModel$MemberInfoBase;)V", "app_playstoreProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 0x30)
    public static class AdCmtSumaryBase implements Serializable {
        public static final int $stable = 8;
        @b("adcmtInfo")
        @Nullable
        private CmtInfoBase adcmtInfo;
        @b("memberInfo")
        @Nullable
        private MemberInfoBase memberInfo;

        @Nullable
        public final CmtInfoBase getAdcmtInfo() {
            return this.adcmtInfo;
        }

        @Nullable
        public final MemberInfoBase getMemberInfo() {
            return this.memberInfo;
        }

        public final void setAdcmtInfo(@Nullable CmtInfoBase commentApiModel$CmtInfoBase0) {
            this.adcmtInfo = commentApiModel$CmtInfoBase0;
        }

        public final void setMemberInfo(@Nullable MemberInfoBase commentApiModel$MemberInfoBase0) {
            this.memberInfo = commentApiModel$MemberInfoBase0;
        }
    }

    @Metadata(d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000E\n\u0000\n\u0002\u0010\u000B\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0011\n\u0002\u0018\u0002\n\u0002\b\u0007\b\u0017\u0018\u00002\u00020\u00012\u00020\u0002B\u0007¢\u0006\u0004\b\u0003\u0010\u0004J\u0019\u0010\b\u001A\u00020\u00072\b\u0010\u0006\u001A\u0004\u0018\u00010\u0005H\u0002¢\u0006\u0004\b\b\u0010\tJ\u000F\u0010\u000B\u001A\u00020\nH\u0016¢\u0006\u0004\b\u000B\u0010\fR\"\u0010\u000E\u001A\u00020\r8\u0006@\u0006X\u0087\u000E¢\u0006\u0012\n\u0004\b\u000E\u0010\u000F\u001A\u0004\b\u0010\u0010\u0011\"\u0004\b\u0012\u0010\u0013R\"\u0010\u0014\u001A\u00020\r8\u0006@\u0006X\u0087\u000E¢\u0006\u0012\n\u0004\b\u0014\u0010\u000F\u001A\u0004\b\u0015\u0010\u0011\"\u0004\b\u0016\u0010\u0013R$\u0010\u0006\u001A\u0004\u0018\u00010\u00058\u0006@\u0006X\u0087\u000E¢\u0006\u0012\n\u0004\b\u0006\u0010\u0017\u001A\u0004\b\u0018\u0010\u0019\"\u0004\b\u001A\u0010\u001BR$\u0010\u001C\u001A\u0004\u0018\u00010\u00058\u0006@\u0006X\u0087\u000E¢\u0006\u0012\n\u0004\b\u001C\u0010\u0017\u001A\u0004\b\u001D\u0010\u0019\"\u0004\b\u001E\u0010\u001BR$\u0010 \u001A\u0004\u0018\u00010\u001F8\u0006@\u0006X\u0087\u000E¢\u0006\u0012\n\u0004\b \u0010!\u001A\u0004\b\"\u0010#\"\u0004\b$\u0010%¨\u0006&"}, d2 = {"Lcom/melon/net/res/v3/CommentApiModel$AttachListBase;", "Ljava/io/Serializable;", "", "<init>", "()V", "", "attachType", "", "isAvailableCmtAttachType", "(Ljava/lang/String;)Z", "Lcom/melon/net/res/v3/MediaAttachHelper$AttachPropertyData;", "toUiModel", "()Lcom/melon/net/res/v3/MediaAttachHelper$AttachPropertyData;", "", "attachSeq", "I", "getAttachSeq", "()I", "setAttachSeq", "(I)V", "attachDsplyOrder", "getAttachDsplyOrder", "setAttachDsplyOrder", "Ljava/lang/String;", "getAttachType", "()Ljava/lang/String;", "setAttachType", "(Ljava/lang/String;)V", "attachValue", "getAttachValue", "setAttachValue", "Lcom/melon/net/res/v3/CommentApiModel$AttachPropertyBase;", "attachProperty", "Lcom/melon/net/res/v3/CommentApiModel$AttachPropertyBase;", "getAttachProperty", "()Lcom/melon/net/res/v3/CommentApiModel$AttachPropertyBase;", "setAttachProperty", "(Lcom/melon/net/res/v3/CommentApiModel$AttachPropertyBase;)V", "app_playstoreProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 0x30)
    public static class AttachListBase implements Serializable {
        public static final int $stable = 8;
        @b("atachDsplyOrder")
        private int attachDsplyOrder;
        @b("atachPropty")
        @Nullable
        private AttachPropertyBase attachProperty;
        @b("atachSeq")
        private int attachSeq;
        @b("atachType")
        @Nullable
        private String attachType;
        @b("atachValue")
        @Nullable
        private String attachValue;

        public AttachListBase() {
            this.attachSeq = -1;
            this.attachDsplyOrder = -1;
        }

        public final int getAttachDsplyOrder() {
            return this.attachDsplyOrder;
        }

        @Nullable
        public final AttachPropertyBase getAttachProperty() {
            return this.attachProperty;
        }

        public final int getAttachSeq() {
            return this.attachSeq;
        }

        @Nullable
        public final String getAttachType() {
            return this.attachType;
        }

        @Nullable
        public final String getAttachValue() {
            return this.attachValue;
        }

        private final boolean isAvailableCmtAttachType(String s) {
            return p.d0(k.A(new String[]{"image", "music_song", "music_album", "music_artist", "video", "link_video", "link_genrl", "kakao_emoticon"}), s);
        }

        public final void setAttachDsplyOrder(int v) {
            this.attachDsplyOrder = v;
        }

        public final void setAttachProperty(@Nullable AttachPropertyBase commentApiModel$AttachPropertyBase0) {
            this.attachProperty = commentApiModel$AttachPropertyBase0;
        }

        public final void setAttachSeq(int v) {
            this.attachSeq = v;
        }

        public final void setAttachType(@Nullable String s) {
            this.attachType = s;
        }

        public final void setAttachValue(@Nullable String s) {
            this.attachValue = s;
        }

        public s toUiModel() {
            return this.toUiModel();
        }

        @NotNull
        public AttachPropertyData toUiModel() {
            AttachPropertyData mediaAttachHelper$AttachPropertyData0 = MediaAttachHelper.INSTANCE.getAttachPropertyData((this.attachType == null ? "" : this.attachType), this.attachProperty);
            if(mediaAttachHelper$AttachPropertyData0 != null) {
                if(!this.isAvailableCmtAttachType(this.attachType)) {
                    mediaAttachHelper$AttachPropertyData0 = null;
                }
                if(mediaAttachHelper$AttachPropertyData0 != null) {
                    return mediaAttachHelper$AttachPropertyData0;
                }
            }
            return new None(null, 1, null);
        }
    }

    @Metadata(d1 = {"\u0000<\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000E\n\u0002\b\u0011\n\u0002\u0010\b\n\u0002\b5\n\u0002\u0010\u000B\n\u0002\bG\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0007\b\u0017\u0018\u0000 \u00A3\u00012\u00020\u0001:\u0002\u00A3\u0001B\u0007\u00A2\u0006\u0004\b\u0002\u0010\u0003R \u0010\u0004\u001A\u0004\u0018\u00010\u00058\u0006@\u0006X\u0087\u000E\u00A2\u0006\u000E\n\u0000\u001A\u0004\b\u0006\u0010\u0007\"\u0004\b\b\u0010\tR \u0010\n\u001A\u0004\u0018\u00010\u00058\u0006@\u0006X\u0087\u000E\u00A2\u0006\u000E\n\u0000\u001A\u0004\b\u000B\u0010\u0007\"\u0004\b\f\u0010\tR \u0010\r\u001A\u0004\u0018\u00010\u00058\u0006@\u0006X\u0087\u000E\u00A2\u0006\u000E\n\u0000\u001A\u0004\b\u000E\u0010\u0007\"\u0004\b\u000F\u0010\tR \u0010\u0010\u001A\u0004\u0018\u00010\u00058\u0006@\u0006X\u0087\u000E\u00A2\u0006\u000E\n\u0000\u001A\u0004\b\u0011\u0010\u0007\"\u0004\b\u0012\u0010\tR \u0010\u0013\u001A\u0004\u0018\u00010\u00058\u0006@\u0006X\u0087\u000E\u00A2\u0006\u000E\n\u0000\u001A\u0004\b\u0014\u0010\u0007\"\u0004\b\u0015\u0010\tR\u001E\u0010\u0016\u001A\u00020\u00178\u0006@\u0006X\u0087\u000E\u00A2\u0006\u000E\n\u0000\u001A\u0004\b\u0018\u0010\u0019\"\u0004\b\u001A\u0010\u001BR \u0010\u001C\u001A\u0004\u0018\u00010\u00058\u0006@\u0006X\u0087\u000E\u00A2\u0006\u000E\n\u0000\u001A\u0004\b\u001D\u0010\u0007\"\u0004\b\u001E\u0010\tR \u0010\u001F\u001A\u0004\u0018\u00010\u00058\u0006@\u0006X\u0087\u000E\u00A2\u0006\u000E\n\u0000\u001A\u0004\b \u0010\u0007\"\u0004\b!\u0010\tR \u0010\"\u001A\u0004\u0018\u00010\u00058\u0006@\u0006X\u0087\u000E\u00A2\u0006\u000E\n\u0000\u001A\u0004\b#\u0010\u0007\"\u0004\b$\u0010\tR \u0010%\u001A\u0004\u0018\u00010\u00058\u0006@\u0006X\u0087\u000E\u00A2\u0006\u000E\n\u0000\u001A\u0004\b&\u0010\u0007\"\u0004\b\'\u0010\tR \u0010(\u001A\u0004\u0018\u00010\u00058\u0006@\u0006X\u0087\u000E\u00A2\u0006\u000E\n\u0000\u001A\u0004\b)\u0010\u0007\"\u0004\b*\u0010\tR \u0010+\u001A\u0004\u0018\u00010\u00058\u0006@\u0006X\u0087\u000E\u00A2\u0006\u000E\n\u0000\u001A\u0004\b,\u0010\u0007\"\u0004\b-\u0010\tR \u0010.\u001A\u0004\u0018\u00010\u00058\u0006@\u0006X\u0087\u000E\u00A2\u0006\u000E\n\u0000\u001A\u0004\b/\u0010\u0007\"\u0004\b0\u0010\tR\u001E\u00101\u001A\u00020\u00178\u0006@\u0006X\u0087\u000E\u00A2\u0006\u000E\n\u0000\u001A\u0004\b2\u0010\u0019\"\u0004\b3\u0010\u001BR\u001E\u00104\u001A\u00020\u00178\u0006@\u0006X\u0087\u000E\u00A2\u0006\u000E\n\u0000\u001A\u0004\b5\u0010\u0019\"\u0004\b6\u0010\u001BR \u00107\u001A\u0004\u0018\u00010\u00058\u0006@\u0006X\u0087\u000E\u00A2\u0006\u000E\n\u0000\u001A\u0004\b8\u0010\u0007\"\u0004\b9\u0010\tR \u0010:\u001A\u0004\u0018\u00010\u00058\u0006@\u0006X\u0087\u000E\u00A2\u0006\u000E\n\u0000\u001A\u0004\b;\u0010\u0007\"\u0004\b<\u0010\tR \u0010=\u001A\u0004\u0018\u00010\u00058\u0006@\u0006X\u0087\u000E\u00A2\u0006\u000E\n\u0000\u001A\u0004\b>\u0010\u0007\"\u0004\b?\u0010\tR \u0010@\u001A\u0004\u0018\u00010\u00058\u0006@\u0006X\u0087\u000E\u00A2\u0006\u000E\n\u0000\u001A\u0004\bA\u0010\u0007\"\u0004\bB\u0010\tR\u001E\u0010C\u001A\u00020\u00178\u0006@\u0006X\u0087\u000E\u00A2\u0006\u000E\n\u0000\u001A\u0004\bD\u0010\u0019\"\u0004\bE\u0010\u001BR \u0010F\u001A\u0004\u0018\u00010\u00058\u0006@\u0006X\u0087\u000E\u00A2\u0006\u000E\n\u0000\u001A\u0004\bG\u0010\u0007\"\u0004\bH\u0010\tR\u001E\u0010I\u001A\u00020\u00178\u0006@\u0006X\u0087\u000E\u00A2\u0006\u000E\n\u0000\u001A\u0004\bJ\u0010\u0019\"\u0004\bK\u0010\u001BR\u001A\u0010L\u001A\u00020MX\u0086\u000E\u00A2\u0006\u000E\n\u0000\u001A\u0004\bN\u0010O\"\u0004\bP\u0010QR\u001E\u0010R\u001A\u00020M8\u0006@\u0006X\u0087\u000E\u00A2\u0006\u000E\n\u0000\u001A\u0004\bS\u0010O\"\u0004\bT\u0010QR\u001E\u0010U\u001A\u00020M8\u0006@\u0006X\u0087\u000E\u00A2\u0006\u000E\n\u0000\u001A\u0004\bV\u0010O\"\u0004\bW\u0010QR\u001E\u0010X\u001A\u00020M8\u0006@\u0006X\u0087\u000E\u00A2\u0006\u000E\n\u0000\u001A\u0004\bY\u0010O\"\u0004\bZ\u0010QR\u001E\u0010[\u001A\u00020M8\u0006@\u0006X\u0087\u000E\u00A2\u0006\u000E\n\u0000\u001A\u0004\b\\\u0010O\"\u0004\b]\u0010QR\u001E\u0010^\u001A\u00020M8\u0006@\u0006X\u0087\u000E\u00A2\u0006\u000E\n\u0000\u001A\u0004\b_\u0010O\"\u0004\b`\u0010QR\u001E\u0010a\u001A\u00020M8\u0006@\u0006X\u0087\u000E\u00A2\u0006\u000E\n\u0000\u001A\u0004\bb\u0010O\"\u0004\bc\u0010QR\u001E\u0010d\u001A\u00020M8\u0006@\u0006X\u0087\u000E\u00A2\u0006\u000E\n\u0000\u001A\u0004\be\u0010O\"\u0004\bf\u0010QR\u001E\u0010g\u001A\u00020\u00178\u0006@\u0006X\u0087\u000E\u00A2\u0006\u000E\n\u0000\u001A\u0004\bh\u0010\u0019\"\u0004\bi\u0010\u001BR\u001E\u0010j\u001A\u00020\u00178\u0006@\u0006X\u0087\u000E\u00A2\u0006\u000E\n\u0000\u001A\u0004\bk\u0010\u0019\"\u0004\bl\u0010\u001BR\u001E\u0010m\u001A\u00020\u00178\u0006@\u0006X\u0087\u000E\u00A2\u0006\u000E\n\u0000\u001A\u0004\bn\u0010\u0019\"\u0004\bo\u0010\u001BR \u0010p\u001A\u0004\u0018\u00010\u00058\u0006@\u0006X\u0087\u000E\u00A2\u0006\u000E\n\u0000\u001A\u0004\bq\u0010\u0007\"\u0004\br\u0010\tR\u001E\u0010s\u001A\u00020M8\u0006@\u0006X\u0087\u000E\u00A2\u0006\u000E\n\u0000\u001A\u0004\bt\u0010O\"\u0004\bu\u0010QR\u001E\u0010v\u001A\u00020M8\u0006@\u0006X\u0087\u000E\u00A2\u0006\u000E\n\u0000\u001A\u0004\bw\u0010O\"\u0004\bx\u0010QR\u001E\u0010y\u001A\u00020\u00178\u0006@\u0006X\u0087\u000E\u00A2\u0006\u000E\n\u0000\u001A\u0004\bz\u0010\u0019\"\u0004\b{\u0010\u001BR \u0010|\u001A\u0004\u0018\u00010\u00058\u0006@\u0006X\u0087\u000E\u00A2\u0006\u000E\n\u0000\u001A\u0004\b}\u0010\u0007\"\u0004\b~\u0010\tR\"\u0010\u007F\u001A\u0004\u0018\u00010\u00058\u0006@\u0006X\u0087\u000E\u00A2\u0006\u0010\n\u0000\u001A\u0005\b\u0080\u0001\u0010\u0007\"\u0005\b\u0081\u0001\u0010\tR#\u0010\u0082\u0001\u001A\u0004\u0018\u00010\u00058\u0006@\u0006X\u0087\u000E\u00A2\u0006\u0010\n\u0000\u001A\u0005\b\u0083\u0001\u0010\u0007\"\u0005\b\u0084\u0001\u0010\tR!\u0010\u0085\u0001\u001A\u00020\u00178\u0006@\u0006X\u0087\u000E\u00A2\u0006\u0010\n\u0000\u001A\u0005\b\u0086\u0001\u0010\u0019\"\u0005\b\u0087\u0001\u0010\u001BR#\u0010\u0088\u0001\u001A\u0004\u0018\u00010\u00058\u0006@\u0006X\u0087\u000E\u00A2\u0006\u0010\n\u0000\u001A\u0005\b\u0089\u0001\u0010\u0007\"\u0005\b\u008A\u0001\u0010\tR!\u0010\u008B\u0001\u001A\u00020M8\u0006@\u0006X\u0087\u000E\u00A2\u0006\u0010\n\u0000\u001A\u0005\b\u008C\u0001\u0010O\"\u0005\b\u008D\u0001\u0010QR!\u0010\u008E\u0001\u001A\u00020M8\u0006@\u0006X\u0087\u000E\u00A2\u0006\u0010\n\u0000\u001A\u0005\b\u008F\u0001\u0010O\"\u0005\b\u0090\u0001\u0010QR#\u0010\u0091\u0001\u001A\u0004\u0018\u00010\u00058\u0006@\u0006X\u0087\u000E\u00A2\u0006\u0010\n\u0000\u001A\u0005\b\u0092\u0001\u0010\u0007\"\u0005\b\u0093\u0001\u0010\tR;\u0010\u0094\u0001\u001A\u001A\u0012\u0005\u0012\u00030\u0096\u0001\u0018\u00010\u0095\u0001j\f\u0012\u0005\u0012\u00030\u0096\u0001\u0018\u0001`\u0097\u00018\u0006@\u0006X\u0087\u000E\u00A2\u0006\u0012\n\u0000\u001A\u0006\b\u0098\u0001\u0010\u0099\u0001\"\u0006\b\u009A\u0001\u0010\u009B\u0001R;\u0010\u009C\u0001\u001A\u001A\u0012\u0005\u0012\u00030\u009D\u0001\u0018\u00010\u0095\u0001j\f\u0012\u0005\u0012\u00030\u009D\u0001\u0018\u0001`\u0097\u00018\u0006@\u0006X\u0087\u000E\u00A2\u0006\u0012\n\u0000\u001A\u0006\b\u009E\u0001\u0010\u0099\u0001\"\u0006\b\u009F\u0001\u0010\u009B\u0001R#\u0010\u00A0\u0001\u001A\u0004\u0018\u00010\u00058\u0006@\u0006X\u0087\u000E\u00A2\u0006\u0010\n\u0000\u001A\u0005\b\u00A1\u0001\u0010\u0007\"\u0005\b\u00A2\u0001\u0010\t\u00A8\u0006\u00A4\u0001"}, d2 = {"Lcom/melon/net/res/v3/CommentApiModel$AttachPropertyBase;", "Ljava/io/Serializable;", "<init>", "()V", "textCont", "", "getTextCont", "()Ljava/lang/String;", "setTextCont", "(Ljava/lang/String;)V", "thumbUrl", "getThumbUrl", "setThumbUrl", "originalUrl", "getOriginalUrl", "setOriginalUrl", "videoUrl", "getVideoUrl", "setVideoUrl", "linkUrl", "getLinkUrl", "setLinkUrl", "artistId", "", "getArtistId", "()I", "setArtistId", "(I)V", "artistName", "getArtistName", "setArtistName", "artistImagePath", "getArtistImagePath", "setArtistImagePath", "artistType", "getArtistType", "setArtistType", "nationalityName", "getNationalityName", "setNationalityName", "actTypeName", "getActTypeName", "setActTypeName", "sex", "getSex", "setSex", "gnr", "getGnr", "setGnr", "fanCnt", "getFanCnt", "setFanCnt", "albumId", "getAlbumId", "setAlbumId", "albumName", "getAlbumName", "setAlbumName", "albumImagePath", "getAlbumImagePath", "setAlbumImagePath", "issueDate", "getIssueDate", "setIssueDate", "dsplyIssueDate", "getDsplyIssueDate", "setDsplyIssueDate", "songId", "getSongId", "setSongId", "songName", "getSongName", "setSongName", "totalSongCnt", "getTotalSongCnt", "setTotalSongCnt", "serviceFlag", "", "getServiceFlag", "()Z", "setServiceFlag", "(Z)V", "adultFlag", "getAdultFlag", "setAdultFlag", "holdBackFlag", "getHoldBackFlag", "setHoldBackFlag", "freezoneFlag", "getFreezoneFlag", "setFreezoneFlag", "stAvailFlag", "getStAvailFlag", "setStAvailFlag", "dlAvailFlag", "getDlAvailFlag", "setDlAvailFlag", "albumOnlyFlag", "getAlbumOnlyFlag", "setAlbumOnlyFlag", "albumDiscountFlag", "getAlbumDiscountFlag", "setAlbumDiscountFlag", "videoId", "getVideoId", "setVideoId", "videoWidth", "getVideoWidth", "setVideoWidth", "videoHeight", "getVideoHeight", "setVideoHeight", "videoTitle", "getVideoTitle", "setVideoTitle", "videoFreezoneFlag", "getVideoFreezoneFlag", "setVideoFreezoneFlag", "videoAdultFlag", "getVideoAdultFlag", "setVideoAdultFlag", "videoAgeLevel", "getVideoAgeLevel", "setVideoAgeLevel", "videoImagePath", "getVideoImagePath", "setVideoImagePath", "videoIssueDate", "getVideoIssueDate", "setVideoIssueDate", "dsplyVideoIssueDate", "getDsplyVideoIssueDate", "setDsplyVideoIssueDate", "videoViewCnt", "getVideoViewCnt", "setVideoViewCnt", "innerVideoType", "getInnerVideoType", "setInnerVideoType", "mvFlag", "getMvFlag", "setMvFlag", "liveFlag", "getLiveFlag", "setLiveFlag", "dsplyPlayTime", "getDsplyPlayTime", "setDsplyPlayTime", "videoAppearanceList", "Ljava/util/ArrayList;", "Lcom/melon/net/res/v3/CommentApiModel$VideoAppearanceListBase;", "Lkotlin/collections/ArrayList;", "getVideoAppearanceList", "()Ljava/util/ArrayList;", "setVideoAppearanceList", "(Ljava/util/ArrayList;)V", "artistList", "Lcom/melon/net/res/common/ArtistsInfoBase;", "getArtistList", "setArtistList", "kakaoEmoticon", "getKakaoEmoticon", "setKakaoEmoticon", "Companion", "app_playstoreProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 0x30)
    public static class AttachPropertyBase implements Serializable {
        @Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u000E\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0012\u0010\u0004\u001A\u0004\u0018\u00010\u00052\b\u0010\u0006\u001A\u0004\u0018\u00010\u0007¨\u0006\b"}, d2 = {"Lcom/melon/net/res/v3/CommentApiModel$AttachPropertyBase$Companion;", "", "<init>", "()V", "getMvTitle", "", "item", "Lcom/melon/net/res/v3/CommentApiModel$AttachPropertyBase;", "app_playstoreProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 0x30)
        public static final class com.melon.net.res.v3.CommentApiModel.AttachPropertyBase.Companion {
            private com.melon.net.res.v3.CommentApiModel.AttachPropertyBase.Companion() {
            }

            public com.melon.net.res.v3.CommentApiModel.AttachPropertyBase.Companion(DefaultConstructorMarker defaultConstructorMarker0) {
            }

            @Nullable
            public final String getMvTitle(@Nullable AttachPropertyBase commentApiModel$AttachPropertyBase0) {
                if(commentApiModel$AttachPropertyBase0 == null) {
                    return null;
                }
                StringBuilder stringBuilder0 = new StringBuilder();
                q.d(commentApiModel$AttachPropertyBase0);
                if(commentApiModel$AttachPropertyBase0.getMvFlag()) {
                    stringBuilder0.append("[MV] ");
                }
                else if(commentApiModel$AttachPropertyBase0.getLiveFlag()) {
                    stringBuilder0.append("[Live] ");
                }
                stringBuilder0.append(commentApiModel$AttachPropertyBase0.getVideoTitle());
                return stringBuilder0.toString();
            }
        }

        public static final int $stable;
        @NotNull
        public static final com.melon.net.res.v3.CommentApiModel.AttachPropertyBase.Companion Companion;
        @b("actTypeName")
        @Nullable
        private String actTypeName;
        @b("adultFlag")
        private boolean adultFlag;
        @b("albumDiscountFlag")
        private boolean albumDiscountFlag;
        @b("albumId")
        private int albumId;
        @b("albumImagePath")
        @Nullable
        private String albumImagePath;
        @b("albumName")
        @Nullable
        private String albumName;
        @b("albumOnlyFlag")
        private boolean albumOnlyFlag;
        @b("artistId")
        private int artistId;
        @b("artistImagePath")
        @Nullable
        private String artistImagePath;
        @b("artistList")
        @Nullable
        private ArrayList artistList;
        @b("artistName")
        @Nullable
        private String artistName;
        @b("artistType")
        @Nullable
        private String artistType;
        @b("dlAvailFlag")
        private boolean dlAvailFlag;
        @b("dsplyIssueDate")
        @Nullable
        private String dsplyIssueDate;
        @b("dsplyPlayTime")
        @Nullable
        private String dsplyPlayTime;
        @b("dsplyVideoIssueDate")
        @Nullable
        private String dsplyVideoIssueDate;
        @b("fanCnt")
        private int fanCnt;
        @b("freezoneFlag")
        private boolean freezoneFlag;
        @b("gnr")
        @Nullable
        private String gnr;
        @b("holdBackFlag")
        private boolean holdBackFlag;
        @b("innerVideoType")
        @Nullable
        private String innerVideoType;
        @b("issueDate")
        @Nullable
        private String issueDate;
        @b("kakaoEmoticon")
        @Nullable
        private String kakaoEmoticon;
        @b("linkUrl")
        @Nullable
        private String linkUrl;
        @b("liveFlag")
        private boolean liveFlag;
        @b("mvFlag")
        private boolean mvFlag;
        @b("nationalityName")
        @Nullable
        private String nationalityName;
        @b("originalUrl")
        @Nullable
        private String originalUrl;
        private boolean serviceFlag;
        @b("sex")
        @Nullable
        private String sex;
        @b("songId")
        private int songId;
        @b("songName")
        @Nullable
        private String songName;
        @b("stAvailFlag")
        private boolean stAvailFlag;
        @b("textCont")
        @Nullable
        private String textCont;
        @b("thumbUrl")
        @Nullable
        private String thumbUrl;
        @b("totalSongCnt")
        private int totalSongCnt;
        @b("videoAdultFlag")
        private boolean videoAdultFlag;
        @b("videoAgeLevel")
        private int videoAgeLevel;
        @b("videoAppearanceList")
        @Nullable
        private ArrayList videoAppearanceList;
        @b("videoFreezoneFlag")
        private boolean videoFreezoneFlag;
        @b("videoHeight")
        private int videoHeight;
        @b("videoId")
        private int videoId;
        @b("videoImagePath")
        @Nullable
        private String videoImagePath;
        @b("videoIssueDate")
        @Nullable
        private String videoIssueDate;
        @b("videoTitle")
        @Nullable
        private String videoTitle;
        @b("videoUrl")
        @Nullable
        private String videoUrl;
        @b("videoViewCnt")
        private int videoViewCnt;
        @b("videoWidth")
        private int videoWidth;

        static {
            AttachPropertyBase.Companion = new com.melon.net.res.v3.CommentApiModel.AttachPropertyBase.Companion(null);
            AttachPropertyBase.$stable = 8;
        }

        public AttachPropertyBase() {
            this.artistId = -1;
            this.fanCnt = -1;
            this.albumId = -1;
            this.songId = -1;
            this.totalSongCnt = -1;
            this.serviceFlag = true;
            this.videoId = -1;
            this.videoWidth = -1;
            this.videoHeight = -1;
            this.videoAgeLevel = -1;
            this.videoViewCnt = -1;
        }

        @Nullable
        public final String getActTypeName() {
            return this.actTypeName;
        }

        public final boolean getAdultFlag() {
            return this.adultFlag;
        }

        public final boolean getAlbumDiscountFlag() {
            return this.albumDiscountFlag;
        }

        public final int getAlbumId() {
            return this.albumId;
        }

        @Nullable
        public final String getAlbumImagePath() {
            return this.albumImagePath;
        }

        @Nullable
        public final String getAlbumName() {
            return this.albumName;
        }

        public final boolean getAlbumOnlyFlag() {
            return this.albumOnlyFlag;
        }

        public final int getArtistId() {
            return this.artistId;
        }

        @Nullable
        public final String getArtistImagePath() {
            return this.artistImagePath;
        }

        @Nullable
        public final ArrayList getArtistList() {
            return this.artistList;
        }

        @Nullable
        public final String getArtistName() {
            return this.artistName;
        }

        @Nullable
        public final String getArtistType() {
            return this.artistType;
        }

        public final boolean getDlAvailFlag() {
            return this.dlAvailFlag;
        }

        @Nullable
        public final String getDsplyIssueDate() {
            return this.dsplyIssueDate;
        }

        @Nullable
        public final String getDsplyPlayTime() {
            return this.dsplyPlayTime;
        }

        @Nullable
        public final String getDsplyVideoIssueDate() {
            return this.dsplyVideoIssueDate;
        }

        public final int getFanCnt() {
            return this.fanCnt;
        }

        public final boolean getFreezoneFlag() {
            return this.freezoneFlag;
        }

        @Nullable
        public final String getGnr() {
            return this.gnr;
        }

        public final boolean getHoldBackFlag() {
            return this.holdBackFlag;
        }

        @Nullable
        public final String getInnerVideoType() {
            return this.innerVideoType;
        }

        @Nullable
        public final String getIssueDate() {
            return this.issueDate;
        }

        @Nullable
        public final String getKakaoEmoticon() {
            return this.kakaoEmoticon;
        }

        @Nullable
        public final String getLinkUrl() {
            return this.linkUrl;
        }

        public final boolean getLiveFlag() {
            return this.liveFlag;
        }

        public final boolean getMvFlag() {
            return this.mvFlag;
        }

        @Nullable
        public final String getNationalityName() {
            return this.nationalityName;
        }

        @Nullable
        public final String getOriginalUrl() {
            return this.originalUrl;
        }

        public final boolean getServiceFlag() {
            return this.serviceFlag;
        }

        @Nullable
        public final String getSex() {
            return this.sex;
        }

        public final int getSongId() {
            return this.songId;
        }

        @Nullable
        public final String getSongName() {
            return this.songName;
        }

        public final boolean getStAvailFlag() {
            return this.stAvailFlag;
        }

        @Nullable
        public final String getTextCont() {
            return this.textCont;
        }

        @Nullable
        public final String getThumbUrl() {
            return this.thumbUrl;
        }

        public final int getTotalSongCnt() {
            return this.totalSongCnt;
        }

        public final boolean getVideoAdultFlag() {
            return this.videoAdultFlag;
        }

        public final int getVideoAgeLevel() {
            return this.videoAgeLevel;
        }

        @Nullable
        public final ArrayList getVideoAppearanceList() {
            return this.videoAppearanceList;
        }

        public final boolean getVideoFreezoneFlag() {
            return this.videoFreezoneFlag;
        }

        public final int getVideoHeight() {
            return this.videoHeight;
        }

        public final int getVideoId() {
            return this.videoId;
        }

        @Nullable
        public final String getVideoImagePath() {
            return this.videoImagePath;
        }

        @Nullable
        public final String getVideoIssueDate() {
            return this.videoIssueDate;
        }

        @Nullable
        public final String getVideoTitle() {
            return this.videoTitle;
        }

        @Nullable
        public final String getVideoUrl() {
            return this.videoUrl;
        }

        public final int getVideoViewCnt() {
            return this.videoViewCnt;
        }

        public final int getVideoWidth() {
            return this.videoWidth;
        }

        public final void setActTypeName(@Nullable String s) {
            this.actTypeName = s;
        }

        public final void setAdultFlag(boolean z) {
            this.adultFlag = z;
        }

        public final void setAlbumDiscountFlag(boolean z) {
            this.albumDiscountFlag = z;
        }

        public final void setAlbumId(int v) {
            this.albumId = v;
        }

        public final void setAlbumImagePath(@Nullable String s) {
            this.albumImagePath = s;
        }

        public final void setAlbumName(@Nullable String s) {
            this.albumName = s;
        }

        public final void setAlbumOnlyFlag(boolean z) {
            this.albumOnlyFlag = z;
        }

        public final void setArtistId(int v) {
            this.artistId = v;
        }

        public final void setArtistImagePath(@Nullable String s) {
            this.artistImagePath = s;
        }

        public final void setArtistList(@Nullable ArrayList arrayList0) {
            this.artistList = arrayList0;
        }

        public final void setArtistName(@Nullable String s) {
            this.artistName = s;
        }

        public final void setArtistType(@Nullable String s) {
            this.artistType = s;
        }

        public final void setDlAvailFlag(boolean z) {
            this.dlAvailFlag = z;
        }

        public final void setDsplyIssueDate(@Nullable String s) {
            this.dsplyIssueDate = s;
        }

        public final void setDsplyPlayTime(@Nullable String s) {
            this.dsplyPlayTime = s;
        }

        public final void setDsplyVideoIssueDate(@Nullable String s) {
            this.dsplyVideoIssueDate = s;
        }

        public final void setFanCnt(int v) {
            this.fanCnt = v;
        }

        public final void setFreezoneFlag(boolean z) {
            this.freezoneFlag = z;
        }

        public final void setGnr(@Nullable String s) {
            this.gnr = s;
        }

        public final void setHoldBackFlag(boolean z) {
            this.holdBackFlag = z;
        }

        public final void setInnerVideoType(@Nullable String s) {
            this.innerVideoType = s;
        }

        public final void setIssueDate(@Nullable String s) {
            this.issueDate = s;
        }

        public final void setKakaoEmoticon(@Nullable String s) {
            this.kakaoEmoticon = s;
        }

        public final void setLinkUrl(@Nullable String s) {
            this.linkUrl = s;
        }

        public final void setLiveFlag(boolean z) {
            this.liveFlag = z;
        }

        public final void setMvFlag(boolean z) {
            this.mvFlag = z;
        }

        public final void setNationalityName(@Nullable String s) {
            this.nationalityName = s;
        }

        public final void setOriginalUrl(@Nullable String s) {
            this.originalUrl = s;
        }

        public final void setServiceFlag(boolean z) {
            this.serviceFlag = z;
        }

        public final void setSex(@Nullable String s) {
            this.sex = s;
        }

        public final void setSongId(int v) {
            this.songId = v;
        }

        public final void setSongName(@Nullable String s) {
            this.songName = s;
        }

        public final void setStAvailFlag(boolean z) {
            this.stAvailFlag = z;
        }

        public final void setTextCont(@Nullable String s) {
            this.textCont = s;
        }

        public final void setThumbUrl(@Nullable String s) {
            this.thumbUrl = s;
        }

        public final void setTotalSongCnt(int v) {
            this.totalSongCnt = v;
        }

        public final void setVideoAdultFlag(boolean z) {
            this.videoAdultFlag = z;
        }

        public final void setVideoAgeLevel(int v) {
            this.videoAgeLevel = v;
        }

        public final void setVideoAppearanceList(@Nullable ArrayList arrayList0) {
            this.videoAppearanceList = arrayList0;
        }

        public final void setVideoFreezoneFlag(boolean z) {
            this.videoFreezoneFlag = z;
        }

        public final void setVideoHeight(int v) {
            this.videoHeight = v;
        }

        public final void setVideoId(int v) {
            this.videoId = v;
        }

        public final void setVideoImagePath(@Nullable String s) {
            this.videoImagePath = s;
        }

        public final void setVideoIssueDate(@Nullable String s) {
            this.videoIssueDate = s;
        }

        public final void setVideoTitle(@Nullable String s) {
            this.videoTitle = s;
        }

        public final void setVideoUrl(@Nullable String s) {
            this.videoUrl = s;
        }

        public final void setVideoViewCnt(int v) {
            this.videoViewCnt = v;
        }

        public final void setVideoWidth(int v) {
            this.videoWidth = v;
        }
    }

    @Metadata(d1 = {"\u0000\u001C\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0010\u000E\n\u0002\b\u0011\b\u0017\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003R\u001E\u0010\u0004\u001A\u00020\u00058\u0006@\u0006X\u0087\u000E¢\u0006\u000E\n\u0000\u001A\u0004\b\u0006\u0010\u0007\"\u0004\b\b\u0010\tR \u0010\n\u001A\u0004\u0018\u00010\u000B8\u0006@\u0006X\u0087\u000E¢\u0006\u000E\n\u0000\u001A\u0004\b\f\u0010\r\"\u0004\b\u000E\u0010\u000FR\u001E\u0010\u0010\u001A\u00020\u00058\u0006@\u0006X\u0087\u000E¢\u0006\u000E\n\u0000\u001A\u0004\b\u0011\u0010\u0007\"\u0004\b\u0012\u0010\tR \u0010\u0013\u001A\u0004\u0018\u00010\u000B8\u0006@\u0006X\u0087\u000E¢\u0006\u000E\n\u0000\u001A\u0004\b\u0014\u0010\r\"\u0004\b\u0015\u0010\u000FR \u0010\u0016\u001A\u0004\u0018\u00010\u000B8\u0006@\u0006X\u0087\u000E¢\u0006\u000E\n\u0000\u001A\u0004\b\u0017\u0010\r\"\u0004\b\u0018\u0010\u000FR \u0010\u0019\u001A\u0004\u0018\u00010\u000B8\u0006@\u0006X\u0087\u000E¢\u0006\u000E\n\u0000\u001A\u0004\b\u001A\u0010\r\"\u0004\b\u001B\u0010\u000F¨\u0006\u001C"}, d2 = {"Lcom/melon/net/res/v3/CommentApiModel$AttachSumryBase;", "Ljava/io/Serializable;", "<init>", "()V", "atachSeq", "", "getAtachSeq", "()I", "setAtachSeq", "(I)V", "attachType", "", "getAttachType", "()Ljava/lang/String;", "setAttachType", "(Ljava/lang/String;)V", "attachDsplyOrder", "getAttachDsplyOrder", "setAttachDsplyOrder", "attachValue", "getAttachValue", "setAttachValue", "attachThumbUrl", "getAttachThumbUrl", "setAttachThumbUrl", "attachVideoTitle", "getAttachVideoTitle", "setAttachVideoTitle", "app_playstoreProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 0x30)
    public static class AttachSumryBase implements Serializable {
        public static final int $stable = 8;
        @b("atachSeq")
        private int atachSeq;
        @b("atachDsplyOrder")
        private int attachDsplyOrder;
        @b("atachThumbUrl")
        @Nullable
        private String attachThumbUrl;
        @b("atachType")
        @Nullable
        private String attachType;
        @b("atachValue")
        @Nullable
        private String attachValue;
        @b("atachVideoTitle")
        @Nullable
        private String attachVideoTitle;

        public AttachSumryBase() {
            this.atachSeq = -1;
            this.attachDsplyOrder = -1;
        }

        public final int getAtachSeq() {
            return this.atachSeq;
        }

        public final int getAttachDsplyOrder() {
            return this.attachDsplyOrder;
        }

        @Nullable
        public final String getAttachThumbUrl() {
            return this.attachThumbUrl;
        }

        @Nullable
        public final String getAttachType() {
            return this.attachType;
        }

        @Nullable
        public final String getAttachValue() {
            return this.attachValue;
        }

        @Nullable
        public final String getAttachVideoTitle() {
            return this.attachVideoTitle;
        }

        public final void setAtachSeq(int v) {
            this.atachSeq = v;
        }

        public final void setAttachDsplyOrder(int v) {
            this.attachDsplyOrder = v;
        }

        public final void setAttachThumbUrl(@Nullable String s) {
            this.attachThumbUrl = s;
        }

        public final void setAttachType(@Nullable String s) {
            this.attachType = s;
        }

        public final void setAttachValue(@Nullable String s) {
            this.attachValue = s;
        }

        public final void setAttachVideoTitle(@Nullable String s) {
            this.attachVideoTitle = s;
        }
    }

    @Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000E\n\u0002\b\u0005\b\u0007\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003R \u0010\u0004\u001A\u0004\u0018\u00010\u00058\u0006@\u0006X\u0087\u000E¢\u0006\u000E\n\u0000\u001A\u0004\b\u0006\u0010\u0007\"\u0004\b\b\u0010\t¨\u0006\n"}, d2 = {"Lcom/melon/net/res/v3/CommentApiModel$BreakIPListBase;", "Ljava/io/Serializable;", "<init>", "()V", "breakIp", "", "getBreakIp", "()Ljava/lang/String;", "setBreakIp", "(Ljava/lang/String;)V", "app_playstoreProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 0x30)
    public static final class BreakIPListBase implements Serializable {
        public static final int $stable = 8;
        @b("breakIp")
        @Nullable
        private String breakIp;

        @Nullable
        public final String getBreakIp() {
            return this.breakIp;
        }

        public final void setBreakIp(@Nullable String s) {
            this.breakIp = s;
        }
    }

    @Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000E\n\u0002\b\u0005\b\u0007\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003R \u0010\u0004\u001A\u0004\u0018\u00010\u00058\u0006@\u0006X\u0087\u000E¢\u0006\u000E\n\u0000\u001A\u0004\b\u0006\u0010\u0007\"\u0004\b\b\u0010\t¨\u0006\n"}, d2 = {"Lcom/melon/net/res/v3/CommentApiModel$BreakWordlistBase;", "Ljava/io/Serializable;", "<init>", "()V", "breakWord", "", "getBreakWord", "()Ljava/lang/String;", "setBreakWord", "(Ljava/lang/String;)V", "app_playstoreProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 0x30)
    public static final class BreakWordlistBase implements Serializable {
        public static final int $stable = 8;
        @b("breakWord")
        @Nullable
        private String breakWord;

        @Nullable
        public final String getBreakWord() {
            return this.breakWord;
        }

        public final void setBreakWord(@Nullable String s) {
            this.breakWord = s;
        }
    }

    @Metadata(d1 = {"\u0000<\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\b\n\u0002\u0010\u000E\n\u0002\b\u000B\n\u0002\u0010\u000B\n\u0002\bh\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\t\b\u0017\u0018\u00002\u00020\u0001B\u0007\u00A2\u0006\u0004\b\u0002\u0010\u0003R\u001E\u0010\u0004\u001A\u00020\u00058\u0006@\u0006X\u0087\u000E\u00A2\u0006\u000E\n\u0000\u001A\u0004\b\u0006\u0010\u0007\"\u0004\b\b\u0010\tR\u001E\u0010\n\u001A\u00020\u00058\u0006@\u0006X\u0087\u000E\u00A2\u0006\u000E\n\u0000\u001A\u0004\b\u000B\u0010\u0007\"\u0004\b\f\u0010\tR \u0010\r\u001A\u0004\u0018\u00010\u000E8\u0006@\u0006X\u0087\u000E\u00A2\u0006\u000E\n\u0000\u001A\u0004\b\u000F\u0010\u0010\"\u0004\b\u0011\u0010\u0012R \u0010\u0013\u001A\u0004\u0018\u00010\u000E8\u0006@\u0006X\u0087\u000E\u00A2\u0006\u000E\n\u0000\u001A\u0004\b\u0014\u0010\u0010\"\u0004\b\u0015\u0010\u0012R\u001E\u0010\u0016\u001A\u00020\u00058\u0006@\u0006X\u0087\u000E\u00A2\u0006\u000E\n\u0000\u001A\u0004\b\u0017\u0010\u0007\"\u0004\b\u0018\u0010\tR\u001E\u0010\u0019\u001A\u00020\u001A8\u0006@\u0006X\u0087\u000E\u00A2\u0006\u000E\n\u0000\u001A\u0004\b\u001B\u0010\u001C\"\u0004\b\u001D\u0010\u001ER\u001E\u0010\u001F\u001A\u00020\u001A8\u0006@\u0006X\u0087\u000E\u00A2\u0006\u000E\n\u0000\u001A\u0004\b \u0010\u001C\"\u0004\b!\u0010\u001ER\u001E\u0010\"\u001A\u00020\u001A8\u0006@\u0006X\u0087\u000E\u00A2\u0006\u000E\n\u0000\u001A\u0004\b#\u0010\u001C\"\u0004\b$\u0010\u001ER\u001E\u0010%\u001A\u00020\u001A8\u0006@\u0006X\u0087\u000E\u00A2\u0006\u000E\n\u0000\u001A\u0004\b&\u0010\u001C\"\u0004\b\'\u0010\u001ER\u001E\u0010(\u001A\u00020\u001A8\u0006@\u0006X\u0087\u000E\u00A2\u0006\u000E\n\u0000\u001A\u0004\b)\u0010\u001C\"\u0004\b*\u0010\u001ER\u001A\u0010+\u001A\u00020\u001AX\u0086\u000E\u00A2\u0006\u000E\n\u0000\u001A\u0004\b,\u0010\u001C\"\u0004\b-\u0010\u001ER\u001E\u0010.\u001A\u00020\u001A8\u0006@\u0006X\u0087\u000E\u00A2\u0006\u000E\n\u0000\u001A\u0004\b/\u0010\u001C\"\u0004\b0\u0010\u001ER\u001E\u00101\u001A\u00020\u001A8\u0006@\u0006X\u0087\u000E\u00A2\u0006\u000E\n\u0000\u001A\u0004\b2\u0010\u001C\"\u0004\b3\u0010\u001ER\u001E\u00104\u001A\u00020\u001A8\u0006@\u0006X\u0087\u000E\u00A2\u0006\u000E\n\u0000\u001A\u0004\b5\u0010\u001C\"\u0004\b6\u0010\u001ER\u001E\u00107\u001A\u00020\u001A8\u0006@\u0006X\u0087\u000E\u00A2\u0006\u000E\n\u0000\u001A\u0004\b8\u0010\u001C\"\u0004\b9\u0010\u001ER\u001E\u0010:\u001A\u00020\u001A8\u0006@\u0006X\u0087\u000E\u00A2\u0006\u000E\n\u0000\u001A\u0004\b;\u0010\u001C\"\u0004\b<\u0010\u001ER\u001E\u0010=\u001A\u00020\u001A8\u0006@\u0006X\u0087\u000E\u00A2\u0006\u000E\n\u0000\u001A\u0004\b>\u0010\u001C\"\u0004\b?\u0010\u001ER\u001E\u0010@\u001A\u00020\u001A8\u0006@\u0006X\u0087\u000E\u00A2\u0006\u000E\n\u0000\u001A\u0004\bA\u0010\u001C\"\u0004\bB\u0010\u001ER\u001E\u0010C\u001A\u00020\u00058\u0006@\u0006X\u0087\u000E\u00A2\u0006\u000E\n\u0000\u001A\u0004\bD\u0010\u0007\"\u0004\bE\u0010\tR\u001E\u0010F\u001A\u00020\u00058\u0006@\u0006X\u0087\u000E\u00A2\u0006\u000E\n\u0000\u001A\u0004\bG\u0010\u0007\"\u0004\bH\u0010\tR\u001E\u0010I\u001A\u00020\u00058\u0006@\u0006X\u0087\u000E\u00A2\u0006\u000E\n\u0000\u001A\u0004\bJ\u0010\u0007\"\u0004\bK\u0010\tR\u001E\u0010L\u001A\u00020\u00058\u0006@\u0006X\u0087\u000E\u00A2\u0006\u000E\n\u0000\u001A\u0004\bM\u0010\u0007\"\u0004\bN\u0010\tR\u001E\u0010O\u001A\u00020\u00058\u0006@\u0006X\u0087\u000E\u00A2\u0006\u000E\n\u0000\u001A\u0004\bP\u0010\u0007\"\u0004\bQ\u0010\tR\u001E\u0010R\u001A\u00020\u00058\u0006@\u0006X\u0087\u000E\u00A2\u0006\u000E\n\u0000\u001A\u0004\bS\u0010\u0007\"\u0004\bT\u0010\tR\u001E\u0010U\u001A\u00020\u00058\u0006@\u0006X\u0087\u000E\u00A2\u0006\u000E\n\u0000\u001A\u0004\bV\u0010\u0007\"\u0004\bW\u0010\tR\u001E\u0010X\u001A\u00020\u001A8\u0006@\u0006X\u0087\u000E\u00A2\u0006\u000E\n\u0000\u001A\u0004\bY\u0010\u001C\"\u0004\bZ\u0010\u001ER\u001E\u0010[\u001A\u00020\u001A8\u0006@\u0006X\u0087\u000E\u00A2\u0006\u000E\n\u0000\u001A\u0004\b\\\u0010\u001C\"\u0004\b]\u0010\u001ER \u0010^\u001A\u0004\u0018\u00010\u000E8\u0006@\u0006X\u0087\u000E\u00A2\u0006\u000E\n\u0000\u001A\u0004\b_\u0010\u0010\"\u0004\b`\u0010\u0012R \u0010a\u001A\u0004\u0018\u00010\u000E8\u0006@\u0006X\u0087\u000E\u00A2\u0006\u000E\n\u0000\u001A\u0004\bb\u0010\u0010\"\u0004\bc\u0010\u0012R \u0010d\u001A\u0004\u0018\u00010\u000E8\u0006@\u0006X\u0087\u000E\u00A2\u0006\u000E\n\u0000\u001A\u0004\be\u0010\u0010\"\u0004\bf\u0010\u0012R \u0010g\u001A\u0004\u0018\u00010\u000E8\u0006@\u0006X\u0087\u000E\u00A2\u0006\u000E\n\u0000\u001A\u0004\bh\u0010\u0010\"\u0004\bi\u0010\u0012R \u0010j\u001A\u0004\u0018\u00010\u000E8\u0006@\u0006X\u0087\u000E\u00A2\u0006\u000E\n\u0000\u001A\u0004\bk\u0010\u0010\"\u0004\bl\u0010\u0012R \u0010m\u001A\u0004\u0018\u00010\u000E8\u0006@\u0006X\u0087\u000E\u00A2\u0006\u000E\n\u0000\u001A\u0004\bn\u0010\u0010\"\u0004\bo\u0010\u0012R\u001E\u0010p\u001A\u00020\u001A8\u0006@\u0006X\u0087\u000E\u00A2\u0006\u000E\n\u0000\u001A\u0004\bq\u0010\u001C\"\u0004\br\u0010\u001ER\u001E\u0010s\u001A\u00020\u001A8\u0006@\u0006X\u0087\u000E\u00A2\u0006\u000E\n\u0000\u001A\u0004\bt\u0010\u001C\"\u0004\bu\u0010\u001ER\u001E\u0010v\u001A\u00020\u001A8\u0006@\u0006X\u0087\u000E\u00A2\u0006\u000E\n\u0000\u001A\u0004\bw\u0010\u001C\"\u0004\bx\u0010\u001ER\u001E\u0010y\u001A\u00020\u001A8\u0006@\u0006X\u0087\u000E\u00A2\u0006\u000E\n\u0000\u001A\u0004\bz\u0010\u001C\"\u0004\b{\u0010\u001ER\u001E\u0010|\u001A\u00020\u001A8\u0006@\u0006X\u0087\u000E\u00A2\u0006\u000E\n\u0000\u001A\u0004\b}\u0010\u001C\"\u0004\b~\u0010\u001ER \u0010\u007F\u001A\u00020\u00058\u0006@\u0006X\u0087\u000E\u00A2\u0006\u0010\n\u0000\u001A\u0005\b\u0080\u0001\u0010\u0007\"\u0005\b\u0081\u0001\u0010\tR;\u0010\u0082\u0001\u001A\u001A\u0012\u0005\u0012\u00030\u0084\u0001\u0018\u00010\u0083\u0001j\f\u0012\u0005\u0012\u00030\u0084\u0001\u0018\u0001`\u0085\u00018\u0006@\u0006X\u0087\u000E\u00A2\u0006\u0012\n\u0000\u001A\u0006\b\u0086\u0001\u0010\u0087\u0001\"\u0006\b\u0088\u0001\u0010\u0089\u0001R;\u0010\u008A\u0001\u001A\u001A\u0012\u0005\u0012\u00030\u008B\u0001\u0018\u00010\u0083\u0001j\f\u0012\u0005\u0012\u00030\u008B\u0001\u0018\u0001`\u0085\u00018\u0006@\u0006X\u0087\u000E\u00A2\u0006\u0012\n\u0000\u001A\u0006\b\u008C\u0001\u0010\u0087\u0001\"\u0006\b\u008D\u0001\u0010\u0089\u0001R\u001D\u0010\u008E\u0001\u001A\u00020\u001AX\u0086\u000E\u00A2\u0006\u0010\n\u0000\u001A\u0005\b\u008F\u0001\u0010\u001C\"\u0005\b\u0090\u0001\u0010\u001ER\u001D\u0010\u0091\u0001\u001A\u00020\u001AX\u0086\u000E\u00A2\u0006\u0010\n\u0000\u001A\u0005\b\u0092\u0001\u0010\u001C\"\u0005\b\u0093\u0001\u0010\u001E\u00A8\u0006\u0094\u0001"}, d2 = {"Lcom/melon/net/res/v3/CommentApiModel$CmtInfoBase;", "Ljava/io/Serializable;", "<init>", "()V", "cmtNo", "", "getCmtNo", "()I", "setCmtNo", "(I)V", "cmtSeq", "getCmtSeq", "setCmtSeq", "cmtCont", "", "getCmtCont", "()Ljava/lang/String;", "setCmtCont", "(Ljava/lang/String;)V", "cmtSumry", "getCmtSumry", "setCmtSumry", "parntCmtSeq", "getParntCmtSeq", "setParntCmtSeq", "ancmFlag", "", "getAncmFlag", "()Z", "setAncmFlag", "(Z)V", "bestFlag", "getBestFlag", "setBestFlag", "mobleFlag", "getMobleFlag", "setMobleFlag", "secrtFlag", "getSecrtFlag", "setSecrtFlag", "breakFlag", "getBreakFlag", "setBreakFlag", "tempActFlag", "getTempActFlag", "setTempActFlag", "delFlag", "getDelFlag", "setDelFlag", "newFlag", "getNewFlag", "setNewFlag", "textAttachFlag", "getTextAttachFlag", "setTextAttachFlag", "musicAttachFlag", "getMusicAttachFlag", "setMusicAttachFlag", "vdoAttachFlag", "getVdoAttachFlag", "setVdoAttachFlag", "imageAttachFlag", "getImageAttachFlag", "setImageAttachFlag", "linkAttachFlag", "getLinkAttachFlag", "setLinkAttachFlag", "attachCnt", "getAttachCnt", "setAttachCnt", "recmCnt", "getRecmCnt", "setRecmCnt", "nonRecmCnt", "getNonRecmCnt", "setNonRecmCnt", "reprtCnt", "getReprtCnt", "setReprtCnt", "viewCnt", "getViewCnt", "setViewCnt", "totalAdcmtCnt", "getTotalAdcmtCnt", "setTotalAdcmtCnt", "validAdcmtCnt", "getValidAdcmtCnt", "setValidAdcmtCnt", "updtBtnFlag", "getUpdtBtnFlag", "setUpdtBtnFlag", "delBtnFlag", "getDelBtnFlag", "setDelBtnFlag", "dsplyDate", "getDsplyDate", "setDsplyDate", "dsplyDate2", "getDsplyDate2", "setDsplyDate2", "dsplyTime", "getDsplyTime", "setDsplyTime", "dsplyRegDate", "getDsplyRegDate", "setDsplyRegDate", "dsplyUpdtDate", "getDsplyUpdtDate", "setDsplyUpdtDate", "stickerSeq", "getStickerSeq", "setStickerSeq", "recmFlag", "getRecmFlag", "setRecmFlag", "memberRecmFlag", "getMemberRecmFlag", "setMemberRecmFlag", "memberNonRecmFlag", "getMemberNonRecmFlag", "setMemberNonRecmFlag", "memberReprtFlag", "getMemberReprtFlag", "setMemberReprtFlag", "memberCmtFlag", "getMemberCmtFlag", "setMemberCmtFlag", "melonDjLevel", "getMelonDjLevel", "setMelonDjLevel", "attachSumry", "Ljava/util/ArrayList;", "Lcom/melon/net/res/v3/CommentApiModel$AttachSumryBase;", "Lkotlin/collections/ArrayList;", "getAttachSumry", "()Ljava/util/ArrayList;", "setAttachSumry", "(Ljava/util/ArrayList;)V", "adcmtSumary", "Lcom/melon/net/res/v3/CommentApiModel$AdCmtSumaryBase;", "getAdcmtSumary", "setAdcmtSumary", "pinnedFlag", "getPinnedFlag", "setPinnedFlag", "playFlag", "getPlayFlag", "setPlayFlag", "app_playstoreProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 0x30)
    public static class CmtInfoBase implements Serializable {
        public static final int $stable = 8;
        @b("adcmtSumary")
        @Nullable
        private ArrayList adcmtSumary;
        @b("ancmFlag")
        private boolean ancmFlag;
        @b("atachCnt")
        private int attachCnt;
        @b("atachSumry")
        @Nullable
        private ArrayList attachSumry;
        @b("bestFlag")
        private boolean bestFlag;
        @b("breakFlag")
        private boolean breakFlag;
        @b(alternate = {"CMTCONT"}, value = "cmtCont")
        @Nullable
        private String cmtCont;
        @b(alternate = {"CMTNO"}, value = "cmtNo")
        private int cmtNo;
        @b(alternate = {"CMTSEQ"}, value = "cmtSeq")
        private int cmtSeq;
        @b("cmtSumry")
        @Nullable
        private String cmtSumry;
        @b("delBtnFlag")
        private boolean delBtnFlag;
        @b("delFlag")
        private boolean delFlag;
        @b("dsplyDate")
        @Nullable
        private String dsplyDate;
        @b("dsplyDate2")
        @Nullable
        private String dsplyDate2;
        @b("dsplyRegDate")
        @Nullable
        private String dsplyRegDate;
        @b("dsplyTime")
        @Nullable
        private String dsplyTime;
        @b("dsplyUpdtDate")
        @Nullable
        private String dsplyUpdtDate;
        @b("imageAtachFlag")
        private boolean imageAttachFlag;
        @b("linkAtachFlag")
        private boolean linkAttachFlag;
        @b("melonDjLevel")
        private int melonDjLevel;
        @b("memberCmtFlag")
        private boolean memberCmtFlag;
        @b("memberNonRecmFlag")
        private boolean memberNonRecmFlag;
        @b("memberRecmFlag")
        private boolean memberRecmFlag;
        @b("memberReprtFlag")
        private boolean memberReprtFlag;
        @b("mobleFlag")
        private boolean mobleFlag;
        @b("musicAtachFlag")
        private boolean musicAttachFlag;
        @b("newFlag")
        private boolean newFlag;
        @b("nonRecmCnt")
        private int nonRecmCnt;
        @b("parntCmtSeq")
        private int parntCmtSeq;
        private boolean pinnedFlag;
        private boolean playFlag;
        @b("recmCnt")
        private int recmCnt;
        @b("recmFlag")
        private boolean recmFlag;
        @b("reprtCnt")
        private int reprtCnt;
        @b("secrtFlag")
        private boolean secrtFlag;
        @b("stickerSeq")
        @Nullable
        private String stickerSeq;
        private boolean tempActFlag;
        @b("textAtachFlag")
        private boolean textAttachFlag;
        @b("totalAdcmtCnt")
        private int totalAdcmtCnt;
        @b("updtBtnFlag")
        private boolean updtBtnFlag;
        @b("validAdcmtCnt")
        private int validAdcmtCnt;
        @b("vdoAtachFlag")
        private boolean vdoAttachFlag;
        @b("viewCnt")
        private int viewCnt;

        public CmtInfoBase() {
            this.cmtNo = -1;
            this.cmtSeq = -1;
            this.parntCmtSeq = -1;
            this.attachCnt = -1;
            this.recmCnt = -1;
            this.nonRecmCnt = -1;
            this.reprtCnt = -1;
            this.viewCnt = -1;
            this.totalAdcmtCnt = -1;
            this.validAdcmtCnt = -1;
            this.melonDjLevel = -1;
        }

        @Nullable
        public final ArrayList getAdcmtSumary() {
            return this.adcmtSumary;
        }

        public final boolean getAncmFlag() {
            return this.ancmFlag;
        }

        public final int getAttachCnt() {
            return this.attachCnt;
        }

        @Nullable
        public final ArrayList getAttachSumry() {
            return this.attachSumry;
        }

        public final boolean getBestFlag() {
            return this.bestFlag;
        }

        public final boolean getBreakFlag() {
            return this.breakFlag;
        }

        @Nullable
        public final String getCmtCont() {
            return this.cmtCont;
        }

        public final int getCmtNo() {
            return this.cmtNo;
        }

        public final int getCmtSeq() {
            return this.cmtSeq;
        }

        @Nullable
        public final String getCmtSumry() {
            return this.cmtSumry;
        }

        public final boolean getDelBtnFlag() {
            return this.delBtnFlag;
        }

        public final boolean getDelFlag() {
            return this.delFlag;
        }

        @Nullable
        public final String getDsplyDate() {
            return this.dsplyDate;
        }

        @Nullable
        public final String getDsplyDate2() {
            return this.dsplyDate2;
        }

        @Nullable
        public final String getDsplyRegDate() {
            return this.dsplyRegDate;
        }

        @Nullable
        public final String getDsplyTime() {
            return this.dsplyTime;
        }

        @Nullable
        public final String getDsplyUpdtDate() {
            return this.dsplyUpdtDate;
        }

        public final boolean getImageAttachFlag() {
            return this.imageAttachFlag;
        }

        public final boolean getLinkAttachFlag() {
            return this.linkAttachFlag;
        }

        public final int getMelonDjLevel() {
            return this.melonDjLevel;
        }

        public final boolean getMemberCmtFlag() {
            return this.memberCmtFlag;
        }

        public final boolean getMemberNonRecmFlag() {
            return this.memberNonRecmFlag;
        }

        public final boolean getMemberRecmFlag() {
            return this.memberRecmFlag;
        }

        public final boolean getMemberReprtFlag() {
            return this.memberReprtFlag;
        }

        public final boolean getMobleFlag() {
            return this.mobleFlag;
        }

        public final boolean getMusicAttachFlag() {
            return this.musicAttachFlag;
        }

        public final boolean getNewFlag() {
            return this.newFlag;
        }

        public final int getNonRecmCnt() {
            return this.nonRecmCnt;
        }

        public final int getParntCmtSeq() {
            return this.parntCmtSeq;
        }

        public final boolean getPinnedFlag() {
            return this.pinnedFlag;
        }

        public final boolean getPlayFlag() {
            return this.playFlag;
        }

        public final int getRecmCnt() {
            return this.recmCnt;
        }

        public final boolean getRecmFlag() {
            return this.recmFlag;
        }

        public final int getReprtCnt() {
            return this.reprtCnt;
        }

        public final boolean getSecrtFlag() {
            return this.secrtFlag;
        }

        @Nullable
        public final String getStickerSeq() {
            return this.stickerSeq;
        }

        public final boolean getTempActFlag() {
            return this.tempActFlag;
        }

        public final boolean getTextAttachFlag() {
            return this.textAttachFlag;
        }

        public final int getTotalAdcmtCnt() {
            return this.totalAdcmtCnt;
        }

        public final boolean getUpdtBtnFlag() {
            return this.updtBtnFlag;
        }

        public final int getValidAdcmtCnt() {
            return this.validAdcmtCnt;
        }

        public final boolean getVdoAttachFlag() {
            return this.vdoAttachFlag;
        }

        public final int getViewCnt() {
            return this.viewCnt;
        }

        public final void setAdcmtSumary(@Nullable ArrayList arrayList0) {
            this.adcmtSumary = arrayList0;
        }

        public final void setAncmFlag(boolean z) {
            this.ancmFlag = z;
        }

        public final void setAttachCnt(int v) {
            this.attachCnt = v;
        }

        public final void setAttachSumry(@Nullable ArrayList arrayList0) {
            this.attachSumry = arrayList0;
        }

        public final void setBestFlag(boolean z) {
            this.bestFlag = z;
        }

        public final void setBreakFlag(boolean z) {
            this.breakFlag = z;
        }

        public final void setCmtCont(@Nullable String s) {
            this.cmtCont = s;
        }

        public final void setCmtNo(int v) {
            this.cmtNo = v;
        }

        public final void setCmtSeq(int v) {
            this.cmtSeq = v;
        }

        public final void setCmtSumry(@Nullable String s) {
            this.cmtSumry = s;
        }

        public final void setDelBtnFlag(boolean z) {
            this.delBtnFlag = z;
        }

        public final void setDelFlag(boolean z) {
            this.delFlag = z;
        }

        public final void setDsplyDate(@Nullable String s) {
            this.dsplyDate = s;
        }

        public final void setDsplyDate2(@Nullable String s) {
            this.dsplyDate2 = s;
        }

        public final void setDsplyRegDate(@Nullable String s) {
            this.dsplyRegDate = s;
        }

        public final void setDsplyTime(@Nullable String s) {
            this.dsplyTime = s;
        }

        public final void setDsplyUpdtDate(@Nullable String s) {
            this.dsplyUpdtDate = s;
        }

        public final void setImageAttachFlag(boolean z) {
            this.imageAttachFlag = z;
        }

        public final void setLinkAttachFlag(boolean z) {
            this.linkAttachFlag = z;
        }

        public final void setMelonDjLevel(int v) {
            this.melonDjLevel = v;
        }

        public final void setMemberCmtFlag(boolean z) {
            this.memberCmtFlag = z;
        }

        public final void setMemberNonRecmFlag(boolean z) {
            this.memberNonRecmFlag = z;
        }

        public final void setMemberRecmFlag(boolean z) {
            this.memberRecmFlag = z;
        }

        public final void setMemberReprtFlag(boolean z) {
            this.memberReprtFlag = z;
        }

        public final void setMobleFlag(boolean z) {
            this.mobleFlag = z;
        }

        public final void setMusicAttachFlag(boolean z) {
            this.musicAttachFlag = z;
        }

        public final void setNewFlag(boolean z) {
            this.newFlag = z;
        }

        public final void setNonRecmCnt(int v) {
            this.nonRecmCnt = v;
        }

        public final void setParntCmtSeq(int v) {
            this.parntCmtSeq = v;
        }

        public final void setPinnedFlag(boolean z) {
            this.pinnedFlag = z;
        }

        public final void setPlayFlag(boolean z) {
            this.playFlag = z;
        }

        public final void setRecmCnt(int v) {
            this.recmCnt = v;
        }

        public final void setRecmFlag(boolean z) {
            this.recmFlag = z;
        }

        public final void setReprtCnt(int v) {
            this.reprtCnt = v;
        }

        public final void setSecrtFlag(boolean z) {
            this.secrtFlag = z;
        }

        public final void setStickerSeq(@Nullable String s) {
            this.stickerSeq = s;
        }

        public final void setTempActFlag(boolean z) {
            this.tempActFlag = z;
        }

        public final void setTextAttachFlag(boolean z) {
            this.textAttachFlag = z;
        }

        public final void setTotalAdcmtCnt(int v) {
            this.totalAdcmtCnt = v;
        }

        public final void setUpdtBtnFlag(boolean z) {
            this.updtBtnFlag = z;
        }

        public final void setValidAdcmtCnt(int v) {
            this.validAdcmtCnt = v;
        }

        public final void setVdoAttachFlag(boolean z) {
            this.vdoAttachFlag = z;
        }

        public final void setViewCnt(int v) {
            this.viewCnt = v;
        }
    }

    @Metadata(d1 = {"\u0000@\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000B\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\b\b\u0017\u0018\u0000 )2\u00020\u00012\u00020\u0002:\u0001)B\u0007¢\u0006\u0004\b\u0003\u0010\u0004J\r\u0010\u0006\u001A\u00020\u0005¢\u0006\u0004\b\u0006\u0010\u0007J\r\u0010\b\u001A\u00020\u0005¢\u0006\u0004\b\b\u0010\u0007J\r\u0010\t\u001A\u00020\u0005¢\u0006\u0004\b\t\u0010\u0007J\r\u0010\n\u001A\u00020\u0005¢\u0006\u0004\b\n\u0010\u0007J\r\u0010\u000B\u001A\u00020\u0005¢\u0006\u0004\b\u000B\u0010\u0007J\u000F\u0010\r\u001A\u00020\fH\u0016¢\u0006\u0004\b\r\u0010\u000ER$\u0010\u0010\u001A\u0004\u0018\u00010\u000F8\u0006@\u0006X\u0087\u000E¢\u0006\u0012\n\u0004\b\u0010\u0010\u0011\u001A\u0004\b\u0012\u0010\u0013\"\u0004\b\u0014\u0010\u0015R$\u0010\u0017\u001A\u0004\u0018\u00010\u00168\u0006@\u0006X\u0087\u000E¢\u0006\u0012\n\u0004\b\u0017\u0010\u0018\u001A\u0004\b\u0019\u0010\u001A\"\u0004\b\u001B\u0010\u001CR$\u0010\u001D\u001A\u0004\u0018\u00010\u00168\u0006@\u0006X\u0087\u000E¢\u0006\u0012\n\u0004\b\u001D\u0010\u0018\u001A\u0004\b\u001E\u0010\u001A\"\u0004\b\u001F\u0010\u001CR6\u0010#\u001A\u0016\u0012\u0004\u0012\u00020!\u0018\u00010 j\n\u0012\u0004\u0012\u00020!\u0018\u0001`\"8\u0006@\u0006X\u0087\u000E¢\u0006\u0012\n\u0004\b#\u0010$\u001A\u0004\b%\u0010&\"\u0004\b\'\u0010(¨\u0006*"}, d2 = {"Lcom/melon/net/res/v3/CommentApiModel$CmtListBase;", "Ljava/io/Serializable;", "", "<init>", "()V", "", "isArtist", "()Z", "hasUserLink", "isBlocked", "isEditable", "isNotice", "Lba/s;", "toUiModel", "()Lba/s;", "Lcom/melon/net/res/v3/CommentApiModel$CmtInfoBase;", "cmtInfo", "Lcom/melon/net/res/v3/CommentApiModel$CmtInfoBase;", "getCmtInfo", "()Lcom/melon/net/res/v3/CommentApiModel$CmtInfoBase;", "setCmtInfo", "(Lcom/melon/net/res/v3/CommentApiModel$CmtInfoBase;)V", "Lcom/melon/net/res/v3/CommentApiModel$MemberInfoBase;", "memberInfo", "Lcom/melon/net/res/v3/CommentApiModel$MemberInfoBase;", "getMemberInfo", "()Lcom/melon/net/res/v3/CommentApiModel$MemberInfoBase;", "setMemberInfo", "(Lcom/melon/net/res/v3/CommentApiModel$MemberInfoBase;)V", "recommenderInfo", "getRecommenderInfo", "setRecommenderInfo", "Ljava/util/ArrayList;", "Lcom/melon/net/res/v3/CommentApiModel$AttachListBase;", "Lkotlin/collections/ArrayList;", "attachList", "Ljava/util/ArrayList;", "getAttachList", "()Ljava/util/ArrayList;", "setAttachList", "(Ljava/util/ArrayList;)V", "Companion", "app_playstoreProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 0x30)
    public static class CmtListBase implements Serializable {
        @Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\t\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003R\u000E\u0010\u0004\u001A\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000¨\u0006\u0006"}, d2 = {"Lcom/melon/net/res/v3/CommentApiModel$CmtListBase$Companion;", "", "<init>", "()V", "serialVersionUID", "", "app_playstoreProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 0x30)
        public static final class com.melon.net.res.v3.CommentApiModel.CmtListBase.Companion {
            private com.melon.net.res.v3.CommentApiModel.CmtListBase.Companion() {
            }

            public com.melon.net.res.v3.CommentApiModel.CmtListBase.Companion(DefaultConstructorMarker defaultConstructorMarker0) {
            }
        }

        public static final int $stable = 0;
        @NotNull
        public static final com.melon.net.res.v3.CommentApiModel.CmtListBase.Companion Companion = null;
        @b("atachList")
        @Nullable
        private ArrayList attachList;
        @b("cmtInfo")
        @Nullable
        private CmtInfoBase cmtInfo;
        @b("memberInfo")
        @Nullable
        private MemberInfoBase memberInfo;
        @b("recommenderInfo")
        @Nullable
        private MemberInfoBase recommenderInfo;
        private static final long serialVersionUID = 0x624026504F20A7AAL;

        static {
            CmtListBase.Companion = new com.melon.net.res.v3.CommentApiModel.CmtListBase.Companion(null);
            CmtListBase.$stable = 8;
        }

        @Nullable
        public final ArrayList getAttachList() {
            return this.attachList;
        }

        @Nullable
        public final CmtInfoBase getCmtInfo() {
            return this.cmtInfo;
        }

        @Nullable
        public final MemberInfoBase getMemberInfo() {
            return this.memberInfo;
        }

        @Nullable
        public final MemberInfoBase getRecommenderInfo() {
            return this.recommenderInfo;
        }

        public final boolean hasUserLink() {
            String s = this.memberInfo == null ? null : this.memberInfo.getMemberKey();
            if(s == null) {
                s = "";
            }
            return this.isArtist() || !StringIds.a(s, StringIds.c) && !StringIds.a(s, StringIds.i) && !StringIds.a(s, StringIds.k);
        }

        public final boolean isArtist() {
            return this.memberInfo == null ? false : this.memberInfo.getArtistFlag();
        }

        public final boolean isBlocked() {
            Boolean boolean0 = null;
            Boolean boolean1 = this.cmtInfo == null ? null : Boolean.valueOf(this.cmtInfo.getBreakFlag());
            CmtInfoBase commentApiModel$CmtInfoBase0 = this.cmtInfo;
            if(commentApiModel$CmtInfoBase0 != null) {
                boolean0 = Boolean.valueOf(commentApiModel$CmtInfoBase0.getDelFlag());
            }
            Iterable iterable0 = k.A(new Boolean[]{boolean1, boolean0});
            if(iterable0 instanceof Collection && ((Collection)iterable0).isEmpty()) {
                return false;
            }
            for(Object object0: iterable0) {
                if(q.b(((Boolean)object0), Boolean.TRUE)) {
                    return true;
                }
                if(false) {
                    break;
                }
            }
            return false;
        }

        // 去混淆评级： 低(40)
        public final boolean isEditable() {
            return this.cmtInfo != null && !this.cmtInfo.getDelFlag() && !this.cmtInfo.getAncmFlag() && this.cmtInfo.getMemberCmtFlag() && !this.cmtInfo.getTempActFlag();
        }

        public final boolean isNotice() {
            return this.cmtInfo == null ? false : this.cmtInfo.getAncmFlag();
        }

        public final void setAttachList(@Nullable ArrayList arrayList0) {
            this.attachList = arrayList0;
        }

        public final void setCmtInfo(@Nullable CmtInfoBase commentApiModel$CmtInfoBase0) {
            this.cmtInfo = commentApiModel$CmtInfoBase0;
        }

        public final void setMemberInfo(@Nullable MemberInfoBase commentApiModel$MemberInfoBase0) {
            this.memberInfo = commentApiModel$MemberInfoBase0;
        }

        public final void setRecommenderInfo(@Nullable MemberInfoBase commentApiModel$MemberInfoBase0) {
            this.recommenderInfo = commentApiModel$MemberInfoBase0;
        }

        @NotNull
        public s toUiModel() {
            String s11;
            boolean z16;
            int v4;
            boolean z15;
            boolean z14;
            boolean z13;
            String s8;
            boolean z12;
            int v3;
            String s6;
            String s5;
            String s4;
            String s3;
            String s2;
            int v = this.cmtInfo == null ? -1 : this.cmtInfo.getCmtSeq();
            boolean z = this.cmtInfo == null ? false : this.cmtInfo.getAncmFlag();
            String s = this.memberInfo == null ? null : this.memberInfo.getMemberKey();
            if(s == null) {
                s = "";
            }
            boolean z1 = this.isArtist();
            String s1 = String.valueOf((this.memberInfo == null ? null : this.memberInfo.getArtistId()));
            boolean z2 = this.cmtInfo == null ? false : this.cmtInfo.getBestFlag();
            boolean z3 = this.hasUserLink();
            boolean z4 = this.isBlocked();
            boolean z5 = this.cmtInfo == null ? false : this.cmtInfo.getTempActFlag();
            boolean z6 = this.isEditable();
            boolean z7 = g.M((this.memberInfo == null ? null : this.memberInfo.getMemberDjType()));
            int v1 = ResourceUtils.getDjIconColorId((this.memberInfo == null ? null : this.memberInfo.getMemberDjIconType()));
            boolean z8 = this.memberInfo == null ? false : this.memberInfo.getOfficial();
            boolean z9 = this.cmtInfo == null ? false : this.cmtInfo.getMemberCmtFlag();
            if(this.isArtist()) {
                s2 = s;
                s3 = this.memberInfo == null ? null : this.memberInfo.getArtistName();
                if(s3 == null) {
                    s3 = "";
                }
            }
            else {
                s2 = s;
                s3 = this.memberInfo == null ? null : this.memberInfo.getMemberNickname();
                if(s3 == null) {
                    s3 = "";
                }
            }
            if(this.isArtist()) {
                s4 = s3;
                s5 = this.memberInfo == null ? null : this.memberInfo.getArtistImage();
            }
            else {
                s4 = s3;
                s5 = this.memberInfo == null ? null : this.memberInfo.getMyPageImg();
            }
            s6 = s5 == null ? "" : s5;
            boolean z10 = this.cmtInfo == null ? false : this.cmtInfo.getPinnedFlag();
            boolean z11 = this.cmtInfo == null ? false : this.cmtInfo.getPlayFlag();
            int v2 = this.memberInfo == null ? -1 : this.memberInfo.getArtistTemperature();
            String s7 = this.cmtInfo == null ? null : this.cmtInfo.getCmtCont();
            if(s7 == null || s7.length() <= 0) {
                s7 = null;
            }
            if(s7 == null) {
                v3 = v1;
                z12 = z8;
                s8 = "";
            }
            else {
                v3 = v1;
                Pattern pattern0 = Pattern.compile("\n");
                z12 = z8;
                q.f(pattern0, "compile(...)");
                s8 = pattern0.matcher(s7).replaceAll("<br>");
                q.f(s8, "replaceAll(...)");
            }
            if((this.cmtInfo == null ? 0 : this.cmtInfo.getAttachCnt()) <= 0 || (this.attachList == null || this.attachList.isEmpty())) {
                z13 = z5;
                z14 = z6;
                z15 = z7;
                v4 = v3;
                z16 = false;
            }
            else {
                z13 = z5;
                z14 = z6;
                z15 = z7;
                v4 = v3;
                z16 = true;
            }
            String s9 = this.cmtInfo == null ? null : this.cmtInfo.getDsplyDate();
            if(s9 == null) {
                s9 = "";
            }
            CmtInfoBase commentApiModel$CmtInfoBase0 = this.cmtInfo;
            if(commentApiModel$CmtInfoBase0 == null) {
                s11 = "";
            }
            else {
                String s10 = commentApiModel$CmtInfoBase0.getDsplyDate2();
                s11 = s10 == null ? "" : s10;
            }
            int v5 = this.cmtInfo == null ? 0 : this.cmtInfo.getRecmCnt();
            int v6 = this.cmtInfo == null ? 0 : this.cmtInfo.getNonRecmCnt();
            boolean z17 = this.cmtInfo == null ? false : this.cmtInfo.getMemberRecmFlag();
            boolean z18 = this.cmtInfo == null ? false : this.cmtInfo.getMemberNonRecmFlag();
            int v7 = this.cmtInfo == null ? 0 : this.cmtInfo.getValidAdcmtCnt();
            ArrayList arrayList0 = this.attachList;
            if(arrayList0 == null) {
                arrayList0 = w.a;
            }
            ArrayList arrayList1 = new ArrayList(je.q.Q(10, arrayList0));
            for(Object object0: arrayList0) {
                arrayList1.add(((AttachListBase)object0).toUiModel());
            }
            ArrayList arrayList2 = new ArrayList();
            for(Object object1: arrayList1) {
                if(!(((AttachPropertyData)object1) instanceof None)) {
                    arrayList2.add(object1);
                }
            }
            boolean z19 = this.recommenderInfo != null;
            String s12 = this.recommenderInfo == null ? null : this.recommenderInfo.getMyPageImg();
            return s12 == null ? new CommentUiModel(v, z, s2, z1, s1, z2, z3, z4, z13, z14, z15, v4, z12, z9, s4, s6, 0, z10, z11, v2, s8, z16, s9, s11, v5, v6, z17, z18, v7, arrayList2, false, false, z19, "", 0xC0000000, 0, null) : new CommentUiModel(v, z, s2, z1, s1, z2, z3, z4, z13, z14, z15, v4, z12, z9, s4, s6, 0, z10, z11, v2, s8, z16, s9, s11, v5, v6, z17, z18, v7, arrayList2, false, false, z19, s12, 0xC0000000, 0, null);
        }
    }

    @Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000E\n\u0002\b\u0005\b\u0007\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003R \u0010\u0004\u001A\u0004\u0018\u00010\u00058\u0006@\u0006X\u0087\u000E¢\u0006\u000E\n\u0000\u001A\u0004\b\u0006\u0010\u0007\"\u0004\b\b\u0010\t¨\u0006\n"}, d2 = {"Lcom/melon/net/res/v3/CommentApiModel$GenrlLinkAttachBreakURLListBase;", "Ljava/io/Serializable;", "<init>", "()V", "genrlLinkAttachBreakUrl", "", "getGenrlLinkAttachBreakUrl", "()Ljava/lang/String;", "setGenrlLinkAttachBreakUrl", "(Ljava/lang/String;)V", "app_playstoreProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 0x30)
    public static final class GenrlLinkAttachBreakURLListBase implements Serializable {
        public static final int $stable = 8;
        @b("genrlLinkAtachBreakUrl")
        @Nullable
        private String genrlLinkAttachBreakUrl;

        @Nullable
        public final String getGenrlLinkAttachBreakUrl() {
            return this.genrlLinkAttachBreakUrl;
        }

        public final void setGenrlLinkAttachBreakUrl(@Nullable String s) {
            this.genrlLinkAttachBreakUrl = s;
        }
    }

    @Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000E\n\u0002\b\b\n\u0002\u0010\u000B\n\u0002\b\u0010\n\u0002\u0010\b\n\u0002\b)\b\u0017\u0018\u00002\u00020\u0001B\u0007\u00A2\u0006\u0004\b\u0002\u0010\u0003R \u0010\u0004\u001A\u0004\u0018\u00010\u00058\u0006@\u0006X\u0087\u000E\u00A2\u0006\u000E\n\u0000\u001A\u0004\b\u0006\u0010\u0007\"\u0004\b\b\u0010\tR \u0010\n\u001A\u0004\u0018\u00010\u00058\u0006@\u0006X\u0087\u000E\u00A2\u0006\u000E\n\u0000\u001A\u0004\b\u000B\u0010\u0007\"\u0004\b\f\u0010\tR\u001E\u0010\r\u001A\u00020\u000E8\u0006@\u0006X\u0087\u000E\u00A2\u0006\u000E\n\u0000\u001A\u0004\b\u000F\u0010\u0010\"\u0004\b\u0011\u0010\u0012R\u001E\u0010\u0013\u001A\u00020\u000E8\u0006@\u0006X\u0087\u000E\u00A2\u0006\u000E\n\u0000\u001A\u0004\b\u0014\u0010\u0010\"\u0004\b\u0015\u0010\u0012R\u001E\u0010\u0016\u001A\u00020\u000E8\u0006@\u0006X\u0087\u000E\u00A2\u0006\u000E\n\u0000\u001A\u0004\b\u0017\u0010\u0010\"\u0004\b\u0018\u0010\u0012R\u001E\u0010\u0019\u001A\u00020\u000E8\u0006@\u0006X\u0087\u000E\u00A2\u0006\u000E\n\u0000\u001A\u0004\b\u0019\u0010\u0010\"\u0004\b\u001A\u0010\u0012R\u001E\u0010\u001B\u001A\u00020\u000E8\u0006@\u0006X\u0087\u000E\u00A2\u0006\u000E\n\u0000\u001A\u0004\b\u001C\u0010\u0010\"\u0004\b\u001D\u0010\u0012R\u001E\u0010\u001E\u001A\u00020\u001F8\u0006@\u0006X\u0087\u000E\u00A2\u0006\u000E\n\u0000\u001A\u0004\b \u0010!\"\u0004\b\"\u0010#R \u0010$\u001A\u0004\u0018\u00010\u00058\u0006@\u0006X\u0087\u000E\u00A2\u0006\u000E\n\u0000\u001A\u0004\b%\u0010\u0007\"\u0004\b&\u0010\tR \u0010\'\u001A\u0004\u0018\u00010\u00058\u0006@\u0006X\u0087\u000E\u00A2\u0006\u000E\n\u0000\u001A\u0004\b(\u0010\u0007\"\u0004\b)\u0010\tR\u001E\u0010*\u001A\u00020\u001F8\u0006@\u0006X\u0087\u000E\u00A2\u0006\u000E\n\u0000\u001A\u0004\b+\u0010!\"\u0004\b,\u0010#R\u001E\u0010-\u001A\u00020\u001F8\u0006@\u0006X\u0087\u000E\u00A2\u0006\u000E\n\u0000\u001A\u0004\b.\u0010!\"\u0004\b/\u0010#R\u001E\u00100\u001A\u00020\u001F8\u0006@\u0006X\u0087\u000E\u00A2\u0006\u000E\n\u0000\u001A\u0004\b1\u0010!\"\u0004\b2\u0010#R \u00103\u001A\u0004\u0018\u00010\u00058\u0006@\u0006X\u0087\u000E\u00A2\u0006\u000E\n\u0000\u001A\u0004\b4\u0010\u0007\"\u0004\b5\u0010\tR \u00106\u001A\u0004\u0018\u00010\u00058\u0006@\u0006X\u0087\u000E\u00A2\u0006\u000E\n\u0000\u001A\u0004\b7\u0010\u0007\"\u0004\b8\u0010\tR \u00109\u001A\u0004\u0018\u00010\u00058\u0006@\u0006X\u0087\u000E\u00A2\u0006\u000E\n\u0000\u001A\u0004\b:\u0010\u0007\"\u0004\b;\u0010\tR\u001A\u0010<\u001A\u00020\u001FX\u0086\u000E\u00A2\u0006\u000E\n\u0000\u001A\u0004\b=\u0010!\"\u0004\b>\u0010#R\u001A\u0010?\u001A\u00020\u000EX\u0086\u000E\u00A2\u0006\u000E\n\u0000\u001A\u0004\b@\u0010\u0010\"\u0004\bA\u0010\u0012R\u001A\u0010B\u001A\u00020\u000EX\u0086\u000E\u00A2\u0006\u000E\n\u0000\u001A\u0004\bC\u0010\u0010\"\u0004\bD\u0010\u0012R\u001A\u0010E\u001A\u00020\u000EX\u0086\u000E\u00A2\u0006\u000E\n\u0000\u001A\u0004\bF\u0010\u0010\"\u0004\bG\u0010\u0012\u00A8\u0006H"}, d2 = {"Lcom/melon/net/res/v3/CommentApiModel$MemberInfoBase;", "Ljava/io/Serializable;", "<init>", "()V", "memberKey", "", "getMemberKey", "()Ljava/lang/String;", "setMemberKey", "(Ljava/lang/String;)V", "memberNickname", "getMemberNickname", "setMemberNickname", "melonDjFlag", "", "getMelonDjFlag", "()Z", "setMelonDjFlag", "(Z)V", "melonPowerDjFlag", "getMelonPowerDjFlag", "setMelonPowerDjFlag", "melonLabelDjFlag", "getMelonLabelDjFlag", "setMelonLabelDjFlag", "isEssential", "setEssential", "artistFlag", "getArtistFlag", "setArtistFlag", "artistId", "", "getArtistId", "()I", "setArtistId", "(I)V", "artistName", "getArtistName", "setArtistName", "artistImage", "getArtistImage", "setArtistImage", "memberStatus", "getMemberStatus", "setMemberStatus", "svcStatus", "getSvcStatus", "setSvcStatus", "melonDjLevel", "getMelonDjLevel", "setMelonDjLevel", "memberDjType", "getMemberDjType", "setMemberDjType", "myPageImg", "getMyPageImg", "setMyPageImg", "memberDjIconType", "getMemberDjIconType", "setMemberDjIconType", "artistTemperature", "getArtistTemperature", "setArtistTemperature", "artistFanFlag", "getArtistFanFlag", "setArtistFanFlag", "pinUseFlag", "getPinUseFlag", "setPinUseFlag", "official", "getOfficial", "setOfficial", "app_playstoreProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 0x30)
    public static class MemberInfoBase implements Serializable {
        public static final int $stable = 8;
        private boolean artistFanFlag;
        @b("artistFlag")
        private boolean artistFlag;
        @b("artistId")
        private int artistId;
        @b("artistImage")
        @Nullable
        private String artistImage;
        @b("artistName")
        @Nullable
        private String artistName;
        private int artistTemperature;
        @b("ISESSENTIAL")
        private boolean isEssential;
        @b("melonDjFlag")
        private boolean melonDjFlag;
        @b("melonDjLevel")
        private int melonDjLevel;
        @b("melonLabelDjFlag")
        private boolean melonLabelDjFlag;
        @b("melonPowerDjFlag")
        private boolean melonPowerDjFlag;
        @b(alternate = {"MEMBERDJICONTYPE"}, value = "memberDjIconType")
        @Nullable
        private String memberDjIconType;
        @b("memberDjType")
        @Nullable
        private String memberDjType;
        @b("memberKey")
        @Nullable
        private String memberKey;
        @b("memberNickname")
        @Nullable
        private String memberNickname;
        @b("memberStatus")
        private int memberStatus;
        @b("mypageImg")
        @Nullable
        private String myPageImg;
        private boolean official;
        private boolean pinUseFlag;
        @b("svcStatus")
        private int svcStatus;

        public MemberInfoBase() {
            this.artistId = -1;
            this.memberStatus = -1;
            this.svcStatus = -1;
            this.melonDjLevel = -1;
            this.artistTemperature = -1;
        }

        public final boolean getArtistFanFlag() {
            return this.artistFanFlag;
        }

        public final boolean getArtistFlag() {
            return this.artistFlag;
        }

        public final int getArtistId() {
            return this.artistId;
        }

        @Nullable
        public final String getArtistImage() {
            return this.artistImage;
        }

        @Nullable
        public final String getArtistName() {
            return this.artistName;
        }

        public final int getArtistTemperature() {
            return this.artistTemperature;
        }

        public final boolean getMelonDjFlag() {
            return this.melonDjFlag;
        }

        public final int getMelonDjLevel() {
            return this.melonDjLevel;
        }

        public final boolean getMelonLabelDjFlag() {
            return this.melonLabelDjFlag;
        }

        public final boolean getMelonPowerDjFlag() {
            return this.melonPowerDjFlag;
        }

        @Nullable
        public final String getMemberDjIconType() {
            return this.memberDjIconType;
        }

        @Nullable
        public final String getMemberDjType() {
            return this.memberDjType;
        }

        @Nullable
        public final String getMemberKey() {
            return this.memberKey;
        }

        @Nullable
        public final String getMemberNickname() {
            return this.memberNickname;
        }

        public final int getMemberStatus() {
            return this.memberStatus;
        }

        @Nullable
        public final String getMyPageImg() {
            return this.myPageImg;
        }

        public final boolean getOfficial() {
            return this.official;
        }

        public final boolean getPinUseFlag() {
            return this.pinUseFlag;
        }

        public final int getSvcStatus() {
            return this.svcStatus;
        }

        public final boolean isEssential() {
            return this.isEssential;
        }

        public final void setArtistFanFlag(boolean z) {
            this.artistFanFlag = z;
        }

        public final void setArtistFlag(boolean z) {
            this.artistFlag = z;
        }

        public final void setArtistId(int v) {
            this.artistId = v;
        }

        public final void setArtistImage(@Nullable String s) {
            this.artistImage = s;
        }

        public final void setArtistName(@Nullable String s) {
            this.artistName = s;
        }

        public final void setArtistTemperature(int v) {
            this.artistTemperature = v;
        }

        public final void setEssential(boolean z) {
            this.isEssential = z;
        }

        public final void setMelonDjFlag(boolean z) {
            this.melonDjFlag = z;
        }

        public final void setMelonDjLevel(int v) {
            this.melonDjLevel = v;
        }

        public final void setMelonLabelDjFlag(boolean z) {
            this.melonLabelDjFlag = z;
        }

        public final void setMelonPowerDjFlag(boolean z) {
            this.melonPowerDjFlag = z;
        }

        public final void setMemberDjIconType(@Nullable String s) {
            this.memberDjIconType = s;
        }

        public final void setMemberDjType(@Nullable String s) {
            this.memberDjType = s;
        }

        public final void setMemberKey(@Nullable String s) {
            this.memberKey = s;
        }

        public final void setMemberNickname(@Nullable String s) {
            this.memberNickname = s;
        }

        public final void setMemberStatus(int v) {
            this.memberStatus = v;
        }

        public final void setMyPageImg(@Nullable String s) {
            this.myPageImg = s;
        }

        public final void setOfficial(boolean z) {
            this.official = z;
        }

        public final void setPinUseFlag(boolean z) {
            this.pinUseFlag = z;
        }

        public final void setSvcStatus(int v) {
            this.svcStatus = v;
        }
    }

    @Metadata(d1 = {"\u0000\u001C\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0010\u000E\n\u0002\b\u001D\b\u0017\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003R\u001E\u0010\u0004\u001A\u00020\u00058\u0006@\u0006X\u0087\u000E¢\u0006\u000E\n\u0000\u001A\u0004\b\u0006\u0010\u0007\"\u0004\b\b\u0010\tR \u0010\n\u001A\u0004\u0018\u00010\u000B8\u0006@\u0006X\u0087\u000E¢\u0006\u000E\n\u0000\u001A\u0004\b\f\u0010\r\"\u0004\b\u000E\u0010\u000FR\u001E\u0010\u0010\u001A\u00020\u00058\u0006@\u0006X\u0087\u000E¢\u0006\u000E\n\u0000\u001A\u0004\b\u0011\u0010\u0007\"\u0004\b\u0012\u0010\tR\u001E\u0010\u0013\u001A\u00020\u00058\u0006@\u0006X\u0087\u000E¢\u0006\u000E\n\u0000\u001A\u0004\b\u0014\u0010\u0007\"\u0004\b\u0015\u0010\tR \u0010\u0016\u001A\u0004\u0018\u00010\u000B8\u0006@\u0006X\u0087\u000E¢\u0006\u000E\n\u0000\u001A\u0004\b\u0017\u0010\r\"\u0004\b\u0018\u0010\u000FR\u001E\u0010\u0019\u001A\u00020\u00058\u0006@\u0006X\u0087\u000E¢\u0006\u000E\n\u0000\u001A\u0004\b\u001A\u0010\u0007\"\u0004\b\u001B\u0010\tR\u001E\u0010\u001C\u001A\u00020\u00058\u0006@\u0006X\u0087\u000E¢\u0006\u000E\n\u0000\u001A\u0004\b\u001D\u0010\u0007\"\u0004\b\u001E\u0010\tR\u001E\u0010\u001F\u001A\u00020\u00058\u0006@\u0006X\u0087\u000E¢\u0006\u000E\n\u0000\u001A\u0004\b \u0010\u0007\"\u0004\b!\u0010\tR\u001E\u0010\"\u001A\u00020\u00058\u0006@\u0006X\u0087\u000E¢\u0006\u000E\n\u0000\u001A\u0004\b#\u0010\u0007\"\u0004\b$\u0010\tR\u001E\u0010%\u001A\u00020\u00058\u0006@\u0006X\u0087\u000E¢\u0006\u000E\n\u0000\u001A\u0004\b&\u0010\u0007\"\u0004\b\'\u0010\t¨\u0006("}, d2 = {"Lcom/melon/net/res/v3/CommentApiModel$PageInfoBase;", "Ljava/io/Serializable;", "<init>", "()V", "chnlSeq", "", "getChnlSeq", "()I", "setChnlSeq", "(I)V", "contsRefValue", "", "getContsRefValue", "()Ljava/lang/String;", "setContsRefValue", "(Ljava/lang/String;)V", "sortType", "getSortType", "setSortType", "srchType", "getSrchType", "setSrchType", "srchWord", "getSrchWord", "setSrchWord", "totalCnt", "getTotalCnt", "setTotalCnt", "validCnt", "getValidCnt", "setValidCnt", "startSeq", "getStartSeq", "setStartSeq", "pageSize", "getPageSize", "setPageSize", "pageNo", "getPageNo", "setPageNo", "app_playstoreProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 0x30)
    public static class PageInfoBase implements Serializable {
        public static final int $stable = 8;
        @b("chnlSeq")
        private int chnlSeq;
        @b("contsRefValue")
        @Nullable
        private String contsRefValue;
        @b("pageNo")
        private int pageNo;
        @b("pageSize")
        private int pageSize;
        @b("sortType")
        private int sortType;
        @b("srchType")
        private int srchType;
        @b("srchWord")
        @Nullable
        private String srchWord;
        @b("startSeq")
        private int startSeq;
        @b("totalCnt")
        private int totalCnt;
        @b("validCnt")
        private int validCnt;

        public PageInfoBase() {
            this.chnlSeq = -1;
            this.sortType = -1;
            this.srchType = -1;
            this.totalCnt = -1;
            this.validCnt = -1;
            this.startSeq = -1;
            this.pageSize = -1;
            this.pageNo = -1;
        }

        public final int getChnlSeq() {
            return this.chnlSeq;
        }

        @Nullable
        public final String getContsRefValue() {
            return this.contsRefValue;
        }

        public final int getPageNo() {
            return this.pageNo;
        }

        public final int getPageSize() {
            return this.pageSize;
        }

        public final int getSortType() {
            return this.sortType;
        }

        public final int getSrchType() {
            return this.srchType;
        }

        @Nullable
        public final String getSrchWord() {
            return this.srchWord;
        }

        public final int getStartSeq() {
            return this.startSeq;
        }

        public final int getTotalCnt() {
            return this.totalCnt;
        }

        public final int getValidCnt() {
            return this.validCnt;
        }

        public final void setChnlSeq(int v) {
            this.chnlSeq = v;
        }

        public final void setContsRefValue(@Nullable String s) {
            this.contsRefValue = s;
        }

        public final void setPageNo(int v) {
            this.pageNo = v;
        }

        public final void setPageSize(int v) {
            this.pageSize = v;
        }

        public final void setSortType(int v) {
            this.sortType = v;
        }

        public final void setSrchType(int v) {
            this.srchType = v;
        }

        public final void setSrchWord(@Nullable String s) {
            this.srchWord = s;
        }

        public final void setStartSeq(int v) {
            this.startSeq = v;
        }

        public final void setTotalCnt(int v) {
            this.totalCnt = v;
        }

        public final void setValidCnt(int v) {
            this.validCnt = v;
        }
    }

    @Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0005\b\u0017\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003R\u001E\u0010\u0004\u001A\u00020\u00058\u0006@\u0006X\u0087\u000E¢\u0006\u000E\n\u0000\u001A\u0004\b\u0006\u0010\u0007\"\u0004\b\b\u0010\t¨\u0006\n"}, d2 = {"Lcom/melon/net/res/v3/CommentApiModel$PageListBase;", "Ljava/io/Serializable;", "<init>", "()V", "page", "", "getPage", "()I", "setPage", "(I)V", "app_playstoreProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 0x30)
    public static class PageListBase implements Serializable {
        public static final int $stable = 8;
        @b("page")
        private int page;

        public PageListBase() {
            this.page = -1;
        }

        public final int getPage() {
            return this.page;
        }

        public final void setPage(int v) {
            this.page = v;
        }
    }

    @Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0014\n\u0002\u0010\u000B\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0007\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003R\u001E\u0010\u0004\u001A\u00020\u00058\u0006@\u0006X\u0087\u000E¢\u0006\u000E\n\u0000\u001A\u0004\b\u0006\u0010\u0007\"\u0004\b\b\u0010\tR\u001E\u0010\n\u001A\u00020\u00058\u0006@\u0006X\u0087\u000E¢\u0006\u000E\n\u0000\u001A\u0004\b\u000B\u0010\u0007\"\u0004\b\f\u0010\tR\u001E\u0010\r\u001A\u00020\u00058\u0006@\u0006X\u0087\u000E¢\u0006\u000E\n\u0000\u001A\u0004\b\u000E\u0010\u0007\"\u0004\b\u000F\u0010\tR\u001E\u0010\u0010\u001A\u00020\u00058\u0006@\u0006X\u0087\u000E¢\u0006\u000E\n\u0000\u001A\u0004\b\u0011\u0010\u0007\"\u0004\b\u0012\u0010\tR\u001E\u0010\u0013\u001A\u00020\u00058\u0006@\u0006X\u0087\u000E¢\u0006\u000E\n\u0000\u001A\u0004\b\u0014\u0010\u0007\"\u0004\b\u0015\u0010\tR\u001E\u0010\u0016\u001A\u00020\u00058\u0006@\u0006X\u0087\u000E¢\u0006\u000E\n\u0000\u001A\u0004\b\u0017\u0010\u0007\"\u0004\b\u0018\u0010\tR\u001E\u0010\u0019\u001A\u00020\u001A8\u0006@\u0006X\u0087\u000E¢\u0006\u000E\n\u0000\u001A\u0004\b\u001B\u0010\u001C\"\u0004\b\u001D\u0010\u001ER2\u0010\u001F\u001A\u0016\u0012\u0004\u0012\u00020!\u0018\u00010 j\n\u0012\u0004\u0012\u00020!\u0018\u0001`\"8\u0006@\u0006X\u0087\u000E¢\u0006\u000E\n\u0000\u001A\u0004\b#\u0010$\"\u0004\b%\u0010&¨\u0006\'"}, d2 = {"Lcom/melon/net/res/v3/CommentApiModel$PagingInfoBase;", "Ljava/io/Serializable;", "<init>", "()V", "firstPageNo", "", "getFirstPageNo", "()I", "setFirstPageNo", "(I)V", "lastPageNo", "getLastPageNo", "setLastPageNo", "prevPageNo", "getPrevPageNo", "setPrevPageNo", "nextPageNo", "getNextPageNo", "setNextPageNo", "prevGroupPageNo", "getPrevGroupPageNo", "setPrevGroupPageNo", "nextGroupPageNo", "getNextGroupPageNo", "setNextGroupPageNo", "more", "", "getMore", "()Z", "setMore", "(Z)V", "pageList", "Ljava/util/ArrayList;", "Lcom/melon/net/res/v3/CommentApiModel$PageListBase;", "Lkotlin/collections/ArrayList;", "getPageList", "()Ljava/util/ArrayList;", "setPageList", "(Ljava/util/ArrayList;)V", "app_playstoreProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 0x30)
    public static final class PagingInfoBase implements Serializable {
        public static final int $stable = 8;
        @b("firstPageNo")
        private int firstPageNo;
        @b("lastPageNo")
        private int lastPageNo;
        @b("more")
        private boolean more;
        @b("nextGroupPageNo")
        private int nextGroupPageNo;
        @b("nextPageNo")
        private int nextPageNo;
        @b("pageList")
        @Nullable
        private ArrayList pageList;
        @b("prevGroupPageNo")
        private int prevGroupPageNo;
        @b("prevPageNo")
        private int prevPageNo;

        public PagingInfoBase() {
            this.firstPageNo = -1;
            this.lastPageNo = -1;
            this.prevPageNo = -1;
            this.nextPageNo = -1;
            this.prevGroupPageNo = -1;
            this.nextGroupPageNo = -1;
        }

        public final int getFirstPageNo() {
            return this.firstPageNo;
        }

        public final int getLastPageNo() {
            return this.lastPageNo;
        }

        public final boolean getMore() {
            return this.more;
        }

        public final int getNextGroupPageNo() {
            return this.nextGroupPageNo;
        }

        public final int getNextPageNo() {
            return this.nextPageNo;
        }

        @Nullable
        public final ArrayList getPageList() {
            return this.pageList;
        }

        public final int getPrevGroupPageNo() {
            return this.prevGroupPageNo;
        }

        public final int getPrevPageNo() {
            return this.prevPageNo;
        }

        public final void setFirstPageNo(int v) {
            this.firstPageNo = v;
        }

        public final void setLastPageNo(int v) {
            this.lastPageNo = v;
        }

        public final void setMore(boolean z) {
            this.more = z;
        }

        public final void setNextGroupPageNo(int v) {
            this.nextGroupPageNo = v;
        }

        public final void setNextPageNo(int v) {
            this.nextPageNo = v;
        }

        public final void setPageList(@Nullable ArrayList arrayList0) {
            this.pageList = arrayList0;
        }

        public final void setPrevGroupPageNo(int v) {
            this.prevGroupPageNo = v;
        }

        public final void setPrevPageNo(int v) {
            this.prevPageNo = v;
        }
    }

    @Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000E\n\u0002\b\u0005\b\u0007\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003R \u0010\u0004\u001A\u0004\u0018\u00010\u00058\u0006@\u0006X\u0087\u000E¢\u0006\u000E\n\u0000\u001A\u0004\b\u0006\u0010\u0007\"\u0004\b\b\u0010\t¨\u0006\n"}, d2 = {"Lcom/melon/net/res/v3/CommentApiModel$VdoLinkAttachPermURLListBase;", "Ljava/io/Serializable;", "<init>", "()V", "vdoLinkAttachPermUrl", "", "getVdoLinkAttachPermUrl", "()Ljava/lang/String;", "setVdoLinkAttachPermUrl", "(Ljava/lang/String;)V", "app_playstoreProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 0x30)
    public static final class VdoLinkAttachPermURLListBase implements Serializable {
        public static final int $stable = 8;
        @b("vdoLinkAtachPermUrl")
        @Nullable
        private String vdoLinkAttachPermUrl;

        @Nullable
        public final String getVdoLinkAttachPermUrl() {
            return this.vdoLinkAttachPermUrl;
        }

        public final void setVdoLinkAttachPermUrl(@Nullable String s) {
            this.vdoLinkAttachPermUrl = s;
        }
    }

    @Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000E\n\u0002\b\u0005\b\u0017\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003R \u0010\u0004\u001A\u0004\u0018\u00010\u00058\u0006@\u0006X\u0087\u000E¢\u0006\u000E\n\u0000\u001A\u0004\b\u0006\u0010\u0007\"\u0004\b\b\u0010\t¨\u0006\n"}, d2 = {"Lcom/melon/net/res/v3/CommentApiModel$VideoAppearanceListBase;", "Ljava/io/Serializable;", "<init>", "()V", "videoAppearance", "", "getVideoAppearance", "()Ljava/lang/String;", "setVideoAppearance", "(Ljava/lang/String;)V", "app_playstoreProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 0x30)
    public static class VideoAppearanceListBase implements Serializable {
        public static final int $stable = 8;
        @b("videoAppearance")
        @Nullable
        private String videoAppearance;

        @Nullable
        public final String getVideoAppearance() {
            return this.videoAppearance;
        }

        public final void setVideoAppearance(@Nullable String s) {
            this.videoAppearance = s;
        }
    }

    public static final int $stable;

}


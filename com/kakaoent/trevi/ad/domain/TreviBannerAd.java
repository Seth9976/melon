package com.kakaoent.trevi.ad.domain;

import A7.d;
import H0.b;
import java.util.ArrayList;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.q;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000E\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0010\u000B\n\u0002\b\f\n\u0002\u0018\u0002\n\u0002\bI\b\u0086\b\u0018\u00002\u00020\u0001B\u00D5\u0002\u0012\n\b\u0002\u0010\u0002\u001A\u0004\u0018\u00010\u0003\u0012\b\b\u0002\u0010\u0004\u001A\u00020\u0005\u0012\u001C\b\u0002\u0010\u0006\u001A\u0016\u0012\u0004\u0012\u00020\b\u0018\u00010\u0007j\n\u0012\u0004\u0012\u00020\b\u0018\u0001`\t\u0012\n\b\u0002\u0010\n\u001A\u0004\u0018\u00010\u0003\u0012\b\b\u0002\u0010\u000B\u001A\u00020\u0005\u0012\n\b\u0002\u0010\f\u001A\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\r\u001A\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u000E\u001A\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u000F\u001A\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0010\u001A\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0011\u001A\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0012\u001A\u0004\u0018\u00010\u0003\u0012\b\b\u0002\u0010\u0013\u001A\u00020\u0014\u0012\n\b\u0002\u0010\u0015\u001A\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0016\u001A\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0017\u001A\u0004\u0018\u00010\u0003\u0012\b\b\u0002\u0010\u0018\u001A\u00020\u0005\u0012\b\b\u0002\u0010\u0019\u001A\u00020\u0014\u0012\b\b\u0002\u0010\u001A\u001A\u00020\u0014\u0012\b\b\u0002\u0010\u001B\u001A\u00020\u0014\u0012\b\b\u0002\u0010\u001C\u001A\u00020\u0014\u0012\n\b\u0002\u0010\u001D\u001A\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u001E\u001A\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u001F\u001A\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010 \u001A\u0004\u0018\u00010!\u0012\n\b\u0002\u0010\"\u001A\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010#\u001A\u0004\u0018\u00010\u0003\u0012\b\b\u0002\u0010$\u001A\u00020\u0014\u00A2\u0006\u0002\u0010%J\u000B\u0010I\u001A\u0004\u0018\u00010\u0003H\u00C6\u0003J\u000B\u0010J\u001A\u0004\u0018\u00010\u0003H\u00C6\u0003J\u000B\u0010K\u001A\u0004\u0018\u00010\u0003H\u00C6\u0003J\u000B\u0010L\u001A\u0004\u0018\u00010\u0003H\u00C6\u0003J\t\u0010M\u001A\u00020\u0014H\u00C6\u0003J\u000B\u0010N\u001A\u0004\u0018\u00010\u0003H\u00C6\u0003J\u000B\u0010O\u001A\u0004\u0018\u00010\u0003H\u00C6\u0003J\u000B\u0010P\u001A\u0004\u0018\u00010\u0003H\u00C6\u0003J\t\u0010Q\u001A\u00020\u0005H\u00C6\u0003J\t\u0010R\u001A\u00020\u0014H\u00C6\u0003J\t\u0010S\u001A\u00020\u0014H\u00C6\u0003J\t\u0010T\u001A\u00020\u0005H\u00C6\u0003J\t\u0010U\u001A\u00020\u0014H\u00C6\u0003J\t\u0010V\u001A\u00020\u0014H\u00C6\u0003J\u000B\u0010W\u001A\u0004\u0018\u00010\u0003H\u00C6\u0003J\u000B\u0010X\u001A\u0004\u0018\u00010\u0003H\u00C6\u0003J\u000B\u0010Y\u001A\u0004\u0018\u00010\u0003H\u00C6\u0003J\u000B\u0010Z\u001A\u0004\u0018\u00010!H\u00C6\u0003J\u000B\u0010[\u001A\u0004\u0018\u00010\u0003H\u00C6\u0003J\u000B\u0010\\\u001A\u0004\u0018\u00010\u0003H\u00C6\u0003J\t\u0010]\u001A\u00020\u0014H\u00C6\u0003J\u001D\u0010^\u001A\u0016\u0012\u0004\u0012\u00020\b\u0018\u00010\u0007j\n\u0012\u0004\u0012\u00020\b\u0018\u0001`\tH\u00C6\u0003J\u000B\u0010_\u001A\u0004\u0018\u00010\u0003H\u00C6\u0003J\t\u0010`\u001A\u00020\u0005H\u00C6\u0003J\u000B\u0010a\u001A\u0004\u0018\u00010\u0003H\u00C6\u0003J\u000B\u0010b\u001A\u0004\u0018\u00010\u0003H\u00C6\u0003J\u000B\u0010c\u001A\u0004\u0018\u00010\u0003H\u00C6\u0003J\u000B\u0010d\u001A\u0004\u0018\u00010\u0003H\u00C6\u0003J\u00D9\u0002\u0010e\u001A\u00020\u00002\n\b\u0002\u0010\u0002\u001A\u0004\u0018\u00010\u00032\b\b\u0002\u0010\u0004\u001A\u00020\u00052\u001C\b\u0002\u0010\u0006\u001A\u0016\u0012\u0004\u0012\u00020\b\u0018\u00010\u0007j\n\u0012\u0004\u0012\u00020\b\u0018\u0001`\t2\n\b\u0002\u0010\n\u001A\u0004\u0018\u00010\u00032\b\b\u0002\u0010\u000B\u001A\u00020\u00052\n\b\u0002\u0010\f\u001A\u0004\u0018\u00010\u00032\n\b\u0002\u0010\r\u001A\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u000E\u001A\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u000F\u001A\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0010\u001A\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0011\u001A\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0012\u001A\u0004\u0018\u00010\u00032\b\b\u0002\u0010\u0013\u001A\u00020\u00142\n\b\u0002\u0010\u0015\u001A\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0016\u001A\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0017\u001A\u0004\u0018\u00010\u00032\b\b\u0002\u0010\u0018\u001A\u00020\u00052\b\b\u0002\u0010\u0019\u001A\u00020\u00142\b\b\u0002\u0010\u001A\u001A\u00020\u00142\b\b\u0002\u0010\u001B\u001A\u00020\u00142\b\b\u0002\u0010\u001C\u001A\u00020\u00142\n\b\u0002\u0010\u001D\u001A\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u001E\u001A\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u001F\u001A\u0004\u0018\u00010\u00032\n\b\u0002\u0010 \u001A\u0004\u0018\u00010!2\n\b\u0002\u0010\"\u001A\u0004\u0018\u00010\u00032\n\b\u0002\u0010#\u001A\u0004\u0018\u00010\u00032\b\b\u0002\u0010$\u001A\u00020\u0014H\u00C6\u0001J\u0013\u0010f\u001A\u00020\u00142\b\u0010g\u001A\u0004\u0018\u00010\u0001H\u00D6\u0003J\t\u0010h\u001A\u00020\u0005H\u00D6\u0001J\t\u0010i\u001A\u00020\u0003H\u00D6\u0001R\u0013\u0010\u001D\u001A\u0004\u0018\u00010\u0003\u00A2\u0006\b\n\u0000\u001A\u0004\b&\u0010\'R\u0013\u0010#\u001A\u0004\u0018\u00010\u0003\u00A2\u0006\b\n\u0000\u001A\u0004\b(\u0010\'R\u0013\u0010\"\u001A\u0004\u0018\u00010\u0003\u00A2\u0006\b\n\u0000\u001A\u0004\b)\u0010\'R\u0013\u0010\u0010\u001A\u0004\u0018\u00010\u0003\u00A2\u0006\b\n\u0000\u001A\u0004\b*\u0010\'R\u0013\u0010\u0011\u001A\u0004\u0018\u00010\u0003\u00A2\u0006\b\n\u0000\u001A\u0004\b+\u0010\'R\u0011\u0010$\u001A\u00020\u0014\u00A2\u0006\b\n\u0000\u001A\u0004\b,\u0010-R\u0013\u0010\u000E\u001A\u0004\u0018\u00010\u0003\u00A2\u0006\b\n\u0000\u001A\u0004\b.\u0010\'R\u0011\u0010\u0013\u001A\u00020\u0014\u00A2\u0006\b\n\u0000\u001A\u0004\b/\u0010-R\u0013\u0010\r\u001A\u0004\u0018\u00010\u0003\u00A2\u0006\b\n\u0000\u001A\u0004\b0\u0010\'R\u0013\u0010\f\u001A\u0004\u0018\u00010\u0003\u00A2\u0006\b\n\u0000\u001A\u0004\b1\u0010\'R\u0013\u0010\n\u001A\u0004\u0018\u00010\u0003\u00A2\u0006\b\n\u0000\u001A\u0004\b2\u0010\'R\u0011\u0010\u001C\u001A\u00020\u0014\u00A2\u0006\b\n\u0000\u001A\u0004\b3\u0010-R\u0013\u0010\u0016\u001A\u0004\u0018\u00010\u0003\u00A2\u0006\b\n\u0000\u001A\u0004\b4\u0010\'R\u001C\u0010\u0012\u001A\u0004\u0018\u00010\u0003X\u0086\u000E\u00A2\u0006\u000E\n\u0000\u001A\u0004\b5\u0010\'\"\u0004\b6\u00107R\u0013\u0010\u0002\u001A\u0004\u0018\u00010\u0003\u00A2\u0006\b\n\u0000\u001A\u0004\b8\u0010\'R\u0011\u0010\u0004\u001A\u00020\u0005\u00A2\u0006\b\n\u0000\u001A\u0004\b9\u0010:R%\u0010\u0006\u001A\u0016\u0012\u0004\u0012\u00020\b\u0018\u00010\u0007j\n\u0012\u0004\u0012\u00020\b\u0018\u0001`\t\u00A2\u0006\b\n\u0000\u001A\u0004\b;\u0010<R\u0013\u0010\u001F\u001A\u0004\u0018\u00010\u0003\u00A2\u0006\b\n\u0000\u001A\u0004\b=\u0010\'R\u0013\u0010\u001E\u001A\u0004\u0018\u00010\u0003\u00A2\u0006\b\n\u0000\u001A\u0004\b>\u0010\'R\u0013\u0010 \u001A\u0004\u0018\u00010!\u00A2\u0006\b\n\u0000\u001A\u0004\b?\u0010@R\u0011\u0010\u000B\u001A\u00020\u0005\u00A2\u0006\b\n\u0000\u001A\u0004\bA\u0010:R\u0011\u0010\u0018\u001A\u00020\u0005\u00A2\u0006\b\n\u0000\u001A\u0004\bB\u0010:R\u0011\u0010\u0019\u001A\u00020\u0014\u00A2\u0006\b\n\u0000\u001A\u0004\bC\u0010-R\u0013\u0010\u0017\u001A\u0004\u0018\u00010\u0003\u00A2\u0006\b\n\u0000\u001A\u0004\bD\u0010\'R\u0013\u0010\u0015\u001A\u0004\u0018\u00010\u0003\u00A2\u0006\b\n\u0000\u001A\u0004\bE\u0010\'R\u0013\u0010\u000F\u001A\u0004\u0018\u00010\u0003\u00A2\u0006\b\n\u0000\u001A\u0004\bF\u0010\'R\u0011\u0010\u001A\u001A\u00020\u0014\u00A2\u0006\b\n\u0000\u001A\u0004\bG\u0010-R\u0011\u0010\u001B\u001A\u00020\u0014\u00A2\u0006\b\n\u0000\u001A\u0004\bH\u0010-\u00A8\u0006j"}, d2 = {"Lcom/kakaoent/trevi/ad/domain/TreviBannerAd;", "", "impId", "", "impType", "", "integrationInfos", "Ljava/util/ArrayList;", "Lcom/kakaoent/trevi/ad/domain/IntegrationInfo;", "Lkotlin/collections/ArrayList;", "dspContentId", "priority", "dspCampaignId", "dspAdId", "contentSeq", "thumbnailUrl", "backgroundImageUrl", "bgColor", "eventLink", "darkBackground", "", "startDate", "endDate", "rewardUnit", "rewardAmount", "rewardJoin", "userIdExists", "userTarget", "duplicateParticipation", "adTitle", "listTitle", "listDesc", "mission", "Lcom/kakaoent/trevi/ad/domain/Mission;", "askVimp", "askClick", "bridgeExists", "(Ljava/lang/String;ILjava/util/ArrayList;Ljava/lang/String;ILjava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;ZLjava/lang/String;Ljava/lang/String;Ljava/lang/String;IZZZZLjava/lang/String;Ljava/lang/String;Ljava/lang/String;Lcom/kakaoent/trevi/ad/domain/Mission;Ljava/lang/String;Ljava/lang/String;Z)V", "getAdTitle", "()Ljava/lang/String;", "getAskClick", "getAskVimp", "getBackgroundImageUrl", "getBgColor", "getBridgeExists", "()Z", "getContentSeq", "getDarkBackground", "getDspAdId", "getDspCampaignId", "getDspContentId", "getDuplicateParticipation", "getEndDate", "getEventLink", "setEventLink", "(Ljava/lang/String;)V", "getImpId", "getImpType", "()I", "getIntegrationInfos", "()Ljava/util/ArrayList;", "getListDesc", "getListTitle", "getMission", "()Lcom/kakaoent/trevi/ad/domain/Mission;", "getPriority", "getRewardAmount", "getRewardJoin", "getRewardUnit", "getStartDate", "getThumbnailUrl", "getUserIdExists", "getUserTarget", "component1", "component10", "component11", "component12", "component13", "component14", "component15", "component16", "component17", "component18", "component19", "component2", "component20", "component21", "component22", "component23", "component24", "component25", "component26", "component27", "component28", "component3", "component4", "component5", "component6", "component7", "component8", "component9", "copy", "equals", "other", "hashCode", "toString", "trevi-ad-android-sdk_release"}, k = 1, mv = {1, 9, 0}, xi = 0x30)
public final class TreviBannerAd {
    @Nullable
    private final String adTitle;
    @Nullable
    private final String askClick;
    @Nullable
    private final String askVimp;
    @Nullable
    private final String backgroundImageUrl;
    @Nullable
    private final String bgColor;
    private final boolean bridgeExists;
    @Nullable
    private final String contentSeq;
    private final boolean darkBackground;
    @Nullable
    private final String dspAdId;
    @Nullable
    private final String dspCampaignId;
    @Nullable
    private final String dspContentId;
    private final boolean duplicateParticipation;
    @Nullable
    private final String endDate;
    @Nullable
    private String eventLink;
    @Nullable
    private final String impId;
    private final int impType;
    @Nullable
    private final ArrayList integrationInfos;
    @Nullable
    private final String listDesc;
    @Nullable
    private final String listTitle;
    @Nullable
    private final Mission mission;
    private final int priority;
    private final int rewardAmount;
    private final boolean rewardJoin;
    @Nullable
    private final String rewardUnit;
    @Nullable
    private final String startDate;
    @Nullable
    private final String thumbnailUrl;
    private final boolean userIdExists;
    private final boolean userTarget;

    public TreviBannerAd() {
        this(null, 0, null, null, 0, null, null, null, null, null, null, null, false, null, null, null, 0, false, false, false, false, null, null, null, null, null, null, false, 0xFFFFFFF, null);
    }

    public TreviBannerAd(@Nullable String s, int v, @Nullable ArrayList arrayList0, @Nullable String s1, int v1, @Nullable String s2, @Nullable String s3, @Nullable String s4, @Nullable String s5, @Nullable String s6, @Nullable String s7, @Nullable String s8, boolean z, @Nullable String s9, @Nullable String s10, @Nullable String s11, int v2, boolean z1, boolean z2, boolean z3, boolean z4, @Nullable String s12, @Nullable String s13, @Nullable String s14, @Nullable Mission mission0, @Nullable String s15, @Nullable String s16, boolean z5) {
        this.impId = s;
        this.impType = v;
        this.integrationInfos = arrayList0;
        this.dspContentId = s1;
        this.priority = v1;
        this.dspCampaignId = s2;
        this.dspAdId = s3;
        this.contentSeq = s4;
        this.thumbnailUrl = s5;
        this.backgroundImageUrl = s6;
        this.bgColor = s7;
        this.eventLink = s8;
        this.darkBackground = z;
        this.startDate = s9;
        this.endDate = s10;
        this.rewardUnit = s11;
        this.rewardAmount = v2;
        this.rewardJoin = z1;
        this.userIdExists = z2;
        this.userTarget = z3;
        this.duplicateParticipation = z4;
        this.adTitle = s12;
        this.listTitle = s13;
        this.listDesc = s14;
        this.mission = mission0;
        this.askVimp = s15;
        this.askClick = s16;
        this.bridgeExists = z5;
    }

    public TreviBannerAd(String s, int v, ArrayList arrayList0, String s1, int v1, String s2, String s3, String s4, String s5, String s6, String s7, String s8, boolean z, String s9, String s10, String s11, int v2, boolean z1, boolean z2, boolean z3, boolean z4, String s12, String s13, String s14, Mission mission0, String s15, String s16, boolean z5, int v3, DefaultConstructorMarker defaultConstructorMarker0) {
        this(((v3 & 1) == 0 ? s : null), ((v3 & 2) == 0 ? v : 0), ((v3 & 4) == 0 ? arrayList0 : null), ((v3 & 8) == 0 ? s1 : null), ((v3 & 16) == 0 ? v1 : 0), ((v3 & 0x20) == 0 ? s2 : null), ((v3 & 0x40) == 0 ? s3 : null), ((v3 & 0x80) == 0 ? s4 : null), ((v3 & 0x100) == 0 ? s5 : null), ((v3 & 0x200) == 0 ? s6 : null), ((v3 & 0x400) == 0 ? s7 : null), ((v3 & 0x800) == 0 ? s8 : null), ((v3 & 0x1000) == 0 ? z : false), ((v3 & 0x2000) == 0 ? s9 : null), ((v3 & 0x4000) == 0 ? s10 : null), ((v3 & 0x8000) == 0 ? s11 : null), ((v3 & 0x10000) == 0 ? v2 : 0), ((v3 & 0x20000) == 0 ? z1 : false), ((v3 & 0x40000) == 0 ? z2 : false), ((v3 & 0x80000) == 0 ? z3 : false), ((v3 & 0x100000) == 0 ? z4 : false), ((v3 & 0x200000) == 0 ? s12 : null), ((v3 & 0x400000) == 0 ? s13 : null), ((v3 & 0x800000) == 0 ? s14 : null), ((v3 & 0x1000000) == 0 ? mission0 : null), ((v3 & 0x2000000) == 0 ? s15 : null), ((v3 & 0x4000000) == 0 ? s16 : null), ((v3 & 0x8000000) == 0 ? z5 : false));
    }

    @Nullable
    public final String component1() {
        return this.impId;
    }

    @Nullable
    public final String component10() {
        return this.backgroundImageUrl;
    }

    @Nullable
    public final String component11() {
        return this.bgColor;
    }

    @Nullable
    public final String component12() {
        return this.eventLink;
    }

    public final boolean component13() {
        return this.darkBackground;
    }

    @Nullable
    public final String component14() {
        return this.startDate;
    }

    @Nullable
    public final String component15() {
        return this.endDate;
    }

    @Nullable
    public final String component16() {
        return this.rewardUnit;
    }

    public final int component17() {
        return this.rewardAmount;
    }

    public final boolean component18() {
        return this.rewardJoin;
    }

    public final boolean component19() {
        return this.userIdExists;
    }

    public final int component2() {
        return this.impType;
    }

    public final boolean component20() {
        return this.userTarget;
    }

    public final boolean component21() {
        return this.duplicateParticipation;
    }

    @Nullable
    public final String component22() {
        return this.adTitle;
    }

    @Nullable
    public final String component23() {
        return this.listTitle;
    }

    @Nullable
    public final String component24() {
        return this.listDesc;
    }

    @Nullable
    public final Mission component25() {
        return this.mission;
    }

    @Nullable
    public final String component26() {
        return this.askVimp;
    }

    @Nullable
    public final String component27() {
        return this.askClick;
    }

    public final boolean component28() {
        return this.bridgeExists;
    }

    @Nullable
    public final ArrayList component3() {
        return this.integrationInfos;
    }

    @Nullable
    public final String component4() {
        return this.dspContentId;
    }

    public final int component5() {
        return this.priority;
    }

    @Nullable
    public final String component6() {
        return this.dspCampaignId;
    }

    @Nullable
    public final String component7() {
        return this.dspAdId;
    }

    @Nullable
    public final String component8() {
        return this.contentSeq;
    }

    @Nullable
    public final String component9() {
        return this.thumbnailUrl;
    }

    @NotNull
    public final TreviBannerAd copy(@Nullable String s, int v, @Nullable ArrayList arrayList0, @Nullable String s1, int v1, @Nullable String s2, @Nullable String s3, @Nullable String s4, @Nullable String s5, @Nullable String s6, @Nullable String s7, @Nullable String s8, boolean z, @Nullable String s9, @Nullable String s10, @Nullable String s11, int v2, boolean z1, boolean z2, boolean z3, boolean z4, @Nullable String s12, @Nullable String s13, @Nullable String s14, @Nullable Mission mission0, @Nullable String s15, @Nullable String s16, boolean z5) {
        return new TreviBannerAd(s, v, arrayList0, s1, v1, s2, s3, s4, s5, s6, s7, s8, z, s9, s10, s11, v2, z1, z2, z3, z4, s12, s13, s14, mission0, s15, s16, z5);
    }

    public static TreviBannerAd copy$default(TreviBannerAd treviBannerAd0, String s, int v, ArrayList arrayList0, String s1, int v1, String s2, String s3, String s4, String s5, String s6, String s7, String s8, boolean z, String s9, String s10, String s11, int v2, boolean z1, boolean z2, boolean z3, boolean z4, String s12, String s13, String s14, Mission mission0, String s15, String s16, boolean z5, int v3, Object object0) {
        String s17 = (v3 & 1) == 0 ? s : treviBannerAd0.impId;
        int v4 = (v3 & 2) == 0 ? v : treviBannerAd0.impType;
        ArrayList arrayList1 = (v3 & 4) == 0 ? arrayList0 : treviBannerAd0.integrationInfos;
        String s18 = (v3 & 8) == 0 ? s1 : treviBannerAd0.dspContentId;
        int v5 = (v3 & 16) == 0 ? v1 : treviBannerAd0.priority;
        String s19 = (v3 & 0x20) == 0 ? s2 : treviBannerAd0.dspCampaignId;
        String s20 = (v3 & 0x40) == 0 ? s3 : treviBannerAd0.dspAdId;
        String s21 = (v3 & 0x80) == 0 ? s4 : treviBannerAd0.contentSeq;
        String s22 = (v3 & 0x100) == 0 ? s5 : treviBannerAd0.thumbnailUrl;
        String s23 = (v3 & 0x200) == 0 ? s6 : treviBannerAd0.backgroundImageUrl;
        String s24 = (v3 & 0x400) == 0 ? s7 : treviBannerAd0.bgColor;
        String s25 = (v3 & 0x800) == 0 ? s8 : treviBannerAd0.eventLink;
        boolean z6 = (v3 & 0x1000) == 0 ? z : treviBannerAd0.darkBackground;
        String s26 = (v3 & 0x2000) == 0 ? s9 : treviBannerAd0.startDate;
        String s27 = (v3 & 0x4000) == 0 ? s10 : treviBannerAd0.endDate;
        String s28 = (v3 & 0x8000) == 0 ? s11 : treviBannerAd0.rewardUnit;
        int v6 = (v3 & 0x10000) == 0 ? v2 : treviBannerAd0.rewardAmount;
        boolean z7 = (v3 & 0x20000) == 0 ? z1 : treviBannerAd0.rewardJoin;
        boolean z8 = (v3 & 0x40000) == 0 ? z2 : treviBannerAd0.userIdExists;
        boolean z9 = (v3 & 0x80000) == 0 ? z3 : treviBannerAd0.userTarget;
        boolean z10 = (v3 & 0x100000) == 0 ? z4 : treviBannerAd0.duplicateParticipation;
        String s29 = (v3 & 0x200000) == 0 ? s12 : treviBannerAd0.adTitle;
        String s30 = (v3 & 0x400000) == 0 ? s13 : treviBannerAd0.listTitle;
        String s31 = (v3 & 0x800000) == 0 ? s14 : treviBannerAd0.listDesc;
        Mission mission1 = (v3 & 0x1000000) == 0 ? mission0 : treviBannerAd0.mission;
        String s32 = (v3 & 0x2000000) == 0 ? s15 : treviBannerAd0.askVimp;
        String s33 = (v3 & 0x4000000) == 0 ? s16 : treviBannerAd0.askClick;
        return (v3 & 0x8000000) == 0 ? treviBannerAd0.copy(s17, v4, arrayList1, s18, v5, s19, s20, s21, s22, s23, s24, s25, z6, s26, s27, s28, v6, z7, z8, z9, z10, s29, s30, s31, mission1, s32, s33, z5) : treviBannerAd0.copy(s17, v4, arrayList1, s18, v5, s19, s20, s21, s22, s23, s24, s25, z6, s26, s27, s28, v6, z7, z8, z9, z10, s29, s30, s31, mission1, s32, s33, treviBannerAd0.bridgeExists);
    }

    @Override
    public boolean equals(@Nullable Object object0) {
        if(this == object0) {
            return true;
        }
        if(!(object0 instanceof TreviBannerAd)) {
            return false;
        }
        TreviBannerAd treviBannerAd0 = (TreviBannerAd)object0;
        if(!q.b(this.impId, treviBannerAd0.impId)) {
            return false;
        }
        if(this.impType != treviBannerAd0.impType) {
            return false;
        }
        if(!q.b(this.integrationInfos, treviBannerAd0.integrationInfos)) {
            return false;
        }
        if(!q.b(this.dspContentId, treviBannerAd0.dspContentId)) {
            return false;
        }
        if(this.priority != treviBannerAd0.priority) {
            return false;
        }
        if(!q.b(this.dspCampaignId, treviBannerAd0.dspCampaignId)) {
            return false;
        }
        if(!q.b(this.dspAdId, treviBannerAd0.dspAdId)) {
            return false;
        }
        if(!q.b(this.contentSeq, treviBannerAd0.contentSeq)) {
            return false;
        }
        if(!q.b(this.thumbnailUrl, treviBannerAd0.thumbnailUrl)) {
            return false;
        }
        if(!q.b(this.backgroundImageUrl, treviBannerAd0.backgroundImageUrl)) {
            return false;
        }
        if(!q.b(this.bgColor, treviBannerAd0.bgColor)) {
            return false;
        }
        if(!q.b(this.eventLink, treviBannerAd0.eventLink)) {
            return false;
        }
        if(this.darkBackground != treviBannerAd0.darkBackground) {
            return false;
        }
        if(!q.b(this.startDate, treviBannerAd0.startDate)) {
            return false;
        }
        if(!q.b(this.endDate, treviBannerAd0.endDate)) {
            return false;
        }
        if(!q.b(this.rewardUnit, treviBannerAd0.rewardUnit)) {
            return false;
        }
        if(this.rewardAmount != treviBannerAd0.rewardAmount) {
            return false;
        }
        if(this.rewardJoin != treviBannerAd0.rewardJoin) {
            return false;
        }
        if(this.userIdExists != treviBannerAd0.userIdExists) {
            return false;
        }
        if(this.userTarget != treviBannerAd0.userTarget) {
            return false;
        }
        if(this.duplicateParticipation != treviBannerAd0.duplicateParticipation) {
            return false;
        }
        if(!q.b(this.adTitle, treviBannerAd0.adTitle)) {
            return false;
        }
        if(!q.b(this.listTitle, treviBannerAd0.listTitle)) {
            return false;
        }
        if(!q.b(this.listDesc, treviBannerAd0.listDesc)) {
            return false;
        }
        if(!q.b(this.mission, treviBannerAd0.mission)) {
            return false;
        }
        if(!q.b(this.askVimp, treviBannerAd0.askVimp)) {
            return false;
        }
        return q.b(this.askClick, treviBannerAd0.askClick) ? this.bridgeExists == treviBannerAd0.bridgeExists : false;
    }

    @Nullable
    public final String getAdTitle() {
        return this.adTitle;
    }

    @Nullable
    public final String getAskClick() {
        return this.askClick;
    }

    @Nullable
    public final String getAskVimp() {
        return this.askVimp;
    }

    @Nullable
    public final String getBackgroundImageUrl() {
        return this.backgroundImageUrl;
    }

    @Nullable
    public final String getBgColor() {
        return this.bgColor;
    }

    public final boolean getBridgeExists() {
        return this.bridgeExists;
    }

    @Nullable
    public final String getContentSeq() {
        return this.contentSeq;
    }

    public final boolean getDarkBackground() {
        return this.darkBackground;
    }

    @Nullable
    public final String getDspAdId() {
        return this.dspAdId;
    }

    @Nullable
    public final String getDspCampaignId() {
        return this.dspCampaignId;
    }

    @Nullable
    public final String getDspContentId() {
        return this.dspContentId;
    }

    public final boolean getDuplicateParticipation() {
        return this.duplicateParticipation;
    }

    @Nullable
    public final String getEndDate() {
        return this.endDate;
    }

    @Nullable
    public final String getEventLink() {
        return this.eventLink;
    }

    @Nullable
    public final String getImpId() {
        return this.impId;
    }

    public final int getImpType() {
        return this.impType;
    }

    @Nullable
    public final ArrayList getIntegrationInfos() {
        return this.integrationInfos;
    }

    @Nullable
    public final String getListDesc() {
        return this.listDesc;
    }

    @Nullable
    public final String getListTitle() {
        return this.listTitle;
    }

    @Nullable
    public final Mission getMission() {
        return this.mission;
    }

    public final int getPriority() {
        return this.priority;
    }

    public final int getRewardAmount() {
        return this.rewardAmount;
    }

    public final boolean getRewardJoin() {
        return this.rewardJoin;
    }

    @Nullable
    public final String getRewardUnit() {
        return this.rewardUnit;
    }

    @Nullable
    public final String getStartDate() {
        return this.startDate;
    }

    @Nullable
    public final String getThumbnailUrl() {
        return this.thumbnailUrl;
    }

    public final boolean getUserIdExists() {
        return this.userIdExists;
    }

    public final boolean getUserTarget() {
        return this.userTarget;
    }

    @Override
    public int hashCode() {
        int v = 0;
        int v1 = d.e(d.e(d.e(d.e(d.b(this.rewardAmount, (((d.e((((((((d.b(this.priority, ((d.b(this.impType, (this.impId == null ? 0 : this.impId.hashCode()) * 0x1F, 0x1F) + (this.integrationInfos == null ? 0 : this.integrationInfos.hashCode())) * 0x1F + (this.dspContentId == null ? 0 : this.dspContentId.hashCode())) * 0x1F, 0x1F) + (this.dspCampaignId == null ? 0 : this.dspCampaignId.hashCode())) * 0x1F + (this.dspAdId == null ? 0 : this.dspAdId.hashCode())) * 0x1F + (this.contentSeq == null ? 0 : this.contentSeq.hashCode())) * 0x1F + (this.thumbnailUrl == null ? 0 : this.thumbnailUrl.hashCode())) * 0x1F + (this.backgroundImageUrl == null ? 0 : this.backgroundImageUrl.hashCode())) * 0x1F + (this.bgColor == null ? 0 : this.bgColor.hashCode())) * 0x1F + (this.eventLink == null ? 0 : this.eventLink.hashCode())) * 0x1F, 0x1F, this.darkBackground) + (this.startDate == null ? 0 : this.startDate.hashCode())) * 0x1F + (this.endDate == null ? 0 : this.endDate.hashCode())) * 0x1F + (this.rewardUnit == null ? 0 : this.rewardUnit.hashCode())) * 0x1F, 0x1F), 0x1F, this.rewardJoin), 0x1F, this.userIdExists), 0x1F, this.userTarget), 0x1F, this.duplicateParticipation);
        int v2 = this.adTitle == null ? 0 : this.adTitle.hashCode();
        int v3 = this.listTitle == null ? 0 : this.listTitle.hashCode();
        int v4 = this.listDesc == null ? 0 : this.listDesc.hashCode();
        int v5 = this.mission == null ? 0 : this.mission.hashCode();
        int v6 = this.askVimp == null ? 0 : this.askVimp.hashCode();
        String s = this.askClick;
        if(s != null) {
            v = s.hashCode();
        }
        return Boolean.hashCode(this.bridgeExists) + ((((((v1 + v2) * 0x1F + v3) * 0x1F + v4) * 0x1F + v5) * 0x1F + v6) * 0x1F + v) * 0x1F;
    }

    public final void setEventLink(@Nullable String s) {
        this.eventLink = s;
    }

    @Override
    @NotNull
    public String toString() {
        StringBuilder stringBuilder0 = new StringBuilder("TreviBannerAd(impId=");
        stringBuilder0.append(this.impId);
        stringBuilder0.append(", impType=");
        stringBuilder0.append(this.impType);
        stringBuilder0.append(", integrationInfos=");
        stringBuilder0.append(this.integrationInfos);
        stringBuilder0.append(", dspContentId=");
        stringBuilder0.append(this.dspContentId);
        stringBuilder0.append(", priority=");
        stringBuilder0.append(this.priority);
        stringBuilder0.append(", dspCampaignId=");
        stringBuilder0.append(this.dspCampaignId);
        stringBuilder0.append(", dspAdId=");
        stringBuilder0.append(this.dspAdId);
        stringBuilder0.append(", contentSeq=");
        stringBuilder0.append(this.contentSeq);
        stringBuilder0.append(", thumbnailUrl=");
        stringBuilder0.append(this.thumbnailUrl);
        stringBuilder0.append(", backgroundImageUrl=");
        stringBuilder0.append(this.backgroundImageUrl);
        stringBuilder0.append(", bgColor=");
        stringBuilder0.append(this.bgColor);
        stringBuilder0.append(", eventLink=");
        stringBuilder0.append(this.eventLink);
        stringBuilder0.append(", darkBackground=");
        stringBuilder0.append(this.darkBackground);
        stringBuilder0.append(", startDate=");
        stringBuilder0.append(this.startDate);
        stringBuilder0.append(", endDate=");
        stringBuilder0.append(this.endDate);
        stringBuilder0.append(", rewardUnit=");
        stringBuilder0.append(this.rewardUnit);
        stringBuilder0.append(", rewardAmount=");
        stringBuilder0.append(this.rewardAmount);
        stringBuilder0.append(", rewardJoin=");
        stringBuilder0.append(this.rewardJoin);
        stringBuilder0.append(", userIdExists=");
        stringBuilder0.append(this.userIdExists);
        stringBuilder0.append(", userTarget=");
        stringBuilder0.append(this.userTarget);
        stringBuilder0.append(", duplicateParticipation=");
        stringBuilder0.append(this.duplicateParticipation);
        stringBuilder0.append(", adTitle=");
        stringBuilder0.append(this.adTitle);
        stringBuilder0.append(", listTitle=");
        stringBuilder0.append(this.listTitle);
        stringBuilder0.append(", listDesc=");
        stringBuilder0.append(this.listDesc);
        stringBuilder0.append(", mission=");
        stringBuilder0.append(this.mission);
        stringBuilder0.append(", askVimp=");
        stringBuilder0.append(this.askVimp);
        stringBuilder0.append(", askClick=");
        stringBuilder0.append(this.askClick);
        stringBuilder0.append(", bridgeExists=");
        return b.k(stringBuilder0, this.bridgeExists, ')');
    }
}


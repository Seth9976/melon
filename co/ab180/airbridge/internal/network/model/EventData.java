package co.ab180.airbridge.internal.network.model;

import co.ab180.airbridge.internal.parser.RuleWith;
import co.ab180.airbridge.internal.parser.d;
import co.ab180.airbridge.internal.parser.e.f;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.q;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@RuleWith(f.class)
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000@\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000E\n\u0002\b\u0002\n\u0002\u0010\t\n\u0002\b\u0005\n\u0002\u0010\u000B\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0015\n\u0002\u0010\b\n\u0002\b\u001E\b\u0081\b\u0018\u00002\u00020\u0001B\u00BB\u0001\u0012\u0006\u0010\u001F\u001A\u00020\u0002\u0012\u0006\u0010 \u001A\u00020\u0005\u0012\u0006\u0010!\u001A\u00020\u0005\u0012\n\b\u0002\u0010\"\u001A\u0004\u0018\u00010\u0002\u0012\n\b\u0002\u0010#\u001A\u0004\u0018\u00010\u0002\u0012\n\b\u0002\u0010$\u001A\u0004\u0018\u00010\u000B\u0012\n\b\u0002\u0010%\u001A\u0004\u0018\u00010\u0005\u0012\n\b\u0002\u0010&\u001A\u0004\u0018\u00010\u0005\u0012\n\b\u0002\u0010\'\u001A\u0004\u0018\u00010\u0002\u0012\n\b\u0002\u0010(\u001A\u0004\u0018\u00010\u0005\u0012\n\b\u0002\u0010)\u001A\u0004\u0018\u00010\u0002\u0012\n\b\u0002\u0010*\u001A\u0004\u0018\u00010\u0014\u0012\n\b\u0002\u0010+\u001A\u0004\u0018\u00010\u0017\u0012\n\b\u0002\u0010,\u001A\u0004\u0018\u00010\u0002\u0012\n\b\u0002\u0010-\u001A\u0004\u0018\u00010\u0002\u0012\n\b\u0002\u0010.\u001A\u0004\u0018\u00010\u001C\u00A2\u0006\u0004\bN\u0010OJ\u0010\u0010\u0003\u001A\u00020\u0002H\u00C6\u0003\u00A2\u0006\u0004\b\u0003\u0010\u0004J\u0010\u0010\u0006\u001A\u00020\u0005H\u00C6\u0003\u00A2\u0006\u0004\b\u0006\u0010\u0007J\u0010\u0010\b\u001A\u00020\u0005H\u00C6\u0003\u00A2\u0006\u0004\b\b\u0010\u0007J\u0012\u0010\t\u001A\u0004\u0018\u00010\u0002H\u00C6\u0003\u00A2\u0006\u0004\b\t\u0010\u0004J\u0012\u0010\n\u001A\u0004\u0018\u00010\u0002H\u00C6\u0003\u00A2\u0006\u0004\b\n\u0010\u0004J\u0012\u0010\f\u001A\u0004\u0018\u00010\u000BH\u00C6\u0003\u00A2\u0006\u0004\b\f\u0010\rJ\u0012\u0010\u000E\u001A\u0004\u0018\u00010\u0005H\u00C6\u0003\u00A2\u0006\u0004\b\u000E\u0010\u000FJ\u0012\u0010\u0010\u001A\u0004\u0018\u00010\u0005H\u00C6\u0003\u00A2\u0006\u0004\b\u0010\u0010\u000FJ\u0012\u0010\u0011\u001A\u0004\u0018\u00010\u0002H\u00C6\u0003\u00A2\u0006\u0004\b\u0011\u0010\u0004J\u0012\u0010\u0012\u001A\u0004\u0018\u00010\u0005H\u00C6\u0003\u00A2\u0006\u0004\b\u0012\u0010\u000FJ\u0012\u0010\u0013\u001A\u0004\u0018\u00010\u0002H\u00C6\u0003\u00A2\u0006\u0004\b\u0013\u0010\u0004J\u0012\u0010\u0015\u001A\u0004\u0018\u00010\u0014H\u00C6\u0003\u00A2\u0006\u0004\b\u0015\u0010\u0016J\u0012\u0010\u0018\u001A\u0004\u0018\u00010\u0017H\u00C6\u0003\u00A2\u0006\u0004\b\u0018\u0010\u0019J\u0012\u0010\u001A\u001A\u0004\u0018\u00010\u0002H\u00C6\u0003\u00A2\u0006\u0004\b\u001A\u0010\u0004J\u0012\u0010\u001B\u001A\u0004\u0018\u00010\u0002H\u00C6\u0003\u00A2\u0006\u0004\b\u001B\u0010\u0004J\u0012\u0010\u001D\u001A\u0004\u0018\u00010\u001CH\u00C6\u0003\u00A2\u0006\u0004\b\u001D\u0010\u001EJ\u00CA\u0001\u0010/\u001A\u00020\u00002\b\b\u0002\u0010\u001F\u001A\u00020\u00022\b\b\u0002\u0010 \u001A\u00020\u00052\b\b\u0002\u0010!\u001A\u00020\u00052\n\b\u0002\u0010\"\u001A\u0004\u0018\u00010\u00022\n\b\u0002\u0010#\u001A\u0004\u0018\u00010\u00022\n\b\u0002\u0010$\u001A\u0004\u0018\u00010\u000B2\n\b\u0002\u0010%\u001A\u0004\u0018\u00010\u00052\n\b\u0002\u0010&\u001A\u0004\u0018\u00010\u00052\n\b\u0002\u0010\'\u001A\u0004\u0018\u00010\u00022\n\b\u0002\u0010(\u001A\u0004\u0018\u00010\u00052\n\b\u0002\u0010)\u001A\u0004\u0018\u00010\u00022\n\b\u0002\u0010*\u001A\u0004\u0018\u00010\u00142\n\b\u0002\u0010+\u001A\u0004\u0018\u00010\u00172\n\b\u0002\u0010,\u001A\u0004\u0018\u00010\u00022\n\b\u0002\u0010-\u001A\u0004\u0018\u00010\u00022\n\b\u0002\u0010.\u001A\u0004\u0018\u00010\u001CH\u00C6\u0001\u00A2\u0006\u0004\b/\u00100J\u0010\u00101\u001A\u00020\u0002H\u00D6\u0001\u00A2\u0006\u0004\b1\u0010\u0004J\u0010\u00103\u001A\u000202H\u00D6\u0001\u00A2\u0006\u0004\b3\u00104J\u001A\u00106\u001A\u00020\u000B2\b\u00105\u001A\u0004\u0018\u00010\u0001H\u00D6\u0003\u00A2\u0006\u0004\b6\u00107R\u001E\u0010$\u001A\u0004\u0018\u00010\u000B8\u0006@\u0007X\u0087\u0004\u00A2\u0006\f\n\u0004\b$\u00108\u001A\u0004\b$\u0010\rR\u001E\u0010,\u001A\u0004\u0018\u00010\u00028\u0006@\u0007X\u0087\u0004\u00A2\u0006\f\n\u0004\b,\u00109\u001A\u0004\b:\u0010\u0004R\u001E\u0010*\u001A\u0004\u0018\u00010\u00148\u0006@\u0007X\u0087\u0004\u00A2\u0006\f\n\u0004\b*\u0010;\u001A\u0004\b<\u0010\u0016R\u001C\u0010!\u001A\u00020\u00058\u0006@\u0007X\u0087\u0004\u00A2\u0006\f\n\u0004\b!\u0010=\u001A\u0004\b>\u0010\u0007R\u001E\u0010#\u001A\u0004\u0018\u00010\u00028\u0006@\u0007X\u0087\u0004\u00A2\u0006\f\n\u0004\b#\u00109\u001A\u0004\b?\u0010\u0004R\u001C\u0010 \u001A\u00020\u00058\u0006@\u0007X\u0087\u0004\u00A2\u0006\f\n\u0004\b \u0010=\u001A\u0004\b@\u0010\u0007R\u001E\u0010\'\u001A\u0004\u0018\u00010\u00028\u0006@\u0007X\u0087\u0004\u00A2\u0006\f\n\u0004\b\'\u00109\u001A\u0004\bA\u0010\u0004R\u001E\u0010&\u001A\u0004\u0018\u00010\u00058\u0006@\u0007X\u0087\u0004\u00A2\u0006\f\n\u0004\b&\u0010B\u001A\u0004\bC\u0010\u000FR\u001E\u0010(\u001A\u0004\u0018\u00010\u00058\u0006@\u0007X\u0087\u0004\u00A2\u0006\f\n\u0004\b(\u0010B\u001A\u0004\bD\u0010\u000FR\u001C\u0010\u001F\u001A\u00020\u00028\u0006@\u0007X\u0087\u0004\u00A2\u0006\f\n\u0004\b\u001F\u00109\u001A\u0004\bE\u0010\u0004R\u001E\u0010\"\u001A\u0004\u0018\u00010\u00028\u0006@\u0007X\u0087\u0004\u00A2\u0006\f\n\u0004\b\"\u00109\u001A\u0004\bF\u0010\u0004R\u001E\u0010)\u001A\u0004\u0018\u00010\u00028\u0006@\u0007X\u0087\u0004\u00A2\u0006\f\n\u0004\b)\u00109\u001A\u0004\bG\u0010\u0004R\u001E\u0010-\u001A\u0004\u0018\u00010\u00028\u0006@\u0007X\u0087\u0004\u00A2\u0006\f\n\u0004\b-\u00109\u001A\u0004\bH\u0010\u0004R\u001E\u0010+\u001A\u0004\u0018\u00010\u00178\u0006@\u0007X\u0087\u0004\u00A2\u0006\f\n\u0004\b+\u0010I\u001A\u0004\bJ\u0010\u0019R\u001E\u0010%\u001A\u0004\u0018\u00010\u00058\u0006@\u0007X\u0087\u0004\u00A2\u0006\f\n\u0004\b%\u0010B\u001A\u0004\bK\u0010\u000FR\u001E\u0010.\u001A\u0004\u0018\u00010\u001C8\u0006@\u0007X\u0087\u0004\u00A2\u0006\f\n\u0004\b.\u0010L\u001A\u0004\bM\u0010\u001E\u00A8\u0006P"}, d2 = {"Lco/ab180/airbridge/internal/network/model/EventData;", "", "", "component1", "()Ljava/lang/String;", "", "component2", "()J", "component3", "component4", "component5", "", "component6", "()Ljava/lang/Boolean;", "component7", "()Ljava/lang/Long;", "component8", "component9", "component10", "component11", "Lco/ab180/airbridge/internal/network/model/MetaInstallReferrerData;", "component12", "()Lco/ab180/airbridge/internal/network/model/MetaInstallReferrerData;", "Lco/ab180/airbridge/internal/network/model/InstallReferrerData;", "component13", "()Lco/ab180/airbridge/internal/network/model/InstallReferrerData;", "component14", "component15", "Lco/ab180/airbridge/internal/network/model/GoalData;", "component16", "()Lco/ab180/airbridge/internal/network/model/GoalData;", "sessionId", "sessionStartTimestamp", "sessionTimeoutMillis", "triggeredBy", "deeplink", "isUniversalTrackingLink", "installTimestamp", "installBeginTimestamp", "referrer", "referrerClickTimestamp", "pushToken", "metaInstallReferrerData", "installReferrerData", "appMarketIdentifier", "appStorePackageName", "goalData", "copy", "(Ljava/lang/String;JJLjava/lang/String;Ljava/lang/String;Ljava/lang/Boolean;Ljava/lang/Long;Ljava/lang/Long;Ljava/lang/String;Ljava/lang/Long;Ljava/lang/String;Lco/ab180/airbridge/internal/network/model/MetaInstallReferrerData;Lco/ab180/airbridge/internal/network/model/InstallReferrerData;Ljava/lang/String;Ljava/lang/String;Lco/ab180/airbridge/internal/network/model/GoalData;)Lco/ab180/airbridge/internal/network/model/EventData;", "toString", "", "hashCode", "()I", "other", "equals", "(Ljava/lang/Object;)Z", "Ljava/lang/Boolean;", "Ljava/lang/String;", "getAppMarketIdentifier", "Lco/ab180/airbridge/internal/network/model/MetaInstallReferrerData;", "getMetaInstallReferrerData", "J", "getSessionTimeoutMillis", "getDeeplink", "getSessionStartTimestamp", "getReferrer", "Ljava/lang/Long;", "getInstallBeginTimestamp", "getReferrerClickTimestamp", "getSessionId", "getTriggeredBy", "getPushToken", "getAppStorePackageName", "Lco/ab180/airbridge/internal/network/model/InstallReferrerData;", "getInstallReferrerData", "getInstallTimestamp", "Lco/ab180/airbridge/internal/network/model/GoalData;", "getGoalData", "<init>", "(Ljava/lang/String;JJLjava/lang/String;Ljava/lang/String;Ljava/lang/Boolean;Ljava/lang/Long;Ljava/lang/Long;Ljava/lang/String;Ljava/lang/Long;Ljava/lang/String;Lco/ab180/airbridge/internal/network/model/MetaInstallReferrerData;Lco/ab180/airbridge/internal/network/model/InstallReferrerData;Ljava/lang/String;Ljava/lang/String;Lco/ab180/airbridge/internal/network/model/GoalData;)V", "airbridge_release"}, k = 1, mv = {1, 4, 3})
public final class EventData {
    @d("appMarketIdentifier")
    @Nullable
    private final String appMarketIdentifier;
    @d("appStorePackageName")
    @Nullable
    private final String appStorePackageName;
    @d("deeplink")
    @Nullable
    private final String deeplink;
    @d("goal")
    @Nullable
    private final GoalData goalData;
    @d("systemInstallStartTimestamp")
    @Nullable
    private final Long installBeginTimestamp;
    @d("appMarketReferrer")
    @Nullable
    private final InstallReferrerData installReferrerData;
    @d("systemInstallTimestamp")
    @Nullable
    private final Long installTimestamp;
    @d("isUniversalTrackingLink")
    @Nullable
    private final Boolean isUniversalTrackingLink;
    @d("metaInstallReferrer")
    @Nullable
    private final MetaInstallReferrerData metaInstallReferrerData;
    @d("pushToken")
    @Nullable
    private final String pushToken;
    @d("googleReferrer")
    @Nullable
    private final String referrer;
    @d("systemInstallClickTimestamp")
    @Nullable
    private final Long referrerClickTimestamp;
    @d("sessionID")
    @NotNull
    private final String sessionId;
    @d("sessionStartTimestamp")
    private final long sessionStartTimestamp;
    @d("sessionTimeOut")
    private final long sessionTimeoutMillis;
    @d("triggeredBy")
    @Nullable
    private final String triggeredBy;

    public EventData(@NotNull String s, long v, long v1, @Nullable String s1, @Nullable String s2, @Nullable Boolean boolean0, @Nullable Long long0, @Nullable Long long1, @Nullable String s3, @Nullable Long long2, @Nullable String s4, @Nullable MetaInstallReferrerData metaInstallReferrerData0, @Nullable InstallReferrerData installReferrerData0, @Nullable String s5, @Nullable String s6, @Nullable GoalData goalData0) {
        this.sessionId = s;
        this.sessionStartTimestamp = v;
        this.sessionTimeoutMillis = v1;
        this.triggeredBy = s1;
        this.deeplink = s2;
        this.isUniversalTrackingLink = boolean0;
        this.installTimestamp = long0;
        this.installBeginTimestamp = long1;
        this.referrer = s3;
        this.referrerClickTimestamp = long2;
        this.pushToken = s4;
        this.metaInstallReferrerData = metaInstallReferrerData0;
        this.installReferrerData = installReferrerData0;
        this.appMarketIdentifier = s5;
        this.appStorePackageName = s6;
        this.goalData = goalData0;
    }

    public EventData(String s, long v, long v1, String s1, String s2, Boolean boolean0, Long long0, Long long1, String s3, Long long2, String s4, MetaInstallReferrerData metaInstallReferrerData0, InstallReferrerData installReferrerData0, String s5, String s6, GoalData goalData0, int v2, DefaultConstructorMarker defaultConstructorMarker0) {
        this(s, v, v1, ((v2 & 8) == 0 ? s1 : null), ((v2 & 16) == 0 ? s2 : null), ((v2 & 0x20) == 0 ? boolean0 : null), ((v2 & 0x40) == 0 ? long0 : null), ((v2 & 0x80) == 0 ? long1 : null), ((v2 & 0x100) == 0 ? s3 : null), ((v2 & 0x200) == 0 ? long2 : null), ((v2 & 0x400) == 0 ? s4 : null), ((v2 & 0x800) == 0 ? metaInstallReferrerData0 : null), ((v2 & 0x1000) == 0 ? installReferrerData0 : null), ((v2 & 0x2000) == 0 ? s5 : null), ((v2 & 0x4000) == 0 ? s6 : null), ((v2 & 0x8000) == 0 ? goalData0 : null));
    }

    @NotNull
    public final String component1() {
        return this.sessionId;
    }

    @Nullable
    public final Long component10() {
        return this.referrerClickTimestamp;
    }

    @Nullable
    public final String component11() {
        return this.pushToken;
    }

    @Nullable
    public final MetaInstallReferrerData component12() {
        return this.metaInstallReferrerData;
    }

    @Nullable
    public final InstallReferrerData component13() {
        return this.installReferrerData;
    }

    @Nullable
    public final String component14() {
        return this.appMarketIdentifier;
    }

    @Nullable
    public final String component15() {
        return this.appStorePackageName;
    }

    @Nullable
    public final GoalData component16() {
        return this.goalData;
    }

    public final long component2() {
        return this.sessionStartTimestamp;
    }

    public final long component3() {
        return this.sessionTimeoutMillis;
    }

    @Nullable
    public final String component4() {
        return this.triggeredBy;
    }

    @Nullable
    public final String component5() {
        return this.deeplink;
    }

    @Nullable
    public final Boolean component6() {
        return this.isUniversalTrackingLink;
    }

    @Nullable
    public final Long component7() {
        return this.installTimestamp;
    }

    @Nullable
    public final Long component8() {
        return this.installBeginTimestamp;
    }

    @Nullable
    public final String component9() {
        return this.referrer;
    }

    @NotNull
    public final EventData copy(@NotNull String s, long v, long v1, @Nullable String s1, @Nullable String s2, @Nullable Boolean boolean0, @Nullable Long long0, @Nullable Long long1, @Nullable String s3, @Nullable Long long2, @Nullable String s4, @Nullable MetaInstallReferrerData metaInstallReferrerData0, @Nullable InstallReferrerData installReferrerData0, @Nullable String s5, @Nullable String s6, @Nullable GoalData goalData0) {
        return new EventData(s, v, v1, s1, s2, boolean0, long0, long1, s3, long2, s4, metaInstallReferrerData0, installReferrerData0, s5, s6, goalData0);
    }

    public static EventData copy$default(EventData eventData0, String s, long v, long v1, String s1, String s2, Boolean boolean0, Long long0, Long long1, String s3, Long long2, String s4, MetaInstallReferrerData metaInstallReferrerData0, InstallReferrerData installReferrerData0, String s5, String s6, GoalData goalData0, int v2, Object object0) {
        String s7 = (v2 & 1) == 0 ? s : eventData0.sessionId;
        long v3 = (v2 & 2) == 0 ? v : eventData0.sessionStartTimestamp;
        long v4 = (v2 & 4) == 0 ? v1 : eventData0.sessionTimeoutMillis;
        String s8 = (v2 & 8) == 0 ? s1 : eventData0.triggeredBy;
        String s9 = (v2 & 16) == 0 ? s2 : eventData0.deeplink;
        Boolean boolean1 = (v2 & 0x20) == 0 ? boolean0 : eventData0.isUniversalTrackingLink;
        Long long3 = (v2 & 0x40) == 0 ? long0 : eventData0.installTimestamp;
        Long long4 = (v2 & 0x80) == 0 ? long1 : eventData0.installBeginTimestamp;
        String s10 = (v2 & 0x100) == 0 ? s3 : eventData0.referrer;
        Long long5 = (v2 & 0x200) == 0 ? long2 : eventData0.referrerClickTimestamp;
        String s11 = (v2 & 0x400) == 0 ? s4 : eventData0.pushToken;
        MetaInstallReferrerData metaInstallReferrerData1 = (v2 & 0x800) == 0 ? metaInstallReferrerData0 : eventData0.metaInstallReferrerData;
        InstallReferrerData installReferrerData1 = (v2 & 0x1000) == 0 ? installReferrerData0 : eventData0.installReferrerData;
        String s12 = (v2 & 0x2000) == 0 ? s5 : eventData0.appMarketIdentifier;
        String s13 = (v2 & 0x4000) == 0 ? s6 : eventData0.appStorePackageName;
        return (v2 & 0x8000) == 0 ? eventData0.copy(s7, v3, v4, s8, s9, boolean1, long3, long4, s10, long5, s11, metaInstallReferrerData1, installReferrerData1, s12, s13, goalData0) : eventData0.copy(s7, v3, v4, s8, s9, boolean1, long3, long4, s10, long5, s11, metaInstallReferrerData1, installReferrerData1, s12, s13, eventData0.goalData);
    }

    // 去混淆评级： 中等(150)
    @Override
    public boolean equals(@Nullable Object object0) {
        return this == object0 || object0 instanceof EventData && q.b(this.sessionId, ((EventData)object0).sessionId) && this.sessionStartTimestamp == ((EventData)object0).sessionStartTimestamp && this.sessionTimeoutMillis == ((EventData)object0).sessionTimeoutMillis && q.b(this.triggeredBy, ((EventData)object0).triggeredBy) && q.b(this.deeplink, ((EventData)object0).deeplink) && q.b(this.isUniversalTrackingLink, ((EventData)object0).isUniversalTrackingLink) && q.b(this.installTimestamp, ((EventData)object0).installTimestamp) && q.b(this.installBeginTimestamp, ((EventData)object0).installBeginTimestamp) && q.b(this.referrer, ((EventData)object0).referrer) && q.b(this.referrerClickTimestamp, ((EventData)object0).referrerClickTimestamp) && q.b(this.pushToken, ((EventData)object0).pushToken) && q.b(this.metaInstallReferrerData, ((EventData)object0).metaInstallReferrerData) && q.b(this.installReferrerData, ((EventData)object0).installReferrerData) && q.b(this.appMarketIdentifier, ((EventData)object0).appMarketIdentifier) && q.b(this.appStorePackageName, ((EventData)object0).appStorePackageName) && q.b(this.goalData, ((EventData)object0).goalData);
    }

    @Nullable
    public final String getAppMarketIdentifier() {
        return this.appMarketIdentifier;
    }

    @Nullable
    public final String getAppStorePackageName() {
        return this.appStorePackageName;
    }

    @Nullable
    public final String getDeeplink() {
        return this.deeplink;
    }

    @Nullable
    public final GoalData getGoalData() {
        return this.goalData;
    }

    @Nullable
    public final Long getInstallBeginTimestamp() {
        return this.installBeginTimestamp;
    }

    @Nullable
    public final InstallReferrerData getInstallReferrerData() {
        return this.installReferrerData;
    }

    @Nullable
    public final Long getInstallTimestamp() {
        return this.installTimestamp;
    }

    @Nullable
    public final MetaInstallReferrerData getMetaInstallReferrerData() {
        return this.metaInstallReferrerData;
    }

    @Nullable
    public final String getPushToken() {
        return this.pushToken;
    }

    @Nullable
    public final String getReferrer() {
        return this.referrer;
    }

    @Nullable
    public final Long getReferrerClickTimestamp() {
        return this.referrerClickTimestamp;
    }

    @NotNull
    public final String getSessionId() {
        return this.sessionId;
    }

    public final long getSessionStartTimestamp() {
        return this.sessionStartTimestamp;
    }

    public final long getSessionTimeoutMillis() {
        return this.sessionTimeoutMillis;
    }

    @Nullable
    public final String getTriggeredBy() {
        return this.triggeredBy;
    }

    @Override
    public int hashCode() {
        int v = 0;
        int v1 = A7.d.c(A7.d.c((this.sessionId == null ? 0 : this.sessionId.hashCode()) * 0x1F, 0x1F, this.sessionStartTimestamp), 0x1F, this.sessionTimeoutMillis);
        int v2 = this.triggeredBy == null ? 0 : this.triggeredBy.hashCode();
        int v3 = this.deeplink == null ? 0 : this.deeplink.hashCode();
        int v4 = this.isUniversalTrackingLink == null ? 0 : this.isUniversalTrackingLink.hashCode();
        int v5 = this.installTimestamp == null ? 0 : this.installTimestamp.hashCode();
        int v6 = this.installBeginTimestamp == null ? 0 : this.installBeginTimestamp.hashCode();
        int v7 = this.referrer == null ? 0 : this.referrer.hashCode();
        int v8 = this.referrerClickTimestamp == null ? 0 : this.referrerClickTimestamp.hashCode();
        int v9 = this.pushToken == null ? 0 : this.pushToken.hashCode();
        int v10 = this.metaInstallReferrerData == null ? 0 : this.metaInstallReferrerData.hashCode();
        int v11 = this.installReferrerData == null ? 0 : this.installReferrerData.hashCode();
        int v12 = this.appMarketIdentifier == null ? 0 : this.appMarketIdentifier.hashCode();
        int v13 = this.appStorePackageName == null ? 0 : this.appStorePackageName.hashCode();
        GoalData goalData0 = this.goalData;
        if(goalData0 != null) {
            v = goalData0.hashCode();
        }
        return ((((((((((((v1 + v2) * 0x1F + v3) * 0x1F + v4) * 0x1F + v5) * 0x1F + v6) * 0x1F + v7) * 0x1F + v8) * 0x1F + v9) * 0x1F + v10) * 0x1F + v11) * 0x1F + v12) * 0x1F + v13) * 0x1F + v;
    }

    @Nullable
    public final Boolean isUniversalTrackingLink() {
        return this.isUniversalTrackingLink;
    }

    @Override
    @NotNull
    public String toString() {
        return "EventData(sessionId=" + this.sessionId + ", sessionStartTimestamp=" + this.sessionStartTimestamp + ", sessionTimeoutMillis=" + this.sessionTimeoutMillis + ", triggeredBy=" + this.triggeredBy + ", deeplink=" + this.deeplink + ", isUniversalTrackingLink=" + this.isUniversalTrackingLink + ", installTimestamp=" + this.installTimestamp + ", installBeginTimestamp=" + this.installBeginTimestamp + ", referrer=" + this.referrer + ", referrerClickTimestamp=" + this.referrerClickTimestamp + ", pushToken=" + this.pushToken + ", metaInstallReferrerData=" + this.metaInstallReferrerData + ", installReferrerData=" + this.installReferrerData + ", appMarketIdentifier=" + this.appMarketIdentifier + ", appStorePackageName=" + this.appStorePackageName + ", goalData=" + this.goalData + ")";
    }
}


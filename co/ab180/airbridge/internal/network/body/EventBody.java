package co.ab180.airbridge.internal.network.body;

import co.ab180.airbridge.internal.network.model.AppInfo;
import co.ab180.airbridge.internal.network.model.DeviceInfo;
import co.ab180.airbridge.internal.network.model.EventData;
import co.ab180.airbridge.internal.network.model.UserInfo;
import co.ab180.airbridge.internal.parser.RuleWith;
import co.ab180.airbridge.internal.parser.e.d;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.q;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@RuleWith(d.class)
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000P\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000E\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0010$\n\u0002\b\u000E\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u000B\n\u0002\b\u0015\b\u0081\b\u0018\u00002\u00020\u0001Be\u0012\u0006\u0010\u0019\u001A\u00020\u0002\u0012\u0006\u0010\u001A\u001A\u00020\u0002\u0012\u0006\u0010\u001B\u001A\u00020\u0002\u0012\u0006\u0010\u001C\u001A\u00020\u0007\u0012\u0006\u0010\u001D\u001A\u00020\n\u0012\n\b\u0002\u0010\u001E\u001A\u0004\u0018\u00010\r\u0012\n\b\u0002\u0010\u001F\u001A\u0004\u0018\u00010\u0010\u0012\u0006\u0010 \u001A\u00020\u0013\u0012\u0014\b\u0002\u0010!\u001A\u000E\u0012\u0004\u0012\u00020\u0002\u0012\u0002\b\u0003\u0018\u00010\u0016\u00A2\u0006\u0004\b<\u0010=J\u0010\u0010\u0003\u001A\u00020\u0002H\u00C6\u0003\u00A2\u0006\u0004\b\u0003\u0010\u0004J\u0010\u0010\u0005\u001A\u00020\u0002H\u00C6\u0003\u00A2\u0006\u0004\b\u0005\u0010\u0004J\u0010\u0010\u0006\u001A\u00020\u0002H\u00C6\u0003\u00A2\u0006\u0004\b\u0006\u0010\u0004J\u0010\u0010\b\u001A\u00020\u0007H\u00C6\u0003\u00A2\u0006\u0004\b\b\u0010\tJ\u0010\u0010\u000B\u001A\u00020\nH\u00C6\u0003\u00A2\u0006\u0004\b\u000B\u0010\fJ\u0012\u0010\u000E\u001A\u0004\u0018\u00010\rH\u00C6\u0003\u00A2\u0006\u0004\b\u000E\u0010\u000FJ\u0012\u0010\u0011\u001A\u0004\u0018\u00010\u0010H\u00C6\u0003\u00A2\u0006\u0004\b\u0011\u0010\u0012J\u0010\u0010\u0014\u001A\u00020\u0013H\u00C6\u0003\u00A2\u0006\u0004\b\u0014\u0010\u0015J\u001C\u0010\u0017\u001A\u000E\u0012\u0004\u0012\u00020\u0002\u0012\u0002\b\u0003\u0018\u00010\u0016H\u00C6\u0003\u00A2\u0006\u0004\b\u0017\u0010\u0018Jz\u0010\"\u001A\u00020\u00002\b\b\u0002\u0010\u0019\u001A\u00020\u00022\b\b\u0002\u0010\u001A\u001A\u00020\u00022\b\b\u0002\u0010\u001B\u001A\u00020\u00022\b\b\u0002\u0010\u001C\u001A\u00020\u00072\b\b\u0002\u0010\u001D\u001A\u00020\n2\n\b\u0002\u0010\u001E\u001A\u0004\u0018\u00010\r2\n\b\u0002\u0010\u001F\u001A\u0004\u0018\u00010\u00102\b\b\u0002\u0010 \u001A\u00020\u00132\u0014\b\u0002\u0010!\u001A\u000E\u0012\u0004\u0012\u00020\u0002\u0012\u0002\b\u0003\u0018\u00010\u0016H\u00C6\u0001\u00A2\u0006\u0004\b\"\u0010#J\u0010\u0010$\u001A\u00020\u0002H\u00D6\u0001\u00A2\u0006\u0004\b$\u0010\u0004J\u0010\u0010&\u001A\u00020%H\u00D6\u0001\u00A2\u0006\u0004\b&\u0010\'J\u001A\u0010*\u001A\u00020)2\b\u0010(\u001A\u0004\u0018\u00010\u0001H\u00D6\u0003\u00A2\u0006\u0004\b*\u0010+R\u001E\u0010\u001F\u001A\u0004\u0018\u00010\u00108\u0006@\u0007X\u0087\u0004\u00A2\u0006\f\n\u0004\b\u001F\u0010,\u001A\u0004\b-\u0010\u0012R\u001C\u0010\u001C\u001A\u00020\u00078\u0006@\u0007X\u0087\u0004\u00A2\u0006\f\n\u0004\b\u001C\u0010.\u001A\u0004\b/\u0010\tR\u001C\u0010\u001B\u001A\u00020\u00028\u0006@\u0007X\u0087\u0004\u00A2\u0006\f\n\u0004\b\u001B\u00100\u001A\u0004\b1\u0010\u0004R\u001C\u0010\u0019\u001A\u00020\u00028\u0006@\u0007X\u0087\u0004\u00A2\u0006\f\n\u0004\b\u0019\u00100\u001A\u0004\b2\u0010\u0004R(\u0010!\u001A\u000E\u0012\u0004\u0012\u00020\u0002\u0012\u0002\b\u0003\u0018\u00010\u00168\u0006@\u0007X\u0087\u0004\u00A2\u0006\f\n\u0004\b!\u00103\u001A\u0004\b4\u0010\u0018R\u001C\u0010\u001D\u001A\u00020\n8\u0006@\u0007X\u0087\u0004\u00A2\u0006\f\n\u0004\b\u001D\u00105\u001A\u0004\b6\u0010\fR\u001C\u0010\u001A\u001A\u00020\u00028\u0006@\u0007X\u0087\u0004\u00A2\u0006\f\n\u0004\b\u001A\u00100\u001A\u0004\b7\u0010\u0004R\u001C\u0010 \u001A\u00020\u00138\u0006@\u0007X\u0087\u0004\u00A2\u0006\f\n\u0004\b \u00108\u001A\u0004\b9\u0010\u0015R\u001E\u0010\u001E\u001A\u0004\u0018\u00010\r8\u0006@\u0007X\u0087\u0004\u00A2\u0006\f\n\u0004\b\u001E\u0010:\u001A\u0004\b;\u0010\u000F\u00A8\u0006>"}, d2 = {"Lco/ab180/airbridge/internal/network/body/EventBody;", "", "", "component1", "()Ljava/lang/String;", "component2", "component3", "Lco/ab180/airbridge/internal/network/model/AppInfo;", "component4", "()Lco/ab180/airbridge/internal/network/model/AppInfo;", "Lco/ab180/airbridge/internal/network/model/DeviceInfo;", "component5", "()Lco/ab180/airbridge/internal/network/model/DeviceInfo;", "Lco/ab180/airbridge/internal/network/model/UserInfo;", "component6", "()Lco/ab180/airbridge/internal/network/model/UserInfo;", "Lco/ab180/airbridge/internal/network/model/EventData;", "component7", "()Lco/ab180/airbridge/internal/network/model/EventData;", "", "component8", "()J", "", "component9", "()Ljava/util/Map;", "uuid", "sdkVersion", "platform", "appInfo", "deviceInfo", "userInfo", "eventData", "eventTimestamp", "internal", "copy", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Lco/ab180/airbridge/internal/network/model/AppInfo;Lco/ab180/airbridge/internal/network/model/DeviceInfo;Lco/ab180/airbridge/internal/network/model/UserInfo;Lco/ab180/airbridge/internal/network/model/EventData;JLjava/util/Map;)Lco/ab180/airbridge/internal/network/body/EventBody;", "toString", "", "hashCode", "()I", "other", "", "equals", "(Ljava/lang/Object;)Z", "Lco/ab180/airbridge/internal/network/model/EventData;", "getEventData", "Lco/ab180/airbridge/internal/network/model/AppInfo;", "getAppInfo", "Ljava/lang/String;", "getPlatform", "getUuid", "Ljava/util/Map;", "getInternal", "Lco/ab180/airbridge/internal/network/model/DeviceInfo;", "getDeviceInfo", "getSdkVersion", "J", "getEventTimestamp", "Lco/ab180/airbridge/internal/network/model/UserInfo;", "getUserInfo", "<init>", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Lco/ab180/airbridge/internal/network/model/AppInfo;Lco/ab180/airbridge/internal/network/model/DeviceInfo;Lco/ab180/airbridge/internal/network/model/UserInfo;Lco/ab180/airbridge/internal/network/model/EventData;JLjava/util/Map;)V", "airbridge_release"}, k = 1, mv = {1, 4, 3})
public final class EventBody {
    @co.ab180.airbridge.internal.parser.d("app")
    @NotNull
    private final AppInfo appInfo;
    @co.ab180.airbridge.internal.parser.d("device")
    @NotNull
    private final DeviceInfo deviceInfo;
    @co.ab180.airbridge.internal.parser.d("eventData")
    @Nullable
    private final EventData eventData;
    @co.ab180.airbridge.internal.parser.d("eventTimestamp")
    private final long eventTimestamp;
    @co.ab180.airbridge.internal.parser.d("internal")
    @Nullable
    private final Map internal;
    @co.ab180.airbridge.internal.parser.d("sdkDevelopmentPlatform")
    @NotNull
    private final String platform;
    @co.ab180.airbridge.internal.parser.d("sdkVersion")
    @NotNull
    private final String sdkVersion;
    @co.ab180.airbridge.internal.parser.d("user")
    @Nullable
    private final UserInfo userInfo;
    @co.ab180.airbridge.internal.parser.d("eventUUID")
    @NotNull
    private final String uuid;

    public EventBody(@NotNull String s, @NotNull String s1, @NotNull String s2, @NotNull AppInfo appInfo0, @NotNull DeviceInfo deviceInfo0, @Nullable UserInfo userInfo0, @Nullable EventData eventData0, long v, @Nullable Map map0) {
        this.uuid = s;
        this.sdkVersion = s1;
        this.platform = s2;
        this.appInfo = appInfo0;
        this.deviceInfo = deviceInfo0;
        this.userInfo = userInfo0;
        this.eventData = eventData0;
        this.eventTimestamp = v;
        this.internal = map0;
    }

    public EventBody(String s, String s1, String s2, AppInfo appInfo0, DeviceInfo deviceInfo0, UserInfo userInfo0, EventData eventData0, long v, Map map0, int v1, DefaultConstructorMarker defaultConstructorMarker0) {
        if((v1 & 0x20) != 0) {
            userInfo0 = null;
        }
        if((v1 & 0x40) != 0) {
            eventData0 = null;
        }
        this(s, s1, s2, appInfo0, deviceInfo0, userInfo0, eventData0, v, ((v1 & 0x100) == 0 ? map0 : null));
    }

    @NotNull
    public final String component1() {
        return this.uuid;
    }

    @NotNull
    public final String component2() {
        return this.sdkVersion;
    }

    @NotNull
    public final String component3() {
        return this.platform;
    }

    @NotNull
    public final AppInfo component4() {
        return this.appInfo;
    }

    @NotNull
    public final DeviceInfo component5() {
        return this.deviceInfo;
    }

    @Nullable
    public final UserInfo component6() {
        return this.userInfo;
    }

    @Nullable
    public final EventData component7() {
        return this.eventData;
    }

    public final long component8() {
        return this.eventTimestamp;
    }

    @Nullable
    public final Map component9() {
        return this.internal;
    }

    @NotNull
    public final EventBody copy(@NotNull String s, @NotNull String s1, @NotNull String s2, @NotNull AppInfo appInfo0, @NotNull DeviceInfo deviceInfo0, @Nullable UserInfo userInfo0, @Nullable EventData eventData0, long v, @Nullable Map map0) {
        return new EventBody(s, s1, s2, appInfo0, deviceInfo0, userInfo0, eventData0, v, map0);
    }

    public static EventBody copy$default(EventBody eventBody0, String s, String s1, String s2, AppInfo appInfo0, DeviceInfo deviceInfo0, UserInfo userInfo0, EventData eventData0, long v, Map map0, int v1, Object object0) {
        if((v1 & 1) != 0) {
            s = eventBody0.uuid;
        }
        if((v1 & 2) != 0) {
            s1 = eventBody0.sdkVersion;
        }
        if((v1 & 4) != 0) {
            s2 = eventBody0.platform;
        }
        if((v1 & 8) != 0) {
            appInfo0 = eventBody0.appInfo;
        }
        if((v1 & 16) != 0) {
            deviceInfo0 = eventBody0.deviceInfo;
        }
        if((v1 & 0x20) != 0) {
            userInfo0 = eventBody0.userInfo;
        }
        if((v1 & 0x40) != 0) {
            eventData0 = eventBody0.eventData;
        }
        if((v1 & 0x80) != 0) {
            v = eventBody0.eventTimestamp;
        }
        if((v1 & 0x100) != 0) {
            map0 = eventBody0.internal;
        }
        return eventBody0.copy(s, s1, s2, appInfo0, deviceInfo0, userInfo0, eventData0, v, map0);
    }

    // 去混淆评级： 中等(90)
    @Override
    public boolean equals(@Nullable Object object0) {
        return this == object0 || object0 instanceof EventBody && q.b(this.uuid, ((EventBody)object0).uuid) && q.b(this.sdkVersion, ((EventBody)object0).sdkVersion) && q.b(this.platform, ((EventBody)object0).platform) && q.b(this.appInfo, ((EventBody)object0).appInfo) && q.b(this.deviceInfo, ((EventBody)object0).deviceInfo) && q.b(this.userInfo, ((EventBody)object0).userInfo) && q.b(this.eventData, ((EventBody)object0).eventData) && this.eventTimestamp == ((EventBody)object0).eventTimestamp && q.b(this.internal, ((EventBody)object0).internal);
    }

    @NotNull
    public final AppInfo getAppInfo() {
        return this.appInfo;
    }

    @NotNull
    public final DeviceInfo getDeviceInfo() {
        return this.deviceInfo;
    }

    @Nullable
    public final EventData getEventData() {
        return this.eventData;
    }

    public final long getEventTimestamp() {
        return this.eventTimestamp;
    }

    @Nullable
    public final Map getInternal() {
        return this.internal;
    }

    @NotNull
    public final String getPlatform() {
        return this.platform;
    }

    @NotNull
    public final String getSdkVersion() {
        return this.sdkVersion;
    }

    @Nullable
    public final UserInfo getUserInfo() {
        return this.userInfo;
    }

    @NotNull
    public final String getUuid() {
        return this.uuid;
    }

    @Override
    public int hashCode() {
        int v = 0;
        int v1 = A7.d.c((((((((this.uuid == null ? 0 : this.uuid.hashCode()) * 0x1F + (this.sdkVersion == null ? 0 : this.sdkVersion.hashCode())) * 0x1F + (this.platform == null ? 0 : this.platform.hashCode())) * 0x1F + (this.appInfo == null ? 0 : this.appInfo.hashCode())) * 0x1F + (this.deviceInfo == null ? 0 : this.deviceInfo.hashCode())) * 0x1F + (this.userInfo == null ? 0 : this.userInfo.hashCode())) * 0x1F + (this.eventData == null ? 0 : this.eventData.hashCode())) * 0x1F, 0x1F, this.eventTimestamp);
        Map map0 = this.internal;
        if(map0 != null) {
            v = map0.hashCode();
        }
        return v1 + v;
    }

    @Override
    @NotNull
    public String toString() {
        return "EventBody(uuid=" + this.uuid + ", sdkVersion=" + this.sdkVersion + ", platform=" + this.platform + ", appInfo=" + this.appInfo + ", deviceInfo=" + this.deviceInfo + ", userInfo=" + this.userInfo + ", eventData=" + this.eventData + ", eventTimestamp=" + this.eventTimestamp + ", internal=" + this.internal + ")";
    }
}


package co.ab180.airbridge.internal.network.body;

import U4.x;
import co.ab180.airbridge.internal.network.model.AppInfo;
import co.ab180.airbridge.internal.network.model.DeviceInfo;
import co.ab180.airbridge.internal.parser.RuleWith;
import co.ab180.airbridge.internal.parser.d;
import co.ab180.airbridge.internal.parser.e.r;
import kotlin.Metadata;
import kotlin.jvm.internal.q;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@RuleWith(r.class)
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000@\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000E\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\t\n\u0002\b\f\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u000B\n\u0002\b\u0011\b\u0081\b\u0018\u00002\u00020\u0001B?\u0012\u0006\u0010\u0013\u001A\u00020\u0002\u0012\u0006\u0010\u0014\u001A\u00020\u0002\u0012\u0006\u0010\u0015\u001A\u00020\u0002\u0012\u0006\u0010\u0016\u001A\u00020\u0007\u0012\u0006\u0010\u0017\u001A\u00020\n\u0012\u0006\u0010\u0018\u001A\u00020\r\u0012\u0006\u0010\u0019\u001A\u00020\u0010\u00A2\u0006\u0004\b0\u00101J\u0010\u0010\u0003\u001A\u00020\u0002H\u00C6\u0003\u00A2\u0006\u0004\b\u0003\u0010\u0004J\u0010\u0010\u0005\u001A\u00020\u0002H\u00C6\u0003\u00A2\u0006\u0004\b\u0005\u0010\u0004J\u0010\u0010\u0006\u001A\u00020\u0002H\u00C6\u0003\u00A2\u0006\u0004\b\u0006\u0010\u0004J\u0010\u0010\b\u001A\u00020\u0007H\u00C6\u0003\u00A2\u0006\u0004\b\b\u0010\tJ\u0010\u0010\u000B\u001A\u00020\nH\u00C6\u0003\u00A2\u0006\u0004\b\u000B\u0010\fJ\u0010\u0010\u000E\u001A\u00020\rH\u00C6\u0003\u00A2\u0006\u0004\b\u000E\u0010\u000FJ\u0010\u0010\u0011\u001A\u00020\u0010H\u00C6\u0003\u00A2\u0006\u0004\b\u0011\u0010\u0012JV\u0010\u001A\u001A\u00020\u00002\b\b\u0002\u0010\u0013\u001A\u00020\u00022\b\b\u0002\u0010\u0014\u001A\u00020\u00022\b\b\u0002\u0010\u0015\u001A\u00020\u00022\b\b\u0002\u0010\u0016\u001A\u00020\u00072\b\b\u0002\u0010\u0017\u001A\u00020\n2\b\b\u0002\u0010\u0018\u001A\u00020\r2\b\b\u0002\u0010\u0019\u001A\u00020\u0010H\u00C6\u0001\u00A2\u0006\u0004\b\u001A\u0010\u001BJ\u0010\u0010\u001C\u001A\u00020\u0002H\u00D6\u0001\u00A2\u0006\u0004\b\u001C\u0010\u0004J\u0010\u0010\u001E\u001A\u00020\u001DH\u00D6\u0001\u00A2\u0006\u0004\b\u001E\u0010\u001FJ\u001A\u0010\"\u001A\u00020!2\b\u0010 \u001A\u0004\u0018\u00010\u0001H\u00D6\u0003\u00A2\u0006\u0004\b\"\u0010#R\u001C\u0010\u0018\u001A\u00020\r8\u0006@\u0007X\u0087\u0004\u00A2\u0006\f\n\u0004\b\u0018\u0010$\u001A\u0004\b%\u0010\u000FR\u001C\u0010\u0017\u001A\u00020\n8\u0006@\u0007X\u0087\u0004\u00A2\u0006\f\n\u0004\b\u0017\u0010&\u001A\u0004\b\'\u0010\fR\u001C\u0010\u0013\u001A\u00020\u00028\u0006@\u0007X\u0087\u0004\u00A2\u0006\f\n\u0004\b\u0013\u0010(\u001A\u0004\b)\u0010\u0004R\u001C\u0010\u0016\u001A\u00020\u00078\u0006@\u0007X\u0087\u0004\u00A2\u0006\f\n\u0004\b\u0016\u0010*\u001A\u0004\b+\u0010\tR\u001C\u0010\u0014\u001A\u00020\u00028\u0006@\u0007X\u0087\u0004\u00A2\u0006\f\n\u0004\b\u0014\u0010(\u001A\u0004\b,\u0010\u0004R\u001C\u0010\u0015\u001A\u00020\u00028\u0006@\u0007X\u0087\u0004\u00A2\u0006\f\n\u0004\b\u0015\u0010(\u001A\u0004\b-\u0010\u0004R\u001C\u0010\u0019\u001A\u00020\u00108\u0006@\u0007X\u0087\u0004\u00A2\u0006\f\n\u0004\b\u0019\u0010.\u001A\u0004\b/\u0010\u0012\u00A8\u00062"}, d2 = {"Lco/ab180/airbridge/internal/network/body/LogData;", "", "", "component1", "()Ljava/lang/String;", "component2", "component3", "Lco/ab180/airbridge/internal/network/body/LogInfo;", "component4", "()Lco/ab180/airbridge/internal/network/body/LogInfo;", "Lco/ab180/airbridge/internal/network/model/AppInfo;", "component5", "()Lco/ab180/airbridge/internal/network/model/AppInfo;", "Lco/ab180/airbridge/internal/network/model/DeviceInfo;", "component6", "()Lco/ab180/airbridge/internal/network/model/DeviceInfo;", "", "component7", "()J", "uuid", "sdkVersion", "platform", "logInfo", "appInfo", "deviceInfo", "eventTimestamp", "copy", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Lco/ab180/airbridge/internal/network/body/LogInfo;Lco/ab180/airbridge/internal/network/model/AppInfo;Lco/ab180/airbridge/internal/network/model/DeviceInfo;J)Lco/ab180/airbridge/internal/network/body/LogData;", "toString", "", "hashCode", "()I", "other", "", "equals", "(Ljava/lang/Object;)Z", "Lco/ab180/airbridge/internal/network/model/DeviceInfo;", "getDeviceInfo", "Lco/ab180/airbridge/internal/network/model/AppInfo;", "getAppInfo", "Ljava/lang/String;", "getUuid", "Lco/ab180/airbridge/internal/network/body/LogInfo;", "getLogInfo", "getSdkVersion", "getPlatform", "J", "getEventTimestamp", "<init>", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Lco/ab180/airbridge/internal/network/body/LogInfo;Lco/ab180/airbridge/internal/network/model/AppInfo;Lco/ab180/airbridge/internal/network/model/DeviceInfo;J)V", "airbridge_release"}, k = 1, mv = {1, 4, 3})
public final class LogData {
    @d("app")
    @NotNull
    private final AppInfo appInfo;
    @d("device")
    @NotNull
    private final DeviceInfo deviceInfo;
    @d("eventTimestamp")
    private final long eventTimestamp;
    @d("log")
    @NotNull
    private final LogInfo logInfo;
    @d("sdkDevelopmentPlatform")
    @NotNull
    private final String platform;
    @d("sdkVersion")
    @NotNull
    private final String sdkVersion;
    @d("eventUUID")
    @NotNull
    private final String uuid;

    public LogData(@NotNull String s, @NotNull String s1, @NotNull String s2, @NotNull LogInfo logInfo0, @NotNull AppInfo appInfo0, @NotNull DeviceInfo deviceInfo0, long v) {
        this.uuid = s;
        this.sdkVersion = s1;
        this.platform = s2;
        this.logInfo = logInfo0;
        this.appInfo = appInfo0;
        this.deviceInfo = deviceInfo0;
        this.eventTimestamp = v;
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
    public final LogInfo component4() {
        return this.logInfo;
    }

    @NotNull
    public final AppInfo component5() {
        return this.appInfo;
    }

    @NotNull
    public final DeviceInfo component6() {
        return this.deviceInfo;
    }

    public final long component7() {
        return this.eventTimestamp;
    }

    @NotNull
    public final LogData copy(@NotNull String s, @NotNull String s1, @NotNull String s2, @NotNull LogInfo logInfo0, @NotNull AppInfo appInfo0, @NotNull DeviceInfo deviceInfo0, long v) {
        return new LogData(s, s1, s2, logInfo0, appInfo0, deviceInfo0, v);
    }

    public static LogData copy$default(LogData logData0, String s, String s1, String s2, LogInfo logInfo0, AppInfo appInfo0, DeviceInfo deviceInfo0, long v, int v1, Object object0) {
        if((v1 & 1) != 0) {
            s = logData0.uuid;
        }
        if((v1 & 2) != 0) {
            s1 = logData0.sdkVersion;
        }
        if((v1 & 4) != 0) {
            s2 = logData0.platform;
        }
        if((v1 & 8) != 0) {
            logInfo0 = logData0.logInfo;
        }
        if((v1 & 16) != 0) {
            appInfo0 = logData0.appInfo;
        }
        if((v1 & 0x20) != 0) {
            deviceInfo0 = logData0.deviceInfo;
        }
        if((v1 & 0x40) != 0) {
            v = logData0.eventTimestamp;
        }
        return logData0.copy(s, s1, s2, logInfo0, appInfo0, deviceInfo0, v);
    }

    // 去混淆评级： 中等(70)
    @Override
    public boolean equals(@Nullable Object object0) {
        return this == object0 || object0 instanceof LogData && q.b(this.uuid, ((LogData)object0).uuid) && q.b(this.sdkVersion, ((LogData)object0).sdkVersion) && q.b(this.platform, ((LogData)object0).platform) && q.b(this.logInfo, ((LogData)object0).logInfo) && q.b(this.appInfo, ((LogData)object0).appInfo) && q.b(this.deviceInfo, ((LogData)object0).deviceInfo) && this.eventTimestamp == ((LogData)object0).eventTimestamp;
    }

    @NotNull
    public final AppInfo getAppInfo() {
        return this.appInfo;
    }

    @NotNull
    public final DeviceInfo getDeviceInfo() {
        return this.deviceInfo;
    }

    public final long getEventTimestamp() {
        return this.eventTimestamp;
    }

    @NotNull
    public final LogInfo getLogInfo() {
        return this.logInfo;
    }

    @NotNull
    public final String getPlatform() {
        return this.platform;
    }

    @NotNull
    public final String getSdkVersion() {
        return this.sdkVersion;
    }

    @NotNull
    public final String getUuid() {
        return this.uuid;
    }

    @Override
    public int hashCode() {
        int v = 0;
        int v1 = this.uuid == null ? 0 : this.uuid.hashCode();
        int v2 = this.sdkVersion == null ? 0 : this.sdkVersion.hashCode();
        int v3 = this.platform == null ? 0 : this.platform.hashCode();
        int v4 = this.logInfo == null ? 0 : this.logInfo.hashCode();
        int v5 = this.appInfo == null ? 0 : this.appInfo.hashCode();
        DeviceInfo deviceInfo0 = this.deviceInfo;
        if(deviceInfo0 != null) {
            v = deviceInfo0.hashCode();
        }
        return Long.hashCode(this.eventTimestamp) + (((((v1 * 0x1F + v2) * 0x1F + v3) * 0x1F + v4) * 0x1F + v5) * 0x1F + v) * 0x1F;
    }

    @Override
    @NotNull
    public String toString() {
        StringBuilder stringBuilder0 = new StringBuilder("LogData(uuid=");
        stringBuilder0.append(this.uuid);
        stringBuilder0.append(", sdkVersion=");
        stringBuilder0.append(this.sdkVersion);
        stringBuilder0.append(", platform=");
        stringBuilder0.append(this.platform);
        stringBuilder0.append(", logInfo=");
        stringBuilder0.append(this.logInfo);
        stringBuilder0.append(", appInfo=");
        stringBuilder0.append(this.appInfo);
        stringBuilder0.append(", deviceInfo=");
        stringBuilder0.append(this.deviceInfo);
        stringBuilder0.append(", eventTimestamp=");
        return x.h(this.eventTimestamp, ")", stringBuilder0);
    }
}


package co.ab180.airbridge.internal.network.model;

import co.ab180.airbridge.internal.parser.RuleWith;
import co.ab180.airbridge.internal.parser.d;
import co.ab180.airbridge.internal.parser.e.c;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.q;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@RuleWith(c.class)
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000@\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000E\n\u0002\b\u0002\n\u0002\u0010\u000B\n\u0002\b\t\n\u0002\u0010\b\n\u0002\b\u000B\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010$\n\u0002\bD\b\u0081\b\u0018\u00002\u00020\u0001B\u00EF\u0001\u0012\u0006\u0010(\u001A\u00020\u0002\u0012\u0006\u0010)\u001A\u00020\u0005\u0012\u0006\u0010*\u001A\u00020\u0002\u0012\b\u0010+\u001A\u0004\u0018\u00010\u0002\u0012\b\u0010,\u001A\u0004\u0018\u00010\u0005\u0012\b\u0010-\u001A\u0004\u0018\u00010\u0002\u0012\b\u0010.\u001A\u0004\u0018\u00010\u0005\u0012\b\u0010/\u001A\u0004\u0018\u00010\u0002\u0012\b\u00100\u001A\u0004\u0018\u00010\u000F\u0012\u0006\u00101\u001A\u00020\u0002\u0012\u0006\u00102\u001A\u00020\u0002\u0012\u0006\u00103\u001A\u00020\u0002\u0012\u0006\u00104\u001A\u00020\u0002\u0012\u0006\u00105\u001A\u00020\u0002\u0012\u0006\u00106\u001A\u00020\u0002\u0012\u0006\u00107\u001A\u00020\u0002\u0012\u0006\u00108\u001A\u00020\u0002\u0012\u0006\u00109\u001A\u00020\u0002\u0012\u0006\u0010:\u001A\u00020\u001B\u0012\u0006\u0010;\u001A\u00020\u001E\u0012\n\b\u0002\u0010<\u001A\u0004\u0018\u00010!\u0012\u0016\b\u0002\u0010=\u001A\u0010\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u0002\u0018\u00010$\u0012\u0016\b\u0002\u0010>\u001A\u0010\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u0001\u0018\u00010$\u00A2\u0006\u0004\bf\u0010gJ\u0010\u0010\u0003\u001A\u00020\u0002H\u00C6\u0003\u00A2\u0006\u0004\b\u0003\u0010\u0004J\u0010\u0010\u0006\u001A\u00020\u0005H\u00C6\u0003\u00A2\u0006\u0004\b\u0006\u0010\u0007J\u0010\u0010\b\u001A\u00020\u0002H\u00C6\u0003\u00A2\u0006\u0004\b\b\u0010\u0004J\u0012\u0010\t\u001A\u0004\u0018\u00010\u0002H\u00C6\u0003\u00A2\u0006\u0004\b\t\u0010\u0004J\u0012\u0010\n\u001A\u0004\u0018\u00010\u0005H\u00C6\u0003\u00A2\u0006\u0004\b\n\u0010\u000BJ\u0012\u0010\f\u001A\u0004\u0018\u00010\u0002H\u00C6\u0003\u00A2\u0006\u0004\b\f\u0010\u0004J\u0012\u0010\r\u001A\u0004\u0018\u00010\u0005H\u00C6\u0003\u00A2\u0006\u0004\b\r\u0010\u000BJ\u0012\u0010\u000E\u001A\u0004\u0018\u00010\u0002H\u00C6\u0003\u00A2\u0006\u0004\b\u000E\u0010\u0004J\u0012\u0010\u0010\u001A\u0004\u0018\u00010\u000FH\u00C6\u0003\u00A2\u0006\u0004\b\u0010\u0010\u0011J\u0010\u0010\u0012\u001A\u00020\u0002H\u00C6\u0003\u00A2\u0006\u0004\b\u0012\u0010\u0004J\u0010\u0010\u0013\u001A\u00020\u0002H\u00C6\u0003\u00A2\u0006\u0004\b\u0013\u0010\u0004J\u0010\u0010\u0014\u001A\u00020\u0002H\u00C6\u0003\u00A2\u0006\u0004\b\u0014\u0010\u0004J\u0010\u0010\u0015\u001A\u00020\u0002H\u00C6\u0003\u00A2\u0006\u0004\b\u0015\u0010\u0004J\u0010\u0010\u0016\u001A\u00020\u0002H\u00C6\u0003\u00A2\u0006\u0004\b\u0016\u0010\u0004J\u0010\u0010\u0017\u001A\u00020\u0002H\u00C6\u0003\u00A2\u0006\u0004\b\u0017\u0010\u0004J\u0010\u0010\u0018\u001A\u00020\u0002H\u00C6\u0003\u00A2\u0006\u0004\b\u0018\u0010\u0004J\u0010\u0010\u0019\u001A\u00020\u0002H\u00C6\u0003\u00A2\u0006\u0004\b\u0019\u0010\u0004J\u0010\u0010\u001A\u001A\u00020\u0002H\u00C6\u0003\u00A2\u0006\u0004\b\u001A\u0010\u0004J\u0010\u0010\u001C\u001A\u00020\u001BH\u00C6\u0003\u00A2\u0006\u0004\b\u001C\u0010\u001DJ\u0010\u0010\u001F\u001A\u00020\u001EH\u00C6\u0003\u00A2\u0006\u0004\b\u001F\u0010 J\u0012\u0010\"\u001A\u0004\u0018\u00010!H\u00C6\u0003\u00A2\u0006\u0004\b\"\u0010#J\u001E\u0010%\u001A\u0010\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u0002\u0018\u00010$H\u00C6\u0003\u00A2\u0006\u0004\b%\u0010&J\u001E\u0010\'\u001A\u0010\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u0001\u0018\u00010$H\u00C6\u0003\u00A2\u0006\u0004\b\'\u0010&J\u00A0\u0002\u0010?\u001A\u00020\u00002\b\b\u0002\u0010(\u001A\u00020\u00022\b\b\u0002\u0010)\u001A\u00020\u00052\b\b\u0002\u0010*\u001A\u00020\u00022\n\b\u0002\u0010+\u001A\u0004\u0018\u00010\u00022\n\b\u0002\u0010,\u001A\u0004\u0018\u00010\u00052\n\b\u0002\u0010-\u001A\u0004\u0018\u00010\u00022\n\b\u0002\u0010.\u001A\u0004\u0018\u00010\u00052\n\b\u0002\u0010/\u001A\u0004\u0018\u00010\u00022\n\b\u0002\u00100\u001A\u0004\u0018\u00010\u000F2\b\b\u0002\u00101\u001A\u00020\u00022\b\b\u0002\u00102\u001A\u00020\u00022\b\b\u0002\u00103\u001A\u00020\u00022\b\b\u0002\u00104\u001A\u00020\u00022\b\b\u0002\u00105\u001A\u00020\u00022\b\b\u0002\u00106\u001A\u00020\u00022\b\b\u0002\u00107\u001A\u00020\u00022\b\b\u0002\u00108\u001A\u00020\u00022\b\b\u0002\u00109\u001A\u00020\u00022\b\b\u0002\u0010:\u001A\u00020\u001B2\b\b\u0002\u0010;\u001A\u00020\u001E2\n\b\u0002\u0010<\u001A\u0004\u0018\u00010!2\u0016\b\u0002\u0010=\u001A\u0010\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u0002\u0018\u00010$2\u0016\b\u0002\u0010>\u001A\u0010\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u0001\u0018\u00010$H\u00C6\u0001\u00A2\u0006\u0004\b?\u0010@J\u0010\u0010A\u001A\u00020\u0002H\u00D6\u0001\u00A2\u0006\u0004\bA\u0010\u0004J\u0010\u0010B\u001A\u00020\u000FH\u00D6\u0001\u00A2\u0006\u0004\bB\u0010CJ\u001A\u0010E\u001A\u00020\u00052\b\u0010D\u001A\u0004\u0018\u00010\u0001H\u00D6\u0003\u00A2\u0006\u0004\bE\u0010FR*\u0010=\u001A\u0010\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u0002\u0018\u00010$8\u0006@\u0007X\u0087\u0004\u00A2\u0006\f\n\u0004\b=\u0010G\u001A\u0004\bH\u0010&R\u001C\u00105\u001A\u00020\u00028\u0006@\u0007X\u0087\u0004\u00A2\u0006\f\n\u0004\b5\u0010I\u001A\u0004\bJ\u0010\u0004R\u001C\u0010(\u001A\u00020\u00028\u0006@\u0007X\u0087\u0004\u00A2\u0006\f\n\u0004\b(\u0010I\u001A\u0004\bK\u0010\u0004R\u001E\u0010<\u001A\u0004\u0018\u00010!8\u0006@\u0007X\u0087\u0004\u00A2\u0006\f\n\u0004\b<\u0010L\u001A\u0004\bM\u0010#R\u001E\u0010,\u001A\u0004\u0018\u00010\u00058\u0006@\u0007X\u0087\u0004\u00A2\u0006\f\n\u0004\b,\u0010N\u001A\u0004\bO\u0010\u000BR\u001C\u0010*\u001A\u00020\u00028\u0006@\u0007X\u0087\u0004\u00A2\u0006\f\n\u0004\b*\u0010I\u001A\u0004\bP\u0010\u0004R\u001C\u00101\u001A\u00020\u00028\u0006@\u0007X\u0087\u0004\u00A2\u0006\f\n\u0004\b1\u0010I\u001A\u0004\bQ\u0010\u0004R\u001E\u0010-\u001A\u0004\u0018\u00010\u00028\u0006@\u0007X\u0087\u0004\u00A2\u0006\f\n\u0004\b-\u0010I\u001A\u0004\bR\u0010\u0004R\u001C\u00102\u001A\u00020\u00028\u0006@\u0007X\u0087\u0004\u00A2\u0006\f\n\u0004\b2\u0010I\u001A\u0004\bS\u0010\u0004R\u001C\u00109\u001A\u00020\u00028\u0006@\u0007X\u0087\u0004\u00A2\u0006\f\n\u0004\b9\u0010I\u001A\u0004\bT\u0010\u0004R\u001C\u00106\u001A\u00020\u00028\u0006@\u0007X\u0087\u0004\u00A2\u0006\f\n\u0004\b6\u0010I\u001A\u0004\bU\u0010\u0004R\u001C\u00103\u001A\u00020\u00028\u0006@\u0007X\u0087\u0004\u00A2\u0006\f\n\u0004\b3\u0010I\u001A\u0004\bV\u0010\u0004R\u001E\u00100\u001A\u0004\u0018\u00010\u000F8\u0006@\u0007X\u0087\u0004\u00A2\u0006\f\n\u0004\b0\u0010W\u001A\u0004\bX\u0010\u0011R\u001C\u0010)\u001A\u00020\u00058\u0006@\u0007X\u0087\u0004\u00A2\u0006\f\n\u0004\b)\u0010Y\u001A\u0004\bZ\u0010\u0007R\u001E\u0010.\u001A\u0004\u0018\u00010\u00058\u0006@\u0007X\u0087\u0004\u00A2\u0006\f\n\u0004\b.\u0010N\u001A\u0004\b[\u0010\u000BR\u001E\u0010/\u001A\u0004\u0018\u00010\u00028\u0006@\u0007X\u0087\u0004\u00A2\u0006\f\n\u0004\b/\u0010I\u001A\u0004\b\\\u0010\u0004R\u001C\u00107\u001A\u00020\u00028\u0006@\u0007X\u0087\u0004\u00A2\u0006\f\n\u0004\b7\u0010I\u001A\u0004\b]\u0010\u0004R\u001C\u00108\u001A\u00020\u00028\u0006@\u0007X\u0087\u0004\u00A2\u0006\f\n\u0004\b8\u0010I\u001A\u0004\b^\u0010\u0004R\u001C\u0010;\u001A\u00020\u001E8\u0006@\u0007X\u0087\u0004\u00A2\u0006\f\n\u0004\b;\u0010_\u001A\u0004\b`\u0010 R\u001C\u00104\u001A\u00020\u00028\u0006@\u0007X\u0087\u0004\u00A2\u0006\f\n\u0004\b4\u0010I\u001A\u0004\ba\u0010\u0004R*\u0010>\u001A\u0010\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u0001\u0018\u00010$8\u0006@\u0007X\u0087\u0004\u00A2\u0006\f\n\u0004\b>\u0010G\u001A\u0004\bb\u0010&R\u001E\u0010+\u001A\u0004\u0018\u00010\u00028\u0006@\u0007X\u0087\u0004\u00A2\u0006\f\n\u0004\b+\u0010I\u001A\u0004\bc\u0010\u0004R\u001C\u0010:\u001A\u00020\u001B8\u0006@\u0007X\u0087\u0004\u00A2\u0006\f\n\u0004\b:\u0010d\u001A\u0004\be\u0010\u001D\u00A8\u0006h"}, d2 = {"Lco/ab180/airbridge/internal/network/model/DeviceInfo;", "", "", "component1", "()Ljava/lang/String;", "", "component2", "()Z", "component3", "component4", "component5", "()Ljava/lang/Boolean;", "component6", "component7", "component8", "", "component9", "()Ljava/lang/Integer;", "component10", "component11", "component12", "component13", "component14", "component15", "component16", "component17", "component18", "Lco/ab180/airbridge/internal/network/model/ScreenInfo;", "component19", "()Lco/ab180/airbridge/internal/network/model/ScreenInfo;", "Lco/ab180/airbridge/internal/network/model/NetworkInfo;", "component20", "()Lco/ab180/airbridge/internal/network/model/NetworkInfo;", "Lco/ab180/airbridge/internal/network/model/LocationInfo;", "component21", "()Lco/ab180/airbridge/internal/network/model/LocationInfo;", "", "component22", "()Ljava/util/Map;", "component23", "uuid", "hasDataBeforeAppSetIDCollected", "backupUUID", "gaid", "limitAdTracking", "oaid", "oaidLimitAdTracking", "appSetID", "appSetIDScope", "model", "type", "ip", "manufacturer", "osName", "osVersion", "locale", "timezone", "orientation", "screenInfo", "networkInfo", "locationInfo", "alias", "iabtcf", "copy", "(Ljava/lang/String;ZLjava/lang/String;Ljava/lang/String;Ljava/lang/Boolean;Ljava/lang/String;Ljava/lang/Boolean;Ljava/lang/String;Ljava/lang/Integer;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Lco/ab180/airbridge/internal/network/model/ScreenInfo;Lco/ab180/airbridge/internal/network/model/NetworkInfo;Lco/ab180/airbridge/internal/network/model/LocationInfo;Ljava/util/Map;Ljava/util/Map;)Lco/ab180/airbridge/internal/network/model/DeviceInfo;", "toString", "hashCode", "()I", "other", "equals", "(Ljava/lang/Object;)Z", "Ljava/util/Map;", "getAlias", "Ljava/lang/String;", "getOsName", "getUuid", "Lco/ab180/airbridge/internal/network/model/LocationInfo;", "getLocationInfo", "Ljava/lang/Boolean;", "getLimitAdTracking", "getBackupUUID", "getModel", "getOaid", "getType", "getOrientation", "getOsVersion", "getIp", "Ljava/lang/Integer;", "getAppSetIDScope", "Z", "getHasDataBeforeAppSetIDCollected", "getOaidLimitAdTracking", "getAppSetID", "getLocale", "getTimezone", "Lco/ab180/airbridge/internal/network/model/NetworkInfo;", "getNetworkInfo", "getManufacturer", "getIabtcf", "getGaid", "Lco/ab180/airbridge/internal/network/model/ScreenInfo;", "getScreenInfo", "<init>", "(Ljava/lang/String;ZLjava/lang/String;Ljava/lang/String;Ljava/lang/Boolean;Ljava/lang/String;Ljava/lang/Boolean;Ljava/lang/String;Ljava/lang/Integer;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Lco/ab180/airbridge/internal/network/model/ScreenInfo;Lco/ab180/airbridge/internal/network/model/NetworkInfo;Lco/ab180/airbridge/internal/network/model/LocationInfo;Ljava/util/Map;Ljava/util/Map;)V", "airbridge_release"}, k = 1, mv = {1, 4, 3})
public final class DeviceInfo {
    @d("alias")
    @Nullable
    private final Map alias;
    @d("appSetID")
    @Nullable
    private final String appSetID;
    @d("appSetIDScope")
    @Nullable
    private final Integer appSetIDScope;
    @d("airbridgeGeneratedDeviceUUID")
    @NotNull
    private final String backupUUID;
    @d("gaid")
    @Nullable
    private final String gaid;
    @d("hasDataBeforeAppSetIDCollected")
    private final boolean hasDataBeforeAppSetIDCollected;
    @d("iabtcf")
    @Nullable
    private final Map iabtcf;
    @d("deviceIP")
    @NotNull
    private final String ip;
    @d("limitAdTracking")
    @Nullable
    private final Boolean limitAdTracking;
    @d("locale")
    @NotNull
    private final String locale;
    @d("location")
    @Nullable
    private final LocationInfo locationInfo;
    @d("manufacturer")
    @NotNull
    private final String manufacturer;
    @d("deviceModel")
    @NotNull
    private final String model;
    @d("network")
    @NotNull
    private final NetworkInfo networkInfo;
    @d("oaid")
    @Nullable
    private final String oaid;
    @d("oaidLimitAdTracking")
    @Nullable
    private final Boolean oaidLimitAdTracking;
    @d("orientation")
    @NotNull
    private final String orientation;
    @d("osName")
    @NotNull
    private final String osName;
    @d("osVersion")
    @NotNull
    private final String osVersion;
    @d("screen")
    @NotNull
    private final ScreenInfo screenInfo;
    @d("timezone")
    @NotNull
    private final String timezone;
    @d("deviceType")
    @NotNull
    private final String type;
    @d("deviceUUID")
    @NotNull
    private final String uuid;

    public DeviceInfo(@NotNull String s, boolean z, @NotNull String s1, @Nullable String s2, @Nullable Boolean boolean0, @Nullable String s3, @Nullable Boolean boolean1, @Nullable String s4, @Nullable Integer integer0, @NotNull String s5, @NotNull String s6, @NotNull String s7, @NotNull String s8, @NotNull String s9, @NotNull String s10, @NotNull String s11, @NotNull String s12, @NotNull String s13, @NotNull ScreenInfo screenInfo0, @NotNull NetworkInfo networkInfo0, @Nullable LocationInfo locationInfo0, @Nullable Map map0, @Nullable Map map1) {
        this.uuid = s;
        this.hasDataBeforeAppSetIDCollected = z;
        this.backupUUID = s1;
        this.gaid = s2;
        this.limitAdTracking = boolean0;
        this.oaid = s3;
        this.oaidLimitAdTracking = boolean1;
        this.appSetID = s4;
        this.appSetIDScope = integer0;
        this.model = s5;
        this.type = s6;
        this.ip = s7;
        this.manufacturer = s8;
        this.osName = s9;
        this.osVersion = s10;
        this.locale = s11;
        this.timezone = s12;
        this.orientation = s13;
        this.screenInfo = screenInfo0;
        this.networkInfo = networkInfo0;
        this.locationInfo = locationInfo0;
        this.alias = map0;
        this.iabtcf = map1;
    }

    public DeviceInfo(String s, boolean z, String s1, String s2, Boolean boolean0, String s3, Boolean boolean1, String s4, Integer integer0, String s5, String s6, String s7, String s8, String s9, String s10, String s11, String s12, String s13, ScreenInfo screenInfo0, NetworkInfo networkInfo0, LocationInfo locationInfo0, Map map0, Map map1, int v, DefaultConstructorMarker defaultConstructorMarker0) {
        this(s, z, s1, s2, boolean0, s3, boolean1, s4, integer0, s5, s6, s7, s8, s9, s10, s11, s12, s13, screenInfo0, networkInfo0, ((v & 0x100000) == 0 ? locationInfo0 : null), ((v & 0x200000) == 0 ? map0 : null), ((v & 0x400000) == 0 ? map1 : null));
    }

    @NotNull
    public final String component1() {
        return this.uuid;
    }

    @NotNull
    public final String component10() {
        return this.model;
    }

    @NotNull
    public final String component11() {
        return this.type;
    }

    @NotNull
    public final String component12() {
        return this.ip;
    }

    @NotNull
    public final String component13() {
        return this.manufacturer;
    }

    @NotNull
    public final String component14() {
        return this.osName;
    }

    @NotNull
    public final String component15() {
        return this.osVersion;
    }

    @NotNull
    public final String component16() {
        return this.locale;
    }

    @NotNull
    public final String component17() {
        return this.timezone;
    }

    @NotNull
    public final String component18() {
        return this.orientation;
    }

    @NotNull
    public final ScreenInfo component19() {
        return this.screenInfo;
    }

    public final boolean component2() {
        return this.hasDataBeforeAppSetIDCollected;
    }

    @NotNull
    public final NetworkInfo component20() {
        return this.networkInfo;
    }

    @Nullable
    public final LocationInfo component21() {
        return this.locationInfo;
    }

    @Nullable
    public final Map component22() {
        return this.alias;
    }

    @Nullable
    public final Map component23() {
        return this.iabtcf;
    }

    @NotNull
    public final String component3() {
        return this.backupUUID;
    }

    @Nullable
    public final String component4() {
        return this.gaid;
    }

    @Nullable
    public final Boolean component5() {
        return this.limitAdTracking;
    }

    @Nullable
    public final String component6() {
        return this.oaid;
    }

    @Nullable
    public final Boolean component7() {
        return this.oaidLimitAdTracking;
    }

    @Nullable
    public final String component8() {
        return this.appSetID;
    }

    @Nullable
    public final Integer component9() {
        return this.appSetIDScope;
    }

    @NotNull
    public final DeviceInfo copy(@NotNull String s, boolean z, @NotNull String s1, @Nullable String s2, @Nullable Boolean boolean0, @Nullable String s3, @Nullable Boolean boolean1, @Nullable String s4, @Nullable Integer integer0, @NotNull String s5, @NotNull String s6, @NotNull String s7, @NotNull String s8, @NotNull String s9, @NotNull String s10, @NotNull String s11, @NotNull String s12, @NotNull String s13, @NotNull ScreenInfo screenInfo0, @NotNull NetworkInfo networkInfo0, @Nullable LocationInfo locationInfo0, @Nullable Map map0, @Nullable Map map1) {
        return new DeviceInfo(s, z, s1, s2, boolean0, s3, boolean1, s4, integer0, s5, s6, s7, s8, s9, s10, s11, s12, s13, screenInfo0, networkInfo0, locationInfo0, map0, map1);
    }

    public static DeviceInfo copy$default(DeviceInfo deviceInfo0, String s, boolean z, String s1, String s2, Boolean boolean0, String s3, Boolean boolean1, String s4, Integer integer0, String s5, String s6, String s7, String s8, String s9, String s10, String s11, String s12, String s13, ScreenInfo screenInfo0, NetworkInfo networkInfo0, LocationInfo locationInfo0, Map map0, Map map1, int v, Object object0) {
        String s14 = (v & 1) == 0 ? s : deviceInfo0.uuid;
        boolean z1 = (v & 2) == 0 ? z : deviceInfo0.hasDataBeforeAppSetIDCollected;
        String s15 = (v & 4) == 0 ? s1 : deviceInfo0.backupUUID;
        String s16 = (v & 8) == 0 ? s2 : deviceInfo0.gaid;
        Boolean boolean2 = (v & 16) == 0 ? boolean0 : deviceInfo0.limitAdTracking;
        String s17 = (v & 0x20) == 0 ? s3 : deviceInfo0.oaid;
        Boolean boolean3 = (v & 0x40) == 0 ? boolean1 : deviceInfo0.oaidLimitAdTracking;
        String s18 = (v & 0x80) == 0 ? s4 : deviceInfo0.appSetID;
        Integer integer1 = (v & 0x100) == 0 ? integer0 : deviceInfo0.appSetIDScope;
        String s19 = (v & 0x200) == 0 ? s5 : deviceInfo0.model;
        String s20 = (v & 0x400) == 0 ? s6 : deviceInfo0.type;
        String s21 = (v & 0x800) == 0 ? s7 : deviceInfo0.ip;
        String s22 = (v & 0x1000) == 0 ? s8 : deviceInfo0.manufacturer;
        String s23 = (v & 0x2000) == 0 ? s9 : deviceInfo0.osName;
        String s24 = (v & 0x4000) == 0 ? s10 : deviceInfo0.osVersion;
        String s25 = (v & 0x8000) == 0 ? s11 : deviceInfo0.locale;
        String s26 = (v & 0x10000) == 0 ? s12 : deviceInfo0.timezone;
        String s27 = (v & 0x20000) == 0 ? s13 : deviceInfo0.orientation;
        ScreenInfo screenInfo1 = (v & 0x40000) == 0 ? screenInfo0 : deviceInfo0.screenInfo;
        NetworkInfo networkInfo1 = (v & 0x80000) == 0 ? networkInfo0 : deviceInfo0.networkInfo;
        LocationInfo locationInfo1 = (v & 0x100000) == 0 ? locationInfo0 : deviceInfo0.locationInfo;
        Map map2 = (v & 0x200000) == 0 ? map0 : deviceInfo0.alias;
        return (v & 0x400000) == 0 ? deviceInfo0.copy(s14, z1, s15, s16, boolean2, s17, boolean3, s18, integer1, s19, s20, s21, s22, s23, s24, s25, s26, s27, screenInfo1, networkInfo1, locationInfo1, map2, map1) : deviceInfo0.copy(s14, z1, s15, s16, boolean2, s17, boolean3, s18, integer1, s19, s20, s21, s22, s23, s24, s25, s26, s27, screenInfo1, networkInfo1, locationInfo1, map2, deviceInfo0.iabtcf);
    }

    // 去混淆评级： 低(38)
    @Override
    public boolean equals(@Nullable Object object0) {
        if(this != object0) {
            if(object0 instanceof DeviceInfo) {
                DeviceInfo deviceInfo0 = (DeviceInfo)object0;
                return q.b(this.uuid, deviceInfo0.uuid) && this.hasDataBeforeAppSetIDCollected == deviceInfo0.hasDataBeforeAppSetIDCollected && q.b(this.backupUUID, deviceInfo0.backupUUID) && q.b(this.gaid, deviceInfo0.gaid) && q.b(this.limitAdTracking, deviceInfo0.limitAdTracking) && q.b(this.oaid, deviceInfo0.oaid) && q.b(this.oaidLimitAdTracking, deviceInfo0.oaidLimitAdTracking) && q.b(this.appSetID, deviceInfo0.appSetID) && q.b(this.appSetIDScope, deviceInfo0.appSetIDScope) && q.b(this.model, deviceInfo0.model) && q.b(this.type, deviceInfo0.type) && q.b(this.ip, deviceInfo0.ip) && q.b(this.manufacturer, deviceInfo0.manufacturer) && q.b(this.osName, deviceInfo0.osName) && q.b(this.osVersion, deviceInfo0.osVersion) && q.b(this.locale, deviceInfo0.locale) && q.b(this.timezone, deviceInfo0.timezone) && q.b(this.orientation, deviceInfo0.orientation) && q.b(this.screenInfo, deviceInfo0.screenInfo) && q.b(this.networkInfo, deviceInfo0.networkInfo) && q.b(this.locationInfo, deviceInfo0.locationInfo) && q.b(this.alias, deviceInfo0.alias) && q.b(this.iabtcf, deviceInfo0.iabtcf);
            }
            return false;
        }
        return true;
    }

    @Nullable
    public final Map getAlias() {
        return this.alias;
    }

    @Nullable
    public final String getAppSetID() {
        return this.appSetID;
    }

    @Nullable
    public final Integer getAppSetIDScope() {
        return this.appSetIDScope;
    }

    @NotNull
    public final String getBackupUUID() {
        return this.backupUUID;
    }

    @Nullable
    public final String getGaid() {
        return this.gaid;
    }

    public final boolean getHasDataBeforeAppSetIDCollected() {
        return this.hasDataBeforeAppSetIDCollected;
    }

    @Nullable
    public final Map getIabtcf() {
        return this.iabtcf;
    }

    @NotNull
    public final String getIp() {
        return this.ip;
    }

    @Nullable
    public final Boolean getLimitAdTracking() {
        return this.limitAdTracking;
    }

    @NotNull
    public final String getLocale() {
        return this.locale;
    }

    @Nullable
    public final LocationInfo getLocationInfo() {
        return this.locationInfo;
    }

    @NotNull
    public final String getManufacturer() {
        return this.manufacturer;
    }

    @NotNull
    public final String getModel() {
        return this.model;
    }

    @NotNull
    public final NetworkInfo getNetworkInfo() {
        return this.networkInfo;
    }

    @Nullable
    public final String getOaid() {
        return this.oaid;
    }

    @Nullable
    public final Boolean getOaidLimitAdTracking() {
        return this.oaidLimitAdTracking;
    }

    @NotNull
    public final String getOrientation() {
        return this.orientation;
    }

    @NotNull
    public final String getOsName() {
        return this.osName;
    }

    @NotNull
    public final String getOsVersion() {
        return this.osVersion;
    }

    @NotNull
    public final ScreenInfo getScreenInfo() {
        return this.screenInfo;
    }

    @NotNull
    public final String getTimezone() {
        return this.timezone;
    }

    @NotNull
    public final String getType() {
        return this.type;
    }

    @NotNull
    public final String getUuid() {
        return this.uuid;
    }

    @Override
    public int hashCode() {
        int v = 0;
        int v1 = this.uuid == null ? 0 : this.uuid.hashCode();
        int v2 = this.hasDataBeforeAppSetIDCollected;
        if(v2) {
            v2 = 1;
        }
        int v3 = this.backupUUID == null ? 0 : this.backupUUID.hashCode();
        int v4 = this.gaid == null ? 0 : this.gaid.hashCode();
        int v5 = this.limitAdTracking == null ? 0 : this.limitAdTracking.hashCode();
        int v6 = this.oaid == null ? 0 : this.oaid.hashCode();
        int v7 = this.oaidLimitAdTracking == null ? 0 : this.oaidLimitAdTracking.hashCode();
        int v8 = this.appSetID == null ? 0 : this.appSetID.hashCode();
        int v9 = this.appSetIDScope == null ? 0 : this.appSetIDScope.hashCode();
        int v10 = this.model == null ? 0 : this.model.hashCode();
        int v11 = this.type == null ? 0 : this.type.hashCode();
        int v12 = this.ip == null ? 0 : this.ip.hashCode();
        int v13 = this.manufacturer == null ? 0 : this.manufacturer.hashCode();
        int v14 = this.osName == null ? 0 : this.osName.hashCode();
        int v15 = this.osVersion == null ? 0 : this.osVersion.hashCode();
        int v16 = this.locale == null ? 0 : this.locale.hashCode();
        int v17 = this.timezone == null ? 0 : this.timezone.hashCode();
        int v18 = this.orientation == null ? 0 : this.orientation.hashCode();
        int v19 = this.screenInfo == null ? 0 : this.screenInfo.hashCode();
        int v20 = this.networkInfo == null ? 0 : this.networkInfo.hashCode();
        int v21 = this.locationInfo == null ? 0 : this.locationInfo.hashCode();
        int v22 = this.alias == null ? 0 : this.alias.hashCode();
        Map map0 = this.iabtcf;
        if(map0 != null) {
            v = map0.hashCode();
        }
        return (((((((((((((((((((((v1 * 0x1F + v2) * 0x1F + v3) * 0x1F + v4) * 0x1F + v5) * 0x1F + v6) * 0x1F + v7) * 0x1F + v8) * 0x1F + v9) * 0x1F + v10) * 0x1F + v11) * 0x1F + v12) * 0x1F + v13) * 0x1F + v14) * 0x1F + v15) * 0x1F + v16) * 0x1F + v17) * 0x1F + v18) * 0x1F + v19) * 0x1F + v20) * 0x1F + v21) * 0x1F + v22) * 0x1F + v;
    }

    @Override
    @NotNull
    public String toString() {
        return "DeviceInfo(uuid=" + this.uuid + ", hasDataBeforeAppSetIDCollected=" + this.hasDataBeforeAppSetIDCollected + ", backupUUID=" + this.backupUUID + ", gaid=" + this.gaid + ", limitAdTracking=" + this.limitAdTracking + ", oaid=" + this.oaid + ", oaidLimitAdTracking=" + this.oaidLimitAdTracking + ", appSetID=" + this.appSetID + ", appSetIDScope=" + this.appSetIDScope + ", model=" + this.model + ", type=" + this.type + ", ip=" + this.ip + ", manufacturer=" + this.manufacturer + ", osName=" + this.osName + ", osVersion=" + this.osVersion + ", locale=" + this.locale + ", timezone=" + this.timezone + ", orientation=" + this.orientation + ", screenInfo=" + this.screenInfo + ", networkInfo=" + this.networkInfo + ", locationInfo=" + this.locationInfo + ", alias=" + this.alias + ", iabtcf=" + this.iabtcf + ")";
    }
}


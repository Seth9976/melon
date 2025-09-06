package com.melon.playback.melon.model;

import A7.d;
import U4.x;
import ac.y;
import com.melon.playback.melon.streaming.tracker.NetworkEvents;
import k8.Y;
import kotlin.Metadata;
import kotlin.jvm.internal.q;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000B\n\u0002\b\u0005\n\u0002\u0010\u000E\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0016\n\u0002\u0010\b\n\u0002\b\u0012\b\u0087\b\u0018\u0000 52\u00020\u0001:\u00016Bg\u0012\u0006\u0010\u0003\u001A\u00020\u0002\u0012\u0006\u0010\u0004\u001A\u00020\u0002\u0012\u0006\u0010\u0005\u001A\u00020\u0002\u0012\u0006\u0010\u0006\u001A\u00020\u0002\u0012\u0006\u0010\u0007\u001A\u00020\u0002\u0012\u0006\u0010\t\u001A\u00020\b\u0012\u0006\u0010\n\u001A\u00020\b\u0012\u0006\u0010\u000B\u001A\u00020\b\u0012\u0006\u0010\f\u001A\u00020\b\u0012\u0006\u0010\r\u001A\u00020\b\u0012\u0006\u0010\u000F\u001A\u00020\u000E\u0012\u0006\u0010\u0010\u001A\u00020\b\u00A2\u0006\u0004\b\u0011\u0010\u0012J\u0010\u0010\u0013\u001A\u00020\u0002H\u00C6\u0003\u00A2\u0006\u0004\b\u0013\u0010\u0014J\u0010\u0010\u0015\u001A\u00020\u0002H\u00C6\u0003\u00A2\u0006\u0004\b\u0015\u0010\u0014J\u0010\u0010\u0016\u001A\u00020\u0002H\u00C6\u0003\u00A2\u0006\u0004\b\u0016\u0010\u0014J\u0010\u0010\u0017\u001A\u00020\u0002H\u00C6\u0003\u00A2\u0006\u0004\b\u0017\u0010\u0014J\u0010\u0010\u0018\u001A\u00020\u0002H\u00C6\u0003\u00A2\u0006\u0004\b\u0018\u0010\u0014J\u0010\u0010\u0019\u001A\u00020\bH\u00C6\u0003\u00A2\u0006\u0004\b\u0019\u0010\u001AJ\u0010\u0010\u001B\u001A\u00020\bH\u00C6\u0003\u00A2\u0006\u0004\b\u001B\u0010\u001AJ\u0010\u0010\u001C\u001A\u00020\bH\u00C6\u0003\u00A2\u0006\u0004\b\u001C\u0010\u001AJ\u0010\u0010\u001D\u001A\u00020\bH\u00C6\u0003\u00A2\u0006\u0004\b\u001D\u0010\u001AJ\u0010\u0010\u001E\u001A\u00020\bH\u00C6\u0003\u00A2\u0006\u0004\b\u001E\u0010\u001AJ\u0010\u0010\u001F\u001A\u00020\u000EH\u00C6\u0003\u00A2\u0006\u0004\b\u001F\u0010 J\u0010\u0010!\u001A\u00020\bH\u00C6\u0003\u00A2\u0006\u0004\b!\u0010\u001AJ\u0088\u0001\u0010\"\u001A\u00020\u00002\b\b\u0002\u0010\u0003\u001A\u00020\u00022\b\b\u0002\u0010\u0004\u001A\u00020\u00022\b\b\u0002\u0010\u0005\u001A\u00020\u00022\b\b\u0002\u0010\u0006\u001A\u00020\u00022\b\b\u0002\u0010\u0007\u001A\u00020\u00022\b\b\u0002\u0010\t\u001A\u00020\b2\b\b\u0002\u0010\n\u001A\u00020\b2\b\b\u0002\u0010\u000B\u001A\u00020\b2\b\b\u0002\u0010\f\u001A\u00020\b2\b\b\u0002\u0010\r\u001A\u00020\b2\b\b\u0002\u0010\u000F\u001A\u00020\u000E2\b\b\u0002\u0010\u0010\u001A\u00020\bH\u00C6\u0001\u00A2\u0006\u0004\b\"\u0010#J\u0010\u0010$\u001A\u00020\bH\u00D6\u0001\u00A2\u0006\u0004\b$\u0010\u001AJ\u0010\u0010&\u001A\u00020%H\u00D6\u0001\u00A2\u0006\u0004\b&\u0010\'J\u001A\u0010)\u001A\u00020\u00022\b\u0010(\u001A\u0004\u0018\u00010\u0001H\u00D6\u0003\u00A2\u0006\u0004\b)\u0010*R\u0017\u0010\u0003\u001A\u00020\u00028\u0006\u00A2\u0006\f\n\u0004\b\u0003\u0010+\u001A\u0004\b\u0003\u0010\u0014R\u0017\u0010\u0004\u001A\u00020\u00028\u0006\u00A2\u0006\f\n\u0004\b\u0004\u0010+\u001A\u0004\b\u0004\u0010\u0014R\u0017\u0010\u0005\u001A\u00020\u00028\u0006\u00A2\u0006\f\n\u0004\b\u0005\u0010+\u001A\u0004\b\u0005\u0010\u0014R\u0017\u0010\u0006\u001A\u00020\u00028\u0006\u00A2\u0006\f\n\u0004\b\u0006\u0010+\u001A\u0004\b\u0006\u0010\u0014R\u0017\u0010\u0007\u001A\u00020\u00028\u0006\u00A2\u0006\f\n\u0004\b\u0007\u0010+\u001A\u0004\b\u0007\u0010\u0014R\u0017\u0010\t\u001A\u00020\b8\u0006\u00A2\u0006\f\n\u0004\b\t\u0010,\u001A\u0004\b-\u0010\u001AR\u0017\u0010\n\u001A\u00020\b8\u0006\u00A2\u0006\f\n\u0004\b\n\u0010,\u001A\u0004\b.\u0010\u001AR\u0017\u0010\u000B\u001A\u00020\b8\u0006\u00A2\u0006\f\n\u0004\b\u000B\u0010,\u001A\u0004\b/\u0010\u001AR\u0017\u0010\f\u001A\u00020\b8\u0006\u00A2\u0006\f\n\u0004\b\f\u0010,\u001A\u0004\b0\u0010\u001AR\u0017\u0010\r\u001A\u00020\b8\u0006\u00A2\u0006\f\n\u0004\b\r\u0010,\u001A\u0004\b1\u0010\u001AR\u0017\u0010\u000F\u001A\u00020\u000E8\u0006\u00A2\u0006\f\n\u0004\b\u000F\u00102\u001A\u0004\b3\u0010 R\u0017\u0010\u0010\u001A\u00020\b8\u0006\u00A2\u0006\f\n\u0004\b\u0010\u0010,\u001A\u0004\b4\u0010\u001A\u00A8\u00067"}, d2 = {"Lcom/melon/playback/melon/model/PlaybackErrorReport;", "", "", "isPowerSaveMode", "isIgnoreBatteryOptimizations", "isBackgroundRestricted", "isAvailableBackgroundData", "isNotificationsEnabled", "", "contentId", "playerType", "mediaItemUri", "networkType", "streamingIp", "Lcom/melon/playback/melon/streaming/tracker/NetworkEvents;", "streamingApiInfo", "errorInfo", "<init>", "(ZZZZZLjava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Lcom/melon/playback/melon/streaming/tracker/NetworkEvents;Ljava/lang/String;)V", "component1", "()Z", "component2", "component3", "component4", "component5", "component6", "()Ljava/lang/String;", "component7", "component8", "component9", "component10", "component11", "()Lcom/melon/playback/melon/streaming/tracker/NetworkEvents;", "component12", "copy", "(ZZZZZLjava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Lcom/melon/playback/melon/streaming/tracker/NetworkEvents;Ljava/lang/String;)Lcom/melon/playback/melon/model/PlaybackErrorReport;", "toString", "", "hashCode", "()I", "other", "equals", "(Ljava/lang/Object;)Z", "Z", "Ljava/lang/String;", "getContentId", "getPlayerType", "getMediaItemUri", "getNetworkType", "getStreamingIp", "Lcom/melon/playback/melon/streaming/tracker/NetworkEvents;", "getStreamingApiInfo", "getErrorInfo", "Companion", "ac/y", "app_playstoreProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 0x30)
public final class PlaybackErrorReport {
    public static final int $stable = 8;
    @NotNull
    public static final y Companion;
    @NotNull
    private final String contentId;
    @NotNull
    private final String errorInfo;
    private final boolean isAvailableBackgroundData;
    private final boolean isBackgroundRestricted;
    private final boolean isIgnoreBatteryOptimizations;
    private final boolean isNotificationsEnabled;
    private final boolean isPowerSaveMode;
    @NotNull
    private final String mediaItemUri;
    @NotNull
    private final String networkType;
    @NotNull
    private final String playerType;
    @NotNull
    private final NetworkEvents streamingApiInfo;
    @NotNull
    private final String streamingIp;

    static {
        PlaybackErrorReport.Companion = new y();  // 初始化器: Ljava/lang/Object;-><init>()V
    }

    public PlaybackErrorReport(boolean z, boolean z1, boolean z2, boolean z3, boolean z4, @NotNull String s, @NotNull String s1, @NotNull String s2, @NotNull String s3, @NotNull String s4, @NotNull NetworkEvents networkEvents0, @NotNull String s5) {
        q.g(s, "contentId");
        q.g(s1, "playerType");
        q.g(s2, "mediaItemUri");
        q.g(s3, "networkType");
        q.g(s4, "streamingIp");
        q.g(networkEvents0, "streamingApiInfo");
        q.g(s5, "errorInfo");
        super();
        this.isPowerSaveMode = z;
        this.isIgnoreBatteryOptimizations = z1;
        this.isBackgroundRestricted = z2;
        this.isAvailableBackgroundData = z3;
        this.isNotificationsEnabled = z4;
        this.contentId = s;
        this.playerType = s1;
        this.mediaItemUri = s2;
        this.networkType = s3;
        this.streamingIp = s4;
        this.streamingApiInfo = networkEvents0;
        this.errorInfo = s5;
    }

    public final boolean component1() {
        return this.isPowerSaveMode;
    }

    @NotNull
    public final String component10() {
        return this.streamingIp;
    }

    @NotNull
    public final NetworkEvents component11() {
        return this.streamingApiInfo;
    }

    @NotNull
    public final String component12() {
        return this.errorInfo;
    }

    public final boolean component2() {
        return this.isIgnoreBatteryOptimizations;
    }

    public final boolean component3() {
        return this.isBackgroundRestricted;
    }

    public final boolean component4() {
        return this.isAvailableBackgroundData;
    }

    public final boolean component5() {
        return this.isNotificationsEnabled;
    }

    @NotNull
    public final String component6() {
        return this.contentId;
    }

    @NotNull
    public final String component7() {
        return this.playerType;
    }

    @NotNull
    public final String component8() {
        return this.mediaItemUri;
    }

    @NotNull
    public final String component9() {
        return this.networkType;
    }

    @NotNull
    public final PlaybackErrorReport copy(boolean z, boolean z1, boolean z2, boolean z3, boolean z4, @NotNull String s, @NotNull String s1, @NotNull String s2, @NotNull String s3, @NotNull String s4, @NotNull NetworkEvents networkEvents0, @NotNull String s5) {
        q.g(s, "contentId");
        q.g(s1, "playerType");
        q.g(s2, "mediaItemUri");
        q.g(s3, "networkType");
        q.g(s4, "streamingIp");
        q.g(networkEvents0, "streamingApiInfo");
        q.g(s5, "errorInfo");
        return new PlaybackErrorReport(z, z1, z2, z3, z4, s, s1, s2, s3, s4, networkEvents0, s5);
    }

    public static PlaybackErrorReport copy$default(PlaybackErrorReport playbackErrorReport0, boolean z, boolean z1, boolean z2, boolean z3, boolean z4, String s, String s1, String s2, String s3, String s4, NetworkEvents networkEvents0, String s5, int v, Object object0) {
        if((v & 1) != 0) {
            z = playbackErrorReport0.isPowerSaveMode;
        }
        if((v & 2) != 0) {
            z1 = playbackErrorReport0.isIgnoreBatteryOptimizations;
        }
        if((v & 4) != 0) {
            z2 = playbackErrorReport0.isBackgroundRestricted;
        }
        if((v & 8) != 0) {
            z3 = playbackErrorReport0.isAvailableBackgroundData;
        }
        if((v & 16) != 0) {
            z4 = playbackErrorReport0.isNotificationsEnabled;
        }
        if((v & 0x20) != 0) {
            s = playbackErrorReport0.contentId;
        }
        if((v & 0x40) != 0) {
            s1 = playbackErrorReport0.playerType;
        }
        if((v & 0x80) != 0) {
            s2 = playbackErrorReport0.mediaItemUri;
        }
        if((v & 0x100) != 0) {
            s3 = playbackErrorReport0.networkType;
        }
        if((v & 0x200) != 0) {
            s4 = playbackErrorReport0.streamingIp;
        }
        if((v & 0x400) != 0) {
            networkEvents0 = playbackErrorReport0.streamingApiInfo;
        }
        if((v & 0x800) != 0) {
            s5 = playbackErrorReport0.errorInfo;
        }
        return playbackErrorReport0.copy(z, z1, z2, z3, z4, s, s1, s2, s3, s4, networkEvents0, s5);
    }

    @Override
    public boolean equals(@Nullable Object object0) {
        if(this == object0) {
            return true;
        }
        if(!(object0 instanceof PlaybackErrorReport)) {
            return false;
        }
        if(this.isPowerSaveMode != ((PlaybackErrorReport)object0).isPowerSaveMode) {
            return false;
        }
        if(this.isIgnoreBatteryOptimizations != ((PlaybackErrorReport)object0).isIgnoreBatteryOptimizations) {
            return false;
        }
        if(this.isBackgroundRestricted != ((PlaybackErrorReport)object0).isBackgroundRestricted) {
            return false;
        }
        if(this.isAvailableBackgroundData != ((PlaybackErrorReport)object0).isAvailableBackgroundData) {
            return false;
        }
        if(this.isNotificationsEnabled != ((PlaybackErrorReport)object0).isNotificationsEnabled) {
            return false;
        }
        if(!q.b(this.contentId, ((PlaybackErrorReport)object0).contentId)) {
            return false;
        }
        if(!q.b(this.playerType, ((PlaybackErrorReport)object0).playerType)) {
            return false;
        }
        if(!q.b(this.mediaItemUri, ((PlaybackErrorReport)object0).mediaItemUri)) {
            return false;
        }
        if(!q.b(this.networkType, ((PlaybackErrorReport)object0).networkType)) {
            return false;
        }
        if(!q.b(this.streamingIp, ((PlaybackErrorReport)object0).streamingIp)) {
            return false;
        }
        return q.b(this.streamingApiInfo, ((PlaybackErrorReport)object0).streamingApiInfo) ? q.b(this.errorInfo, ((PlaybackErrorReport)object0).errorInfo) : false;
    }

    @NotNull
    public final String getContentId() {
        return this.contentId;
    }

    @NotNull
    public final String getErrorInfo() {
        return this.errorInfo;
    }

    @NotNull
    public final String getMediaItemUri() {
        return this.mediaItemUri;
    }

    @NotNull
    public final String getNetworkType() {
        return this.networkType;
    }

    @NotNull
    public final String getPlayerType() {
        return this.playerType;
    }

    @NotNull
    public final NetworkEvents getStreamingApiInfo() {
        return this.streamingApiInfo;
    }

    @NotNull
    public final String getStreamingIp() {
        return this.streamingIp;
    }

    @Override
    public int hashCode() {
        return this.errorInfo.hashCode() + (this.streamingApiInfo.hashCode() + x.b(x.b(x.b(x.b(x.b(d.e(d.e(d.e(d.e(Boolean.hashCode(this.isPowerSaveMode) * 0x1F, 0x1F, this.isIgnoreBatteryOptimizations), 0x1F, this.isBackgroundRestricted), 0x1F, this.isAvailableBackgroundData), 0x1F, this.isNotificationsEnabled), 0x1F, this.contentId), 0x1F, this.playerType), 0x1F, this.mediaItemUri), 0x1F, this.networkType), 0x1F, this.streamingIp)) * 0x1F;
    }

    public final boolean isAvailableBackgroundData() {
        return this.isAvailableBackgroundData;
    }

    public final boolean isBackgroundRestricted() {
        return this.isBackgroundRestricted;
    }

    public final boolean isIgnoreBatteryOptimizations() {
        return this.isIgnoreBatteryOptimizations;
    }

    public final boolean isNotificationsEnabled() {
        return this.isNotificationsEnabled;
    }

    public final boolean isPowerSaveMode() {
        return this.isPowerSaveMode;
    }

    @Override
    @NotNull
    public String toString() {
        StringBuilder stringBuilder0 = Y.q("PlaybackErrorReport(isPowerSaveMode=", ", isIgnoreBatteryOptimizations=", this.isPowerSaveMode, ", isBackgroundRestricted=", this.isIgnoreBatteryOptimizations);
        x.y(stringBuilder0, this.isBackgroundRestricted, ", isAvailableBackgroundData=", this.isAvailableBackgroundData, ", isNotificationsEnabled=");
        Y.y(stringBuilder0, this.isNotificationsEnabled, ", contentId=", this.contentId, ", playerType=");
        d.u(stringBuilder0, this.playerType, ", mediaItemUri=", this.mediaItemUri, ", networkType=");
        d.u(stringBuilder0, this.networkType, ", streamingIp=", this.streamingIp, ", streamingApiInfo=");
        stringBuilder0.append(this.streamingApiInfo);
        stringBuilder0.append(", errorInfo=");
        stringBuilder0.append(this.errorInfo);
        stringBuilder0.append(")");
        return stringBuilder0.toString();
    }
}


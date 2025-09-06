package com.facebook.appevents.internal;

import android.content.SharedPreferences.Editor;
import android.content.SharedPreferences;
import android.preference.PreferenceManager;
import com.facebook.FacebookSdk;
import java.util.UUID;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.q;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u000E\n\u0002\u0010\b\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u000B\b\u0000\u0018\u0000 +2\u00020\u0001:\u0001+B\'\b\u0007\u0012\b\u0010\u0003\u001A\u0004\u0018\u00010\u0002\u0012\b\u0010\u0004\u001A\u0004\u0018\u00010\u0002\u0012\b\b\u0002\u0010\u0006\u001A\u00020\u0005¢\u0006\u0004\b\u0007\u0010\bJ\r\u0010\n\u001A\u00020\t¢\u0006\u0004\b\n\u0010\u000BJ\r\u0010\f\u001A\u00020\t¢\u0006\u0004\b\f\u0010\u000BR\u0019\u0010\u0003\u001A\u0004\u0018\u00010\u00028\u0006¢\u0006\f\n\u0004\b\u0003\u0010\r\u001A\u0004\b\u000E\u0010\u000FR$\u0010\u0004\u001A\u0004\u0018\u00010\u00028\u0006@\u0006X\u0086\u000E¢\u0006\u0012\n\u0004\b\u0004\u0010\r\u001A\u0004\b\u0010\u0010\u000F\"\u0004\b\u0011\u0010\u0012R\"\u0010\u0006\u001A\u00020\u00058\u0006@\u0006X\u0086\u000E¢\u0006\u0012\n\u0004\b\u0006\u0010\u0013\u001A\u0004\b\u0014\u0010\u0015\"\u0004\b\u0016\u0010\u0017R$\u0010\u001A\u001A\u00020\u00182\u0006\u0010\u0019\u001A\u00020\u00188\u0006@BX\u0086\u000E¢\u0006\f\n\u0004\b\u001A\u0010\u001B\u001A\u0004\b\u001C\u0010\u001DR$\u0010\u001E\u001A\u0004\u0018\u00010\u00028F@\u0006X\u0086\u000E¢\u0006\u0012\n\u0004\b\u001E\u0010\r\u001A\u0004\b\u001F\u0010\u000F\"\u0004\b \u0010\u0012R$\u0010\"\u001A\u0004\u0018\u00010!8\u0006@\u0006X\u0086\u000E¢\u0006\u0012\n\u0004\b\"\u0010#\u001A\u0004\b$\u0010%\"\u0004\b&\u0010\'R\u0011\u0010*\u001A\u00020\u00028F¢\u0006\u0006\u001A\u0004\b(\u0010)¨\u0006,"}, d2 = {"Lcom/facebook/appevents/internal/SessionInfo;", "", "", "sessionStartTime", "sessionLastEventTime", "Ljava/util/UUID;", "sessionId", "<init>", "(Ljava/lang/Long;Ljava/lang/Long;Ljava/util/UUID;)V", "Lie/H;", "incrementInterruptionCount", "()V", "writeSessionToDisk", "Ljava/lang/Long;", "getSessionStartTime", "()Ljava/lang/Long;", "getSessionLastEventTime", "setSessionLastEventTime", "(Ljava/lang/Long;)V", "Ljava/util/UUID;", "getSessionId", "()Ljava/util/UUID;", "setSessionId", "(Ljava/util/UUID;)V", "", "<set-?>", "interruptionCount", "I", "getInterruptionCount", "()I", "diskRestoreTime", "getDiskRestoreTime", "setDiskRestoreTime", "Lcom/facebook/appevents/internal/SourceApplicationInfo;", "sourceApplicationInfo", "Lcom/facebook/appevents/internal/SourceApplicationInfo;", "getSourceApplicationInfo", "()Lcom/facebook/appevents/internal/SourceApplicationInfo;", "setSourceApplicationInfo", "(Lcom/facebook/appevents/internal/SourceApplicationInfo;)V", "getSessionLength", "()J", "sessionLength", "Companion", "facebook-core_release"}, k = 1, mv = {1, 8, 0}, xi = 0x30)
public final class SessionInfo {
    @Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000E\n\u0002\b\u0006\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0011\u0010\u0005\u001A\u0004\u0018\u00010\u0004H\u0007¢\u0006\u0004\b\u0005\u0010\u0006J\u000F\u0010\b\u001A\u00020\u0007H\u0007¢\u0006\u0004\b\b\u0010\u0003R\u0014\u0010\n\u001A\u00020\t8\u0002X\u0082T¢\u0006\u0006\n\u0004\b\n\u0010\u000BR\u0014\u0010\f\u001A\u00020\t8\u0002X\u0082T¢\u0006\u0006\n\u0004\b\f\u0010\u000BR\u0014\u0010\r\u001A\u00020\t8\u0002X\u0082T¢\u0006\u0006\n\u0004\b\r\u0010\u000BR\u0014\u0010\u000E\u001A\u00020\t8\u0002X\u0082T¢\u0006\u0006\n\u0004\b\u000E\u0010\u000B¨\u0006\u000F"}, d2 = {"Lcom/facebook/appevents/internal/SessionInfo$Companion;", "", "<init>", "()V", "Lcom/facebook/appevents/internal/SessionInfo;", "getStoredSessionInfo", "()Lcom/facebook/appevents/internal/SessionInfo;", "Lie/H;", "clearSavedSessionFromDisk", "", "INTERRUPTION_COUNT_KEY", "Ljava/lang/String;", "LAST_SESSION_INFO_END_KEY", "LAST_SESSION_INFO_START_KEY", "SESSION_ID_KEY", "facebook-core_release"}, k = 1, mv = {1, 8, 0}, xi = 0x30)
    public static final class Companion {
        private Companion() {
        }

        public Companion(DefaultConstructorMarker defaultConstructorMarker0) {
        }

        public final void clearSavedSessionFromDisk() {
            SharedPreferences.Editor sharedPreferences$Editor0 = PreferenceManager.getDefaultSharedPreferences(FacebookSdk.getApplicationContext()).edit();
            sharedPreferences$Editor0.remove("com.facebook.appevents.SessionInfo.sessionStartTime");
            sharedPreferences$Editor0.remove("com.facebook.appevents.SessionInfo.sessionEndTime");
            sharedPreferences$Editor0.remove("com.facebook.appevents.SessionInfo.interruptionCount");
            sharedPreferences$Editor0.remove("com.facebook.appevents.SessionInfo.sessionId");
            sharedPreferences$Editor0.apply();
            SourceApplicationInfo.Companion.clearSavedSourceApplicationInfoFromDisk();
        }

        @Nullable
        public final SessionInfo getStoredSessionInfo() {
            SharedPreferences sharedPreferences0 = PreferenceManager.getDefaultSharedPreferences(FacebookSdk.getApplicationContext());
            long v = sharedPreferences0.getLong("com.facebook.appevents.SessionInfo.sessionStartTime", 0L);
            long v1 = sharedPreferences0.getLong("com.facebook.appevents.SessionInfo.sessionEndTime", 0L);
            String s = sharedPreferences0.getString("com.facebook.appevents.SessionInfo.sessionId", null);
            if(v != 0L && v1 != 0L && s != null) {
                SessionInfo sessionInfo0 = new SessionInfo(v, v1, null, 4, null);
                sessionInfo0.interruptionCount = sharedPreferences0.getInt("com.facebook.appevents.SessionInfo.interruptionCount", 0);
                sessionInfo0.setSourceApplicationInfo(SourceApplicationInfo.Companion.getStoredSourceApplicatioInfo());
                sessionInfo0.setDiskRestoreTime(System.currentTimeMillis());
                UUID uUID0 = UUID.fromString(s);
                q.f(uUID0, "fromString(sessionIDStr)");
                sessionInfo0.setSessionId(uUID0);
                return sessionInfo0;
            }
            return null;
        }
    }

    @NotNull
    public static final Companion Companion = null;
    @NotNull
    private static final String INTERRUPTION_COUNT_KEY = "com.facebook.appevents.SessionInfo.interruptionCount";
    @NotNull
    private static final String LAST_SESSION_INFO_END_KEY = "com.facebook.appevents.SessionInfo.sessionEndTime";
    @NotNull
    private static final String LAST_SESSION_INFO_START_KEY = "com.facebook.appevents.SessionInfo.sessionStartTime";
    @NotNull
    private static final String SESSION_ID_KEY = "com.facebook.appevents.SessionInfo.sessionId";
    @Nullable
    private Long diskRestoreTime;
    private int interruptionCount;
    @NotNull
    private UUID sessionId;
    @Nullable
    private Long sessionLastEventTime;
    @Nullable
    private final Long sessionStartTime;
    @Nullable
    private SourceApplicationInfo sourceApplicationInfo;

    static {
        SessionInfo.Companion = new Companion(null);
    }

    public SessionInfo(@Nullable Long long0, @Nullable Long long1) {
        this(long0, long1, null, 4, null);
    }

    public SessionInfo(@Nullable Long long0, @Nullable Long long1, @NotNull UUID uUID0) {
        q.g(uUID0, "sessionId");
        super();
        this.sessionStartTime = long0;
        this.sessionLastEventTime = long1;
        this.sessionId = uUID0;
    }

    public SessionInfo(Long long0, Long long1, UUID uUID0, int v, DefaultConstructorMarker defaultConstructorMarker0) {
        if((v & 4) != 0) {
            uUID0 = UUID.randomUUID();
            q.f(uUID0, "randomUUID()");
        }
        this(long0, long1, uUID0);
    }

    public static final void clearSavedSessionFromDisk() {
        SessionInfo.Companion.clearSavedSessionFromDisk();
    }

    @Nullable
    public final Long getDiskRestoreTime() {
        return this.diskRestoreTime == null ? 0L : this.diskRestoreTime;
    }

    public final int getInterruptionCount() {
        return this.interruptionCount;
    }

    @NotNull
    public final UUID getSessionId() {
        return this.sessionId;
    }

    @Nullable
    public final Long getSessionLastEventTime() {
        return this.sessionLastEventTime;
    }

    public final long getSessionLength() {
        if(this.sessionStartTime != null) {
            return this.sessionLastEventTime == null ? 0L : this.sessionLastEventTime.longValue() - ((long)this.sessionStartTime);
        }
        return 0L;
    }

    @Nullable
    public final Long getSessionStartTime() {
        return this.sessionStartTime;
    }

    @Nullable
    public final SourceApplicationInfo getSourceApplicationInfo() {
        return this.sourceApplicationInfo;
    }

    @Nullable
    public static final SessionInfo getStoredSessionInfo() {
        return SessionInfo.Companion.getStoredSessionInfo();
    }

    public final void incrementInterruptionCount() {
        ++this.interruptionCount;
    }

    public final void setDiskRestoreTime(@Nullable Long long0) {
        this.diskRestoreTime = long0;
    }

    public final void setSessionId(@NotNull UUID uUID0) {
        q.g(uUID0, "<set-?>");
        this.sessionId = uUID0;
    }

    public final void setSessionLastEventTime(@Nullable Long long0) {
        this.sessionLastEventTime = long0;
    }

    public final void setSourceApplicationInfo(@Nullable SourceApplicationInfo sourceApplicationInfo0) {
        this.sourceApplicationInfo = sourceApplicationInfo0;
    }

    public final void writeSessionToDisk() {
        SharedPreferences.Editor sharedPreferences$Editor0 = PreferenceManager.getDefaultSharedPreferences(FacebookSdk.getApplicationContext()).edit();
        long v = 0L;
        sharedPreferences$Editor0.putLong("com.facebook.appevents.SessionInfo.sessionStartTime", (this.sessionStartTime == null ? 0L : ((long)this.sessionStartTime)));
        Long long0 = this.sessionLastEventTime;
        if(long0 != null) {
            v = (long)long0;
        }
        sharedPreferences$Editor0.putLong("com.facebook.appevents.SessionInfo.sessionEndTime", v);
        sharedPreferences$Editor0.putInt("com.facebook.appevents.SessionInfo.interruptionCount", this.interruptionCount);
        sharedPreferences$Editor0.putString("com.facebook.appevents.SessionInfo.sessionId", this.sessionId.toString());
        sharedPreferences$Editor0.apply();
        SourceApplicationInfo sourceApplicationInfo0 = this.sourceApplicationInfo;
        if(sourceApplicationInfo0 != null) {
            sourceApplicationInfo0.writeSourceApplicationInfoToDisk();
        }
    }
}


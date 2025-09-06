package com.facebook.internal;

import android.content.Intent;
import com.facebook.internal.instrument.crashshield.CrashShieldHandler;
import java.util.UUID;
import jeb.synthetic.FIN;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.q;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000B\n\u0002\b\u0002\b\u0007\u0018\u0000 \u00152\u00020\u0001:\u0001\u0015B\u0019\b\u0007\u0012\u0006\u0010\u0002\u001A\u00020\u0003\u0012\b\b\u0002\u0010\u0004\u001A\u00020\u0005¢\u0006\u0002\u0010\u0006J\u0006\u0010\u0013\u001A\u00020\u0014R\u0011\u0010\u0004\u001A\u00020\u0005¢\u0006\b\n\u0000\u001A\u0004\b\u0007\u0010\bR\u001A\u0010\u0002\u001A\u00020\u0003X\u0086\u000E¢\u0006\u000E\n\u0000\u001A\u0004\b\t\u0010\n\"\u0004\b\u000B\u0010\fR\u001C\u0010\r\u001A\u0004\u0018\u00010\u000EX\u0086\u000E¢\u0006\u000E\n\u0000\u001A\u0004\b\u000F\u0010\u0010\"\u0004\b\u0011\u0010\u0012¨\u0006\u0016"}, d2 = {"Lcom/facebook/internal/AppCall;", "", "requestCode", "", "callId", "Ljava/util/UUID;", "(ILjava/util/UUID;)V", "getCallId", "()Ljava/util/UUID;", "getRequestCode", "()I", "setRequestCode", "(I)V", "requestIntent", "Landroid/content/Intent;", "getRequestIntent", "()Landroid/content/Intent;", "setRequestIntent", "(Landroid/content/Intent;)V", "setPending", "", "Companion", "facebook-common_release"}, k = 1, mv = {1, 8, 0}, xi = 0x30)
public final class AppCall {
    @Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000B\n\u0002\b\u0002\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u001A\u0010\b\u001A\u0004\u0018\u00010\u00042\u0006\u0010\t\u001A\u00020\n2\u0006\u0010\u000B\u001A\u00020\fH\u0007J\u0012\u0010\r\u001A\u00020\u000E2\b\u0010\u000F\u001A\u0004\u0018\u00010\u0004H\u0002R\"\u0010\u0005\u001A\u0004\u0018\u00010\u00042\b\u0010\u0003\u001A\u0004\u0018\u00010\u0004@BX\u0086\u000E¢\u0006\b\n\u0000\u001A\u0004\b\u0006\u0010\u0007¨\u0006\u0010"}, d2 = {"Lcom/facebook/internal/AppCall$Companion;", "", "()V", "<set-?>", "Lcom/facebook/internal/AppCall;", "currentPendingCall", "getCurrentPendingCall", "()Lcom/facebook/internal/AppCall;", "finishPendingCall", "callId", "Ljava/util/UUID;", "requestCode", "", "setCurrentPendingCall", "", "appCall", "facebook-common_release"}, k = 1, mv = {1, 8, 0}, xi = 0x30)
    public static final class Companion {
        private Companion() {
        }

        public Companion(DefaultConstructorMarker defaultConstructorMarker0) {
        }

        public static final boolean access$setCurrentPendingCall(Companion appCall$Companion0, AppCall appCall0) {
            return appCall$Companion0.setCurrentPendingCall(appCall0);
        }

        @Nullable
        public final AppCall finishPendingCall(@NotNull UUID uUID0, int v) {
            synchronized(this) {
                q.g(uUID0, "callId");
                AppCall appCall0 = this.getCurrentPendingCall();
                if(appCall0 != null && q.b(appCall0.getCallId(), uUID0) && appCall0.getRequestCode() == v) {
                    this.setCurrentPendingCall(null);
                    return appCall0;
                }
                return null;
            }
        }

        @Nullable
        public final AppCall getCurrentPendingCall() {
            return AppCall.access$getCurrentPendingCall$cp();
        }

        private final boolean setCurrentPendingCall(AppCall appCall0) {
            synchronized(this) {
                AppCall appCall1 = this.getCurrentPendingCall();
                AppCall.access$setCurrentPendingCall$cp(appCall0);
                return appCall1 != null;
            }
        }
    }

    @NotNull
    public static final Companion Companion;
    @NotNull
    private final UUID callId;
    @Nullable
    private static AppCall currentPendingCall;
    private int requestCode;
    @Nullable
    private Intent requestIntent;

    static {
        AppCall.Companion = new Companion(null);
    }

    public AppCall(int v) {
        this(v, null, 2, null);
    }

    public AppCall(int v, @NotNull UUID uUID0) {
        q.g(uUID0, "callId");
        super();
        this.requestCode = v;
        this.callId = uUID0;
    }

    public AppCall(int v, UUID uUID0, int v1, DefaultConstructorMarker defaultConstructorMarker0) {
        if((v1 & 2) != 0) {
            uUID0 = UUID.randomUUID();
            q.f(uUID0, "randomUUID()");
        }
        this(v, uUID0);
    }

    // 去混淆评级： 低(20)
    public static final AppCall access$getCurrentPendingCall$cp() {
        return CrashShieldHandler.isObjectCrashing(AppCall.class) ? null : AppCall.currentPendingCall;
    }

    public static final void access$setCurrentPendingCall$cp(AppCall appCall0) {
        if(CrashShieldHandler.isObjectCrashing(AppCall.class)) {
            return;
        }
        AppCall.currentPendingCall = appCall0;
    }

    @Nullable
    public static final AppCall finishPendingCall(@NotNull UUID uUID0, int v) {
        Class class0 = AppCall.class;
        __monitor_enter(class0);
        int v1 = FIN.finallyOpen$NT();
        if(CrashShieldHandler.isObjectCrashing(AppCall.class)) {
            FIN.finallyCodeBegin$NT(v1);
            __monitor_exit(class0);
            FIN.finallyCodeEnd$NT(v1);
            return null;
        }
        try {
            AppCall appCall0 = AppCall.Companion.finishPendingCall(uUID0, v);
            FIN.finallyExec$NT(v1);
            return appCall0;
        }
        catch(Throwable throwable0) {
            CrashShieldHandler.handleThrowable(throwable0, AppCall.class);
            FIN.finallyExec$NT(v1);
            return null;
        }
    }

    // 去混淆评级： 低(20)
    @NotNull
    public final UUID getCallId() {
        return CrashShieldHandler.isObjectCrashing(this) ? null : this.callId;
    }

    // 去混淆评级： 低(20)
    public final int getRequestCode() {
        return CrashShieldHandler.isObjectCrashing(this) ? 0 : this.requestCode;
    }

    // 去混淆评级： 低(20)
    @Nullable
    public final Intent getRequestIntent() {
        return CrashShieldHandler.isObjectCrashing(this) ? null : this.requestIntent;
    }

    public final boolean setPending() {
        if(CrashShieldHandler.isObjectCrashing(this)) {
            return false;
        }
        try {
            return Companion.access$setCurrentPendingCall(AppCall.Companion, this);
        }
        catch(Throwable throwable0) {
            CrashShieldHandler.handleThrowable(throwable0, this);
            return false;
        }
    }

    public final void setRequestCode(int v) {
        if(CrashShieldHandler.isObjectCrashing(this)) {
            return;
        }
        this.requestCode = v;
    }

    public final void setRequestIntent(@Nullable Intent intent0) {
        if(CrashShieldHandler.isObjectCrashing(this)) {
            return;
        }
        this.requestIntent = intent0;
    }
}


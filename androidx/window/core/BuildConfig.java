package androidx.window.core;

import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\bÀ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u0011\u0010\u0003\u001A\u00020\u0004¢\u0006\b\n\u0000\u001A\u0004\b\u0005\u0010\u0006¨\u0006\u0007"}, d2 = {"Landroidx/window/core/BuildConfig;", "", "()V", "verificationMode", "Landroidx/window/core/VerificationMode;", "getVerificationMode", "()Landroidx/window/core/VerificationMode;", "window_release"}, k = 1, mv = {1, 9, 0}, xi = 0x30)
public final class BuildConfig {
    @NotNull
    public static final BuildConfig INSTANCE;
    @NotNull
    private static final VerificationMode verificationMode;

    static {
        BuildConfig.INSTANCE = new BuildConfig();
        BuildConfig.verificationMode = VerificationMode.QUIET;
    }

    @NotNull
    public final VerificationMode getVerificationMode() {
        return BuildConfig.verificationMode;
    }
}


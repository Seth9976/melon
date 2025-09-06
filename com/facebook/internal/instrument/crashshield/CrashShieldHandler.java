package com.facebook.internal.instrument.crashshield;

import java.util.Collections;
import java.util.Set;
import java.util.WeakHashMap;
import kotlin.Metadata;
import kotlin.jvm.internal.q;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0003\n\u0002\b\u0004\n\u0002\u0010\u000B\n\u0002\b\n\n\u0002\u0010#\n\u0000\n\u0002\u0010\"\n\u0002\b\u0005\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u000F\u0010\u0005\u001A\u00020\u0004H\u0007¢\u0006\u0004\b\u0005\u0010\u0003J\u000F\u0010\u0006\u001A\u00020\u0004H\u0007¢\u0006\u0004\b\u0006\u0010\u0003J!\u0010\n\u001A\u00020\u00042\b\u0010\b\u001A\u0004\u0018\u00010\u00072\u0006\u0010\t\u001A\u00020\u0001H\u0007¢\u0006\u0004\b\n\u0010\u000BJ\u0017\u0010\r\u001A\u00020\f2\u0006\u0010\t\u001A\u00020\u0001H\u0007¢\u0006\u0004\b\r\u0010\u000EJ\u0019\u0010\u000F\u001A\u00020\u00042\b\u0010\t\u001A\u0004\u0018\u00010\u0001H\u0007¢\u0006\u0004\b\u000F\u0010\u0010J\u000F\u0010\u0011\u001A\u00020\u0004H\u0007¢\u0006\u0004\b\u0011\u0010\u0003J\u000F\u0010\u0012\u001A\u00020\u0004H\u0007¢\u0006\u0004\b\u0012\u0010\u0003J\u000F\u0010\u0013\u001A\u00020\fH\u0007¢\u0006\u0004\b\u0013\u0010\u0014J\u0019\u0010\u0015\u001A\u00020\u00042\b\u0010\b\u001A\u0004\u0018\u00010\u0007H\u0007¢\u0006\u0004\b\u0015\u0010\u0016R8\u0010\u001A\u001A&\u0012\f\u0012\n \u0018*\u0004\u0018\u00010\u00010\u0001 \u0018*\u0012\u0012\f\u0012\n \u0018*\u0004\u0018\u00010\u00010\u0001\u0018\u00010\u00190\u00178\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u001A\u0010\u001BR\u0016\u0010\u001C\u001A\u00020\f8\u0002@\u0002X\u0082\u000E¢\u0006\u0006\n\u0004\b\u001C\u0010\u001D¨\u0006\u001E"}, d2 = {"Lcom/facebook/internal/instrument/crashshield/CrashShieldHandler;", "", "<init>", "()V", "Lie/H;", "enable", "disable", "", "e", "o", "handleThrowable", "(Ljava/lang/Throwable;Ljava/lang/Object;)V", "", "isObjectCrashing", "(Ljava/lang/Object;)Z", "methodFinished", "(Ljava/lang/Object;)V", "reset", "resetCrashingObjects", "isDebug", "()Z", "scheduleCrashInDebug", "(Ljava/lang/Throwable;)V", "", "kotlin.jvm.PlatformType", "", "crashingObjects", "Ljava/util/Set;", "enabled", "Z", "facebook-core_release"}, k = 1, mv = {1, 8, 0}, xi = 0x30)
public final class CrashShieldHandler {
    @NotNull
    public static final CrashShieldHandler INSTANCE;
    private static final Set crashingObjects;
    private static boolean enabled;

    static {
        CrashShieldHandler.INSTANCE = new CrashShieldHandler();
        CrashShieldHandler.crashingObjects = Collections.newSetFromMap(new WeakHashMap());
    }

    public static final void disable() {
        CrashShieldHandler.enabled = false;
    }

    public static final void enable() {
        CrashShieldHandler.enabled = true;
    }

    public static final void handleThrowable(@Nullable Throwable throwable0, @NotNull Object object0) {
        q.g(object0, "o");
    }

    public static final boolean isDebug() [...] // Inlined contents

    public static final boolean isObjectCrashing(@NotNull Object object0) {
        q.g(object0, "o");
        return CrashShieldHandler.crashingObjects.contains(object0);
    }

    public static final void methodFinished(@Nullable Object object0) {
    }

    public static final void reset() {
        CrashShieldHandler.resetCrashingObjects();
    }

    public static final void resetCrashingObjects() {
        CrashShieldHandler.crashingObjects.clear();
    }

    public static final void scheduleCrashInDebug(@Nullable Throwable throwable0) {

        @Metadata(d1 = {"\u0000\u0011\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u000F\u0010\u0003\u001A\u00020\u0002H\u0017¢\u0006\u0004\b\u0003\u0010\u0004¨\u0006\u0005"}, d2 = {"com/facebook/internal/instrument/crashshield/CrashShieldHandler$scheduleCrashInDebug$1", "Ljava/lang/Runnable;", "Lie/H;", "run", "()V", "facebook-core_release"}, k = 1, mv = {1, 8, 0}, xi = 0x30)
        public final class com.facebook.internal.instrument.crashshield.CrashShieldHandler.scheduleCrashInDebug.1 implements Runnable {
            public com.facebook.internal.instrument.crashshield.CrashShieldHandler.scheduleCrashInDebug.1(Throwable throwable0) {
            }

            @Override
            public void run() {
                throw new RuntimeException(this.$e);
            }
        }

    }
}


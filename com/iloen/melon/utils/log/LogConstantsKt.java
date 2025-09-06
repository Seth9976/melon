package com.iloen.melon.utils.log;

import C8.c;
import Db.i;
import De.I;
import Qb.b;
import kotlin.Metadata;
import kotlin.jvm.internal.q;
import org.jetbrains.annotations.NotNull;
import we.k;

@Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0010\u000E\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0002\b\f\n\u0002\u0010\u000B\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\b\u001A!\u0010\u0006\u001A\u00020\u0005*\u00020\u00002\u0006\u0010\u0002\u001A\u00020\u00012\u0006\u0010\u0004\u001A\u00020\u0003\u00A2\u0006\u0004\b\u0006\u0010\u0007\u001A!\u0010\b\u001A\u00020\u0005*\u00020\u00002\u0006\u0010\u0002\u001A\u00020\u00012\u0006\u0010\u0004\u001A\u00020\u0003\u00A2\u0006\u0004\b\b\u0010\u0007\u001A!\u0010\t\u001A\u00020\u0005*\u00020\u00002\u0006\u0010\u0002\u001A\u00020\u00012\u0006\u0010\u0004\u001A\u00020\u0003\u00A2\u0006\u0004\b\t\u0010\u0007\u001A!\u0010\n\u001A\u00020\u0005*\u00020\u00002\u0006\u0010\u0002\u001A\u00020\u00012\u0006\u0010\u0004\u001A\u00020\u0003\u00A2\u0006\u0004\b\n\u0010\u0007\u001A!\u0010\u000B\u001A\u00020\u0005*\u00020\u00002\u0006\u0010\u0002\u001A\u00020\u00012\u0006\u0010\u0004\u001A\u00020\u0003\u00A2\u0006\u0004\b\u000B\u0010\u0007\u001A\u0019\u0010\f\u001A\u00020\u0005*\u00020\u00002\u0006\u0010\u0002\u001A\u00020\u0001\u00A2\u0006\u0004\b\f\u0010\r\u001A\u0019\u0010\u000E\u001A\u00020\u0005*\u00020\u00002\u0006\u0010\u0002\u001A\u00020\u0001\u00A2\u0006\u0004\b\u000E\u0010\r\u001A\u0019\u0010\u000F\u001A\u00020\u0005*\u00020\u00002\u0006\u0010\u0002\u001A\u00020\u0001\u00A2\u0006\u0004\b\u000F\u0010\r\u001A\u0019\u0010\u0010\u001A\u00020\u0005*\u00020\u00002\u0006\u0010\u0002\u001A\u00020\u0001\u00A2\u0006\u0004\b\u0010\u0010\r\u001A\u0019\u0010\u0011\u001A\u00020\u0005*\u00020\u00002\u0006\u0010\u0002\u001A\u00020\u0001\u00A2\u0006\u0004\b\u0011\u0010\r\u001A3\u0010\u0018\u001A\u00020\u0005*\u00020\u00002\b\b\u0002\u0010\u0013\u001A\u00020\u00122\u0016\u0010\u0017\u001A\u0012\u0012\b\u0012\u00060\u0015j\u0002`\u0016\u0012\u0004\u0012\u00020\u00050\u0014\u00A2\u0006\u0004\b\u0018\u0010\u0019\u001A3\u0010\u001A\u001A\u00020\u0005*\u00020\u00002\b\b\u0002\u0010\u0013\u001A\u00020\u00122\u0016\u0010\u0017\u001A\u0012\u0012\b\u0012\u00060\u0015j\u0002`\u0016\u0012\u0004\u0012\u00020\u00050\u0014\u00A2\u0006\u0004\b\u001A\u0010\u0019\u001A3\u0010\u001B\u001A\u00020\u0005*\u00020\u00002\b\b\u0002\u0010\u0013\u001A\u00020\u00122\u0016\u0010\u0017\u001A\u0012\u0012\b\u0012\u00060\u0015j\u0002`\u0016\u0012\u0004\u0012\u00020\u00050\u0014\u00A2\u0006\u0004\b\u001B\u0010\u0019\u001A3\u0010\u001C\u001A\u00020\u0005*\u00020\u00002\b\b\u0002\u0010\u0013\u001A\u00020\u00122\u0016\u0010\u0017\u001A\u0012\u0012\b\u0012\u00060\u0015j\u0002`\u0016\u0012\u0004\u0012\u00020\u00050\u0014\u00A2\u0006\u0004\b\u001C\u0010\u0019\u001A3\u0010\u001D\u001A\u00020\u0005*\u00020\u00002\b\b\u0002\u0010\u0013\u001A\u00020\u00122\u0016\u0010\u0017\u001A\u0012\u0012\b\u0012\u00060\u0015j\u0002`\u0016\u0012\u0004\u0012\u00020\u00050\u0014\u00A2\u0006\u0004\b\u001D\u0010\u0019\u00A8\u0006\u001E"}, d2 = {"Lcom/iloen/melon/utils/log/LogU;", "", "message", "", "pivotTime", "Lie/H;", "verbose", "(Lcom/iloen/melon/utils/log/LogU;Ljava/lang/String;J)V", "debug", "info", "warn", "error", "verboseOnlyDebugMode", "(Lcom/iloen/melon/utils/log/LogU;Ljava/lang/String;)V", "debugOnlyDebugMode", "infoOnlyDebugMode", "warnOnlyDebugMode", "errorOnlyDebugMode", "", "onlyDebug", "Lkotlin/Function1;", "Ljava/lang/StringBuilder;", "Lkotlin/text/StringBuilder;", "builderAction", "buildVerbose", "(Lcom/iloen/melon/utils/log/LogU;ZLwe/k;)V", "buildDebug", "buildInfo", "buildWarn", "buildError", "app_playstoreProdRelease"}, k = 2, mv = {2, 2, 0}, xi = 0x30)
public final class LogConstantsKt {
    public static final void buildDebug(@NotNull LogU logU0, boolean z, @NotNull k k0) {
        q.g(logU0, "<this>");
        q.g(k0, "builderAction");
        i.a(logU0.getNewLog(), new Hb.k(z, 0), new c(6, k0), 1);
    }

    public static void buildDebug$default(LogU logU0, boolean z, k k0, int v, Object object0) {
        if((v & 1) != 0) {
            z = false;
        }
        LogConstantsKt.buildDebug(logU0, z, k0);
    }

    public static final void buildError(@NotNull LogU logU0, boolean z, @NotNull k k0) {
        q.g(logU0, "<this>");
        q.g(k0, "builderAction");
        i.b(logU0.getNewLog(), new Hb.k(z, 0), new c(7, k0), 1);
    }

    public static void buildError$default(LogU logU0, boolean z, k k0, int v, Object object0) {
        if((v & 1) != 0) {
            z = false;
        }
        LogConstantsKt.buildError(logU0, z, k0);
    }

    public static final void buildInfo(@NotNull LogU logU0, boolean z, @NotNull k k0) {
        q.g(logU0, "<this>");
        q.g(k0, "builderAction");
        i.c(logU0.getNewLog(), new Hb.k(z, 0), new c(10, k0), 1);
    }

    public static void buildInfo$default(LogU logU0, boolean z, k k0, int v, Object object0) {
        if((v & 1) != 0) {
            z = false;
        }
        LogConstantsKt.buildInfo(logU0, z, k0);
    }

    public static final void buildVerbose(@NotNull LogU logU0, boolean z, @NotNull k k0) {
        q.g(logU0, "<this>");
        q.g(k0, "builderAction");
        i.f(logU0.getNewLog(), new Hb.k(z, 0), new c(8, k0), 1);
    }

    public static void buildVerbose$default(LogU logU0, boolean z, k k0, int v, Object object0) {
        if((v & 1) != 0) {
            z = false;
        }
        LogConstantsKt.buildVerbose(logU0, z, k0);
    }

    public static final void buildWarn(@NotNull LogU logU0, boolean z, @NotNull k k0) {
        q.g(logU0, "<this>");
        q.g(k0, "builderAction");
        i.g(logU0.getNewLog(), new Hb.k(z, 0), new c(9, k0), 1);
    }

    public static void buildWarn$default(LogU logU0, boolean z, k k0, int v, Object object0) {
        if((v & 1) != 0) {
            z = false;
        }
        LogConstantsKt.buildWarn(logU0, z, k0);
    }

    public static final void debug(@NotNull LogU logU0, @NotNull String s, long v) {
        q.g(logU0, "<this>");
        q.g(s, "message");
        i.a(logU0.getNewLog(), null, new a(s, v, 1), 3);
    }

    public static final void debugOnlyDebugMode(@NotNull LogU logU0, @NotNull String s) {
        q.g(logU0, "<this>");
        q.g(s, "message");
        I.x(logU0.getNewLog(), new b(s, 2));
    }

    public static final void error(@NotNull LogU logU0, @NotNull String s, long v) {
        q.g(logU0, "<this>");
        q.g(s, "message");
        i.b(logU0.getNewLog(), null, new a(s, v, 0), 3);
    }

    public static final void errorOnlyDebugMode(@NotNull LogU logU0, @NotNull String s) {
        q.g(logU0, "<this>");
        q.g(s, "message");
        i i0 = logU0.getNewLog();
        b b0 = new b(s, 2);
        q.g(i0, "<this>");
        i.b(i0, new A9.a(22), b0, 1);
    }

    public static final void info(@NotNull LogU logU0, @NotNull String s, long v) {
        q.g(logU0, "<this>");
        q.g(s, "message");
        i.c(logU0.getNewLog(), null, new a(s, v, 4), 3);
    }

    public static final void infoOnlyDebugMode(@NotNull LogU logU0, @NotNull String s) {
        q.g(logU0, "<this>");
        q.g(s, "message");
        I.M(logU0.getNewLog(), new b(s, 2));
    }

    public static final void verbose(@NotNull LogU logU0, @NotNull String s, long v) {
        q.g(logU0, "<this>");
        q.g(s, "message");
        i.f(logU0.getNewLog(), null, new a(s, v, 2), 3);
    }

    public static final void verboseOnlyDebugMode(@NotNull LogU logU0, @NotNull String s) {
        q.g(logU0, "<this>");
        q.g(s, "message");
        i i0 = logU0.getNewLog();
        b b0 = new b(s, 2);
        q.g(i0, "<this>");
        i.f(i0, new A9.a(23), b0, 1);
    }

    public static final void warn(@NotNull LogU logU0, @NotNull String s, long v) {
        q.g(logU0, "<this>");
        q.g(s, "message");
        i.g(logU0.getNewLog(), null, new a(s, v, 3), 3);
    }

    public static final void warnOnlyDebugMode(@NotNull LogU logU0, @NotNull String s) {
        q.g(logU0, "<this>");
        q.g(s, "message");
        i i0 = logU0.getNewLog();
        b b0 = new b(s, 2);
        q.g(i0, "<this>");
        i.g(i0, new A9.a(24), b0, 1);
    }
}


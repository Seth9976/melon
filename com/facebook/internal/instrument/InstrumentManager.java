package com.facebook.internal.instrument;

import B3.n;
import com.facebook.FacebookSdk;
import com.facebook.internal.FeatureManager.Feature;
import com.facebook.internal.FeatureManager;
import com.facebook.internal.instrument.anrreport.ANRHandler;
import com.facebook.internal.instrument.crashreport.CrashHandler;
import com.facebook.internal.instrument.crashshield.CrashShieldHandler;
import com.facebook.internal.instrument.errorreport.ErrorReportHandler;
import com.facebook.internal.instrument.threadcheck.ThreadCheckHandler;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\bÇ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u000F\u0010\u0005\u001A\u00020\u0004H\u0007¢\u0006\u0004\b\u0005\u0010\u0003¨\u0006\u0006"}, d2 = {"Lcom/facebook/internal/instrument/InstrumentManager;", "", "<init>", "()V", "Lie/H;", "start", "facebook-core_release"}, k = 1, mv = {1, 8, 0}, xi = 0x30)
public final class InstrumentManager {
    @NotNull
    public static final InstrumentManager INSTANCE;

    static {
        InstrumentManager.INSTANCE = new InstrumentManager();
    }

    public static final void start() {
        if(!FacebookSdk.getAutoLogAppEventsEnabled()) {
            return;
        }
        n n0 = new n(3);
        FeatureManager.checkFeature(Feature.CrashReport, n0);
        n n1 = new n(4);
        FeatureManager.checkFeature(Feature.ErrorReport, n1);
        n n2 = new n(5);
        FeatureManager.checkFeature(Feature.AnrReport, n2);
    }

    private static final void start$lambda$0(boolean z) {
        if(z) {
            CrashHandler.Companion.enable();
            if(FeatureManager.isEnabled(Feature.CrashShield)) {
                ExceptionAnalyzer.enable();
                CrashShieldHandler.enable();
            }
            if(FeatureManager.isEnabled(Feature.ThreadCheck)) {
                ThreadCheckHandler.enable();
            }
        }
    }

    private static final void start$lambda$1(boolean z) {
        if(z) {
            ErrorReportHandler.enable();
        }
    }

    private static final void start$lambda$2(boolean z) {
        if(z) {
            ANRHandler.enable();
        }
    }
}


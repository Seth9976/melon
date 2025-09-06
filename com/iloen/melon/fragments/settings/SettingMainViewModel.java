package com.iloen.melon.fragments.settings;

import A0.c;
import Db.h;
import Hb.a;
import androidx.lifecycle.m0;
import com.iloen.melon.utils.system.ToastManager;
import ie.r;
import java.util.concurrent.atomic.AtomicBoolean;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlinx.coroutines.flow.MutableStateFlow;
import kotlinx.coroutines.flow.StateFlow;
import kotlinx.coroutines.flow.StateFlowKt;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u0000>\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000B\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0004\b\u0007\u0018\u0000 \u00182\u00020\u0001:\u0001\u0018B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\r\u0010\u0005\u001A\u00020\u0004¢\u0006\u0004\b\u0005\u0010\u0003R\u0014\u0010\u0007\u001A\u00020\u00068\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0007\u0010\bR\u001A\u0010\u000B\u001A\b\u0012\u0004\u0012\u00020\n0\t8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u000B\u0010\fR\u001D\u0010\u000E\u001A\b\u0012\u0004\u0012\u00020\n0\r8\u0006¢\u0006\f\n\u0004\b\u000E\u0010\u000F\u001A\u0004\b\u0010\u0010\u0011R\u0016\u0010\u0013\u001A\u00020\u00128\u0002@\u0002X\u0082\u000E¢\u0006\u0006\n\u0004\b\u0013\u0010\u0014R\u0016\u0010\u0016\u001A\u00020\u00158\u0002@\u0002X\u0082\u000E¢\u0006\u0006\n\u0004\b\u0016\u0010\u0017¨\u0006\u0019"}, d2 = {"Lcom/iloen/melon/fragments/settings/SettingMainViewModel;", "Landroidx/lifecycle/m0;", "<init>", "()V", "Lie/H;", "onClickLoggerUnlock", "LHb/a;", "backdoor", "LHb/a;", "Lkotlinx/coroutines/flow/MutableStateFlow;", "", "_enableLogger", "Lkotlinx/coroutines/flow/MutableStateFlow;", "Lkotlinx/coroutines/flow/StateFlow;", "enableLogger", "Lkotlinx/coroutines/flow/StateFlow;", "getEnableLogger", "()Lkotlinx/coroutines/flow/StateFlow;", "", "triggerTime", "J", "", "triggerCount", "I", "Companion", "app_playstoreProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 0x30)
public final class SettingMainViewModel extends m0 {
    @Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u000E\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003R\u000E\u0010\u0004\u001A\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000¨\u0006\u0006"}, d2 = {"Lcom/iloen/melon/fragments/settings/SettingMainViewModel$Companion;", "", "<init>", "()V", "TAG", "", "app_playstoreProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 0x30)
    public static final class Companion {
        private Companion() {
        }

        public Companion(DefaultConstructorMarker defaultConstructorMarker0) {
        }
    }

    public static final int $stable = 0;
    @NotNull
    public static final Companion Companion = null;
    @NotNull
    public static final String TAG = "SettingMainViewModel";
    @NotNull
    private final MutableStateFlow _enableLogger;
    @NotNull
    private final a backdoor;
    @NotNull
    private final StateFlow enableLogger;
    private int triggerCount;
    private long triggerTime;

    static {
        SettingMainViewModel.Companion = new Companion(null);
        SettingMainViewModel.$stable = 8;
    }

    public SettingMainViewModel() {
        this.backdoor = h.c;
        MutableStateFlow mutableStateFlow0 = StateFlowKt.MutableStateFlow(Boolean.valueOf(h.c.D()));
        this._enableLogger = mutableStateFlow0;
        this.enableLogger = mutableStateFlow0;
    }

    @NotNull
    public final StateFlow getEnableLogger() {
        return this.enableLogger;
    }

    public final void onClickLoggerUnlock() {
        long v = System.currentTimeMillis();
        if(Long.compare(v - this.triggerTime, 500L) <= 0) {
            int v1 = this.triggerCount;
            this.triggerCount = v1 + 1;
            if(v1 >= 10) {
                ((c)this.backdoor).getClass();
                ToastManager.show("Logcat is activated");
                ((AtomicBoolean)((r)((c)this.backdoor).b).getValue()).set(true);
                Boolean boolean0 = Boolean.valueOf(((c)this.backdoor).D());
                this._enableLogger.setValue(boolean0);
                this.triggerTime = 0L;
                this.triggerCount = 0;
            }
        }
        else {
            this.triggerCount = 1;
        }
        this.triggerTime = v;
    }
}


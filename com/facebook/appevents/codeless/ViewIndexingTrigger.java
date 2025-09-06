package com.facebook.appevents.codeless;

import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;
import com.facebook.internal.instrument.crashshield.CrashShieldHandler;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.q;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\b\b\u0001\u0018\u0000 \u00152\u00020\u0001:\u0002\u0015\u0016B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u0017\u0010\u0007\u001A\u00020\u00062\b\u0010\u0005\u001A\u0004\u0018\u00010\u0004¢\u0006\u0004\b\u0007\u0010\bJ\u0017\u0010\u000B\u001A\u00020\u00062\u0006\u0010\n\u001A\u00020\tH\u0016¢\u0006\u0004\b\u000B\u0010\fJ\u001F\u0010\u0011\u001A\u00020\u00062\u0006\u0010\u000E\u001A\u00020\r2\u0006\u0010\u0010\u001A\u00020\u000FH\u0016¢\u0006\u0004\b\u0011\u0010\u0012R\u0018\u0010\u0013\u001A\u0004\u0018\u00010\u00048\u0002@\u0002X\u0082\u000E¢\u0006\u0006\n\u0004\b\u0013\u0010\u0014¨\u0006\u0017"}, d2 = {"Lcom/facebook/appevents/codeless/ViewIndexingTrigger;", "Landroid/hardware/SensorEventListener;", "<init>", "()V", "Lcom/facebook/appevents/codeless/ViewIndexingTrigger$OnShakeListener;", "listener", "Lie/H;", "setOnShakeListener", "(Lcom/facebook/appevents/codeless/ViewIndexingTrigger$OnShakeListener;)V", "Landroid/hardware/SensorEvent;", "event", "onSensorChanged", "(Landroid/hardware/SensorEvent;)V", "Landroid/hardware/Sensor;", "sensor", "", "accuracy", "onAccuracyChanged", "(Landroid/hardware/Sensor;I)V", "onShakeListener", "Lcom/facebook/appevents/codeless/ViewIndexingTrigger$OnShakeListener;", "Companion", "OnShakeListener", "facebook-core_release"}, k = 1, mv = {1, 8, 0}, xi = 0x30)
public final class ViewIndexingTrigger implements SensorEventListener {
    @Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u0006\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000E\u0010\u0003\u001A\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000¨\u0006\u0005"}, d2 = {"Lcom/facebook/appevents/codeless/ViewIndexingTrigger$Companion;", "", "()V", "SHAKE_THRESHOLD_GRAVITY", "", "facebook-core_release"}, k = 1, mv = {1, 8, 0}, xi = 0x30)
    public static final class Companion {
        private Companion() {
        }

        public Companion(DefaultConstructorMarker defaultConstructorMarker0) {
        }
    }

    @Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\bæ\u0080\u0001\u0018\u00002\u00020\u0001J\u000F\u0010\u0003\u001A\u00020\u0002H&¢\u0006\u0004\b\u0003\u0010\u0004¨\u0006\u0005"}, d2 = {"Lcom/facebook/appevents/codeless/ViewIndexingTrigger$OnShakeListener;", "", "Lie/H;", "onShake", "()V", "facebook-core_release"}, k = 1, mv = {1, 8, 0}, xi = 0x30)
    public interface OnShakeListener {
        void onShake();
    }

    @NotNull
    public static final Companion Companion = null;
    private static final double SHAKE_THRESHOLD_GRAVITY = 2.3;
    @Nullable
    private OnShakeListener onShakeListener;

    static {
        ViewIndexingTrigger.Companion = new Companion(null);
    }

    @Override  // android.hardware.SensorEventListener
    public void onAccuracyChanged(@NotNull Sensor sensor0, int v) {
        if(CrashShieldHandler.isObjectCrashing(this)) {
            return;
        }
        try {
            q.g(sensor0, "sensor");
        }
        catch(Throwable throwable0) {
            CrashShieldHandler.handleThrowable(throwable0, this);
        }
    }

    @Override  // android.hardware.SensorEventListener
    public void onSensorChanged(@NotNull SensorEvent sensorEvent0) {
        if(CrashShieldHandler.isObjectCrashing(this)) {
            return;
        }
        else {
            try {
                q.g(sensorEvent0, "event");
                OnShakeListener viewIndexingTrigger$OnShakeListener0 = this.onShakeListener;
                if(viewIndexingTrigger$OnShakeListener0 != null) {
                    float[] arr_f = sensorEvent0.values;
                    double f = (double)(arr_f[0] / 9.80665f);
                    double f1 = (double)(arr_f[1] / 9.80665f);
                    double f2 = (double)(arr_f[2] / 9.80665f);
                    if(Math.sqrt(f2 * f2 + (f1 * f1 + f * f)) > 2.3) {
                        viewIndexingTrigger$OnShakeListener0.onShake();
                        return;
                    }
                }
                return;
            }
            catch(Throwable throwable0) {
            }
        }
        CrashShieldHandler.handleThrowable(throwable0, this);
    }

    public final void setOnShakeListener(@Nullable OnShakeListener viewIndexingTrigger$OnShakeListener0) {
        if(CrashShieldHandler.isObjectCrashing(this)) {
            return;
        }
        this.onShakeListener = viewIndexingTrigger$OnShakeListener0;
    }
}


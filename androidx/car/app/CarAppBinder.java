package androidx.car.app;

import A.a;
import H7.c;
import android.content.Intent;
import android.content.res.Configuration;
import android.os.Binder;
import android.os.Looper;
import android.util.Log;
import androidx.car.app.serialization.Bundleable;
import androidx.car.app.utils.g;
import androidx.car.app.utils.h;
import androidx.lifecycle.t;
import java.util.Objects;
import y.e;

final class CarAppBinder extends Stub {
    private j mCurrentSession;
    private final SessionInfo mCurrentSessionInfo;
    private HandshakeInfo mHandshakeInfo;
    private a mHostValidator;
    private CarAppService mService;

    public CarAppBinder(CarAppService carAppService0, SessionInfo sessionInfo0) {
        this.mService = carAppService0;
        this.mCurrentSessionInfo = sessionInfo0;
    }

    public void destroy() {
        this.mHandshakeInfo = null;
        this.mService = null;
    }

    @Override  // androidx.car.app.ICarApp
    public void getAppInfo(IOnDoneCallback iOnDoneCallback0) {
        try {
            CarAppService carAppService0 = this.mService;
            Objects.requireNonNull(carAppService0);
            if(carAppService0.b == null) {
                carAppService0.b = AppInfo.create(carAppService0);
            }
            g.d("getAppInfo onSuccess", new c(iOnDoneCallback0, carAppService0.b, "getAppInfo", 10));
        }
        catch(IllegalArgumentException illegalArgumentException0) {
            g.f(iOnDoneCallback0, "getAppInfo", illegalArgumentException0);
        }
    }

    private t getCurrentLifecycle() [...] // Inlined contents

    public j getCurrentSession() {
        return null;
    }

    public SessionInfo getCurrentSessionInfo() {
        return this.mCurrentSessionInfo;
    }

    public HandshakeInfo getHandshakeInfo() {
        return this.mHandshakeInfo;
    }

    private a getHostValidator() {
        CarAppService carAppService0 = this.mService;
        Objects.requireNonNull(carAppService0);
        carAppService0.a();
        return null;
    }

    @Override  // androidx.car.app.ICarApp
    public void getManager(String s, IOnDoneCallback iOnDoneCallback0) {
        h.a(() -> throw null);
    }

    // 检测为 Lambda 实现
    private void lambda$getManager$7(String s, IOnDoneCallback iOnDoneCallback0) [...]

    // 检测为 Lambda 实现
    private Object lambda$onAppCreate$0(ICarHost iCarHost0, Configuration configuration0, Intent intent0) [...]

    private Object lambda$onAppPause$3() {
        throw null;
    }

    private Object lambda$onAppResume$2() {
        throw null;
    }

    private Object lambda$onAppStart$1() {
        throw null;
    }

    private Object lambda$onAppStop$4() {
        throw null;
    }

    private Object lambda$onConfigurationChanged$6(Configuration configuration0) {
        throw null;
    }

    private Object lambda$onNewIntent$5(Intent intent0) {
        throw null;
    }

    @Override  // androidx.car.app.ICarApp
    public void onAppCreate(ICarHost iCarHost0, Intent intent0, Configuration configuration0, IOnDoneCallback iOnDoneCallback0) {
        if(Log.isLoggable("CarApp", 3)) {
            Log.d("CarApp", "onAppCreate intent: " + intent0);
        }
        g.b(iOnDoneCallback0, "onAppCreate", () -> {
            Objects.requireNonNull(this.mService);
            Objects.requireNonNull(this.mCurrentSessionInfo);
            throw new RuntimeException("Please override and implement CarAppService#onCreateSession(SessionInfo).");
        });
        if(Log.isLoggable("CarApp", 3)) {
            Log.d("CarApp", "onAppCreate completed");
        }
    }

    @Override  // androidx.car.app.ICarApp
    public void onAppPause(IOnDoneCallback iOnDoneCallback0) {
        g.c(null, iOnDoneCallback0, "onAppPause", new androidx.car.app.c(this, 0));
    }

    @Override  // androidx.car.app.ICarApp
    public void onAppResume(IOnDoneCallback iOnDoneCallback0) {
        g.c(null, iOnDoneCallback0, "onAppResume", new androidx.car.app.c(this, 3));
    }

    @Override  // androidx.car.app.ICarApp
    public void onAppStart(IOnDoneCallback iOnDoneCallback0) {
        g.c(null, iOnDoneCallback0, "onAppStart", new androidx.car.app.c(this, 1));
    }

    @Override  // androidx.car.app.ICarApp
    public void onAppStop(IOnDoneCallback iOnDoneCallback0) {
        g.c(null, iOnDoneCallback0, "onAppStop", new androidx.car.app.c(this, 2));
    }

    public void onAutoDriveEnabled() {
    }

    @Override  // androidx.car.app.ICarApp
    public void onConfigurationChanged(Configuration configuration0, IOnDoneCallback iOnDoneCallback0) {
        g.c(null, iOnDoneCallback0, "onConfigurationChanged", new b(0, this, configuration0));
    }

    private void onConfigurationChangedInternal(j j0, Configuration configuration0) {
        if(Looper.getMainLooper() != Looper.myLooper()) {
            throw new IllegalStateException("Not running on main thread when it is required to");
        }
        if(Log.isLoggable("CarApp", 3)) {
            Log.d("CarApp", "onCarConfigurationChanged configuration: " + configuration0);
        }
        throw null;
    }

    public void onDestroyLifecycle() {
    }

    @Override  // androidx.car.app.ICarApp
    public void onHandshakeCompleted(Bundleable bundleable0, IOnDoneCallback iOnDoneCallback0) {
        Objects.requireNonNull(this.mService);
        try {
            String s = ((HandshakeInfo)bundleable0.a()).getHostPackageName();
            Binder.getCallingUid();
            Objects.requireNonNull(s);
            this.getHostValidator();
        }
        catch(e | IllegalArgumentException e0) {
            g.f(iOnDoneCallback0, "onHandshakeCompleted", e0);
            return;
        }
        throw null;
    }

    @Override  // androidx.car.app.ICarApp
    public void onNewIntent(Intent intent0, IOnDoneCallback iOnDoneCallback0) {
        g.c(null, iOnDoneCallback0, "onNewIntent", new b(1, this, intent0));
    }

    private void onNewIntentInternal(j j0, Intent intent0) {
        if(Looper.getMainLooper() != Looper.myLooper()) {
            throw new IllegalStateException("Not running on main thread when it is required to");
        }
        throw null;
    }

    public void setHandshakeInfo(HandshakeInfo handshakeInfo0) {
        int v = handshakeInfo0.getHostCarAppApiLevel();
        if(v < 1 || v > B.a.C()) {
            throw new IllegalArgumentException("Invalid Car App API level received: " + v);
        }
        this.mHandshakeInfo = handshakeInfo0;
    }
}


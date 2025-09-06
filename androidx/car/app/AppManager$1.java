package androidx.car.app;

import android.content.pm.PackageManager;
import androidx.car.app.utils.g;

class AppManager.1 extends Stub {
    final CarContext val$carContext;

    public AppManager.1(a a0, CarContext carContext0) {
        this.val$carContext = carContext0;
        super();
    }

    @Override  // androidx.car.app.IAppManager
    public void getTemplate(IOnDoneCallback iOnDoneCallback0) {
        throw null;
    }

    private static Object lambda$onBackPressed$0(CarContext carContext0) {
        carContext0.getClass();
        throw null;
    }

    private static Object lambda$startLocationUpdates$1(CarContext carContext0) {
        carContext0.getClass();
        throw null;
    }

    private static Object lambda$stopLocationUpdates$2(CarContext carContext0) {
        carContext0.getClass();
        throw null;
    }

    @Override  // androidx.car.app.IAppManager
    public void onBackPressed(IOnDoneCallback iOnDoneCallback0) {
        throw null;
    }

    @Override  // androidx.car.app.IAppManager
    public void startLocationUpdates(IOnDoneCallback iOnDoneCallback0) {
        PackageManager packageManager0 = this.val$carContext.getPackageManager();
        boolean z = false;
        boolean z1 = packageManager0.checkPermission("android.permission.ACCESS_FINE_LOCATION", "com.iloen.melon") == -1;
        if(packageManager0.checkPermission("android.permission.ACCESS_COARSE_LOCATION", "com.iloen.melon") == -1) {
            z = true;
        }
        if(z1 && z) {
            g.f(iOnDoneCallback0, "startLocationUpdates", new SecurityException("Location permission(s) not granted."));
        }
        throw null;
    }

    @Override  // androidx.car.app.IAppManager
    public void stopLocationUpdates(IOnDoneCallback iOnDoneCallback0) {
        throw null;
    }
}


package androidx.car.app.navigation;

import androidx.car.app.IOnDoneCallback;
import androidx.car.app.utils.g;
import androidx.lifecycle.t;

class NavigationManager.1 extends Stub {
    final t val$lifecycle;

    public NavigationManager.1(b b0, t t0) {
        this.val$lifecycle = t0;
        super();
    }

    // 检测为 Lambda 实现
    private Object lambda$onStopNavigation$0() [...]

    @Override  // androidx.car.app.navigation.INavigationManager
    public void onStopNavigation(IOnDoneCallback iOnDoneCallback0) {
        a a0 = () -> throw null;
        g.c(this.val$lifecycle, iOnDoneCallback0, "onStopNavigation", a0);
    }
}


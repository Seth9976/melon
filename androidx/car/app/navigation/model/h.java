package androidx.car.app.navigation.model;

import androidx.car.app.utils.a;

public final class h implements a {
    public final PanModeListenerStub a;
    public final boolean b;

    public h(PanModeListenerStub panModeDelegateImpl$PanModeListenerStub0, boolean z) {
        this.a = panModeDelegateImpl$PanModeListenerStub0;
        this.b = z;
    }

    @Override  // androidx.car.app.utils.a
    public final Object a() {
        return this.a.lambda$onPanModeChanged$0(this.b);
    }
}


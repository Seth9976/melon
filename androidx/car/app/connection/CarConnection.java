package androidx.car.app.connection;

import android.content.Context;
import androidx.lifecycle.K;
import java.util.Objects;
import r.a;
import r.d;

public final class CarConnection {
    public final K a;

    public CarConnection(Context context0) {
        Objects.requireNonNull(context0);
        a a0 = context0.getPackageManager().hasSystemFeature("android.hardware.type.automotive") ? new a() : new d(context0);  // 初始化器: Landroidx/lifecycle/K;-><init>()V
        this.a = a0;
    }
}


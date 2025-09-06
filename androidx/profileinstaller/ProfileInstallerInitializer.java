package androidx.profileinstaller;

import K4.b;
import android.content.Context;
import android.view.Choreographer;
import e3.h;
import f1.B;
import java.util.Collections;
import java.util.List;

public class ProfileInstallerInitializer implements b {
    @Override  // K4.b
    public final List a() {
        return Collections.EMPTY_LIST;
    }

    @Override  // K4.b
    public final Object b(Context context0) {
        Context context1 = context0.getApplicationContext();
        Choreographer.getInstance().postFrameCallback(new B(this, context1));
        return new h();  // 初始化器: Ljava/lang/Object;-><init>()V
    }
}


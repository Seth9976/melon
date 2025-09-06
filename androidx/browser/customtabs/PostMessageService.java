package androidx.browser.customtabs;

import android.app.Service;
import android.content.Intent;
import android.os.IBinder;
import p.n;

public class PostMessageService extends Service {
    public final n a;

    public PostMessageService() {
        this.a = new n();  // 初始化器: Landroid/support/customtabs/IPostMessageService$Stub;-><init>()V
    }

    @Override  // android.app.Service
    public final IBinder onBind(Intent intent0) {
        return this.a;
    }
}


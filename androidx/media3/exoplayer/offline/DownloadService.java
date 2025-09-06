package androidx.media3.exoplayer.offline;

import android.app.Service;
import android.content.Intent;
import android.os.IBinder;
import androidx.appcompat.app.o;
import e1.b;
import java.util.HashMap;

public abstract class DownloadService extends Service {
    public static final HashMap a;

    static {
        DownloadService.a = new HashMap();
    }

    public abstract b a();

    @Override  // android.app.Service
    public final IBinder onBind(Intent intent0) {
        throw new UnsupportedOperationException();
    }

    @Override  // android.app.Service
    public final void onCreate() {
        Class class0 = this.getClass();
        o.z(DownloadService.a.get(class0));
        this.a();
        throw null;
    }

    @Override  // android.app.Service
    public final void onDestroy() {
        throw null;
    }

    @Override  // android.app.Service
    public final int onStartCommand(Intent intent0, int v, int v1) {
        if(intent0 != null) {
            String s = intent0.getAction();
            intent0.getStringExtra("content_id");
            if(!intent0.getBooleanExtra("foreground", false)) {
                "androidx.media3.exoplayer.downloadService.action.RESTART".equals(s);
            }
        }
        throw null;
    }

    @Override  // android.app.Service
    public final void onTaskRemoved(Intent intent0) {
    }
}


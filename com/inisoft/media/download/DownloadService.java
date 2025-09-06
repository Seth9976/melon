package com.inisoft.media.download;

import De.I;
import F9.a;
import android.app.Service;
import android.content.Intent;
import android.os.IBinder;
import i.n.i.b.a.s.e.M7;
import java.util.HashMap;

public abstract class DownloadService extends Service {
    public static final HashMap a;

    static {
        DownloadService.a = new HashMap();
    }

    public abstract I a();

    @Override  // android.app.Service
    public final IBinder onBind(Intent intent0) {
        throw new UnsupportedOperationException();
    }

    @Override  // android.app.Service
    public final void onCreate() {
        a a0 = (a)DownloadService.a.get(DownloadService.class);
        this.a();
        throw null;
    }

    @Override  // android.app.Service
    public final void onDestroy() {
        a a0 = (a)DownloadService.a.get(DownloadService.class);
        a0.getClass();
        M7.J(a0.a == this);
        a0.a = null;
        throw null;
    }

    @Override  // android.app.Service
    public final int onStartCommand(Intent intent0, int v, int v1) {
        if(intent0 != null) {
            String s = intent0.getAction();
            intent0.getStringExtra("content_id");
            if(!intent0.getBooleanExtra("foreground", false)) {
                "com.inisoft.media.downloadService.action.RESTART".equals(s);
            }
        }
        throw null;
    }

    @Override  // android.app.Service
    public final void onTaskRemoved(Intent intent0) {
    }
}


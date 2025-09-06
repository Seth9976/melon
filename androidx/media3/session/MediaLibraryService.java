package androidx.media3.session;

import android.content.Intent;
import android.os.IBinder;
import e3.b;

public abstract class MediaLibraryService extends MediaSessionService {
    @Override  // androidx.media3.session.MediaSessionService
    public f0 f(w0 w00) {
        return this.j(w00);
    }

    public abstract f0 j(w0 arg1);

    @Override  // androidx.media3.session.MediaSessionService
    public IBinder onBind(Intent intent0) {
        if(intent0 == null) {
            return null;
        }
        if("androidx.media3.session.MediaLibraryService".equals(intent0.getAction())) {
            synchronized(this.a) {
                IBinder iBinder0 = this.d;
                b.k(iBinder0);
                return iBinder0;
            }
        }
        return super.onBind(intent0);
    }
}


package j3;

import android.content.ContentResolver;
import android.database.ContentObserver;
import android.net.Uri;
import android.os.Handler;

public final class d extends ContentObserver {
    public final ContentResolver a;
    public final Uri b;
    public final e c;

    public d(e e0, Handler handler0, ContentResolver contentResolver0, Uri uri0) {
        this.c = e0;
        super(handler0);
        this.a = contentResolver0;
        this.b = uri0;
    }

    @Override  // android.database.ContentObserver
    public final void onChange(boolean z) {
        b b0 = b.c(this.c.a, this.c.i, this.c.h);
        this.c.a(b0);
    }
}


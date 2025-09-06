package androidx.media3.session.legacy;

import B0.q;
import android.media.session.MediaSessionManager.RemoteUserInfo;
import android.os.Build.VERSION;
import android.text.TextUtils;

public final class b0 {
    public final a0 a;

    public b0(MediaSessionManager.RemoteUserInfo mediaSessionManager$RemoteUserInfo0) {
        String s = mediaSessionManager$RemoteUserInfo0.getPackageName();
        if(s == null) {
            throw new NullPointerException("package shouldn\'t be null");
        }
        if(TextUtils.isEmpty(s)) {
            throw new IllegalArgumentException("packageName should be nonempty");
        }
        this.a = new Y(mediaSessionManager$RemoteUserInfo0.getPackageName(), mediaSessionManager$RemoteUserInfo0.getPid(), mediaSessionManager$RemoteUserInfo0.getUid());  // 初始化器: Landroidx/media3/session/legacy/a0;-><init>(Ljava/lang/String;II)V
    }

    public b0(String s, int v, int v1) {
        if(s == null) {
            throw new NullPointerException("package shouldn\'t be null");
        }
        if(TextUtils.isEmpty(s)) {
            throw new IllegalArgumentException("packageName should be nonempty");
        }
        if(Build.VERSION.SDK_INT >= 28) {
            Y y0 = new Y(s, v, v1);  // 初始化器: Landroidx/media3/session/legacy/a0;-><init>(Ljava/lang/String;II)V
            q.n(v, v1, s);
            this.a = y0;
            return;
        }
        this.a = new a0(s, v, v1);
    }

    @Override
    public final boolean equals(Object object0) {
        if(this == object0) {
            return true;
        }
        return object0 instanceof b0 ? this.a.equals(((b0)object0).a) : false;
    }

    @Override
    public final int hashCode() {
        return this.a.hashCode();
    }
}


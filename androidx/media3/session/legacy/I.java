package androidx.media3.session.legacy;

import E9.m;
import Q0.a;
import android.content.ComponentName;
import android.content.Context;
import android.media.browse.MediaBrowser;
import android.os.Bundle;
import android.os.Messenger;
import android.os.Process;
import androidx.collection.f;
import x9.c;

public final class i {
    public final Context a;
    public final MediaBrowser b;
    public final Bundle c;
    public final m d;
    public final f e;
    public c f;
    public Messenger g;
    public MediaSessionCompat.Token h;

    public i(Context context0, ComponentName componentName0, a a0, Bundle bundle0) {
        this.d = new m(this);
        this.e = new f(0);  // 初始化器: Landroidx/collection/V;-><init>(I)V
        this.a = context0;
        Bundle bundle1 = bundle0 == null ? new Bundle() : new Bundle(bundle0);
        this.c = bundle1;
        bundle1.putInt("extra_client_version", 1);
        bundle1.putInt("extra_calling_pid", Process.myPid());
        a0.b = this;
        h h0 = (h)a0.a;
        h0.getClass();
        this.b = new MediaBrowser(context0, componentName0, h0, bundle1);
    }
}


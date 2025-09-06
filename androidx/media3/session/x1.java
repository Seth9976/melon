package androidx.media3.session;

import android.content.ComponentName;
import android.media.session.MediaSession.Token;
import android.os.Bundle;

public interface x1 {
    Object a();

    String b();

    int c();

    ComponentName d();

    boolean e();

    MediaSession.Token f();

    Bundle getExtras();

    String getPackageName();

    int getType();

    int getUid();

    Bundle toBundle();
}


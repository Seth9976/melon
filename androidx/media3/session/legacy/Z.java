package androidx.media3.session.legacy;

import android.os.Bundle;
import android.os.Message;
import android.os.Messenger;
import android.support.v4.media.session.MediaSessionCompat.Token;

public final class z implements y {
    public final Messenger a;

    public z(Messenger messenger0) {
        this.a = messenger0;
    }

    public final void a(String s, MediaSessionCompat.Token mediaSessionCompat$Token0, Bundle bundle0) {
        if(bundle0 == null) {
            bundle0 = new Bundle();
        }
        bundle0.putInt("extra_service_version", 2);
        Bundle bundle1 = new Bundle();
        bundle1.putString("data_media_item_id", s);
        bundle1.putParcelable("data_media_session_token", g.a(mediaSessionCompat$Token0, Token.CREATOR));
        bundle1.putBundle("data_root_hints", bundle0);
        this.b(1, bundle1);
    }

    public final void b(int v, Bundle bundle0) {
        Message message0 = Message.obtain();
        message0.what = v;
        message0.arg1 = 2;
        if(bundle0 != null) {
            message0.setData(bundle0);
        }
        this.a.send(message0);
    }
}


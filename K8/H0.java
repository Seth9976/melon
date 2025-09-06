package k8;

import Td.b;
import android.content.Context;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import com.iloen.melon.MelonAppBase;
import com.iloen.melon.MusicBrowserActivity;
import com.iloen.melon.eventbus.EventBusHelper;
import com.iloen.melon.eventbus.EventPermission;
import com.iloen.melon.utils.log.LogU;
import com.iloen.melon.utils.ui.ViewUtils;
import kotlin.jvm.internal.q;
import l9.a;

public final class h0 extends Handler {
    public final MusicBrowserActivity a;

    public h0(MusicBrowserActivity musicBrowserActivity0, Looper looper0) {
        this.a = musicBrowserActivity0;
        super(looper0);
    }

    @Override  // android.os.Handler
    public final void handleMessage(Message message0) {
        q.g(message0, "msg");
        Context context0 = Y.a(MelonAppBase.Companion);
        boolean z = b.f(context0, a.c);
        boolean z1 = b.e(context0, "android.permission.READ_MEDIA_AUDIO");
        EventBusHelper.post(new EventPermission(z1, z));
        int v = z ? 8 : 16;
        MusicBrowserActivity musicBrowserActivity0 = this.a;
        if(z && z1) {
            LogU.Companion.i("MusicBrowserActivity", "checkRuntimePermission() => Permission Success");
            if(musicBrowserActivity0.checkingNotificationPermission && !b.e(context0, "android.permission.POST_NOTIFICATIONS")) {
                v = 0x40;
                LogU.Companion.i("MusicBrowserActivity", "checkRuntimePermission() => Permission Fail");
                ViewUtils.setOrientation(musicBrowserActivity0, 1);
                b.b(musicBrowserActivity0, v, new ea.b(musicBrowserActivity0, context0));
                return;
            }
            MusicBrowserActivity.onCompleteCheckPermission$default(musicBrowserActivity0, false, 1, null);
            return;
        }
        LogU.Companion.i("MusicBrowserActivity", "checkRuntimePermission() => Permission Fail");
        ViewUtils.setOrientation(musicBrowserActivity0, 1);
        b.b(musicBrowserActivity0, v, new ea.b(musicBrowserActivity0, context0));
    }
}


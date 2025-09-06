package pd;

import androidx.lifecycle.D;
import androidx.lifecycle.f;
import com.iloen.melon.utils.log.LogU;
import com.melon.ui.playback.VideoControllerHelper;
import kotlin.jvm.internal.q;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.CoroutineScopeKt;

public final class v implements f {
    public final VideoControllerHelper a;

    public v(VideoControllerHelper videoControllerHelper0) {
        this.a = videoControllerHelper0;
    }

    @Override  // androidx.lifecycle.f
    public final void onDestroy(D d0) {
        LogU.info$default(this.a.b, "onUiDestroy()", null, false, 6, null);
        this.a.l.clear();
    }

    @Override  // androidx.lifecycle.f
    public final void onPause(D d0) {
    }

    @Override  // androidx.lifecycle.f
    public final void onResume(D d0) {
        q.g(d0, "owner");
    }

    @Override  // androidx.lifecycle.f
    public final void onStart(D d0) {
        q.g(d0, "owner");
        this.a.c();
    }

    @Override  // androidx.lifecycle.f
    public final void onStop(D d0) {
        VideoControllerHelper videoControllerHelper0 = this.a;
        LogU.info$default(videoControllerHelper0.b, "onUiStop()", null, false, 6, null);
        CoroutineScope coroutineScope0 = videoControllerHelper0.i;
        if(coroutineScope0 != null) {
            CoroutineScopeKt.cancel$default(coroutineScope0, "cancelCollectControllerState() Cancel", null, 2, null);
        }
        videoControllerHelper0.i = null;
    }
}


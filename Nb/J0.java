package Nb;

import R8.m;
import android.os.Debug;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import com.iloen.melon.utils.log.Category;
import com.iloen.melon.utils.log.LogU;
import com.iloen.melon.utils.ui.FloatingLyricHelper;
import com.melon.playback.PlaybackLibraryService;
import java.text.DecimalFormat;
import java.util.Arrays;
import jc.j;
import kotlin.jvm.internal.q;

public final class j0 extends Handler {
    public final PlaybackLibraryService a;

    public j0(PlaybackLibraryService playbackLibraryService0, Looper looper0) {
        this.a = playbackLibraryService0;
        super(looper0);
    }

    @Override  // android.os.Handler
    public final void handleMessage(Message message0) {
        q.g(message0, "msg");
        int v = message0.what;
        PlaybackLibraryService playbackLibraryService0 = this.a;
        if(v == 1) {
            LogU.info$default(playbackLibraryService0.m, "onStartBackgroundThread()", null, false, 6, null);
            m.a(playbackLibraryService0, m.a);
            return;
        }
        if(v == 2) {
            LogU.info$default(playbackLibraryService0.m, "onFinishBackgroundThread()", null, false, 6, null);
            m.b(playbackLibraryService0);
            j.c("Service shutdown");
            ((Looper)playbackLibraryService0.n.getValue()).quit();
            LogU.info$default(playbackLibraryService0.m, "SERVICE FINISHED COMPLETELY: " + playbackLibraryService0, null, false, 6, null);
            return;
        }
        if(v == PlaybackLibraryService.M) {
            double f = ((double)Debug.getNativeHeapAllocatedSize()) / 1048576.0;
            double f1 = ((double)Debug.getNativeHeapSize()) / 1048576.0;
            double f2 = ((double)Debug.getNativeHeapFreeSize()) / 1048576.0;
            DecimalFormat decimalFormat0 = new DecimalFormat();
            decimalFormat0.setMaximumFractionDigits(1);
            decimalFormat0.setMinimumFractionDigits(1);
            String s = "[Runtime] avail/max/free >> 8,192.0 8,192.0 3,251.0" + String.format(" | %s %s %s << alloc/avail/free [Native]", Arrays.copyOf(new Object[]{decimalFormat0.format(f), decimalFormat0.format(f1), decimalFormat0.format(f2)}, 3));
            LogU.debug$default(LogU.Companion.create("HEAP", true, Category.Playback), s, null, false, 6, null);
            playbackLibraryService0.l().sendEmptyMessageDelayed(message0.what, 1000L);
            return;
        }
        if(v == PlaybackLibraryService.N) {
            FloatingLyricHelper.INSTANCE.requestStartFloatingLyric();
        }
    }
}


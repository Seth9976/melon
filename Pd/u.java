package pd;

import android.widget.SeekBar.OnSeekBarChangeListener;
import android.widget.SeekBar;
import com.melon.ui.playback.VideoControllerHelper;
import kotlin.jvm.internal.q;
import kotlinx.coroutines.flow.MutableStateFlow;

public final class u implements SeekBar.OnSeekBarChangeListener {
    public final VideoControllerHelper a;

    public u(VideoControllerHelper videoControllerHelper0) {
        this.a = videoControllerHelper0;
    }

    @Override  // android.widget.SeekBar$OnSeekBarChangeListener
    public final void onProgressChanged(SeekBar seekBar0, int v, boolean z) {
        q.g(seekBar0, "seekBar");
        if(z) {
            MutableStateFlow mutableStateFlow0 = this.a.n;
            while(true) {
                Object object0 = mutableStateFlow0.getValue();
                q.g(((a)object0), "it");
                if(mutableStateFlow0.compareAndSet(object0, a.a(((a)object0), false, false, null, null, null, 0L, 0L, ((long)v), false, false, null, 0x77F))) {
                    break;
                }
            }
        }
    }

    @Override  // android.widget.SeekBar$OnSeekBarChangeListener
    public final void onStartTrackingTouch(SeekBar seekBar0) {
        q.g(seekBar0, "seekBar");
        MutableStateFlow mutableStateFlow0 = this.a.n;
        do {
            Object object0 = mutableStateFlow0.getValue();
            q.g(((a)object0), "it");
        }
        while(!mutableStateFlow0.compareAndSet(object0, a.a(((a)object0), false, false, null, null, null, 0L, 0L, 0L, true, false, null, 0x6FF)));
    }

    @Override  // android.widget.SeekBar$OnSeekBarChangeListener
    public final void onStopTrackingTouch(SeekBar seekBar0) {
        q.g(seekBar0, "seekBar");
        VideoControllerHelper videoControllerHelper0 = this.a;
        MutableStateFlow mutableStateFlow0 = videoControllerHelper0.n;
        do {
            Object object0 = mutableStateFlow0.getValue();
            q.g(((a)object0), "it");
        }
        while(!mutableStateFlow0.compareAndSet(object0, a.a(((a)object0), false, false, null, null, null, 0L, 0L, 0L, false, false, null, 0x6FF)));
        long v = (long)seekBar0.getProgress();
        videoControllerHelper0.f.z(v);
    }
}


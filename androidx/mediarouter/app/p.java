package androidx.mediarouter.app;

import android.widget.SeekBar.OnSeekBarChangeListener;
import android.widget.SeekBar;
import l4.O;

public final class p implements SeekBar.OnSeekBarChangeListener {
    public final f a;
    public final MediaRouteControllerDialog b;

    public p(MediaRouteControllerDialog mediaRouteControllerDialog0) {
        this.b = mediaRouteControllerDialog0;
        this.a = new f(this, 1);
    }

    @Override  // android.widget.SeekBar$OnSeekBarChangeListener
    public final void onProgressChanged(SeekBar seekBar0, int v, boolean z) {
        if(z) {
            ((O)seekBar0.getTag()).j(v);
        }
    }

    @Override  // android.widget.SeekBar$OnSeekBarChangeListener
    public final void onStartTrackingTouch(SeekBar seekBar0) {
        MediaRouteControllerDialog mediaRouteControllerDialog0 = this.b;
        if(mediaRouteControllerDialog0.i0 != null) {
            mediaRouteControllerDialog0.g0.removeCallbacks(this.a);
        }
        mediaRouteControllerDialog0.i0 = (O)seekBar0.getTag();
    }

    @Override  // android.widget.SeekBar$OnSeekBarChangeListener
    public final void onStopTrackingTouch(SeekBar seekBar0) {
        this.b.g0.postDelayed(this.a, 500L);
    }
}


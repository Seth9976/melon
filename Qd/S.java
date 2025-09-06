package qd;

import android.widget.SeekBar.OnSeekBarChangeListener;
import android.widget.SeekBar;
import kotlin.jvm.internal.q;
import we.k;

public final class s implements SeekBar.OnSeekBarChangeListener {
    public final k a;
    public final k b;
    public final k c;

    public s(k k0, k k1, k k2) {
        this.a = k0;
        this.b = k1;
        this.c = k2;
    }

    @Override  // android.widget.SeekBar$OnSeekBarChangeListener
    public final void onProgressChanged(SeekBar seekBar0, int v, boolean z) {
        q.g(seekBar0, "seekBar");
        if(z) {
            this.a.invoke(v);
        }
    }

    @Override  // android.widget.SeekBar$OnSeekBarChangeListener
    public final void onStartTrackingTouch(SeekBar seekBar0) {
        q.g(seekBar0, "seekBar");
        Integer integer0 = seekBar0.getProgress();
        this.b.invoke(integer0);
    }

    @Override  // android.widget.SeekBar$OnSeekBarChangeListener
    public final void onStopTrackingTouch(SeekBar seekBar0) {
        q.g(seekBar0, "seekBar");
        Integer integer0 = seekBar0.getProgress();
        this.c.invoke(integer0);
    }
}


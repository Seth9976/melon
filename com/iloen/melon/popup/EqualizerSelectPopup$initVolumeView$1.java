package com.iloen.melon.popup;

import android.content.Context;
import android.widget.SeekBar.OnSeekBarChangeListener;
import android.widget.SeekBar;
import com.iloen.melon.player.playlist.common.h;
import com.iloen.melon.utils.system.VolumeUtils;
import kotlin.Metadata;
import kotlin.jvm.internal.q;

@Metadata(d1 = {"\u0000 \n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000B\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\b\n\u0018\u00002\u00020\u0001J\'\u0010\t\u001A\u00020\b2\u0006\u0010\u0003\u001A\u00020\u00022\u0006\u0010\u0005\u001A\u00020\u00042\u0006\u0010\u0007\u001A\u00020\u0006H\u0016¢\u0006\u0004\b\t\u0010\nJ\u0017\u0010\u000B\u001A\u00020\b2\u0006\u0010\u0003\u001A\u00020\u0002H\u0016¢\u0006\u0004\b\u000B\u0010\fJ\u0017\u0010\r\u001A\u00020\b2\u0006\u0010\u0003\u001A\u00020\u0002H\u0016¢\u0006\u0004\b\r\u0010\f¨\u0006\u000E"}, d2 = {"com/iloen/melon/popup/EqualizerSelectPopup$initVolumeView$1", "Landroid/widget/SeekBar$OnSeekBarChangeListener;", "Landroid/widget/SeekBar;", "seekBar", "", "progress", "", "fromUser", "Lie/H;", "onProgressChanged", "(Landroid/widget/SeekBar;IZ)V", "onStartTrackingTouch", "(Landroid/widget/SeekBar;)V", "onStopTrackingTouch", "app_playstoreProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 0x30)
public final class EqualizerSelectPopup.initVolumeView.1 implements SeekBar.OnSeekBarChangeListener {
    public final EqualizerSelectPopup a;

    public EqualizerSelectPopup.initVolumeView.1(EqualizerSelectPopup equalizerSelectPopup0) {
        this.a = equalizerSelectPopup0;
    }

    @Override  // android.widget.SeekBar$OnSeekBarChangeListener
    public void onProgressChanged(SeekBar seekBar0, int v, boolean z) {
        q.g(seekBar0, "seekBar");
        if(z) {
            Context context0 = this.a.getContext();
            SeekBar seekBar1 = EqualizerSelectPopup.access$getMVolumeSeekBar$p(this.a);
            q.d(seekBar1);
            int v1 = seekBar1.getProgress();
            VolumeUtils.Companion.setVolumeFromProgress(context0, v1);
            EqualizerSelectPopup.access$setMuteIcon(this.a, v);
            h h0 = new h(20);
            this.a.trackTiaraEventLog(h0);
        }
    }

    @Override  // android.widget.SeekBar$OnSeekBarChangeListener
    public void onStartTrackingTouch(SeekBar seekBar0) {
        q.g(seekBar0, "seekBar");
    }

    @Override  // android.widget.SeekBar$OnSeekBarChangeListener
    public void onStopTrackingTouch(SeekBar seekBar0) {
        q.g(seekBar0, "seekBar");
    }
}


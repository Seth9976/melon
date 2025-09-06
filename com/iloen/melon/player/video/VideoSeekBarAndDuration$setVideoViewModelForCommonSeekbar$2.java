package com.iloen.melon.player.video;

import android.widget.SeekBar.OnSeekBarChangeListener;
import android.widget.SeekBar;
import kotlin.Metadata;

@Metadata(d1 = {"\u0000\"\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000B\n\u0002\b\u0004\b\n\u0018\u00002\u00020\u0001J\u0019\u0010\u0005\u001A\u00020\u00042\b\u0010\u0003\u001A\u0004\u0018\u00010\u0002H\u0016¢\u0006\u0004\b\u0005\u0010\u0006J\u0019\u0010\u0007\u001A\u00020\u00042\b\u0010\u0003\u001A\u0004\u0018\u00010\u0002H\u0016¢\u0006\u0004\b\u0007\u0010\u0006J)\u0010\f\u001A\u00020\u00042\b\u0010\u0003\u001A\u0004\u0018\u00010\u00022\u0006\u0010\t\u001A\u00020\b2\u0006\u0010\u000B\u001A\u00020\nH\u0016¢\u0006\u0004\b\f\u0010\r¨\u0006\u000E"}, d2 = {"com/iloen/melon/player/video/VideoSeekBarAndDuration$setVideoViewModelForCommonSeekbar$2", "Landroid/widget/SeekBar$OnSeekBarChangeListener;", "Landroid/widget/SeekBar;", "p0", "Lie/H;", "onStartTrackingTouch", "(Landroid/widget/SeekBar;)V", "onStopTrackingTouch", "", "p1", "", "p2", "onProgressChanged", "(Landroid/widget/SeekBar;IZ)V", "app_playstoreProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 0x30)
public final class VideoSeekBarAndDuration.setVideoViewModelForCommonSeekbar.2 implements SeekBar.OnSeekBarChangeListener {
    public final VideoViewModel a;

    public VideoSeekBarAndDuration.setVideoViewModelForCommonSeekbar.2(VideoViewModel videoViewModel0) {
        this.a = videoViewModel0;
    }

    @Override  // android.widget.SeekBar$OnSeekBarChangeListener
    public void onProgressChanged(SeekBar seekBar0, int v, boolean z) {
    }

    @Override  // android.widget.SeekBar$OnSeekBarChangeListener
    public void onStartTrackingTouch(SeekBar seekBar0) {
        this.a.updateIsSeekingByUser(true);
    }

    @Override  // android.widget.SeekBar$OnSeekBarChangeListener
    public void onStopTrackingTouch(SeekBar seekBar0) {
        this.a.updateIsSeekingByUser(false);
    }
}


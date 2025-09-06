package com.kakao.emoticon.util;

import android.media.MediaPlayer.OnCompletionListener;
import android.media.MediaPlayer;

public final class b implements MediaPlayer.OnCompletionListener {
    @Override  // android.media.MediaPlayer$OnCompletionListener
    public final void onCompletion(MediaPlayer mediaPlayer0) {
        mediaPlayer0.reset();
    }
}


package com.kakao.emoticon.util;

import android.media.MediaPlayer.OnPreparedListener;
import android.media.MediaPlayer;

public final class a implements MediaPlayer.OnPreparedListener {
    @Override  // android.media.MediaPlayer$OnPreparedListener
    public final void onPrepared(MediaPlayer mediaPlayer0) {
        mediaPlayer0.start();
    }
}


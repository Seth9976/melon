package com.kakao.emoticon.util;

import android.media.MediaPlayer.OnErrorListener;
import android.media.MediaPlayer;

public final class c implements MediaPlayer.OnErrorListener {
    @Override  // android.media.MediaPlayer$OnErrorListener
    public final boolean onError(MediaPlayer mediaPlayer0, int v, int v1) {
        return SoundUtil.lambda$tryPlaySound$0(mediaPlayer0, v, v1);
    }
}


package com.iloen.melon.playback;

import android.net.Uri;

public interface IPlayer {
    int getAudioSessionId();

    int getCurrentPosition();

    int getDuration();

    PlayerKind getPlayerKind();

    void initialize(IPlayerEventListener arg1);

    boolean isPlaying();

    void pause();

    void play();

    void release();

    void reset();

    void seekTo(int arg1);

    void setData(Uri arg1);

    void setVolume(float arg1);

    void stop();
}


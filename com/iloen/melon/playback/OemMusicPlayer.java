package com.iloen.melon.playback;

import android.media.AudioAttributes.Builder;
import android.media.MediaPlayer.OnCompletionListener;
import android.media.MediaPlayer.OnErrorListener;
import android.media.MediaPlayer.OnPreparedListener;
import android.media.MediaPlayer.OnSeekCompleteListener;
import android.media.MediaPlayer;
import android.net.Uri;
import com.iloen.melon.utils.log.LogU;

public class OemMusicPlayer extends MediaPlayer implements IPlayer {
    private static final String TAG = "OemMusicPlayer";

    private String getErrorMessage(int v, int v1) {
        StringBuilder stringBuilder0 = new StringBuilder();
        stringBuilder0.append("[" + v + "/" + v1 + "]");
        switch(v) {
            case 1: {
                stringBuilder0.append("MEDIA_ERROR_UNKNOWN, ");
                break;
            }
            case 100: {
                stringBuilder0.append("MEDIA_ERROR_SERVER_DIED, ");
                break;
            }
            default: {
                stringBuilder0.append("MEDIA_ERROR_NOTHING, ");
            }
        }
        switch(v1) {
            case -1010: {
                stringBuilder0.append("MEDIA_ERROR_UNSUPPORTED");
                return stringBuilder0.toString();
            }
            case -1007: {
                stringBuilder0.append("MEDIA_ERROR_MALFORMED");
                return stringBuilder0.toString();
            }
            case -1004: {
                stringBuilder0.append("MEDIA_ERROR_IO");
                return stringBuilder0.toString();
            }
            case -110: {
                stringBuilder0.append("MEDIA_ERROR_TIMED_OUT");
                return stringBuilder0.toString();
            }
            default: {
                stringBuilder0.append("MEDIA_ERROR_SYSTEM " + v1);
                return stringBuilder0.toString();
            }
        }
    }

    @Override  // com.iloen.melon.playback.IPlayer
    public PlayerKind getPlayerKind() {
        return PlayerKind.OemMusicPlayer;
    }

    @Override  // com.iloen.melon.playback.IPlayer
    public void initialize(IPlayerEventListener iPlayerEventListener0) {
        LogU.d("OemMusicPlayer", "initialize with listener: " + iPlayerEventListener0);
        this.setAudioAttributes(new AudioAttributes.Builder().setUsage(1).setContentType(2).build());
        this.setOnSeekCompleteListener(new MediaPlayer.OnSeekCompleteListener() {
            @Override  // android.media.MediaPlayer$OnSeekCompleteListener
            public void onSeekComplete(MediaPlayer mediaPlayer0) {
                LogU.d("OemMusicPlayer", "onSeekComplete");
                iPlayerEventListener0.onSeekComplete(((IPlayer)mediaPlayer0));
            }
        });
        this.setOnCompletionListener(new MediaPlayer.OnCompletionListener() {
            @Override  // android.media.MediaPlayer$OnCompletionListener
            public void onCompletion(MediaPlayer mediaPlayer0) {
                LogU.d("OemMusicPlayer", "onCompletion");
                iPlayerEventListener0.onCompletion(((IPlayer)mediaPlayer0));
            }
        });
        this.setOnErrorListener(new MediaPlayer.OnErrorListener() {
            @Override  // android.media.MediaPlayer$OnErrorListener
            public boolean onError(MediaPlayer mediaPlayer0, int v, int v1) {
                if(v == -38) {
                    LogU.e("OemMusicPlayer", "Ignoring -38 error, extra:" + v1);
                    return true;
                }
                LogU.e("OemMusicPlayer", "onError - what:" + v + ",extra:" + v1);
                int v2 = OemMusicPlayer.this.getPlayerKind().getValue();
                String s = OemMusicPlayer.this.getErrorMessage(v, v1);
                iPlayerEventListener0.onError(((IPlayer)mediaPlayer0), v2, v1, s, null);
                return false;
            }
        });
        this.setOnPreparedListener(new MediaPlayer.OnPreparedListener() {
            @Override  // android.media.MediaPlayer$OnPreparedListener
            public void onPrepared(MediaPlayer mediaPlayer0) {
                synchronized(this) {
                    LogU.d("OemMusicPlayer", "onPrepared");
                    iPlayerEventListener0.onPrepared(((IPlayer)mediaPlayer0));
                }
            }
        });
    }

    @Override  // com.iloen.melon.playback.IPlayer
    public void play() {
        try {
            this.start();
        }
        catch(IllegalStateException illegalStateException0) {
            throw new IllegalMPStateException(illegalStateException0);
        }
    }

    @Override  // com.iloen.melon.playback.IPlayer
    public void setData(Uri uri0) {
        LogU.d("OemMusicPlayer", "setData " + uri0);
        try {
            this.setDataSource(uri0.toString());
            this.prepareAsync();
        }
        catch(Exception exception0) {
            LogU.e("OemMusicPlayer", "setData error: " + exception0);
            throw new IllegalStateException(exception0);
        }
    }

    @Override  // com.iloen.melon.playback.IPlayer
    public void setVolume(float f) {
        this.setVolume(f, f);
    }
}


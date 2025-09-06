package com.iloen.melon.playback;

public interface IPlayerEventListener {
    void onBufferingChange(boolean arg1);

    void onCompletion(IPlayer arg1);

    @Deprecated
    void onDisplayChange(IPlayer arg1, int arg2, int arg3);

    void onError(IPlayer arg1, int arg2, int arg3, String arg4, Exception arg5);

    void onPcm(IPlayer arg1, byte[] arg2, int arg3, int arg4, int arg5, int arg6);

    void onPrepared(IPlayer arg1);

    void onSeekComplete(IPlayer arg1);
}


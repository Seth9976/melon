package e3;

import java.util.concurrent.ThreadFactory;

public final class w implements ThreadFactory {
    @Override
    public final Thread newThread(Runnable runnable0) {
        return new Thread(runnable0, "ExoPlayer:AudioTrackReleaseThread");
    }
}


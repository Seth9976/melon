package i.n.i.b.a.s.e;

import android.media.AudioTrack;

public final class pb extends Thread {
    public final AudioTrack a;
    public final ub b;

    public pb(ub ub0, AudioTrack audioTrack0) {
        this.b = ub0;
        this.a = audioTrack0;
        super("ExoPlayer:AudioTrackReleaseThread");
    }

    @Override
    public final void run() {
        try {
            this.a.flush();
            this.a.release();
        }
        finally {
            this.b.h.open();
        }
    }
}


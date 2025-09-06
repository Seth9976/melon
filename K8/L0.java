package k8;

import android.content.Intent;
import android.net.Uri;
import com.iloen.melon.MusicBrowserActivity;
import kotlin.coroutines.Continuation;
import oe.c;

public final class l0 extends c {
    public Uri B;
    public Object D;
    public final MusicBrowserActivity E;
    public int G;
    public Intent r;
    public String w;

    public l0(MusicBrowserActivity musicBrowserActivity0, Continuation continuation0) {
        this.E = musicBrowserActivity0;
        super(continuation0);
    }

    @Override  // oe.a
    public final Object invokeSuspend(Object object0) {
        this.D = object0;
        this.G |= 0x80000000;
        return this.E.handleIntent(null, this);
    }
}


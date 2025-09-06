package k8;

import android.widget.ImageView;
import com.iloen.melon.MusicBrowserActivity;
import kotlin.coroutines.Continuation;
import oe.c;

public final class j0 extends c {
    public ImageView B;
    public Object D;
    public final MusicBrowserActivity E;
    public int G;
    public String r;
    public ImageView w;

    public j0(MusicBrowserActivity musicBrowserActivity0, Continuation continuation0) {
        this.E = musicBrowserActivity0;
        super(continuation0);
    }

    @Override  // oe.a
    public final Object invokeSuspend(Object object0) {
        this.D = object0;
        this.G |= 0x80000000;
        return this.E.flipIconWithAnimation(null, null, null, this);
    }
}


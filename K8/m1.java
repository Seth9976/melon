package k8;

import com.iloen.melon.MusicBrowserActivity;
import kotlin.jvm.internal.r;
import we.a;

public final class m1 extends r implements a {
    public final int f;
    public final MusicBrowserActivity g;

    public m1(MusicBrowserActivity musicBrowserActivity0, int v) {
        this.f = v;
        this.g = musicBrowserActivity0;
        super(0);
    }

    @Override  // we.a
    public final Object invoke() {
        switch(this.f) {
            case 0: {
                return this.g.getDefaultViewModelProviderFactory();
            }
            case 1: {
                return this.g.getViewModelStore();
            }
            default: {
                return this.g.getDefaultViewModelCreationExtras();
            }
        }
    }
}


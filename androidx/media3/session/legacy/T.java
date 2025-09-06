package androidx.media3.session.legacy;

import X2.b;

public final class t extends s {
    public final MediaBrowserServiceCompat g;

    public t(MediaBrowserServiceCompat mediaBrowserServiceCompat0) {
        this.g = mediaBrowserServiceCompat0;
        super(mediaBrowserServiceCompat0);
    }

    @Override  // androidx.media3.session.legacy.p
    public final b0 l() {
        MediaBrowserServiceCompat mediaBrowserServiceCompat0 = this.g;
        n n0 = mediaBrowserServiceCompat0.f;
        if(n0 == null) {
            throw new IllegalStateException("This should be called inside of onGetRoot, onLoadChildren, onLoadItem, onSearch, or onCustomAction methods");
        }
        if(n0 == mediaBrowserServiceCompat0.c) {
            b b0 = (b)this.b;
            b0.getClass();
            return new b0(b0.getCurrentBrowserInfo());
        }
        return n0.d;
    }
}


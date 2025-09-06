package com.melon.playback;

import Nb.o0;
import androidx.media3.session.MediaLibraryService;
import androidx.media3.session.f0;
import ee.l;
import fe.b;
import k8.j;
import kotlinx.coroutines.CoroutineScope;
import mb.k;

public abstract class Hilt_PlaybackLibraryService extends MediaLibraryService implements b {
    public volatile l j;
    public final Object k;
    public boolean l;

    public Hilt_PlaybackLibraryService() {
        this.k = new Object();
        this.l = false;
    }

    @Override  // fe.b
    public final Object generatedComponent() {
        if(this.j == null) {
            Object object0 = this.k;
            synchronized(object0) {
                if(this.j == null) {
                    this.j = new l(this);
                }
            }
        }
        return this.j.generatedComponent();
    }

    @Override  // androidx.media3.session.MediaSessionService
    public void onCreate() {
        if(!this.l) {
            this.l = true;
            o0 o00 = (o0)this.generatedComponent();
            ((PlaybackLibraryService)this).r = (k)((j)o00).b.m.get();
            ((PlaybackLibraryService)this).w = (f0)((j)o00).g.get();
            ((PlaybackLibraryService)this).B = (CoroutineScope)((j)o00).c.get();
        }
        super.onCreate();
    }
}


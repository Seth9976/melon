package com.google.android.exoplayer2.offline;

import java.io.IOException;

public final class e implements Runnable {
    public final int a;
    public final Object b;
    public final Object c;

    public e(int v, Object object0, Object object1) {
        this.a = v;
        this.b = object0;
        this.c = object1;
        super();
    }

    @Override
    public final void run() {
        switch(this.a) {
            case 0: {
                ((DownloadManagerHelper)this.b).lambda$attachService$0(((DownloadService)this.c));
                return;
            }
            case 1: {
                ((DownloadHelper)this.b).lambda$onMediaPreparationFailed$3(((IOException)this.c));
                return;
            }
            default: {
                ((DownloadHelper)this.b).lambda$prepare$1(((Callback)this.c));
            }
        }
    }
}


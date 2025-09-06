package com.google.android.exoplayer2.offline;

import com.google.android.exoplayer2.scheduler.RequirementsWatcher.Listener;
import com.google.android.exoplayer2.scheduler.RequirementsWatcher;

public final class c implements Listener {
    public final DownloadManager a;

    public c(DownloadManager downloadManager0) {
        this.a = downloadManager0;
    }

    @Override  // com.google.android.exoplayer2.scheduler.RequirementsWatcher$Listener
    public final void onRequirementsStateChanged(RequirementsWatcher requirementsWatcher0, int v) {
        this.a.onRequirementsStateChanged(requirementsWatcher0, v);
    }
}


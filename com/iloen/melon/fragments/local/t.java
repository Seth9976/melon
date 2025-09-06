package com.iloen.melon.fragments.local;

import java.io.File;
import java.io.FilenameFilter;

public final class t implements FilenameFilter {
    public final int a;
    public final LocalFolderListFragment b;

    public t(LocalFolderListFragment localFolderListFragment0, int v) {
        this.a = v;
        this.b = localFolderListFragment0;
        super();
    }

    @Override
    public final boolean accept(File file0, String s) {
        return this.a == 0 ? AddPlaylistSongFolderCoroutineAsync.backgroundWork$lambda$0(this.b, file0, s) : ScanFileCoroutineAsync.backgroundWork$lambda$0(this.b, file0, s);
    }
}


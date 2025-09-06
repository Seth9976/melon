package com.facebook.internal;

import java.io.File;
import java.io.FilenameFilter;

public final class b implements FilenameFilter {
    public final int a;

    public b(int v) {
        this.a = v;
        super();
    }

    @Override
    public final boolean accept(File file0, String s) {
        switch(this.a) {
            case 0: {
                return BufferFile.filterExcludeBufferFiles$lambda$0(file0, s);
            }
            case 1: {
                return BufferFile.filterExcludeNonBufferFiles$lambda$1(file0, s);
            }
            default: {
                return Utility.refreshBestGuessNumberOfCPUCores$lambda$4(file0, s);
            }
        }
    }
}


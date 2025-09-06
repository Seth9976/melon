package k7;

import java.io.File;
import java.io.FilenameFilter;

public final class b implements FilenameFilter {
    public final String a;

    public b(String s) {
        this.a = s;
    }

    @Override
    public final boolean accept(File file0, String s) {
        return s.startsWith(this.a);
    }
}


package h9;

import com.iloen.melon.mcache.util.FileLog;
import java.io.File;
import java.io.FileFilter;

public final class a implements FileFilter {
    public final FileLog a;

    public a(FileLog fileLog0) {
        this.a = fileLog0;
    }

    @Override
    public final boolean accept(File file0) {
        return file0.getName().contains(this.a.mFilename);
    }
}


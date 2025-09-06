package P1;

import android.net.Uri;
import androidx.core.content.FileProvider;
import java.io.File;
import java.io.IOException;
import java.util.HashMap;

public final class d {
    public final String a;
    public final HashMap b;

    public d(String s) {
        this.b = new HashMap();
        this.a = s;
    }

    public final File a(Uri uri0) {
        File file2;
        String s = uri0.getEncodedPath();
        int v = s.indexOf(0x2F, 1);
        if(v == -1) {
            throw new IllegalArgumentException("Unable to find path from root: " + uri0);
        }
        String s1 = Uri.decode(s.substring(1, v));
        String s2 = Uri.decode(s.substring(v + 1));
        File file0 = (File)this.b.get(s1);
        if(file0 == null) {
            throw new IllegalArgumentException("Unable to find configured root for " + uri0);
        }
        File file1 = new File(file0, s2);
        try {
            file2 = file1.getCanonicalFile();
        }
        catch(IOException unused_ex) {
            throw new IllegalArgumentException("Failed to resolve canonical path for " + file1);
        }
        if(!FileProvider.a(file2.getPath()).startsWith(FileProvider.a(file0.getPath()) + '/')) {
            throw new SecurityException("Resolved path jumped beyond configured root");
        }
        return file2;
    }
}


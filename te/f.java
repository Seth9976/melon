package te;

import java.io.File;
import kotlin.jvm.internal.q;

public final class f extends c {
    public boolean b;
    public File[] c;
    public int d;

    @Override  // te.h
    public final File a() {
        File file0 = this.a;
        if(!this.b) {
            this.b = true;
            return file0;
        }
        File[] arr_file = this.c;
        if(arr_file != null && this.d >= arr_file.length) {
            return null;
        }
        if(arr_file == null) {
            File[] arr_file1 = file0.listFiles();
            this.c = arr_file1;
            if(arr_file1 == null || arr_file1.length == 0) {
                return null;
            }
        }
        File[] arr_file2 = this.c;
        q.d(arr_file2);
        int v = this.d;
        this.d = v + 1;
        return arr_file2[v];
    }
}


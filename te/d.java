package te;

import java.io.File;
import kotlin.jvm.internal.q;

public final class d extends c {
    public boolean b;
    public File[] c;
    public int d;
    public boolean e;

    @Override  // te.h
    public final File a() {
        File file0 = this.a;
        if(!this.e && this.c == null) {
            File[] arr_file = file0.listFiles();
            this.c = arr_file;
            if(arr_file == null) {
                this.e = true;
            }
        }
        File[] arr_file1 = this.c;
        if(arr_file1 != null && this.d < arr_file1.length) {
            q.d(arr_file1);
            int v = this.d;
            this.d = v + 1;
            return arr_file1[v];
        }
        if(!this.b) {
            this.b = true;
            return file0;
        }
        return null;
    }
}


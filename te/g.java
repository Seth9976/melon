package te;

import Sf.j;
import i.n.i.b.a.s.e.M3;
import java.io.File;
import java.util.ArrayDeque;
import je.b;

public final class g extends b {
    public final ArrayDeque c;
    public final j d;

    public g(j j0) {
        this.d = j0;
        ArrayDeque arrayDeque0 = new ArrayDeque();
        this.c = arrayDeque0;
        File file0 = (File)j0.b;
        if(file0.isDirectory()) {
            arrayDeque0.push(this.b(file0));
            return;
        }
        if(file0.isFile()) {
            arrayDeque0.push(new e(file0));  // 初始化器: Lte/h;-><init>(Ljava/io/File;)V
            return;
        }
        this.a = 2;
    }

    @Override  // je.b
    public final void a() {
        File file0;
        while(true) {
            ArrayDeque arrayDeque0 = this.c;
            h h0 = (h)arrayDeque0.peek();
            if(h0 == null) {
                file0 = null;
                break;
            }
            File file1 = h0.a();
            if(file1 == null) {
                arrayDeque0.pop();
            }
            else {
                if(file1.equals(h0.a) || !file1.isDirectory() || arrayDeque0.size() >= 0x7FFFFFFF) {
                    file0 = file1;
                    break;
                }
                arrayDeque0.push(this.b(file1));
            }
        }
        if(file0 != null) {
            this.b = file0;
            this.a = 1;
            return;
        }
        this.a = 2;
    }

    public final c b(File file0) {
        switch(((i)this.d.c).ordinal()) {
            case 0: {
                return new f(file0);  // 初始化器: Lte/h;-><init>(Ljava/io/File;)V
            }
            case 1: {
                return new d(file0);  // 初始化器: Lte/h;-><init>(Ljava/io/File;)V
            }
            default: {
                throw new M3();  // 初始化器: Ljava/lang/RuntimeException;-><init>()V
            }
        }
    }
}


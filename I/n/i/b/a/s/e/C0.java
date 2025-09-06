package i.n.i.b.a.s.e;

import android.os.Handler.Callback;
import android.os.Handler;
import android.os.Message;
import java.util.TreeMap;

public final class c0 implements Handler.Callback {
    public final L3 a;
    public final fc b;
    public final a4 c;
    public final Handler d;
    public final TreeMap e;
    public p1 f;
    public boolean g;
    public boolean h;
    public boolean i;

    public c0(p1 p10, fc fc0, L3 l30) {
        this.f = p10;
        this.b = fc0;
        this.a = l30;
        this.e = new TreeMap();
        this.d = L7.j(this);
        this.c = new a4();  // 初始化器: Ljava/lang/Object;-><init>()V
    }

    @Override  // android.os.Handler$Callback
    public final boolean handleMessage(Message message0) {
        if(!this.i) {
            if(message0.what != 1) {
                return false;
            }
            long v = ((a0)message0.obj).a;
            long v1 = ((a0)message0.obj).b;
            TreeMap treeMap0 = this.e;
            Long long0 = (Long)treeMap0.get(v1);
            if(long0 == null) {
                treeMap0.put(v1, v);
                return true;
            }
            if(((long)long0) > v) {
                treeMap0.put(v1, v);
            }
        }
        return true;
    }
}


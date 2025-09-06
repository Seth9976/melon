package U2;

import De.d;
import S2.a;
import androidx.collection.W;
import androidx.lifecycle.D;
import androidx.lifecycle.q0;
import androidx.loader.content.Loader;
import java.io.FileDescriptor;
import java.io.PrintWriter;
import kotlin.jvm.internal.q;

public final class g extends b {
    public final Object a;
    public final f b;

    public g(D d0, q0 q00) {
        this.a = d0;
        q.g(q00, "store");
        q.g(a.b, "defaultCreationExtras");
        o9.b b0 = new o9.b(q00, f.c, a.b);
        d d1 = df.d.y(f.class);
        String s = d1.l();
        if(s == null) {
            throw new IllegalArgumentException("Local and anonymous classes can not be ViewModels");
        }
        this.b = (f)b0.s(d1, "androidx.lifecycle.ViewModelProvider.DefaultKey:" + s);
    }

    public final void b(String s, FileDescriptor fileDescriptor0, PrintWriter printWriter0, String[] arr_s) {
        W w0 = this.b.a;
        if(w0.c > 0) {
            printWriter0.print(s);
            printWriter0.println("Loaders:");
            for(int v = 0; v < w0.c; ++v) {
                c c0 = (c)w0.e(v);
                printWriter0.print(s);
                printWriter0.print("  #");
                printWriter0.print(w0.a[v]);
                printWriter0.print(": ");
                printWriter0.println(c0.toString());
                printWriter0.print(s + "    ");
                printWriter0.print("mId=");
                printWriter0.print(0);
                printWriter0.print(" mArgs=");
                printWriter0.println(null);
                printWriter0.print(s + "    ");
                printWriter0.print("mLoader=");
                Loader loader0 = c0.l;
                printWriter0.println(loader0);
                loader0.dump(s + "    " + "  ", fileDescriptor0, printWriter0, arr_s);
                if(c0.n != null) {
                    printWriter0.print(s + "    ");
                    printWriter0.print("mCallbacks=");
                    printWriter0.println(c0.n);
                    U2.d d0 = c0.n;
                    d0.getClass();
                    printWriter0.print(s + "    " + "  ");
                    printWriter0.print("mDeliveredData=");
                    printWriter0.println(d0.c);
                }
                printWriter0.print(s + "    ");
                printWriter0.print("mData=");
                printWriter0.println(loader0.dataToString(c0.getValue()));
                printWriter0.print(s + "    ");
                printWriter0.print("mStarted=");
                printWriter0.println(c0.hasActiveObservers());
            }
        }
    }

    @Override
    public final String toString() {
        Class class0 = this.a.getClass();
        return "LoaderManager{" + Integer.toHexString(System.identityHashCode(this)) + " in " + class0.getSimpleName() + "{" + Integer.toHexString(System.identityHashCode(class0)) + "}}";
    }
}


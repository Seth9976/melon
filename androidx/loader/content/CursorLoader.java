package androidx.loader.content;

import Q0.p1;
import Q1.c;
import Y1.b;
import Y1.h;
import android.content.Context;
import android.database.Cursor;
import android.net.Uri;
import java.io.FileDescriptor;
import java.io.PrintWriter;
import java.util.Arrays;

public class CursorLoader extends AsyncTaskLoader {
    public final p1 a;
    public final Uri b;
    public final String[] c;
    public Cursor d;
    public b e;

    public CursorLoader(Context context0) {
        super(context0);
        this.a = new p1(this);
    }

    public CursorLoader(Context context0, Uri uri0, String[] arr_s) {
        super(context0);
        this.a = new p1(this);
        this.b = uri0;
        this.c = arr_s;
    }

    public final void a(Cursor cursor0) {
        if(!this.isReset()) {
            Cursor cursor1 = this.d;
            this.d = cursor0;
            if(this.isStarted()) {
                super.deliverResult(cursor0);
            }
            if(cursor1 != null && cursor1 != cursor0 && !cursor1.isClosed()) {
                cursor1.close();
            }
        }
        else if(cursor0 != null) {
            cursor0.close();
        }
    }

    public final Cursor b() {
        synchronized(this) {
            if(!this.isLoadInBackgroundCanceled()) {
                this.e = new b();  // 初始化器: Ljava/lang/Object;-><init>()V
                try {
                    Cursor cursor0 = c.N(this.getContext().getContentResolver(), this.b, this.c, this.e);
                    if(cursor0 != null) {
                        try {
                            cursor0.getCount();
                            cursor0.registerContentObserver(this.a);
                        }
                        catch(RuntimeException runtimeException0) {
                            cursor0.close();
                            throw runtimeException0;
                        }
                    }
                    return cursor0;
                }
                finally {
                    synchronized(this) {
                        this.e = null;
                    }
                }
            }
        }
        throw new h();
    }

    @Override  // androidx.loader.content.AsyncTaskLoader
    public final void cancelLoadInBackground() {
        super.cancelLoadInBackground();
        synchronized(this) {
            b b0 = this.e;
            if(b0 != null) {
                b0.a();
            }
        }
    }

    @Override  // androidx.loader.content.Loader
    public final void deliverResult(Object object0) {
        this.a(((Cursor)object0));
    }

    @Override  // androidx.loader.content.AsyncTaskLoader
    public final void dump(String s, FileDescriptor fileDescriptor0, PrintWriter printWriter0, String[] arr_s) {
        super.dump(s, fileDescriptor0, printWriter0, arr_s);
        printWriter0.print(s);
        printWriter0.print("mUri=");
        printWriter0.println(this.b);
        printWriter0.print(s);
        printWriter0.print("mProjection=");
        printWriter0.println(Arrays.toString(this.c));
        printWriter0.print(s);
        printWriter0.print("mSelection=");
        printWriter0.println(null);
        printWriter0.print(s);
        printWriter0.print("mSelectionArgs=");
        printWriter0.println("null");
        printWriter0.print(s);
        printWriter0.print("mSortOrder=");
        printWriter0.println(null);
        printWriter0.print(s);
        printWriter0.print("mCursor=");
        printWriter0.println(this.d);
    }

    @Override  // androidx.loader.content.AsyncTaskLoader
    public final Object loadInBackground() {
        return this.b();
    }

    @Override  // androidx.loader.content.AsyncTaskLoader
    public final void onCanceled(Object object0) {
        if(((Cursor)object0) != null && !((Cursor)object0).isClosed()) {
            ((Cursor)object0).close();
        }
    }

    @Override  // androidx.loader.content.Loader
    public final void onReset() {
        super.onReset();
        this.cancelLoad();
        if(this.d != null && !this.d.isClosed()) {
            this.d.close();
        }
        this.d = null;
    }

    @Override  // androidx.loader.content.Loader
    public final void onStartLoading() {
        Cursor cursor0 = this.d;
        if(cursor0 != null) {
            this.a(cursor0);
        }
        if(!this.takeContentChanged() && this.d != null) {
            return;
        }
        this.forceLoad();
    }

    @Override  // androidx.loader.content.Loader
    public final void onStopLoading() {
        this.cancelLoad();
    }
}


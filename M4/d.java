package m4;

import android.graphics.Bitmap;
import android.os.AsyncTask;
import android.util.Log;

public final class d extends AsyncTask {
    public final f a;
    public final e b;

    public d(e e0, f f0) {
        this.b = e0;
        this.a = f0;
        super();
    }

    @Override  // android.os.AsyncTask
    public final Object doInBackground(Object[] arr_object) {
        Bitmap[] arr_bitmap = (Bitmap[])arr_object;
        try {
            return this.b.a();
        }
        catch(Exception exception0) {
            Log.e("Palette", "Exception thrown during async generate", exception0);
            return null;
        }
    }

    @Override  // android.os.AsyncTask
    public final void onPostExecute(Object object0) {
        this.a.a(((h)object0));
    }
}


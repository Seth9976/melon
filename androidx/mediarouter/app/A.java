package androidx.mediarouter.app;

import android.content.Context;
import android.graphics.drawable.Drawable.ConstantState;
import android.graphics.drawable.Drawable;
import android.os.AsyncTask;
import d5.w;

public final class a extends AsyncTask {
    public final int a;
    public final Context b;
    public final MediaRouteButton c;

    public a(MediaRouteButton mediaRouteButton0, int v, Context context0) {
        this.c = mediaRouteButton0;
        super();
        this.a = v;
        this.b = context0;
    }

    @Override  // android.os.AsyncTask
    public final Object doInBackground(Object[] arr_object) {
        Void[] arr_void = (Void[])arr_object;
        int v = this.a;
        return ((Drawable.ConstantState)MediaRouteButton.r.get(v)) == null ? w.B(this.b, v) : null;
    }

    @Override  // android.os.AsyncTask
    public final void onCancelled(Object object0) {
        if(((Drawable)object0) != null) {
            Drawable.ConstantState drawable$ConstantState0 = ((Drawable)object0).getConstantState();
            MediaRouteButton.r.put(this.a, drawable$ConstantState0);
        }
        this.c.g = null;
    }

    @Override  // android.os.AsyncTask
    public final void onPostExecute(Object object0) {
        Drawable drawable0 = (Drawable)object0;
        int v = this.a;
        MediaRouteButton mediaRouteButton0 = this.c;
        if(drawable0 == null) {
            Drawable.ConstantState drawable$ConstantState1 = (Drawable.ConstantState)MediaRouteButton.r.get(v);
            if(drawable$ConstantState1 != null) {
                drawable0 = drawable$ConstantState1.newDrawable();
            }
        }
        else {
            Drawable.ConstantState drawable$ConstantState0 = drawable0.getConstantState();
            MediaRouteButton.r.put(v, drawable$ConstantState0);
        }
        mediaRouteButton0.g = null;
        mediaRouteButton0.setRemoteIndicatorDrawableInternal(drawable0);
    }
}


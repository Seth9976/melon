package r;

import android.content.AsyncQueryHandler;
import android.content.ContentResolver;
import android.database.Cursor;
import android.util.Log;

public final class c extends AsyncQueryHandler {
    public final d a;

    public c(d d0, ContentResolver contentResolver0) {
        this.a = d0;
        super(contentResolver0);
    }

    @Override  // android.content.AsyncQueryHandler
    public final void onQueryComplete(int v, Object object0, Cursor cursor0) {
        d d0 = this.a;
        if(cursor0 == null) {
            Log.w("CarApp.Conn", "Null response from content provider when checking connection to the car, treating as disconnected");
            d0.postValue(0);
            return;
        }
        int v1 = cursor0.getColumnIndex("CarConnectionState");
        if(v1 < 0) {
            Log.e("CarApp.Conn", "Connection to car response is missing the connection type, treating as disconnected");
            d0.postValue(0);
            return;
        }
        if(!cursor0.moveToNext()) {
            Log.e("CarApp.Conn", "Connection to car response is empty, treating as disconnected");
            d0.postValue(0);
            return;
        }
        d0.postValue(cursor0.getInt(v1));
    }
}


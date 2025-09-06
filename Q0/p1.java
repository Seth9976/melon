package Q0;

import android.database.ContentObserver;
import android.net.Uri;
import android.os.Handler;
import androidx.appcompat.widget.Y0;
import androidx.loader.content.CursorLoader;
import ie.H;
import kotlinx.coroutines.channels.Channel;

public final class p1 extends ContentObserver {
    public final int a;
    public final Object b;

    public p1(Y0 y00) {
        this.a = 2;
        this.b = y00;
        super(new Handler());
    }

    public p1(CursorLoader cursorLoader0) {
        this.a = 1;
        this.b = cursorLoader0;
        super(new Handler());
    }

    public p1(Channel channel0, Handler handler0) {
        this.a = 0;
        this.b = channel0;
        super(handler0);
    }

    @Override  // android.database.ContentObserver
    public boolean deliverSelfNotifications() {
        switch(this.a) {
            case 1: {
                return true;
            }
            case 2: {
                return true;
            }
            default: {
                return super.deliverSelfNotifications();
            }
        }
    }

    @Override  // android.database.ContentObserver
    public void onChange(boolean z) {
        switch(this.a) {
            case 1: {
                ((CursorLoader)this.b).onContentChanged();
                return;
            }
            case 2: {
                Y0 y00 = (Y0)this.b;
                if(y00.b && (y00.c != null && !y00.c.isClosed())) {
                    y00.a = y00.c.requery();
                }
                return;
            }
            default: {
                super.onChange(z);
            }
        }
    }

    @Override  // android.database.ContentObserver
    public void onChange(boolean z, Uri uri0) {
        if(this.a != 0) {
            super.onChange(z, uri0);
            return;
        }
        ((Channel)this.b).trySend-JP2dKIU(H.a);
    }
}


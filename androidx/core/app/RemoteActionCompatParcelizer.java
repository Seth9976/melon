package androidx.core.app;

import P4.b;
import P4.c;
import P4.d;
import android.app.PendingIntent;
import android.text.TextUtils;
import androidx.core.graphics.drawable.IconCompat;

public class RemoteActionCompatParcelizer {
    public static RemoteActionCompat read(b b0) {
        RemoteActionCompat remoteActionCompat0 = new RemoteActionCompat();
        d d0 = remoteActionCompat0.a;
        boolean z = true;
        if(b0.e(1)) {
            d0 = b0.h();
        }
        remoteActionCompat0.a = (IconCompat)d0;
        remoteActionCompat0.b = b0.e(2) ? ((CharSequence)TextUtils.CHAR_SEQUENCE_CREATOR.createFromParcel(((c)b0).e)) : remoteActionCompat0.b;
        remoteActionCompat0.c = b0.e(3) ? ((CharSequence)TextUtils.CHAR_SEQUENCE_CREATOR.createFromParcel(((c)b0).e)) : remoteActionCompat0.c;
        remoteActionCompat0.d = (PendingIntent)b0.g(remoteActionCompat0.d, 4);
        remoteActionCompat0.e = b0.e(5) ? ((c)b0).e.readInt() != 0 : remoteActionCompat0.e;
        boolean z1 = remoteActionCompat0.f;
        if(!b0.e(6)) {
            z = z1;
        }
        else if(((c)b0).e.readInt() == 0) {
            z = false;
        }
        remoteActionCompat0.f = z;
        return remoteActionCompat0;
    }

    public static void write(RemoteActionCompat remoteActionCompat0, b b0) {
        b0.getClass();
        IconCompat iconCompat0 = remoteActionCompat0.a;
        b0.i(1);
        b0.l(iconCompat0);
        CharSequence charSequence0 = remoteActionCompat0.b;
        b0.i(2);
        TextUtils.writeToParcel(charSequence0, ((c)b0).e, 0);
        CharSequence charSequence1 = remoteActionCompat0.c;
        b0.i(3);
        TextUtils.writeToParcel(charSequence1, ((c)b0).e, 0);
        b0.k(remoteActionCompat0.d, 4);
        boolean z = remoteActionCompat0.e;
        b0.i(5);
        ((c)b0).e.writeInt(((int)z));
        boolean z1 = remoteActionCompat0.f;
        b0.i(6);
        ((c)b0).e.writeInt(((int)z1));
    }
}


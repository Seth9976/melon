package androidx.media3.session.legacy;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import android.os.Parcelable;
import android.support.v4.media.MediaDescriptionCompat.Builder;
import android.support.v4.media.MediaDescriptionCompat;
import java.util.ArrayList;
import java.util.List;

public abstract class g {
    public static Parcelable a(Parcelable parcelable0, Parcelable.Creator parcelable$Creator0) {
        if(parcelable0 == null) {
            return null;
        }
        Parcelable parcelable1 = (Parcelable)g.c(parcelable0);
        Parcel parcel0 = Parcel.obtain();
        try {
            parcelable1.writeToParcel(parcel0, 0);
            parcel0.setDataPosition(0);
            return (Parcelable)g.c(((Parcelable)parcelable$Creator0.createFromParcel(parcel0)));
        }
        finally {
            parcel0.recycle();
        }
    }

    public static ArrayList b(List list0, Parcelable.Creator parcelable$Creator0) {
        if(list0 == null) {
            return null;
        }
        ArrayList arrayList0 = new ArrayList();
        for(int v = 0; v < list0.size(); ++v) {
            arrayList0.add(g.a(((Parcelable)list0.get(v)), parcelable$Creator0));
        }
        return arrayList0;
    }

    public static Object c(Parcelable parcelable0) {
        return parcelable0;
    }

    public static MediaDescriptionCompat d(MediaDescriptionCompat mediaDescriptionCompat0) {
        return new Builder().setMediaId(mediaDescriptionCompat0.getMediaId()).setTitle(mediaDescriptionCompat0.getTitle()).setSubtitle(mediaDescriptionCompat0.getSubtitle()).setDescription(mediaDescriptionCompat0.getDescription()).setIconBitmap(mediaDescriptionCompat0.getIconBitmap()).setIconUri(mediaDescriptionCompat0.getIconUri()).setExtras(mediaDescriptionCompat0.getExtras()).setMediaUri(mediaDescriptionCompat0.getMediaUri()).build();
    }
}


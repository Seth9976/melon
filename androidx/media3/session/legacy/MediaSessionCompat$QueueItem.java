package androidx.media3.session.legacy;

import U4.x;
import android.annotation.SuppressLint;
import android.media.session.MediaSession.QueueItem;
import android.os.Parcel;
import android.os.Parcelable.Creator;
import android.os.Parcelable;
import java.util.ArrayList;
import java.util.List;

@SuppressLint({"BanParcelableUsage"})
public final class MediaSessionCompat.QueueItem implements Parcelable {
    public static final Parcelable.Creator CREATOR;
    public final MediaDescriptionCompat a;
    public final long b;
    public MediaSession.QueueItem c;

    static {
        MediaSessionCompat.QueueItem.CREATOR = new U(4);
    }

    public MediaSessionCompat.QueueItem(MediaSession.QueueItem mediaSession$QueueItem0, MediaDescriptionCompat mediaDescriptionCompat0, long v) {
        if(mediaDescriptionCompat0 == null) {
            throw new IllegalArgumentException("Description cannot be null");
        }
        if(v == -1L) {
            throw new IllegalArgumentException("Id cannot be QueueItem.UNKNOWN_ID");
        }
        this.a = mediaDescriptionCompat0;
        this.b = v;
        this.c = mediaSession$QueueItem0;
    }

    public MediaSessionCompat.QueueItem(Parcel parcel0) {
        this.a = (MediaDescriptionCompat)MediaDescriptionCompat.CREATOR.createFromParcel(parcel0);
        this.b = parcel0.readLong();
    }

    public static ArrayList a(List list0) {
        if(list0 != null) {
            ArrayList arrayList0 = new ArrayList(list0.size());
            for(Object object0: list0) {
                arrayList0.add(new MediaSessionCompat.QueueItem(((MediaSession.QueueItem)object0), MediaDescriptionCompat.a(((MediaSession.QueueItem)object0).getDescription()), ((MediaSession.QueueItem)object0).getQueueId()));
            }
            return arrayList0;
        }
        return null;
    }

    @Override  // android.os.Parcelable
    public final int describeContents() {
        return 0;
    }

    @Override
    public final String toString() {
        StringBuilder stringBuilder0 = new StringBuilder("MediaSession.QueueItem {Description=");
        stringBuilder0.append(this.a);
        stringBuilder0.append(", Id=");
        return x.h(this.b, " }", stringBuilder0);
    }

    @Override  // android.os.Parcelable
    public final void writeToParcel(Parcel parcel0, int v) {
        this.a.writeToParcel(parcel0, v);
        parcel0.writeLong(this.b);
    }
}


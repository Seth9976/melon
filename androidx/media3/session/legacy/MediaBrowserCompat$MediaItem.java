package androidx.media3.session.legacy;

import android.annotation.SuppressLint;
import android.os.Parcel;
import android.os.Parcelable.Creator;
import android.os.Parcelable;
import android.text.TextUtils;

@SuppressLint({"BanParcelableUsage"})
public class MediaBrowserCompat.MediaItem implements Parcelable {
    public static final Parcelable.Creator CREATOR;
    public final int a;
    public final MediaDescriptionCompat b;

    static {
        MediaBrowserCompat.MediaItem.CREATOR = new U(1);
    }

    public MediaBrowserCompat.MediaItem(Parcel parcel0) {
        this.a = parcel0.readInt();
        this.b = (MediaDescriptionCompat)MediaDescriptionCompat.CREATOR.createFromParcel(parcel0);
    }

    public MediaBrowserCompat.MediaItem(MediaDescriptionCompat mediaDescriptionCompat0, int v) {
        if(TextUtils.isEmpty(mediaDescriptionCompat0.a)) {
            throw new IllegalArgumentException("description must have a non-empty media id");
        }
        this.a = v;
        this.b = mediaDescriptionCompat0;
    }

    @Override  // android.os.Parcelable
    public final int describeContents() {
        return 0;
    }

    @Override
    public final String toString() {
        return "MediaItem{mFlags=" + this.a + ", mDescription=" + this.b + '}';
    }

    @Override  // android.os.Parcelable
    public final void writeToParcel(Parcel parcel0, int v) {
        parcel0.writeInt(this.a);
        this.b.writeToParcel(parcel0, v);
    }
}


package androidx.media3.session.legacy;

import android.annotation.SuppressLint;
import android.media.MediaMetadata;
import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable.Creator;
import android.os.Parcelable;
import androidx.collection.f;

@SuppressLint({"BanParcelableUsage"})
public final class MediaMetadataCompat implements Parcelable {
    public static final Parcelable.Creator CREATOR;
    public final Bundle a;
    public MediaMetadata b;
    public static final f c;
    public static final String[] d;

    static {
        f f0 = new f(0);  // 初始化器: Landroidx/collection/V;-><init>(I)V
        MediaMetadataCompat.c = f0;
        f0.put("android.media.metadata.TITLE", 1);
        f0.put("android.media.metadata.ARTIST", 1);
        f0.put("android.media.metadata.DURATION", 0);
        f0.put("android.media.metadata.ALBUM", 1);
        f0.put("android.media.metadata.AUTHOR", 1);
        f0.put("android.media.metadata.WRITER", 1);
        f0.put("android.media.metadata.COMPOSER", 1);
        f0.put("android.media.metadata.COMPILATION", 1);
        f0.put("android.media.metadata.DATE", 1);
        f0.put("android.media.metadata.YEAR", 0);
        f0.put("android.media.metadata.GENRE", 1);
        f0.put("android.media.metadata.TRACK_NUMBER", 0);
        f0.put("android.media.metadata.NUM_TRACKS", 0);
        f0.put("android.media.metadata.DISC_NUMBER", 0);
        f0.put("android.media.metadata.ALBUM_ARTIST", 1);
        f0.put("android.media.metadata.ART", 2);
        f0.put("android.media.metadata.ART_URI", 1);
        f0.put("android.media.metadata.ALBUM_ART", 2);
        f0.put("android.media.metadata.ALBUM_ART_URI", 1);
        f0.put("android.media.metadata.USER_RATING", 3);
        f0.put("android.media.metadata.RATING", 3);
        f0.put("android.media.metadata.DISPLAY_TITLE", 1);
        f0.put("android.media.metadata.DISPLAY_SUBTITLE", 1);
        f0.put("android.media.metadata.DISPLAY_DESCRIPTION", 1);
        f0.put("android.media.metadata.DISPLAY_ICON", 2);
        f0.put("android.media.metadata.DISPLAY_ICON_URI", 1);
        f0.put("android.media.metadata.MEDIA_ID", 1);
        f0.put("android.media.metadata.BT_FOLDER_TYPE", 0);
        f0.put("android.media.metadata.MEDIA_URI", 1);
        f0.put("android.media.metadata.ADVERTISEMENT", 0);
        f0.put("android.media.metadata.DOWNLOAD_STATUS", 0);
        MediaMetadataCompat.d = new String[]{"android.media.metadata.TITLE", "android.media.metadata.ARTIST", "android.media.metadata.ALBUM", "android.media.metadata.ALBUM_ARTIST", "android.media.metadata.WRITER", "android.media.metadata.AUTHOR", "android.media.metadata.COMPOSER"};
        MediaMetadataCompat.CREATOR = new U(3);
    }

    public MediaMetadataCompat(Bundle bundle0) {
        Bundle bundle1 = new Bundle(bundle0);
        this.a = bundle1;
        V.f(bundle1);
    }

    public MediaMetadataCompat(Parcel parcel0) {
        Bundle bundle0 = parcel0.readBundle(V.class.getClassLoader());
        bundle0.getClass();
        this.a = bundle0;
    }

    public final long a(String s) {
        return this.a.getLong(s, 0L);
    }

    @Override  // android.os.Parcelable
    public final int describeContents() {
        return 0;
    }

    @Override  // android.os.Parcelable
    public final void writeToParcel(Parcel parcel0, int v) {
        parcel0.writeBundle(this.a);
    }
}


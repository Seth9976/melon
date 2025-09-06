package androidx.media3.session.legacy;

import android.annotation.SuppressLint;
import android.graphics.Bitmap;
import android.media.MediaDescription.Builder;
import android.media.MediaDescription;
import android.net.Uri;
import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable.Creator;
import android.os.Parcelable;

@SuppressLint({"BanParcelableUsage"})
public final class MediaDescriptionCompat implements Parcelable {
    public static final Parcelable.Creator CREATOR;
    public final String a;
    public final CharSequence b;
    public final CharSequence c;
    public final CharSequence d;
    public final Bitmap e;
    public final Uri f;
    public final Bundle g;
    public final Uri h;
    public MediaDescription i;

    static {
        MediaDescriptionCompat.CREATOR = new U(2);
    }

    public MediaDescriptionCompat(String s, CharSequence charSequence0, CharSequence charSequence1, CharSequence charSequence2, Bitmap bitmap0, Uri uri0, Bundle bundle0, Uri uri1) {
        this.a = s;
        this.b = charSequence0;
        this.c = charSequence1;
        this.d = charSequence2;
        this.e = bitmap0;
        this.f = uri0;
        this.g = bundle0;
        this.h = uri1;
    }

    public static MediaDescriptionCompat a(Object object0) {
        Bundle bundle1;
        Uri uri0 = null;
        if(object0 != null) {
            String s = ((MediaDescription)object0).getMediaId();
            CharSequence charSequence0 = ((MediaDescription)object0).getTitle();
            CharSequence charSequence1 = ((MediaDescription)object0).getSubtitle();
            CharSequence charSequence2 = ((MediaDescription)object0).getDescription();
            Bitmap bitmap0 = ((MediaDescription)object0).getIconBitmap();
            Uri uri1 = ((MediaDescription)object0).getIconUri();
            Bundle bundle0 = V.D(((MediaDescription)object0).getExtras());
            if(bundle0 != null) {
                bundle0 = new Bundle(bundle0);
            }
            if(bundle0 == null) {
                bundle1 = null;
            }
            else {
                Uri uri2 = (Uri)bundle0.getParcelable("android.support.v4.media.description.MEDIA_URI");
                if(uri2 == null) {
                    bundle1 = bundle0;
                }
                else if(bundle0.containsKey("android.support.v4.media.description.NULL_BUNDLE_FLAG") && bundle0.size() == 2) {
                    bundle1 = null;
                }
                else {
                    bundle0.remove("android.support.v4.media.description.MEDIA_URI");
                    bundle0.remove("android.support.v4.media.description.NULL_BUNDLE_FLAG");
                    bundle1 = bundle0;
                }
                uri0 = uri2;
            }
            if(uri0 == null) {
                uri0 = ((MediaDescription)object0).getMediaUri();
            }
            MediaDescriptionCompat mediaDescriptionCompat0 = new MediaDescriptionCompat(s, charSequence0, charSequence1, charSequence2, bitmap0, uri1, bundle1, uri0);
            mediaDescriptionCompat0.i = (MediaDescription)object0;
            return mediaDescriptionCompat0;
        }
        return null;
    }

    public final MediaDescription d() {
        MediaDescription mediaDescription0 = this.i;
        if(mediaDescription0 != null) {
            return mediaDescription0;
        }
        MediaDescription.Builder mediaDescription$Builder0 = new MediaDescription.Builder();
        mediaDescription$Builder0.setMediaId(this.a);
        mediaDescription$Builder0.setTitle(this.b);
        mediaDescription$Builder0.setSubtitle(this.c);
        mediaDescription$Builder0.setDescription(this.d);
        mediaDescription$Builder0.setIconBitmap(this.e);
        mediaDescription$Builder0.setIconUri(this.f);
        mediaDescription$Builder0.setExtras(this.g);
        mediaDescription$Builder0.setMediaUri(this.h);
        MediaDescription mediaDescription1 = mediaDescription$Builder0.build();
        this.i = mediaDescription1;
        return mediaDescription1;
    }

    @Override  // android.os.Parcelable
    public final int describeContents() {
        return 0;
    }

    @Override
    public final String toString() {
        return this.b + ", " + this.c + ", " + this.d;
    }

    @Override  // android.os.Parcelable
    public final void writeToParcel(Parcel parcel0, int v) {
        this.d().writeToParcel(parcel0, v);
    }
}


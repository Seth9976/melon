package android.support.v4.media;

import android.annotation.SuppressLint;
import android.graphics.Bitmap;
import android.media.MediaDescription.Builder;
import android.media.MediaDescription;
import android.net.Uri;
import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable.Creator;
import android.os.Parcelable;
import android.support.v4.media.session.MediaSessionCompat;
import android.text.TextUtils;

@SuppressLint({"BanParcelableUsage"})
public final class MediaDescriptionCompat implements Parcelable {
    static class Api21Impl {
        public static MediaDescription build(MediaDescription.Builder mediaDescription$Builder0) {
            return mediaDescription$Builder0.build();
        }

        public static MediaDescription.Builder createBuilder() {
            return new MediaDescription.Builder();
        }

        public static CharSequence getDescription(MediaDescription mediaDescription0) {
            return mediaDescription0.getDescription();
        }

        public static Bundle getExtras(MediaDescription mediaDescription0) {
            return mediaDescription0.getExtras();
        }

        public static Bitmap getIconBitmap(MediaDescription mediaDescription0) {
            return mediaDescription0.getIconBitmap();
        }

        public static Uri getIconUri(MediaDescription mediaDescription0) {
            return mediaDescription0.getIconUri();
        }

        public static String getMediaId(MediaDescription mediaDescription0) {
            return mediaDescription0.getMediaId();
        }

        public static CharSequence getSubtitle(MediaDescription mediaDescription0) {
            return mediaDescription0.getSubtitle();
        }

        public static CharSequence getTitle(MediaDescription mediaDescription0) {
            return mediaDescription0.getTitle();
        }

        public static void setDescription(MediaDescription.Builder mediaDescription$Builder0, CharSequence charSequence0) {
            mediaDescription$Builder0.setDescription(charSequence0);
        }

        public static void setExtras(MediaDescription.Builder mediaDescription$Builder0, Bundle bundle0) {
            mediaDescription$Builder0.setExtras(bundle0);
        }

        public static void setIconBitmap(MediaDescription.Builder mediaDescription$Builder0, Bitmap bitmap0) {
            mediaDescription$Builder0.setIconBitmap(bitmap0);
        }

        public static void setIconUri(MediaDescription.Builder mediaDescription$Builder0, Uri uri0) {
            mediaDescription$Builder0.setIconUri(uri0);
        }

        public static void setMediaId(MediaDescription.Builder mediaDescription$Builder0, String s) {
            mediaDescription$Builder0.setMediaId(s);
        }

        public static void setSubtitle(MediaDescription.Builder mediaDescription$Builder0, CharSequence charSequence0) {
            mediaDescription$Builder0.setSubtitle(charSequence0);
        }

        public static void setTitle(MediaDescription.Builder mediaDescription$Builder0, CharSequence charSequence0) {
            mediaDescription$Builder0.setTitle(charSequence0);
        }
    }

    static class Api23Impl {
        public static Uri getMediaUri(MediaDescription mediaDescription0) {
            return mediaDescription0.getMediaUri();
        }

        public static void setMediaUri(MediaDescription.Builder mediaDescription$Builder0, Uri uri0) {
            mediaDescription$Builder0.setMediaUri(uri0);
        }
    }

    public static final class Builder {
        private CharSequence mDescription;
        private Bundle mExtras;
        private Bitmap mIcon;
        private Uri mIconUri;
        private String mMediaId;
        private Uri mMediaUri;
        private CharSequence mSubtitle;
        private CharSequence mTitle;

        public MediaDescriptionCompat build() {
            return new MediaDescriptionCompat(this.mMediaId, this.mTitle, this.mSubtitle, this.mDescription, this.mIcon, this.mIconUri, this.mExtras, this.mMediaUri);
        }

        public Builder setDescription(CharSequence charSequence0) {
            this.mDescription = charSequence0;
            return this;
        }

        public Builder setExtras(Bundle bundle0) {
            this.mExtras = bundle0;
            return this;
        }

        public Builder setIconBitmap(Bitmap bitmap0) {
            this.mIcon = bitmap0;
            return this;
        }

        public Builder setIconUri(Uri uri0) {
            this.mIconUri = uri0;
            return this;
        }

        public Builder setMediaId(String s) {
            this.mMediaId = s;
            return this;
        }

        public Builder setMediaUri(Uri uri0) {
            this.mMediaUri = uri0;
            return this;
        }

        public Builder setSubtitle(CharSequence charSequence0) {
            this.mSubtitle = charSequence0;
            return this;
        }

        public Builder setTitle(CharSequence charSequence0) {
            this.mTitle = charSequence0;
            return this;
        }
    }

    public static final long BT_FOLDER_TYPE_ALBUMS = 2L;
    public static final long BT_FOLDER_TYPE_ARTISTS = 3L;
    public static final long BT_FOLDER_TYPE_GENRES = 4L;
    public static final long BT_FOLDER_TYPE_MIXED = 0L;
    public static final long BT_FOLDER_TYPE_PLAYLISTS = 5L;
    public static final long BT_FOLDER_TYPE_TITLES = 1L;
    public static final long BT_FOLDER_TYPE_YEARS = 6L;
    public static final Parcelable.Creator CREATOR = null;
    public static final String DESCRIPTION_KEY_MEDIA_URI = "android.support.v4.media.description.MEDIA_URI";
    public static final String DESCRIPTION_KEY_NULL_BUNDLE_FLAG = "android.support.v4.media.description.NULL_BUNDLE_FLAG";
    public static final String EXTRA_BT_FOLDER_TYPE = "android.media.extra.BT_FOLDER_TYPE";
    public static final String EXTRA_DOWNLOAD_STATUS = "android.media.extra.DOWNLOAD_STATUS";
    public static final long STATUS_DOWNLOADED = 2L;
    public static final long STATUS_DOWNLOADING = 1L;
    public static final long STATUS_NOT_DOWNLOADED = 0L;
    private static final String TAG = "MediaDescriptionCompat";
    private final CharSequence mDescription;
    private MediaDescription mDescriptionFwk;
    private final Bundle mExtras;
    private final Bitmap mIcon;
    private final Uri mIconUri;
    private final String mMediaId;
    private final Uri mMediaUri;
    private final CharSequence mSubtitle;
    private final CharSequence mTitle;

    static {
        MediaDescriptionCompat.CREATOR = new Parcelable.Creator() {
            public MediaDescriptionCompat createFromParcel(Parcel parcel0) {
                return MediaDescriptionCompat.fromMediaDescription(MediaDescription.CREATOR.createFromParcel(parcel0));
            }

            @Override  // android.os.Parcelable$Creator
            public Object createFromParcel(Parcel parcel0) {
                return this.createFromParcel(parcel0);
            }

            public MediaDescriptionCompat[] newArray(int v) {
                return new MediaDescriptionCompat[v];
            }

            @Override  // android.os.Parcelable$Creator
            public Object[] newArray(int v) {
                return this.newArray(v);
            }
        };
    }

    public MediaDescriptionCompat(Parcel parcel0) {
        this.mMediaId = parcel0.readString();
        Parcelable.Creator parcelable$Creator0 = TextUtils.CHAR_SEQUENCE_CREATOR;
        this.mTitle = (CharSequence)parcelable$Creator0.createFromParcel(parcel0);
        this.mSubtitle = (CharSequence)parcelable$Creator0.createFromParcel(parcel0);
        this.mDescription = (CharSequence)parcelable$Creator0.createFromParcel(parcel0);
        ClassLoader classLoader0 = MediaDescriptionCompat.class.getClassLoader();
        this.mIcon = (Bitmap)parcel0.readParcelable(classLoader0);
        this.mIconUri = (Uri)parcel0.readParcelable(classLoader0);
        this.mExtras = parcel0.readBundle(classLoader0);
        this.mMediaUri = (Uri)parcel0.readParcelable(classLoader0);
    }

    public MediaDescriptionCompat(String s, CharSequence charSequence0, CharSequence charSequence1, CharSequence charSequence2, Bitmap bitmap0, Uri uri0, Bundle bundle0, Uri uri1) {
        this.mMediaId = s;
        this.mTitle = charSequence0;
        this.mSubtitle = charSequence1;
        this.mDescription = charSequence2;
        this.mIcon = bitmap0;
        this.mIconUri = uri0;
        this.mExtras = bundle0;
        this.mMediaUri = uri1;
    }

    @Override  // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public static MediaDescriptionCompat fromMediaDescription(Object object0) {
        MediaDescriptionCompat mediaDescriptionCompat0 = null;
        if(object0 != null) {
            Builder mediaDescriptionCompat$Builder0 = new Builder();
            mediaDescriptionCompat$Builder0.setMediaId(Api21Impl.getMediaId(((MediaDescription)object0)));
            mediaDescriptionCompat$Builder0.setTitle(Api21Impl.getTitle(((MediaDescription)object0)));
            mediaDescriptionCompat$Builder0.setSubtitle(Api21Impl.getSubtitle(((MediaDescription)object0)));
            mediaDescriptionCompat$Builder0.setDescription(Api21Impl.getDescription(((MediaDescription)object0)));
            mediaDescriptionCompat$Builder0.setIconBitmap(Api21Impl.getIconBitmap(((MediaDescription)object0)));
            mediaDescriptionCompat$Builder0.setIconUri(Api21Impl.getIconUri(((MediaDescription)object0)));
            Bundle bundle0 = Api21Impl.getExtras(((MediaDescription)object0));
            if(bundle0 != null) {
                bundle0 = MediaSessionCompat.unparcelWithClassLoader(bundle0);
            }
            Uri uri0 = bundle0 == null ? null : ((Uri)bundle0.getParcelable("android.support.v4.media.description.MEDIA_URI"));
            if(uri0 == null) {
                mediaDescriptionCompat0 = bundle0;
            }
            else if(!bundle0.containsKey("android.support.v4.media.description.NULL_BUNDLE_FLAG") || bundle0.size() != 2) {
                bundle0.remove("android.support.v4.media.description.MEDIA_URI");
                bundle0.remove("android.support.v4.media.description.NULL_BUNDLE_FLAG");
                mediaDescriptionCompat0 = bundle0;
            }
            mediaDescriptionCompat$Builder0.setExtras(((Bundle)mediaDescriptionCompat0));
            if(uri0 == null) {
                mediaDescriptionCompat$Builder0.setMediaUri(Api23Impl.getMediaUri(((MediaDescription)object0)));
            }
            else {
                mediaDescriptionCompat$Builder0.setMediaUri(uri0);
            }
            mediaDescriptionCompat0 = mediaDescriptionCompat$Builder0.build();
            mediaDescriptionCompat0.mDescriptionFwk = (MediaDescription)object0;
        }
        return mediaDescriptionCompat0;
    }

    public CharSequence getDescription() {
        return this.mDescription;
    }

    public Bundle getExtras() {
        return this.mExtras;
    }

    public Bitmap getIconBitmap() {
        return this.mIcon;
    }

    public Uri getIconUri() {
        return this.mIconUri;
    }

    public Object getMediaDescription() {
        MediaDescription mediaDescription0 = this.mDescriptionFwk;
        if(mediaDescription0 == null) {
            MediaDescription.Builder mediaDescription$Builder0 = Api21Impl.createBuilder();
            Api21Impl.setMediaId(mediaDescription$Builder0, this.mMediaId);
            Api21Impl.setTitle(mediaDescription$Builder0, this.mTitle);
            Api21Impl.setSubtitle(mediaDescription$Builder0, this.mSubtitle);
            Api21Impl.setDescription(mediaDescription$Builder0, this.mDescription);
            Api21Impl.setIconBitmap(mediaDescription$Builder0, this.mIcon);
            Api21Impl.setIconUri(mediaDescription$Builder0, this.mIconUri);
            Api21Impl.setExtras(mediaDescription$Builder0, this.mExtras);
            Api23Impl.setMediaUri(mediaDescription$Builder0, this.mMediaUri);
            mediaDescription0 = Api21Impl.build(mediaDescription$Builder0);
            this.mDescriptionFwk = mediaDescription0;
        }
        return mediaDescription0;
    }

    public String getMediaId() {
        return this.mMediaId;
    }

    public Uri getMediaUri() {
        return this.mMediaUri;
    }

    public CharSequence getSubtitle() {
        return this.mSubtitle;
    }

    public CharSequence getTitle() {
        return this.mTitle;
    }

    @Override
    public String toString() {
        return this.mTitle + ", " + this.mSubtitle + ", " + this.mDescription;
    }

    @Override  // android.os.Parcelable
    public void writeToParcel(Parcel parcel0, int v) {
        ((MediaDescription)this.getMediaDescription()).writeToParcel(parcel0, v);
    }
}


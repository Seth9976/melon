package androidx.media3.session.legacy;

import I6.p0;
import U4.x;
import android.annotation.SuppressLint;
import android.media.session.PlaybackState.CustomAction;
import android.media.session.PlaybackState;
import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable.Creator;
import android.os.Parcelable;
import android.text.TextUtils;
import java.util.AbstractCollection;
import java.util.ArrayList;
import java.util.List;

@SuppressLint({"BanParcelableUsage"})
public final class PlaybackStateCompat implements Parcelable {
    public static final class CustomAction implements Parcelable {
        public static final Parcelable.Creator CREATOR;
        public final String a;
        public final CharSequence b;
        public final int c;
        public final Bundle d;
        public PlaybackState.CustomAction e;

        static {
            CustomAction.CREATOR = new d0();  // 初始化器: Ljava/lang/Object;-><init>()V
        }

        public CustomAction(Parcel parcel0) {
            String s = parcel0.readString();
            s.getClass();
            this.a = s;
            CharSequence charSequence0 = (CharSequence)TextUtils.CHAR_SEQUENCE_CREATOR.createFromParcel(parcel0);
            charSequence0.getClass();
            this.b = charSequence0;
            this.c = parcel0.readInt();
            this.d = parcel0.readBundle(V.class.getClassLoader());
        }

        public CustomAction(String s, CharSequence charSequence0, int v, Bundle bundle0) {
            this.a = s;
            this.b = charSequence0;
            this.c = v;
            this.d = bundle0;
        }

        @Override  // android.os.Parcelable
        public final int describeContents() {
            return 0;
        }

        @Override
        public final String toString() {
            return "Action:mName=\'" + this.b + ", mIcon=" + this.c + ", mExtras=" + this.d;
        }

        @Override  // android.os.Parcelable
        public final void writeToParcel(Parcel parcel0, int v) {
            parcel0.writeString(this.a);
            TextUtils.writeToParcel(this.b, parcel0, v);
            parcel0.writeInt(this.c);
            parcel0.writeBundle(this.d);
        }
    }

    public static final Parcelable.Creator CREATOR;
    public final int a;
    public final long b;
    public final long c;
    public final float d;
    public final long e;
    public final int f;
    public final CharSequence g;
    public final long h;
    public final AbstractCollection i;
    public final long j;
    public final Bundle k;
    public PlaybackState l;

    static {
        PlaybackStateCompat.CREATOR = new U(7);
    }

    public PlaybackStateCompat(int v, long v1, long v2, float f, long v3, int v4, CharSequence charSequence0, long v5, ArrayList arrayList0, long v6, Bundle bundle0) {
        this.a = v;
        this.b = v1;
        this.c = v2;
        this.d = f;
        this.e = v3;
        this.f = v4;
        this.g = charSequence0;
        this.h = v5;
        p0 p00 = arrayList0 == null ? p0.e : new ArrayList(arrayList0);
        this.i = p00;
        this.j = v6;
        this.k = bundle0;
    }

    public PlaybackStateCompat(Parcel parcel0) {
        this.a = parcel0.readInt();
        this.b = parcel0.readLong();
        this.d = parcel0.readFloat();
        this.h = parcel0.readLong();
        this.c = parcel0.readLong();
        this.e = parcel0.readLong();
        this.g = (CharSequence)TextUtils.CHAR_SEQUENCE_CREATOR.createFromParcel(parcel0);
        ArrayList arrayList0 = parcel0.createTypedArrayList(CustomAction.CREATOR);
        if(arrayList0 == null) {
            arrayList0 = p0.e;
        }
        this.i = arrayList0;
        this.j = parcel0.readLong();
        this.k = parcel0.readBundle(V.class.getClassLoader());
        this.f = parcel0.readInt();
    }

    public static PlaybackStateCompat a(PlaybackState playbackState0) {
        ArrayList arrayList0 = null;
        if(playbackState0 != null) {
            List list0 = playbackState0.getCustomActions();
            if(list0 != null) {
                arrayList0 = new ArrayList(list0.size());
                for(Object object0: list0) {
                    if(object0 != null) {
                        Bundle bundle0 = ((PlaybackState.CustomAction)object0).getExtras();
                        V.f(bundle0);
                        CustomAction playbackStateCompat$CustomAction0 = new CustomAction(((PlaybackState.CustomAction)object0).getAction(), ((PlaybackState.CustomAction)object0).getName(), ((PlaybackState.CustomAction)object0).getIcon(), bundle0);
                        playbackStateCompat$CustomAction0.e = (PlaybackState.CustomAction)object0;
                        arrayList0.add(playbackStateCompat$CustomAction0);
                    }
                }
            }
            Bundle bundle1 = playbackState0.getExtras();
            V.f(bundle1);
            PlaybackStateCompat playbackStateCompat0 = new PlaybackStateCompat(playbackState0.getState(), playbackState0.getPosition(), playbackState0.getBufferedPosition(), playbackState0.getPlaybackSpeed(), playbackState0.getActions(), 0, playbackState0.getErrorMessage(), playbackState0.getLastPositionUpdateTime(), arrayList0, playbackState0.getActiveQueueItemId(), bundle1);
            playbackStateCompat0.l = playbackState0;
            return playbackStateCompat0;
        }
        return null;
    }

    @Override  // android.os.Parcelable
    public final int describeContents() {
        return 0;
    }

    @Override
    public final String toString() {
        StringBuilder stringBuilder0 = new StringBuilder("PlaybackState {state=");
        stringBuilder0.append(this.a);
        stringBuilder0.append(", position=");
        stringBuilder0.append(this.b);
        stringBuilder0.append(", buffered position=");
        stringBuilder0.append(this.c);
        stringBuilder0.append(", speed=");
        stringBuilder0.append(this.d);
        stringBuilder0.append(", updated=");
        stringBuilder0.append(this.h);
        stringBuilder0.append(", actions=");
        stringBuilder0.append(this.e);
        stringBuilder0.append(", error code=");
        stringBuilder0.append(this.f);
        stringBuilder0.append(", error message=");
        stringBuilder0.append(this.g);
        stringBuilder0.append(", custom actions=");
        stringBuilder0.append(this.i);
        stringBuilder0.append(", active item id=");
        return x.h(this.j, "}", stringBuilder0);
    }

    @Override  // android.os.Parcelable
    public final void writeToParcel(Parcel parcel0, int v) {
        parcel0.writeInt(this.a);
        parcel0.writeLong(this.b);
        parcel0.writeFloat(this.d);
        parcel0.writeLong(this.h);
        parcel0.writeLong(this.c);
        parcel0.writeLong(this.e);
        TextUtils.writeToParcel(this.g, parcel0, v);
        parcel0.writeTypedList(((List)this.i));
        parcel0.writeLong(this.j);
        parcel0.writeBundle(this.k);
        parcel0.writeInt(this.f);
    }
}


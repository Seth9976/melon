package o8;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.iloen.melon.alarm.MusicAlarmParcelable;
import com.melon.net.res.VoiceAlarm.Track;
import kotlin.jvm.internal.q;

public final class f implements Parcelable.Creator {
    @Override  // android.os.Parcelable$Creator
    public final Object createFromParcel(Parcel parcel0) {
        q.g(parcel0, "parcel");
        int v = parcel0.readInt();
        int v1 = parcel0.readInt();
        int v2 = parcel0.readInt();
        int v3 = parcel0.readInt();
        boolean z = parcel0.readInt() != 0;
        boolean[] arr_z = parcel0.createBooleanArray();
        boolean z1 = true;
        String s = parcel0.readString();
        if(parcel0.readInt() == 0) {
            z1 = false;
        }
        int v4 = parcel0.readInt();
        String s1 = parcel0.readString();
        String s2 = parcel0.readString();
        String s3 = parcel0.readString();
        return parcel0.readInt() == 0 ? new MusicAlarmParcelable(v, v1, v2, v3, z, arr_z, s, z1, v4, s1, s2, s3, null) : new MusicAlarmParcelable(v, v1, v2, v3, z, arr_z, s, z1, v4, s1, s2, s3, ((Track)Track.CREATOR.createFromParcel(parcel0)));
    }

    @Override  // android.os.Parcelable$Creator
    public final Object[] newArray(int v) {
        return new MusicAlarmParcelable[v];
    }
}


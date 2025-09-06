package tc;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.iloen.melon.net.v5x.response.CastDetailRes.CAST;
import com.iloen.melon.net.v5x.response.CastDetailRes.PROGRAM;
import com.melon.playlist.station.CastData;
import kotlin.jvm.internal.q;

public final class a implements Parcelable.Creator {
    @Override  // android.os.Parcelable$Creator
    public final Object createFromParcel(Parcel parcel0) {
        q.g(parcel0, "parcel");
        return new CastData(parcel0.readString(), ((CAST)parcel0.readSerializable()), ((PROGRAM)parcel0.readSerializable()), parcel0.readString(), parcel0.readString());
    }

    @Override  // android.os.Parcelable$Creator
    public final Object[] newArray(int v) {
        return new CastData[v];
    }
}


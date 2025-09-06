package com.iloen.melon.dlna.upnp.cds;

import N8.b;
import android.os.Parcel;
import android.os.Parcelable;
import java.util.Map.Entry;
import java.util.Map;
import je.x;
import kotlin.Metadata;
import kotlin.jvm.internal.q;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0007\u0018\u0000 \u00022\u00020\u0001:\u0001\u0003¨\u0006\u0004"}, d2 = {"Lcom/iloen/melon/dlna/upnp/cds/Tag;", "Landroid/os/Parcelable;", "CREATOR", "N8/b", "app_playstoreProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 0x30)
public final class Tag implements Parcelable {
    @NotNull
    public static final b CREATOR;
    public final String a;
    public final String b;
    public final Map c;

    static {
        Tag.CREATOR = new b();  // 初始化器: Ljava/lang/Object;-><init>()V
        new Tag("", "", x.a);
    }

    public Tag(String s, String s1, Map map0) {
        q.g(s1, "value");
        super();
        this.a = s;
        this.b = s1;
        this.c = map0;
    }

    @Override  // android.os.Parcelable
    public final int describeContents() {
        return 0;
    }

    @Override
    public final String toString() {
        StringBuilder stringBuilder0 = new StringBuilder();
        stringBuilder0.append(this.b);
        for(Object object0: this.c.entrySet()) {
            stringBuilder0.append("\n@" + ((Map.Entry)object0).getKey() + " => " + ((Map.Entry)object0).getValue());
        }
        String s = stringBuilder0.toString();
        q.f(s, "toString(...)");
        return s;
    }

    @Override  // android.os.Parcelable
    public final void writeToParcel(Parcel parcel0, int v) {
        q.g(parcel0, "dest");
        parcel0.writeString(this.a);
        parcel0.writeString(this.b);
        parcel0.writeInt(this.c.size());
        for(Object object0: this.c.entrySet()) {
            parcel0.writeString(((String)((Map.Entry)object0).getKey()));
            parcel0.writeString(((String)((Map.Entry)object0).getValue()));
        }
    }
}


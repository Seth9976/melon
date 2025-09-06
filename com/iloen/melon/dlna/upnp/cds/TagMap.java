package com.iloen.melon.dlna.upnp.cds;

import N8.c;
import Tf.o;
import android.os.Parcel;
import android.os.Parcelable;
import java.util.Collection;
import java.util.List;
import java.util.Map.Entry;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.internal.q;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0001\u0018\u0000 \u00022\u00020\u0001:\u0001\u0003¨\u0006\u0004"}, d2 = {"Lcom/iloen/melon/dlna/upnp/cds/TagMap;", "Landroid/os/Parcelable;", "CREATOR", "N8/c", "app_playstoreProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 0x30)
public final class TagMap implements Parcelable {
    @NotNull
    public static final c CREATOR;
    public final Map a;

    static {
        TagMap.CREATOR = new c();  // 初始化器: Ljava/lang/Object;-><init>()V
    }

    public TagMap(Map map0) {
        this.a = map0;
    }

    public final String a(String s, String s1) {
        Tag tag0;
        List list0 = (List)this.a.get(s);
        if(list0 == null) {
            tag0 = null;
        }
        else if(list0.size() > 0) {
            tag0 = (Tag)list0.get(0);
        }
        else {
            tag0 = null;
        }
        if(tag0 == null) {
            return null;
        }
        return s1 == null || s1.length() == 0 ? tag0.b : ((String)tag0.c.get(s1));
    }

    public static String b(TagMap tagMap0, String s) {
        int v = o.E0(s, '@', 0, 6);
        if(v < 0) {
            return tagMap0.a(s, null);
        }
        String s1 = s.substring(0, v);
        q.f(s1, "substring(...)");
        String s2 = s.substring(v + 1);
        q.f(s2, "substring(...)");
        return tagMap0.a(s1, s2);
    }

    @Override  // android.os.Parcelable
    public final int describeContents() {
        return 0;
    }

    @Override
    public final boolean equals(Object object0) {
        if(this == object0) {
            return true;
        }
        return object0 instanceof TagMap ? q.b(this.a, ((TagMap)object0).a) : false;
    }

    @Override
    public final int hashCode() {
        return this.a.hashCode();
    }

    @Override
    public final String toString() {
        StringBuilder stringBuilder0 = new StringBuilder();
        for(Object object0: this.a.entrySet()) {
            Map.Entry map$Entry0 = (Map.Entry)object0;
            int v = ((Collection)map$Entry0.getValue()).size();
            for(int v1 = 0; v1 < v; ++v1) {
                Tag tag0 = (Tag)((List)map$Entry0.getValue()).get(v1);
                stringBuilder0.append(((String)map$Entry0.getKey()));
                if(((List)map$Entry0.getValue()).size() == 1) {
                    stringBuilder0.append(" => ");
                }
                else {
                    stringBuilder0.append("[" + v1 + "] => ");
                }
                stringBuilder0.append(tag0.b);
                stringBuilder0.append("\n");
                for(Object object1: tag0.c.entrySet()) {
                    stringBuilder0.append("      @" + ((Map.Entry)object1).getKey() + " => " + ((Map.Entry)object1).getValue() + "\n");
                }
            }
        }
        String s = stringBuilder0.toString();
        q.f(s, "toString(...)");
        return s;
    }

    @Override  // android.os.Parcelable
    public final void writeToParcel(Parcel parcel0, int v) {
        q.g(parcel0, "dest");
        parcel0.writeInt(this.a.size());
        for(Object object0: this.a.entrySet()) {
            String s = (String)((Map.Entry)object0).getKey();
            List list0 = (List)((Map.Entry)object0).getValue();
            parcel0.writeString(s);
            parcel0.writeTypedList(list0);
        }
    }
}


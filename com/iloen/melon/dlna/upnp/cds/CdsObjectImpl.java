package com.iloen.melon.dlna.upnp.cds;

import N8.a;
import Tf.v;
import android.os.Parcel;
import kotlin.Metadata;
import kotlin.jvm.internal.q;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0001\u0018\u0000 \u00022\u00020\u0001:\u0001\u0003¨\u0006\u0004"}, d2 = {"Lcom/iloen/melon/dlna/upnp/cds/CdsObjectImpl;", "Lcom/iloen/melon/dlna/upnp/cds/CdsObject;", "CREATOR", "N8/a", "app_playstoreProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 0x30)
public final class CdsObjectImpl implements CdsObject {
    @NotNull
    public static final a CREATOR;
    public final String a;
    public final boolean b;
    public final Tag c;
    public final TagMap d;
    public final String e;
    public final String f;

    static {
        CdsObjectImpl.CREATOR = new a();  // 初始化器: Ljava/lang/Object;-><init>()V
    }

    public CdsObjectImpl(String s, boolean z, Tag tag0, TagMap tagMap0) {
        this.a = s;
        this.b = z;
        this.c = tag0;
        this.d = tagMap0;
        String s1 = TagMap.b(tagMap0, "@id");
        if(s1 == null) {
            throw new IllegalArgumentException("Malformed item");
        }
        this.e = s1;
        if(TagMap.b(tagMap0, "@parentID") == null) {
            throw new IllegalArgumentException("Malformed item");
        }
        String s2 = TagMap.b(tagMap0, "upnp:class");
        if(s2 == null) {
            throw new IllegalArgumentException("Malformed item");
        }
        String s3 = TagMap.b(tagMap0, "dc:title");
        if(s3 == null) {
            throw new IllegalArgumentException("Malformed item");
        }
        this.f = s3;
        CdsObjectImpl.CREATOR.getClass();
        if(!z || v.r0(s2, "object.item.imageItem", false) || v.r0(s2, "object.item.audioItem", false)) {
            return;
        }
        v.r0(s2, "object.item.videoItem", false);
    }

    @Override  // com.iloen.melon.dlna.upnp.cds.CdsObject
    public final String H() {
        return this.a;
    }

    @Override  // android.os.Parcelable
    public final int describeContents() {
        return 0;
    }

    @Override
    public final boolean equals(Object object0) {
        if(this != object0) {
            if(object0 instanceof CdsObject) {
                String s = ((CdsObject)object0).getObjectId();
                if(q.b(this.e, s)) {
                    String s1 = ((CdsObject)object0).H();
                    return this.a.equals(s1);
                }
            }
            return false;
        }
        return true;
    }

    @Override  // com.iloen.melon.dlna.upnp.cds.CdsObject
    public final String getObjectId() {
        return this.e;
    }

    @Override
    public final int hashCode() {
        return this.d.a.hashCode();
    }

    @Override
    public final String toString() {
        return this.f;
    }

    @Override  // android.os.Parcelable
    public final void writeToParcel(Parcel parcel0, int v) {
        q.g(parcel0, "dest");
        parcel0.writeString(this.a);
        parcel0.writeByte(((byte)this.b));
        parcel0.writeParcelable(this.c, v);
        parcel0.writeParcelable(this.d, v);
    }
}


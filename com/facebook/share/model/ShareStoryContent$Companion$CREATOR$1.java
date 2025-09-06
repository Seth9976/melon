package com.facebook.share.model;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import kotlin.Metadata;
import kotlin.jvm.internal.q;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u0000%\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0011\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001J\u0010\u0010\u0003\u001A\u00020\u00022\u0006\u0010\u0004\u001A\u00020\u0005H\u0016J\u001D\u0010\u0006\u001A\n\u0012\u0006\u0012\u0004\u0018\u00010\u00020\u00072\u0006\u0010\b\u001A\u00020\tH\u0016¢\u0006\u0002\u0010\n¨\u0006\u000B"}, d2 = {"com/facebook/share/model/ShareStoryContent$Companion$CREATOR$1", "Landroid/os/Parcelable$Creator;", "Lcom/facebook/share/model/ShareStoryContent;", "createFromParcel", "parcel", "Landroid/os/Parcel;", "newArray", "", "size", "", "(I)[Lcom/facebook/share/model/ShareStoryContent;", "facebook-common_release"}, k = 1, mv = {1, 8, 0}, xi = 0x30)
public final class ShareStoryContent.Companion.CREATOR.1 implements Parcelable.Creator {
    @NotNull
    public ShareStoryContent createFromParcel(@NotNull Parcel parcel0) {
        q.g(parcel0, "parcel");
        return new ShareStoryContent(parcel0);
    }

    @Override  // android.os.Parcelable$Creator
    public Object createFromParcel(Parcel parcel0) {
        return this.createFromParcel(parcel0);
    }

    @NotNull
    public ShareStoryContent[] newArray(int v) {
        return new ShareStoryContent[v];
    }

    @Override  // android.os.Parcelable$Creator
    public Object[] newArray(int v) {
        return this.newArray(v);
    }
}


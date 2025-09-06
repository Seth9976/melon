package com.iloen.melon.fragments.main.foru;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import android.os.Parcelable;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.q;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000E\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u000B\b\u0007\u0018\u0000 \u00192\u00020\u0001:\u0001\u0019B\u001F\b\u0016\u0012\b\u0010\u0003\u001A\u0004\u0018\u00010\u0002\u0012\n\b\u0002\u0010\u0004\u001A\u0004\u0018\u00010\u0002¢\u0006\u0004\b\u0005\u0010\u0006B\u0011\b\u0016\u0012\u0006\u0010\b\u001A\u00020\u0007¢\u0006\u0004\b\u0005\u0010\tJ\u000F\u0010\u000B\u001A\u00020\nH\u0016¢\u0006\u0004\b\u000B\u0010\fJ\u001F\u0010\u0010\u001A\u00020\u000F2\u0006\u0010\r\u001A\u00020\u00072\u0006\u0010\u000E\u001A\u00020\nH\u0016¢\u0006\u0004\b\u0010\u0010\u0011R$\u0010\u0003\u001A\u0004\u0018\u00010\u00028\u0006@\u0006X\u0086\u000E¢\u0006\u0012\n\u0004\b\u0003\u0010\u0012\u001A\u0004\b\u0013\u0010\u0014\"\u0004\b\u0015\u0010\u0016R$\u0010\u0004\u001A\u0004\u0018\u00010\u00028\u0006@\u0006X\u0086\u000E¢\u0006\u0012\n\u0004\b\u0004\u0010\u0012\u001A\u0004\b\u0017\u0010\u0014\"\u0004\b\u0018\u0010\u0016¨\u0006\u001A"}, d2 = {"Lcom/iloen/melon/fragments/main/foru/SelectedTag;", "Landroid/os/Parcelable;", "", "tagName", "emoji", "<init>", "(Ljava/lang/String;Ljava/lang/String;)V", "Landroid/os/Parcel;", "in", "(Landroid/os/Parcel;)V", "", "describeContents", "()I", "dest", "flags", "Lie/H;", "writeToParcel", "(Landroid/os/Parcel;I)V", "Ljava/lang/String;", "getTagName", "()Ljava/lang/String;", "setTagName", "(Ljava/lang/String;)V", "getEmoji", "setEmoji", "CREATOR", "app_playstoreProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 0x30)
public final class SelectedTag implements Parcelable {
    @Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0011\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\b\u0086\u0003\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0003\u0010\u0004J\u0010\u0010\u0005\u001A\u00020\u00022\u0006\u0010\u0006\u001A\u00020\u0007H\u0016J\u001D\u0010\b\u001A\n\u0012\u0006\u0012\u0004\u0018\u00010\u00020\t2\u0006\u0010\n\u001A\u00020\u000BH\u0016¢\u0006\u0002\u0010\f¨\u0006\r"}, d2 = {"Lcom/iloen/melon/fragments/main/foru/SelectedTag$CREATOR;", "Landroid/os/Parcelable$Creator;", "Lcom/iloen/melon/fragments/main/foru/SelectedTag;", "<init>", "()V", "createFromParcel", "parcel", "Landroid/os/Parcel;", "newArray", "", "size", "", "(I)[Lcom/iloen/melon/fragments/main/foru/SelectedTag;", "app_playstoreProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 0x30)
    public static final class CREATOR implements Parcelable.Creator {
        private CREATOR() {
        }

        public CREATOR(DefaultConstructorMarker defaultConstructorMarker0) {
        }

        @NotNull
        public SelectedTag createFromParcel(@NotNull Parcel parcel0) {
            q.g(parcel0, "parcel");
            return new SelectedTag(parcel0);
        }

        @Override  // android.os.Parcelable$Creator
        public Object createFromParcel(Parcel parcel0) {
            return this.createFromParcel(parcel0);
        }

        @NotNull
        public SelectedTag[] newArray(int v) {
            return new SelectedTag[v];
        }

        @Override  // android.os.Parcelable$Creator
        public Object[] newArray(int v) {
            return this.newArray(v);
        }
    }

    public static final int $stable;
    @NotNull
    public static final CREATOR CREATOR;
    @Nullable
    private String emoji;
    @Nullable
    private String tagName;

    static {
        SelectedTag.CREATOR = new CREATOR(null);
        SelectedTag.$stable = 8;
    }

    public SelectedTag(@NotNull Parcel parcel0) {
        q.g(parcel0, "in");
        super();
        this.emoji = "";
        this.tagName = parcel0.readString();
        this.emoji = parcel0.readString();
    }

    public SelectedTag(@Nullable String s, @Nullable String s1) {
        this.tagName = "";
        this.emoji = "";
        if(s == null) {
            s = "";
        }
        this.tagName = s;
        if(s1 == null) {
            s1 = "";
        }
        this.emoji = s1;
    }

    public SelectedTag(String s, String s1, int v, DefaultConstructorMarker defaultConstructorMarker0) {
        if((v & 2) != 0) {
            s1 = "";
        }
        this(s, s1);
    }

    @Override  // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    @Nullable
    public final String getEmoji() {
        return this.emoji;
    }

    @Nullable
    public final String getTagName() {
        return this.tagName;
    }

    public final void setEmoji(@Nullable String s) {
        this.emoji = s;
    }

    public final void setTagName(@Nullable String s) {
        this.tagName = s;
    }

    @Override  // android.os.Parcelable
    public void writeToParcel(@NotNull Parcel parcel0, int v) {
        q.g(parcel0, "dest");
        parcel0.writeString(this.tagName);
        parcel0.writeString(this.emoji);
    }
}


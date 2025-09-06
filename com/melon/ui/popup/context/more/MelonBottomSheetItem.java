package com.melon.ui.popup.context.more;

import A7.d;
import android.os.Parcel;
import android.os.Parcelable.Creator;
import android.os.Parcelable;
import kotlin.Metadata;
import kotlin.jvm.internal.q;
import org.jetbrains.annotations.NotNull;
import v9.n;
import zd.M;

@Metadata(d1 = {"\u0000\n\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b\u0087\b\u0018\u00002\u00020\u0001¨\u0006\u0002"}, d2 = {"Lcom/melon/ui/popup/context/more/MelonBottomSheetItem;", "Landroid/os/Parcelable;", "app_playstoreProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 0x30)
public final class MelonBottomSheetItem implements Parcelable {
    @NotNull
    public static final Parcelable.Creator CREATOR;
    public final M a;
    public final int b;
    public final Integer c;
    public final String d;
    public final boolean e;
    public final ExtraProperties f;

    static {
        MelonBottomSheetItem.CREATOR = new n(2);
    }

    public MelonBottomSheetItem(M m0, int v, Integer integer0, String s, ExtraProperties extraProperties0, int v1) {
        this(m0, v, ((v1 & 4) == 0 ? integer0 : null), ((v1 & 8) == 0 ? s : null), true, ((v1 & 0x20) == 0 ? extraProperties0 : null));
    }

    public MelonBottomSheetItem(M m0, int v, Integer integer0, String s, boolean z, ExtraProperties extraProperties0) {
        q.g(m0, "id");
        super();
        this.a = m0;
        this.b = v;
        this.c = integer0;
        this.d = s;
        this.e = z;
        this.f = extraProperties0;
    }

    public static MelonBottomSheetItem a(MelonBottomSheetItem melonBottomSheetItem0, boolean z, ExtraProperties extraProperties0, int v) {
        M m0 = melonBottomSheetItem0.a;
        int v1 = (v & 2) == 0 ? 0x7F13027C : melonBottomSheetItem0.b;  // string:ctx_menu_playlist_info "플레이리스트 정보"
        Integer integer0 = melonBottomSheetItem0.c;
        String s = melonBottomSheetItem0.d;
        if((v & 16) != 0) {
            z = melonBottomSheetItem0.e;
        }
        if((v & 0x20) != 0) {
            extraProperties0 = melonBottomSheetItem0.f;
        }
        melonBottomSheetItem0.getClass();
        q.g(m0, "id");
        return new MelonBottomSheetItem(m0, v1, integer0, s, z, extraProperties0);
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
        if(!(object0 instanceof MelonBottomSheetItem)) {
            return false;
        }
        if(this.a != ((MelonBottomSheetItem)object0).a) {
            return false;
        }
        if(this.b != ((MelonBottomSheetItem)object0).b) {
            return false;
        }
        if(!q.b(this.c, ((MelonBottomSheetItem)object0).c)) {
            return false;
        }
        if(!q.b(this.d, ((MelonBottomSheetItem)object0).d)) {
            return false;
        }
        return this.e == ((MelonBottomSheetItem)object0).e ? q.b(this.f, ((MelonBottomSheetItem)object0).f) : false;
    }

    @Override
    public final int hashCode() {
        int v = 0;
        int v1 = d.e(((d.b(this.b, this.a.hashCode() * 0x1F, 0x1F) + (this.c == null ? 0 : this.c.hashCode())) * 0x1F + (this.d == null ? 0 : this.d.hashCode())) * 0x1F, 0x1F, this.e);
        ExtraProperties extraProperties0 = this.f;
        if(extraProperties0 != null) {
            v = extraProperties0.hashCode();
        }
        return v1 + v;
    }

    @Override
    public final String toString() {
        return "MelonBottomSheetItem(id=" + this.a + ", textResId=" + this.b + ", imgResId=" + this.c + ", text=" + this.d + ", isEnabled=" + this.e + ", extraProperties=" + this.f + ")";
    }

    @Override  // android.os.Parcelable
    public final void writeToParcel(Parcel parcel0, int v) {
        int v1;
        q.g(parcel0, "dest");
        parcel0.writeString(this.a.name());
        parcel0.writeInt(this.b);
        Integer integer0 = this.c;
        if(integer0 == null) {
            v1 = 0;
        }
        else {
            parcel0.writeInt(1);
            v1 = (int)integer0;
        }
        parcel0.writeInt(v1);
        parcel0.writeString(this.d);
        parcel0.writeInt(((int)this.e));
        parcel0.writeParcelable(this.f, v);
    }
}


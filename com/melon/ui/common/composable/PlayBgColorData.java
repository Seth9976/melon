package com.melon.ui.common.composable;

import Cc.v2;
import android.os.Parcel;
import android.os.Parcelable.Creator;
import android.os.Parcelable;
import java.util.ArrayList;
import java.util.Objects;
import kotlin.Metadata;
import kotlin.jvm.internal.q;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u0000\n\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b\u0007\u0018\u00002\u00020\u0001¨\u0006\u0002"}, d2 = {"Lcom/melon/ui/common/composable/PlayBgColorData;", "Landroid/os/Parcelable;", "app_playstoreProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 0x30)
public final class PlayBgColorData implements Parcelable {
    @NotNull
    public static final Parcelable.Creator CREATOR;
    public final int a;
    public final ArrayList b;

    static {
        PlayBgColorData.CREATOR = new v2();  // 初始化器: Ljava/lang/Object;-><init>()V
    }

    public PlayBgColorData(int v, ArrayList arrayList0) {
        this.a = v;
        this.b = arrayList0;
    }

    @Override  // android.os.Parcelable
    public final int describeContents() {
        return 0;
    }

    // 去混淆评级： 低(20)
    @Override
    public final boolean equals(Object object0) {
        return object0 instanceof PlayBgColorData && ((PlayBgColorData)object0).b.equals(this.b) && ((PlayBgColorData)object0).a == this.a;
    }

    @Override
    public final int hashCode() {
        return Objects.hash(new Object[]{this.b, this.a});
    }

    @Override  // android.os.Parcelable
    public final void writeToParcel(Parcel parcel0, int v) {
        q.g(parcel0, "dest");
        parcel0.writeInt(this.a);
        parcel0.writeInt(this.b.size());
        for(Object object0: this.b) {
            parcel0.writeInt(((Number)object0).intValue());
        }
    }
}


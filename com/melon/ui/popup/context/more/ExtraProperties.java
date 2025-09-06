package com.melon.ui.popup.context.more;

import U4.x;
import android.os.Parcel;
import android.os.Parcelable.Creator;
import android.os.Parcelable;
import androidx.appcompat.app.o;
import com.iloen.melon.constants.AddPosition;
import kotlin.Metadata;
import kotlin.jvm.internal.q;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b7\u0018\u00002\u00020\u0001:\u0006\u0002\u0003\u0004\u0005\u0006\u0007\u0082\u0001\u0006\b\t\n\u000B\f\r¨\u0006\u000E"}, d2 = {"Lcom/melon/ui/popup/context/more/ExtraProperties;", "Landroid/os/Parcelable;", "Link", "ArtistInfo", "AddPositionInfo", "ToggleInfo", "QualityInfo", "CheckedItemInfo", "Lcom/melon/ui/popup/context/more/ExtraProperties$AddPositionInfo;", "Lcom/melon/ui/popup/context/more/ExtraProperties$ArtistInfo;", "Lcom/melon/ui/popup/context/more/ExtraProperties$CheckedItemInfo;", "Lcom/melon/ui/popup/context/more/ExtraProperties$Link;", "Lcom/melon/ui/popup/context/more/ExtraProperties$QualityInfo;", "Lcom/melon/ui/popup/context/more/ExtraProperties$ToggleInfo;", "app_playstoreProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 0x30)
public abstract class ExtraProperties implements Parcelable {
    @Metadata(d1 = {"\u0000\n\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b\u0087\b\u0018\u00002\u00020\u0001¨\u0006\u0002"}, d2 = {"Lcom/melon/ui/popup/context/more/ExtraProperties$AddPositionInfo;", "Lcom/melon/ui/popup/context/more/ExtraProperties;", "app_playstoreProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 0x30)
    public static final class AddPositionInfo extends ExtraProperties {
        @NotNull
        public static final Parcelable.Creator CREATOR;
        public final AddPosition a;

        static {
            AddPositionInfo.CREATOR = new c();  // 初始化器: Ljava/lang/Object;-><init>()V
        }

        public AddPositionInfo(AddPosition addPosition0) {
            this.a = addPosition0;
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
            return object0 instanceof AddPositionInfo ? this.a == ((AddPositionInfo)object0).a : false;
        }

        @Override
        public final int hashCode() {
            return this.a == null ? 0 : this.a.hashCode();
        }

        @Override
        public final String toString() {
            return "AddPositionInfo(addPosition=" + this.a + ")";
        }

        @Override  // android.os.Parcelable
        public final void writeToParcel(Parcel parcel0, int v) {
            q.g(parcel0, "dest");
            AddPosition addPosition0 = this.a;
            if(addPosition0 == null) {
                parcel0.writeInt(0);
                return;
            }
            parcel0.writeInt(1);
            parcel0.writeString(addPosition0.name());
        }
    }

    @Metadata(d1 = {"\u0000\n\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b\u0087\b\u0018\u00002\u00020\u0001¨\u0006\u0002"}, d2 = {"Lcom/melon/ui/popup/context/more/ExtraProperties$ArtistInfo;", "Lcom/melon/ui/popup/context/more/ExtraProperties;", "app_playstoreProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 0x30)
    public static final class ArtistInfo extends ExtraProperties {
        @NotNull
        public static final Parcelable.Creator CREATOR;
        public final String a;
        public final String b;

        static {
            ArtistInfo.CREATOR = new d();  // 初始化器: Ljava/lang/Object;-><init>()V
        }

        public ArtistInfo(String s, String s1) {
            q.g(s, "artistId");
            q.g(s1, "artistName");
            super();
            this.a = s;
            this.b = s1;
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
            if(!(object0 instanceof ArtistInfo)) {
                return false;
            }
            return q.b(this.a, ((ArtistInfo)object0).a) ? q.b(this.b, ((ArtistInfo)object0).b) : false;
        }

        @Override
        public final int hashCode() {
            return this.b.hashCode() + this.a.hashCode() * 0x1F;
        }

        @Override
        public final String toString() {
            return "ArtistInfo(artistId=" + this.a + ", artistName=" + this.b + ")";
        }

        @Override  // android.os.Parcelable
        public final void writeToParcel(Parcel parcel0, int v) {
            q.g(parcel0, "dest");
            parcel0.writeString(this.a);
            parcel0.writeString(this.b);
        }
    }

    @Metadata(d1 = {"\u0000\n\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b\u0087\b\u0018\u00002\u00020\u0001¨\u0006\u0002"}, d2 = {"Lcom/melon/ui/popup/context/more/ExtraProperties$CheckedItemInfo;", "Lcom/melon/ui/popup/context/more/ExtraProperties;", "app_playstoreProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 0x30)
    public static final class CheckedItemInfo extends ExtraProperties {
        @NotNull
        public static final Parcelable.Creator CREATOR;
        public final int a;
        public final String b;
        public final boolean c;

        static {
            CheckedItemInfo.CREATOR = new e();  // 初始化器: Ljava/lang/Object;-><init>()V
        }

        public CheckedItemInfo(int v, String s, boolean z) {
            q.g(s, "title");
            super();
            this.a = v;
            this.b = s;
            this.c = z;
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
            if(!(object0 instanceof CheckedItemInfo)) {
                return false;
            }
            if(this.a != ((CheckedItemInfo)object0).a) {
                return false;
            }
            return q.b(this.b, ((CheckedItemInfo)object0).b) ? this.c == ((CheckedItemInfo)object0).c : false;
        }

        @Override
        public final int hashCode() {
            return Boolean.hashCode(this.c) + x.b(this.a * 0x1F, 0x1F, this.b);
        }

        @Override
        public final String toString() {
            return o.s(x.o(this.a, "CheckedItemInfo(index=", ", title=", this.b, ", isChecked="), this.c, ")");
        }

        @Override  // android.os.Parcelable
        public final void writeToParcel(Parcel parcel0, int v) {
            q.g(parcel0, "dest");
            parcel0.writeInt(this.a);
            parcel0.writeString(this.b);
            parcel0.writeInt(((int)this.c));
        }
    }

    @Metadata(d1 = {"\u0000\n\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b\u0087\b\u0018\u00002\u00020\u0001¨\u0006\u0002"}, d2 = {"Lcom/melon/ui/popup/context/more/ExtraProperties$Link;", "Lcom/melon/ui/popup/context/more/ExtraProperties;", "app_playstoreProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 0x30)
    public static final class Link extends ExtraProperties {
        @NotNull
        public static final Parcelable.Creator CREATOR;
        public final String a;
        public final String b;

        static {
            Link.CREATOR = new f();  // 初始化器: Ljava/lang/Object;-><init>()V
        }

        public Link(String s, String s1) {
            this.a = s;
            this.b = s1;
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
            if(!(object0 instanceof Link)) {
                return false;
            }
            return q.b(this.a, ((Link)object0).a) ? q.b(this.b, ((Link)object0).b) : false;
        }

        @Override
        public final int hashCode() {
            int v = 0;
            int v1 = this.a == null ? 0 : this.a.hashCode();
            String s = this.b;
            if(s != null) {
                v = s.hashCode();
            }
            return v1 * 0x1F + v;
        }

        @Override
        public final String toString() {
            return "Link(linkType=" + this.a + ", linkUrl=" + this.b + ")";
        }

        @Override  // android.os.Parcelable
        public final void writeToParcel(Parcel parcel0, int v) {
            q.g(parcel0, "dest");
            parcel0.writeString(this.a);
            parcel0.writeString(this.b);
        }
    }

    @Metadata(d1 = {"\u0000\n\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b\u0087\b\u0018\u00002\u00020\u0001¨\u0006\u0002"}, d2 = {"Lcom/melon/ui/popup/context/more/ExtraProperties$QualityInfo;", "Lcom/melon/ui/popup/context/more/ExtraProperties;", "app_playstoreProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 0x30)
    public static final class QualityInfo extends ExtraProperties {
        @NotNull
        public static final Parcelable.Creator CREATOR;
        public final String a;

        static {
            QualityInfo.CREATOR = new g();  // 初始化器: Ljava/lang/Object;-><init>()V
        }

        public QualityInfo(String s) {
            q.g(s, "quality");
            super();
            this.a = s;
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
            return object0 instanceof QualityInfo ? q.b(this.a, ((QualityInfo)object0).a) : false;
        }

        @Override
        public final int hashCode() {
            return this.a.hashCode();
        }

        @Override
        public final String toString() {
            return "QualityInfo(quality=" + this.a + ")";
        }

        @Override  // android.os.Parcelable
        public final void writeToParcel(Parcel parcel0, int v) {
            q.g(parcel0, "dest");
            parcel0.writeString(this.a);
        }
    }

    @Metadata(d1 = {"\u0000\n\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b\u0087\b\u0018\u00002\u00020\u0001¨\u0006\u0002"}, d2 = {"Lcom/melon/ui/popup/context/more/ExtraProperties$ToggleInfo;", "Lcom/melon/ui/popup/context/more/ExtraProperties;", "app_playstoreProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 0x30)
    public static final class ToggleInfo extends ExtraProperties {
        @NotNull
        public static final Parcelable.Creator CREATOR;
        public final boolean a;

        static {
            ToggleInfo.CREATOR = new h();  // 初始化器: Ljava/lang/Object;-><init>()V
        }

        public ToggleInfo(boolean z) {
            this.a = z;
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
            return object0 instanceof ToggleInfo ? this.a == ((ToggleInfo)object0).a : false;
        }

        @Override
        public final int hashCode() {
            return Boolean.hashCode(this.a);
        }

        @Override
        public final String toString() {
            return "ToggleInfo(toggleOn=" + this.a + ")";
        }

        @Override  // android.os.Parcelable
        public final void writeToParcel(Parcel parcel0, int v) {
            q.g(parcel0, "dest");
            parcel0.writeInt(((int)this.a));
        }
    }

}


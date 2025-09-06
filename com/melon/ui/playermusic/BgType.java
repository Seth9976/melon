package com.melon.ui.playermusic;

import A7.d;
import U4.x;
import android.os.Parcel;
import android.os.Parcelable.Creator;
import android.os.Parcelable;
import java.util.ArrayList;
import java.util.List;
import k8.Y;
import kotlin.Metadata;
import kotlin.jvm.internal.q;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u0000\u001A\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b7\u0018\u00002\u00020\u0001:\u0003\u0002\u0003\u0004\u0082\u0001\u0003\u0005\u0006\u0007¨\u0006\b"}, d2 = {"Lcom/melon/ui/playermusic/BgType;", "Landroid/os/Parcelable;", "SpecialVideo", "SpecialImage", "Album", "Lcom/melon/ui/playermusic/BgType$Album;", "Lcom/melon/ui/playermusic/BgType$SpecialImage;", "Lcom/melon/ui/playermusic/BgType$SpecialVideo;", "app_playstoreProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 0x30)
public abstract class BgType implements Parcelable {
    @Metadata(d1 = {"\u0000\n\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b\u0087\b\u0018\u00002\u00020\u0001¨\u0006\u0002"}, d2 = {"Lcom/melon/ui/playermusic/BgType$Album;", "Lcom/melon/ui/playermusic/BgType;", "app_playstoreProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 0x30)
    public static final class Album extends BgType {
        @NotNull
        public static final Parcelable.Creator CREATOR;
        public final String a;
        public final String b;
        public final List c;

        static {
            Album.CREATOR = new a();  // 初始化器: Ljava/lang/Object;-><init>()V
        }

        public Album(String s, String s1, List list0) {
            q.g(s, "songName");
            q.g(s1, "artistName");
            q.g(list0, "urls");
            super();
            this.a = s;
            this.b = s1;
            this.c = list0;
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
            if(!(object0 instanceof Album)) {
                return false;
            }
            if(!q.b(this.a, ((Album)object0).a)) {
                return false;
            }
            return q.b(this.b, ((Album)object0).b) ? q.b(this.c, ((Album)object0).c) : false;
        }

        @Override
        public final int hashCode() {
            return this.c.hashCode() + x.b(this.a.hashCode() * 0x1F, 0x1F, this.b);
        }

        @Override
        public final String toString() {
            return Y.m(d.o("Album(songName=", this.a, ", artistName=", this.b, ", urls="), this.c, ")");
        }

        @Override  // android.os.Parcelable
        public final void writeToParcel(Parcel parcel0, int v) {
            q.g(parcel0, "dest");
            parcel0.writeString(this.a);
            parcel0.writeString(this.b);
            parcel0.writeStringList(this.c);
        }
    }

    @Metadata(d1 = {"\u0000\n\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b\u0087\b\u0018\u00002\u00020\u0001¨\u0006\u0002"}, d2 = {"Lcom/melon/ui/playermusic/BgType$SpecialImage;", "Lcom/melon/ui/playermusic/BgType;", "app_playstoreProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 0x30)
    public static final class SpecialImage extends BgType {
        @NotNull
        public static final Parcelable.Creator CREATOR;
        public final String a;
        public final String b;
        public final List c;

        static {
            SpecialImage.CREATOR = new b();  // 初始化器: Ljava/lang/Object;-><init>()V
        }

        public SpecialImage(ArrayList arrayList0, String s, String s1) {
            q.g(s, "songName");
            q.g(s1, "artistName");
            q.g(arrayList0, "urls");
            super();
            this.a = s;
            this.b = s1;
            this.c = arrayList0;
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
            if(!(object0 instanceof SpecialImage)) {
                return false;
            }
            if(!q.b(this.a, ((SpecialImage)object0).a)) {
                return false;
            }
            return q.b(this.b, ((SpecialImage)object0).b) ? q.b(this.c, ((SpecialImage)object0).c) : false;
        }

        @Override
        public final int hashCode() {
            return this.c.hashCode() + x.b(this.a.hashCode() * 0x1F, 0x1F, this.b);
        }

        @Override
        public final String toString() {
            return Y.m(d.o("SpecialImage(songName=", this.a, ", artistName=", this.b, ", urls="), this.c, ")");
        }

        @Override  // android.os.Parcelable
        public final void writeToParcel(Parcel parcel0, int v) {
            q.g(parcel0, "dest");
            parcel0.writeString(this.a);
            parcel0.writeString(this.b);
            parcel0.writeStringList(this.c);
        }
    }

    @Metadata(d1 = {"\u0000\n\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b\u0087\b\u0018\u00002\u00020\u0001¨\u0006\u0002"}, d2 = {"Lcom/melon/ui/playermusic/BgType$SpecialVideo;", "Lcom/melon/ui/playermusic/BgType;", "app_playstoreProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 0x30)
    public static final class SpecialVideo extends BgType {
        @NotNull
        public static final Parcelable.Creator CREATOR;
        public final String a;
        public final String b;
        public final String c;
        public final String d;

        static {
            SpecialVideo.CREATOR = new c();  // 初始化器: Ljava/lang/Object;-><init>()V
        }

        public SpecialVideo(String s, String s1, String s2, String s3) {
            q.g(s, "songName");
            q.g(s1, "artistName");
            q.g(s2, "videoUrl");
            super();
            this.a = s;
            this.b = s1;
            this.c = s2;
            this.d = s3;
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
            if(!(object0 instanceof SpecialVideo)) {
                return false;
            }
            if(!q.b(this.a, ((SpecialVideo)object0).a)) {
                return false;
            }
            if(!q.b(this.b, ((SpecialVideo)object0).b)) {
                return false;
            }
            return q.b(this.c, ((SpecialVideo)object0).c) ? q.b(this.d, ((SpecialVideo)object0).d) : false;
        }

        @Override
        public final int hashCode() {
            int v = x.b(x.b(this.a.hashCode() * 0x1F, 0x1F, this.b), 0x1F, this.c);
            return this.d == null ? v : v + this.d.hashCode();
        }

        @Override
        public final String toString() {
            return d.n(d.o("SpecialVideo(songName=", this.a, ", artistName=", this.b, ", videoUrl="), this.c, ", stillImgUrl=", this.d, ")");
        }

        @Override  // android.os.Parcelable
        public final void writeToParcel(Parcel parcel0, int v) {
            q.g(parcel0, "dest");
            parcel0.writeString(this.a);
            parcel0.writeString(this.b);
            parcel0.writeString(this.c);
            parcel0.writeString(this.d);
        }
    }

}


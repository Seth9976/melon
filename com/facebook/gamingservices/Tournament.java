package com.facebook.gamingservices;

import S7.b;
import android.os.Parcel;
import android.os.Parcelable.Creator;
import androidx.appcompat.app.o;
import com.facebook.gamingservices.internal.DateFormatter;
import com.facebook.share.model.ShareModel;
import com.facebook.share.model.ShareModelBuilder;
import java.time.ZonedDateTime;
import java.time.format.DateTimeFormatter;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.q;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000E\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\t\u0018\u0000 \u001C2\u00020\u0001:\u0002\u001D\u001CB/\b\u0016\u0012\u0006\u0010\u0003\u001A\u00020\u0002\u0012\b\u0010\u0004\u001A\u0004\u0018\u00010\u0002\u0012\b\u0010\u0005\u001A\u0004\u0018\u00010\u0002\u0012\b\u0010\u0006\u001A\u0004\u0018\u00010\u0002¢\u0006\u0004\b\u0007\u0010\bB\u0011\b\u0016\u0012\u0006\u0010\n\u001A\u00020\t¢\u0006\u0004\b\u0007\u0010\u000BJ\u000F\u0010\r\u001A\u00020\fH\u0016¢\u0006\u0004\b\r\u0010\u000EJ\u001F\u0010\u0012\u001A\u00020\u00112\u0006\u0010\u000F\u001A\u00020\t2\u0006\u0010\u0010\u001A\u00020\fH\u0016¢\u0006\u0004\b\u0012\u0010\u0013R\u0014\u0010\u0003\u001A\u00020\u00028\u0006X\u0087\u0004¢\u0006\u0006\n\u0004\b\u0003\u0010\u0014R\u0016\u0010\u0005\u001A\u0004\u0018\u00010\u00028\u0006X\u0087\u0004¢\u0006\u0006\n\u0004\b\u0005\u0010\u0014R\u0016\u0010\u0006\u001A\u0004\u0018\u00010\u00028\u0006X\u0087\u0004¢\u0006\u0006\n\u0004\b\u0006\u0010\u0014R\u0018\u0010\u0004\u001A\u0004\u0018\u00010\u00028\u0000@\u0000X\u0081\u000E¢\u0006\u0006\n\u0004\b\u0004\u0010\u0014R(\u0010\u001B\u001A\u0004\u0018\u00010\u00152\b\u0010\u0016\u001A\u0004\u0018\u00010\u00158F@BX\u0086\u000E¢\u0006\f\u001A\u0004\b\u0017\u0010\u0018\"\u0004\b\u0019\u0010\u001A¨\u0006\u001E"}, d2 = {"Lcom/facebook/gamingservices/Tournament;", "Lcom/facebook/share/model/ShareModel;", "", "identifier", "endTime", "title", "payload", "<init>", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V", "Landroid/os/Parcel;", "parcel", "(Landroid/os/Parcel;)V", "", "describeContents", "()I", "out", "flags", "Lie/H;", "writeToParcel", "(Landroid/os/Parcel;I)V", "Ljava/lang/String;", "Ljava/time/ZonedDateTime;", "newValue", "getExpiration", "()Ljava/time/ZonedDateTime;", "setExpiration", "(Ljava/time/ZonedDateTime;)V", "expiration", "CREATOR", "Builder", "facebook-gamingservices_release"}, k = 1, mv = {1, 8, 0}, xi = 0x30)
public final class Tournament implements ShareModel {
    @Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000E\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0019\n\u0002\u0010\u000B\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0004\b\u0080\b\u0018\u00002\u000E\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00000\u0001B1\u0012\u0006\u0010\u0003\u001A\u00020\u0004\u0012\n\b\u0002\u0010\u0005\u001A\u0004\u0018\u00010\u0006\u0012\n\b\u0002\u0010\u0007\u001A\u0004\u0018\u00010\u0004\u0012\n\b\u0002\u0010\b\u001A\u0004\u0018\u00010\u0004\u00A2\u0006\u0002\u0010\tJ\b\u0010\u0019\u001A\u00020\u0002H\u0016J\t\u0010\u001A\u001A\u00020\u0004H\u00C6\u0003J\u000B\u0010\u001B\u001A\u0004\u0018\u00010\u0006H\u00C6\u0003J\u000B\u0010\u001C\u001A\u0004\u0018\u00010\u0004H\u00C6\u0003J\u000B\u0010\u001D\u001A\u0004\u0018\u00010\u0004H\u00C6\u0003J7\u0010\u001E\u001A\u00020\u00002\b\b\u0002\u0010\u0003\u001A\u00020\u00042\n\b\u0002\u0010\u0005\u001A\u0004\u0018\u00010\u00062\n\b\u0002\u0010\u0007\u001A\u0004\u0018\u00010\u00042\n\b\u0002\u0010\b\u001A\u0004\u0018\u00010\u0004H\u00C6\u0001J\u0013\u0010\u001F\u001A\u00020 2\b\u0010!\u001A\u0004\u0018\u00010\"H\u00D6\u0003J\u0010\u0010\u0005\u001A\u00020\u00002\b\u0010\u0005\u001A\u0004\u0018\u00010\u0006J\t\u0010#\u001A\u00020$H\u00D6\u0001J\u000E\u0010\u0003\u001A\u00020\u00002\u0006\u0010\u0003\u001A\u00020\u0004J\u0010\u0010\b\u001A\u00020\u00002\b\u0010\b\u001A\u0004\u0018\u00010\u0004J\u0012\u0010%\u001A\u00020\u00002\b\u0010&\u001A\u0004\u0018\u00010\u0002H\u0016J\u0010\u0010\u0007\u001A\u00020\u00002\b\u0010\u0007\u001A\u0004\u0018\u00010\u0004J\t\u0010\'\u001A\u00020\u0004H\u00D6\u0001R\u001C\u0010\n\u001A\u0004\u0018\u00010\u0004X\u0086\u000E\u00A2\u0006\u000E\n\u0000\u001A\u0004\b\u000B\u0010\f\"\u0004\b\r\u0010\u000ER\u001C\u0010\u0005\u001A\u0004\u0018\u00010\u0006X\u0086\u000E\u00A2\u0006\u000E\n\u0000\u001A\u0004\b\u000F\u0010\u0010\"\u0004\b\u0011\u0010\u0012R\u001A\u0010\u0003\u001A\u00020\u0004X\u0086\u000E\u00A2\u0006\u000E\n\u0000\u001A\u0004\b\u0013\u0010\f\"\u0004\b\u0014\u0010\u000ER\u001C\u0010\b\u001A\u0004\u0018\u00010\u0004X\u0086\u000E\u00A2\u0006\u000E\n\u0000\u001A\u0004\b\u0015\u0010\f\"\u0004\b\u0016\u0010\u000ER\u001C\u0010\u0007\u001A\u0004\u0018\u00010\u0004X\u0086\u000E\u00A2\u0006\u000E\n\u0000\u001A\u0004\b\u0017\u0010\f\"\u0004\b\u0018\u0010\u000E\u00A8\u0006("}, d2 = {"Lcom/facebook/gamingservices/Tournament$Builder;", "Lcom/facebook/share/model/ShareModelBuilder;", "Lcom/facebook/gamingservices/Tournament;", "identifier", "", "expiration", "Ljava/time/ZonedDateTime;", "title", "payload", "(Ljava/lang/String;Ljava/time/ZonedDateTime;Ljava/lang/String;Ljava/lang/String;)V", "endTime", "getEndTime", "()Ljava/lang/String;", "setEndTime", "(Ljava/lang/String;)V", "getExpiration", "()Ljava/time/ZonedDateTime;", "setExpiration", "(Ljava/time/ZonedDateTime;)V", "getIdentifier", "setIdentifier", "getPayload", "setPayload", "getTitle", "setTitle", "build", "component1", "component2", "component3", "component4", "copy", "equals", "", "other", "", "hashCode", "", "readFrom", "tournament", "toString", "facebook-gamingservices_release"}, k = 1, mv = {1, 8, 0}, xi = 0x30)
    public static final class Builder implements ShareModelBuilder {
        @Nullable
        private String endTime;
        @Nullable
        private ZonedDateTime expiration;
        @NotNull
        private String identifier;
        @Nullable
        private String payload;
        @Nullable
        private String title;

        public Builder(@NotNull String s, @Nullable ZonedDateTime zonedDateTime0, @Nullable String s1, @Nullable String s2) {
            q.g(s, "identifier");
            super();
            this.identifier = s;
            this.expiration = zonedDateTime0;
            this.title = s1;
            this.payload = s2;
        }

        public Builder(String s, ZonedDateTime zonedDateTime0, String s1, String s2, int v, DefaultConstructorMarker defaultConstructorMarker0) {
            if((v & 2) != 0) {
                zonedDateTime0 = null;
            }
            if((v & 4) != 0) {
                s1 = null;
            }
            if((v & 8) != 0) {
                s2 = null;
            }
            this(s, zonedDateTime0, s1, s2);
        }

        @NotNull
        public Tournament build() {
            return new Tournament(this.identifier, this.endTime, this.title, this.payload);
        }

        @Override  // com.facebook.share.ShareBuilder
        public Object build() {
            return this.build();
        }

        @NotNull
        public final String component1() {
            return this.identifier;
        }

        @Nullable
        public final ZonedDateTime component2() {
            return this.expiration;
        }

        @Nullable
        public final String component3() {
            return this.title;
        }

        @Nullable
        public final String component4() {
            return this.payload;
        }

        @NotNull
        public final Builder copy(@NotNull String s, @Nullable ZonedDateTime zonedDateTime0, @Nullable String s1, @Nullable String s2) {
            q.g(s, "identifier");
            return new Builder(s, zonedDateTime0, s1, s2);
        }

        public static Builder copy$default(Builder tournament$Builder0, String s, ZonedDateTime zonedDateTime0, String s1, String s2, int v, Object object0) {
            if((v & 1) != 0) {
                s = tournament$Builder0.identifier;
            }
            if((v & 2) != 0) {
                zonedDateTime0 = tournament$Builder0.expiration;
            }
            if((v & 4) != 0) {
                s1 = tournament$Builder0.title;
            }
            if((v & 8) != 0) {
                s2 = tournament$Builder0.payload;
            }
            return tournament$Builder0.copy(s, zonedDateTime0, s1, s2);
        }

        @Override
        public boolean equals(@Nullable Object object0) {
            if(this == object0) {
                return true;
            }
            if(!(object0 instanceof Builder)) {
                return false;
            }
            if(!q.b(this.identifier, ((Builder)object0).identifier)) {
                return false;
            }
            if(!q.b(this.expiration, ((Builder)object0).expiration)) {
                return false;
            }
            return q.b(this.title, ((Builder)object0).title) ? q.b(this.payload, ((Builder)object0).payload) : false;
        }

        @NotNull
        public final Builder expiration(@Nullable ZonedDateTime zonedDateTime0) {
            this.expiration = zonedDateTime0;
            if(zonedDateTime0 != null) {
                this.endTime = zonedDateTime0.format(DateTimeFormatter.ISO_DATE_TIME);
            }
            return this;
        }

        @Nullable
        public final String getEndTime() {
            return this.endTime;
        }

        @Nullable
        public final ZonedDateTime getExpiration() {
            return this.expiration;
        }

        @NotNull
        public final String getIdentifier() {
            return this.identifier;
        }

        @Nullable
        public final String getPayload() {
            return this.payload;
        }

        @Nullable
        public final String getTitle() {
            return this.title;
        }

        @Override
        public int hashCode() {
            int v = this.identifier.hashCode();
            int v1 = 0;
            int v2 = this.expiration == null ? 0 : this.expiration.hashCode();
            int v3 = this.title == null ? 0 : this.title.hashCode();
            String s = this.payload;
            if(s != null) {
                v1 = s.hashCode();
            }
            return ((v * 0x1F + v2) * 0x1F + v3) * 0x1F + v1;
        }

        @NotNull
        public final Builder identifier(@NotNull String s) {
            q.g(s, "identifier");
            this.identifier = s;
            return this;
        }

        @NotNull
        public final Builder payload(@Nullable String s) {
            this.payload = s;
            return this;
        }

        @NotNull
        public Builder readFrom(@Nullable Tournament tournament0) {
            if(tournament0 != null) {
                Builder tournament$Builder0 = this.identifier(tournament0.identifier).expiration(tournament0.getExpiration()).title(tournament0.title).payload(tournament0.payload);
                return tournament$Builder0 == null ? this : tournament$Builder0;
            }
            return this;
        }

        @Override  // com.facebook.share.model.ShareModelBuilder
        public ShareModelBuilder readFrom(ShareModel shareModel0) {
            return this.readFrom(((Tournament)shareModel0));
        }

        public final void setEndTime(@Nullable String s) {
            this.endTime = s;
        }

        public final void setExpiration(@Nullable ZonedDateTime zonedDateTime0) {
            this.expiration = zonedDateTime0;
        }

        public final void setIdentifier(@NotNull String s) {
            q.g(s, "<set-?>");
            this.identifier = s;
        }

        public final void setPayload(@Nullable String s) {
            this.payload = s;
        }

        public final void setTitle(@Nullable String s) {
            this.title = s;
        }

        @NotNull
        public final Builder title(@Nullable String s) {
            this.title = s;
            return this;
        }

        @Override
        @NotNull
        public String toString() {
            StringBuilder stringBuilder0 = new StringBuilder("Builder(identifier=");
            stringBuilder0.append(this.identifier);
            stringBuilder0.append(", expiration=");
            stringBuilder0.append(this.expiration);
            stringBuilder0.append(", title=");
            stringBuilder0.append(this.title);
            stringBuilder0.append(", payload=");
            return o.r(stringBuilder0, this.payload, ')');
        }
    }

    @Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0011\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\b\u0086\u0003\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0003J\u0010\u0010\u0004\u001A\u00020\u00022\u0006\u0010\u0005\u001A\u00020\u0006H\u0016J\u001D\u0010\u0007\u001A\n\u0012\u0006\u0012\u0004\u0018\u00010\u00020\b2\u0006\u0010\t\u001A\u00020\nH\u0016¢\u0006\u0002\u0010\u000B¨\u0006\f"}, d2 = {"Lcom/facebook/gamingservices/Tournament$CREATOR;", "Landroid/os/Parcelable$Creator;", "Lcom/facebook/gamingservices/Tournament;", "()V", "createFromParcel", "parcel", "Landroid/os/Parcel;", "newArray", "", "size", "", "(I)[Lcom/facebook/gamingservices/Tournament;", "facebook-gamingservices_release"}, k = 1, mv = {1, 8, 0}, xi = 0x30)
    public static final class CREATOR implements Parcelable.Creator {
        private CREATOR() {
        }

        public CREATOR(DefaultConstructorMarker defaultConstructorMarker0) {
        }

        @NotNull
        public Tournament createFromParcel(@NotNull Parcel parcel0) {
            q.g(parcel0, "parcel");
            return new Tournament(parcel0);
        }

        @Override  // android.os.Parcelable$Creator
        public Object createFromParcel(Parcel parcel0) {
            return this.createFromParcel(parcel0);
        }

        @NotNull
        public Tournament[] newArray(int v) {
            return new Tournament[v];
        }

        @Override  // android.os.Parcelable$Creator
        public Object[] newArray(int v) {
            return this.newArray(v);
        }
    }

    @NotNull
    public static final CREATOR CREATOR;
    @b("tournament_end_time")
    @Nullable
    public String endTime;
    @b("id")
    @NotNull
    public final String identifier;
    @b("tournament_payload")
    @Nullable
    public final String payload;
    @b("tournament_title")
    @Nullable
    public final String title;

    static {
        Tournament.CREATOR = new CREATOR(null);
    }

    public Tournament(@NotNull Parcel parcel0) {
        q.g(parcel0, "parcel");
        this(parcel0.toString(), parcel0.toString(), parcel0.toString(), parcel0.toString());
    }

    public Tournament(@NotNull String s, @Nullable String s1, @Nullable String s2, @Nullable String s3) {
        q.g(s, "identifier");
        super();
        this.identifier = s;
        this.endTime = s1;
        this.title = s2;
        this.payload = s3;
        this.setExpiration((s1 == null ? null : DateFormatter.INSTANCE.format$facebook_gamingservices_release(s1)));
    }

    @Override  // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    @Nullable
    public final ZonedDateTime getExpiration() {
        return this.endTime == null ? null : DateFormatter.INSTANCE.format$facebook_gamingservices_release(this.endTime);
    }

    private final void setExpiration(ZonedDateTime zonedDateTime0) {
        if(zonedDateTime0 != null) {
            this.endTime = zonedDateTime0.format(DateTimeFormatter.ISO_DATE_TIME);
            this.setExpiration(zonedDateTime0);
        }
    }

    @Override  // android.os.Parcelable
    public void writeToParcel(@NotNull Parcel parcel0, int v) {
        q.g(parcel0, "out");
        parcel0.writeString(this.identifier);
        parcel0.writeString(this.endTime);
        parcel0.writeString(this.title);
        parcel0.writeString(this.payload);
    }
}


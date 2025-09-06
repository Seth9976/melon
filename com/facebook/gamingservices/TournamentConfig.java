package com.facebook.gamingservices;

import android.media.Image;
import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.facebook.gamingservices.internal.DateFormatter;
import com.facebook.gamingservices.internal.TournamentScoreType;
import com.facebook.gamingservices.internal.TournamentSortOrder;
import com.facebook.share.model.ShareModel;
import com.facebook.share.model.ShareModelBuilder;
import java.time.Instant;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.q;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000P\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000E\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\t\u0018\u0000 ,2\u00020\u0001:\u0002-,B\u0011\b\u0012\u0012\u0006\u0010\u0003\u001A\u00020\u0002¢\u0006\u0004\b\u0004\u0010\u0005B\u0011\b\u0010\u0012\u0006\u0010\u0007\u001A\u00020\u0006¢\u0006\u0004\b\u0004\u0010\bJ\u000F\u0010\n\u001A\u00020\tH\u0016¢\u0006\u0004\b\n\u0010\u000BJ\u001F\u0010\u000F\u001A\u00020\u000E2\u0006\u0010\f\u001A\u00020\u00062\u0006\u0010\r\u001A\u00020\tH\u0016¢\u0006\u0004\b\u000F\u0010\u0010R\u0019\u0010\u0012\u001A\u0004\u0018\u00010\u00118\u0006¢\u0006\f\n\u0004\b\u0012\u0010\u0013\u001A\u0004\b\u0014\u0010\u0015R\u0019\u0010\u0017\u001A\u0004\u0018\u00010\u00168\u0006¢\u0006\f\n\u0004\b\u0017\u0010\u0018\u001A\u0004\b\u0019\u0010\u001AR\u0019\u0010\u001C\u001A\u0004\u0018\u00010\u001B8\u0006¢\u0006\f\n\u0004\b\u001C\u0010\u001D\u001A\u0004\b\u001E\u0010\u001FR\u0019\u0010!\u001A\u0004\u0018\u00010 8\u0006¢\u0006\f\n\u0004\b!\u0010\"\u001A\u0004\b#\u0010$R\u0019\u0010&\u001A\u0004\u0018\u00010%8\u0006¢\u0006\f\n\u0004\b&\u0010\'\u001A\u0004\b(\u0010)R\u0019\u0010*\u001A\u0004\u0018\u00010\u00118\u0006¢\u0006\f\n\u0004\b*\u0010\u0013\u001A\u0004\b+\u0010\u0015¨\u0006."}, d2 = {"Lcom/facebook/gamingservices/TournamentConfig;", "Lcom/facebook/share/model/ShareModel;", "Lcom/facebook/gamingservices/TournamentConfig$Builder;", "builder", "<init>", "(Lcom/facebook/gamingservices/TournamentConfig$Builder;)V", "Landroid/os/Parcel;", "parcel", "(Landroid/os/Parcel;)V", "", "describeContents", "()I", "out", "flags", "Lie/H;", "writeToParcel", "(Landroid/os/Parcel;I)V", "", "title", "Ljava/lang/String;", "getTitle", "()Ljava/lang/String;", "Lcom/facebook/gamingservices/internal/TournamentSortOrder;", "sortOrder", "Lcom/facebook/gamingservices/internal/TournamentSortOrder;", "getSortOrder", "()Lcom/facebook/gamingservices/internal/TournamentSortOrder;", "Lcom/facebook/gamingservices/internal/TournamentScoreType;", "scoreType", "Lcom/facebook/gamingservices/internal/TournamentScoreType;", "getScoreType", "()Lcom/facebook/gamingservices/internal/TournamentScoreType;", "Ljava/time/Instant;", "endTime", "Ljava/time/Instant;", "getEndTime", "()Ljava/time/Instant;", "Landroid/media/Image;", "image", "Landroid/media/Image;", "getImage", "()Landroid/media/Image;", "payload", "getPayload", "CREATOR", "Builder", "facebook-gamingservices_release"}, k = 1, mv = {1, 8, 0}, xi = 0x30)
public final class TournamentConfig implements ShareModel {
    @Metadata(d1 = {"\u0000@\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000E\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\b\t\u0018\u00002\u000E\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00000\u0001B\u0005¢\u0006\u0002\u0010\u0003J\b\u0010%\u001A\u00020\u0002H\u0016J\u0015\u0010&\u001A\u00020\u00002\u0006\u0010\'\u001A\u00020(H\u0000¢\u0006\u0002\b)J\u0012\u0010&\u001A\u00020\u00002\b\u0010*\u001A\u0004\u0018\u00010\u0002H\u0016J\u000E\u0010+\u001A\u00020\u00002\u0006\u0010\u0004\u001A\u00020\u0005J\u0010\u0010,\u001A\u00020\u00002\b\u0010\n\u001A\u0004\u0018\u00010\u000BJ\u0010\u0010-\u001A\u00020\u00002\b\u0010\u0010\u001A\u0004\u0018\u00010\u0011J\u000E\u0010.\u001A\u00020\u00002\u0006\u0010\u0016\u001A\u00020\u0017J\u000E\u0010/\u001A\u00020\u00002\u0006\u0010\u001C\u001A\u00020\u001DJ\u0010\u00100\u001A\u00020\u00002\b\u0010\"\u001A\u0004\u0018\u00010\u0011R\u001C\u0010\u0004\u001A\u0004\u0018\u00010\u0005X\u0086\u000E¢\u0006\u000E\n\u0000\u001A\u0004\b\u0006\u0010\u0007\"\u0004\b\b\u0010\tR\u001C\u0010\n\u001A\u0004\u0018\u00010\u000BX\u0086\u000E¢\u0006\u000E\n\u0000\u001A\u0004\b\f\u0010\r\"\u0004\b\u000E\u0010\u000FR\u001C\u0010\u0010\u001A\u0004\u0018\u00010\u0011X\u0086\u000E¢\u0006\u000E\n\u0000\u001A\u0004\b\u0012\u0010\u0013\"\u0004\b\u0014\u0010\u0015R\u001C\u0010\u0016\u001A\u0004\u0018\u00010\u0017X\u0086\u000E¢\u0006\u000E\n\u0000\u001A\u0004\b\u0018\u0010\u0019\"\u0004\b\u001A\u0010\u001BR\u001C\u0010\u001C\u001A\u0004\u0018\u00010\u001DX\u0086\u000E¢\u0006\u000E\n\u0000\u001A\u0004\b\u001E\u0010\u001F\"\u0004\b \u0010!R\u001C\u0010\"\u001A\u0004\u0018\u00010\u0011X\u0086\u000E¢\u0006\u000E\n\u0000\u001A\u0004\b#\u0010\u0013\"\u0004\b$\u0010\u0015¨\u00061"}, d2 = {"Lcom/facebook/gamingservices/TournamentConfig$Builder;", "Lcom/facebook/share/model/ShareModelBuilder;", "Lcom/facebook/gamingservices/TournamentConfig;", "()V", "endTime", "Ljava/time/Instant;", "getEndTime", "()Ljava/time/Instant;", "setEndTime", "(Ljava/time/Instant;)V", "image", "Landroid/media/Image;", "getImage", "()Landroid/media/Image;", "setImage", "(Landroid/media/Image;)V", "payload", "", "getPayload", "()Ljava/lang/String;", "setPayload", "(Ljava/lang/String;)V", "scoreType", "Lcom/facebook/gamingservices/internal/TournamentScoreType;", "getScoreType", "()Lcom/facebook/gamingservices/internal/TournamentScoreType;", "setScoreType", "(Lcom/facebook/gamingservices/internal/TournamentScoreType;)V", "sortOrder", "Lcom/facebook/gamingservices/internal/TournamentSortOrder;", "getSortOrder", "()Lcom/facebook/gamingservices/internal/TournamentSortOrder;", "setSortOrder", "(Lcom/facebook/gamingservices/internal/TournamentSortOrder;)V", "title", "getTitle", "setTitle", "build", "readFrom", "parcel", "Landroid/os/Parcel;", "readFrom$facebook_gamingservices_release", "model", "setTournamentEndTime", "setTournamentImage", "setTournamentPayload", "setTournamentScoreType", "setTournamentSortOrder", "setTournamentTitle", "facebook-gamingservices_release"}, k = 1, mv = {1, 8, 0}, xi = 0x30)
    public static final class Builder implements ShareModelBuilder {
        @Nullable
        private Instant endTime;
        @Nullable
        private Image image;
        @Nullable
        private String payload;
        @Nullable
        private TournamentScoreType scoreType;
        @Nullable
        private TournamentSortOrder sortOrder;
        @Nullable
        private String title;

        @NotNull
        public TournamentConfig build() {
            return new TournamentConfig(this, null);
        }

        @Override  // com.facebook.share.ShareBuilder
        public Object build() {
            return this.build();
        }

        @Nullable
        public final Instant getEndTime() {
            return this.endTime;
        }

        @Nullable
        public final Image getImage() {
            return this.image;
        }

        @Nullable
        public final String getPayload() {
            return this.payload;
        }

        @Nullable
        public final TournamentScoreType getScoreType() {
            return this.scoreType;
        }

        @Nullable
        public final TournamentSortOrder getSortOrder() {
            return this.sortOrder;
        }

        @Nullable
        public final String getTitle() {
            return this.title;
        }

        @NotNull
        public Builder readFrom(@Nullable TournamentConfig tournamentConfig0) {
            if(tournamentConfig0 == null) {
                return this;
            }
            TournamentSortOrder tournamentSortOrder0 = tournamentConfig0.getSortOrder();
            if(tournamentSortOrder0 != null) {
                this.setTournamentSortOrder(tournamentSortOrder0);
            }
            TournamentScoreType tournamentScoreType0 = tournamentConfig0.getScoreType();
            if(tournamentScoreType0 != null) {
                this.setTournamentScoreType(tournamentScoreType0);
            }
            Instant instant0 = tournamentConfig0.getEndTime();
            if(instant0 != null) {
                this.setTournamentEndTime(instant0);
            }
            String s = tournamentConfig0.getTitle();
            if(s != null) {
                this.setTournamentTitle(s);
            }
            this.setTournamentPayload(tournamentConfig0.getPayload());
            return this;
        }

        @Override  // com.facebook.share.model.ShareModelBuilder
        public ShareModelBuilder readFrom(ShareModel shareModel0) {
            return this.readFrom(((TournamentConfig)shareModel0));
        }

        @NotNull
        public final Builder readFrom$facebook_gamingservices_release(@NotNull Parcel parcel0) {
            q.g(parcel0, "parcel");
            return this.readFrom(((TournamentConfig)parcel0.readParcelable(TournamentConfig.class.getClassLoader())));
        }

        public final void setEndTime(@Nullable Instant instant0) {
            this.endTime = instant0;
        }

        public final void setImage(@Nullable Image image0) {
            this.image = image0;
        }

        public final void setPayload(@Nullable String s) {
            this.payload = s;
        }

        public final void setScoreType(@Nullable TournamentScoreType tournamentScoreType0) {
            this.scoreType = tournamentScoreType0;
        }

        public final void setSortOrder(@Nullable TournamentSortOrder tournamentSortOrder0) {
            this.sortOrder = tournamentSortOrder0;
        }

        public final void setTitle(@Nullable String s) {
            this.title = s;
        }

        @NotNull
        public final Builder setTournamentEndTime(@NotNull Instant instant0) {
            q.g(instant0, "endTime");
            this.endTime = instant0;
            return this;
        }

        @NotNull
        public final Builder setTournamentImage(@Nullable Image image0) {
            this.image = image0;
            return this;
        }

        @NotNull
        public final Builder setTournamentPayload(@Nullable String s) {
            this.payload = s;
            return this;
        }

        @NotNull
        public final Builder setTournamentScoreType(@NotNull TournamentScoreType tournamentScoreType0) {
            q.g(tournamentScoreType0, "scoreType");
            this.scoreType = tournamentScoreType0;
            return this;
        }

        @NotNull
        public final Builder setTournamentSortOrder(@NotNull TournamentSortOrder tournamentSortOrder0) {
            q.g(tournamentSortOrder0, "sortOrder");
            this.sortOrder = tournamentSortOrder0;
            return this;
        }

        @NotNull
        public final Builder setTournamentTitle(@Nullable String s) {
            this.title = s;
            return this;
        }
    }

    @Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0011\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\b\u0086\u0003\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0003J\u0010\u0010\u0004\u001A\u00020\u00022\u0006\u0010\u0005\u001A\u00020\u0006H\u0016J\u001D\u0010\u0007\u001A\n\u0012\u0006\u0012\u0004\u0018\u00010\u00020\b2\u0006\u0010\t\u001A\u00020\nH\u0016¢\u0006\u0002\u0010\u000B¨\u0006\f"}, d2 = {"Lcom/facebook/gamingservices/TournamentConfig$CREATOR;", "Landroid/os/Parcelable$Creator;", "Lcom/facebook/gamingservices/TournamentConfig;", "()V", "createFromParcel", "parcel", "Landroid/os/Parcel;", "newArray", "", "size", "", "(I)[Lcom/facebook/gamingservices/TournamentConfig;", "facebook-gamingservices_release"}, k = 1, mv = {1, 8, 0}, xi = 0x30)
    public static final class CREATOR implements Parcelable.Creator {
        private CREATOR() {
        }

        public CREATOR(DefaultConstructorMarker defaultConstructorMarker0) {
        }

        @NotNull
        public TournamentConfig createFromParcel(@NotNull Parcel parcel0) {
            q.g(parcel0, "parcel");
            return new TournamentConfig(parcel0);
        }

        @Override  // android.os.Parcelable$Creator
        public Object createFromParcel(Parcel parcel0) {
            return this.createFromParcel(parcel0);
        }

        @NotNull
        public TournamentConfig[] newArray(int v) {
            return new TournamentConfig[v];
        }

        @Override  // android.os.Parcelable$Creator
        public Object[] newArray(int v) {
            return this.newArray(v);
        }
    }

    @NotNull
    public static final CREATOR CREATOR;
    @Nullable
    private final Instant endTime;
    @Nullable
    private final Image image;
    @Nullable
    private final String payload;
    @Nullable
    private final TournamentScoreType scoreType;
    @Nullable
    private final TournamentSortOrder sortOrder;
    @Nullable
    private final String title;

    static {
        TournamentConfig.CREATOR = new CREATOR(null);
    }

    public TournamentConfig(@NotNull Parcel parcel0) {
        q.g(parcel0, "parcel");
        TournamentScoreType tournamentScoreType0;
        TournamentSortOrder tournamentSortOrder0;
        super();
        this.title = parcel0.readString();
        TournamentSortOrder[] arr_tournamentSortOrder = TournamentSortOrder.values();
        for(int v1 = 0; true; ++v1) {
            tournamentSortOrder0 = null;
            if(v1 >= arr_tournamentSortOrder.length) {
                break;
            }
            TournamentSortOrder tournamentSortOrder1 = arr_tournamentSortOrder[v1];
            if(q.b(tournamentSortOrder1.name(), parcel0.readString())) {
                tournamentSortOrder0 = tournamentSortOrder1;
                break;
            }
        }
        this.sortOrder = tournamentSortOrder0;
        TournamentScoreType[] arr_tournamentScoreType = TournamentScoreType.values();
        for(int v = 0; true; ++v) {
            tournamentScoreType0 = null;
            if(v >= arr_tournamentScoreType.length) {
                break;
            }
            TournamentScoreType tournamentScoreType1 = arr_tournamentScoreType[v];
            if(q.b(tournamentScoreType1.name(), parcel0.readString())) {
                tournamentScoreType0 = tournamentScoreType1;
                break;
            }
        }
        this.scoreType = tournamentScoreType0;
        String s = parcel0.readString();
        this.endTime = s == null ? null : Instant.from(DateFormatter.INSTANCE.format$facebook_gamingservices_release(s));
        this.payload = parcel0.readString();
        this.image = null;
    }

    private TournamentConfig(Builder tournamentConfig$Builder0) {
        this.title = tournamentConfig$Builder0.getTitle();
        this.sortOrder = tournamentConfig$Builder0.getSortOrder();
        this.scoreType = tournamentConfig$Builder0.getScoreType();
        this.endTime = tournamentConfig$Builder0.getEndTime();
        this.image = tournamentConfig$Builder0.getImage();
        this.payload = tournamentConfig$Builder0.getPayload();
    }

    public TournamentConfig(Builder tournamentConfig$Builder0, DefaultConstructorMarker defaultConstructorMarker0) {
        this(tournamentConfig$Builder0);
    }

    @Override  // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    @Nullable
    public final Instant getEndTime() {
        return this.endTime;
    }

    @Nullable
    public final Image getImage() {
        return this.image;
    }

    @Nullable
    public final String getPayload() {
        return this.payload;
    }

    @Nullable
    public final TournamentScoreType getScoreType() {
        return this.scoreType;
    }

    @Nullable
    public final TournamentSortOrder getSortOrder() {
        return this.sortOrder;
    }

    @Nullable
    public final String getTitle() {
        return this.title;
    }

    @Override  // android.os.Parcelable
    public void writeToParcel(@NotNull Parcel parcel0, int v) {
        q.g(parcel0, "out");
        parcel0.writeString(String.valueOf(this.sortOrder));
        parcel0.writeString(String.valueOf(this.scoreType));
        parcel0.writeString(String.valueOf(this.endTime));
        parcel0.writeString(this.title);
        parcel0.writeString(this.payload);
    }
}


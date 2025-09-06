package com.facebook.share.model;

import Tf.o;
import android.os.Parcel;
import android.os.Parcelable.Creator;
import android.text.TextUtils;
import ie.d;
import java.util.List;
import je.p;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.q;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000H\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000E\n\u0002\b\u0006\n\u0002\u0010 \n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\r\u0018\u0000 12\u00020\u0001:\u00042314B\u0011\b\u0012\u0012\u0006\u0010\u0003\u001A\u00020\u0002¢\u0006\u0004\b\u0004\u0010\u0005B\u0011\b\u0010\u0012\u0006\u0010\u0007\u001A\u00020\u0006¢\u0006\u0004\b\u0004\u0010\bJ\u000F\u0010\n\u001A\u00020\tH\u0016¢\u0006\u0004\b\n\u0010\u000BJ\u001F\u0010\u000F\u001A\u00020\u000E2\u0006\u0010\f\u001A\u00020\u00062\u0006\u0010\r\u001A\u00020\tH\u0016¢\u0006\u0004\b\u000F\u0010\u0010R\u0019\u0010\u0012\u001A\u0004\u0018\u00010\u00118\u0006¢\u0006\f\n\u0004\b\u0012\u0010\u0013\u001A\u0004\b\u0014\u0010\u0015R\u0019\u0010\u0016\u001A\u0004\u0018\u00010\u00118\u0006¢\u0006\f\n\u0004\b\u0016\u0010\u0013\u001A\u0004\b\u0017\u0010\u0015R\u001F\u0010\u0019\u001A\n\u0012\u0004\u0012\u00020\u0011\u0018\u00010\u00188\u0006¢\u0006\f\n\u0004\b\u0019\u0010\u001A\u001A\u0004\b\u001B\u0010\u001CR\u0019\u0010\u001D\u001A\u0004\u0018\u00010\u00118\u0006¢\u0006\f\n\u0004\b\u001D\u0010\u0013\u001A\u0004\b\u001E\u0010\u0015R\u0019\u0010\u001F\u001A\u0004\u0018\u00010\u00118\u0006¢\u0006\f\n\u0004\b\u001F\u0010\u0013\u001A\u0004\b \u0010\u0015R\u0019\u0010\"\u001A\u0004\u0018\u00010!8\u0006¢\u0006\f\n\u0004\b\"\u0010#\u001A\u0004\b$\u0010%R\u0019\u0010&\u001A\u0004\u0018\u00010\u00118\u0006¢\u0006\f\n\u0004\b&\u0010\u0013\u001A\u0004\b\'\u0010\u0015R\u0019\u0010)\u001A\u0004\u0018\u00010(8\u0006¢\u0006\f\n\u0004\b)\u0010*\u001A\u0004\b+\u0010,R\u001F\u0010-\u001A\n\u0012\u0004\u0012\u00020\u0011\u0018\u00010\u00188\u0006¢\u0006\f\n\u0004\b-\u0010\u001A\u001A\u0004\b.\u0010\u001CR\u0013\u00100\u001A\u0004\u0018\u00010\u00118G¢\u0006\u0006\u001A\u0004\b/\u0010\u0015¨\u00065"}, d2 = {"Lcom/facebook/share/model/GameRequestContent;", "Lcom/facebook/share/model/ShareModel;", "Lcom/facebook/share/model/GameRequestContent$Builder;", "builder", "<init>", "(Lcom/facebook/share/model/GameRequestContent$Builder;)V", "Landroid/os/Parcel;", "parcel", "(Landroid/os/Parcel;)V", "", "describeContents", "()I", "out", "flags", "Lie/H;", "writeToParcel", "(Landroid/os/Parcel;I)V", "", "message", "Ljava/lang/String;", "getMessage", "()Ljava/lang/String;", "cta", "getCta", "", "recipients", "Ljava/util/List;", "getRecipients", "()Ljava/util/List;", "title", "getTitle", "data", "getData", "Lcom/facebook/share/model/GameRequestContent$ActionType;", "actionType", "Lcom/facebook/share/model/GameRequestContent$ActionType;", "getActionType", "()Lcom/facebook/share/model/GameRequestContent$ActionType;", "objectId", "getObjectId", "Lcom/facebook/share/model/GameRequestContent$Filters;", "filters", "Lcom/facebook/share/model/GameRequestContent$Filters;", "getFilters", "()Lcom/facebook/share/model/GameRequestContent$Filters;", "suggestions", "getSuggestions", "getTo", "to", "Companion", "ActionType", "Builder", "Filters", "facebook-common_release"}, k = 1, mv = {1, 8, 0}, xi = 0x30)
public final class GameRequestContent implements ShareModel {
    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0006\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002j\u0002\b\u0003j\u0002\b\u0004j\u0002\b\u0005j\u0002\b\u0006¨\u0006\u0007"}, d2 = {"Lcom/facebook/share/model/GameRequestContent$ActionType;", "", "(Ljava/lang/String;I)V", "SEND", "ASKFOR", "TURN", "INVITE", "facebook-common_release"}, k = 1, mv = {1, 8, 0}, xi = 0x30)
    public static enum ActionType {
        SEND,
        ASKFOR,
        TURN,
        INVITE;

        private static final ActionType[] $values() [...] // Inlined contents
    }

    @Metadata(d1 = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000E\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u000B\n\u0002\u0010 \n\u0002\b\r\n\u0002\u0018\u0002\n\u0002\b\u000E\u0018\u00002\u000E\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00000\u0001B\u0005\u00A2\u0006\u0002\u0010\u0003J\b\u0010+\u001A\u00020\u0002H\u0016J\u0015\u0010,\u001A\u00020\u00002\u0006\u0010-\u001A\u00020.H\u0000\u00A2\u0006\u0002\b/J\u0012\u0010,\u001A\u00020\u00002\b\u00100\u001A\u0004\u0018\u00010\u0002H\u0016J\u0010\u00101\u001A\u00020\u00002\b\u0010\u0004\u001A\u0004\u0018\u00010\u0005J\u0010\u00102\u001A\u00020\u00002\b\u0010\n\u001A\u0004\u0018\u00010\u000BJ\u0010\u00103\u001A\u00020\u00002\b\u0010\u0010\u001A\u0004\u0018\u00010\u000BJ\u0010\u00104\u001A\u00020\u00002\b\u0010\u0013\u001A\u0004\u0018\u00010\u0014J\u0010\u00105\u001A\u00020\u00002\b\u0010\u0019\u001A\u0004\u0018\u00010\u000BJ\u0010\u00106\u001A\u00020\u00002\b\u0010\u001C\u001A\u0004\u0018\u00010\u000BJ\u0016\u00107\u001A\u00020\u00002\u000E\u0010\u001F\u001A\n\u0012\u0004\u0012\u00020\u000B\u0018\u00010 J\u0016\u00108\u001A\u00020\u00002\u000E\u0010%\u001A\n\u0012\u0004\u0012\u00020\u000B\u0018\u00010 J\u0010\u00109\u001A\u00020\u00002\b\u0010(\u001A\u0004\u0018\u00010\u000BJ\u0012\u0010:\u001A\u00020\u00002\b\u0010;\u001A\u0004\u0018\u00010\u000BH\u0007R\u001C\u0010\u0004\u001A\u0004\u0018\u00010\u0005X\u0080\u000E\u00A2\u0006\u000E\n\u0000\u001A\u0004\b\u0006\u0010\u0007\"\u0004\b\b\u0010\tR\u001C\u0010\n\u001A\u0004\u0018\u00010\u000BX\u0080\u000E\u00A2\u0006\u000E\n\u0000\u001A\u0004\b\f\u0010\r\"\u0004\b\u000E\u0010\u000FR\u001C\u0010\u0010\u001A\u0004\u0018\u00010\u000BX\u0080\u000E\u00A2\u0006\u000E\n\u0000\u001A\u0004\b\u0011\u0010\r\"\u0004\b\u0012\u0010\u000FR\u001C\u0010\u0013\u001A\u0004\u0018\u00010\u0014X\u0080\u000E\u00A2\u0006\u000E\n\u0000\u001A\u0004\b\u0015\u0010\u0016\"\u0004\b\u0017\u0010\u0018R\u001C\u0010\u0019\u001A\u0004\u0018\u00010\u000BX\u0080\u000E\u00A2\u0006\u000E\n\u0000\u001A\u0004\b\u001A\u0010\r\"\u0004\b\u001B\u0010\u000FR\u001C\u0010\u001C\u001A\u0004\u0018\u00010\u000BX\u0080\u000E\u00A2\u0006\u000E\n\u0000\u001A\u0004\b\u001D\u0010\r\"\u0004\b\u001E\u0010\u000FR\"\u0010\u001F\u001A\n\u0012\u0004\u0012\u00020\u000B\u0018\u00010 X\u0080\u000E\u00A2\u0006\u000E\n\u0000\u001A\u0004\b!\u0010\"\"\u0004\b#\u0010$R\"\u0010%\u001A\n\u0012\u0004\u0012\u00020\u000B\u0018\u00010 X\u0080\u000E\u00A2\u0006\u000E\n\u0000\u001A\u0004\b&\u0010\"\"\u0004\b\'\u0010$R\u001C\u0010(\u001A\u0004\u0018\u00010\u000BX\u0080\u000E\u00A2\u0006\u000E\n\u0000\u001A\u0004\b)\u0010\r\"\u0004\b*\u0010\u000F\u00A8\u0006<"}, d2 = {"Lcom/facebook/share/model/GameRequestContent$Builder;", "Lcom/facebook/share/model/ShareModelBuilder;", "Lcom/facebook/share/model/GameRequestContent;", "()V", "actionType", "Lcom/facebook/share/model/GameRequestContent$ActionType;", "getActionType$facebook_common_release", "()Lcom/facebook/share/model/GameRequestContent$ActionType;", "setActionType$facebook_common_release", "(Lcom/facebook/share/model/GameRequestContent$ActionType;)V", "cta", "", "getCta$facebook_common_release", "()Ljava/lang/String;", "setCta$facebook_common_release", "(Ljava/lang/String;)V", "data", "getData$facebook_common_release", "setData$facebook_common_release", "filters", "Lcom/facebook/share/model/GameRequestContent$Filters;", "getFilters$facebook_common_release", "()Lcom/facebook/share/model/GameRequestContent$Filters;", "setFilters$facebook_common_release", "(Lcom/facebook/share/model/GameRequestContent$Filters;)V", "message", "getMessage$facebook_common_release", "setMessage$facebook_common_release", "objectId", "getObjectId$facebook_common_release", "setObjectId$facebook_common_release", "recipients", "", "getRecipients$facebook_common_release", "()Ljava/util/List;", "setRecipients$facebook_common_release", "(Ljava/util/List;)V", "suggestions", "getSuggestions$facebook_common_release", "setSuggestions$facebook_common_release", "title", "getTitle$facebook_common_release", "setTitle$facebook_common_release", "build", "readFrom", "parcel", "Landroid/os/Parcel;", "readFrom$facebook_common_release", "content", "setActionType", "setCta", "setData", "setFilters", "setMessage", "setObjectId", "setRecipients", "setSuggestions", "setTitle", "setTo", "to", "facebook-common_release"}, k = 1, mv = {1, 8, 0}, xi = 0x30)
    public static final class Builder implements ShareModelBuilder {
        @Nullable
        private ActionType actionType;
        @Nullable
        private String cta;
        @Nullable
        private String data;
        @Nullable
        private Filters filters;
        @Nullable
        private String message;
        @Nullable
        private String objectId;
        @Nullable
        private List recipients;
        @Nullable
        private List suggestions;
        @Nullable
        private String title;

        @NotNull
        public GameRequestContent build() {
            return new GameRequestContent(this, null);
        }

        @Override  // com.facebook.share.ShareBuilder
        public Object build() {
            return this.build();
        }

        @Nullable
        public final ActionType getActionType$facebook_common_release() {
            return this.actionType;
        }

        @Nullable
        public final String getCta$facebook_common_release() {
            return this.cta;
        }

        @Nullable
        public final String getData$facebook_common_release() {
            return this.data;
        }

        @Nullable
        public final Filters getFilters$facebook_common_release() {
            return this.filters;
        }

        @Nullable
        public final String getMessage$facebook_common_release() {
            return this.message;
        }

        @Nullable
        public final String getObjectId$facebook_common_release() {
            return this.objectId;
        }

        @Nullable
        public final List getRecipients$facebook_common_release() {
            return this.recipients;
        }

        @Nullable
        public final List getSuggestions$facebook_common_release() {
            return this.suggestions;
        }

        @Nullable
        public final String getTitle$facebook_common_release() {
            return this.title;
        }

        @NotNull
        public Builder readFrom(@Nullable GameRequestContent gameRequestContent0) {
            return gameRequestContent0 == null ? this : this.setMessage(gameRequestContent0.getMessage()).setCta(gameRequestContent0.getCta()).setRecipients(gameRequestContent0.getRecipients()).setTitle(gameRequestContent0.getTitle()).setData(gameRequestContent0.getData()).setActionType(gameRequestContent0.getActionType()).setObjectId(gameRequestContent0.getObjectId()).setFilters(gameRequestContent0.getFilters()).setSuggestions(gameRequestContent0.getSuggestions());
        }

        @Override  // com.facebook.share.model.ShareModelBuilder
        public ShareModelBuilder readFrom(ShareModel shareModel0) {
            return this.readFrom(((GameRequestContent)shareModel0));
        }

        @NotNull
        public final Builder readFrom$facebook_common_release(@NotNull Parcel parcel0) {
            q.g(parcel0, "parcel");
            return this.readFrom(((GameRequestContent)parcel0.readParcelable(GameRequestContent.class.getClassLoader())));
        }

        @NotNull
        public final Builder setActionType(@Nullable ActionType gameRequestContent$ActionType0) {
            this.actionType = gameRequestContent$ActionType0;
            return this;
        }

        public final void setActionType$facebook_common_release(@Nullable ActionType gameRequestContent$ActionType0) {
            this.actionType = gameRequestContent$ActionType0;
        }

        @NotNull
        public final Builder setCta(@Nullable String s) {
            this.cta = s;
            return this;
        }

        public final void setCta$facebook_common_release(@Nullable String s) {
            this.cta = s;
        }

        @NotNull
        public final Builder setData(@Nullable String s) {
            this.data = s;
            return this;
        }

        public final void setData$facebook_common_release(@Nullable String s) {
            this.data = s;
        }

        @NotNull
        public final Builder setFilters(@Nullable Filters gameRequestContent$Filters0) {
            this.filters = gameRequestContent$Filters0;
            return this;
        }

        public final void setFilters$facebook_common_release(@Nullable Filters gameRequestContent$Filters0) {
            this.filters = gameRequestContent$Filters0;
        }

        @NotNull
        public final Builder setMessage(@Nullable String s) {
            this.message = s;
            return this;
        }

        public final void setMessage$facebook_common_release(@Nullable String s) {
            this.message = s;
        }

        @NotNull
        public final Builder setObjectId(@Nullable String s) {
            this.objectId = s;
            return this;
        }

        public final void setObjectId$facebook_common_release(@Nullable String s) {
            this.objectId = s;
        }

        @NotNull
        public final Builder setRecipients(@Nullable List list0) {
            this.recipients = list0;
            return this;
        }

        public final void setRecipients$facebook_common_release(@Nullable List list0) {
            this.recipients = list0;
        }

        @NotNull
        public final Builder setSuggestions(@Nullable List list0) {
            this.suggestions = list0;
            return this;
        }

        public final void setSuggestions$facebook_common_release(@Nullable List list0) {
            this.suggestions = list0;
        }

        @NotNull
        public final Builder setTitle(@Nullable String s) {
            this.title = s;
            return this;
        }

        public final void setTitle$facebook_common_release(@Nullable String s) {
            this.title = s;
        }

        @d
        @NotNull
        public final Builder setTo(@Nullable String s) {
            if(s != null) {
                this.recipients = p.P0(o.S0(s, new char[]{','}));
            }
            return this;
        }
    }

    @Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u0016\u0010\u0003\u001A\b\u0012\u0004\u0012\u00020\u00050\u00048\u0006X\u0087\u0004¢\u0006\u0002\n\u0000¨\u0006\u0006"}, d2 = {"Lcom/facebook/share/model/GameRequestContent$Companion;", "", "()V", "CREATOR", "Landroid/os/Parcelable$Creator;", "Lcom/facebook/share/model/GameRequestContent;", "facebook-common_release"}, k = 1, mv = {1, 8, 0}, xi = 0x30)
    public static final class Companion {
        private Companion() {
        }

        public Companion(DefaultConstructorMarker defaultConstructorMarker0) {
        }
    }

    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0005\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002j\u0002\b\u0003j\u0002\b\u0004j\u0002\b\u0005¨\u0006\u0006"}, d2 = {"Lcom/facebook/share/model/GameRequestContent$Filters;", "", "(Ljava/lang/String;I)V", "APP_USERS", "APP_NON_USERS", "EVERYBODY", "facebook-common_release"}, k = 1, mv = {1, 8, 0}, xi = 0x30)
    public static enum Filters {
        APP_USERS,
        APP_NON_USERS,
        EVERYBODY;

        private static final Filters[] $values() [...] // Inlined contents
    }

    @NotNull
    public static final Parcelable.Creator CREATOR;
    @NotNull
    public static final Companion Companion;
    @Nullable
    private final ActionType actionType;
    @Nullable
    private final String cta;
    @Nullable
    private final String data;
    @Nullable
    private final Filters filters;
    @Nullable
    private final String message;
    @Nullable
    private final String objectId;
    @Nullable
    private final List recipients;
    @Nullable
    private final List suggestions;
    @Nullable
    private final String title;

    static {
        GameRequestContent.Companion = new Companion(null);
        GameRequestContent.CREATOR = new GameRequestContent.Companion.CREATOR.1();
    }

    public GameRequestContent(@NotNull Parcel parcel0) {
        q.g(parcel0, "parcel");
        super();
        this.message = parcel0.readString();
        this.cta = parcel0.readString();
        this.recipients = parcel0.createStringArrayList();
        this.title = parcel0.readString();
        this.data = parcel0.readString();
        this.actionType = (ActionType)parcel0.readSerializable();
        this.objectId = parcel0.readString();
        this.filters = (Filters)parcel0.readSerializable();
        this.suggestions = parcel0.createStringArrayList();
    }

    private GameRequestContent(Builder gameRequestContent$Builder0) {
        this.message = gameRequestContent$Builder0.getMessage$facebook_common_release();
        this.cta = gameRequestContent$Builder0.getCta$facebook_common_release();
        this.recipients = gameRequestContent$Builder0.getRecipients$facebook_common_release();
        this.title = gameRequestContent$Builder0.getTitle$facebook_common_release();
        this.data = gameRequestContent$Builder0.getData$facebook_common_release();
        this.actionType = gameRequestContent$Builder0.getActionType$facebook_common_release();
        this.objectId = gameRequestContent$Builder0.getObjectId$facebook_common_release();
        this.filters = gameRequestContent$Builder0.getFilters$facebook_common_release();
        this.suggestions = gameRequestContent$Builder0.getSuggestions$facebook_common_release();
    }

    public GameRequestContent(Builder gameRequestContent$Builder0, DefaultConstructorMarker defaultConstructorMarker0) {
        this(gameRequestContent$Builder0);
    }

    @Override  // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    @Nullable
    public final ActionType getActionType() {
        return this.actionType;
    }

    @Nullable
    public final String getCta() {
        return this.cta;
    }

    @Nullable
    public final String getData() {
        return this.data;
    }

    @Nullable
    public final Filters getFilters() {
        return this.filters;
    }

    @Nullable
    public final String getMessage() {
        return this.message;
    }

    @Nullable
    public final String getObjectId() {
        return this.objectId;
    }

    @Nullable
    public final List getRecipients() {
        return this.recipients;
    }

    @Nullable
    public final List getSuggestions() {
        return this.suggestions;
    }

    @Nullable
    public final String getTitle() {
        return this.title;
    }

    @d
    @Nullable
    public final String getTo() {
        return this.recipients == null ? null : TextUtils.join(",", this.recipients);
    }

    @Override  // android.os.Parcelable
    public void writeToParcel(@NotNull Parcel parcel0, int v) {
        q.g(parcel0, "out");
        parcel0.writeString(this.message);
        parcel0.writeString(this.cta);
        parcel0.writeStringList(this.recipients);
        parcel0.writeString(this.title);
        parcel0.writeString(this.data);
        parcel0.writeSerializable(this.actionType);
        parcel0.writeString(this.objectId);
        parcel0.writeSerializable(this.filters);
        parcel0.writeStringList(this.suggestions);
    }
}


package com.facebook.share.model;

import android.net.Uri;
import android.os.Parcel;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.q;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000H\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0010\u000E\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0010\n\u0002\u0018\u0002\n\u0002\b\u0006\b&\u0018\u0000*\u0014\b\u0000\u0010\u0001*\u000E\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010\u0000*\u0014\b\u0001\u0010\u0003*\u000E\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010\u00022\u00020\u0004:\u0001-B\u001D\b\u0014\u0012\u0012\u0010\u0005\u001A\u000E\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010\u0002¢\u0006\u0004\b\u0006\u0010\u0007B\u0011\b\u0014\u0012\u0006\u0010\t\u001A\u00020\b¢\u0006\u0004\b\u0006\u0010\nJ\u001F\u0010\r\u001A\n\u0012\u0004\u0012\u00020\f\u0018\u00010\u000B2\u0006\u0010\t\u001A\u00020\bH\u0002¢\u0006\u0004\b\r\u0010\u000EJ\u000F\u0010\u0010\u001A\u00020\u000FH\u0016¢\u0006\u0004\b\u0010\u0010\u0011J\u001F\u0010\u0015\u001A\u00020\u00142\u0006\u0010\u0012\u001A\u00020\b2\u0006\u0010\u0013\u001A\u00020\u000FH\u0016¢\u0006\u0004\b\u0015\u0010\u0016R\u0019\u0010\u0018\u001A\u0004\u0018\u00010\u00178\u0006¢\u0006\f\n\u0004\b\u0018\u0010\u0019\u001A\u0004\b\u001A\u0010\u001BR\u001F\u0010\u001C\u001A\n\u0012\u0004\u0012\u00020\f\u0018\u00010\u000B8\u0006¢\u0006\f\n\u0004\b\u001C\u0010\u001D\u001A\u0004\b\u001E\u0010\u001FR\u0019\u0010 \u001A\u0004\u0018\u00010\f8\u0006¢\u0006\f\n\u0004\b \u0010!\u001A\u0004\b\"\u0010#R\u0019\u0010$\u001A\u0004\u0018\u00010\f8\u0006¢\u0006\f\n\u0004\b$\u0010!\u001A\u0004\b%\u0010#R\u0019\u0010&\u001A\u0004\u0018\u00010\f8\u0006¢\u0006\f\n\u0004\b&\u0010!\u001A\u0004\b\'\u0010#R\u0019\u0010)\u001A\u0004\u0018\u00010(8\u0006¢\u0006\f\n\u0004\b)\u0010*\u001A\u0004\b+\u0010,¨\u0006."}, d2 = {"Lcom/facebook/share/model/ShareContent;", "M", "Lcom/facebook/share/model/ShareContent$Builder;", "B", "Lcom/facebook/share/model/ShareModel;", "builder", "<init>", "(Lcom/facebook/share/model/ShareContent$Builder;)V", "Landroid/os/Parcel;", "parcel", "(Landroid/os/Parcel;)V", "", "", "readUnmodifiableStringList", "(Landroid/os/Parcel;)Ljava/util/List;", "", "describeContents", "()I", "out", "flags", "Lie/H;", "writeToParcel", "(Landroid/os/Parcel;I)V", "Landroid/net/Uri;", "contentUrl", "Landroid/net/Uri;", "getContentUrl", "()Landroid/net/Uri;", "peopleIds", "Ljava/util/List;", "getPeopleIds", "()Ljava/util/List;", "placeId", "Ljava/lang/String;", "getPlaceId", "()Ljava/lang/String;", "pageId", "getPageId", "ref", "getRef", "Lcom/facebook/share/model/ShareHashtag;", "shareHashtag", "Lcom/facebook/share/model/ShareHashtag;", "getShareHashtag", "()Lcom/facebook/share/model/ShareHashtag;", "Builder", "facebook-common_release"}, k = 1, mv = {1, 8, 0}, xi = 0x30)
public abstract class ShareContent implements ShareModel {
    @Metadata(d1 = {"\u00004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000E\n\u0002\b\u0005\n\u0002\u0010 \n\u0002\b\u0019\b&\u0018\u0000*\u0014\b\u0002\u0010\u0001*\u000E\u0012\u0004\u0012\u0002H\u0001\u0012\u0004\u0012\u0002H\u00030\u0002*\u0014\b\u0003\u0010\u0003*\u000E\u0012\u0004\u0012\u0002H\u0001\u0012\u0004\u0012\u0002H\u00030\u00002\u000E\u0012\u0004\u0012\u0002H\u0001\u0012\u0004\u0012\u0002H\u00030\u0004B\u0005¢\u0006\u0002\u0010\u0005J\u0017\u0010$\u001A\u00028\u00032\b\u0010%\u001A\u0004\u0018\u00018\u0002H\u0016¢\u0006\u0002\u0010&J\u0015\u0010\'\u001A\u00028\u00032\b\u0010\u0006\u001A\u0004\u0018\u00010\u0007¢\u0006\u0002\u0010(J\u0015\u0010)\u001A\u00028\u00032\b\u0010\u0012\u001A\u0004\u0018\u00010\u0013¢\u0006\u0002\u0010*J\u001B\u0010+\u001A\u00028\u00032\u000E\u0010\u0018\u001A\n\u0012\u0004\u0012\u00020\u0013\u0018\u00010\u0019¢\u0006\u0002\u0010,J\u0015\u0010-\u001A\u00028\u00032\b\u0010\u001E\u001A\u0004\u0018\u00010\u0013¢\u0006\u0002\u0010*J\u0015\u0010.\u001A\u00028\u00032\b\u0010!\u001A\u0004\u0018\u00010\u0013¢\u0006\u0002\u0010*J\u0015\u0010/\u001A\u00028\u00032\b\u00100\u001A\u0004\u0018\u00010\r¢\u0006\u0002\u00101R\u001C\u0010\u0006\u001A\u0004\u0018\u00010\u0007X\u0080\u000E¢\u0006\u000E\n\u0000\u001A\u0004\b\b\u0010\t\"\u0004\b\n\u0010\u000BR\u001C\u0010\f\u001A\u0004\u0018\u00010\rX\u0080\u000E¢\u0006\u000E\n\u0000\u001A\u0004\b\u000E\u0010\u000F\"\u0004\b\u0010\u0010\u0011R\u001C\u0010\u0012\u001A\u0004\u0018\u00010\u0013X\u0080\u000E¢\u0006\u000E\n\u0000\u001A\u0004\b\u0014\u0010\u0015\"\u0004\b\u0016\u0010\u0017R\"\u0010\u0018\u001A\n\u0012\u0004\u0012\u00020\u0013\u0018\u00010\u0019X\u0080\u000E¢\u0006\u000E\n\u0000\u001A\u0004\b\u001A\u0010\u001B\"\u0004\b\u001C\u0010\u001DR\u001C\u0010\u001E\u001A\u0004\u0018\u00010\u0013X\u0080\u000E¢\u0006\u000E\n\u0000\u001A\u0004\b\u001F\u0010\u0015\"\u0004\b \u0010\u0017R\u001C\u0010!\u001A\u0004\u0018\u00010\u0013X\u0080\u000E¢\u0006\u000E\n\u0000\u001A\u0004\b\"\u0010\u0015\"\u0004\b#\u0010\u0017¨\u00062"}, d2 = {"Lcom/facebook/share/model/ShareContent$Builder;", "M", "Lcom/facebook/share/model/ShareContent;", "B", "Lcom/facebook/share/model/ShareModelBuilder;", "()V", "contentUrl", "Landroid/net/Uri;", "getContentUrl$facebook_common_release", "()Landroid/net/Uri;", "setContentUrl$facebook_common_release", "(Landroid/net/Uri;)V", "hashtag", "Lcom/facebook/share/model/ShareHashtag;", "getHashtag$facebook_common_release", "()Lcom/facebook/share/model/ShareHashtag;", "setHashtag$facebook_common_release", "(Lcom/facebook/share/model/ShareHashtag;)V", "pageId", "", "getPageId$facebook_common_release", "()Ljava/lang/String;", "setPageId$facebook_common_release", "(Ljava/lang/String;)V", "peopleIds", "", "getPeopleIds$facebook_common_release", "()Ljava/util/List;", "setPeopleIds$facebook_common_release", "(Ljava/util/List;)V", "placeId", "getPlaceId$facebook_common_release", "setPlaceId$facebook_common_release", "ref", "getRef$facebook_common_release", "setRef$facebook_common_release", "readFrom", "content", "(Lcom/facebook/share/model/ShareContent;)Lcom/facebook/share/model/ShareContent$Builder;", "setContentUrl", "(Landroid/net/Uri;)Lcom/facebook/share/model/ShareContent$Builder;", "setPageId", "(Ljava/lang/String;)Lcom/facebook/share/model/ShareContent$Builder;", "setPeopleIds", "(Ljava/util/List;)Lcom/facebook/share/model/ShareContent$Builder;", "setPlaceId", "setRef", "setShareHashtag", "shareHashtag", "(Lcom/facebook/share/model/ShareHashtag;)Lcom/facebook/share/model/ShareContent$Builder;", "facebook-common_release"}, k = 1, mv = {1, 8, 0}, xi = 0x30)
    public static abstract class Builder implements ShareModelBuilder {
        @Nullable
        private Uri contentUrl;
        @Nullable
        private ShareHashtag hashtag;
        @Nullable
        private String pageId;
        @Nullable
        private List peopleIds;
        @Nullable
        private String placeId;
        @Nullable
        private String ref;

        @Nullable
        public final Uri getContentUrl$facebook_common_release() {
            return this.contentUrl;
        }

        @Nullable
        public final ShareHashtag getHashtag$facebook_common_release() {
            return this.hashtag;
        }

        @Nullable
        public final String getPageId$facebook_common_release() {
            return this.pageId;
        }

        @Nullable
        public final List getPeopleIds$facebook_common_release() {
            return this.peopleIds;
        }

        @Nullable
        public final String getPlaceId$facebook_common_release() {
            return this.placeId;
        }

        @Nullable
        public final String getRef$facebook_common_release() {
            return this.ref;
        }

        @NotNull
        public Builder readFrom(@Nullable ShareContent shareContent0) {
            return shareContent0 == null ? this : this.setContentUrl(shareContent0.getContentUrl()).setPeopleIds(shareContent0.getPeopleIds()).setPlaceId(shareContent0.getPlaceId()).setPageId(shareContent0.getPageId()).setRef(shareContent0.getRef()).setShareHashtag(shareContent0.getShareHashtag());
        }

        @Override  // com.facebook.share.model.ShareModelBuilder
        public ShareModelBuilder readFrom(ShareModel shareModel0) {
            return this.readFrom(((ShareContent)shareModel0));
        }

        @NotNull
        public final Builder setContentUrl(@Nullable Uri uri0) {
            this.contentUrl = uri0;
            return this;
        }

        public final void setContentUrl$facebook_common_release(@Nullable Uri uri0) {
            this.contentUrl = uri0;
        }

        public final void setHashtag$facebook_common_release(@Nullable ShareHashtag shareHashtag0) {
            this.hashtag = shareHashtag0;
        }

        @NotNull
        public final Builder setPageId(@Nullable String s) {
            this.pageId = s;
            return this;
        }

        public final void setPageId$facebook_common_release(@Nullable String s) {
            this.pageId = s;
        }

        @NotNull
        public final Builder setPeopleIds(@Nullable List list0) {
            this.peopleIds = list0 == null ? null : Collections.unmodifiableList(list0);
            return this;
        }

        public final void setPeopleIds$facebook_common_release(@Nullable List list0) {
            this.peopleIds = list0;
        }

        @NotNull
        public final Builder setPlaceId(@Nullable String s) {
            this.placeId = s;
            return this;
        }

        public final void setPlaceId$facebook_common_release(@Nullable String s) {
            this.placeId = s;
        }

        @NotNull
        public final Builder setRef(@Nullable String s) {
            this.ref = s;
            return this;
        }

        public final void setRef$facebook_common_release(@Nullable String s) {
            this.ref = s;
        }

        @NotNull
        public final Builder setShareHashtag(@Nullable ShareHashtag shareHashtag0) {
            this.hashtag = shareHashtag0;
            return this;
        }
    }

    @Nullable
    private final Uri contentUrl;
    @Nullable
    private final String pageId;
    @Nullable
    private final List peopleIds;
    @Nullable
    private final String placeId;
    @Nullable
    private final String ref;
    @Nullable
    private final ShareHashtag shareHashtag;

    public ShareContent(@NotNull Parcel parcel0) {
        q.g(parcel0, "parcel");
        super();
        this.contentUrl = (Uri)parcel0.readParcelable(Uri.class.getClassLoader());
        this.peopleIds = this.readUnmodifiableStringList(parcel0);
        this.placeId = parcel0.readString();
        this.pageId = parcel0.readString();
        this.ref = parcel0.readString();
        this.shareHashtag = new com.facebook.share.model.ShareHashtag.Builder().readFrom$facebook_common_release(parcel0).build();
    }

    public ShareContent(@NotNull Builder shareContent$Builder0) {
        q.g(shareContent$Builder0, "builder");
        super();
        this.contentUrl = shareContent$Builder0.getContentUrl$facebook_common_release();
        this.peopleIds = shareContent$Builder0.getPeopleIds$facebook_common_release();
        this.placeId = shareContent$Builder0.getPlaceId$facebook_common_release();
        this.pageId = shareContent$Builder0.getPageId$facebook_common_release();
        this.ref = shareContent$Builder0.getRef$facebook_common_release();
        this.shareHashtag = shareContent$Builder0.getHashtag$facebook_common_release();
    }

    @Override  // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    @Nullable
    public final Uri getContentUrl() {
        return this.contentUrl;
    }

    @Nullable
    public final String getPageId() {
        return this.pageId;
    }

    @Nullable
    public final List getPeopleIds() {
        return this.peopleIds;
    }

    @Nullable
    public final String getPlaceId() {
        return this.placeId;
    }

    @Nullable
    public final String getRef() {
        return this.ref;
    }

    @Nullable
    public final ShareHashtag getShareHashtag() {
        return this.shareHashtag;
    }

    private final List readUnmodifiableStringList(Parcel parcel0) {
        ArrayList arrayList0 = new ArrayList();
        parcel0.readStringList(arrayList0);
        return arrayList0.isEmpty() ? null : Collections.unmodifiableList(arrayList0);
    }

    @Override  // android.os.Parcelable
    public void writeToParcel(@NotNull Parcel parcel0, int v) {
        q.g(parcel0, "out");
        parcel0.writeParcelable(this.contentUrl, 0);
        parcel0.writeStringList(this.peopleIds);
        parcel0.writeString(this.placeId);
        parcel0.writeString(this.pageId);
        parcel0.writeString(this.ref);
        parcel0.writeParcelable(this.shareHashtag, 0);
    }
}


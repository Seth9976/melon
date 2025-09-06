package com.facebook.share.internal;

import android.annotation.SuppressLint;
import android.os.Bundle;
import com.facebook.internal.Utility;
import com.facebook.share.model.AppGroupCreationContent.AppGroupPrivacy;
import com.facebook.share.model.AppGroupCreationContent;
import com.facebook.share.model.GameRequestContent.ActionType;
import com.facebook.share.model.GameRequestContent.Filters;
import com.facebook.share.model.GameRequestContent;
import com.facebook.share.model.ShareContent;
import com.facebook.share.model.ShareHashtag;
import com.facebook.share.model.ShareLinkContent;
import com.facebook.share.model.SharePhoto;
import com.facebook.share.model.SharePhotoContent;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import je.w;
import kotlin.Metadata;
import kotlin.jvm.internal.q;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u0000:\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\bÆ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0010\u0010\u0003\u001A\u00020\u00042\u0006\u0010\u0005\u001A\u00020\u0006H\u0007J\u0010\u0010\u0003\u001A\u00020\u00042\u0006\u0010\u0007\u001A\u00020\bH\u0007J\u0010\u0010\u0003\u001A\u00020\u00042\u0006\u0010\t\u001A\u00020\nH\u0007J\u0010\u0010\u0003\u001A\u00020\u00042\u0006\u0010\u000B\u001A\u00020\fH\u0007J\u0018\u0010\r\u001A\u00020\u00042\u000E\u0010\u000E\u001A\n\u0012\u0002\b\u0003\u0012\u0002\b\u00030\u000FH\u0007J\u0010\u0010\u0010\u001A\u00020\u00042\u0006\u0010\u0011\u001A\u00020\u0012H\u0007J\u0010\u0010\u0010\u001A\u00020\u00042\u0006\u0010\t\u001A\u00020\nH\u0007¨\u0006\u0013"}, d2 = {"Lcom/facebook/share/internal/WebDialogParameters;", "", "()V", "create", "Landroid/os/Bundle;", "appGroupCreationContent", "Lcom/facebook/share/model/AppGroupCreationContent;", "gameRequestContent", "Lcom/facebook/share/model/GameRequestContent;", "shareLinkContent", "Lcom/facebook/share/model/ShareLinkContent;", "sharePhotoContent", "Lcom/facebook/share/model/SharePhotoContent;", "createBaseParameters", "shareContent", "Lcom/facebook/share/model/ShareContent;", "createForFeed", "shareFeedContent", "Lcom/facebook/share/internal/ShareFeedContent;", "facebook-common_release"}, k = 1, mv = {1, 8, 0}, xi = 0x30)
public final class WebDialogParameters {
    @NotNull
    public static final WebDialogParameters INSTANCE;

    static {
        WebDialogParameters.INSTANCE = new WebDialogParameters();
    }

    @NotNull
    public static final Bundle create(@NotNull AppGroupCreationContent appGroupCreationContent0) {
        String s1;
        q.g(appGroupCreationContent0, "appGroupCreationContent");
        Bundle bundle0 = new Bundle();
        Utility.putNonEmptyString(bundle0, "name", appGroupCreationContent0.getName());
        Utility.putNonEmptyString(bundle0, "description", appGroupCreationContent0.getDescription());
        AppGroupPrivacy appGroupCreationContent$AppGroupPrivacy0 = appGroupCreationContent0.getAppGroupPrivacy();
        if(appGroupCreationContent$AppGroupPrivacy0 == null) {
            s1 = null;
        }
        else {
            String s = appGroupCreationContent$AppGroupPrivacy0.toString();
            if(s == null) {
                s1 = null;
            }
            else {
                Locale locale0 = Locale.ENGLISH;
                q.f(locale0, "ENGLISH");
                s1 = s.toLowerCase(locale0);
                q.f(s1, "this as java.lang.String).toLowerCase(locale)");
            }
        }
        Utility.putNonEmptyString(bundle0, "privacy", s1);
        return bundle0;
    }

    @NotNull
    public static final Bundle create(@NotNull GameRequestContent gameRequestContent0) {
        String s2;
        q.g(gameRequestContent0, "gameRequestContent");
        Bundle bundle0 = new Bundle();
        Utility.putNonEmptyString(bundle0, "message", gameRequestContent0.getMessage());
        Utility.putCommaSeparatedStringList(bundle0, "to", gameRequestContent0.getRecipients());
        Utility.putNonEmptyString(bundle0, "title", gameRequestContent0.getTitle());
        Utility.putNonEmptyString(bundle0, "data", gameRequestContent0.getData());
        ActionType gameRequestContent$ActionType0 = gameRequestContent0.getActionType();
        String s = null;
        if(gameRequestContent$ActionType0 == null) {
            s2 = null;
        }
        else {
            String s1 = gameRequestContent$ActionType0.toString();
            if(s1 == null) {
                s2 = null;
            }
            else {
                Locale locale0 = Locale.ENGLISH;
                q.f(locale0, "ENGLISH");
                s2 = s1.toLowerCase(locale0);
                q.f(s2, "this as java.lang.String).toLowerCase(locale)");
            }
        }
        Utility.putNonEmptyString(bundle0, "action_type", s2);
        Utility.putNonEmptyString(bundle0, "object_id", gameRequestContent0.getObjectId());
        Filters gameRequestContent$Filters0 = gameRequestContent0.getFilters();
        if(gameRequestContent$Filters0 != null) {
            String s3 = gameRequestContent$Filters0.toString();
            if(s3 != null) {
                Locale locale1 = Locale.ENGLISH;
                q.f(locale1, "ENGLISH");
                s = s3.toLowerCase(locale1);
                q.f(s, "this as java.lang.String).toLowerCase(locale)");
            }
        }
        Utility.putNonEmptyString(bundle0, "filters", s);
        Utility.putCommaSeparatedStringList(bundle0, "suggestions", gameRequestContent0.getSuggestions());
        return bundle0;
    }

    @NotNull
    public static final Bundle create(@NotNull ShareLinkContent shareLinkContent0) {
        q.g(shareLinkContent0, "shareLinkContent");
        Bundle bundle0 = WebDialogParameters.createBaseParameters(shareLinkContent0);
        Utility.putUri(bundle0, "href", shareLinkContent0.getContentUrl());
        Utility.putNonEmptyString(bundle0, "quote", shareLinkContent0.getQuote());
        return bundle0;
    }

    @NotNull
    public static final Bundle create(@NotNull SharePhotoContent sharePhotoContent0) {
        q.g(sharePhotoContent0, "sharePhotoContent");
        Bundle bundle0 = WebDialogParameters.createBaseParameters(sharePhotoContent0);
        List list0 = sharePhotoContent0.getPhotos();
        if(list0 == null) {
            list0 = w.a;
        }
        ArrayList arrayList0 = new ArrayList(je.q.Q(10, list0));
        for(Object object0: list0) {
            arrayList0.add(String.valueOf(((SharePhoto)object0).getImageUrl()));
        }
        bundle0.putStringArray("media", ((String[])arrayList0.toArray(new String[0])));
        return bundle0;
    }

    @NotNull
    public static final Bundle createBaseParameters(@NotNull ShareContent shareContent0) {
        q.g(shareContent0, "shareContent");
        Bundle bundle0 = new Bundle();
        ShareHashtag shareHashtag0 = shareContent0.getShareHashtag();
        Utility.putNonEmptyString(bundle0, "hashtag", (shareHashtag0 == null ? null : shareHashtag0.getHashtag()));
        return bundle0;
    }

    @NotNull
    public static final Bundle createForFeed(@NotNull ShareFeedContent shareFeedContent0) {
        q.g(shareFeedContent0, "shareFeedContent");
        Bundle bundle0 = new Bundle();
        Utility.putNonEmptyString(bundle0, "to", shareFeedContent0.getToId());
        Utility.putNonEmptyString(bundle0, "link", shareFeedContent0.getLink());
        Utility.putNonEmptyString(bundle0, "picture", shareFeedContent0.getPicture());
        Utility.putNonEmptyString(bundle0, "source", shareFeedContent0.getMediaSource());
        Utility.putNonEmptyString(bundle0, "name", shareFeedContent0.getLinkName());
        Utility.putNonEmptyString(bundle0, "caption", shareFeedContent0.getLinkCaption());
        Utility.putNonEmptyString(bundle0, "description", shareFeedContent0.getLinkDescription());
        return bundle0;
    }

    @SuppressLint({"DeprecatedMethod"})
    @NotNull
    public static final Bundle createForFeed(@NotNull ShareLinkContent shareLinkContent0) {
        q.g(shareLinkContent0, "shareLinkContent");
        Bundle bundle0 = new Bundle();
        Utility.putNonEmptyString(bundle0, "link", Utility.getUriString(shareLinkContent0.getContentUrl()));
        Utility.putNonEmptyString(bundle0, "quote", shareLinkContent0.getQuote());
        ShareHashtag shareHashtag0 = shareLinkContent0.getShareHashtag();
        Utility.putNonEmptyString(bundle0, "hashtag", (shareHashtag0 == null ? null : shareHashtag0.getHashtag()));
        return bundle0;
    }
}


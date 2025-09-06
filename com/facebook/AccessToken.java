package com.facebook;

import U4.x;
import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable.Creator;
import android.os.Parcelable;
import android.text.TextUtils;
import com.facebook.internal.Utility.GraphMeRequestWithCacheCallback;
import com.facebook.internal.Utility;
import com.facebook.internal.Validate;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Date;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import je.w;
import k8.Y;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.q;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

@Metadata(d1 = {"\u0000h\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000E\n\u0002\b\u0003\n\u0002\u0010\u001E\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000B\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0010\"\n\u0002\b\u001A\u0018\u0000 N2\u00020\u0001:\u0003OPNB\u008B\u0001\b\u0017\u0012\u0006\u0010\u0003\u001A\u00020\u0002\u0012\u0006\u0010\u0004\u001A\u00020\u0002\u0012\u0006\u0010\u0005\u001A\u00020\u0002\u0012\u0010\u0010\u0007\u001A\f\u0012\u0006\u0012\u0004\u0018\u00010\u0002\u0018\u00010\u0006\u0012\u0010\u0010\b\u001A\f\u0012\u0006\u0012\u0004\u0018\u00010\u0002\u0018\u00010\u0006\u0012\u0010\u0010\t\u001A\f\u0012\u0006\u0012\u0004\u0018\u00010\u0002\u0018\u00010\u0006\u0012\b\u0010\u000B\u001A\u0004\u0018\u00010\n\u0012\b\u0010\r\u001A\u0004\u0018\u00010\f\u0012\b\u0010\u000E\u001A\u0004\u0018\u00010\f\u0012\b\u0010\u000F\u001A\u0004\u0018\u00010\f\u0012\n\b\u0002\u0010\u0010\u001A\u0004\u0018\u00010\u0002\u00A2\u0006\u0004\b\u0011\u0010\u0012B\u0011\b\u0010\u0012\u0006\u0010\u0014\u001A\u00020\u0013\u00A2\u0006\u0004\b\u0011\u0010\u0015J\u000F\u0010\u0016\u001A\u00020\u0002H\u0016\u00A2\u0006\u0004\b\u0016\u0010\u0017J\u001A\u0010\u001B\u001A\u00020\u001A2\b\u0010\u0019\u001A\u0004\u0018\u00010\u0018H\u0096\u0002\u00A2\u0006\u0004\b\u001B\u0010\u001CJ\u000F\u0010\u001E\u001A\u00020\u001DH\u0016\u00A2\u0006\u0004\b\u001E\u0010\u001FJ\u000F\u0010#\u001A\u00020 H\u0000\u00A2\u0006\u0004\b!\u0010\"J\u000F\u0010$\u001A\u00020\u001DH\u0016\u00A2\u0006\u0004\b$\u0010\u001FJ\u001F\u0010(\u001A\u00020\'2\u0006\u0010%\u001A\u00020\u00132\u0006\u0010&\u001A\u00020\u001DH\u0016\u00A2\u0006\u0004\b(\u0010)J\u000F\u0010*\u001A\u00020\u0002H\u0002\u00A2\u0006\u0004\b*\u0010\u0017J\u001B\u0010.\u001A\u00020\'2\n\u0010-\u001A\u00060+j\u0002`,H\u0002\u00A2\u0006\u0004\b.\u0010/J!\u00101\u001A\u00020\n2\u0006\u00100\u001A\u00020\n2\b\u0010\u0010\u001A\u0004\u0018\u00010\u0002H\u0002\u00A2\u0006\u0004\b1\u00102R\u0017\u00103\u001A\u00020\f8\u0006\u00A2\u0006\f\n\u0004\b3\u00104\u001A\u0004\b5\u00106R\u001F\u0010\u0007\u001A\n\u0012\u0006\u0012\u0004\u0018\u00010\u0002078\u0006\u00A2\u0006\f\n\u0004\b\u0007\u00108\u001A\u0004\b9\u0010:R\u001F\u0010\b\u001A\n\u0012\u0006\u0012\u0004\u0018\u00010\u0002078\u0006\u00A2\u0006\f\n\u0004\b\b\u00108\u001A\u0004\b;\u0010:R\u001F\u0010\t\u001A\n\u0012\u0006\u0012\u0004\u0018\u00010\u0002078\u0006\u00A2\u0006\f\n\u0004\b\t\u00108\u001A\u0004\b<\u0010:R\u0017\u0010=\u001A\u00020\u00028\u0006\u00A2\u0006\f\n\u0004\b=\u0010>\u001A\u0004\b?\u0010\u0017R\u0017\u0010@\u001A\u00020\n8\u0006\u00A2\u0006\f\n\u0004\b@\u0010A\u001A\u0004\bB\u0010CR\u0017\u0010D\u001A\u00020\f8\u0006\u00A2\u0006\f\n\u0004\bD\u00104\u001A\u0004\bE\u00106R\u0017\u0010\u0004\u001A\u00020\u00028\u0006\u00A2\u0006\f\n\u0004\b\u0004\u0010>\u001A\u0004\bF\u0010\u0017R\u0017\u0010\u0005\u001A\u00020\u00028\u0006\u00A2\u0006\f\n\u0004\b\u0005\u0010>\u001A\u0004\bG\u0010\u0017R\u0017\u0010\u000F\u001A\u00020\f8\u0006\u00A2\u0006\f\n\u0004\b\u000F\u00104\u001A\u0004\bH\u00106R\u0019\u0010\u0010\u001A\u0004\u0018\u00010\u00028\u0006\u00A2\u0006\f\n\u0004\b\u0010\u0010>\u001A\u0004\bI\u0010\u0017R\u0011\u0010J\u001A\u00020\u001A8F\u00A2\u0006\u0006\u001A\u0004\bJ\u0010KR\u0011\u0010L\u001A\u00020\u001A8F\u00A2\u0006\u0006\u001A\u0004\bL\u0010KR\u0011\u0010M\u001A\u00020\u001A8F\u00A2\u0006\u0006\u001A\u0004\bM\u0010K\u00A8\u0006Q"}, d2 = {"Lcom/facebook/AccessToken;", "Landroid/os/Parcelable;", "", "accessToken", "applicationId", "userId", "", "permissions", "declinedPermissions", "expiredPermissions", "Lcom/facebook/AccessTokenSource;", "accessTokenSource", "Ljava/util/Date;", "expirationTime", "lastRefreshTime", "dataAccessExpirationTime", "graphDomain", "<init>", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/util/Collection;Ljava/util/Collection;Ljava/util/Collection;Lcom/facebook/AccessTokenSource;Ljava/util/Date;Ljava/util/Date;Ljava/util/Date;Ljava/lang/String;)V", "Landroid/os/Parcel;", "parcel", "(Landroid/os/Parcel;)V", "toString", "()Ljava/lang/String;", "", "other", "", "equals", "(Ljava/lang/Object;)Z", "", "hashCode", "()I", "Lorg/json/JSONObject;", "toJSONObject$facebook_core_release", "()Lorg/json/JSONObject;", "toJSONObject", "describeContents", "dest", "flags", "Lie/H;", "writeToParcel", "(Landroid/os/Parcel;I)V", "tokenToString", "Ljava/lang/StringBuilder;", "Lkotlin/text/StringBuilder;", "builder", "appendPermissions", "(Ljava/lang/StringBuilder;)V", "tokenSource", "convertTokenSourceForGraphDomain", "(Lcom/facebook/AccessTokenSource;Ljava/lang/String;)Lcom/facebook/AccessTokenSource;", "expires", "Ljava/util/Date;", "getExpires", "()Ljava/util/Date;", "", "Ljava/util/Set;", "getPermissions", "()Ljava/util/Set;", "getDeclinedPermissions", "getExpiredPermissions", "token", "Ljava/lang/String;", "getToken", "source", "Lcom/facebook/AccessTokenSource;", "getSource", "()Lcom/facebook/AccessTokenSource;", "lastRefresh", "getLastRefresh", "getApplicationId", "getUserId", "getDataAccessExpirationTime", "getGraphDomain", "isExpired", "()Z", "isDataAccessExpired", "isInstagramToken", "Companion", "AccessTokenCreationCallback", "AccessTokenRefreshCallback", "facebook-core_release"}, k = 1, mv = {1, 8, 0}, xi = 0x30)
public final class AccessToken implements Parcelable {
    @Metadata(d1 = {"\u0000\u001E\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\bf\u0018\u00002\u00020\u0001J\u0019\u0010\u0005\u001A\u00020\u00042\b\u0010\u0003\u001A\u0004\u0018\u00010\u0002H&¢\u0006\u0004\b\u0005\u0010\u0006J\u0019\u0010\t\u001A\u00020\u00042\b\u0010\b\u001A\u0004\u0018\u00010\u0007H&¢\u0006\u0004\b\t\u0010\n¨\u0006\u000B"}, d2 = {"Lcom/facebook/AccessToken$AccessTokenCreationCallback;", "", "Lcom/facebook/AccessToken;", "token", "Lie/H;", "onSuccess", "(Lcom/facebook/AccessToken;)V", "Lcom/facebook/FacebookException;", "error", "onError", "(Lcom/facebook/FacebookException;)V", "facebook-core_release"}, k = 1, mv = {1, 8, 0}, xi = 0x30)
    public interface AccessTokenCreationCallback {
        void onError(@Nullable FacebookException arg1);

        void onSuccess(@Nullable AccessToken arg1);
    }

    @Metadata(d1 = {"\u0000\u001E\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\bf\u0018\u00002\u00020\u0001J\u0019\u0010\u0005\u001A\u00020\u00042\b\u0010\u0003\u001A\u0004\u0018\u00010\u0002H&¢\u0006\u0004\b\u0005\u0010\u0006J\u0019\u0010\t\u001A\u00020\u00042\b\u0010\b\u001A\u0004\u0018\u00010\u0007H&¢\u0006\u0004\b\t\u0010\n¨\u0006\u000B"}, d2 = {"Lcom/facebook/AccessToken$AccessTokenRefreshCallback;", "", "Lcom/facebook/AccessToken;", "accessToken", "Lie/H;", "OnTokenRefreshed", "(Lcom/facebook/AccessToken;)V", "Lcom/facebook/FacebookException;", "exception", "OnTokenRefreshFailed", "(Lcom/facebook/FacebookException;)V", "facebook-core_release"}, k = 1, mv = {1, 8, 0}, xi = 0x30)
    public interface AccessTokenRefreshCallback {
        void OnTokenRefreshFailed(@Nullable FacebookException arg1);

        void OnTokenRefreshed(@Nullable AccessToken arg1);
    }

    @Metadata(d1 = {"\u0000p\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0010\u000E\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000B\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0011\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0016\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002\u00A2\u0006\u0004\b\u0002\u0010\u0003JC\u0010\u000F\u001A\u0004\u0018\u00010\u000E2\u0010\u0010\u0006\u001A\f\u0012\u0006\u0012\u0004\u0018\u00010\u0005\u0018\u00010\u00042\u0006\u0010\b\u001A\u00020\u00072\u0006\u0010\n\u001A\u00020\t2\u0006\u0010\f\u001A\u00020\u000B2\u0006\u0010\r\u001A\u00020\u0005H\u0002\u00A2\u0006\u0004\b\u000F\u0010\u0010J\u0011\u0010\u0011\u001A\u0004\u0018\u00010\u000EH\u0007\u00A2\u0006\u0004\b\u0011\u0010\u0012J\u0019\u0010\u0015\u001A\u00020\u00142\b\u0010\u0013\u001A\u0004\u0018\u00010\u000EH\u0007\u00A2\u0006\u0004\b\u0015\u0010\u0016J\u000F\u0010\u0018\u001A\u00020\u0017H\u0007\u00A2\u0006\u0004\b\u0018\u0010\u0019J\u000F\u0010\u001A\u001A\u00020\u0017H\u0007\u00A2\u0006\u0004\b\u001A\u0010\u0019J\u000F\u0010\u001B\u001A\u00020\u0017H\u0007\u00A2\u0006\u0004\b\u001B\u0010\u0019J\u000F\u0010\u001C\u001A\u00020\u0014H\u0007\u00A2\u0006\u0004\b\u001C\u0010\u0003J\u000F\u0010\u001D\u001A\u00020\u0014H\u0007\u00A2\u0006\u0004\b\u001D\u0010\u0003J\u0019\u0010\u001D\u001A\u00020\u00142\b\u0010\u001F\u001A\u0004\u0018\u00010\u001EH\u0007\u00A2\u0006\u0004\b\u001D\u0010 J\'\u0010%\u001A\u00020\u00142\u0006\u0010\"\u001A\u00020!2\u0006\u0010\r\u001A\u00020\u00052\u0006\u0010$\u001A\u00020#H\u0007\u00A2\u0006\u0004\b%\u0010&J!\u0010*\u001A\u0004\u0018\u00010\u000E2\u0006\u0010\'\u001A\u00020\u000E2\u0006\u0010\b\u001A\u00020\u0007H\u0001\u00A2\u0006\u0004\b(\u0010)J\u0017\u0010-\u001A\u00020\u000E2\u0006\u0010\'\u001A\u00020\u000EH\u0000\u00A2\u0006\u0004\b+\u0010,J\u0019\u00100\u001A\u0004\u0018\u00010\u000E2\u0006\u0010\b\u001A\u00020\u0007H\u0001\u00A2\u0006\u0004\b.\u0010/J)\u00104\u001A\n\u0012\u0006\u0012\u0004\u0018\u00010\u00050\u00042\u0006\u0010\b\u001A\u00020\u00072\b\u00101\u001A\u0004\u0018\u00010\u0005H\u0001\u00A2\u0006\u0004\b2\u00103J\u0017\u00109\u001A\u00020\u000E2\u0006\u00106\u001A\u000205H\u0001\u00A2\u0006\u0004\b7\u00108R\u0014\u0010:\u001A\u00020\u00058\u0006X\u0086T\u00A2\u0006\u0006\n\u0004\b:\u0010;R\u0014\u0010<\u001A\u00020\u00058\u0002X\u0082T\u00A2\u0006\u0006\n\u0004\b<\u0010;R\u001A\u0010>\u001A\b\u0012\u0004\u0012\u00020\u000E0=8\u0006X\u0087\u0004\u00A2\u0006\u0006\n\u0004\b>\u0010?R\u0014\u0010A\u001A\u00020@8\u0002X\u0082T\u00A2\u0006\u0006\n\u0004\bA\u0010BR\u0014\u0010C\u001A\u00020\u00058\u0006X\u0086T\u00A2\u0006\u0006\n\u0004\bC\u0010;R\u0014\u0010D\u001A\u00020\u00058\u0002X\u0082T\u00A2\u0006\u0006\n\u0004\bD\u0010;R\u0014\u0010E\u001A\u00020\t8\u0002X\u0082\u0004\u00A2\u0006\u0006\n\u0004\bE\u0010FR\u0014\u0010G\u001A\u00020\u000B8\u0002X\u0082\u0004\u00A2\u0006\u0006\n\u0004\bG\u0010HR\u0014\u0010I\u001A\u00020\u00058\u0006X\u0086T\u00A2\u0006\u0006\n\u0004\bI\u0010;R\u0014\u0010J\u001A\u00020\u000B8\u0002X\u0082\u0004\u00A2\u0006\u0006\n\u0004\bJ\u0010HR\u0014\u0010K\u001A\u00020\u00058\u0002X\u0082T\u00A2\u0006\u0006\n\u0004\bK\u0010;R\u0014\u0010L\u001A\u00020\u00058\u0002X\u0082T\u00A2\u0006\u0006\n\u0004\bL\u0010;R\u0014\u0010M\u001A\u00020\u00058\u0006X\u0086T\u00A2\u0006\u0006\n\u0004\bM\u0010;R\u0014\u0010N\u001A\u00020\u00058\u0006X\u0086T\u00A2\u0006\u0006\n\u0004\bN\u0010;R\u0014\u0010O\u001A\u00020\u00058\u0002X\u0082T\u00A2\u0006\u0006\n\u0004\bO\u0010;R\u0014\u0010P\u001A\u00020\u000B8\u0002X\u0082\u0004\u00A2\u0006\u0006\n\u0004\bP\u0010HR\u0014\u0010Q\u001A\u00020\u00058\u0002X\u0082T\u00A2\u0006\u0006\n\u0004\bQ\u0010;R\u0014\u0010R\u001A\u00020\u00058\u0002X\u0082T\u00A2\u0006\u0006\n\u0004\bR\u0010;R\u0014\u0010S\u001A\u00020\u00058\u0002X\u0082T\u00A2\u0006\u0006\n\u0004\bS\u0010;R\u0014\u0010T\u001A\u00020\u00058\u0006X\u0086T\u00A2\u0006\u0006\n\u0004\bT\u0010;R\u0014\u0010U\u001A\u00020\u00058\u0002X\u0082T\u00A2\u0006\u0006\n\u0004\bU\u0010;\u00A8\u0006V"}, d2 = {"Lcom/facebook/AccessToken$Companion;", "", "<init>", "()V", "", "", "requestedPermissions", "Landroid/os/Bundle;", "bundle", "Lcom/facebook/AccessTokenSource;", "source", "Ljava/util/Date;", "expirationBase", "applicationId", "Lcom/facebook/AccessToken;", "createFromBundle", "(Ljava/util/List;Landroid/os/Bundle;Lcom/facebook/AccessTokenSource;Ljava/util/Date;Ljava/lang/String;)Lcom/facebook/AccessToken;", "getCurrentAccessToken", "()Lcom/facebook/AccessToken;", "accessToken", "Lie/H;", "setCurrentAccessToken", "(Lcom/facebook/AccessToken;)V", "", "isCurrentAccessTokenActive", "()Z", "isDataAccessActive", "isLoggedInWithInstagram", "expireCurrentAccessToken", "refreshCurrentAccessTokenAsync", "Lcom/facebook/AccessToken$AccessTokenRefreshCallback;", "callback", "(Lcom/facebook/AccessToken$AccessTokenRefreshCallback;)V", "Landroid/content/Intent;", "intent", "Lcom/facebook/AccessToken$AccessTokenCreationCallback;", "accessTokenCallback", "createFromNativeLinkingIntent", "(Landroid/content/Intent;Ljava/lang/String;Lcom/facebook/AccessToken$AccessTokenCreationCallback;)V", "current", "createFromRefresh$facebook_core_release", "(Lcom/facebook/AccessToken;Landroid/os/Bundle;)Lcom/facebook/AccessToken;", "createFromRefresh", "createExpired$facebook_core_release", "(Lcom/facebook/AccessToken;)Lcom/facebook/AccessToken;", "createExpired", "createFromLegacyCache$facebook_core_release", "(Landroid/os/Bundle;)Lcom/facebook/AccessToken;", "createFromLegacyCache", "key", "getPermissionsFromBundle$facebook_core_release", "(Landroid/os/Bundle;Ljava/lang/String;)Ljava/util/List;", "getPermissionsFromBundle", "Lorg/json/JSONObject;", "jsonObject", "createFromJSONObject$facebook_core_release", "(Lorg/json/JSONObject;)Lcom/facebook/AccessToken;", "createFromJSONObject", "ACCESS_TOKEN_KEY", "Ljava/lang/String;", "APPLICATION_ID_KEY", "Landroid/os/Parcelable$Creator;", "CREATOR", "Landroid/os/Parcelable$Creator;", "", "CURRENT_JSON_FORMAT", "I", "DATA_ACCESS_EXPIRATION_TIME", "DECLINED_PERMISSIONS_KEY", "DEFAULT_ACCESS_TOKEN_SOURCE", "Lcom/facebook/AccessTokenSource;", "DEFAULT_EXPIRATION_TIME", "Ljava/util/Date;", "DEFAULT_GRAPH_DOMAIN", "DEFAULT_LAST_REFRESH_TIME", "EXPIRED_PERMISSIONS_KEY", "EXPIRES_AT_KEY", "EXPIRES_IN_KEY", "GRAPH_DOMAIN", "LAST_REFRESH_KEY", "MAX_DATE", "PERMISSIONS_KEY", "SOURCE_KEY", "TOKEN_KEY", "USER_ID_KEY", "VERSION_KEY", "facebook-core_release"}, k = 1, mv = {1, 8, 0}, xi = 0x30)
    public static final class Companion {
        private Companion() {
        }

        public Companion(DefaultConstructorMarker defaultConstructorMarker0) {
        }

        @NotNull
        public final AccessToken createExpired$facebook_core_release(@NotNull AccessToken accessToken0) {
            q.g(accessToken0, "current");
            return new AccessToken(accessToken0.getToken(), accessToken0.getApplicationId(), accessToken0.getUserId(), accessToken0.getPermissions(), accessToken0.getDeclinedPermissions(), accessToken0.getExpiredPermissions(), accessToken0.getSource(), new Date(), new Date(), accessToken0.getDataAccessExpirationTime(), null, 0x400, null);
        }

        private final AccessToken createFromBundle(List list0, Bundle bundle0, AccessTokenSource accessTokenSource0, Date date0, String s) {
            String s1 = bundle0.getString("access_token");
            if(s1 == null) {
                return null;
            }
            Date date1 = Utility.getBundleLongAsDate(bundle0, "expires_in", date0);
            if(date1 == null) {
                return null;
            }
            String s2 = bundle0.getString("user_id");
            if(s2 == null) {
                return null;
            }
            Date date2 = Utility.getBundleLongAsDate(bundle0, "data_access_expiration_time", new Date(0L));
            return new AccessToken(s1, s, s2, list0, null, null, accessTokenSource0, date1, new Date(), date2, null, 0x400, null);
        }

        @NotNull
        public final AccessToken createFromJSONObject$facebook_core_release(@NotNull JSONObject jSONObject0) {
            q.g(jSONObject0, "jsonObject");
            if(jSONObject0.getInt("version") > 1) {
                throw new FacebookException("Unknown AccessToken serialization format.");
            }
            String s = jSONObject0.getString("token");
            Date date0 = new Date(jSONObject0.getLong("expires_at"));
            JSONArray jSONArray0 = jSONObject0.getJSONArray("permissions");
            JSONArray jSONArray1 = jSONObject0.getJSONArray("declined_permissions");
            JSONArray jSONArray2 = jSONObject0.optJSONArray("expired_permissions");
            Date date1 = new Date(jSONObject0.getLong("last_refresh"));
            String s1 = jSONObject0.getString("source");
            q.f(s1, "jsonObject.getString(SOURCE_KEY)");
            AccessTokenSource accessTokenSource0 = AccessTokenSource.valueOf(s1);
            String s2 = jSONObject0.getString("application_id");
            String s3 = jSONObject0.getString("user_id");
            Date date2 = new Date(jSONObject0.optLong("data_access_expiration_time", 0L));
            String s4 = jSONObject0.optString("graph_domain", null);
            q.f(s, "token");
            q.f(s2, "applicationId");
            q.f(s3, "userId");
            q.f(jSONArray0, "permissionsArray");
            Collection collection0 = Utility.jsonArrayToStringList(jSONArray0);
            q.f(jSONArray1, "declinedPermissionsArray");
            Collection collection1 = Utility.jsonArrayToStringList(jSONArray1);
            return jSONArray2 == null ? new AccessToken(s, s2, s3, collection0, collection1, new ArrayList(), accessTokenSource0, date0, date1, date2, s4) : new AccessToken(s, s2, s3, collection0, collection1, Utility.jsonArrayToStringList(jSONArray2), accessTokenSource0, date0, date1, date2, s4);
        }

        @Nullable
        public final AccessToken createFromLegacyCache$facebook_core_release(@NotNull Bundle bundle0) {
            String s2;
            q.g(bundle0, "bundle");
            List list0 = this.getPermissionsFromBundle$facebook_core_release(bundle0, "com.facebook.TokenCachingStrategy.Permissions");
            List list1 = this.getPermissionsFromBundle$facebook_core_release(bundle0, "com.facebook.TokenCachingStrategy.DeclinedPermissions");
            List list2 = this.getPermissionsFromBundle$facebook_core_release(bundle0, "com.facebook.TokenCachingStrategy.ExpiredPermissions");
            com.facebook.LegacyTokenHelper.Companion legacyTokenHelper$Companion0 = LegacyTokenHelper.Companion;
            String s = legacyTokenHelper$Companion0.getApplicationId(bundle0);
            if(Utility.isNullOrEmpty(s)) {
                s = FacebookSdk.getApplicationId();
            }
            String s1 = legacyTokenHelper$Companion0.getToken(bundle0);
            if(s1 == null) {
                return null;
            }
            JSONObject jSONObject0 = Utility.awaitGetGraphMeRequestWithCache(s1);
            if(jSONObject0 == null) {
                s2 = null;
            }
            else {
                try {
                    s2 = jSONObject0.getString("id");
                }
                catch(JSONException unused_ex) {
                    return null;
                }
            }
            if(s == null) {
                return null;
            }
            return s2 == null ? null : new AccessToken(s1, s, s2, list0, list1, list2, legacyTokenHelper$Companion0.getSource(bundle0), legacyTokenHelper$Companion0.getExpirationDate(bundle0), legacyTokenHelper$Companion0.getLastRefreshDate(bundle0), null, null, 0x400, null);
        }

        public final void createFromNativeLinkingIntent(@NotNull Intent intent0, @NotNull String s, @NotNull AccessTokenCreationCallback accessToken$AccessTokenCreationCallback0) {
            q.g(intent0, "intent");
            q.g(s, "applicationId");
            q.g(accessToken$AccessTokenCreationCallback0, "accessTokenCallback");
            if(intent0.getExtras() == null) {
                accessToken$AccessTokenCreationCallback0.onError(new FacebookException("No extras found on intent"));
                return;
            }
            Bundle bundle0 = new Bundle(intent0.getExtras());
            String s1 = bundle0.getString("access_token");
            if(s1 != null && s1.length() != 0) {
                String s2 = bundle0.getString("user_id");
                if(s2 == null || s2.length() == 0) {
                    Utility.getGraphMeRequestWithCacheAsync(s1, new GraphMeRequestWithCacheCallback() {
                        @Override  // com.facebook.internal.Utility$GraphMeRequestWithCacheCallback
                        public void onFailure(@Nullable FacebookException facebookException0) {
                            s.onError(facebookException0);
                        }

                        @Override  // com.facebook.internal.Utility$GraphMeRequestWithCacheCallback
                        public void onSuccess(@Nullable JSONObject jSONObject0) {
                            try {
                                String s = jSONObject0 == null ? null : jSONObject0.getString("id");
                                if(s != null) {
                                    accessToken$AccessTokenCreationCallback0.putString("user_id", s);
                                    Date date0 = new Date();
                                    AccessToken accessToken0 = AccessToken.Companion.createFromBundle(null, accessToken$AccessTokenCreationCallback0, AccessTokenSource.FACEBOOK_APPLICATION_WEB, date0, this.$applicationId);
                                    s.onSuccess(accessToken0);
                                    return;
                                }
                            }
                            catch(Exception unused_ex) {
                            }
                            FacebookException facebookException0 = new FacebookException("Unable to generate access token due to missing user id");
                            s.onError(facebookException0);
                        }
                    });
                    return;
                }
                Date date0 = new Date();
                accessToken$AccessTokenCreationCallback0.onSuccess(this.createFromBundle(null, bundle0, AccessTokenSource.FACEBOOK_APPLICATION_WEB, date0, s));
                return;
            }
            accessToken$AccessTokenCreationCallback0.onError(new FacebookException("No access token found on intent"));
        }

        @SuppressLint({"FieldGetter"})
        @Nullable
        public final AccessToken createFromRefresh$facebook_core_release(@NotNull AccessToken accessToken0, @NotNull Bundle bundle0) {
            q.g(accessToken0, "current");
            q.g(bundle0, "bundle");
            if(accessToken0.getSource() != AccessTokenSource.FACEBOOK_APPLICATION_WEB && accessToken0.getSource() != AccessTokenSource.FACEBOOK_APPLICATION_NATIVE && accessToken0.getSource() != AccessTokenSource.FACEBOOK_APPLICATION_SERVICE) {
                throw new FacebookException("Invalid token source: " + accessToken0.getSource());
            }
            Date date0 = Utility.getBundleLongAsDate(bundle0, "expires_in", new Date(0L));
            String s = bundle0.getString("access_token");
            if(s == null) {
                return null;
            }
            String s1 = bundle0.getString("graph_domain");
            Date date1 = Utility.getBundleLongAsDate(bundle0, "data_access_expiration_time", new Date(0L));
            return Utility.isNullOrEmpty(s) ? null : new AccessToken(s, accessToken0.getApplicationId(), accessToken0.getUserId(), accessToken0.getPermissions(), accessToken0.getDeclinedPermissions(), accessToken0.getExpiredPermissions(), accessToken0.getSource(), date0, new Date(), date1, s1);
        }

        public final void expireCurrentAccessToken() {
            AccessToken accessToken0 = AccessTokenManager.Companion.getInstance().getCurrentAccessToken();
            if(accessToken0 != null) {
                this.setCurrentAccessToken(this.createExpired$facebook_core_release(accessToken0));
            }
        }

        @Nullable
        public final AccessToken getCurrentAccessToken() {
            return AccessTokenManager.Companion.getInstance().getCurrentAccessToken();
        }

        @NotNull
        public final List getPermissionsFromBundle$facebook_core_release(@NotNull Bundle bundle0, @Nullable String s) {
            q.g(bundle0, "bundle");
            ArrayList arrayList0 = bundle0.getStringArrayList(s);
            if(arrayList0 == null) {
                return w.a;
            }
            List list0 = Collections.unmodifiableList(new ArrayList(arrayList0));
            q.f(list0, "{\n            Collection…Permissions))\n          }");
            return list0;
        }

        public final boolean isCurrentAccessTokenActive() {
            AccessToken accessToken0 = AccessTokenManager.Companion.getInstance().getCurrentAccessToken();
            return accessToken0 != null && !accessToken0.isExpired();
        }

        public final boolean isDataAccessActive() {
            AccessToken accessToken0 = AccessTokenManager.Companion.getInstance().getCurrentAccessToken();
            return accessToken0 != null && !accessToken0.isDataAccessExpired();
        }

        public final boolean isLoggedInWithInstagram() {
            AccessToken accessToken0 = AccessTokenManager.Companion.getInstance().getCurrentAccessToken();
            return accessToken0 != null && !accessToken0.isExpired() && accessToken0.isInstagramToken();
        }

        public final void refreshCurrentAccessTokenAsync() {
            AccessTokenManager.Companion.getInstance().refreshCurrentAccessToken(null);
        }

        public final void refreshCurrentAccessTokenAsync(@Nullable AccessTokenRefreshCallback accessToken$AccessTokenRefreshCallback0) {
            AccessTokenManager.Companion.getInstance().refreshCurrentAccessToken(accessToken$AccessTokenRefreshCallback0);
        }

        public final void setCurrentAccessToken(@Nullable AccessToken accessToken0) {
            AccessTokenManager.Companion.getInstance().setCurrentAccessToken(accessToken0);
        }
    }

    @Metadata(k = 3, mv = {1, 8, 0}, xi = 0x30)
    public final class WhenMappings {
        public static final int[] $EnumSwitchMapping$0;

        static {
            int[] arr_v = new int[AccessTokenSource.values().length];
            try {
                arr_v[AccessTokenSource.FACEBOOK_APPLICATION_WEB.ordinal()] = 1;
            }
            catch(NoSuchFieldError unused_ex) {
            }
            try {
                arr_v[AccessTokenSource.CHROME_CUSTOM_TAB.ordinal()] = 2;
            }
            catch(NoSuchFieldError unused_ex) {
            }
            try {
                arr_v[AccessTokenSource.WEB_VIEW.ordinal()] = 3;
            }
            catch(NoSuchFieldError unused_ex) {
            }
            WhenMappings.$EnumSwitchMapping$0 = arr_v;
        }
    }

    @NotNull
    public static final String ACCESS_TOKEN_KEY = "access_token";
    @NotNull
    private static final String APPLICATION_ID_KEY = "application_id";
    @NotNull
    public static final Parcelable.Creator CREATOR = null;
    private static final int CURRENT_JSON_FORMAT = 1;
    @NotNull
    public static final Companion Companion = null;
    @NotNull
    public static final String DATA_ACCESS_EXPIRATION_TIME = "data_access_expiration_time";
    @NotNull
    private static final String DECLINED_PERMISSIONS_KEY = "declined_permissions";
    @NotNull
    private static final AccessTokenSource DEFAULT_ACCESS_TOKEN_SOURCE = null;
    @NotNull
    private static final Date DEFAULT_EXPIRATION_TIME = null;
    @NotNull
    public static final String DEFAULT_GRAPH_DOMAIN = "facebook";
    @NotNull
    private static final Date DEFAULT_LAST_REFRESH_TIME = null;
    @NotNull
    private static final String EXPIRED_PERMISSIONS_KEY = "expired_permissions";
    @NotNull
    private static final String EXPIRES_AT_KEY = "expires_at";
    @NotNull
    public static final String EXPIRES_IN_KEY = "expires_in";
    @NotNull
    public static final String GRAPH_DOMAIN = "graph_domain";
    @NotNull
    private static final String LAST_REFRESH_KEY = "last_refresh";
    @NotNull
    private static final Date MAX_DATE = null;
    @NotNull
    private static final String PERMISSIONS_KEY = "permissions";
    @NotNull
    private static final String SOURCE_KEY = "source";
    @NotNull
    private static final String TOKEN_KEY = "token";
    @NotNull
    public static final String USER_ID_KEY = "user_id";
    @NotNull
    private static final String VERSION_KEY = "version";
    @NotNull
    private final String applicationId;
    @NotNull
    private final Date dataAccessExpirationTime;
    @NotNull
    private final Set declinedPermissions;
    @NotNull
    private final Set expiredPermissions;
    @NotNull
    private final Date expires;
    @Nullable
    private final String graphDomain;
    @NotNull
    private final Date lastRefresh;
    @NotNull
    private final Set permissions;
    @NotNull
    private final AccessTokenSource source;
    @NotNull
    private final String token;
    @NotNull
    private final String userId;

    static {
        AccessToken.Companion = new Companion(null);
        Date date0 = new Date(0x7FFFFFFFFFFFFFFFL);
        AccessToken.MAX_DATE = date0;
        AccessToken.DEFAULT_EXPIRATION_TIME = date0;
        AccessToken.DEFAULT_LAST_REFRESH_TIME = new Date();
        AccessToken.DEFAULT_ACCESS_TOKEN_SOURCE = AccessTokenSource.FACEBOOK_APPLICATION_WEB;
        AccessToken.CREATOR = new AccessToken.Companion.CREATOR.1();
    }

    public AccessToken(@NotNull Parcel parcel0) {
        q.g(parcel0, "parcel");
        super();
        this.expires = new Date(parcel0.readLong());
        ArrayList arrayList0 = new ArrayList();
        parcel0.readStringList(arrayList0);
        Set set0 = Collections.unmodifiableSet(new HashSet(arrayList0));
        q.f(set0, "unmodifiableSet(HashSet(permissionsList))");
        this.permissions = set0;
        arrayList0.clear();
        parcel0.readStringList(arrayList0);
        Set set1 = Collections.unmodifiableSet(new HashSet(arrayList0));
        q.f(set1, "unmodifiableSet(HashSet(permissionsList))");
        this.declinedPermissions = set1;
        arrayList0.clear();
        parcel0.readStringList(arrayList0);
        Set set2 = Collections.unmodifiableSet(new HashSet(arrayList0));
        q.f(set2, "unmodifiableSet(HashSet(permissionsList))");
        this.expiredPermissions = set2;
        this.token = Validate.notNullOrEmpty(parcel0.readString(), "token");
        String s = parcel0.readString();
        this.source = s == null ? AccessToken.DEFAULT_ACCESS_TOKEN_SOURCE : AccessTokenSource.valueOf(s);
        this.lastRefresh = new Date(parcel0.readLong());
        this.applicationId = Validate.notNullOrEmpty(parcel0.readString(), "applicationId");
        this.userId = Validate.notNullOrEmpty(parcel0.readString(), "userId");
        this.dataAccessExpirationTime = new Date(parcel0.readLong());
        this.graphDomain = parcel0.readString();
    }

    public AccessToken(@NotNull String s, @NotNull String s1, @NotNull String s2, @Nullable Collection collection0, @Nullable Collection collection1, @Nullable Collection collection2, @Nullable AccessTokenSource accessTokenSource0, @Nullable Date date0, @Nullable Date date1, @Nullable Date date2) {
        q.g(s, "accessToken");
        q.g(s1, "applicationId");
        q.g(s2, "userId");
        this(s, s1, s2, collection0, collection1, collection2, accessTokenSource0, date0, date1, date2, null, 0x400, null);
    }

    public AccessToken(@NotNull String s, @NotNull String s1, @NotNull String s2, @Nullable Collection collection0, @Nullable Collection collection1, @Nullable Collection collection2, @Nullable AccessTokenSource accessTokenSource0, @Nullable Date date0, @Nullable Date date1, @Nullable Date date2, @Nullable String s3) {
        q.g(s, "accessToken");
        q.g(s1, "applicationId");
        q.g(s2, "userId");
        super();
        Validate.notEmpty(s, "accessToken");
        Validate.notEmpty(s1, "applicationId");
        Validate.notEmpty(s2, "userId");
        if(date0 == null) {
            date0 = AccessToken.DEFAULT_EXPIRATION_TIME;
        }
        this.expires = date0;
        Set set0 = Collections.unmodifiableSet((collection0 == null ? new HashSet() : new HashSet(collection0)));
        q.f(set0, "unmodifiableSet(if (perm…missions) else HashSet())");
        this.permissions = set0;
        Set set1 = Collections.unmodifiableSet((collection1 == null ? new HashSet() : new HashSet(collection1)));
        q.f(set1, "unmodifiableSet(\n       …missions) else HashSet())");
        this.declinedPermissions = set1;
        Set set2 = Collections.unmodifiableSet((collection2 == null ? new HashSet() : new HashSet(collection2)));
        q.f(set2, "unmodifiableSet(\n       …missions) else HashSet())");
        this.expiredPermissions = set2;
        this.token = s;
        if(accessTokenSource0 == null) {
            accessTokenSource0 = AccessToken.DEFAULT_ACCESS_TOKEN_SOURCE;
        }
        this.source = this.convertTokenSourceForGraphDomain(accessTokenSource0, s3);
        if(date1 == null) {
            date1 = AccessToken.DEFAULT_LAST_REFRESH_TIME;
        }
        this.lastRefresh = date1;
        this.applicationId = s1;
        this.userId = s2;
        if(date2 == null || date2.getTime() == 0L) {
            date2 = AccessToken.DEFAULT_EXPIRATION_TIME;
        }
        this.dataAccessExpirationTime = date2;
        if(s3 == null) {
            s3 = "facebook";
        }
        this.graphDomain = s3;
    }

    public AccessToken(String s, String s1, String s2, Collection collection0, Collection collection1, Collection collection2, AccessTokenSource accessTokenSource0, Date date0, Date date1, Date date2, String s3, int v, DefaultConstructorMarker defaultConstructorMarker0) {
        this(s, s1, s2, collection0, collection1, collection2, accessTokenSource0, date0, date1, date2, ((v & 0x400) == 0 ? s3 : "facebook"));
    }

    private final void appendPermissions(StringBuilder stringBuilder0) {
        stringBuilder0.append(" permissions:");
        stringBuilder0.append("[");
        stringBuilder0.append(TextUtils.join(", ", this.permissions));
        stringBuilder0.append("]");
    }

    private final AccessTokenSource convertTokenSourceForGraphDomain(AccessTokenSource accessTokenSource0, String s) {
        if(s != null && s.equals("instagram")) {
            switch(WhenMappings.$EnumSwitchMapping$0[accessTokenSource0.ordinal()]) {
                case 1: {
                    return AccessTokenSource.INSTAGRAM_APPLICATION_WEB;
                }
                case 2: {
                    return AccessTokenSource.INSTAGRAM_CUSTOM_CHROME_TAB;
                }
                case 3: {
                    return AccessTokenSource.INSTAGRAM_WEB_VIEW;
                }
                default: {
                    return accessTokenSource0;
                }
            }
        }
        return accessTokenSource0;
    }

    @NotNull
    public static final AccessToken createFromJSONObject$facebook_core_release(@NotNull JSONObject jSONObject0) {
        return AccessToken.Companion.createFromJSONObject$facebook_core_release(jSONObject0);
    }

    @Nullable
    public static final AccessToken createFromLegacyCache$facebook_core_release(@NotNull Bundle bundle0) {
        return AccessToken.Companion.createFromLegacyCache$facebook_core_release(bundle0);
    }

    public static final void createFromNativeLinkingIntent(@NotNull Intent intent0, @NotNull String s, @NotNull AccessTokenCreationCallback accessToken$AccessTokenCreationCallback0) {
        AccessToken.Companion.createFromNativeLinkingIntent(intent0, s, accessToken$AccessTokenCreationCallback0);
    }

    @SuppressLint({"FieldGetter"})
    @Nullable
    public static final AccessToken createFromRefresh$facebook_core_release(@NotNull AccessToken accessToken0, @NotNull Bundle bundle0) {
        return AccessToken.Companion.createFromRefresh$facebook_core_release(accessToken0, bundle0);
    }

    @Override  // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    @Override
    public boolean equals(@Nullable Object object0) {
        if(this == object0) {
            return true;
        }
        if(!(object0 instanceof AccessToken)) {
            return false;
        }
        if(q.b(this.expires, ((AccessToken)object0).expires) && q.b(this.permissions, ((AccessToken)object0).permissions) && q.b(this.declinedPermissions, ((AccessToken)object0).declinedPermissions) && q.b(this.expiredPermissions, ((AccessToken)object0).expiredPermissions) && q.b(this.token, ((AccessToken)object0).token) && this.source == ((AccessToken)object0).source && q.b(this.lastRefresh, ((AccessToken)object0).lastRefresh) && q.b(this.applicationId, ((AccessToken)object0).applicationId) && q.b(this.userId, ((AccessToken)object0).userId) && q.b(this.dataAccessExpirationTime, ((AccessToken)object0).dataAccessExpirationTime)) {
            String s = ((AccessToken)object0).graphDomain;
            return this.graphDomain == null ? s == null : q.b(this.graphDomain, s);
        }
        return false;
    }

    public static final void expireCurrentAccessToken() {
        AccessToken.Companion.expireCurrentAccessToken();
    }

    @NotNull
    public final String getApplicationId() {
        return this.applicationId;
    }

    @Nullable
    public static final AccessToken getCurrentAccessToken() {
        return AccessToken.Companion.getCurrentAccessToken();
    }

    @NotNull
    public final Date getDataAccessExpirationTime() {
        return this.dataAccessExpirationTime;
    }

    @NotNull
    public final Set getDeclinedPermissions() {
        return this.declinedPermissions;
    }

    @NotNull
    public final Set getExpiredPermissions() {
        return this.expiredPermissions;
    }

    @NotNull
    public final Date getExpires() {
        return this.expires;
    }

    @Nullable
    public final String getGraphDomain() {
        return this.graphDomain;
    }

    @NotNull
    public final Date getLastRefresh() {
        return this.lastRefresh;
    }

    @NotNull
    public final Set getPermissions() {
        return this.permissions;
    }

    @NotNull
    public static final List getPermissionsFromBundle$facebook_core_release(@NotNull Bundle bundle0, @Nullable String s) {
        return AccessToken.Companion.getPermissionsFromBundle$facebook_core_release(bundle0, s);
    }

    @NotNull
    public final AccessTokenSource getSource() {
        return this.source;
    }

    @NotNull
    public final String getToken() {
        return this.token;
    }

    @NotNull
    public final String getUserId() {
        return this.userId;
    }

    @Override
    public int hashCode() {
        int v = x.b(x.b((this.lastRefresh.hashCode() + (this.source.hashCode() + x.b((this.expiredPermissions.hashCode() + (this.declinedPermissions.hashCode() + (this.permissions.hashCode() + (this.expires.hashCode() + 0x20F) * 0x1F) * 0x1F) * 0x1F) * 0x1F, 0x1F, this.token)) * 0x1F) * 0x1F, 0x1F, this.applicationId), 0x1F, this.userId);
        int v1 = this.dataAccessExpirationTime.hashCode();
        return this.graphDomain == null ? (v1 + v) * 0x1F : (v1 + v) * 0x1F + this.graphDomain.hashCode();
    }

    public static final boolean isCurrentAccessTokenActive() {
        return AccessToken.Companion.isCurrentAccessTokenActive();
    }

    public static final boolean isDataAccessActive() {
        return AccessToken.Companion.isDataAccessActive();
    }

    public final boolean isDataAccessExpired() {
        return new Date().after(this.dataAccessExpirationTime);
    }

    public final boolean isExpired() {
        return new Date().after(this.expires);
    }

    public final boolean isInstagramToken() {
        return this.graphDomain != null && this.graphDomain.equals("instagram");
    }

    public static final boolean isLoggedInWithInstagram() {
        return AccessToken.Companion.isLoggedInWithInstagram();
    }

    public static final void refreshCurrentAccessTokenAsync() {
        AccessToken.Companion.refreshCurrentAccessTokenAsync();
    }

    public static final void refreshCurrentAccessTokenAsync(@Nullable AccessTokenRefreshCallback accessToken$AccessTokenRefreshCallback0) {
        AccessToken.Companion.refreshCurrentAccessTokenAsync(accessToken$AccessTokenRefreshCallback0);
    }

    public static final void setCurrentAccessToken(@Nullable AccessToken accessToken0) {
        AccessToken.Companion.setCurrentAccessToken(accessToken0);
    }

    @NotNull
    public final JSONObject toJSONObject$facebook_core_release() {
        JSONObject jSONObject0 = new JSONObject();
        jSONObject0.put("version", 1);
        jSONObject0.put("token", this.token);
        jSONObject0.put("expires_at", this.expires.getTime());
        jSONObject0.put("permissions", new JSONArray(this.permissions));
        jSONObject0.put("declined_permissions", new JSONArray(this.declinedPermissions));
        jSONObject0.put("expired_permissions", new JSONArray(this.expiredPermissions));
        jSONObject0.put("last_refresh", this.lastRefresh.getTime());
        jSONObject0.put("source", this.source.name());
        jSONObject0.put("application_id", this.applicationId);
        jSONObject0.put("user_id", this.userId);
        jSONObject0.put("data_access_expiration_time", this.dataAccessExpirationTime.getTime());
        String s = this.graphDomain;
        if(s != null) {
            jSONObject0.put("graph_domain", s);
        }
        return jSONObject0;
    }

    @Override
    @NotNull
    public String toString() {
        StringBuilder stringBuilder0 = Y.p("{AccessToken token:");
        stringBuilder0.append(this.tokenToString());
        this.appendPermissions(stringBuilder0);
        stringBuilder0.append("}");
        String s = stringBuilder0.toString();
        q.f(s, "builder.toString()");
        return s;
    }

    // 去混淆评级： 低(20)
    private final String tokenToString() {
        return FacebookSdk.isLoggingBehaviorEnabled(LoggingBehavior.INCLUDE_ACCESS_TOKENS) ? this.token : "ACCESS_TOKEN_REMOVED";
    }

    @Override  // android.os.Parcelable
    public void writeToParcel(@NotNull Parcel parcel0, int v) {
        q.g(parcel0, "dest");
        parcel0.writeLong(this.expires.getTime());
        parcel0.writeStringList(new ArrayList(this.permissions));
        parcel0.writeStringList(new ArrayList(this.declinedPermissions));
        parcel0.writeStringList(new ArrayList(this.expiredPermissions));
        parcel0.writeString(this.token);
        parcel0.writeString(this.source.name());
        parcel0.writeLong(this.lastRefresh.getTime());
        parcel0.writeString(this.applicationId);
        parcel0.writeString(this.userId);
        parcel0.writeLong(this.dataAccessExpirationTime.getTime());
        parcel0.writeString(this.graphDomain);
    }
}


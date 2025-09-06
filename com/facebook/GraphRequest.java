package com.facebook;

import Tf.a;
import Tf.o;
import Tf.v;
import U4.x;
import android.content.Context;
import android.graphics.Bitmap.CompressFormat;
import android.graphics.Bitmap;
import android.location.Location;
import android.net.Uri.Builder;
import android.net.Uri;
import android.os.Bundle;
import android.os.Handler;
import android.os.Parcel;
import android.os.ParcelFileDescriptor.AutoCloseInputStream;
import android.os.ParcelFileDescriptor;
import android.os.Parcelable.Creator;
import android.os.Parcelable;
import android.text.TextUtils;
import android.util.Log;
import android.util.Pair;
import b.l;
import com.facebook.internal.AttributionIdentifiers;
import com.facebook.internal.Logger;
import com.facebook.internal.ServerProtocol;
import com.facebook.internal.Utility;
import com.facebook.internal.Validate;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.IOException;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;
import java.net.URLEncoder;
import java.security.SecureRandom;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import java.util.Map.Entry;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.zip.GZIPOutputStream;
import je.n;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.q;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

@Metadata(d1 = {"\u0000h\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000E\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000B\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0012\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010%\n\u0002\u0018\u0002\n\u0002\b\f\n\u0002\u0018\u0002\n\u0002\b9\u0018\u0000 m2\u00020\u0001:\tnompqrstuBQ\b\u0017\u0012\n\b\u0002\u0010\u0003\u001A\u0004\u0018\u00010\u0002\u0012\n\b\u0002\u0010\u0005\u001A\u0004\u0018\u00010\u0004\u0012\n\b\u0002\u0010\u0007\u001A\u0004\u0018\u00010\u0006\u0012\n\b\u0002\u0010\t\u001A\u0004\u0018\u00010\b\u0012\n\b\u0002\u0010\u000B\u001A\u0004\u0018\u00010\n\u0012\n\b\u0002\u0010\f\u001A\u0004\u0018\u00010\u0004\u00A2\u0006\u0004\b\r\u0010\u000EB\u001B\b\u0010\u0012\b\u0010\u0003\u001A\u0004\u0018\u00010\u0002\u0012\u0006\u0010\u0010\u001A\u00020\u000F\u00A2\u0006\u0004\b\r\u0010\u0011J\u0015\u0010\u0015\u001A\u00020\u00142\u0006\u0010\u0013\u001A\u00020\u0012\u00A2\u0006\u0004\b\u0015\u0010\u0016J\r\u0010\u0018\u001A\u00020\u0017\u00A2\u0006\u0004\b\u0018\u0010\u0019J\r\u0010\u001B\u001A\u00020\u001A\u00A2\u0006\u0004\b\u001B\u0010\u001CJ\u000F\u0010\u001D\u001A\u00020\u0004H\u0016\u00A2\u0006\u0004\b\u001D\u0010\u001EJ\u000F\u0010\u001F\u001A\u00020\u0014H\u0002\u00A2\u0006\u0004\b\u001F\u0010 J\u0011\u0010!\u001A\u0004\u0018\u00010\u0004H\u0002\u00A2\u0006\u0004\b!\u0010\u001EJ\u0011\u0010\"\u001A\u0004\u0018\u00010\u0004H\u0002\u00A2\u0006\u0004\b\"\u0010\u001EJ\u001F\u0010%\u001A\u00020\u00042\u0006\u0010#\u001A\u00020\u00042\u0006\u0010$\u001A\u00020\u0012H\u0002\u00A2\u0006\u0004\b%\u0010&J\u0017\u0010\'\u001A\u00020\u00042\u0006\u0010#\u001A\u00020\u0004H\u0002\u00A2\u0006\u0004\b\'\u0010(J\u000F\u0010)\u001A\u00020\u0012H\u0002\u00A2\u0006\u0004\b)\u0010*J\u000F\u0010+\u001A\u00020\u0012H\u0002\u00A2\u0006\u0004\b+\u0010*J\u000F\u0010,\u001A\u00020\u0012H\u0002\u00A2\u0006\u0004\b,\u0010*J+\u00102\u001A\u00020\u00142\u0006\u0010.\u001A\u00020-2\u0012\u00101\u001A\u000E\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u0002000/H\u0002\u00A2\u0006\u0004\b2\u00103R$\u0010\u0003\u001A\u0004\u0018\u00010\u00028\u0006@\u0006X\u0086\u000E\u00A2\u0006\u0012\n\u0004\b\u0003\u00104\u001A\u0004\b5\u00106\"\u0004\b7\u00108R$\u0010\u0005\u001A\u0004\u0018\u00010\u00048\u0006@\u0006X\u0086\u000E\u00A2\u0006\u0012\n\u0004\b\u0005\u00109\u001A\u0004\b:\u0010\u001E\"\u0004\b;\u0010<R$\u0010>\u001A\u0004\u0018\u00010=8\u0006@\u0006X\u0086\u000E\u00A2\u0006\u0012\n\u0004\b>\u0010?\u001A\u0004\b@\u0010A\"\u0004\bB\u0010CR$\u0010D\u001A\u0004\u0018\u00010\u00048\u0006@\u0006X\u0086\u000E\u00A2\u0006\u0012\n\u0004\bD\u00109\u001A\u0004\bE\u0010\u001E\"\u0004\bF\u0010<R$\u0010G\u001A\u0004\u0018\u00010\u00048\u0006@\u0006X\u0086\u000E\u00A2\u0006\u0012\n\u0004\bG\u00109\u001A\u0004\bH\u0010\u001E\"\u0004\bI\u0010<R\"\u0010J\u001A\u00020\u00128\u0006@\u0006X\u0086\u000E\u00A2\u0006\u0012\n\u0004\bJ\u0010K\u001A\u0004\bL\u0010*\"\u0004\bM\u0010\u0016R\"\u0010\u0007\u001A\u00020\u00068\u0006@\u0006X\u0086\u000E\u00A2\u0006\u0012\n\u0004\b\u0007\u0010N\u001A\u0004\bO\u0010P\"\u0004\bQ\u0010RR$\u0010S\u001A\u0004\u0018\u00010\u00018\u0006@\u0006X\u0086\u000E\u00A2\u0006\u0012\n\u0004\bS\u0010T\u001A\u0004\bU\u0010V\"\u0004\bW\u0010XR$\u0010\f\u001A\u0004\u0018\u00010\u00048\u0006@\u0006X\u0086\u000E\u00A2\u0006\u0012\n\u0004\b\f\u00109\u001A\u0004\bY\u0010\u001E\"\u0004\bZ\u0010<R.\u0010\u000B\u001A\u0004\u0018\u00010\n2\b\u0010\u000B\u001A\u0004\u0018\u00010\n8\u0006@FX\u0086\u000E\u00A2\u0006\u0012\n\u0004\b\u000B\u0010[\u001A\u0004\b\\\u0010]\"\u0004\b^\u0010_R.\u0010\t\u001A\u0004\u0018\u00010\b2\b\u0010`\u001A\u0004\u0018\u00010\b8\u0006@FX\u0086\u000E\u00A2\u0006\u0012\n\u0004\b\t\u0010a\u001A\u0004\bb\u0010c\"\u0004\bd\u0010eR\u0016\u0010f\u001A\u00020\u00128\u0002@\u0002X\u0082\u000E\u00A2\u0006\u0006\n\u0004\bf\u0010KR\u0018\u0010\u0010\u001A\u0004\u0018\u00010\u00048\u0002@\u0002X\u0082\u000E\u00A2\u0006\u0006\n\u0004\b\u0010\u00109R\u0011\u0010h\u001A\u00020\u00048F\u00A2\u0006\u0006\u001A\u0004\bg\u0010\u001ER\u0011\u0010j\u001A\u00020\u00048F\u00A2\u0006\u0006\u001A\u0004\bi\u0010\u001ER\u0016\u0010l\u001A\u0004\u0018\u00010\u00048BX\u0082\u0004\u00A2\u0006\u0006\u001A\u0004\bk\u0010\u001E\u00A8\u0006v"}, d2 = {"Lcom/facebook/GraphRequest;", "", "Lcom/facebook/AccessToken;", "accessToken", "", "graphPath", "Landroid/os/Bundle;", "parameters", "Lcom/facebook/HttpMethod;", "httpMethod", "Lcom/facebook/GraphRequest$Callback;", "callback", "version", "<init>", "(Lcom/facebook/AccessToken;Ljava/lang/String;Landroid/os/Bundle;Lcom/facebook/HttpMethod;Lcom/facebook/GraphRequest$Callback;Ljava/lang/String;)V", "Ljava/net/URL;", "overriddenURL", "(Lcom/facebook/AccessToken;Ljava/net/URL;)V", "", "forceOverride", "Lie/H;", "setForceApplicationRequest", "(Z)V", "Lcom/facebook/GraphResponse;", "executeAndWait", "()Lcom/facebook/GraphResponse;", "Lcom/facebook/GraphRequestAsyncTask;", "executeAsync", "()Lcom/facebook/GraphRequestAsyncTask;", "toString", "()Ljava/lang/String;", "addCommonParameters", "()V", "getAccessTokenToUseForRequest", "getClientTokenForRequest", "baseUrl", "isBatch", "appendParametersToBaseUrl", "(Ljava/lang/String;Z)Ljava/lang/String;", "getUrlWithGraphPath", "(Ljava/lang/String;)Ljava/lang/String;", "shouldForceClientTokenForRequest", "()Z", "isValidGraphRequestForDomain", "isApplicationRequest", "Lorg/json/JSONArray;", "batch", "", "Lcom/facebook/GraphRequest$Attachment;", "attachments", "serializeToBatch", "(Lorg/json/JSONArray;Ljava/util/Map;)V", "Lcom/facebook/AccessToken;", "getAccessToken", "()Lcom/facebook/AccessToken;", "setAccessToken", "(Lcom/facebook/AccessToken;)V", "Ljava/lang/String;", "getGraphPath", "setGraphPath", "(Ljava/lang/String;)V", "Lorg/json/JSONObject;", "graphObject", "Lorg/json/JSONObject;", "getGraphObject", "()Lorg/json/JSONObject;", "setGraphObject", "(Lorg/json/JSONObject;)V", "batchEntryName", "getBatchEntryName", "setBatchEntryName", "batchEntryDependsOn", "getBatchEntryDependsOn", "setBatchEntryDependsOn", "batchEntryOmitResultOnSuccess", "Z", "getBatchEntryOmitResultOnSuccess", "setBatchEntryOmitResultOnSuccess", "Landroid/os/Bundle;", "getParameters", "()Landroid/os/Bundle;", "setParameters", "(Landroid/os/Bundle;)V", "tag", "Ljava/lang/Object;", "getTag", "()Ljava/lang/Object;", "setTag", "(Ljava/lang/Object;)V", "getVersion", "setVersion", "Lcom/facebook/GraphRequest$Callback;", "getCallback", "()Lcom/facebook/GraphRequest$Callback;", "setCallback", "(Lcom/facebook/GraphRequest$Callback;)V", "value", "Lcom/facebook/HttpMethod;", "getHttpMethod", "()Lcom/facebook/HttpMethod;", "setHttpMethod", "(Lcom/facebook/HttpMethod;)V", "forceApplicationRequest", "getRelativeUrlForBatchedRequest", "relativeUrlForBatchedRequest", "getUrlForSingleRequest", "urlForSingleRequest", "getGraphPathWithVersion", "graphPathWithVersion", "Companion", "Attachment", "Callback", "GraphJSONArrayCallback", "GraphJSONObjectCallback", "KeyValueSerializer", "OnProgressCallback", "ParcelableResourceWithMimeType", "Serializer", "facebook-core_release"}, k = 1, mv = {1, 8, 0}, xi = 0x30)
public final class GraphRequest {
    @Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\b\u0002\u0018\u00002\u00020\u0001B\u0017\u0012\u0006\u0010\u0002\u001A\u00020\u0003\u0012\b\u0010\u0004\u001A\u0004\u0018\u00010\u0001¢\u0006\u0002\u0010\u0005R\u0011\u0010\u0002\u001A\u00020\u0003¢\u0006\b\n\u0000\u001A\u0004\b\u0006\u0010\u0007R\u0013\u0010\u0004\u001A\u0004\u0018\u00010\u0001¢\u0006\b\n\u0000\u001A\u0004\b\b\u0010\t¨\u0006\n"}, d2 = {"Lcom/facebook/GraphRequest$Attachment;", "", "request", "Lcom/facebook/GraphRequest;", "value", "(Lcom/facebook/GraphRequest;Ljava/lang/Object;)V", "getRequest", "()Lcom/facebook/GraphRequest;", "getValue", "()Ljava/lang/Object;", "facebook-core_release"}, k = 1, mv = {1, 8, 0}, xi = 0x30)
    static final class Attachment {
        @NotNull
        private final GraphRequest request;
        @Nullable
        private final Object value;

        public Attachment(@NotNull GraphRequest graphRequest0, @Nullable Object object0) {
            q.g(graphRequest0, "request");
            super();
            this.request = graphRequest0;
            this.value = object0;
        }

        @NotNull
        public final GraphRequest getRequest() {
            return this.request;
        }

        @Nullable
        public final Object getValue() {
            return this.value;
        }
    }

    @Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\bæ\u0080\u0001\u0018\u00002\u00020\u0001J\u0017\u0010\u0005\u001A\u00020\u00042\u0006\u0010\u0003\u001A\u00020\u0002H&¢\u0006\u0004\b\u0005\u0010\u0006¨\u0006\u0007"}, d2 = {"Lcom/facebook/GraphRequest$Callback;", "", "Lcom/facebook/GraphResponse;", "response", "Lie/H;", "onCompleted", "(Lcom/facebook/GraphResponse;)V", "facebook-core_release"}, k = 1, mv = {1, 8, 0}, xi = 0x30)
    public interface Callback {
        void onCompleted(@NotNull GraphResponse arg1);
    }

    @Metadata(d1 = {"\u0000\u0088\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000E\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u0011\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u001E\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\b\u000E\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000B\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010$\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010%\n\u0002\b;\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002\u00A2\u0006\u0004\b\u0002\u0010\u0003J\u0011\u0010\u0005\u001A\u0004\u0018\u00010\u0004H\u0007\u00A2\u0006\u0004\b\u0005\u0010\u0006J\u0019\u0010\t\u001A\u00020\b2\b\u0010\u0007\u001A\u0004\u0018\u00010\u0004H\u0007\u00A2\u0006\u0004\b\t\u0010\nJ-\u0010\u0011\u001A\u00020\u00102\b\u0010\f\u001A\u0004\u0018\u00010\u000B2\b\u0010\r\u001A\u0004\u0018\u00010\u00042\b\u0010\u000F\u001A\u0004\u0018\u00010\u000EH\u0007\u00A2\u0006\u0004\b\u0011\u0010\u0012J#\u0010\u0014\u001A\u00020\u00102\b\u0010\f\u001A\u0004\u0018\u00010\u000B2\b\u0010\u000F\u001A\u0004\u0018\u00010\u0013H\u0007\u00A2\u0006\u0004\b\u0014\u0010\u0015J7\u0010\u0019\u001A\u00020\u00102\b\u0010\f\u001A\u0004\u0018\u00010\u000B2\b\u0010\u0016\u001A\u0004\u0018\u00010\u00042\b\u0010\u0018\u001A\u0004\u0018\u00010\u00172\b\u0010\u000F\u001A\u0004\u0018\u00010\u000EH\u0007\u00A2\u0006\u0004\b\u0019\u0010\u001AJ7\u0010\u001D\u001A\u00020\u00102\b\u0010\f\u001A\u0004\u0018\u00010\u000B2\b\u0010\u0016\u001A\u0004\u0018\u00010\u00042\b\u0010\u001C\u001A\u0004\u0018\u00010\u001B2\b\u0010\u000F\u001A\u0004\u0018\u00010\u000EH\u0007\u00A2\u0006\u0004\b\u001D\u0010\u001EJ#\u0010 \u001A\u00020\u00102\b\u0010\f\u001A\u0004\u0018\u00010\u000B2\b\u0010\u000F\u001A\u0004\u0018\u00010\u001FH\u0007\u00A2\u0006\u0004\b \u0010!J-\u0010\"\u001A\u00020\u00102\b\u0010\f\u001A\u0004\u0018\u00010\u000B2\b\u0010\u0016\u001A\u0004\u0018\u00010\u00042\b\u0010\u000F\u001A\u0004\u0018\u00010\u000EH\u0007\u00A2\u0006\u0004\b\"\u0010\u0012JG\u0010)\u001A\u00020\u00102\b\u0010\f\u001A\u0004\u0018\u00010\u000B2\b\u0010$\u001A\u0004\u0018\u00010#2\u0006\u0010&\u001A\u00020%2\u0006\u0010\'\u001A\u00020%2\b\u0010(\u001A\u0004\u0018\u00010\u00042\b\u0010\u000F\u001A\u0004\u0018\u00010\u001FH\u0007\u00A2\u0006\u0004\b)\u0010*JI\u0010/\u001A\u00020\u00102\b\u0010\f\u001A\u0004\u0018\u00010\u000B2\b\u0010\u0016\u001A\u0004\u0018\u00010\u00042\u0006\u0010,\u001A\u00020+2\b\u0010-\u001A\u0004\u0018\u00010\u00042\b\u0010.\u001A\u0004\u0018\u00010\u001B2\b\u0010\u000F\u001A\u0004\u0018\u00010\u000EH\u0007\u00A2\u0006\u0004\b/\u00100JI\u0010/\u001A\u00020\u00102\b\u0010\f\u001A\u0004\u0018\u00010\u000B2\b\u0010\u0016\u001A\u0004\u0018\u00010\u00042\u0006\u00102\u001A\u0002012\b\u0010-\u001A\u0004\u0018\u00010\u00042\b\u0010.\u001A\u0004\u0018\u00010\u001B2\b\u0010\u000F\u001A\u0004\u0018\u00010\u000EH\u0007\u00A2\u0006\u0004\b/\u00103JI\u0010/\u001A\u00020\u00102\b\u0010\f\u001A\u0004\u0018\u00010\u000B2\b\u0010\u0016\u001A\u0004\u0018\u00010\u00042\u0006\u00105\u001A\u0002042\b\u0010-\u001A\u0004\u0018\u00010\u00042\b\u0010.\u001A\u0004\u0018\u00010\u001B2\b\u0010\u000F\u001A\u0004\u0018\u00010\u000EH\u0007\u00A2\u0006\u0004\b/\u00106J5\u00109\u001A\u00020\u00102\b\u0010\f\u001A\u0004\u0018\u00010\u000B2\u0006\u00108\u001A\u0002072\b\u0010\u0007\u001A\u0004\u0018\u00010\u00042\b\u0010\u000F\u001A\u0004\u0018\u00010\u000EH\u0007\u00A2\u0006\u0004\b9\u0010:J+\u00109\u001A\u00020\u00102\b\u0010\f\u001A\u0004\u0018\u00010\u000B2\u0006\u00108\u001A\u0002072\b\u0010\u000F\u001A\u0004\u0018\u00010\u000EH\u0007\u00A2\u0006\u0004\b9\u0010;J#\u0010?\u001A\u00020>2\u0012\u0010=\u001A\n\u0012\u0006\b\u0001\u0012\u00020\u00100<\"\u00020\u0010H\u0007\u00A2\u0006\u0004\b?\u0010@J\u001D\u0010?\u001A\u00020>2\f\u0010=\u001A\b\u0012\u0004\u0012\u00020\u00100AH\u0007\u00A2\u0006\u0004\b?\u0010BJ\u0017\u0010?\u001A\u00020>2\u0006\u0010=\u001A\u00020CH\u0007\u00A2\u0006\u0004\b?\u0010DJ\u0017\u0010G\u001A\u00020F2\u0006\u0010E\u001A\u00020\u0010H\u0007\u00A2\u0006\u0004\bG\u0010HJ)\u0010J\u001A\b\u0012\u0004\u0012\u00020F0I2\u0012\u0010=\u001A\n\u0012\u0006\b\u0001\u0012\u00020\u00100<\"\u00020\u0010H\u0007\u00A2\u0006\u0004\bJ\u0010KJ#\u0010J\u001A\b\u0012\u0004\u0012\u00020F0I2\f\u0010=\u001A\b\u0012\u0004\u0012\u00020\u00100AH\u0007\u00A2\u0006\u0004\bJ\u0010LJ\u001D\u0010J\u001A\b\u0012\u0004\u0012\u00020F0I2\u0006\u0010=\u001A\u00020CH\u0007\u00A2\u0006\u0004\bJ\u0010MJ#\u0010O\u001A\u00020N2\u0012\u0010=\u001A\n\u0012\u0006\b\u0001\u0012\u00020\u00100<\"\u00020\u0010H\u0007\u00A2\u0006\u0004\bO\u0010PJ\u001D\u0010O\u001A\u00020N2\f\u0010=\u001A\b\u0012\u0004\u0012\u00020\u00100AH\u0007\u00A2\u0006\u0004\bO\u0010QJ\u0017\u0010O\u001A\u00020N2\u0006\u0010=\u001A\u00020CH\u0007\u00A2\u0006\u0004\bO\u0010RJ+\u0010T\u001A\b\u0012\u0004\u0012\u00020F0I2\u0006\u0010S\u001A\u00020>2\f\u0010=\u001A\b\u0012\u0004\u0012\u00020\u00100AH\u0007\u00A2\u0006\u0004\bT\u0010UJ%\u0010T\u001A\b\u0012\u0004\u0012\u00020F0I2\u0006\u0010S\u001A\u00020>2\u0006\u0010=\u001A\u00020CH\u0007\u00A2\u0006\u0004\bT\u0010VJ\u001F\u0010W\u001A\u00020N2\u0006\u0010S\u001A\u00020>2\u0006\u0010=\u001A\u00020CH\u0007\u00A2\u0006\u0004\bW\u0010XJ)\u0010W\u001A\u00020N2\b\u0010Z\u001A\u0004\u0018\u00010Y2\u0006\u0010S\u001A\u00020>2\u0006\u0010=\u001A\u00020CH\u0007\u00A2\u0006\u0004\bW\u0010[J%\u0010_\u001A\u00020\b2\u0006\u0010=\u001A\u00020C2\f\u0010\\\u001A\b\u0012\u0004\u0012\u00020F0IH\u0001\u00A2\u0006\u0004\b]\u0010^J\u0017\u0010b\u001A\u00020\b2\u0006\u0010=\u001A\u00020CH\u0001\u00A2\u0006\u0004\b`\u0010aJ\u001F\u0010e\u001A\u00020\b2\u0006\u0010=\u001A\u00020C2\u0006\u0010S\u001A\u00020>H\u0001\u00A2\u0006\u0004\bc\u0010dJ\u0019\u0010f\u001A\u00020\u00042\b\u0010\u0016\u001A\u0004\u0018\u00010\u0004H\u0002\u00A2\u0006\u0004\bf\u0010gJ\u0017\u0010j\u001A\u00020>2\u0006\u0010i\u001A\u00020hH\u0002\u00A2\u0006\u0004\bj\u0010kJ\u0017\u0010m\u001A\u00020l2\u0006\u0010=\u001A\u00020CH\u0002\u00A2\u0006\u0004\bm\u0010nJ\u001F\u0010p\u001A\u00020\b2\u0006\u0010S\u001A\u00020>2\u0006\u0010o\u001A\u00020lH\u0002\u00A2\u0006\u0004\bp\u0010qJ\u0017\u0010r\u001A\u00020l2\u0006\u0010=\u001A\u00020CH\u0002\u00A2\u0006\u0004\br\u0010nJA\u0010x\u001A\u00020\b2\u0006\u0010=\u001A\u00020C2\b\u0010t\u001A\u0004\u0018\u00010s2\u0006\u0010u\u001A\u00020%2\u0006\u0010i\u001A\u00020h2\u0006\u0010w\u001A\u00020v2\u0006\u0010o\u001A\u00020lH\u0002\u00A2\u0006\u0004\bx\u0010yJ\u0017\u0010{\u001A\u00020l2\u0006\u0010z\u001A\u00020\u0004H\u0002\u00A2\u0006\u0004\b{\u0010|J(\u0010\u007F\u001A\u00020\b2\u0006\u0010\u0018\u001A\u00020\u00172\u0006\u0010z\u001A\u00020\u00042\u0006\u0010~\u001A\u00020}H\u0002\u00A2\u0006\u0005\b\u007F\u0010\u0080\u0001J5\u0010\u0084\u0001\u001A\u00020\b2\u0007\u0010\u0081\u0001\u001A\u00020\u00042\u0007\u0010\u0082\u0001\u001A\u00020\u00012\u0006\u0010~\u001A\u00020}2\u0007\u0010\u0083\u0001\u001A\u00020lH\u0002\u00A2\u0006\u0006\b\u0084\u0001\u0010\u0085\u0001J,\u0010\u0088\u0001\u001A\u00020\b2\u0007\u0010\u0086\u0001\u001A\u00020\u001B2\u0007\u0010~\u001A\u00030\u0087\u00012\u0006\u0010E\u001A\u00020\u0010H\u0002\u00A2\u0006\u0006\b\u0088\u0001\u0010\u0089\u0001J2\u0010\u008D\u0001\u001A\u00020\b2\u0015\u0010\u008C\u0001\u001A\u0010\u0012\u0004\u0012\u00020\u0004\u0012\u0005\u0012\u00030\u008B\u00010\u008A\u00012\u0007\u0010~\u001A\u00030\u0087\u0001H\u0002\u00A2\u0006\u0006\b\u008D\u0001\u0010\u008E\u0001J@\u0010\u0090\u0001\u001A\u00020\b2\u0007\u0010~\u001A\u00030\u0087\u00012\f\u0010=\u001A\b\u0012\u0004\u0012\u00020\u00100A2\u0015\u0010\u008C\u0001\u001A\u0010\u0012\u0004\u0012\u00020\u0004\u0012\u0005\u0012\u00030\u008B\u00010\u008F\u0001H\u0002\u00A2\u0006\u0006\b\u0090\u0001\u0010\u0091\u0001J\u001B\u0010\u0093\u0001\u001A\u00020\u00042\u0007\u0010\u0092\u0001\u001A\u00020CH\u0002\u00A2\u0006\u0006\b\u0093\u0001\u0010\u0094\u0001J\u001D\u0010\u0095\u0001\u001A\u00020l2\t\u0010\u0082\u0001\u001A\u0004\u0018\u00010\u0001H\u0002\u00A2\u0006\u0006\b\u0095\u0001\u0010\u0096\u0001J\u001D\u0010\u0097\u0001\u001A\u00020l2\t\u0010\u0082\u0001\u001A\u0004\u0018\u00010\u0001H\u0002\u00A2\u0006\u0006\b\u0097\u0001\u0010\u0096\u0001J\u001D\u0010\u0098\u0001\u001A\u00020\u00042\t\u0010\u0082\u0001\u001A\u0004\u0018\u00010\u0001H\u0002\u00A2\u0006\u0006\b\u0098\u0001\u0010\u0099\u0001R\'\u0010\u009B\u0001\u001A\u000B \u009A\u0001*\u0004\u0018\u00010\u00040\u00048\u0000X\u0081\u0004\u00A2\u0006\u000F\n\u0006\b\u009B\u0001\u0010\u009C\u0001\u0012\u0005\b\u009D\u0001\u0010\u0003R\u0016\u0010\u009F\u0001\u001A\u00020\u00048BX\u0082\u0004\u00A2\u0006\u0007\u001A\u0005\b\u009E\u0001\u0010\u0006R\"\u0010\u00A0\u0001\u001A\u0004\u0018\u00010\u00048B@\u0002X\u0082\u000E\u00A2\u0006\u000F\n\u0006\b\u00A0\u0001\u0010\u009C\u0001\u001A\u0005\b\u00A1\u0001\u0010\u0006R\u0017\u0010\u00A2\u0001\u001A\u00020\u00048\u0002X\u0082T\u00A2\u0006\b\n\u0006\b\u00A2\u0001\u0010\u009C\u0001R\u0017\u0010\u00A3\u0001\u001A\u00020\u00048\u0006X\u0086T\u00A2\u0006\b\n\u0006\b\u00A3\u0001\u0010\u009C\u0001R\u0017\u0010\u00A4\u0001\u001A\u00020\u00048\u0002X\u0082T\u00A2\u0006\b\n\u0006\b\u00A4\u0001\u0010\u009C\u0001R\u0017\u0010\u00A5\u0001\u001A\u00020\u00048\u0002X\u0082T\u00A2\u0006\b\n\u0006\b\u00A5\u0001\u0010\u009C\u0001R\u0017\u0010\u00A6\u0001\u001A\u00020\u00048\u0002X\u0082T\u00A2\u0006\b\n\u0006\b\u00A6\u0001\u0010\u009C\u0001R\u0017\u0010\u00A7\u0001\u001A\u00020\u00048\u0002X\u0082T\u00A2\u0006\b\n\u0006\b\u00A7\u0001\u0010\u009C\u0001R\u0017\u0010\u00A8\u0001\u001A\u00020\u00048\u0002X\u0082T\u00A2\u0006\b\n\u0006\b\u00A8\u0001\u0010\u009C\u0001R\u0017\u0010\u00A9\u0001\u001A\u00020\u00048\u0002X\u0082T\u00A2\u0006\b\n\u0006\b\u00A9\u0001\u0010\u009C\u0001R\u0017\u0010\u00AA\u0001\u001A\u00020\u00048\u0002X\u0082T\u00A2\u0006\b\n\u0006\b\u00AA\u0001\u0010\u009C\u0001R\u0017\u0010\u00AB\u0001\u001A\u00020\u00048\u0002X\u0082T\u00A2\u0006\b\n\u0006\b\u00AB\u0001\u0010\u009C\u0001R\u0017\u0010\u00AC\u0001\u001A\u00020\u00048\u0002X\u0082T\u00A2\u0006\b\n\u0006\b\u00AC\u0001\u0010\u009C\u0001R\u0017\u0010\u00AD\u0001\u001A\u00020\u00048\u0002X\u0082T\u00A2\u0006\b\n\u0006\b\u00AD\u0001\u0010\u009C\u0001R\u0017\u0010\u00AE\u0001\u001A\u00020\u00048\u0002X\u0082T\u00A2\u0006\b\n\u0006\b\u00AE\u0001\u0010\u009C\u0001R\u0017\u0010\u00AF\u0001\u001A\u00020\u00048\u0002X\u0082T\u00A2\u0006\b\n\u0006\b\u00AF\u0001\u0010\u009C\u0001R\u0017\u0010\u00B0\u0001\u001A\u00020\u00048\u0002X\u0082T\u00A2\u0006\b\n\u0006\b\u00B0\u0001\u0010\u009C\u0001R\u0017\u0010\u00B1\u0001\u001A\u00020\u00048\u0002X\u0082T\u00A2\u0006\b\n\u0006\b\u00B1\u0001\u0010\u009C\u0001R\u0017\u0010\u00B2\u0001\u001A\u00020\u00048\u0002X\u0082T\u00A2\u0006\b\n\u0006\b\u00B2\u0001\u0010\u009C\u0001R\u0017\u0010\u00B3\u0001\u001A\u00020\u00048\u0002X\u0082T\u00A2\u0006\b\n\u0006\b\u00B3\u0001\u0010\u009C\u0001R\u0017\u0010\u00B4\u0001\u001A\u00020\u00048\u0002X\u0082T\u00A2\u0006\b\n\u0006\b\u00B4\u0001\u0010\u009C\u0001R\u0017\u0010\u00B5\u0001\u001A\u00020\u00048\u0002X\u0082T\u00A2\u0006\b\n\u0006\b\u00B5\u0001\u0010\u009C\u0001R\u0017\u0010\u00B6\u0001\u001A\u00020\u00048\u0002X\u0082T\u00A2\u0006\b\n\u0006\b\u00B6\u0001\u0010\u009C\u0001R\u0017\u0010\u00B7\u0001\u001A\u00020\u00048\u0002X\u0082T\u00A2\u0006\b\n\u0006\b\u00B7\u0001\u0010\u009C\u0001R\u0017\u0010\u00B8\u0001\u001A\u00020\u00048\u0002X\u0082T\u00A2\u0006\b\n\u0006\b\u00B8\u0001\u0010\u009C\u0001R\u0017\u0010\u00B9\u0001\u001A\u00020\u00048\u0006X\u0086T\u00A2\u0006\b\n\u0006\b\u00B9\u0001\u0010\u009C\u0001R\u0017\u0010\u00BA\u0001\u001A\u00020\u00048\u0002X\u0082T\u00A2\u0006\b\n\u0006\b\u00BA\u0001\u0010\u009C\u0001R\u0017\u0010\u00BB\u0001\u001A\u00020\u00048\u0002X\u0082T\u00A2\u0006\b\n\u0006\b\u00BB\u0001\u0010\u009C\u0001R\u0017\u0010\u00BC\u0001\u001A\u00020\u00048\u0002X\u0082T\u00A2\u0006\b\n\u0006\b\u00BC\u0001\u0010\u009C\u0001R\u0017\u0010\u00BD\u0001\u001A\u00020%8\u0006X\u0086T\u00A2\u0006\b\n\u0006\b\u00BD\u0001\u0010\u00BE\u0001R\u0017\u0010\u00BF\u0001\u001A\u00020\u00048\u0002X\u0082T\u00A2\u0006\b\n\u0006\b\u00BF\u0001\u0010\u009C\u0001R\u0017\u0010\u00C0\u0001\u001A\u00020\u00048\u0002X\u0082\u0004\u00A2\u0006\b\n\u0006\b\u00C0\u0001\u0010\u009C\u0001R\u0017\u0010\u00C1\u0001\u001A\u00020\u00048\u0002X\u0082T\u00A2\u0006\b\n\u0006\b\u00C1\u0001\u0010\u009C\u0001R\u0017\u0010\u00C2\u0001\u001A\u00020\u00048\u0002X\u0082T\u00A2\u0006\b\n\u0006\b\u00C2\u0001\u0010\u009C\u0001R\u0017\u0010\u00C3\u0001\u001A\u00020\u00048\u0002X\u0082T\u00A2\u0006\b\n\u0006\b\u00C3\u0001\u0010\u009C\u0001R\u0017\u0010\u00C4\u0001\u001A\u00020\u00048\u0002X\u0082T\u00A2\u0006\b\n\u0006\b\u00C4\u0001\u0010\u009C\u0001R\u0017\u0010\u00C5\u0001\u001A\u00020\u00048\u0002X\u0082T\u00A2\u0006\b\n\u0006\b\u00C5\u0001\u0010\u009C\u0001R\u0017\u0010\u00C6\u0001\u001A\u00020\u00048\u0002X\u0082T\u00A2\u0006\b\n\u0006\b\u00C6\u0001\u0010\u009C\u0001R\u0017\u0010\u00C7\u0001\u001A\u00020\u00048\u0002X\u0082T\u00A2\u0006\b\n\u0006\b\u00C7\u0001\u0010\u009C\u0001R\u0017\u0010\u00C8\u0001\u001A\u00020\u00048\u0002X\u0082T\u00A2\u0006\b\n\u0006\b\u00C8\u0001\u0010\u009C\u0001R\u0017\u0010\u00C9\u0001\u001A\u00020\u00048\u0002X\u0082T\u00A2\u0006\b\n\u0006\b\u00C9\u0001\u0010\u009C\u0001R\u001B\u0010\u00CA\u0001\u001A\u0004\u0018\u00010\u00048\u0002@\u0002X\u0082\u000E\u00A2\u0006\b\n\u0006\b\u00CA\u0001\u0010\u009C\u0001R\"\u0010\u00CC\u0001\u001A\r \u009A\u0001*\u0005\u0018\u00010\u00CB\u00010\u00CB\u00018\u0002X\u0082\u0004\u00A2\u0006\b\n\u0006\b\u00CC\u0001\u0010\u00CD\u0001\u00A8\u0006\u00CE\u0001"}, d2 = {"Lcom/facebook/GraphRequest$Companion;", "", "<init>", "()V", "", "getDefaultBatchApplicationId", "()Ljava/lang/String;", "applicationId", "Lie/H;", "setDefaultBatchApplicationId", "(Ljava/lang/String;)V", "Lcom/facebook/AccessToken;", "accessToken", "id", "Lcom/facebook/GraphRequest$Callback;", "callback", "Lcom/facebook/GraphRequest;", "newDeleteObjectRequest", "(Lcom/facebook/AccessToken;Ljava/lang/String;Lcom/facebook/GraphRequest$Callback;)Lcom/facebook/GraphRequest;", "Lcom/facebook/GraphRequest$GraphJSONObjectCallback;", "newMeRequest", "(Lcom/facebook/AccessToken;Lcom/facebook/GraphRequest$GraphJSONObjectCallback;)Lcom/facebook/GraphRequest;", "graphPath", "Lorg/json/JSONObject;", "graphObject", "newPostRequest", "(Lcom/facebook/AccessToken;Ljava/lang/String;Lorg/json/JSONObject;Lcom/facebook/GraphRequest$Callback;)Lcom/facebook/GraphRequest;", "Landroid/os/Bundle;", "parameters", "newPostRequestWithBundle", "(Lcom/facebook/AccessToken;Ljava/lang/String;Landroid/os/Bundle;Lcom/facebook/GraphRequest$Callback;)Lcom/facebook/GraphRequest;", "Lcom/facebook/GraphRequest$GraphJSONArrayCallback;", "newMyFriendsRequest", "(Lcom/facebook/AccessToken;Lcom/facebook/GraphRequest$GraphJSONArrayCallback;)Lcom/facebook/GraphRequest;", "newGraphPathRequest", "Landroid/location/Location;", "location", "", "radiusInMeters", "resultsLimit", "searchText", "newPlacesSearchRequest", "(Lcom/facebook/AccessToken;Landroid/location/Location;IILjava/lang/String;Lcom/facebook/GraphRequest$GraphJSONArrayCallback;)Lcom/facebook/GraphRequest;", "Landroid/graphics/Bitmap;", "image", "caption", "params", "newUploadPhotoRequest", "(Lcom/facebook/AccessToken;Ljava/lang/String;Landroid/graphics/Bitmap;Ljava/lang/String;Landroid/os/Bundle;Lcom/facebook/GraphRequest$Callback;)Lcom/facebook/GraphRequest;", "Ljava/io/File;", "file", "(Lcom/facebook/AccessToken;Ljava/lang/String;Ljava/io/File;Ljava/lang/String;Landroid/os/Bundle;Lcom/facebook/GraphRequest$Callback;)Lcom/facebook/GraphRequest;", "Landroid/net/Uri;", "photoUri", "(Lcom/facebook/AccessToken;Ljava/lang/String;Landroid/net/Uri;Ljava/lang/String;Landroid/os/Bundle;Lcom/facebook/GraphRequest$Callback;)Lcom/facebook/GraphRequest;", "Landroid/content/Context;", "context", "newCustomAudienceThirdPartyIdRequest", "(Lcom/facebook/AccessToken;Landroid/content/Context;Ljava/lang/String;Lcom/facebook/GraphRequest$Callback;)Lcom/facebook/GraphRequest;", "(Lcom/facebook/AccessToken;Landroid/content/Context;Lcom/facebook/GraphRequest$Callback;)Lcom/facebook/GraphRequest;", "", "requests", "Ljava/net/HttpURLConnection;", "toHttpConnection", "([Lcom/facebook/GraphRequest;)Ljava/net/HttpURLConnection;", "", "(Ljava/util/Collection;)Ljava/net/HttpURLConnection;", "Lcom/facebook/GraphRequestBatch;", "(Lcom/facebook/GraphRequestBatch;)Ljava/net/HttpURLConnection;", "request", "Lcom/facebook/GraphResponse;", "executeAndWait", "(Lcom/facebook/GraphRequest;)Lcom/facebook/GraphResponse;", "", "executeBatchAndWait", "([Lcom/facebook/GraphRequest;)Ljava/util/List;", "(Ljava/util/Collection;)Ljava/util/List;", "(Lcom/facebook/GraphRequestBatch;)Ljava/util/List;", "Lcom/facebook/GraphRequestAsyncTask;", "executeBatchAsync", "([Lcom/facebook/GraphRequest;)Lcom/facebook/GraphRequestAsyncTask;", "(Ljava/util/Collection;)Lcom/facebook/GraphRequestAsyncTask;", "(Lcom/facebook/GraphRequestBatch;)Lcom/facebook/GraphRequestAsyncTask;", "connection", "executeConnectionAndWait", "(Ljava/net/HttpURLConnection;Ljava/util/Collection;)Ljava/util/List;", "(Ljava/net/HttpURLConnection;Lcom/facebook/GraphRequestBatch;)Ljava/util/List;", "executeConnectionAsync", "(Ljava/net/HttpURLConnection;Lcom/facebook/GraphRequestBatch;)Lcom/facebook/GraphRequestAsyncTask;", "Landroid/os/Handler;", "callbackHandler", "(Landroid/os/Handler;Ljava/net/HttpURLConnection;Lcom/facebook/GraphRequestBatch;)Lcom/facebook/GraphRequestAsyncTask;", "responses", "runCallbacks$facebook_core_release", "(Lcom/facebook/GraphRequestBatch;Ljava/util/List;)V", "runCallbacks", "validateFieldsParamForGetRequests$facebook_core_release", "(Lcom/facebook/GraphRequestBatch;)V", "validateFieldsParamForGetRequests", "serializeToUrlConnection$facebook_core_release", "(Lcom/facebook/GraphRequestBatch;Ljava/net/HttpURLConnection;)V", "serializeToUrlConnection", "getDefaultPhotoPathIfNull", "(Ljava/lang/String;)Ljava/lang/String;", "Ljava/net/URL;", "url", "createConnection", "(Ljava/net/URL;)Ljava/net/HttpURLConnection;", "", "hasOnProgressCallbacks", "(Lcom/facebook/GraphRequestBatch;)Z", "shouldUseGzip", "setConnectionContentType", "(Ljava/net/HttpURLConnection;Z)V", "isGzipCompressible", "Lcom/facebook/internal/Logger;", "logger", "numRequests", "Ljava/io/OutputStream;", "outputStream", "processRequest", "(Lcom/facebook/GraphRequestBatch;Lcom/facebook/internal/Logger;ILjava/net/URL;Ljava/io/OutputStream;Z)V", "path", "isMeRequest", "(Ljava/lang/String;)Z", "Lcom/facebook/GraphRequest$KeyValueSerializer;", "serializer", "processGraphObject", "(Lorg/json/JSONObject;Ljava/lang/String;Lcom/facebook/GraphRequest$KeyValueSerializer;)V", "key", "value", "passByValue", "processGraphObjectProperty", "(Ljava/lang/String;Ljava/lang/Object;Lcom/facebook/GraphRequest$KeyValueSerializer;Z)V", "bundle", "Lcom/facebook/GraphRequest$Serializer;", "serializeParameters", "(Landroid/os/Bundle;Lcom/facebook/GraphRequest$Serializer;Lcom/facebook/GraphRequest;)V", "", "Lcom/facebook/GraphRequest$Attachment;", "attachments", "serializeAttachments", "(Ljava/util/Map;Lcom/facebook/GraphRequest$Serializer;)V", "", "serializeRequestsAsJSON", "(Lcom/facebook/GraphRequest$Serializer;Ljava/util/Collection;Ljava/util/Map;)V", "batch", "getBatchAppId", "(Lcom/facebook/GraphRequestBatch;)Ljava/lang/String;", "isSupportedAttachmentType", "(Ljava/lang/Object;)Z", "isSupportedParameterType", "parameterToString", "(Ljava/lang/Object;)Ljava/lang/String;", "kotlin.jvm.PlatformType", "TAG", "Ljava/lang/String;", "getTAG$facebook_core_release$annotations", "getMimeContentType", "mimeContentType", "userAgent", "getUserAgent", "ACCEPT_LANGUAGE_HEADER", "ACCESS_TOKEN_PARAM", "ATTACHED_FILES_PARAM", "ATTACHMENT_FILENAME_PREFIX", "BATCH_APP_ID_PARAM", "BATCH_BODY_PARAM", "BATCH_ENTRY_DEPENDS_ON_PARAM", "BATCH_ENTRY_NAME_PARAM", "BATCH_ENTRY_OMIT_RESPONSE_ON_SUCCESS_PARAM", "BATCH_METHOD_PARAM", "BATCH_PARAM", "BATCH_RELATIVE_URL_PARAM", "CAPTION_PARAM", "CONTENT_ENCODING_HEADER", "CONTENT_TYPE_HEADER", "DEBUG_KEY", "DEBUG_MESSAGES_KEY", "DEBUG_MESSAGE_KEY", "DEBUG_MESSAGE_LINK_KEY", "DEBUG_MESSAGE_TYPE_KEY", "DEBUG_PARAM", "DEBUG_SEVERITY_INFO", "DEBUG_SEVERITY_WARNING", "FIELDS_PARAM", "FORMAT_JSON", "FORMAT_PARAM", "ISO_8601_FORMAT_STRING", "MAXIMUM_BATCH_SIZE", "I", "ME", "MIME_BOUNDARY", "MY_FRIENDS", "MY_PHOTOS", "PICTURE_PARAM", "SDK_ANDROID", "SDK_PARAM", "SEARCH", "USER_AGENT_BASE", "USER_AGENT_HEADER", "VIDEOS_SUFFIX", "defaultBatchApplicationId", "Ljava/util/regex/Pattern;", "versionPattern", "Ljava/util/regex/Pattern;", "facebook-core_release"}, k = 1, mv = {1, 8, 0}, xi = 0x30)
    public static final class Companion {
        private Companion() {
        }

        public Companion(DefaultConstructorMarker defaultConstructorMarker0) {
        }

        public static void a(ArrayList arrayList0, GraphRequestBatch graphRequestBatch0) {
            Companion.runCallbacks$lambda$2(arrayList0, graphRequestBatch0);
        }

        public static final boolean access$isSupportedAttachmentType(Companion graphRequest$Companion0, Object object0) {
            return graphRequest$Companion0.isSupportedAttachmentType(object0);
        }

        public static final void access$processGraphObject(Companion graphRequest$Companion0, JSONObject jSONObject0, String s, KeyValueSerializer graphRequest$KeyValueSerializer0) {
            graphRequest$Companion0.processGraphObject(jSONObject0, s, graphRequest$KeyValueSerializer0);
        }

        private final HttpURLConnection createConnection(URL uRL0) {
            URLConnection uRLConnection0 = uRL0.openConnection();
            q.e(uRLConnection0, "null cannot be cast to non-null type java.net.HttpURLConnection");
            ((HttpURLConnection)uRLConnection0).setRequestProperty("User-Agent", "FBAndroidSDK.18.1.3");
            ((HttpURLConnection)uRLConnection0).setRequestProperty("Accept-Language", Locale.getDefault().toString());
            ((HttpURLConnection)uRLConnection0).setChunkedStreamingMode(0);
            return (HttpURLConnection)uRLConnection0;
        }

        @NotNull
        public final GraphResponse executeAndWait(@NotNull GraphRequest graphRequest0) {
            q.g(graphRequest0, "request");
            List list0 = this.executeBatchAndWait(new GraphRequest[]{graphRequest0});
            if(list0.size() != 1) {
                throw new FacebookException("invalid state: expected a single response");
            }
            return (GraphResponse)list0.get(0);
        }

        @NotNull
        public final List executeBatchAndWait(@NotNull GraphRequestBatch graphRequestBatch0) {
            List list0;
            HttpURLConnection httpURLConnection0;
            Exception exception0;
            q.g(graphRequestBatch0, "requests");
            Validate.notEmptyAndContainsNoNulls(graphRequestBatch0, "requests");
            URLConnection uRLConnection0 = null;
            try {
                exception0 = exception1;
                httpURLConnection0 = null;
                httpURLConnection0 = this.toHttpConnection(graphRequestBatch0);
                exception0 = null;
            }
            catch(Exception throwable0) {
                Utility.disconnectQuietly(uRLConnection0);
                throw throwable0;
            }
            catch(Throwable unused_ex) {
            }
            try {
                if(httpURLConnection0 == null) {
                    FacebookException facebookException0 = new FacebookException(exception0);
                    List list1 = GraphResponse.Companion.constructErrorResponses(graphRequestBatch0.getRequests(), null, facebookException0);
                    this.runCallbacks$facebook_core_release(graphRequestBatch0, list1);
                    list0 = list1;
                }
                else {
                    list0 = this.executeConnectionAndWait(httpURLConnection0, graphRequestBatch0);
                }
            }
            catch(Throwable throwable0) {
                uRLConnection0 = httpURLConnection0;
                Utility.disconnectQuietly(uRLConnection0);
                throw throwable0;
            }
            Utility.disconnectQuietly(httpURLConnection0);
            return list0;
        }

        @NotNull
        public final List executeBatchAndWait(@NotNull Collection collection0) {
            q.g(collection0, "requests");
            return this.executeBatchAndWait(new GraphRequestBatch(collection0));
        }

        @NotNull
        public final List executeBatchAndWait(@NotNull GraphRequest[] arr_graphRequest) {
            q.g(arr_graphRequest, "requests");
            return this.executeBatchAndWait(n.z0(arr_graphRequest));
        }

        @NotNull
        public final GraphRequestAsyncTask executeBatchAsync(@NotNull GraphRequestBatch graphRequestBatch0) {
            q.g(graphRequestBatch0, "requests");
            Validate.notEmptyAndContainsNoNulls(graphRequestBatch0, "requests");
            GraphRequestAsyncTask graphRequestAsyncTask0 = new GraphRequestAsyncTask(graphRequestBatch0);
            graphRequestAsyncTask0.executeOnExecutor(FacebookSdk.getExecutor(), new Void[0]);
            return graphRequestAsyncTask0;
        }

        @NotNull
        public final GraphRequestAsyncTask executeBatchAsync(@NotNull Collection collection0) {
            q.g(collection0, "requests");
            return this.executeBatchAsync(new GraphRequestBatch(collection0));
        }

        @NotNull
        public final GraphRequestAsyncTask executeBatchAsync(@NotNull GraphRequest[] arr_graphRequest) {
            q.g(arr_graphRequest, "requests");
            return this.executeBatchAsync(n.z0(arr_graphRequest));
        }

        @NotNull
        public final List executeConnectionAndWait(@NotNull HttpURLConnection httpURLConnection0, @NotNull GraphRequestBatch graphRequestBatch0) {
            q.g(httpURLConnection0, "connection");
            q.g(graphRequestBatch0, "requests");
            List list0 = GraphResponse.Companion.fromHttpConnection$facebook_core_release(httpURLConnection0, graphRequestBatch0);
            Utility.disconnectQuietly(httpURLConnection0);
            int v = graphRequestBatch0.size();
            if(v != list0.size()) {
                throw new FacebookException(String.format(Locale.US, "Received %d responses while expecting %d", Arrays.copyOf(new Object[]{list0.size(), v}, 2)));
            }
            this.runCallbacks$facebook_core_release(graphRequestBatch0, list0);
            AccessTokenManager.Companion.getInstance().extendAccessTokenIfNeeded();
            return list0;
        }

        @NotNull
        public final List executeConnectionAndWait(@NotNull HttpURLConnection httpURLConnection0, @NotNull Collection collection0) {
            q.g(httpURLConnection0, "connection");
            q.g(collection0, "requests");
            return this.executeConnectionAndWait(httpURLConnection0, new GraphRequestBatch(collection0));
        }

        @NotNull
        public final GraphRequestAsyncTask executeConnectionAsync(@Nullable Handler handler0, @NotNull HttpURLConnection httpURLConnection0, @NotNull GraphRequestBatch graphRequestBatch0) {
            q.g(httpURLConnection0, "connection");
            q.g(graphRequestBatch0, "requests");
            GraphRequestAsyncTask graphRequestAsyncTask0 = new GraphRequestAsyncTask(httpURLConnection0, graphRequestBatch0);
            graphRequestBatch0.setCallbackHandler(handler0);
            graphRequestAsyncTask0.executeOnExecutor(FacebookSdk.getExecutor(), new Void[0]);
            return graphRequestAsyncTask0;
        }

        @NotNull
        public final GraphRequestAsyncTask executeConnectionAsync(@NotNull HttpURLConnection httpURLConnection0, @NotNull GraphRequestBatch graphRequestBatch0) {
            q.g(httpURLConnection0, "connection");
            q.g(graphRequestBatch0, "requests");
            return this.executeConnectionAsync(null, httpURLConnection0, graphRequestBatch0);
        }

        private final String getBatchAppId(GraphRequestBatch graphRequestBatch0) {
            String s = graphRequestBatch0.getBatchApplicationId();
            if(s != null && !graphRequestBatch0.isEmpty()) {
                return s;
            }
            for(Object object0: graphRequestBatch0) {
                AccessToken accessToken0 = ((GraphRequest)object0).getAccessToken();
                if(accessToken0 != null) {
                    return accessToken0.getApplicationId();
                }
                if(false) {
                    break;
                }
            }
            String s1 = GraphRequest.defaultBatchApplicationId;
            return s1 == null || s1.length() <= 0 ? FacebookSdk.getApplicationId() : s1;
        }

        @Nullable
        public final String getDefaultBatchApplicationId() {
            return GraphRequest.defaultBatchApplicationId;
        }

        private final String getDefaultPhotoPathIfNull(String s) {
            return s == null ? "me/photos" : s;
        }

        // 去混淆评级： 低(40)
        private final String getMimeContentType() [...] // 潜在的解密器

        public static void getTAG$facebook_core_release$annotations() {
        }

        private final String getUserAgent() [...] // 潜在的解密器

        private final boolean hasOnProgressCallbacks(GraphRequestBatch graphRequestBatch0) {
            for(Object object0: graphRequestBatch0.getCallbacks()) {
                if(((com.facebook.GraphRequestBatch.Callback)object0) instanceof OnProgressCallback) {
                    return true;
                }
                if(false) {
                    break;
                }
            }
            for(Object object1: graphRequestBatch0) {
                if(((GraphRequest)object1).getCallback() instanceof com.facebook.GraphRequest.OnProgressCallback) {
                    return true;
                }
                if(false) {
                    break;
                }
            }
            return false;
        }

        private final boolean isGzipCompressible(GraphRequestBatch graphRequestBatch0) {
            for(Object object0: graphRequestBatch0) {
                GraphRequest graphRequest0 = (GraphRequest)object0;
                for(Object object1: graphRequest0.getParameters().keySet()) {
                    if(this.isSupportedAttachmentType(graphRequest0.getParameters().get(((String)object1)))) {
                        return false;
                    }
                    if(false) {
                        break;
                    }
                }
                if(false) {
                    break;
                }
            }
            return true;
        }

        private final boolean isMeRequest(String s) {
            Matcher matcher0 = GraphRequest.versionPattern.matcher(s);
            if(matcher0.matches()) {
                s = matcher0.group(1);
                q.f(s, "matcher.group(1)");
            }
            return v.r0(s, "me/", false) || v.r0(s, "/me/", false);
        }

        // 去混淆评级： 中等(50)
        private final boolean isSupportedAttachmentType(Object object0) {
            return object0 instanceof Bitmap || object0 instanceof byte[] || object0 instanceof Uri || object0 instanceof ParcelFileDescriptor || object0 instanceof ParcelableResourceWithMimeType;
        }

        // 去混淆评级： 低(40)
        private final boolean isSupportedParameterType(Object object0) {
            return object0 instanceof String || object0 instanceof Boolean || object0 instanceof Number || object0 instanceof Date;
        }

        @NotNull
        public final GraphRequest newCustomAudienceThirdPartyIdRequest(@Nullable AccessToken accessToken0, @NotNull Context context0, @Nullable Callback graphRequest$Callback0) {
            q.g(context0, "context");
            return this.newCustomAudienceThirdPartyIdRequest(accessToken0, context0, null, graphRequest$Callback0);
        }

        @NotNull
        public final GraphRequest newCustomAudienceThirdPartyIdRequest(@Nullable AccessToken accessToken0, @NotNull Context context0, @Nullable String s, @Nullable Callback graphRequest$Callback0) {
            q.g(context0, "context");
            if(s == null && accessToken0 != null) {
                s = accessToken0.getApplicationId();
            }
            if(s == null) {
                s = Utility.getMetadataApplicationId(context0);
            }
            if(s == null) {
                throw new FacebookException("Facebook App ID cannot be determined");
            }
            AttributionIdentifiers attributionIdentifiers0 = AttributionIdentifiers.Companion.getAttributionIdentifiers(context0);
            Bundle bundle0 = new Bundle();
            if(accessToken0 == null) {
                if(attributionIdentifiers0 == null) {
                    throw new FacebookException("There is no access token and attribution identifiers could not be retrieved");
                }
                String s1 = attributionIdentifiers0.getAttributionId() == null ? attributionIdentifiers0.getAndroidAdvertiserId() : attributionIdentifiers0.getAttributionId();
                if(s1 != null) {
                    bundle0.putString("udid", s1);
                }
            }
            if(FacebookSdk.getLimitEventAndDataUsage(context0) || attributionIdentifiers0 != null && attributionIdentifiers0.isTrackingLimited()) {
                bundle0.putString("limit_event_usage", "1");
            }
            return new GraphRequest(accessToken0, s + "/custom_audience_third_party_id", bundle0, HttpMethod.GET, graphRequest$Callback0, null, 0x20, null);
        }

        @NotNull
        public final GraphRequest newDeleteObjectRequest(@Nullable AccessToken accessToken0, @Nullable String s, @Nullable Callback graphRequest$Callback0) {
            return new GraphRequest(accessToken0, s, null, HttpMethod.DELETE, graphRequest$Callback0, null, 0x20, null);
        }

        @NotNull
        public final GraphRequest newGraphPathRequest(@Nullable AccessToken accessToken0, @Nullable String s, @Nullable Callback graphRequest$Callback0) {
            return new GraphRequest(accessToken0, s, null, null, graphRequest$Callback0, null, 0x20, null);
        }

        @NotNull
        public final GraphRequest newMeRequest(@Nullable AccessToken accessToken0, @Nullable GraphJSONObjectCallback graphRequest$GraphJSONObjectCallback0) {
            return new GraphRequest(accessToken0, "me", null, null, new b(graphRequest$GraphJSONObjectCallback0, 3), null, 0x20, null);
        }

        private static final void newMeRequest$lambda$0(GraphJSONObjectCallback graphRequest$GraphJSONObjectCallback0, GraphResponse graphResponse0) {
            q.g(graphResponse0, "response");
            if(graphRequest$GraphJSONObjectCallback0 != null) {
                graphRequest$GraphJSONObjectCallback0.onCompleted(graphResponse0.getJSONObject(), graphResponse0);
            }
        }

        @NotNull
        public final GraphRequest newMyFriendsRequest(@Nullable AccessToken accessToken0, @Nullable GraphJSONArrayCallback graphRequest$GraphJSONArrayCallback0) {
            return new GraphRequest(accessToken0, "me/friends", null, null, new Callback() {
                @Override  // com.facebook.GraphRequest$Callback
                public void onCompleted(@NotNull GraphResponse graphResponse0) {
                    q.g(graphResponse0, "response");
                    if(this.$callback != null) {
                        JSONObject jSONObject0 = graphResponse0.getJSONObject();
                        JSONArray jSONArray0 = jSONObject0 == null ? null : jSONObject0.optJSONArray("data");
                        this.$callback.onCompleted(jSONArray0, graphResponse0);
                    }
                }
            }, null, 0x20, null);
        }

        @NotNull
        public final GraphRequest newPlacesSearchRequest(@Nullable AccessToken accessToken0, @Nullable Location location0, int v, int v1, @Nullable String s, @Nullable GraphJSONArrayCallback graphRequest$GraphJSONArrayCallback0) {
            if(location0 == null && Utility.isNullOrEmpty(s)) {
                throw new FacebookException("Either location or searchText must be specified.");
            }
            Bundle bundle0 = new Bundle(5);
            bundle0.putString("type", "place");
            bundle0.putInt("limit", v1);
            if(location0 != null) {
                bundle0.putString("center", String.format(Locale.US, "%f,%f", Arrays.copyOf(new Object[]{location0.getLatitude(), location0.getLongitude()}, 2)));
                bundle0.putInt("distance", v);
            }
            if(!Utility.isNullOrEmpty(s)) {
                bundle0.putString("q", s);
            }
            b b0 = new b(graphRequest$GraphJSONArrayCallback0, 2);
            return new GraphRequest(accessToken0, "search", bundle0, HttpMethod.GET, b0, null, 0x20, null);
        }

        private static final void newPlacesSearchRequest$lambda$1(GraphJSONArrayCallback graphRequest$GraphJSONArrayCallback0, GraphResponse graphResponse0) {
            q.g(graphResponse0, "response");
            if(graphRequest$GraphJSONArrayCallback0 != null) {
                JSONObject jSONObject0 = graphResponse0.getJSONObject();
                graphRequest$GraphJSONArrayCallback0.onCompleted((jSONObject0 == null ? null : jSONObject0.optJSONArray("data")), graphResponse0);
            }
        }

        @NotNull
        public final GraphRequest newPostRequest(@Nullable AccessToken accessToken0, @Nullable String s, @Nullable JSONObject jSONObject0, @Nullable Callback graphRequest$Callback0) {
            GraphRequest graphRequest0 = new GraphRequest(accessToken0, s, null, HttpMethod.POST, graphRequest$Callback0, null, 0x20, null);
            graphRequest0.setGraphObject(jSONObject0);
            return graphRequest0;
        }

        @NotNull
        public final GraphRequest newPostRequestWithBundle(@Nullable AccessToken accessToken0, @Nullable String s, @Nullable Bundle bundle0, @Nullable Callback graphRequest$Callback0) {
            return new GraphRequest(accessToken0, s, bundle0, HttpMethod.POST, graphRequest$Callback0, null, 0x20, null);
        }

        @NotNull
        public final GraphRequest newUploadPhotoRequest(@Nullable AccessToken accessToken0, @Nullable String s, @NotNull Bitmap bitmap0, @Nullable String s1, @Nullable Bundle bundle0, @Nullable Callback graphRequest$Callback0) {
            q.g(bitmap0, "image");
            Bundle bundle1 = new Bundle();
            if(bundle0 != null) {
                bundle1.putAll(bundle0);
            }
            bundle1.putParcelable("picture", bitmap0);
            if(s1 != null && s1.length() > 0) {
                bundle1.putString("caption", s1);
            }
            return new GraphRequest(accessToken0, this.getDefaultPhotoPathIfNull(s), bundle1, HttpMethod.POST, graphRequest$Callback0, null, 0x20, null);
        }

        @NotNull
        public final GraphRequest newUploadPhotoRequest(@Nullable AccessToken accessToken0, @Nullable String s, @NotNull Uri uri0, @Nullable String s1, @Nullable Bundle bundle0, @Nullable Callback graphRequest$Callback0) {
            q.g(uri0, "photoUri");
            if(Utility.isFileUri(uri0)) {
                return this.newUploadPhotoRequest(accessToken0, s, new File(uri0.getPath()), s1, bundle0, graphRequest$Callback0);
            }
            if(!Utility.isContentUri(uri0)) {
                throw new FacebookException("The photo Uri must be either a file:// or content:// Uri");
            }
            Bundle bundle1 = new Bundle();
            if(bundle0 != null) {
                bundle1.putAll(bundle0);
            }
            bundle1.putParcelable("picture", uri0);
            if(s1 != null && s1.length() > 0) {
                bundle1.putString("caption", s1);
            }
            return new GraphRequest(accessToken0, this.getDefaultPhotoPathIfNull(s), bundle1, HttpMethod.POST, graphRequest$Callback0, null, 0x20, null);
        }

        @NotNull
        public final GraphRequest newUploadPhotoRequest(@Nullable AccessToken accessToken0, @Nullable String s, @NotNull File file0, @Nullable String s1, @Nullable Bundle bundle0, @Nullable Callback graphRequest$Callback0) {
            q.g(file0, "file");
            ParcelFileDescriptor parcelFileDescriptor0 = ParcelFileDescriptor.open(file0, 0x10000000);
            Bundle bundle1 = new Bundle();
            if(bundle0 != null) {
                bundle1.putAll(bundle0);
            }
            bundle1.putParcelable("picture", parcelFileDescriptor0);
            if(s1 != null && s1.length() > 0) {
                bundle1.putString("caption", s1);
            }
            return new GraphRequest(accessToken0, this.getDefaultPhotoPathIfNull(s), bundle1, HttpMethod.POST, graphRequest$Callback0, null, 0x20, null);
        }

        private final String parameterToString(Object object0) {
            if(object0 instanceof String) {
                return (String)object0;
            }
            if(!(object0 instanceof Boolean) && !(object0 instanceof Number)) {
                if(!(object0 instanceof Date)) {
                    throw new IllegalArgumentException("Unsupported parameter type.");
                }
                String s = new SimpleDateFormat("yyyy-MM-dd\'T\'HH:mm:ssZ", Locale.US).format(((Date)object0));
                q.f(s, "iso8601DateFormat.format(value)");
                return s;
            }
            return object0.toString();
        }

        private final void processGraphObject(JSONObject jSONObject0, String s, KeyValueSerializer graphRequest$KeyValueSerializer0) {
            boolean z;
            if(this.isMeRequest(s)) {
                int v = o.F0(s, ":", 0, false, 6);
                int v1 = o.F0(s, "?", 0, false, 6);
                z = v <= 3 || v1 != -1 && v >= v1 ? false : true;
            }
            else {
                z = false;
            }
            Iterator iterator0 = jSONObject0.keys();
            while(iterator0.hasNext()) {
                Object object0 = iterator0.next();
                Object object1 = jSONObject0.opt(((String)object0));
                q.f(((String)object0), "key");
                q.f(object1, "value");
                this.processGraphObjectProperty(((String)object0), object1, graphRequest$KeyValueSerializer0, z && v.j0(((String)object0), "image", true));
            }
        }

        private final void processGraphObjectProperty(String s, Object object0, KeyValueSerializer graphRequest$KeyValueSerializer0, boolean z) {
            Class class0 = object0.getClass();
            if(JSONObject.class.isAssignableFrom(class0)) {
                if(z) {
                    Iterator iterator0 = ((JSONObject)object0).keys();
                    while(iterator0.hasNext()) {
                        Object object1 = iterator0.next();
                        String s1 = String.format("%s[%s]", Arrays.copyOf(new Object[]{s, ((String)object1)}, 2));
                        Object object2 = ((JSONObject)object0).opt(((String)object1));
                        q.f(object2, "jsonObject.opt(propertyName)");
                        this.processGraphObjectProperty(s1, object2, graphRequest$KeyValueSerializer0, true);
                    }
                    return;
                }
                if(((JSONObject)object0).has("id")) {
                    String s2 = ((JSONObject)object0).optString("id");
                    q.f(s2, "jsonObject.optString(\"id\")");
                    this.processGraphObjectProperty(s, s2, graphRequest$KeyValueSerializer0, false);
                    return;
                }
                if(((JSONObject)object0).has("url")) {
                    String s3 = ((JSONObject)object0).optString("url");
                    q.f(s3, "jsonObject.optString(\"url\")");
                    this.processGraphObjectProperty(s, s3, graphRequest$KeyValueSerializer0, false);
                    return;
                }
                if(!((JSONObject)object0).has("fbsdk:create_object")) {
                    return;
                }
                String s4 = ((JSONObject)object0).toString();
                q.f(s4, "jsonObject.toString()");
                this.processGraphObjectProperty(s, s4, graphRequest$KeyValueSerializer0, false);
                return;
            }
            if(JSONArray.class.isAssignableFrom(class0)) {
                int v = ((JSONArray)object0).length();
                for(int v1 = 0; v1 < v; ++v1) {
                    String s5 = String.format(Locale.ROOT, "%s[%d]", Arrays.copyOf(new Object[]{s, v1}, 2));
                    Object object3 = ((JSONArray)object0).opt(v1);
                    q.f(object3, "jsonArray.opt(i)");
                    this.processGraphObjectProperty(s5, object3, graphRequest$KeyValueSerializer0, z);
                }
                return;
            }
            if(!String.class.isAssignableFrom(class0) && !Number.class.isAssignableFrom(class0) && !Boolean.class.isAssignableFrom(class0)) {
                if(Date.class.isAssignableFrom(class0)) {
                    String s6 = new SimpleDateFormat("yyyy-MM-dd\'T\'HH:mm:ssZ", Locale.US).format(((Date)object0));
                    q.f(s6, "iso8601DateFormat.format(date)");
                    graphRequest$KeyValueSerializer0.writeString(s, s6);
                    return;
                }
                Utility.logd("GraphRequest", "The type of property " + s + " in the graph object is unknown. It won\'t be sent in the request.");
                return;
            }
            graphRequest$KeyValueSerializer0.writeString(s, object0.toString());
        }

        private final void processRequest(GraphRequestBatch graphRequestBatch0, Logger logger0, int v, URL uRL0, OutputStream outputStream0, boolean z) {
            Serializer graphRequest$Serializer0 = new Serializer(outputStream0, logger0, z);
            if(v == 1) {
                GraphRequest graphRequest0 = graphRequestBatch0.get(0);
                HashMap hashMap0 = new HashMap();
                for(Object object0: graphRequest0.getParameters().keySet()) {
                    String s = (String)object0;
                    Object object1 = graphRequest0.getParameters().get(s);
                    if(this.isSupportedAttachmentType(object1)) {
                        q.f(s, "key");
                        hashMap0.put(s, new Attachment(graphRequest0, object1));
                    }
                }
                if(logger0 != null) {
                    logger0.append("  Parameters:\n");
                }
                this.serializeParameters(graphRequest0.getParameters(), graphRequest$Serializer0, graphRequest0);
                if(logger0 != null) {
                    logger0.append("  Attachments:\n");
                }
                this.serializeAttachments(hashMap0, graphRequest$Serializer0);
                JSONObject jSONObject0 = graphRequest0.getGraphObject();
                if(jSONObject0 != null) {
                    String s1 = uRL0.getPath();
                    q.f(s1, "url.path");
                    this.processGraphObject(jSONObject0, s1, graphRequest$Serializer0);
                }
                return;
            }
            String s2 = this.getBatchAppId(graphRequestBatch0);
            if(s2.length() == 0) {
                throw new FacebookException("App ID was not specified at the request or Settings.");
            }
            graphRequest$Serializer0.writeString("batch_app_id", s2);
            HashMap hashMap1 = new HashMap();
            this.serializeRequestsAsJSON(graphRequest$Serializer0, graphRequestBatch0, hashMap1);
            if(logger0 != null) {
                logger0.append("  Attachments:\n");
            }
            this.serializeAttachments(hashMap1, graphRequest$Serializer0);
        }

        public final void runCallbacks$facebook_core_release(@NotNull GraphRequestBatch graphRequestBatch0, @NotNull List list0) {
            q.g(graphRequestBatch0, "requests");
            q.g(list0, "responses");
            int v = graphRequestBatch0.size();
            ArrayList arrayList0 = new ArrayList();
            for(int v1 = 0; v1 < v; ++v1) {
                GraphRequest graphRequest0 = graphRequestBatch0.get(v1);
                if(graphRequest0.getCallback() != null) {
                    arrayList0.add(new Pair(graphRequest0.getCallback(), list0.get(v1)));
                }
            }
            if(arrayList0.size() > 0) {
                l l0 = new l(4, arrayList0, graphRequestBatch0);
                Handler handler0 = graphRequestBatch0.getCallbackHandler();
                if(handler0 != null) {
                    handler0.post(l0);
                    return;
                }
                l0.run();
            }
        }

        private static final void runCallbacks$lambda$2(ArrayList arrayList0, GraphRequestBatch graphRequestBatch0) {
            q.g(arrayList0, "$callbacks");
            q.g(graphRequestBatch0, "$requests");
            for(Object object0: arrayList0) {
                Callback graphRequest$Callback0 = (Callback)((Pair)object0).first;
                Object object1 = ((Pair)object0).second;
                q.f(object1, "pair.second");
                graphRequest$Callback0.onCompleted(((GraphResponse)object1));
            }
            for(Object object2: graphRequestBatch0.getCallbacks()) {
                ((com.facebook.GraphRequestBatch.Callback)object2).onBatchCompleted(graphRequestBatch0);
            }
        }

        private final void serializeAttachments(Map map0, Serializer graphRequest$Serializer0) {
            for(Object object0: map0.entrySet()) {
                Map.Entry map$Entry0 = (Map.Entry)object0;
                Object object1 = ((Attachment)map$Entry0.getValue()).getValue();
                if(GraphRequest.Companion.isSupportedAttachmentType(object1)) {
                    graphRequest$Serializer0.writeObject(((String)map$Entry0.getKey()), ((Attachment)map$Entry0.getValue()).getValue(), ((Attachment)map$Entry0.getValue()).getRequest());
                }
            }
        }

        private final void serializeParameters(Bundle bundle0, Serializer graphRequest$Serializer0, GraphRequest graphRequest0) {
            for(Object object0: bundle0.keySet()) {
                String s = (String)object0;
                Object object1 = bundle0.get(s);
                if(this.isSupportedParameterType(object1)) {
                    q.f(s, "key");
                    graphRequest$Serializer0.writeObject(s, object1, graphRequest0);
                }
            }
        }

        private final void serializeRequestsAsJSON(Serializer graphRequest$Serializer0, Collection collection0, Map map0) {
            JSONArray jSONArray0 = new JSONArray();
            for(Object object0: collection0) {
                ((GraphRequest)object0).serializeToBatch(jSONArray0, map0);
            }
            graphRequest$Serializer0.writeRequestsAsJson("batch", jSONArray0, collection0);
        }

        public final void serializeToUrlConnection$facebook_core_release(@NotNull GraphRequestBatch graphRequestBatch0, @NotNull HttpURLConnection httpURLConnection0) {
            BufferedOutputStream bufferedOutputStream2;
            URL uRL1;
            Throwable throwable2;
            BufferedOutputStream bufferedOutputStream1;
            q.g(graphRequestBatch0, "requests");
            q.g(httpURLConnection0, "connection");
            Logger logger0 = new Logger(LoggingBehavior.REQUESTS, "Request");
            int v = graphRequestBatch0.size();
            boolean z = this.isGzipCompressible(graphRequestBatch0);
            BufferedOutputStream bufferedOutputStream0 = null;
            HttpMethod httpMethod0 = v == 1 ? graphRequestBatch0.get(0).getHttpMethod() : null;
            if(httpMethod0 == null) {
                httpMethod0 = HttpMethod.POST;
            }
            httpURLConnection0.setRequestMethod(httpMethod0.name());
            this.setConnectionContentType(httpURLConnection0, z);
            URL uRL0 = httpURLConnection0.getURL();
            logger0.append("Request:\n");
            logger0.appendKeyValue("Id", "1");
            q.f(uRL0, "url");
            logger0.appendKeyValue("URL", uRL0);
            String s = httpURLConnection0.getRequestMethod();
            q.f(s, "connection.requestMethod");
            logger0.appendKeyValue("Method", s);
            String s1 = httpURLConnection0.getRequestProperty("User-Agent");
            q.f(s1, "connection.getRequestProperty(\"User-Agent\")");
            logger0.appendKeyValue("User-Agent", s1);
            String s2 = httpURLConnection0.getRequestProperty("Content-Type");
            q.f(s2, "connection.getRequestProperty(\"Content-Type\")");
            logger0.appendKeyValue("Content-Type", s2);
            httpURLConnection0.setConnectTimeout(graphRequestBatch0.getTimeout());
            httpURLConnection0.setReadTimeout(graphRequestBatch0.getTimeout());
            if(httpMethod0 == HttpMethod.POST) {
                httpURLConnection0.setDoOutput(true);
                try {
                    bufferedOutputStream1 = new BufferedOutputStream(httpURLConnection0.getOutputStream());
                }
                catch(Throwable throwable0) {
                    goto label_56;
                }
                if(z) {
                    try {
                        bufferedOutputStream1 = new GZIPOutputStream(bufferedOutputStream1);
                        goto label_40;
                    }
                    catch(Throwable throwable1) {
                        throwable2 = throwable1;
                        bufferedOutputStream0 = bufferedOutputStream1;
                    }
                }
                else {
                    try {
                    label_40:
                        if(this.hasOnProgressCallbacks(graphRequestBatch0)) {
                            ProgressNoopOutputStream progressNoopOutputStream0 = new ProgressNoopOutputStream(graphRequestBatch0.getCallbackHandler());
                            this.processRequest(graphRequestBatch0, null, v, uRL0, progressNoopOutputStream0, z);
                            uRL1 = uRL0;
                            bufferedOutputStream2 = new ProgressOutputStream(bufferedOutputStream1, graphRequestBatch0, progressNoopOutputStream0.getProgressMap(), ((long)progressNoopOutputStream0.getMaxProgress()));
                        }
                        else {
                            uRL1 = uRL0;
                            bufferedOutputStream2 = bufferedOutputStream1;
                        }
                    }
                    catch(Throwable throwable0) {
                        bufferedOutputStream0 = bufferedOutputStream1;
                        goto label_56;
                    }
                    try {
                        this.processRequest(graphRequestBatch0, logger0, v, uRL1, bufferedOutputStream2, z);
                        goto label_60;
                    }
                    catch(Throwable throwable0) {
                        bufferedOutputStream0 = bufferedOutputStream2;
                    }
                label_56:
                    throwable2 = throwable0;
                }
                if(bufferedOutputStream0 != null) {
                    bufferedOutputStream0.close();
                }
                throw throwable2;
            label_60:
                bufferedOutputStream2.close();
                logger0.log();
                return;
            }
            logger0.log();
        }

        private final void setConnectionContentType(HttpURLConnection httpURLConnection0, boolean z) {
            if(z) {
                httpURLConnection0.setRequestProperty("Content-Type", "application/x-www-form-urlencoded");
                httpURLConnection0.setRequestProperty("Content-Encoding", "gzip");
                return;
            }
            httpURLConnection0.setRequestProperty("Content-Type", "multipart/form-data; boundary=j833RtNfI-wT2QTv01aPEpPaG1LKQm8");
        }

        public final void setDefaultBatchApplicationId(@Nullable String s) {
            GraphRequest.defaultBatchApplicationId = s;
        }

        @NotNull
        public final HttpURLConnection toHttpConnection(@NotNull GraphRequestBatch graphRequestBatch0) {
            HttpURLConnection httpURLConnection0;
            URL uRL0;
            q.g(graphRequestBatch0, "requests");
            this.validateFieldsParamForGetRequests$facebook_core_release(graphRequestBatch0);
            try {
                uRL0 = graphRequestBatch0.size() == 1 ? new URL(graphRequestBatch0.get(0).getUrlForSingleRequest()) : new URL(ServerProtocol.getGraphUrlBase());
                goto label_9;
            }
            catch(MalformedURLException malformedURLException0) {
            }
            throw new FacebookException("could not construct URL for request", malformedURLException0);
            try {
            label_9:
                httpURLConnection0 = null;
                httpURLConnection0 = this.createConnection(uRL0);
                this.serializeToUrlConnection$facebook_core_release(graphRequestBatch0, httpURLConnection0);
                return httpURLConnection0;
            }
            catch(IOException iOException0) {
                Utility.disconnectQuietly(httpURLConnection0);
                throw new FacebookException("could not construct request body", iOException0);
            }
            catch(JSONException jSONException0) {
                Utility.disconnectQuietly(httpURLConnection0);
                throw new FacebookException("could not construct request body", jSONException0);
            }
        }

        @NotNull
        public final HttpURLConnection toHttpConnection(@NotNull Collection collection0) {
            q.g(collection0, "requests");
            Validate.notEmpty(collection0, "requests");
            return this.toHttpConnection(new GraphRequestBatch(collection0));
        }

        @NotNull
        public final HttpURLConnection toHttpConnection(@NotNull GraphRequest[] arr_graphRequest) {
            q.g(arr_graphRequest, "requests");
            return this.toHttpConnection(n.z0(arr_graphRequest));
        }

        public final void validateFieldsParamForGetRequests$facebook_core_release(@NotNull GraphRequestBatch graphRequestBatch0) {
            q.g(graphRequestBatch0, "requests");
            for(Object object0: graphRequestBatch0) {
                GraphRequest graphRequest0 = (GraphRequest)object0;
                if(HttpMethod.GET == graphRequest0.getHttpMethod() && Utility.isNullOrEmpty(graphRequest0.getParameters().getString("fields"))) {
                    StringBuilder stringBuilder0 = new StringBuilder("GET requests for /");
                    Logger.Companion.log(LoggingBehavior.DEVELOPER_ERRORS, 5, "Request", x.m(stringBuilder0, (graphRequest0.getGraphPath() == null ? "" : graphRequest0.getGraphPath()), " should contain an explicit \"fields\" parameter."));
                }
            }
        }
    }

    @Metadata(d1 = {"\u0000\u001C\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\bæ\u0080\u0001\u0018\u00002\u00020\u0001J#\u0010\u0007\u001A\u00020\u00062\b\u0010\u0003\u001A\u0004\u0018\u00010\u00022\b\u0010\u0005\u001A\u0004\u0018\u00010\u0004H&¢\u0006\u0004\b\u0007\u0010\b¨\u0006\t"}, d2 = {"Lcom/facebook/GraphRequest$GraphJSONArrayCallback;", "", "Lorg/json/JSONArray;", "objects", "Lcom/facebook/GraphResponse;", "response", "Lie/H;", "onCompleted", "(Lorg/json/JSONArray;Lcom/facebook/GraphResponse;)V", "facebook-core_release"}, k = 1, mv = {1, 8, 0}, xi = 0x30)
    public interface GraphJSONArrayCallback {
        void onCompleted(@Nullable JSONArray arg1, @Nullable GraphResponse arg2);
    }

    @Metadata(d1 = {"\u0000\u001C\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\bæ\u0080\u0001\u0018\u00002\u00020\u0001J#\u0010\u0007\u001A\u00020\u00062\b\u0010\u0003\u001A\u0004\u0018\u00010\u00022\b\u0010\u0005\u001A\u0004\u0018\u00010\u0004H&¢\u0006\u0004\b\u0007\u0010\b¨\u0006\t"}, d2 = {"Lcom/facebook/GraphRequest$GraphJSONObjectCallback;", "", "Lorg/json/JSONObject;", "obj", "Lcom/facebook/GraphResponse;", "response", "Lie/H;", "onCompleted", "(Lorg/json/JSONObject;Lcom/facebook/GraphResponse;)V", "facebook-core_release"}, k = 1, mv = {1, 8, 0}, xi = 0x30)
    public interface GraphJSONObjectCallback {
        void onCompleted(@Nullable JSONObject arg1, @Nullable GraphResponse arg2);
    }

    @Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000E\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\bâ\u0080\u0001\u0018\u00002\u00020\u0001J\u001F\u0010\u0006\u001A\u00020\u00052\u0006\u0010\u0003\u001A\u00020\u00022\u0006\u0010\u0004\u001A\u00020\u0002H&¢\u0006\u0004\b\u0006\u0010\u0007¨\u0006\b"}, d2 = {"Lcom/facebook/GraphRequest$KeyValueSerializer;", "", "", "key", "value", "Lie/H;", "writeString", "(Ljava/lang/String;Ljava/lang/String;)V", "facebook-core_release"}, k = 1, mv = {1, 8, 0}, xi = 0x30)
    interface KeyValueSerializer {
        void writeString(@NotNull String arg1, @NotNull String arg2);
    }

    @Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\bf\u0018\u00002\u00020\u0001J\u001F\u0010\u0006\u001A\u00020\u00052\u0006\u0010\u0003\u001A\u00020\u00022\u0006\u0010\u0004\u001A\u00020\u0002H&¢\u0006\u0004\b\u0006\u0010\u0007¨\u0006\b"}, d2 = {"Lcom/facebook/GraphRequest$OnProgressCallback;", "Lcom/facebook/GraphRequest$Callback;", "", "current", "max", "Lie/H;", "onProgress", "(JJ)V", "facebook-core_release"}, k = 1, mv = {1, 8, 0}, xi = 0x30)
    public interface com.facebook.GraphRequest.OnProgressCallback extends Callback {
        void onProgress(long arg1, long arg2);
    }

    @Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000E\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\n\u0018\u0000 \u0019*\n\b\u0000\u0010\u0002*\u0004\u0018\u00010\u00012\u00020\u0001:\u0001\u0019B\u001B\b\u0016\u0012\u0006\u0010\u0003\u001A\u00028\u0000\u0012\b\u0010\u0005\u001A\u0004\u0018\u00010\u0004¢\u0006\u0004\b\u0006\u0010\u0007B\u0011\b\u0012\u0012\u0006\u0010\t\u001A\u00020\b¢\u0006\u0004\b\u0006\u0010\nJ\u000F\u0010\f\u001A\u00020\u000BH\u0016¢\u0006\u0004\b\f\u0010\rJ\u001F\u0010\u0011\u001A\u00020\u00102\u0006\u0010\u000E\u001A\u00020\b2\u0006\u0010\u000F\u001A\u00020\u000BH\u0016¢\u0006\u0004\b\u0011\u0010\u0012R\u0019\u0010\u0005\u001A\u0004\u0018\u00010\u00048\u0006¢\u0006\f\n\u0004\b\u0005\u0010\u0013\u001A\u0004\b\u0014\u0010\u0015R\u0019\u0010\u0003\u001A\u0004\u0018\u00018\u00008\u0006¢\u0006\f\n\u0004\b\u0003\u0010\u0016\u001A\u0004\b\u0017\u0010\u0018¨\u0006\u001A"}, d2 = {"Lcom/facebook/GraphRequest$ParcelableResourceWithMimeType;", "Landroid/os/Parcelable;", "RESOURCE", "resource", "", "mimeType", "<init>", "(Landroid/os/Parcelable;Ljava/lang/String;)V", "Landroid/os/Parcel;", "source", "(Landroid/os/Parcel;)V", "", "describeContents", "()I", "out", "flags", "Lie/H;", "writeToParcel", "(Landroid/os/Parcel;I)V", "Ljava/lang/String;", "getMimeType", "()Ljava/lang/String;", "Landroid/os/Parcelable;", "getResource", "()Landroid/os/Parcelable;", "Companion", "facebook-core_release"}, k = 1, mv = {1, 8, 0}, xi = 0x30)
    public static final class ParcelableResourceWithMimeType implements Parcelable {
        @Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u001C\u0010\u0003\u001A\u000E\u0012\n\u0012\b\u0012\u0002\b\u0003\u0018\u00010\u00050\u00048\u0006X\u0087\u0004¢\u0006\u0002\n\u0000¨\u0006\u0006"}, d2 = {"Lcom/facebook/GraphRequest$ParcelableResourceWithMimeType$Companion;", "", "()V", "CREATOR", "Landroid/os/Parcelable$Creator;", "Lcom/facebook/GraphRequest$ParcelableResourceWithMimeType;", "facebook-core_release"}, k = 1, mv = {1, 8, 0}, xi = 0x30)
        public static final class com.facebook.GraphRequest.ParcelableResourceWithMimeType.Companion {
            private com.facebook.GraphRequest.ParcelableResourceWithMimeType.Companion() {
            }

            public com.facebook.GraphRequest.ParcelableResourceWithMimeType.Companion(DefaultConstructorMarker defaultConstructorMarker0) {
            }
        }

        @NotNull
        public static final Parcelable.Creator CREATOR;
        @NotNull
        public static final com.facebook.GraphRequest.ParcelableResourceWithMimeType.Companion Companion;
        @Nullable
        private final String mimeType;
        @Nullable
        private final Parcelable resource;

        static {
            ParcelableResourceWithMimeType.Companion = new com.facebook.GraphRequest.ParcelableResourceWithMimeType.Companion(null);
            ParcelableResourceWithMimeType.CREATOR = new GraphRequest.ParcelableResourceWithMimeType.Companion.CREATOR.1();
        }

        private ParcelableResourceWithMimeType(Parcel parcel0) {
            this.mimeType = parcel0.readString();
            this.resource = parcel0.readParcelable(FacebookSdk.getApplicationContext().getClassLoader());
        }

        public ParcelableResourceWithMimeType(Parcel parcel0, DefaultConstructorMarker defaultConstructorMarker0) {
            this(parcel0);
        }

        public ParcelableResourceWithMimeType(Parcelable parcelable0, @Nullable String s) {
            this.mimeType = s;
            this.resource = parcelable0;
        }

        @Override  // android.os.Parcelable
        public int describeContents() {
            return 1;
        }

        @Nullable
        public final String getMimeType() {
            return this.mimeType;
        }

        @Nullable
        public final Parcelable getResource() {
            return this.resource;
        }

        @Override  // android.os.Parcelable
        public void writeToParcel(@NotNull Parcel parcel0, int v) {
            q.g(parcel0, "out");
            parcel0.writeString(this.mimeType);
            parcel0.writeParcelable(this.resource, v);
        }
    }

    @Metadata(d1 = {"\u0000x\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000B\n\u0002\b\u0003\n\u0002\u0010\u000E\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u001E\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0012\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u000B\n\u0002\u0010\u0011\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0002\u0018\u00002\u00020\u0001B!\u0012\u0006\u0010\u0003\u001A\u00020\u0002\u0012\b\u0010\u0005\u001A\u0004\u0018\u00010\u0004\u0012\u0006\u0010\u0007\u001A\u00020\u0006\u00A2\u0006\u0004\b\b\u0010\tJ)\u0010\u0011\u001A\u00020\u00102\u0006\u0010\u000B\u001A\u00020\n2\b\u0010\r\u001A\u0004\u0018\u00010\f2\b\u0010\u000F\u001A\u0004\u0018\u00010\u000E\u00A2\u0006\u0004\b\u0011\u0010\u0012J+\u0010\u0017\u001A\u00020\u00102\u0006\u0010\u000B\u001A\u00020\n2\u0006\u0010\u0014\u001A\u00020\u00132\f\u0010\u0016\u001A\b\u0012\u0004\u0012\u00020\u000E0\u0015\u00A2\u0006\u0004\b\u0017\u0010\u0018J\u001F\u0010\u0019\u001A\u00020\u00102\u0006\u0010\u000B\u001A\u00020\n2\u0006\u0010\r\u001A\u00020\nH\u0016\u00A2\u0006\u0004\b\u0019\u0010\u001AJ\u001D\u0010\u001D\u001A\u00020\u00102\u0006\u0010\u000B\u001A\u00020\n2\u0006\u0010\u001C\u001A\u00020\u001B\u00A2\u0006\u0004\b\u001D\u0010\u001EJ\u001D\u0010!\u001A\u00020\u00102\u0006\u0010\u000B\u001A\u00020\n2\u0006\u0010 \u001A\u00020\u001F\u00A2\u0006\u0004\b!\u0010\"J\'\u0010&\u001A\u00020\u00102\u0006\u0010\u000B\u001A\u00020\n2\u0006\u0010$\u001A\u00020#2\b\u0010%\u001A\u0004\u0018\u00010\n\u00A2\u0006\u0004\b&\u0010\'J\'\u0010*\u001A\u00020\u00102\u0006\u0010\u000B\u001A\u00020\n2\u0006\u0010)\u001A\u00020(2\b\u0010%\u001A\u0004\u0018\u00010\n\u00A2\u0006\u0004\b*\u0010+J\r\u0010,\u001A\u00020\u0010\u00A2\u0006\u0004\b,\u0010-J+\u00101\u001A\u00020\u00102\b\u0010.\u001A\u0004\u0018\u00010\n2\b\u0010/\u001A\u0004\u0018\u00010\n2\b\u00100\u001A\u0004\u0018\u00010\n\u00A2\u0006\u0004\b1\u00102J-\u00106\u001A\u00020\u00102\u0006\u00103\u001A\u00020\n2\u0016\u00105\u001A\f\u0012\b\b\u0001\u0012\u0004\u0018\u00010\f04\"\u0004\u0018\u00010\f\u00A2\u0006\u0004\b6\u00107J-\u00108\u001A\u00020\u00102\u0006\u00103\u001A\u00020\n2\u0016\u00105\u001A\f\u0012\b\b\u0001\u0012\u0004\u0018\u00010\f04\"\u0004\u0018\u00010\f\u00A2\u0006\u0004\b8\u00107R\u0014\u0010\u0003\u001A\u00020\u00028\u0002X\u0082\u0004\u00A2\u0006\u0006\n\u0004\b\u0003\u00109R\u0016\u0010\u0005\u001A\u0004\u0018\u00010\u00048\u0002X\u0082\u0004\u00A2\u0006\u0006\n\u0004\b\u0005\u0010:R\u0016\u0010;\u001A\u00020\u00068\u0002@\u0002X\u0082\u000E\u00A2\u0006\u0006\n\u0004\b;\u0010<R\u0014\u0010\u0007\u001A\u00020\u00068\u0002X\u0082\u0004\u00A2\u0006\u0006\n\u0004\b\u0007\u0010<R\u0018\u0010A\u001A\u00060=j\u0002`>8BX\u0082\u0004\u00A2\u0006\u0006\u001A\u0004\b?\u0010@\u00A8\u0006B"}, d2 = {"Lcom/facebook/GraphRequest$Serializer;", "Lcom/facebook/GraphRequest$KeyValueSerializer;", "Ljava/io/OutputStream;", "outputStream", "Lcom/facebook/internal/Logger;", "logger", "", "useUrlEncode", "<init>", "(Ljava/io/OutputStream;Lcom/facebook/internal/Logger;Z)V", "", "key", "", "value", "Lcom/facebook/GraphRequest;", "request", "Lie/H;", "writeObject", "(Ljava/lang/String;Ljava/lang/Object;Lcom/facebook/GraphRequest;)V", "Lorg/json/JSONArray;", "requestJsonArray", "", "requests", "writeRequestsAsJson", "(Ljava/lang/String;Lorg/json/JSONArray;Ljava/util/Collection;)V", "writeString", "(Ljava/lang/String;Ljava/lang/String;)V", "Landroid/graphics/Bitmap;", "bitmap", "writeBitmap", "(Ljava/lang/String;Landroid/graphics/Bitmap;)V", "", "bytes", "writeBytes", "(Ljava/lang/String;[B)V", "Landroid/net/Uri;", "contentUri", "mimeType", "writeContentUri", "(Ljava/lang/String;Landroid/net/Uri;Ljava/lang/String;)V", "Landroid/os/ParcelFileDescriptor;", "descriptor", "writeFile", "(Ljava/lang/String;Landroid/os/ParcelFileDescriptor;Ljava/lang/String;)V", "writeRecordBoundary", "()V", "name", "filename", "contentType", "writeContentDisposition", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V", "format", "", "args", "write", "(Ljava/lang/String;[Ljava/lang/Object;)V", "writeLine", "Ljava/io/OutputStream;", "Lcom/facebook/internal/Logger;", "firstWrite", "Z", "Ljava/lang/RuntimeException;", "Lkotlin/RuntimeException;", "getInvalidTypeError", "()Ljava/lang/RuntimeException;", "invalidTypeError", "facebook-core_release"}, k = 1, mv = {1, 8, 0}, xi = 0x30)
    static final class Serializer implements KeyValueSerializer {
        private boolean firstWrite;
        @Nullable
        private final Logger logger;
        @NotNull
        private final OutputStream outputStream;
        private final boolean useUrlEncode;

        public Serializer(@NotNull OutputStream outputStream0, @Nullable Logger logger0, boolean z) {
            q.g(outputStream0, "outputStream");
            super();
            this.outputStream = outputStream0;
            this.logger = logger0;
            this.firstWrite = true;
            this.useUrlEncode = z;
        }

        private final RuntimeException getInvalidTypeError() {
            return new IllegalArgumentException("value is not a supported type.");
        }

        public final void write(@NotNull String s, @NotNull Object[] arr_object) {
            q.g(s, "format");
            q.g(arr_object, "args");
            if(!this.useUrlEncode) {
                if(this.firstWrite) {
                    byte[] arr_b = "--".getBytes(a.a);
                    q.f(arr_b, "this as java.lang.String).getBytes(charset)");
                    this.outputStream.write(arr_b);
                    byte[] arr_b1 = "NZZxSw0EskyuXizQuqTB-fX2cxkOKtnScnQNBa".getBytes(a.a);
                    q.f(arr_b1, "this as java.lang.String).getBytes(charset)");
                    this.outputStream.write(arr_b1);
                    byte[] arr_b2 = "\r\n".getBytes(a.a);
                    q.f(arr_b2, "this as java.lang.String).getBytes(charset)");
                    this.outputStream.write(arr_b2);
                    this.firstWrite = false;
                }
                Object[] arr_object1 = Arrays.copyOf(arr_object, arr_object.length);
                byte[] arr_b3 = String.format(s, Arrays.copyOf(arr_object1, arr_object1.length)).getBytes(a.a);
                q.f(arr_b3, "this as java.lang.String).getBytes(charset)");
                this.outputStream.write(arr_b3);
                return;
            }
            Locale locale0 = Locale.US;
            Object[] arr_object2 = Arrays.copyOf(arr_object, arr_object.length);
            String s1 = URLEncoder.encode(String.format(locale0, s, Arrays.copyOf(arr_object2, arr_object2.length)), "UTF-8");
            q.f(s1, "encode(String.format(Loc… format, *args), \"UTF-8\")");
            byte[] arr_b4 = s1.getBytes(a.a);
            q.f(arr_b4, "this as java.lang.String).getBytes(charset)");
            this.outputStream.write(arr_b4);
        }

        public final void writeBitmap(@NotNull String s, @NotNull Bitmap bitmap0) {
            q.g(s, "key");
            q.g(bitmap0, "bitmap");
            this.writeContentDisposition(s, s, "image/png");
            bitmap0.compress(Bitmap.CompressFormat.PNG, 100, this.outputStream);
            this.writeLine("", new Object[0]);
            this.writeRecordBoundary();
            Logger logger0 = this.logger;
            if(logger0 != null) {
                logger0.appendKeyValue("    " + s, "<Image>");
            }
        }

        public final void writeBytes(@NotNull String s, @NotNull byte[] arr_b) {
            q.g(s, "key");
            q.g(arr_b, "bytes");
            this.writeContentDisposition(s, s, "content/unknown");
            this.outputStream.write(arr_b);
            this.writeLine("", new Object[0]);
            this.writeRecordBoundary();
            Logger logger0 = this.logger;
            if(logger0 != null) {
                logger0.appendKeyValue("    " + s, String.format(Locale.ROOT, "<Data: %d>", Arrays.copyOf(new Object[]{((int)arr_b.length)}, 1)));
            }
        }

        public final void writeContentDisposition(@Nullable String s, @Nullable String s1, @Nullable String s2) {
            if(!this.useUrlEncode) {
                this.write("Content-Disposition: form-data; name=\"%s\"", new Object[]{s});
                if(s1 != null) {
                    this.write("; filename=\"%s\"", new Object[]{s1});
                }
                this.writeLine("", new Object[0]);
                if(s2 != null) {
                    this.writeLine("%s: %s", new Object[]{"Content-Type", s2});
                }
                this.writeLine("", new Object[0]);
                return;
            }
            byte[] arr_b = String.format("%s=", Arrays.copyOf(new Object[]{s}, 1)).getBytes(a.a);
            q.f(arr_b, "this as java.lang.String).getBytes(charset)");
            this.outputStream.write(arr_b);
        }

        public final void writeContentUri(@NotNull String s, @NotNull Uri uri0, @Nullable String s1) {
            int v1;
            q.g(s, "key");
            q.g(uri0, "contentUri");
            if(s1 == null) {
                s1 = "content/unknown";
            }
            this.writeContentDisposition(s, s, s1);
            if(this.outputStream instanceof ProgressNoopOutputStream) {
                long v = Utility.getContentSize(uri0);
                ((ProgressNoopOutputStream)this.outputStream).addProgress(v);
                v1 = 0;
            }
            else {
                v1 = Utility.copyAndCloseInputStream(FacebookSdk.getApplicationContext().getContentResolver().openInputStream(uri0), this.outputStream);
            }
            this.writeLine("", new Object[0]);
            this.writeRecordBoundary();
            Logger logger0 = this.logger;
            if(logger0 != null) {
                logger0.appendKeyValue("    " + s, String.format(Locale.ROOT, "<Data: %d>", Arrays.copyOf(new Object[]{v1}, 1)));
            }
        }

        public final void writeFile(@NotNull String s, @NotNull ParcelFileDescriptor parcelFileDescriptor0, @Nullable String s1) {
            int v;
            q.g(s, "key");
            q.g(parcelFileDescriptor0, "descriptor");
            if(s1 == null) {
                s1 = "content/unknown";
            }
            this.writeContentDisposition(s, s, s1);
            OutputStream outputStream0 = this.outputStream;
            if(outputStream0 instanceof ProgressNoopOutputStream) {
                ((ProgressNoopOutputStream)outputStream0).addProgress(parcelFileDescriptor0.getStatSize());
                v = 0;
            }
            else {
                v = Utility.copyAndCloseInputStream(new ParcelFileDescriptor.AutoCloseInputStream(parcelFileDescriptor0), this.outputStream);
            }
            this.writeLine("", new Object[0]);
            this.writeRecordBoundary();
            Logger logger0 = this.logger;
            if(logger0 != null) {
                logger0.appendKeyValue("    " + s, String.format(Locale.ROOT, "<Data: %d>", Arrays.copyOf(new Object[]{v}, 1)));
            }
        }

        public final void writeLine(@NotNull String s, @NotNull Object[] arr_object) {
            q.g(s, "format");
            q.g(arr_object, "args");
            this.write(s, Arrays.copyOf(arr_object, arr_object.length));
            if(!this.useUrlEncode) {
                this.write("\r\n", new Object[0]);
            }
        }

        public final void writeObject(@NotNull String s, @Nullable Object object0, @Nullable GraphRequest graphRequest0) {
            q.g(s, "key");
            OutputStream outputStream0 = this.outputStream;
            if(outputStream0 instanceof RequestOutputStream) {
                q.e(outputStream0, "null cannot be cast to non-null type com.facebook.RequestOutputStream");
                ((RequestOutputStream)outputStream0).setCurrentRequest(graphRequest0);
            }
            Companion graphRequest$Companion0 = GraphRequest.Companion;
            if(graphRequest$Companion0.isSupportedParameterType(object0)) {
                this.writeString(s, graphRequest$Companion0.parameterToString(object0));
                return;
            }
            if(object0 instanceof Bitmap) {
                this.writeBitmap(s, ((Bitmap)object0));
                return;
            }
            if(object0 instanceof byte[]) {
                this.writeBytes(s, ((byte[])object0));
                return;
            }
            if(object0 instanceof Uri) {
                this.writeContentUri(s, ((Uri)object0), null);
                return;
            }
            if(object0 instanceof ParcelFileDescriptor) {
                this.writeFile(s, ((ParcelFileDescriptor)object0), null);
                return;
            }
            if(!(object0 instanceof ParcelableResourceWithMimeType)) {
                throw this.getInvalidTypeError();
            }
            Parcelable parcelable0 = ((ParcelableResourceWithMimeType)object0).getResource();
            String s1 = ((ParcelableResourceWithMimeType)object0).getMimeType();
            if(parcelable0 instanceof ParcelFileDescriptor) {
                this.writeFile(s, ((ParcelFileDescriptor)parcelable0), s1);
                return;
            }
            if(!(parcelable0 instanceof Uri)) {
                throw this.getInvalidTypeError();
            }
            this.writeContentUri(s, ((Uri)parcelable0), s1);
        }

        public final void writeRecordBoundary() {
            if(!this.useUrlEncode) {
                this.writeLine("--%s", new Object[]{"U1mJF5Q4d7eMEMMMeKo71m76mFeA20aaa00"});
                return;
            }
            byte[] arr_b = "&".getBytes(a.a);
            q.f(arr_b, "this as java.lang.String).getBytes(charset)");
            this.outputStream.write(arr_b);
        }

        public final void writeRequestsAsJson(@NotNull String s, @NotNull JSONArray jSONArray0, @NotNull Collection collection0) {
            q.g(s, "key");
            q.g(jSONArray0, "requestJsonArray");
            q.g(collection0, "requests");
            OutputStream outputStream0 = this.outputStream;
            if(!(outputStream0 instanceof RequestOutputStream)) {
                String s1 = jSONArray0.toString();
                q.f(s1, "requestJsonArray.toString()");
                this.writeString(s, s1);
                return;
            }
            q.e(outputStream0, "null cannot be cast to non-null type com.facebook.RequestOutputStream");
            this.writeContentDisposition(s, null, null);
            this.write("[", new Object[0]);
            int v = 0;
            for(Object object0: collection0) {
                JSONObject jSONObject0 = jSONArray0.getJSONObject(v);
                ((RequestOutputStream)outputStream0).setCurrentRequest(((GraphRequest)object0));
                if(v > 0) {
                    this.write(",%s", new Object[]{jSONObject0.toString()});
                }
                else {
                    this.write("%s", new Object[]{jSONObject0.toString()});
                }
                ++v;
            }
            this.write("]", new Object[0]);
            Logger logger0 = this.logger;
            if(logger0 != null) {
                String s2 = jSONArray0.toString();
                q.f(s2, "requestJsonArray.toString()");
                logger0.appendKeyValue("    " + s, s2);
            }
        }

        @Override  // com.facebook.GraphRequest$KeyValueSerializer
        public void writeString(@NotNull String s, @NotNull String s1) {
            q.g(s, "key");
            q.g(s1, "value");
            this.writeContentDisposition(s, null, null);
            this.writeLine("%s", new Object[]{s1});
            this.writeRecordBoundary();
            Logger logger0 = this.logger;
            if(logger0 != null) {
                logger0.appendKeyValue("    " + s, s1);
            }
        }
    }

    @NotNull
    private static final String ACCEPT_LANGUAGE_HEADER = "Accept-Language";
    @NotNull
    public static final String ACCESS_TOKEN_PARAM = "access_token";
    @NotNull
    private static final String ATTACHED_FILES_PARAM = "attached_files";
    @NotNull
    private static final String ATTACHMENT_FILENAME_PREFIX = "file";
    @NotNull
    private static final String BATCH_APP_ID_PARAM = "batch_app_id";
    @NotNull
    private static final String BATCH_BODY_PARAM = "body";
    @NotNull
    private static final String BATCH_ENTRY_DEPENDS_ON_PARAM = "depends_on";
    @NotNull
    private static final String BATCH_ENTRY_NAME_PARAM = "name";
    @NotNull
    private static final String BATCH_ENTRY_OMIT_RESPONSE_ON_SUCCESS_PARAM = "omit_response_on_success";
    @NotNull
    private static final String BATCH_METHOD_PARAM = "method";
    @NotNull
    private static final String BATCH_PARAM = "batch";
    @NotNull
    private static final String BATCH_RELATIVE_URL_PARAM = "relative_url";
    @NotNull
    private static final String CAPTION_PARAM = "caption";
    @NotNull
    private static final String CONTENT_ENCODING_HEADER = "Content-Encoding";
    @NotNull
    private static final String CONTENT_TYPE_HEADER = "Content-Type";
    @NotNull
    public static final Companion Companion = null;
    @NotNull
    private static final String DEBUG_KEY = "__debug__";
    @NotNull
    private static final String DEBUG_MESSAGES_KEY = "messages";
    @NotNull
    private static final String DEBUG_MESSAGE_KEY = "message";
    @NotNull
    private static final String DEBUG_MESSAGE_LINK_KEY = "link";
    @NotNull
    private static final String DEBUG_MESSAGE_TYPE_KEY = "type";
    @NotNull
    private static final String DEBUG_PARAM = "debug";
    @NotNull
    private static final String DEBUG_SEVERITY_INFO = "info";
    @NotNull
    private static final String DEBUG_SEVERITY_WARNING = "warning";
    @NotNull
    public static final String FIELDS_PARAM = "fields";
    @NotNull
    private static final String FORMAT_JSON = "json";
    @NotNull
    private static final String FORMAT_PARAM = "format";
    @NotNull
    private static final String ISO_8601_FORMAT_STRING = "yyyy-MM-dd\'T\'HH:mm:ssZ";
    public static final int MAXIMUM_BATCH_SIZE = 50;
    @NotNull
    private static final String ME = "me";
    @NotNull
    private static final String MIME_BOUNDARY = null;
    @NotNull
    private static final String MY_FRIENDS = "me/friends";
    @NotNull
    private static final String MY_PHOTOS = "me/photos";
    @NotNull
    private static final String PICTURE_PARAM = "picture";
    @NotNull
    private static final String SDK_ANDROID = "android";
    @NotNull
    private static final String SDK_PARAM = "sdk";
    @NotNull
    private static final String SEARCH = "search";
    public static final String TAG = null;
    @NotNull
    private static final String USER_AGENT_BASE = "FBAndroidSDK";
    @NotNull
    private static final String USER_AGENT_HEADER = "User-Agent";
    @NotNull
    private static final String VIDEOS_SUFFIX = "/videos";
    @Nullable
    private AccessToken accessToken;
    @Nullable
    private String batchEntryDependsOn;
    @Nullable
    private String batchEntryName;
    private boolean batchEntryOmitResultOnSuccess;
    @Nullable
    private Callback callback;
    @Nullable
    private static String defaultBatchApplicationId;
    private boolean forceApplicationRequest;
    @Nullable
    private JSONObject graphObject;
    @Nullable
    private String graphPath;
    @Nullable
    private HttpMethod httpMethod;
    @Nullable
    private String overriddenURL;
    @NotNull
    private Bundle parameters;
    @Nullable
    private Object tag;
    @Nullable
    private static volatile String userAgent;
    @Nullable
    private String version;
    private static final Pattern versionPattern;

    static {
        GraphRequest.Companion = new Companion(null);
        GraphRequest.TAG = "GraphRequest";
        char[] arr_c = "-_1234567890abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ".toCharArray();
        q.f(arr_c, "this as java.lang.String).toCharArray()");
        StringBuilder stringBuilder0 = new StringBuilder();
        SecureRandom secureRandom0 = new SecureRandom();
        int v = secureRandom0.nextInt(11);
        for(int v1 = 0; v1 < v + 30; ++v1) {
            stringBuilder0.append(arr_c[secureRandom0.nextInt(arr_c.length)]);
        }
        q.f("U7vHeOxj_6hXLHuLdvgqs89KfFd2CDvWqnBj_ngk", "buffer.toString()");
        GraphRequest.MIME_BOUNDARY = "U7vHeOxj_6hXLHuLdvgqs89KfFd2CDvWqnBj_ngk";
        GraphRequest.versionPattern = Pattern.compile("^/?v\\d+\\.\\d+/(.*)");
    }

    public GraphRequest() {
        this(null, null, null, null, null, null, 0x3F, null);
    }

    public GraphRequest(@Nullable AccessToken accessToken0) {
        this(accessToken0, null, null, null, null, null, 62, null);
    }

    public GraphRequest(@Nullable AccessToken accessToken0, @Nullable String s) {
        this(accessToken0, s, null, null, null, null, 60, null);
    }

    public GraphRequest(@Nullable AccessToken accessToken0, @Nullable String s, @Nullable Bundle bundle0) {
        this(accessToken0, s, bundle0, null, null, null, 56, null);
    }

    public GraphRequest(@Nullable AccessToken accessToken0, @Nullable String s, @Nullable Bundle bundle0, @Nullable HttpMethod httpMethod0) {
        this(accessToken0, s, bundle0, httpMethod0, null, null, 0x30, null);
    }

    public GraphRequest(@Nullable AccessToken accessToken0, @Nullable String s, @Nullable Bundle bundle0, @Nullable HttpMethod httpMethod0, @Nullable Callback graphRequest$Callback0) {
        this(accessToken0, s, bundle0, httpMethod0, graphRequest$Callback0, null, 0x20, null);
    }

    public GraphRequest(@Nullable AccessToken accessToken0, @Nullable String s, @Nullable Bundle bundle0, @Nullable HttpMethod httpMethod0, @Nullable Callback graphRequest$Callback0, @Nullable String s1) {
        this.batchEntryOmitResultOnSuccess = true;
        this.accessToken = accessToken0;
        this.graphPath = s;
        this.version = s1;
        this.setCallback(graphRequest$Callback0);
        this.setHttpMethod(httpMethod0);
        this.parameters = bundle0 == null ? new Bundle() : new Bundle(bundle0);
        if(this.version == null) {
            this.version = FacebookSdk.getGraphApiVersion();
        }
    }

    public GraphRequest(AccessToken accessToken0, String s, Bundle bundle0, HttpMethod httpMethod0, Callback graphRequest$Callback0, String s1, int v, DefaultConstructorMarker defaultConstructorMarker0) {
        if((v & 1) != 0) {
            accessToken0 = null;
        }
        if((v & 2) != 0) {
            s = null;
        }
        if((v & 4) != 0) {
            bundle0 = null;
        }
        if((v & 8) != 0) {
            httpMethod0 = null;
        }
        if((v & 16) != 0) {
            graphRequest$Callback0 = null;
        }
        this(accessToken0, s, bundle0, httpMethod0, graphRequest$Callback0, ((v & 0x20) == 0 ? s1 : null));
    }

    public GraphRequest(@Nullable AccessToken accessToken0, @NotNull URL uRL0) {
        q.g(uRL0, "overriddenURL");
        super();
        this.batchEntryOmitResultOnSuccess = true;
        this.accessToken = accessToken0;
        this.overriddenURL = uRL0.toString();
        this.setHttpMethod(HttpMethod.GET);
        this.parameters = new Bundle();
    }

    private static final void _set_callback_$lambda$0(Callback graphRequest$Callback0, GraphResponse graphResponse0) {
        q.g(graphResponse0, "response");
        JSONObject jSONObject0 = graphResponse0.getJSONObject();
        JSONObject jSONObject1 = jSONObject0 == null ? null : jSONObject0.optJSONObject("__debug__");
        JSONArray jSONArray0 = jSONObject1 == null ? null : jSONObject1.optJSONArray("messages");
        if(jSONArray0 != null) {
            int v = jSONArray0.length();
            for(int v1 = 0; v1 < v; ++v1) {
                JSONObject jSONObject2 = jSONArray0.optJSONObject(v1);
                String s = jSONObject2 == null ? null : jSONObject2.optString("message");
                String s1 = jSONObject2 == null ? null : jSONObject2.optString("type");
                String s2 = jSONObject2 == null ? null : jSONObject2.optString("link");
                if(s != null && s1 != null) {
                    LoggingBehavior loggingBehavior0 = s1.equals("warning") ? LoggingBehavior.GRAPH_API_DEBUG_WARNING : LoggingBehavior.GRAPH_API_DEBUG_INFO;
                    if(!Utility.isNullOrEmpty(s2)) {
                        s = s + " Link: " + s2;
                    }
                    q.f("GraphRequest", "TAG");
                    Logger.Companion.log(loggingBehavior0, "GraphRequest", s);
                }
            }
        }
        if(graphRequest$Callback0 != null) {
            graphRequest$Callback0.onCompleted(graphResponse0);
        }
    }

    public static final String access$getMIME_BOUNDARY$cp() [...] // 潜在的解密器

    private final void addCommonParameters() {
        Bundle bundle0 = this.parameters;
        if(this.shouldForceClientTokenForRequest()) {
            bundle0.putString("access_token", this.getClientTokenForRequest());
        }
        else {
            String s = this.getAccessTokenToUseForRequest();
            if(s != null) {
                bundle0.putString("access_token", s);
            }
        }
        if(!bundle0.containsKey("access_token") && Utility.isNullOrEmpty(FacebookSdk.getClientToken())) {
            Log.w("GraphRequest", "Starting with v13 of the SDK, a client token must be embedded in your client code before making Graph API calls. Visit https://developers.facebook.com/docs/android/getting-started#client-token to learn how to implement this change.");
        }
        bundle0.putString("sdk", "android");
        bundle0.putString("format", "json");
        if(FacebookSdk.isLoggingBehaviorEnabled(LoggingBehavior.GRAPH_API_DEBUG_INFO)) {
            bundle0.putString("debug", "info");
            return;
        }
        if(FacebookSdk.isLoggingBehaviorEnabled(LoggingBehavior.GRAPH_API_DEBUG_WARNING)) {
            bundle0.putString("debug", "warning");
        }
    }

    private final String appendParametersToBaseUrl(String s, boolean z) {
        if(!z && this.httpMethod == HttpMethod.POST) {
            return s;
        }
        Uri.Builder uri$Builder0 = Uri.parse(s).buildUpon();
        for(Object object0: this.parameters.keySet()) {
            String s1 = (String)object0;
            String s2 = this.parameters.get(s1);
            if(s2 == null) {
                s2 = "";
            }
            Companion graphRequest$Companion0 = GraphRequest.Companion;
            if(Companion.access$isSupportedParameterType(graphRequest$Companion0, s2)) {
                uri$Builder0.appendQueryParameter(s1, Companion.access$parameterToString(graphRequest$Companion0, s2).toString());
            }
            else {
                if(this.httpMethod != HttpMethod.GET) {
                    throw new IllegalArgumentException(String.format(Locale.US, "Unsupported parameter type for GET request: %s", Arrays.copyOf(new Object[]{s2.getClass().getSimpleName()}, 1)));
                }
                if(false) {
                    break;
                }
            }
        }
        String s3 = uri$Builder0.toString();
        q.f(s3, "uriBuilder.toString()");
        return s3;
    }

    @NotNull
    public static final GraphResponse executeAndWait(@NotNull GraphRequest graphRequest0) {
        return GraphRequest.Companion.executeAndWait(graphRequest0);
    }

    @NotNull
    public final GraphResponse executeAndWait() {
        return GraphRequest.Companion.executeAndWait(this);
    }

    @NotNull
    public final GraphRequestAsyncTask executeAsync() {
        return GraphRequest.Companion.executeBatchAsync(new GraphRequest[]{this});
    }

    @NotNull
    public static final List executeBatchAndWait(@NotNull GraphRequestBatch graphRequestBatch0) {
        return GraphRequest.Companion.executeBatchAndWait(graphRequestBatch0);
    }

    @NotNull
    public static final List executeBatchAndWait(@NotNull Collection collection0) {
        return GraphRequest.Companion.executeBatchAndWait(collection0);
    }

    @NotNull
    public static final List executeBatchAndWait(@NotNull GraphRequest[] arr_graphRequest) {
        return GraphRequest.Companion.executeBatchAndWait(arr_graphRequest);
    }

    @NotNull
    public static final GraphRequestAsyncTask executeBatchAsync(@NotNull GraphRequestBatch graphRequestBatch0) {
        return GraphRequest.Companion.executeBatchAsync(graphRequestBatch0);
    }

    @NotNull
    public static final GraphRequestAsyncTask executeBatchAsync(@NotNull Collection collection0) {
        return GraphRequest.Companion.executeBatchAsync(collection0);
    }

    @NotNull
    public static final GraphRequestAsyncTask executeBatchAsync(@NotNull GraphRequest[] arr_graphRequest) {
        return GraphRequest.Companion.executeBatchAsync(arr_graphRequest);
    }

    @NotNull
    public static final List executeConnectionAndWait(@NotNull HttpURLConnection httpURLConnection0, @NotNull GraphRequestBatch graphRequestBatch0) {
        return GraphRequest.Companion.executeConnectionAndWait(httpURLConnection0, graphRequestBatch0);
    }

    @NotNull
    public static final List executeConnectionAndWait(@NotNull HttpURLConnection httpURLConnection0, @NotNull Collection collection0) {
        return GraphRequest.Companion.executeConnectionAndWait(httpURLConnection0, collection0);
    }

    @NotNull
    public static final GraphRequestAsyncTask executeConnectionAsync(@Nullable Handler handler0, @NotNull HttpURLConnection httpURLConnection0, @NotNull GraphRequestBatch graphRequestBatch0) {
        return GraphRequest.Companion.executeConnectionAsync(handler0, httpURLConnection0, graphRequestBatch0);
    }

    @NotNull
    public static final GraphRequestAsyncTask executeConnectionAsync(@NotNull HttpURLConnection httpURLConnection0, @NotNull GraphRequestBatch graphRequestBatch0) {
        return GraphRequest.Companion.executeConnectionAsync(httpURLConnection0, graphRequestBatch0);
    }

    @Nullable
    public final AccessToken getAccessToken() {
        return this.accessToken;
    }

    private final String getAccessTokenToUseForRequest() {
        AccessToken accessToken0 = this.accessToken;
        if(accessToken0 != null) {
            if(!this.parameters.containsKey("access_token")) {
                String s = accessToken0.getToken();
                Logger.Companion.registerAccessToken(s);
                return s;
            }
            return this.parameters.getString("access_token");
        }
        return this.parameters.containsKey("access_token") ? this.parameters.getString("access_token") : this.getClientTokenForRequest();
    }

    @Nullable
    public final String getBatchEntryDependsOn() {
        return this.batchEntryDependsOn;
    }

    @Nullable
    public final String getBatchEntryName() {
        return this.batchEntryName;
    }

    public final boolean getBatchEntryOmitResultOnSuccess() {
        return this.batchEntryOmitResultOnSuccess;
    }

    @Nullable
    public final Callback getCallback() {
        return this.callback;
    }

    private final String getClientTokenForRequest() {
        String s = FacebookSdk.getApplicationId();
        String s1 = FacebookSdk.getClientToken();
        if(s.length() > 0 && s1.length() > 0) {
            return s + '|' + s1;
        }
        Utility.logd("GraphRequest", "Warning: Request without access token missing application ID or client token.");
        return null;
    }

    @Nullable
    public static final String getDefaultBatchApplicationId() {
        return GraphRequest.Companion.getDefaultBatchApplicationId();
    }

    @Nullable
    public final JSONObject getGraphObject() {
        return this.graphObject;
    }

    @Nullable
    public final String getGraphPath() {
        return this.graphPath;
    }

    // 去混淆评级： 低(20)
    private final String getGraphPathWithVersion() {
        return GraphRequest.versionPattern.matcher(this.graphPath).matches() ? this.graphPath : String.format("%s/%s", Arrays.copyOf(new Object[]{this.version, this.graphPath}, 2));
    }

    @Nullable
    public final HttpMethod getHttpMethod() {
        return this.httpMethod;
    }

    @NotNull
    public final Bundle getParameters() {
        return this.parameters;
    }

    @NotNull
    public final String getRelativeUrlForBatchedRequest() {
        if(this.overriddenURL != null) {
            throw new FacebookException("Can\'t override URL for a batch request");
        }
        String s = this.getUrlWithGraphPath(ServerProtocol.getGraphUrlBase());
        this.addCommonParameters();
        Uri uri0 = Uri.parse(this.appendParametersToBaseUrl(s, true));
        return String.format("%s?%s", Arrays.copyOf(new Object[]{uri0.getPath(), uri0.getQuery()}, 2));
    }

    @Nullable
    public final Object getTag() {
        return this.tag;
    }

    @NotNull
    public final String getUrlForSingleRequest() {
        String s = this.overriddenURL;
        if(s != null) {
            return s;
        }
        String s1 = this.getUrlWithGraphPath((this.httpMethod != HttpMethod.POST || this.graphPath == null || !v.i0(this.graphPath, "/videos", false) ? ServerProtocol.getGraphUrlBaseForSubdomain(FacebookSdk.getGraphDomain()) : ServerProtocol.getGraphVideoUrlBase()));
        this.addCommonParameters();
        return this.appendParametersToBaseUrl(s1, false);
    }

    private final String getUrlWithGraphPath(String s) {
        if(!this.isValidGraphRequestForDomain()) {
            s = "https://graph.null";
        }
        return String.format("%s/%s", Arrays.copyOf(new Object[]{s, this.getGraphPathWithVersion()}, 2));
    }

    @Nullable
    public final String getVersion() {
        return this.version;
    }

    private final boolean isApplicationRequest() {
        if(this.graphPath == null) {
            return false;
        }
        String s = "^/?" + FacebookSdk.getApplicationId() + "/?.*";
        return this.forceApplicationRequest || Pattern.matches(s, this.graphPath) || Pattern.matches("^/?app/?.*", this.graphPath);
    }

    private final boolean isValidGraphRequestForDomain() {
        return q.b(FacebookSdk.getGraphDomain(), "instagram.com") ? !this.isApplicationRequest() : true;
    }

    @NotNull
    public static final GraphRequest newCustomAudienceThirdPartyIdRequest(@Nullable AccessToken accessToken0, @NotNull Context context0, @Nullable Callback graphRequest$Callback0) {
        return GraphRequest.Companion.newCustomAudienceThirdPartyIdRequest(accessToken0, context0, graphRequest$Callback0);
    }

    @NotNull
    public static final GraphRequest newCustomAudienceThirdPartyIdRequest(@Nullable AccessToken accessToken0, @NotNull Context context0, @Nullable String s, @Nullable Callback graphRequest$Callback0) {
        return GraphRequest.Companion.newCustomAudienceThirdPartyIdRequest(accessToken0, context0, s, graphRequest$Callback0);
    }

    @NotNull
    public static final GraphRequest newDeleteObjectRequest(@Nullable AccessToken accessToken0, @Nullable String s, @Nullable Callback graphRequest$Callback0) {
        return GraphRequest.Companion.newDeleteObjectRequest(accessToken0, s, graphRequest$Callback0);
    }

    @NotNull
    public static final GraphRequest newGraphPathRequest(@Nullable AccessToken accessToken0, @Nullable String s, @Nullable Callback graphRequest$Callback0) {
        return GraphRequest.Companion.newGraphPathRequest(accessToken0, s, graphRequest$Callback0);
    }

    @NotNull
    public static final GraphRequest newMeRequest(@Nullable AccessToken accessToken0, @Nullable GraphJSONObjectCallback graphRequest$GraphJSONObjectCallback0) {
        return GraphRequest.Companion.newMeRequest(accessToken0, graphRequest$GraphJSONObjectCallback0);
    }

    @NotNull
    public static final GraphRequest newMyFriendsRequest(@Nullable AccessToken accessToken0, @Nullable GraphJSONArrayCallback graphRequest$GraphJSONArrayCallback0) {
        return GraphRequest.Companion.newMyFriendsRequest(accessToken0, graphRequest$GraphJSONArrayCallback0);
    }

    @NotNull
    public static final GraphRequest newPlacesSearchRequest(@Nullable AccessToken accessToken0, @Nullable Location location0, int v, int v1, @Nullable String s, @Nullable GraphJSONArrayCallback graphRequest$GraphJSONArrayCallback0) {
        return GraphRequest.Companion.newPlacesSearchRequest(accessToken0, location0, v, v1, s, graphRequest$GraphJSONArrayCallback0);
    }

    @NotNull
    public static final GraphRequest newPostRequest(@Nullable AccessToken accessToken0, @Nullable String s, @Nullable JSONObject jSONObject0, @Nullable Callback graphRequest$Callback0) {
        return GraphRequest.Companion.newPostRequest(accessToken0, s, jSONObject0, graphRequest$Callback0);
    }

    @NotNull
    public static final GraphRequest newPostRequestWithBundle(@Nullable AccessToken accessToken0, @Nullable String s, @Nullable Bundle bundle0, @Nullable Callback graphRequest$Callback0) {
        return GraphRequest.Companion.newPostRequestWithBundle(accessToken0, s, bundle0, graphRequest$Callback0);
    }

    @NotNull
    public static final GraphRequest newUploadPhotoRequest(@Nullable AccessToken accessToken0, @Nullable String s, @NotNull Bitmap bitmap0, @Nullable String s1, @Nullable Bundle bundle0, @Nullable Callback graphRequest$Callback0) {
        return GraphRequest.Companion.newUploadPhotoRequest(accessToken0, s, bitmap0, s1, bundle0, graphRequest$Callback0);
    }

    @NotNull
    public static final GraphRequest newUploadPhotoRequest(@Nullable AccessToken accessToken0, @Nullable String s, @NotNull Uri uri0, @Nullable String s1, @Nullable Bundle bundle0, @Nullable Callback graphRequest$Callback0) {
        return GraphRequest.Companion.newUploadPhotoRequest(accessToken0, s, uri0, s1, bundle0, graphRequest$Callback0);
    }

    @NotNull
    public static final GraphRequest newUploadPhotoRequest(@Nullable AccessToken accessToken0, @Nullable String s, @NotNull File file0, @Nullable String s1, @Nullable Bundle bundle0, @Nullable Callback graphRequest$Callback0) {
        return GraphRequest.Companion.newUploadPhotoRequest(accessToken0, s, file0, s1, bundle0, graphRequest$Callback0);
    }

    public static final void runCallbacks$facebook_core_release(@NotNull GraphRequestBatch graphRequestBatch0, @NotNull List list0) {
        GraphRequest.Companion.runCallbacks$facebook_core_release(graphRequestBatch0, list0);
    }

    private final void serializeToBatch(JSONArray jSONArray0, Map map0) {
        JSONObject jSONObject0 = new JSONObject();
        String s = this.batchEntryName;
        if(s != null) {
            jSONObject0.put("name", s);
            jSONObject0.put("omit_response_on_success", this.batchEntryOmitResultOnSuccess);
        }
        String s1 = this.batchEntryDependsOn;
        if(s1 != null) {
            jSONObject0.put("depends_on", s1);
        }
        String s2 = this.getRelativeUrlForBatchedRequest();
        jSONObject0.put("relative_url", s2);
        jSONObject0.put("method", this.httpMethod);
        AccessToken accessToken0 = this.accessToken;
        if(accessToken0 != null) {
            Logger.Companion.registerAccessToken(accessToken0.getToken());
        }
        ArrayList arrayList0 = new ArrayList();
        for(Object object0: this.parameters.keySet()) {
            Object object1 = this.parameters.get(((String)object0));
            if(Companion.access$isSupportedAttachmentType(GraphRequest.Companion, object1)) {
                String s3 = String.format(Locale.ROOT, "%s%d", Arrays.copyOf(new Object[]{"file", map0.size()}, 2));
                arrayList0.add(s3);
                map0.put(s3, new Attachment(this, object1));
            }
        }
        if(!arrayList0.isEmpty()) {
            jSONObject0.put("attached_files", TextUtils.join(",", arrayList0));
        }
        JSONObject jSONObject1 = this.graphObject;
        if(jSONObject1 != null) {
            ArrayList arrayList1 = new ArrayList();
            com.facebook.GraphRequest.serializeToBatch.1 graphRequest$serializeToBatch$10 = new KeyValueSerializer() {
                @Override  // com.facebook.GraphRequest$KeyValueSerializer
                public void writeString(@NotNull String s, @NotNull String s1) {
                    q.g(s, "key");
                    q.g(s1, "value");
                    String s2 = String.format(Locale.US, "%s=%s", Arrays.copyOf(new Object[]{s, URLEncoder.encode(s1, "UTF-8")}, 2));
                    this.$keysAndValues.add(s2);
                }
            };
            Companion.access$processGraphObject(GraphRequest.Companion, jSONObject1, s2, graphRequest$serializeToBatch$10);
            jSONObject0.put("body", TextUtils.join("&", arrayList1));
        }
        jSONArray0.put(jSONObject0);
    }

    public static final void serializeToUrlConnection$facebook_core_release(@NotNull GraphRequestBatch graphRequestBatch0, @NotNull HttpURLConnection httpURLConnection0) {
        GraphRequest.Companion.serializeToUrlConnection$facebook_core_release(graphRequestBatch0, httpURLConnection0);
    }

    public final void setAccessToken(@Nullable AccessToken accessToken0) {
        this.accessToken = accessToken0;
    }

    public final void setBatchEntryDependsOn(@Nullable String s) {
        this.batchEntryDependsOn = s;
    }

    public final void setBatchEntryName(@Nullable String s) {
        this.batchEntryName = s;
    }

    public final void setBatchEntryOmitResultOnSuccess(boolean z) {
        this.batchEntryOmitResultOnSuccess = z;
    }

    public final void setCallback(@Nullable Callback graphRequest$Callback0) {
        if(!FacebookSdk.isLoggingBehaviorEnabled(LoggingBehavior.GRAPH_API_DEBUG_INFO) && !FacebookSdk.isLoggingBehaviorEnabled(LoggingBehavior.GRAPH_API_DEBUG_WARNING)) {
            this.callback = graphRequest$Callback0;
            return;
        }
        this.callback = new b(graphRequest$Callback0, 1);
    }

    public static final void setDefaultBatchApplicationId(@Nullable String s) {
        GraphRequest.Companion.setDefaultBatchApplicationId(s);
    }

    public final void setForceApplicationRequest(boolean z) {
        this.forceApplicationRequest = z;
    }

    public final void setGraphObject(@Nullable JSONObject jSONObject0) {
        this.graphObject = jSONObject0;
    }

    public final void setGraphPath(@Nullable String s) {
        this.graphPath = s;
    }

    public final void setHttpMethod(@Nullable HttpMethod httpMethod0) {
        if(this.overriddenURL != null && httpMethod0 != HttpMethod.GET) {
            throw new FacebookException("Can\'t change HTTP method on request with overridden URL.");
        }
        if(httpMethod0 == null) {
            httpMethod0 = HttpMethod.GET;
        }
        this.httpMethod = httpMethod0;
    }

    public final void setParameters(@NotNull Bundle bundle0) {
        q.g(bundle0, "<set-?>");
        this.parameters = bundle0;
    }

    public final void setTag(@Nullable Object object0) {
        this.tag = object0;
    }

    public final void setVersion(@Nullable String s) {
        this.version = s;
    }

    private final boolean shouldForceClientTokenForRequest() {
        String s = this.getAccessTokenToUseForRequest();
        boolean z = s == null ? false : o.v0(s, "|", false);
        return s != null && v.r0(s, "IG", false) && !z && this.isApplicationRequest() || !this.isValidGraphRequestForDomain() && !z;
    }

    @NotNull
    public static final HttpURLConnection toHttpConnection(@NotNull GraphRequestBatch graphRequestBatch0) {
        return GraphRequest.Companion.toHttpConnection(graphRequestBatch0);
    }

    @NotNull
    public static final HttpURLConnection toHttpConnection(@NotNull Collection collection0) {
        return GraphRequest.Companion.toHttpConnection(collection0);
    }

    @NotNull
    public static final HttpURLConnection toHttpConnection(@NotNull GraphRequest[] arr_graphRequest) {
        return GraphRequest.Companion.toHttpConnection(arr_graphRequest);
    }

    @Override
    @NotNull
    public String toString() {
        StringBuilder stringBuilder0 = new StringBuilder("{Request:  accessToken: ");
        AccessToken accessToken0 = this.accessToken;
        if(accessToken0 == null) {
            accessToken0 = "null";
        }
        stringBuilder0.append(accessToken0);
        stringBuilder0.append(", graphPath: ");
        stringBuilder0.append(this.graphPath);
        stringBuilder0.append(", graphObject: ");
        stringBuilder0.append(this.graphObject);
        stringBuilder0.append(", httpMethod: ");
        stringBuilder0.append(this.httpMethod);
        stringBuilder0.append(", parameters: ");
        stringBuilder0.append(this.parameters);
        stringBuilder0.append("}");
        String s = stringBuilder0.toString();
        q.f(s, "StringBuilder()\n        …(\"}\")\n        .toString()");
        return s;
    }

    public static final void validateFieldsParamForGetRequests$facebook_core_release(@NotNull GraphRequestBatch graphRequestBatch0) {
        GraphRequest.Companion.validateFieldsParamForGetRequests$facebook_core_release(graphRequestBatch0);
    }
}


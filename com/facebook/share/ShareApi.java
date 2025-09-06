package com.facebook.share;

import android.graphics.Bitmap;
import android.net.Uri;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Log;
import com.facebook.AccessToken;
import com.facebook.FacebookCallback;
import com.facebook.FacebookException;
import com.facebook.FacebookGraphResponseException;
import com.facebook.FacebookRequestError;
import com.facebook.GraphRequest.Callback;
import com.facebook.GraphRequest;
import com.facebook.GraphResponse;
import com.facebook.HttpMethod;
import com.facebook.internal.CollectionMapper.Collection;
import com.facebook.internal.CollectionMapper.OnErrorListener;
import com.facebook.internal.CollectionMapper.OnMapValueCompleteListener;
import com.facebook.internal.CollectionMapper.OnMapperCompleteListener;
import com.facebook.internal.CollectionMapper.ValueMapper;
import com.facebook.internal.CollectionMapper;
import com.facebook.internal.Mutable;
import com.facebook.internal.Utility;
import com.facebook.internal.instrument.crashshield.CrashShieldHandler;
import com.facebook.share.internal.ShareContentValidation;
import com.facebook.share.internal.ShareInternalUtility;
import com.facebook.share.internal.VideoUploader;
import com.facebook.share.model.ShareContent;
import com.facebook.share.model.ShareLinkContent;
import com.facebook.share.model.SharePhoto;
import com.facebook.share.model.SharePhotoContent;
import com.facebook.share.model.ShareVideoContent;
import java.io.FileNotFoundException;
import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public final class ShareApi {
    private static final String DEFAULT_CHARSET = "UTF-8";
    private static final String DEFAULT_GRAPH_NODE = "me";
    private static final String GRAPH_PATH_FORMAT = "%s/%s";
    private static final String PHOTOS_EDGE = "photos";
    private static final String TAG = "ShareApi";
    private String graphNode;
    private String message;
    private final ShareContent shareContent;

    public ShareApi(ShareContent shareContent0) {
        this.shareContent = shareContent0;
        this.graphNode = "me";
    }

    public static void access$000(ShareApi shareApi0, ArrayList arrayList0, OnMapValueCompleteListener collectionMapper$OnMapValueCompleteListener0) {
        Class class0 = ShareApi.class;
        if(CrashShieldHandler.isObjectCrashing(class0)) {
            return;
        }
        try {
            shareApi0.stageArrayList(arrayList0, collectionMapper$OnMapValueCompleteListener0);
        }
        catch(Throwable throwable0) {
            CrashShieldHandler.handleThrowable(throwable0, class0);
        }
    }

    public static void access$100(ShareApi shareApi0, SharePhoto sharePhoto0, OnMapValueCompleteListener collectionMapper$OnMapValueCompleteListener0) {
        Class class0 = ShareApi.class;
        if(CrashShieldHandler.isObjectCrashing(class0)) {
            return;
        }
        try {
            shareApi0.stagePhoto(sharePhoto0, collectionMapper$OnMapValueCompleteListener0);
        }
        catch(Throwable throwable0) {
            CrashShieldHandler.handleThrowable(throwable0, class0);
        }
    }

    private void addCommonParameters(Bundle bundle0, ShareContent shareContent0) {
        if(CrashShieldHandler.isObjectCrashing(this)) {
            return;
        }
        else {
            try {
                List list0 = shareContent0.getPeopleIds();
                if(!Utility.isNullOrEmpty(list0)) {
                    bundle0.putString("tags", TextUtils.join(", ", list0));
                }
                if(!Utility.isNullOrEmpty(shareContent0.getPlaceId())) {
                    bundle0.putString("place", shareContent0.getPlaceId());
                }
                if(!Utility.isNullOrEmpty(shareContent0.getPageId())) {
                    bundle0.putString("page", shareContent0.getPageId());
                }
                if(!Utility.isNullOrEmpty(shareContent0.getRef())) {
                    bundle0.putString("ref", shareContent0.getRef());
                }
                return;
            }
            catch(Throwable throwable0) {
            }
        }
        CrashShieldHandler.handleThrowable(throwable0, this);
    }

    public boolean canShare() {
        if(CrashShieldHandler.isObjectCrashing(this)) {
            return false;
        }
        try {
            if(this.getShareContent() == null) {
                return false;
            }
            AccessToken accessToken0 = AccessToken.getCurrentAccessToken();
            if(!AccessToken.isCurrentAccessTokenActive()) {
                return false;
            }
            Set set0 = accessToken0.getPermissions();
            if(set0 == null || !set0.contains("publish_actions")) {
                Log.w("ShareApi", "The publish_actions permissions are missing, the share will fail unless this app was authorized to publish in another installation.");
            }
            return true;
        }
        catch(Throwable throwable0) {
        }
        CrashShieldHandler.handleThrowable(throwable0, this);
        return false;
    }

    // 去混淆评级： 低(20)
    public String getGraphNode() {
        return CrashShieldHandler.isObjectCrashing(this) ? null : this.graphNode;
    }

    private String getGraphPath(String s) {
        if(CrashShieldHandler.isObjectCrashing(this)) {
            return null;
        }
        try {
            return URLEncoder.encode(this.getGraphNode(), "UTF-8") + "/" + s;
        }
        catch(UnsupportedEncodingException throwable0) {
            CrashShieldHandler.handleThrowable(throwable0, this);
        }
        catch(Throwable unused_ex) {
        }
        return null;
    }

    // 去混淆评级： 低(20)
    public String getMessage() {
        return CrashShieldHandler.isObjectCrashing(this) ? null : this.message;
    }

    // 去混淆评级： 低(20)
    public ShareContent getShareContent() {
        return CrashShieldHandler.isObjectCrashing(this) ? null : this.shareContent;
    }

    private Bundle getSharePhotoCommonParameters(SharePhoto sharePhoto0, SharePhotoContent sharePhotoContent0) {
        if(CrashShieldHandler.isObjectCrashing(this)) {
            return null;
        }
        try {
            Bundle bundle0 = sharePhoto0.getParameters();
            if(!bundle0.containsKey("place") && !Utility.isNullOrEmpty(sharePhotoContent0.getPlaceId())) {
                bundle0.putString("place", sharePhotoContent0.getPlaceId());
            }
            if(!bundle0.containsKey("tags") && !Utility.isNullOrEmpty(sharePhotoContent0.getPeopleIds())) {
                List list0 = sharePhotoContent0.getPeopleIds();
                if(!Utility.isNullOrEmpty(list0)) {
                    JSONArray jSONArray0 = new JSONArray();
                    for(Object object0: list0) {
                        JSONObject jSONObject0 = new JSONObject();
                        jSONObject0.put("tag_uid", ((String)object0));
                        jSONArray0.put(jSONObject0);
                    }
                    bundle0.putString("tags", jSONArray0.toString());
                }
            }
            if(!bundle0.containsKey("ref") && !Utility.isNullOrEmpty(sharePhotoContent0.getRef())) {
                bundle0.putString("ref", sharePhotoContent0.getRef());
            }
            return bundle0;
        }
        catch(Throwable throwable0) {
        }
        CrashShieldHandler.handleThrowable(throwable0, this);
        return null;
    }

    private static void handleImagesOnAction(Bundle bundle0) {
        Class class0 = ShareApi.class;
        if(!CrashShieldHandler.isObjectCrashing(class0)) {
            try {
                String s = bundle0.getString("image");
                if(s != null) {
                    try {
                        JSONArray jSONArray0 = new JSONArray(s);
                        for(int v = 0; v < jSONArray0.length(); ++v) {
                            JSONObject jSONObject0 = jSONArray0.optJSONObject(v);
                            if(jSONObject0 == null) {
                                bundle0.putString("image[" + v + "][url]", jSONArray0.getString(v));
                            }
                            else {
                                ShareApi.putImageInBundleWithArrayFormat(bundle0, v, jSONObject0);
                            }
                        }
                        bundle0.remove("image");
                        return;
                    }
                    catch(JSONException unused_ex) {
                        try {
                            ShareApi.putImageInBundleWithArrayFormat(bundle0, 0, new JSONObject(s));
                            bundle0.remove("image");
                            return;
                        }
                        catch(JSONException unused_ex) {
                        }
                    }
                }
                return;
            }
            catch(Throwable throwable0) {
            }
            CrashShieldHandler.handleThrowable(throwable0, class0);
        }
    }

    private static void putImageInBundleWithArrayFormat(Bundle bundle0, int v, JSONObject jSONObject0) {
        Class class0 = ShareApi.class;
        if(CrashShieldHandler.isObjectCrashing(class0)) {
            return;
        }
        else {
            try {
                Iterator iterator0 = jSONObject0.keys();
                while(iterator0.hasNext()) {
                    Object object0 = iterator0.next();
                    bundle0.putString("image[" + v + "][" + ((String)object0) + "]", jSONObject0.get(((String)object0)).toString());
                }
                return;
            }
            catch(Throwable throwable0) {
            }
        }
        CrashShieldHandler.handleThrowable(throwable0, class0);
    }

    public void setGraphNode(String s) {
        if(CrashShieldHandler.isObjectCrashing(this)) {
            return;
        }
        this.graphNode = s;
    }

    public void setMessage(String s) {
        if(CrashShieldHandler.isObjectCrashing(this)) {
            return;
        }
        this.message = s;
    }

    public static void share(ShareContent shareContent0, FacebookCallback facebookCallback0) {
        Class class0 = ShareApi.class;
        if(CrashShieldHandler.isObjectCrashing(class0)) {
            return;
        }
        try {
            new ShareApi(shareContent0).share(facebookCallback0);
        }
        catch(Throwable throwable0) {
            CrashShieldHandler.handleThrowable(throwable0, class0);
        }
    }

    public void share(FacebookCallback facebookCallback0) {
        if(CrashShieldHandler.isObjectCrashing(this)) {
            return;
        }
        else {
            try {
                if(!this.canShare()) {
                    ShareInternalUtility.invokeCallbackWithError(facebookCallback0, "Insufficient permissions for sharing content via Api.");
                    return;
                }
                ShareContent shareContent0 = this.getShareContent();
                try {
                    ShareContentValidation.validateForApiShare(shareContent0);
                }
                catch(FacebookException facebookException0) {
                    ShareInternalUtility.invokeCallbackWithException(facebookCallback0, facebookException0);
                    return;
                }
                if(shareContent0 instanceof ShareLinkContent) {
                    this.shareLinkContent(((ShareLinkContent)shareContent0), facebookCallback0);
                    return;
                }
                if(shareContent0 instanceof SharePhotoContent) {
                    this.sharePhotoContent(((SharePhotoContent)shareContent0), facebookCallback0);
                    return;
                }
                if(shareContent0 instanceof ShareVideoContent) {
                    this.shareVideoContent(((ShareVideoContent)shareContent0), facebookCallback0);
                    return;
                }
                return;
            }
            catch(Throwable throwable0) {
            }
        }
        CrashShieldHandler.handleThrowable(throwable0, this);
    }

    private void shareLinkContent(ShareLinkContent shareLinkContent0, FacebookCallback facebookCallback0) {
        if(CrashShieldHandler.isObjectCrashing(this)) {
            return;
        }
        try {
            com.facebook.share.ShareApi.2 shareApi$20 = new Callback() {
                @Override  // com.facebook.GraphRequest$Callback
                public void onCompleted(GraphResponse graphResponse0) {
                    JSONObject jSONObject0 = graphResponse0.getJSONObject();
                    String s = jSONObject0 == null ? null : jSONObject0.optString("id");
                    ShareInternalUtility.invokeCallbackWithResults(facebookCallback0, s, graphResponse0);
                }
            };
            Bundle bundle0 = new Bundle();
            this.addCommonParameters(bundle0, shareLinkContent0);
            bundle0.putString("message", this.getMessage());
            bundle0.putString("link", Utility.getUriString(shareLinkContent0.getContentUrl()));
            bundle0.putString("ref", shareLinkContent0.getRef());
            new GraphRequest(AccessToken.getCurrentAccessToken(), this.getGraphPath("feed"), bundle0, HttpMethod.POST, shareApi$20).executeAsync();
        }
        catch(Throwable throwable0) {
            CrashShieldHandler.handleThrowable(throwable0, this);
        }
    }

    private void sharePhotoContent(SharePhotoContent sharePhotoContent0, FacebookCallback facebookCallback0) {
        AccessToken accessToken1;
        Bundle bundle0;
        if(!CrashShieldHandler.isObjectCrashing(this)) {
            try {
                Mutable mutable0 = new Mutable(0);
                AccessToken accessToken0 = AccessToken.getCurrentAccessToken();
                ArrayList arrayList0 = new ArrayList();
                com.facebook.share.ShareApi.1 shareApi$10 = new Callback() {
                    @Override  // com.facebook.GraphRequest$Callback
                    public void onCompleted(GraphResponse graphResponse0) {
                        JSONObject jSONObject0 = graphResponse0.getJSONObject();
                        if(jSONObject0 != null) {
                            new ArrayList().add(jSONObject0);
                        }
                        if(graphResponse0.getError() != null) {
                            new ArrayList().add(graphResponse0);
                        }
                        mutable0.value = (int)(((int)(((Integer)mutable0.value))) - 1);
                        if(((int)(((Integer)mutable0.value))) == 0) {
                            if(!new ArrayList().isEmpty()) {
                                GraphResponse graphResponse1 = (GraphResponse)new ArrayList().get(0);
                                ShareInternalUtility.invokeCallbackWithResults(facebookCallback0, null, graphResponse1);
                                return;
                            }
                            if(!new ArrayList().isEmpty()) {
                                String s = ((JSONObject)new ArrayList().get(0)).optString("id");
                                ShareInternalUtility.invokeCallbackWithResults(facebookCallback0, s, graphResponse0);
                            }
                        }
                    }
                };
                try {
                    Iterator iterator0 = sharePhotoContent0.getPhotos().iterator();
                    while(true) {
                        if(!iterator0.hasNext()) {
                            mutable0.value = (int)(((int)(((Integer)mutable0.value))) + arrayList0.size());
                            for(Object object0: arrayList0) {
                                ((GraphRequest)object0).executeAsync();
                            }
                            return;
                        }
                        Object object1 = iterator0.next();
                        SharePhoto sharePhoto0 = (SharePhoto)object1;
                        try {
                            bundle0 = this.getSharePhotoCommonParameters(sharePhoto0, sharePhotoContent0);
                        }
                        catch(JSONException jSONException0) {
                            ShareInternalUtility.invokeCallbackWithException(facebookCallback0, jSONException0);
                            return;
                        }
                        Bitmap bitmap0 = sharePhoto0.getBitmap();
                        Uri uri0 = sharePhoto0.getImageUrl();
                        String s = sharePhoto0.getCaption() == null ? this.getMessage() : sharePhoto0.getCaption();
                        if(bitmap0 == null) {
                            accessToken1 = accessToken0;
                            if(uri0 != null) {
                                arrayList0.add(GraphRequest.newUploadPhotoRequest(accessToken1, this.getGraphPath("photos"), uri0, s, bundle0, shareApi$10));
                            }
                        }
                        else {
                            accessToken1 = accessToken0;
                            arrayList0.add(GraphRequest.newUploadPhotoRequest(accessToken1, this.getGraphPath("photos"), bitmap0, s, bundle0, shareApi$10));
                        }
                        accessToken0 = accessToken1;
                    }
                }
                catch(FileNotFoundException fileNotFoundException0) {
                    ShareInternalUtility.invokeCallbackWithException(facebookCallback0, fileNotFoundException0);
                }
            }
            catch(Throwable throwable0) {
                CrashShieldHandler.handleThrowable(throwable0, this);
            }
        }
    }

    private void shareVideoContent(ShareVideoContent shareVideoContent0, FacebookCallback facebookCallback0) {
        if(!CrashShieldHandler.isObjectCrashing(this)) {
            try {
                try {
                    VideoUploader.uploadAsync(shareVideoContent0, this.getGraphNode(), facebookCallback0);
                }
                catch(FileNotFoundException fileNotFoundException0) {
                    ShareInternalUtility.invokeCallbackWithException(facebookCallback0, fileNotFoundException0);
                }
            }
            catch(Throwable throwable0) {
                CrashShieldHandler.handleThrowable(throwable0, this);
            }
        }
    }

    private void stageArrayList(ArrayList arrayList0, OnMapValueCompleteListener collectionMapper$OnMapValueCompleteListener0) {
        if(CrashShieldHandler.isObjectCrashing(this)) {
            return;
        }
        try {
            JSONArray jSONArray0 = new JSONArray();
            this.stageCollectionValues(new Collection() {
                public Object get(Integer integer0) {
                    return arrayList0.get(((int)integer0));
                }

                @Override  // com.facebook.internal.CollectionMapper$Collection
                public Object get(Object object0) {
                    return this.get(((Integer)object0));
                }

                @Override  // com.facebook.internal.CollectionMapper$Collection
                public Iterator keyIterator() {
                    return new Iterator() {
                        @Override
                        public boolean hasNext() {
                            return ((int)(((Integer)new Mutable(0).value))) < this.val$arrayList.size();
                        }

                        public Integer next() {
                            Object object0 = new Mutable(0).value;
                            new Mutable(0).value = (int)(((int)(((Integer)object0))) + 1);
                            return (Integer)object0;
                        }

                        @Override
                        public Object next() {
                            return this.next();
                        }

                        @Override
                        public void remove() {
                        }
                    };
                }

                public void set(Integer integer0, Object object0, OnErrorListener collectionMapper$OnErrorListener0) {
                    try {
                        jSONArray0.put(((int)integer0), object0);
                    }
                    catch(JSONException jSONException0) {
                        String s = jSONException0.getLocalizedMessage();
                        if(s == null) {
                            s = "Error staging object.";
                        }
                        collectionMapper$OnErrorListener0.onError(new FacebookException(s));
                    }
                }

                @Override  // com.facebook.internal.CollectionMapper$Collection
                public void set(Object object0, Object object1, OnErrorListener collectionMapper$OnErrorListener0) {
                    this.set(((Integer)object0), object1, collectionMapper$OnErrorListener0);
                }
            }, new OnMapperCompleteListener() {
                @Override  // com.facebook.internal.CollectionMapper$OnMapperCompleteListener
                public void onComplete() {
                    collectionMapper$OnMapValueCompleteListener0.onComplete(jSONArray0);
                }

                @Override  // com.facebook.internal.CollectionMapper$OnErrorListener
                public void onError(FacebookException facebookException0) {
                    collectionMapper$OnMapValueCompleteListener0.onError(facebookException0);
                }
            });
        }
        catch(Throwable throwable0) {
            CrashShieldHandler.handleThrowable(throwable0, this);
        }
    }

    private void stageCollectionValues(Collection collectionMapper$Collection0, OnMapperCompleteListener collectionMapper$OnMapperCompleteListener0) {
        if(CrashShieldHandler.isObjectCrashing(this)) {
            return;
        }
        try {
            CollectionMapper.iterate(collectionMapper$Collection0, new ValueMapper() {
                @Override  // com.facebook.internal.CollectionMapper$ValueMapper
                public void mapValue(Object object0, OnMapValueCompleteListener collectionMapper$OnMapValueCompleteListener0) {
                    if(object0 instanceof ArrayList) {
                        ShareApi.access$000(ShareApi.this, ((ArrayList)object0), collectionMapper$OnMapValueCompleteListener0);
                        return;
                    }
                    if(object0 instanceof SharePhoto) {
                        ShareApi.access$100(ShareApi.this, ((SharePhoto)object0), collectionMapper$OnMapValueCompleteListener0);
                        return;
                    }
                    collectionMapper$OnMapValueCompleteListener0.onComplete(object0);
                }
            }, collectionMapper$OnMapperCompleteListener0);
        }
        catch(Throwable throwable0) {
            CrashShieldHandler.handleThrowable(throwable0, this);
        }
    }

    private void stagePhoto(SharePhoto sharePhoto0, OnMapValueCompleteListener collectionMapper$OnMapValueCompleteListener0) {
        if(!CrashShieldHandler.isObjectCrashing(this)) {
            try {
                Bitmap bitmap0 = sharePhoto0.getBitmap();
                Uri uri0 = sharePhoto0.getImageUrl();
                if(bitmap0 == null && uri0 == null) {
                    collectionMapper$OnMapValueCompleteListener0.onError(new FacebookException("Photos must have an imageURL or bitmap."));
                    return;
                }
                com.facebook.share.ShareApi.6 shareApi$60 = new Callback() {
                    @Override  // com.facebook.GraphRequest$Callback
                    public void onCompleted(GraphResponse graphResponse0) {
                        FacebookRequestError facebookRequestError0 = graphResponse0.getError();
                        String s = "Error staging photo.";
                        if(facebookRequestError0 != null) {
                            String s1 = facebookRequestError0.getErrorMessage();
                            if(s1 != null) {
                                s = s1;
                            }
                            FacebookGraphResponseException facebookGraphResponseException0 = new FacebookGraphResponseException(graphResponse0, s);
                            collectionMapper$OnMapValueCompleteListener0.onError(facebookGraphResponseException0);
                            return;
                        }
                        JSONObject jSONObject0 = graphResponse0.getJSONObject();
                        if(jSONObject0 == null) {
                            FacebookException facebookException0 = new FacebookException("Error staging photo.");
                            collectionMapper$OnMapValueCompleteListener0.onError(facebookException0);
                            return;
                        }
                        String s2 = jSONObject0.optString("uri");
                        if(s2 == null) {
                            FacebookException facebookException1 = new FacebookException("Error staging photo.");
                            collectionMapper$OnMapValueCompleteListener0.onError(facebookException1);
                            return;
                        }
                        JSONObject jSONObject1 = new JSONObject();
                        try {
                            jSONObject1.put("url", s2);
                            jSONObject1.put("user_generated", sharePhoto0.getUserGenerated());
                        }
                        catch(JSONException jSONException0) {
                            String s3 = jSONException0.getLocalizedMessage();
                            if(s3 != null) {
                                s = s3;
                            }
                            FacebookException facebookException2 = new FacebookException(s);
                            collectionMapper$OnMapValueCompleteListener0.onError(facebookException2);
                            return;
                        }
                        collectionMapper$OnMapValueCompleteListener0.onComplete(jSONObject1);
                    }
                };
                if(bitmap0 != null) {
                    ShareInternalUtility.newUploadStagingResourceWithImageRequest(AccessToken.getCurrentAccessToken(), bitmap0, shareApi$60).executeAsync();
                    return;
                }
                try {
                    ShareInternalUtility.newUploadStagingResourceWithImageRequest(AccessToken.getCurrentAccessToken(), uri0, shareApi$60).executeAsync();
                }
                catch(FileNotFoundException fileNotFoundException0) {
                    String s = fileNotFoundException0.getLocalizedMessage();
                    if(s == null) {
                        s = "Error staging photo.";
                    }
                    collectionMapper$OnMapValueCompleteListener0.onError(new FacebookException(s));
                }
                return;
            }
            catch(Throwable throwable0) {
            }
            CrashShieldHandler.handleThrowable(throwable0, this);
        }
    }
}


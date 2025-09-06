package com.bumptech.glide.integration.okhttp3;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.drawable.Drawable;
import android.net.Uri;
import com.bumptech.glide.Glide;
import com.bumptech.glide.RequestBuilder;
import com.bumptech.glide.RequestManager;
import com.bumptech.glide.manager.Lifecycle;
import com.bumptech.glide.manager.RequestManagerTreeNode;
import com.bumptech.glide.request.RequestListener;
import com.bumptech.glide.request.RequestOptions;
import java.io.File;
import java.net.URL;

public class GlideRequests extends RequestManager {
    public GlideRequests(Glide glide0, Lifecycle lifecycle0, RequestManagerTreeNode requestManagerTreeNode0, Context context0) {
        super(glide0, lifecycle0, requestManagerTreeNode0, context0);
    }

    @Override  // com.bumptech.glide.RequestManager
    public RequestManager addDefaultRequestListener(RequestListener requestListener0) {
        return this.addDefaultRequestListener(requestListener0);
    }

    public GlideRequests addDefaultRequestListener(RequestListener requestListener0) {
        return (GlideRequests)super.addDefaultRequestListener(requestListener0);
    }

    @Override  // com.bumptech.glide.RequestManager
    public RequestManager applyDefaultRequestOptions(RequestOptions requestOptions0) {
        return this.applyDefaultRequestOptions(requestOptions0);
    }

    public GlideRequests applyDefaultRequestOptions(RequestOptions requestOptions0) {
        synchronized(this) {
            return (GlideRequests)super.applyDefaultRequestOptions(requestOptions0);
        }
    }

    @Override  // com.bumptech.glide.RequestManager
    public RequestBuilder as(Class class0) {
        return this.as(class0);
    }

    public GlideRequest as(Class class0) {
        return new GlideRequest(this.glide, this, class0, this.context);
    }

    @Override  // com.bumptech.glide.RequestManager
    public RequestBuilder asBitmap() {
        return this.asBitmap();
    }

    public GlideRequest asBitmap() {
        return (GlideRequest)super.asBitmap();
    }

    @Override  // com.bumptech.glide.RequestManager
    public RequestBuilder asDrawable() {
        return this.asDrawable();
    }

    public GlideRequest asDrawable() {
        return (GlideRequest)super.asDrawable();
    }

    @Override  // com.bumptech.glide.RequestManager
    public RequestBuilder asFile() {
        return this.asFile();
    }

    public GlideRequest asFile() {
        return (GlideRequest)super.asFile();
    }

    @Override  // com.bumptech.glide.RequestManager
    public RequestBuilder asGif() {
        return this.asGif();
    }

    public GlideRequest asGif() {
        return (GlideRequest)super.asGif();
    }

    @Override  // com.bumptech.glide.RequestManager
    public RequestManager clearOnStop() {
        return this.clearOnStop();
    }

    public GlideRequests clearOnStop() {
        synchronized(this) {
            return (GlideRequests)super.clearOnStop();
        }
    }

    @Override  // com.bumptech.glide.RequestManager
    public RequestBuilder download(Object object0) {
        return this.download(object0);
    }

    public GlideRequest download(Object object0) {
        return (GlideRequest)super.download(object0);
    }

    @Override  // com.bumptech.glide.RequestManager
    public RequestBuilder downloadOnly() {
        return this.downloadOnly();
    }

    public GlideRequest downloadOnly() {
        return (GlideRequest)super.downloadOnly();
    }

    @Override  // com.bumptech.glide.RequestManager
    public RequestBuilder load(Bitmap bitmap0) {
        return this.load(bitmap0);
    }

    @Override  // com.bumptech.glide.RequestManager
    public RequestBuilder load(Drawable drawable0) {
        return this.load(drawable0);
    }

    @Override  // com.bumptech.glide.RequestManager
    public RequestBuilder load(Uri uri0) {
        return this.load(uri0);
    }

    @Override  // com.bumptech.glide.RequestManager
    public RequestBuilder load(File file0) {
        return this.load(file0);
    }

    @Override  // com.bumptech.glide.RequestManager
    public RequestBuilder load(Integer integer0) {
        return this.load(integer0);
    }

    @Override  // com.bumptech.glide.RequestManager
    public RequestBuilder load(Object object0) {
        return this.load(object0);
    }

    @Override  // com.bumptech.glide.RequestManager
    public RequestBuilder load(String s) {
        return this.load(s);
    }

    @Override  // com.bumptech.glide.RequestManager
    @Deprecated
    public RequestBuilder load(URL uRL0) {
        return this.load(uRL0);
    }

    @Override  // com.bumptech.glide.RequestManager
    public RequestBuilder load(byte[] arr_b) {
        return this.load(arr_b);
    }

    public GlideRequest load(Bitmap bitmap0) {
        return (GlideRequest)super.load(bitmap0);
    }

    public GlideRequest load(Drawable drawable0) {
        return (GlideRequest)super.load(drawable0);
    }

    public GlideRequest load(Uri uri0) {
        return (GlideRequest)super.load(uri0);
    }

    public GlideRequest load(File file0) {
        return (GlideRequest)super.load(file0);
    }

    public GlideRequest load(Integer integer0) {
        return (GlideRequest)super.load(integer0);
    }

    public GlideRequest load(Object object0) {
        return (GlideRequest)super.load(object0);
    }

    public GlideRequest load(String s) {
        return (GlideRequest)super.load(s);
    }

    @Deprecated
    public GlideRequest load(URL uRL0) {
        return (GlideRequest)super.load(uRL0);
    }

    public GlideRequest load(byte[] arr_b) {
        return (GlideRequest)super.load(arr_b);
    }

    @Override  // com.bumptech.glide.RequestManager
    public Object load(Bitmap bitmap0) {
        return this.load(bitmap0);
    }

    @Override  // com.bumptech.glide.RequestManager
    public Object load(Drawable drawable0) {
        return this.load(drawable0);
    }

    @Override  // com.bumptech.glide.RequestManager
    public Object load(Uri uri0) {
        return this.load(uri0);
    }

    @Override  // com.bumptech.glide.RequestManager
    public Object load(File file0) {
        return this.load(file0);
    }

    @Override  // com.bumptech.glide.RequestManager
    public Object load(Integer integer0) {
        return this.load(integer0);
    }

    @Override  // com.bumptech.glide.RequestManager
    public Object load(Object object0) {
        return this.load(object0);
    }

    @Override  // com.bumptech.glide.RequestManager
    public Object load(String s) {
        return this.load(s);
    }

    @Override  // com.bumptech.glide.RequestManager
    @Deprecated
    public Object load(URL uRL0) {
        return this.load(uRL0);
    }

    @Override  // com.bumptech.glide.RequestManager
    public Object load(byte[] arr_b) {
        return this.load(arr_b);
    }

    @Override  // com.bumptech.glide.RequestManager
    public RequestManager setDefaultRequestOptions(RequestOptions requestOptions0) {
        return this.setDefaultRequestOptions(requestOptions0);
    }

    public GlideRequests setDefaultRequestOptions(RequestOptions requestOptions0) {
        synchronized(this) {
            return (GlideRequests)super.setDefaultRequestOptions(requestOptions0);
        }
    }

    @Override  // com.bumptech.glide.RequestManager
    public void setRequestOptions(RequestOptions requestOptions0) {
        if(requestOptions0 instanceof GlideOptions) {
            super.setRequestOptions(requestOptions0);
            return;
        }
        super.setRequestOptions(new GlideOptions().apply(requestOptions0));
    }
}


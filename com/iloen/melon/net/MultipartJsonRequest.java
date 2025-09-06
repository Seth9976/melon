package com.iloen.melon.net;

import android.content.Context;
import android.text.TextUtils;
import com.android.volley.Request.Priority;
import com.android.volley.Response.ErrorListener;
import com.android.volley.Response.Listener;
import com.iloen.melon.utils.log.LogU;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.util.Map.Entry;
import java.util.Map;
import org.apache.http.HttpEntity;
import org.apache.http.entity.ContentType;
import org.apache.http.entity.mime.HttpMultipartMode;
import org.apache.http.entity.mime.MultipartEntityBuilder;
import org.apache.http.entity.mime.content.FileBody;
import org.apache.http.entity.mime.content.InputStreamBody;

public class MultipartJsonRequest extends VolleyRequest {
    private static final String CONTENT_MIME_TYPE = "multipart/form-data";
    private static final String FILE_PART_NAME = "imageFile";
    private static final String TAG = "MultipartJsonRequest";
    private HttpEntity mHttpEntity;
    private Map mStringPart;

    public MultipartJsonRequest(Context context0, String s, Class class0, Map map0, String s1, File file0, Map map1, Listener response$Listener0, ErrorListener response$ErrorListener0, long v) {
        super(context0, 1, s, class0, map0, null, null, response$Listener0, response$ErrorListener0, false, Priority.NORMAL, v);
        this.mStringPart = map1;
        this.mHttpEntity = this.buildMultipartEntity(s1, file0);
    }

    public MultipartJsonRequest(Context context0, String s, Class class0, Map map0, String s1, InputStream inputStream0, Map map1, Listener response$Listener0, ErrorListener response$ErrorListener0, long v) {
        super(context0, 1, s, class0, map0, null, null, response$Listener0, response$ErrorListener0, false, Priority.NORMAL, v);
        this.mStringPart = map1;
        this.mHttpEntity = this.buildMultipartEntity(s1, inputStream0);
    }

    private HttpEntity buildMultipartEntity(String s, File file0) {
        MultipartEntityBuilder multipartEntityBuilder0 = MultipartEntityBuilder.create();
        multipartEntityBuilder0.setMode(HttpMultipartMode.BROWSER_COMPATIBLE);
        Map map0 = this.mStringPart;
        if(map0 != null) {
            for(Object object0: map0.entrySet()) {
                multipartEntityBuilder0.addTextBody(((String)((Map.Entry)object0).getKey()), ((String)((Map.Entry)object0).getValue()), ContentType.create("multipart/form-data", "utf-8"));
            }
        }
        if(TextUtils.isEmpty(s)) {
            s = "imageFile";
        }
        multipartEntityBuilder0.addPart(s, new FileBody(file0));
        return multipartEntityBuilder0.build();
    }

    private HttpEntity buildMultipartEntity(String s, InputStream inputStream0) {
        MultipartEntityBuilder multipartEntityBuilder0 = MultipartEntityBuilder.create();
        multipartEntityBuilder0.setMode(HttpMultipartMode.BROWSER_COMPATIBLE);
        Map map0 = this.mStringPart;
        if(map0 != null) {
            for(Object object0: map0.entrySet()) {
                multipartEntityBuilder0.addTextBody(((String)((Map.Entry)object0).getKey()), ((String)((Map.Entry)object0).getValue()), ContentType.create("multipart/form-data", "utf-8"));
            }
        }
        if(TextUtils.isEmpty(s)) {
            s = "imageFile";
        }
        multipartEntityBuilder0.addPart(s, new InputStreamBody(inputStream0, s));
        return multipartEntityBuilder0.build();
    }

    @Override  // com.iloen.melon.net.VolleyRequest
    public byte[] getBody() {
        ByteArrayOutputStream byteArrayOutputStream0 = new ByteArrayOutputStream();
        try {
            this.mHttpEntity.writeTo(byteArrayOutputStream0);
            return byteArrayOutputStream0.toByteArray();
        }
        catch(IOException iOException0) {
            LogU.e("MultipartJsonRequest", "getBody() " + iOException0);
            return byteArrayOutputStream0.toByteArray();
        }
    }

    @Override  // com.iloen.melon.net.VolleyRequest
    public String getBodyContentType() {
        return this.mHttpEntity.getContentType().getValue();
    }
}


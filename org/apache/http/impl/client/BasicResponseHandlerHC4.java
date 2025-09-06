package org.apache.http.impl.client;

import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.StatusLine;
import org.apache.http.annotation.Immutable;
import org.apache.http.client.HttpResponseException;
import org.apache.http.client.ResponseHandler;
import org.apache.http.util.EntityUtilsHC4;

@Immutable
public class BasicResponseHandlerHC4 implements ResponseHandler {
    @Override  // org.apache.http.client.ResponseHandler
    public Object handleResponse(HttpResponse httpResponse0) {
        return this.handleResponse(httpResponse0);
    }

    public String handleResponse(HttpResponse httpResponse0) {
        StatusLine statusLine0 = httpResponse0.getStatusLine();
        HttpEntity httpEntity0 = httpResponse0.getEntity();
        if(statusLine0.getStatusCode() < 300) {
            return httpEntity0 == null ? null : EntityUtilsHC4.toString(httpEntity0);
        }
        EntityUtilsHC4.consume(httpEntity0);
        throw new HttpResponseException(statusLine0.getStatusCode(), statusLine0.getReasonPhrase());
    }
}


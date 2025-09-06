package org.apache.http.client;

import org.apache.http.HttpResponse;

@Deprecated
public interface ResponseHandler {
    Object handleResponse(HttpResponse arg1);
}


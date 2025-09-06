package org.apache.http.client.protocol;

import java.util.Locale;
import org.apache.http.Header;
import org.apache.http.HeaderElement;
import org.apache.http.HttpEntity;
import org.apache.http.HttpException;
import org.apache.http.HttpResponse;
import org.apache.http.HttpResponseInterceptor;
import org.apache.http.annotation.Immutable;
import org.apache.http.client.entity.DeflateDecompressingEntity;
import org.apache.http.client.entity.GzipDecompressingEntity;
import org.apache.http.protocol.HttpContext;

@Immutable
public class ResponseContentEncoding implements HttpResponseInterceptor {
    public static final String UNCOMPRESSED = "http.client.response.uncompressed";

    @Override  // org.apache.http.HttpResponseInterceptor
    public void process(HttpResponse httpResponse0, HttpContext httpContext0) {
        HttpEntity httpEntity0 = httpResponse0.getEntity();
        if(httpEntity0 != null && httpEntity0.getContentLength() != 0L) {
            Header header0 = httpEntity0.getContentEncoding();
            if(header0 != null) {
                HeaderElement[] arr_headerElement = header0.getElements();
                if(arr_headerElement.length > 0) {
                    HeaderElement headerElement0 = arr_headerElement[0];
                    String s = headerElement0.getName().toLowerCase(Locale.ENGLISH);
                    if("gzip".equals(s) || "x-gzip".equals(s)) {
                        httpResponse0.setEntity(new GzipDecompressingEntity(httpResponse0.getEntity()));
                        httpResponse0.removeHeaders("Content-Length");
                        httpResponse0.removeHeaders("Content-Encoding");
                        httpResponse0.removeHeaders("Content-MD5");
                    }
                    else if("deflate".equals(s)) {
                        httpResponse0.setEntity(new DeflateDecompressingEntity(httpResponse0.getEntity()));
                        httpResponse0.removeHeaders("Content-Length");
                        httpResponse0.removeHeaders("Content-Encoding");
                        httpResponse0.removeHeaders("Content-MD5");
                    }
                    else if(!"identity".equals(s)) {
                        throw new HttpException("Unsupported Content-Coding: " + headerElement0.getName());
                    }
                }
            }
        }
    }
}


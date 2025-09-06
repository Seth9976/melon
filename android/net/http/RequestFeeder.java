package android.net.http;

import org.apache.http.HttpHost;

interface RequestFeeder {
    Request getRequest();

    Request getRequest(HttpHost arg1);

    boolean haveRequest(HttpHost arg1);

    void requeueRequest(Request arg1);
}


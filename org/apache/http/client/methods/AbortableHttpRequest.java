package org.apache.http.client.methods;

import org.apache.http.conn.ClientConnectionRequest;
import org.apache.http.conn.ConnectionReleaseTrigger;

@Deprecated
public interface AbortableHttpRequest {
    void abort();

    void setConnectionRequest(ClientConnectionRequest arg1);

    void setReleaseTrigger(ConnectionReleaseTrigger arg1);
}


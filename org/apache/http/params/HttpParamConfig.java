package org.apache.http.params;

import java.nio.charset.Charset;
import org.apache.http.config.ConnectionConfig.Builder;
import org.apache.http.config.ConnectionConfig;
import org.apache.http.config.MessageConstraints;
import org.apache.http.config.SocketConfig;

@Deprecated
public final class HttpParamConfig {
    public static ConnectionConfig getConnectionConfig(HttpParams httpParams0) {
        MessageConstraints messageConstraints0 = HttpParamConfig.getMessageConstraints(httpParams0);
        String s = (String)httpParams0.getParameter("http.protocol.element-charset");
        Builder connectionConfig$Builder0 = ConnectionConfig.custom();
        return s == null ? connectionConfig$Builder0.setCharset(null).setMessageConstraints(messageConstraints0).build() : connectionConfig$Builder0.setCharset(Charset.forName(s)).setMessageConstraints(messageConstraints0).build();
    }

    public static MessageConstraints getMessageConstraints(HttpParams httpParams0) {
        return MessageConstraints.custom().setMaxHeaderCount(httpParams0.getIntParameter("http.connection.max-header-count", -1)).setMaxLineLength(httpParams0.getIntParameter("http.connection.max-line-length", -1)).build();
    }

    public static SocketConfig getSocketConfig(HttpParams httpParams0) {
        return SocketConfig.custom().setSoTimeout(httpParams0.getIntParameter("http.socket.timeout", 0)).setSoLinger(httpParams0.getIntParameter("http.socket.linger", -1)).setTcpNoDelay(httpParams0.getBooleanParameter("http.tcp.nodelay", true)).build();
    }
}


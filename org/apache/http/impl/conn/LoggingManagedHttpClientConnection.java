package org.apache.http.impl.conn;

import android.util.Log;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.Socket;
import java.nio.charset.CharsetDecoder;
import java.nio.charset.CharsetEncoder;
import org.apache.http.Header;
import org.apache.http.HttpRequest;
import org.apache.http.HttpResponse;
import org.apache.http.annotation.NotThreadSafe;
import org.apache.http.config.MessageConstraints;
import org.apache.http.entity.ContentLengthStrategy;
import org.apache.http.io.HttpMessageParserFactory;
import org.apache.http.io.HttpMessageWriterFactory;

@NotThreadSafe
class LoggingManagedHttpClientConnection extends DefaultManagedHttpClientConnection {
    private static final String HEADER_TAG = "Headers";
    private static final String TAG = "HttpClient";
    private final WireHC4 wire;

    public LoggingManagedHttpClientConnection(String s, int v, int v1, CharsetDecoder charsetDecoder0, CharsetEncoder charsetEncoder0, MessageConstraints messageConstraints0, ContentLengthStrategy contentLengthStrategy0, ContentLengthStrategy contentLengthStrategy1, HttpMessageWriterFactory httpMessageWriterFactory0, HttpMessageParserFactory httpMessageParserFactory0) {
        super(s, v, v1, charsetDecoder0, charsetEncoder0, messageConstraints0, contentLengthStrategy0, contentLengthStrategy1, httpMessageWriterFactory0, httpMessageParserFactory0);
        this.wire = new WireHC4(s);
    }

    @Override  // org.apache.http.impl.BHttpConnectionBase, org.apache.http.HttpConnection
    public void close() {
        if(Log.isLoggable("HttpClient", 3)) {
            Log.d("HttpClient", this.getId() + ": Close connection");
        }
        super.close();
    }

    @Override  // org.apache.http.impl.BHttpConnectionBase
    public InputStream getSocketInputStream(Socket socket0) {
        InputStream inputStream0 = super.getSocketInputStream(socket0);
        return this.wire.enabled() ? new LoggingInputStream(inputStream0, this.wire) : inputStream0;
    }

    @Override  // org.apache.http.impl.BHttpConnectionBase
    public OutputStream getSocketOutputStream(Socket socket0) {
        OutputStream outputStream0 = super.getSocketOutputStream(socket0);
        return this.wire.enabled() ? new LoggingOutputStream(outputStream0, this.wire) : outputStream0;
    }

    @Override  // org.apache.http.impl.DefaultBHttpClientConnection
    public void onRequestSubmitted(HttpRequest httpRequest0) {
        if(httpRequest0 != null && Log.isLoggable("Headers", 3)) {
            Log.d("Headers", this.getId() + " >> " + httpRequest0.getRequestLine().toString());
            Header[] arr_header = httpRequest0.getAllHeaders();
            for(int v = 0; v < arr_header.length; ++v) {
                Log.d("Headers", this.getId() + " >> " + arr_header[v].toString());
            }
        }
    }

    @Override  // org.apache.http.impl.DefaultBHttpClientConnection
    public void onResponseReceived(HttpResponse httpResponse0) {
        if(httpResponse0 != null && Log.isLoggable("Headers", 3)) {
            Log.d("Headers", this.getId() + " << " + httpResponse0.getStatusLine().toString());
            Header[] arr_header = httpResponse0.getAllHeaders();
            for(int v = 0; v < arr_header.length; ++v) {
                Log.d("Headers", this.getId() + " << " + arr_header[v].toString());
            }
        }
    }

    @Override  // org.apache.http.impl.conn.DefaultManagedHttpClientConnection
    public void shutdown() {
        if(Log.isLoggable("HttpClient", 3)) {
            Log.d("HttpClient", this.getId() + ": Shutdown connection");
        }
        super.shutdown();
    }
}


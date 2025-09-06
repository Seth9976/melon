package org.apache.http.impl.io;

import java.util.ArrayList;
import java.util.List;
import org.apache.http.Header;
import org.apache.http.HttpMessage;
import org.apache.http.MessageConstraintException;
import org.apache.http.ParseException;
import org.apache.http.ProtocolException;
import org.apache.http.annotation.NotThreadSafe;
import org.apache.http.config.MessageConstraints;
import org.apache.http.io.HttpMessageParser;
import org.apache.http.io.SessionInputBuffer;
import org.apache.http.message.BasicLineParserHC4;
import org.apache.http.message.LineParser;
import org.apache.http.params.HttpParamConfig;
import org.apache.http.params.HttpParams;
import org.apache.http.util.Args;
import org.apache.http.util.CharArrayBuffer;

@NotThreadSafe
public abstract class AbstractMessageParserHC4 implements HttpMessageParser {
    private static final int HEADERS = 1;
    private static final int HEAD_LINE;
    private final List headerLines;
    protected final LineParser lineParser;
    private HttpMessage message;
    private final MessageConstraints messageConstraints;
    private final SessionInputBuffer sessionBuffer;
    private int state;

    public AbstractMessageParserHC4(SessionInputBuffer sessionInputBuffer0, LineParser lineParser0, MessageConstraints messageConstraints0) {
        this.sessionBuffer = (SessionInputBuffer)Args.notNull(sessionInputBuffer0, "Session input buffer");
        if(lineParser0 == null) {
            lineParser0 = BasicLineParserHC4.INSTANCE;
        }
        this.lineParser = lineParser0;
        if(messageConstraints0 == null) {
            messageConstraints0 = MessageConstraints.DEFAULT;
        }
        this.messageConstraints = messageConstraints0;
        this.headerLines = new ArrayList();
        this.state = 0;
    }

    @Deprecated
    public AbstractMessageParserHC4(SessionInputBuffer sessionInputBuffer0, LineParser lineParser0, HttpParams httpParams0) {
        Args.notNull(sessionInputBuffer0, "Session input buffer");
        Args.notNull(httpParams0, "HTTP parameters");
        this.sessionBuffer = sessionInputBuffer0;
        this.messageConstraints = HttpParamConfig.getMessageConstraints(httpParams0);
        if(lineParser0 == null) {
            lineParser0 = BasicLineParserHC4.INSTANCE;
        }
        this.lineParser = lineParser0;
        this.headerLines = new ArrayList();
        this.state = 0;
    }

    @Override  // org.apache.http.io.HttpMessageParser
    public HttpMessage parse() {
        int v = this.state;
        if(v == 0) {
            try {
                this.message = this.parseHead(this.sessionBuffer);
                this.state = 1;
            }
            catch(ParseException parseException0) {
                throw new ProtocolException(parseException0.getMessage(), parseException0);
            }
        }
        else if(v != 1) {
            throw new IllegalStateException("Inconsistent parser state");
        }
        Header[] arr_header = AbstractMessageParserHC4.parseHeaders(this.sessionBuffer, this.messageConstraints.getMaxHeaderCount(), this.messageConstraints.getMaxLineLength(), this.lineParser, this.headerLines);
        this.message.setHeaders(arr_header);
        HttpMessage httpMessage0 = this.message;
        this.message = null;
        this.headerLines.clear();
        this.state = 0;
        return httpMessage0;
    }

    public abstract HttpMessage parseHead(SessionInputBuffer arg1);

    public static Header[] parseHeaders(SessionInputBuffer sessionInputBuffer0, int v, int v1, LineParser lineParser0) {
        ArrayList arrayList0 = new ArrayList();
        if(lineParser0 == null) {
            lineParser0 = BasicLineParserHC4.INSTANCE;
        }
        return AbstractMessageParserHC4.parseHeaders(sessionInputBuffer0, v, v1, lineParser0, arrayList0);
    }

    public static Header[] parseHeaders(SessionInputBuffer sessionInputBuffer0, int v, int v1, LineParser lineParser0, List list0) {
        int v2;
        Args.notNull(sessionInputBuffer0, "Session input buffer");
        Args.notNull(lineParser0, "Line parser");
        Args.notNull(list0, "Header line list");
        CharArrayBuffer charArrayBuffer0 = null;
        CharArrayBuffer charArrayBuffer1 = null;
        while(true) {
            if(charArrayBuffer0 == null) {
                charArrayBuffer0 = new CharArrayBuffer(0x40);
            }
            else {
                charArrayBuffer0.clear();
            }
            v2 = 0;
            if(sessionInputBuffer0.readLine(charArrayBuffer0) == -1 || charArrayBuffer0.length() < 1) {
                break;
            }
            switch(charArrayBuffer0.charAt(0)) {
                case 9: 
                case 0x20: {
                    if(charArrayBuffer1 != null) {
                    label_14:
                        while(v2 < charArrayBuffer0.length()) {
                            switch(charArrayBuffer0.charAt(v2)) {
                                case 9: 
                                case 0x20: {
                                    ++v2;
                                    continue;
                                }
                                default: {
                                    break label_14;
                                }
                            }
                        }
                        if(v1 > 0) {
                            int v3 = charArrayBuffer1.length();
                            if(charArrayBuffer0.length() + (v3 + 1) - v2 > v1) {
                                throw new MessageConstraintException("Maximum line length limit exceeded");
                            }
                        }
                        charArrayBuffer1.append(' ');
                        charArrayBuffer1.append(charArrayBuffer0, v2, charArrayBuffer0.length() - v2);
                        goto label_29;
                    }
                }
            }
            list0.add(charArrayBuffer0);
            charArrayBuffer1 = charArrayBuffer0;
            charArrayBuffer0 = null;
        label_29:
            if(v > 0 && list0.size() >= v) {
                throw new MessageConstraintException("Maximum header count exceeded");
            }
        }
        Header[] arr_header = new Header[list0.size()];
        while(v2 < list0.size()) {
            CharArrayBuffer charArrayBuffer2 = (CharArrayBuffer)list0.get(v2);
            try {
                arr_header[v2] = lineParser0.parseHeader(charArrayBuffer2);
                ++v2;
            }
            catch(ParseException parseException0) {
                throw new ProtocolException(parseException0.getMessage());
            }
        }
        return arr_header;
    }
}


package org.apache.http.io;

import org.apache.http.config.MessageConstraints;

public interface HttpMessageParserFactory {
    HttpMessageParser create(SessionInputBuffer arg1, MessageConstraints arg2);
}


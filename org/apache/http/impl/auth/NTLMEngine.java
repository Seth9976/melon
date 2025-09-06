package org.apache.http.impl.auth;

@Deprecated
public interface NTLMEngine {
    String generateType1Msg(String arg1, String arg2);

    String generateType3Msg(String arg1, String arg2, String arg3, String arg4, String arg5);
}


package org.gagravarr.ogg;

public interface OggStreamListener {
    OggStreamReader[] processNewStream(int arg1, byte[] arg2);

    void processStreamEnd(int arg1);
}


package org.gagravarr.ogg;

public interface OggStreamPacket {
    byte[] getData();

    void setData(byte[] arg1);

    OggPacket write();
}


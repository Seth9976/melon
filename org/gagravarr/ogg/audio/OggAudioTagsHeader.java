package org.gagravarr.ogg.audio;

import java.util.List;
import org.gagravarr.ogg.OggStreamPacket;

public interface OggAudioTagsHeader extends OggStreamPacket {
    String getAlbum();

    String getArtist();

    List getComments(String arg1);

    String getDate();

    String getGenre();

    String getTitle();

    String getTrackNumber();

    int getTrackNumberNumeric();

    String getVendor();
}


package com.iloen.melon.net.mcp.response;

import com.iloen.melon.net.v5x.common.StatsElementsBase;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class MixUpPlayBase implements Serializable {
    public static class PlaylistBase implements Serializable {
        public List songIdList;
        public StatsElementsBase statsElements;

        public PlaylistBase() {
            this.songIdList = new ArrayList();
        }
    }

    public PlaylistBase playlist;
    public String subtitle;
    public String title;
    public PlaylistBase waitingList;

    public MixUpPlayBase() {
        this.title = "";
        this.subtitle = "";
    }
}


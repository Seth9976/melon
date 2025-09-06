package com.google.android.exoplayer2.trackselection;

import android.util.Pair;
import com.google.android.exoplayer2.RendererCapabilities;
import com.google.android.exoplayer2.RendererConfiguration;
import com.google.android.exoplayer2.Timeline;
import com.google.android.exoplayer2.source.MediaSource.MediaPeriodId;
import com.google.android.exoplayer2.source.TrackGroup;
import com.google.android.exoplayer2.source.TrackGroupArray;
import com.google.android.exoplayer2.util.MimeTypes;
import com.google.android.exoplayer2.util.Util;
import java.util.Arrays;

public abstract class MappingTrackSelector extends TrackSelector {
    public static final class MappedTrackInfo {
        public static final int RENDERER_SUPPORT_EXCEEDS_CAPABILITIES_TRACKS = 2;
        public static final int RENDERER_SUPPORT_NO_TRACKS = 0;
        public static final int RENDERER_SUPPORT_PLAYABLE_TRACKS = 3;
        public static final int RENDERER_SUPPORT_UNSUPPORTED_TRACKS = 1;
        @Deprecated
        public final int length;
        private final int rendererCount;
        private final int[][][] rendererFormatSupports;
        private final int[] rendererMixedMimeTypeAdaptiveSupports;
        private final TrackGroupArray[] rendererTrackGroups;
        private final int[] rendererTrackTypes;
        private final TrackGroupArray unmappedTrackGroups;

        public MappedTrackInfo(int[] arr_v, TrackGroupArray[] arr_trackGroupArray, int[] arr_v1, int[][][] arr3_v, TrackGroupArray trackGroupArray0) {
            this.rendererTrackTypes = arr_v;
            this.rendererTrackGroups = arr_trackGroupArray;
            this.rendererFormatSupports = arr3_v;
            this.rendererMixedMimeTypeAdaptiveSupports = arr_v1;
            this.unmappedTrackGroups = trackGroupArray0;
            this.rendererCount = arr_v.length;
            this.length = arr_v.length;
        }

        public int getAdaptiveSupport(int v, int v1, boolean z) {
            int v2 = this.rendererTrackGroups[v].get(v1).length;
            int[] arr_v = new int[v2];
            int v4 = 0;
            for(int v3 = 0; v3 < v2; ++v3) {
                int v5 = this.getTrackSupport(v, v1, v3);
                if(v5 == 4 || z && v5 == 3) {
                    arr_v[v4] = v3;
                    ++v4;
                }
            }
            return this.getAdaptiveSupport(v, v1, Arrays.copyOf(arr_v, v4));
        }

        public int getAdaptiveSupport(int v, int v1, int[] arr_v) {
            int v2 = 0;
            int v3 = 16;
            String s = null;
            int v4 = 0;
            for(int v5 = 0; v2 < arr_v.length; ++v5) {
                String s1 = this.rendererTrackGroups[v].get(v1).getFormat(arr_v[v2]).sampleMimeType;
                if(v5 == 0) {
                    s = s1;
                }
                else {
                    v4 |= !Util.areEqual(s, s1);
                }
                v3 = Math.min(v3, RendererCapabilities.getAdaptiveSupport(this.rendererFormatSupports[v][v1][v2]));
                ++v2;
            }
            return v4 == 0 ? v3 : Math.min(v3, this.rendererMixedMimeTypeAdaptiveSupports[v]);
        }

        public int getRendererCount() {
            return this.rendererCount;
        }

        public int getRendererSupport(int v) {
            int[][] arr2_v = this.rendererFormatSupports[v];
            int v2 = 0;
            for(int v1 = 0; v1 < arr2_v.length; ++v1) {
                int[] arr_v = arr2_v[v1];
                for(int v3 = 0; v3 < arr_v.length; ++v3) {
                    int v4 = RendererCapabilities.getFormatSupport(arr_v[v3]);
                    int v5 = 1;
                    if(v4 != 0 && v4 != 1) {
                        switch(v4) {
                            case 2: {
                                break;
                            }
                            case 3: {
                                v5 = 2;
                                break;
                            }
                            case 4: {
                                return 3;
                            }
                            default: {
                                throw new IllegalStateException();
                            }
                        }
                    }
                    v2 = Math.max(v2, v5);
                }
            }
            return v2;
        }

        public int getRendererType(int v) {
            return this.rendererTrackTypes[v];
        }

        @Deprecated
        public int getTrackFormatSupport(int v, int v1, int v2) {
            return this.getTrackSupport(v, v1, v2);
        }

        public TrackGroupArray getTrackGroups(int v) {
            return this.rendererTrackGroups[v];
        }

        public int getTrackSupport(int v, int v1, int v2) {
            return RendererCapabilities.getFormatSupport(this.rendererFormatSupports[v][v1][v2]);
        }

        @Deprecated
        public int getTrackTypeRendererSupport(int v) {
            return this.getTypeSupport(v);
        }

        public int getTypeSupport(int v) {
            int v2 = 0;
            for(int v1 = 0; v1 < this.rendererCount; ++v1) {
                if(this.rendererTrackTypes[v1] == v) {
                    v2 = Math.max(v2, this.getRendererSupport(v1));
                }
            }
            return v2;
        }

        @Deprecated
        public TrackGroupArray getUnassociatedTrackGroups() {
            return this.getUnmappedTrackGroups();
        }

        public TrackGroupArray getUnmappedTrackGroups() {
            return this.unmappedTrackGroups;
        }
    }

    private MappedTrackInfo currentMappedTrackInfo;

    private static int findRenderer(RendererCapabilities[] arr_rendererCapabilities, TrackGroup trackGroup0, int[] arr_v, boolean z) {
        int v = arr_rendererCapabilities.length;
        int v2 = 0;
        int v3 = 1;
        for(int v1 = 0; v1 < arr_rendererCapabilities.length; ++v1) {
            RendererCapabilities rendererCapabilities0 = arr_rendererCapabilities[v1];
            int v5 = 0;
            for(int v4 = 0; v4 < trackGroup0.length; ++v4) {
                v5 = Math.max(v5, RendererCapabilities.getFormatSupport(rendererCapabilities0.supportsFormat(trackGroup0.getFormat(v4))));
            }
            int v6 = arr_v[v1] == 0 ? 1 : 0;
            if(v5 > v2 || v5 == v2 && z && v3 == 0 && v6 != 0) {
                v = v1;
                v3 = v6;
                v2 = v5;
            }
        }
        return v;
    }

    public final MappedTrackInfo getCurrentMappedTrackInfo() {
        return this.currentMappedTrackInfo;
    }

    private static int[] getFormatSupport(RendererCapabilities rendererCapabilities0, TrackGroup trackGroup0) {
        int[] arr_v = new int[trackGroup0.length];
        for(int v = 0; v < trackGroup0.length; ++v) {
            arr_v[v] = rendererCapabilities0.supportsFormat(trackGroup0.getFormat(v));
        }
        return arr_v;
    }

    private static int[] getMixedMimeTypeAdaptationSupports(RendererCapabilities[] arr_rendererCapabilities) {
        int[] arr_v = new int[arr_rendererCapabilities.length];
        for(int v = 0; v < arr_rendererCapabilities.length; ++v) {
            arr_v[v] = arr_rendererCapabilities[v].supportsMixedMimeTypeAdaptation();
        }
        return arr_v;
    }

    @Override  // com.google.android.exoplayer2.trackselection.TrackSelector
    public final void onSelectionActivated(Object object0) {
        this.currentMappedTrackInfo = (MappedTrackInfo)object0;
    }

    public abstract Pair selectTracks(MappedTrackInfo arg1, int[][][] arg2, int[] arg3);

    @Override  // com.google.android.exoplayer2.trackselection.TrackSelector
    public final TrackSelectorResult selectTracks(RendererCapabilities[] arr_rendererCapabilities, TrackGroupArray trackGroupArray0, MediaPeriodId mediaSource$MediaPeriodId0, Timeline timeline0) {
        int[] arr_v = new int[arr_rendererCapabilities.length + 1];
        int v = arr_rendererCapabilities.length + 1;
        TrackGroup[][] arr2_trackGroup = new TrackGroup[v][];
        int[][][] arr3_v = new int[arr_rendererCapabilities.length + 1][][];
        for(int v2 = 0; v2 < v; ++v2) {
            arr2_trackGroup[v2] = new TrackGroup[trackGroupArray0.length];
            arr3_v[v2] = new int[trackGroupArray0.length][];
        }
        int[] arr_v1 = MappingTrackSelector.getMixedMimeTypeAdaptationSupports(arr_rendererCapabilities);
        for(int v3 = 0; v3 < trackGroupArray0.length; ++v3) {
            TrackGroup trackGroup0 = trackGroupArray0.get(v3);
            int v4 = MappingTrackSelector.findRenderer(arr_rendererCapabilities, trackGroup0, arr_v, MimeTypes.getTrackType(trackGroup0.getFormat(0).sampleMimeType) == 4);
            int[] arr_v2 = v4 == arr_rendererCapabilities.length ? new int[trackGroup0.length] : MappingTrackSelector.getFormatSupport(arr_rendererCapabilities[v4], trackGroup0);
            int v5 = arr_v[v4];
            arr2_trackGroup[v4][v5] = trackGroup0;
            arr3_v[v4][v5] = arr_v2;
            arr_v[v4] = v5 + 1;
        }
        TrackGroupArray[] arr_trackGroupArray = new TrackGroupArray[arr_rendererCapabilities.length];
        int[] arr_v3 = new int[arr_rendererCapabilities.length];
        for(int v1 = 0; v1 < arr_rendererCapabilities.length; ++v1) {
            int v6 = arr_v[v1];
            arr_trackGroupArray[v1] = new TrackGroupArray(((TrackGroup[])Util.nullSafeArrayCopy(arr2_trackGroup[v1], v6)));
            arr3_v[v1] = (int[][])Util.nullSafeArrayCopy(arr3_v[v1], v6);
            arr_v3[v1] = arr_rendererCapabilities[v1].getTrackType();
        }
        MappedTrackInfo mappingTrackSelector$MappedTrackInfo0 = new MappedTrackInfo(arr_v3, arr_trackGroupArray, arr_v1, arr3_v, new TrackGroupArray(((TrackGroup[])Util.nullSafeArrayCopy(arr2_trackGroup[arr_rendererCapabilities.length], arr_v[arr_rendererCapabilities.length]))));
        Pair pair0 = this.selectTracks(mappingTrackSelector$MappedTrackInfo0, arr3_v, arr_v1);
        return new TrackSelectorResult(((RendererConfiguration[])pair0.first), ((TrackSelection[])pair0.second), mappingTrackSelector$MappedTrackInfo0);
    }
}


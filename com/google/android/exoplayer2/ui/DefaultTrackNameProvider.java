package com.google.android.exoplayer2.ui;

import android.content.res.Resources;
import android.text.TextUtils;
import com.google.android.exoplayer2.Format;
import com.google.android.exoplayer2.util.Assertions;
import com.google.android.exoplayer2.util.MimeTypes;
import com.google.android.exoplayer2.util.Util;
import java.util.Locale;

public class DefaultTrackNameProvider implements TrackNameProvider {
    private final Resources resources;

    public DefaultTrackNameProvider(Resources resources0) {
        this.resources = (Resources)Assertions.checkNotNull(resources0);
    }

    private String buildAudioChannelString(Format format0) {
        int v = format0.channelCount;
        if(v != -1 && v >= 1) {
            switch(v) {
                case 1: {
                    return this.resources.getString(string.exo_track_mono);
                }
                case 2: {
                    return this.resources.getString(string.exo_track_stereo);
                }
                case 6: 
                case 7: {
                    return this.resources.getString(string.exo_track_surround_5_point_1);
                }
                case 8: {
                    return this.resources.getString(string.exo_track_surround_7_point_1);
                }
                default: {
                    return this.resources.getString(string.exo_track_surround);
                }
            }
        }
        return "";
    }

    private String buildBitrateString(Format format0) {
        return format0.bitrate == -1 ? "" : this.resources.getString(string.exo_track_bitrate, new Object[]{((float)(((float)format0.bitrate) / 1000000.0f))});
    }

    // 去混淆评级： 低(20)
    private String buildLabelString(Format format0) {
        return TextUtils.isEmpty(format0.label) ? "" : format0.label;
    }

    private String buildLanguageOrLabelString(Format format0) {
        String s = this.joinWithSeparator(new String[]{this.buildLanguageString(format0), this.buildRoleString(format0)});
        return TextUtils.isEmpty(s) ? this.buildLabelString(format0) : s;
    }

    private String buildLanguageString(Format format0) {
        String s = format0.language;
        if(!TextUtils.isEmpty(s) && !"und".equals(s)) {
            return Util.SDK_INT < 21 ? new Locale(s).getDisplayName() : Locale.forLanguageTag(s).getDisplayName();
        }
        return "";
    }

    private String buildResolutionString(Format format0) {
        return format0.width == -1 || format0.height == -1 ? "" : this.resources.getString(string.exo_track_resolution, new Object[]{format0.width, format0.height});
    }

    private String buildRoleString(Format format0) {
        String s = (format0.roleFlags & 2) == 0 ? "" : this.resources.getString(string.exo_track_role_alternate);
        if((format0.roleFlags & 4) != 0) {
            s = this.joinWithSeparator(new String[]{s, this.resources.getString(string.exo_track_role_supplementary)});
        }
        if((format0.roleFlags & 8) != 0) {
            s = this.joinWithSeparator(new String[]{s, this.resources.getString(string.exo_track_role_commentary)});
        }
        return (format0.roleFlags & 0x440) == 0 ? s : this.joinWithSeparator(new String[]{s, this.resources.getString(string.exo_track_role_closed_captions)});
    }

    @Override  // com.google.android.exoplayer2.ui.TrackNameProvider
    public String getTrackName(Format format0) {
        String s;
        int v = DefaultTrackNameProvider.inferPrimaryTrackType(format0);
        if(v == 2) {
            s = this.joinWithSeparator(new String[]{this.buildRoleString(format0), this.buildResolutionString(format0), this.buildBitrateString(format0)});
            return s.length() == 0 ? this.resources.getString(string.exo_track_unknown) : s;
        }
        s = v == 1 ? this.joinWithSeparator(new String[]{this.buildLanguageOrLabelString(format0), this.buildAudioChannelString(format0), this.buildBitrateString(format0)}) : this.buildLanguageOrLabelString(format0);
        return s.length() == 0 ? this.resources.getString(string.exo_track_unknown) : s;
    }

    private static int inferPrimaryTrackType(Format format0) {
        int v = MimeTypes.getTrackType(format0.sampleMimeType);
        if(v != -1) {
            return v;
        }
        if(MimeTypes.getVideoMediaMimeType(format0.codecs) != null) {
            return 2;
        }
        if(MimeTypes.getAudioMediaMimeType(format0.codecs) != null) {
            return 1;
        }
        if(format0.width == -1 && format0.height == -1) {
            return format0.channelCount != -1 || format0.sampleRate != -1 ? 1 : -1;
        }
        return 2;
    }

    private String joinWithSeparator(String[] arr_s) {
        String s = "";
        for(int v = 0; v < arr_s.length; ++v) {
            String s1 = arr_s[v];
            if(s1.length() > 0) {
                s = TextUtils.isEmpty(s) ? s1 : this.resources.getString(string.exo_item_list, new Object[]{s, s1});
            }
        }
        return s;
    }
}


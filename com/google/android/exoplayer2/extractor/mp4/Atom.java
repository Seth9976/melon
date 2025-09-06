package com.google.android.exoplayer2.extractor.mp4;

import b3.Z;
import com.google.android.exoplayer2.util.ParsableByteArray;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

abstract class Atom {
    static final class ContainerAtom extends Atom {
        public final List containerChildren;
        public final long endPosition;
        public final List leafChildren;

        public ContainerAtom(int v, long v1) {
            super(v);
            this.endPosition = v1;
            this.leafChildren = new ArrayList();
            this.containerChildren = new ArrayList();
        }

        public void add(ContainerAtom atom$ContainerAtom0) {
            this.containerChildren.add(atom$ContainerAtom0);
        }

        public void add(LeafAtom atom$LeafAtom0) {
            this.leafChildren.add(atom$LeafAtom0);
        }

        public int getChildAtomOfTypeCount(int v) {
            int v1 = this.leafChildren.size();
            int v4 = 0;
            for(int v3 = 0; v3 < v1; ++v3) {
                if(((LeafAtom)this.leafChildren.get(v3)).type == v) {
                    ++v4;
                }
            }
            int v5 = this.containerChildren.size();
            for(int v2 = 0; v2 < v5; ++v2) {
                if(((ContainerAtom)this.containerChildren.get(v2)).type == v) {
                    ++v4;
                }
            }
            return v4;
        }

        public ContainerAtom getContainerAtomOfType(int v) {
            int v1 = this.containerChildren.size();
            for(int v2 = 0; v2 < v1; ++v2) {
                ContainerAtom atom$ContainerAtom0 = (ContainerAtom)this.containerChildren.get(v2);
                if(atom$ContainerAtom0.type == v) {
                    return atom$ContainerAtom0;
                }
            }
            return null;
        }

        public LeafAtom getLeafAtomOfType(int v) {
            int v1 = this.leafChildren.size();
            for(int v2 = 0; v2 < v1; ++v2) {
                LeafAtom atom$LeafAtom0 = (LeafAtom)this.leafChildren.get(v2);
                if(atom$LeafAtom0.type == v) {
                    return atom$LeafAtom0;
                }
            }
            return null;
        }

        @Override  // com.google.android.exoplayer2.extractor.mp4.Atom
        public String toString() {
            String s = Atom.getAtomTypeString(this.type);
            String s1 = Arrays.toString(this.leafChildren.toArray());
            String s2 = Arrays.toString(this.containerChildren.toArray());
            StringBuilder stringBuilder0 = Z.o(Z.e(Z.e(Z.e(22, s), s1), s2), s, " leaves: ", s1, " containers: ");
            stringBuilder0.append(s2);
            return stringBuilder0.toString();
        }
    }

    static final class LeafAtom extends Atom {
        public final ParsableByteArray data;

        public LeafAtom(int v, ParsableByteArray parsableByteArray0) {
            super(v);
            this.data = parsableByteArray0;
        }
    }

    public static final int DEFINES_LARGE_SIZE = 1;
    public static final int EXTENDS_TO_END_SIZE = 0;
    public static final int FULL_HEADER_SIZE = 12;
    public static final int HEADER_SIZE = 8;
    public static final int LONG_HEADER_SIZE = 16;
    public static final int TYPE_Opus = 0x4F707573;
    public static final int TYPE_TTML = 1414810956;
    public static final int TYPE__mp3 = 0x2E6D7033;
    public static final int TYPE_ac_3 = 0x61632D33;
    public static final int TYPE_ac_4 = 0x61632D34;
    public static final int TYPE_alac = 0x616C6163;
    public static final int TYPE_alaw = 0x616C6177;
    public static final int TYPE_av01 = 0x61763031;
    public static final int TYPE_av1C = 0x61763143;
    public static final int TYPE_avc1 = 0x61766331;
    public static final int TYPE_avc3 = 0x61766333;
    public static final int TYPE_avcC = 0x61766343;
    public static final int TYPE_c608 = 0x63363038;
    public static final int TYPE_camm = 0x63616D6D;
    public static final int TYPE_co64 = 0x636F3634;
    public static final int TYPE_ctts = 0x63747473;
    public static final int TYPE_d263 = 1681012275;
    public static final int TYPE_dOps = 0x644F7073;
    public static final int TYPE_dac3 = 1684103987;
    public static final int TYPE_dac4 = 1684103988;
    public static final int TYPE_data = 1684108385;
    public static final int TYPE_ddts = 1684305011;
    public static final int TYPE_dec3 = 0x64656333;
    public static final int TYPE_dfLa = 0x64664C61;
    public static final int TYPE_dtsc = 0x64747363;
    public static final int TYPE_dtse = 0x64747365;
    public static final int TYPE_dtsh = 1685353320;
    public static final int TYPE_dtsl = 0x6474736C;
    public static final int TYPE_dva1 = 0x64766131;
    public static final int TYPE_dvav = 0x64766176;
    public static final int TYPE_dvcC = 1685480259;
    public static final int TYPE_dvh1 = 0x64766831;
    public static final int TYPE_dvhe = 0x64766865;
    public static final int TYPE_dvvC = 0x64767643;
    public static final int TYPE_ec_3 = 1700998451;
    public static final int TYPE_edts = 1701082227;
    public static final int TYPE_elst = 1701606260;
    public static final int TYPE_emsg = 1701671783;
    public static final int TYPE_enca = 1701733217;
    public static final int TYPE_encv = 1701733238;
    public static final int TYPE_esds = 1702061171;
    public static final int TYPE_fLaC = 0x664C6143;
    public static final int TYPE_frma = 0x66726D61;
    public static final int TYPE_ftyp = 0x66747970;
    public static final int TYPE_hdlr = 0x68646C72;
    public static final int TYPE_hev1 = 0x68657631;
    public static final int TYPE_hvc1 = 1752589105;
    public static final int TYPE_hvcC = 0x68766343;
    public static final int TYPE_ilst = 0x696C7374;
    public static final int TYPE_keys = 1801812339;
    public static final int TYPE_lpcm = 0x6C70636D;
    public static final int TYPE_mdat = 1835295092;
    public static final int TYPE_mdhd = 0x6D646864;
    public static final int TYPE_mdia = 0x6D646961;
    public static final int TYPE_mean = 1835360622;
    public static final int TYPE_mehd = 1835362404;
    public static final int TYPE_meta = 0x6D657461;
    public static final int TYPE_minf = 1835626086;
    public static final int TYPE_moof = 0x6D6F6F66;
    public static final int TYPE_moov = 0x6D6F6F76;
    public static final int TYPE_mp4a = 0x6D703461;
    public static final int TYPE_mp4v = 1836070006;
    public static final int TYPE_mvex = 0x6D766578;
    public static final int TYPE_mvhd = 0x6D766864;
    public static final int TYPE_name = 0x6E616D65;
    public static final int TYPE_pasp = 0x70617370;
    public static final int TYPE_proj = 0x70726F6A;
    public static final int TYPE_pssh = 0x70737368;
    public static final int TYPE_s263 = 1932670515;
    public static final int TYPE_saio = 0x7361696F;
    public static final int TYPE_saiz = 0x7361697A;
    public static final int TYPE_samr = 1935764850;
    public static final int TYPE_sawb = 0x73617762;
    public static final int TYPE_sbgp = 0x73626770;
    public static final int TYPE_schi = 0x73636869;
    public static final int TYPE_schm = 0x7363686D;
    public static final int TYPE_senc = 1936027235;
    public static final int TYPE_sgpd = 0x73677064;
    public static final int TYPE_sidx = 1936286840;
    public static final int TYPE_sinf = 0x73696E66;
    public static final int TYPE_sowt = 0x736F7774;
    public static final int TYPE_st3d = 0x73743364;
    public static final int TYPE_stbl = 1937007212;
    public static final int TYPE_stco = 1937007471;
    public static final int TYPE_stpp = 1937010800;
    public static final int TYPE_stsc = 1937011555;
    public static final int TYPE_stsd = 1937011556;
    public static final int TYPE_stss = 1937011571;
    public static final int TYPE_stsz = 1937011578;
    public static final int TYPE_stts = 1937011827;
    public static final int TYPE_stz2 = 1937013298;
    public static final int TYPE_sv3d = 0x73763364;
    public static final int TYPE_tenc = 1952804451;
    public static final int TYPE_tfdt = 0x74666474;
    public static final int TYPE_tfhd = 0x74666864;
    public static final int TYPE_tkhd = 0x746B6864;
    public static final int TYPE_traf = 1953653094;
    public static final int TYPE_trak = 1953653099;
    public static final int TYPE_trex = 0x74726578;
    public static final int TYPE_trun = 0x7472756E;
    public static final int TYPE_twos = 0x74776F73;
    public static final int TYPE_tx3g = 1954034535;
    public static final int TYPE_udta = 0x75647461;
    public static final int TYPE_ulaw = 1970037111;
    public static final int TYPE_uuid = 1970628964;
    public static final int TYPE_vmhd = 0x766D6864;
    public static final int TYPE_vp08 = 0x76703038;
    public static final int TYPE_vp09 = 0x76703039;
    public static final int TYPE_vpcC = 0x76706343;
    public static final int TYPE_wave = 2002876005;
    public static final int TYPE_wvtt = 2004251764;
    public final int type;

    public Atom(int v) {
        this.type = v;
    }

    public static String getAtomTypeString(int v) {
        return ((char)(v >> 24 & 0xFF)) + ((char)(v >> 16 & 0xFF)) + ((char)(v >> 8 & 0xFF)) + ((char)(v & 0xFF));
    }

    public static int parseFullAtomFlags(int v) [...] // Inlined contents

    public static int parseFullAtomVersion(int v) [...] // Inlined contents

    @Override
    public String toString() {
        return Atom.getAtomTypeString(this.type);
    }
}


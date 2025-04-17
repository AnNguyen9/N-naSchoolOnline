package assembly;

import Event.EventName;
import Item.ItemName;
import io.Util;
import stream.Server;

/**
 *
 * @author 
 */
public class ItemLeave {

    public static short[] ItemTrangBi3x = new short[]{
        96, 101, 106, 111, 116, 121,
        128, 129, 176, 138, 139, 181, 148, 149, 186, 158, 159, 191, 168, 169
    };
    public static short[] ItemTrangBi4x = new short[]{
        171, 161, 151, 141, 131,
        170, 160, 150, 140, 130,
        97, 102, 107, 112, 117, 122,
        192, 187, 182, 177
    };
    public static short[] ItemTrangBi5x = new short[]{
        173, 163, 153, 143, 133,
        172, 162, 152, 142, 132,
        98, 103, 108, 113, 118, 123,
        193, 188, 183, 178
    };
    public static short[] ItemTrangBi6x = new short[]{
        330, 329, 328, 327, 326,
        325, 323, 321, 319, 317,
        324, 322, 320, 318
    };
    public static short[] ItemTrangBi7x = new short[]{
        363, 361, 359, 357, 355,
        368, 367, 366, 365, 364,
        362, 360, 358, 356
    };
    public static short[] ItemTrangBi8x = new short[]{
        500, 501, 502, 496, 497, 503, 498, 499, 504, 494, 495, 505, 492, 493

    };
    public static short[] Do10x = new short[]{885, 886, 887, 888, 889, 890};
    public static short[] Dathuctinh = new short[]{893};
    public static short[] VuKhi5x = new short[]{98, 103, 108, 113, 118, 123};
    public static short[] VuKhi6x = new short[]{331, 332, 333, 334, 335, 336};
    public static short[] VuKhi7x = new short[]{369, 370, 371, 372, 373, 374};
    public static short[] VuKhi8x = new short[]{506, 507, 508, 509, 510, 511};
    public static short[] VuKhi9x = new short[]{632, 633, 634, 635, 636, 637};
    public static short[] VienNgocRong = new short[]{222, 223, 224, 225, 226, 227};
    public static short[] Cacloaidan = new short[]{275, 276, 277, 278, 545};
    public static short[] Ruonghuyenthoai = new short[]{891, 545};
    //------------------------------------------------------------------------//
    public static short[] TrangBiXeSoi = new short[]{439, 486, 440, 487, 441, 488, 442, 489}; // trang bị sói xe
    public static short[] ExpXeSoi = new short[]{573, 574, 575, 576, 577, 578}; // exp xe sói
    public static short[] arrItemmapngoai = new short[]{10000, 10000, 10000, 10000, 10001, 10001, 10001, 10001, 10002, 10002, 10002, 10002, 10002, 10003};

    //-------------------------------------------------------------------------//
    public static short[] VatPhamSuKien = new short[]{ItemName.BANH_THAP_CAM, ItemName.BANH_DEO, ItemName.BANH_DAU_XANH, ItemName.BANH_PIA};
    public static short[] arrItemSuKienHalloween = new short[]{ItemName.XUONG_THU, ItemName.TAN_LINH, ItemName.QUA_TAO, ItemName.MAT_ONG};
    public static short[] ItemLDGT = new short[]{
        ItemName.DA_CAP_8, ItemName.DA_CAP_8, ItemName.DA_CAP_8, ItemName.DA_CAP_8, ItemName.DA_CAP_8,
        ItemName.CHUYEN_TINH_THACH,
        ItemName.DA_NANG_CAP_BI_KIP, ItemName.DA_NANG_CAP_BI_KIP, ItemName.DA_NANG_CAP_BI_KIP, ItemName.DA_NANG_CAP_BI_KIP, ItemName.DA_NANG_CAP_BI_KIP,
        ItemName.DA_THANG_AN, ItemName.DA_THANG_AN, ItemName.DA_THANG_AN, ItemName.DA_THANG_AN, ItemName.DA_THANG_AN,
        ItemName.THE_BAI_KINH_NGHIEM_GIA_TOC_SO, ItemName.THE_BAI_KINH_NGHIEM_GIA_TOC_SO, ItemName.THE_BAI_KINH_NGHIEM_GIA_TOC_SO,
        ItemName.THE_BAI_KINH_NGHIEM_GIA_TOC_TRUNG,
        ItemName.THE_BAI_KINH_NGHIEM_GIA_TOC_CAO,
        ItemName.NGOC_1_SAO, ItemName.NGOC_2_SAO, ItemName.NGOC_3_SAO};

    public static void LeaveItemMapVIP(TileMap place, Mob mob3, int master) {
        ItemMap im = null;
        try {
            if (Util.nextInt(500) < 1) {
                im = place.LeaveItem((short) TrangBiXeSoi[Util.nextInt(TrangBiXeSoi.length)], mob3.x, mob3.y, mob3.templates.type, false);
            } else if (Util.nextInt(500) < 5) {
                im = place.LeaveItem((short) ExpXeSoi[Util.nextInt(ExpXeSoi.length)], mob3.x, mob3.y, mob3.templates.type, false);
            } else if (Util.nextInt(500) < 1) {
                im = place.LeaveItem((short) Cacloaidan[Util.nextInt(Cacloaidan.length)], mob3.x, mob3.y, mob3.templates.type, false);
            } else if (Util.nextInt(500) < 1) {
                im = place.LeaveItem((short) ItemName.TU_TINH_THACH_SO_CAP, mob3.x, mob3.y, mob3.templates.type, false); // TTS
            } else if (Util.nextInt(500) < 1) {
                im = place.LeaveItem((short) ItemName.TU_TINH_THACH_TRUNG_CAP, mob3.x, mob3.y, mob3.templates.type, false); // TTS
            } else if (Util.nextInt(700) < 1) {
                im = place.LeaveItem((short) ItemName.CHUYEN_TINH_THACH, mob3.x, mob3.y, mob3.templates.type, false); // TTS
            } else if (Util.nextInt(500) < 1) {
                im = place.LeaveItem((short) ItemName.DA_NANG_CAP_BI_KIP, mob3.x, mob3.y, mob3.templates.type, false); // TTS
            } else if (Util.nextInt(500) < 1) {
                im = place.LeaveItem((short) VienNgocRong[Util.nextInt(VienNgocRong.length)], mob3.x, mob3.y, mob3.templates.type, false);
            } else if (mob3.lvboss == 2) {
                im = place.LeaveItem((short) ItemName.NGOC_7_SAO, mob3.x, mob3.y, mob3.templates.type, false); // TTS
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        if (im != null) {
            im.item.quantity = 1;
            im.item.isLock = false;
            im.master = master;
        }
    }

    public static void LeaveItemMapBiAn(TileMap place, Mob mob3, int master) {
        ItemMap im = null;
        try {
            if (Util.nextInt(500) < 1) {
                im = place.LeaveItem((short) TrangBiXeSoi[Util.nextInt(TrangBiXeSoi.length)], mob3.x, mob3.y, mob3.templates.type, false);
            } else if (Util.nextInt(500) < 1) {
                im = place.LeaveItem((short) ExpXeSoi[Util.nextInt(ExpXeSoi.length)], mob3.x, mob3.y, mob3.templates.type, false);
            } else if (Util.nextInt(500) < 1) {
                im = place.LeaveItem((short) Cacloaidan[Util.nextInt(Cacloaidan.length)], mob3.x, mob3.y, mob3.templates.type, false);
            } else if (Util.nextInt(3000) < 1) {
                im = place.LeaveItem((short) ItemName.TU_TINH_THACH_CAO_CAP, mob3.x, mob3.y, mob3.templates.type, false); // TTS
            } else if (Util.nextInt(2000) < 1) {
                im = place.LeaveItem((short) ItemName.TU_TINH_THACH_TRUNG_CAP, mob3.x, mob3.y, mob3.templates.type, false); // TTS
            } else if (Util.nextInt(1500) < 1) {
                im = place.LeaveItem((short) ItemName.CHUYEN_TINH_THACH, mob3.x, mob3.y, mob3.templates.type, false); // TTS
            } else if (Util.nextInt(1000) < 1) {
                im = place.LeaveItem((short) ItemName.DA_NANG_CAP_BI_KIP, mob3.x, mob3.y, mob3.templates.type, false); // TTS
            } else if (Util.nextInt(1000) < 1) {
                im = place.LeaveItem((short) ItemName.DA_THANG_AN, mob3.x, mob3.y, mob3.templates.type, false); // TTS
            } else if (Util.nextInt(1000) < 1) {
                im = place.LeaveItem((short) VienNgocRong[Util.nextInt(VienNgocRong.length)], mob3.x, mob3.y, mob3.templates.type, false);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        if (im != null) {
            im.item.quantity = 1;
            im.item.isLock = false;
            im.master = master;
        }
    }

    public static void LeaveItemMapLangCo(TileMap place, Mob mob3, int master) {
        ItemMap im = null;
        try {
            if (Util.nextInt(500) < 1) {
                im = place.LeaveItem((short) TrangBiXeSoi[Util.nextInt(TrangBiXeSoi.length)], mob3.x, mob3.y, mob3.templates.type, false);
            } else if (Util.nextInt(300) < 1) {
                im = place.LeaveItem((short) ExpXeSoi[Util.nextInt(ExpXeSoi.length)], mob3.x, mob3.y, mob3.templates.type, false);
            } else if (Util.nextInt(200) < 1) {
                im = place.LeaveItem((short) ItemName.TU_TINH_THACH_SO_CAP, mob3.x, mob3.y, mob3.templates.type, false); // TTS
            } else if (Util.nextInt(500) < 1) {
                im = place.LeaveItem((short) Do10x[Util.nextInt(Do10x.length)], mob3.x, mob3.y, mob3.templates.type, false);
            } else if (Util.nextInt(2000) < 1) {
                im = place.LeaveItem((short) Ruonghuyenthoai[Util.nextInt(Ruonghuyenthoai.length)], mob3.x, mob3.y, mob3.templates.type, false);
            } else if (Util.nextInt(1000) < 1) {
                im = place.LeaveItem((short) Dathuctinh[Util.nextInt(Dathuctinh.length)], mob3.x, mob3.y, mob3.templates.type, false);
            } else if (Util.nextInt(600) < 1) {
                im = place.LeaveItem((short) ItemName.TU_TINH_THACH_TRUNG_CAP, mob3.x, mob3.y, mob3.templates.type, false); // TTS
            } else if (Util.nextInt(1500) < 1) {
                im = place.LeaveItem((short) ItemName.CHUYEN_TINH_THACH, mob3.x, mob3.y, mob3.templates.type, false); // TTS
            } else if (Util.nextInt(500) < 1) {
                im = place.LeaveItem((short) ItemName.DA_NANG_CAP_BI_KIP, mob3.x, mob3.y, mob3.templates.type, false); // TTS
            } else if (Util.nextInt(130) < 1) {
                im = place.LeaveItem((short) ItemName.DA_THANG_AN, mob3.x, mob3.y, mob3.templates.type, false); // TTS
            } else if (mob3.lvboss == 2) {
                im = place.LeaveItem((short) ItemName.HARLEY_DAVIDSON, mob3.x, mob3.y, mob3.templates.type, false); // TTS
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        if (im != null) {
            im.item.quantity = 1;
            im.item.isLock = false;
            im.master = master;
        }
    }

    public static void LeaveItemMapVDMQ(TileMap place, Mob mob3, int master) {
        ItemMap im = null;
        try {
            if (Util.nextInt(600) < 1) {
                im = place.LeaveItem((short) TrangBiXeSoi[Util.nextInt(TrangBiXeSoi.length)], mob3.x, mob3.y, mob3.templates.type, false);
            } else if (Util.nextInt(500) < 1) {
                im = place.LeaveItem((short) ExpXeSoi[Util.nextInt(ExpXeSoi.length)], mob3.x, mob3.y, mob3.templates.type, false);
            } else if (Util.nextInt(1000) < 1) {
                im = place.LeaveItem((short) Dathuctinh[Util.nextInt(Dathuctinh.length)], mob3.x, mob3.y, mob3.templates.type, false);
            } else if (Util.nextInt(1000) < 1) {
                im = place.LeaveItem((short) ItemName.TU_TINH_THACH_SO_CAP, mob3.x, mob3.y, mob3.templates.type, false); // TTS
            } else if (Util.nextInt(1500) < 1) {
                im = place.LeaveItem((short) ItemName.TU_TINH_THACH_TRUNG_CAP, mob3.x, mob3.y, mob3.templates.type, false); // TTS
            } else if (Util.nextInt(2000) < 1) {
                im = place.LeaveItem((short) ItemName.CHUYEN_TINH_THACH, mob3.x, mob3.y, mob3.templates.type, false); // TTS
            } else if (Util.nextInt(500) < 1) {
                im = place.LeaveItem((short) ItemName.DA_NANG_CAP_BI_KIP, mob3.x, mob3.y, mob3.templates.type, false); // TTS
            } else if (Util.nextInt(500) < 1) {
                im = place.LeaveItem((short) ItemName.DA_THANG_AN, mob3.x, mob3.y, mob3.templates.type, false); // TTS
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        if (im != null) {
            im.item.quantity = 1;
            im.item.isLock = false;
            im.master = master;
        }
    }

    public static void leaveItemSuKien(TileMap place, Mob mob3, int master) {
        ItemMap im = null;
        int per = Util.nextInt(100);
        try {
            switch (Server.manager.event) {
                case EventName.SU_KIEN_DUA_HAU: {
                    if (per < 3 && (mob3.level > 20)) {
                        im = place.LeaveItem(VatPhamSuKien[Util.nextInt(VatPhamSuKien.length)], mob3.x, mob3.y, mob3.templates.type, false);
                    }
                    break;
                }
                case EventName.HALLOWEEN: {
                    if (per < 20 && (mob3.level > 20)) {
                        im = place.LeaveItem(arrItemSuKienHalloween[Util.nextInt(arrItemSuKienHalloween.length)], mob3.x, mob3.y, mob3.templates.type, false);
                    }
                    break;
                }
                default: {
                    break;
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        if (im != null) {
            im.item.quantity = 1;
            im.item.isLock = false;
            im.master = master;
        }
    }

    public static void LeaveItemMapNgoai(TileMap place, Mob mob3, int master) {
        ItemMap im = null;
        int percent = Util.nextInt(arrItemmapngoai.length);
        try {
            if (arrItemmapngoai[percent] != -1) {
                switch (arrItemmapngoai[percent]) {
                    case 10000: {
                        if (mob3.level < 30) {
                            im = place.LeaveItem((short) 14, mob3.x, mob3.y, mob3.templates.type, false);
                        } else if (mob3.level >= 30 && mob3.level < 50) {
                            im = place.LeaveItem((short) 15, mob3.x, mob3.y, mob3.templates.type, false);
                        } else if (mob3.level >= 50 && mob3.level < 70) {
                            im = place.LeaveItem((short) 16, mob3.x, mob3.y, mob3.templates.type, false);
                        } else if (mob3.level >= 70) {
                            im = place.LeaveItem((short) 17, mob3.x, mob3.y, mob3.templates.type, false);
                        }
                        break;
                    }
                    case 10001: {
                        if (mob3.level < 30) {
                            im = place.LeaveItem((short) 19, mob3.x, mob3.y, mob3.templates.type, false);
                        } else if (mob3.level >= 30 && mob3.level < 50) {
                            im = place.LeaveItem((short) 20, mob3.x, mob3.y, mob3.templates.type, false);
                        } else if (mob3.level >= 50 && mob3.level < 70) {
                            im = place.LeaveItem((short) 21, mob3.x, mob3.y, mob3.templates.type, false);
                        } else if (mob3.level >= 70) {
                            im = place.LeaveItem((short) 22, mob3.x, mob3.y, mob3.templates.type, false);
                        }
                        break;
                    }
                    case 10002: {
                        if (mob3.level < 30) {
                            im = place.LeaveItem((short) 3, mob3.x, mob3.y, mob3.templates.type, false);
                        } else if (mob3.level >= 30 && mob3.level < 50) {
                            im = place.LeaveItem((short) 4, mob3.x, mob3.y, mob3.templates.type, false);
                        } else if (mob3.level >= 50 && mob3.level < 70) {
                            im = place.LeaveItem((short) 5, mob3.x, mob3.y, mob3.templates.type, false);
                        }
                        break;
                    }
                    case 10003: {
                        if (mob3.level >= 30 && mob3.level < 40) {
                            int perCentArr = Util.nextInt(ItemTrangBi3x.length);
                            im = place.LeaveItem(ItemTrangBi3x[perCentArr], mob3.x, mob3.y, mob3.templates.type, false);
                        } else if (mob3.level >= 40 && mob3.level < 50) {
                            int perCentArr = Util.nextInt(ItemTrangBi4x.length);
                            im = place.LeaveItem(ItemTrangBi4x[perCentArr], mob3.x, mob3.y, mob3.templates.type, false);
                        } else if (mob3.level >= 50 && mob3.level < 60) {
                            int perCentArr = Util.nextInt(ItemTrangBi5x.length);
                            im = place.LeaveItem(ItemTrangBi5x[perCentArr], mob3.x, mob3.y, mob3.templates.type, false);
                        } else if (mob3.level >= 60 && mob3.level < 70) {
                            int perCentArr = Util.nextInt(ItemTrangBi6x.length);
                            im = place.LeaveItem(ItemTrangBi6x[perCentArr], mob3.x, mob3.y, mob3.templates.type, false);
                        } else if (mob3.level >= 70 && mob3.level < 80) {
                            int perCentArr = Util.nextInt(ItemTrangBi7x.length);
                            im = place.LeaveItem(ItemTrangBi7x[perCentArr], mob3.x, mob3.y, mob3.templates.type, false);
                        } else if (mob3.level >= 80) {
                            int perCentArr = Util.nextInt(ItemTrangBi8x.length);
                            im = place.LeaveItem(ItemTrangBi8x[perCentArr], mob3.x, mob3.y, mob3.templates.type, false);
                        }
                        break;
                    }
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        if (im != null) {
            im.item.quantity = 1;
            im.item.isLock = false;
            im.master = master;
        }
    }

    public static void leaveYen(TileMap place, Mob mob3, int master) {
        try {
            ItemMap im = place.LeaveItem((short) 12, mob3.x, mob3.y, mob3.templates.type, mob3.isboss);
            if (im != null) {
                im.item.quantity = 1;
                im.item.isLock = false;
                im.master = master;
                im.checkMob = mob3.lvboss;
                if (mob3.isboss) {
                    im.checkMob = 4;
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void leaveChiaKhoa(TileMap place, Mob mob3, int master) {
        try {
            ItemMap im = place.LeaveItem((short) 260, mob3.x, mob3.y, mob3.templates.type, mob3.isboss);
            if (im != null) {
                im.item.quantity = 1;
                im.item.isLock = true;
                im.master = master;
                im.item.isExpires = true;
                im.item.expires = place.map.timeMap;
                im.checkMob = mob3.lvboss;
                if (mob3.isboss) {
                    im.checkMob = 4;
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void leaveLDGT(TileMap place, Mob mob3, int master) { // nhặt đồ ldgt
        ItemMap im = null;
        try {
            if (mob3.templates.id == 81) {
                int per = Util.nextInt(10);
                if (per < 4) {
                    im = place.LeaveItem((short) 261, mob3.x, mob3.y, mob3.templates.type, mob3.isboss);
                    if (im != null) {
                        im.item.quantity = 1;
                        im.item.isLock = true;
                        im.master = master;
                        im.item.isExpires = true;
                        im.item.expires = place.map.timeMap;
                    }
                }
            } else if (mob3.templates.id == 82) {
                int i;
                for (i = 0; i < ItemLDGT.length; i++) {
                    im = place.LeaveItem((short) ItemLDGT[i], mob3.x, mob3.y, mob3.templates.type, true);
                    if (im != null) {
                        im.item.quantity = 1;
                        im.item.isLock = false;
                        im.master = master;
                    }
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}

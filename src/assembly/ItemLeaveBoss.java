/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package assembly;

import Item.ItemName;
import static assembly.ItemLeave.VienNgocRong;
import static assembly.ItemLeave.VuKhi6x;
import static assembly.ItemLeave.VuKhi7x;
import static assembly.ItemLeave.VuKhi8x;
import static assembly.ItemLeave.VuKhi9x;
import io.Util;

/**
 *
 * @author Administrator
 */
public class ItemLeaveBoss {

    public static short[] ItemBOSSThuong = new short[]{
        ItemName.DA_CAP_8, ItemName.DA_CAP_8, ItemName.DA_CAP_8, ItemName.DA_CAP_8, ItemName.DA_CAP_8,
        ItemName.CHUYEN_TINH_THACH,
        ItemName.DA_NANG_CAP_BI_KIP, ItemName.DA_NANG_CAP_BI_KIP, ItemName.DA_NANG_CAP_BI_KIP, ItemName.DA_NANG_CAP_BI_KIP, ItemName.DA_NANG_CAP_BI_KIP,
        ItemName.DA_THANG_AN, ItemName.DA_THANG_AN, ItemName.DA_THANG_AN, ItemName.DA_THANG_AN, ItemName.DA_THANG_AN,
        ItemName.THE_BAI_KINH_NGHIEM_GIA_TOC_SO, ItemName.THE_BAI_KINH_NGHIEM_GIA_TOC_SO, ItemName.THE_BAI_KINH_NGHIEM_GIA_TOC_SO,
        ItemName.THE_BAI_KINH_NGHIEM_GIA_TOC_TRUNG, ItemName.LINH_CHI_VAN_NAM,
        ItemName.THE_BAI_KINH_NGHIEM_GIA_TOC_CAO};

    public static short[] ItemBOSSVDMQ = new short[]{
        ItemName.DA_CAP_8, ItemName.DA_CAP_8, ItemName.DA_CAP_8, ItemName.DA_CAP_8, ItemName.DA_CAP_8,
        ItemName.CHUYEN_TINH_THACH, ItemName.CHUYEN_TINH_THACH,
        ItemName.DA_NANG_CAP_BI_KIP, ItemName.DA_NANG_CAP_BI_KIP, ItemName.DA_NANG_CAP_BI_KIP, ItemName.DA_NANG_CAP_BI_KIP, ItemName.DA_NANG_CAP_BI_KIP, ItemName.DA_NANG_CAP_BI_KIP,
        ItemName.DA_THANG_AN, ItemName.DA_THANG_AN, ItemName.DA_THANG_AN, ItemName.DA_THANG_AN, ItemName.DA_THANG_AN, ItemName.DA_THANG_AN,
        ItemName.THE_BAI_KINH_NGHIEM_GIA_TOC_SO, ItemName.THE_BAI_KINH_NGHIEM_GIA_TOC_SO, ItemName.THE_BAI_KINH_NGHIEM_GIA_TOC_SO,
        ItemName.THE_BAI_KINH_NGHIEM_GIA_TOC_TRUNG, ItemName.LINH_CHI_VAN_NAM,
        ItemName.THE_BAI_KINH_NGHIEM_GIA_TOC_CAO, ItemName.SACH_VO_CONG_KAGE_BUNSHIN};
    public static short[] ItemBOSSLangCo = new short[]{
        ItemName.DA_CAP_8, ItemName.DA_CAP_8, ItemName.DA_CAP_8, ItemName.DA_CAP_8, ItemName.DA_CAP_8,
        ItemName.CHUYEN_TINH_THACH, ItemName.CHUYEN_TINH_THACH,
        ItemName.DA_NANG_CAP_BI_KIP, ItemName.DA_NANG_CAP_BI_KIP, ItemName.DA_NANG_CAP_BI_KIP, ItemName.DA_NANG_CAP_BI_KIP, ItemName.DA_NANG_CAP_BI_KIP, ItemName.DA_NANG_CAP_BI_KIP,
        ItemName.DA_THANG_AN, ItemName.DA_THANG_AN, ItemName.DA_THANG_AN, ItemName.DA_THANG_AN, ItemName.DA_THANG_AN, ItemName.DA_THANG_AN,
        ItemName.THE_BAI_KINH_NGHIEM_GIA_TOC_SO, ItemName.THE_BAI_KINH_NGHIEM_GIA_TOC_SO, ItemName.THE_BAI_KINH_NGHIEM_GIA_TOC_SO,
        ItemName.THE_BAI_KINH_NGHIEM_GIA_TOC_TRUNG, ItemName.LINH_CHI_VAN_NAM,
        ItemName.THE_BAI_KINH_NGHIEM_GIA_TOC_CAO, ItemName.SACH_VO_CONG_KAGE_BUNSHIN};

    public static void ItemBossTheGioi(TileMap place, Mob mob3, int master) {
        ItemMap im = null;
        int random = Util.nextInt(50);
        int i;
        try {
            if (random < 3) {
                for (i = 0; i < VuKhi6x.length; i++) {
                    im = place.LeaveItem((short) VuKhi6x[i], mob3.x, mob3.y, mob3.templates.type, true);
                    if (im != null) {
                        im.item.quantity = 1;
                        im.item.isLock = false;
                        im.item.upgradeNext((byte) Util.nextInt(8, 12));
                        im.master = master;
                    }
                }
            } else if (random < 2) {
                for (i = 0; i < VuKhi7x.length; i++) {
                    im = place.LeaveItem((short) VuKhi7x[i], mob3.x, mob3.y, mob3.templates.type, true);
                    if (im != null) {
                        im.item.quantity = 1;
                        im.item.isLock = false;
                        im.item.upgradeNext((byte) Util.nextInt(8, 12));
                        im.master = master;
                    }
                }
            } else if (random < 1) {
                for (i = 0; i < VuKhi8x.length; i++) {
                    im = place.LeaveItem((short) VuKhi8x[i], mob3.x, mob3.y, mob3.templates.type, true);
                    if (im != null) {
                        im.item.quantity = 1;
                        im.item.isLock = false;
                        im.item.upgradeNext((byte) Util.nextInt(8, 12));
                        im.master = master;
                    }
                }
            }
            for (i = 0; i < ItemBOSSVDMQ.length; i++) {
                im = place.LeaveItem(ItemBOSSVDMQ[i], mob3.x, mob3.y, mob3.templates.type, true);
                if (im != null) {
                    im.item.quantity = 1;
                    im.item.isLock = false;
                    im.master = master;
                }
            }

        } catch (Exception e) {
        }
    }

    public static void ItemBossSuKien(TileMap place, Mob mob3, int master) {
        ItemMap im = null;
        int i;
        int random = Util.nextInt(50);
        try {
            if (random < 20) {
                for (i = 0; i < VuKhi9x.length; i++) {
                    im = place.LeaveItem(VuKhi9x[i], mob3.x, mob3.y, mob3.templates.type, true);
                    if (im != null) {
                        im.item.quantity = 1;
                        im.item.isLock = false;
                        im.master = master;
                    }
                }
            }
        } catch (Exception e) {
        }
    }

    public static void ItemBossLangCo(TileMap place, Mob mob3, int master) {
        ItemMap im = null;
        int i;
        int random = Util.nextInt(50);
        try {
            if (random < 4) {
                im = place.LeaveItem((short) VuKhi6x[Util.nextInt(VuKhi6x.length)], mob3.x, mob3.y, mob3.templates.type, false);
                if (im != null) {
                    im.item.quantity = 1;
                    im.item.isLock = false;
                    im.item.upgradeNext((byte) Util.nextInt(1, 10));
                    im.master = master;
                }
            } else if (random < 3) {
                im = place.LeaveItem((short) VuKhi7x[Util.nextInt(VuKhi7x.length)], mob3.x, mob3.y, mob3.templates.type, false);
                if (im != null) {
                    im.item.quantity = 1;
                    im.item.isLock = false;
                    im.item.upgradeNext((byte) Util.nextInt(1, 10));
                    im.master = master;
                }
            } else if (random < 2) {
                im = place.LeaveItem((short) VuKhi8x[Util.nextInt(VuKhi8x.length)], mob3.x, mob3.y, mob3.templates.type, false);
                if (im != null) {
                    im.item.quantity = 1;
                    im.item.isLock = false;
                    im.item.upgradeNext((byte) Util.nextInt(1, 10));
                    im.master = master;
                }
            } else if (random < 1) {
                im = place.LeaveItem((short) VuKhi9x[Util.nextInt(VuKhi9x.length)], mob3.x, mob3.y, mob3.templates.type, false);
                if (im != null) {
                    im.item.quantity = 1;
                    im.item.isLock = false;
                    im.item.upgradeNext((byte) Util.nextInt(1, 10));
                    im.master = master;
                }
            } else if (random < 5) {
                im = place.LeaveItem((short) VienNgocRong[Util.nextInt(VienNgocRong.length)], mob3.x, mob3.y, mob3.templates.type, false);
                if (im != null) {
                    im.item.quantity = 1;
                    im.item.isLock = false;
                    im.master = master;
                }
            }
            // Item Mặc Định
            for (i = 0; i < ItemBOSSLangCo.length; i++) {
                im = place.LeaveItem(ItemBOSSLangCo[i], mob3.x, mob3.y, mob3.templates.type, true);
                if (im != null) {
                    im.item.quantity = 1;
                    im.item.isLock = false;
                    im.master = master;
                }
            }

        } catch (Exception e) {
        }
    }

    public static void ItemBossVDMQ(TileMap place, Mob mob3, int master) {
        ItemMap im = null;
        int i;
        int random = Util.nextInt(50);
        try {
            if (random < 4) {
                im = place.LeaveItem((short) VuKhi6x[Util.nextInt(VuKhi6x.length)], mob3.x, mob3.y, mob3.templates.type, false);
                if (im != null) {
                    im.item.quantity = 1;
                    im.item.isLock = false;
                    im.item.upgradeNext((byte) Util.nextInt(1, 10));
                    im.master = master;
                }
            } else if (random < 3) {
                im = place.LeaveItem((short) VuKhi7x[Util.nextInt(VuKhi7x.length)], mob3.x, mob3.y, mob3.templates.type, false);
                if (im != null) {
                    im.item.quantity = 1;
                    im.item.isLock = false;
                    im.item.upgradeNext((byte) Util.nextInt(1, 10));
                    im.master = master;
                }
            } else if (random < 2) {
                im = place.LeaveItem((short) VuKhi8x[Util.nextInt(VuKhi8x.length)], mob3.x, mob3.y, mob3.templates.type, false);
                if (im != null) {
                    im.item.quantity = 1;
                    im.item.isLock = false;
                    im.item.upgradeNext((byte) Util.nextInt(1, 10));
                    im.master = master;
                }
            } else if (random < 1) {
                im = place.LeaveItem((short) VuKhi9x[Util.nextInt(VuKhi9x.length)], mob3.x, mob3.y, mob3.templates.type, false);
                if (im != null) {
                    im.item.quantity = 1;
                    im.item.isLock = false;
                    im.item.upgradeNext((byte) Util.nextInt(1, 10));
                    im.master = master;
                }
            } else if (random < 5) {
                im = place.LeaveItem((short) VienNgocRong[Util.nextInt(VienNgocRong.length)], mob3.x, mob3.y, mob3.templates.type, false);
                if (im != null) {
                    im.item.quantity = 1;
                    im.item.isLock = false;
                    im.master = master;
                }
            }
            // Item Mặc Định
            for (i = 0; i < ItemBOSSVDMQ.length; i++) {
                im = place.LeaveItem(ItemBOSSVDMQ[i], mob3.x, mob3.y, mob3.templates.type, true);
                if (im != null) {
                    im.item.quantity = 1;
                    im.item.isLock = false;
                    im.master = master;
                }
            }

        } catch (Exception e) {
        }
    }

    public static void ItemBossThuong(TileMap place, Mob mob3, int master) {
        ItemMap im = null;
        int random = Util.nextInt(100);
        int i;
        try {
            if (random < 3) {
                im = place.LeaveItem((short) VuKhi6x[Util.nextInt(VuKhi6x.length)], mob3.x, mob3.y, mob3.templates.type, false);
                if (im != null) {
                    im.item.quantity = 1;
                    im.item.isLock = false;
                    im.item.upgradeNext((byte) Util.nextInt(1, 10));
                    im.master = master;
                }
            } else if (random < 2) {
                im = place.LeaveItem((short) VuKhi7x[Util.nextInt(VuKhi7x.length)], mob3.x, mob3.y, mob3.templates.type, false);
                if (im != null) {
                    im.item.quantity = 1;
                    im.item.isLock = false;
                    im.item.upgradeNext((byte) Util.nextInt(1, 10));
                    im.master = master;
                }
            } else if (random < 1) {
                im = place.LeaveItem((short) VuKhi8x[Util.nextInt(VuKhi8x.length)], mob3.x, mob3.y, mob3.templates.type, false);
                if (im != null) {
                    im.item.quantity = 1;
                    im.item.isLock = false;
                    im.item.upgradeNext((byte) Util.nextInt(1, 10));
                    im.master = master;
                }
            } else if (random < 4) {
                im = place.LeaveItem((short) VienNgocRong[Util.nextInt(VienNgocRong.length)], mob3.x, mob3.y, mob3.templates.type, false);
                if (im != null) {
                    im.item.quantity = 1;
                    im.item.isLock = false;
                    im.item.upgradeNext((byte) Util.nextInt(1, 10));
                    im.master = master;
                }
            }

            for (i = 0; i < ItemBOSSThuong.length; i++) {
                im = place.LeaveItem(ItemBOSSThuong[i], mob3.x, mob3.y, mob3.templates.type, true);
                if (im != null) {
                    im.item.quantity = 1;
                    im.item.isLock = false;
                    im.master = master;
                }

            }
        } catch (Exception e) {
        }
    }
}

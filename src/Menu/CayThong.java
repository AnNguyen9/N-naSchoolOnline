/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Menu;

import History.LichSu;
import Item.ItemName;
import Item.RandomItem;
import assembly.Item;
import assembly.Language;
import assembly.Option;
import assembly.Player;
import static assembly.UseItem.HanSuDung;
import io.Util;
import server.Manager;
import server.Service;
import template.ItemTemplate;

/**
 *
 * @author Administrator
 */
public class CayThong {

    public static void npcCayThong(Player p, byte npcid, byte menuId, byte b3) {
        switch (menuId) {
            case 0: {
                if (p.c.isNhanban) {
                    p.conn.sendMessageLog(Language.NOT_FOR_PHAN_THAN);
                    return;
                }
                if (p.c.quantityItemyTotal(673) < 1) {
                    p.conn.sendMessageLog("Bạn Không Đủ Quà Trang Trí.");
                    return;
                }
                if (p.c.getBagNull() < 1) {
                    p.conn.sendMessageLog("Hành Trang Không Đủ Chổ Trống");
                    return;
                }
                p.c.removeItemBags(673, 1);
                p.updateExp(5000000);
                p.c.eventPoint += 1;
                if (Util.nextInt(10) < 5) {
                    p.updateExp(Util.nextInt(5000000, 10000000));
                    Service.chatNPC(p, (short) npcid, "Trang trí nhận được Kinh Nghiệm");
                } else if (Util.percent(20, 1)) {
                    p.c.addItemBag(true, ItemTemplate.itemDefault(ItemName.RUONG_NGOC, false));
                    Service.chatNPC(p, (short) npcid, "Trang trí nhận được " + ItemTemplate.ItemTemplateId(ItemName.RUONG_NGOC).name);
                } else if (Util.nextInt(30000) < 1) {
                    p.c.addItemBag(true, ItemTemplate.itemDefault(383, false));
                    LichSu.LichSuMoItemVinhVien(p.c.name, ItemTemplate.ItemTemplateId(383).name);
                    Manager.chatKTG(p.c.name + " Trang Trí Cây Thông nhận được " + ItemTemplate.ItemTemplateId(383).name);
                } else if (Util.nextInt(40000) < 1) {
                    p.c.addItemBag(true, ItemTemplate.itemDefault(384, false));
                    LichSu.LichSuMoItemVinhVien(p.c.name, ItemTemplate.ItemTemplateId(384).name);
                    Manager.chatKTG(p.c.name + " Trang Trí Cây Thông nhận được " + ItemTemplate.ItemTemplateId(384).name);
                } else if (Util.nextInt(50000) < 1) {
                    p.c.addItemBag(true, ItemTemplate.itemDefault(385, false));
                    LichSu.LichSuMoItemVinhVien(p.c.name, ItemTemplate.ItemTemplateId(385).name);
                    Manager.chatKTG(p.c.name + " Trang Trí Cây Thông nhận được " + ItemTemplate.ItemTemplateId(385).name);
                } else if (Util.nextInt(500) < 3) {
                    p.c.addItemBag(true, ItemTemplate.itemDefault(ItemName.XICH_NHAN_NGAN_LANG, false));
                    Service.chatNPC(p, (short) npcid, "Trang trí nhận được " + ItemTemplate.ItemTemplateId(ItemName.XICH_NHAN_NGAN_LANG).name);
                } else if (Util.nextInt(500) < 2) {
                    p.c.addItemBag(true, ItemTemplate.itemDefault(ItemName.HARLEY_DAVIDSON, false));
                    Service.chatNPC(p, (short) npcid, "Trang trí nhận được " + ItemTemplate.ItemTemplateId(ItemName.HARLEY_DAVIDSON).name);
                } else if (Util.nextInt(500) < 1) {
                    p.c.addItemBag(true, ItemTemplate.itemDefault(ItemName.XE_MAY, false));
                    Service.chatNPC(p, (short) npcid, "Trang trí nhận được " + ItemTemplate.ItemTemplateId(ItemName.XE_MAY).name);
                } else if (Util.nextInt(10000) < 1) {
                    Item itemup = ItemTemplate.itemDefault(ItemName.THAI_DUONG_VO_CUC_KIEM);
                    itemup.sys = 1;
                    p.c.addItemBag(true, itemup);
                    Service.chatNPC(p, (short) npcid, "Trang trí nhận được " + ItemTemplate.ItemTemplateId(ItemName.THAI_DUONG_VO_CUC_KIEM).name);
                } else if (Util.nextInt(10000) < 2) {
                    Item itemup = ItemTemplate.itemDefault(ItemName.THAI_DUONG_THIEN_HOA_TIEU);
                    itemup.sys = 1;
                    p.c.addItemBag(true, itemup);
                    Service.chatNPC(p, (short) npcid, "Trang trí nhận được " + ItemTemplate.ItemTemplateId(ItemName.THAI_DUONG_THIEN_HOA_TIEU).name);
                } else if (Util.nextInt(10000) < 3) {
                    Item itemup = ItemTemplate.itemDefault(ItemName.THAI_DUONG_TANG_HON_DAO);
                    itemup.sys = 2;
                    p.c.addItemBag(true, itemup);
                    Service.chatNPC(p, (short) npcid, "Trang trí nhận được " + ItemTemplate.ItemTemplateId(ItemName.THAI_DUONG_TANG_HON_DAO).name);
                } else if (Util.nextInt(10000) < 4) {
                    Item itemup = ItemTemplate.itemDefault(ItemName.THAI_DUONG_BANG_THAN_CUNG);
                    itemup.sys = 2;
                    p.c.addItemBag(true, itemup);
                    Service.chatNPC(p, (short) npcid, "Trang trí nhận được " + ItemTemplate.ItemTemplateId(ItemName.THAI_DUONG_BANG_THAN_CUNG).name);
                } else if (Util.nextInt(10000) < 5) {
                    Item itemup = ItemTemplate.itemDefault(ItemName.THAI_DUONG_CHIEN_LUC_DAO);
                    itemup.sys = 3;
                    p.c.addItemBag(true, itemup);
                    Service.chatNPC(p, (short) npcid, "Trang trí nhận được " + ItemTemplate.ItemTemplateId(ItemName.THAI_DUONG_CHIEN_LUC_DAO).name);
                } else if (Util.nextInt(10000) < 6) {
                    Item itemup = ItemTemplate.itemDefault(ItemName.THAI_DUONG_HOANG_PHONG_PHIEN);
                    itemup.sys = 3;
                    p.c.addItemBag(true, itemup);
                    Service.chatNPC(p, (short) npcid, "Trang trí nhận được " + ItemTemplate.ItemTemplateId(ItemName.THAI_DUONG_HOANG_PHONG_PHIEN).name);
                } else {
                    int itemID = RandomItem.ITEM_DOCOGIATRI.next();
                    Item itm = ItemTemplate.itemDefault(itemID);
                    if (itemID == ItemName.MAT_NA_HO || itemID == ItemName.MAT_NA_HO_1) {
                        if (Util.percent(120, 1)) {
                            itm.options.add(new Option(58, 10));
                            itm.options.add(new Option(6, 3000));
                            itm.options.add(new Option(7, 3000));
                            itm.options.add(new Option(94, 10));
                            itm.options.add(new Option(47, 50));
                            itm.options.add(new Option(127, 10));
                            itm.options.add(new Option(128, 10));
                            itm.options.add(new Option(129, 10));
                            Manager.chatKTG(p.c.name + " Trang Trí Cây Thông nhận được " + ItemTemplate.ItemTemplateId(itemID).name + " Vĩnh Viễn");
                            LichSu.LichSuMoItemVinhVien(p.c.name, ItemTemplate.ItemTemplateId(itemID).name);
                        } else {
                            int HSD = HanSuDung[Util.nextInt(HanSuDung.length)];
                            itm.isExpires = true;
                            itm.expires = Util.TimeDay(HSD);
                            itm.options.add(new Option(58, Util.nextInt(5, 10)));
                            itm.options.add(new Option(6, Util.nextInt(2000, 3000)));
                            itm.options.add(new Option(7, Util.nextInt(2000, 3000)));
                            itm.options.add(new Option(94, Util.nextInt(5, 10)));
                            itm.options.add(new Option(47, Util.nextInt(25, 50)));
                            itm.options.add(new Option(127, Util.nextInt(5, 10)));
                            itm.options.add(new Option(128, Util.nextInt(5, 10)));
                            itm.options.add(new Option(129, Util.nextInt(5, 10)));
                        }
                    }
                    if (itemID == ItemName.TUAN_LOC) {
                        if (Util.percent(120, 1)) {
                            itm.options.add(new Option(87, 5000));
                            itm.options.add(new Option(6, 5000));
                            itm.options.add(new Option(7, 5000));
                            itm.options.add(new Option(92, 10));
                            itm.options.add(new Option(127, 5));
                            itm.options.add(new Option(128, 5));
                            itm.options.add(new Option(129, 5));
                            Manager.chatKTG(p.c.name + " Trang Trí Cây Thông nhận được " + ItemTemplate.ItemTemplateId(itemID).name + " Vĩnh Viễn");
                            LichSu.LichSuMoItemVinhVien(p.c.name, ItemTemplate.ItemTemplateId(itemID).name);
                        } else {
                            int HSD = HanSuDung[Util.nextInt(HanSuDung.length)];
                            itm.isExpires = true;
                            itm.expires = Util.TimeDay(HSD);
                            itm.options.add(new Option(87, 5000));
                            itm.options.add(new Option(6, 5000));
                            itm.options.add(new Option(7, 5000));
                            itm.options.add(new Option(92, 10));
                            itm.options.add(new Option(127, 5));
                            itm.options.add(new Option(128, 5));
                            itm.options.add(new Option(129, 5));
                        }
                    }
                    if (itemID == ItemName.HAKAIRO_YOROI) {
                        if (Util.percent(120, 1)) {
                            LichSu.LichSuMoItemVinhVien(p.c.name, ItemTemplate.ItemTemplateId(itemID).name);
                            Manager.chatKTG(p.c.name + " Trang Trí Cây Thông nhận được " + ItemTemplate.ItemTemplateId(itemID).name + " Vĩnh Viễn");
                        } else {
                            int HSD = HanSuDung[Util.nextInt(HanSuDung.length)];
                            itm.isExpires = true;
                            itm.expires = Util.TimeDay(HSD);
                        }
                    }
                    if (itemID == ItemName.MAT_NA_SHIN_AH || itemID == ItemName.MAT_NA_VO_DIEN || itemID == ItemName.MAT_NA_ONI || itemID == ItemName.MAT_NA_KUMA || itemID == ItemName.MAT_NA_INU) {
                        if (Util.percent(100, 1)) {
                            LichSu.LichSuMoItemVinhVien(p.c.name, ItemTemplate.ItemTemplateId(itemID).name);
                            Manager.chatKTG(p.c.name + " Trang Trí Cây Thông nhận được " + ItemTemplate.ItemTemplateId(itemID).name + " Vĩnh Viễn");
                        } else {
                            int HSD = HanSuDung[Util.nextInt(HanSuDung.length)];
                            itm.isExpires = true;
                            itm.expires = Util.TimeDay(HSD);
                        }
                    }
                    if (itemID == ItemName.BACH_HO) {
                        if (Util.percent(120, 1)) {
                            LichSu.LichSuMoItemVinhVien(p.c.name, ItemTemplate.ItemTemplateId(itemID).name);
                            Manager.chatKTG(p.c.name + " Trang Trí Cây Thông nhận được " + ItemTemplate.ItemTemplateId(itemID).name + " Vĩnh Viễn");
                        } else {
                            int HSD = HanSuDung[Util.nextInt(HanSuDung.length)];
                            itm.isExpires = true;
                            itm.expires = Util.TimeDay(HSD);
                        }
                    }
                    Service.chatNPC(p, (short) npcid, "Trang trí nhận được " + ItemTemplate.ItemTemplateId(itemID).name);
                    p.c.addItemBag(true, itm);
                    break;
                }
            }
        }
    }
}

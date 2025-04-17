/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Event;

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
import stream.Server;
import template.ItemTemplate;

/**
 *
 * @author Administrator
 */
public class ItemHandleEvent {

    public static void hopbanhthuong (Player p, Item item, byte index) {
        ItemTemplate data = ItemTemplate.ItemTemplateId(item.id);
        if (p.c.getBagNull() == 0) {
            p.conn.sendMessageLog("Hành trang không đủ chỗ trống.");
            return;
        }
        p.c.eventPoint += 1;
        p.c.removeItemBag(index, 1);
        p.updateExp(10000000);
        if (Util.percent(50, 1)) {
            p.c.addItemBag(true, ItemTemplate.itemDefault(ItemName.RUONG_NGOC, false));
        } else if (Util.nextInt(30000) < 1) {
            p.c.addItemBag(true, ItemTemplate.itemDefault(383, false));
            Manager.chatKTG(p.c.name + " sử dụng " + data.name + " đã nhận được " + ItemTemplate.ItemTemplateId(383).name);
        } else if (Util.nextInt(40000) < 1) {
            p.c.addItemBag(true, ItemTemplate.itemDefault(384, false));
            Manager.chatKTG(p.c.name + " sử dụng " + data.name + " đã nhận được " + ItemTemplate.ItemTemplateId(384).name);
        } else if (Util.nextInt(50000) < 1) {
            p.c.addItemBag(true, ItemTemplate.itemDefault(385, false));
            Manager.chatKTG(p.c.name + " sử dụng " + data.name + " đã nhận được " + ItemTemplate.ItemTemplateId(385).name);
        } else if (Util.nextInt(10000) < 1) {
            Item itemup = ItemTemplate.itemDefault(ItemName.HAC_NGUU);
            itemup.options.add(new Option(58, Util.nextInt(2, 5)));
            itemup.options.add(new Option(94, Util.nextInt(2, 5)));
            itemup.options.add(new Option(57, Util.nextInt(2, 5)));
            p.c.addItemBag(true, itemup);
        } else if (Util.nextInt(6000) < 1) {
            p.c.addItemBag(true, ItemTemplate.itemDefault(ItemName.XICH_NHAN_NGAN_LANG, false));
        } else if (Util.nextInt(7000) < 1) {
            p.c.addItemBag(true, ItemTemplate.itemDefault(ItemName.HARLEY_DAVIDSON, false));
        } else if (Util.nextInt(5000) < 1) {
            p.c.addItemBag(true, ItemTemplate.itemDefault(ItemName.XE_MAY, false));
        } else {
            p.c.upyenMessage(Util.nextInt(1000, 20000));
        }
        int itemID = RandomItem.ITEM_DOKHONGGIATRI.next();
        Item itm = ItemTemplate.itemDefault(itemID);
        p.c.addItemBag(true, itm);
    }

    public static void hopbanhthuonghang (Player p, Item item, byte index) {
        ItemTemplate data = ItemTemplate.ItemTemplateId(item.id);
        if (p.c.getBagNull() == 0) {
            p.conn.sendMessageLog("Hành trang không đủ chỗ trống.");
            return;
        }
        p.c.eventPoint += 2;
        p.c.removeItemBag(index, 1);
        p.updateExp(100000000);
        if (Util.percent(20, 1)) {
            p.c.addItemBag(true, ItemTemplate.itemDefault(ItemName.RUONG_NGOC, false));
        } else if (Util.nextInt(10000) < 1) {
            p.c.addItemBag(true, ItemTemplate.itemDefault(383, false));
            LichSu.LichSuMoItemVinhVien(p.c.name, ItemTemplate.ItemTemplateId(383).name);
            Manager.chatKTG(p.c.name + " Sử Dụng " + data.name + " nhận được " + ItemTemplate.ItemTemplateId(383).name);
        } else if (Util.nextInt(20000) < 1) {
            p.c.addItemBag(true, ItemTemplate.itemDefault(384, false));
            LichSu.LichSuMoItemVinhVien(p.c.name, ItemTemplate.ItemTemplateId(384).name);
            Manager.chatKTG(p.c.name + " Sử Dụng " + data.name + " nhận được " + ItemTemplate.ItemTemplateId(384).name);
        } else if (Util.nextInt(30000) < 1) {
            p.c.addItemBag(true, ItemTemplate.itemDefault(385, false));
            LichSu.LichSuMoItemVinhVien(p.c.name, ItemTemplate.ItemTemplateId(385).name);
            Manager.chatKTG(p.c.name + " Sử Dụng " + data.name + " nhận được " + ItemTemplate.ItemTemplateId(385).name);
        } else if (Util.nextInt(2000) < 1) {
            p.c.addItemBag(true, ItemTemplate.itemDefault(308, false));
            LichSu.LichSuMoItemVinhVien(p.c.name, ItemTemplate.ItemTemplateId(308).name);
            Manager.chatKTG(p.c.name + " Sử Dụng " + data.name + " nhận được " + ItemTemplate.ItemTemplateId(308).name);
        } else if (Util.nextInt(5000) < 1) {
            p.c.addItemBag(true, ItemTemplate.itemDefault(309, false));
            LichSu.LichSuMoItemVinhVien(p.c.name, ItemTemplate.ItemTemplateId(309).name);
            Manager.chatKTG(p.c.name + " Sử Dụng " + data.name + " nhận được " + ItemTemplate.ItemTemplateId(309).name);
        } else if (Util.nextInt(600) < 1) {
            Item itemup = ItemTemplate.itemDefault(ItemName.XICH_NHAN_NGAN_LANG);
            itemup.options.add(new Option(58, Util.nextInt(2, 10)));
            itemup.options.add(new Option(94, Util.nextInt(2, 20)));
            p.c.addItemBag(true, itemup);
        } else if (Util.nextInt(1500) < 1) {
            Item itemup = ItemTemplate.itemDefault(ItemName.HAC_NGUU);
            itemup.options.add(new Option(58, Util.nextInt(2, 10)));
            itemup.options.add(new Option(94, Util.nextInt(2, 10)));
            itemup.options.add(new Option(57, Util.nextInt(2, 10)));
            p.c.addItemBag(true, itemup);
        } else if (Util.nextInt(700) < 1) {
            Item itemup = ItemTemplate.itemDefault(ItemName.HARLEY_DAVIDSON);
            itemup.options.add(new Option(58, Util.nextInt(3, 10)));
            itemup.options.add(new Option(94, Util.nextInt(3, 20)));
            p.c.addItemBag(true, itemup);
        } else if (Util.nextInt(500) < 1) {
            Item itemup = ItemTemplate.itemDefault(ItemName.XE_MAY);
            itemup.options.add(new Option(58, Util.nextInt(1, 10)));
            itemup.options.add(new Option(94, Util.nextInt(1, 20)));
        } else {
            int itemID = RandomItem.ITEM_DOCOGIATRI.next();
            Item itm = ItemTemplate.itemDefault(itemID);
            if (itemID == ItemName.PET_BONG_MA || itemID == ItemName.PET_YEU_TINH) {
                if (Util.percent(150, 1)) {
                    itm.options.add(new Option(87, Util.nextInt(3000, 5000)));
                    itm.options.add(new Option(100, Util.nextInt(10, 20)));
                    itm.options.add(new Option(67, Util.nextInt(10, 50)));
                    itm.options.add(new Option(84, Util.nextInt(10, 100)));
                    itm.options.add(new Option(92, Util.nextInt(10, 100)));
                    itm.options.add(new Option(80, Util.nextInt(50, 200)));
                    itm.options.add(new Option(94, Util.nextInt(10, 100)));
                    itm.options.add(new Option(57, Util.nextInt(10, 100)));
                    LichSu.LichSuMoItemVinhVien(p.c.name, ItemTemplate.ItemTemplateId(itemID).name);
                    Manager.chatKTG(p.c.name + " Sử Dụng " + data.name + " nhận được " + ItemTemplate.ItemTemplateId(itemID).name + " Vĩnh Viễn");
                } else {
                    int HSD = HanSuDung[Util.nextInt(HanSuDung.length)];
                    itm.isExpires = true;
                    itm.expires = Util.TimeDay(HSD);
                    itm.options.add(new Option(87, Util.nextInt(3000, 5000)));
                    itm.options.add(new Option(100, Util.nextInt(10, 20)));
                    itm.options.add(new Option(67, Util.nextInt(10, 50)));
                    itm.options.add(new Option(84, Util.nextInt(10, 100)));
                    itm.options.add(new Option(92, Util.nextInt(10, 100)));
                    itm.options.add(new Option(80, Util.nextInt(50, 200)));
                    itm.options.add(new Option(94, Util.nextInt(10, 100)));
                    itm.options.add(new Option(57, Util.nextInt(10, 100)));
                }
            }
            if (itemID == ItemName.GAY_MAT_TRANG || itemID == ItemName.GAY_TRAI_TIM) {
                if (Util.percent(150, 1)) {
                    itm.options.add(new Option(58, Util.nextInt(1, 10)));
                    itm.options.add(new Option(87, Util.nextInt(1000, 5000)));
                    itm.options.add(new Option(98, Util.nextInt(1, 10)));
                    itm.options.add(new Option(102, Util.nextInt(1000, 5000)));
                    itm.options.add(new Option(8, Util.nextInt(100, 150)));
                    itm.options.add(new Option(9, Util.nextInt(10, 100)));
                    itm.options.add(new Option(8, Util.nextInt(10, 100)));
                    itm.options.add(new Option(94, Util.nextInt(10, 100)));
                    itm.options.add(new Option(57, Util.nextInt(10, 100)));
                    Manager.chatKTG(p.c.name + " Sử Dụng " + data.name + " nhận được " + ItemTemplate.ItemTemplateId(itemID).name + " Vĩnh Viễn");
                    LichSu.LichSuMoItemVinhVien(p.c.name, ItemTemplate.ItemTemplateId(itemID).name);
                } else {
                    int HSD = HanSuDung[Util.nextInt(HanSuDung.length)];
                    itm.isExpires = true;
                    itm.expires = Util.TimeDay(HSD);
                    itm.options.add(new Option(58, Util.nextInt(1, 10)));
                    itm.options.add(new Option(87, Util.nextInt(1000, 5000)));
                    itm.options.add(new Option(98, Util.nextInt(1, 10)));
                    itm.options.add(new Option(102, Util.nextInt(1000, 5000)));
                    itm.options.add(new Option(8, Util.nextInt(100, 150)));
                    itm.options.add(new Option(9, Util.nextInt(10, 100)));
                    itm.options.add(new Option(8, Util.nextInt(10, 100)));
                    itm.options.add(new Option(94, Util.nextInt(10, 100)));
                    itm.options.add(new Option(57, Util.nextInt(10, 100)));
                }
            }
            if (itemID == ItemName.MAT_NA_HO || itemID == ItemName.MAT_NA_HO_1) {
                if (Util.percent(150, 1)) {
                    itm.options.add(new Option(58, Util.nextInt(5, 10)));
                    itm.options.add(new Option(6, Util.nextInt(2000, 5000)));
                    itm.options.add(new Option(7, Util.nextInt(2000, 5000)));
                    itm.options.add(new Option(94, Util.nextInt(5, 10)));
                    itm.options.add(new Option(47, Util.nextInt(25, 50)));
                    itm.options.add(new Option(127, Util.nextInt(5, 10)));
                    itm.options.add(new Option(128, Util.nextInt(5, 10)));
                    itm.options.add(new Option(129, Util.nextInt(5, 10)));
                    Manager.chatKTG(p.c.name + " Sử Dụng " + data.name + " nhận được " + ItemTemplate.ItemTemplateId(itemID).name + " Vĩnh Viễn");
                    LichSu.LichSuMoItemVinhVien(p.c.name, ItemTemplate.ItemTemplateId(itemID).name);
                } else {
                    int HSD = HanSuDung[Util.nextInt(HanSuDung.length)];
                    itm.isExpires = true;
                    itm.expires = Util.TimeDay(HSD);
                    itm.options.add(new Option(58, Util.nextInt(5, 10)));
                    itm.options.add(new Option(6, Util.nextInt(2000, 5000)));
                    itm.options.add(new Option(7, Util.nextInt(2000, 5000)));
                    itm.options.add(new Option(94, Util.nextInt(5, 10)));
                    itm.options.add(new Option(47, Util.nextInt(25, 50)));
                    itm.options.add(new Option(127, Util.nextInt(5, 10)));
                    itm.options.add(new Option(128, Util.nextInt(5, 10)));
                    itm.options.add(new Option(129, Util.nextInt(5, 10)));
                }
            }
            if (itemID == ItemName.NHAT_TU_LAM_PHONG || itemID == ItemName.THIEN_NGUYET_CHI_NU) {
                if (Util.percent(150, 1)) {
                    itm.options.add(new Option(82, 5000));
                    itm.options.add(new Option(94, 100));
                    itm.options.add(new Option(80, 200));
                    itm.options.add(new Option(92, 100));
                    itm.options.add(new Option(58, 10));
                    itm.options.add(new Option(127, 10));
                    itm.options.add(new Option(128, 10));
                    itm.options.add(new Option(129, 10));
                    LichSu.LichSuMoItemVinhVien(p.c.name, ItemTemplate.ItemTemplateId(itemID).name);
                } else {
                    int HSD = HanSuDung[Util.nextInt(HanSuDung.length)];
                    itm.isExpires = true;
                    itm.expires = Util.TimeDay(HSD);
                    itm.options.add(new Option(82, Util.nextInt(3000, 5000)));
                    itm.options.add(new Option(94, Util.nextInt(50, 100)));
                    itm.options.add(new Option(80, Util.nextInt(100, 200)));
                    itm.options.add(new Option(92, Util.nextInt(50, 100)));
                    itm.options.add(new Option(58, Util.nextInt(5, 10)));
                    itm.options.add(new Option(127, Util.nextInt(5, 10)));
                    itm.options.add(new Option(128, Util.nextInt(5, 10)));
                    itm.options.add(new Option(129, Util.nextInt(5, 10)));
                }
            }
            if (itemID == ItemName.HAKAIRO_YOROI) {
                if (Util.percent(500, 1)) {
                    LichSu.LichSuMoItemVinhVien(p.c.name, ItemTemplate.ItemTemplateId(itemID).name);
                    Manager.chatKTG(p.c.name + " Sử Dụng " + data.name + " nhận được " + ItemTemplate.ItemTemplateId(itemID).name + " Vĩnh Viễn");
                } else {
                    int HSD = HanSuDung[Util.nextInt(HanSuDung.length)];
                    itm.isExpires = true;
                    itm.expires = Util.TimeDay(HSD);
                }
            }
            p.c.addItemBag(true, itm);
        }
    }
    
    public static void KeoTao(Player p, Item item, byte index) {
        ItemTemplate data = ItemTemplate.ItemTemplateId(item.id);
        if (Server.manager.event != EventName.HALLOWEEN) {
            p.sendAddchatYellow(Language.END_EVENT);
            return;
        }
        if (p.c.getBagNull() == 0) {
            p.conn.sendMessageLog("Hành trang không đủ chỗ trống.");
            return;
        }
        p.c.removeItemBag(index, 1);
        p.updateExp(10000000);
        if (Util.nextInt(10) < 5) {
            p.updateExp(Util.nextInt(15000000, 20000000));
        } else if (Util.percent(30, 1)) {
            p.c.addItemBag(true, ItemTemplate.itemDefault(ItemName.RUONG_NGOC, false));
        }  else if (Util.percent(1000, 1)) {
            p.c.addItemBag(true, ItemTemplate.itemDefault(ItemName.BANH_TRUNG_THU_BANG_HOA, false));
        } else if (Util.percent(1001, 1)) {
            p.c.addItemBag(true, ItemTemplate.itemDefault(ItemName.BANH_TRUNG_THU_PHONG_LOI, false));
        }
        else if (Util.percent(1002, 1)) {
            p.c.addItemBag(true, ItemTemplate.itemDefault(ItemName.BACH_HO, false));
        }
        else if (Util.percent(1003, 1)) {
            p.c.addItemBag(true, ItemTemplate.itemDefault(ItemName.LAN_SU_VU, false));
        }
        int itemID = RandomItem.KEO_TAO.next();
        Item itm = ItemTemplate.itemDefault(itemID);
        if (itemID == ItemName.RUONG_BACH_NGAN || itemID == ItemName.BAT_BAO) {
            Manager.chatKTG(p.c.name + " sử dụng " + data.name + " đã nhận được " + ItemTemplate.ItemTemplateId(itemID).name);
        }
        if (itemID == ItemName.MAT_NA_THO || itemID == ItemName.MAT_NA_THO_1) {
            if (Util.percent(120, 1)) {
                Manager.chatKTG(p.c.name + " sử dụng " + data.name + " đã nhận được " + ItemTemplate.ItemTemplateId(itemID).name + " vĩnh viễn");
                itm.options.add(new Option(58, 20));
                itm.options.add(new Option(92, 100));
                itm.options.add(new Option(94, 100));
                itm.options.add(new Option(82, 500));
                itm.options.add(new Option(127, 10));
                itm.options.add(new Option(128, 10));
                itm.options.add(new Option(129, 10));
                LichSu.LichSuMoItemVinhVien(p.c.name, ItemTemplate.ItemTemplateId(itemID).name);
            } else {
                int HSD = HanSuDung[Util.nextInt(HanSuDung.length)];
                itm.isExpires = true;
                itm.expires = Util.TimeDay(HSD);
                itm.options.add(new Option(58, Util.nextInt(10, 20)));
                itm.options.add(new Option(92, Util.nextInt(50, 100)));
                itm.options.add(new Option(94, Util.nextInt(50, 100)));
                itm.options.add(new Option(82, Util.nextInt(400, 500)));
                itm.options.add(new Option(127, Util.nextInt(5, 10)));
                itm.options.add(new Option(128, Util.nextInt(5, 10)));
                itm.options.add(new Option(129, Util.nextInt(5, 10)));
            }
        }
        p.c.addItemBag(true, itm);
    }
    
    public static void HopMaQuy(Player p, Item item, byte index) {
        ItemTemplate data = ItemTemplate.ItemTemplateId(item.id);
        if (Server.manager.event != EventName.HALLOWEEN) {
            p.sendAddchatYellow(Language.END_EVENT);
            return;
        }
        if (p.c.getBagNull() == 0) {
            p.conn.sendMessageLog("Hành trang không đủ chỗ trống.");
            return;
        }
        if (p.c.quantityItemyTotal(ItemName.CHIA_KHOA) < 1) {
            p.sendAddchatYellow("Bạn không đủ chìa khoá.");
            return;
        }
        p.c.removeItemBag(index, 1);
        p.c.removeItemBags(818, 1);
        p.c.eventPoint += 1;
        p.updateExp(20000000);
        if (Util.nextInt(10) < 2) {
            p.updateExp(Util.nextInt(15000000, 20000000));
        } else if (Util.percent(30, 1)) {
            p.c.addItemBag(true, ItemTemplate.itemDefault(ItemName.RUONG_NGOC, false));
        } else if (Util.percent(1000, 1)) {
            p.c.addItemBag(true, ItemTemplate.itemDefault(ItemName.BANH_TRUNG_THU_BANG_HOA, false));
        } else if (Util.percent(1001, 1)) {
            p.c.addItemBag(true, ItemTemplate.itemDefault(ItemName.BANH_TRUNG_THU_PHONG_LOI, false));
        }
        else if (Util.percent(1002, 1)) {
            p.c.addItemBag(true, ItemTemplate.itemDefault(ItemName.BACH_HO, false));
        }
        else if (Util.percent(1003, 1)) {
            p.c.addItemBag(true, ItemTemplate.itemDefault(ItemName.LAN_SU_VU, false));
        }
        int itemID = RandomItem.HOP_MA_QUY.next();
        Item itm = ItemTemplate.itemDefault(itemID);
        if (itemID == ItemName.GAY_MAT_TRANG || itemID == ItemName.GAY_TRAI_TIM) {
            if (Util.percent(120, 1)) {
                itm.options.add(new Option(58, 20));
                itm.options.add(new Option(92, 100));
                itm.options.add(new Option(94, 150));
                itm.options.add(new Option(121, 30));
                itm.options.add(new Option(84, 100));
                itm.options.add(new Option(80, 500));
                itm.options.add(new Option(120, 1000));
                itm.options.add(new Option(127, 10));
                itm.options.add(new Option(128, 10));
                itm.options.add(new Option(129, 10));
                LichSu.LichSuMoItemVinhVien(p.c.name, ItemTemplate.ItemTemplateId(itemID).name);
            } else {
                int HSD = HanSuDung[Util.nextInt(HanSuDung.length)];
                itm.isExpires = true;
                itm.expires = Util.TimeDay(HSD);
                itm.options.add(new Option(58, Util.nextInt(10, 20)));
                itm.options.add(new Option(92, Util.nextInt(50, 100)));
                itm.options.add(new Option(94, Util.nextInt(100, 150)));
                itm.options.add(new Option(121, Util.nextInt(10, 30)));
                itm.options.add(new Option(84, Util.nextInt(50, 100)));
                itm.options.add(new Option(80, Util.nextInt(250, 500)));
                itm.options.add(new Option(120, Util.nextInt(500, 1000)));
                itm.options.add(new Option(127, Util.nextInt(5, 10)));
                itm.options.add(new Option(128, Util.nextInt(5, 10)));
                itm.options.add(new Option(129, Util.nextInt(5, 10)));
            }
        }
        if (itemID == ItemName.NHAT_TU_LAM_PHONG || itemID == ItemName.THIEN_NGUYET_CHI_NU) {
            if (Util.percent(120, 1)) {
                itm.options.add(new Option(82, 5000));
                itm.options.add(new Option(94, 100));
                itm.options.add(new Option(80, 200));
                itm.options.add(new Option(92, 100));
                itm.options.add(new Option(58, 10));
                itm.options.add(new Option(127, 10));
                itm.options.add(new Option(128, 10));
                itm.options.add(new Option(129, 10));
                LichSu.LichSuMoItemVinhVien(p.c.name, ItemTemplate.ItemTemplateId(itemID).name);
            } else {
                int HSD = HanSuDung[Util.nextInt(HanSuDung.length)];
                itm.isExpires = true;
                itm.expires = Util.TimeDay(HSD);
                itm.options.add(new Option(82, Util.nextInt(3000, 5000)));
                itm.options.add(new Option(94, Util.nextInt(50, 100)));
                itm.options.add(new Option(80, Util.nextInt(100, 200)));
                itm.options.add(new Option(92, Util.nextInt(50, 100)));
                itm.options.add(new Option(58, Util.nextInt(5, 10)));
                itm.options.add(new Option(127, Util.nextInt(5, 10)));
                itm.options.add(new Option(128, Util.nextInt(5, 10)));
                itm.options.add(new Option(129, Util.nextInt(5, 10)));
            }
        }
        if (itemID == ItemName.MAT_NA_THO || itemID == ItemName.MAT_NA_THO_1) {
            if (Util.percent(120, 1)) {
                Manager.chatKTG(p.c.name + " sử dụng " + data.name + " đã nhận được " + ItemTemplate.ItemTemplateId(itemID).name + " vĩnh viễn");
                itm.options.add(new Option(58, 20));
                itm.options.add(new Option(92, 100));
                itm.options.add(new Option(94, 100));
                itm.options.add(new Option(82, 500));
                itm.options.add(new Option(127, 10));
                itm.options.add(new Option(128, 10));
                itm.options.add(new Option(129, 10));
                LichSu.LichSuMoItemVinhVien(p.c.name, ItemTemplate.ItemTemplateId(itemID).name);
            } else {
                int HSD = HanSuDung[Util.nextInt(HanSuDung.length)];
                itm.isExpires = true;
                itm.expires = Util.TimeDay(HSD);
                itm.options.add(new Option(58, Util.nextInt(10, 20)));
                itm.options.add(new Option(92, Util.nextInt(50, 100)));
                itm.options.add(new Option(94, Util.nextInt(50, 100)));
                itm.options.add(new Option(82, Util.nextInt(400, 500)));
                itm.options.add(new Option(127, Util.nextInt(5, 10)));
                itm.options.add(new Option(128, Util.nextInt(5, 10)));
                itm.options.add(new Option(129, Util.nextInt(5, 10)));
            }
        }
        if (itemID == ItemName.MAT_NA_SHIN_AH || itemID == ItemName.MAT_NA_VO_DIEN || itemID == ItemName.MAT_NA_ONI || itemID == ItemName.MAT_NA_KUMA || itemID == ItemName.MAT_NA_INU) {
            if (Util.percent(120, 1)) {
                Manager.chatKTG(p.c.name + " sử dụng " + data.name + " đã nhận được " + ItemTemplate.ItemTemplateId(itemID).name + " vĩnh viễn");
                itm.options.add(new Option(58, 20));
                itm.options.add(new Option(82, 2000));
                itm.options.add(new Option(127, 10));
                itm.options.add(new Option(128, 10));
                itm.options.add(new Option(129, 10));
                LichSu.LichSuMoItemVinhVien(p.c.name, ItemTemplate.ItemTemplateId(itemID).name);
            } else {
                int HSD = HanSuDung[Util.nextInt(HanSuDung.length)];
                itm.isExpires = true;
                itm.expires = Util.TimeDay(HSD);
                itm.options.add(new Option(58, Util.nextInt(10, 20)));
                itm.options.add(new Option(82, Util.nextInt(1000, 2000)));
                itm.options.add(new Option(127, Util.nextInt(5, 10)));
                itm.options.add(new Option(128, Util.nextInt(5, 10)));
                itm.options.add(new Option(129, Util.nextInt(5, 10)));
            }
        }
        if (itemID == ItemName.RUONG_BACH_NGAN || itemID == ItemName.RUONG_HUYEN_BI || itemID == ItemName.BAT_BAO) {
            Manager.chatKTG(p.c.name + " sử dụng " + data.name + " đã nhận được " + ItemTemplate.ItemTemplateId(itemID).name);
        }
        p.c.addItemBag(true, itm);
    }
}

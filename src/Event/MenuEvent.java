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
import server.Rank;
import server.Service;
import stream.Server;
import template.ItemTemplate;

/**
 *
 * @author voqua
 */
public class MenuEvent {

    public static void npcTienNu(Player p, byte npcid, byte menuId, byte b3) {
        switch (Server.manager.event) {
            case EventName.SU_KIEN_DUA_HAU: {
                if (p.c.isNhanban) {
                    Service.chatNPC(p, (short) npcid, Language.NOT_FOR_PHAN_THAN);
                    return;
                }
                switch (menuId) {
                    case 0:
                        Service.sendInputDialog(p, (short) -1, "Nhập số lượng");
                        break;
                    case 1:
                        Service.sendInputDialog(p, (short) -2, "Nhập số lượng");
                        break;
                    case 2:
                        Server.manager.sendTB(p, "Top", Rank.getStringBXH(4)
                                + "\n- Số Điểm EVENT : " + p.c.eventPoint);
                        break;
                    case 3:
                        Server.manager.sendTB(p, "Hướng Dẫn",
                                "- 2 (Bánh thập cẩm + Bánh dẻo + Bánh đậu xanh + Bánh Pía) + 50.000 XU = Hộp Bánh Thường không khóa) +1 Điểm EVENT .\n"
                                + "- 2 Hộp Bánh Thường + 50 Lượng = Hộp Bánh Thượng Hạng(khóa) +2 Điểm EVENT .\n"
                        );
                        break;

                }
                break;
            }
            case EventName.HALLOWEEN: {
                if (p.c.isNhanban) {
                    Service.chatNPC(p, (short) npcid, Language.NOT_FOR_PHAN_THAN);
                    return;
                }
                switch (menuId) {
                    case 0:
                        Service.sendInputDialog(p, (short) -20, "Nhập số lượng");
                        break;
                    case 1:
                        Service.sendInputDialog(p, (short) -19, "Nhập số lượng");
                        break;
                    case 2:
                        Server.manager.sendTB(p, "Top Điểm Sự Kiện", Rank.getStringBXH(4)
                                + "\n- Điểm Của Bạn : " + p.c.eventPoint);
                        break;
                    case 3:
                        Server.manager.sendTB(p, "Hướng dẫn",
                                "  - Kẹo Táo : Quả Táo + Mật Ong + 20 Lượng.\n"
                                + "- Hộp Ma Qủy  : Xương Thú + Tàn Linh + 50 Lượng ( 1 Điểm Đua Top Hộp Ma Qủy + Tỉ Lệ Ra Đồ Hiếm Cao ).\n"
                                + "- Dùng Hộp Ma Qủy Cần Chìa Khóa Ở Ghoso Với Giá 20K XU "
                        );
                        break;
                    default: {
                        break;
                    }
                }
                break;
            }
            default: {
                Service.chatNPC(p, (short) npcid, "Chức năng này đang cập nhật!");
                break;
            }
        }
    }

    public static void NpcDuaBe(Player p, byte npcid, byte menuId, byte b3) {
        switch (menuId) {
            case 0: {
                if (p.c.isNhanban) {
                    p.conn.sendMessageLog(Language.NOT_FOR_PHAN_THAN);
                    return;
                } else {
                    if (p.c.nvtruyentin == 0) {
                        Service.chatNPC(p, (short) npcid, "Con Muốn Có Quà.");
                        return;
                    }
                    if (p.c.nvtruyentin == 1) {
                        p.c.nvtruyentin = 2;
                        Service.chatNPC(p, (short) npcid, "Con Cám Ơn ! Giáng Sinh An Lành ! Giờ Hãy về gặp Ông Già Noel nhận lấy phấn thưởng.");
                        break;
                    }
                }
            }
        }
    }

    public static void NpcOngGiaNoel(Player p, byte npcid, byte menuId, byte b3) {
        if (p.c.isNhanban) {
            Service.chatNPC(p, (short) npcid, Language.NOT_FOR_PHAN_THAN);
            return;
        }
        switch (b3) {
            case 0: {
                if (p.c.isNhanban) {
                    p.conn.sendMessageLog(Language.NOT_FOR_PHAN_THAN);
                    break;
                } else {
                    if (p.c.nvtruyentin == 1 || p.c.nvtruyentin == 2) {
                        Service.chatNPC(p, (short) npcid, "Con đã nhận nhiệm vụ trước đó rồi mà.");
                        return;
                    }
                    if (p.c.quantityItemyTotal(484) < 1) {
                        Service.chatNPC(p, (short) npcid, "Hành trang của con không có đủ túi quà");
                        break;
                    } else {
                        Service.chatNPC(p, (short) npcid, "Con hãy đi tìm Đứa Bé Ở Vách Ichidai Để Phát Quà.");
                        p.c.nvtruyentin = 1;
                        p.c.removeItemBags(484, 1);
                    }
                }
                break;
            }
            case 1: {
                if (p.c.nvtruyentin == 0) {
                    Service.chatNPC(p, (short) npcid, "Con chưa nhận nhiệm vụ.");
                    return;
                } else {
                    Service.chatNPC(p, (short) npcid, "Con đã hủy nhiệm vụ lần này.");
                    p.c.nvtruyentin = 0;
                }
                break;
            }
            case 2: {
                if (p.c.nvtruyentin == 0) {
                    Service.chatNPC(p, (short) npcid, "Con chưa nhận nhiệm vụ.");
                    return;
                }
                if (p.c.nvtruyentin == 1) {
                    Service.chatNPC(p, (short) npcid, "Con chưa hoàn thành nhiệm vụ để nhận thưởng.");
                    return;
                }
                if (p.c.getBagNull() < 1) {
                    p.conn.sendMessageLog("Hành trang không đủ chỗ trống");
                    return;
                }
                if (p.c.nvtruyentin == 2) {
                    p.c.nvtruyentin = 0;
                    p.updateExp(5000000);
                    p.c.upxuMessage(Util.nextInt(5000, 10000));
                    if (Util.nextInt(10) < 5) {
                        p.updateExp(Util.nextInt(5000000, 10000000));
                    } else if (Util.percent(20, 1)) {
                        p.c.addItemBag(true, ItemTemplate.itemDefault(838, false));
                    } else if (Util.nextInt(30000) < 1) {
                        p.c.addItemBag(true, ItemTemplate.itemDefault(383, false));
                        LichSu.LichSuMoItemVinhVien(p.c.name, ItemTemplate.ItemTemplateId(383).name);
                        Manager.chatKTG(p.c.name + " Phát Quà Cho Đứa Bé nhận được " + ItemTemplate.ItemTemplateId(383).name);
                    } else if (Util.nextInt(40000) < 1) {
                        p.c.addItemBag(true, ItemTemplate.itemDefault(384, false));
                        LichSu.LichSuMoItemVinhVien(p.c.name, ItemTemplate.ItemTemplateId(384).name);
                        Manager.chatKTG(p.c.name + " Phát Quà Cho Đứa Bé nhận được " + ItemTemplate.ItemTemplateId(384).name);
                    } else if (Util.nextInt(50000) < 1) {
                        p.c.addItemBag(true, ItemTemplate.itemDefault(385, false));
                        LichSu.LichSuMoItemVinhVien(p.c.name, ItemTemplate.ItemTemplateId(385).name);
                        Manager.chatKTG(p.c.name + " Phát Quà Cho Đứa Bé nhận được " + ItemTemplate.ItemTemplateId(385).name);
                    } else if (Util.nextInt(500) < 3) {
                        p.c.addItemBag(true, ItemTemplate.itemDefault(ItemName.XICH_NHAN_NGAN_LANG, false));
                    } else if (Util.nextInt(500) < 2) {
                        p.c.addItemBag(true, ItemTemplate.itemDefault(ItemName.HARLEY_DAVIDSON, false));
                    } else if (Util.nextInt(500) < 1) {
                        p.c.addItemBag(true, ItemTemplate.itemDefault(ItemName.XE_MAY, false));
                    } else if (Util.nextInt(10000) < 1) {
                        Item itemup = ItemTemplate.itemDefault(ItemName.THAI_DUONG_VO_CUC_KIEM);
                        itemup.sys = 1;
                        p.c.addItemBag(true, itemup);
                    } else if (Util.nextInt(10000) < 2) {
                        Item itemup = ItemTemplate.itemDefault(ItemName.THAI_DUONG_THIEN_HOA_TIEU);
                        itemup.sys = 1;
                        p.c.addItemBag(true, itemup);
                    } else if (Util.nextInt(10000) < 3) {
                        Item itemup = ItemTemplate.itemDefault(ItemName.THAI_DUONG_TANG_HON_DAO);
                        itemup.sys = 2;
                        p.c.addItemBag(true, itemup);
                    } else if (Util.nextInt(10000) < 4) {
                        Item itemup = ItemTemplate.itemDefault(ItemName.THAI_DUONG_BANG_THAN_CUNG);
                        itemup.sys = 2;
                        p.c.addItemBag(true, itemup);
                    } else if (Util.nextInt(10000) < 5) {
                        Item itemup = ItemTemplate.itemDefault(ItemName.THAI_DUONG_CHIEN_LUC_DAO);
                        itemup.sys = 3;
                        p.c.addItemBag(true, itemup);
                    } else if (Util.nextInt(10000) < 6) {
                        Item itemup = ItemTemplate.itemDefault(ItemName.THAI_DUONG_HOANG_PHONG_PHIEN);
                        itemup.sys = 3;
                        p.c.addItemBag(true, itemup);
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
                                Manager.chatKTG(p.c.name + " Phát Qùa Cho Đứa Bé nhận được " + ItemTemplate.ItemTemplateId(itemID).name + " Vĩnh Viễn");
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
                                Manager.chatKTG(p.c.name + " Phát Qùa Cho Đứa Bé nhận được " + ItemTemplate.ItemTemplateId(itemID).name + " Vĩnh Viễn");
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
                                Manager.chatKTG(p.c.name + " Phát Qùa Cho Đứa Bé nhận được " + ItemTemplate.ItemTemplateId(itemID).name + " Vĩnh Viễn");
                            } else {
                                int HSD = HanSuDung[Util.nextInt(HanSuDung.length)];
                                itm.isExpires = true;
                                itm.expires = Util.TimeDay(HSD);
                            }
                        }
                        if (itemID == ItemName.MAT_NA_SHIN_AH || itemID == ItemName.MAT_NA_VO_DIEN || itemID == ItemName.MAT_NA_ONI || itemID == ItemName.MAT_NA_KUMA || itemID == ItemName.MAT_NA_INU) {
                            if (Util.percent(100, 1)) {
                                LichSu.LichSuMoItemVinhVien(p.c.name, ItemTemplate.ItemTemplateId(itemID).name);
                                Manager.chatKTG(p.c.name + " Phát Qùa Cho Đứa Bé nhận được " + ItemTemplate.ItemTemplateId(itemID).name + " Vĩnh Viễn");
                            } else {
                                int HSD = HanSuDung[Util.nextInt(HanSuDung.length)];
                                itm.isExpires = true;
                                itm.expires = Util.TimeDay(HSD);
                            }
                        }
                        if (itemID == ItemName.BACH_HO) {
                            if (Util.percent(120, 1)) {
                                LichSu.LichSuMoItemVinhVien(p.c.name, ItemTemplate.ItemTemplateId(itemID).name);
                                Manager.chatKTG(p.c.name + " Phát Qùa Cho Đứa Bé nhận được " + ItemTemplate.ItemTemplateId(itemID).name + " Vĩnh Viễn");
                            } else {
                                int HSD = HanSuDung[Util.nextInt(HanSuDung.length)];
                                itm.isExpires = true;
                                itm.expires = Util.TimeDay(HSD);
                            }
                        }
                        p.c.addItemBag(true, itm);
                        Service.chatNPC(p, (short) npcid, "Cám ơn ! Chúc Giáng Sinh Vui Vẽ.");
                    }
                    break;
                }
            }
        }
    }
}

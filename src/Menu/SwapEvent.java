/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Menu;

import History.LichSu;
import Item.ItemName;
import assembly.Item;
import assembly.Player;
import server.Service;
import template.ItemTemplate;

/**
 *
 * @author Administrator
 */
public class SwapEvent {

    public static void Lamhopbanhthuong(Player p, String str) {
        try {
            int num = Integer.parseInt(str);
            if (num < 1 || num > 10000) {
                p.conn.sendMessageLog("Tối Đa 10000 Cái 1 Lần");
                return;
            }
            long soluong = Integer.parseInt(str);
            if (p.c.quantityItemyTotal(ItemName.BANH_THAP_CAM) >= 2 * soluong && p.c.quantityItemyTotal(ItemName.BANH_DEO) >= 2 * soluong && p.c.quantityItemyTotal(ItemName.BANH_DAU_XANH) >= 2 * soluong && p.c.quantityItemyTotal(ItemName.BANH_PIA) >= 2 * soluong) {
                if (p.c.getBagNull() == 0) {
                    Service.chatNPC(p, (short) 33, "Hành Trang Không Đủ Chổ Trống");
                    return;
                }
                if (p.c.xu < 60000 * soluong) {
                    Service.chatNPC(p, (short) 33, "Không Đủ Xu");
                    return;
                }
                p.c.removeItemBags(ItemName.BANH_THAP_CAM, (int) (2 * soluong));
                p.c.removeItemBags(ItemName.BANH_DEO, (int) (2 * soluong));
                p.c.removeItemBags(ItemName.BANH_DAU_XANH, (int) (2 * soluong));
                p.c.removeItemBags(ItemName.BANH_PIA, (int) (2 * soluong));
                LichSu.LichSuXu(p.c.name, p.c.xu, (int) (p.c.xu - (50000 * soluong)), "Làm " + soluong + " Hộp bánh thường", -(50000 * soluong));
                p.c.upxuMessage(-(50000 * soluong));
                Item it = ItemTemplate.itemDefault(ItemName.HOP_BANH_THUONG);
                it.quantity = (int) (1 * soluong);
                it.isLock = false;
                p.c.addItemBag(true, it);
            } else {
                Service.chatNPC(p, (short) 33, "Hành Trang Không Đủ Nguyên Liệu");
            }
        } catch (NumberFormatException e) {
            p.conn.sendMessageLog("Không hợp lệ");
        }
    }

    public static void Lamhopbanhthuonghang(Player p, String str) {
        try {
            int num = Integer.parseInt(str);
            if (num < 1 || num > 10000) {
                p.conn.sendMessageLog("Tối Đa 10000 Cái 1 Lần");
                return;
            }
            long soluong = Integer.parseInt(str);
            if (p.c.quantityItemyTotal(ItemName.HOP_BANH_THUONG) >= 2 * soluong) {
                if (p.c.getBagNull() == 0) {
                    Service.chatNPC(p, (short) 33, "Hành Trang Không Đủ Chổ Trống");
                    return;
                }
                if (p.luong < 50 * soluong) {
                    Service.chatNPC(p, (short) 33, "Không Đủ Lượng ");
                    return;
                }
                p.c.removeItemBags(ItemName.HOP_BANH_THUONG, (int) (2 * soluong));
                LichSu.LichSuLuong(p.c.name, p.luong, (int) (p.luong - (50 * soluong)), "Làm " + soluong + " Bó Hộp bánh thượng hạng", -(50 * soluong));
                p.upluongMessage(-(50 * soluong));
                Item it = ItemTemplate.itemDefault(ItemName.HOP_BANH_THUONG_HANG);
                it.quantity = (int) (1 * soluong);
                it.isLock = true;
                p.c.addItemBag(true, it);
            } else {
                Service.chatNPC(p, (short) 33, "Hành Trang Không Đủ Nguyên Liệu");
            }
        } catch (NumberFormatException e) {
            p.conn.sendMessageLog("Không hợp lệ");
        }
    }
    
    public static void Lamkeotao(Player p, String str) {
        try {
            int num = Integer.parseInt(str);
            if (num < 1 || num > 10000) {
                p.conn.sendMessageLog("Tối Đa 10000 Cái 1 Lần");
                return;
            }
            long soluong = Integer.parseInt(str);
            if (p.c.quantityItemyTotal(ItemName.QUA_TAO) >= 1 * soluong && p.c.quantityItemyTotal(ItemName.MAT_ONG) >= 1) {
                if (p.c.getBagNull() == 0) {
                    p.conn.sendMessageLog("Hành trang không đủ chỗ trống");
                    return;
                }
                if (p.luong < 20 * soluong) {
                    p.conn.sendMessageLog("Không Đủ Lượng");
                } else {
                    p.c.removeItemBags(ItemName.QUA_TAO, (int) (1 * soluong));
                    p.c.removeItemBags(ItemName.MAT_ONG, (int) (1 * soluong));

                    p.upluongMessage(-(20 * soluong));
                    Item it = ItemTemplate.itemDefault(ItemName.KEO_TAO);
                    it.quantity = (int) (1 * soluong);
                    it.isLock = false;
                    p.c.addItemBag(true, it);
                }
                return;
            } else {
                Service.chatNPC(p, (short) 33, "Không Đủ Nguyên Liệu");
            }
        } catch (Exception e) {
            p.conn.sendMessageLog("Không hợp lệ");
        }
    }
    
    public static void Lamhopmaquy(Player p, String str) {
        try {
            int num = Integer.parseInt(str);
            if (num < 1 || num > 10000) {
                p.conn.sendMessageLog("Tối Đa 10000 Cái 1 Lần");
                return;
            }
            long soluong = Integer.parseInt(str);
            if (p.c.quantityItemyTotal(ItemName.XUONG_THU) >= 1 * soluong && p.c.quantityItemyTotal(ItemName.TAN_LINH) >= 1) {
                if (p.c.getBagNull() == 0) {
                    p.conn.sendMessageLog("Hành trang không đủ chỗ trống");
                    return;
                }
                if (p.luong < 50 * soluong) {
                    p.conn.sendMessageLog("Không Đủ Lượng");
                } else {
                    p.c.removeItemBags(ItemName.XUONG_THU, (int) (1 * soluong));
                    p.c.removeItemBags(ItemName.TAN_LINH, (int) (1 * soluong));
                    p.upluongMessage(-(50 * soluong));
                    Item it = ItemTemplate.itemDefault(ItemName.HOP_MA_QUY);
                    it.quantity = (int) (1 * soluong);
                    it.isLock = false;
                    p.c.addItemBag(true, it);
                }
                return;
            } else {
                Service.chatNPC(p, (short) 33, "Không Đủ Nguyên Liệu");
            }
        } catch (Exception e) {
            p.conn.sendMessageLog("Không hợp lệ");
        }
    }
}

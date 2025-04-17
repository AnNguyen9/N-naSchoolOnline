/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Upgrade;

import assembly.Item;
import assembly.Option;
import assembly.Player;
import io.Util;
import server.Service;
import stream.Server;

public class Yoroi {

    public static int[] Percent = new int[]{100, 90, 80, 70, 60, 50, 40, 30, 25, 20, 15, 10, 8, 5, 3, 1};

    public static void MenuUpgradeYoroi(Player p, byte npcid, byte menuId, byte b3) {
        switch (menuId) {
            case 0: {
                Item YY = p.c.ItemBody[12];
                if (p.c.isNhanban) {
                    Service.chatNPC(p, (short) npcid, "Phân thân không thể sử dụng chức năng này");
                    return;
                }
                if (YY == null || YY.id != 420 && YY.id != 421 && YY.id != 422) {
                    Service.chatNPC(p, (short) npcid, "Hãy Mặc Yoroi Vào Mới Có Thể Nâng Cấp");
                    return;
                }

                if (YY.upgrade == 14) {
                    Service.chatNPC(p, (short) npcid, "Yoroi Đã đạt cấp tối đa");
                    break;
                }
                if (p.c.getBagNull() == 1) {
                    Service.chatNPC(p, (short) 45, "Hành Trang Không Đủ Chổ Trống");
                    return;
                }
                if (p.c.xu < 50000000) {
                    Service.chatNPC(p, (short) npcid, "Không đủ 50tr xu để nâng cấp");
                    return;
                }
                if (p.c.quantityItemyTotal(222) < 1
                        || p.c.quantityItemyTotal(223) < 1
                        || p.c.quantityItemyTotal(224) < 1
                        || p.c.quantityItemyTotal(225) < 1
                        || p.c.quantityItemyTotal(226) < 1
                        || p.c.quantityItemyTotal(227) < 1
                        || p.c.quantityItemyTotal(228) < 1) {
                    Service.chatNPC(p, (short) npcid, "Bạn Không Đủ 7 Viên Ngọc Mỗi Loại Để Nâng Cấp");
                    return;
                }
                Service.startYesNoDlg(p, (byte) 12, "Bạn có muốn nâng cấp Yoroi "
                        + " cấp " + (YY.upgrade + 1)
                        + " với 50.000.000 "
                        + " Xu Và 7 Viên Ngọc Mỗi Loại không 9 ( Tỉ Lệ : 100% )? ");
                break;
            }

            case 1: {
                Server.manager.sendTB(p,
                        "Hướng dẫn",
                        "Xu Và 7 Viên Ngọc Mỗi Loại"
                );
                break;
            }
        }
    }

    public static void UpgradeYoroi(Player p) {
        Item YY = p.c.get().ItemBody[12];
        p.c.upxuMessage(-50000000);
        p.c.removeItemBags(222, 1);
        p.c.removeItemBags(223, 1);
        p.c.removeItemBags(224, 1);
        p.c.removeItemBags(225, 1);
        p.c.removeItemBags(226, 1);
        p.c.removeItemBags(227, 1);
        p.c.removeItemBags(228, 1);
        if (Yoroi.Percent[YY.getUpgrade()] >= Util.nextInt(1)) {
            for (byte k = 0; k < YY.options.size(); ++k) {
                Option option = YY.options.get(k);
                if (option.id == 80 || option.id == 81) {
                    Option ops = option;
                    ops.param += 10;
                }
                if (option.id == 82 || option.id == 83) {
                    Option ops = option;
                    ops.param += 350;
                }
                if (option.id == 84) {
                    Option ops = option;
                    ops.param += 50;
                }
                if (option.id == 79) {
                    Option ops = option;
                    ops.param += 1;
                }
            }
            YY.setUpgrade(YY.getUpgrade() + 1);
            YY.setLock(true);
            p.c.addItemBag(true, YY);
            Service.chatNPC(p, (short) 48, "Nâng Cấp Thành Công");
            p.c.removeItemBody((byte) 12);
        } else {
            Service.chatNPC(p, (short) 48, " Nâng Cấp Thất Bại !");
        }
    }

}

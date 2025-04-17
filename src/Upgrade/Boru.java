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

public class Boru {


    public static void MenuUpgradeBoru(Player p, byte npcid, byte menuId, byte b3) {
        switch (menuId) {
            case 0: {
                Item Boru = p.c.ItemBody[10];
                if (p.c.isNhanban) {
                    Service.chatNPC(p, (short) npcid, "Phân thân không thể sử dụng chức năng này");
                    return;
                }
                if (Boru == null || Boru.id != 781) {
                    Service.chatNPC(p, (short) npcid, "Hãy Mặc Boru Vào Mới Có Thể Nâng Cấp");
                    return;
                }
                if (Boru.upgrade == 11) {
                    Service.chatNPC(p, (short) npcid, "Boru Đã đạt cấp tối đa");
                    break;
                }
                if (p.c.getBagNull() == 1) {
                    Service.chatNPC(p, (short) 45, "Hành Trang Không Đủ Chổ Trống");
                    return;
                }
                if (p.c.xu < 30000000) {
                    Service.chatNPC(p, (short) npcid, "Không đủ 30tr xu để nâng cấp");
                    return;
                }
                if (p.c.quantityItemyTotal(454) < 1) {
                    Service.chatNPC(p, (short) npcid, "Bạn Không Đủ 1 Viên Chuyển Tinh Thạch Để Nâng Cấp");
                    return;
                }
                Service.startYesNoDlg(p, (byte) 10, "Bạn có muốn nâng cấp Boru "
                        + " cấp " + (Boru.upgrade + 1)
                        + " với 30.000.000 "
                        + " Xu Và 1 Viên Chuyển Tinh Thạch không ( Tỉ Lệ : 15% )? ");
                break;
            }

            case 1: {
                Server.manager.sendTB(p,
                        "Hướng dẫn",
                        ""
                );
                break;
            }
        }
    }

    public static void UpgradeBoru(Player p) {
        Item Boru = p.c.get().ItemBody[10];
        p.c.upxuMessage(-30000000);
        p.c.removeItemBags(454, 1);
         if (Util.nextInt(100) < 10) {
            for (byte k = 0; k < Boru.options.size(); ++k) {
                Option option = Boru.options.get(k);
                if (option.id == 6 || option.id == 7) {
                    Option ops = option;
                    ops.param += 100;
                }
                if (option.id == 87 ) {
                    Option ops = option;
                    ops.param += 500;
                }
                if (option.id == 100) {
                    Option ops = option;
                    ops.param += 1;
                }
            }
            Boru.setUpgrade(Boru.getUpgrade() + 1);
            Boru.setLock(true);
            p.c.addItemBag(true, Boru);
            Service.chatNPC(p, (short) 49, "Nâng Cấp Thành Công");
            p.c.removeItemBody((byte) 10);
        } else {
            Service.chatNPC(p, (short) 49, " Nâng Cấp Thất Bại !");
        }
    }

}

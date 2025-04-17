/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Upgrade;

import History.LichSu;
import assembly.Item;
import assembly.Option;
import assembly.Player;
import io.Util;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import server.Service;
import stream.Server;
import template.ItemTemplate;

/**
 *
 * @author voqua
 */
public class BiKip {

    public static int[] Luong = new int[]{100, 500, 1000, 1500, 2000, 2500, 3000, 3500, 4000, 4500, 5000, 5500, 6000, 6500, 7000, 8000}; // lượng
    public static int[] Xu = new int[]{100000, 500000, 1000000, 1500000, 2000000, 2500000, 3000000, 3500000, 4000000, 4500000, 5000000, 5500000, 6000000, 6500000, 7000000, 8000000}; // lượng
    // Options Bí Kíp
    public static int[] Options = new int[]{95, 96, 97, 81, 87, 82, 83, 94, 92, 84, 86, 79, 80, 98, 57};
    public static int[] param = new int[]{
        Util.nextInt(10, 30),
        Util.nextInt(10, 30),
        Util.nextInt(10, 30),
        Util.nextInt(10, 30),
        Util.nextInt(100, 500),
        Util.nextInt(100, 500),
        Util.nextInt(100, 500),
        Util.nextInt(10, 20),
        Util.nextInt(10, 20),
        Util.nextInt(10, 20),
        Util.nextInt(10, 20),
        Util.nextInt(1, 5),
        Util.nextInt(10, 50),
        Util.nextInt(1, 5),
        Util.nextInt(1, 10)};
    public static int[] Tile = new int[]{100, 90, 80, 70, 60, 50, 40, 30, 25, 20, 15, 10, 8, 5, 3, 1}; // tỉ lệ

    public static void MenuUpgradeBiKip(Player p, byte npcid, byte menuId, byte b3) throws IOException {
        if (p.c.isNhanban) {
            Service.chatNPC(p, (short) 44, "Chức năng này không dành cho phân thân");
            return;
        }
        switch (menuId) {
            case 0: {

                Item Item = p.c.ItemBody[15];
                if (p.c.get().nclass == 0) {
                    Service.chatNPC(p, (short) 44, "Hãy Nhập Học Để Có Thể Luyện Bí Kíp.");
                    return;
                }
                if (p.c.get().level < 60) {
                    Service.chatNPC(p, (short) 44, "Yêu Cầu Trình Độ Cấp 60 Mới Có Thể Luyện Bí Kíp.");
                    return;
                }
                if (Item == null) {
                    Service.chatNPC(p, (short) 44, "Bạn Phải Đeo Bí Kíp Lên Người Mới Có Thể Luyện Bí Kíp");
                    return;
                }
                if (Item.upgrade >= 1) {
                    Service.chatNPC(p, (short) 44, "Bí Kíp Đã Được Nâng Cấp Không Thể Luyện Bí Kíp");
                    return;
                }
                if (p.c.getBagNull() == 0) {
                    Service.chatNPC(p, (short) 44, "Hành Trang Không Đủ Chổ Trống");
                    return;
                }
                if (p.luong < 1000) {
                    Service.chatNPC(p, (short) 44, "Bạn Không Đủ 1000 Lượng Để Luyện Bí Kíp");
                    return;
                }
                if (p.c.xu < 1000000) {
                    Service.chatNPC(p, (short) 44, "Bạn Không Đủ 1.000.000 Xu Để Luyện Bí Kíp");
                    return;
                }
                Item it = ItemTemplate.itemDefault(396 + p.c.nclass);
                int a = Util.nextInt(1, 8);
                List<Integer> list = new ArrayList<>();
                for (int i = 0; i < BiKip.Options.length; i++) {
                    list.add(i);
                }
                while (it.options.size() < a) {
                    int index = Util.nextInt(list.size());
                    int indexOption = list.get(index);
                    list.remove(index);
                    it.options.add(new Option(BiKip.Options[indexOption], (BiKip.param[indexOption])));
                }
                it.setLock(true);
                p.c.addItemBag(true, it);
                p.c.removeItemBody((byte) 15);
                LichSu.LichSuLuong(p.c.name, p.luong, (p.luong - 1000), "Luyện Bí Kíp", -1000);
                p.upluongMessage(-1000);
                LichSu.LichSuXu(p.c.name, p.c.xu, (p.c.xu - 1000000), "Luyện Bí Kíp", -1000000);
                p.c.upxuMessage(-1000000);
                String b = "";
                if (a == 5) {
                    b = "Ngon ! Hi sinh vì Đam Mê thì chưa bao giờ là Ngu";
                } else if (a >= 2 && a <= 4) {
                    b = "Chỉ số MẠNH hay YẾU là do Nhân Phẩm của bạn !";
                } else {
                    b = "Chỉ số Cùi thì ta làm lại . Dừng lại là Thất Bại rồi !";
                }
                Service.chatNPC(p, (short) 44, b);
                break;
            }
            case 1: {
                Item Item = p.c.get().ItemBody[15];
                if (Item == null) {
                    Service.chatNPC(p, (short) 44, "Bạn phải đeo bí kíp lên người mới có thể nâng cấp bí kíp");
                    return;
                }
                if (Item.getUpgrade() >= 16) {
                    Service.chatNPC(p, (short) 44, "Bí kíp đã đạt cấp tối đa");
                    return;
                }
                if (p.c.getBagNull() == 0) {
                    Service.chatNPC(p, (short) 44, "Hành trang không đủ chỗ trống");
                    return;
                }
                if (p.c.quantityItemyTotal(837) < 5 * Item.upgrade) {
                    ItemTemplate data = ItemTemplate.ItemTemplateId(837);
                    Service.chatNPC(p, (short) 44, "Bạn không đủ " + 5 * Item.upgrade + " viên " + data.name + " để nâng cấp");
                    return;
                }
                if (p.luong < Luong[Item.upgrade]) {
                    Service.chatNPC(p, (short) 44, "Bạn Không Đủ Lượng Để Nâng Cấp Bí Kíp");
                    return;
                }
                if (p.c.xu < Xu[Item.upgrade]) {
                    Service.chatNPC(p, (short) 44, "Bạn Không Đủ Xu Để Nâng Cấp Bí Kíp");
                    return;
                }
                ItemTemplate data = ItemTemplate.ItemTemplateId(Item.id);
                Service.startYesNoDlg(p, (byte) 15,
                        "Bạn có muốn nâng cấp " + data.name + " cấp " + (Item.upgrade + 1) + " Với " + Luong[Item.upgrade]
                        + " Lượng và " + Xu[Item.upgrade] + " Xu Và " + (Item.upgrade) * 5 + " Đá Nâng Cấp Bí Kíp Với tỷ lệ thành công là "
                        + Tile[Item.upgrade] + "% không?");
                break;
            }
            case 2: {
                Item Item = p.c.get().ItemBody[15];
                if (Item == null) {
                    Service.chatNPC(p, (short) 44, "Bạn phải mặc bí kíp lên người trước");
                    return;
                }
                Service.startYesNoDlg(p, (byte) -4, "Bạn Có Muốn Xóa Bí Kíp Đang Mặc Trên Người Không. Ấn Đồng Ý Bí Kíp Sẽ Mất Vĩnh Viễn");
                break;
            }
            case 3: {
                Server.manager.sendTB(p,
                        "Hướng dẫn",
                        "- Để Tham Gia Chức Năng Bí Kíp Con Cần Có Bí Kíp  \n"
                        + "- Để Luyện Bí Kíp Con Cần Có 1000 Lượng + 1.000.000 Xu \n"
                        + "- Khi Luyện Bí Kíp Sẽ Nhận Được Random 1 Đến 8 Chỉ Số Ngẫu Nhiên \n"
                        + "- Nếu May Mắn Sẽ Nhận Được Chỉ Số Ngon \n"
                        + "- Để Nâng Cấp Bí Kíp Con Cần Có Đá Nâng Cấp Bí Kíp \n"
                        + "- Khi Nâng Cấp Bí Kíp Con Cần Phải Bỏ Ra 1 Ít Lượng Xu Và 1 Số Đá Nâng Cấp \n"
                        + "- Khi Nâng Cấp Bí Kíp Sẽ Được Tăng Chỉ Số Của Bí Kíp \n"
                );
                break;
            }
        }
    }

    public static void UpgradeBiKip(Player p) {
        Item it = p.c.get().ItemBody[15];
        LichSu.LichSuLuong(p.c.name, p.luong, (-Luong[it.upgrade]), "Nâng Cấp Bí Kíp", -Luong[it.upgrade]);
        p.upluongMessage(-Luong[it.upgrade]);
        LichSu.LichSuXu(p.c.name, p.c.xu, (p.c.xu - Xu[it.upgrade]), "Nâng Cấp Bí Kíp", -Xu[it.upgrade]);
        p.c.upxuMessage(-Xu[it.upgrade]);
        p.c.removeItemBags(837, (5 * it.upgrade));
        if (BiKip.Tile[it.getUpgrade()] >= Util.nextInt(111)) {
            for (byte k = 0; k < it.options.size(); ++k) {
                Option option = it.options.get(k);
                if (option.id == 95 || option.id == 96 || option.id == 97 || option.id == 81) {
                    Option ops = option;
                    ops.param += 8;
                }
                if (option.id == 87 || option.id == 82 || option.id == 83) {
                    Option ops = option;
                    ops.param += 595;
                }
                if (option.id == 84 || option.id == 86 || option.id == 94 || option.id == 92) {
                    Option ops = option;
                    ops.param += 5;
                }
                if (option.id == 80) {
                    Option ops = option;
                    ops.param += 10;
                }
                if (option.id == 79 || option.id == 98) {
                    Option ops = option;
                    ops.param += 1;
                }
                if (option.id == 58) {
                    Option ops = option;
                    ops.param += 6;
                }
            }
            it.setUpgrade(it.getUpgrade() + 1);
            it.setLock(true);
            p.c.addItemBag(true, it);
            Service.chatNPC(p, (short) 44, "Nâng Cấp Thành Công");
            p.c.removeItemBody((byte) 15);
        } else {
            Service.chatNPC(p, (short) 44, " Nâng Cấp Thất Bại !");
        }
    }
}

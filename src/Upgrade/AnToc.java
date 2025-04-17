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
import java.util.ArrayList;
import java.util.List;
import server.Service;
import stream.Server;
import template.ItemTemplate;

/**
 *
 * @author Administrator
 */
public class AnToc {

    public static int[] Luong = new int[]{100, 500, 1000, 1500, 2000, 2500, 3000, 3500, 4000, 4500, 5000, 5500, 6000, 6500, 7000, 8000}; // lượng
    public static int[] Xu = new int[]{100000, 500000, 1000000, 1500000, 2000000, 2500000, 3000000, 3500000, 4000000, 4500000, 5000000, 5500000, 6000000, 6500000, 7000000, 8000000}; // lượng
    public static int[] Tile = new int[]{100, 90, 80, 70, 60, 50, 40, 30, 25, 20, 15, 10, 8, 5, 3, 1}; // tỉ lệ
    public static int[] Options = new int[]{95, 96, 97, 81, 87, 82, 83, 94, 92, 84, 86, 79, 80, 98, 58, 67};
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
        Util.nextInt(1, 5),
        Util.nextInt(1, 10)};

    public static void MenuAnToc(Player p, byte npcid, byte menuId, byte b3) {
        if (p.c.isNhanban) {
            Service.chatNPC(p, (short) 45, "Chức năng này không dành cho phân thân");
            return;
        }
        switch (menuId) {
            case 0:
                Item AnToc = p.c.ItemBody[29];
                if (AnToc == null || AnToc.id != 839) {
                    Service.chatNPC(p, (short) 45, "Bạn Phải Đeo Ấn Tộc Lên Người Mới Có Thể Luyện Ấn");
                    return;
                }
                if (AnToc.upgrade >= 1) {
                    Service.chatNPC(p, (short) 45, "Ấn Tộc Đã Được Thăng Ấn Không Thể Luyện Ấn");
                    return;
                }
                if (p.c.getBagNull() == 0) {
                    Service.chatNPC(p, (short) 45, "Hành Trang Không Đủ Chổ Trống");
                    return;
                }
                if (p.luong < 1000) {
                    Service.chatNPC(p, (short) 45, "Bạn Không Đủ 1000 Lượng Để Luyện Ấn");
                    return;
                }
                if (p.c.xu < 1000000) {
                    Service.chatNPC(p, (short) 45, "Bạn Không Đủ 1.000.000 Xu Để Luyện Ấn");
                    return;
                }
                Item An = ItemTemplate.itemDefault(839);
                int a = Util.nextInt(1, 8);
                List<Integer> list = new ArrayList<>();
                for (int i = 0; i < Options.length; i++) {
                    list.add(i);
                }
                while (An.options.size() < a) {
                    int index = Util.nextInt(list.size());
                    int indexOption = list.get(index);
                    list.remove(index);
                    An.options.add(new Option(Options[indexOption], (param[indexOption])));
                }
                An.setLock(true);
                p.c.addItemBag(true, An);
                p.c.removeItemBody((byte) 29);
                LichSu.LichSuLuong(p.c.name, p.luong, (p.luong - 1000), "Luyện Ấn", (p.luong - 1000));
                p.upluongMessage(-1000);
                LichSu.LichSuXu(p.c.name, p.c.xu, (p.c.xu - 1000000), "Luyện Ấn", (p.c.xu - 1000000));
                p.c.upxuMessage(-1000000);
                String b = "";
                if (a == 5) {
                    b = "Ngon ! Hi Sinh Vì Đam Mê Chưa Bao Giờ Là Ngu";
                } else if (a >= 2 && a <= 4) {
                    b = "May Mắn Cũng Là 1 Loại Thực Lực , Nếu Không Đủ May Mắn Hãy Nạp !";
                } else {
                    b = "Chỉ Số Mạnh Hay Yếu Phụ Thuộc Vào Nhân Phẩm Của Bạn !";
                }
                Service.chatNPC(p, (short) 45, b);
                break;
            case 1:
                Item item = p.c.ItemBody[29];
                if (item == null || item.id != 839) {
                    Service.chatNPC(p, (short) 45, "Hãy Mang Ấn Tộc Vào Mới Được Thăng Ấn.");
                    return;
                }
                if (item.upgrade == 16) {
                    Service.chatNPC(p, (short) 45, "Ấn Tộc Đã Đạt Cấp Tối Đa.");
                    return;
                }
                if (p.luong < Luong[item.upgrade]) {
                    Service.chatNPC(p, (short) 45, "Bạn Không Đủ Lượng Để Thăng Ấn");
                    return;
                }
                if (p.c.xu < Xu[item.upgrade]) {
                    Service.chatNPC(p, (short) 45, "Bạn Không Đủ Xu Để Thăng Ấn");
                    return;
                }
                if (p.c.quantityItemyTotal(840) < 5 * item.upgrade) {
                    ItemTemplate data = ItemTemplate.ItemTemplateId(840);
                    p.conn.sendMessageLog("Bạn không đủ " + 5 * item.upgrade + " " + data.name + " Để Thăng Ấn");
                    return;
                }
                ItemTemplate data = ItemTemplate.ItemTemplateId(item.id);
                Service.startYesNoDlg(p, (byte) 29,
                        "Bạn có muốn nâng cấp " + data.name + " cấp " + (item.upgrade + 1) + " Với " + Luong[item.upgrade]
                        + " Lượng và " + Xu[item.upgrade] + " Xu Và " + (item.upgrade) * 5 + " Đá Thăng Ấn Với tỷ lệ thành công là "
                        + Tile[item.upgrade] + "% không?");
                break;
            case 2: {
                Item Item = p.c.get().ItemBody[29];
                if (Item == null) {
                    Service.chatNPC(p, (short) 45, "Bạn phải mặc Ấn Tộc lên người trước");
                    return;
                }
                Service.startYesNoDlg(p, (byte) -5, "Bạn Có Muốn Xóa Ấn Tộc Đang Mặc Trên Người Không. Ấn Đồng Ý Ấn Tộc Sẽ Mất Vĩnh Viễn");
                break;
            }
            case 3:
                Server.manager.sendTB(p,
                        "Hướng dẫn",
                        "- Để Tham Gia Chức Năng Ấn Tộc Con Cần Có Ấn Tộc  \n"
                        + "- Ấn Tộc Sẽ Được Bán Tại Shop Gia Tộc Với Giá 100.000.000 Xu \n"
                        + "- Gia Tộc Đạt Cấp 30 Trở Lên Mới Có Thể Mua Ấn Tộc \n"
                        + "- Để Luyện Ấn Tộc Con Cần Có 1000 Lượng Và 1.000.000 Xu\n"
                        + "- Khi Luyện Ấn Sẽ Nhận Được Random 1 Đến 8 Chỉ Số Ngẫu Nhiên \n"
                        + "- Nếu May Mắn Sẽ Nhận Được Chỉ Số Ngon \n"
                        + "- Để Thăng Ấn Con Cần Có Đá Thăng Ấn \n"
                        + "- Khi Thăng Ấn Con Cần Phải Bỏ Ra 1 Ít Lượng Xu Và 1 Số Đá Thăng Ấn \n"
                        + "- Thăng Ấn Càng Cao Số Lượng Và Đá Thăng Ấn Sẽ Tăng Theo \n"
                        + "- Khi Thăng Ấn Sẽ Được Tăng Chỉ Số Của Ấn \n"
                        + "- Khi Ấn Đạt Cấp 14 Trở Lên Sẽ Có Hào Quang \n"
                );
                break;
        }
    }

    public static void UpgradeAnToc(Player p) {
        Item item = p.c.ItemBody[29];
        LichSu.LichSuLuong(p.c.name, p.luong, (p.luong - Luong[item.upgrade]), "Thăng Ấn", -Luong[item.upgrade]);
        LichSu.LichSuXu(p.c.name, p.c.xu, (p.c.xu - Xu[item.upgrade]), "Thăng Ấn", -Xu[item.upgrade]);
        p.upluongMessage(-Luong[item.upgrade]);
        p.c.upxuMessage(-Xu[item.upgrade]);
        p.c.removeItemBags(840, (5 * item.upgrade));
        if (Tile[item.upgrade] >= Util.nextInt(111)) {
            for (byte k = 0; k < item.options.size(); ++k) {
                Option option = item.options.get(k);
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
                if (option.id == 58 || option.id == 79 || option.id == 98) {
                    Option ops = option;
                    ops.param += 1;
                }
                if (option.id == 67) {
                    Option ops = option;
                    ops.param += 6;
                }
            }
            item.upgrade = (byte) (item.upgrade + 1);
            item.isLock = true;
            p.c.addItemBag(true, item);
            Service.chatNPC(p, (short) 45, "Thăng Ấn Thành Công");
            p.c.removeItemBody((byte) 29);
        } else {
            Service.chatNPC(p, (short) 45, "Thăng Ấn Thất Bại");
        }
    }

}

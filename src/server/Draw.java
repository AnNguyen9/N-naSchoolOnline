 package server;

import Menu.MenuAdmin;
import Menu.Send;
import Menu.Swap;
import Menu.SwapEvent;
import assembly.Char;
import stream.Server;
import assembly.ClanManager;
import assembly.Player;
import io.Message;
import io.Util;

import java.io.IOException;
import stream.Client;

public class Draw {

    public static void Draw(Player p, Message m) throws IOException {
        short menuId = m.reader().readShort();
        String str = m.reader().readUTF();
        m.cleanup();
        //   System.out.println("menuId "+menuId+" str "+str);
        byte b = -1;
        try {
            b = m.reader().readByte();
        } catch (IOException e) {
        }
        m.cleanup();

        switch (menuId) {
            case -1: {
                SwapEvent.Lamhopbanhthuong(p, str);
                break;
            }
            case -2: {
                SwapEvent.Lamhopbanhthuonghang(p, str);
                break;
            }
            case -19: {
                SwapEvent.Lamkeotao(p, str);
                break;
            }
            case -20: {
                SwapEvent.Lamhopmaquy(p, str);
                break;
            }
            // vòng xoay
            case 100: {
                try {
                    String num = str.replaceAll(" ", "").trim();
                    if (num.length() > 10 || !Util.checkNumInt(num) || b < 0 || b >= Server.manager.rotationluck.length) {
                        return;
                    }
                    int xujoin = Integer.parseInt(num);
                    Server.manager.rotationluck[b].joinLuck(p, xujoin);
                } catch (Exception e) {
                    p.conn.sendMessageLog("Không hợp lệ");
                }
                break;
            }
            case 101: {
                if (b < 0) {
                    return;
                }
                if (b == 0 && p.c.isTaskDanhVong == 1 && p.c.taskDanhVong[0] == 0 && p.c.taskDanhVong[1] < p.c.taskDanhVong[2]) {
                    p.c.taskDanhVong[1]++;
                }
                if (b == 1 && p.c.isTaskDanhVong == 1 && p.c.taskDanhVong[0] == 1 && p.c.taskDanhVong[1] < p.c.taskDanhVong[2]) {
                    p.c.taskDanhVong[1]++;
                }
                Server.manager.rotationluck[b].luckMessage(p);
                break;
            }
            case 102: {
                p.typemenu = 92;
                Menu.doMenuArray(p, new String[]{"Vòng Xoay VIP", "Vòng Xoay Thường"});
                break;
            }
            case 1: {
                Swap.VanBienLenh(p, m, str);
                break;
            }
            case 2: {
                Swap.MoiLoiDai(p, m, str);
                break;
            }
            case 3: {
                Swap.DatCuocLoiDai(p, m, str);
                break;
            }
            case 4: {
                Swap.GiftCode(p, m, str);
                break;
            }
            //Mời gia tộc chiến
            case 5: {
                Swap.MoiGiaTocChien(p, m, str);
                break;
            }
            //Đặt cược gia tộc chiến
            case 8: {
                Swap.DatCuocGiaTocChien(p, m, str);
                break;
            }
            //Đổi coin => lượng
            case 9: {
                Swap.DoiCoinRaLuong(p, m, str);
                break;
            }
             case 10: {
                Swap.DoiCoinRaXu(p, m, str);
                break;
            }
//            case 10: {
//                Swap.DoiLuongRaXu(p, m, str);
//                break;
//            }
            case 11: {
                Swap.DoiLuongRaYen(p, m, str);
                break;
            }
            case 50: {
                try {
                    ClanManager.createClan(p, str);
                } catch (Exception e) {
                    p.conn.sendMessageLog("Không hợp lệ");
                }
                break;
            }

            case 9990: {
                MenuAdmin.ThayDoiExp(p, m, str);
                break;
            }
            //Thong bao
            case 9991: {
                MenuAdmin.DangThongBao(p, m, str);
                break;
            }
            //kỹ năng
            case 9992: {
                MenuAdmin.CongKyNang(p, m, str);
                break;
            }
            //tiềm năng
            case 9993: {
                MenuAdmin.CongTiemNang(p, m, str);
                break;
            }
            //tăng level
            case 9994: {
                MenuAdmin.TangLevel(p, m, str);
                break;
            }

            //tăng lượng
            case 9995: {
                MenuAdmin.TangLuong(p, m, str);
                break;
            }

            //tăng xu
            case 9996: {
                MenuAdmin.TangXu(p, m, str);
                break;
            }
            //tăng yên
            case 9997: {
                MenuAdmin.TangYen(p, m, str);
                break;
            }

            //bảo trì
            case 9998: {
                MenuAdmin.BaoTri(p, m, str);
                break;
            }

            //khoá tài khoản
            case 9999: {
                MenuAdmin.KhoaTaiKhoan(p, m, str);
                break;
            }
            
            case 555: {
                try {
                    int num = Integer.parseInt(str);
                    if (num < 1 || num > 100000000) {
                        //thông báo
                        p.conn.sendMessageLog("Cược Tối Đa 100.000.000 Xu");
                        return;
                    }
                    int jointai = Integer.parseInt(str);
                    if (jointai % 10 != 0) {
                        p.conn.sendMessageLog("Số Tiền Cược Phải Chia Hết Cho 10.");
                        return;
                    }
                    Server.manager.TaiXiu[0].joinTai(p, jointai);
                } catch (NumberFormatException e) {
                    p.conn.sendMessageLog("Không Xác Định.");
                }
                break;
            }
            case 556: {
                try {
                    int num = Integer.parseInt(str);
                    if (num < 1 || num > 100000000) {
                        //thông báo
                        p.conn.sendMessageLog("Cược Tối Đa 100.000.000 Xu");
                        return;
                    }
                    int joinxiu = Integer.parseInt(str);
                    if (joinxiu % 10 != 0) {
                        p.conn.sendMessageLog("Số Tiền Cược Phải Chia Hết Cho 10.");
                        return;
                    }
                    Server.manager.TaiXiu[0].joinXiu(p, joinxiu);
                } catch (NumberFormatException e) {
                    p.conn.sendMessageLog("Không Xác Định.");
                }
                break;
            }
            case 1010:
                try {
                    p.nameUS = str;
                    Char a1 = Client.gI().getNinja(str);
                    if (a1 != null) {
                        Menu.sendWrite(p, (short) 1011, "Nhập lượng:");
                    } else {
                        p.sendAddchatYellow("Nhân vật này không tồn tại hoặc không online.");
                    }
                } catch (Exception e) {
                    p.conn.sendMessageLog("Không hợp lệ");
                }
                break;
            case 1011:
                try {
                    p.luongGF = str;
                    Send.sendLuong(p);
                } catch (Exception e) {
                    p.conn.sendMessageLog("Không hợp lệ");
                }
                break;
            case 1012:
                try {
                    p.nameUS = str;
                    Char a2 = Client.gI().getNinja(str);
                    if (a2 != null) {
                        Menu.sendWrite(p, (short) 1013, "Nhập xu:");
                    } else {
                        p.sendAddchatYellow("Nhân vật này không tồn tại hoặc không online.");
                    }
                } catch (Exception e) {
                    p.conn.sendMessageLog("Không hợp lệ");
                }
                break;
            case 1013:
                try {
                    p.xuGF = str;
                    Send.sendXu(p);
                } catch (Exception e) {
                    p.conn.sendMessageLog("Không hợp lệ");
                }
                break;
            default: {
                break;
            }
        }

    }
}

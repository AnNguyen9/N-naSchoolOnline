package Task;

import History.LichSu;
import assembly.Char;
import assembly.Item;
import assembly.Mob;
import assembly.Option;
import io.Util;
import server.GameCanvas;
import server.Manager;
import server.Service;
import template.ItemTemplate;

public class Task {

    public static void Task(final Char c, final short npcId) {
        // Nhan nhiem vu
        switch (c.taskId) {
            case 0:
                Service.openUIConfirm(c, npcId, Talk.getTask(0, 0), new String[]{Text.get(0, 10), Text.get(0, 11)});
                break;
            case 1:
                Service.openUIConfirm(c, npcId, Talk.getTask(0, 7), new String[]{Text.get(0, 10), Text.get(0, 11)});
                break;
            case 2:
                Service.openUIConfirm(c, npcId, Talk.getTask(0, 27), new String[]{Text.get(0, 10), Text.get(0, 11)});
                break;
            case 3:
                Service.openUIConfirm(c, npcId, Talk.getTask(0, 30), new String[]{Text.get(0, 10), Text.get(0, 11)});
                break;
            case 4:
                Service.openUIConfirm(c, npcId, Talk.getTask(0, 35), new String[]{Text.get(0, 10), Text.get(0, 11)});
                break;
            case 5:
                Service.openUIConfirm(c, npcId, Talk.getTask(0, 38), new String[]{Text.get(0, 10), Text.get(0, 11)});
                break;
            case 6:
                Service.openUIConfirm(c, npcId, Talk.getTask(0, 41), new String[]{Text.get(0, 10), Text.get(0, 11)});
                break;
            case 7:
                Service.openUIConfirm(c, npcId, Talk.getTask(0, 44), new String[]{Text.get(0, 10), Text.get(0, 11)});
                break;
            case 8:
                Service.openUIConfirm(c, npcId, Talk.getTask(0, 110), new String[]{Text.get(0, 10), Text.get(0, 11)});
                break;
            case 9: {
                Service.openUIConfirm(c, npcId, Talk.getTask(0, 110), new String[]{Text.get(0, 10), Text.get(0, 11)});
                break;
            }
            case 10: {
                Service.openUIConfirm(c, npcId, "Hãy nhận nhiệm vụ đi con",
                        new String[]{Text.get(0, 10), Text.get(0, 11)});
                break;
            }
            default:
                Service.openUIConfirm(c, npcId, "Hãy nhận nhiệm vụ đi con",
                        new String[]{Text.get(0, 10), Text.get(0, 11)});
                break;

        }
    }

    public static void doTask(final Char c, final short npcId, final byte menuId, final byte optionId) {
        if (c.taskId == 1) {
            switch (c.taskIndex) {
                case 0:
                    Service.openUIConfirm(c, npcId, Talk.getTask(0, 12), new String[]{Talk.getTask(0, 17), Talk.getTask(0, 18), Talk.getTask(0, 19)});
                    break;
                case 1:
                    Service.openUIConfirm(c, npcId, Talk.getTask(0, 13), new String[]{Talk.getTask(0, 19), Talk.getTask(0, 20), Talk.getTask(0, 18)});
                    break;
                case 2:
                    Service.openUIConfirm(c, npcId, Talk.getTask(0, 14), new String[]{Talk.getTask(0, 18), Talk.getTask(0, 17), Talk.getTask(0, 21)});
                    break;
                case 3:
                    Service.openUIConfirm(c, npcId, Talk.getTask(0, 15), new String[]{Talk.getTask(0, 22), Talk.getTask(0, 18), Talk.getTask(0, 23)});
                    break;
                case 4:
                    Service.openUIConfirm(c, npcId, Talk.getTask(0, 16), new String[]{Talk.getTask(0, 20), Talk.getTask(0, 23), Talk.getTask(0, 19)});
                    break;
                default:
                    break;
            }
        } else if (c.taskId == 7) {
            switch (c.taskIndex) {
                case 1:
                    Service.openUIConfirm(c, npcId, Talk.getTask(0, 49), new String[]{Talk.getTask(0, 46), Talk.getTask(0, 47), Talk.getTask(0, 48)});
                    break;
                case 2:
                    Service.openUIConfirm(c, npcId, Talk.getTask(0, 50), new String[]{Talk.getTask(0, 51), Talk.getTask(0, 52), Talk.getTask(0, 53)});
                    break;
                case 3:
                    Service.openUIConfirm(c, npcId, Talk.getTask(0, 54), new String[]{Talk.getTask(0, 55), Talk.getTask(0, 56), Talk.getTask(0, 57)});
                    break;
                case 4:
                    Service.openUIConfirm(c, npcId, Talk.getTask(0, 58), new String[]{Talk.getTask(0, 59), Talk.getTask(0, 60), Talk.getTask(0, 61)});
                    break;
                case 5:
                    Service.openUIConfirm(c, npcId, Talk.getTask(0, 62), new String[]{Talk.getTask(0, 63), Talk.getTask(0, 64), Talk.getTask(0, 65)});
                    break;
                case 6:
                    Service.openUIConfirm(c, npcId, Talk.getTask(0, 67), new String[]{Talk.getTask(0, 68), Talk.getTask(0, 69), Talk.getTask(0, 70)});
                    break;
                case 7:
                    Service.openUIConfirm(c, npcId, Talk.getTask(0, 71), new String[]{Talk.getTask(0, 72), Talk.getTask(0, 73), Talk.getTask(0, 74)});
                    break;
                case 8:
                    Service.openUIConfirm(c, npcId, Talk.getTask(0, 75), new String[]{Talk.getTask(0, 76), Talk.getTask(0, 77), Talk.getTask(0, 78)});
                    break;
                case 9:
                    Service.openUIConfirm(c, npcId, Talk.getTask(0, 79), new String[]{Talk.getTask(0, 80), Talk.getTask(0, 81), Talk.getTask(0, 82)});
                    break;
                case 10:
                    Service.openUIConfirm(c, npcId, Talk.getTask(0, 83), new String[]{Talk.getTask(0, 84), Talk.getTask(0, 85), Talk.getTask(0, 86)});
                    break;
                case 11:
                    Service.openUIConfirm(c, npcId, Talk.getTask(0, 88), new String[]{Talk.getTask(0, 89), Talk.getTask(0, 90), Talk.getTask(0, 91)});
                    break;
                case 12:
                    Service.openUIConfirm(c, npcId, Talk.getTask(0, 92), new String[]{Talk.getTask(0, 93), Talk.getTask(0, 94), Talk.getTask(0, 95)});
                    break;
                case 13:
                    Service.openUIConfirm(c, npcId, Talk.getTask(0, 96), new String[]{Talk.getTask(0, 97), Talk.getTask(0, 98), Talk.getTask(0, 99)});
                    break;
                case 14:
                    Service.openUIConfirm(c, npcId, Talk.getTask(0, 100), new String[]{Talk.getTask(0, 101), Talk.getTask(0, 102), Talk.getTask(0, 103)});
                    break;
                case 15:
                    Service.openUIConfirm(c, npcId, Talk.getTask(0, 104), new String[]{Talk.getTask(0, 105), Talk.getTask(0, 106), Talk.getTask(0, 107)});
                    break;
                default:
                    break;
            }
        }
    }

    public static void FinishTask(final Char c, final short npcId) {
        switch (c.taskId) {
            case 0:
                Service.openUISay(c, npcId, Talk.getTask(0, 9));
                c.p.updateExp(200);
                c.upyenMessage(10000);
                break;
            case 1:
                if (c.getBagNull() < 1) {
                    GameCanvas.startOKDlg(c.p.conn, Text.get(0, 15));
                    return;
                }
                Service.openUISay(c, npcId, Talk.getTask(0, 26));
                c.p.updateExp(400);
                c.upyenMessage(10000);
                Item itemup = ItemTemplate.itemDefault(194);
                itemup.isLock = true;
                itemup.options.add(new Option(0, Util.nextInt(5, 10)));
                itemup.options.add(new Option(1, Util.nextInt(5, 10)));
                c.addItemBag(false, itemup);
                break;
            case 2:
                Service.openUISay(c, npcId, Talk.getTask(0, 28));
                c.p.updateExp(600);
                c.upyenMessage(10000);
                break;
            case 3:
                Service.openUISay(c, npcId, Talk.getTask(0, 34));
                c.p.updateExp(800);
                c.upyenMessage(10000);
                break;
            case 4:
                if (c.getBagNull() < 1) {
                    GameCanvas.startOKDlg(c.p.conn, Text.get(0, 15));
                    return;
                }
                Service.openUISay(c, npcId, Talk.getTask(0, 37));
                c.p.updateExp(1000);
                c.upyenMessage(10000);
                break;
            case 5:
                if (c.getBagNull() < 2) {
                    GameCanvas.startOKDlg(c.p.conn, Text.get(0, 15));
                    return;
                }
                Service.openUISay(c, npcId, Talk.getTask(0, 40));
                c.p.updateExp(1000);
                c.upyenMessage(10000);
                break;
            case 6:
                Service.openUISay(c, npcId, Talk.getTask(0, 43));
                c.p.updateExp(1200);
                c.upyenMessage(10000);
                break;
            case 7:
                if (c.getBagNull() < 1) {
                    GameCanvas.startOKDlg(c.p.conn, Text.get(0, 15));
                    return;
                }
                Service.openUISay(c, npcId, Talk.getTask(0, 43));
                c.p.updateExp(1000);
                LichSu.LichSuLuong(c.name, c.p.luong, (c.p.luong + 50), "Nhiệm vụ chính tuyến", +50);
                c.p.upluongMessage(100);
                c.upyenMessage(10000);
                break;
            case 8:
                if (c.getBagNull() < 1) {
                    GameCanvas.startOKDlg(c.p.conn, Text.get(0, 15));
                    return;
                }
                Service.openUISay(c, npcId, Talk.getTask(0, 115));
                c.p.updateExp(30000);
                c.upyenMessage(1000000);
                c.addItemBag(true, ItemTemplate.itemDefault(222, true));
                break;
            case 16:
                if (c.getBagNull() < 1) {
                    GameCanvas.startOKDlg(c.p.conn, Text.get(0, 15));
                    return;
                }
                Service.openUISay(c, npcId, Talk.getTask(0, 115));
                c.p.updateExp(30000);
                c.p.upluongMessage(100);
                c.upyenMessage(1000000);
                c.addItemBag(true, ItemTemplate.itemDefault(223, true));
                break;
            case 20:
                if (c.getBagNull() < 1) {
                    GameCanvas.startOKDlg(c.p.conn, Text.get(0, 15));
                    return;
                }
                LichSu.LichSuLuong(c.name, c.p.luong, (c.p.luong + 50), "Nhiệm vụ chính tuyến", +50);
                c.p.upluongMessage(100);
                c.addItemBag(true, ItemTemplate.itemDefault(224, true));
                break;
            case 24:
                if (c.getBagNull() < 1) {
                    GameCanvas.startOKDlg(c.p.conn, Text.get(0, 15));
                    return;
                }
                LichSu.LichSuLuong(c.name, c.p.luong, (c.p.luong + 50), "Nhiệm vụ chính tuyến", +50);
                c.p.upluongMessage(100);
                c.addItemBag(true, ItemTemplate.itemDefault(225, true));
                break;
            case 27:
                if (c.getBagNull() < 1) {
                    GameCanvas.startOKDlg(c.p.conn, Text.get(0, 15));
                    return;
                }
                LichSu.LichSuLuong(c.name, c.p.luong, (c.p.luong + 50), "Nhiệm vụ chính tuyến", +50);
                c.p.upluongMessage(100);
                c.addItemBag(true, ItemTemplate.itemDefault(226, true));
                break;
            case 32:
                if (c.getBagNull() < 1) {
                    GameCanvas.startOKDlg(c.p.conn, Text.get(0, 15));
                    return;
                }
                LichSu.LichSuLuong(c.name, c.p.luong, (c.p.luong + 50), "Nhiệm vụ chính tuyến", +50);
                c.p.upluongMessage(100);
                c.addItemBag(true, ItemTemplate.itemDefault(227, true));
                break;
            case 42:
                if (c.getBagNull() < 1) {
                    GameCanvas.startOKDlg(c.p.conn, Text.get(0, 15));
                    return;
                }
                LichSu.LichSuLuong(c.name, c.p.luong, (c.p.luong + 50), "Nhiệm vụ chính tuyến", +50);
                c.p.upluongMessage(100);
                c.addItemBag(true, ItemTemplate.itemDefault(228, true));
                break;
            default:
                c.upxuMessage(50000);
                LichSu.LichSuLuong(c.name, c.p.luong, (c.p.luong + 50), "Nhiệm vụ chính tuyến", +50);
                c.p.upluongMessage(100);
                break;
        }
        c.uptaskMaint();
        c.clearTask();
    }

    public static void getTask(final Char c, final byte npcId, final byte menuId, final byte optionId) {
        if (menuId == 0 && c.taskIndex == -1) {
            c.taskIndex = 0;
            Service.getTask(c);
            switch (c.taskId) {
                case 0:
                    Service.openUISay(c, npcId, Talk.getTask(0, 8));
                    break;
                case 1:
                    Service.openUISay(c, npcId, Talk.getTask(0, 10));
                    break;
                case 2:
                    Service.openUISay(c, npcId, Talk.getTask(0, 28));
                    if (c.ItemBody[1] != null) {
                        c.uptaskMaint();
                    }
                    break;
                case 3:
                    Service.openUISay(c, npcId, Talk.getTask(0, 31));
                    break;
                case 4:
                    Service.openUISay(c, npcId, Talk.getTask(0, 36));
                    break;
                case 5:
                    Service.openUISay(c, npcId, Talk.getTask(0, 39));
                    break;
                case 6:
                    Service.openUISay(c, (short) npcId, Talk.getTask(0, 42));
                    break;
                case 7:
                    Service.openUISay(c, (short) npcId, Talk.getTask(0, 45));
                    break;
                case 8:
                    Service.openUISay(c, (short) npcId, Talk.getTask(0, 111));
                    break;
                case 15:
                    Item Itemup = ItemTemplate.itemDefault(214);
                    Itemup.quantity = 3;
                    Itemup.isLock = true;
                    c.addItemBag(true, Itemup);
                    break;
                case 19:
                    Item Itemup1 = ItemTemplate.itemDefault(219);
                    Itemup1.quantity = 50;
                    Itemup1.isLock = true;
                    c.addItemBag(true, Itemup1);
                    break;
                case 23:
                    c.addItemBag(true, ItemTemplate.itemDefault(231, true));
                    break;
                case 24:
                    c.addItemBag(true, ItemTemplate.itemDefault(234, true));
                    break;
                case 32:
                    c.addItemBag(true, ItemTemplate.itemDefault(266, true));
                    break;
                case 35:
                    Item Itemup2 = ItemTemplate.itemDefault(219);
                    Itemup2.quantity = 150;
                    Itemup2.isLock = true;
                    c.addItemBag(true, Itemup2);
                    break;
                case 40:
                    Item Itemup3 = ItemTemplate.itemDefault(288);
                    Itemup3.quantity = 10;
                    Itemup3.isLock = true;
                    c.addItemBag(true, Itemup3);
                    break;
            }
            requestLevel(c);
        } else if (c.taskId == 1) {
            switch (c.taskIndex) {
                case 0:
                    if (menuId == 1) {
                        c.uptaskMaint();
                        Service.openUIConfirm(c, npcId, Talk.getTask(0, 13), new String[]{Talk.getTask(0, 19), Talk.getTask(0, 20), Talk.getTask(0, 18)});
                    } else {
                        Service.openUIConfirm(c, npcId, String.format(Talk.getTask(0, 24), new Object[]{Talk.getTask(0, 12)}), new String[]{Talk.getTask(0, 17), Talk.getTask(0, 18), Talk.getTask(0, 19)});
                    }
                    break;
                case 1:
                    if (menuId == 0) {
                        c.uptaskMaint();
                        Service.openUIConfirm(c, (short) npcId, Talk.getTask(0, 14), new String[]{Talk.getTask(0, 18), Talk.getTask(0, 17), Talk.getTask(0, 21)});
                    } else {
                        Service.openUIConfirm(c, (short) npcId, String.format(Talk.getTask(0, 24), new Object[]{Talk.getTask(0, 13)}), new String[]{Talk.getTask(0, 19), Talk.getTask(0, 20), Talk.getTask(0, 18)});
                    }
                    break;
                case 2:
                    if (menuId == 1) {
                        c.uptaskMaint();
                        Service.openUIConfirm(c, (short) npcId, Talk.getTask(0, 15), new String[]{Talk.getTask(0, 22), Talk.getTask(0, 18), Talk.getTask(0, 23)});
                    } else {
                        Service.openUIConfirm(c, (short) npcId, String.format(Talk.getTask(0, 24), new Object[]{Talk.getTask(0, 14)}), new String[]{Talk.getTask(0, 18), Talk.getTask(0, 17), Talk.getTask(0, 21)});
                    }
                    break;
                case 3:
                    if (menuId == 2) {
                        c.uptaskMaint();
                        Service.openUIConfirm(c, (short) npcId, Talk.getTask(0, 16), new String[]{Talk.getTask(0, 20), Talk.getTask(0, 23), Talk.getTask(0, 19)});
                    } else {
                        Service.openUIConfirm(c, (short) npcId, String.format(Talk.getTask(0, 24), new Object[]{Talk.getTask(0, 15)}), new String[]{Talk.getTask(0, 22), Talk.getTask(0, 18), Talk.getTask(0, 23)});
                    }
                    break;
                case 4:
                    if (menuId == 0) {
                        c.uptaskMaint();
                        Service.openUISay(c, (short) npcId, Talk.getTask(0, 25));
                    } else {
                        Service.openUIConfirm(c, (short) npcId, String.format(Talk.getTask(0, 24), new Object[]{Talk.getTask(0, 16)}), new String[]{Talk.getTask(0, 20), Talk.getTask(0, 23), Talk.getTask(0, 19)});
                    }
                    break;
                default:
                    break;
            }
        } else if (c.taskId == 7) {
            switch (c.taskIndex) {
                case 1:
                    if (menuId == 1) {
                        c.uptaskMaint();
                        Service.openUIConfirm(c, (short) npcId, Talk.getTask(0, 50), new String[]{Talk.getTask(0, 51), Talk.getTask(0, 52), Talk.getTask(0, 53)});
                    } else {
                        Service.openUIConfirm(c, (short) npcId, String.format(Talk.getTask(0, 24), new Object[]{Talk.getTask(0, 49)}), new String[]{Talk.getTask(0, 46), Talk.getTask(0, 47), Talk.getTask(0, 48)});
                    }
                    break;
                case 2:
                    if (menuId == 0) {
                        c.uptaskMaint();
                        Service.openUIConfirm(c, (short) npcId, Talk.getTask(0, 54), new String[]{Talk.getTask(0, 55), Talk.getTask(0, 56), Talk.getTask(0, 57)});
                    } else {
                        Service.openUIConfirm(c, (short) npcId, String.format(Talk.getTask(0, 24), new Object[]{Talk.getTask(0, 50)}), new String[]{Talk.getTask(0, 51), Talk.getTask(0, 52), Talk.getTask(0, 53)});
                    }
                    break;
                case 3:
                    if (menuId == 1) {
                        c.uptaskMaint();
                        Service.openUIConfirm(c, (short) npcId, Talk.getTask(0, 58), new String[]{Talk.getTask(0, 59), Talk.getTask(0, 60), Talk.getTask(0, 61)});
                    } else {
                        Service.openUIConfirm(c, (short) npcId, String.format(Talk.getTask(0, 24), new Object[]{Talk.getTask(0, 54)}), new String[]{Talk.getTask(0, 55), Talk.getTask(0, 56), Talk.getTask(0, 57)});
                    }
                    break;
                case 4:
                    if (menuId == 1) {
                        c.uptaskMaint();
                        Service.openUIConfirm(c, (short) npcId, Talk.getTask(0, 62), new String[]{Talk.getTask(0, 63), Talk.getTask(0, 64), Talk.getTask(0, 65)});
                    } else {
                        Service.openUIConfirm(c, (short) npcId, String.format(Talk.getTask(0, 24), new Object[]{Talk.getTask(0, 58)}), new String[]{Talk.getTask(0, 59), Talk.getTask(0, 60), Talk.getTask(0, 61)});
                    }
                    break;
                case 5:
                    if (menuId == 2) {
                        c.uptaskMaint();
                        Service.openUISay(c, (short) npcId, Talk.getTask(0, 66));
                    } else {
                        Service.openUIConfirm(c, (short) npcId, String.format(Talk.getTask(0, 24), new Object[]{Talk.getTask(0, 62)}), new String[]{Talk.getTask(0, 63), Talk.getTask(0, 64), Talk.getTask(0, 65)});
                    }
                    break;
                case 6:
                    if (menuId == 2) {
                        c.uptaskMaint();
                        Service.openUIConfirm(c, (short) npcId, Talk.getTask(0, 71), new String[]{Talk.getTask(0, 72), Talk.getTask(0, 73), Talk.getTask(0, 74)});
                    } else {
                        Service.openUIConfirm(c, (short) npcId, String.format(Talk.getTask(0, 24), new Object[]{Talk.getTask(0, 67)}), new String[]{Talk.getTask(0, 68), Talk.getTask(0, 69), Talk.getTask(0, 70)});
                    }
                    break;
                case 7:
                    if (menuId == 0) {
                        c.uptaskMaint();
                        Service.openUIConfirm(c, (short) npcId, Talk.getTask(0, 75), new String[]{Talk.getTask(0, 76), Talk.getTask(0, 77), Talk.getTask(0, 78)});
                    } else {
                        Service.openUIConfirm(c, (short) npcId, String.format(Talk.getTask(0, 24), new Object[]{Talk.getTask(0, 71)}), new String[]{Talk.getTask(0, 72), Talk.getTask(0, 73), Talk.getTask(0, 74)});
                    }
                    break;
                case 8:
                    if (menuId == 2) {
                        c.uptaskMaint();
                        Service.openUIConfirm(c, (short) npcId, Talk.getTask(0, 79), new String[]{Talk.getTask(0, 80), Talk.getTask(0, 81), Talk.getTask(0, 82)});
                    } else {
                        Service.openUIConfirm(c, (short) npcId, String.format(Talk.getTask(0, 24), new Object[]{Talk.getTask(0, 75)}), new String[]{Talk.getTask(0, 76), Talk.getTask(0, 77), Talk.getTask(0, 78)});
                    }
                    break;
                case 9:
                    if (menuId == 2) {
                        c.uptaskMaint();
                        Service.openUIConfirm(c, (short) npcId, Talk.getTask(0, 83), new String[]{Talk.getTask(0, 84), Talk.getTask(0, 85), Talk.getTask(0, 86)});
                    } else {
                        Service.openUIConfirm(c, (short) npcId, String.format(Talk.getTask(0, 24), new Object[]{Talk.getTask(0, 79)}), new String[]{Talk.getTask(0, 80), Talk.getTask(0, 81), Talk.getTask(0, 82)});
                    }
                    break;
                case 10:
                    if (menuId == 1) {
                        c.uptaskMaint();
                        Service.openUISay(c, (short) npcId, Talk.getTask(0, 87));
                    } else {
                        Service.openUIConfirm(c, (short) npcId, String.format(Talk.getTask(0, 24), new Object[]{Talk.getTask(0, 83)}), new String[]{Talk.getTask(0, 84), Talk.getTask(0, 85), Talk.getTask(0, 86)});
                    }
                    break;
                case 11:
                    if (menuId == 0) {
                        c.uptaskMaint();
                        Service.openUIConfirm(c, (short) npcId, Talk.getTask(0, 92), new String[]{Talk.getTask(0, 93), Talk.getTask(0, 94), Talk.getTask(0, 95)});
                    } else {
                        Service.openUIConfirm(c, (short) npcId, String.format(Talk.getTask(0, 24), new Object[]{Talk.getTask(0, 88)}), new String[]{Talk.getTask(0, 89), Talk.getTask(0, 90), Talk.getTask(0, 91)});
                    }
                    break;
                case 12:
                    if (menuId == 1) {
                        c.uptaskMaint();
                        Service.openUIConfirm(c, (short) npcId, Talk.getTask(0, 96), new String[]{Talk.getTask(0, 97), Talk.getTask(0, 98), Talk.getTask(0, 99)});
                    } else {
                        Service.openUIConfirm(c, (short) npcId, String.format(Talk.getTask(0, 24), new Object[]{Talk.getTask(0, 92)}), new String[]{Talk.getTask(0, 93), Talk.getTask(0, 94), Talk.getTask(0, 95)});
                    }
                    break;
                case 13:
                    if (menuId == 2) {
                        c.uptaskMaint();
                        Service.openUIConfirm(c, (short) npcId, Talk.getTask(0, 100), new String[]{Talk.getTask(0, 101), Talk.getTask(0, 102), Talk.getTask(0, 103)});
                    } else {
                        Service.openUIConfirm(c, (short) npcId, String.format(Talk.getTask(0, 24), new Object[]{Talk.getTask(0, 96)}), new String[]{Talk.getTask(0, 97), Talk.getTask(0, 98), Talk.getTask(0, 99)});
                    }
                    break;
                case 14:
                    if (menuId == 2) {
                        c.uptaskMaint();
                        Service.openUIConfirm(c, (short) npcId, Talk.getTask(0, 104), new String[]{Talk.getTask(0, 105), Talk.getTask(0, 106), Talk.getTask(0, 107)});
                    } else {
                        Service.openUIConfirm(c, (short) npcId, String.format(Talk.getTask(0, 24), new Object[]{Talk.getTask(0, 100)}), new String[]{Talk.getTask(0, 101), Talk.getTask(0, 102), Talk.getTask(0, 103)});
                    }
                    break;
                case 15:
                    if (menuId == 1) {
                        c.uptaskMaint();
                        Service.openUISay(c, (short) npcId, Talk.getTask(0, 108));
                    } else {
                        Service.openUIConfirm(c, (short) npcId, String.format(Talk.getTask(0, 24), new Object[]{Talk.getTask(0, 104)}), new String[]{Talk.getTask(0, 105), Talk.getTask(0, 106), Talk.getTask(0, 107)});
                    }
                    break;
                default:
                    break;
            }
        }

    }

    public static boolean isTaskNPC(final Char _char, final short npcId) {
        try {
            byte npcID = server.Manager.tasks[_char.taskId][_char.taskIndex + 1];
            if (npcID == -1) {
                npcID = getHieuTruong(_char.nclass);
            }
            return (npcID == npcId);
        } catch (Exception e) {
            return false;
        }
    }

    private static byte getHieuTruong(int nClass) {

        switch (nClass) {
            case 1:
            case 2:
                return 9;
            case 3:
            case 4:
                return 10;
            case 5:
            case 6:
                return 11;
            default:
                break;
        }

        return 0;
    }

    public static boolean isFinishTask(Char c) {
        try {
            return ((Manager.taskTemplates[c.taskId]).subNames.length == c.taskIndex + 1);
        } catch (Exception e) {
            return false;
        }
    }

    public static boolean isExtermination(final Char _char, final Mob mob) {
        switch (mob.templates.id) {
            case 0:
                if (_char.taskId == 2 && _char.taskIndex == 1) {
                    return true;
                }
                break;
            case 1:
                if (_char.taskId == 3 && _char.taskIndex == 2) {
                    return true;
                }
                break;
            case 2:
                if (_char.taskId == 3 && _char.taskIndex == 3) {
                    return true;
                }
                break;
            case 5:
                if (_char.taskId == 10 && _char.taskIndex == 0) {
                    return true;
                }
                break;
            case 6:
                if (_char.taskId == 10 && _char.taskIndex == 1) {
                    return true;
                }
                break;

            case 7:
                if (_char.taskId == 10 && _char.taskIndex == 2) {
                    return true;
                }
                break;
            case 23:
                if (_char.taskId == 16 && _char.taskIndex == 1) {
                    return true;
                }
                break;
            case 24:
                if (_char.taskId == 16 && _char.taskIndex == 2) {
                    return true;
                }
                break;
            case 30:
                if (_char.taskId == 21 && _char.taskIndex == 1) {
                    return true;
                }
                break;
            case 31:
                if (_char.taskId == 21 && _char.taskIndex == 2) {
                    return true;
                }
                break;
            case 37:
                if (_char.taskId == 25 && _char.taskIndex == 1) {
                    return true;
                }
                break;
            case 38:
                if (_char.taskId == 25 && _char.taskIndex == 2) {
                    return true;
                }
                break;
            case 42:
                if (_char.taskId == 28 && _char.taskIndex == 1) {
                    return true;
                }
                break;
            case 43:
                if (_char.taskId == 28 && _char.taskIndex == 2) {
                    return true;
                }
                break;
            case 44:
                if (_char.taskId == 29 && _char.taskIndex == 1 && mob.lvboss == 1) {
                    return true;
                }
                break;
            case 51:
                if (_char.taskId == 33 && _char.taskIndex == 1) {
                    return true;
                }
                break;
            case 52:
                if (_char.taskId == 33 && _char.taskIndex == 2) {
                    return true;
                }
                break;
            case 58:
                if (_char.taskId == 37 && _char.taskIndex == 1 && mob.lvboss == 1) {
                    return true;
                }
                break;
            case 59:
                if (_char.taskId == 37 && _char.taskIndex == 2 && mob.lvboss == 2) {
                    return true;
                }
                break;
            case 169:
                if (_char.taskId == 41 && _char.taskIndex == 1 && mob.lvboss == 1) {
                    return true;
                }
                break;
            case 178:
                if (_char.taskId == 41 && _char.taskIndex == 2 && mob.lvboss == 2) {
                    return true;
                }
                break;

        }
        return false;
    }

    public static void requestLevel(final Char _char) {
        switch (_char.taskId) {
            case 4: {
                if (_char.taskIndex == 0 && _char.level >= 4) {
                    _char.uptaskMaint();
                    break;
                }
                break;
            }
            case 5: {
                if (_char.taskIndex == 0 && _char.level >= 5) {
                    _char.uptaskMaint();
                    break;
                }
                break;
            }
            case 6: {
                if (_char.taskIndex == 0 && _char.level >= 6) {
                    _char.uptaskMaint();
                    break;
                }
                break;
            }
            case 7: {
                if (_char.taskIndex == 0 && _char.level >= 7) {
                    _char.uptaskMaint();
                    break;
                }
                break;
            }
            case 8: {
                if (_char.taskIndex == 0 && _char.level >= 9) {
                    _char.uptaskMaint();
                    break;
                }
                break;
            }
            case 9: {
                if (_char.taskIndex == 0 && _char.level >= 10) {
                    _char.uptaskMaint();
                }
            }
            case 11: {
                if (_char.taskIndex == 0 && _char.level >= 11) {
                    _char.uptaskMaint();
                    break;
                }
                break;
            }
            case 12: {
                if (_char.taskIndex == 0 && _char.level >= 12) {
                    _char.uptaskMaint();
                    break;
                }
                break;
            }
            case 13: {
                if (_char.taskIndex == 0 && _char.level >= 14) {
                    _char.uptaskMaint();
                    break;
                }
                break;
            }
            case 14: {
                if (_char.taskIndex == 0 && _char.level >= 16) {
                    _char.uptaskMaint();
                    break;
                }
                break;
            }
            case 15: {
                if (_char.taskIndex == 0 && _char.level >= 19) {
                    _char.uptaskMaint();
                    break;
                }
                break;
            }
            case 16:
                if (_char.taskIndex == 0 && _char.level >= 22) {
                    _char.uptaskMaint();
                }
                break;
            case 17:
                if (_char.taskIndex == 0 && _char.level >= 25) {
                    _char.uptaskMaint();
                }
                break;
            case 18:
                if (_char.taskIndex == 0 && _char.level >= 26) {
                    _char.uptaskMaint();
                }
                break;
            case 19:
                if (_char.taskIndex == 0 && _char.level >= 27) {
                    _char.uptaskMaint();
                }
                break;
            case 20:
                if (_char.taskIndex == 0 && _char.level >= 28) {
                    _char.uptaskMaint();
                }
                break;
            case 21:
                if (_char.taskIndex == 0 && _char.level >= 30) {
                    _char.uptaskMaint();
                }
                break;
            case 22:
                if (_char.taskIndex == 0 && _char.level >= 32) {
                    _char.uptaskMaint();
                }
                break;
            case 23:
                if (_char.taskIndex == 0 && _char.level >= 35) {
                    _char.uptaskMaint();
                }
                break;
            case 24:
                if (_char.taskIndex == 0 && _char.level >= 36) {
                    _char.uptaskMaint();
                }
                break;
            case 25:
                if (_char.taskIndex == 0 && _char.level >= 37) {
                    _char.uptaskMaint();
                }
                break;
            case 26:
                if (_char.taskIndex == 0 && _char.level >= 38) {
                    _char.uptaskMaint();
                }
                break;
            case 27:
                if (_char.taskIndex == 0 && _char.level >= 39) {
                    _char.uptaskMaint();
                }
                break;
            case 28:
                if (_char.taskIndex == 0 && _char.level >= 41) {
                    _char.uptaskMaint();
                }
                break;
            case 29:
                if (_char.taskIndex == 0 && _char.level >= 43) {
                    _char.uptaskMaint();
                }
                break;
            case 30:
                if (_char.taskIndex == 0 && _char.level >= 44) {
                    _char.uptaskMaint();
                }
                break;
            case 31:
                if (_char.taskIndex == 0 && _char.level >= 45) {
                    _char.uptaskMaint();
                }
                break;
            case 32:
                if (_char.taskIndex == 0 && _char.level >= 49) {
                    _char.uptaskMaint();
                }
                break;
            case 33:
                if (_char.taskIndex == 0 && _char.level >= 51) {
                    _char.uptaskMaint();
                }
                break;
            case 34:
                if (_char.taskIndex == 0 && _char.level >= 53) {
                    _char.uptaskMaint();
                }
                break;
            case 35:
                if (_char.taskIndex == 0 && _char.level >= 55) {
                    _char.uptaskMaint();
                }
                break;
            case 36:
                if (_char.taskIndex == 0 && _char.level >= 57) {
                    _char.uptaskMaint();
                }
                break;
            case 37:
                if (_char.taskIndex == 0 && _char.level >= 59) {
                    _char.uptaskMaint();
                }
                break;
            case 38:
                if (_char.taskIndex == 0 && _char.level >= 61) {
                    _char.uptaskMaint();
                }
                break;
            case 39:
                if (_char.taskIndex == 0 && _char.level >= 63) {
                    _char.uptaskMaint();
                }
                break;
            case 40:
                if (_char.taskIndex == 0 && _char.level >= 65) {
                    _char.uptaskMaint();
                }
                break;
            case 41:
                if (_char.taskIndex == 0 && _char.level >= 69) {
                    _char.uptaskMaint();
                }
                break;
            case 42:
                if (_char.taskIndex == 0 && _char.level >= 70) {
                    _char.uptaskMaint();
                }
                break;

        }
        inMap(_char);
    }

    public static short itemDrop(Char c, Mob mob) {
        switch (c.taskId) {
            case 4:
                if (c.taskIndex == 1 && mob.templates.id == 3) {
                    return 209;
                }
                if (c.taskIndex == 2 && mob.templates.id == 4) {
                    return 210;
                }
                break;
            case 5:
                if (c.taskIndex == 1 && mob.templates.id == 54) {
                    return 211;
                }
                break;
            case 14:
                if (c.taskIndex == 1 && mob.templates.id == 9) {
                    return 212;
                }
                if (c.taskIndex == 2 && mob.templates.id == 15) {
                    return 213;
                }
                break;
            case 18:
                if (c.taskIndex == 1 && mob.templates.id == 26) {
                    return 216;
                }
                if (c.taskIndex == 2 && mob.templates.id == 27) {
                    return 217;
                }
                break;
            case 22:
                if (c.taskIndex == 1 && mob.templates.id == 33) {
                    return 230;
                }
                break;
            case 26:
                if (c.taskIndex == 1 && (mob.templates.id == 39 || mob.templates.id == 40)) {
                    return 236;
                }
                break;
            case 27:
                if (c.taskIndex == 1 && (mob.templates.id == 41)) {
                    return 238;
                }
                break;
            case 31:
                if (c.taskIndex == 1 && (mob.templates.id == 47)) {
                    return 264;
                }
                if (c.taskIndex == 2 && (mob.templates.id == 48)) {
                    return 265;
                }
                break;
            case 34:
                if (c.taskIndex == 1 && mob.templates.id == 53) {
                    return 347;
                }
                break;
            case 36:
                if (c.taskIndex == 1 && mob.templates.id == 57) {
                    return 348;
                }
                break;
            case 38:
                if (c.taskIndex == 1 && mob.templates.id == 60) {
                    return 349;
                }
                if (c.taskIndex == 2 && mob.templates.id == 61) {
                    return 350;
                }
                break;

            default:
        }
        return -1;
    }

    public static boolean itemPick(Char c, short itemTemplateId) {
        switch (c.taskId) {
            case 4:
                if (c.taskIndex == 1 && itemTemplateId == 209) {
                    return true;
                }
                if (c.taskIndex == 2 && itemTemplateId == 210) {
                    return true;
                }
                break;
            case 5:
                if (c.taskIndex == 1 && itemTemplateId == 211) {
                    return true;
                }
                break;
            case 14:
                if (c.taskIndex == 1 && itemTemplateId == 212) {
                    return true;
                }
                if (c.taskIndex == 2 && itemTemplateId == 213) {
                    return true;
                }
                break;
            case 18:
                if (c.taskIndex == 1 && itemTemplateId == 216) {
                    return true;
                }
                if (c.taskIndex == 2 && itemTemplateId == 217) {
                    return true;
                }
                break;
            case 22:
                if (c.taskIndex == 1 && itemTemplateId == 230) {
                    return true;
                }
                break;
            case 26:
                if (c.taskIndex == 1 && itemTemplateId == 236) {
                    return true;
                }
                break;
            case 27:
                if (c.taskIndex == 1 && (itemTemplateId == 238)) {
                    return true;
                }
                break;
            case 31:
                if (c.taskIndex == 1 && (itemTemplateId == 264)) {
                    return true;
                }
                if (c.taskIndex == 2 && (itemTemplateId == 265)) {
                    return true;
                }
                break;
            case 34:
                if (c.taskIndex == 1 && itemTemplateId == 347) {
                    return true;
                }
                break;
            case 36:
                if (c.taskIndex == 1 && itemTemplateId == 348) {
                    return true;
                }
                break;
            case 38:
                if (c.taskIndex == 1 && itemTemplateId == 349) {
                    return true;
                }
                if (c.taskIndex == 2 && itemTemplateId == 350) {
                    return true;
                }
                break;
        }
        return false;
    }

    public static void inMap(final Char _char) {
        switch (_char.taskId) {
            case 6:
                if (_char.taskIndex == 1 && _char.tileMap.map.id == 2) {
                    _char.uptaskMaint();
                    break;
                }
                if (_char.taskIndex == 2 && _char.tileMap.map.id == 71) {
                    _char.uptaskMaint();
                    break;
                }
                if (_char.taskIndex == 3 && _char.tileMap.map.id == 26) {
                    _char.uptaskMaint();
                    break;
                }
                break;
        }
    }

    public static boolean isLockChangeMap(short mapID, byte taskId) {
        if (1 == 1) {
            return false;
        }
        switch (taskId) {
            case 0:
            case 1:
            case 2:
                return (mapID != 22);
            case 3:
            case 4:
                return (mapID != 21 && mapID != 22 && mapID != 23);
            case 5:
                return (mapID != 6 && mapID != 20 && mapID != 21 && mapID != 22 && mapID != 23);
            case 6:
                return (mapID != 2 && mapID != 6 && mapID != 20 && mapID != 21 && mapID != 22 && mapID != 23 && mapID != 25 && mapID != 26 && mapID != 69 && mapID != 70 && mapID != 71);
            case 7:
            case 8:
                return (mapID != 1 && mapID != 2 && mapID != 6 && mapID != 20 && mapID != 21 && mapID != 22 && mapID != 23 && mapID != 25 && mapID != 26 && mapID != 27 && mapID != 69 && mapID != 70 && mapID != 71 && mapID != 72);
        }
        return false;
    }

    public static boolean isLockChangeMap2(short mapID, byte taskId) {
        if (1 == 1) {
            return false;
        }
        switch (taskId) {
            case 0:
            case 1:
            case 2:
            case 3:
            case 4:
            case 5:
            case 6:
            case 7:
            case 8:
                return (mapID == 1 || mapID == 10 || mapID == 17 || mapID == 27 || mapID == 32 || mapID == 38 || mapID == 43 || mapID == 48 || mapID == 72);
        }
        return false;
    }
}

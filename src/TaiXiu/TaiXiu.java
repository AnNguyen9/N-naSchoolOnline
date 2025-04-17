package TaiXiu;

import History.LichSu;
import server.*;
import java.util.ArrayList;
import assembly.Char;
import assembly.Player;
import io.Util;
import stream.Server;

/**
 *
 * @author Tien
 */
public class TaiXiu {

    public int totalxiu;
    public int totaltai;

    public short playertai;
    public short playerxiu;

    public long time;
    public long timewait;

    public boolean start;
    public boolean tai;
    public boolean xiu;

    public long tongrandom;
    public String taiorxiu;

    public ArrayList<Char> teamtai;
    public ArrayList<Char> teamxiu;
    public int canthiep;

    // Khởi tạo
    public TaiXiu() {
        this.totaltai = 0;
        this.totalxiu = 0;
        this.playertai = 0;
        this.playerxiu = 0;
        this.teamtai = new ArrayList<>();
        this.teamxiu = new ArrayList<>();
        this.tai = false;
        this.xiu = false;
        this.time = 60;
        this.start = true;
    }

    //Thông tin kết quả.
    public void InfoTaiXiu(Player p) {
        String text = "Tổng tiền cược Tài : " + this.totaltai + " Xu \n"
                + "Tổng tiền cược Xỉu : " + this.totalxiu + " Xu \n"
                + "Thời gian : " + this.time + " giây\n\n";

        if (taiorxiu != null) {
            text += "Kết quả phiên trước : " + this.taiorxiu + " : " + this.tongrandom + "\n";
        }
        if (!(p.c.Tai == false && p.c.Xiu == false)) {
            text += "\nBạn đã cược " + p.c.Join + " Xu vào " + p.c.TaiXiu;
        } else {
            text += p.c.TaiXiu;
        }
        Server.manager.sendTB(p, "Tài Xỉu", text);
    }

    //random để lấy kết quả
    private void random() {
        long a = Util.nextInt(1, 6);
        long b = Util.nextInt(1, 6);
        long c = Util.nextInt(1, 6);
        ArrayList<Integer> list = new ArrayList<>();
        if (canthiep == 1) { // xỉu
            int at = Util.nextInt(1, 6);
            int tmp = 9 - at;
            if (tmp > 6) {
                tmp = 6;
            }
            int bt = Util.nextInt(1, tmp);
            tmp = 10 - (at + bt);
            if (tmp > 6) {
                tmp = 6;
            }
            int ct = Util.nextInt(1, tmp);
            list.add(at);
            list.add(bt);
            list.add(ct);
        }

        if (canthiep == 2) { // tài
            int at = Util.nextInt(1, 6);
            int tmp = 5 - at;
            if (tmp < 1) {
                tmp = 1;
            }
            int bt = Util.nextInt(tmp, 6);
            tmp = 11 - (at + bt);
            if (tmp < 1) {
                tmp = 1;
            }
            int ct = Util.nextInt(tmp, 6);
            list.add(at);
            list.add(bt);
            list.add(ct);
        }

        if (canthiep != 0) {
            canthiep = 0;
            int index = Util.nextInt(3);
            a = list.get(index);
            list.remove(index);
            index = Util.nextInt(2);
            b = list.get(index);
            list.remove(index);
            c = list.get(0);
            list.clear();
        }

        this.tongrandom = a + b + c;
        if (3 <= this.tongrandom && this.tongrandom <= 10) {
            this.taiorxiu = "Xỉu";
            this.xiu = true;
            this.tai = false;
        } else if (this.tongrandom > 10) {
            this.taiorxiu = "Tài";
            this.tai = true;
            this.xiu = false;
        }
        Manager.serverChat("Thông Báo", "Kết Quả : " + taiorxiu + " : Tổng : " + a + " + " + b + " + " + c + " = " + tongrandom);
        SoiCau.soicau.add(new SoiCau("+ " + taiorxiu, ": Tổng : " + a + " + " + b + " + " + c + " = " + this.tongrandom));
    }

    public void Start() {
        if (this.start == true) {
            if (this.time > 0) {
                this.time -= 1;
            }
            if (this.time == 0) {
                this.start = false;
                this.timewait = 10;
                this.random();
                this.Wait();
            }
        }
    }

    public void Wait() {
        while (this.start == false) {
            if (this.timewait > 0) {
                this.timewait -= 1;
            }
            if (this.tai == true) {
                for (int i = 0; i < this.teamtai.size(); i++) {
                    Char c = this.teamtai.get(i);
                    if (c.Join > 0) {
                        LichSu.LichSuThangTaiXiu(c.name, "Thắng Tài Xỉu", c.xu, (c.xu + c.Join * 18 / 10), +c.Join * 18 / 10);
                        LichSu.LichSuXu(c.name, c.xu, (c.xu + (c.Join * 18 / 10)), "Thắng Tài Xỉu : ", +(c.Join * 18 / 10));
                        c.upxuMessage(c.Join * 18 / 10);
                        c.p.conn.sendMessageLog("Bạn Đã Thắng " + c.Join * 18 / 10 + " Xu");
                        c.Join = 0;
                        c.Tai = false;
                        c.Xiu = false;
                        this.tai = false;
                        c.Data();
                    }
                }
                for (int i = 0; i < this.teamxiu.size(); i++) {
                    Char c = this.teamxiu.get(i);
                    c.Join = 0;
                    c.Xiu = false;
                    c.Tai = false;
                    this.xiu = false;
                    c.Data();
                }
                this.totaltai = 0;
                this.teamtai.clear();
                this.totalxiu = 0;
                this.teamxiu.clear();
            }
            if (this.xiu == true) {
                for (int i = 0; i < this.teamxiu.size(); i++) {
                    Char c = this.teamxiu.get(i);
                    if (c.Join > 0) {
                        LichSu.LichSuThangTaiXiu(c.name, "Thắng Tài Xỉu", c.xu, (c.xu + c.Join * 18 / 10), +c.Join * 18 / 10);
                        LichSu.LichSuXu(c.name, c.xu, (c.xu + (c.Join * 18 / 10)), "Thắng Tài Xỉu : ", +c.Join * 18 / 10);
                        c.upxuMessage(c.Join * 18 / 10);
                        c.p.conn.sendMessageLog("Bạn Đã Thắng " + c.Join * 18 / 10 + " Xu");
                        c.Join = 0;
                        c.Xiu = false;
                        c.Tai = false;
                        this.xiu = false;
                        c.Data();
                    }
                }
                for (int i = 0; i < this.teamtai.size(); i++) {
                    Char c = this.teamtai.get(i);
                    c.Join = 0;
                    c.Tai = false;
                    c.Xiu = false;
                    this.tai = false;
                    c.Data();
                }
                this.totalxiu = 0;
                this.teamxiu.clear();
                this.totaltai = 0;
                this.teamtai.clear();
            }
            if (this.timewait == 0) {
                this.time = 60;
                this.start = true;
                this.Start();
            }
        }
    }

    // đặt cược tài
    public void joinTai(Player p, int JoinTai) {
        if (this.time <= 10L) {
            p.conn.sendMessageLog("Đã hết thời gian đặt cược.");
            return;
        }
        if (JoinTai > p.c.xu || JoinTai <= 0 || ((p.c.xu - JoinTai) < 0)) {
            p.conn.sendMessageLog("Bạn không đủ xu để đặt cược.");
            return;
        }
        if (p.c.Xiu == true || p.c.Tai == true) {
            p.conn.sendMessageLog("Bạn đã đặt cược.");
            return;
        }
        this.totaltai += JoinTai;
        p.c.Join += JoinTai;
        LichSu.LichSuDatTaiXiu(p.c.name, "Đặt Tài", p.c.xu, (p.c.xu - JoinTai), -JoinTai);
        LichSu.LichSuXu(p.c.name, p.c.xu, (p.c.xu - JoinTai), "Đặt Tài : ", -JoinTai);
        p.c.upxuMessage(-JoinTai);
        p.c.Tai = true;
        p.c.Xiu = false;
        this.teamtai.add(p.c);
        p.c.Data();
        Server.manager.TaiXiu[0].InfoTaiXiu(p);
    }

    // đặt cược xỉu
    public void joinXiu(Player p, int JoinXiu) {
        if (this.time <= 10L) {
            p.conn.sendMessageLog("Đã hết thời gian đặt cược.");
            return;
        }
        if (JoinXiu > p.c.xu || JoinXiu <= 0 || ((p.c.xu - JoinXiu) < 0)) {
            p.conn.sendMessageLog("Bạn không đủ xu để đặt cược.");
            return;
        }
        if (p.c.Xiu == true || p.c.Tai == true) {
            p.conn.sendMessageLog("Bạn đã đặt cược.");
            return;
        }
        this.totalxiu += JoinXiu;
        p.c.Join += JoinXiu;
        LichSu.LichSuDatTaiXiu(p.c.name, "Đặt Xỉu", p.c.xu, (p.c.xu - JoinXiu), -JoinXiu);
        LichSu.LichSuXu(p.c.name, p.c.xu, (p.c.xu - JoinXiu), "Đặt Tài : ", -JoinXiu);
        p.c.upxuMessage(-JoinXiu);
        p.c.Xiu = true;
        p.c.Tai = false;
        this.teamxiu.add(p.c);
        p.c.Data();
        Server.manager.TaiXiu[0].InfoTaiXiu(p);
    }
}

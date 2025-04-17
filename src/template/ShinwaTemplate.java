package template;

import assembly.Item;
import java.util.concurrent.atomic.AtomicInteger;

public class ShinwaTemplate {

    public static long _3DAYS = 86400000L;
    public static final AtomicInteger atomicInteger = new AtomicInteger();

    private int id;
    private Item item;
    private long timeStart;
    private int timeEnd;
    private String seller;
    private long price;

    public ShinwaTemplate(Item item, long timeStart, String seller, long price) {
        this.id = atomicInteger.incrementAndGet();
        this.item = item;
        this.timeStart = timeStart;
        this.seller = seller;
        this.price = price;
        this.timeEnd = this.getRemainTime();
    }

    public int getId() {
        return id;
    }
    
    

    public Item getItem() {
        return this.item;
    }

    public long getTimeStart() {
        return this.timeStart;
    }

    public int getTimeEnd() {
        return this.timeEnd;
    }

    public String getSeller() {
        return this.seller;
    }

    public long getPrice() {
        return this.price;
    }

    public void setItem(final Item item) {
        this.item = item;
    }

    public void setTimeStart(final long timeStart) {
        this.timeStart = timeStart;
    }

    public void setTimeEnd(final int timeEnd) {
        this.timeEnd = timeEnd;
    }

    public void setSeller(final String seller) {
        this.seller = seller;
    }

    public void setPrice(final long price) {
        this.price = price;
    }

    public int getRemainTime() {
        return (int) ((ShinwaTemplate._3DAYS - (System.currentTimeMillis() - this.getTimeStart())) / 1000L);
    }

    public boolean isExpired() {
        return System.currentTimeMillis() - this.getTimeStart() >= ShinwaTemplate._3DAYS || this.getRemainTime() <= 0;
    }
}

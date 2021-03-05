import java.time.LocalTime;

public class Museum extends Location implements Visitable, Payable{
    private LocalTime openingTime, closingTime;
    private int ticketPrice;

    public Museum(String name) {
        super(name);
    }

    @Override
    public int getTicketPrice() {
        return ticketPrice;
    }

    @Override
    public LocalTime getOpeningTime() {
        return openingTime;
    }

    @Override
    public LocalTime getClosingTime() {
        return closingTime;
    }

    @Override
    public void setOpeningTime(LocalTime openingTime) {
        this.openingTime = openingTime;
    }

    @Override
    public void setClosingTime(LocalTime closingTime) {
        this.closingTime = closingTime;
    }

    @Override
    public void setTicketPrice(int ticketPrice) {
        this.ticketPrice = ticketPrice;
    }
}

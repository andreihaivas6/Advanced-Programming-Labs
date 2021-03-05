import java.time.LocalTime;

public class Church extends Location implements Visitable{
    private LocalTime openingTime, closingTime;

    public Church(String name) {
        super(name);
    }

    @Override
    public void setOpeningTime(LocalTime openingTime) {
        this.openingTime = openingTime;
    }

    @Override
    public void setClosingTime(LocalTime closingTime) {
        this.closingTime = closingTime;
    }
}

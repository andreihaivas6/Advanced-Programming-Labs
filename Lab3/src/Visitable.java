import java.time.Duration;
import java.time.LocalTime;

public interface Visitable {
    default LocalTime getOpeningTime(){
        return LocalTime.of(9, 30);
        // return LocalTime.parse("9:30");
    }

    default LocalTime getClosingTime(){
        return LocalTime.of(20, 0);
    }

    static Duration getVisitingDuration(LocalTime start, LocalTime end){
        return Duration.between(start, end);
    }

    void setOpeningTime(LocalTime openingTime);
    void setClosingTime(LocalTime closingTime);
}

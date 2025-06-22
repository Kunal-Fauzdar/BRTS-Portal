import java.sql.Time;

public class station {
    String station_name ;
    Time arrival_time;
    station(String station_name , Time arrival_time)
    {
        this.station_name = station_name;
        this.arrival_time = arrival_time;
    }
}

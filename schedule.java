import java.sql.Time;

public class schedule {
    String bus_number;
    String route_name;
    String route_description;
    Time departure_time;
    Time arrival_time;
    public schedule(String bus_number,String route_name,String route_description,Time departure_time,Time arrival_time)
    {
        this.bus_number = bus_number;
        this.route_name = route_name;
        this.route_description = route_description;
        this.departure_time = departure_time;
        this.arrival_time = arrival_time;
    }
    
}

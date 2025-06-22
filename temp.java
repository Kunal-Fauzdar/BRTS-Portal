import java.sql.Statement;

public class temp {
       public static void main(String[] args) {
        System.out.println("Bus Number        Bus Name        Route Name          Route Description                                               "+"\n"+"bus_id"+"           "+"bus_number"+"        "+"route_name"+"          "+"route_description"+"Route Description                                               ");
    }
}

//SELECT  r.route_name , r.route_description , r.route_id FROM routes_table r JOIN Route_Stations rs1 ON r.route_id = rs1.route_id JOIN Route_Stations rs2 ON r.route_id = rs2.route_id WHERE rs1.station_id = 8 AND rs2.station_id = 9 AND  rs1.station_order < rs2.station_order;

import java.util.ArrayList;

public class Station {
    String isim;
    ArrayList<Edge> baglantilar;
    Station(String isim){
        this.isim = isim;
        this.baglantilar = new ArrayList<>();
    }
}

import java.io.File;
import java.util.*;
import java.io.FileNotFoundException;

public class Graph {
    HashMap<String, Station> agHaritasi = new HashMap<>();

    public void haritayiYukle(String dosyaYolu){
        File dosya = new File(dosyaYolu);
        try (Scanner okuyucu = new Scanner(dosya)) {
            while(okuyucu.hasNextLine()){
                String satir = okuyucu.nextLine();
                String[] parcalar = satir.split(",");
                String kaynak_istasyon = parcalar[0].trim();
                String hedef_istasyon = parcalar[1].trim();
                int sure = Integer.parseInt(parcalar[2].trim());

                agHaritasi.putIfAbsent(kaynak_istasyon, new Station(kaynak_istasyon));
                agHaritasi.putIfAbsent(hedef_istasyon, new Station(hedef_istasyon));

                Station gercek_kaynak_istasyon = agHaritasi.get(kaynak_istasyon);
                Station gercek_hedef_istasyon = agHaritasi.get(hedef_istasyon);

                gercek_kaynak_istasyon.baglantilar.add(new Edge(gercek_hedef_istasyon, sure));
                gercek_hedef_istasyon.baglantilar.add(new Edge(gercek_kaynak_istasyon, sure));
            }
        }
        catch(FileNotFoundException e) {
            System.out.println("Dosya bulunamadı...");
        }
    }

    public void enKisaYoluBul(String baslangic, String bitis){
        Station baslangicIstasyonu = agHaritasi.get(baslangic);
        Station bitisIstasyonu = agHaritasi.get(bitis);

        if(baslangicIstasyonu == null || bitisIstasyonu == null){
            System.out.println("Hata: Girdiğiniz durak bulunamadı. Lütfen uzantısıyla (örn: Haliç_M2) doğru yazdığınızdan emin olun.");
            return;
        }

        HashMap<Station, Integer> mesafeTablosu = new HashMap<>();
        for(Station Istasyon : agHaritasi.values()){
            mesafeTablosu.put(Istasyon, Integer.MAX_VALUE);
        }

        mesafeTablosu.put(baslangicIstasyonu, 0);

        HashMap<Station, Station> ebeveynTablosu = new HashMap<>();

        PriorityQueue<Station> oncelikliIstasyonlar = new PriorityQueue<>(
                (istasyon1, istasyon2) -> mesafeTablosu.get(istasyon1) - mesafeTablosu.get(istasyon2)
        );
        oncelikliIstasyonlar.add(baslangicIstasyonu);

        while(!oncelikliIstasyonlar.isEmpty()){
            Station suankiIstasyon = oncelikliIstasyonlar.poll();

            if(suankiIstasyon.equals(bitisIstasyonu)){
                break;
            }
            else{
                for(Edge bagliDurak : suankiIstasyon.baglantilar){
                    int gecenSure = mesafeTablosu.get(suankiIstasyon);
                    gecenSure += bagliDurak.sure;

                    if(gecenSure < mesafeTablosu.get(bagliDurak.gidilen_istasyon)){
                        mesafeTablosu.put(bagliDurak.gidilen_istasyon, gecenSure);
                        ebeveynTablosu.put(bagliDurak.gidilen_istasyon, suankiIstasyon);
                        oncelikliIstasyonlar.add(bagliDurak.gidilen_istasyon);
                    }
                }
            }
        }
        ArrayList<String> gecilenDuraklar = new ArrayList<>();

        Station geziciIstasyon = bitisIstasyonu;
        while(geziciIstasyon != null){
            gecilenDuraklar.add(geziciIstasyon.isim);
            geziciIstasyon = ebeveynTablosu.get(geziciIstasyon);
        }
        Collections.reverse(gecilenDuraklar);
        System.out.println("Toplam Süre: " + mesafeTablosu.get(bitisIstasyonu) + " dakika");

        for(int i = 0 ; i < gecilenDuraklar.size() ; i++){
            System.out.print(gecilenDuraklar.get(i));
            if(i < (gecilenDuraklar.size() - 1)){
                System.out.print("->");
            }
        }
    }
}

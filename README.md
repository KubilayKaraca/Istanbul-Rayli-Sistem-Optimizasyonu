# İstanbul Raylı Sistem Optimizasyonu 🚇

Bu proje, İstanbul'daki karmaşık raylı sistem ağında (Metro ve Marmaray) iki istasyon arasındaki en kısa ve en hızlı rotayı hesaplayan bir Java uygulamasıdır. Algoritma, hatlar arası aktarma sürelerini ve yürüme mesafelerini hesaba katarak **Dijkstra'nın En Kısa Yol Algoritması (Dijkstra's Shortest Path Algorithm)** ile çalışır.

## Özellikler (Features)
* **Gerçekçi Veri Seti:** M1, M2, M3, M4, M5, M6, M7, M8, M9 ve B1 (Marmaray) hatlarının güncel durakları ve seyahat süreleri.
* **Akıllı Aktarma:** Hatlar arası yeraltı/yerüstü yürüyüş süreleri (Edge weight) hesaplamaya dahildir.
* **Optimizasyon:** `PriorityQueue` ve `HashMap` kullanılarak `O(E log V)` zaman karmaşıklığında yüksek performanslı yönlendirme.
* **Hata Toleransı:** Hatalı durak girişlerine ve dosya okuma esnasındaki gizli boşluk karakterlerine karşı güvenli mimari.

## Kullanılan Teknolojiler
* Java (Object-Oriented Programming)
* Veri Yapıları: Graph, Priority Queue, Hash Map, Array List

## Kurulum ve Kullanım (How to Run)
1. Projeyi bilgisayarınıza indirin (Clone).
2. `harita.csv` dosyasının `Main.java` ile aynı veya erişilebilir bir dizinde olduğundan emin olun.
3. Terminal veya IDE üzerinden `Main` sınıfını çalıştırın.
4. Başlangıç ve hedef duraklarını hat uzantılarıyla (Örn: `Haliç_M2`) girin.

**Örnek Çıktı:**
```text
Başlangıç durağını giriniz: Haliç_M2
Hedef durağı giriniz: Acıbadem_M4
Toplam Süre: 23 dakika
Haliç_M2 -> Vezneciler_M2 -> Yenikapı_M2 -> Yenikapı_B1 -> Sirkeci_B1 -> Üsküdar_B1 -> Ayrılık Çeşmesi_B1 -> Ayrılık Çeşmesi_M4 -> Acıbadem_M4

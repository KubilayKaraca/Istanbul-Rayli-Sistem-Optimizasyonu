# 🚇 İstanbul Raylı Sistem Rota Optimizasyonu

![Java](https://img.shields.io/badge/Java-ED8B00?style=for-the-badge&logo=java&logoColor=white)
![Data Structures](https://img.shields.io/badge/Data_Structures-Graphs-blue?style=for-the-badge)
![Algorithm](https://img.shields.io/badge/Algorithm-Dijkstra-success?style=for-the-badge)

Bu proje, İstanbul'daki karmaşık raylı sistem ağında (Metro ve Marmaray) iki istasyon arasındaki en kısa ve en hızlı rotayı hesaplayan, **Nesne Yönelimli Programlama (OOP)** prensipleriyle geliştirilmiş bir Java konsol uygulamasıdır. Algoritma, hatlar arası aktarma sürelerini ve yürüme mesafelerini hesaba katarak **Dijkstra'nın En Kısa Yol Algoritması** ile çalışır.

## 🌟 Öne Çıkan Özellikler

* **Gerçekçi Ağ Haritası:** M1, M2, M3, M4, M5, M6, M7, M8, M9 ve B1 (Marmaray) hatlarının güncel durakları ve istasyonlar arası gerçek seyahat süreleri sisteme entegredir.
* **Akıllı Aktarma Mantığı:** Hatlar arası yeraltı/yerüstü yürüyüş süreleri graf (çizge) yapısında kenar ağırlığı (edge weight) olarak tanımlanmıştır.
* **Yüksek Performans:** `PriorityQueue` (Öncelikli Kuyruk) ve `HashMap` yapıları kullanılarak `O(E log V)` zaman karmaşıklığında hızlı ve bellek dostu rota hesaplaması yapılır.
* **Hata Toleransı (Robustness):** Gizli boşluk karakterlerine (`.trim()`) ve hatalı kullanıcı girişlerine (`NullPointerException` kontrolleri) karşı korumalı ve güvenli mimari.

## 📂 Proje Yapısı

Proje modüler bir yapıda, 4 temel Java sınıfından ve 1 veri dosyasından oluşmaktadır:

* `Station.java`: Graf üzerindeki her bir durağı (düğümü) ve sahip olduğu bağlantıları (kenarları) temsil eden veri yapısı.
* `Edge.java`: İki istasyon arasındaki mesafeyi / seyahat süresini ve yönü tutan bağlantı sınıfı.
* `Graph.java`: Haritanın hafızaya yüklendiği, bağlantıların çift yönlü (bidirectional) kurulduğu ve Dijkstra algoritmasının işletildiği çekirdek sınıf.
* `Main.java`: Kullanıcı etkileşimini sağlayan ve programı başlatan ana sınıf.
* `harita.csv`: Tüm hatların, durakların ve aktarma noktalarının virgülle ayrılmış (CSV) formatta tutulduğu veri seti.

## 🚀 Kurulum ve Kullanım

1. Tüm `.java` dosyalarını aynı dizinde derleyin.
2. `harita.csv` dosyasının derlenen kodlarla aynı dizinde (veya belirtilen yolda) olduğuna emin olun.
3. `Main` sınıfını çalıştırın ve uzantılarıyla birlikte (Örn: `Haliç_M2`) başlangıç ve bitiş durak isimlerini girin.

## 💻 Örnek Çıktı

```text
Başlangıç durağını giriniz: Haliç_M2
Hedef durağı giriniz: Acıbadem_M4
Toplam Süre: 23 dakika
Haliç_M2 -> Vezneciler_M2 -> Yenikapı_M2 -> Yenikapı_B1 -> Sirkeci_B1 -> Üsküdar_B1 -> Ayrılık Çeşmesi_B1 -> Ayrılık Çeşmesi_M4 -> Acıbadem_M4

## 👨‍💻 Geliştirici

Kubilay Karaca

Bahçeşehir Üniversitesi - Bilgisayar Mühendisliği
Github: @KubilayKaraca

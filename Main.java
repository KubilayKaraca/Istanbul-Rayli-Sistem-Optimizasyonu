import java.util.*;
public class Main{
    public static void main(String[] args){
        Graph harita = new Graph();
        harita.haritayiYukle("harita.csv");
        Scanner kullanicidanVeriAl = new Scanner(System.in);
        System.out.print("Başlangıç durağını giriniz: ");
        String baslangic = kullanicidanVeriAl.nextLine();
        System.out.print("Hedef durağı giriniz: ");
        String bitis = kullanicidanVeriAl.nextLine();
        harita.enKisaYoluBul(baslangic, bitis);
    }
}


package hu.petrik.aukcioprojekt;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeFormatterBuilder;

public class Festmeny {
    private String cim;
    private String festo;
    private String stilus;
    private int licitekSzama;
    private int legmagasabbLicit;
    private LocalDateTime legutolsoLicitIdeje;
    private boolean elkelt;

    public Festmeny(String cim, String festo, String stilus) {
        this.cim = cim;
        this.festo = festo;
        this.stilus = stilus;
        this.licitekSzama = 0;
        this.legmagasabbLicit = 0;
        this.elkelt = false;
    }

    public String getCim() {
        return cim;
    }

    public String getFesto() {
        return festo;
    }

    public String getStilus() {
        return stilus;
    }

    public int getLicitekSzama() {
        return licitekSzama;
    }

    public int getLegmagasabbLicit() {
        return legmagasabbLicit;
    }

    public LocalDateTime getLegutolsoLicitIdeje() {
        return legutolsoLicitIdeje;
    }

    public boolean isElkelt() {
        return elkelt;
    }

    public void setElkelt(boolean elkelt) {
        this.elkelt = elkelt;
    }

    public void licit() {
        this.licit(10);
    }

    public void licit(int mertek) {

        if (mertek<10||mertek>100){
            throw new IllegalArgumentException("A licit mértéke 10 és 100% között kell legyen!");
        }

        if (this.elkelt) {
            throw new RuntimeException("A festmény már elkelt");
        }
        if (this.licitekSzama == 0) {
            this.legmagasabbLicit = 100;
        } else {
            int ujLicit =this.legmagasabbLicit * (100+mertek)/100;
            this.legmagasabbLicit = getKerekitettLicitMatematikaiMuveletekkel(ujLicit);
        }
        this.licitekSzama++;
        this.legutolsoLicitIdeje = LocalDateTime.now();

    }

    private int getKerekitettLicitMatematikaiMuveletekkel(int ujLicit){
        int osztasokSzama=0;
        while(ujLicit>100){
            osztasokSzama++;
            ujLicit/=10;
        }
        ujLicit*=Math.pow(10,osztasokSzama);
        return ujLicit;
    }

    private int getKerekitettLicitSzoveggeAlakitassal(int ujLicit) {
        String szovegesLicit = String.valueOf(ujLicit);
        int hossz = szovegesLicit.length();
        StringBuilder veglegesLicit = new StringBuilder(szovegesLicit.substring(0, 2));

        for (int i = 0; i < hossz - 2; i++) {
            veglegesLicit.append(0);
        }
        return  Integer.parseInt(veglegesLicit.toString());
    }

    DateTimeFormatter formatum= DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");

    @Override
    public String toString() {
        return String.format("%s: %s (%s)\n"+
                "%s"+
                "%d $ - %s (összesen: %d db\n)"
                ,this.festo,this.cim,this.stilus,
                this.elkelt ? "elkelt\n":"",
                this.legmagasabbLicit,this.legutolsoLicitIdeje.format(formatum),this.licitekSzama
        );
    }
}

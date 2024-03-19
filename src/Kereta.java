public class Kereta {
    private String namaKereta;
    private int jumlahTiketTersedia;
    private Ticket[] tiketList;
    private int index;

    public Kereta() {
        this.namaKereta = "Komuter";
        this.jumlahTiketTersedia = 1000;
        this.tiketList = new Ticket[1000];
        this.index = 0;
    }

    public Kereta(String namaKereta, int jumlahTiketTersedia) {
        this.namaKereta = namaKereta;
        this.jumlahTiketTersedia = jumlahTiketTersedia;
        this.tiketList = new Ticket[jumlahTiketTersedia];
        this.index = 0;
    }

    public void tambahTiket(String namaPenumpang) {
        if (this.namaKereta.equals("Komuter")) {
            if (jumlahTiketTersedia > 0) {
                Ticket tiket = new Ticket();
                tiket.setNamaPenumpang(new String[]{namaPenumpang});
                tiketList[index++] = tiket;
                jumlahTiketTersedia--;
                System.out.println("==================================================");
                System.out.println("Tiket berhasil dipesan");
                //System.out.println("==================================================");
            } else {
                System.out.println("Kereta telah habis dipesan, silahkan cari jadwal keberangkatan lainnya");
            }
        }
    }

    public void tambahTiket(String namaPenumpang, String asal, String tujuan) {
        if (!this.namaKereta.equals("Komuter")) {
            if (jumlahTiketTersedia > 0) {
                Ticket tiket = new Ticket();
                tiket.setNamaPenumpang(new String[]{namaPenumpang});
                tiket.setAsal(new String[]{asal});
                tiket.setTujuan(new String[]{tujuan});
                tiketList[index++] = tiket;
                jumlahTiketTersedia--;
                System.out.println("==================================================");
                System.out.println("Tiket berhasil dipesan Sisa tiket tersedia: " + jumlahTiketTersedia);
            } else {
                System.out.println("==================================================");
                System.out.println("Kereta telah habis dipesan, silahkan cari jadwal keberangkatan lainnya");
            }
        }
    }

    public void tampilkanTiket() {
        System.out.println("==================================================");
        System.out.println("Daftar penumpang kereta api " + namaKereta);
        System.out.println("----------------------------");
        for (Ticket tiket : tiketList) {
            if (tiket != null) {
                String[] namaPenumpang = tiket.getNamaPenumpang();
                String[] asal = tiket.getAsal();
                String[] tujuan = tiket.getTujuan();
                for (int i = 0; i < namaPenumpang.length; i++) {
                    System.out.println("Nama: " + namaPenumpang[i]);
                    if (asal != null && tujuan != null) {
                        System.out.println("Asal: " + asal[i]);
                        System.out.println("Tujuan: " + tujuan[i]);
                        System.out.println("----------------------------");
                    }
                    
                }
            }
        }
    }
}

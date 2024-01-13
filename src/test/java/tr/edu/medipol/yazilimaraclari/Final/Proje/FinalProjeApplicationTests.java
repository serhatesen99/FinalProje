package tr.edu.medipol.yazilimaraclari.Final.Proje;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import java.util.List;
import static org.junit.jupiter.api.Assertions.*;

public class FinalProjeApplicationTests {
    private UrunYonetim urunYonetim;

    @BeforeEach
    public void setUp() {
        urunYonetim = new UrunYonetim();
    }
    
    @Test
    public void urunEkleTest() {
        Urun urun = new Urun();
        urun.setAd("Yogurt");
        urun.setFiyat(60.0);

        Urun eklenenUrun = urunYonetim.urunEkle(urun);

        assertNotNull(eklenenUrun);
        assertEquals(urun.getAd(), eklenenUrun.getAd());
        assertEquals(urun.getFiyat(), eklenenUrun.getFiyat());
    }
    

    @Test
    public void urunGosterTest() {
        Urun urun1 = new Urun();
        urun1.setAd("Deterjan");
        urun1.setFiyat(100.0);

        Urun urun2 = new Urun();
        urun2.setAd("Cips");
        urun2.setFiyat(30.0);

        urunYonetim.urunEkle(urun1);
        urunYonetim.urunEkle(urun2);

        List<Urun> urunListesi = urunYonetim.urunGoster();

        assertEquals(2, urunListesi.size());
        assertTrue(urunListesi.contains(urun1));
        assertTrue(urunListesi.contains(urun2));
    }
    
    
    
    
    @Test
    public void urunGosterByIdTest() {

        Urun testUrun = new Urun();
        testUrun.setAd("Test Ürünü");
        testUrun.setFiyat(50.0);
        Urun eklenenUrun = urunYonetim.urunEkle(testUrun);

        Long urunId = eklenenUrun.getId();

        Urun getirilenUrun = urunYonetim.urunGosterById(urunId);

        assertNotNull(getirilenUrun);
        assertEquals(testUrun.getAd(), getirilenUrun.getAd());
        assertEquals(testUrun.getFiyat(), getirilenUrun.getFiyat());
    }
    
    

    @Test
    public void urunSilTest() {
        Urun urun = new Urun();
        urun.setAd("Peynir");
        urun.setFiyat(150.0);

        Urun eklenenUrun = urunYonetim.urunEkle(urun);
        
        Long urunId = eklenenUrun.getId();
        urunYonetim.urunSil(urunId);

        List<Urun> urunListesi = urunYonetim.urunGoster();

        assertEquals(0, urunListesi.size());
    }
    
    
}





package tr.edu.medipol.yazilimaraclari.Final.Proje;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

@RestController
@RequestMapping("/urunler")
public class UrunYonetim {

    private final List<Urun> urunListesi = new ArrayList<>();
    
    @GetMapping
    public List<Urun> urunGoster() {
        return urunListesi;
    }
    
    @GetMapping("/{id}")
    public Urun urunGosterById(@PathVariable Long id) {
        for (Urun urun : urunListesi) {
            if (Objects.equals(urun.getId(), id)) {
                return urun;}}
        return null;  
       }

    @PostMapping
    public Urun urunEkle(@RequestBody Urun urun) {
        urunListesi.add(urun);
        return urun;
    }

    @DeleteMapping("/{id}")
    public void urunSil(@PathVariable Long id) {
        urunListesi.removeIf(urun -> Objects.equals(urun.getId(), id));
    }
    }

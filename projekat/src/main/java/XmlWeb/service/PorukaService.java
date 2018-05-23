package XmlWeb.service;

import XmlWeb.dodatno.Konverter;
import XmlWeb.dto.PorukaDTO;
import XmlWeb.model.Korisnik;
import XmlWeb.model.Poruka;
import XmlWeb.repository.PorukaRepository;
import XmlWeb.repository.SamoPosiljaoci;
import XmlWeb.repository.SamoPrimaoci;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

@Service
public class PorukaService {

    @Autowired
    private PorukaRepository porRepo;

    public void sendPoruka(PorukaDTO p){
        Konverter k = new Konverter();
        Poruka por = k.converterPoruke(p);
        if(por!=null){
            porRepo.save(por);
        }
    }

    public List<Poruka> getAllPoruke(){
        List<Poruka> poruke = new ArrayList<>();
        porRepo.findAll().forEach(poruke::add);
        return poruke;
    }

    public List<Korisnik> getInbox(Long korisnikId){

        List<Korisnik> inbox = new ArrayList<Korisnik>();
        HashMap<Long, Korisnik> mapa = new HashMap<>();

        List<SamoPosiljaoci> temp1 =  porRepo.findDistinctByPrimalacIdOrderByVremeKreiranja(korisnikId);
        List<SamoPrimaoci> temp2 = porRepo.findDistinctByPosiljalacIdOrderByVremeKreiranja(korisnikId);

        for (SamoPosiljaoci s1:temp1) {
            mapa.put(s1.getPosiljalac().getId(), s1.getPosiljalac());
        }

        for(SamoPrimaoci s2:temp2){
            mapa.put(s2.getPrimalac().getId(), s2.getPrimalac());
        }
        if(mapa.size()>0){
            inbox = new ArrayList<Korisnik>(mapa.values());
        }

        return inbox;
    }

    public List<Poruka> getChat(Long osoba1, Long osoba2){
        return porRepo.findByPosiljalacIdAndPrimalacIdOrPrimalacIdAndPosiljalacIdOrderByVremeKreiranjaAsc(osoba1, osoba2); //Jos malo kul madjije :D
    }




}
package XmlWeb.controller;

import java.util.List;

import XmlWeb.config.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import XmlWeb.dto.KorisnikDTO;
import XmlWeb.model.Korisnik;
import XmlWeb.service.KorisnikService;

import javax.ws.rs.core.MediaType;


@RestController
public class KorisnikController {
	
	@Autowired
	private KorisnikService korisnikService;

	
	@AgentRead
	@AdminRead
	@RequestMapping(method = RequestMethod.GET, value = "/user")
	public List<Korisnik> getKorisnici(){
		System.out.println("usao po sve korisnike: " + korisnikService.getAllKorisnik().size());
		return korisnikService.getAllKorisnik();
	}

	@PermitAll
	/*@UserRead
	@AgentRead sry, morao sam ovo zakomentarisati, ne znam zasto ne radi ni ovaj upit
	@AdminRead*/
	@RequestMapping(method = RequestMethod.GET, value = "/user/{id}")
	public Korisnik getKorisnikByID(@PathVariable Long id){
		return korisnikService.getKorisnik(id);
	}

	@UserRead
	@AgentRead
	@AdminRead
	@RequestMapping(method = RequestMethod.GET, value = "/user/username/{id}")
	public Korisnik getKorisnikByUsername(@RequestBody String id){
		return korisnikService.getKorisnik(id);
	}

	@UserWrite
	@AdminWrite
	@RequestMapping(method = RequestMethod.PUT, value = "/user")
	public void updateKorisnik(@RequestBody KorisnikDTO k){ korisnikService.updateKorisnik(k); }

	@UserWrite
	@AdminWrite
	@RequestMapping(method = RequestMethod.POST, value = "/user")
	public void addKorisnik(@RequestBody KorisnikDTO k){
		korisnikService.addKorisnik(k);
	}

	@AdminWrite
	@RequestMapping(method = RequestMethod.DELETE, value = "/user/{id}")
	public void deleteKorisnik(@PathVariable Long id){
		 korisnikService.deleteKorisnik(id);
	}

	@AdminWrite
	@RequestMapping(method = RequestMethod.GET, value = "/user/block/{id}")
	public void blockKorisnik(@PathVariable Long id){
		 korisnikService.blockKorisnik(id);
	}

	@PermitAll
	@RequestMapping(method = RequestMethod.GET, value = "/user/status/{id}", produces = MediaType.TEXT_PLAIN)
	public String getStatusKorisnika(@PathVariable Long id){

		return korisnikService.getKorisnik(id).getStatusNaloga().toString() + "," + korisnikService.getKorisnik(id).getRole().name();
	}

}

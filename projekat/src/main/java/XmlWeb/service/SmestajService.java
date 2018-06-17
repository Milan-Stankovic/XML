package XmlWeb.service;

import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import XmlWeb.dto.SearchDTO;
import XmlWeb.model.Smestaj;
import XmlWeb.repository.SmestajRepository;

@Service
public class SmestajService {
	
	@Autowired
	private SmestajRepository smestajRepository;
	
	public Collection<Smestaj> getAllSmestaj(){
		return smestajRepository.findAll();
	}
	
	public Collection<Smestaj> getAllSmestajSimple(SearchDTO ser){
		return smestajRepository.findAll();
	}
	
	public Collection<Smestaj> getAllSmestajAdv(SearchDTO ser){
		return smestajRepository.findAll();
	}

}

package isa.projekat.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import isa.projekat.model.Hall;
import isa.projekat.model.dto.Converters;
import isa.projekat.model.dto.HallDTO;
import isa.projekat.repository.HallRepository;
import isa.projekat.service.HallService;

@RestController
@RequestMapping(value="halls")
public class HallController {

	@Autowired
	private HallService hallService;
	
	@Autowired
	private HallRepository hallRepository;
	
	@RequestMapping(value="getHall", method=RequestMethod.GET)
	@ResponseBody
	public ResponseEntity<HallDTO> getHall(@RequestParam("id") Long id) {
		Hall hall = hallService.findOne(id);
		HallDTO result = Converters.convertHallToHallDTO(hall);
		return new ResponseEntity<HallDTO>(result, HttpStatus.OK);
	}
}

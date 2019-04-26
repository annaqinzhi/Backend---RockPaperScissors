package controller;

import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;


import model.Game;
import service.PlayerService;

@RestController
public class PlayerController {
	@Autowired
	private PlayerService ps;
	
	@RequestMapping(value="/api/games", method=RequestMethod.POST)
	   public String createGame(@RequestParam String name) {
		   return ps.createGame(name);   
	   }
	
	@RequestMapping(value="/api/games/{id}", method=RequestMethod.GET)
	   public Game getGameByUuid(@PathVariable("id") UUID id) {
		   return ps.getGameByUuid(id);
	   }
	 
	 
	@RequestMapping(value="/api/games/{id}/join", method=RequestMethod.POST)
	   public String addPlayerByName(@RequestParam String name, @PathVariable("id") UUID id) {
		   return ps.addPlayerByName(name, id);
	   }
	 
	@RequestMapping(value="/api/games/{id}/move", method=RequestMethod.POST)
	   public String setMove(@RequestParam String move, @RequestParam String name, @PathVariable("id") UUID id) {
		   return ps.setMove(move, name, id);		   
	   }
	

}

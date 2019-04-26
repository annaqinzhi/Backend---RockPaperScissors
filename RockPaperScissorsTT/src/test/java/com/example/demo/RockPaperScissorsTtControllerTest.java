package com.example.demo;

import org.junit.Before;
import org.junit.Test;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import model.Game;

//import com.tutorialspoint.demo.model.Product;

public class RockPaperScissorsTtControllerTest extends AbstractTest {
	private String uuid;
	
	
   @Override
   @Before
   public void setUp() {
      super.setUp();
   }
   @Test
   public void playGame() throws Exception {
	   //Create game and games id
		String uri1 = "/api/games";
		MvcResult mvcResult1 = mvc
				.perform(MockMvcRequestBuilders.post(uri1).param("name", "lisa")
				.accept(MediaType.ALL_VALUE))
				.andReturn();
		String content1 = mvcResult1.getResponse().getContentAsString();
		uuid = content1;
		System.out.println("UUID is " + content1);
		
		//Another player join in by using id
		String uri2 = "/api/games/" + uuid + "/join";
		MvcResult mvcResult2 = mvc.perform(MockMvcRequestBuilders.post(uri2).param("name", "Filip")
				.accept(MediaType.ALL_VALUE))
				.andReturn();
		String content2 = mvcResult2.getResponse().getContentAsString();
		System.out.println(content2 + " joined the game.");

		//Player1 give move
		String uri3 = "/api/games/" + uuid + "/move";
		MvcResult mvcResult3 = mvc
				.perform(MockMvcRequestBuilders.post(uri3).param("name", "Filip").param("move", "Paper")
				.accept(MediaType.ALL_VALUE))
				.andReturn();
		String content3 = mvcResult3.getResponse().getContentAsString();
		System.out.println(content3);

		//Player2 give move
		String uri4 = "/api/games/" + uuid + "/move";
		MvcResult mvcResult4 = mvc
				.perform(MockMvcRequestBuilders.post(uri4).param("name", "Lisa").param("move", "Rock")
				.accept(MediaType.ALL_VALUE))
				.andReturn();;
		String content4 = mvcResult4.getResponse().getContentAsString();
		System.out.println(content4);
		
		//Check the game result by using id
		String uri5 = "/api/games/" + uuid;
		MvcResult mvcResult5 = mvc.perform(MockMvcRequestBuilders.get(uri5).accept(MediaType.APPLICATION_JSON))
				.andReturn();
		String content5 = mvcResult5.getResponse().getContentAsString();
		Game game5 = super.mapFromJson(content5, Game.class);
		System.out.println("Game is " + game5.toString());
    
   }  
   
}
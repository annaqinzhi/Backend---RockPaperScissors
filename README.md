# Backend---RockPaperScissors
Backend - RockPaperScissors (Sten sax påse) Spring Boot/Maven/eclipse, SpringToolSuite4


# RockPaperScissors API

### Port
server.port=4000

### Test tool
Rested (for Mac, similar to Postman)  

### Unit Test added

### API
POST    /api/games
POST    /api/games/{id}/join
POST    /api/games/{id}/move
GET      /api/games/{id}

### Game introduction & API User Guides

* <Player1 create a game by input name, an UUID created for this game>:    
  POST    /api/games?name="Lisa"
  Response body: "fe84801d-6689-4b35-8d3f-166722873516"   (UUID)
  
* <Player2 get the UUID from Player1, and conneted to the game by UUID>: 
  POST    /api/games/{id}/join?name="Filip"
  Response body: "Filip"
  
* <Both of Players give moves by input name and move>:
  POST    /api/games/{id}/move?name="Lisa"&move="Rock"
  Response body: "Lisa Rock"
  POST    /api/games/{id}/move?name="Filip"&move="Paper"
  Response body: "Filip Paper"
  
 * <Players can see the result by input UUID>:
  GET      /api/games/fe84801d-6689-4b35-8d3f-166722873516
  Response body: 
  {
  "player1": {
  "name": "Lisa",
  "move": "Rock",
  "win": false
  },
  "player2": {
  "name": "Filip",
  "move": "Paper",
  "win": true
  },
  "end": true
  }
  
  


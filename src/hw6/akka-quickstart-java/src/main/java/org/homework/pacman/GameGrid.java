package org.homework.pacman;


import akka.actor.typed.ActorRef;
import akka.actor.typed.Behavior;
import akka.actor.typed.javadsl.AbstractBehavior;
import akka.actor.typed.javadsl.ActorContext;
import akka.actor.typed.javadsl.Behaviors;
import akka.actor.typed.javadsl.Receive;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Random;

public class GameGrid extends AbstractBehavior<GameGrid.GameGridCommand> {
    private final int width;
    private final int height;
    private final int[][] grid;
    //    private list<ActorRef<Ghost.GhostCommand> ghosts;
    int pacManX;
    int pacManY;
    private boolean powerPellets = false;
    private int powerPelletsCounter = 0;
    private int score;

    GameRootActor gameRootActor;
    ArrayList<Ghost> ghosts = new ArrayList<Ghost>();
    HashMap<Integer, Integer> ghostsMapX = new HashMap<Integer, Integer>();
    HashMap<Integer, Integer> ghostsMapY = new HashMap<Integer, Integer>();

    interface GameGridCommand {
    }

    ;

    @Override
    public Receive<GameGridCommand> createReceive() {
        return newReceiveBuilder()
                .onMessage(StartGame.class, this::startGame)
                .onMessage(MovePacMan.class, this::movePacMan)
                .onMessage(MoveGhost.class, this::moveGhost)
                .onMessage(AddGhost.class, this::addGhost)
                .build();
    }

    public ActorRef getActorRef() {
        return getContext().getSelf();
    }

    public static class StartGame implements GameGridCommand {
        private final GameGrid gameGrid;

        public StartGame(GameGrid gameGrid) {
            this.gameGrid = gameGrid;
        }
    }

    public static class AddGhost implements GameGridCommand {
        private final int id;
        private final int x;
        private final int y;

        public AddGhost(int id, int x, int y) {
            this.id = id;
            this.x = x;
            this.y = y;
        }
    }

    private Behavior<GameGridCommand> addGhost(AddGhost addGhost) {
        ghosts.add(new Ghost(getContext(), addGhost.id));
        ghostsMapX.put(addGhost.id, addGhost.x);
        ghostsMapY.put(addGhost.id, addGhost.y);
        return this;
    }

    public static class MovePacMan implements GameGridCommand {
        private String direction;

        public MovePacMan(String direction) {
            this.direction = direction;

        }
    }

    public static class MoveGhost implements GameGridCommand {
        private final int ghostId;
        private int x = 2;
        private int y = 2;

        private String direction;

        public MoveGhost(int ghostId) {
            this.ghostId = ghostId;
        }
    }

    public GameGrid(ActorContext<GameGridCommand> context, GameRootActor gameRootActor) {
        super(context);
        this.gameRootActor = gameRootActor;
        this.width = 3;
        this.height = 3;
        this.grid = new int[width][height];
        this.pacManX = 0;
        this.pacManY = 0;
        for (int i = 0; i < width; i++) {
            for (int j = 0; j < height; j++) {
                Random rand = new Random();
                int foodSpawnChance = rand.nextInt(5) + 2; //starts at 0, so add 1
                switch (foodSpawnChance) {
                    case 2:
                        grid[i][j] = 2;
                        break;
                    case 3:
                        grid[i][j] = 3;
                        break;
                    case 4:
                        grid[i][j] = 4;
                        break;
                    case 5:
                        grid[i][j] = 5;
                        break;
                }
            }
        }
    }

    public static Behavior<GameGrid.GameGridCommand> create(GameRootActor gameRootActor) {
        return Behaviors.setup(context -> new GameGrid(context, gameRootActor));
    }

    private Behavior<GameGridCommand> startGame(StartGame startGame) {
        return this;
    }

    private Behavior<GameGrid.GameGridCommand> movePacMan(MovePacMan movePacMan) {
        if(powerPelletsCounter > 0){
            powerPelletsCounter--;
        }
        if(powerPelletsCounter == 0 && powerPellets){
            powerPellets = false;
            System.out.println("Power Pellets have worn off");
        }
        String direction = movePacMan.direction;
        switch (direction) {
            case "North":
                if (pacManY > 0) {
                    pacManY--;
                }
                break;
            case "South":
                if (pacManY < height - 1) {
                    pacManY++;
                }
                break;
            case "East":
                if (pacManX < width - 1) {
                    pacManX++;
                }
                break;
            case "West":
                if (pacManX > 0) {
                    pacManX--;
                }
                break;

        }
        switch (grid[pacManX][pacManY]) {
            case 2:
                System.out.println("You ate a power pellet!");
                powerPellets = true;
                powerPelletsCounter = 5;
                break;
            case 3:
                System.out.println("You ate a fruit!");
                score += 100;
                break;
            case 4:
                System.out.println("You ate a cherry!");
                score += 10;
                break;
            case 5:
                break;
        }

        System.out.println("PacMan moved to " + pacManX + ", " + pacManY);
        for (Ghost ghost : ghosts) {
//            ghost.getActorRef().tell(new Ghost.Move(pacManX, pacManY));
            Random rand = new Random();
            int directionInt = rand.nextInt(4) + 1; //starts at 0, so add 1
            String directionString = "";
            switch (directionInt) {
                case 1:
                    directionString = "North";
                    break;
                case 2:
                    directionString = "South";
                    break;
                case 3:
                    directionString = "East";
                    break;
                case 4:
                    directionString = "West";
                    break;
            }
            this.moveGhost(new MoveGhost(ghost.getId()));
        }
//        moveGhost(new MoveGhost(0, 0, 0, "North"));
        return this;
    }

    private Behavior<GameGridCommand> moveGhost(MoveGhost moveGhost) {
        int x = moveGhost.x;
        int y = moveGhost.y;
        Random rand = new Random();
        int foodSpawnChance = rand.nextInt(5) + 2; //starts at 0, so add 1
        grid[x][y] = foodSpawnChance;
        Random rand2 = new Random();
        int directionInt = rand2.nextInt(4) + 1; //starts at 0, so add 1
        String direction;
        switch (directionInt) {
            case 1:
                if(moveGhost.y > 0) {
                    y--;
                }
                break;
            case 2:
                if(moveGhost.y < height - 1) {
                    moveGhost.y++;
                }
                break;
            case 3:
                if (moveGhost.x < width - 1) {
                    moveGhost.x++;
                }
                break;
            case 4:
                if (moveGhost.x > 0) {
                    moveGhost.x--;
                }
                break;
            default:
                if (moveGhost.x < width - 1) {
                    moveGhost.x++;
                }
                break;

        }
        System.out.println("Ghost moved to " + moveGhost.x + ", " + moveGhost.y);
        System.out.println(pacManX + ", " + pacManY);
        if(moveGhost.x == pacManX && moveGhost.y == pacManY){
            if(powerPellets){
                score += 200;
                System.out.println("You ate a ghost!");
                System.out.println("Score: " + score);
            }
            else{
                gameRootActor.GameOver(this.score);
            }
        }
        return this;
    }

}

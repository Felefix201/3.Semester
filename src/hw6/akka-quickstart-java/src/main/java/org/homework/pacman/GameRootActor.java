//package org.homework.pacman;
//
//
//import akka.actor.typed.ActorRef;
//import akka.actor.typed.Behavior;
//import akka.actor.typed.javadsl.AbstractBehavior;
//import akka.actor.typed.javadsl.ActorContext;
//import akka.actor.typed.javadsl.Behaviors;
//import akka.actor.typed.javadsl.Receive;
//
//import java.util.Scanner;
//import java.util.concurrent.Semaphore;
//
//public class GameRootActor extends AbstractBehavior<GameRootActor.GameRootCommand> {
//    private boolean isRunning = true;
//    public GameRootActor(ActorContext<GameRootCommand> context) {
//        super(context);
//    }
//
//    public static Behavior<GameRootCommand> create() {
//        return Behaviors.setup(GameRootActor::new);
//    }
//
//     void GameOver (int points) {
//        System.out.println("Game Over! You got " + points + " points!");
//        isRunning = false;
//    }
//    public enum StartGame implements GameRootCommand {
//        START_GAME,
//    }
//
//    @Override
//    public Receive<GameRootCommand> createReceive() {
//        return newReceiveBuilder()
//                .onMessage(GameRootActor.StartGame.class, this::startGame)
//                .onMessage(GameRootActor.GameOver.class, this::gameOver)
//                .build();
//    }
//
//    public interface GameRootCommand {
//    }
//
//    static class GameOver implements GameRootCommand {
//        private final String points;
//
//        public GameOver(String points) {
//            this.points = points;
//        }
//    }
//    private Behavior<GameRootCommand> gameOver(GameOver gameOver) {
//        System.out.println("Game Over! You got " + gameOver.points + " points!");
//        this.isRunning = false;
//        return this;
//    }
//
//    public ActorRef<GameRootCommand> getActorRef() {
//        return getContext().getSelf();
//    }
//
//    private Behavior<GameRootCommand> startGame(StartGame startGame) {
//
//        ActorRef gameGridActor = getContext().spawn(GameGrid.create(this), "GameGridActor");
//        ActorRef pacManPlayerActor = getContext().spawn(PacManPlayer.create("PacMan"), "PacManPlayerActor");
////        ActorRef ghostActor = getContext().spawn(Ghost.create(), "GhostActor");
////        gameGridActor.tell(new GameGrid(g).StartGame(gameGrid));
//        pacManPlayerActor.tell(new PacManPlayer.StartGame(gameGridActor));
////        for (Ghost ghost : ghosts) {
////            ghostActor.tell(new Ghost().StartGame(ghost));
////        }
//        Semaphore inputSemaphore = new Semaphore(1);
//        System.out.println("Game Started");
//        int counter = 0;
//        int ghostCounter = 0;
//        gameGridActor.tell(new GameGrid.AddGhost(ghostCounter, 2, 2));
//        while (isRunning) {
//            System.out.println("Choose your direction: ");
//            Scanner scanner = new Scanner(System.in);
//            String direction = scanner.nextLine();
//            if (direction.equals("North") || direction.equals("South") || direction.equals("West") || direction.equals("East")) {
//                pacManPlayerActor.tell(new PacManPlayer.Move(direction));
//            } else {
//                System.out.println("Invalid direction, you can only choose North, South, West or East");
//            }
//            counter++;
//            if (counter == 10) {
//                //addghost
//                gameGridActor.tell(new GameGrid.AddGhost(ghostCounter, 2, 2));
//                ghostCounter++;
//                counter = 0;
//            }
//        }
//        System.out.println("Game Over");
//        return this;
//    }
//
//}

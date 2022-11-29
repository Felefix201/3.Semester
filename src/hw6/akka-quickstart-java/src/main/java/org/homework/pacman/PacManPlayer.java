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
//import java.awt.event.KeyEvent;
//
//public class PacManPlayer extends AbstractBehavior<PacManPlayer.PlayerCommand> {
//
//    private final String name;
//    private ActorRef gameGridActorRef;
//
//    public PacManPlayer(ActorContext<PlayerCommand> context, String name) {
//        super(context);
//        this.name = name;
//    }
//
//    @Override
//    public Receive<PlayerCommand> createReceive() {
//        return newReceiveBuilder()
//                .onMessage(StartGame.class, this::startGame)
//                .onMessage(Move.class, this::move)
//                .build();
//    }
//
//    interface PlayerCommand {
//    }
//
//    public static Behavior<PlayerCommand> create(String name){
//        return Behaviors.setup(context -> new PacManPlayer(context, name));
//    }
//
//    public static class StartGame implements PlayerCommand {
//        public final ActorRef gameGrid;
//
//        public StartGame(ActorRef gameGrid) {
//            this.gameGrid = gameGrid;
//        }
//    }
//
//    public static class Move implements PlayerCommand {
//        private String direction;
//        public Move(String direction) {
//            this.direction = direction;
//        }
//    }
//
//    private Behavior<PlayerCommand> startGame(StartGame startGame) {
//        this.gameGridActorRef = startGame.gameGrid;
//        return this;
//    }
//
//    private Behavior<PlayerCommand> move(Move move) {
//        gameGridActorRef.tell(new GameGrid.MovePacMan(move.direction));
//        return this;
//    }
//}
//
//

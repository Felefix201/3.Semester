package org.homework.pacman;

import akka.actor.typed.ActorRef;
import akka.actor.typed.Behavior;
import akka.actor.typed.javadsl.AbstractBehavior;
import akka.actor.typed.javadsl.ActorContext;
import akka.actor.typed.javadsl.Behaviors;
import akka.actor.typed.javadsl.Receive;


public class Ghost extends AbstractBehavior {
    private final int id;

//    public final ActorRef gameGrid;
    public Ghost(ActorContext context, int id) {
        super(context);
        this.id = id;
    }

    public interface GhostCommand {
    }

    public int getId() {
        return id;
    }
    public static Behavior create(int id) {
        return Behaviors.setup(context -> new Ghost(context, id));
    }

    @Override
    public Receive createReceive() {
        return newReceiveBuilder()
//                .onMessage(Move.class, this::move)
                .build();
    }


    public static class Move {
        private String direction;
        private int pacManX;
        private int pacManY;
        public Move(int pacManX, int pacManY) {
            this.pacManX = pacManX;
            this.pacManY = pacManY;
        }
    }
    public akka.actor.typed.ActorRef getActorRef() {
        return this.getContext().getSelf();
    }
    private Behavior<GhostCommand> move(Move move) {
        int pacManX = move.pacManX;
        int pacManY = move.pacManY;
//        switch (pacManX) {
//            case paxManX > this.x:
//                gameGrid.tell(new GameGrid.MoveGhost(this.id, "right"));
//                break;
//        }
        return this;
    }
}

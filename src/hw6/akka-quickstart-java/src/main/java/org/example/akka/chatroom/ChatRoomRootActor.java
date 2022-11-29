//package org.example.akka.chatroom;
//
//import akka.actor.Actor;
//import akka.actor.typed.ActorRef;
//import akka.actor.typed.Behavior;
//import akka.actor.typed.javadsl.AbstractBehavior;
//import akka.actor.typed.javadsl.ActorContext;
//import akka.actor.typed.javadsl.Behaviors;
//import akka.actor.typed.javadsl.Receive;
//
//public class ChatRoomRootActor extends AbstractBehavior<ChatRoomRootActor.StartMessage> {
//
//    public static Behavior<ChatRoomRootActor.StartMessage> create(){
//        return Behaviors.setup(ChatRoomRootActor::new);
//    }
//
//    public ChatRoomRootActor(ActorContext<StartMessage> context) {
//        super(context);
//    }
//
//    interface StartMessage{}
//    public enum Start implements StartMessage{
//        INSTANCE
//    }
//
//
//    @Override
//    public Receive<StartMessage> createReceive() {
//        return newReceiveBuilder()
//                .onMessage(ChatRoomRootActor.Start.class, this::createChatRoomSystem)
//                .build();
//    }
//
//    private Behavior<StartMessage> createChatRoomSystem(Start start) {
//        ActorRef chatRoomActorRef = getContext().spawn(ChatRoomActor.create(), "ChatRoomRootActor");
//        ActorRef userActor1 = getContext().spawn(UserActor.create("Alice"), "Alice");
//        ActorRef userActor2 = getContext().spawn(UserActor.create("Bob"), "Bob");
//
//        userActor1.tell(new UserActor.StartMessage(chatRoomActorRef));
//        userActor2.tell(new UserActor.StartMessage(chatRoomActorRef));
//        return this;
//    }
//}

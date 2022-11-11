package org.example.akka.chatroom;

import akka.actor.typed.ActorRef;
import akka.actor.typed.Behavior;
import akka.actor.typed.javadsl.AbstractBehavior;
import akka.actor.typed.javadsl.ActorContext;
import akka.actor.typed.javadsl.Behaviors;
import akka.actor.typed.javadsl.Receive;

public class UserActor extends AbstractBehavior<UserActor.UserMessage> {

    private String name;

    public static Behavior<UserMessage> create(String name){
        return Behaviors.setup(context -> new UserActor(context, name));
    }

    public UserActor(ActorContext<UserMessage> context, String name) {
        super(context);
        this.name = name;
    }

    public interface UserMessage{}

    public static class StartMessage implements UserMessage{
        private final ActorRef chatRoomActorRef;

        public StartMessage(ActorRef chatRoomActorRef) {
            this.chatRoomActorRef = chatRoomActorRef;
        }
    }

    public static class MessagePosted implements UserMessage{
        private final String message;
        private final String from;

        public MessagePosted(String message, String from) {
            this.message = message;
            this.from = from;
        }
    }

    private ActorRef chatRoomActorRef;

    @Override
    public Receive<UserMessage> createReceive() {
        return newReceiveBuilder()
                .onMessage(StartMessage.class, this::startUserActor)
                .onMessage(MessagePosted.class, this::receivePublishedChatMessage)
                .build();
    }

    private Behavior<UserMessage> receivePublishedChatMessage(MessagePosted messagePosted) {
        System.out.println(name + " received published chat message: "
                + messagePosted.message + " FROM " + messagePosted.from);
        return this;
    }

    private Behavior<UserMessage> startUserActor(StartMessage startMessage) {
        this.chatRoomActorRef = startMessage.chatRoomActorRef;
        System.out.println("Received StartMessage");
        chatRoomActorRef.tell(new ChatRoomActor.EnterChatCommand(getContext().getSelf()));
        chatRoomActorRef.tell(new ChatRoomActor.PostChatMessage("Hi", name));
        return this;
    }


}

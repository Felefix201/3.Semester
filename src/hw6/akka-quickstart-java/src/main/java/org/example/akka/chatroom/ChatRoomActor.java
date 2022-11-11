package org.example.akka.chatroom;

import akka.actor.typed.ActorRef;
import akka.actor.typed.Behavior;
import akka.actor.typed.javadsl.AbstractBehavior;
import akka.actor.typed.javadsl.ActorContext;
import akka.actor.typed.javadsl.Behaviors;
import akka.actor.typed.javadsl.Receive;

import java.util.ArrayList;
import java.util.List;

public class ChatRoomActor extends AbstractBehavior<ChatRoomActor.ChatCommand> {

    public static Behavior<ChatCommand> create(){
        return Behaviors.setup(ChatRoomActor::new);
    }

    public ChatRoomActor(ActorContext<ChatCommand> context) {
        super(context);
    }

    interface ChatCommand {}

    public static class EnterChatCommand implements ChatCommand{
        public final ActorRef user;
        public EnterChatCommand(ActorRef user) {
            this.user = user;
        }
    }

    public static class PostChatMessage implements ChatCommand{

        public final String message;
        public final String from;

        public PostChatMessage(String message, String from) {
            this.message = message;
            this.from = from;
        }
    }

    @Override
    public Receive<ChatCommand> createReceive() {
        return newReceiveBuilder()
                .onMessage(EnterChatCommand.class, this::enterChat)
                .onMessage(PostChatMessage.class, this::postChatMessage)
                .build();
    }

    private Behavior<ChatCommand> postChatMessage(PostChatMessage postChatMessage) {
        for(ActorRef users : registeredUsers){
            users.tell(new UserActor.MessagePosted(postChatMessage.message, postChatMessage.from));
        }
        return this;
    }

    private List<ActorRef<UserActor.UserMessage>> registeredUsers = new ArrayList<>();

    private Behavior<ChatCommand> enterChat(EnterChatCommand enterChatCommand){
        System.out.println("Received enterChatMessage " + enterChatCommand.user);
        registeredUsers.add(enterChatCommand.user);
        System.out.println("Registered users: " + registeredUsers);
        return this;
    }


}

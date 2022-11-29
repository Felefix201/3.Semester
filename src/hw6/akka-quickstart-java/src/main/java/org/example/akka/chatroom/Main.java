//package org.example.akka.chatroom;
//
//import akka.actor.typed.ActorSystem;
//
//import java.io.IOException;
//
//public class Main {
//    public static void main(String[] args) throws InterruptedException {
//        ActorSystem chatRoomSystem = ActorSystem.create(ChatRoomRootActor.create(), "ChatRoomRoot");
//
//        chatRoomSystem.tell(ChatRoomRootActor.Start.INSTANCE);
//
//        Thread.sleep(1000);
//
//        chatRoomSystem.terminate();
//    }
//}

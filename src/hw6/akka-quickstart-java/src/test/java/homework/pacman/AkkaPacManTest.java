package homework.pacman;
import akka.actor.testkit.typed.javadsl.TestKitJunitResource;
import akka.actor.testkit.typed.javadsl.TestProbe;
import akka.actor.typed.ActorRef;
import akka.actor.typed.ActorSystem;
import com.example.Greeter;
import org.example.akka.chatroom.ChatRoomRootActor;
import org.homework.pacman.GameRootActor;
import org.junit.ClassRule;
import org.junit.Test;

public class AkkaPacManTest {

    //#definition


        @ClassRule
        public static final TestKitJunitResource testKit = new TestKitJunitResource();
//#definition

        //#test
        @Test
        public void testGreeterActorSendingOfGreeting() throws InterruptedException {
            ActorSystem gameRootActor = ActorSystem.create(GameRootActor.create(), "GameRoot");
            gameRootActor.tell(GameRootActor.StartGame.START_GAME);

            Thread.sleep(1000);

//            GameRootActor.terminate();
        }
        //#test


}

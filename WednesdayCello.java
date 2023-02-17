package gh2;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Base64;
import java.util.zip.GZIPInputStream;

public class WednesdayCello {
    public static void main(String[] args) {

        GuitarPlayer player1 = new GuitarPlayer(new java.io.File("src/gh2/wednesday_cello.mid"));
        FireCrackerPlayer player2 = new FireCrackerPlayer(new java.io.File("src/gh2/wednesday_cello.mid"));
        ViolinPlayer player3 = new ViolinPlayer(new java.io.File("src/gh2/wednesday_cello.mid"));

        WednesdayPlayer player = new WednesdayPlayer(new java.io.File("src/gh2/wednesday_cello.mid"));
        player.play();


    }

}


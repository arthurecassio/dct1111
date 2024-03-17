package br.ufrn.dct.media;

import org.junit.Assert;
import org.junit.Test;

import java.util.logging.Logger;


public class MediaTest {
    Logger logs = Logger.getAnonymousLogger();
    @Test
    public void testMedia(){
       Media testMedia = new Media(3.0,4.0,5.0);
       Assert.assertEquals(4.0,testMedia.calcule(),0.0001d);
       logs.info(testMedia.verificarAprovacao());
       logs.info(testMedia.verificarAprovacaoRecuperacao(8.0));

    }
}

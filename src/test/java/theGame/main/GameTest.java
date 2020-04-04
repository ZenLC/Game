package theGame.main;

import org.jboss.arquillian.container.test.api.Deployment;
import org.jboss.arquillian.junit.Arquillian;
import org.jboss.shrinkwrap.api.ShrinkWrap;
import org.jboss.shrinkwrap.api.asset.EmptyAsset;
import org.jboss.shrinkwrap.api.spec.JavaArchive;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import theGame.state.GameState;

import static org.junit.Assert.*;

@RunWith(Arquillian.class)
public class GameTest {
    @Deployment
    public static JavaArchive createDeployment() {
        return ShrinkWrap.create(JavaArchive.class)
                .addClass(Game.class)
                .addAsManifestResource(EmptyAsset.INSTANCE, "beans.xml");
    }

    @Test
    public void startTest() {
        Game g=null;
        g.setRunning(false);
        g.start();
        Assert.assertTrue(g.isRunning());
    }

    @Test
    public void stopTest() {
        Game g=null;
        g.setRunning(true);
        g.stop();
        Assert.assertFalse(g.isRunning());
    }
}

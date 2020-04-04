package tile;

import org.jboss.arquillian.container.test.api.Deployment;
import org.jboss.arquillian.junit.Arquillian;
import org.jboss.shrinkwrap.api.ShrinkWrap;
import org.jboss.shrinkwrap.api.asset.EmptyAsset;
import org.jboss.shrinkwrap.api.spec.JavaArchive;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;

import static org.junit.Assert.*;

@RunWith(Arquillian.class)
public class wallTileTest {
    @Deployment
    public static JavaArchive createDeployment() {
        return ShrinkWrap.create(JavaArchive.class)
                .addClass(wallTile.class)
                .addAsManifestResource(EmptyAsset.INSTANCE, "beans.xml");
    }
/*
Test if the tile wall can be passed
 */
    @Test
    public void isSolid() {
        Assert.assertTrue(wallTile.Wall.isSolid());
    }
}

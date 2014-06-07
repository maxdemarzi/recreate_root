package org.neo4j;

import org.junit.Assert;
import org.junit.Test;
import org.junit.rules.TemporaryFolder;
import org.neo4j.graphdb.GraphDatabaseService;
import org.neo4j.graphdb.NotFoundException;
import org.neo4j.graphdb.Transaction;
import org.neo4j.graphdb.factory.GraphDatabaseFactory;

import java.io.IOException;

public class RootNodeCreatorTest {

    @Test
    public void verifyRootCreation() throws IOException {
        TemporaryFolder temporaryFolder = new TemporaryFolder();
        temporaryFolder.create();

        GraphDatabaseService database = new GraphDatabaseFactory().newEmbeddedDatabase(temporaryFolder.getRoot().getAbsolutePath());
        Transaction tx = database.beginTx();
        try {
            database.getNodeById(0).delete();
            tx.success();
        }
        finally {
            tx.finish();
        }


        try {
            database.getNodeById(0);
            Assert.fail();
        } catch (NotFoundException e) {
            //ok
        }

        database.shutdown();
        String[] args = {temporaryFolder.getRoot().getAbsolutePath()};
        new RootNodeCreator().main(args);

        database = new GraphDatabaseFactory().newEmbeddedDatabase(temporaryFolder.getRoot().getAbsolutePath());
        Assert.assertNotNull(database.getNodeById(0));
    }
}

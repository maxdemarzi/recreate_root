package org.neo4j;

import org.neo4j.unsafe.batchinsert.BatchInserter;
import org.neo4j.unsafe.batchinsert.BatchInserters;

import java.util.HashMap;

public class RootNodeCreator {
    /**
     * Create the root node. Make sure the database is stopped when running this.
     *
     * @param pathToDatabase path to the database.
     */

    public static void main(String[] args) {
        BatchInserter inserter = BatchInserters.inserter(args[0]);
        inserter.createNode(0, new HashMap<String, Object>());
        inserter.shutdown();
    }
}

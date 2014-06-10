Recreate Root Node
==================


Recreate the Root Node


1. Build it:

        mvn clean package

2. Stop the database

3. Copy dependencies in same folder as target:

        cp dependencies/batch-import-jar-with-dependencies.jar target

4. Run the following command in the target folder:

        java -cp "batch-import-jar-with-dependencies.jar" -cp "recreateroot-1.0-SNAPSHOT.jar:*" org.neo4j.RootNodeCreator <path to your neo4j/data/graph.db>

For example:

        java -cp "batch-import-jar-with-dependencies.jar" -cp "recreateroot-1.0-SNAPSHOT.jar:*" org.neo4j.RootNodeCreator /Users/maxdemarzi/Projects/neography/neo4j/data/graph.db

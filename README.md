Recreate Root Node
==================


Recreate the Root Node


1. Build it:

        mvn clean package

2. Copy target/recreateroot-1.0-SNAPSHOT.jar to the neo4j/lib directory of your Neo4j server.

3. Stop the database

4. Run the following command:

        java -cp "recreateroot-1.0-SNAPSHOT.jar:*" org.neo4j.RootNodeCreator <path to your neo4j/data/graph.db>

For example:

        java -cp "recreateroot-1.0-SNAPSHOT.jar:*" org.neo4j.RootNodeCreator /Users/maxdemarzi/Projects/neography/neo4j/data/graph.db 
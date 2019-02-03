# Jooq Batch Insert Bug
Batch inserting records with a version inserts the version but does not update the record in place.
See [FoobarTest.java](src/test/java/com/github/yaseenkadir/jbivb/tables/records/FoobarTest.java)

## Setup
```bash
docker-compose up
docker exec -it sample-db /bin/bash

# In the new terminal
# psql -U sample
# CREATE TABLE foobar (id BIGINT PRIMARY KEY NOT NULL, version INT NOT NULL );
# \q

mvn clean install
```

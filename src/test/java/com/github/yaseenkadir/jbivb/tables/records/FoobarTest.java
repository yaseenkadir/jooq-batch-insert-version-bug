package com.github.yaseenkadir.jbivb.tables.records;

import com.github.yaseenkadir.jbivb.Tables;
import org.jooq.DSLContext;
import org.jooq.Record;
import org.jooq.Result;
import org.jooq.exception.DataChangedException;
import org.jooq.impl.DSL;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

public class FoobarTest {

    private DSLContext dslContext;

    @BeforeEach
    public void setup() {
        dslContext = DSL.using("jdbc:postgresql://localhost:5432/sample", "sample", "dolphins");
        dslContext.settings().withExecuteWithOptimisticLocking(true);
//        dslContext.settings().withExecuteWithOptimisticLockingExcludeUnversioned(true);
        dslContext.delete(Tables.FOOBAR).execute();
    }

    @Test
    public void batchInsertInsertsVersionButDoesNotUpdateRecord() {
        FoobarRecord foobarRecord1 = dslContext.newRecord(Tables.FOOBAR);
        foobarRecord1.setId(1L);
        FoobarRecord foobarRecord2 = dslContext.newRecord(Tables.FOOBAR);
        foobarRecord2.setId(2L);

        List<FoobarRecord> records = new ArrayList<>();
        records.add(foobarRecord1);
        records.add(foobarRecord2);

        dslContext.batchInsert(records).execute();

        // Should not be null
        assertNull(foobarRecord1.getVersion());
        assertNull(foobarRecord2.getVersion());

        // The result exists in both
        Result<Record> result = dslContext.select()
                .from(Tables.FOOBAR)
                .fetch();
        int foobar1Version = result.getValue(0, Tables.FOOBAR.VERSION);
        int foobar2Version = result.getValue(0, Tables.FOOBAR.VERSION);

        assertEquals(1, foobar1Version);
        assertEquals(1, foobar2Version);
    }

    @Test
    public void insertWorks() {
        FoobarRecord foobarRecord1 = dslContext.newRecord(Tables.FOOBAR);
        foobarRecord1.setId(1L);
        FoobarRecord foobarRecord2 = dslContext.newRecord(Tables.FOOBAR);
        foobarRecord2.setId(2L);

        foobarRecord1.insert();
        foobarRecord2.insert();

        assertEquals(1, foobarRecord1.getVersion().intValue());
        assertEquals(1, foobarRecord2.getVersion().intValue());
    }

    @Test()
    public void versionMismatchThrows() {
        FoobarRecord foobarRecord1 = dslContext.newRecord(Tables.FOOBAR);
        foobarRecord1.setId(1L);
        foobarRecord1.insert();

        assertEquals(1L, foobarRecord1.getVersion().intValue());

        FoobarRecord foobarRecord2 = dslContext.newRecord(Tables.FOOBAR);
        foobarRecord2.setId(1L);
        foobarRecord2.setVersion(0);
        assertThrows(DataChangedException.class, () -> foobarRecord2.update());
    }
}

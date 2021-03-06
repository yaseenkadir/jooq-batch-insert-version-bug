/*
 * This file is generated by jOOQ.
 */
package com.github.yaseenkadir.jbivb.tables;


import com.github.yaseenkadir.jbivb.Public;
import com.github.yaseenkadir.jbivb.tables.records.FoobarRecord;

import java.util.Arrays;
import java.util.List;

import javax.annotation.Generated;

import org.jooq.Field;
import org.jooq.Name;
import org.jooq.Schema;
import org.jooq.Table;
import org.jooq.TableField;
import org.jooq.UniqueKey;
import org.jooq.impl.DSL;
import org.jooq.impl.Internal;
import org.jooq.impl.TableImpl;


/**
 * This class is generated by jOOQ.
 */
@Generated(
    value = {
        "http://www.jooq.org",
        "jOOQ version:3.11.9"
    },
    comments = "This class is generated by jOOQ"
)
@SuppressWarnings({ "all", "unchecked", "rawtypes" })
public class Foobar extends TableImpl<FoobarRecord> {

    private static final long serialVersionUID = 152463081;

    /**
     * The reference instance of <code>public.foobar</code>
     */
    public static final Foobar FOOBAR = new Foobar();

    /**
     * The class holding records for this type
     */
    @Override
    public Class<FoobarRecord> getRecordType() {
        return FoobarRecord.class;
    }

    /**
     * The column <code>public.foobar.id</code>.
     */
    public final TableField<FoobarRecord, Long> ID = createField("id", org.jooq.impl.SQLDataType.BIGINT.nullable(false), this, "");

    /**
     * The column <code>public.foobar.version</code>.
     */
    public final TableField<FoobarRecord, Integer> VERSION = createField("version", org.jooq.impl.SQLDataType.INTEGER.nullable(false), this, "");

    /**
     * Create a <code>public.foobar</code> table reference
     */
    public Foobar() {
        this(DSL.name("foobar"), null);
    }

    /**
     * Create an aliased <code>public.foobar</code> table reference
     */
    public Foobar(String alias) {
        this(DSL.name(alias), FOOBAR);
    }

    /**
     * Create an aliased <code>public.foobar</code> table reference
     */
    public Foobar(Name alias) {
        this(alias, FOOBAR);
    }

    private Foobar(Name alias, Table<FoobarRecord> aliased) {
        this(alias, aliased, null);
    }

    private Foobar(Name alias, Table<FoobarRecord> aliased, Field<?>[] parameters) {
        super(alias, null, aliased, parameters, DSL.comment(""));
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Schema getSchema() {
        return Public.PUBLIC;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public UniqueKey<FoobarRecord> getPrimaryKey() {
        return Internal.createUniqueKey(com.github.yaseenkadir.jbivb.tables.Foobar.FOOBAR, "foobar_pkey", com.github.yaseenkadir.jbivb.tables.Foobar.FOOBAR.ID);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public List<UniqueKey<FoobarRecord>> getKeys() {
        return Arrays.<UniqueKey<FoobarRecord>>asList(
              Internal.createUniqueKey(com.github.yaseenkadir.jbivb.tables.Foobar.FOOBAR, "foobar_pkey", com.github.yaseenkadir.jbivb.tables.Foobar.FOOBAR.ID)
        );
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public TableField<FoobarRecord, Integer> getRecordVersion() {
        return VERSION;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Foobar as(String alias) {
        return new Foobar(DSL.name(alias), this);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Foobar as(Name alias) {
        return new Foobar(alias, this);
    }

    /**
     * Rename this table
     */
    @Override
    public Foobar rename(String name) {
        return new Foobar(DSL.name(name), null);
    }

    /**
     * Rename this table
     */
    @Override
    public Foobar rename(Name name) {
        return new Foobar(name, null);
    }
}

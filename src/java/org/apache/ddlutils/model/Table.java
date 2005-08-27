package org.apache.ddlutils.model;

/*
 * Copyright 1999-2004 The Apache Software Foundation.
 * 
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 * 
 *      http://www.apache.org/licenses/LICENSE-2.0
 * 
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.apache.commons.collections.Predicate;
import org.apache.commons.collections.list.PredicatedList;

/**
 * Represents a table in the database model.
 * 
 * @version $Revision$
 */
public class Table implements Serializable, Cloneable
{
    /** Unique ID for serialization purposes */
    private static final long serialVersionUID = -5541154961302342608L;

    /** The catalog of this table as read from the database */
    private String _catalog = null;
    /** The table's schema */
    private String _schema = null;
    /** The name */
    private String _name = null;
    /** A desription of the table */
    private String _description = null;
    /** The table's type as read from the database */
    private String _type = null;
    /** The columns in this table */
    private ArrayList _columns = new ArrayList();
    /** The foreign keys associated to this table */
    private ArrayList _foreignKeys = new ArrayList();
    /** The indices applied to this table */
    private ArrayList _indices = new ArrayList();

    /**
     * Returns the catalog of this table as read from the database.
     * 
     * @return The catalog
     */
    public String getCatalog()
    {
        return _catalog;
    }

    /**
     * Sets the catalog of this table.
     * 
     * @param catalog The catalog
     */
    public void setCatalog(String catalog)
    {
        _catalog = catalog;
    }

    /**
     * Returns the schema of this table as read from the database.
     * 
     * @return The schema
     */
    public String getSchema()
    {
        return _schema;
    }

    /**
     * Sets the schema of this table.
     * 
     * @param schema The schema
     */
    public void setSchema(String schema)
    {
        _schema = schema;
    }

    /**
     * Returns the type of this table as read from the database.
     * 
     * @return The type
     */
    public String getType()
    {
        return _type;
    }

    /**
     * Sets the type of this table.
     * 
     * @param type The type
     */
    public void setType(String type)
    {
        _type = type;
    }

    /**
     * Returns the name of the table.
     * 
     * @return The name
     */
    public String getName()
    {
        return _name;
    }

    /**
     * Sets the name of the table.
     * 
     * @param name The name
     */
    public void setName(String name)
    {
        _name = name;
    }

    /**
     * Returns the description of the table.
     *
     * @return The description
     */
    public String getDescription()
    {
        return _description;
    }

    /**
     * Sets the description of the table.
     *
     * @param description The description
     */
    public void setDescription(String description)
    {
        _description = description;
    }

    /**
     * Returns the number of columns in this table.
     * 
     * @return The number of columns
     */
    public int getColumnCount()
    {
        return _columns.size();
    }

    /**
     * Returns the column at the specified position.
     * 
     * @param idx The column index
     * @return The column at this position
     */
    public Column getColumn(int idx)
    {
        return (Column)_columns.get(idx);
    }

    /**
     * Returns the columns in this table.
     * 
     * @return The columns
     */
    public Column[] getColumns()
    {
        return (Column[])_columns.toArray(new Column[_columns.size()]);
    }

    /**
     * Adds the given column.
     * 
     * @param column The column
     */
    public void addColumn(Column column)
    {
        if (column != null)
        {
            _columns.add(column);
        }
    }

    /**
     * Adds the given column at the specified position .
     * 
     * @param idx    The index where to add the column
     * @param column The column
     */
    public void addColumn(int idx, Column column)
    {
        if (column != null)
        {
            _columns.add(idx, column);
        }
    }

    /**
     * Removes the given column.
     * 
     * @param column The column to remove
     */
    public void removeColumn(Column column)
    {
        if (column != null)
        {
            _columns.remove(column);
        }
    }

    /**
     * Removes the indicated column.
     * 
     * @param idx The index of the column to remove
     */
    public void removeColumn(int idx)
    {
        _columns.remove(idx);
    }

    /**
     * Returns the number of foreign keys.
     * 
     * @return The number of foreign keys
     */
    public int getForeignKeyCount()
    {
        return _foreignKeys.size();
    }

    /**
     * Returns the foreign key at the given position.
     * 
     * @param idx The foreign key index
     * @return The foreign key
     */
    public ForeignKey getForeignKey(int idx)
    {
        return (ForeignKey)_foreignKeys.get(idx);
    }

    /**
     * Returns the foreign keys of this table.
     * 
     * @return The foreign keys
     */
    public ForeignKey[] getForeignKeys()
    {
        return (ForeignKey[])_foreignKeys.toArray(new ForeignKey[_foreignKeys.size()]);
    }

    /**
     * Adds the given foreign key.
     * 
     * @param foreignKey The foreign key
     */
    public void addForeignKey(ForeignKey foreignKey)
    {
        if (foreignKey != null)
        {
            _foreignKeys.add(foreignKey);
        }
    }

    /**
     * Adds the given foreign key at the specified position.
     * 
     * @param idx        The index to add the foreign key at
     * @param foreignKey The foreign key
     */
    public void addForeignKey(int idx, ForeignKey foreignKey)
    {
        if (foreignKey != null)
        {
            _foreignKeys.add(idx, foreignKey);
        }
    }

    /**
     * Removes the given foreign key.
     * 
     * @param foreignKey The foreign key to remove
     */
    public void removeForeignKey(ForeignKey foreignKey)
    {
        if (foreignKey != null)
        {
            _foreignKeys.remove(foreignKey);
        }
    }

    /**
     * Removes the indicated foreign key.
     * 
     * @param idx The index of the foreign key to remove
     */
    public void removeForeignKey(int idx)
    {
        _foreignKeys.remove(idx);
    }

    /**
     * Returns the number of indices.
     * 
     * @return The number of indices
     */
    public int getIndexCount()
    {
        return _indices.size();
    }

    /**
     * Returns the index at the specified position.
     * 
     * @param idx The position
     * @return The index
     */
    public Index getIndex(int idx)
    {
        return (Index)_indices.get(idx);
    }

    /**
     * Adds the given index.
     * 
     * @param index The index
     */
    public void addIndex(Index index)
    {
        if (index != null)
        {
            _indices.add(index);
        }
    }

    /**
     * Adds the given index at the specified position.
     * 
     * @param idx   The position to add the index at
     * @param index The index
     */
    public void addIndex(int idx, Index index)
    {
        if (index != null)
        {
            _indices.add(idx, index);
        }
    }

    /**
     * Returns the indices of this table.
     * 
     * @return The indices
     */
    public Index[] getIndices()
    {
        return (Index[])_indices.toArray(new Index[_indices.size()]);
    }

    /**
     * Gets a list of non-unique indices on this table.
     * 
     * @return The unique indices
     */
    public Index[] getNonUniqueIndices()
    {
        List nonUniqueIndices = PredicatedList.decorate(_indices, new Predicate() {
            public boolean evaluate(Object input) {
                return !((Index)input).isUnique();
            }
        });

        return (Index[])nonUniqueIndices.toArray(new Index[nonUniqueIndices.size()]);
    }

    /**
     * Gets a list of unique indices on this table.
     * 
     * @return The unique indices
     */
    public Index[] getUniqueIndices()
    {
        List uniqueIndices = PredicatedList.decorate(_indices, new Predicate() {
            public boolean evaluate(Object input) {
                return ((Index)input).isUnique();
            }
        });

        return (Index[])uniqueIndices.toArray(new Index[uniqueIndices.size()]);
    }

    /**
     * Removes the given index.
     * 
     * @param index The index to remove
     */
    public void removeIndex(Index index)
    {
        if (index != null)
        {
            _indices.remove(index);
        }
    }

    /**
     * Removes the indicated index.
     * 
     * @param idx The position of the index to remove
     */
    public void removeIndex(int idx)
    {
        _indices.remove(idx);
    }

    // Helper methods
    //-------------------------------------------------------------------------

    /**
     * @return true if there is at least one primary key column
     *  on this table
     */
    public boolean hasPrimaryKey()
    {
        for (Iterator it = _columns.iterator(); it.hasNext(); )
        {
            Column column = (Column)it.next();

            if (column.isPrimaryKey())
            {
                return true;
            }
        }
        return false;
    }

    /**
     * Finds the column with the specified name, using case insensitive matching.
     * Note that this method is not called getColumn(String) to avoid introspection
     * problems.
     * 
     * @param name The name of the column
     * @return The column or <code>null</code> if there is no such column
     */
    public Column findColumn(String name)
    {
        return findColumn(name, false);
    }

    /**
     * Finds the column with the specified name, using case insensitive matching.
     * Note that this method is not called getColumn(String) to avoid introspection
     * problems.
     * 
     * @param name          The name of the column
     * @param caseSensitive Whether case matters for the names
     * @return The column or <code>null</code> if there is no such column
     */
    public Column findColumn(String name, boolean caseSensitive)
    {
        for (Iterator it = _columns.iterator(); it.hasNext(); )
        {
            Column column = (Column)it.next();

            if (caseSensitive)
            {
                if (column.getName().equals(name))
                {
                    return column;
                }
            }
            else
            {
                if (column.getName().equalsIgnoreCase(name))
                {
                    return column;
                }
            }
        }
        return null;
    }

    /**
     * Finds the index with the specified name, using case insensitive matching.
     * Note that this method is not called getIndex to avoid introspection
     * problems.
     * 
     * @param name The name of the index
     * @return The index or <code>null</code> if there is no such index
     */
    public Index findIndex(String name)
    {
        return findIndex(name, false);
    }

    /**
     * Finds the index with the specified name, using case insensitive matching.
     * Note that this method is not called getIndex to avoid introspection
     * problems.
     * 
     * @param name          The name of the index
     * @param caseSensitive Whether case matters for the names
     * @return The index or <code>null</code> if there is no such index
     */
    public Index findIndex(String name, boolean caseSensitive)
    {
        for (int idx = 0; idx < getIndexCount(); idx++)
        {
            Index index = getIndex(idx);

            if (caseSensitive)
            {
                if (index.getName().equals(name))
                {
                    return index;
                }
            }
            else
            {
                if (index.getName().equalsIgnoreCase(name))
                {
                    return index;
                }
            }
        }
        return null;
    }

    /**
     * Finds the foreign key in this table that is equal to the supplied foreign key.
     * 
     * @param key The foreign key to search for
     * @return The found foreign key
     */
    public ForeignKey findForeignKey(ForeignKey key)
    {
        for (int idx = 0; idx < getForeignKeyCount(); idx++)
        {
            ForeignKey fk = getForeignKey(idx);

            if (fk.equals(key))
            {
                return fk;
            }
        }
        return null;
    }

    /**
     * Returns the primary key columns of this table.
     * 
     * @return The primary key columns
     */
    public Column[] getPrimaryKeyColumns()
    {
        List pkColumns = PredicatedList.decorate(_columns, new Predicate() {
            public boolean evaluate(Object input) {
                return ((Column)input).isPrimaryKey();
            }
        });

        return (Column[])pkColumns.toArray(new Column[pkColumns.size()]);
    }

    /**
     * Returns the auto increment column in this table if there is one.
     * 
     * @return The column or <code>null</code> if there is none in this table
     */
    public Column getAutoIncrementColumn()
    {
        for (int idx = 0; idx < getColumnCount(); idx++)
        {
            Column column = getColumn(idx);

            if (column.isAutoIncrement())
            {
                return column;
            }
        }
        return null;
    }

    /* (non-Javadoc)
     * @see java.lang.Object#clone()
     */
    public Object clone() throws CloneNotSupportedException
    {
        Table result = new Table();

        result._catalog     = _catalog;
        result._schema      = _schema;
        result._name        = _name;
        result._type        = _type;
        result._columns     = (ArrayList)_columns.clone();
        result._foreignKeys = (ArrayList)_foreignKeys.clone();
        result._indices     = (ArrayList)_indices.clone();
        return result;
    }

    /* (non-Javadoc)
     * @see java.lang.Object#toString()
     */
    public String toString()
    {
        return "Table " + _name + " [" + _columns.size() + " columns]";
    }
}

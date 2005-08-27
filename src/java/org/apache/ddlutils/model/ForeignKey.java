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

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * Represents a database foreign key.
 */
public class ForeignKey implements Cloneable
{
    //  TODO: Make the create/alter/drop functionality respect the name property

    /** The name of the foreign key, may be <code>null</code> */
    private String    _name;
    /** The target table */
    private Table     _foreignTable;
    /** The name of the foreign table */
    private String    _foreignTableName;
    /** The references between local and remote columns */
    private ArrayList _references = new ArrayList();

    /**
     * Creates a new foreign key object that has no name.
     */
    public ForeignKey()
    {
        this(null);
    }
    
    /**
     * Creates a new foreign key object.
     * 
     * @param name The name of the foreign key
     */
    public ForeignKey(String name)
    {
        _name = name;
    }

    /**
     * Returns the name of this foreign key.
     * 
     * @return The name
     */
    public String getName()
    {
        return _name;
    }

    /**
     * Sets the name of this foreign key.
     * 
     * @param name The name
     */
    public void setName(String name)
    {
        _name = name;
    }

    /**
     * Returns the foreign table.
     *
     * @return The foreign table
     */
    public Table getForeignTable()
    {
        return _foreignTable;
    }

    /**
     * Sets the foreign table.
     *
     * @param foreignTable The foreign table
     */
    public void setForeignTable(Table foreignTable)
    {
        _foreignTable     = foreignTable;
        _foreignTableName = (foreignTable == null ? null : foreignTable.getName());
    }

    /**
     * Returns the name of the foreign table.
     * 
     * @return The table name
     */
    public String getForeignTableName()
    {
        return _foreignTableName;
    }
    
    /**
     * Sets the name of the foreign table. Please note that you should not use this method
     * when manually constructing or manipulating the database model. Rather utilize the
     * {@link #setForeignTable(Table)} method.
     * 
     * @param foreignTableName The table name
     */
    public void setForeignTableName(String foreignTableName)
    {
        if ((_foreignTable != null) && !_foreignTable.getName().equals(foreignTableName))
        {
            _foreignTable = null;
        }
        _foreignTableName = foreignTableName;
    }

    /**
     * Adds a reference, ie. a mapping between a local column (in the table that owns this foreign key)
     * and a remote column.
     * 
     * @param reference The reference to add
     */
    public void addReference(Reference reference)
    {
        _references.add(reference);
    }

    /**
     * Returns the references.
     * 
     * @return The references
     */
    public List getReferences()
    {
        return _references;
    }

    /**
     * Returns the indicated reference.
     * 
     * @param idx The index
     * @return The reference
     */
    public Reference getReference(int idx)
    {
        return (Reference)_references.get(idx);
    }

    /**
     * Returns the first reference if it exists.
     * 
     * @return The first reference
     */
    public Reference getFirstReference()
    {
        return (Reference)(_references.isEmpty() ? null : _references.get(0));
    }

    /* (non-Javadoc)
     * @see java.lang.Object#equals(java.lang.Object)
     */
    public boolean equals(Object other)
    {
        boolean result = (other != null) && getClass().equals(other.getClass());

        if (result)
        {
            ForeignKey fk = (ForeignKey) other;

            result = _foreignTableName.equals(fk._foreignTableName) &&
                     (_references.size() == fk._references.size());

            if (result)
            {
                //check all references - need to ensure order is same for valid comparison
                List copyThis = (List)_references.clone();
                List copyThat = (List)fk._references.clone();

                Collections.sort(copyThis);
                Collections.sort(copyThat);
                result = copyThis.equals(copyThat);
            }
        }
        return result;
    }

    /* (non-Javadoc)
     * @see java.lang.Object#toString()
     */
    public String toString()
    {
        //TODO show name and references
        return "ForeignKey[" + _foreignTableName + "]";
    }

    /* (non-Javadoc)
     * @see java.lang.Object#clone()
     */
    public Object clone() throws CloneNotSupportedException
    {
        ForeignKey result = new ForeignKey(_name);

        result._foreignTableName = _foreignTableName;
        result._references       = (ArrayList)_references.clone();
        return result;
    }
}

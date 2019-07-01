# Hibernate-tutorial
Hibernate is an ORM framework. ORM (Object Relation Mapping) is a mechanism to map object to database tables.

## Difference between get() and load()
* Get : A case of invalid id get() method return null object. It never returns proxy. Get() method support Eager loading.
* Load : A case of invalid id load() method return proxy object. ObjectNotFoundException is thrown. Load() method support Lazy loading.

## Inheritance - IS-A Relationship

> Hibernate supports the three basic inheritance mapping strategies:
 
* Table per class hierarchy

        <hibernate-mapping>
            <class name="com.modal.configuration.InheritanceMapping.IS_A.Person" table="person">
                <id name="id" type="java.lang.Long">
                    <generator class="increment"/>
                </id>
                <discriminator column="type" type="java.lang.String"/>
                <property name="name" type="java.lang.String"/>
        
                <subclass name="com.modal.configuration.InheritanceMapping.IS_A.Student" discriminator-value="st">
                    <property name="cource" type="java.lang.String"/>
                    <property name="fee" type="int"/>
                </subclass>
        
                <subclass name="com.modal.configuration.InheritanceMapping.IS_A.Emp" discriminator-value="emp">
                    <property name="job" type="java.lang.String"/>
                    <property name="salary" type="java.lang.Long"/>
                </subclass>
            </class>
        </hibernate-mapping>

* Table per subclass

        <hibernate-mapping>
            <class name="com.modal.configuration.InheritanceMapping.IS_A.Person" table="person">
                <id type="java.lang.Long" name="id" column="id">
                    <generator class="increment"/>
                </id>
                <property name="name" column="name" type="java.lang.String"/>
        
                <joined-subclass name="com.modal.configuration.InheritanceMapping.IS_A.Student" table="student">
                    <key column="st_id"></key>
                    <property name="cource" type="java.lang.String"/>
                    <property name="fee" type="int"/>
                </joined-subclass>
        
                <joined-subclass name="com.modal.configuration.InheritanceMapping.IS_A.Emp" table="emp">
                    <key column="emp_id"></key>
                    <property name="job" type="java.lang.String"/>
                    <property name="salary" type="java.lang.Long"/>
                </joined-subclass>
            </class>
        </hibernate-mapping>

* Table per concrete class 
    
        <hibernate-mapping>
            <class table="person" name="com.modal.configuration.InheritanceMapping.IS_A.Person">
                <id name="id" column="id" type="java.lang.Long">
                    <generator class="increment"/>
                </id>
                <property name="name" type="java.lang.String"/>
        
                <union-subclass name="com.modal.configuration.InheritanceMapping.IS_A.Student" table="student">
                    <property name="cource" type="java.lang.String"/>
                    <property name="fee" type="int"/>
                </union-subclass>
        
                <union-subclass name="com.modal.configuration.InheritanceMapping.IS_A.Emp" table="emp">
                    <property name="job" type="java.lang.String"/>
                    <property name="salary" type="java.lang.Long"/>
                </union-subclass>
        
            </class>
        </hibernate-mapping>
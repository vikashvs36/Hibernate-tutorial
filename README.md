# Hibernate-tutorial
Hibernate is an ORM framework. ORM (Object Relation Mapping) is a mechanism to map object to database tables.

## Difference between get() and load()
* Get : A case of invalid id get() method return null object. It never returns proxy. Get() method support Eager loading.
* Load : A case of invalid id load() method return proxy object. ObjectNotFoundException is thrown. Load() method support Lazy loading.

## Inheritance - IS-A Relationship

> ### Hibernate supports the three basic inheritance mapping strategies:
 
* Table per class hierarchy

    > ### Configuration Strategy

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
    
    > ### Annotation Strategy
    
        @Entity
        @Inheritance(strategy = InheritanceType.SINGLE_TABLE)
        @DiscriminatorColumn(name = "type", discriminatorType = DiscriminatorType.STRING)
        @DiscriminatorValue(value = "emp")
        public class Emp {
        
        @Entity
        @DiscriminatorValue(value = "regular_emp")
        public class RegularEmp extends Emp {

* Table per subclass

    > ### Configuration Strategy

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
    
    > ### Annotation Strategy
    
        @Entity
        @Inheritance(strategy = InheritanceType.JOINED)
        public class Emp {
        
        @Entity
        @PrimaryKeyJoinColumn(name = "id")
        public class RegularEmp extends Emp {

* Table per concrete class 

    > ### Configuration Strategy
    
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
    
    > ### Annotation Strategy
    
        @Entity
        @Inheritance(strategy = InheritanceType.TABLE_PER_CLASS)
        public class Emp {
            
        @Entity
        @Table(name = "regular_emp")
        @AttributeOverrides({
            @AttributeOverride(name="id", column=@Column(name="id")),
            @AttributeOverride(name="name", column=@Column(name="name"))
        })
        public class RegularEmp extends Emp {
       
You can visit "https://docs.jboss.org/hibernate/core/3.3/reference/en/html/inheritance.html" for more information.

## Embedded

   > ### Annotation Strategy

        @Entity
        @Table(name = "user")
        public class User {
        
            @Id
            @GeneratedValue(strategy = GenerationType.AUTO)
            private int id;
            private String username;
            @Embedded
            @AttributeOverrides({
                    @AttributeOverride(name = "city", column = @Column(name = "home_city")),
                    @AttributeOverride(name = "state", column = @Column(name = "home_state")),
                    @AttributeOverride(name = "country", column = @Column(name = "home_country")),
                    @AttributeOverride(name = "pincode", column = @Column(name = "home_pincode"))
            })
            private Address home_address;
            @Embedded
            private Address office_address;
            // Setter and getter
        }    
   
        @Embeddable
        public class Address {
            private String state;
            private String country;
            // Setter and getter
        }

## Relationships 

There are four types of mapping. which is given below :

* One To One
* One To Many
* Many To One 
* Many To Many

Each of these relation can be Uni-directional and Bi-directional.

> ### Uni-directional

In Uni-directional relation can be access from only one side. It's only from main or owner entity. for example if 
there are two table User and Profile then we can access Profile properties from User side but we can't access user
from Profile side. 

> ### Bi-directional

In Uni-directional relation can be access from both of side. It may be main entity or relational entity. for example
if there are two table User and Profile then we can access Profile properties from User side and also access user 
from Profile side.

## One To One - Relation

One to One relation can be mapped in the flowing three ways :

* Same primary key mapping
* Primary key foreign key mapping
* Relation table mapping

### Implement One To One relation using Uni-directional

> ### Same primary key mapping

In this approach, Owner and owned entity tables are mapped by using the same primary key values in the related records.

**Configuration Based**

    <hibernate-mapping>
        <-- Owned entity -->
        <class name="com.modal.has_A_RelationShip.oneToOne.configuration.uniDirectional.Capital" table="capital">
            <id name="id" type="int">
                <generator class="increment" />
            </id>
            <property name="name" type="java.lang.String"/>
        </class>
    
        <-- Owner entity -->
        <class name="com.modal.has_A_RelationShip.oneToOne.configuration.uniDirectional.State" table="state">
            <id type="int" name="id">
                <generator class="foreign">
                    <param name="property">capital</param>
                </generator>
            </id>
    
            <property name="name" type="java.lang.String"/>
            <one-to-one name="capital" 
                        class="com.modal.has_A_RelationShip.oneToOne.configuration.uniDirectional.Capital" 
                        cascade="all"/>
        </class>
    </hibernate-mapping>
    
**Annotation Based**  
    
    @Entity
    @Table(name = "user")
    public class User {
    
        @Id
        @GeneratedValue(generator= "foreigngen")
        private long id;
        private String username, password;
        @OneToOne(cascade = CascadeType.ALL)
        @PrimaryKeyJoinColumn
        private Profile profile;
        
        // Setter and Getter    
    }
    
    @Entity
    @Table(name = "profile")
    public class Profile {
    
        @Id
        @GeneratedValue
        private int id;
        private String address;
        
        // Setter and Getter    
    }


  
    
 
> ### Primary key foreign key mapping

In this Approach, Entities are mapped is using by the primary key of owned entity table as the foreign key in th owner
entity table.

**Configuration Based**

    <hibernate-mapping>
        <-- Owned entity -->
        <class name="com.modal.has_A_RelationShip.oneToOne.configuration.uniDirectional.Capital" table="capital">
            <id name="id" type="int">
                <generator class="increment" />
            </id>
            <property name="name" type="java.lang.String"/>
        </class>
    
        <-- Owner entity -->
        <class name="com.modal.has_A_RelationShip.oneToOne.configuration.uniDirectional.State" table="state">
            <id type="int" name="id">
                <generator class="increment"/>
            </id>
            <property name="name" type="java.lang.String"/>
    
            <many-to-one unique="true" name="capital"
                         class="com.modal.has_A_RelationShip.oneToOne.configuration.uniDirectional.Capital"
                         column="capital_id"
                         cascade="all"/>
        </class>
    </hibernate-mapping>
    

**Annotation Based**  

    
    
> ### Relation table mapping

In this approach, Both entities are linked with the help of the relation table which contains primary key of 
both the table as foreign key. That mean a third table will be created.

**Configuration Based**

    <hibernate-mapping>
        <class name="com.modal.has_A_RelationShip.oneToOne.configuration.uniDirectional.Capital" table="capital">
            <id name="id" type="int">
                <generator class="increment" />
            </id>
            <property name="name" type="java.lang.String"/>
        </class>
    
        <class name="com.modal.has_A_RelationShip.oneToOne.configuration.uniDirectional.State" table="state">
            <id type="int" name="id">
                <generator class="increment"/>
            </id>
            <property name="name" type="java.lang.String"/>
    
            <join table="state_capital">
                <key column="state_id"/>
    
                <many-to-one unique="true" name="capital"
                         class="com.modal.has_A_RelationShip.oneToOne.configuration.uniDirectional.Capital"
                         column="capital_id"
                         cascade="all"/>
            </join>
        </class>
    </hibernate-mapping>


### Implement One To One relation using Bi-directional


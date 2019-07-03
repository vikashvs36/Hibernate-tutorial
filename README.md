# Hibernate-tutorial
Hibernate is an ORM framework. ORM (Object Relation Mapping) is a mechanism to map object to database tables.

## Difference between get() and load()
* Get : A case of invalid id get() method return null object. It never returns proxy. Get() method support Eager loading.
* Load : A case of invalid id load() method return proxy object. ObjectNotFoundException is thrown. Load() method support Lazy loading.

## Inheritance - IS-A Relationship

> Hibernate supports the three basic inheritance mapping strategies:
 
* Table per class hierarchy

    > Configuration Strategy

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
    
    > Annotation Strategy
    
        @Entity
        @Inheritance(strategy = InheritanceType.SINGLE_TABLE)
        @DiscriminatorColumn(name = "type", discriminatorType = DiscriminatorType.STRING)
        @DiscriminatorValue(value = "emp")
        public class Emp {
        
        @Entity
        @DiscriminatorValue(value = "regular_emp")
        public class RegularEmp extends Emp {

* Table per subclass

    > Configuration Strategy

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
    
    > Annotation Strategy
    
        @Entity
        @Inheritance(strategy = InheritanceType.JOINED)
        public class Emp {
        
        @Entity
        @PrimaryKeyJoinColumn(name = "id")
        public class RegularEmp extends Emp {

* Table per concrete class 

    > Configuration Strategy
    
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
    
    > Annotation Strategy
    
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

   > Annotation Strategy

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


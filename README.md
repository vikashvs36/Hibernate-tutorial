# Hibernate-tutorial
Hibernate is an ORM framework. ORM (Object Relation Mapping) is a mechanism to map object to database tables.

## Difference between get() and load()
* Get : A case of invalid id get() method return null object. It never returns proxy. Get() method support Eager loading.
* Load : A case of invalid id load() method return proxy object. ObjectNotFoundException is thrown. Load() method support Lazy loading.


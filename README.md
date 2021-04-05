# ddd-springboot-kata

This repo is to leverage spring boot sample project to refactor to ddd tactical design, way to point out the key steps in implementing function codes from test.

## Architecture design follow Onion Architecture

At beginning, we defined the layered architecture for separating responsibility, in order to better guide new-comers to know each layer's responsibility and mapping classic clean-architecture layers, design conventions, and DDD tactical design patterns, the following layers explained detail:

folders under Bounded Context name -

**Anti-corruption Layer as translator in each layer**

From traditional design, there is always a database-table-like entity pass through-out to client, it leads to huge impact when modifying entities then each layer updates is a need.

In order to well protect inner layers object not being impacted, when receiving external layer pass-in argument objects, translate it into inner layer objects for further instructions.

**Models**

* AggregateRoot
* Aggregate
* Entity
* Value Object
* Interfaces  
* Repository (***interface only***)
* Services
  
**Infrastructure**

* Data access implementation
* Migrations  
* Cache
* Logging
* All the infra-specific services  

**Interfaces (User Interface)**
* Controllers
* Views
* ViewModels
* GUI project

**Configurations (aka.Framework and Drivers)**

* Framework configurations
* Database Driver configurations
* Middleware settings

**DDD Patterns**


(In Spring boot framework, all of these configurations could be place here)

## Kata objectives

This kata guide DDD practitioners to refactor legacy code into Clean Architecture design, and by adding tests to make  sure all of these modifications still satisfied business requirements.

### 1 - Add test for inquiry all tutorials
### 2 - Extract I/O object types to DTO 
### 3 - Add test for creating tutorial


--------

## How to run sample app
There are a few default sample data loaded while starting application, spring boot will load data from /resources/data.sql : 
```
insert into tutorials values (1,'test1','yes','kimtest');
insert into tutorials values (2,'test2','yes','fongtest');
insert into tutorials values (3,'test3','yes','arthurtest');
insert into tutorials values (4,'test4','yes','rivertest');
```

To start the sample app, you need to build first and run : 

```
cd $sourceCodeFolder/

//check there is a build.gradle file in current folder, then : 

gradle build

gradle bootRun
```

To check the data insertions runs well, just open browser and visit : 
> http://localhost:8080/h2-ui
> 
modify the jdbc url to : 
> jdbc:h2:mem:testdb
> 
then login :D 

Test application by simplify using curl command : 
> curl http://localhost:8080/api/tutorials | jq '.'
> 

Sample data output
```
[
  {
    "id": 1,
    "title": "kimtest",
    "description": "test1",
    "published": true
  },
  {
    "id": 2,
    "title": "fongtest",
    "description": "test2",
    "published": true
  },
  {
    "id": 3,
    "title": "arthurtest",
    "description": "test3",
    "published": true
  },
  {
    "id": 4,
    "title": "rivertest",
    "description": "test4",
    "published": true
  }
]
```

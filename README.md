# ddd-springboot-kata

This repo is to leverage spring boot sample project to refactory to ddd tactical design, way to point out the key steps in implementing function codes from test.

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

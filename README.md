# Group 140 CSC207 project: Q/A forum
## Group members (alphabetical order by last name):
Chihan Cui, Qianjun Huang, Liwei Yang, Jiawei Yu,  Gangquan Zhang, Xiling Zhao, Yuyang Zhao, Jiajie Zhu
### Task assignment
# Project introduction
## 1. Entities
### 1.1 User.java
User.java is a class that is used to store the data of each individual user/administrator of the forum. \
\
The user object has the following attributes:
* username
* userid
* password
* email

The entity provides interfaces for other functions to modify the username, password, and email. The userid, however,
is immutable once registration.
### 1.2 Course.java
Course.java is a class that is used to store the data of each specific course registrated on the forum.
\
The course object  has the following attributes:
* course name
* course code
* course description
* semester offering
* course instructor(s)
* students

Most attributes for the course objects, once created, are immutable. The object only provides two
functions to add/remove students.
### 1.3 Post.java
Post.java is a class that is used to store the data of the posts in the forum. \
The posts has the following attributes:
* topic
* texts
* images
* comments
* posted by which user

The post object, once created, are modifiable, and can be commented by other user objects. \
Some attributes, however, like the user who posted this thread, is immutable and viewable to everyone.
### 1.4 Comment.java
Comment.java is a class that used to store the data of each comment to a post.\
The posts has the following attributes.
* texts
* images
* comments
* posted by which user

The comment object is very similar to a post. However, it must be attached to a post or another comment.
### 1.5 Report.java
Comment.java is a class that used to store the data of a report of a problem in a forum to be viewed and resolved by the administrator.\
The posts has the following attributes.
* report type
* content
* posted by which user

All of the information of the Report object, once created, are immutable.
## 2. Use cases
### 2.1 Course use case
The course use case provides interface to create, modify, and delete course information. It has following functions:
* addCourse()
Function **addCourse()** takes in the course information and attempt to create the course and 
return *true*. If the course already exist, do nothing and return *false*. 


* modifyCourse()
Function **modifyCourse()** takes in the course information and attempt to modify the course and
  return *true*. If the course does not exist, do nothing and return *false*.


* deleteCourse()
Function **deleteCourse()** takes some in the course information and attempt to create the course and
  return *true*. If the course information does not match, do nothing and return *false*.

### 2.2 Login use case
### 2.3 User use case
### 2.4 Post use case
### 2.5 report use case

## 3. Controllers
## 4. Graphical User Interface

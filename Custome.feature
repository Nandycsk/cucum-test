#Please Do not change Feature Templet
Feature: To test the application to calculate college fee for different type of student
#Please Do not change Scenario Outline Templet
Scenario Outline: To calculate college fee for different type of student
#Please Do not change Given Templet
Given Browser is launched and user is on application page
When User Enters student name,"<Student_type>","<Student_per_room>"
When User clicks on the calculate fee button
Then "<College_fee>","<hostel_fee>,"<additional_fee>,"<total_fee>" should be correctly displayed
 
Examples:
 
|Student_type|Student_per_room|College_fee|hostel_fee|additional_fee|total_fee|
|Day Scholar | |120000 | | |120000 |
|Hosteler |1 |120000 |75750 |30300 |226050 |
|Hosteler |2 |120000 |75750 |15150 |210900 |
|Hosteler |3 |120000 |75750 | |195750 |
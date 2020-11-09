Feature: Fee Calculation app
 Scenario Outline: Validate fee calculation
 Given firefox is started and navigated to index page
 When I enter student name, student type "<Student Type>", Number of Students Per room "<Students per room>" and click the get total fee button.
 Then I validate College Fee "<College Fee>", Hostel Fee "<Hostel Fee>", Additional Fee "<Additional Fee>", Total Fee "<Total Fee>" and close the driver with quit method
 
 Examples:
 |Student Type|Students per room|College Fee|Hostel Fee|Additional Fee|Total Fee|
 |Day Scholar| 0 |120000| 0 |0 |120000| 
 |Hosteller |1 |120000| 75750 |30300| 226050| 
 |Hosteller| 2 |120000 |75750| 15150 |210900 |
 |Hosteller| 3 |120000 |75750| 0| 195750| 
 
 
 
Feature: check functionalities on website

  @uitesting
  Scenario: checking the table of people's details
    When From main menu click on 'Sort and Tables'
    And Check if table contains more than 25 records
    And Sort the data by Age descending
    Then Check if the 1st person in the table is older than 65



@ui
@firefox
Feature:Login Session

  Scenario: Check browser forward after logout
    Given Navigate to login page
    And Enter valid UserId and Password and click Login
    And Should see login successful
    When Click Log out button
    Then Should see browser not allowed to forward and session closed

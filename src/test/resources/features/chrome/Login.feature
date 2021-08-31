@ui
@chrome

Feature:Login

  Scenario: Success Login
    Given Navigate to login page
    When Enter valid UserId and Password and click Login
    Then Should see login successful

  Scenario: Failed scenario for screenshot
    Given Navigate to login page
    When Enter valid UserId and Password and click Login
    Then Should see login Failed

  Scenario: Invalid Password Valid User Login
    Given Navigate to login page
    When  Enter valid User and invalid Password and click Login
    Then Should see login Failed

  Scenario: Invalid User Valid Password Login
    Given Navigate to login page
    When Enter invalid User and valid Password and click Login
    Then Should see login Failed

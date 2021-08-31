@ui
@chrome
Feature: Favorite Restaurant

    #Make test restaurant non-favorite for automation reuse
  Scenario: Make Test Restaurant NOT Favorite
    Given Logged in Successfully
    Given Search test restaurant and make it non-favorite

  Scenario: Add Favorite
    Given Logged in Successfully
    And Search for non-favorite restaurant and go to restaurants page
    And Click 'Favorite' button in restaurant page
    And Should see favorite button text is "Favorilerden Çıkar"
    When Go to main page and click favorites tab
    Then Should see restaurant LISTED in favorites

  Scenario: Remove Favorite
    Given Logged in Successfully
    And Search for non-favorite restaurant and go to restaurants page
    And Should see favorite button text is "Favorilere Ekle"
    When Go to main page and click favorites tab
    Then Should see restaurant NOT listed in favorites

  Scenario: Check if Favorite Restaurant Reachable from Main Page
    Given Logged in Successfully
    And Search for non-favorite restaurant and go to restaurants page
    And Click 'Favorite' button in restaurant page
    And Should see favorite button text is "Favorilerden Çıkar"
    When Go to main page and click favorites tab
    And Click favorite restaurant from favorites tab
    Then Should see restaurant reachable from Favorites

  Scenario: Check Add Favorite Button Works Properly
    Given Logged in Successfully
    And Search for non-favorite restaurant and go to restaurants page
    And Should see favorite button text is "Favorilere Ekle"
    When Click 'Favorite' button in restaurant page
    Then Should see favorite button text is "Favorilerden Çıkar"
    And Click 'Favorite' button in restaurant page
    And Should see favorite button text is "Favorilere Ekle"
    When Go to main page and click favorites tab
    Then Should see restaurant NOT listed in favorites














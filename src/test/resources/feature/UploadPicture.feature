Feature: Upload profile picture
  Scenario: Successfully upload profile picture
    Given I on instagram home page
    When Click on profile option on side bar
    Then Navigate to profile page
    When Click on add profile picture
    And Select a picture
    Then Profile picture is uploaded


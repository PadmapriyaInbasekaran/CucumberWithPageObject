Feature: Search for any product in amazon page

  Scenario Outline: Search for any product in amazon page

    Given : Open amazon.com
    When : Enter <mobileNumber> and click login
    And : Incorrect phone number message should be visible
    When : Locate the searchbar
    And : Enter required mobile name in the searchbar
    And : click on search
    Then : Results page should be displayed
    Examples:
      | mobileNumber |
      | 123456789    |
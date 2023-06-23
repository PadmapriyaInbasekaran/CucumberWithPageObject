Feature: Verify Login page

  @Login
  Scenario Outline: Verify amazon login page with invalid credentials

    Given : Open amazon.com
    When : Enter <mobileNumber> and click login
    Then : Incorrect phone number message should be visible
    Examples:
      | mobileNumber |
      | 123456789    |


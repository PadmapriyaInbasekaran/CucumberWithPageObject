Feature: Add item to cart

  Scenario Outline: Add selected product to cart

    Given : Open amazon.com
    When : Enter <mobileNumber> and click login
    And : Incorrect phone number message should be visible
    When : Locate the searchbar
    And : Enter required mobile name in the searchbar
    And : click on search
    And : Results page should be displayed
    When : click on link
    And : click on deliver to India
    And : Enter <US Zipcode> in the textBox
    And : Click Apply
    And : click continue
    When : Find add to cart button
    And : click
    And : click on No thanks
    Then : Verify item added to cart
    Examples:
      | mobileNumber | US Zipcode |
      | 123456789 | 99950 |
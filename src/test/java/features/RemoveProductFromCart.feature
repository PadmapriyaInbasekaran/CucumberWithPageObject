Feature: Remove product from cart

  Scenario Outline: Remove product in cart

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
    And : Verify item added to cart
    And : click on the cart icon
    When : click delete under the product
    Then : Verify item removed from cart

    Examples:
      | mobileNumber | US Zipcode |
      | 123456789 | 99950 |

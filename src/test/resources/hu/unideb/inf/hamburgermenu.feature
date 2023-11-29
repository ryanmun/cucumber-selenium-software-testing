Feature: Hamburger Menu Test.

  Background:
    Given the homepage is open
    And the Username is filled with 'standard_user'
    And the Password is filled with 'secret_sauce'
    And the Login button is clicked

    Scenario: All items test
      Given the 'Cart' is opened
      And the 'Hamburger Menu' is Clicked
      When the 'inventorySidebarLinkAllItems' option is chosen
      Then the inventory page is opened


    Scenario: Logout option test
      Given the inventory page is opened
      And the 'Hamburger Menu' is Clicked
      When the 'logoutSidebarLinkItemMenu' is Clicked
      Then The Login Screen is open

    Scenario: About option tested when cart is open
      Given the 'Cart' is opened
      And the 'Hamburger Menu' is Clicked
      When the 'aboutSidebarLinkItemMenu' is Clicked
      Then Check if About Webpage is opened

    Scenario: Reset App State option test
      Given the 'Sauce Labs Backpack' is added to the cart
      And the cart badge exists
      And the 'Hamburger Menu' is Clicked
      When the 'resetSidebarLinkAppState' is Clicked
      Then the cart badge does not exist

  Scenario: About option tested when on home page
    Given the homepage is open
    And the Username is filled with 'standard_user'
    And the Password is filled with 'secret_sauce'
    And the Login button is clicked
    And the Hamburger Menu is Clicked
    When About option is Clicked
    Then Check if About Webpage is opened
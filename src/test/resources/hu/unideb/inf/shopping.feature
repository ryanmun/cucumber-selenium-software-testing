Feature: Saucedemo Shopping

  Background:
    Given the home page is opened
    And the 'Username' field is filled with 'standard_user'
    And the 'Password' field is filled with 'secret_sauce'
    And the 'Login' button is clicked

    Scenario: Buying a backpack and t-shirt
      Given the 'Sauce Labs Backpack' is added to the cart
      And the 'Sauce Labs Bolt T-Shirt' is added to the cart
      And the 'Cart' button is clicked
      And the 'Checkout' button is clicked
      And the 'First Name' field is filled with 'testname_first'
      And the 'Last Name' field is filled with 'testname_last'
      And the 'Zip Code' field is filled with '1111'
      When the 'Continue' button is clicked
      Then the price should read 'Total: $49.66'


    Scenario Outline: Buying a backpack and t-shirt
      Given the '<item1>' is added to the cart
      And the '<item2>' is added to the cart
      And the 'Cart' button is clicked
      And the 'Checkout' button is clicked
      And the 'First Name' field is filled with '<firstName>'
      And the 'Last Name' field is filled with '<lastName>'
      And the 'Zip Code' field is filled with '<zipcode>'
      When the 'Continue' button is clicked
      Then the price should read '<total>'
      Examples:
        | item1 | item2 | firstName | lastName | zipcode | total |

        | Sauce Labs Backpack | Sauce Labs Bike Light | Ryan | Munaki | 111 | Total: $43.18 |
        | Sauce Labs Backpack |  | Ryan | Munaki | 111 | Total: $32.39  |

Feature: Buy Product
  Scenario: the user can buy 2 items product back packs with blue colour
    Given user select back pack items
    Given select two items back packs with blue colour
    Given user must be login before checkout
    When user input address and payment method
    Then user success buy product
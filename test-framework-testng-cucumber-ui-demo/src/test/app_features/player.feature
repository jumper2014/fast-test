@player
Feature: Player

#  Scenario: Start apk
#    Given appium is running
#    When remove apk
#    And install apk
#    And start apk
#    Then player is installed
#    And version is 3.11.10


#  Scenario: Remove apk
#    Given appium is running
#    When remove apk
#    Then player is not installed
#
#  Scenario: Install apk
#    Given appium is running
#    When install apk
#    Then player is installed
#
#  Scenario: Swipe
#    Given appium is running
#    When start apk
#    And swipe menu
#    Then player is installed

  Scenario: Swipe
    Given appium is running
    When start apk
    And select channel 1
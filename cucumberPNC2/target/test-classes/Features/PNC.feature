Feature: Open a PNC session, review Virtual Wallet and close window
  Scenario Outline: Access to PNC account
    Given Open Browser
    When Enter url and click on Login button
    Then Enter "<username>" and "<password>"
    And Click on Login button
    Then Go to Virtual Wallet
    And CLose Session
    Examples:
      |username  |password  |
      | ciga210188     | morelia1    |

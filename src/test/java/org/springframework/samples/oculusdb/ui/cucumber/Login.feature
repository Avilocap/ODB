Feature: Traditional Login
  I can do login in the system with my username and password.

  Scenario: Successful login as admin1 (Positive)
    Given I am not logged in the system
    When I do login as testuser
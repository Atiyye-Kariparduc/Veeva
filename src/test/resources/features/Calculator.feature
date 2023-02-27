@Veeva
  #HappyPath
Feature: Carbohydrate Calculator Calculation Logic
  Background:
   When user click "Metrik unit" buttom
  Scenario Outline: Verify calculation logic for carbohydrate intake
    Given the user enters their age as "<age>"
    And the user selects their gender as "<gender>"
    And the user enters their height as "<height>"
    And the user enters their weight as "<weight>"
    And the user selects their activity level as "<activityLevel>"
    When the user submits the form
    Then verify the calculated carbohydrate intake should be "<expectedCarbs>" calories per day

    Examples:
      | age | gender | height | weight | activityLevel | expectedCarbs |
      | 30  | male   | 180    | 75     | 0        | 2,076         |
    #  | 45  | female | 160    | 60     | 1     | 178.5         |
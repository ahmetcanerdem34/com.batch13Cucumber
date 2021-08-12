@rapor1
Feature: Feature: US1005_Amazon Scenario Outline

  Scenario Outline: TC10_Amazon Coklu Arama

    Given kullanici amazon sayfasina gider
    Then "<Meyve>" için arama yapar
    And sonuclarin "<Meyve>" icerdigini test eder

    Examples:
    |Meyve|
    |armut|
    |apple|
    |karpuz|
    |kiraz|
    |elma|
    |erik|
    |avakado|
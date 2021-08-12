
@rapor1
  Feature:US1006_Farkli Url Calistirma

    Scenario Outline:


      Given kullanici "<sayfaUrl>" sayfasina gider

      Examples:
      |sayfaUrl|
      |amazon_url|
      |yandex_url|
      |facebook_url           |
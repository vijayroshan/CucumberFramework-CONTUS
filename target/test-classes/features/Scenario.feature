Feature: To validate the behavior of Whatsapp Web when the application is opened in two tabs of the same browser

Background:
		Given The user launches Chrome Browser
  Scenario: User should be notified if whatsapp application is open in some other tab of the same browser
    Given Login screen of whatsapp web application is displayed
    When User opens whatsapp web application in a new tab
    And Switches back to previous tab
    Then A popup with the message _Whatsapp is open in another window. Click _Use Here_ to use WhatsApp in this window_ should be displayed with _CLOSE_ & _USE HERE_ options

  Scenario: Login page of whatsapp should get loaded by clicking on _USE HERE_ and in the previous tab the popup should be displayed.
    Given A popup with the message _ Whatsapp is open in another window. Click _Use Here_ to use WhatsApp in this window_ and options _CLOSE_ & _USE HERE_ is displayed
    When User clicks on _USE HERE_ option
    Then Login page of whatsapp should get loaded
    And Login page of whatsapp should get loaded
    And In the previous tab, popup with message  _Whatsapp is open in another window. Click _Use Here_ to use WhatsApp in this window_ and options _CLOSE_ & _USE HERE_ should be displayed

  Scenario: Whatsapp home screen should be displayed on clicking on _CLOSE_ option
    Given The popup with the message _ Whatsapp is open in another window. Click _Use Here_ to use WhatsApp in this window_ and options _CLOSE_ & _USE HERE_ is displayed
    When User clicks on _CLOSE_ option
    Then Whatsapp.com page should get loaded

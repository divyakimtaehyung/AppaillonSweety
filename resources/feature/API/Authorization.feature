Feature: authentication API feature

  Background: Backend API should be available

  Scenario Outline: Verify the response message is depend on the Accepted Language parameter for all POST methods in Authorization APIs.
    Given a POST API endpoint for Authorization microservices <testcase>
    When user sends the POST request
    Then system receives Http 2xx HTTP success code
    And receives a valid response
    Examples:
      | testcase |
      | DB-TC-469 |

  Scenario Outline: Verify the response message is depend on the X-Tenant ID parameter for all POST methods in Authorization APIs.
    Given a POST API endpoint for Authorization microservices <testcase>
    When user sends the POST request
    Then system receives Http 2xx HTTP success code
    And receives a valid response
    Examples:
      | testcase |
      | DB-TC-470 |

  Scenario Outline: Verify the response message is depend on the Accepted Language parameter for all PUT methods in Authorization APIs.
    Given a PUT API endpoint for Authorization microservices <testcase>
    When user sends the PUT request
    Then system receives Http 2xx HTTP success code
    And receives a valid response
    Examples:
      | testcase |
      | DB-TC-527 |

  Scenario Outline: Verify the response message is depend on the X-Tenant ID parameter for all PUT methods in Authorization APIs.
    Given a PUT API endpoint for Authorization microservices <testcase>
    When user sends the PUT request
    Then system receives Http 2xx HTTP success code
    And receives a valid response
    Examples:
      | testcase |
      | DB-TC-528 |

  Scenario Outline: Verify the response message is depend on the Accepted Language parameter for all GET methods in Authorization APIs.
    Given a GET API endpoint for Authorization microservices <testcase>
    When user sends the GET request
    Then system receives Http 2xx HTTP success code
    And receives a valid response
    Examples:
      | testcase |
      | DB-TC-535 |

  Scenario Outline: Verify the response message is depend on the X-Tenant ID parameter for all GET methods in Authorization APIs.
    Given a GET API endpoint for Authorization microservices <testcase>
    When user sends the GET request
    Then system receives Http 2xx HTTP success code
    And receives a valid response
    Examples:
      | testcase |
      | DB-TC-536 |

  Scenario Outline: Verify the response message is depend on the Accepted Language parameter for all DELETE methods in Authorization APIs.
    Given a DELETE API endpoint for Authorization microservices <testcase>
    When user sends the DELETE request
    Then system receives Http 2xx HTTP success code
    And receives a valid response
    Examples:
      | testcase |
      | DB-TC-560 |

  Scenario Outline: Verify the response message is depend on the X-Tenant ID parameter for all DELETE methods in Authorization APIs.
    Given a DELETE API endpoint for Authorization microservices <testcase>
    When user sends the DELETE request
    Then system receives Http 2xx HTTP success code
    And receives a valid response
    Examples:
      | testcase |
      | DB-TC-561 |

  Scenario Outline: Verify the fullName field in Add a user API [POST../api/v1/users]
    Given a POST API endpoint for Authorization microservices <testcase>
    When user sets the header params
    And enters invalid fullName in request body
    And sends POST request
    Then system receives 4xx HTTP error code
    And receives a valid application error response
    Examples:
      | testcase |
      | DB-TC-471 |

  Scenario Outline: Verify the countryCode field in Add a user API [POST../api/v1/users]
    Given a POST API endpoint for Authorization microservices <testcase>
    When user sets the header params
    And enters invalid countryCode in request body
    And sends POST request
    Then system receives 4xx HTTP error code
    And receives a valid application error response
    Examples:
      | testcase |
      | DB-TC-472 |

  Scenario Outline: Verify the mobileNumber field in Add a user API [POST../api/v1/users]
    Given a POST API endpoint for Authorization microservices <testcase>
    When user sets the header params
    And enters invalid mobileNumber in request body
    And sends POST request
    Then system receives 4xx HTTP error code
    And receives a valid application error response
    Examples:
      | testcase |
      | DB-TC-473 |

  Scenario Outline: Verify the appType field in Add a user API [POST../api/v1/users]
    Given a POST API endpoint for Authorization microservices <testcase>
    When user sets the header params
    And enters invalid appType in request body
    And sends POST request
    Then system receives 4xx HTTP error code
    And receives a valid application error response
    Examples:
      | testcase |
      | DB-TC-474 |

  Scenario Outline: Verify the roles field in Add a user API [POST../api/v1/users]
    Given a POST API endpoint for Authorization microservices <testcase>
    When user sets the header params
    And enters invalid roles in request body
    And sends POST request
    Then system receives 4xx HTTP error code
    And receives a valid application error response
    Examples:
      | testcase |
      | DB-TC-475 |

  Scenario Outline: Verify the emailId field in Add a user API [POST../api/v1/users]
    Given a POST API endpoint for Authorization microservices <testcase>
    When user sets the header params
    And enters invalid emailId in request body
    And sends POST request
    Then system receives 4xx HTTP error code
    And receives a valid application error response
    Examples:
      | testcase |
      | DB-TC-476 |

  Scenario Outline: Verify that a bank's super admin creates a bank initiator through the Add a user API [POST ../api/v1/users] when 2FA is enabled globally and the user opted-in for 2FA.
    Given a POST API endpoint for Authorization microservices <testcase>
    When user sets the header params
    And enters valid Authorization key of bank super admin and valid data in request body
    And sends POST request
    Then receives 2xx HTTP success code
    And receives a valid application success response
    Examples:
      | testcase |
      | DB-TC-477 |

  Scenario Outline: Verify that a bank's super admin creates a bank authorizer through the Add a user API [POST ../api/v1/users] when 2FA is enabled globally and the user opted-in for 2FA.
    Given a POST API endpoint for Authorization microservices <testcase>
    When user sets the header params
    And enters valid Authorization key of bank super admin and valid data in request body
    And sends POST request
    Then receives 2xx HTTP success code
    And receives a valid application success response
    Examples:
      | testcase |
      | DB-TC-478 |

  Scenario Outline: Verify that a bank's super admin creates a bank admin with both initiator and authorizer through the Add a user API [POST ../api/v1/users] when 2FA is enabled globally and the user opted-in for 2FA.
    Given a POST API endpoint for Authorization microservices <testcase>
    When user sets the header params
    And enters valid Authorization key of bank super admin and valid data in request body
    And sends POST request
    Then receives 2xx HTTP success code
    And receives a valid application success response
    Examples:
      | testcase |
      | DB-TC-479 |

  Scenario Outline: Verify that a bank's super admin creates a customer user through the Add a user API [POST ../api/v1/users] when 2FA is enabled globally and the user opted-in for 2FA.
    Given a POST API endpoint for Authorization microservices <testcase>
    When user sets the header params
    And enters valid Authorization key of bank super admin and valid data in request body
    And sends POST request
    Then receives 2xx HTTP success code
    And receives a valid application success response
    Examples:
      | testcase |
      | DB-TC-480 |

  Scenario Outline: Verify that a bank initiator creates a bank initiator through the Add a user API [POST ../api/v1/users] when 2FA is enabled globally and the user opted-in for 2FA.
    Given a POST API endpoint for Authorization microservices <testcase>
    When user sets the header params
    And enters valid Authorization key of bank initiator and valid data in request body
    And sends POST request
    Then receives 2xx HTTP success code
    And receives a valid application success response
    Examples:
      | testcase |
      | DB-TC-481 |

  Scenario Outline: Verify that a bank initiator creates a bank authorizer through the Add a user API [POST ../api/v1/users] when 2FA is enabled globally and the user opted-in for 2FA.
    Given a POST API endpoint for Authorization microservices <testcase>
    When user sets the header params
    And enters valid Authorization key of bank initiator and valid data in request body
    And sends POST request
    Then receives 2xx HTTP success code
    And receives a valid application success response
    Examples:
      | testcase |
      | DB-TC-482 |

  Scenario Outline: Verify that a bank initiator creates a bank admin with both initiator and authorizer through the Add a user API [POST ../api/v1/users] when 2FA is enabled globally and the user opted-in for 2FA.
    Given a POST API endpoint for Authorization microservices <testcase>
    When user sets the header params
    And enters valid Authorization key of bank initiator and valid data in request body
    And sends POST request
    Then receives 2xx HTTP success code
    And receives a valid application success response
    Examples:
      | testcase |
      | DB-TC-483 |

  Scenario Outline: Verify that a bank initiator creates a customer user through the Add a user API [POST ../api/v1/users] when 2FA is enabled globally and the user opted-in for 2FA.
    Given a POST API endpoint for Authorization microservices <testcase>
    When user sets the header params
    And enters valid Authorization key of bank initiator and valid data in request body
    And sends POST request
    Then receives 2xx HTTP success code
    And receives a valid application success response
    Examples:
      | testcase |
      | DB-TC-484 |

  Scenario Outline: Verify that a bank admin with both initiator and authorizer creates a bank initiator through the Add a user API [POST ../api/v1/users] when 2FA is enabled globally and the user opted-in for 2FA.
    Given a POST API endpoint for Authorization microservices <testcase>
    When user sets the header params
    And enters valid Authorization key of bank initiator authorizer and valid data in request body
    And sends POST request
    Then receives 2xx HTTP success code
    And receives a valid application success response
    Examples:
      | testcase |
      | DB-TC-485 |

  Scenario Outline: Verify that a bank admin with both initiator and authorizer creates a bank authorizer through the Add a user API [POST ../api/v1/users] when 2FA is enabled globally and the user opted-in for 2FA.
    Given a POST API endpoint for Authorization microservices <testcase>
    When user sets the header params
    And enters valid Authorization key of bank initiator authorizer and valid data in request body
    And sends POST request
    Then receives 2xx HTTP success code
    And receives a valid application success response
    Examples:
      | testcase |
      | DB-TC-486 |

  Scenario Outline: Verify that a bank admin with both initiator and authorizer  creates a bank admin with both initiator and authorizer through the Add a user API [POST ../api/v1/users] when 2FA is enabled globally and the user opted-in for 2FA.
    Given a POST API endpoint for Authorization microservices <testcase>
    When user sets the header params
    And enters valid Authorization key of bank initiator authorizer and valid data in request body
    And sends POST request
    Then receives 2xx HTTP success code
    And receives a valid application success response
    Examples:
      | testcase |
      | DB-TC-487 |

  Scenario Outline: Verify that a bank admin with both initiator and authorizer creates a customer user through the Add a user API [POST ../api/v1/users] when 2FA is enabled globally and the user opted-in for 2FA.
    Given a POST API endpoint for Authorization microservices <testcase>
    When user sets the header params
    And enters valid Authorization key of bank initiator authorizer and valid data in request body
    And sends POST request
    Then receives 2xx HTTP success code
    And receives a valid application success response
    Examples:
      | testcase |
      | DB-TC-488 |

  Scenario Outline: Verify that a bank authorizer creates a bank initiator through the Add a user API [POST ../api/v1/users] when 2FA is enabled globally and the user opted-in for 2FA.
    Given a POST API endpoint for Authorization microservices <testcase>
    When user sets the header params
    And enters valid Authorization key of bank authorizer and valid data in request body
    And sends POST request
    Then system receives 4xx HTTP error code
    And receives a valid application error response
    Examples:
      | testcase |
      | DB-TC-489 |

  Scenario Outline: Verify that a bank authorizer creates a bank authorizer through the Add a user API [POST ../api/v1/users] when 2FA is enabled globally and the user opted-in for 2FA.
    Given a POST API endpoint for Authorization microservices <testcase>
    When user sets the header params
    And enters valid Authorization key of bank authorizer and valid data in request body
    And sends POST request
    Then system receives 4xx HTTP error code
    And receives a valid application error response
    Examples:
      | testcase |
      | DB-TC-490 |

  Scenario Outline: Verify that a bank authorizer  creates a bank admin with both initiator and authorizer through the Add a user API [POST ../api/v1/users] when 2FA is enabled globally and the user opted-in for 2FA.
    Given a POST API endpoint for Authorization microservices <testcase>
    When user sets the header params
    And enters valid Authorization key of bank authorizer and valid data in request body
    And sends POST request
    Then system receives 4xx HTTP error code
    And receives a valid application error response
    Examples:
      | testcase |
      | DB-TC-491 |

  Scenario Outline: Verify that a bank authorizer creates a customer user through the Add a user API [POST ../api/v1/users] when 2FA is enabled globally and the user opted-in for 2FA.
    Given a POST API endpoint for Authorization microservices <testcase>
    When user sets the header params
    And enters valid Authorization key of bank authorizer and valid data in request body
    And sends POST request
    Then system receives 4xx HTTP error code
    And receives a valid application error response
    Examples:
      | testcase |
      | DB-TC-492 |

  Scenario Outline: Verify that a bank's super admin creates a bank initiator through the Add a user API [POST ../api/v1/users] when 2FA is enabled globally and the user opted-out for 2FA.
    Given a POST API endpoint for Authorization microservices <testcase>
    When user sets the header params
    And enters valid Authorization key of bank super admin and valid data in request body
    And sends POST request
    Then receives 2xx HTTP success code
    And receives a valid application success response
    Examples:
      | testcase |
      | DB-TC-493 |

  Scenario Outline: Verify that a bank's super admin creates a bank authorizer through the Add a user API [POST ../api/v1/users] when 2FA is enabled globally and the user opted-out for 2FA.
    Given a POST API endpoint for Authorization microservices <testcase>
    When user sets the header params
    And enters valid Authorization key of bank super admin and valid data in request body
    And sends POST request
    Then receives 2xx HTTP success code
    And receives a valid application success response
    Examples:
      | testcase |
      | DB-TC-494 |

  Scenario Outline: Verify that a bank's super admin creates a bank admin with both initiator and authorizer through the Add a user API [POST ../api/v1/users] when 2FA is enabled globally and the user opted-out for 2FA.
    Given a POST API endpoint for Authorization microservices <testcase>
    When user sets the header params
    And enters valid Authorization key of bank super admin and valid data in request body
    And sends POST request
    Then receives 2xx HTTP success code
    And receives a valid application success response
    Examples:
      | testcase |
      | DB-TC-495 |

  Scenario Outline: Verify that a bank's super admin creates a customer user through the Add a user API [POST ../api/v1/users] when 2FA is enabled globally and the user opted-out for 2FA.
    Given a POST API endpoint for Authorization microservices <testcase>
    When user sets the header params
    And enters valid Authorization key of bank super admin and valid data in request body
    And sends POST request
    Then receives 2xx HTTP success code
    And receives a valid application success response
    Examples:
      | testcase |
      | DB-TC-496 |

  Scenario Outline: Verify that a bank initiator creates a bank initiator through the Add a user API [POST ../api/v1/users] when 2FA is enabled globally and the user opted-out for 2FA.
    Given a POST API endpoint for Authorization microservices <testcase>
    When user sets the header params
    And enters valid Authorization key of bank initiator and valid data in request body
    And sends POST request
    Then receives 2xx HTTP success code
    And receives a valid application success response
    Examples:
      | testcase |
      | DB-TC-497 |

  Scenario Outline: Verify that a bank initiator creates a bank authorizer through the Add a user API [POST ../api/v1/users] when 2FA is enabled globally and the user opted-out for 2FA.
    Given a POST API endpoint for Authorization microservices <testcase>
    When user sets the header params
    And enters valid Authorization key of bank initiator and valid data in request body
    And sends POST request
    Then receives 2xx HTTP success code
    And receives a valid application success response
    Examples:
      | testcase |
      | DB-TC-498 |

  Scenario Outline: Verify that a bank initiator creates a bank admin with both initiator and authorizer through the Add a user API [POST ../api/v1/users] when 2FA is enabled globally and the user opted-out for 2FA.
    Given a POST API endpoint for Authorization microservices <testcase>
    When user sets the header params
    And enters valid Authorization key of bank initiator and valid data in request body
    And sends POST request
    Then receives 2xx HTTP success code
    And receives a valid application success response
    Examples:
      | testcase |
      | DB-TC-499 |

  Scenario Outline: Verify that a bank initiator creates a customer user through the Add a user API [POST ../api/v1/users] when 2FA is enabled globally and the user opted-out for 2FA.
    Given a POST API endpoint for Authorization microservices <testcase>
    When user sets the header params
    And enters valid Authorization key of bank initiator and valid data in request body
    And sends POST request
    Then receives 2xx HTTP success code
    And receives a valid application success response
    Examples:
      | testcase |
      | DB-TC-500 |

  Scenario Outline: Verify that a bank admin with both initiator and authorizer creates a bank initiator through the Add a user API [POST ../api/v1/users] when 2FA is enabled globally and the user opted-out for 2FA.
    Given a POST API endpoint for Authorization microservices <testcase>
    When user sets the header params
    And enters valid Authorization key of bank initiator authorizer and valid data in request body
    And sends POST request
    Then receives 2xx HTTP success code
    And receives a valid application success response
    Examples:
      | testcase |
      | DB-TC-501 |

  Scenario Outline: Verify that a bank admin with both initiator and authorizer creates a bank authorizer through the Add a user API [POST ../api/v1/users] when 2FA is enabled globally and the user opted-out for 2FA.
    Given a POST API endpoint for Authorization microservices <testcase>
    When user sets the header params
    And enters valid Authorization key of bank initiator authorizer and valid data in request body
    And sends POST request
    Then receives 2xx HTTP success code
    And receives a valid application success response
    Examples:
      | testcase |
      | DB-TC-502 |

  Scenario Outline: Verify that a bank admin with both initiator and authorizer  creates a bank admin with both initiator and authorizer through the Add a user API [POST ../api/v1/users] when 2FA is enabled globally and the user opted-out for 2FA.
    Given a POST API endpoint for Authorization microservices <testcase>
    When user sets the header params
    And enters valid Authorization key of bank initiator authorizer and valid data in request body
    And sends POST request
    Then receives 2xx HTTP success code
    And receives a valid application success response
    Examples:
      | testcase |
      | DB-TC-503 |

  Scenario Outline: Verify that a bank admin with both initiator and authorizer creates a customer user through the Add a user API [POST ../api/v1/users] when 2FA is enabled globally and the user opted-out for 2FA.
    Given a POST API endpoint for Authorization microservices <testcase>
    When user sets the header params
    And enters valid Authorization key of bank initiator authorizer and valid data in request body
    And sends POST request
    Then receives 2xx HTTP success code
    And receives a valid application success response
    Examples:
      | testcase |
      | DB-TC-504 |

  Scenario Outline: Verify that a bank authorizer creates a bank initiator through the Add a user API [POST ../api/v1/users] when 2FA is enabled globally and the user opted-out for 2FA.
    Given a POST API endpoint for Authorization microservices <testcase>
    When user sets the header params
    And enters valid Authorization key of bank authorizer and valid data in request body
    And sends POST request
    Then system receives 4xx HTTP error code
    And receives a valid application error response
    Examples:
      | testcase |
      | DB-TC-505 |

  Scenario Outline: Verify that a bank authorizer creates a bank authorizer through the Add a user API [POST ../api/v1/users] when 2FA is enabled globally and the user opted-out for 2FA.
    Given a POST API endpoint for Authorization microservices <testcase>
    When user sets the header params
    And enters valid Authorization key of bank authorizer and valid data in request body
    And sends POST request
    Then system receives 4xx HTTP error code
    And receives a valid application error response
    Examples:
      | testcase |
      | DB-TC-506 |

  Scenario Outline: Verify that a bank authorizer creates a bank admin with both initiator and authorizer through the Add a user API [POST ../api/v1/users] when 2FA is enabled globally and the user opted-out for 2FA.
    Given a POST API endpoint for Authorization microservices <testcase>
    When user sets the header params
    And enters valid Authorization key of bank authorizer and valid data in request body
    And sends POST request
    Then system receives 4xx HTTP error code
    And receives a valid application error response
    Examples:
      | testcase |
      | DB-TC-507 |

  Scenario Outline: Verify that a bank authorizer creates a customer user through the Add a user API [POST ../api/v1/users] when 2FA is enabled globally and the user opted-out for 2FA.
    Given a POST API endpoint for Authorization microservices <testcase>
    When user sets the header params
    And enters valid Authorization key of bank authorizer and valid data in request body
    And sends POST request
    Then system receives 4xx HTTP error code
    And receives a valid application error response
    Examples:
      | testcase |
      | DB-TC-508 |

  Scenario Outline: Verify that a bank's super admin creates a bank initiator through the Add a user API [POST ../api/v1/users] when 2FA is disabled globally
    Given a POST API endpoint for Authorization microservices <testcase>
    When user sets the header params
    And enters valid Authorization key of bank super admin and valid data in request body
    And sends POST request
    Then receives 2xx HTTP success code
    And receives a valid application success response
    Examples:
      | testcase |
      | DB-TC-509 |

  Scenario Outline: Verify that a bank's super admin creates a bank authorizer through the Add a user API [POST ../api/v1/users] when 2FA is disabled globally
    Given a POST API endpoint for Authorization microservices <testcase>
    When user sets the header params
    And enters valid Authorization key of bank super admin and valid data in request body
    And sends POST request
    Then receives 2xx HTTP success code
    And receives a valid application success response
    Examples:
      | testcase |
      | DB-TC-510 |

  Scenario Outline: Verify that a bank's super admin creates a bank admin with both initiator and authorizer through the Add a user API [POST ../api/v1/users] when 2FA is disabled globally
    Given a POST API endpoint for Authorization microservices <testcase>
    When user sets the header params
    And enters valid Authorization key of bank super admin and valid data in request body
    And sends POST request
    Then receives 2xx HTTP success code
    And receives a valid application success response
    Examples:
      | testcase |
      | DB-TC-511 |

  Scenario Outline: Verify that a bank's super admin creates a customer user through the Add a user API [POST ../api/v1/users] when 2FA is disabled globally
    Given a POST API endpoint for Authorization microservices <testcase>
    When user sets the header params
    And enters valid Authorization key of bank super admin and valid data in request body
    And sends POST request
    Then receives 2xx HTTP success code
    And receives a valid application success response
    Examples:
      | testcase |
      | DB-TC-512 |

  Scenario Outline: Verify that a bank initiator creates a bank initiator through the Add a user API [POST ../api/v1/users] when 2FA is disabled globally
    Given a POST API endpoint for Authorization microservices <testcase>
    When user sets the header params
    And enters valid Authorization key of bank initiator and valid data in request body
    And sends POST request
    Then receives 2xx HTTP success code
    And receives a valid application success response
    Examples:
      | testcase |
      | DB-TC-513 |

  Scenario Outline: Verify that a bank initiator creates a bank authorizer through the Add a user API [POST ../api/v1/users] when 2FA is disabled globally
    Given a POST API endpoint for Authorization microservices <testcase>
    When user sets the header params
    And enters valid Authorization key of bank initiator and valid data in request body
    And sends POST request
    Then receives 2xx HTTP success code
    And receives a valid application success response
    Examples:
      | testcase |
      | DB-TC-514 |

  Scenario Outline: Verify that a bank initiator creates a bank admin with both initiator and authorizer through the Add a user API [POST ../api/v1/users] when 2FA is disabled globally
    Given a POST API endpoint for Authorization microservices <testcase>
    When user sets the header params
    And enters valid Authorization key of bank initiator and valid data in request body
    And sends POST request
    Then receives 2xx HTTP success code
    And receives a valid application success response
    Examples:
      | testcase |
      | DB-TC-515 |

  Scenario Outline: Verify that a bank initiator creates a customer user through the Add a user API [POST ../api/v1/users] when 2FA is disabled globally
    Given a POST API endpoint for Authorization microservices <testcase>
    When user sets the header params
    And enters valid Authorization key of bank initiator and valid data in request body
    And sends POST request
    Then receives 2xx HTTP success code
    And receives a valid application success response
    Examples:
      | testcase |
      | DB-TC-516 |

  Scenario Outline: Verify that a bank admin with both initiator and authorizer creates a bank initiator through the Add a user API [POST ../api/v1/users] when 2FA is disabled globally
    Given a POST API endpoint for Authorization microservices <testcase>
    When user sets the header params
    And enters valid Authorization key of bank initiator authorizer and valid data in request body
    And sends POST request
    Then receives 2xx HTTP success code
    And receives a valid application success response
    Examples:
      | testcase |
      | DB-TC-517 |

  Scenario Outline: Verify that a bank admin with both initiator and authorizer creates a bank authorizer through the Add a user API [POST ../api/v1/users] when 2FA is disabled globally
    Given a POST API endpoint for Authorization microservices <testcase>
    When user sets the header params
    And enters valid Authorization key of bank initiator authorizer and valid data in request body
    And sends POST request
    Then receives 2xx HTTP success code
    And receives a valid application success response
    Examples:
      | testcase |
      | DB-TC-518 |

  Scenario Outline: Verify that a bank admin with both initiator and authorizer  creates a bank admin with both initiator and authorizer through the Add a user API [POST ../api/v1/users] when 2FA is disabled globally
    Given a POST API endpoint for Authorization microservices <testcase>
    When user sets the header params
    And enters valid Authorization key of bank initiator authorizer and valid data in request body
    And sends POST request
    Then receives 2xx HTTP success code
    And receives a valid application success response
    Examples:
      | testcase |
      | DB-TC-519 |

  Scenario Outline: Verify that a bank admin with both initiator and authorizer creates a customer user through the Add a user API [POST ../api/v1/users] when 2FA is disabled globally
    Given a POST API endpoint for Authorization microservices <testcase>
    When user sets the header params
    And enters valid Authorization key of bank initiator authorizer and valid data in request body
    And sends POST request
    Then receives 2xx HTTP success code
    And receives a valid application success response
    Examples:
      | testcase |
      | DB-TC-520 |

  Scenario Outline: Verify that a bank authorizer creates a bank initiator through the Add a user API [POST ../api/v1/users] when 2FA is disabled globally
    Given a POST API endpoint for Authorization microservices <testcase>
    When user sets the header params
    And enters valid Authorization key of bank authorizer and valid data in request body
    And sends POST request
    Then system receives 4xx HTTP error code
    And receives a valid application error response
    Examples:
      | testcase |
      | DB-TC-521 |

  Scenario Outline: Verify that a bank authorizer creates a bank authorizer through the Add a user API [POST ../api/v1/users] when 2FA is disabled globally
    Given a POST API endpoint for Authorization microservices <testcase>
    When user sets the header params
    And enters valid Authorization key of bank authorizer and valid data in request body
    And sends POST request
    Then system receives 4xx HTTP error code
    And receives a valid application error response
    Examples:
      | testcase |
      | DB-TC-522 |

  Scenario Outline: Verify that a bank authorizer  creates a bank admin with both initiator and authorizer through the Add a user API [POST ../api/v1/users] when 2FA is disabled globally
    Given a POST API endpoint for Authorization microservices <testcase>
    When user sets the header params
    And enters valid Authorization key of bank authorizer and valid data in request body
    And sends POST request
    Then system receives 4xx HTTP error code
    And receives a valid application error response
    Examples:
      | testcase |
      | DB-TC-523 |

  Scenario Outline: Verify that a bank authorizer creates a customer user through the Add a user API [POST ../api/v1/users] when 2FA is disabled globally
    Given a POST API endpoint for Authorization microservices <testcase>
    When user sets the header params
    And enters valid Authorization key of bank authorizer and valid data in request body
    And sends POST request
    Then system receives 4xx HTTP error code
    And receives a valid application error response
    Examples:
      | testcase |
      | DB-TC-524 |

  Scenario Outline: Verify that a bank admin tries to get user details by userID through the Get user by userId API [GET ../api/v1/users{userId}] when 2FA is enabled globally and the user opted-in for 2FA.
    Given a GET API endpoint for Authorization microservices <testcase>
    When user sets the header params
    And enters valid Authorization key of bank admin and userId key and valid data in request body
    And sends GET request
    Then receives 2xx HTTP success code
    And receives a valid application success response
    Examples:
      | testcase |
      | DB-TC-530 |

  Scenario Outline: Verify that a bank admin tries to get user details by userID through the Get user by userId API [GET ../api/v1/users{userId}] when 2FA is enabled globally and the user opted-out for 2FA.
    Given a GET API endpoint for Authorization microservices <testcase>
    When user sets the header params
    And enters valid Authorization key of bank admin and userId key and valid data in request body
    And sends GET request
    Then receives 2xx HTTP success code
    And receives a valid application success response
    Examples:
      | testcase |
      | DB-TC-531 |

  Scenario Outline: Verify that a bank admin tries to get user details by userID through the Get user by userId API [GET ../api/v1/users{userId}] when 2FA is disabled globally.
    Given a GET API endpoint for Authorization microservices <testcase>
    When user sets the header params
    And enters valid Authorization key of bank admin and userId key and valid data in request body
    And sends GET request
    Then receives 2xx HTTP success code
    And receives a valid application success response
    Examples:
      | testcase |
      | DB-TC-532 |

  Scenario Outline: Verify the response of Forgot Password API [PUT../api/v1/users/{userId}/forgot-password] for bank admin
    Given a PUT API endpoint for Authorization microservices <testcase>
    When user sets the header params
    And enters valid Authorization key of bank admin and valid data in request body
    And sends PUT request
    Then receives 2xx HTTP success code
    And receives a valid application success response
    Examples:
      | testcase |
      | DB-TC-534 |

  Scenario Outline: Verify that a bank's superadmin tries to authorize that user initiated by bank initiator through the Authorize a user API [PUT ../api/v1/users/{userId}] when 2FA is enabled globally and the user opted-in for 2FA.
    Given a PUT API endpoint for Authorization microservices <testcase>
    When user sets the header params
    And enters valid Authorization key of bank super admin and userId key and valid data in request body
    And sends PUT request
    Then receives 2xx HTTP success code
    And receives a valid application success response
    Examples:
      | testcase |
      | DB-TC-538 |

  Scenario Outline: Verify that a bank's superadmin tries to authorize that user initiated by bank initiatorAuthorizer through the Authorize a user API [PUT ../api/v1/users/{userId}] when 2FA is enabled globally and the user opted-in for 2FA.
    Given a PUT API endpoint for Authorization microservices <testcase>
    When user sets the header params
    And enters valid Authorization key of bank super admin and userId key and valid data in request body
    And sends PUT request
    Then receives 2xx HTTP success code
    And receives a valid application success response
    Examples:
      | testcase |
      | DB-TC-539 |

  Scenario Outline: Verify that a bank Authorizer tries to authorize that user initiated by bank initiator through the Authorize a user API [PUT ../api/v1/users/{userId}] when 2FA is enabled globally and the user opted-in for 2FA.
    Given a PUT API endpoint for Authorization microservices <testcase>
    When user sets the header params
    And enters valid Authorization key of bank authorizer and userId key and valid data in request body
    And sends PUT request
    Then receives 2xx HTTP success code
    And receives a valid application success response
    Examples:
      | testcase |
      | DB-TC-540 |

  Scenario Outline: Verify that a bank Authorizer tries to authorize that user initiated by bank initiatorAuthorizer through the Authorize a user API [PUT ../api/v1/users/{userId}] when 2FA is enabled globally and the user opted-in for 2FA.
    Given a PUT API endpoint for Authorization microservices <testcase>
    When user sets the header params
    And enters valid Authorization key of bank authorizer and userId key and valid data in request body
    And sends PUT request
    Then receives 2xx HTTP success code
    And receives a valid application success response
    Examples:
      | testcase |
      | DB-TC-541 |

  Scenario Outline: Verify that a bank initiatorAuthorizer tries to authorize that user initiated by bank initiator through the Authorize a user API [PUT ../api/v1/users/{userId}] when 2FA is enabled globally and the user opted-in for 2FA.
    Given a PUT API endpoint for Authorization microservices <testcase>
    When user sets the header params
    And enters valid Authorization key of bank initiator authorizer and userId key and valid data in request body
    And sends PUT request
    Then receives 2xx HTTP success code
    And receives a valid application success response
    Examples:
      | testcase |
      | DB-TC-542 |

  Scenario Outline: Verify that a bank initiatorAuthorizer tries to authorize that user initiated by same bank initiatorAuthorizer through the Authorize a user API [PUT ../api/v1/users/{userId}] when 2FA is enabled globally and the user opted-in for 2FA.
    Given a PUT API endpoint for Authorization microservices <testcase>
    When user sets the header params
    And enters valid Authorization key of bank initiator authorizer and userId key and valid data in request body
    And sends PUT request
    Then system receives 4xx HTTP error code
    And receives a valid application error response
    Examples:
      | testcase |
      | DB-TC-543 |

  Scenario Outline: Verify that a bank initiatorAuthorizer tries to authorize that user initiated by different bank initiatorAuthorizer through the Authorize a user API [PUT ../api/v1/users/{userId}] when 2FA is enabled globally and the user opted-in for 2FA.
    Given a PUT API endpoint for Authorization microservices <testcase>
    When user sets the header params
    And enters valid Authorization key of bank initiator authorizer and userId key and valid data in request body
    And sends PUT request
    Then receives 2xx HTTP success code
    And receives a valid application success response
    Examples:
      | testcase |
      | DB-TC-544 |

  Scenario Outline: Verify that a bank's superadmin tries to authorize that user initiated by bank initiator through the Authorize a user API [PUT ../api/v1/users/{userId}] when 2FA is enabled globally and the user opted-out for 2FA.
    Given a PUT API endpoint for Authorization microservices <testcase>
    When user sets the header params
    And enters valid Authorization key of bank super admin and userId key and valid data in request body
    And sends PUT request
    Then receives 2xx HTTP success code
    And receives a valid application success response
    Examples:
      | testcase |
      | DB-TC-545 |

  Scenario Outline: Verify that a bank's superadmin tries to authorize that user initiated by bank initiator through the Authorize a user API [PUT ../api/v1/users/{userId}] when 2FA is enabled globally and the user opted-out for 2FA.
    Given a PUT API endpoint for Authorization microservices <testcase>
    When user sets the header params
    And enters valid Authorization key of bank super admin and userId key and valid data in request body
    And sends PUT request
    Then receives 2xx HTTP success code
    And receives a valid application success response
    Examples:
      | testcase |
      | DB-TC-546 |

  Scenario Outline: Verify that a bank Authorizer tries to authorize that user initiated by bank initiator through the Authorize a user API [PUT ../api/v1/users/{userId}] when 2FA is enabled globally and the user opted-out for 2FA.
    Given a PUT API endpoint for Authorization microservices <testcase>
    When user sets the header params
    And enters valid Authorization key of bank authorizer and userId key and valid data in request body
    And sends PUT request
    Then receives 2xx HTTP success code
    And receives a valid application success response
    Examples:
      | testcase |
      | DB-TC-547 |

  Scenario Outline: Verify that a bank Authorizer tries to authorize that user initiated by bank initiatorAuthorizer through the Authorize a user API [PUT ../api/v1/users/{userId}] when 2FA is enabled globally and the user opted-out for 2FA.
    Given a PUT API endpoint for Authorization microservices <testcase>
    When user sets the header params
    And enters valid Authorization key of bank authorizer and userId key and valid data in request body
    And sends PUT request
    Then receives 2xx HTTP success code
    And receives a valid application success response
    Examples:
      | testcase |
      | DB-TC-548 |

  Scenario Outline: Verify that a bank initiatorAuthorizer tries to authorize that user initiated by bank initiator through the Authorize a user API [PUT ../api/v1/users/{userId}] when 2FA is enabled globally and the user opted-out for 2FA.
    Given a PUT API endpoint for Authorization microservices <testcase>
    When user sets the header params
    And enters valid Authorization key of bank initiator authorizer and userId key and valid data in request body
    And sends PUT request
    Then receives 2xx HTTP success code
    And receives a valid application success response
    Examples:
      | testcase |
      | DB-TC-549 |

  Scenario Outline: Verify that a bank initiatorAuthorizer tries to authorize that user initiated by same bank initiatorAuthorizer through the Authorize a user API [PUT ../api/v1/users/{userId}] when 2FA is enabled globally and the user opted-out for 2FA.
    Given a PUT API endpoint for Authorization microservices <testcase>
    When user sets the header params
    And enters valid Authorization key of bank initiator authorizer and userId key and valid data in request body
    And sends PUT request
    Then system receives 4xx HTTP error code
    And receives a valid application error response
    Examples:
      | testcase |
      | DB-TC-550 |

  Scenario Outline: Verify that a bank initiatorAuthorizer tries to authorize that user initiated by different bank initiatorAuthorizer through the Authorize a user API [PUT ../api/v1/users/{userId}] when 2FA is enabled globally and the user opted-out for 2FA.
    Given a PUT API endpoint for Authorization microservices <testcase>
    When user sets the header params
    And enters valid Authorization key of bank initiator authorizer and userId key and valid data in request body
    And sends PUT request
    Then receives 2xx HTTP success code
    And receives a valid application success response
    Examples:
      | testcase |
      | DB-TC-551 |

  Scenario Outline: Verify that a bank's superadmin tries to authorize that user initiated by bank initiator through the Authorize a user API [PUT ../api/v1/users/{userId}] when 2FA is disabled globally.
    Given a PUT API endpoint for Authorization microservices <testcase>
    When user sets the header params
    And enters valid Authorization key of bank super admin and userId key and valid data in request body
    And sends PUT request
    Then receives 2xx HTTP success code
    And receives a valid application success response
    Examples:
      | testcase |
      | DB-TC-552 |

  Scenario Outline: Verify that a bank's superadmin tries to authorize that user initiated by bank initiatorAuthorizer through the Authorize a user API [PUT ../api/v1/users/{userId}] when 2FA is disabled globally.
    Given a PUT API endpoint for Authorization microservices <testcase>
    When user sets the header params
    And enters valid Authorization key of bank super admin and userId key and valid data in request body
    And sends PUT request
    Then receives 2xx HTTP success code
    And receives a valid application success response
    Examples:
      | testcase |
      | DB-TC-553 |

  Scenario Outline: Verify that a bank Authorizer tries to authorize that user initiated by bank initiator through the Authorize a user API [PUT ../api/v1/users/{userId}] when 2FA is disabled globally.
    Given a PUT API endpoint for Authorization microservices <testcase>
    When user sets the header params
    And enters valid Authorization key of bank authorizer and userId key and valid data in request body
    And sends PUT request
    Then receives 2xx HTTP success code
    And receives a valid application success response
    Examples:
      | testcase |
      | DB-TC-554 |

  Scenario Outline: Verify that a bank Authorizer tries to authorize that user initiated by bank initiatorAuthorizer through the Authorize a user API [PUT ../api/v1/users/{userId}] when 2FA is disabled globally.
    Given a PUT API endpoint for Authorization microservices <testcase>
    When user sets the header params
    And enters valid Authorization key of bank authorizer and userId key and valid data in request body
    And sends PUT request
    Then receives 2xx HTTP success code
    And receives a valid application success response
    Examples:
      | testcase |
      | DB-TC-555 |

  Scenario Outline: Verify that a bank initiatorAuthorizer tries to authorize that user initiated by bank initiator through the Authorize a user API [PUT ../api/v1/users/{userId}] when 2FA is disabled globally.
    Given a PUT API endpoint for Authorization microservices <testcase>
    When user sets the header params
    And enters valid Authorization key of bank initiator authorizer and userId key and valid data in request body
    And sends PUT request
    Then receives 2xx HTTP success code
    And receives a valid application success response
    Examples:
      | testcase |
      | DB-TC-556 |

  Scenario Outline: Verify that a bank initiatorAuthorizer tries to authorize that user initiated by same bank initiatorAuthorizer through the Authorize a user API [PUT ../api/v1/users/{userId}] when 2FA is disabled globally.
    Given a PUT API endpoint for Authorization microservices <testcase>
    When user sets the header params
    And enters valid Authorization key of bank initiator authorizer and userId key and valid data in request body
    And sends PUT request
    Then system receives 4xx HTTP error code
    And receives a valid application error response
    Examples:
      | testcase |
      | DB-TC-557 |

  Scenario Outline: Verify that a bank initiatorAuthorizer tries to authorize that user initiated by different bank initiatorAuthorizer through the Authorize a user API [PUT ../api/v1/users/{userId}] when 2FA is disabled globally.
    Given a PUT API endpoint for Authorization microservices <testcase>
    When user sets the header params
    And enters valid Authorization key of bank initiator authorizer and userId key and valid data in request body
    And sends PUT request
    Then receives 2xx HTTP success code
    And receives a valid application success response
    Examples:
      | testcase |
      | DB-TC-558 |

  Scenario Outline: Verify the oldPassword field in Force change password API [PUT../api/v1/users/{userId}/force-change-password]
    Given a PUT API endpoint for Authorization microservices <testcase>
    When user sets the header params
    And enters invalid oldPassword in request body
    And sends PUT request
    Then system receives 4xx HTTP error code
    And receives a valid application error response
    Examples:
      | testcase |
      | DB-TC-563 |

  Scenario Outline: Verify the newPassword field in Force change password API [PUT../api/v1/users/{userId}/force-change-password]
    Given a PUT API endpoint for Authorization microservices <testcase>
    When user sets the header params
    And enters invalid newPassword in request body
    And sends PUT request
    Then system receives 4xx HTTP error code
    And receives a valid application error response
    Examples:
      | testcase |
      | DB-TC-564 |

  Scenario Outline: Verify the confirmPassword field in Force change password API [PUT../api/v1/users/{userId}/force-change-password]
    Given a PUT API endpoint for Authorization microservices <testcase>
    When user sets the header params
    And enters invalid confirmPassword in request body
    And sends PUT request
    Then system receives 4xx HTTP error code
    And receives a valid application error response
    Examples:
      | testcase |
      | DB-TC-565 |

  Scenario Outline: Verify that a newly created bank admin can change the password through the force change password API [PUT ../api/v1/users/{userId}/force-change-password] when 2FA is enabled globally and the user opted-in for 2FA.
    Given a PUT API endpoint for Authorization microservices <testcase>
    When user sets the header params
    And enters valid Authorization key of new bank admin and valid data in request body
    And sends PUT request
    Then receives 2xx HTTP success code
    And receives a valid application success response
    Examples:
      | testcase |
      | DB-TC-566 |

  Scenario Outline: Verify that a password expiry bank admin can change the password through the force change password API [PUT ../api/v1/users/{userId}/force-change-password] when 2FA is enabled globally and the user opted-in for 2FA.
    Given a PUT API endpoint for Authorization microservices <testcase>
    When user sets the header params
    And enters valid Authorization key of expiry bank admin and valid data in request body
    And sends PUT request
    Then receives 2xx HTTP success code
    And receives a valid application success response
    Examples:
      | testcase |
      | DB-TC-567 |

  Scenario Outline: Verify that a bank admin can change the password through the force change password API [PUT ../api/v1/users/{userId}/force-change-password] when 2FA is enabled globally and the user opted-in for 2FA.
    Given a PUT API endpoint for Authorization microservices <testcase>
    When user sets the header params
    And enters valid Authorization key of bank admin and valid data in request body
    And sends PUT request
    Then system receives 4xx HTTP error code
    And receives a valid application error response
    Examples:
      | testcase |
      | DB-TC-568 |

  Scenario Outline: Verify that a locked user bank admin can change the password through the force change password API [PUT ../api/v1/users/{userId}/force-change-password] when 2FA is enabled globally and the user opted-in for 2FA.
    Given a PUT API endpoint for Authorization microservices <testcase>
    When user sets the header params
    And enters valid Authorization key of locked bank admin and valid data in request body
    And sends PUT request
    Then system receives 4xx HTTP error code
    And receives a valid application error response
    Examples:
      | testcase |
      | DB-TC-569 |

  Scenario Outline: Verify that a newly created bank admin can change the password through the force change password API [PUT ../api/v1/users/{userId}/force-change-password] when 2FA is enabled globally and the user opted-out for 2FA.
    Given a PUT API endpoint for Authorization microservices <testcase>
    When user sets the header params
    And enters valid Authorization key of new bank admin and valid data in request body
    And sends PUT request
    Then receives 2xx HTTP success code
    And receives a valid application success response
    Examples:
      | testcase |
      | DB-TC-570 |

  Scenario Outline: Verify that a password expiry  bank admin can change the password through the force change password API [PUT ../api/v1/users/{userId}/force-change-password] when 2FA is enabled globally and the user opted-out for 2FA.
    Given a PUT API endpoint for Authorization microservices <testcase>
    When user sets the header params
    And enters valid Authorization key of expiry bank admin and valid data in request body
    And sends PUT request
    Then receives 2xx HTTP success code
    And receives a valid application success response
    Examples:
      | testcase |
      | DB-TC-571 |

  Scenario Outline: Verify that a normal bank admin can change the password through the force change password API [PUT ../api/v1/users/{userId}/force-change-password] when 2FA is enabled globally and the user opted-out for 2FA.
    Given a PUT API endpoint for Authorization microservices <testcase>
    When user sets the header params
    And enters valid Authorization key of bank admin and valid data in request body
    And sends PUT request
    Then system receives 4xx HTTP error code
    And receives a valid application error response
    Examples:
      | testcase |
      | DB-TC-572 |

  Scenario Outline: Verify that a locked user bank admin can change the password through the force change password API [PUT ../api/v1/users/{userId}/force-change-password] when 2FA is enabled globally and the user opted-out for 2FA.
    Given a PUT API endpoint for Authorization microservices <testcase>
    When user sets the header params
    And enters valid Authorization key of locked admin and valid data in request body
    And sends PUT request
    Then system receives 4xx HTTP error code
    And receives a valid application error response
    Examples:
      | testcase |
      | DB-TC-573 |

  Scenario Outline: Verify that a newly created bank admin can change the password through the force change password API [PUT ../api/v1/users/{userId}/force-change-password] when 2FA is disabled globally.
    Given a PUT API endpoint for Authorization microservices <testcase>
    When user sets the header params
    And enters valid Authorization key of new bank admin and valid data in request body
    And sends PUT request
    Then receives 2xx HTTP success code
    And receives a valid application success response
    Examples:
      | testcase |
      | DB-TC-574 |

  Scenario Outline: Verify that a password expiry  bank admin can change the password through the force change password API [PUT ../api/v1/users/{userId}/force-change-password] when 2FA is disabled globally
    Given a PUT API endpoint for Authorization microservices <testcase>
    When user sets the header params
    And enters valid Authorization key of expiry bank admin and valid data in request body
    And sends PUT request
    Then receives 2xx HTTP success code
    And receives a valid application success response
    Examples:
      | testcase |
      | DB-TC-575 |

  Scenario Outline: Verify that a normal bank admin can change the password through the force change password API [PUT ../api/v1/users/{userId}/force-change-password] when 2FA is disabled globally.
    Given a PUT API endpoint for Authorization microservices <testcase>
    When user sets the header params
    And enters valid Authorization key of bank admin and valid data in request body
    And sends PUT request
    Then system receives 4xx HTTP error code
    And receives a valid application error response
    Examples:
      | testcase |
      | DB-TC-576 |

  Scenario Outline: Verify that a locked user bank admin can change the password through the force change password API [PUT ../api/v1/users/{userId}/force-change-password] when 2FA is disabled globally.
    Given a PUT API endpoint for Authorization microservices <testcase>
    When user sets the header params
    And enters valid Authorization key of locked bank admin and valid data in request body
    And sends PUT request
    Then system receives 4xx HTTP error code
    And receives a valid application error response
    Examples:
      | testcase |
      | DB-TC-577 |

  Scenario Outline: Verify the userImage field in Upload user image API [POST../api/v1/users/{userId}/upload-image]
    Given a POST API endpoint for Authorization microservices <testcase>
    When user sets the header params
    And enters invalid userImage in request body
    And sends POST request
    Then system receives 4xx HTTP error code
    And receives a valid application error response
    Examples:
      | testcase |
      | DB-TC-582 |

  Scenario Outline: Verify that a bank admin can upload image to non-existing user through the Upload user image API [POST ../api/v1/users/{userId}/upload-image] when 2FA is enabled globally and the user opted-in for 2FA.
    Given a POST API endpoint for Authorization microservices <testcase>
    When user sets the header params
    And enters valid Authorization key of bank admin and userId key and valid data in request body
    And sends POST request
    Then system receives 4xx HTTP error code
    And receives a valid application error response
    Examples:
      | testcase |
      | DB-TC-583 |

  Scenario Outline: Verify that a bank super admin can upload image to the initiated user who is in authorization pending status, through the Upload user image API [POST ../api/v1/users/{userId}/upload-image] when 2FA is enabled globally and the user opted-in for 2FA.
    Given a POST API endpoint for Authorization microservices <testcase>
    When user sets the header params
    And enters valid Authorization key of bank super admin and userId key and valid data in request body
    And sends POST request
    Then system receives 4xx HTTP error code
    And receives a valid application error response
    Examples:
      | testcase |
      | DB-TC-584 |

  Scenario Outline: Verify that a bank super admin can upload image to  existing user who is authorized, through the Upload user image API [POST ../api/v1/users/{userId}/upload-image] when 2FA is enabled globally and the user opted-in for 2FA.
    Given a POST API endpoint for Authorization microservices <testcase>
    When user sets the header params
    And enters valid Authorization key of bank super admin and userId key and valid data in request body
    And sends POST request
    Then receives 2xx HTTP success code
    And receives a valid application success response
    Examples:
      | testcase |
      | DB-TC-585 |

  Scenario Outline: Verify that a bank initiator can upload image to the initiated user who is in authorization pending status, through the Upload user image API [POST ../api/v1/users/{userId}/upload-image] when 2FA is enabled globally and the user opted-in for 2FA.
    Given a POST API endpoint for Authorization microservices <testcase>
    When user sets the header params
    And enters valid Authorization key of bank initiator and userId key and valid data in request body
    And sends POST request
    Then system receives 4xx HTTP error code
    And receives a valid application error response
    Examples:
      | testcase |
      | DB-TC-586 |

  Scenario Outline: Verify that a bank initiator can upload image to existing user who is authorized, through the Upload user image API [POST ../api/v1/users/{userId}/upload-image] when 2FA is enabled globally and the user opted-in for 2FA.
    Given a POST API endpoint for Authorization microservices <testcase>
    When user sets the header params
    And enters valid Authorization key of bank initiator and userId key and valid data in request body
    And sends POST request
    Then receives 2xx HTTP success code
    And receives a valid application success response
    Examples:
      | testcase |
      | DB-TC-587 |

  Scenario Outline: Verify that a bank Authorizer can upload image to the initiated user who is in authorization pending status, through the Upload user image API [POST ../api/v1/users/{userId}/upload-image] when 2FA is enabled globally and the user opted-in for 2FA.
    Given a POST API endpoint for Authorization microservices <testcase>
    When user sets the header params
    And enters valid Authorization key of bank authorizer and userId key and valid data in request body
    And sends POST request
    Then system receives 4xx HTTP error code
    And receives a valid application error response
    Examples:
      | testcase |
      | DB-TC-588 |

  Scenario Outline: Verify that a bank Authorizer can upload image to existing user who is authorized, through the Upload user image API [POST ../api/v1/users/{userId}/upload-image] when 2FA is enabled globally and the user opted-in for 2FA.
    Given a POST API endpoint for Authorization microservices <testcase>
    When user sets the header params
    And enters valid Authorization key of bank authorizer and userId key and valid data in request body
    And sends POST request
    Then system receives 4xx HTTP error code
    And receives a valid application error response
    Examples:
      | testcase |
      | DB-TC-589 |

  Scenario Outline: Verify that a bank initiatorAuthorizer can upload image to the initiated user who is in authorization pending status, through the Upload user image API [POST ../api/v1/users/{userId}/upload-image]
    Given a POST API endpoint for Authorization microservices <testcase>
    When user sets the header params
    And enters valid Authorization key of bank initiator authorizer and userId key and valid data in request body
    And sends POST request
    Then system receives 4xx HTTP error code
    And receives a valid application error response
    Examples:
      | testcase |
      | DB-TC-590 |

  Scenario Outline: Verify that a bank initiatorAuthorizer can upload image to existing user who is authorized, through the Upload user image API [POST ../api/v1/users/{userId}/upload-image] when 2FA is enabled globally and the user opted-in for 2FA.
    Given a POST API endpoint for Authorization microservices <testcase>
    When user sets the header params
    And enters valid Authorization key of bank initiator authorizer and userId key and valid data in request body
    And sends POST request
    Then receives 2xx HTTP success code
    And receives a valid application success response
    Examples:
      | testcase |
      | DB-TC-591 |

  Scenario Outline: Verify that a bank admin can upload image to non-existing user through the Upload user image API [POST ../api/v1/users/{userId}/upload-image] when 2FA is enabled globally and the user opted-out for 2FA.
    Given a POST API endpoint for Authorization microservices <testcase>
    When user sets the header params
    And enters valid Authorization key of bank admin authorizer and userId key and valid data in request body
    And sends POST request
    Then system receives 4xx HTTP error code
    And receives a valid application error response
    Examples:
      | testcase |
      | DB-TC-592 |

  Scenario Outline: Verify that a bank super admin can upload image to the initiated user who is in authorization pending status, through the Upload user image API [POST ../api/v1/users/{userId}/upload-image] when 2FA is enabled globally and the user opted-out for 2FA.
    Given a POST API endpoint for Authorization microservices <testcase>
    When user sets the header params
    And enters valid Authorization key of bank super admin authorizer and userId key and valid data in request body
    And sends POST request
    Then system receives 4xx HTTP error code
    And receives a valid application error response
    Examples:
      | testcase |
      | DB-TC-593 |

  Scenario Outline: Verify that a bank super admin can upload image to  existing user who is authorized, through the Upload user image API [POST ../api/v1/users/{userId}/upload-image] when 2FA is enabled globally and the user opted-out for 2FA.
    Given a POST API endpoint for Authorization microservices <testcase>
    When user sets the header params
    And enters valid Authorization key of bank super admin authorizer and userId key and valid data in request body
    And sends POST request
    Then receives 2xx HTTP success code
    And receives a valid application success response
    Examples:
      | testcase |
      | DB-TC-594 |

  Scenario Outline: Verify that a bank initiator can upload image to the initiated user who is in authorization pending status, through the Upload user image API [POST ../api/v1/users/{userId}/upload-image] when 2FA is enabled globally and the user opted-out for 2FA.
    Given a POST API endpoint for Authorization microservices <testcase>
    When user sets the header params
    And enters valid Authorization key of bank initiator and userId key and valid data in request body
    And sends POST request
    Then system receives 4xx HTTP error code
    And receives a valid application error response
    Examples:
      | testcase |
      | DB-TC-595 |

  Scenario Outline: Verify that a bank initiator can upload image to existing user who is authorized, through the Upload user image API [POST ../api/v1/users/{userId}/upload-image] when 2FA is enabled globally and the user opted-out for 2FA.
    Given a POST API endpoint for Authorization microservices <testcase>
    When user sets the header params
    And enters valid Authorization key of bank initiator and userId key and valid data in request body
    And sends POST request
    Then receives 2xx HTTP success code
    And receives a valid application success response
    Examples:
      | testcase |
      | DB-TC-596 |

  Scenario Outline: Verify that a bank Authorizer can upload image to the initiated user who is in authorization pending status, through the Upload user image API [POST ../api/v1/users/{userId}/upload-image] when 2FA is enabled globally and the user opted-out for 2FA.
    Given a POST API endpoint for Authorization microservices <testcase>
    When user sets the header params
    And enters valid Authorization key of bank authorizer and userId key and valid data in request body
    And sends POST request
    Then system receives 4xx HTTP error code
    And receives a valid application error response
    Examples:
      | testcase |
      | DB-TC-597 |

  Scenario Outline: Verify that a bank Authorizer can upload image to existing user who is authorized, through the Upload user image API [POST ../api/v1/users/{userId}/upload-image] when 2FA is enabled globally and the user opted-out for 2FA.
    Given a POST API endpoint for Authorization microservices <testcase>
    When user sets the header params
    And enters valid Authorization key of bank authorizer and userId key and valid data in request body
    And sends POST request
    Then system receives 4xx HTTP error code
    And receives a valid application error response
    Examples:
      | testcase |
      | DB-TC-598 |

  Scenario Outline: Verify that a bank initiatorAuthorizer can upload image to the initiated user who is in authorization pending status, through the Upload user image API [POST ../api/v1/users/{userId}/upload-image]
    Given a POST API endpoint for Authorization microservices <testcase>
    When user sets the header params
    And enters valid Authorization key of bank initiator authorizer and userId key and valid data in request body
    And sends POST request
    Then system receives 4xx HTTP error code
    And receives a valid application error response
    Examples:
      | testcase |
      | DB-TC-599 |

  Scenario Outline: Verify that a bank initiatorAuthorizer can upload image to existing user who is authorized, through the Upload user image API [POST ../api/v1/users/{userId}/upload-image] when 2FA is enabled globally and the user opted-out for 2FA.
    Given a POST API endpoint for Authorization microservices <testcase>
    When user sets the header params
    And enters valid Authorization key of bank initiator authorizer and userId key and valid data in request body
    And sends POST request
    Then receives 2xx HTTP success code
    And receives a valid application success response
    Examples:
      | testcase |
      | DB-TC-600 |

  Scenario Outline: Verify that a bank admin can upload image to non-existing user through the Upload user image API [POST ../api/v1/users/{userId}/upload-image] when 2FA is disabled globally
    Given a POST API endpoint for Authorization microservices <testcase>
    When user sets the header params
    And enters valid Authorization key of bank admin and userId key and valid data in request body
    And sends POST request
    Then system receives 4xx HTTP error code
    And receives a valid application error response
    Examples:
      | testcase |
      | DB-TC-601 |

  Scenario Outline: Verify that a bank super admin can upload image to the initiated user who is in authorization pending status, through the Upload user image API [POST ../api/v1/users/{userId}/upload-image] when 2FA is disabled globally
    Given a POST API endpoint for Authorization microservices <testcase>
    When user sets the header params
    And enters valid Authorization key of bank super admin and userId key and valid data in request body
    And sends POST request
    Then system receives 4xx HTTP error code
    And receives a valid application error response
    Examples:
      | testcase |
      | DB-TC-602 |

  Scenario Outline: Verify that a bank super admin can upload image to  existing user who is authorized, through the Upload user image API [POST ../api/v1/users/{userId}/upload-image] when 2FA is disabled globally
    Given a POST API endpoint for Authorization microservices <testcase>
    When user sets the header params
    And enters valid Authorization key of bank super admin and userId key and valid data in request body
    And sends POST request
    Then receives 2xx HTTP success code
    And receives a valid application success response
    Examples:
      | testcase |
      | DB-TC-603 |

  Scenario Outline: Verify that a bank initiator can upload image to the initiated user who is in authorization pending status, through the Upload user image API [POST ../api/v1/users/{userId}/upload-image] when 2FA is disabled globally
    Given a POST API endpoint for Authorization microservices <testcase>
    When user sets the header params
    And enters valid Authorization key of bank initiator and userId key and valid data in request body
    And sends POST request
    Then system receives 4xx HTTP error code
    And receives a valid application error response
    Examples:
      | testcase |
      | DB-TC-604 |

  Scenario Outline: Verify that a bank initiator can upload image to existing user who is authorized, through the Upload user image API [POST ../api/v1/users/{userId}/upload-image] when 2FA is disabled globally
    Given a POST API endpoint for Authorization microservices <testcase>
    When user sets the header params
    And enters valid Authorization key of bank initiator and userId key and valid data in request body
    And sends POST request
    Then receives 2xx HTTP success code
    And receives a valid application success response
    Examples:
      | testcase |
      | DB-TC-605 |

  Scenario Outline: Verify that a bank Authorizer can upload image to the initiated user who is in authorization pending status, through the Upload user image API [POST ../api/v1/users/{userId}/upload-image] when 2FA is disabled globally
    Given a POST API endpoint for Authorization microservices <testcase>
    When user sets the header params
    And enters valid Authorization key of bank authorizer and userId key and valid data in request body
    And sends POST request
    Then system receives 4xx HTTP error code
    And receives a valid application error response
    Examples:
      | testcase |
      | DB-TC-606 |

  Scenario Outline: Verify that a bank Authorizer can upload image to existing user who is authorized, through the Upload user image API [POST ../api/v1/users/{userId}/upload-image] when 2FA is disabled globally
    Given a POST API endpoint for Authorization microservices <testcase>
    When user sets the header params
    And enters valid Authorization key of bank authorizer and userId key and valid data in request body
    And sends POST request
    Then system receives 4xx HTTP error code
    And receives a valid application error response
    Examples:
      | testcase |
      | DB-TC-607 |

  Scenario Outline: Verify that a bank initiatorAuthorizer can upload image to the initiated user who is in authorization pending status, through the Upload user image API [POST ../api/v1/users/{userId}/upload-image] when 2FA is disabled globally
    Given a POST API endpoint for Authorization microservices <testcase>
    When user sets the header params
    And enters valid Authorization key of bank initiator authorizer and userId key and valid data in request body
    And sends POST request
    Then system receives 4xx HTTP error code
    And receives a valid application error response
    Examples:
      | testcase |
      | DB-TC-608 |

  Scenario Outline: Verify that a bank initiatorAuthorizer can upload image to existing user who is authorized, through the Upload user image API [POST ../api/v1/users/{userId}/upload-image] when 2FA is disabled globally
    Given a POST API endpoint for Authorization microservices <testcase>
    When user sets the header params
    And enters valid Authorization key of bank initiator authorizer and userId key and valid data in request body
    And sends POST request
    Then receives 2xx HTTP success code
    And receives a valid application success response
    Examples:
      | testcase |
      | DB-TC-610 |

  Scenario Outline: Verify the length field in Set password policies API [PUT../api/v1/realms/passwordPolicies]
    Given a PUT API endpoint for Authorization microservices <testcase>
    When user sets the header params
    And enters length in request body
    And sends PUT request
    Then receives 2xx HTTP success code
    And receives a valid application success response
    Examples:
      | testcase |
      | DB-TC-611 |

  Scenario Outline: Verify the upperCase field in Set password policies API [PUT../api/v1/realms/passwordPolicies]
    Given a PUT API endpoint for Authorization microservices <testcase>
    When user sets the header params
    And enters upperCase in request body
    And sends PUT request
    Then receives 2xx HTTP success code
    And receives a valid application success response
    Examples:
      | testcase |
      | DB-TC-614 |

  Scenario Outline: Verify the lowerCase field in Set password policies API [PUT../api/v1/realms/passwordPolicies]
    Given a PUT API endpoint for Authorization microservices <testcase>
    When user sets the header params
    And enters lowerCase in request body
    And sends PUT request
    Then receives 2xx HTTP success code
    And receives a valid application success response
    Examples:
      | testcase |
      | DB-TC-615 |

  Scenario Outline: Verify the digits field in Set password policies API [PUT../api/v1/realms/passwordPolicies]
    Given a PUT API endpoint for Authorization microservices <testcase>
    When user sets the header params
    And enters digits in request body
    And sends PUT request
    Then receives 2xx HTTP success code
    And receives a valid application success response
    Examples:
      | testcase |
      | DB-TC-616 |

  Scenario Outline: Verify the specialChars field in Set password policies API [PUT../api/v1/realms/passwordPolicies]
    Given a PUT API endpoint for Authorization microservices <testcase>
    When user sets the header params
    And enters specialChars in request body
    And sends PUT request
    Then receives 2xx HTTP success code
    And receives a valid application success response
    Examples:
      | testcase |
      | DB-TC-617 |

  Scenario Outline: Verify the maxLength field in Set password policies API [PUT../api/v1/realms/passwordPolicies]
    Given a PUT API endpoint for Authorization microservices <testcase>
    When user sets the header params
    And enters maxLength in request body
    And sends PUT request
    Then receives 2xx HTTP success code
    And receives a valid application success response
    Examples:
      | testcase |
      | DB-TC-618 |

  Scenario Outline: Verify the passwordHistory field in Set password policies API [PUT../api/v1/realms/passwordPolicies]
    Given a PUT API endpoint for Authorization microservices <testcase>
    When user sets the header params
    And enters passwordHistory in request body
    And sends PUT request
    Then receives 2xx HTTP success code
    And receives a valid application success response
    Examples:
      | testcase |
      | DB-TC-619 |

  Scenario Outline: Verify the notUsername field in Set password policies API [PUT../api/v1/realms/passwordPolicies]
    Given a PUT API endpoint for Authorization microservices <testcase>
    When user sets the header params
    And enters notUsername in request body
    And sends PUT request
    Then receives 2xx HTTP success code
    And receives a valid application success response
    Examples:
      | testcase |
      | DB-TC-620 |

  Scenario Outline: Verify the notEmail field in Set password policies API [PUT../api/v1/realms/passwordPolicies]
    Given a PUT API endpoint for Authorization microservices <testcase>
    When user sets the header params
    And enters notEmail in request body
    And sends PUT request
    Then receives 2xx HTTP success code
    And receives a valid application success response
    Examples:
      | testcase |
      | DB-TC-621 |

  Scenario Outline: Verify that a bank admin can view the users details through the Get users API [GET ../api/v1/users] when 2FA is enabled globally and the user opted-in for 2FA.
    Given a GET API endpoint for Authorization microservices <testcase>
    When user sets the header params
    And enters valid Authorization key of bank admin and userId key and valid data in request body
    And sends GET request
    Then receives 2xx HTTP success code
    And receives a valid application success response
    Examples:
      | testcase |
      | DB-TC-622 |

  Scenario Outline: Verify that a bank admin can view the users details through the Get users API [GET ../api/v1/users] when 2FA is enabled globally and the user opted-in for 2FA.
    Given a GET API endpoint for Authorization microservices <testcase>
    When user sets the header params
    And enters valid Authorization key of bank admin and userId key and valid data in request body
    And sends GET request
    Then receives 2xx HTTP success code
    And receives a valid application success response
    Examples:
      | testcase |
      | DB-TC-623 |

  Scenario Outline: Verify that a bank admin can view the users details through the Get users API [GET ../api/v1/users] when 2FA is disabled globally
    Given a GET API endpoint for Authorization microservices <testcase>
    When user sets the header params
    And enters valid Authorization key of bank admin and userId key and valid data in request body
    And sends GET request
    Then receives 2xx HTTP success code
    And receives a valid application success response
    Examples:
      | testcase |
      | DB-TC-624 |

  Scenario Outline: Verify the response of Set password policies API [PUT../api/v1/realms/passwordPolicies]
    Given a PUT API endpoint for Authorization microservices <testcase>
    When user sets the header params
    And enters data in request body
    And sends PUT request
    Then receives 2xx HTTP success code
    And receives a valid application success response
    Examples:
      | testcase |
      | DB-TC-628 |

  Scenario Outline: Verify the response of Get dashboard data by API [GET../api/v1/dashboard] for bank admin
    Given a GET API endpoint for Authorization microservices <testcase>
    When user sets the header params
    And enters valid Authorization key of bank admin
    And sends GET request
    Then receives 2xx HTTP success code
    And receives a valid application success response
    Examples:
      | testcase |
      | DB-TC-629 |

  Scenario Outline: Verify the response of Get password policies API [GET../api/v1/passwordPolicies] for bank admin
    Given a GET API endpoint for Authorization microservices <testcase>
    When user sets the header params
    And enters valid Authorization key of bank admin
    And sends GET request
    Then receives 2xx HTTP success code
    And receives a valid application success response
    Examples:
      | testcase |
      | DB-TC-635 |

  Scenario Outline: Verify the response of Get password policies API [GET../api/v1/realms/passwordPolicies] for bank admin
    Given a GET API endpoint for Authorization microservices <testcase>
    When user sets the header params
    And enters valid Authorization key of bank admin
    And sends GET request
    Then receives 2xx HTTP success code
    And receives a valid application success response
    Examples:
      | testcase |
      | DB-TC-639 |

  Scenario Outline: Verify the response of Get user by email API [GET-api/v1/users-by-email]
    Given a GET API endpoint for Authorization microservices <testcase>
    When user sets the header params
    And sends GET request
    Then receives 2xx HTTP success code
    And receives a valid application success response
    Examples:
      | testcase |
      | DB-TC-640 |

  Scenario Outline: Verify the response of Get menu items API [GET../api/v1/users/menu-items] for bank admin
    Given a GET API endpoint for Authorization microservices <testcase>
    When user sets the header params
    And enters valid Authorization key of bank admin
    And sends GET request
    Then receives 2xx HTTP success code
    And receives a valid application success response
    Examples:
      | testcase |
      | DB-TC-641 |

  Scenario Outline: Verify the name field in Create a role API [POST../api/v1/roles]
    Given a POST API endpoint for Authorization microservices <testcase>
    When user sets the header params
    And enters invalid name in request body
    And sends POST request
    Then system receives 4xx HTTP error code
    And receives a valid application error response
    Examples:
      | testcase |
      | DB-TC-647 |

  Scenario Outline: Verify the description field in Create a role API [POST../api/v1/roles]
    Given a POST API endpoint for Authorization microservices <testcase>
    When user sets the header params
    And enters invalid description in request body
    And sends POST request
    Then system receives 4xx HTTP error code
    And receives a valid application error response
    Examples:
      | testcase |
      | DB-TC-648 |

  Scenario Outline: Verify the composite field in Create a role API [POST../api/v1/roles]
    Given a POST API endpoint for Authorization microservices <testcase>
    When user sets the header params
    And enters invalid composite in request body
    And sends POST request
    Then system receives 4xx HTTP error code
    And receives a valid application error response
    Examples:
      | testcase |
      | DB-TC-649 |

  Scenario Outline: Verify the clientRole field in Create a role API [POST../api/v1/roles]
    Given a POST API endpoint for Authorization microservices <testcase>
    When user sets the header params
    And enters invalid clientRole in request body
    And sends POST request
    Then system receives 4xx HTTP error code
    And receives a valid application error response
    Examples:
      | testcase |
      | DB-TC-650 |

  Scenario Outline: Verify the response of Create a role API [POST../api/v1/roles] for bank admin
    Given a POST API endpoint for Authorization microservices <testcase>
    When user sets the header params
    And enters data in request body
    And sends POST request
    Then receives 2xx HTTP success code
    And receives a valid application success response
    Examples:
      | testcase |
      | DB-TC-651 |

  Scenario Outline: Verify the response of Get all roles API [GET../api/v1/roles] for bank admin
    Given a GET API endpoint for Authorization microservices <testcase>
    When user sets the header params
    And sends GET request
    Then receives 2xx HTTP success code
    And receives a valid application success response
    Examples:
      | testcase |
      | DB-TC-659 |

  Scenario Outline: Verify the response of Get a role by name API [GET../api/v1/roles/{roleName}] for bank admin
    Given a GET API endpoint for Authorization microservices <testcase>
    When user sets the header params
    And sends GET request
    Then receives 2xx HTTP success code
    And receives a valid application success response
    Examples:
      | testcase |
      | DB-TC-660 |

  Scenario Outline: Verify the response of Delete a role by name [DELETE../api/v1/roles/{roleName}] for bank admin
    Given a Delete API endpoint for Authorization microservices <testcase>
    When user sets the header params
    And enters valid Authorization key and roleName of bank admin
    And sends Delete request
    Then receives 2xx HTTP success code
    And receives a valid application success response
    Examples:
      | testcase |
      | DB-TC-663 |

  Scenario Outline: Verify the old password field in change password API [PUT../api/v1/users/{userId}/change-password]
    Given a PUT API endpoint for Authorization microservices <testcase>
    When user sets the header params
    And enters invalid oldPassword in request body
    And sends PUT request
    Then system receives 4xx HTTP error code
    And receives a valid application error response
    Examples:
      | testcase |
      | DB-TC-666 |

  Scenario Outline: Verify the New password field in change password API [PUT../api/v1/users/{userId}/change-password]
    Given a PUT API endpoint for Authorization microservices <testcase>
    When user sets the header params
    And enters invalid newPassword in request body
    And sends PUT request
    Then system receives 4xx HTTP error code
    And receives a valid application error response
    Examples:
      | testcase |
      | DB-TC-667 |

  Scenario Outline: Verify the confirm password field in change password API [PUT../api/v1/users/{userId}/change-password]
    Given a PUT API endpoint for Authorization microservices <testcase>
    When user sets the header params
    And enters invalid confirmPassword in request body
    And sends PUT request
    Then system receives 4xx HTTP error code
    And receives a valid application error response
    Examples:
      | testcase |
      | DB-TC-668 |

  Scenario Outline: Verify that a existing bank admin can change the password through the change password API [PUT ../api/v1/users/{userId}/change-password] when 2FA is enabled globally and the user opted-in for 2FA.
    Given a PUT API endpoint for Authorization microservices <testcase>
    When user sets the header params
    And enters valid Authorization key of existing bank admin and valid data in request body
    And sends PUT request
    Then receives 2xx HTTP success code
    And receives a valid application success response
    Examples:
      | testcase |
      | DB-TC-669 |

  Scenario Outline: Verify that a existing bank admin can change the password through the change password API [PUT ../api/v1/users/{userId}/change-password] when 2FA is enabled globally and the user opted-out for 2FA.
    Given a PUT API endpoint for Authorization microservices <testcase>
    When user sets the header params
    And enters valid Authorization key of existing bank admin and valid data in request body
    And sends PUT request
    Then receives 2xx HTTP success code
    And receives a valid application success response
    Examples:
      | testcase |
      | DB-TC-670 |

  Scenario Outline: Verify that a existing bank admin can change the password through the change password API [PUT ../api/v1/users/{userId}/change-password] when 2FA is disabled globally
    Given a PUT API endpoint for Authorization microservices <testcase>
    When user sets the header params
    And enters valid Authorization key of existing bank admin and valid data in request body
    And sends PUT request
    Then receives 2xx HTTP success code
    And receives a valid application success response
    Examples:
      | testcase |
      | DB-TC-671 |
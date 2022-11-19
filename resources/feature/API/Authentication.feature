Feature: Authentication API feature

  Background: Backend API should be available

  @1
  Scenario Outline: Verify the response message is depend on the Accepted Language parameter for all POST methods in Authentication APIs.
    Given a POST API endpoint for Authentication microservices <testcase>
    When user sends the POST login request <testcase>
    Then system receives Http 2xx HTTP success code <testcase>
    And receives a valid response
    Examples:
      | testcase  |
      | DB-TC-397 |

  @2
  Scenario Outline: Verify the response message is depend on the X-Tenant ID parameter for all POST methods in Authentication APIs.
    Given a POST API endpoint for Authentication microservices <testcase>
    When user sends the POST login request <testcase>
    Then system receives Http 2xx HTTP success code <testcase>
    And receives a valid response
    Examples:
      | testcase  |
      | DB-TC-398 |

  @3
#  Scenario Outline: Verify the response message is depend on the Accepted Language parameter for all PUT methods in Authentication APIs.
#    Given a PUT API endpoint for Authentication microservices <testcase>
#    When user sends the PUT request
#    Then system receives Http 2xx HTTP success code
#    And receives a valid response
#    Examples:
#      | testcase |
#      | DB-TC-409 |
#
#  Scenario Outline: Verify the response message is depend on the X-Tenant ID parameter for all PUT methods in Authentication APIs.
#    Given a PUT API endpoint for Authentication microservices <testcase>
#    When user sends the PUT request
#    Then system receives Http 2xx HTTP success code
#    And receives a valid response
#    Examples:
#      | testcase |
#      | DB-TC-410 |

    @5
  #access token  authorization
  Scenario Outline: Verify the userId field in Generate otp API [POST../api/v1/otp/generate]
    Given a OTP POST API endpoint for Authentication microservices <testcase>
    And enters invalid userId in OTP request body <testcase>
    And sends POST request
    Then system receives 4xx HTTP error code
    And receives a valid application error response
    Examples:
      | testcase  |
      | DB-TC-396 |

  @6
  Scenario Outline: Verify the emailId field in Generate otp API [POST../api/v1/otp/generate]
    Given a OTP POST API endpoint for Authentication microservices <testcase>
    And enters invalid emailId in request body <testcase>
    And sends POST request
    Then system receives 4xx HTTP error code
    And receives a valid application error response
    Examples:
      | testcase  |
      | DB-TC-422 |

  @7
  Scenario Outline: Verify the apiRequestMap [array]field in Generate otp API [POST../api/v1/otp/generate]
    Given a OTP POST API endpoint for Authentication microservices <testcase>
    And enters invalid apiRequestMap in request body <testcase>
    And sends POST request
    Then system receives 4xx HTTP error code
    And receives a valid application error response
    Examples:
      | testcase  |
      | DB-TC-426 |

  @8
  Scenario Outline: Verify the mobileNumber field in Generate otp API [POST../api/v1/otp/generate]
    Given a OTP POST API endpoint for Authentication microservices <testcase>
    And enters invalid mobileNumber in request body <testcase>
    And sends POST request
    Then system receives 4xx HTTP error code
    And receives a valid application error response
    Examples:
      | testcase  |
      | DB-TC-423 |

  @9
  Scenario Outline: Verify the appType field in Generate otp API [POST../api/v1/otp/generate]
    Given a OTP POST API endpoint for Authentication microservices <testcase>
    And enters invalid appType in request  <testcase>
    And sends POST request
    Then system receives 4xx HTTP error code
    And receives a valid application error response
    Examples:
      | testcase  |
      | DB-TC-408 |

  @10
  Scenario Outline: Verify the OTP Response in Generate OTP API [POST-api/v1/otp/generate] for New User First time login when 2FA = TRUE and Bank admin has opted in for OTP
    Given a OTP POST API endpoint for Authentication microservices <testcase>
    And enters invalid userId in OTP request body <testcase>
    And sends POST request
    Then system receives 4xx HTTP error code
    And receives a valid application error response
    Examples:
      | testcase  |
      | DB-TC-396 |

  @11
  Scenario Outline: Verify the OTP Response in Generate OTP API [POST-api/v1/otp/generate] for New User First time login when 2FA = TRUE and Bank admin has opted in for OTP
    Given a OTP POST API endpoint for invalid Authentication key microservices <testcase>
    And enters valid Authorization key of new bank admin and valid data in request <testcase>
    And sends POST request
    Then receives 2xx HTTP success code
    And receives a valid application success response
    Examples:
      | testcase  |
      | DB-TC-399 |

  @12
  Scenario Outline: Verify the OTP Response in Generate OTP API [POST-api/v1/otp/generate] for New User First time login when 2FA = TRUE and Bank admin has opted out for OTP
    Given a OTP POST API endpoint for invalid Authentication key microservices <testcase>
    And enters valid Authorization key of new bank admin and valid data in request body <testcase>
    And sends POST request
    Then receives 2xx HTTP success code
    And receives a valid application success response
    Examples:
      | testcase  |
      | DB-TC-400 |

  @13
  Scenario Outline: Verify the OTP Response in Generate OTP API [POST-api/v1/otp/generate] for New User First time login when 2FA = FALSE
    Given a OTP POST API endpoint for invalid Authentication key microservices <testcase>
    And enters valid Authorization key of new bank admin and valid data in request body <testcase>
    And sends POST request
    Then receives 2xx HTTP success code
    And receives a valid application success response
    Examples:
      | testcase  |
      | DB-TC-401 |

  @14
  Scenario Outline: Verify the OTP Response in Generate OTP API [POST-api/v1/otp/generate] for Expired User Login when 2FA = TRUE and Bank admin has opted in for OTP
    Given a OTP POST API endpoint for invalid Authentication key microservices <testcase>
    And enters valid Authorization key of expired bank admin and valid data in request body<testcase>
    And sends POST request
    Then receives 2xx HTTP success code
    And receives a valid application success response
    Examples:
      | testcase  |
      | DB-TC-402 |

  @15
  Scenario Outline: Verify the OTP Response in Generate OTP API [POST-api/v1/otp/generate] for Expired User Login when 2FA = TRUE and Bank admin has opted out for OTP
    Given a OTP POST API endpoint for invalid Authentication key microservices <testcase>
    And enters valid Authorization key of expired bank admin and valid data in request body<testcase>
    And sends POST request
    Then receives 2xx HTTP success code
    And receives a valid application success response
    Examples:
      | testcase  |
      | DB-TC-403 |

  @16
  Scenario Outline: Verify the OTP Response in Generate OTP API [POST-api/v1/otp/generate] for Expired User Login when 2FA = FALSE
    Given a OTP POST API endpoint for invalid Authentication key microservices <testcase>
    And enters valid Authorization key of expired bank admin and valid data in request body<testcase>    And sends POST request
    And sends POST request
    Then receives 2xx HTTP success code
    And receives a valid application success response
    Examples:
      | testcase  |
      | DB-TC-404 |

  @17
  Scenario Outline: Verify the OTP Response in Generate OTP API [POST-api/v1/otp/generate] for Existing User Login when 2FA = TRUE and Bank admin has opted in for OTP
    Given a OTP POST API endpoint for invalid Authentication key microservices <testcase>
    And enters valid Authorization key of expired bank admin and valid data in request body<testcase>
    And sends POST request
    Then receives 2xx HTTP success code
    And receives a valid application success response
    Examples:
      | testcase  |
      | DB-TC-405 |

  @18
  Scenario Outline: Verify the OTP Response in Generate OTP API [POST-api/v1/otp/generate] for Existing User Login when 2FA = TRUE and Bank admin has opted out for OTP
    Given a OTP POST API endpoint for invalid Authentication key microservices <testcase>
    And enters valid Authorization key of expired bank admin and valid data in request body<testcase>
    And sends POST request
    Then system receives 4xx HTTP error code
    And receives a valid application error response
    Examples:
      | testcase  |
      | DB-TC-406 |

  @19
  Scenario Outline: Verify the OTP Response in Generate OTP API [POST-api/v1/otp/generate] for Existing User Login when 2FA = FALSE
    Given a OTP POST API endpoint for invalid Authentication key microservices <testcase>
    And enters valid Authorization key of expired bank admin and valid data in request body<testcase>
    And sends POST request
    Then system receives 4xx HTTP error code
    And receives a valid application error response
    Examples:
      | testcase  |
      | DB-TC-407 |

  @20
  Scenario Outline: Verify the userId field in Resend otp API [PUT../api/v1/otp/resend]
    Given a PUT API endpoint for Authentication microservices <testcase>
    When user sets the header params
    And enters invalid userId in request body<testcase>
    And sends PUT request
    Then system receives 4xx HTTP error code
    And receives a valid application error response
    Examples:
      | testcase  |
      | DB-TC-411 |

  @21
  Scenario Outline: Verify the refNo field in Resend otp API [PUT../api/v1/otp/resend]
    Given a PUT API endpoint for Authentication microservices <testcase>
    When user sets the header params
    And enters invalid refNo in request body<testcase>
    And sends PUT request
    Then system receives 4xx HTTP error code
    And receives a valid application error response
    Examples:
      | testcase  |
      | DB-TC-412 |

  @22
  Scenario Outline: Verify the response of Resend OTP [PUT../api/v1/otp/resend] when 2FA is enabled globally and the user opted-in for newly created bank admin
    Given a PUT API endpoint for Authentication microservices <testcase>
    When user sets the header params
    And enters valid Authorization key of new bank admin and valid data in put request body<testcase>
    And sends PUT request
    Then receives 2xx HTTP success code
    And receives a valid application success response
    Examples:
      | testcase  |
      | DB-TC-413 |

  @23
  Scenario Outline: Verify the response of Resend OTP [PUT../api/v1/otp/resend] when 2FA is enabled globally and the user opted-out for newly created bank admin
    Given a PUT API endpoint for Authentication microservices <testcase>
    When user sets the header params
    And enters valid Authorization key of new bank admin and valid data in put request body<testcase>
    And sends PUT request
    Then receives 2xx HTTP success code
    And receives a valid application success response
    Examples:
      | testcase  |
      | DB-TC-414 |

  @24
  Scenario Outline: Verify the response of Resend OTP [PUT../api/v1/otp/resend] when 2FA is disabled globally for newly created bank admin
    Given a PUT API endpoint for Authentication microservices <testcase>
    When user sets the header params
    And enters valid Authorization key of new bank admin and valid data in put request body<testcase>
    And sends PUT request
    Then receives 2xx HTTP success code
    And receives a valid application success response
    Examples:
      | testcase  |
      | DB-TC-415 |

  @25
  Scenario Outline: Verify the response of Resend OTP [PUT../api/v1/otp/resend] when 2FA is enabled globally and the user opted-in for existing bank admin
    Given a PUT API endpoint for Authentication microservices <testcase>
    When user sets the header params
    And enters valid Authorization key of existing bank admin and valid data in request body<testcase>
    And sends PUT request
    Then receives 2xx HTTP success code
    And receives a valid application success response
    Examples:
      | testcase  |
      | DB-TC-416 |

  @26
  Scenario Outline: Verify the response of Resend OTP [PUT../api/v1/otp/resend] when 2FA is enabled globally and the user opted-out for existing bank admin
    Given a PUT API endpoint for Authentication microservices <testcase>
    When user sets the header params
    And enters valid Authorization key of existing bank admin and valid data in request body<testcase>
    And sends PUT request
    Then system receives 4xx HTTP error code
    And receives a valid application error response
    Examples:
      | testcase  |
      | DB-TC-417 |

  @27
  Scenario Outline: Verify the response of Resend OTP [PUT../api/v1/otp/resend] when 2FA is disabled globally for existing bank admin
    Given a PUT API endpoint for Authentication microservices <testcase>
    When user sets the header params
    And enters valid Authorization key of existing bank admin and valid data in request body<testcase>
    And sends PUT request
    Then system receives 4xx HTTP error code
    And receives a valid application error response
    Examples:
      | testcase  |
      | DB-TC-418 |

  @29
  Scenario Outline: Verify the response of Resend OTP [PUT../api/v1/otp/resend] when 2FA is enabled globally and the user opted-in for expired bank admin
    Given a PUT API endpoint for Authentication microservices <testcase>
    When user sets the header params
    And enters valid Authorization key of expired bank admin and valid data in request <testcase>
    And sends PUT request
    Then receives 2xx HTTP success code
    And receives a valid application success response
    Examples:
      | testcase  |
      | DB-TC-419 |

  @30
  Scenario Outline: Verify the response of Resend OTP [PUT../api/v1/otp/resend] when 2FA is enabled globally and the user opted-out for expired bank admin
    Given a PUT API endpoint for Authentication microservices <testcase>
    When user sets the header params
    And enters valid Authorization key of expired bank admin and valid data in request <testcase>
    And sends PUT request
    Then receives 2xx HTTP success code
    And receives a valid application success response
    Examples:
      | testcase  |
      | DB-TC-420 |


  @31
  Scenario Outline: Verify the response of Resend OTP [PUT../api/v1/otp/resend] when 2FA is disabled globally for expired bank admin
    Given a PUT API endpoint for Authentication microservices <testcase>
    When user sets the header params
    And enters valid Authorization key of expired bank admin and valid data in resend request body<testcase>
    And sends PUT request
    Then receives 2xx HTTP success code
    And receives a valid application success response
    Examples:
      | testcase  |
      | DB-TC-421 |

  @32
  Scenario Outline: Verify the userId field in Validate otp API [PUT../api/v1/otp/validate]
    Given a PUT validate API endpoint for Authentication microservices <testcase>
    When user sets the header params
    And enters invalid userId in validate request body<testcase>
    And sends PUT request
    Then system receives 4xx HTTP error code
    And receives a valid application error response
    Examples:
      | testcase  |
      | DB-TC-427 |

  @33
  Scenario Outline: Verify the otp field in Validate otp API [PUT../api/v1/otp/validate]
    Given a PUT validate API endpoint for Authentication microservices <testcase>
    When user sets the header params
    And enters invalid otp in request body<testcase>
    And sends PUT request
    Then system receives 4xx HTTP error code
    And receives a valid application error response
    Examples:
      | testcase  |
      | DB-TC-428 |


  @34
  Scenario Outline: Verify the refNo field in Validate otp API [PUT../api/v1/otp/validate]
    Given a PUT validate API endpoint for Authentication microservices <testcase>
    When user sets the header params
    And enters invalid refNo in put validate request body<testcase>
    And sends PUT request
    Then system receives 4xx HTTP error code
    And receives a valid application error response
    Examples:
      | testcase  |
      | DB-TC-429 |

  @35
  Scenario Outline: Verify the requestId field in Validate otp API [PUT../api/v1/otp/validate]
    Given a PUT validate API endpoint for Authentication microservices <testcase>
    When user sets the header params
    And enters invalid requestId in put validate request body<testcase>
    And sends PUT request
    Then system receives 4xx HTTP error code
    And receives a valid application error response
    Examples:
      | testcase  |
      | DB-TC-430 |

  @36
  Scenario Outline: Verify the appType field in Validate otp API [PUT../api/v1/otp/validate]
    Given a PUT validate API endpoint for Authentication microservices <testcase>
    When user sets the header params
    And enters invalid appType in put validate request body<testcase>
    And sends PUT request
    Then system receives 4xx HTTP error code
    And receives a valid application error response
    Examples:
      | testcase  |
      | DB-TC-431 |

  @37
  Scenario Outline: Verify the response to validate an OTP by Validate otp API [PUT../api/v1/otp/validate] for bank admin
    Given a PUT validate API endpoint for Authentication microservices <testcase>
    When user sets the header params
    And enters valid Authorization key of bank admin and valid data in request body<testcase>
    And sends PUT request
    Then receives 2xx HTTP success code
    And receives a valid application success response
    Examples:
      | testcase  |
      | DB-TC-432 |

  @38
  Scenario Outline: Verify the user will be logout out by Logout a user API [POST-api/v1/users/logout].
    Given a POST logout API endpoint for Authentication microservices <testcase>
    When user sets the header params
    And enters valid Authorization key and refresh_token of bank admin and valid data in logout request body<testcase>
    And sends POST request
    Then receives 2xx HTTP success code
    And receives a valid application success response
    Examples:
      | testcase  |
      | DB-TC-436 |

  @39
  Scenario Outline: Verify the userId field in Login API [POST../api/v1/users/login]
    Given a POST logout API endpoint for Authentication microservices <testcase>
    When user sets the header params
    And enters invalid userId in logout post request body
    And sends POST request
    Then system receives 4xx HTTP error code
    And receives a valid application error response
    Examples:
      | testcase  |
      | DB-TC-439 |


  @40
  Scenario Outline: Verify the password field in Login API [POST../api/v1/users/login]
    Given a POST logout API endpoint for Authentication microservices <testcase>
    When user sets the header params
    And enters invalid password in logout post request body
    And sends POST request
    Then system receives 4xx HTTP error code
    And receives a valid application error response
    Examples:
      | testcase  |
      | DB-TC-440 |


#-------doubt
  @41
  Scenario Outline: Verify that a newly created bank admin can login through the Login with username and password API [POST ../api/v1/users/login] when 2FA is enabled globally and the user opted-in for 2FA.
    Given a POST API endpoint for Authentication microservices <testcase>
    When user sets the header params
    And enters valid OS-TYPE key of new bank admin and valid data in request body <testcase>
    And sends POST request
    Then system receives 4xx HTTP error code
    And receives a valid application error response
    Examples:
      | testcase  |
      | DB-TC-441 |

  @42
  Scenario Outline: Verify that a bank admin can login through Login with username and password API [POST../api/v1/users/login] when 2FA is enabled globally and the user opted-in for 2FA.
    Given a POST API endpoint for Authentication microservices <testcase>
    When user sets the header params
    And enters valid OS-TYPE key of new bank admin and valid data in request body <testcase>
    And sends POST request
    Then receives 2xx HTTP success code
    And receives a valid application success response
    Examples:
      | testcase  |
      | DB-TC-442 |

  @43
  Scenario Outline: Verify that a bank admin whose password is expired can login through Login with username and password API [POST../api/v1/users/login] when 2FA is enabled globally and the user opted-in for 2FA.
    Given a POST API endpoint for Authentication microservices <testcase>
    When user sets the header params
    And enters valid OS-TYPE key of new bank admin and valid data in request body <testcase>
    And sends POST request
    Then receives 2xx HTTP success code
    And receives a valid application success response
    Examples:
      | testcase  |
      | DB-TC-443 |

  @44
  Scenario Outline: Verify that a bank admin who has locked can login through Login with username and password API [POST../api/v1/users/login] when 2FA is enabled globally and the user opted-in for 2FA.
    Given a POST API endpoint for Authentication microservices <testcase>
    When user sets the header params
    And enters valid OS-TYPE key of new bank admin and valid data in request body <testcase>
    And sends POST request
    Then system receives 4xx HTTP error code
    And receives a valid application error response
    Examples:
      | testcase  |
      | DB-TC-444 |

  @45
  Scenario Outline: Verify that the bank admin who's already logged in can re-login through Login with username and password API [POST../api/v1/users/login] when 2FA is enabled globally and the user opted-in for 2FA.
    Given a POST API endpoint for Authentication microservices <testcase>
    When user sets the header params
    And enters valid OS-TYPE key of new bank admin and valid data in request body <testcase>
    And sends POST request
    Then receives 2xx HTTP success code
    And receives a valid application success response
    Examples:
      | testcase  |
      | DB-TC-445 |

  @46
  Scenario Outline: Verify that a newly created bank admin can login through the Login with username and password API [POST ../api/v1/users/login] when 2FA is enabled globally and the user opted-out for 2FA
    Given a POST API endpoint for Authentication microservices <testcase>
    When user sets the header params
    And enters valid OS-TYPE key of new bank admin and valid data in request body <testcase>
    And sends POST request
    Then system receives 4xx HTTP error code
    And receives a valid application error response
    Examples:
      | testcase  |
      | DB-TC-446 |

  @47
  Scenario Outline: Verify that a bank admin can log in through Login with username and password API [POST../api/v1/users/login] when 2FA is enabled globally and the user opted-out for 2FA.
    Given a POST API endpoint for Authentication microservices <testcase>
    When user sets the header params
    And enters valid OS-TYPE key of new bank admin and valid data in request body <testcase>
    And sends POST request
    Then receives 2xx HTTP success code
    And receives a valid application success response
    Examples:
      | testcase  |
      | DB-TC-447 |

  @48
  Scenario Outline: Verify that a bank admin whose password is expired can login through Login with username and password API [POST../api/v1/users/login] when 2FA is enabled globally and the user opted-out for 2FA.
    Given a POST API endpoint for Authentication microservices <testcase>
    When user sets the header params
    And enters valid OS-TYPE key of new bank admin and valid data in request body <testcase>
    And sends POST request
    Then receives 2xx HTTP success code
    And receives a valid application success response
    Examples:
      | testcase  |
      | DB-TC-448 |

  @49
  Scenario Outline: Verify that a bank admin who has locked can login through Login with username and password API [POST../api/v1/users/login] when 2FA is enabled globally and the user opted-out for 2FA.
    Given a POST API endpoint for Authentication microservices <testcase>
    When user sets the header params
    And enters valid OS-TYPE key of new bank admin and valid data in request body <testcase>
    And sends POST request
    Then system receives 4xx HTTP error code
    And receives a valid application error response
    Examples:
      | testcase  |
      | DB-TC-449 |


  @50
  Scenario Outline: Verify that the bank admin who's already logged in can re-login through Login with username and password API [POST../api/v1/users/login] when 2FA is enabled globally and the user opted-out for 2FA.
    Given a POST API endpoint for Authentication microservices <testcase>
    When user sets the header params
    And enters valid OS-TYPE key of new bank admin and valid data in request body <testcase>
    And sends POST request
    Then receives 2xx HTTP success code
    And receives a valid application success response
    Examples:
      | testcase  |
      | DB-TC-450 |

  @51
  Scenario Outline: Verify that a newly created bank admin can login through the Login with username and password API [POST ../api/v1/users/login] when 2FA is disabled
    Given a POST API endpoint for Authentication microservices <testcase>
    When user sets the header params
    And enters valid OS-TYPE key of new bank admin and valid data in request body <testcase>
    And sends POST request
    Then system receives 4xx HTTP error code
    And receives a valid application error response
    Examples:
      | testcase  |
      | DB-TC-451 |

  @52
  Scenario Outline: Verify that a bank admin can login through Login with username and password API [POST../api/v1/users/login] when 2FA is disabled.
    Given a POST API endpoint for Authentication microservices <testcase>
    When user sets the header params
    And enters valid OS-TYPE key of new bank admin and valid data in request body <testcase>
    And sends POST request
    Then receives 2xx HTTP success code
    And receives a valid application success response
    Examples:
      | testcase  |
      | DB-TC-452 |

  @53
  Scenario Outline: Verify that a bank admin whose password is expired can login through Login with username and password API [POST../api/v1/users/login] when 2FA is disabled.
    Given a POST API endpoint for Authentication microservices <testcase>
    When user sets the header params
    And enters valid OS-TYPE key of new bank admin and valid data in request body <testcase>
    And sends POST request
    Then receives 2xx HTTP success code
    And receives a valid application success response
    Examples:
      | testcase  |
      | DB-TC-453 |

  @54
  Scenario Outline: Verify that a bank admin who has locked can log in through Login with username and password API [POST../api/v1/users/login] when 2FA is disabled.
    Given a POST API endpoint for Authentication microservices <testcase>
    When user sets the header params
    And enters valid OS-TYPE key of new bank admin and valid data in request body <testcase>
    And sends POST request
    Then system receives 4xx HTTP error code
    And receives a valid application error response
    Examples:
      | testcase  |
      | DB-TC-454 |

  @55
  Scenario Outline: Verify that the bank admin who's already logged in can re-login through Login with username and password API [POST../api/v1/users/login] when 2FA is disabled.
    Given a POST API endpoint for Authentication microservices <testcase>
    When user sets the header params
    And enters valid OS-TYPE key of new bank admin and valid data in request body <testcase>
    And sends POST request
    Then receives 2xx HTTP success code
    And receives a valid application success response
    Examples:
      | testcase  |
      | DB-TC-455 |

  Scenario Outline: Verify the session is refreshed and a new token is generated by Refresh access token API [POST-api/v1/refresh-access-token].
    Given refresh POST API endpoint for Authentication microservices <testcase>
    When user sets the header params
    And enters valid refresh_token key of bank admin<testcase>
    And sends POST request
    Then receives 2xx HTTP success code
    And receives a valid application success response
    Examples:
      | testcase  |
      | DB-TC-459 |
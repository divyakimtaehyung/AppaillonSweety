Feature: Workflow management API feature

  Background: Backend API should be available

  @1
  Scenario Outline: Verify that Bank Admin initiator is able to Add initiate the workflow when POST API [../v1/corporate-onboard/workflows] is performed
    Given set API URI and headers <testcase>
    Given a POST API endpoint for workflow mapping <testcase>
    And enters valid bank admin initiator in actionBy field and valid data in request body
    And sends POST request<testcase>
    Then receives 2xx HTTP success code
    And receives a valid application success response
    Examples:
      | testcase  |
      | DB-TC-213 |

  @2
  Scenario Outline: Verify the code is mandatory field in request body of initiate the addition of the workflow when POST API [../v1/corporate-onboard/workflows] is performed
    Given set API URI and headers <testcase>
    Then a POST API endpoint for workflow mapping <testcase>
    And enters invalid code in request body<testcase>
    And sends POST request<testcase>
    Then system receives 4xx HTTP error code
    And receives a valid application error response
    Examples:
      | testcase  |
      | DB-TC-205 |

  @3
  Scenario Outline: Verify the id is mandatory field in request body of initiate the addition of the workflow when POST API [../v1/corporate-onboard/workflows] is performed
    Given set API URI and headers <testcase>
    Given a POST API endpoint for workflow mapping <testcase>
    And enters invalid id in request body <testcase>
    And sends POST request<testcase>
    Then system receives 4xx HTTP error code
    And receives a valid application error response
    Examples:
      | testcase  |
      | DB-TC-206 |

  @4
  Scenario Outline: Verify the description is mandatory field in request body of initiate the addition of the workflow when POST API [../v1/corporate-onboard/workflows] is performed
    Given set API URI and headers <testcase>
    Given a POST API endpoint for workflow mapping <testcase>
    And enters invalid description in the request body
    And sends POST request<testcase>
    Then system receives 4xx HTTP error code
    And receives a valid application error response
    Examples:
      | testcase  |
      | DB-TC-207 |

  @5
  Scenario Outline: Verify the workflowKey is mandatory field in request body of initiate the addition of the workflow when POST API [../v1/corporate-onboard/workflows] is performed
    Given set API URI and headers <testcase>
    Given a POST API endpoint for workflow mapping <testcase>
    And enters invalid workflowKey in request body
    And sends POST request<testcase>
    Then system receives 4xx HTTP error code
    And receives a valid application error response
    Examples:
      | testcase  |
      | DB-TC-208 |

  @6
  Scenario Outline: Verify the tenant is mandatory field in request body of initiate the addition of the workflow when POST API [../v1/corporate-onboard/workflows] is performed
    Given set API URI and headers <testcase>
    Given a POST API endpoint for workflow mapping <testcase>
    And enters invalid tenant in request body
    And sends POST request<testcase>
    Then system receives 4xx HTTP error code
    And receives a valid application error response
    Examples:
      | testcase  |
      | DB-TC-209 |

  @7
  Scenario Outline: Verify the actionBy is mandatory field in request body of initiate the addition of the workflow when POST API [../v1/corporate-onboard/workflows] is performed
    Given set API URI and headers <testcase>
    Given a POST API endpoint for workflow mapping <testcase>
    And enters invalid actionBy in request body
    And sends POST request<testcase>
    Then system receives 4xx HTTP error code
    And receives a valid application error response
    Examples:
      | testcase  |
      | DB-TC-210 |

  @8
  Scenario Outline: Verify that each code is linked with an respective Id's when POST API [../v1/corporate-onboard/workflows] is performed
    Given set API URI and headers <testcase>
    Given a POST API endpoint for workflow mapping <testcase>
    And enters valid data in code and other fields in request body
    And enters valid id which is not linked with the given code in request body
    And sends POST request<testcase>
    Then system receives 4xx HTTP error code
    And receives a valid application error response
    Examples:
      | testcase  |
      | DB-TC-211 |

  @9
  Scenario Outline: Verify that Bank Admin of tenant_1 shouldn't add initiate a workflow for Tenant_2 when POST API [../v1/corporate-onboard/workflows] is performed
    Given set API URI and headers <testcase>
    Given a POST API endpoint for workflow mapping <testcase>
    And And enters valid data in request body
    And enters valid tenant_Y in request body
    And sends POST request<testcase>
    Then system receives 4xx HTTP error code
    And receives a valid application error response
    Examples:
      | testcase  |
      | DB-TC-212 |


  @10
  Scenario Outline: Verify that Bank Admin Authorizer won't able to Add initiate the workflow when POST API [../v1/corporate-onboard/workflows] is performed
    Given set API URI and headers <testcase>
    Given a POST API endpoint for workflow mapping <testcase>
    And enters valid bank admin authorizer in actionBy field and valid data in other fields
    And sends POST request<testcase>
    Then system receives 4xx HTTP error code
    And receives a valid application error response
    Examples:
      | testcase  |
      | DB-TC-214 |


  @11
  Scenario Outline: Verify that Bank Admin Initiator and Authorizer is able to Add initiate the workflow when POST API [../v1/corporate-onboard/workflows] is performed
    Given set API URI and headers <testcase>
    Given a POST API endpoint for workflow mapping <testcase>
    And enters valid Bank Admin Initiator and Authorizer in actionBy field and valid data in request body
    And sends POST request<testcase>
    Then receives 2xx HTTP success code
    And receives a valid application success response
    Examples:
      | testcase  |
      | DB-TC-215 |

  @12
  Scenario Outline: Verify that Super Admin is able to Add initiate the workflow when POST API [../v1/corporate-onboard/workflows] is performed
    Given set API URI and headers <testcase>
    Given a POST API endpoint for workflow mapping <testcase>
    And enters valid Super Admin in actionBy field and valid data in other fields request body
    And sends POST request<testcase>
    Then receives 2xx HTTP success code
    And receives a valid application success response
    Examples:
      | testcase  |
      | DB-TC-216 |

  @13
  Scenario Outline: Verify that Bank Admin is not able initiate an existing workflow of a tenant when POST API [../v1/corporate-onboard/workflows] is performed
    Given set API URI and headers <testcase>
    Given a POST API endpoint for workflow mapping <testcase>
    And enters existing workflow in tenant and valid data in other fields of request body
    And sends POST request<testcase>
    Then system receives 4xx HTTP error code
    And receives a valid application error response
    Examples:
      | testcase  |
      | DB-TC-217 |

  @14
  Scenario Outline: Verify that Bank Admin is not able initiate an existing workflow of a tenant when POST API [../v1/corporate-onboard/workflows] is performed
    Given set API URI and headers <testcase>
    Given a POST API endpoint for workflow mapping <testcase>
    And enters deleted workflow in tenant and valid data in other fields of request body
    And sends POST request<testcase>
    Then receives 2xx HTTP success code
    And receives a valid application success response
    Examples:
      | testcase  |
      | DB-TC-218 |

  @15
  Scenario Outline: Verify that system should list down all the configured workflows when GET API [../v1/workflow/tasks/listworkflow] is performed
    Given set API URI and headers <testcase>
    Given a GET API endpoint for workflow mapping <testcase>
    When user sends the GET request
    Then system receives 2xx HTTP success code
    And receives a valid workflow keys as response
    Examples:
      | testcase  |
      | DB-TC-202 |

  @16
  Scenario Outline: Verify that Bank Admin Authorizer is able to authorize the Add initiated workflow when PUT API [../v1/corporate-onboard/workflows/{id}/tenants/{tenant}] is performed
    Given set API URI and headers <testcase>
    Given a PUT API endpoint for workflow mapping <testcase>
    And enters ADDAUTH in action and Bank Admin authorizer in actionBy and fill valid details in other fields of request body
    And sends PUT request
    Then system receives 2xx HTTP success code
    And receives a valid application success response
    Examples:
      | testcase  |
      | DB-TC-224 |

  @17
  Scenario Outline: Verify that Bank Admin Initiator is not able to authorize the Add initiated workflow when PUT API [../v1/corporate-onboard/workflows/{id}/tenants/{tenant}] is performed
    Given set API URI and headers <testcase>
    Given a PUT API endpoint for workflow mapping <testcase>
    And enters ADDAUTH in action and Bank Admin Initiator in actionBy and valid details in other fields of request body
    And sends PUT request
    Then receives 4xx HTTP error code
    And receives a valid application error response
    Examples:
      | testcase  |
      | DB-TC-231 |

  @18
  Scenario Outline: Verify that Bank Admin with a role (Initiator and Authorizer) is able to authorize the Add initiated workflow when PUT API [../v1/corporate-onboard/workflows/{id}/tenants/{tenant}] is performed
    Given set API URI and headers <testcase>
    Given a PUT API endpoint for workflow mapping <testcase>
    And enters ADDAUTH in action and Bank Admin initiator authorizer in actionBy and fill valid details in other fields of request body
    And sends PUT request
    Then system receives 2xx HTTP success code
    And receives a valid application success response
    Examples:
      | testcase  |
      | DB-TC-232 |

  @19
  Scenario Outline: Verify that Bank Admin with a role (Initiator and Authorizer) is not able to authorize the Add initiated workflow when PUT API [../v1/corporate-onboard/workflows/{id}/tenants/{tenant}] is performed
    Given set API URI and headers <testcase>
    Given a PUT API endpoint for workflow mapping <testcase>
    And enters ADDAUTH in action and Bank Admin Initiator in actionBy and valid details in other fields of request body
    And sends PUT request
    Then receives 4xx HTTP error code
    And receives a valid application error response
    Examples:
      | testcase  |
      | DB-TC-233 |

  @20
  Scenario Outline: Verify that Super Admin is able to authorize the Add initiated workflow when PUT API [../v1/corporate-onboard/workflows/{id}/tenants/{tenant}] is performed
    Given set API URI and headers <testcase>
    Given a PUT API endpoint for workflow mapping <testcase>
    And enters ADDAUTH in action and super admin in actionBy and fill valid details in other fields of request body
    And sends PUT request
    Then system receives 2xx HTTP success code
    And receives a valid application success response
    Examples:
      | testcase  |
      | DB-TC-234 |

  @21
  Scenario Outline: Verify that Bank Admin Authorizer is able to reject the Add initiated workflow when PUT API [../v1/corporate-onboard/workflows/{id}/tenants/{tenant}] is performed
    Given set API URI and headers <testcase>
    Given a PUT API endpoint for workflow mapping <testcase>
    And enters ADDREJ in action and super admin in actionBy and fill valid details in other fields of request body
    And sends PUT request
    Then system receives 2xx HTTP success code
    And receives a valid application success response
    Examples:
      | testcase  |
      | DB-TC-246 |

  @22
  Scenario Outline: Verify that Bank Admin Initiator is not able to reject the Add initiated workflow when PUT API [../v1/corporate-onboard/workflows/{id}/tenants/{tenant}] is performed
    Given set API URI and headers <testcase>
    Given a PUT API endpoint for workflow mapping <testcase>
    And enters ADDREJ in action and Bank Admin Initiator in actionBy and fill valid details in other fields of request body
    And sends PUT request
    Then receives 4xx HTTP error code
    And receives a valid application error response
    Examples:
      | testcase  |
      | DB-TC-248 |

  @23
  Scenario Outline: Verify that Bank Admin with a role (Initiator and Authorizer) is able to reject the Add initiated workflow when PUT API [../v1/corporate-onboard/workflows/{id}/tenants/{tenant}] is performed
    Given set API URI and headers <testcase>
    Given a PUT API endpoint for workflow mapping <testcase>
    And enters ADDREJ in action and Bank Admin authorizer in actionBy and fill valid details in other fields of request body
    And sends PUT request
    Then system receives 2xx HTTP success code
    And receives a valid application success response
    Examples:
      | testcase  |
      | DB-TC-249 |

  @24
  #The Bank admin with a role (Initiator and Authorizer) will ADDINT (Initiate the addition of the workflow) and then the same user will also try to ADDREJ (Authorize the add initiated workflow) --> This user should not be able to reject the add initiated workflow
  Scenario Outline: Verify that Bank Admin with a role (Initiator and Authorizer) is not able to reject the Add initiated workflow when PUT API [../v1/corporate-onboard/workflows/{id}/tenants/{tenant}] is performed
    Given set API URI and headers <testcase>
    Given a PUT API endpoint for workflow mapping <testcase>
    And enters ADDREJ in action and Bank Admin initiator authorizer in actionBy and fill valid details in other fields of request body
    And sends PUT request
    Then receives 4xx HTTP error code
    And receives a valid application error response
    Examples:
      | testcase  |
      | DB-TC-250 |

  @25
  Scenario Outline: Verify that Bank Admin Initiator is able to Modify initiate the authorized workflow when PUT API [../v1/corporate-onboard/workflows/{id}/tenants/{tenant}] is performed
    Given set API URI and headers <testcase>
    Given a PUT API endpoint for workflow mapping <testcase>
    Then ADDAUTH authorize the record
    And enters MODINT in action and Bank Admin Initiator in actionBy and fill valid details in other fields of request body
    And sends PUT request
    Then system receives 2xx HTTP success code
    And receives a valid application success response
    Examples:
      | testcase  |
      | DB-TC-252 |

  @26
  Scenario Outline: Verify that Bank Admin Authorizer is not able to Modify initiate the authorized workflow when PUT API [../v1/corporate-onboard/workflows/{id}/tenants/{tenant}] is performed
    Given set API URI and headers <testcase>
    Given a PUT API endpoint for workflow mapping <testcase>
    Then ADDAUTH authorize the record
    And enters MODINT in action and Bank Admin Authorizer in actionBy and fill valid details in other fields of request body
    And sends PUT request
    Then receives 4xx HTTP error code
    And receives a valid application error response
    Examples:
      | testcase  |
      | DB-TC-254 |

  @27
  Scenario Outline: Verify that Bank Admin with a role (Initiator and Authorizer) is able to Modify initiate the authorized workflow when PUT API [../v1/corporate-onboard/workflows/{id}/tenants/{tenant}] is performed
    Given set API URI and headers <testcase>
    Given a PUT API endpoint for workflow mapping <testcase>
    Then ADDAUTH authorize the record
    And enters MODINT in action and Bank Admin Initiator Authorizer in actionBy and fill valid details in other fields of request body
    And sends PUT request
    Then system receives 2xx HTTP success code
    And receives a valid application success response
    Examples:
      | testcase  |
      | DB-TC-255 |

  @28
  Scenario Outline: Verify that Bank Admin with a role (Initiator and Authorizer) is able to Modify initiate the authorized workflow by same user when PUT API [../v1/corporate-onboard/workflows/{id}/tenants/{tenant}] is performed
    Given set API URI and headers <testcase>
    Given a PUT API endpoint for workflow mapping <testcase>
    Then ADDAUTH authorize the record
    And enters MODINT in action and Bank Admin Initiator Authorizer in actionBy and fill valid details in other fields of request body
    And sends PUT request
    Then system receives 2xx HTTP success code
    And receives a valid application success response
    Examples:
      | testcase  |
      | DB-TC-257 |

  @29
  Scenario Outline: Verify that Super Admin is able to Modify the authorized workflow when PUT API [../v1/corporate-onboard/workflows/{id}/tenants/{tenant}] is performed
    Given set API URI and headers <testcase>
    Given a PUT API endpoint for workflow mapping <testcase>
    Then ADDAUTH authorize the record
    And enters MODINT in action and Super Admin in actionBy and fill valid details in other fields of request body
    And sends PUT request
    Then system receives 2xx HTTP success code
    And receives a valid application success response
    Examples:
      | testcase  |
      | DB-TC-258 |

  @30
  Scenario Outline: Verify that Bank Admin Authorizer is able to authorize the Modify initiated workflow when PUT API [../v1/corporate-onboard/workflows/{id}/tenants/{tenant}] is performed
    Given set API URI and headers <testcase>
    Given a PUT API endpoint for workflow mapping <testcase>
    Then ADDAUTH and MODINT the record
    And enters MODAUT in action and Bank Admin Authorizer in actionBy and fill valid details in other fields of request body
    And sends PUT request
    Then system receives 2xx HTTP success code
    And receives a valid application success response
    Examples:
      | testcase  |
      | DB-TC-259 |

  @31
  Scenario Outline: Verify that Bank Admin Initiator is not able to authorize the Modify initiated workflow when PUT API [../v1/corporate-onboard/workflows/{id}/tenants/{tenant}] is performed
    Given set API URI and headers <testcase>
    Given a PUT API endpoint for workflow mapping <testcase>
    Then ADDAUTH and MODINT the record
    And enters MODAUT in action and Bank Admin Initiator in actionBy and fill valid details in other fields of request body
    And sends PUT request
    Then receives 4xx HTTP error code
    And receives a valid application error response
    Examples:
      | testcase  |
      | DB-TC-260 |

  @32
  Scenario Outline: Verify that Bank Admin with a role (Initiator and Authorizer) is able to authorize the Modify initiated workflow when PUT API [../v1/corporate-onboard/workflows/{id}/tenants/{tenant}] is performed
    Given set API URI and headers <testcase>
    Given a PUT API endpoint for workflow mapping <testcase>
    Then ADDAUTH and MODINT the record
    And enters MODAUT in action and Bank Admin authorizer Initiator in actionBy and fill valid details in other fields of request body
    And sends PUT request
    Then system receives 2xx HTTP success code
    And receives a valid application success response
    Examples:
      | testcase  |
      | DB-TC-261 |

  @33
    #The Bank admin with a role (Initiator and Authorizer) will MODINT (Initiate the modification of the workflow) and then the same user will also try to MODAUT (Authorize the modify initiated workflow) --> This user should not be able to authorize the modify initiated workflow
  Scenario Outline: Verify that Bank Admin with a role (Initiator and Authorizer) is not able to authorize the Modify initiated workflow when PUT API [../v1/corporate-onboard/workflows/{id}/tenants/{tenant}] is performed
    Given set API URI and headers <testcase>
    Given a PUT API endpoint for workflow mapping <testcase>
    Then ADDAUTH and MODINT the record
    And enters MODAUT in action and Bank Admin authorizer Initiator in actionBy and fill valid details in other fields of request body
    And sends PUT request
    Then receives 4xx HTTP error code
    And receives a valid application error response
    Examples:
      | testcase  |
      | DB-TC-262 |


    #check---
  @34
  Scenario Outline: Verify that Super Admin is able to authorize the Modify initiated workflow when PUT API [../v1/corporate-onboard/workflows/{id}/tenants/{tenant}] is performed
    Given set API URI and headers <testcase>
    Given a PUT API endpoint for workflow mapping <testcase>
    Then ADDAUTH and MODINT the record
    And enters MODAUT in action and super admin in actionBy and fill valid details in other fields of request body
    And sends PUT request
    Then system receives 2xx HTTP success code
    And receives a valid application success response
    Examples:
      | testcase  |
      | DB-TC-263 |

  @35
  Scenario Outline: Verify that Bank Admin Authorizer is able to reject the Modify initiated workflow when PUT API [../v1/corporate-onboard/workflows/{id}/tenants/{tenant}] is performed
    Given set API URI and headers <testcase>
    Given a PUT API endpoint for workflow mapping <testcase>
    Then ADDAUTH and MODINT the record
    And enters MODREJ in action and Bank Admin Authorizer in actionBy and fill valid details in other fields of request body
    And sends PUT request
    Then system receives 2xx HTTP success code
    And receives a valid application success response
    Examples:
      | testcase  |
      | DB-TC-266 |

  @36
  Scenario Outline: Verify that Bank Admin Initiator is not able to reject the Modify initiated workflow when PUT API [../v1/corporate-onboard/workflows/{id}/tenants/{tenant}] is performed
    Given set API URI and headers <testcase>
    Given a PUT API endpoint for workflow mapping <testcase>
    Then ADDAUTH and MODINT the record
    And enters MODREJ in action and Bank Admin Initiator in actionBy and fill valid details in other fields of request body
    And sends PUT request
    Then system receives 2xx HTTP success code
    And receives a valid application success response
    Examples:
      | testcase  |
      | DB-TC-267 |

  @37
  Scenario Outline: Verify that Bank Admin with a role (Initiator and Authorizer) is able to reject the Modify initiated workflow when PUT API [../v1/corporate-onboard/workflows/{id}/tenants/{tenant}] is performed
    Given set API URI and headers <testcase>
    Given a PUT API endpoint for workflow mapping <testcase>
    Then ADDAUTH and MODINT the record
    And enters MODREJ in action and Bank Admin Initiator Authorizer in actionBy and fill valid details in other fields of request body
    And sends PUT request
    Then system receives 2xx HTTP success code
    And receives a valid application success response
    Examples:
      | testcase  |
      | DB-TC-268 |

  @38
  Scenario Outline: Verify that Bank Admin with a role (Initiator and Authorizer) is not able to reject the Modify initiated workflow when PUT API [../v1/corporate-onboard/workflows/{id}/tenants/{tenant}] is performed
    Given set API URI and headers <testcase>
    Given a PUT API endpoint for workflow mapping <testcase>
    Then ADDAUTH and MODINT the record
    And enters MODREJ in action and Bank Admin Initiator Authorizer in actionBy and fill valid details in other fields of request body
    And sends PUT request
    Then receives 4xx HTTP error code
    And receives a valid application error response
    Examples:
      | testcase  |
      | DB-TC-269 |

  @39
  Scenario Outline: Verify that Super Admin is able to reject the Modify initiated workflow when PUT API [../v1/corporate-onboard/workflows/{id}/tenants/{tenant}] is performed
    Given set API URI and headers <testcase>
    Given a PUT API endpoint for workflow mapping <testcase>
    Then ADDAUTH and MODINT the record
    And enters MODREJ in action and super admin in actionBy and fill valid details in other fields of request body
    And sends PUT request
    Then system receives 2xx HTTP success code
    And receives a valid application success response
    Examples:
      | testcase  |
      | DB-TC-270 |

  @40
  Scenario Outline: Verify that Bank Admin Initiator is able to Delete initiate the authorized workflow when PUT API [../v1/corporate-onboard/workflows/{id}/tenants/{tenant}] is performed
    Given set API URI and headers <testcase>
    Given a PUT API endpoint for workflow mapping <testcase>
    Then ADDAUTH authorize the record
    And enters DELINT in action and Bank Admin Initiator in actionBy and fill valid details in other fields of request body
    And sends PUT request
    Then system receives 2xx HTTP success code
    And receives a valid application success response
    Examples:
      | testcase  |
      | DB-TC-275 |

  @41
  Scenario Outline: Verify that Bank Admin Authorizer is not able to Delete Initiate for the authorized workflow when PUT API [../v1/corporate-onboard/workflows/{id}/tenants/{tenant}] is performed
    Given set API URI and headers <testcase>
    Given a PUT API endpoint for workflow mapping <testcase>
    Then ADDAUTH authorize the record
    And enters DELINT in action and Bank Admin Authorizer in actionBy and fill valid details in other fields of request body
    And sends PUT request
    Then receives 4xx HTTP error code
    And receives a valid application error response
    Examples:
      | testcase  |
      | DB-TC-276 |

  @42
  Scenario Outline: Verify that Bank Admin with a role (Initiator and Authorizer) is able to Delete initiate for the authorized workflow when PUT API [../v1/corporate-onboard/workflows/{id}/tenants/{tenant}] is performed
    Given set API URI and headers <testcase>
    Given a PUT API endpoint for workflow mapping <testcase>
    Then ADDAUTH authorize the record
    And enters DELINT in action and Bank Admin initiator Authorizer in actionBy and fill valid details in other fields of request body
    And sends PUT request
    Then system receives 2xx HTTP success code
    And receives a valid application success response
    Examples:
      | testcase  |
      | DB-TC-277 |

  @43
  Scenario Outline: Verify that Bank Admin with a role (I&A) is able to Delete initiate for the workflow which added by Bank Admin with a role (I&A) when PUT API [../v1/corporate-onboard/workflows/{id}/tenants/{tenant}] is performed
    Given set API URI and headers <testcase>
    Given a PUT API endpoint for workflow mapping <testcase>
    Then ADDAUTH authorize the record
    And enters DELINT in action and Bank Admin initiator Authorizer in actionBy and fill valid details in other fields of request body
    And sends PUT request
    Then system receives 2xx HTTP success code
    And receives a valid application success response
    Examples:
      | testcase  |
      | DB-TC-278 |

  @44
  Scenario Outline: Verify that Super Admin is able to Delete the authorized workflow when PUT API [../v1/corporate-onboard/workflows/{id}/tenants/{tenant}] is performed
    Given set API URI and headers <testcase>
    Given a PUT API endpoint for workflow mapping <testcase>
    Then ADDAUTH authorize the record
    And enters DELINT in action and super admin in actionBy and fill valid details in other fields of request body
    And sends PUT request
    Then system receives 2xx HTTP success code
    And receives a valid application success response
    Examples:
      | testcase  |
      | DB-TC-279 |

  @45
  Scenario Outline: Verify that Bank Admin Authorizer is able to reject the Delete initiated workflow when PUT API [../v1/corporate-onboard/workflows/{id}/tenants/{tenant}] is performed
    Given set API URI and headers <testcase>
    Given a PUT API endpoint for workflow mapping <testcase>
    Then ADDAUTH and DELINT the record
    And enters DELREJ in action and Bank Admin Authorizer in actionBy and fill valid details in other fields of request body
    And sends PUT request
    Then system receives 2xx HTTP success code
    And receives a valid application success response
    Examples:
      | testcase  |
      | DB-TC-280 |

  @46
  Scenario Outline: Verify that Bank Admin Initiator is not able to reject the Delete initiated workflow when PUT API [../v1/corporate-onboard/workflows/{id}/tenants/{tenant}] is performed
    Given set API URI and headers <testcase>
    Given a PUT API endpoint for workflow mapping <testcase>
    Then ADDAUTH and DELINT the record
    And enters DELREJ in action and Bank Admin Initiator in actionBy and fill valid details in other fields of request body
    And sends PUT request
    Then receives 4xx HTTP error code
    And receives a valid application error response
    Examples:
      | testcase  |
      | DB-TC-281 |

  @47
  Scenario Outline: Verify that Bank Admin with a role (Initiator and Authorizer) is able to reject the Delete initiated workflow when PUT API [../v1/corporate-onboard/workflows/{id}/tenants/{tenant}] is performed
    Given set API URI and headers <testcase>
    Given a PUT API endpoint for workflow mapping <testcase>
    Then ADDAUTH and DELINT the record
    And enters DELREJ in action and Bank Admin Initiator authorizer in actionBy and fill valid details in other fields of request body
    And sends PUT request
    Then system receives 2xx HTTP success code
    And receives a valid application success response
    Examples:
      | testcase  |
      | DB-TC-282 |

  @48
     #The Bank admin with a role (Initiator and Authorizer) will DELINT (Initiate the deletion of the workflow) and then the same user will also try to DELREJ (Authorize the delete initiated workflow) --> This user should not be able to Reject the modify initiated workflow
  Scenario Outline: Verify that Bank Admin with a role (Initiator and Authorizer) is not able to reject the Delete initiated workflow when PUT API [../v1/corporate-onboard/workflows/{id}/tenants/{tenant}] is performed
    Given set API URI and headers <testcase>
    Given a PUT API endpoint for workflow mapping <testcase>
    Then ADDAUTH and DELINT the record
    And enters DELREJ in action and Bank Admin Initiator authorizer in actionBy and fill valid details in other fields of request body
    And sends PUT request
    Then system receives 4xx HTTP error code
    And receives a valid application error response
    Examples:
      | testcase  |
      | DB-TC-283 |

  @49
  Scenario Outline: Verify that Super Admin is able to reject the Delete initiated workflow when PUT API [../v1/corporate-onboard/workflows/{id}/tenants/{tenant}] is performed
    Given set API URI and headers <testcase>
    Given a PUT API endpoint for workflow mapping <testcase>
    Then ADDAUTH and DELINT the record
    And enters DELREJ in action and Super Admin in actionBy and fill valid details in other fields of request body
    And sends PUT request
    Then system receives 2xx HTTP success code
    And receives a valid application success response
    Examples:
      | testcase  |
      | DB-TC-284 |

#able  update without desc
  @50
  Scenario Outline: Verify the "description" field is mandatory in request body of PUT API - /v1/corporate-onboard/workflows/{id}/tenants/{tenant}
    Given set API URI and headers <testcase>
    Given a PUT API endpoint for workflow mapping <testcase>
    And enters invalid description in request body _PUT
    And sends PUT request
    Then receives 4xx HTTP error code
    And receives a valid application error response
    Examples:
      | testcase  |
      | DB-TC-285 |

    #able  update invalid workflow
  @51
  Scenario Outline: Verify the "workflowKey" field is mandatory in request body of PUT API - /v1/corporate-onboard/workflows/{id}/tenants/{tenant}
    Given set API URI and headers <testcase>
    Given a PUT API endpoint for workflow mapping <testcase>
    And enters invalid workflowKey in request body _PUT
    And sends PUT request
    Then  receives 4xx HTTP error code
    And receives a valid application error response
    Examples:
      | testcase  |
      | DB-TC-286 |

  @52
  Scenario Outline: Verify the "action" field is mandatory in request body of PUT API - /v1/corporate-onboard/workflows/{id}/tenants/{tenant}
    Given set API URI and headers <testcase>
    Given a PUT API endpoint for workflow mapping <testcase>
    And enters invalid action in request body _PUT
    And sends PUT request
    Then receives 4xx HTTP error code
    And receives a valid application error response
    Examples:
      | testcase  |
      | DB-TC-287 |

  @53
  Scenario Outline: Verify the "actionBy" field is mandatory in request body of PUT API - /v1/corporate-onboard/workflows/{id}/tenants/{tenant}
    Given set API URI and headers <testcase>
    Given a PUT API endpoint for workflow mapping <testcase>
    And enters invalid actionBy in request body _PUT
    And sends PUT request
    Then receives 4xx HTTP error code
    And receives a valid application error response
    Examples:
      | testcase  |
      | DB-TC-288 |

  @54
  Scenario Outline: Verify the "version" field is mandatory in request body of PUT API - /v1/corporate-onboard/workflows/{id}/tenants/{tenant}
    Given set API URI and headers <testcase>
    Given a PUT API endpoint for workflow mapping <testcase>
    And enters invalid version in request body _PUT
    And sends PUT request
    Then  receives 4xx HTTP error code
    And receives a valid application error response
    Examples:
      | testcase  |
      | DB-TC-289 |

  @55
  Scenario Outline: Verify the "remarks" field is mandatory in request body of PUT API - /v1/corporate-onboard/workflows/{id}/tenants/{tenant}
    Given set API URI and headers <testcase>
    Given a PUT API endpoint for workflow mapping <testcase>
    And enters invalid remarks in request body _PUT
    And sends PUT request
    Then receives 4xx HTTP error code
    And receives a valid application error response
    Examples:
      | testcase  |
      | DB-TC-290 |

  @56
  Scenario Outline: Verify the bank admin initiator cannot do an action of authorize deletion of the workflow when DELETE API [../v1/corporate-onboard/workflow/auth] is performed
    Given set API URI and headers <testcase>
    Given a DELETE API endpoint for workflow mapping <testcase>
    And enters Bank Admin Initiator in actionBy and valid details in other headers
    And sends DELETE request
    Then Delete receives 4xx HTTP error code
    And receives a valid application error response
    Examples:
      | testcase  |
      | DB-TC-222 |

  @57
  Scenario Outline: Verify the Bank Admin Authorizer which does belong to the tenant can authorize deletion of the workflow when DELETE API [../v1/corporate-onboard/workflow/auth] is performed
    Given set API URI and headers <testcase>
    Given a DELETE API endpoint for workflow mapping <testcase>
    And enters Bank Admin authorizer unfit with the entered tenant in actionBy and valid details in other headers
    And sends DELETE request
    Then Delete receives 4xx HTTP error code
    And receives a valid application error response
    Examples:
      | testcase  |
      | DB-TC-225 |

  @58
  Scenario Outline: Verify whether the bank admin authorizer cannot do an action of authorize deletion for a modify initiated workflow with DELETE API [../v1/corporate-onboard/workflow/auth] is performed
    Given set API URI and headers <testcase>
    Given a DELETE API endpoint for workflow mapping <testcase>
    And enters modify initiated workflow in id and valid details in other headers
    And sends DELETE request
    Then Delete receives 4xx HTTP error code
    And receives a valid application error response
    Examples:
      | testcase  |
      | DB-TC-226 |

  @59
  Scenario Outline: Verify whether the bank admin authorizer can do an action of authorize deletion for an delete initiated workflow with DELETE API [../v1/corporate-onboard/workflow/auth] is performed
    Given set API URI and headers <testcase>
    Given a DELETE API endpoint for workflow mapping <testcase>
    And enters valid details in all headers _DELETE
    And sends DELETE request
    Then system receives 2xx HTTP success code _DELETE
    And receives a valid application success response
    Examples:
      | testcase  |
      | DB-TC-228 |

  @60
  Scenario Outline: Verify whether the super admin can do an action of authorize deletion for an delete initiated workflow with DELETE API [../v1/corporate-onboard/workflow/auth] is performed
    Given set API URI and headers <testcase>
    Given a DELETE API endpoint for workflow mapping <testcase>
    And enters valid details in all headers _DELETE
    And sends DELETE request
    Then system receives 2xx HTTP success code _DELETE
    And receives a valid application success response
    Examples:
      | testcase  |
      | DB-TC-230 |

  @61
  Scenario Outline: Verify whether the bank admin initiator authorizer can do an action of authorize deletion for an delete initiated workflow with DELETE API [../v1/corporate-onboard/workflow/auth] is performed
    Given set API URI and headers <testcase>
    Given a DELETE API endpoint for workflow mapping <testcase>
    And enters valid details in all headers _DELETE
    And sends DELETE request
    Then system receives 2xx HTTP success code _DELETE
    And receives a valid application success response
    Examples:
      | testcase  |
      | DB-TC-247 |

  @62
    #The Bank admin with a role (Initiator and Authorizer) will DELINT (Initiate the addition of the workflow) and then the same user will also try to DELAUT (Authorize the add initiated workflow) --> This user should not be able to authorize the delete initiated workflow
  Scenario Outline: Scenario Outline: Verify whether the bank admin initiator authorizer can do an action of authorize deletion for an delete initiated workflow from the same user with DELETE API [../v1/corporate-onboard/workflow/auth] is performed
    Given set API URI and headers <testcase>
    Given a DELETE API endpoint for workflow mapping <testcase>
    And enters valid details in all headers _DELETE
    And sends DELETE request
    Then Delete receives 4xx HTTP error code
    And receives a valid application error response
    Examples:
      | testcase  |
      | DB-TC-220 |

  @63
  Scenario Outline: Verify whether the bank admin initiator authorizer cannot do an action of authorize deletion for an add initiated workflow with DELETE API [../v1/corporate-onboard/workflow/auth] is performed
    Given set API URI and headers <testcase>
    Given a DELETE API endpoint for Intiate workflow mapping <testcase>
    And enters add initiated workflow in id and valid details in other headers
    And sends DELETE request
    Then Delete receives 4xx HTTP error code
    And receives a valid application error response
    Examples:
      | testcase  |
      | DB-TC-264 |

  @64
  Scenario Outline: Verify whether the bank admin initiator authorizer cannot do an action of authorize deletion for a modify initiated workflow with DELETE API [../v1/corporate-onboard/workflow/auth] is performed
    Given set API URI and headers <testcase>
    Given a DELETE API endpoint for workflow mapping <testcase>
    And enters modify initiated workflow in id and valid details in other headers
    And sends DELETE request
    Then Delete receives 4xx HTTP error code
    And receives a valid application error response
    Examples:
      | testcase  |
      | DB-TC-265 |

  @65
  Scenario Outline: Verify whether the super admin cannot do an action of authorize deletion for an add initiated workflow with DELETE API [../v1/corporate-onboard/workflow/auth] is performed
    Given set API URI and headers <testcase>
    Given a DELETE API endpoint for workflow mapping <testcase>
    And enters add initiated workflow in id and valid details in other headers
    And sends DELETE request
    Then Delete receives 4xx HTTP error code
    And receives a valid application error response
    Examples:
      | testcase  |
      | DB-TC-270 |

  @66
  Scenario Outline: Verify whether the super admin cannot do an action of authorize deletion for an modify initiated workflow with DELETE API [../v1/corporate-onboard/workflow/auth] is performed
    Given set API URI and headers <testcase>
    Given a DELETE API endpoint for workflow mapping <testcase>
    And enters modify initiated workflow in id and valid details in other headers
    And sends DELETE request
    Then Delete receives 4xx HTTP error code
    And receives a valid application error response
    Examples:
      | testcase  |
      | DB-TC-272 |


  @67
  Scenario Outline: Verify the bank admin can Fetch workflows based on the filter prodDesc in Parameters of a tenant, when GET API [../v1/corporate-onboard/workflows] is performed
    Given set API URI and headers <testcase>
    Given a GET API endpoint for workflow mapping <testcase>
    Given a GET API endpoint sets header params and invalid data in prodDesc for workflow mapping <testcase>
    Then system receives 4xx HTTP error code
    And receives a valid application error response
    When user sets the header params and valid data in prodDesc _GET <testcase>
    Then system receives 2xx HTTP success code
    And receives a valid workflow keys as response
    Examples:
      | testcase  |
      | DB-TC-235 |

  @68
  Scenario Outline: Verify the bank admin can Fetch workflows based on the filter status in Parameters of a tenant, when GET API [../v1/corporate-onboard/workflows] is performed
    Given set API URI and headers <testcase>
    Given a GET API endpoint for workflow mapping <testcase>
    When user sets the header params and invalid data in status <testcase>
    Then system receives 4xx HTTP error code
    And receives a valid application error response
    When user sets the header params and valid data in status<testcase>
    Then system receives 2xx HTTP success code
    And receives a valid workflow keys as response
    Examples:
      | testcase  |
      | DB-TC-236 |

  @69
  Scenario Outline: Verify the bank admin can Fetch workflows based on the filter code in Parameters of a tenant, when GET API [../v1/corporate-onboard/workflows] is performed
    Given set API URI and headers <testcase>
    Given a GET API endpoint for workflow mapping <testcase>
    When user sets the header params and invalid data in code <testcase>
    Then system receives 4xx HTTP error code
    And receives a valid application error response
    When user sets the header params and valid data in code <testcase>
    And user sends the GET request
    Then system receives 2xx HTTP success code
    And receives a valid workflow keys as response
    Examples:
      | testcase  |
      | DB-TC-237 |

    #doubts
  @70
  Scenario Outline: Verify the bank admin can Fetch workflows based on the filter initFromDt in Parameters of a tenant, when GET API [../v1/corporate-onboard/workflows] is performed
    Given set API URI and headers <testcase>
    Given a GET API endpoint for workflow mapping <testcase>
    When user sets the header params and invalid data in initFromDt<testcase>
    Then system receives 4xx HTTP error code
    And receives a valid application error response
    When user sets the header params and valid data in initFromDt<testcase>
    And user sends the GET request
    Then system receives 2xx HTTP success code
    And receives a valid workflow keys as response
    Examples:
      | testcase  |
      | DB-TC-238 |

  @71
  Scenario Outline: Verify the bank admin can Fetch workflows based on the filter initToDt in Parameters of a tenant, when GET API [../v1/corporate-onboard/workflows] is performed
    Given set API URI and headers <testcase>
    Given a GET API endpoint for workflow mapping <testcase>
    When user sets the header params and invalid data in initToDt<testcase>
    Then system receives 4xx HTTP error code
    And receives a valid application error response
    When user sets the header params and valid data in initToDt<testcase>
    Then system receives 2xx HTTP success code
    And receives a valid workflow keys as response
    Examples:
      | testcase  |
      | DB-TC-239 |

  @72
  Scenario Outline: Verify the bank admin can Fetch workflows based on the filter initFromDt and initToDt in Parameters of a tenant, when GET API [../v1/corporate-onboard/workflows] is performed
    Given set API URI and headers <testcase>
    Given a GET API endpoint for workflow mapping <testcase>
    When user sets the header params and invalid data initFromDt and initToDt <testcase>
    Then system receives 4xx HTTP error code
    And receives a valid application error response
    When user sets the header params and valid data initFromDt and initToDt <testcase>
    Then system receives 2xx HTTP success code
    And receives a valid workflow keys as response
    Examples:
      | testcase  |
      | DB-TC-240 |


  @73
  Scenario Outline: Verify the bank admin can Fetch workflows based on the filter authFromDt in Parameters of a tenant, when GET API [../v1/corporate-onboard/workflows] is performed
    Given set API URI and headers <testcase>
    Given a GET API endpoint for workflow mapping <testcase>
    When user sets the header params and invalid data in authFromDt <testcase>
    Then system receives 4xx HTTP error code
    And receives a valid application error response
    When user sets the header params and valid data in authFromDt <testcase>
    Then system receives 2xx HTTP success code
    And receives a valid workflow keys as response
    Examples:
      | testcase  |
      | DB-TC-241 |


  @74
  Scenario Outline: Verify the bank admin can Fetch workflows based on the filter authToDt in Parameters of a tenant, when GET API [../v1/corporate-onboard/workflows] is performed
    Given set API URI and headers <testcase>
    Given a GET API endpoint for workflow mapping <testcase>
    When user sets the header params and invalid data in authToDt <testcase>
    Then system receives 4xx HTTP error code
    And receives a valid application error response
    When user sets the header params and valid data in authToDt <testcase>
    Then system receives 2xx HTTP success code
    And receives a valid workflow keys as response
    Examples:
      | testcase  |
      | DB-TC-242 |

  @75
  Scenario Outline: Verify the bank admin can Fetch workflows based on the filter authFromDt and authToDt in Parameters of a tenant, when GET API [../v1/corporate-onboard/workflows] is performed
    Given set API URI and headers <testcase>
    Given a GET API endpoint for workflow mapping <testcase>
    When user sets the header params and invalid data in authToDt,authFromDate <testcase>
    Then system receives 4xx HTTP error code
    And receives a valid application error response
    When user sets the header params and valid data in authToDt,authFromDate <testcase>
    Then system receives 2xx HTTP success code
    And receives a valid workflow keys as response
    Examples:
      | testcase  |
      | DB-TC-243 |

  @76
  Scenario Outline: Verify the bank admin can Fetch workflows based on the filter when given multiple search criteria for workflow of a tenant GET API [../v1/corporate-onboard/workflows] is performed
    Given set API URI and headers <testcase>
    Given a GET API endpoint for workflow mapping <testcase>
    When user sets invalid params in the header
    Then system receives 4xx HTTP error code
    And receives a valid application error response
    When user sets valid params in the header<testcase>
    Then system receives 2xx HTTP success code
    And receives a valid workflow keys as response
    Examples:
      | testcase  |
      | DB-TC-245 |


  Scenario Outline: Verify that Bank Admin Authorizer is able to authorize the Add initiated workflow when PUT API [../v1/corporate-onboard/workflows/{id}/tenants/{tenant}] is performed
    Given set API URI and headers <testcase>
    Given a PUT API endpoint for workflow mapping <testcase>
    And enters ADDAUTH in action and Bank Admin authorizer in actionBy and fill valid details in other fields of request body
    And sends PUT request
    Then system receives 2xx HTTP success code
    And receives a valid application success response
    Examples:
      | testcase  |
      | DB-TC-224 |


  @77
  Scenario Outline: Verify whether the users cannot do an invalid action for the record having ADDINT as status using PUT API - /v1/corporate-onboard/workflows/{id}/tenants/{tenant}
    Given set API URI and headers <testcase>
    Given a PUT API endpoint for workflow mapping <testcase>
    When user sets the header params with record having ADDINT as status
    And enters MODINT in action in of request body and sends PUT request
    And enters MODAUT in action in of request body and sends PUT request
    And enters MODREJ in action in of request body and sends PUT request
    And enters DELINT in action in of request body and sends PUT request
    And enters DELREJ in action in of request body and sends PUT request
    Then receives 4xx HTTP error code
    And receives a valid application error response
    Examples:
      | testcase  |
      | DB-TC-733 |

  @78
  Scenario Outline: Verify whether the users cannot do an invalid action for the record having ADDAUT as status using PUT API - /v1/corporate-onboard/workflows/{id}/tenants/{tenant}
    Given set API URI and headers <testcase>
    Given a PUT API endpoint for workflow mapping <testcase>
    When user sets the header params with record having ADDAUT as status
    And enters ADDAUT in action in of request body and sends PUT request
    And enters ADDREJ in action in of request body and sends PUT request
    And enters MODAUT in action in of request body and sends PUT request
    And enters MODREJ in action in of request body and sends PUT request
    And enters DELREJ in action in of request body and sends PUT request
    Then receives 4xx HTTP error code
    And receives a valid application error response
    Examples:
      | testcase  |
      | DB-TC-734 |


  @79
  Scenario Outline: Verify whether the users cannot do an invalid action for the record having MODINT as status using PUT API - /v1/corporate-onboard/workflows/{id}/tenants/{tenant}
    Given set API URI and headers <testcase>
    Given a PUT API endpoint for workflow mapping <testcase>
    When user sets the header params with record having MODINT as status
    And enters ADDAUT in action in of request body and sends PUT request
    And enters ADDREJ in action in of request body and sends PUT request
    And enters DELINT in action in of request body and sends PUT request
    And enters DELREJ in action in of request body and sends PUT request
    Then receives 4xx HTTP error code
    And receives a valid application error response
    Examples:
      | testcase  |
      | DB-TC-735 |

  @80
  Scenario Outline: Verify whether the users cannot do an invalid action for the record having MODAUT as status using PUT API - /v1/corporate-onboard/workflows/{id}/tenants/{tenant}
    Given set API URI and headers <testcase>
    Given a PUT API endpoint for workflow mapping <testcase>
    When user sets the header params with record having MODAUT as status
    And enters ADDAUT in action in of request body and sends PUT request
    And enters ADDREJ in action in of request body and sends PUT request
    And enters MODAUT in action in of request body and sends PUT request
    And enters MODREJ in action in of request body and sends PUT request
    And enters DELREJ in action in of request body and sends PUT request
    Then receives 4xx HTTP error code
    And receives a valid application error response
    Examples:
      | testcase  |
      | DB-TC-736 |

  @81
  Scenario Outline: Verify whether the users cannot do an invalid action for the record having DELINT as status using PUT API - /v1/corporate-onboard/workflows/{id}/tenants/{tenant}
    Given set API URI and headers <testcase>
    Given a PUT API endpoint for workflow mapping <testcase>
    When user sets the header params with record having DELINT as status
    And enters ADDAUT in action in of request body and sends PUT request
    And enters ADDREJ in action in of request body and sends PUT request
    And enters MODINT in action in of request body and sends PUT request
    And enters MODAUT in action in of request body and sends PUT request
    And enters MODREJ in action in of request body and sends PUT request
    Then receives 4xx HTTP error code
    And receives a valid application error response
    Examples:
      | testcase  |
      | DB-TC-737 |

  @82
  Scenario Outline: Verify whether the users cannot do an invalid action for the record having DELREJ as status using PUT API - /v1/corporate-onboard/workflows/{id}/tenants/{tenant}
    Given set API URI and headers <testcase>
    Given a PUT API endpoint for workflow mapping <testcase>
    When user sets the header params with record having DELREJ as status
    And enters ADDAUT in action in of request body and sends PUT request
    And enters ADDREJ in action in of request body and sends PUT request
    And enters MODAUT in action in of request body and sends PUT request
    And enters MODREJ in action in of request body and sends PUT request
    And enters DELREJ in action in of request body and sends PUT request
    Then receives 4xx HTTP error code
    And receives a valid application error response
    Examples:
      | testcase  |
      | DB-TC-738 |

  @83
  Scenario Outline: Verify whether the users cannot do action : DELAUT for the record which not having DELINT as status using DELETE API [../v1/corporate-onboard/workflow/auth] is performed
    Given set API URI and headers <testcase>
    When user sets the header params with record having ADDINT as status and sends DELETE request<testcase>
    And sets the header params with record having ADDAUT as status and sends DELETE request<testcase>
    And sets the header params with record having ADDREJ as status and sends DELETE request<testcase>
    And sets the header params with record having MODINT as status and sends DELETE request<testcase>
    And sets the header params with record having MODAUT as status and sends DELETE request<testcase>
    And sets the header params with record having MODREJ as status and sends DELETE request<testcase>
    And sets the header params with record having DELAUT as status and sends DELETE request<testcase>
    And sets the header params with record having DELREJ as status and sends DELETE request<testcase>
    Then receives 4xx HTTP error code
    And receives a valid application error response
    Examples:
      | testcase  |
      | DB-TC-739 |

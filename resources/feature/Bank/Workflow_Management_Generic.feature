Feature: Workflow management generic features

  Background: 2FA_REQUIRED is true in the system
    Given a valid bank application
    When super admin logs into the application with valid email ID and password <testcase>
    Then lands on the Dashboard page
    When clicks on workflow management from LHS Menu
    Then lands on workflow management summary screen


  Scenario Outline: Verify that the super admin is able to search the available workflow mapping only by providing Corporate Type as the search criteria
    When super admin selects a Corporate Type and clicks on Search button<testcase>
    Then system should list down the available corporate type details
    But system should display No records found message if corporate types are not added to the system
    When clicks on the Corporate Type hyperlink from the Search result section
    Then super admin lands on the Workflow mapping details page of the particular corporate type
    Examples:
      | testcase |
      | DB-TC-61 |

  Scenario Outline: Verify that 'Tenant' is a mandatory field and pre-defined values should populate while workflow mapping
    When admin clicks on add button<testcase>
    Then system lands on Workflow Management add initiate screen
    When clicks on the Tenant pre populated values should be displayed
    Then admin clicks a tenant and it should be displayed in the Tenant field
    But Tenant should be highlighted in red colour if nothing is selected on click of save button
    Examples:
      | testcase |
      | DB-TC-120 |

  Scenario Outline: Verify the fields available while workflow mapping by bank admin
    When admin clicks on add button<testcase>
    Then system lands on Workflow Management add initiate screen
    When enters valid data in mandatory and optional fields and click save button
    Then lands on verification page with given data
    Examples:
      | testcase |
      | DB-TC-119 |

  Scenario Outline: Verify that 'Corporate Type' is a mandatory field and pre-defined values should populate while workflow mapping
    When admin clicks on add button<testcase>
    Then system lands on Workflow Management add initiate screen
    When clicks on the Corporate Type pre populated values should be displayed
    Then admin clicks a Corporate Type and it should be displayed in the Tenant field
    But Corporate Type field should be highlighted in red colour if nothing is selected on click of save button
    Examples:
      | testcase |
      | DB-TC-121 |

  Scenario Outline: Verify that 'Description' is a mandatory field and accepts only alphabets with spaces up to 50 characters and no special characters allowed while workflow mapping
    When admin clicks on add button<testcase>
    Then system lands on Workflow Management add initiate screen
    When  enters no data in Description field <testcase> and clicks save button
    Then system should highlight the Description field in red color
    And system should not allow to enter special characters in Description field <testcase>
    And system should not allow to enter numbers in Description field <testcase>
    Examples:
      | testcase |
      | DB-TC-122 |

  Scenario Outline: Verify that 'Workflow' is a mandatory field and pre-defined values should populate while workflow mapping
    When admin clicks on add button<testcase>
    Then system lands on Workflow Management add initiate screen
    When clicks on the Workflow pre populated values should be displayed
    Then admin clicks a Corporate Type and it should be displayed in the Workflow field
    But Workflow field should be highlighted in red colour if nothing is selected on click of save button
    Examples:
      | testcase |
      | DB-TC-123 |

  Scenario Outline: Verify the functionality of the Cancel button while workflow mapping
    When admin clicks on add button<testcase>
    Then system lands on Workflow Management add initiate screen
    When enters valid data in mandatory fields and clicks on save button
    Then admin lands on confirmation screen
    When clicks cancel button
    Then lands on add initiate screen with given values
    When clicks cancel button
    Then lands on workflow management summary screen
    When clicks clicks add button no data should be displayed
    Examples:
      | testcase |
      | DB-TC-124 |
      | DB-TC-118 |

  Scenario Outline: Verify that the super admin is able to search the available workflow mapping only by providing partial data in Description as the search criteria
    When Enter partial data in the Description and clicks Search button<testcase>
    Then system should list down the available corporate type details based on the selected data
    But system should display No records found message if no corporate types matches selection
    Examples:
      | testcase |
      | DB-TC-182 |

  Scenario Outline: Verify that the super admin is able to search the available workflow mapping only by selecting Status as Add Initiated in the search criteria
    When selects Add Initiated in Status field and click on Search button<testcase>
    Then system should list down the available corporate type details based on the selected data
    But system should display a No records found message if no corporate types matches selection
    Examples:
      | testcase |
      | DB-TC-183 |

  Scenario Outline: Verify that the super admin is able to search the available workflow mapping only by selecting Status as Modify Initiated in the search criteria
    When selects Modify Initiated in Status field and click on Search button<testcase>
    Then system should list down the available corporate type details based on the selected data
    But system should display a No records found message if no corporate types matches selection
    Examples:
      | testcase |
      | DB-TC-184 |

  Scenario Outline: Verify that the super admin is able to search the available workflow mapping only by selecting Status as Delete Initiated in the search criteria
    When selects Delete Initiated in Status field and click on Search button<testcase>
    Then system should list down the available corporate type details based on the selected data
    But system should display a No records found message if no corporate types matches selection
    Examples:
      | testcase |
      | DB-TC-185 |

  Scenario Outline: Verify that the super admin is able to search the available workflow mapping only by selecting Status as Authorized in the search criteria
    When selects Authorized in Status field and click on Search button<testcase>
    Then system should list down the available corporate type details based on the selected data
    But system should display a No records found message if no corporate types matches selection
    Examples:
      | testcase |
      | DB-TC-186 |

  Scenario Outline: Verify that the super admin is able to search the available workflow mapping by providing all the search criteria
    When enters data in all the fields and click on Search button<testcase>
    Then system should list down the available corporate type details based on the selected data
    But system should display a No records found message if no corporate types matches selection
    Examples:
      | testcase |
      | DB-TC-187 |

  Scenario Outline: Verify that the admin is not able to modify a workflow mapping which is pending for authorization at any stage
    When selects pending for authorization in Status field and click on Search button<testcase>
    Then system should list down the available corporate type details based on the selected data
    But system should display a No records found message if no corporate types matches selection
    And modify button should not be visible in the actions column
    Examples:
      | testcase |
      | DB-TC-188 |

  Scenario Outline: Verify that the admin is not able to delete a workflow mapping which is pending for authorization at any stage
    When selects pending for authorization in Status field and click on Search button<testcase>
    Then system should list down the available corporate type details based on the selected data
    But system should display a No records found message if no corporate types matches selection
    And delete button should not be visible in the actions column
    Examples:
      | testcase |
      | DB-TC-189 |

  Scenario Outline: Verify the system response when admin clicks on the Search button without providing any search criteria in the Workflow Management summary screen
    When enters no data in all the fields and click on Search button<testcase>
    Then system should list down the available corporate type details
    But system should display a No records found message if no corporate types is available
    Examples:
      | testcase |
      | DB-TC-199 |

  Scenario Outline: Verify that 'remarks' is a mandatory field and accepts only alphabets with spaces up to 50 characters and no special characters allowed while workflow mapping
    When selects pending for authorization in Status field and click on Search button<testcase>
    Then system should list down the available corporate type details based on the selected data
    When  enters no data in remarks field and clicks save button
    Then system should highlight the remarks field in red color
    And system should not allow to enter special characters in remarks field <testcase>
    And system should not allow to enter numbers in remarks field <testcase>
    Examples:
      | testcase |
      | DB-TC-253 |

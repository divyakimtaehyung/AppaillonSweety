Feature: Workflow management feature by super admin

  Background: 2FA_REQUIRED is True in the system
    Given a valid bank application
    When super admin enters a valid email ID and password <testcase>
    And clicks on the Login button
    Then super admin lands on the Dashboard page
    When clicks on workflow management from LHS Menu
    Then lands on workflow management summary screen

  Scenario Outline: Verify that the super admin can map a workflow to a corporate successfully when 2_FACTOR_AUTH = Y in the system and the super admin has opted in for 2FA
    When admin clicks on add button<testcase>
    Then system lands on Workflow Management add initiate screen
    When enters valid details in all the mandatory fields and clicks on Save button<testcase>
    Then admin lands on confirmation screen
    When admin clicks confirm
    Then lands on  OTP screen<testcase>
    When enters OTP from mail and clicks verify
    Then admin displayed with successful message and DB should be updated
    When clicks ok and lands on summary screen searches the added record
    Then record should be displayed with authorized status
    Examples:
      | testcase |
      | DB-TC-125 |

  Scenario Outline: Verify that the super admin can map a workflow to a corporate successfully when 2_FACTOR_AUTH = Y in the system and the super admin has opted out from 2FA
    When admin clicks on add button<testcase>
    Then system lands on Workflow Management add initiate screen
    When enters valid details in all the mandatory fields and clicks on Save button
    Then admin lands on confirmation screen
    When enters OTP from mail and clicks verify
    Then admin displayed with successful message and DB should be updated
    When clicks ok and lands on summary screen searches the added record
    Then record should be displayed with authorized status
    Examples:
      | testcase |
      | DB-TC-126 |

  Scenario Outline: Verify that super admin can approve an add initiated workflow mapping successfully when 2_FACTOR_AUTH = Y in the system and the admin has opted in for 2FA
    When selects Add Initiated in Status field and click on Search button<testcase>
    Then system should list down the add initiated record
    When click on the record
    Then lands on the confirmation screen
    When enters remarks and click authorize
    Then lands on  OTP screen
    When enters OTP from mail and clicks verify
    Then admin displayed with successful message and DB should be updated
    When clicks ok and lands on summary screen searches the added record
    Then record should be displayed with authorized status
    Examples:
      | testcase |
      | DB-TC-131 |

  Scenario Outline: Verify that super admin can approve an add initiated workflow mapping successfully when 2_FACTOR_AUTH = Y in the system and the admin has opted out from 2FA
    When selects Add Initiated in Status field and click on Search button<testcase>
    Then system should list down the add initiated record
    When click on the record
    Then lands on the confirmation screen
    When enters remarks and click authorize
    Then admin displayed with successful message and DB should be updated
    When clicks ok and lands on summary screen searches the added record
    Then record should be displayed with authorized status
    Examples:
      | testcase |
      | DB-TC-132 |

  Scenario Outline: Verify that super admin can reject an add initiated workflow mapping successfully when 2_FACTOR_AUTH = Y in the system and the admin has opted in for 2FA
    When selects Add Initiated in Status field and click on Search button<testcase>
    Then system should list down the add initiated record
    When click on the record
    Then lands on the confirmation screen
    When enters remarks and click Reject
    Then lands on  OTP screen
    When enters OTP from mail and clicks verify
    Then admin displayed with rejection message and DB should be updated
    When clicks ok and lands on summary screen searches the record
    Then record should be displayed with rejected by authorizer status
    Examples:
      | testcase |
      | DB-TC-138 |

  Scenario Outline: Verify that super admin can reject an add initiated workflow mapping successfully when 2_FACTOR_AUTH = Y in the system and the admin has opted out for 2FA
    When selects Add Initiated in Status field and click on Search button<testcase>
    Then system should list down the add initiated record
    When click on the record
    Then lands on the confirmation screen
    When enters remarks and click Reject
    Then admin displayed with rejection message and DB should be updated
    When clicks ok and lands on summary screen searches the record
    Then record should be displayed with rejected by authorizer status
    Examples:
      | testcase |
      | DB-TC-139 |

  Scenario Outline: Verify that the super admin can modify a workflow mapping successfully when 2_FACTOR_AUTH = Y in the system and the super admin has opted in for 2FA
    When selects authorized in Status field and click on Search button<testcase>
    And clicks on the modify button for a record
    Then lands on the modification screen
    When enters valid data in the mandatory fields and clicks save
    Then lands on confirmation screen
    When admin clicks confirm
    Then lands on  OTP screen
    When enters OTP from mail and clicks verify
    Then admin displayed with successful message and DB should be updated
    When clicks ok and lands on summary screen searches the modified record
    Then record should be displayed with authorized status
    Examples:
      | testcase |
      | DB-TC-146 |

  Scenario Outline: Verify that the super admin can modify a workflow mapping successfully when 2_FACTOR_AUTH = Y in the system and the super admin has opted out from 2FA
    When selects authorized in Status field and click on Search button<testcase>
    And clicks on the modify button for a record
    Then lands on the modification screen
    When enters valid data in the mandatory fields and clicks save
    Then lands on confirmation screen
    When admin clicks confirm
    Then lands on  OTP screen
    When enters OTP from mail and clicks verify
    Then admin displayed with successful message and DB should be updated
    When clicks ok and lands on summary screen searches the modified record
    Then record should be displayed with authorized status
    Examples:
      | testcase |
      | DB-TC-147 |

  Scenario Outline: Verify that super admin can approve a modify initiated workflow mapping successfully when 2_FACTOR_AUTH = Y in the system and the admin has opted in for 2FA
    When selects Modify Initiated in Status field and click on Search button<testcase>
    Then system should list down the modify initiated record
    When click on the record
    Then lands on the confirmation screen
    When enters remarks and click authorize
    Then lands on  OTP screen
    When enters OTP from mail and clicks verify
    Then admin displayed with successful message and DB should be updated
    When clicks ok and lands on summary screen searches the added record
    Then record should be displayed with authorized status
    Examples:
      | testcase |
      | DB-TC-152 |

  Scenario Outline: Verify that super admin can approve a modify initiated workflow mapping successfully when 2_FACTOR_AUTH = Y in the system and the admin has opted out for 2FA
    When selects Modify Initiated in Status field and click on Search button<testcase>
    Then system should list down the modify initiated record
    When click on the record
    Then lands on the confirmation screen
    When enters remarks and click authorize
    Then admin displayed with successful message and DB should be updated
    When clicks ok and lands on summary screen searches the added record
    Then record should be displayed with authorized status
    Examples:
      | testcase |
      | DB-TC-153 |

  Scenario Outline: Verify that the super admin can reject a modify initiated workflow mapping successfully when 2_FACTOR_AUTH = Y in the system and the admin has opted in for 2FA
    When selects Modify Initiated in Status field and click on Search button<testcase>
    Then system should list down the modify initiated record
    When click on the record
    Then lands on the confirmation screen
    When enters remarks and click Reject
    Then lands on  OTP screen
    When enters OTP from mail and clicks verify
    Then admin displayed with rejection message and DB should be updated
    When clicks ok and lands on summary screen searches the record
    Then record should be displayed with rejected by authorizer status
    Examples:
      | testcase |
      | DB-TC-156 |

  Scenario Outline: Verify that the super admin can reject a modify initiated workflow mapping successfully when 2_FACTOR_AUTH = Y in the system and the admin has opted in for 2FA
    When selects Modify Initiated in Status field and click on Search button<testcase>
    Then system should list down the modify initiated record
    When click on the record
    Then lands on the confirmation screen
    When enters remarks and click Reject
    Then admin displayed with rejection message and DB should be updated
    When clicks ok and lands on summary screen searches the record
    Then record should be displayed with rejected by authorizer status
    Examples:
      | testcase |
      | DB-TC-157 |

  Scenario Outline: Verify that the super admin can delete a workflow mapping successfully when 2_FACTOR_AUTH = Y in the system and the super admin has opted in from 2FA
    When selects authorized in Status field and click on Search button<testcase>
    And clicks on the delete button for a record
    Then lands on the delete screen
    When clicks delete button
    Then lands on confirmation screen
    When admin clicks confirm
    Then lands on  OTP screen
    When enters OTP from mail and clicks verify
    Then admin displayed with successful message and DB should be updated
    When clicks ok and lands on summary screen searches the deleted record
    Then record should not be displayed
    Examples:
      | testcase |
      | DB-TC-158 |

  Scenario Outline: Verify that the super admin can delete a workflow mapping successfully when 2_FACTOR_AUTH = Y in the system and the super admin has opted out from 2FA
    When selects authorized in Status field and click on Search button<testcase>
    And clicks on the delete button for a record
    Then lands on the delete screen
    When clicks delete button
    Then lands on confirmation screen
    When admin clicks confirm
    Then admin displayed with successful message and DB should be updated
    When clicks ok and lands on summary screen searches the deleted record
    Then record should not be displayed
    Examples:
      | testcase |
      | DB-TC-159 |

  Scenario Outline: Verify that the super admin can approve a delete initiated workflow mapping successfully when 2_FACTOR_AUTH = Y in the system and the admin has opted in for 2FA
    When selects delete Initiated in Status field and click on Search button<testcase>
    Then system should list down the delete initiated record
    When click on the record
    Then lands on the confirmation screen
    When enters remarks and click authorize
    Then lands on  OTP screen
    When enters OTP from mail and clicks verify
    Then admin displayed with successful message and DB should be updated
    When clicks ok and lands on summary screen searches the added record
    Then record should not be displayed
    Examples:
      | testcase |
      | DB-TC-164 |

  Scenario Outline: Verify that the super admin can approve a delete initiated workflow mapping successfully when 2_FACTOR_AUTH = Y in the system and the admin has opted out from 2FA
    When selects delete Initiated in Status field and click on Search button<testcase>
    Then system should list down the delete initiated record
    When click on the record
    Then lands on the confirmation screen
    When enters remarks and click authorize
    Then lands on  OTP screen
    When enters OTP from mail and clicks verify
    Then admin displayed with successful message and DB should be updated
    When clicks ok and lands on summary screen searches the added record
    Then record should not be displayed
    Examples:
      | testcase |
      | DB-TC-165 |

  Scenario Outline: Verify that the super admin can reject a delete initiated workflow mapping successfully when 2_FACTOR_AUTH = Y in the system and the admin has opted in for 2FA
    When selects delete Initiated in Status field and click on Search button<testcase>
    Then system should list down the delete initiated record
    When click on the record
    Then lands on the confirmation screen
    When enters remarks and click Reject
    Then lands on  OTP screen
    When enters OTP from mail and clicks verify
    Then admin displayed with rejection message and DB should be updated
    When clicks ok and lands on summary screen searches the record
    Then record should be displayed with rejected by authorizer status
    Examples:
      | testcase |
      | DB-TC-168 |

  Scenario Outline: Verify that the super admin can reject a delete initiated workflow mapping successfully when 2_FACTOR_AUTH = Y in the system and the admin has opted out for 2FA
    When selects delete Initiated in Status field and click on Search button<testcase>
    Then system should list down the delete initiated record
    When click on the record
    Then lands on the confirmation screen
    When enters remarks and click Reject
    Then admin displayed with rejection message and DB should be updated
    When clicks ok and lands on summary screen searches the record
    Then record should be displayed with rejected by authorizer status
    Examples:
      | testcase |
      | DB-TC-169 |



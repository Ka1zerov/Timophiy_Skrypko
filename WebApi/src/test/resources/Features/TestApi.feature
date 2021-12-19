Feature:
  Background:
    Given request specification is set

  Scenario: File Upload
    When HEADER Dropbox-API-Arg is set
    And HEADER parameter request content type is set asa "application/octet-stream"
    And request body parameters is set for uploading
    And POST HTTP request upload is sent
    Then valid HTTP response code is received as 200

  Scenario:  Get Metadata
    When HEADER parameter request content type is set as "application/json"
    And request body parameters is set for getting metadata
    And POST HTTP request get_metadata is sent
    Then valid HTTP response code is received as 200

  Scenario: File Delete
    When HEADER parameter request content type is set as "application/json"
    And request body parameters is set for deleting file
    And POST HTTP request delete is sent
    Then valid HTTP response code is received as 200
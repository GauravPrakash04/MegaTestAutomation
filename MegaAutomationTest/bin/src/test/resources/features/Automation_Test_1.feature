Feature: Automation Test 1

Scenario: Create and upload a text file "a.text" with content "megatest" in it

Given Mega application launched on browser accepting cookies and user is logged into the User FILE Manager page
When User creates a text file a.text with content "megatesting" and uploads it using File Upload
Then User should verify that a.text is successfully uploaded in File Manager

Scenario: Delete the file "a.text"

Given The text file "a.text" with content "megatesting" is created and uploaded in File Manager
When User Deletes the"a.text" file
Then The "a.text" file should get deleted

Scenario: The file "a.text" can be restored from Rubbish Bin

Given The text file "a.text" was deleted from File Manager
When User enters Rubbish Bin and restores file "a.text"
Then The "a.text" file should get restored to File Manager
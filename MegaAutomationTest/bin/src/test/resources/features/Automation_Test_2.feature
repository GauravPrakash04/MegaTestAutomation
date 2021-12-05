Feature: Automation Test 2

Scenario: Validate that Linux Distros are downloadable

Given User launches https//www.mega.nz/sync url in the browser
When User clicks on Linux option
Then All the distros are downloadable

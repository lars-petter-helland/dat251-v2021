# language: en
Feature: Splitte et navn i fornavn og etternavn
  bla... bla...
  
Scenario: Ett fornavn og ett etternavn
  Given Navnet er "Per Hansen"
  When Vi splitter navnet
  Then Fornavnet blir "Per"
  And Etternavnet blir "Hansen"


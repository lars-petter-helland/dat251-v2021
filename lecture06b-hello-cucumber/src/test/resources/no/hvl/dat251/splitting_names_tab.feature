# language: en
Feature: Splitte et navn i fornavn og etternavn
  bla... bla...
  
Scenario Outline: Diverse eksempler på fulle navn
  Given Navnet er "<navn>"
  When Vi splitter navnet
  Then Fornavnet blir "<fornavn>"
  And Etternavnet blir "<etternavn>"

Examples:
	| navn  		| fornavn	| etternavn	|
	| Per Nilsen 	| Per 		| Nilsen 	|
	| Ola Per Ås 	| Ola Per 	| Ås 		|
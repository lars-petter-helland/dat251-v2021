# language: no
Egenskap: Er det blitt fredag nå?
  Alle ønsker å vite om det er blitt fredag

  Scenariomal: I dag er eller er ikke fredag
    Gitt at det er "<dag>" i dag
    Når jeg spør om det er blitt fredag nå
    Så skal svaret være "<fasit>"

  Eksempler: 
  	| dag		| fasit	|
  	| fredag	| TGIF	|
  	| søndag	| Dessverre	|
  	| blabla	| Dessverre	|
  	
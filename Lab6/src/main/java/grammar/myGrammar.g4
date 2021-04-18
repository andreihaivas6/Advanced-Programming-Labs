grammar myGrammar;

NR: ('1'..'9') ('0'..'9')* | '0';
punct: ' 'NR ' 'NR;
type: 'fill' | 'draw';

command: circleCommand | polygonCommand;
circleCommand: type ' circle' punct raza;
raza: ' 'NR;

polygonCommand: type ' polygon' punct nrLaturi dimensiune;
nrLaturi: ' 'NR;
dimensiune: ' 'NR;


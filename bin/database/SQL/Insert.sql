INSERT INTO autostrada(nome, citta_uno, citta_due, tipo) values("Autostrada del sole", "Milano", "Napoli", 0);
INSERT INTO autostrada(nome, citta_uno, citta_due, tipo) values("Autostrada A3", "Napoli", "Salerno", 0);
INSERT INTO autostrada(nome, citta_uno, citta_due, tipo) values("La Verdemare", "Torino", "Savona", 1);
INSERT INTO autostrada(nome, citta_uno, citta_due, tipo) values("Autostrada Azzurra", "Genova", "Roma", 0);
INSERT INTO autostrada(nome, citta_uno, citta_due, tipo) values("Autostrada Brebemi", "Brescia", "Milano", 1);

INSERT INTO tariffa_autostradale(autostrada_id, tariffaA, tariffaB, tariffa3, tariffa4, tariffa5) values(1, 0.1, 0.2, 0.3, 0.4, 0.5);
INSERT INTO tariffa_autostradale(autostrada_id, tariffaA, tariffaB, tariffa3, tariffa4, tariffa5) values(2, 0.2, 0.3, 0.4, 0.5, 0.6);
INSERT INTO tariffa_autostradale(autostrada_id, tariffaA, tariffaB, tariffa3, tariffa4, tariffa5) values(3, 0.3, 0.4, 0.5, 0.6, 0.7);
INSERT INTO tariffa_autostradale(autostrada_id, tariffaA, tariffaB, tariffa3, tariffa4, tariffa5) values(4, 0.4, 0.5, 0.6, 0.7, 0.8);
INSERT INTO tariffa_autostradale(autostrada_id, tariffaA, tariffaB, tariffa3, tariffa4, tariffa5) values(5, 0.5, 0.6, 0.7, 0.8, 0.9);

INSERT INTO tariffa_tipo_autostrada(autostrada_tipo, tariffa) values(0, 0.5);
INSERT INTO tariffa_tipo_autostrada(autostrada_tipo, tariffa) values(1, 0.6);

INSERT INTO casello(autostrada_id, nome, comune_appartenenza, chilometro) values(1, "Fiorenzuola", "Piacenza", 74);
INSERT INTO casello(autostrada_id, nome, comune_appartenenza, chilometro) values(1, "Lodi", "Lodi", 22.3);
INSERT INTO casello(autostrada_id, nome, comune_appartenenza, chilometro) values(1, "Sasso Marconi", "Bologna", 210);
INSERT INTO casello(autostrada_id, nome, comune_appartenenza, chilometro) values(2, "Ercolano", "Napoli", 8.5);
INSERT INTO casello(autostrada_id, nome, comune_appartenenza, chilometro) values(2, "Portici", "Napoli", 8);
INSERT INTO casello(autostrada_id, nome, comune_appartenenza, chilometro) values(2, "Angri", "Salerno", 29.7);
INSERT INTO casello(autostrada_id, nome, comune_appartenenza, chilometro) values(3, "Ceva", "Cuneo", 81);
INSERT INTO casello(autostrada_id, nome, comune_appartenenza, chilometro) values(3, "Carmagnola", "Torino", 13.1);
INSERT INTO casello(autostrada_id, nome, comune_appartenenza, chilometro) values(3, "Millesimo", "Savona", 97.1);
INSERT INTO casello(autostrada_id, nome, comune_appartenenza, chilometro) values(4, "Lavagna", "Genova", 41.1);
INSERT INTO casello(autostrada_id, nome, comune_appartenenza, chilometro) values(4, "Cecina Nord", "Livorno", 251.6);
INSERT INTO casello(autostrada_id, nome, comune_appartenenza, chilometro) values(4, "Recco", "Genova", 22.8);
INSERT INTO casello(autostrada_id, nome, comune_appartenenza, chilometro) values(5, "Castrezzato", "Brescia", 30.4);
INSERT INTO casello(autostrada_id, nome, comune_appartenenza, chilometro) values(5, "Bariano", "Bergamo", 40.1);
INSERT INTO casello(autostrada_id, nome, comune_appartenenza, chilometro) values(5, "Milano", "Milano", 62.1);

INSERT INTO automobile_con_telepass(targa) values("AA 000 AA");
INSERT INTO automobile_con_telepass(targa) values("AA 001 AA");
INSERT INTO automobile_con_telepass(targa) values("AA 002 AA");
INSERT INTO automobile_con_telepass(targa) values("AA 003 AA");
INSERT INTO automobile_con_telepass(targa) values("AA 004 AA");

INSERT INTO ingresso_telepass(automobile_telepass_targa, casello_id) values("AA 000 AA", 1);
INSERT INTO ingresso_telepass(automobile_telepass_targa, casello_id) values("AA 001 AA", 6);

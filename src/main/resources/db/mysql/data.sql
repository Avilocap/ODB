--Platform

INSERT IGNORE INTO platform VALUES (1, 'Wireless', 'Quest');
INSERT IGNORE INTO platform VALUES (2, 'Power your dreams', 'Rift');
INSERT IGNORE INTO platform VALUES (3, '4 the players', 'PS4');

--Category

INSERT IGNORE INTO category VALUES (1, 'Amazing', 'Action');
INSERT IGNORE INTO category VALUES (2, 'Funny', 'Sports');
INSERT IGNORE INTO category VALUES (3, 'Incredible', 'Arcade');

--Users

INSERT IGNORE INTO users VALUES (1, 'pedro@gmail.com', 'Pedro', 'Rodríguez', 1);
INSERT IGNORE INTO users VALUES (2, 'manu@gmail.com', 'Manuel', 'Jiménez', 2);
INSERT IGNORE INTO users VALUES (3, 'antonio@gmail.com', 'Antonio', 'Ruiz', 3);

--User accounts

INSERT IGNORE INTO user_account VALUES (1, 'authority1', 'pedro1', 'pedro1');
INSERT IGNORE INTO user_account VALUES (2, 'authority2', 'manu1', 'manu1');
INSERT IGNORE INTO user_account VALUES (3, 'authority3', 'antonio1', 'antonio1');
INSERT IGNORE INTO user_account VALUES (4, 'authority4', 'miguel1', 'miguel1');
INSERT IGNORE INTO user_account VALUES (5, 'authority5', 'adri1', 'adri1');
INSERT IGNORE INTO user_account VALUES (6, 'authority6', 'josema1', 'josema1');

--Credit cards

INSERT IGNORE INTO credit_cards VALUES (1, 123, 12, 2022, 'Pedro Rodríguez', 123456);
INSERT IGNORE INTO credit_cards VALUES (2, 456, 5, 2024, 'Manuel Jiménez', 256478);
INSERT IGNORE INTO credit_cards VALUES (3, 789, 7, 2023, 'Antonio Ruiz', 338976);
INSERT IGNORE INTO credit_cards VALUES (4, 678, 3, 2022, 'Miguel López', 354789);

--Applications

INSERT IGNORE INTO application VALUES ('1471853306166046', 'Activision', 'description1', 126000, 'English', 'Call of duty', 170, 'http://www.google.com/imagen1', 70, '13-03-2020', 1000000, 1, 'GAME', 'MULTIPLAYER', 'http://www.callfoduty.com', 1, 3);
INSERT IGNORE INTO application VALUES ('1471853306166044', 'EA Sports', 'description2', 150000, 'English', 'FIFA 20', 16, 'http://www.google.com/imagen2', 70, '21-09-2019', 2000000, 1, 'GAME', 'MULTIPLAYER', 'http://www.fifa20.com', 2, 2);
INSERT IGNORE INTO application VALUES ('1471853306166042', 'Epic games', 'description3', 200000, 'English', 'Fortnite', 207, 'http://www.google.com/imagen3', 10, '13-09-2018', 7000000, 1, 'GAME', 'MULTIPLAYER', 'http://www.fortnite.com', 3, 1);

--Administrator

INSERT IGNORE INTO administrator VALUES (1, 'pedro@gmail.com', 'Pedro', 'Rodríguez', 1);

--Comments

INSERT IGNORE INTO comments VALUES (1, 'This game is awesome!', 'Perfect', 1);
INSERT IGNORE INTO comments VALUES (2, 'This game is a shit', 'Bad', 3);
INSERT IGNORE INTO comments VALUES (3, 'Best game in the world', 'Incredible', 2);

--Developer

INSERT IGNORE INTO developer VALUES (1, 'manu@gmail.com', 'Manuel', 'Jiménez', 'Microsoft', 'Be whats next', 'http://www.microsoft.com', 2, 2);

--Reviews

INSERT IGNORE INTO reviews VALUES (1, 'perfect videogame', 170, '17/02/2020', 'review 1', TRUE, 1);
INSERT IGNORE INTO reviews VALUES (2, 'could be better', 16, '27/01/2020', 'review 2', TRUE, 2);
INSERT IGNORE INTO reviews VALUES (3, 'incredible videogame', 207, '17/01/2020', 'review 3', TRUE, 3);

--Sponsor

INSERT IGNORE INTO sponsors VALUES (1, 'miguel1@gmail', 'Miguel', 'López', 4, 4);

--Sponsorship

INSERT IGNORE INTO sponsorship VALUES (1, 'http://www.miguel.com', 'miguel', 1);
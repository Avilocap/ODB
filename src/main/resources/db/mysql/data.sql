
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

INSERT IGNORE INTO oculusdb.application (id, company, description, income_estimation, language, name, oculusdbid, picture, price, release_date, sales_estimations, total_reviews, type_of_app, type_of_gameplay, website, category_id, platform_id) VALUES (9, 'Lucky VR Inc.', 'PokerStars, the world’s leading poker brand, has combined live and online poker in a truly immersive VR experience.

-Study your opponents, pick up on their tells, and chat in real time
-Handle your chips and cards, just as you would at a real-world poker table
-Keep the table fun with interactive props and toys, summoned in an instant

This is the most exciting poker game on the planet, and there’s a seat open for you right now.

- Key Features -

-Authentic poker action
-A fully immersive, social experience
-Simple, intuitive, easy to play
-Play real opponents
-Realistic physics, from cards and chips to balloons, pistols and more
-Unlock free chips every day
-Certified RNG

- Exotic locales -

-Evil Volcano Lair
-Macau 2050
-The Galaxy Space Station
-Macau Suite
-The Showdown Saloon
-The Monte-Carlo Yacht
-The Void', 536565, 'English', 'PokerStars VR', '2370815932930055', 'https://scontent.oculuscdn.com/v/t64.5771-25/q92/s2048x2048/75330717_659219998185694_5756312562501156864_n.jpg?_nc_cat=105&_nc_sid=79b88e&_nc_ohc=r4S4DDdsbVkAX-ATC8f&_nc_ht=scontent.oculuscdn.com&oh=84e2e6058d5ee2d8a1c752a9a4d1503c&oe=5E9F0BBA', 29.99, '1970-01-18', 7960, 398, 0, 0, 'http://www.starsgroup.com/', 1, 1);
INSERT IGNORE INTO oculusdb.application (id, company, description, income_estimation, language, name, oculusdbid, picture, price, release_date, sales_estimations, total_reviews, type_of_app, type_of_gameplay, website, category_id, platform_id) VALUES (10, 'ILMxLAB', 'Step inside a galaxy far, far away with Vader Immortal: Episode I. You are a smuggler operating near Mustafar, the fiery world Darth Vader calls home. When you are unexpectedly pulled out of hyperspace, you find yourself uncovering an ancient mystery at the behest of the Sith Lord himself.

With the help of your droid companion, ZO-E3, you’ll navigate the dangers of the fortress, hone your lightsaber skills, and meet new characters along the way as you discover what Vader is up to.

Also included with your purchase is Lightsaber Dojo, an open-ended training experience where you can hone your skills with the weapon of a Jedi Knight.

Starring Maya Rudolph, Vader Immortal is a canonical Star Wars adventure created by ILMxLAB and Lucasfilm in collaboration with Oculus Studios.', 548913, 'English', 'Vader Immortal: Episode I', '2108775495884888', 'https://scontent.oculuscdn.com/v/t64.5771-25/q92/s2048x2048/39031316_449628479134540_3043318202793721856_n.jpg?_nc_cat=105&_nc_sid=79b88e&_nc_ohc=vP4IpDBxL0sAX9Kpv3b&_nc_ht=scontent.oculuscdn.com&oh=de24cc3346a92f115f6d633037782cd6&oe=5E9EDAC0', 7.99, '1970-01-18', 68700, 3435, 0, 0, 'https://www.ilmxlab.com/', 1, 1);
INSERT IGNORE INTO oculusdb.application (id, company, description, income_estimation, language, name, oculusdbid, picture, price, release_date, sales_estimations, total_reviews, type_of_app, type_of_gameplay, website, category_id, platform_id) VALUES (11, 'Crytek', 'Feel the exhilaration of extreme free solo climbing. Experience the adrenaline rush as you ascend to epic heights, explore caves, and find shortcuts. Race against your friends’ routes to compete for the fastest times on leaderboards. Navigate and enjoy stunning landscapes from around the world, including the Alps, Southeast Asia, and the American Southwest.

Features:
- Free solo climbing:  Ascend to epic heights, explore caves, and find shortcuts
- Multiplayer and achievements: Race other players’ ghosts, rise up leaderboards and earn over 100 achievements to unlock gear.
- Bouldering: Beat intense routes that demand perfect technique.
- Tourist mode: Climb with simplified mechanics, ideal for introducing your friends to VR.
- Outstanding environments: Enjoy three beautiful, immersive locations by day or night.

Developed by Crytek and achieved with CRYENGINE.', 281906, 'English', 'The Climb', '2376737905701576', 'https://scontent.oculuscdn.com/v/t64.5771-25/q92/s2048x2048/75203615_471473166905415_8666801544387100672_n.jpg?_nc_cat=100&_nc_sid=79b88e&_nc_ohc=kwPykyCgxsUAX-osVUf&_nc_ht=scontent.oculuscdn.com&oh=923f7a176297a0b32cd2c13c42d02574&oe=5E9F525B', 29.99, '1970-01-18', 9400, 470, 0, 0, 'http://www.theclimbgame.com/', 1, 1);
INSERT IGNORE INTO oculusdb.application (id, company, description, income_estimation, language, name, oculusdbid, picture, price, release_date, sales_estimations, total_reviews, type_of_app, type_of_gameplay, website, category_id, platform_id) VALUES (12, 'Survios', '• Live Your Legacy: Challenge both your body and mind as you experience the ascent of Adonis Creed from undiscovered underdog to world-class fighter, all within an immersive universe inspired by the Creed™ films.

• Multiple Game Modes: Choose your path to glory in multiple game modes: story-driven Career, customizable Freeplay, or online PvP.

• Feel the Impact: Phantom Melee Technology mimics the real-life effects of throwing and taking punches in the ring, such as the out-of-body sensation of getting knocked out or the strain of fatigue during a long, frantic bout.

• Break Them―or Become Them: Play or fight the most iconic figures from the Creed™ and Rocky™ universe in Freeplay or PvP, including classic Rocky Balboa, Ivan and Viktor Drago, and more!

• Oculus Cross-Buy: Got CREED: Rise to Glory in your Rift library? Let the punches fly on Quest at no additional cost with complimentary cross-buy.', 269910, 'English', 'Creed: Rise to Glory', '2366245336750543', 'https://scontent.oculuscdn.com/v/t64.5771-25/q92/s2048x2048/38982692_458313288269493_3625162327235493888_n.jpg?_nc_cat=100&_nc_sid=79b88e&_nc_ohc=jeu6so0h5SAAX8dl5ng&_nc_ht=scontent.oculuscdn.com&oh=d3cd860098b0025df03dd756b0c6cf26&oe=5E9E350C', 29.99, '1970-01-18', 9000, 450, 0, 0, 'https://survios.com/creed/', 1, 1);
INSERT IGNORE INTO oculusdb.application (id, company, description, income_estimation, language, name, oculusdbid, picture, price, release_date, sales_estimations, total_reviews, type_of_app, type_of_gameplay, website, category_id, platform_id) VALUES (13, 'Oculus Studios Strike Team', 'Dead and Buried II is a fast-paced multiplayer shooter set in a supernatural western world. Grab your six-shooters and go head-to-head in various game modes. Compete against real players online to see who is the best gunslinger! The game is a sequel to the popular Dead and Buried released on Rift and GO.

Features:
- Competitive Modes: battle online in free-roaming Deathmatch or cover-based Shootout.
- Multiplayer Bots: never wait for players again! Bots will fill the game.
- Portable: with Quest, take the action on the go.
- Social: make new friends in the Town and spin up matches together.
- Weaponry: six-shooters, grenade launchers, and more!
- Future Plans: more events will be added to the Town over time so stay tuned!', 101948, 'English', 'Dead and Buried II', '2134077359973067', 'https://scontent.oculuscdn.com/v/t64.5771-25/q92/s2048x2048/38974680_316041692401259_7240568868186357760_n.jpg?_nc_cat=107&_nc_sid=79b88e&_nc_oc=AQkqhY_ScPCMYtrcMcwL-GCv2C_bsttFPBKFU-A6XpCB96ciXnH4yc4naFnUeFH7JQo&_nc_ht=scontent.oculuscdn.com&oh=19f524003f15ee2a9f0239ab553a02b0&oe=5E9E7B58', 19.99, '1970-01-18', 5100, 255, 0, 0, 'http://www.oculus.com/', 1, 1);
INSERT IGNORE INTO oculusdb.application (id, company, description, income_estimation, language, name, oculusdbid, picture, price, release_date, sales_estimations, total_reviews, type_of_app, type_of_gameplay, website, category_id, platform_id) VALUES (15, 'Owlchemy Labs', 'In a world where robots have replaced all human jobs, step into the "Job Simulator" to learn what it was like ''to do the job''.

Players can relive the glory days of work by simulating the ins and outs of being a gourmet chef, an office worker, a convenience store clerk, and more.

Key Jobbing Features:
●	Throw a stapler at your boss!
●	Learn to ''job'' in four not-so historically accurate representations of work-life before society was automated by robots!
●	Use your hands to stack, manipulate, throw, and smash physics objects in an inexplicably satisfying way!
●	Aggressively chug coffee and eat questionable food from the trash!
●	Able to juggle tomatoes in real life? Do it in VR! Unable to juggle? There''s no cleanup required in VR!
●	Gain valuable life experience by firing new employees, serving slushy treats, brewing English tea, and ripping apart car engines!
●	Work the never-ending night shift with Infinite Overtime mode!', 476502, 'English', 'Job Simulator', '3235570703151406', 'https://scontent.oculuscdn.com/v/t64.5771-25/q92/s2048x2048/38974655_311843986407378_6697994888157331456_n.jpg?_nc_cat=111&_nc_sid=79b88e&_nc_oc=AQmRMzIw5Nkrm3aUysUUfpD7rCdDUjd3q_fNhjmtZZ5ls6Ui0DprUF-5J2KBKUwhr_M&_nc_ht=scontent.oculuscdn.com&oh=e37f1ae8e6903c7272468d620244ec61&oe=5E9D6BDA', 15.99, '1970-01-18', 29800, 1490, 0, 0, 'http://jobsimulatorgame.com/', 1, 1);



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
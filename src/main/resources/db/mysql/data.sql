
--Platform

INSERT IGNORE INTO platform VALUES (1, 'Wireless', 'Quest');
INSERT IGNORE INTO platform VALUES (2, 'Power your dreams', 'Rift');
INSERT IGNORE INTO platform VALUES (3, '4 the players', 'PS4');
INSERT IGNORE INTO platform VALUES (4, 'Virtual reality only in one', 'Go');
INSERT IGNORE INTO platform VALUES (5, 'Play VR on your computer', 'Rift S');

--Category

INSERT IGNORE INTO category VALUES (1, 'Amazing', 'Action');
INSERT IGNORE INTO category VALUES (2, 'Funny', 'Sports');
INSERT IGNORE INTO category VALUES (3, 'Incredible', 'Arcade');

--Roles

INSERT IGNORE INTO role VALUES (1,'ADMIN');
INSERT IGNORE INTO role VALUES (2,'USER');
INSERT IGNORE INTO role VALUES (3,'SPONSOR');
INSERT IGNORE INTO role VALUES (4,'DEVELOPER');

--Users
INSERT IGNORE INTO oculusdb.users (id, email, name, password, surname, username) VALUES (1, 'testuser@gmail.com', 'User', '$2a$10$aqRkmFNk6QGlOmbk.xy7puTC7Y1DmHQayZBYGUghMEbkus.7vwT0K', 'Test', 'testuser');
INSERT IGNORE INTO oculusdb.users (id, email, name, password, surname, username) VALUES (2, 'josema@gmail.com', 'josema', 'josema1234', 'josema', 'josema');
INSERT IGNORE INTO oculusdb.users (id, email, name, password, surname, username) VALUES (3, 'manu@gmail.com', 'manu', '$2a$10$aqRkmFNk6QGlOmbk.xy7puTC7Y1DmHQayZBYGUghMEbkus.7vwT0K', 'manu', 'manu');
INSERT IGNORE INTO oculusdb.users (id, email, name, password, surname, username) VALUES (4, 'adri@gmail.com', 'adri', 'adri1234', 'adri', 'adri');
INSERT IGNORE INTO oculusdb.users (id, email, name, password, surname, username) VALUES (5, 'miguel@gmail.com', 'miguel', 'miguel1234', 'miguel', 'miguel');
INSERT IGNORE INTO oculusdb.users (id, email, name, password, surname, username) VALUES (6, 'david@gmail.com', 'david', 'david1234', 'david', 'david');

--Users roles

INSERT IGNORE INTO oculusdb.users_roles (users_id, roles_id) VALUES (1, 2);
INSERT IGNORE INTO oculusdb.users_roles (users_id, roles_id) VALUES (1, 1);
INSERT IGNORE INTO oculusdb.users_roles (users_id, roles_id) VALUES (2, 2);
INSERT IGNORE INTO oculusdb.users_roles (users_id, roles_id) VALUES (3, 2);
INSERT IGNORE INTO oculusdb.users_roles (users_id, roles_id) VALUES (4, 2);
INSERT IGNORE INTO oculusdb.users_roles (users_id, roles_id) VALUES (5, 2);
INSERT IGNORE INTO oculusdb.users_roles (users_id, roles_id) VALUES (6, 2);
--Credit cards

INSERT IGNORE INTO credit_cards VALUES (1, 123, 12, 2022, 'Pedro Rodríguez', 123456);
INSERT IGNORE INTO credit_cards VALUES (2, 456, 5, 2024, 'Manuel Jiménez', 256478);
INSERT IGNORE INTO credit_cards VALUES (3, 789, 7, 2023, 'Antonio Ruiz', 338976);
INSERT IGNORE INTO credit_cards VALUES (4, 678, 3, 2022, 'Miguel López', 354789);

--Applications
INSERT IGNORE INTO oculusdb.application (id, company, description, income_estimation, language, name, oculusdbid, picture, price, release_date, sales_estimations, total_reviews, type_of_app, type_of_gameplay, website, category_id, platform_id) VALUES (100, 'Ready At Dawn', 'In Lone Echo’s single player story, you’ll be transported to an advanced mining facility within the rings of Saturn, complete with a detailed space station, expansive outer-space environments, and interactive space equipment. Taking on the role of Jack—an advanced artificial intelligence with a state-of-the-art synthetic body—you’ll help Captain Olivia Rhodes solve an increasingly threatening mystery as you use futuristic tools, clever problem solving, and interactive dialogue to engage with the world around you. Taking advantage of the Oculus Touch controllers and full 360° gameplay, Lone Echo lets you take a hands-on approach to exploring space unlike anything you’ve ever played before.', 1146113, 'English', 'Lone Echo', '1368187813209608', 'https://scontent.oculuscdn.com/v/t64.5771-25/q92/s2048x2048/11162690_1597657833600851_7686325918767251456_n.jpg?_nc_cat=102&_nc_sid=79b88e&_nc_ohc=EDYQro3RcYIAX9OLr4p&_nc_ht=scontent.oculuscdn.com&oh=6d3f91c39e0041300f93804491748257&oe=5E9E7776', 39.99, '1970-01-17', 28660, 1433, 0, 0, 'https://www.oculus.com/lone-echo', 1, 1);
INSERT IGNORE INTO oculusdb.application (id, company, description, income_estimation, language, name, oculusdbid, picture, price, release_date, sales_estimations, total_reviews, type_of_app, type_of_gameplay, website, category_id, platform_id) VALUES (101, 'Roman Rekhler, Hamzeh Alsalhi, Oscar Vazquez', 'The ultimate Table Tennis simulator. Play opponents in online multiplayer or practice against the advanced AI. With physics designed to be as real as ever achieved in a Table Tennis simulator, you will forget you are in VR.', 131134, 'English', 'Eleven Table Tennis', '1995434190525828', 'https://scontent.oculuscdn.com/v/t64.5771-25/q92/s2048x2048/75394636_182687759653029_532373432701026304_n.jpg?_nc_cat=111&_nc_sid=79b88e&_nc_oc=AQke-_vfRnsJo6A--cUPcRxpPFql0w9CbGVZR8pWudAJXJFmW_OaMQ0ydYn7IhaJkqQ&_nc_ht=scontent.oculuscdn.com&oh=cb9075e4aaca01e9b39dc873ae4688a3&oe=5EA07FF3', 19.99, '1970-01-18', 6560, 328, 0, 0, 'https://forfunlabs.github.io/', 1, 1);
INSERT IGNORE INTO oculusdb.application (id, company, description, income_estimation, language, name, oculusdbid, picture, price, release_date, sales_estimations, total_reviews, type_of_app, type_of_gameplay, website, category_id, platform_id) VALUES (102, 'Cubicle Ninjas', 'Experience music enhanced, Tai Chi inspired workouts in Virtual Reality. Stimulate your mind, body, and spirit.

*7/5/19 – ADDED 150+ NEW SESSIONS, TWO NEW MODES, & TWO NEW LEVELS*

–EASY TO FOLLOW, CHALLENGING TO MASTER–
Nothing to learn or memorize. Simply follow along. 3-minute to 60-minute sessions.

–MOVING MEDITATIONS–
Let go of tension and stress across 100 sessions in FLOW MODE. A perfect gateway to the concepts of Tai Chi for beginners. Find yourself in the flow, refreshed and energized.

–ARCADE AND WORLD TOUR MODES–
Win points for perfect form across 100 sessions in ARCADE MODE or challenge yourself with the randomized WORLD TOUR MODE, a 60-minute Tai Chi endurance marathon. Strengthen and tone your body, while relaxing your mind.

–BEAUTIFUL NATURE ENVIRONMENTS–
Discover the wilds of nature, in the comfort of your own home with Explore Mode. Eleven beautiful, exotic destinations.

Find your happy place.™', 26773, 'English', 'Guided Tai Chi', '1756328964489238', 'https://scontent.oculuscdn.com/v/t64.5771-25/q92/s2048x2048/38982495_319099892117745_3651611088031580160_n.jpg?_nc_cat=109&_nc_sid=79b88e&_nc_oc=AQlu5Pd2Zm2z_sNm2-GrRpsrOJ5S-Iso96e3z1FK4eqyLxYSNo0DEJgfu8wCHHW55L8&_nc_ht=scontent.oculuscdn.com&oh=daae2cee61a0fe2bc60381d787a527d2&oe=5EA0EA5B', 9.99, '1970-01-18', 2680, 134, 0, 0, 'http://guidedtaichi.com/', 1, 1);
INSERT IGNORE INTO oculusdb.application (id, company, description, income_estimation, language, name, oculusdbid, picture, price, release_date, sales_estimations, total_reviews, type_of_app, type_of_gameplay, website, category_id, platform_id) VALUES (103, 'Harmonix Music Systems, Inc.', 'Dance Central™ is back! Designed from the ground up for VR, Dance Central immerses you and your friends in the world’s best dance club experience where you are the life of the party and nobody steps on your toes.

Dance Central includes a 32 song soundtrack featuring chart-toppers from the 1970s through to today’s biggest hits. With two difficulty levels and unique routines choreographed for each song, there’s plenty to keep you dancing all night.

Dance Central also features the franchise’s first dive into synchronous online multiplayer. Customize your look, take an in-game selfie and then meet up with friends in the multiplayer lounge to party, chat, and dance your hearts out. With cross-play, you can compete against your friends on both the Oculus Quest and Rift Platform in free-for-all or team dance games to see who''s the best in the crew.

Dance Central supports cross-buy. Buy once, play on both Oculus Quest and Rift Platform.', 85171, 'English', 'Dance Central', '2453152771391571', 'https://scontent.oculuscdn.com/v/t64.5771-25/q92/s2048x2048/39031307_457832864824333_6563712254611554304_n.jpg?_nc_cat=105&_nc_sid=79b88e&_nc_oc=AQmcmHBA6U7nKx6yFewsXzSrc55kVE3HGRp8BkRkP9c6CfgdOrgfCVyroGWH4CXsHK0&_nc_ht=scontent.oculuscdn.com&oh=9119d696eedcdf53f96cb31c1d17fafd&oe=5EA0A511', 29.99, '1970-01-18', 2840, 142, 0, 0, 'http://www.dancecentral.com/', 1, 1);
INSERT IGNORE INTO oculusdb.application (id, company, description, income_estimation, language, name, oculusdbid, picture, price, release_date, sales_estimations, total_reviews, type_of_app, type_of_gameplay, website, category_id, platform_id) VALUES (104, 'Cloudhead Games, Ltd.', 'Inspired by God-mode action movies like John Wick and Equilibrium, Pistol Whip puts you gun-first through an explosive batch of hand-crafted action scenes each set to their own pulse-pounding soundtrack. But unlike traditional music games, Pistol Whip has no line in the sand; you have complete freedom to shoot, melee, and dodge targets to the rhythm YOU see fit.

• Pair the pulse-pounding pace of an FPS with the flow-state energy of a music game in a cinematic symphony of violence.

• Form your rhythm and find your playstyle, from tactical to musical, then challenge your skill with friends and world leaderboards.

• Infiltrate a fever dream of hand-crafted scenes, from bank heists to android uprisings, each uniquely designed to music.

• Featuring EDM artists from Kannibalen Records, including Apashe, HVDES, and Black Tiger Sex Machine; with more to come...

• Pistol Whip is cross-buy enabled for Rift and Quest.', 802810, 'English', 'Pistol Whip', '2104963472963790', 'https://scontent.oculuscdn.com/v/t64.5771-25/q92/s2048x2048/38974643_490010415002535_6855805631723470848_n.jpg?_nc_cat=110&_nc_sid=79b88e&_nc_ohc=mX1jPjUU-10AX8diT7Q&_nc_ht=scontent.oculuscdn.com&oh=49ec2f5be46f2cbf07379bc7f3a8f370&oe=5EA0A863', 22.99, '1970-01-18', 34920, 1746, 0, 0, 'http://cloudheadgames.com/pistolwhip/', 1, 1);
INSERT IGNORE INTO oculusdb.application (id, company, description, income_estimation, language, name, oculusdbid, picture, price, release_date, sales_estimations, total_reviews, type_of_app, type_of_gameplay, website, category_id, platform_id) VALUES (105, 'SculptrVR, Inc.', 'Create smooth, polygonal, and cubey sculptures and worlds of any size. SculptrVR''s 10,000x zoom enables massive creations with tiny details! SculptrVR gives you almost unlimited space so your imagination is totally free!

SculptrVR’s intuitive and fun tools let your imagination turn into real creations.

Get a better view of your sculpted landscapes by Hang gliding through them.

Join an online game with 4 friends (cross platform with Go and Rift!) to build massive monuments together or have a sculpt-off!

When you''re happy with your creation, you can upload to the SculptrVR content gallery and let others see the incredible things you''ve made. You can also browse the gallery with hundreds of creations!

Creations made in SculptrVR can be exported to OBJ or FBX formats for 3D printing or sharing online!

In your world, anything is possible.', 22977, 'English', 'SculptrVR', '1978992975501648', 'https://scontent.oculuscdn.com/v/t64.5771-25/q92/s2048x2048/38974561_621234305285673_8048003890697732096_n.jpg?_nc_cat=105&_nc_sid=79b88e&_nc_oc=AQkOd_Nat5TExTIAyEddzuc-MmVXSBzgClkSu3nMzrAydnW5fvZjIy1CTiNp_jaLVuo&_nc_ht=scontent.oculuscdn.com&oh=483347ccf3319483a73e71bf7015f6cb&oe=5EA0F3D6', 9.99, '1970-01-18', 2300, 115, 0, 0, 'http://www.sculptrvr.com/', 1, 1);
INSERT IGNORE INTO oculusdb.application (id, company, description, income_estimation, language, name, oculusdbid, picture, price, release_date, sales_estimations, total_reviews, type_of_app, type_of_gameplay, website, category_id, platform_id) VALUES (106, 'Gravity Sketch', 'Gravity Sketch is an intuitive sketching experience giving you extensive access to tools for creative exploration. You can fully express your ideas in real-time at any scale, from initial conception to model. Create loose free form sketches, detailed models, expansive scenes, and artwork unrestricted.

Export your work as an image or model for use in other phases of your workflow. Gravity Sketch is a tool for the designer who makes every stroke count. Join the community of creatives defining new design workflows.

“The ability to start in 3D and stay in 3D has been the most transformative aspect of the workflow provided by Gravity Sketch, allowing me to create a 3D “napkin sketch” straight from my brain.”

      - Saiful Haque, Concept Artist, Avatar Sequels

- 6 Creation Tools
- 4 Creation Layers
- 4 Environments
- Image import (.jpg and .png)
- Snapshot Tool for quick image capture
- Export/Import .OBJ
- Upload to Landing Pad (a 3D Cloud file management Platform)', 57580, 'English', 'Gravity Sketch', '1587090851394426', 'https://scontent.oculuscdn.com/v/t64.5771-25/q92/s2048x2048/38974705_1273531666148327_7602878707115491328_n.jpg?_nc_cat=100&_nc_sid=79b88e&_nc_ohc=R_T21J2icYIAX9etYM8&_nc_ht=scontent.oculuscdn.com&oh=f6fbb13ae8836df2838cd33f34265fe9&oe=5E9FBFCB', 29.99, '1970-01-18', 1920, 96, 0, 0, 'https://www.gravitysketch.com/', 1, 1);
INSERT IGNORE INTO oculusdb.application (id, company, description, income_estimation, language, name, oculusdbid, picture, price, release_date, sales_estimations, total_reviews, type_of_app, type_of_gameplay, website, category_id, platform_id) VALUES (107, 'Lucky VR Inc.', 'PokerStars, the world’s leading poker brand, has combined live and online poker in a truly immersive VR experience.

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
INSERT IGNORE INTO oculusdb.application (id, company, description, income_estimation, language, name, oculusdbid, picture, price, release_date, sales_estimations, total_reviews, type_of_app, type_of_gameplay, website, category_id, platform_id) VALUES (108, 'ILMxLAB', 'Step inside a galaxy far, far away with Vader Immortal: Episode I. You are a smuggler operating near Mustafar, the fiery world Darth Vader calls home. When you are unexpectedly pulled out of hyperspace, you find yourself uncovering an ancient mystery at the behest of the Sith Lord himself.

With the help of your droid companion, ZO-E3, you’ll navigate the dangers of the fortress, hone your lightsaber skills, and meet new characters along the way as you discover what Vader is up to.

Also included with your purchase is Lightsaber Dojo, an open-ended training experience where you can hone your skills with the weapon of a Jedi Knight.

Starring Maya Rudolph, Vader Immortal is a canonical Star Wars adventure created by ILMxLAB and Lucasfilm in collaboration with Oculus Studios.', 548913, 'English', 'Vader Immortal: Episode I', '2108775495884888', 'https://scontent.oculuscdn.com/v/t64.5771-25/q92/s2048x2048/39031316_449628479134540_3043318202793721856_n.jpg?_nc_cat=105&_nc_sid=79b88e&_nc_ohc=vP4IpDBxL0sAX9Kpv3b&_nc_ht=scontent.oculuscdn.com&oh=de24cc3346a92f115f6d633037782cd6&oe=5E9EDAC0', 7.99, '1970-01-18', 68700, 3435, 0, 0, 'https://www.ilmxlab.com/', 1, 1);
INSERT IGNORE INTO oculusdb.application (id, company, description, income_estimation, language, name, oculusdbid, picture, price, release_date, sales_estimations, total_reviews, type_of_app, type_of_gameplay, website, category_id, platform_id) VALUES (109, 'Crytek', 'Feel the exhilaration of extreme free solo climbing. Experience the adrenaline rush as you ascend to epic heights, explore caves, and find shortcuts. Race against your friends’ routes to compete for the fastest times on leaderboards. Navigate and enjoy stunning landscapes from around the world, including the Alps, Southeast Asia, and the American Southwest.

Features:
- Free solo climbing:  Ascend to epic heights, explore caves, and find shortcuts
- Multiplayer and achievements: Race other players’ ghosts, rise up leaderboards and earn over 100 achievements to unlock gear.
- Bouldering: Beat intense routes that demand perfect technique.
- Tourist mode: Climb with simplified mechanics, ideal for introducing your friends to VR.
- Outstanding environments: Enjoy three beautiful, immersive locations by day or night.

Developed by Crytek and achieved with CRYENGINE.', 281906, 'English', 'The Climb', '2376737905701576', 'https://scontent.oculuscdn.com/v/t64.5771-25/q92/s2048x2048/75203615_471473166905415_8666801544387100672_n.jpg?_nc_cat=100&_nc_sid=79b88e&_nc_ohc=kwPykyCgxsUAX-osVUf&_nc_ht=scontent.oculuscdn.com&oh=923f7a176297a0b32cd2c13c42d02574&oe=5E9F525B', 29.99, '1970-01-18', 9400, 470, 0, 0, 'http://www.theclimbgame.com/', 1, 1);
INSERT IGNORE INTO oculusdb.application (id, company, description, income_estimation, language, name, oculusdbid, picture, price, release_date, sales_estimations, total_reviews, type_of_app, type_of_gameplay, website, category_id, platform_id) VALUES (112, 'Survios', '• Live Your Legacy: Challenge both your body and mind as you experience the ascent of Adonis Creed from undiscovered underdog to world-class fighter, all within an immersive universe inspired by the Creed™ films.

• Multiple Game Modes: Choose your path to glory in multiple game modes: story-driven Career, customizable Freeplay, or online PvP.

• Feel the Impact: Phantom Melee Technology mimics the real-life effects of throwing and taking punches in the ring, such as the out-of-body sensation of getting knocked out or the strain of fatigue during a long, frantic bout.

• Break Them―or Become Them: Play or fight the most iconic figures from the Creed™ and Rocky™ universe in Freeplay or PvP, including classic Rocky Balboa, Ivan and Viktor Drago, and more!

• Oculus Cross-Buy: Got CREED: Rise to Glory in your Rift library? Let the punches fly on Quest at no additional cost with complimentary cross-buy.', 269910, 'English', 'Creed: Rise to Glory', '2366245336750543', 'https://scontent.oculuscdn.com/v/t64.5771-25/q92/s2048x2048/38982692_458313288269493_3625162327235493888_n.jpg?_nc_cat=100&_nc_sid=79b88e&_nc_ohc=jeu6so0h5SAAX8dl5ng&_nc_ht=scontent.oculuscdn.com&oh=d3cd860098b0025df03dd756b0c6cf26&oe=5E9E350C', 29.99, '1970-01-18', 9000, 450, 0, 0, 'https://survios.com/creed/', 1, 1);
INSERT IGNORE INTO oculusdb.application (id, company, description, income_estimation, language, name, oculusdbid, picture, price, release_date, sales_estimations, total_reviews, type_of_app, type_of_gameplay, website, category_id, platform_id) VALUES (113, 'Oculus Studios Strike Team', 'Dead and Buried II is a fast-paced multiplayer shooter set in a supernatural western world. Grab your six-shooters and go head-to-head in various game modes. Compete against real players online to see who is the best gunslinger! The game is a sequel to the popular Dead and Buried released on Rift and GO.

Features:
- Competitive Modes: battle online in free-roaming Deathmatch or cover-based Shootout.
- Multiplayer Bots: never wait for players again! Bots will fill the game.
- Portable: with Quest, take the action on the go.
- Social: make new friends in the Town and spin up matches together.
- Weaponry: six-shooters, grenade launchers, and more!
- Future Plans: more events will be added to the Town over time so stay tuned!', 101948, 'English', 'Dead and Buried II', '2134077359973067', 'https://scontent.oculuscdn.com/v/t64.5771-25/q92/s2048x2048/38974680_316041692401259_7240568868186357760_n.jpg?_nc_cat=107&_nc_sid=79b88e&_nc_oc=AQkqhY_ScPCMYtrcMcwL-GCv2C_bsttFPBKFU-A6XpCB96ciXnH4yc4naFnUeFH7JQo&_nc_ht=scontent.oculuscdn.com&oh=19f524003f15ee2a9f0239ab553a02b0&oe=5E9E7B58', 19.99, '1970-01-18', 5100, 255, 0, 0, 'http://www.oculus.com/', 1, 1);
INSERT IGNORE INTO oculusdb.application (id, company, description, income_estimation, language, name, oculusdbid, picture, price, release_date, sales_estimations, total_reviews, type_of_app, type_of_gameplay, website, category_id, platform_id) VALUES (115, 'Owlchemy Labs', 'In a world where robots have replaced all human jobs, step into the "Job Simulator" to learn what it was like ''to do the job''.

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

INSERT IGNORE INTO oculusdb.administrator (id, email, name, password, surname, username) VALUES (1, 'pedro_admin@gmail.com', 'Pedro', '$2a$10$J1Av8xN3HaF8KZxiYvmOXels/.CmzkntgCizGreqoRqvNNTJukiiu', 'Rodríguez', 'administrator');
INSERT IGNORE INTO administrator_roles(administrator_id,roles_id) VALUES (1,1);
--Comments

INSERT IGNORE INTO comments VALUES (1, 'This game is awesome!', 'Perfect', 1);
INSERT IGNORE INTO comments VALUES (2, 'This game is a shit', 'Bad', 3);
INSERT IGNORE INTO comments VALUES (3, 'Best game in the world', 'Incredible', 2);
INSERT IGNORE INTO comments VALUES (4, 'I think that is a very good game', 'Very good', 2);
INSERT IGNORE INTO comments VALUES (5, 'I regret buying it', 'Bad', 3);
INSERT IGNORE INTO comments VALUES (6, 'Very good game', 'Very good', 4);
INSERT IGNORE INTO comments VALUES (7, 'I did not like it to much', 'Regular', 2);
INSERT IGNORE INTO comments VALUES (8, 'The best game ever!', 'Perfect', 4);
INSERT IGNORE INTO comments VALUES (9, 'What a scam', 'Very bad', 5);
INSERT IGNORE INTO comments VALUES (10, 'Awesome!!', 'Incredible', 6);
INSERT IGNORE INTO comments VALUES (11, 'Disappointing the truth', 'Bad', 5);
INSERT IGNORE INTO comments VALUES (12, 'To play all day!', 'Perfect', 7);
INSERT IGNORE INTO comments VALUES (13, 'I dont like', 'Bad', 8);
INSERT IGNORE INTO comments VALUES (14, '...', 'Regular', 9);

--Developer

INSERT IGNORE INTO oculusdb.developer(id,username,password,name,surname,email,company,webpage,company_description) VALUES (1,'miguel','miguel','Miguel', 'López', 'miguel1@Miguel','Microsoft','http://www.microsoft.com','Be whats next');
INSERT IGNORE INTO developer_roles(developer_id,roles_id) VALUES (1,3);

--Reviews

INSERT IGNORE INTO reviews VALUES (1, 'perfect videogame', 170, '17/02/2020', 'review 1', TRUE, 1);
INSERT IGNORE INTO reviews VALUES (2, 'could be better', 16, '27/01/2020', 'review 2', TRUE, 2);
INSERT IGNORE INTO reviews VALUES (3, 'incredible videogame', 207, '17/01/2020', 'review 3', TRUE, 3);

--Sponsor

INSERT IGNORE INTO oculusdb.sponsors(id,username,password,name,surname,email) VALUES (1,'miguel','miguel','Miguel', 'López', 'miguel1@Miguel');
INSERT IGNORE INTO sponsors_roles(sponsor_id,roles_id) VALUES (1,4);

--Sponsorship

INSERT IGNORE INTO sponsorship VALUES (1, 'http://www.miguel.com', 'miguel', 1);

--Favorites
INSERT IGNORE INTO oculusdb.users_favorites (user_id, favorites_id) VALUES (2, 2);
INSERT IGNORE INTO oculusdb.users_favorites (user_id, favorites_id) VALUES (2, 4);
INSERT IGNORE INTO oculusdb.users_favorites (user_id, favorites_id) VALUES (2, 7);
INSERT IGNORE INTO oculusdb.users_favorites (user_id, favorites_id) VALUES (2, 8);
INSERT IGNORE INTO oculusdb.users_favorites (user_id, favorites_id) VALUES (3, 3);
INSERT IGNORE INTO oculusdb.users_favorites (user_id, favorites_id) VALUES (3, 5);
INSERT IGNORE INTO oculusdb.users_favorites (user_id, favorites_id) VALUES (4, 9);
INSERT IGNORE INTO oculusdb.users_favorites (user_id, favorites_id) VALUES (5, 10);
INSERT IGNORE INTO oculusdb.users_favorites (user_id, favorites_id) VALUES (6, 11);
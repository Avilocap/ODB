
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
INSERT IGNORE INTO oculusdb.users (id, email, name, password, surname, username,premium,active) VALUES (100, 'testuser@gmail.com', 'User', '$2a$10$aqRkmFNk6QGlOmbk.xy7puTC7Y1DmHQayZBYGUghMEbkus.7vwT0K', 'Test', 'testuser',true,true);
INSERT IGNORE INTO oculusdb.users (id, email, name, password, surname, username,premium,active) VALUES (102, 'josema@gmail.com', 'josema', '$2a$10$aqRkmFNk6QGlOmbk.xy7puTC7Y1DmHQayZBYGUghMEbkus.7vwT0K', 'josema', 'josema',false,true);
INSERT IGNORE INTO oculusdb.users (id, email, name, password, surname, username,premium,active) VALUES (103, 'manu@gmail.com', 'manu', '$2a$10$aqRkmFNk6QGlOmbk.xy7puTC7Y1DmHQayZBYGUghMEbkus.7vwT0K', 'manu', 'manu',false,false);
INSERT IGNORE INTO oculusdb.users (id, email, name, password, surname, username,premium,active) VALUES (104, 'adri@gmail.com', 'adri', '$2a$10$aqRkmFNk6QGlOmbk.xy7puTC7Y1DmHQayZBYGUghMEbkus.7vwT0K', 'adri', 'adri',false,true);
INSERT IGNORE INTO oculusdb.users (id, email, name, password, surname, username,premium,active) VALUES (105, 'miguel@gmail.com', 'miguel', '$2a$10$aqRkmFNk6QGlOmbk.xy7puTC7Y1DmHQayZBYGUghMEbkus.7vwT0K', 'miguel', 'miguel',false,true);
INSERT IGNORE INTO oculusdb.users (id, email, name, password, surname, username,premium,active) VALUES (106, 'david@gmail.com', 'david', '$2a$10$aqRkmFNk6QGlOmbk.xy7puTC7Y1DmHQayZBYGUghMEbkus.7vwT0K', 'david', 'david',false,true);

--Users roles

INSERT IGNORE INTO oculusdb.users_roles (users_id, roles_id) VALUES (100, 2);
INSERT IGNORE INTO oculusdb.users_roles (users_id, roles_id) VALUES (100, 1);
INSERT IGNORE INTO oculusdb.users_roles (users_id, roles_id) VALUES (100, 3);
INSERT IGNORE INTO oculusdb.users_roles (users_id, roles_id) VALUES (102, 2);
INSERT IGNORE INTO oculusdb.users_roles (users_id, roles_id) VALUES (103, 2);
INSERT IGNORE INTO oculusdb.users_roles (users_id, roles_id) VALUES (104, 2);
INSERT IGNORE INTO oculusdb.users_roles (users_id, roles_id) VALUES (105, 2);
INSERT IGNORE INTO oculusdb.users_roles (users_id, roles_id) VALUES (106, 2);
--Credit cards

INSERT IGNORE INTO credit_cards VALUES (1, 123, 12, 2022, 'Pedro Rodríguez', 123456);
INSERT IGNORE INTO credit_cards VALUES (2, 456, 5, 2024, 'Manuel Jiménez', 256478);
INSERT IGNORE INTO credit_cards VALUES (3, 789, 7, 2023, 'Antonio Ruiz', 338976);
INSERT IGNORE INTO credit_cards VALUES (4, 678, 3, 2022, 'Miguel López', 354789);

--Applications
INSERT IGNORE INTO oculusdb.application (id, company, description, income_estimation, language, name, oculusdbid, picture, price, release_date, sales_estimations, total_reviews, type_of_app, type_of_gameplay, website, category_id, platform_id) VALUES (100, 'Ready At Dawn', 'In Lone Echo’s single player story, you’ll be transported to an advanced mining facility within the rings of Saturn, complete with a detailed space station, expansive outer-space environments, and interactive space equipment. Taking on the role of Jack—an advanced artificial intelligence with a state-of-the-art synthetic body—you’ll help Captain Olivia Rhodes solve an increasingly threatening mystery as you use futuristic tools, clever problem solving, and interactive dialogue to engage with the world around you. Taking advantage of the Oculus Touch controllers and full 360° gameplay, Lone Echo lets you take a hands-on approach to exploring space unlike anything you’ve ever played before.', 1146113, 'English', 'Lone Echo', '1368187813209608', 'https://scontent.oculuscdn.com/v/t64.5771-25/q92/s2048x2048/11162690_1597657833600851_7686325918767251456_n.jpg?_nc_cat=102&_nc_sid=79b88e&_nc_oc=AQlt5nkYVLclmlR0NbrIigwMWaipjvOVt4Vrcmr18bbvGDwDXDuuLAWwMOo3Qy-hlXA&_nc_ht=scontent.oculuscdn.com&oh=5ddef68832bd6c79f740ef8c917058af&oe=5EF96EF6', 39.99, '1970-01-17', 28660, 1433, 0, 0, 'https://www.oculus.com/lone-echo', 1, 1);
INSERT IGNORE INTO oculusdb.application (id, company, description, income_estimation, language, name, oculusdbid, picture, price, release_date, sales_estimations, total_reviews, type_of_app, type_of_gameplay, website, category_id, platform_id) VALUES (101, 'Roman Rekhler, Hamzeh Alsalhi, Oscar Vazquez', 'The ultimate Table Tennis simulator. Play opponents in online multiplayer or practice against the advanced AI. With physics designed to be as real as ever achieved in a Table Tennis simulator, you will forget you are in VR.', 131134, 'English', 'Eleven Table Tennis', '1995434190525828', 'https://scontent.oculuscdn.com/v/t64.5771-25/q92/s2048x2048/12138787_397652287332883_6859294360643567616_n.jpg?_nc_cat=104&_nc_sid=79b88e&_nc_oc=AQn1fIeU0uUCgxYey9WWi0Ge3C4cYJ5D0gK64Bav6th0FkP9noyuBL-BznN7bU5A6Kk&_nc_ht=scontent.oculuscdn.com&oh=77fe9b8c868ba462a6ab4e0f8852e55c&oe=5EF9C0FD', 19.99, '1970-01-18', 6560, 328, 0, 0, 'https://forfunlabs.github.io/', 1, 1);
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

Find your happy place.™', 26773, 'English', 'Guided Tai Chi', '1756328964489238', 'https://scontent.oculuscdn.com/v/t64.5771-25/q92/s2048x2048/12386220_143524359834998_6551966043043004416_n.jpg?_nc_cat=111&_nc_sid=79b88e&_nc_oc=AQk1hOCGzQH8UNRMwuk_a4-mvbaFHAkKDBSEZn-rlfj2aHux7aRPEE3WEtS9CoWLou4&_nc_ht=scontent.oculuscdn.com&oh=4f8926c80a1301632c3df828a296800e&oe=5EFA5341', 9.99, '1970-01-18', 2680, 134, 0, 0, 'http://guidedtaichi.com/', 1, 1);
INSERT IGNORE INTO oculusdb.application (id, company, description, income_estimation, language, name, oculusdbid, picture, price, release_date, sales_estimations, total_reviews, type_of_app, type_of_gameplay, website, category_id, platform_id) VALUES (103, 'Harmonix Music Systems, Inc.', 'Dance Central™ is back! Designed from the ground up for VR, Dance Central immerses you and your friends in the world’s best dance club experience where you are the life of the party and nobody steps on your toes.

Dance Central includes a 32 song soundtrack featuring chart-toppers from the 1970s through to today’s biggest hits. With two difficulty levels and unique routines choreographed for each song, there’s plenty to keep you dancing all night.

Dance Central also features the franchise’s first dive into synchronous online multiplayer. Customize your look, take an in-game selfie and then meet up with friends in the multiplayer lounge to party, chat, and dance your hearts out. With cross-play, you can compete against your friends on both the Oculus Quest and Rift Platform in free-for-all or team dance games to see who''s the best in the crew.

Dance Central supports cross-buy. Buy once, play on both Oculus Quest and Rift Platform.', 85171, 'English', 'Dance Central', '2453152771391571', 'https://scontent.oculuscdn.com/v/t64.5771-25/q92/s2048x2048/38974827_1487170064787448_4047610027660279808_n.jpg?_nc_cat=111&_nc_sid=79b88e&_nc_oc=AQnjzpCX8eJZwry3nkFwMUpq669G_HhEE0ebbDL9tGVngwn36ea7FiZmXb1GYcet6hE&_nc_ht=scontent.oculuscdn.com&oh=6f3c2ba32963f5384537f83eb96c3b89&oe=5EFADF95', 29.99, '1970-01-18', 2840, 142, 0, 0, 'http://www.dancecentral.com/', 1, 1);
INSERT IGNORE INTO oculusdb.application (id, company, description, income_estimation, language, name, oculusdbid, picture, price, release_date, sales_estimations, total_reviews, type_of_app, type_of_gameplay, website, category_id, platform_id) VALUES (104, 'Cloudhead Games, Ltd.', 'Inspired by God-mode action movies like John Wick and Equilibrium, Pistol Whip puts you gun-first through an explosive batch of hand-crafted action scenes each set to their own pulse-pounding soundtrack. But unlike traditional music games, Pistol Whip has no line in the sand; you have complete freedom to shoot, melee, and dodge targets to the rhythm YOU see fit.

• Pair the pulse-pounding pace of an FPS with the flow-state energy of a music game in a cinematic symphony of violence.

• Form your rhythm and find your playstyle, from tactical to musical, then challenge your skill with friends and world leaderboards.

• Infiltrate a fever dream of hand-crafted scenes, from bank heists to android uprisings, each uniquely designed to music.

• Featuring EDM artists from Kannibalen Records, including Apashe, HVDES, and Black Tiger Sex Machine; with more to come...

• Pistol Whip is cross-buy enabled for Rift and Quest.', 802810, 'English', 'Pistol Whip', '2104963472963790', 'https://scontent.oculuscdn.com/v/t64.5771-25/q92/s2048x2048/75443251_660774431425867_1464881918666342400_n.jpg?_nc_cat=108&_nc_sid=79b88e&_nc_oc=AQmJhe5GOmbdkGufisENz9h43daPGzDjEXv-V3vikGhyszZ_EJ0bn8GeVUlM75ridRM&_nc_ht=scontent.oculuscdn.com&oh=addd76f9b5e7c17cf2887f74466c766c&oe=5EFAA8AA', 22.99, '1970-01-18', 34920, 1746, 0, 0, 'http://cloudheadgames.com/pistolwhip/', 1, 1);
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
- Upload to Landing Pad (a 3D Cloud file management Platform)', 57580, 'English', 'Gravity Sketch', '1587090851394426', 'https://scontent.oculuscdn.com/v/t64.5771-25/q92/s2048x2048/38984453_646356645846950_4132124650354245632_n.jpg?_nc_cat=111&_nc_sid=79b88e&_nc_oc=AQn1AZaTJFL5069iQ03mvB9D56S4-QlNpRz73eBZF32KrkEoUN0gMlJpqm10_LkvCHc&_nc_ht=scontent.oculuscdn.com&oh=4c7e46cee8ce3bea65694c3ccc8e6259&oe=5EF9B28', 29.99, '1970-01-18', 1920, 96, 0, 0, 'https://www.gravitysketch.com/', 1, 1);
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
-The Void', 536565, 'English', 'PokerStars VR', '2370815932930055', 'https://scontent.oculuscdn.com/v/t64.5771-25/q92/s2048x2048/39031478_1870303549768437_6777727897990856704_n.jpg?_nc_cat=102&_nc_sid=79b88e&_nc_oc=AQlp8Iu_RSAj0Km3zNnxHNuqm7oaTY8hlzXYTCwALNrzV9ROOAYcC9VbIRPbS1DML8o&_nc_ht=scontent.oculuscdn.com&oh=5c6cfc9b61e6cb8bc66497e7328a703c&oe=5EF9E873', 29.99, '1970-01-18', 7960, 398, 0, 0, 'http://www.starsgroup.com/', 1, 1);
INSERT IGNORE INTO oculusdb.application (id, company, description, income_estimation, language, name, oculusdbid, picture, price, release_date, sales_estimations, total_reviews, type_of_app, type_of_gameplay, website, category_id, platform_id) VALUES (108, 'ILMxLAB', 'Step inside a galaxy far, far away with Vader Immortal: Episode I. You are a smuggler operating near Mustafar, the fiery world Darth Vader calls home. When you are unexpectedly pulled out of hyperspace, you find yourself uncovering an ancient mystery at the behest of the Sith Lord himself.

With the help of your droid companion, ZO-E3, you’ll navigate the dangers of the fortress, hone your lightsaber skills, and meet new characters along the way as you discover what Vader is up to.

Also included with your purchase is Lightsaber Dojo, an open-ended training experience where you can hone your skills with the weapon of a Jedi Knight.

Starring Maya Rudolph, Vader Immortal is a canonical Star Wars adventure created by ILMxLAB and Lucasfilm in collaboration with Oculus Studios.', 548913, 'English', 'Vader Immortal: Episode I', '2108775495884888', 'https://scontent.oculuscdn.com/v/t64.5771-25/q92/s2048x2048/38974628_306371630277839_4327178799100723200_n.jpg?_nc_cat=110&_nc_sid=79b88e&_nc_oc=AQmMiLyFqbjQOJIruRNu8j7zoAUdKa8kJfVjfWYEcB8IzbLufjP_s42NUkRyPg9p5LY&_nc_ht=scontent.oculuscdn.com&oh=52c8edba4a53300bf87c60250ebee88a&oe=5EFBB145', 7.99, '1970-01-18', 68700, 3435, 0, 0, 'https://www.ilmxlab.com/', 1, 1);
INSERT IGNORE INTO oculusdb.application (id, company, description, income_estimation, language, name, oculusdbid, picture, price, release_date, sales_estimations, total_reviews, type_of_app, type_of_gameplay, website, category_id, platform_id) VALUES (109, 'Crytek', 'Feel the exhilaration of extreme free solo climbing. Experience the adrenaline rush as you ascend to epic heights, explore caves, and find shortcuts. Race against your friends’ routes to compete for the fastest times on leaderboards. Navigate and enjoy stunning landscapes from around the world, including the Alps, Southeast Asia, and the American Southwest.

Features:
- Free solo climbing:  Ascend to epic heights, explore caves, and find shortcuts
- Multiplayer and achievements: Race other players’ ghosts, rise up leaderboards and earn over 100 achievements to unlock gear.
- Bouldering: Beat intense routes that demand perfect technique.
- Tourist mode: Climb with simplified mechanics, ideal for introducing your friends to VR.
- Outstanding environments: Enjoy three beautiful, immersive locations by day or night.

Developed by Crytek and achieved with CRYENGINE.', 281906, 'English', 'The Climb', '2376737905701576', 'https://scontent.oculuscdn.com/v/t64.5771-25/q92/s2048x2048/12410459_1367847169915669_8090052140216614912_n.jpg?_nc_cat=105&_nc_sid=79b88e&_nc_oc=AQmowYhpYnWL7eaQFbIeY3uB2N5aiP5v_dfSQCfAzZy_D5ESM5WYaHTw7WRE1lijhuU&_nc_ht=scontent.oculuscdn.com&oh=87ae9ef489509165aae2208007eab1fa&oe=5EFC475B', 29.99, '1970-01-18', 9400, 470, 0, 0, 'http://www.theclimbgame.com/', 1, 1);
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
- Future Plans: more events will be added to the Town over time so stay tuned!', 101948, 'English', 'Dead and Buried II', '2134077359973067', 'https://scontent.oculuscdn.com/v/t64.5771-25/q92/s2048x2048/75458099_912948675824691_581432898503049216_n.jpg?_nc_cat=103&_nc_sid=79b88e&_nc_oc=AQmniXMSxxON_qukpxqB-LPBOMq0jlIzyFE9OzBmHpGtZsRbQMaMG-ALmMZUFsjTwBQ&_nc_ht=scontent.oculuscdn.com&oh=fab7d5e3ed7f9491643f319233b7d468&oe=5EF8FF4E', 19.99, '1970-01-18', 5100, 255, 0, 0, 'http://www.oculus.com/', 1, 1);
INSERT IGNORE INTO oculusdb.application (id, company, description, income_estimation, language, name, oculusdbid, picture, price, release_date, sales_estimations, total_reviews, type_of_app, type_of_gameplay, website, category_id, platform_id) VALUES (115, 'Owlchemy Labs', 'In a world where robots have replaced all human jobs, step into the "Job Simulator" to learn what it was like ''to do the job''.

Players can relive the glory days of work by simulating the ins and outs of being a gourmet chef, an office worker, a convenience store clerk, and more.

Key Jobbing Features:
●	Throw a stapler at your boss!
●	Learn to ''job'' in four not-so historically accurate representations of work-life before society was automated by robots!
●	Use your hands to stack, manipulate, throw, and smash physics objects in an inexplicably satisfying way!
●	Aggressively chug coffee and eat questionable food from the trash!
●	Able to juggle tomatoes in real life? Do it in VR! Unable to juggle? There''s no cleanup required in VR!
●	Gain valuable life experience by firing new employees, serving slushy treats, brewing English tea, and ripping apart car engines!
●	Work the never-ending night shift with Infinite Overtime mode!', 476502, 'English', 'Job Simulator', '3235570703151406', 'https://scontent.oculuscdn.com/v/t64.5771-25/q92/s2048x2048/39031561_2736314553258894_7276541298054529024_n.jpg?_nc_cat=101&_nc_sid=79b88e&_nc_oc=AQmMBe1cwj1t6h1D6_iCgQFxAII3yG3wKJ_4OMDFuL2t9vO8u21fwAQqhuHbpkLQnzM&_nc_ht=scontent.oculuscdn.com&oh=7c16d238252ac250ad3b84d212a520f9&oe=5EFBB5FC', 15.99, '1970-01-18', 29800, 1490, 0, 0, 'http://jobsimulatorgame.com/', 1, 1);

--Administrator

INSERT IGNORE INTO oculusdb.administrator (id, email, name, password, surname, username) VALUES (1, 'pedro_admin@gmail.com', 'Pedro', '$2a$10$J1Av8xN3HaF8KZxiYvmOXels/.CmzkntgCizGreqoRqvNNTJukiiu', 'Rodríguez', 'administrator');
INSERT IGNORE INTO administrator_roles(administrator_id,roles_id) VALUES (1,1);
--Comments

-- Reviews
INSERT IGNORE INTO oculusdb.reviews (id,oculus_id,title,content,publish_date) values (6000, '3452346523456','Review Title 1', 'Review Content 1', '1970-01-18');

INSERT IGNORE INTO comments VALUES (1001, 'This game is awesome!', 'Perfect', 100, 100);
INSERT IGNORE INTO comments VALUES (1002, 'This game is a shit', 'Bad', 101, 100);
INSERT IGNORE INTO comments VALUES (1003, 'Best game in the world', 'Incredible', 102, 102);
INSERT IGNORE INTO comments VALUES (1004, 'I think that is a very good game', 'Very good', 103, 103);
INSERT IGNORE INTO comments VALUES (1005, 'I regret buying it', 'Bad', 104, 104);
INSERT IGNORE INTO comments VALUES (1006, 'Very good game', 'Very good', 105, 105);
INSERT IGNORE INTO comments VALUES (1007, 'I did not like it to much', 'Regular', 106, 106);
INSERT IGNORE INTO comments VALUES (1008, 'The best game ever!', 'Perfect', 107, 100);
INSERT IGNORE INTO comments VALUES (1009, 'What a scam', 'Very bad', 108, 102);
INSERT IGNORE INTO comments VALUES (10010, 'Awesome!!', 'Incredible', 109, 103);
INSERT IGNORE INTO comments VALUES (10011, 'Disappointing the truth', 'Bad', 110, 104);
INSERT IGNORE INTO comments VALUES (10012, 'To play all day!', 'Perfect', 111, 105);
INSERT IGNORE INTO comments VALUES (10013, 'I dont like', 'Bad', 112, 106);
INSERT IGNORE INTO comments VALUES (10014, '...', 'Regular', 113, 100);


--Developer

INSERT IGNORE INTO oculusdb.developer(id,username,password,name,surname,email,company,webpage,company_description) VALUES (1,'miguel','miguel','Miguel', 'López', 'miguel1@Miguel','Microsoft','http://www.microsoft.com','Be whats next');
-- INSERT IGNORE INTO developer_roles(developer_id,roles_id) VALUES (1,3);

--Sponsor

INSERT IGNORE INTO sponsors (id, email, name, password, surname, username, credit_card_id) VALUES
	(100, 'testsponsor@gmail.com ', 'testsponsor', 'testsponsor', 'testsponsor', 'testsponsor', 1);

--Sponsorship

INSERT IGNORE INTO sponsorship(id, attachmenturl, title, user_id) VALUES (115, 'http://www.miguel.com', 'miguel', 100);

INSERT IGNORE INTO oculusdb.users_sponsorships (user_id, sponsorships_id) VALUES (100, 115);

--Favorites
INSERT IGNORE INTO oculusdb.users_favorites (user_id, favorites_id) VALUES (100, 100);
INSERT IGNORE INTO oculusdb.users_favorites (user_id, favorites_id) VALUES (102, 104);
INSERT IGNORE INTO oculusdb.users_favorites (user_id, favorites_id) VALUES (102, 107);
INSERT IGNORE INTO oculusdb.users_favorites (user_id, favorites_id) VALUES (102, 108);
INSERT IGNORE INTO oculusdb.users_favorites (user_id, favorites_id) VALUES (103, 103);
INSERT IGNORE INTO oculusdb.users_favorites (user_id, favorites_id) VALUES (103, 105);
INSERT IGNORE INTO oculusdb.users_favorites (user_id, favorites_id) VALUES (104, 109);
INSERT IGNORE INTO oculusdb.users_favorites (user_id, favorites_id) VALUES (105, 112);
INSERT IGNORE INTO oculusdb.users_favorites (user_id, favorites_id) VALUES (106, 113);
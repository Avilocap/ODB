
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
INSERT IGNORE INTO oculusdb.application (id, company, description, income_estimation, language, name, oculusdbid, picture, price, release_date, sales_estimations, total_reviews, type_of_app, type_of_gameplay, website, category_id, platform_id) VALUES (100, 'Ready At Dawn', 'In Lone Echo’s single player story, you’ll be transported to an advanced mining facility within the rings of Saturn, complete with a detailed space station, expansive outer-space environments, and interactive space equipment. Taking on the role of Jack—an advanced artificial intelligence with a state-of-the-art synthetic body—you’ll help Captain Olivia Rhodes solve an increasingly threatening mystery as you use futuristic tools, clever problem solving, and interactive dialogue to engage with the world around you. Taking advantage of the Oculus Touch controllers and full 360° gameplay, Lone Echo lets you take a hands-on approach to exploring space unlike anything you’ve ever played before.', 1146113, 'English', 'Lone Echo', '1368187813209608', 'https://www.desconsolados.com/wp-content/uploads/2019/04/lone_echo.jpg', 39.99, '1970-01-17', 28660, 1433, 0, 0, 'https://www.oculus.com/lone-echo', 1, 1);
INSERT IGNORE INTO oculusdb.application (id, company, description, income_estimation, language, name, oculusdbid, picture, price, release_date, sales_estimations, total_reviews, type_of_app, type_of_gameplay, website, category_id, platform_id) VALUES (101, 'Roman Rekhler, Hamzeh Alsalhi, Oscar Vazquez', 'The ultimate Table Tennis simulator. Play opponents in online multiplayer or practice against the advanced AI. With physics designed to be as real as ever achieved in a Table Tennis simulator, you will forget you are in VR.', 131134, 'English', 'Eleven Table Tennis', '1995434190525828', 'https://www.realovirtual.com/thumb/904x387x1/pictures/2020/03/1_Eleven_Table_Tenis_VR.jpg', 19.99, '1970-01-18', 6560, 328, 0, 0, 'https://forfunlabs.github.io/', 1, 1);
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

Find your happy place.™', 26773, 'English', 'Guided Tai Chi', '1756328964489238', 'https://www.realovirtual.com/files/images/14001-15000/14236/5ce3381c00672.jpeg', 9.99, '1970-01-18', 2680, 134, 0, 0, 'http://guidedtaichi.com/', 1, 1);
INSERT IGNORE INTO oculusdb.application (id, company, description, income_estimation, language, name, oculusdbid, picture, price, release_date, sales_estimations, total_reviews, type_of_app, type_of_gameplay, website, category_id, platform_id) VALUES (103, 'Harmonix Music Systems, Inc.', 'Dance Central™ is back! Designed from the ground up for VR, Dance Central immerses you and your friends in the world’s best dance club experience where you are the life of the party and nobody steps on your toes.

Dance Central includes a 32 song soundtrack featuring chart-toppers from the 1970s through to today’s biggest hits. With two difficulty levels and unique routines choreographed for each song, there’s plenty to keep you dancing all night.

Dance Central also features the franchise’s first dive into synchronous online multiplayer. Customize your look, take an in-game selfie and then meet up with friends in the multiplayer lounge to party, chat, and dance your hearts out. With cross-play, you can compete against your friends on both the Oculus Quest and Rift Platform in free-for-all or team dance games to see who''s the best in the crew.

Dance Central supports cross-buy. Buy once, play on both Oculus Quest and Rift Platform.', 85171, 'English', 'Dance Central', '2453152771391571', 'https://www.desconsolados.com/wp-content/uploads/2019/03/Dance-Central.jpg', 29.99, '1970-01-18', 2840, 142, 0, 0, 'http://www.dancecentral.com/', 1, 1);
INSERT IGNORE INTO oculusdb.application (id, company, description, income_estimation, language, name, oculusdbid, picture, price, release_date, sales_estimations, total_reviews, type_of_app, type_of_gameplay, website, category_id, platform_id) VALUES (104, 'Cloudhead Games, Ltd.', 'Inspired by God-mode action movies like John Wick and Equilibrium, Pistol Whip puts you gun-first through an explosive batch of hand-crafted action scenes each set to their own pulse-pounding soundtrack. But unlike traditional music games, Pistol Whip has no line in the sand; you have complete freedom to shoot, melee, and dodge targets to the rhythm YOU see fit.

• Pair the pulse-pounding pace of an FPS with the flow-state energy of a music game in a cinematic symphony of violence.

• Form your rhythm and find your playstyle, from tactical to musical, then challenge your skill with friends and world leaderboards.

• Infiltrate a fever dream of hand-crafted scenes, from bank heists to android uprisings, each uniquely designed to music.

• Featuring EDM artists from Kannibalen Records, including Apashe, HVDES, and Black Tiger Sex Machine; with more to come...

• Pistol Whip is cross-buy enabled for Rift and Quest.', 802810, 'English', 'Pistol Whip', '2104963472963790', 'https://thecouch.world/wp-content/uploads/2020/02/test-pistol-whip-e1573322872841.jpg', 22.99, '1970-01-18', 34920, 1746, 0, 0, 'http://cloudheadgames.com/pistolwhip/', 1, 1);
INSERT IGNORE INTO oculusdb.application (id, company, description, income_estimation, language, name, oculusdbid, picture, price, release_date, sales_estimations, total_reviews, type_of_app, type_of_gameplay, website, category_id, platform_id) VALUES (105, 'SculptrVR, Inc.', 'Create smooth, polygonal, and cubey sculptures and worlds of any size. SculptrVR''s 10,000x zoom enables massive creations with tiny details! SculptrVR gives you almost unlimited space so your imagination is totally free!

SculptrVR’s intuitive and fun tools let your imagination turn into real creations.

Get a better view of your sculpted landscapes by Hang gliding through them.

Join an online game with 4 friends (cross platform with Go and Rift!) to build massive monuments together or have a sculpt-off!

When you''re happy with your creation, you can upload to the SculptrVR content gallery and let others see the incredible things you''ve made. You can also browse the gallery with hundreds of creations!

Creations made in SculptrVR can be exported to OBJ or FBX formats for 3D printing or sharing online!

In your world, anything is possible.', 22977, 'English', 'SculptrVR', '1978992975501648', 'https://www.realovirtual.com/files/images/14001-15000/14986/5d69064b957e1.jpeg', 9.99, '1970-01-18', 2300, 115, 0, 0, 'http://www.sculptrvr.com/', 1, 1);
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
- Upload to Landing Pad (a 3D Cloud file management Platform)', 57580, 'English', 'Gravity Sketch', '1587090851394426', 'https://steamcdn-a.akamaihd.net/steam/apps/551370/capsule_616x353.jpg?t=1536492162', 29.99, '1970-01-18', 1920, 96, 0, 0, 'https://www.gravitysketch.com/', 1, 1);
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
-The Void', 536565, 'English', 'PokerStars VR', '2370815932930055', 'https://www.realovirtual.com/files/images/14001-15000/14215/5ce337f9cf182.jpeg', 29.99, '1970-01-18', 7960, 398, 0, 0, 'http://www.starsgroup.com/', 1, 1);
INSERT IGNORE INTO oculusdb.application (id, company, description, income_estimation, language, name, oculusdbid, picture, price, release_date, sales_estimations, total_reviews, type_of_app, type_of_gameplay, website, category_id, platform_id) VALUES (108, 'ILMxLAB', 'Step inside a galaxy far, far away with Vader Immortal: Episode I. You are a smuggler operating near Mustafar, the fiery world Darth Vader calls home. When you are unexpectedly pulled out of hyperspace, you find yourself uncovering an ancient mystery at the behest of the Sith Lord himself.

With the help of your droid companion, ZO-E3, you’ll navigate the dangers of the fortress, hone your lightsaber skills, and meet new characters along the way as you discover what Vader is up to.

Also included with your purchase is Lightsaber Dojo, an open-ended training experience where you can hone your skills with the weapon of a Jedi Knight.

Starring Maya Rudolph, Vader Immortal is a canonical Star Wars adventure created by ILMxLAB and Lucasfilm in collaboration with Oculus Studios.', 548913, 'English', 'Vader Immortal: Episode I', '2108775495884888', 'https://www.lavanguardia.com/r/GODO/LV/p6/WebSite/2019/04/15/Recortada/img_dmolina_20190415-175130_imagenes_lv_terceros_vaderimmortal_episode1_vader1-kwVG-U4616678307320cE-992x558@LaVanguardia-Web.jpg', 7.99, '1970-01-18', 68700, 3435, 0, 0, 'https://www.ilmxlab.com/', 1, 1);
INSERT IGNORE INTO oculusdb.application (id, company, description, income_estimation, language, name, oculusdbid, picture, price, release_date, sales_estimations, total_reviews, type_of_app, type_of_gameplay, website, category_id, platform_id) VALUES (109, 'Crytek', 'Feel the exhilaration of extreme free solo climbing. Experience the adrenaline rush as you ascend to epic heights, explore caves, and find shortcuts. Race against your friends’ routes to compete for the fastest times on leaderboards. Navigate and enjoy stunning landscapes from around the world, including the Alps, Southeast Asia, and the American Southwest.

Features:
- Free solo climbing:  Ascend to epic heights, explore caves, and find shortcuts
- Multiplayer and achievements: Race other players’ ghosts, rise up leaderboards and earn over 100 achievements to unlock gear.
- Bouldering: Beat intense routes that demand perfect technique.
- Tourist mode: Climb with simplified mechanics, ideal for introducing your friends to VR.
- Outstanding environments: Enjoy three beautiful, immersive locations by day or night.

Developed by Crytek and achieved with CRYENGINE.', 281906, 'English', 'The Climb', '2376737905701576', 'https://i.pinimg.com/originals/ca/45/3f/ca453f7c155828620d2043dc3a4c6da7.png', 29.99, '1970-01-18', 9400, 470, 0, 0, 'http://www.theclimbgame.com/', 1, 1);
INSERT IGNORE INTO oculusdb.application (id, company, description, income_estimation, language, name, oculusdbid, picture, price, release_date, sales_estimations, total_reviews, type_of_app, type_of_gameplay, website, category_id, platform_id) VALUES (112, 'Survios', '• Live Your Legacy: Challenge both your body and mind as you experience the ascent of Adonis Creed from undiscovered underdog to world-class fighter, all within an immersive universe inspired by the Creed™ films.

• Multiple Game Modes: Choose your path to glory in multiple game modes: story-driven Career, customizable Freeplay, or online PvP.

• Feel the Impact: Phantom Melee Technology mimics the real-life effects of throwing and taking punches in the ring, such as the out-of-body sensation of getting knocked out or the strain of fatigue during a long, frantic bout.

• Break Them―or Become Them: Play or fight the most iconic figures from the Creed™ and Rocky™ universe in Freeplay or PvP, including classic Rocky Balboa, Ivan and Viktor Drago, and more!

• Oculus Cross-Buy: Got CREED: Rise to Glory in your Rift library? Let the punches fly on Quest at no additional cost with complimentary cross-buy.', 269910, 'English', 'Creed: Rise to Glory', '2366245336750543', 'https://www.desconsolados.com/wp-content/uploads/2018/09/Creed-Digital-Creed-Cover-Art-Creed-201808132560x1440.png', 29.99, '1970-01-18', 9000, 450, 0, 0, 'https://survios.com/creed/', 1, 1);
INSERT IGNORE INTO oculusdb.application (id, company, description, income_estimation, language, name, oculusdbid, picture, price, release_date, sales_estimations, total_reviews, type_of_app, type_of_gameplay, website, category_id, platform_id) VALUES (113, 'Oculus Studios Strike Team', 'Dead and Buried II is a fast-paced multiplayer shooter set in a supernatural western world. Grab your six-shooters and go head-to-head in various game modes. Compete against real players online to see who is the best gunslinger! The game is a sequel to the popular Dead and Buried released on Rift and GO.

Features:
- Competitive Modes: battle online in free-roaming Deathmatch or cover-based Shootout.
- Multiplayer Bots: never wait for players again! Bots will fill the game.
- Portable: with Quest, take the action on the go.
- Social: make new friends in the Town and spin up matches together.
- Weaponry: six-shooters, grenade launchers, and more!
- Future Plans: more events will be added to the Town over time so stay tuned!', 101948, 'English', 'Dead and Buried II', '2134077359973067', 'https://www.slashgear.com/wp-content/uploads/2016/03/dab.jpg', 19.99, '1970-01-18', 5100, 255, 0, 0, 'http://www.oculus.com/', 1, 1);
INSERT IGNORE INTO oculusdb.application (id, company, description, income_estimation, language, name, oculusdbid, picture, price, release_date, sales_estimations, total_reviews, type_of_app, type_of_gameplay, website, category_id, platform_id) VALUES (115, 'Owlchemy Labs', 'In a world where robots have replaced all human jobs, step into the "Job Simulator" to learn what it was like ''to do the job''.

Players can relive the glory days of work by simulating the ins and outs of being a gourmet chef, an office worker, a convenience store clerk, and more.

Key Jobbing Features:
●	Throw a stapler at your boss!
●	Learn to ''job'' in four not-so historically accurate representations of work-life before society was automated by robots!
●	Use your hands to stack, manipulate, throw, and smash physics objects in an inexplicably satisfying way!
●	Aggressively chug coffee and eat questionable food from the trash!
●	Able to juggle tomatoes in real life? Do it in VR! Unable to juggle? There''s no cleanup required in VR!
●	Gain valuable life experience by firing new employees, serving slushy treats, brewing English tea, and ripping apart car engines!
●	Work the never-ending night shift with Infinite Overtime mode!', 476502, 'English', 'Job Simulator', '3235570703151406', 'https://media-cdn.tripadvisor.com/media/photo-s/12/c8/13/63/job-simulator-vr-game.jpg', 15.99, '1970-01-18', 29800, 1490, 0, 0, 'http://jobsimulatorgame.com/', 1, 1);

--Administrator

INSERT IGNORE INTO oculusdb.administrator (id, email, name, password, surname, username,banner) VALUES (1, 'pedro_admin@gmail.com', 'Pedro', '$2a$10$J1Av8xN3HaF8KZxiYvmOXels/.CmzkntgCizGreqoRqvNNTJukiiu', 'Rodríguez', 'administrator','https://60a99bedadae98078522-a9b6cded92292ef3bace063619038eb1.ssl.cf2.rackcdn.com/images_BrandPromos_Oculus_RiftSVRLandPgBanner.jpg');
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
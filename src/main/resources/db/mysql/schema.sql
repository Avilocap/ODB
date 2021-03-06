
create table category
(
	id int not null
		primary key,
	description varchar(255) null,
	title varchar(255) null
);

create table credit_cards
(
	id int not null
		primary key,
	cvv int not null,
	expiration_month int not null,
	expiration_year int not null,
	holder_name varchar(255) null,
	number int not null
);

create table hibernate_sequence
(
	next_val bigint null
);

create table platform
(
	id int not null
		primary key,
	description varchar(255) null,
	title varchar(255) null
);

create table application
(
	id int not null
		primary key,
	company varchar(255) null,
	description longtext null,
	income_estimation int null,
	language varchar(255) null,
	name varchar(255) null,
	oculusdbid varchar(255) null,
	picture varchar(255) null,
	price double null,
	release_date date null,
	sales_estimations int null,
	total_reviews int null,
	type_of_app int null,
	type_of_gameplay int null,
	website varchar(255) null,
	category_id int null,
	platform_id int null,
	constraint FK8atggxc3sogybwubih9xcmvc7
		foreign key (category_id) references category (id),
	constraint FKfqnwcyffvrt8xxflewv8uk9oh
		foreign key (platform_id) references platform (id)
);

create table application_positive_words
(
    application_id    int not null,
    positive_words_id int not null,
    constraint UK_pa7707fcm9aklhpntk8wn813v
        unique (positive_words_id),
    constraint FKi2n247f4d1sl9yk44cfk2s25a
        foreign key (positive_words_id) references word (id),
    constraint FKi9t69axs2s45u5xp7jn7tqn5b
        foreign key (application_id) references application (id)
);

create table application_negative_words
(
    application_id    int not null,
    negative_words_id int not null,
    constraint UK_l0xn0t3ljmpnhbvxkkco45576
        unique (negative_words_id),
    constraint FK86fagjh5ghj2meoq9hywesu48
        foreign key (negative_words_id) references word (id),
    constraint FKgm7e81ij0xt2hoew3wn6w34e7
        foreign key (application_id) references application (id)
);


create table comments
(
	id int not null
		primary key,
	content varchar(255) null,
	title varchar(255) null,
	application_id int null,
	constraint FKnmjdb5ke19k56vlg2rpmqw4s9
		foreign key (application_id) references application (id)
);

create table reviews
(
	id int not null
		primary key,
	content longtext null,
	oculus_id varchar(255) null,
	publish_date date null,
	title longtext null,
	usefull bit null,
	application_id int null,
	constraint FKcotkguh4ah4b47qovldy4j307
		foreign key (application_id) references application (id)
);

create table user_account
(
	id int not null
		primary key,
	authority varchar(255) null,
	nick varchar(255) null,
	password varchar(255) null
);

create table administrator
(
	id int not null
		primary key,
	email varchar(255) null,
	name varchar(255) null,
	surname varchar(255) null,
	user_account_id int null,
	constraint FKg6h9h18gud3yotccxlt5p2kul
		foreign key (user_account_id) references user_account (id)
);

create table developer
(
	id int not null
		primary key,
	email varchar(255) null,
	name varchar(255) null,
	surname varchar(255) null,
	company varchar(255) null,
	company_description varchar(255) null,
	webpage varchar(255) null,
	user_account_id int null,
	credit_card_id int null,
	constraint FK7av7qj68mwsh84x17bkh8hoo7
		foreign key (credit_card_id) references credit_cards (id),
	constraint FKci8gfng59gnf5lrollybvau9s
		foreign key (user_account_id) references user_account (id)
);

create table sponsors
(
	id int not null
		primary key,
	email varchar(255) null,
	name varchar(255) null,
	surname varchar(255) null,
	user_account_id int null,
	credit_card_id int null,
	constraint FK4450moypbhcaonn9wwgojexy1
		foreign key (user_account_id) references user_account (id),
	constraint FKs6gtu9brokmq622747ldf26lo
		foreign key (credit_card_id) references credit_cards (id)
);

create table sponsorship
(
	id int not null
		primary key,
	attachmenturl varchar(255) null,
	title varchar(255) null,
	sponsor_id int null,
	constraint FKek9gqau49wccsug2w7syhmke6
		foreign key (sponsor_id) references sponsors (id)
);

create table users
(
	id int not null
		primary key,
	email varchar(255) null,
	name varchar(255) null,
	surname varchar(255) null,
	user_account_id int null,
	constraint FK7fjlofg8j4fuptxo1fywusqaq
		foreign key (user_account_id) references user_account (id)
);

create table word
(
    id int not null
        primary key,
    letters varchar(255) null,
    repeats int          not null
);




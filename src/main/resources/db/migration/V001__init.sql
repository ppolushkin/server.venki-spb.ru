create table admins
(
	id serial not null
		constraint admins_pkey
			primary key,
	email varchar(255),
	password_hash varchar(255),
	created_at timestamp not null,
	updated_at timestamp not null,
	receive_emails boolean default true not null
)
;

create table basket_items
(
	id serial not null
		constraint basket_items_pkey
			primary key,
	basket_id integer,
	product_id integer,
	count integer default 1
)
;

create table baskets
(
	id serial not null
		constraint baskets_pkey
			primary key,
	created_at timestamp not null,
	updated_at timestamp not null,
	order_id integer
)
;

create table depot_items
(
	id serial not null
		constraint depot_items_pkey
			primary key,
	product_id integer,
	depot_id integer,
	count integer not null,
	hold_count integer not null,
	created_at timestamp not null,
	updated_at timestamp not null
)
;

create table depots
(
	id serial not null
		constraint depots_pkey
			primary key,
	name varchar(255) not null,
	created_at timestamp not null,
	updated_at timestamp not null
)
;

create table feedback_mails
(
	id serial not null
		constraint feedback_mails_pkey
			primary key,
	email varchar(255),
	name varchar(255),
	phone varchar(255),
	message text,
	created_at timestamp not null,
	updated_at timestamp not null,
	application_name varchar(255) default 'obelisk'::character varying not null
)
;

create table orders
(
	id serial not null
		constraint orders_pkey
			primary key,
	basket_id integer,
	full_name varchar(255),
	phone varchar(255),
	email varchar(255),
	address varchar(255),
	delivery boolean,
	notes text,
	created_at timestamp not null,
	updated_at timestamp not null,
	state varchar(255) default 'new'::character varying not null
)
;

create table pages
(
	id serial not null
		constraint pages_pkey
			primary key,
	reference varchar(255),
	title varchar(255),
	created_at timestamp not null,
	updated_at timestamp not null,
	application_name varchar(255) default 'obelisk'::character varying not null
)
;

create table products
(
	id serial not null
		constraint products_pkey
			primary key,
	article varchar(6) not null,
	name varchar(50) not null,
	height varchar(10),
	width varchar(10),
	notes varchar(600),
	small_image_name varchar(255),
	big_image_name varchar(255),
	extra_image_name varchar(255),
	price numeric not null,
	created_at timestamp not null,
	updated_at timestamp not null,
	may9 varchar(255) default '0'::character varying not null,
	small_img varchar(255),
	medium_img varchar(255),
	big_img varchar(255),
	retail_price numeric default 0 not null
)
;

create table revisions
(
	id serial not null
		constraint revisions_pkey
			primary key,
	page_id integer,
	content text,
	created_at timestamp not null,
	updated_at timestamp not null
)
;

create table schema_migrations
(
	version varchar(255) not null
)
;

create unique index unique_schema_migrations
	on schema_migrations (version)
;

create table tapes
(
	id serial not null
		constraint tapes_pkey
			primary key,
	text varchar(255),
	color varchar(255),
	count integer,
	basket_id integer,
	product_id integer,
	created_at timestamp not null,
	updated_at timestamp not null
)
;

create table schema_version
(
	installed_rank integer not null
		constraint schema_version_pk
			primary key,
	version varchar(50),
	description varchar(200) not null,
	type varchar(20) not null,
	script varchar(1000) not null,
	checksum integer,
	installed_by varchar(100) not null,
	installed_on timestamp default now() not null,
	execution_time integer not null,
	success boolean not null
)
;

create index schema_version_s_idx
	on schema_version (success)
;


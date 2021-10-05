-- EVENTS CATEGORIES
INSERT INTO categories(name) VALUES ('SPORT');
INSERT INTO categories(name) VALUES ('CONFERENCE');
INSERT INTO categories(name) VALUES ('EXPOSITION');
INSERT INTO categories(name) VALUES ('CONCERT');
INSERT INTO categories(name) VALUES ('FESTIVAL');
INSERT INTO categories(name) VALUES ('PERFORMING_ARTS');
INSERT INTO categories(name) VALUES ('COMMUNITY');
INSERT INTO categories(name) VALUES ('POLITIC');
INSERT INTO categories(name) VALUES ('SCIENCE');
INSERT INTO categories(name) VALUES ('TECHNOLOGY');
INSERT INTO categories(name) VALUES ('ENTERTAINMENT');
INSERT INTO categories(name) VALUES ('EDUCATION');

-- ROLES
INSERT INTO roles(name) VALUES ('ADMINISTRATOR');
INSERT INTO roles(name) VALUES ('EVENT_MANAGER');
INSERT INTO roles(name) VALUES ('PARTICIPANT');
INSERT INTO roles(name) VALUES ('READ_USER');

-- SAMPLE LOCATIONS
INSERT INTO locations(region, city, zipcode, street) VALUES ('Germany', 'Hamburg', '12345', 'Samplestraße 1');
INSERT INTO locations(region, city, zipcode, street) VALUES ('Germany', 'Berlin', '12222', 'Unter den Linden 23');
INSERT INTO locations(region, city, zipcode, street) VALUES ('Germany', 'Kiel', '33333', 'Goethestraße 89');
INSERT INTO locations(region, city, zipcode, street) VALUES ('France', 'Paris', 'A12345', 'Sample French street 6');
INSERT INTO locations(region, city, zipcode, street) VALUES ('Belgium', 'Brussels', 'CD2345', 'Sample Belgian street 1a');
INSERT INTO locations(region, city, zipcode, street) VALUES ('Germany', 'Frankfurt', '55555', 'Sample Frankfurter Straße 256');
INSERT INTO locations(region, city, zipcode, street) VALUES ('Germany', 'Kiel', '22344', 'Kieler Straße 2');
INSERT INTO locations(region, city, zipcode, street) VALUES ('Germany', 'Lübeck', '99999', 'Seestraße 123');
INSERT INTO locations(region, city, zipcode, street) VALUES ('Austria', 'Sample Austrian City', 'AD8989', 'Sample Austrian Street 123');
INSERT INTO locations(region, city, zipcode, street) VALUES ('Denmark', 'Sample Denmark City', 'CCC123', 'Sample Street 123');

-- SAMPLE USERS
INSERT INTO users(firstname, lastname, birthday, email, password, is_active, location_id, role_id) VALUES ('Alex', 'Mi', '1922-01-01', 'testuser01@eventsapp.de', '123456', true, 1, 1);
INSERT INTO users(firstname, lastname, birthday, email, password, is_active, location_id, role_id) VALUES ('Karl', 'U', '2000-01-01', 'testuser02@eventsapp.de', '123456', true, 2, 2);
INSERT INTO users(firstname, lastname, birthday, email, password, is_active, location_id, role_id) VALUES ('Michael', 'L', '2001-01-01', 'testuser03@eventsapp.de', '123456', true, 3, 2);
INSERT INTO users(firstname, lastname, birthday, email, password, is_active, location_id, role_id) VALUES ('Peter', 'I', '2000-01-01', 'testuser04@eventsapp.de', '123456', true, 4, 3);
INSERT INTO users(firstname, lastname, birthday, email, password, is_active, location_id, role_id) VALUES ('Elena', 'P', '2010-01-01', 'testuser05@eventsapp.de', '123456', true, 5, 4);

-- SAMPLE EVENTS
INSERT INTO events(name, date_start, date_end, manager_id, created, is_active, location_id) VALUES ('Soccer', '2021-10-08 12:00:00', '2021-10-08 15:00:00', 2, '2021-09-11 22:00:00', true, 6);
INSERT INTO events(name, date_start, date_end, manager_id, created, is_active, location_id) VALUES ('Lecture', '2021-11-08 12:00:00', '2021-11-08 15:00:00', 3, '2021-09-11 22:00:00', true, 7);
INSERT INTO events(name, date_start, date_end, manager_id, created, is_active, location_id) VALUES ('How to Learn Programming', '2021-12-08 12:00:00', '2021-12-10 15:00:00', 2, '2021-09-11 22:00:00', true, 8);
INSERT INTO events(name, date_start, date_end, manager_id, created, is_active, location_id) VALUES ('Rock Concert', '2021-11-23 12:00:00', '2021-11-23 15:00:00', 2, '2021-09-11 22:00:00', false, 9);
INSERT INTO events(name, date_start, date_end, manager_id, created, is_active, location_id) VALUES ('Retro Gallery', '2021-12-08 12:00:00', '2022-01-08 15:00:00', 3, '2021-09-11 22:00:00', true, 10);
INSERT INTO events(name, date_start, date_end, manager_id, created, is_active, location_id) VALUES ('Meet Friends', '2021-10-12 12:00:00', '2021-10-12 15:00:00', 2, '2021-09-11 22:00:00', true, 9);
INSERT INTO events(name, date_start, date_end, manager_id, created, is_active, location_id) VALUES ('Party', '2021-11-11 12:00:00', '2021-11-11 15:00:00', 2, '2021-09-11 22:00:00', true, 8);

-- SAMPLE REGISTRATIONS
INSERT INTO registrations(participant_id, event_id, created, is_active) VALUES(4, 1, '2021-09-10', true);
INSERT INTO registrations(participant_id, event_id, created, is_active) VALUES(4, 2, '2021-09-10', false);
INSERT INTO registrations(participant_id, event_id, created, is_active) VALUES(4, 3, '2021-09-10', true);

-- SAMPLE EVENTS_CATEGORIES
INSERT INTO events_categories VALUES (1, 1);
INSERT INTO events_categories VALUES (12, 2);
INSERT INTO events_categories VALUES (2, 2);
INSERT INTO events_categories VALUES (12, 3);
INSERT INTO events_categories VALUES (10, 3);
INSERT INTO events_categories VALUES (4, 4);
INSERT INTO events_categories VALUES (5, 4);
INSERT INTO events_categories VALUES (6, 5);
INSERT INTO events_categories VALUES (3, 5);
INSERT INTO events_categories VALUES (7, 6);
INSERT INTO events_categories VALUES (11, 6);
INSERT INTO events_categories VALUES (11, 7);

-- SAMPLE SUBSCRIPTIONS
INSERT INTO subscriptions(user_id, category_id, created, is_active) VALUES (4, 2, '2021-09-12', true);
INSERT INTO subscriptions(user_id, category_id, created, is_active) VALUES (4, 4, '2021-09-13', false);
INSERT INTO subscriptions(user_id, category_id, created, is_active) VALUES (4, 6, '2021-09-11', true);
INSERT INTO subscriptions(user_id, location_id, created, is_active) VALUES (1, 8, '2021-09-09', true);
INSERT INTO subscriptions(user_id, manager_id, created, is_active) VALUES (4, 2, '2021-09-11', true);
INSERT INTO subscriptions(user_id, category_id, location_id, created, is_active) VALUES (1, 2, 8, '2021-09-11', true);
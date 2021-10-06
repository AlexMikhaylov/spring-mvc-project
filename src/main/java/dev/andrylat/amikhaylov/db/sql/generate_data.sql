
-- Details about Index (Chapter 11. Indexes in the postresql documentation) and advantages of it: types of index for data structures and how postres is working with index to control the index queries
-- query history: time execution + plan analyse
-- "flash back" in Oracle
-- compare the execution time with the planed time
-- EXPLAIN ANALYSE

CREATE EXTENSION tsm_system_rows;

-- SAMPLE DATA CATEGORIES
INSERT INTO categories (name)
SELECT
    LEFT (md5(i::text), 255)
FROM generate_series(1, 1000000) s(i);


-- SAMPLE DATA ROLES
INSERT INTO roles (name)
SELECT
    LEFT (md5(i::text), 255)
FROM generate_series(1, 1000000) s(i);

-- SAMPLE LOCATIONS
INSERT INTO locations (region, city, zipcode, street)
SELECT
    LEFT (md5(i::text), 255),
    LEFT (md5(i::text), 255),
    LEFT (md5(i::text), 10),
    LEFT (md5(i::text), 255)
FROM generate_series(1, 1000000) s(i);

-- SAMPLE USERS
INSERT INTO users (firstname, lastname, email, password,
                   birthday,
                   location_id, role_id,
                   is_active)
SELECT
    LEFT(md5(i::text), 255),
    LEFT(md5(i::text), 255),
    LEFT(md5(i::text), 255),
    LEFT(md5(i::text), 255),
    '1970-01-01'::date + i,
    (SELECT locations.id FROM locations TABLESAMPLE system_rows(1)) AS location, -- postres executes it differently
    (SELECT roles.id FROM roles TABLESAMPLE system_rows(1)) AS rol,
    (SELECT (round(random()*i):: int)::boolean ) AS boo
FROM generate_series(1, 1000000) s(i)
;

-- SAMPLE EVENTS
INSERT INTO events (name, date_start, date_end, manager_id,
                   created, is_active, location_id)
SELECT
    LEFT(md5(i::text), 255),
    '2021-01-01 12:00:00'::timestamp + interval '1 day'*i,
    '2021-01-03 12:00:00'::timestamp + interval '1 day'*i,
    (SELECT users.id FROM users TABLESAMPLE system_rows(1)) AS manager,
    '2021-09-03 12:00:00'::timestamp + interval '1 day'*i,
    (SELECT (round(random()*i):: int)::boolean ) AS boo,
    (SELECT locations.id FROM locations TABLESAMPLE system_rows(1)) AS loc
FROM generate_series(1, 1000000) s(i)
;

-- SAMPLE REGISTRATIONS
INSERT INTO registrations (participant_id, event_id, created, is_active)
SELECT
    (SELECT users.id FROM users TABLESAMPLE system_rows(1)) AS manager,
    (SELECT events.id FROM events TABLESAMPLE system_rows(1)) AS event,
    '2021-09-23 12:00:00'::timestamp + interval '1 day'*i,
    (SELECT (round(random()*i):: int)::boolean ) AS boo
FROM generate_series(1, 1000000) s(i)
;

-- SAMPLE EVENTS_CATEGORIES
INSERT INTO events_categories (category_id, event_id)
SELECT
    (SELECT categories.id FROM categories TABLESAMPLE system_rows(1)) AS category,
    (SELECT events.id FROM events TABLESAMPLE system_rows(1)) AS event
FROM generate_series(1, 1000000) s(i)
;

-- SAMPLE SUBSCRIPTIONS
INSERT INTO subscriptions (user_id, category_id, location_id, manager_id,
    created, is_active)
SELECT
    (SELECT users.id FROM users TABLESAMPLE system_rows(1)) AS us,
    (SELECT categories.id FROM categories TABLESAMPLE system_rows(1)) AS category,
    (SELECT locations.id FROM locations TABLESAMPLE system_rows(1)) AS loc,
    (SELECT users.id FROM users TABLESAMPLE system_rows(1)) AS manager,
    '2021-09-23 12:00:00'::timestamp + interval '1 day'*i,
    (SELECT (round(random()*i):: int)::boolean ) AS boo
FROM generate_series(1, 1000000) s(i)
;
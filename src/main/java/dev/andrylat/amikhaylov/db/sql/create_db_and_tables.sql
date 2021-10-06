-- CREATE DATABASE events_app; if the db doesn't exist

CREATE TABLE IF NOT EXISTS roles
(
    id   SERIAL NOT NULL,
    name VARCHAR(255),
    PRIMARY KEY (id),
    UNIQUE (name)
);

CREATE TABLE IF NOT EXISTS locations
(
    id      BIGSERIAL    NOT NULL,
    region  VARCHAR(255) NOT NULL,
    city    VARCHAR(255) NOT NULL,
    zipcode VARCHAR(10)  NOT NULL,
    street  VARCHAR(255),
    PRIMARY KEY (id)
);

CREATE TABLE IF NOT EXISTS users
(
    id          BIGSERIAL    NOT NULL,
    firstname   VARCHAR(255) NOT NULL,
    lastname    VARCHAR(255) NOT NULL,
    birthday    DATE         NOT NULL,
    email       VARCHAR(255) NOT NULL,
    password    VARCHAR(255) NOT NULL,
    is_active   BOOLEAN      NOT NULL,
    location_id BIGINT REFERENCES locations (id) ON DELETE CASCADE,
    role_id     INT NOT NULL REFERENCES roles (id) ON DELETE CASCADE,
    PRIMARY KEY (id),
    UNIQUE (email)
);

CREATE TABLE IF NOT EXISTS events
(
    id          BIGSERIAL    NOT NULL,
    name        VARCHAR(255) NOT NULL,
    date_start  TIMESTAMP    NOT NULL,
    date_end    TIMESTAMP    NOT NULL,
    manager_id  BIGINT       NOT NULL REFERENCES users (id) ON DELETE CASCADE,
    created     TIMESTAMP    NOT NULL,
    is_active   BOOLEAN      NOT NULL,
    location_id BIGINT       NOT NULL REFERENCES locations (id) ON DELETE CASCADE,
    PRIMARY KEY (id)
);

CREATE TABLE IF NOT EXISTS registrations
(
    id             BIGSERIAL NOT NULL,
    participant_id BIGINT    NOT NULL REFERENCES users (id) ON DELETE CASCADE,
    event_id       BIGINT    NOT NULL REFERENCES events (id) ON DELETE CASCADE,
    created        TIMESTAMP NOT NULL,
    is_active      BOOLEAN   NOT NULL,
    PRIMARY KEY (id)
);

CREATE TABLE IF NOT EXISTS categories
(
    id   BIGSERIAL    NOT NULL,
    name VARCHAR(255) NOT NULL,
    PRIMARY KEY (id),
    UNIQUE (name)
);

CREATE TABLE IF NOT EXISTS events_categories
(
    category_id BIGINT NOT NULL REFERENCES categories (id) ON DELETE CASCADE,
    event_id    BIGINT NOT NULL REFERENCES events (id) ON DELETE CASCADE,
    UNIQUE (category_id, event_id)
);

CREATE TABLE IF NOT EXISTS subscriptions
(
    user_id     BIGINT    NOT NULL REFERENCES users (id) ON DELETE CASCADE,
    category_id BIGINT REFERENCES categories (id) ON DELETE CASCADE,
    location_id BIGINT REFERENCES locations (id) ON DELETE CASCADE,
    manager_id  BIGINT REFERENCES users (id) ON DELETE CASCADE,
    created     TIMESTAMP NOT NULL,
    is_active   BOOLEAN   NOT NULL
);
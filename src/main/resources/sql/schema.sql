--Tables for Teams, games, ages, season

DROP TABLE IF EXISTS ages cascade;
DROP TABLE IF EXISTS teams cascade;
DROP TABLE IF EXISTS games;
DROP TABLE IF EXISTS locations;
DROP TABLE IF EXISTS seasons;

CREATE TABLE ages(
    age_id SERIAL PRIMARY KEY,
    age_group VARCHAR(20)
);


CREATE TABLE teams(
    team_id SERIAL PRIMARY KEY,
    team_name VARCHAR(50),
    age_id INT,
    FOREIGN KEY(age_id) REFERENCES ages(age_id)
);


CREATE TABLE seasons(
    season_id SERIAL PRIMARY KEY,
    season_name VARCHAR(20)
);


CREATE TABLE locations(
    location_id SERIAL PRIMARY KEY,
    location_name VARCHAR(100),
    location_address VARCHAR(200)
);


CREATE TABLE games(
    game_id SERIAL PRIMARY KEY,
    home_pts SMALLINT,
    away_pts SMALLINT,
    game_date DATE,
    game_time TIME,
    home_id INT,
    away_id INT,
    age_id INT,
    location_id INT,
    season_id INT,
    FOREIGN KEY(home_id) REFERENCES teams(team_id),
    FOREIGN KEY(away_id) REFERENCES teams(team_id),
    FOREIGN KEY(age_id) REFERENCES ages(age_id),
    FOREIGN KEY(location_id) REFERENCES locations(location_id),
    FOREIGN KEY(season_id) REFERENCES seasons(season_id)
);
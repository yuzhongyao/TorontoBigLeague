INSERT INTO ages (age_group) VALUES
('Grade 8'),  --1
('Grade 9'),  --2
('Grade 10'), --3
('Grade 11'), --4
('Grade 12'), --5
('Jr'),       --6
('Sr');       --7

INSERT INTO seasons (season_name) VALUES
('2024-2025'); --1

INSERT INTO sessions(age_id, session_date, season_id) VALUES
(1, '2024-11-23', 1), --grade 8
(1, '2024-12-28', 1), --grade 8
(1, '2025-01-25', 1), --grade 8
(1, '2025-02-15', 1), --grade 8
(1, '2025-03-01', 1), --grade 8
(2, '2024-11-09', 1), --grade 9
(2, '2024-11-30', 1), --grade 9
(2, '2025-12-21', 1), --grade 9
(2, '2025-01-11', 1), --grade 9
(2, '2025-03-01', 1), --grade 9
(3, '2024-11-09', 1), --grade 10
(3, '2024-11-30', 1), --grade 10
(3, '2025-12-21', 1), --grade 10
(3, '2025-01-11', 1), --grade 10
(3, '2025-03-01', 1), --grade 10
(6, '2024-11-09', 1), --jr
(6, '2024-11-30', 1), --jr
(6, '2025-12-21', 1), --jr
(6, '2025-01-11', 1), --jr
(6, '2025-03-01', 1), --jr
(4, '2024-11-02', 1), --grade 11
(4, '2024-12-07', 1), --grade 11
(4, '2025-01-04', 1), --grade 11
(4, '2025-02-01', 1), --grade 11
(4, '2025-03-22', 1), --grade 11
(5, '2024-11-02', 1), --grade 12
(5, '2024-12-07', 1), --grade 12
(5, '2025-01-04', 1), --grade 12
(5, '2025-02-01', 1), --grade 12
(5, '2025-03-22', 1), --grade 12
(7, '2024-11-02', 1), --sr
(7, '2024-12-07', 1), --sr
(7, '2025-01-04', 1), --sr
(7, '2025-02-01', 1), --sr
(7, '2025-03-22', 1); --sr

INSERT INTO locations (location_name, location_address) VALUES
('Sir Wilfrid Laurier C.I.','145 Guildwood Pkwy, Scarborough, ON M1E 1P5'),                 --1
('Toronto Pan Am Sports Centre','875 Morningside Ave, Toronto, ON M1C 0C7'),                --2
('O''Neil C.V.I.','301 Simcoe St N, Oshawa, ON L1G 4T2'),                                   --3
('St. Joan of Arc Catholic Academy','959 Midland Ave, Scarborough, ON M1K 4G4'),            --4
('Village Union Public School','155 Gibb St, Oshawa, ON L1J 1Y4');                          --5

INSERT INTO teams (team_name, age_id) VALUES
--Grade 8
('Royal Crown', 1),
('D Lab', 1),
('Jaxx City', 1),
('Project Excellence', 1),
--Junior Prep
('Royal Crown', 6),
('Legacy Prep', 6),
('Project Excellence', 6),
('Cali Prep', 6),
('Elton Academy', 6),
('Team Thetford Black', 6),
('TIme 2 Hoop', 6),
--Senior Prep
('Time 2 Hoop', 7),
('Project Excellence', 7),
('Kitchener Impact', 7),
('Royal Crown', 7),
('ONLX', 7),
('Elton Academy', 7),
('West United', 7);

-- Inserting test games with both date and time into the games table
INSERT INTO games (home_pts, away_pts, game_date, game_time, home_id, away_id, age_id, location_id, session_id, season_id) VALUES
-- Grade 8 games
(45, 50, '2024-09-15', '10:30:00', 1, 2, 1, 1, 1, 1),  -- Royal Crown vs D Lab at Sir Wilfrid Laurier C.I. at 10:30 AM
(60, 55, '2024-09-17', '12:00:00', 3, 4, 1, 2, 1, 1),  -- Jaxx City vs Project Excellence at Toronto Pan Am Sports Centre at 12:00 PM

-- Junior Prep games
(55, 50, '2024-09-18', '14:00:00', 5, 6, 6, 3, 1, 1),  -- Royal Crown vs Legacy Prep at O'Neil C.V.I. at 2:00 PM
(68, 70, '2024-09-20', '16:30:00', 7, 8, 6, 4, 1, 1),  -- Project Excellence vs Cali Prep at St. Joan of Arc Catholic Academy at 4:30 PM
(72, 66, '2024-09-22', '13:15:00', 9, 10, 6, 5, 1, 1), -- Elton Academy vs Team Thetford Black at Village Union Public School at 1:15 PM

-- Senior Prep games
(80, 78, '2024-09-24', '15:00:00', 11, 12, 7, 1, 1, 1), -- Time 2 Hoop vs Project Excellence at Sir Wilfrid Laurier C.I. at 3:00 PM
(90, 85, '2024-09-25', '11:45:00', 13, 14, 7, 2, 1, 1), -- Kitchener Impact vs Royal Crown at Toronto Pan Am Sports Centre at 11:45 AM
(88, 92, '2024-09-27', '17:30:00', 15, 16, 7, 3, 1, 1); -- ONLX vs Elton Academy at O'Neil C.V.I. at 5:30 PM


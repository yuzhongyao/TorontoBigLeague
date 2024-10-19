INSERT INTO ages (age_group) VALUES
('Grade 8'),  --1
('Grade 9'),  --2
('Grade 10'), --3
('Grade 11'), --4
('Grade 12'), --5
('Jr Prep'),       --6
('Sr Prep'),       --7
('Jr Rep'),        --8
('Sr Rep');        --9
-- Sr 10
-- Jr 11

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
(52, 48, '2024-09-30', '11:00:00', 1, 3, 1, 1, 1, 1),  -- Royal Crown vs Jaxx City at Sir Wilfrid Laurier C.I. at 11:00 AM
(56, 60, '2024-10-02', '13:30:00', 2, 4, 1, 2, 1, 1),  -- D Lab vs Project Excellence at Toronto Pan Am Sports Centre at 1:30 PM
(49, 50, '2024-10-05', '09:45:00', 1, 4, 1, 3, 1, 1),  -- Royal Crown vs Project Excellence at O'Neil C.V.I. at 9:45 AM
(53, 48, '2024-10-08', '10:00:00', 3, 2, 1, 4, 1, 1),  -- Jaxx City vs D Lab at St. Joan of Arc Catholic Academy at 10:00 AM
(61, 59, '2024-10-10', '11:30:00', 4, 1, 1, 5, 1, 1),  -- Project Excellence vs Royal Crown at Village Union Public School at 11:30 AM
(62, 60, '2024-10-12', '14:15:00', 2, 3, 1, 1, 1, 1),  -- D Lab vs Jaxx City at Sir Wilfrid Laurier C.I. at 2:15 PM
(57, 58, '2024-10-15', '16:45:00', 1, 2, 1, 2, 1, 1),  -- Royal Crown vs D Lab at Toronto Pan Am Sports Centre at 4:45 PM
(59, 63, '2024-10-18', '09:30:00', 3, 4, 1, 3, 1, 1),  -- Jaxx City vs Project Excellence at O'Neil C.V.I. at 9:30 AM
(66, 61, '2024-10-20', '12:45:00', 4, 3, 1, 4, 1, 1),  -- Project Excellence vs Jaxx City at St. Joan of Arc Catholic Academy at 12:45 PM
(54, 56, '2024-10-22', '15:30:00', 2, 1, 1, 5, 1, 1),  -- D Lab vs Royal Crown at Village Union Public School at 3:30 PM


-- Junior Prep games
(55, 50, '2024-09-18', '14:00:00', 5, 6, 6, 3, 1, 1),  -- Royal Crown vs Legacy Prep at O'Neil C.V.I. at 2:00 PM
(68, 70, '2024-09-20', '16:30:00', 7, 8, 6, 4, 1, 1),  -- Project Excellence vs Cali Prep at St. Joan of Arc Catholic Academy at 4:30 PM
(72, 66, '2024-09-22', '13:15:00', 9, 10, 6, 5, 1, 1), -- Elton Academy vs Team Thetford Black at Village Union Public School at 1:15 PM
(65, 62, '2024-09-28', '13:00:00', 6, 9, 6, 1, 1, 1),  -- Legacy Prep vs Elton Academy at Sir Wilfrid Laurier C.I. at 1:00 PM
(67, 71, '2024-09-30', '14:00:00', 5, 10, 6, 2, 1, 1),  -- Royal Crown vs Team Thetford Black at Toronto Pan Am Sports Centre at 2:00 PM
(60, 59, '2024-10-01', '09:30:00', 7, 8, 6, 3, 1, 1),  -- Project Excellence vs Cali Prep at O'Neil C.V.I. at 9:30 AM
(63, 62, '2024-10-04', '13:45:00', 9, 5, 6, 4, 1, 1),  -- Elton Academy vs Royal Crown at St. Joan of Arc Catholic Academy at 1:45 PM
(58, 67, '2024-10-06', '11:30:00', 10, 6, 6, 5, 1, 1), -- Team Thetford Black vs Legacy Prep at Village Union Public School at 11:30 AM
(64, 63, '2024-10-08', '15:15:00', 8, 9, 6, 1, 1, 1),  -- Cali Prep vs Elton Academy at Sir Wilfrid Laurier C.I. at 3:15 PM
(59, 57, '2024-10-12', '17:00:00', 5, 7, 6, 2, 1, 1),  -- Royal Crown vs Project Excellence at Toronto Pan Am Sports Centre at 5:00 PM
(62, 60, '2024-10-14', '16:30:00', 6, 10, 6, 3, 1, 1), -- Legacy Prep vs Team Thetford Black at O'Neil C.V.I. at 4:30 PM
(70, 65, '2024-10-17', '12:45:00', 9, 8, 6, 4, 1, 1),  -- Elton Academy vs Cali Prep at St. Joan of Arc Catholic Academy at 12:45 PM
(68, 69, '2024-10-20', '14:00:00', 7, 5, 6, 5, 1, 1),  -- Project Excellence vs Royal Crown at Village Union Public School at 2:00 PM

-- Senior Prep games
(80, 78, '2024-09-24', '15:00:00', 11, 12, 7, 1, 1, 1), -- Time 2 Hoop vs Project Excellence at Sir Wilfrid Laurier C.I. at 3:00 PM
(90, 85, '2024-09-25', '11:45:00', 13, 14, 7, 2, 1, 1), -- Kitchener Impact vs Royal Crown at Toronto Pan Am Sports Centre at 11:45 AM
(88, 92, '2024-09-27', '17:30:00', 15, 16, 7, 3, 1, 1), -- ONLX vs Elton Academy at O'Neil C.V.I. at 5:30 PM
(85, 83, '2024-09-29', '12:00:00', 12, 13, 7, 1, 1, 1), -- Project Excellence vs Kitchener Impact at Sir Wilfrid Laurier C.I. at 12:00 PM
(88, 89, '2024-10-01', '13:45:00', 15, 11, 7, 2, 1, 1), -- ONLX vs Time 2 Hoop at Toronto Pan Am Sports Centre at 1:45 PM
(92, 91, '2024-10-03', '16:00:00', 14, 16, 7, 3, 1, 1), -- Royal Crown vs Elton Academy at O'Neil C.V.I. at 4:00 PM
(87, 82, '2024-10-05', '18:15:00', 13, 11, 7, 4, 1, 1), -- Kitchener Impact vs Time 2 Hoop at St. Joan of Arc Catholic Academy at 6:15 PM
(81, 78, '2024-10-08', '11:45:00', 15, 12, 7, 5, 1, 1), -- ONLX vs Project Excellence at Village Union Public School at 11:45 AM
(90, 86, '2024-10-10', '14:15:00', 14, 16, 7, 1, 1, 1), -- Royal Crown vs Elton Academy at Sir Wilfrid Laurier C.I. at 2:15 PM
(83, 80, '2024-10-12', '09:30:00', 12, 15, 7, 2, 1, 1), -- Project Excellence vs ONLX at Toronto Pan Am Sports Centre at 9:30 AM
(89, 84, '2024-10-15', '16:45:00', 13, 11, 7, 3, 1, 1), -- Kitchener Impact vs Time 2 Hoop at O'Neil C.V.I. at 4:45 PM
(87, 88, '2024-10-17', '18:00:00', 16, 14, 7, 4, 1, 1), -- Elton Academy vs Royal Crown at St. Joan of Arc Catholic Academy at 6:00 PM
(79, 77, '2024-10-20', '13:00:00', 11, 12, 7, 5, 1, 1); -- Time 2 Hoop vs Project Excellence at Village Union Public School at 1:00 PM

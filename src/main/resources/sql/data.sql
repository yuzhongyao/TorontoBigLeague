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

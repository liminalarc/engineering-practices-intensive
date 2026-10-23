INSERT INTO entry (id, species, bloom, form, vigor, status, ribbons, runner_ups) VALUES
    ('11111111-1111-1111-1111-111111111111', 'Showy Cactus', 15, 5, 30, 'COMPETING', 0, 0),
    ('22222222-2222-2222-2222-222222222222', 'Fabulous Fern', 8, 3, 20, 'COMPETING', 0, 0),
    ('33333333-3333-3333-3333-333333333333', 'Vivid Venus Flytrap', 20, 2, 15, 'COMPETING', 0, 0),
    ('44444444-4444-4444-4444-444444444444', 'Blue Ribbon Bamboo', 10, 8, 40, 'COMPETING', 0, 0),
    ('55555555-5555-5555-5555-555555555555', 'The One And Only Sunflower', 6, 4, 25, 'COMPETING', 0, 0);
    
INSERT INTO plant (id, species, height, width, description) VALUES
    (1, 'Cactus', 3, 2, 'Prickily'),
    (2, 'Fern', 8, 3, 'Leafy'),
    (3, 'Venus Flytrap', 20, 15, 'Curious'),
    (4, 'Bamboo', 10, 8, 'Tall'),
    (5, 'Sunflower', 6, 4, 'Edible');

ALTER TABLE plant ALTER COLUMN id RESTART WITH 6;

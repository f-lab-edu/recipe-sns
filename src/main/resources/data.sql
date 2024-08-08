INSERT INTO MEMBER (username, password, nickname, created_at, updated_at, withdrawal_at)
VALUES ('john_doe', 'password123', 'John', CURRENT_TIMESTAMP, NULL, NULL);


INSERT INTO FOOD (food_name, food_code, food_size, carbohydrate, protein, fat, calorie, created_at, updated_at)
VALUES
    ('Apple', 'APL001', 1, 25.0, 0.5, 0.3, 95.0, NOW(), NOW()),
    ('Banana', 'BNN001', 1, 27.0, 1.3, 0.3, 105.0, NOW(), NOW()),
    ('Chicken Breast', 'CHB001', 100, 0.0, 31.0, 3.6, 165.0, NOW(), NOW()),
    ('Salmon Fillet', 'SLM001', 100, 0.0, 20.0, 13.5, 208.0, NOW(), NOW()),
    ('Brown Rice', 'BRN001', 100, 77.0, 7.5, 2.0, 370.0, NOW(), NOW());
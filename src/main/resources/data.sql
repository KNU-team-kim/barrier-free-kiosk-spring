insert ignore into user
(name, phone_number, registration_number, gender, sido, sigungu, road_name, main_building_number, sub_building_number, detail_address)
values
('홍길동', '010-1234-1234', '012345-6789012', 'FEMALE', '대구광역시', '북구', '대학로', 80, null, '1층');

SELECT * FROM user;

COMMIT;
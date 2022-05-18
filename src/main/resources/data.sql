--password
INSERT INTO users (id, username, password) VALUES (1, 'user1', '{bcrypt}$2a$10$qDoISw0uB8nBA9NxTNiQ3OJc4we58/VfYY0fm8pxln7qyH7fezjhO');
INSERT INTO users (id, username, password) VALUES (2, 'customer1', '{bcrypt}$2a$10$qDoISw0uB8nBA9NxTNiQ3OJc4we58/VfYY0fm8pxln7qyH7fezjhO');
INSERT INTO nhan_vien (id, ten_nhan_vien, sdt, dia_chi, users_id) VALUES (1, 'Daisy', 'unkown', 'HCMC', 1);
INSERT INTO khach_hang (id, ho_ten, sdt, users_id) VALUES (1, 'Customer 1', 'unkown', 2);

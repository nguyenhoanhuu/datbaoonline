--password
INSERT INTO users (id, username, password) VALUES (1, 'user1', '{bcrypt}$2a$10$qDoISw0uB8nBA9NxTNiQ3OJc4we58/VfYY0fm8pxln7qyH7fezjhO');
INSERT INTO users (id, username, password) VALUES (2, 'customer1', '{bcrypt}$2a$10$qDoISw0uB8nBA9NxTNiQ3OJc4we58/VfYY0fm8pxln7qyH7fezjhO');
INSERT INTO users (id, username, password) VALUES (3, 'customer2', '{bcrypt}$2a$10$qDoISw0uB8nBA9NxTNiQ3OJc4we58/VfYY0fm8pxln7qyH7fezjhO');
INSERT INTO nhan_vien (id, ten_nhan_vien, sdt, dia_chi, users_id) VALUES (1, 'Daisy', '0968172177', 'HCMC', 1);
INSERT INTO khach_hang (id, ho_ten, sdt, users_id) VALUES (1, 'Nguyễn Hoàn Hữu', '0968123123', 2);
INSERT INTO khach_hang (id, ho_ten, sdt, users_id) VALUES (2, 'Nguyễn Hoàn Hữu', '0968123123', 3);




INSERT INTO khuyen_mai (id, gia_tri_giam, ngay_bat_dau, ngay_het_han, ten_khuyen_mai, nhan_vien_id) VALUES (1, 12000, CAST('2022-12-12T00:00:00.0000000' AS DateTime2), CAST('2022-12-12T00:00:00.0000000' AS DateTime2), 'Lễ 30/4', 1);
INSERT INTO khuyen_mai (id, gia_tri_giam, ngay_bat_dau, ngay_het_han, ten_khuyen_mai, nhan_vien_id) VALUES (2, 20000, CAST('2022-12-12T00:00:00.0000000' AS DateTime2), CAST('2022-12-12T00:00:00.0000000' AS DateTime2), 'Lễ 30/4', 1);
INSERT INTO khuyen_mai (id, gia_tri_giam, ngay_bat_dau, ngay_het_han, ten_khuyen_mai, nhan_vien_id) VALUES (3, 30000, CAST('2022-12-12T00:00:00.0000000' AS DateTime2), CAST('2022-12-12T00:00:00.0000000' AS DateTime2), 'Lễ 30/4', 1);

INSERT INTO don_hang (id, dia_chi_nhan_hang, hinh_thuc_thanh_toan, ngay_tao_don_hang, tong_tien_don_hang, trang_thai_don_hang, khach_hang_id, khuyen_mai_id) VALUES (1, '79/15 XVNT,HCM', 'Tai nhà', CAST('2022-12-12T00:00:00.0000000' AS DateTime2), 12121, 'Chờ xử lý', 1, 1);

INSERT INTO bao (id, don_gia, hinh_anh, mo_ta, ten_bao) VALUES (1, 10000, 'https://khoahoctoday.xembao.vn/Epaper/2016/so60/files/assets/cover/1.jpg', 'viet', 'Tạp chí khoa học và công nghệ');
INSERT INTO bao (id, don_gia, hinh_anh, mo_ta, ten_bao) VALUES (2, 20000, 'https://nhacxua.vn/wp-content/uploads/2020/09/thieu-nhi-40.jpg', 'viet123', 'Thiếu Nhi');
INSERT INTO bao (id, don_gia, hinh_anh, mo_ta, ten_bao) VALUES (3, 3000, 'https://img.nhandan.com.vn/Files/Images/2022/05/17/n17_5_tr1-1652749291889.jpg', 'vietnam có ', 'Báo nhân dân');
INSERT INTO bao (id, don_gia, hinh_anh, mo_ta, ten_bao) VALUES (4, 124123, 'https://nld.mediacdn.vn/2020/8/3/ava-15964262576301231699819.jpg', '123123', 'Nguời lao động');
INSERT INTO bao (id, don_gia, hinh_anh, mo_ta, ten_bao) VALUES (5, 5000, 'http://leadmedia.vn/data/upload/doisongphapluatbw.png', 'báo việt nam chất lượng cao', 'Đời sống và pháp luật');

INSERT INTO chi_tiet_don_hang (ngay_ket_thuc_dat_bao, ngay_dat_bao, so_ky, so_luong, don_hang_id, bao_id) VALUES (CAST('2022-12-22T00:00:00.0000000' AS DateTime2), CAST('2022-12-23T00:00:00.0000000' AS DateTime2), 12, 23, 1, 1);
INSERT INTO chi_tiet_don_hang (ngay_ket_thuc_dat_bao, ngay_dat_bao, so_ky, so_luong, don_hang_id, bao_id) VALUES (CAST('2022-12-22T00:00:00.0000000' AS DateTime2), CAST('2022-12-23T00:00:00.0000000' AS DateTime2), 12, 23, 1, 2);
INSERT INTO chi_tiet_don_hang (ngay_ket_thuc_dat_bao, ngay_dat_bao, so_ky, so_luong, don_hang_id, bao_id) VALUES (CAST('2022-05-20T07:00:00.0000000' AS DateTime2), CAST('2022-05-19T07:00:00.0000000' AS DateTime2), 1, 1, 1, 3);

INSERT INTO gio_hang (id, ngay_tao_gio_hang, khach_hang_id) VALUES (1, CAST('2022-05-11T00:00:00.0000000' AS DateTime2), 1);
INSERT INTO gio_hang (id, ngay_tao_gio_hang, khach_hang_id) VALUES (2, CAST('2022-05-11T00:00:00.0000000' AS DateTime2), 2);

INSERT INTO chi_tiet_gio_hang (ngay_dat_bao, ngay_ket_thuc_dat_bao, so_ky, so_luong, gio_hang_id, bao_id) VALUES (CAST('2022-05-20T07:00:00.0000000' AS DateTime2), CAST('2022-05-27T07:00:00.0000000' AS DateTime2), 7, 1, 1, 1);
INSERT INTO chi_tiet_gio_hang (ngay_dat_bao, ngay_ket_thuc_dat_bao, so_ky, so_luong, gio_hang_id, bao_id) VALUES (CAST('2022-06-04T07:00:00.0000000' AS DateTime2), CAST('2022-07-07T07:00:00.0000000' AS DateTime2), 33, 2, 1, 2);
INSERT INTO chi_tiet_gio_hang (ngay_dat_bao, ngay_ket_thuc_dat_bao, so_ky, so_luong, gio_hang_id, bao_id) VALUES (CAST('2022-05-19T07:00:00.0000000' AS DateTime2), CAST('2022-05-27T07:00:00.0000000' AS DateTime2), 8, 1, 1, 3);

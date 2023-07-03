CREATE DATABASE DuAn1
GO
USE DuAn1
GO

IF OBJECT_ID('MauSac') IS NOT NULL
DROP TABLE MauSac
GO
CREATE TABLE MauSac
(
MaMauSac UNIQUEIDENTIFIER PRIMARY KEY DEFAULT NEWID(),
TenMauSac NVARCHAR(30),
)

IF OBJECT_ID('KichThuoc') IS NOT NULL
DROP TABLE KichThuoc
GO
CREATE TABLE KichThuoc
(
MaKichThuoc UNIQUEIDENTIFIER PRIMARY KEY DEFAULT NEWID(),
TenKichThuoc NVARCHAR(30),
)

IF OBJECT_ID('LoaiSanPham') IS NOT NULL
DROP TABLE LoaiSanPham
GO
CREATE TABLE LoaiSanPham
(
MaLoaiSanPham UNIQUEIDENTIFIER PRIMARY KEY DEFAULT NEWID(),
TenLoaiSanPham NVARCHAR(30),
)

IF OBJECT_ID('ChatLieu') IS NOT NULL
DROP TABLE ChatLieu
GO
CREATE TABLE ChatLieu
(
MaChatLieu UNIQUEIDENTIFIER PRIMARY KEY DEFAULT NEWID(),
TenChatLieu NVARCHAR(30),
)
DROP  FUNCTION AUTO_MaSP
DROP  FUNCTION AUTO_MaKM
DROP  FUNCTION AUTO_MaKH
DROP  FUNCTION AUTO_MaHD
DROP  FUNCTION AUTO_MaNV

CREATE FUNCTION AUTO_MaSP()
RETURNS VARCHAR(5)
AS
BEGIN
	DECLARE @Ma VARCHAR(5)
	IF (SELECT COUNT(MaSanPham) FROM SanPham) = 0
		SET @Ma = '0'
	ELSE
		SELECT @Ma = MAX(RIGHT(MaSanPham, 3)) FROM SanPham
		SELECT @Ma = CASE
			WHEN @Ma >= 0 and @Ma < 9 THEN 'SP00' + CONVERT(CHAR, CONVERT(INT, @Ma) + 1)
			WHEN @Ma >= 9 THEN 'SP0' + CONVERT(CHAR, CONVERT(INT, @Ma) + 1)
		END
	RETURN @Ma
END
IF OBJECT_ID('SanPham') IS NOT NULL
DROP TABLE SanPham
GO
CREATE TABLE SanPham
(
IdSanPham UNIQUEIDENTIFIER PRIMARY KEY DEFAULT NEWID(),
MaSanPham  VARCHAR(20) UNIQUE DEFAULT DBO.AUTO_MaSP(),
TenSanPham NVARCHAR(30),
MaChatLieu UNIQUEIDENTIFIER,
MaLoaiSanPham  UNIQUEIDENTIFIER,
MaKichThuoc UNIQUEIDENTIFIER,
MaMauSac  UNIQUEIDENTIFIER,
SoLuong INT,
GiaBan FLOAT,
TrangThai BIT DEFAULT 0,
Mota NVARCHAR(100),
FOREIGN KEY (MaChatLieu) REFERENCES ChatLieu(MaChatLieu),
FOREIGN KEY (MaMauSac) REFERENCES MauSac(MaMauSac),
FOREIGN KEY (MaKichThuoc) REFERENCES KichThuoc(MaKichThuoc),
FOREIGN KEY (MaLoaiSanPham) REFERENCES LoaiSanPham(MaLoaiSanPham),
)
CREATE FUNCTION AUTO_MaKM()
RETURNS VARCHAR(5)
AS
BEGIN
	DECLARE @Ma VARCHAR(5)
	IF (SELECT COUNT(MaKhuyenMai) FROM KhuyenMai) = 0
		SET @Ma = '0'
	ELSE
		SELECT @Ma = MAX(RIGHT(MaKhuyenMai, 3)) FROM KhuyenMai
		SELECT @Ma = CASE
			WHEN @Ma >= 0 and @Ma < 9 THEN 'KM00' + CONVERT(CHAR, CONVERT(INT, @Ma) + 1)
			WHEN @Ma >= 9 THEN 'KM0' + CONVERT(CHAR, CONVERT(INT, @Ma) + 1)
		END
	RETURN @Ma
END
IF OBJECT_ID('KhuyenMai') IS NOT NULL
DROP TABLE KhuyenMai
GO
CREATE TABLE KhuyenMai
(
IdKhuyenMai UNIQUEIDENTIFIER PRIMARY KEY DEFAULT NEWID(),
MaKhuyenMai  VARCHAR(20) UNIQUE DEFAULT DBO.AUTO_MaKM(),
TenKhuyenMai NVARCHAR(30),
NgayBatDau DATE,
NgayKetThuc DATE,
GiamGia INT,
TrangThai BIT,
MaSanPham VARCHAR(20),
FOREIGN KEY (MaSanPham) REFERENCES SanPham(MaSanPham),
)
CREATE FUNCTION AUTO_MaNV()
RETURNS VARCHAR(5)
AS
BEGIN
	DECLARE @Ma VARCHAR(5)
	IF (SELECT COUNT(MaNhanVien) FROM NhanVien) = 0
		SET @Ma = '0'
	ELSE
		SELECT @Ma = MAX(RIGHT(MaNhanVien, 3)) FROM NhanVien
		SELECT @Ma = CASE
			WHEN @Ma >= 0 and @Ma < 9 THEN 'NV00' + CONVERT(CHAR, CONVERT(INT, @Ma) + 1)
			WHEN @Ma >= 9 THEN 'NV0' + CONVERT(CHAR, CONVERT(INT, @Ma) + 1)
		END
	RETURN @Ma
END
IF OBJECT_ID('NhanVien') IS NOT NULL
DROP TABLE NhanVien
GO 
CREATE TABLE NhanVien
(
IdNhanVien UNIQUEIDENTIFIER PRIMARY KEY DEFAULT NEWID(),
MaNhanVien  VARCHAR(20) UNIQUE DEFAULT DBO.AUTO_MaNV(),
TenNhanVien NVARCHAR(30),
GioiTinh BIT,
NgaySinh DATE,
SoDienThoai VARCHAR(12),
Email VARCHAR(50),
DiaChi NVARCHAR(100),
VaiTro BIT DEFAULT 1,
TrangThai BIT,
MatKhau VARCHAR(30) DEFAULT '123',
)
INSERT INTO NhanVien(TenNhanVien,GioiTinh,CONVERT(Ngay(do_dai), bieuthuc, dinh_dang),SoDienThoai,Email,DiaChi)VALUES 
('THÀNH',0,'22062002','03699678','thanhld@gmail.com','Thái Nguyên')
SELECT  MaNhanVien,TenNhanVien ,GioiTinh ,NgaySinh,SoDienThoai,Email,DiaChi,MatKhau FROM NhanVien WHERE TrangThai LIKE 1
UPDATE NhanVien SET TenNhanVien LIKE ?,GioiTinh LIKE ?,NgaySinh LIKE ?,SoDienThoai LIKE ?,Email LIKE ?,DiaChi LIKE? WHERE MaNhanVien LIKE ?
UPDATE NhanVien SET TrangThai = 1 WHERE MaNhanVien = 'NV002'
CREATE FUNCTION AUTO_MaKH()
RETURNS VARCHAR(5)
AS
BEGIN
	DECLARE @Ma VARCHAR(5)
	IF (SELECT COUNT(MaKhachHang) FROM KhachHang) = 0
		SET @Ma = '0'
	ELSE
		SELECT @Ma = MAX(RIGHT(MaKhachHang, 3)) FROM KhachHang
		SELECT @Ma = CASE
			WHEN @Ma >= 0 and @Ma < 9 THEN 'KH00' + CONVERT(CHAR, CONVERT(INT, @Ma) + 1)
			WHEN @Ma >= 9 THEN 'KH0' + CONVERT(CHAR, CONVERT(INT, @Ma) + 1)
		END
	RETURN @Ma
END
IF OBJECT_ID('KhachHang') IS NOT NULL
DROP TABLE KhachHang
GO
CREATE TABLE KhachHang
(
IdKhachHang UNIQUEIDENTIFIER PRIMARY KEY DEFAULT NEWID(),
MaKhachHang  VARCHAR(20) UNIQUE DEFAULT DBO.AUTO_MaKH(),
TenKhachHang NVARCHAR(30),
SoDienThoai VARCHAR(12),
DiaChi NVARCHAR(100),
)
CREATE FUNCTION AUTO_MaHD()
RETURNS VARCHAR(5)
AS
BEGIN
	DECLARE @Ma VARCHAR(5)
	IF (SELECT COUNT(MaHoaDon) FROM HoaDon) = 0
		SET @Ma = '0'
	ELSE
		SELECT @Ma = MAX(RIGHT(MaHoaDon, 3)) FROM HoaDon
		SELECT @Ma = CASE
			WHEN @Ma >= 0 and @Ma < 9 THEN 'HD00' + CONVERT(CHAR, CONVERT(INT, @Ma) + 1)
			WHEN @Ma >= 9 THEN 'HD0' + CONVERT(CHAR, CONVERT(INT, @Ma) + 1)
		END
	RETURN @Ma
END

IF OBJECT_ID('HoaDon') IS NOT NULL
DROP TABLE HoaDon
GO
CREATE TABLE HoaDon
(
IdHoaDon UNIQUEIDENTIFIER PRIMARY KEY DEFAULT NEWID(),
MaHoaDon  VARCHAR(20) UNIQUE DEFAULT DBO.AUTO_MaHD(),
MaNhanVien  VARCHAR(20),
MaKhachHang VARCHAR(20),
NgayTao DATE,
TongTien FLOAT,
HTThanhToan NVARCHAR(50),
TinhTrang NVARCHAR(50)DEFAULT 'Chưa thanh toán',
GhiChu NVARCHAR(100),
FOREIGN KEY (MaNhanVien) REFERENCES NhanVien(MaNhanVien),
FOREIGN KEY (MaKhachHang) REFERENCES KhachHang(MaKhachHang),
)

IF OBJECT_ID('ChiTietHoaDon') IS NOT NULL
DROP TABLE ChiTietHoaDon
GO
CREATE TABLE ChiTietHoaDon
(
MaHoaDon VARCHAR(20),
MaSanPham  VARCHAR(20),
SoLuong INT,
DonGia FLOAT,
GiamGia INT,
ThanhTien FLOAT,
PRIMARY KEY(MaHoaDon,MaSanPham),
FOREIGN KEY(MaHoaDon) REFERENCES HoaDon(MaHoaDon),
FOREIGN KEY(MaSanPham) REFERENCES SanPham(MaSanPham),
)
INSERT INTO ChiTietHoaDon(MaHoaDon,MaSanPham,SoLuong,DonGia,GiamGia,ThanhTien)VALUES ('HD001','SP001',2,20,200,20000)
INSERT INTO ChiTietHoaDon(MaHoaDon,MaSanPham,SoLuong,DonGia,GiamGia,ThanhTien)VALUES ('HD001','SP002',2,20,200,20000)
SELECT SanPham.MaSanPham,SanPham.TenSanPham,ChiTietHoaDon.SoLuong,ChiTietHoaDon.DonGia,ChiTietHoaDon.GiamGia,ChiTietHoaDon.ThanhTien
FROM ChiTietHoaDon JOIN SanPham ON ChiTietHoaDon.MaSanPham = SanPham.MaSanPham WHERE MaHoaDon LIKE ?
SELECT * FROM SanPham
SELECT * FROM HoaDon
DELETE FROM KichThuoc WHERE MaKichThuoc = '6A64C986-835A-47F2-A35F-F68AD7C7341B'
INSERT INTO LoaiSanPham(TenLoaiSanPham) VALUES ('AO');
SELECT TenLoaiSanPham FROM;
	INSERT INTO ChatLieu(TenChatLieu) VALUES ('Cottong');
	INSERT INTO KichThuoc(TenKichThuoc) VALUES ('L');
	select * from KichThuoc
SELECT MaSanPham,TenSanPham,LoaiSanPham.TenLoaiSanPham, MauSac.TenMauSac,KichThuoc.TenKichThuoc,ChatLieu.TenChatLieu,GiaBan,SoLuong 
FROM SanPham JOIN LoaiSanPham ON SanPham.MaLoaiSanPham = LoaiSanPham.MaLoaiSanPham 
JOIN MauSac ON SanPham.MaMauSac = MauSac.MaMauSac 
JOIN ChatLieu ON SanPham.MaChatLieu = ChatLieu.MaChatLieu 
JOIN KichThuoc ON SanPham.MaKichThuoc = KichThuoc.MaKichThuoc WHERE TenSanPham LIKE 'ao so %'
select * from ChatLieu
select * from MauSac
select * from KichThuoc
select * from SanPham 
DRop table TaiKhoan

INSERT INTO SanPham(TenSanPham,MaLoaiSanPham,MaMauSac,MaKichThuoc,MaChatLieu,GiaBan,SoLuong)
VALUES ('ao so mi','6AC2EFE5-8C53-4CAC-8E69-9045F5AB96E3','DC619149-1542-4835-B454-6A7ED5506AC5','B12A3CB1-3B58-41BF-BC9E-1C8BB667F7D0','8EB0CE7C-0048-438B-B184-44BDD8C0031C',34000,45);
select * from SanPhamS
INSERT INTO HoaDon(MaHoaDon,MaNhanVien,MaKhachHang,NgayTao)

delete from NhanVien
INSERT INTO NhanVien(MaNhanVien,TenNhanVien,MatKhau,VaiTro) VALUES ('PH22749','Thành','123456','Nhân Viên');

SELECT * FROM KhachHang WHERE TenKhachHang LIKE  'TANH' OR SoDienThoai LIKE '0369958572'
INSERT INTO KhachHang(TenKhachHang,SoDienThoai,DiaChi,) VALUES ('THANH','0369958572','THAI NGUYEN')
delete from sanPham
SELECT * FROM SanPham 
UPDATE SanPham SET TenSanPham = ?,MaLoaiSanPham = ?,MaMauSac =?,MaKichThuoc=?,MaChatLieu=?,GiaBan=?,SoLuong=? TrangThai =0 WHERE MaSanPham = 939578C0-69CD-48D1-BA97-C8422F16009C
select * from NhanVien
SELECT MaNhanVien,MatKhau,VaiTro FROM NhanVien WHERE MaNhanVien LIKE ? AND MatKhau LIKE ?
SELECT MaKhuyenMai,TenKhuyenMai,NgayBatDau,NgayKetThuc,GiamGia,KhuyenMai.TrangThai,SanPham.TenSanPham FROM KhuyenMai JOIN SanPham ON KhuyenMai.IdSanPham = SanPham.IdSanPham
INSERT INTO KhuyenMai(TenKhuyenMai,NgayBatDau,NgayKetThuc,GiamGia,TrangThai,IdSanPham) VALUES ('SALE 20%','20200622','20220620',30,0,'D5E03614-1387-47D2-805C-0CE280A67B50');
UPDATE KhuyenMai SET TenKhuyenMai = ?,NgayBatDau =?,NgayKetThuc=?,GiamGia=?,TrangThai = ?,IdSanPham =? WHERE MaKhuyenMai LIKE ?
DELETE FROM KhuyenMai WHERE MaKhuyenMai LIKE ?
SELECT * FROM KhuyenMai
UPDATE KhuyenMai SET TenKhuyenMai = 'KM11',NgayBatDau ='2022-12-14',NgayKetThuc='2022-12-16',GiamGia=38,TrangThai = 0,MaSanPham ='SP001' WHERE MaKhuyenMai = 'KM002'

SELECT MaKhuyenMai,TenKhuyenMai,NgayBatDau,NgayKetThuc,GiamGia,KhuyenMai.TrangThai,SanPham.TenSanPham 
FROM KhuyenMai JOIN SanPham ON KhuyenMai.MaSanPham = SanPham.MaSanPham
WHERE TenKhuyenMai LIKE ? OR SanPham.TenSanPham LIKE ?
select * from NhanVien
select * from KhachHang
SELECT MaHoaDon,NhanVien.TenNhanVien,KhachHang.TenKhachHang,NgayTao
FROM  HoaDon JOIN NhanVien ON HoaDon.MaNhanVien = NhanVien.MaNhanVien JOIN KhachHang
ON HoaDon.MaKhachHang = KhachHang.MaKhachHang WHERE MaHoaDon LIKE ?
delete from HoaDon
select * from HoaDon
INSERT INTO HoaDon(IdNhanVien,IdKhachHang,NgayTao,TongTien,HTThanhToan,TienShip,TinhTrang,GhiChu) 
VALUES ('90945CAB-7328-4F7A-B35E-CE4F9B88E6C8','4D95A443-32AC-4556-8E48-6052864B47D5','2022020',3000000,'Tiền mặt',20,'Đã thanh toán','Not ');
SELECT SanPham.MaSanPham,SanPham.TenSanPham,ChiTietHoaDon.SoLuong,ChiTietHoaDon.DonGia,KhuyenMai.GiamGia,ChiTietHoaDon.ThanhTien
            FROM ChiTietHoaDon JOIN SanPham ON ChiTietHoaDon.MaSanPham = SanPham.MaSanPham JOIN KhuyenMai ON SanPham.MaSanPham = KhuyenMai.MaSanPham WHERE SanPham.MaSanPham LIKE ?
SELECT SanPham.MaSanPham,TenSanPham,GiaBan,SoLuong FROM SanPham WHERE MaSanPham LIKE ?
SELECT * FROM KhachHang
UPDATE SanPham SET SoLuong = (SoLuong - 7) WHERE MaSanPham LIKE 'SP001'

SELECT MaKhachHang,MaNhanVien,NgayTao,TongTien,HTThanhToan,TinhTrang,GhiChu FROM HoaDon WHERE MaHoaDon LIKE ?
Select * from ChiTietHoaDon
SELECT * FROM KhachHang
SELECT* FROM NhanVien
INSERT INTO HoaDon(MaKhachHang,MaNhanVien,NgayTao,TongTien,HTThanhToan,TinhTrang,GhiChu)
VALUES('KH001','admin','20221214',1111110,'Tiền mặt',N'Đã hủy','Not')
SELECT SUM(TongTien) AS 'TongTien' FROM HoaDon WHERE YEAR(NgayTao) LIKE 2022 
MONTH(NgayTao) BETWEEN '20221216' AND '20221216')


SELECT Max(MaHoaDon) FROM HoaDon 
INSERT INTO ChiTietHoaDon(MaHoaDon,MaSanPham,SoLuong,DonGia,GiamGia,ThanhTien) VALUES(?,?,?,?,?,?)

SELECT GiamGia FROM KhuyenMai JOIN SanPham ON KhuyenMai.MaSanPham = SanPham.MaSanPham WHERE SANPHAM.MaSanPham = 'SP002'

SELECT COUNT(TinhTrang) FROM HoaDon WHERE YEAR(NgayTao) LIKE 2022 AND MONTH(NgayTao) = 12 AND TinhTrang LIKE N'Đã hủy'
SELECT COUNT(TinhTrang) FROM HoaDon WHERE (NgayTao BETWEEN ? AND ?) AND TinhTrang = ?
SELECT  FROM HoaDon WHERE MaHoaDon = 'HD20221216001'
UPDATE HOADON SET TinhTrang = N'Đã hủy' WHERE TinhTrang LIKE 'Đã hủy' 

UPDATE HoaDon SET MaKhachHang = ?,MaNhanVien = ?,NgayTao =?,TongTien = ?,HTThanhToan =?,TinhTrang = ?,GhiChu = ? WHERE MaHoaDon LIKE ?
UPDATE NhanVien SET MatKhau = '1234' WHERE Email LIKE 'thanhldph22749@fpt.edu.vn'

SELECT MaHoaDon,NhanVien.TenNhanVien,KhachHang.TenKhachHang,NgayTao,HoaDon.TinhTrang
                FROM  HoaDon JOIN NhanVien ON HoaDon.MaNhanVien = NhanVien.MaNhanVien JOIN KhachHang
                ON HoaDon.MaKhachHang = KhachHang.MaKhachHang WHERE NgayTao = '20221217' AND HoaDon.TinhTrang  = N'Chưa thanh toán'
				DELETE FROM HoaDon WHERE TinhTrang = N'Chưa thanh toán'



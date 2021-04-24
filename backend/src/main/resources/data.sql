INSERT INTO tb_user (name, email, password) VALUES ('Vitor Lucas', 'vitor@gmail.com', '$2a$10$eACCYoNOHEqXve8aIWT8Nu3PkMXWBaOxJ9aORUYzfMQCbVBIhZ8tG');
INSERT INTO tb_user (name, email, password) VALUES ('Ana Paula', 'ana@gmail.com', '$2a$10$eACCYoNOHEqXve8aIWT8Nu3PkMXWBaOxJ9aORUYzfMQCbVBIhZ8tG');

INSERT INTO tb_role (authority) VALUES ('ROLE_OPERATOR');
INSERT INTO tb_role (authority) VALUES ('ROLE_ADMIN');

INSERT INTO tb_user_role (user_id, role_id) VALUES (1, 2);
INSERT INTO tb_user_role (user_id, role_id) VALUES (2, 1);


INSERT INTO tb_client (name, cpf_Cnpj, phone1, phone2) VALUES('Luciano Ferreira', '111.222.333-44', '(61)9 8254-6659', '(61)9 9965-3809');
INSERT INTO tb_client (name, cpf_Cnpj, phone1, phone2) VALUES('Fernanda Silva', '123.456.789-10', '(61)9 9563-0029', '(61)9 8963-2654');
INSERT INTO tb_address(city, district, number, cep, complement, cliente_id) VALUES ('Brasília', 'Asa sul', 416, '70297-400', 'apt 205', 1);
INSERT INTO tb_address(city, district, number, cep, complement, cliente_id) VALUES ('Brasília', 'Asa Norte', 705, '7126-965', 'loja 5', 2);

INSERT INTO TB_ORDER_OF_SERVICE(OPENING_DATE, CLOSING_DATE, SERIAL_NUMBER, STATUS, EQUIPMENT, DEFECT, NOTE, CLIENT_ID, EMPLOYEE_ID) VALUES (TIMESTAMP WITH TIME ZONE '2020-12-22T10:00:00Z', TIMESTAMP WITH TIME ZONE '2021-01-05T08:30:00Z', 'QLKSOE2S3D632369', 4, 'Notebook dell inspiron 15', 'não liga', 'O equipamento não está ligando após uma descarga de energia', 1, 1);
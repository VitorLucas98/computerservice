INSERT INTO tb_user (name, email, password) VALUES ('Vitor Lucas', 'vitor@gmail.com', '$2a$10$eACCYoNOHEqXve8aIWT8Nu3PkMXWBaOxJ9aORUYzfMQCbVBIhZ8tG');
INSERT INTO tb_user (name, email, password) VALUES ('Ana Paula', 'ana@gmail.com', '$2a$10$eACCYoNOHEqXve8aIWT8Nu3PkMXWBaOxJ9aORUYzfMQCbVBIhZ8tG');

INSERT INTO tb_role (authority) VALUES ('ROLE_OPERATOR');
INSERT INTO tb_role (authority) VALUES ('ROLE_ADMIN');

INSERT INTO tb_user_role (user_id, role_id) VALUES (1, 2);
INSERT INTO tb_user_role (user_id, role_id) VALUES (2, 1);


INSERT INTO tb_client (name, cpf_Cnpj, phone1, phone2) VALUES('Luciano Ferreira', '111.222.333-44', '(61)9 8254-6659', '(61)9 9965-3809');
INSERT INTO tb_address(city, district, number, cep, complement, cliente_id) VALUES ('Brasília', 'Asa sul', 416, '70297-400', 'apt 205', 1);

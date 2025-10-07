-- V2: Migrations para adicionar a coluna phrase na tabela de cadastros

ALTER TABLE tb_cadastro
ADD COLUMN imgUrl; VARCHAR(255);
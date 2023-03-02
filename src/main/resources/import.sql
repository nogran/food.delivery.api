INSERT INTO cozinha (id, nome) VALUES (1, 'Tailandesa');
INSERT INTO cozinha (id, nome) VALUES (2, 'Indiana');

INSERT INTO restaurante (nome, taxa_frete, cozinha_id) VALUES ('Tai restaurant', 10, 1);
INSERT INTO restaurante (nome, taxa_frete, cozinha_id) VALUES ('Ind restaurant', 5.50, 2);

INSERT INTO forma_pagamento (id, descricao) VALUES (1, 'cartao');
INSERT INTO forma_pagamento (id, descricao) VALUES (2, 'dinheiro');

INSERT INTO estado (id, nome) VALUES (1, 'MG');
INSERT INTO estado (id, nome) VALUES (2, 'SP');

INSERT INTO cidade (id, nome, estado_id) VALUES (1, 'BH', 1);
INSERT INTO cidade (id, nome, estado_id) VALUES (2, 'SP', 2);

INSERT INTO permissao (id, nome, descricao) VALUES (1, 'Produtos', 'Permite consultar produtos');